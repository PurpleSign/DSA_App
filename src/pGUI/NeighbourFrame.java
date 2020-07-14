/**	DSA_App v0.0	Dh	9.7.2020
 * 
 * 	pGUI
 * 	  NeighbourFrame
 * 
 * 	Exceptions:
 * 	  01 Wrong length
 * 	  02 Wrong Value
 * 	  03 Calculation Error
 * 	  04 Nullpointer Error
 * 	  05 Empty List Error
 * 	  06 Wrong Type Error
 * 	  07 Index Error
 * 	  08 Equal Object Error
 * 	  09 Wrong Selection
 */

package pGUI;

import pLogik.FightElement;
import pLogik.FightManager;
import pLogik.NeighbourElement;
import pDataStructures.List;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JCheckBox;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

public class NeighbourFrame extends JFrame {
	private String name;
	private int id, neiID, width, height;
	private FightManager rFM;
	private MainFrame rMF;
	
	private JPanel contentPane, lInfoPanel;

	private JLabel lFrameTitle_0, lFrameTitle_1, lComboTitle, lNeiDisInfoTitle;
	private JLabel lInfoTitle, lInfoLable_0, lInfoLable_1, lInfoLable_2, lInfoLable_3, lInfoLable_4, 
		lInfoLable_5, lInfoLable_6;
	
	private JComboBox cbNeighbourCombo;
	private JTextArea taNeiText;
	private JButton btNeiButton_0, btNeiButton_1;
	
	private JCheckBox cbInfoCheck_0, cbInfoCheck_1, cbInfoCheck_2;
	private JSpinner spInfoSpinner_1, spInfoSpinner_2, spInfoSpinner_3, spInfoSpinner_4;

	private JComboBoxModel rNeiComboModel;
	
