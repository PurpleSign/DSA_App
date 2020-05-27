/**	DSA_App v0.0	Dh	17.5.2020
 * 
 * 	pGUI
 * 	  ModFrame
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

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pLogik.FightManager;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Component;

public class ModFrame extends JFrame {
	private int zID;
	private FightManager rFM;
	private MainFrame rMF;
	
	private JPanel contentPane, pPropModPanel, pStatModPanel;
	
	private JLabel lModFrameTitle, lModFrameSubTitle;
	private JLabel lPropModTitle, lPropModLable_0, lPropModLable_1, lPropModLable_2, lPropModLable_3, lPropModLable_4,
		lPropModLable_5, lPropModLable_6, lPropModLable_7, lPropModLable_8;
	private JLabel lStatModTitle, lStatModLable_0, lStatModLable_1, lStatModLable_2, lStatModLable_3, lStatModLable_4,
		lStatModLable_5, lStatModLable_6, lStatModLable_7, lStatModLable_8, lStatModLable_9;
	
	private JSpinner spPropModSpinner_0, spPropModSpinner_1, spPropModSpinner_2, spPropModSpinner_3, spPropModSpinner_4,
		spPropModSpinner_5, spPropModSpinner_6, spPropModSpinner_7, spPropModSpinner_8;
	private JSpinner spStatModSpinner_0, spStatModSpinner_1, spStatModSpinner_2, spStatModSpinner_3, spStatModSpinner_4,
		spStatModSpinner_5, spStatModSpinner_6, spStatModSpinner_7, spStatModSpinner_8, spStatModSpinner_9;
	
	private JButton btModFrameButton_0, btModFrameButton_1;

	/**	Dh	17.5.2020
	 * 
	 * 	Erzeugt das ModFrame.
	 */
	public ModFrame(String pName, int pID, FightManager pFM, MainFrame pMF) {
		if (pFM == null) MainFrame.handleException(new Exception("04; MoFra"));
		zID = pID;
		rFM = pFM;
		rMF = pMF;
		
		setTitle("Mod Fenster");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 332, 555);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lModFrameTitle = new JLabel("Modifikator Auswahl");
		lModFrameTitle.setFont(new Font("Liberation Serif", Font.BOLD, 18));
			
		lModFrameSubTitle = new JLabel("");
		lModFrameSubTitle.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		
		if (pName != "") lModFrameSubTitle.setText("für "+pName);
		
		initPropModPanel();
		initStatModPanle();
		
		btModFrameButton_0 = new JButton("Abbrechen");
		btModFrameButton_0.setPreferredSize(new Dimension(90, 30));
		btModFrameButton_0.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		btModFrameButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancel();
			}
		});
		
		btModFrameButton_1 = new JButton("Anwenden");
		btModFrameButton_1.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		btModFrameButton_1.setPreferredSize(new Dimension(90, 30));
		btModFrameButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				applyMods();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(64)
							.addComponent(lModFrameTitle))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btModFrameButton_0, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
							.addComponent(btModFrameButton_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(105)
							.addComponent(lModFrameSubTitle))
						.addComponent(pPropModPanel, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
						.addComponent(pStatModPanel, 0, 0, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lModFrameTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lModFrameSubTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pPropModPanel, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pStatModPanel, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btModFrameButton_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btModFrameButton_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	17.5.2020
	 * 
	 * 	Erzeugtz die GUI-Elemente fuer das PropMod Panel.
	 */
	private void initPropModPanel() {
		pPropModPanel = new JPanel();
		pPropModPanel.setBackground(Color.WHITE);
		
		lPropModTitle = new JLabel("Eigenschafts Mods");
		lPropModTitle.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		lPropModLable_0 = new JLabel("Mut");
		lPropModLable_0.setPreferredSize(new Dimension(80, 15));
		lPropModLable_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lPropModLable_1 = new JLabel("Klugheit");
		lPropModLable_1.setPreferredSize(new Dimension(80, 15));
		lPropModLable_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lPropModLable_2 = new JLabel("Intuition");
		lPropModLable_2.setPreferredSize(new Dimension(80, 15));
		lPropModLable_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lPropModLable_3 = new JLabel("Charisma");
		lPropModLable_3.setPreferredSize(new Dimension(80, 15));
		lPropModLable_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lPropModLable_4 = new JLabel("Fingerfertigkeit");
		lPropModLable_4.setPreferredSize(new Dimension(80, 15));
		lPropModLable_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lPropModLable_5 = new JLabel("Gewandtheit");
		lPropModLable_5.setPreferredSize(new Dimension(80, 15));
		lPropModLable_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lPropModLable_6 = new JLabel("Konstitution");
		lPropModLable_6.setPreferredSize(new Dimension(80, 15));
		lPropModLable_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lPropModLable_7 = new JLabel("K\u00F6rperkraft");
		lPropModLable_7.setPreferredSize(new Dimension(80, 15));
		lPropModLable_7.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lPropModLable_8 = new JLabel("Geschwindigkeit");
		lPropModLable_8.setPreferredSize(new Dimension(80, 15));
		lPropModLable_8.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		spPropModSpinner_0 = new JSpinner();
		spPropModSpinner_0.setPreferredSize(new Dimension(37, 20));
		spPropModSpinner_0.setModel(new SpinnerNumberModel(0, -20, 20, 1));
		
		spPropModSpinner_1 = new JSpinner();
		spPropModSpinner_1.setPreferredSize(new Dimension(37, 20));
		spPropModSpinner_1.setModel(new SpinnerNumberModel(0, -20, 20, 1));
		
		spPropModSpinner_2 = new JSpinner();
		spPropModSpinner_2.setPreferredSize(new Dimension(37, 20));
		spPropModSpinner_2.setModel(new SpinnerNumberModel(0, -20, 20, 1));
		
		spPropModSpinner_3 = new JSpinner();
		spPropModSpinner_3.setPreferredSize(new Dimension(37, 20));
		spPropModSpinner_3.setModel(new SpinnerNumberModel(0, -20, 20, 1));
		
		spPropModSpinner_4 = new JSpinner();
		spPropModSpinner_4.setPreferredSize(new Dimension(37, 20));
		spPropModSpinner_4.setModel(new SpinnerNumberModel(0, -20, 20, 1));
		
		spPropModSpinner_5 = new JSpinner();
		spPropModSpinner_5.setPreferredSize(new Dimension(37, 20));
		spPropModSpinner_5.setModel(new SpinnerNumberModel(0, -20, 20, 1));
		
		spPropModSpinner_6 = new JSpinner();
		spPropModSpinner_6.setPreferredSize(new Dimension(37, 20));
		spPropModSpinner_6.setModel(new SpinnerNumberModel(0, -20, 20, 1));
		
		spPropModSpinner_7 = new JSpinner();
		spPropModSpinner_7.setPreferredSize(new Dimension(37, 20));
		spPropModSpinner_7.setModel(new SpinnerNumberModel(0, -20, 20, 1));
		
		spPropModSpinner_8 = new JSpinner();
		spPropModSpinner_8.setPreferredSize(new Dimension(37, 20));
		spPropModSpinner_8.setModel(new SpinnerNumberModel(0, -20, 20, 1));
		
		GroupLayout gl_pPropModPanel = new GroupLayout(pPropModPanel);
		gl_pPropModPanel.setHorizontalGroup(
			gl_pPropModPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 302, Short.MAX_VALUE)
				.addGroup(gl_pPropModPanel.createSequentialGroup()
					.addGroup(gl_pPropModPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pPropModPanel.createSequentialGroup()
							.addGap(83)
							.addComponent(lPropModTitle))
						.addGroup(gl_pPropModPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pPropModPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lPropModLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lPropModLable_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lPropModLable_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lPropModLable_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pPropModPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pPropModPanel.createSequentialGroup()
									.addComponent(lPropModLable_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(spPropModSpinner_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pPropModPanel.createSequentialGroup()
									.addGroup(gl_pPropModPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_pPropModPanel.createSequentialGroup()
											.addComponent(spPropModSpinner_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lPropModLable_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_pPropModPanel.createSequentialGroup()
											.addComponent(spPropModSpinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lPropModLable_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_pPropModPanel.createSequentialGroup()
											.addComponent(spPropModSpinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lPropModLable_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_pPropModPanel.createSequentialGroup()
											.addComponent(spPropModSpinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lPropModLable_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pPropModPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(spPropModSpinner_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(spPropModSpinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(spPropModSpinner_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(spPropModSpinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_pPropModPanel.setVerticalGroup(
			gl_pPropModPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 169, Short.MAX_VALUE)
				.addGroup(gl_pPropModPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(lPropModTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pPropModPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lPropModLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spPropModSpinner_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lPropModLable_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spPropModSpinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pPropModPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lPropModLable_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spPropModSpinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lPropModLable_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spPropModSpinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pPropModPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lPropModLable_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spPropModSpinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lPropModLable_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spPropModSpinner_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pPropModPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lPropModLable_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spPropModSpinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lPropModLable_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spPropModSpinner_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pPropModPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(spPropModSpinner_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lPropModLable_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pPropModPanel.setLayout(gl_pPropModPanel);
	}
	/**	Dh	17.5.2020
	 * 
	 * 	Erzeugt die GUI-Elemente des StatMod Panels.
	 */
	private void initStatModPanle() {
		pStatModPanel = new JPanel();
		pStatModPanel.setBackground(Color.WHITE);
		
		lStatModTitle = new JLabel("Basiswert Mods");
		lStatModTitle.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		lStatModTitle.setAlignmentX(0.5f);
		
		lStatModLable_0 = new JLabel("Lebenspunkte");
		lStatModLable_0.setPreferredSize(new Dimension(80, 15));
		lStatModLable_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lStatModLable_1 = new JLabel("Ausdauerpunkte");
		lStatModLable_1.setPreferredSize(new Dimension(80, 15));
		lStatModLable_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lStatModLable_2 = new JLabel("Astralpunkte");
		lStatModLable_2.setPreferredSize(new Dimension(80, 15));
		lStatModLable_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lStatModLable_3 = new JLabel("Karmapunkte");
		lStatModLable_3.setPreferredSize(new Dimension(80, 15));
		lStatModLable_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lStatModLable_4 = new JLabel("Magieresistenz");
		lStatModLable_4.setPreferredSize(new Dimension(80, 15));
		lStatModLable_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lStatModLable_5 = new JLabel("Wundschwelle");
		lStatModLable_5.setPreferredSize(new Dimension(80, 15));
		lStatModLable_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lStatModLable_6 = new JLabel("Ini-Basiswert");
		lStatModLable_6.setPreferredSize(new Dimension(80, 15));
		lStatModLable_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lStatModLable_7 = new JLabel("At-Basiswert");
		lStatModLable_7.setPreferredSize(new Dimension(80, 15));
		lStatModLable_7.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lStatModLable_8 = new JLabel("Pa-Pasiswert");
		lStatModLable_8.setPreferredSize(new Dimension(80, 15));
		lStatModLable_8.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lStatModLable_9 = new JLabel("Fk-Basiswert");
		lStatModLable_9.setPreferredSize(new Dimension(80, 15));
		lStatModLable_9.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		spStatModSpinner_0 = new JSpinner();
		spStatModSpinner_0.setPreferredSize(new Dimension(37, 20));
		spStatModSpinner_0.setModel(new SpinnerNumberModel(0, -60, 60, 1));
		
		spStatModSpinner_1 = new JSpinner();
		spStatModSpinner_1.setPreferredSize(new Dimension(37, 20));
		spStatModSpinner_0.setModel(new SpinnerNumberModel(0, -60, 60, 1));
		
		spStatModSpinner_2 = new JSpinner();
		spStatModSpinner_2.setPreferredSize(new Dimension(37, 20));
		spStatModSpinner_0.setModel(new SpinnerNumberModel(0, -60, 60, 1));
		
		spStatModSpinner_3 = new JSpinner();
		spStatModSpinner_3.setPreferredSize(new Dimension(37, 20));
		spStatModSpinner_0.setModel(new SpinnerNumberModel(0, -60, 60, 1));
		
		spStatModSpinner_4 = new JSpinner();
		spStatModSpinner_4.setPreferredSize(new Dimension(37, 20));
		spStatModSpinner_0.setModel(new SpinnerNumberModel(0, -20, 20, 1));
		
		spStatModSpinner_5 = new JSpinner();
		spStatModSpinner_5.setPreferredSize(new Dimension(37, 20));
		spStatModSpinner_0.setModel(new SpinnerNumberModel(0, -20, 20, 1));
		
		spStatModSpinner_6 = new JSpinner();
		spStatModSpinner_6.setPreferredSize(new Dimension(37, 20));
		spStatModSpinner_0.setModel(new SpinnerNumberModel(0, -20, 20, 1));
		
		spStatModSpinner_7 = new JSpinner();
		spStatModSpinner_7.setPreferredSize(new Dimension(37, 20));
		spStatModSpinner_0.setModel(new SpinnerNumberModel(0, -20, 20, 1));
		
		spStatModSpinner_8 = new JSpinner();
		spStatModSpinner_8.setPreferredSize(new Dimension(37, 20));
		spStatModSpinner_0.setModel(new SpinnerNumberModel(0, -20, 20, 1));
		
		spStatModSpinner_9 = new JSpinner();
		spStatModSpinner_9.setPreferredSize(new Dimension(37, 20));
		spStatModSpinner_0.setModel(new SpinnerNumberModel(0, -20, 20, 1));
		
		GroupLayout gl_pStatModPanel = new GroupLayout(pStatModPanel);
		gl_pStatModPanel.setHorizontalGroup(
			gl_pStatModPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 305, Short.MAX_VALUE)
				.addGroup(gl_pStatModPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pStatModPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lStatModLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lStatModLable_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lStatModLable_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lStatModLable_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lStatModLable_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pStatModPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lStatModTitle)
						.addGroup(gl_pStatModPanel.createSequentialGroup()
							.addComponent(spStatModSpinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lStatModLable_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spStatModSpinner_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pStatModPanel.createSequentialGroup()
							.addComponent(spStatModSpinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lStatModLable_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spStatModSpinner_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pStatModPanel.createSequentialGroup()
							.addComponent(spStatModSpinner_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lStatModLable_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spStatModSpinner_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pStatModPanel.createSequentialGroup()
							.addComponent(spStatModSpinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lStatModLable_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spStatModSpinner_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pStatModPanel.createSequentialGroup()
							.addComponent(spStatModSpinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lStatModLable_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spStatModSpinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_pStatModPanel.setVerticalGroup(
			gl_pStatModPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 169, Short.MAX_VALUE)
				.addGroup(gl_pStatModPanel.createSequentialGroup()
					.addGap(0, 4, Short.MAX_VALUE)
					.addComponent(lStatModTitle, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pStatModPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lStatModLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spStatModSpinner_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lStatModLable_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spStatModSpinner_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pStatModPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lStatModLable_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spStatModSpinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lStatModLable_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spStatModSpinner_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pStatModPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lStatModLable_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spStatModSpinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lStatModLable_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spStatModSpinner_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pStatModPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lStatModLable_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spStatModSpinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lStatModLable_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spStatModSpinner_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pStatModPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pStatModPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lStatModLable_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(spStatModSpinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lStatModLable_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(spStatModSpinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11))
		);
		pStatModPanel.setLayout(gl_pStatModPanel);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	17.5.2020
	 * 
	 * 	Beenden die Modauswahl.
	 */
	private void cancel() {
		rMF.closeModFrame();
		setVisible(false);
		dispose();
	}
	/**	Dh	17.5.2020
	 * 
	 * 	Wende die Modifikatoren an, und beenden die Modauswahl.
	 */
	private void applyMods() {
		int[] vTempPropMods = new int[10];
		double[] vTempStatMods = new double[10];
		
		vTempPropMods[0] = (int)spPropModSpinner_0.getValue();
		vTempPropMods[1] = (int)spPropModSpinner_1.getValue();
		vTempPropMods[2] = (int)spPropModSpinner_2.getValue();
		vTempPropMods[3] = (int)spPropModSpinner_3.getValue();
		vTempPropMods[4] = (int)spPropModSpinner_4.getValue();
		vTempPropMods[5] = (int)spPropModSpinner_5.getValue();
		vTempPropMods[6] = (int)spPropModSpinner_6.getValue();
		vTempPropMods[7] = (int)spPropModSpinner_7.getValue();
		vTempPropMods[8] = (int)spPropModSpinner_8.getValue();
		vTempPropMods[9] = 0;
		
		vTempStatMods[0] = (Double.valueOf((int)spStatModSpinner_0.getValue()));
		vTempStatMods[1] = (Double.valueOf((int)spStatModSpinner_1.getValue()));
		vTempStatMods[2] = (Double.valueOf((int)spStatModSpinner_2.getValue()));
		vTempStatMods[3] = (Double.valueOf((int)spStatModSpinner_3.getValue()));
		vTempStatMods[4] = (Double.valueOf((int)spStatModSpinner_4.getValue()));
		vTempStatMods[5] = (Double.valueOf((int)spStatModSpinner_5.getValue()));
		vTempStatMods[6] = (Double.valueOf((int)spStatModSpinner_6.getValue()));
		vTempStatMods[7] = (Double.valueOf((int)spStatModSpinner_7.getValue()));
		vTempStatMods[8] = (Double.valueOf((int)spStatModSpinner_8.getValue()));
		vTempStatMods[9] = (Double.valueOf((int)spStatModSpinner_9.getValue()));
		
		for (int i=0; i < vTempPropMods.length; i++) {
			try{
				if (zID != -1) {
					if (vTempPropMods[i] != 0) rFM.addPropModToFighter(zID, vTempPropMods[i], i); 
					if (vTempStatMods[i] != 0) rFM.addStatModToFighter(zID, vTempStatMods[i], i);
				}else {
					if (vTempPropMods[i] != 0) rFM.addPropModToFighters(vTempPropMods[i], i); 
					if (vTempStatMods[i] != 0) rFM.addStatModToFighters(vTempStatMods[i], i);
				}
			} catch(Exception ex) {MainFrame.handleException(ex);}
		}
		
		if (zID == -1) {
			try {
				rMF.addGenPropMods(vTempPropMods);
				rMF.addGenStatMods(vTempStatMods);
			} catch(Exception ex) {MainFrame.handleException(ex);}
		}
		
		cancel();
	}
}