	/**	Dh	22.5.2020
	 * 	
	 * Create the frame.
	 */
	public NeighbourFrame(String pName, int pID, int pNeiID, FightManager pFM, MainFrame pMF) {
		name = pName;
		id = pID;
		neiID = pNeiID;
		rFM = pFM;
		rMF = pMF;
		
		Point vPos = rMF.getMiddlePosition();
		width = 352;
		height = 341;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds((int)(vPos.getX()-(width/2)), (int)(vPos.getY()-(height/2)), width, height);
		setBounds(100, 100, 352, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		initNeiList();
		initInfoPanel();
		
		btNeiButton_0 = new JButton("Abbrechen");
		btNeiButton_0.setPreferredSize(new Dimension(90, 30));
		btNeiButton_0.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		btNeiButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancel();
			}
		});
		
		btNeiButton_1 = new JButton("Anwenden");
		btNeiButton_1.setPreferredSize(new Dimension(90, 30));
		btNeiButton_1.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		if (neiID == -1) btNeiButton_1.setEnabled(false);
		btNeiButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				applyNeighbours();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lInfoPanel, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
									.addGap(18))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btNeiButton_0, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btNeiButton_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbNeighbourCombo, 0, 175, Short.MAX_VALUE)
								.addComponent(lComboTitle, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
								.addComponent(taNeiText, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(39)
									.addComponent(lNeiDisInfoTitle))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addComponent(lFrameTitle_0))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(117)
							.addComponent(lFrameTitle_1)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lFrameTitle_0)
					.addGap(1)
					.addComponent(lFrameTitle_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lComboTitle)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbNeighbourCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lNeiDisInfoTitle)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(taNeiText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lInfoPanel, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btNeiButton_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btNeiButton_0, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		makeNeiList();
		makePreSet();
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	22.5.2020
	 * 
	 * 	Erstellt die Kampfnachbar ComboBox in Abhaengigkeit, ob's nen hinzufuegen, oder ne Erstellung ist.
	 */
	private void initNeiList() {
		if (neiID != -1) lFrameTitle_0 = new JLabel("Kampfnachberschaft modifizieren");
		else lFrameTitle_0 = new JLabel("Kampfnachberschaft hinzufügen");
		//lFrameTitle_0 = new JLabel("Kampfnachberschaft hinzufügen");
		lFrameTitle_0.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		
		lFrameTitle_1 = new JLabel("f\u00FCr "+name);
		lFrameTitle_1.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		
		if (neiID != -1) lComboTitle = new JLabel("Kampfnachbar*In:");
		else lComboTitle = new JLabel("Kämpfer*Innne Auswahl:");
		//lComboTitle = new JLabel("Kämpfer*Innne Auswahl:");
		lComboTitle.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		
		rNeiComboModel = new JComboBoxModel();
		cbNeighbourCombo = new JComboBox();
		cbNeighbourCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateSelectionObjects();
			}
		});
		cbNeighbourCombo.setModel(rNeiComboModel);
		
		lNeiDisInfoTitle = new JLabel("Distanzwerte:");
		lNeiDisInfoTitle.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		taNeiText = new JTextArea();
		taNeiText.setText("0 = Handgemenge\r\n1 = Nahkampf\r\n2 = Stangenwaffe\r\n3 = Pike\r\n4 > Angaben in Meter.");
		taNeiText.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
	}
	/**	Dh	22.5.2020
	 * 
	 *  Initiiert die GUI-Elemente des Info Panels.
	 */
	private void initInfoPanel() {
		lInfoPanel = new JPanel();
		lInfoPanel.setBackground(Color.WHITE);
		
		lInfoTitle = new JLabel("Inforamtionen");
		lInfoTitle.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		
		lInfoLable_0 = new JLabel("Verb\u00FCndet:");
		lInfoLable_0.setPreferredSize(new Dimension(60, 15));
		lInfoLable_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lInfoLable_1 = new JLabel("Distanz:");
		lInfoLable_1.setToolTipText("0 = Handgemenge, \r\n1 = Nahkampf, \r\n2 = Stangenwaffen, \r\n3 = Pike, \r\n4 > Angaben in Meter.");
		lInfoLable_1.setPreferredSize(new Dimension(60, 15));
		lInfoLable_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lInfoLable_2 = new JLabel("At-Mod:");
		lInfoLable_2.setPreferredSize(new Dimension(60, 15));
		lInfoLable_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lInfoLable_3 = new JLabel("Pa-Mod:");
		lInfoLable_3.setPreferredSize(new Dimension(60, 15));
		lInfoLable_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lInfoLable_4 = new JLabel("Fk-Mod:");
		lInfoLable_4.setPreferredSize(new Dimension(60, 15));
		lInfoLable_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lInfoLable_5 = new JLabel("Gegenseitig");
		lInfoLable_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lInfoLable_6 = new JLabel("    mit Mods.");
		lInfoLable_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));

		cbInfoCheck_0 = new JCheckBox("");
		cbInfoCheck_0.setPreferredSize(new Dimension(18, 15));
		cbInfoCheck_0.setMargin(new Insets(1, 1, 1, 1));
		cbInfoCheck_0.setBackground(Color.WHITE);
		
		spInfoSpinner_1 = new JSpinner();
		spInfoSpinner_1.setToolTipText("0 = Handgemenge, \r\n1 = Nahkampf, \r\n2 = Stangenwaffen, \r\n3 = Pike, \r\n4 > Angaben in Meter.");
		spInfoSpinner_1.setPreferredSize(new Dimension(37, 20));
		spInfoSpinner_1.setModel(new SpinnerNumberModel(0, -1, 1000, 1));
		
		spInfoSpinner_2 = new JSpinner();
		spInfoSpinner_2.setPreferredSize(new Dimension(37, 20));
		spInfoSpinner_2.setModel(new SpinnerNumberModel(0, -20, 20, 1));
		
		spInfoSpinner_3 = new JSpinner();
		spInfoSpinner_3.setPreferredSize(new Dimension(37, 20));
		spInfoSpinner_3.setModel(new SpinnerNumberModel(0, -20, 20, 1));
		
		spInfoSpinner_4 = new JSpinner();
		spInfoSpinner_4.setPreferredSize(new Dimension(37, 20));
		spInfoSpinner_4.setModel(new SpinnerNumberModel(0, -20, 20, 1));
		
		if (neiID == -1) {
			cbInfoCheck_1 = new JCheckBox("");
			cbInfoCheck_1.setSelected(true);
			cbInfoCheck_1.setPreferredSize(new Dimension(18, 15));
			cbInfoCheck_1.setMargin(new Insets(1, 1, 1, 1));
			cbInfoCheck_1.setBackground(Color.WHITE);
		} else cbInfoCheck_1 = null;
		
		cbInfoCheck_2 = new JCheckBox("");
		cbInfoCheck_2.setPreferredSize(new Dimension(18, 15));
		cbInfoCheck_2.setMargin(new Insets(1, 1, 1, 1));
		cbInfoCheck_2.setBackground(Color.WHITE);
		
		/**GroupLayout gl_lInfoPanel = new GroupLayout(lInfoPanel);
		gl_lInfoPanel.setHorizontalGroup(
			gl_lInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lInfoPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_lInfoPanel.createSequentialGroup()
							.addComponent(lInfoLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cbInfoCheck_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_lInfoPanel.createSequentialGroup()
							.addComponent(lInfoLable_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spInfoSpinner_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_lInfoPanel.createSequentialGroup()
							.addComponent(lInfoLable_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spInfoSpinner_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addComponent(lInfoTitle)
						.addGroup(gl_lInfoPanel.createSequentialGroup()
							.addComponent(lInfoLable_3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spInfoSpinner_3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_lInfoPanel.createSequentialGroup()
								.addComponent(lInfoLable_5)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cbInfoCheck_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.LEADING, gl_lInfoPanel.createSequentialGroup()
								.addComponent(lInfoLable_6)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cbInfoCheck_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.LEADING, gl_lInfoPanel.createSequentialGroup()
								.addComponent(lInfoLable_4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(spInfoSpinner_4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		gl_lInfoPanel.setVerticalGroup(
			gl_lInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lInfoPanel.createSequentialGroup()
					.addComponent(lInfoTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lInfoLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbInfoCheck_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lInfoLable_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spInfoSpinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lInfoLable_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spInfoSpinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lInfoLable_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(spInfoSpinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lInfoLable_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(spInfoSpinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lInfoLable_5)
						.addComponent(cbInfoCheck_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lInfoLable_6)
						.addComponent(cbInfoCheck_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		lInfoPanel.setLayout(gl_lInfoPanel);**/
		
		if (neiID == -1) {
			GroupLayout gl_lInfoPanel = new GroupLayout(lInfoPanel);
			gl_lInfoPanel.setHorizontalGroup(
				gl_lInfoPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_lInfoPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_lInfoPanel.createSequentialGroup()
								.addComponent(lInfoLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(cbInfoCheck_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_lInfoPanel.createSequentialGroup()
								.addComponent(lInfoLable_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(spInfoSpinner_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_lInfoPanel.createSequentialGroup()
								.addComponent(lInfoLable_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(spInfoSpinner_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addComponent(lInfoTitle)
							.addGroup(gl_lInfoPanel.createSequentialGroup()
								.addComponent(lInfoLable_3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(spInfoSpinner_3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING, gl_lInfoPanel.createSequentialGroup()
									.addComponent(lInfoLable_5)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(cbInfoCheck_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_lInfoPanel.createSequentialGroup()
									.addComponent(lInfoLable_6)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(cbInfoCheck_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_lInfoPanel.createSequentialGroup()
									.addComponent(lInfoLable_4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(spInfoSpinner_4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(65, Short.MAX_VALUE))
			);
			gl_lInfoPanel.setVerticalGroup(
				gl_lInfoPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_lInfoPanel.createSequentialGroup()
						.addComponent(lInfoTitle)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lInfoLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cbInfoCheck_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lInfoLable_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(spInfoSpinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lInfoLable_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(spInfoSpinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lInfoLable_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addComponent(spInfoSpinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lInfoLable_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addComponent(spInfoSpinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(lInfoLable_5)
							.addComponent(cbInfoCheck_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lInfoLable_6)
							.addComponent(cbInfoCheck_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			lInfoPanel.setLayout(gl_lInfoPanel);
		} else {
			GroupLayout gl_lInfoPanel = new GroupLayout(lInfoPanel);
			gl_lInfoPanel.setHorizontalGroup(
				gl_lInfoPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_lInfoPanel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_lInfoPanel.createSequentialGroup()
								.addComponent(lInfoLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(cbInfoCheck_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_lInfoPanel.createSequentialGroup()
								.addComponent(lInfoLable_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(spInfoSpinner_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_lInfoPanel.createSequentialGroup()
								.addComponent(lInfoLable_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(spInfoSpinner_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addComponent(lInfoTitle)
							.addGroup(gl_lInfoPanel.createSequentialGroup()
								.addComponent(lInfoLable_3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(spInfoSpinner_3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING, gl_lInfoPanel.createSequentialGroup()
									.addComponent(lInfoLable_5))
								.addGroup(Alignment.LEADING, gl_lInfoPanel.createSequentialGroup()
									.addComponent(lInfoLable_6)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(cbInfoCheck_2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_lInfoPanel.createSequentialGroup()
									.addComponent(lInfoLable_4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(spInfoSpinner_4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(65, Short.MAX_VALUE))
			);
			gl_lInfoPanel.setVerticalGroup(
				gl_lInfoPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_lInfoPanel.createSequentialGroup()
						.addComponent(lInfoTitle)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lInfoLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(cbInfoCheck_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lInfoLable_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(spInfoSpinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lInfoLable_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(spInfoSpinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lInfoLable_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addComponent(spInfoSpinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lInfoLable_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addComponent(spInfoSpinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(lInfoLable_5))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_lInfoPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lInfoLable_6)
							.addComponent(cbInfoCheck_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			lInfoPanel.setLayout(gl_lInfoPanel);
		}
	}
	/**	Dh	22.5.2020
	 * 
	 * 	Fuegt die moeglichen Kaempfer*Innen zur Auswahl hinzu.
	 */
	private void makeNeiList() {
		boolean vInsert;
		int vID;
		List vList, vNeiList;
		
		if (neiID != -1) {
			try {
				rNeiComboModel.addElement(rFM.getCharacterOfFighter(neiID).getName(), neiID);
				cbNeighbourCombo.setSelectedIndex(0);
				cbNeighbourCombo.setEnabled(false);
			} catch(Exception ex) {rMF.handleException(ex);}
		}else if (id != -1) {
			try {
				vList = rFM.getNeighbourListOfFighter(id);
				vNeiList = new List();
				
				if(!vList.isEmpty()) {
					vList.toFirst();
					
					while (!vList.isEnd()) {
						vNeiList.append(((NeighbourElement)vList.getCurrent()).getId());
						
						vList.next();
					}
				} 
				
				vList = rFM.getFightList();
				if (!vList.isEmpty()) {
					vList.toFirst();
					
					while(!vList.isEnd()) {
						vInsert = true;
						vID = ((FightElement)vList.getCurrent()).getId();
						
						if (vID == id) vInsert = false;
						if (!vNeiList.isEmpty()) {
							vNeiList.toFirst();
							
							while (!vNeiList.isEnd() && (vInsert == true)) {
								if (vID == ((int)vNeiList.getCurrent())) vInsert = false;
							
								vNeiList.next();
							}
						}
						
						if (vInsert == true) {
							rNeiComboModel.addElement(rFM.getCharacterOfFighter(vID).getName(), vID);
							vList.prior();
						}
						
						vList.next();
					}
				} else throw new Exception("05, NeFra,iNL");
			} catch(Exception ex) {rMF.handleException(ex);}
		} else rMF.handleException(new Exception("02; NeFra,iNL"));
	}
	/**	Dh	23.5.2020
	 * 
	 * 	Holt die vorhanden Werte der Nachbarschaft.
	 */
	private void makePreSet() {
		if (id != -1) {
			if (neiID != -1) {
				try {
					cbInfoCheck_0.setSelected(!rFM.getEnemyTypeOfNeighbourOfFighter(id, neiID));
					spInfoSpinner_1.setValue(rFM.getDistanceOfNeighbourOfFighter(id, neiID));
					spInfoSpinner_2.setValue((int)rFM.getFightModOfNeighbourOfFighter(id, neiID, 1));
					spInfoSpinner_3.setValue((int)rFM.getFightModOfNeighbourOfFighter(id, neiID, 2));
					spInfoSpinner_4.setValue((int)rFM.getFightModOfNeighbourOfFighter(id, neiID, 3));
					cbInfoCheck_2.setSelected(true);
				} catch(Exception ex) {rMF.handleException(ex);}
			}
		}
	}
	
	
	/**	Dh	22.5.2020
	 * 
	 */
 	private void updateSelectionObjects() {
		if ((int)rNeiComboModel.getSelectedObject() != -1) btNeiButton_1.setEnabled(true);
		else btNeiButton_1.setEnabled(false);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	22.5.2020
	 * 
	 * 	Beendet die NeighbourFrame Auswahl.
	 * 
	 */
	private void cancel() {
		rMF.closeNeighbourFrame();
		setVisible(false);
		dispose();
	}
	/**	Dh	22.5.2020
	 * 
	 * 	Wendet die Nachbarschafts aktion an, hinzufügen, oder modifizieren.
	 */
	private void applyNeighbours() {
		boolean vEnemy;
		int vDinstance;
		double[] vFightMods = new double[4];
		
		if (neiID == -1) {
			if ((int)rNeiComboModel.getSelectedObject() != -1) {
				neiID = (int) rNeiComboModel.getSelectedObject();
				vEnemy = !cbInfoCheck_0.isSelected();
				vDinstance = (int)spInfoSpinner_1.getValue();
				vFightMods[0] = 0;
				vFightMods[1] = (Double.valueOf((int)spInfoSpinner_2.getValue()));
				vFightMods[2] = (Double.valueOf((int)spInfoSpinner_3.getValue()));
				vFightMods[3] = (Double.valueOf((int)spInfoSpinner_4.getValue()));
				
				try {
					rFM.addNeighbourToFighter(id, neiID, vEnemy, vDinstance, vFightMods);
					if (cbInfoCheck_1.isSelected()) {
						if (!cbInfoCheck_2.isSelected()) rFM.addNeighbourToFighter(neiID, id, vEnemy, vDinstance);
						else rFM.addNeighbourToFighter(neiID, id, vEnemy, vDinstance, vFightMods);
					}
				}catch (Exception ex) {rMF.handleException(ex);}
				
				cancel();
			}
		}else {
			vEnemy = !cbInfoCheck_0.isSelected();
			vDinstance = (int)spInfoSpinner_1.getValue();
			vFightMods[0] = 0;
			vFightMods[1] = (Double.valueOf((int)spInfoSpinner_2.getValue()));
			vFightMods[2] = (Double.valueOf((int)spInfoSpinner_3.getValue()));
			vFightMods[3] = (Double.valueOf((int)spInfoSpinner_4.getValue()));
			
			try {
				rFM.setEnemyTypeOfNeighbourOfFighter(id, neiID, vEnemy);
				rFM.setDistanceOfNeighbourOfFighter(id, neiID, vDinstance);
				
				rFM.setFightModOfNeighbourOfFighter(id, neiID, vFightMods[1], 1);
				rFM.setFightModOfNeighbourOfFighter(id, neiID, vFightMods[2], 2);
				rFM.setFightModOfNeighbourOfFighter(id, neiID, vFightMods[3], 3);
				
				rFM.setEnemyTypeOfNeighbourOfFighter(neiID, id, vEnemy);
				rFM.setDistanceOfNeighbourOfFighter(neiID, id, vDinstance);
				if (cbInfoCheck_2.isSelected()) {
					rFM.setFightModOfNeighbourOfFighter(neiID, id, vFightMods[1], 1);
					rFM.setFightModOfNeighbourOfFighter(neiID, id, vFightMods[2], 2);
					rFM.setFightModOfNeighbourOfFighter(neiID, id, vFightMods[3], 3);
				}
			} catch(Exception ex) {rMF.handleException(ex);}
			
			cancel();
		}
	}
}
