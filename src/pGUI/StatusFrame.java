/**	DSA_App v0.0	Dh	25.6.2020
 * 
 * 	pGUI
 * 	  StatusFrame
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

import pLogik.CharacterManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class StatusFrame extends JFrame{
	private int ID, Height, Width;
	
	private CharacterManager rCM;
	private MainFrame rMF;
	
	private JPanel contentPane, pStatFramePanel, pTempStatPanel;
	
	private JLabel lStatFrameTitle_0, lStatFrameTitle_1, lStatPanelTitle, lTempStatTitle;
	private JLabel lStatPanelLabel_0, lStatPanelLabel_1, lStatPanelLabel_2, lStatPanelLabel_3, lStatPanelLabel_4, lStatPanelLabel_5,
		lStatPanelLabel_6, lStatPanelLabel_7, lStatPanelLabel_8, lStatPanelLabel_9;
	private JLabel lTempStatPanelLabel_0, lTempStatPanelLabel_1, lTempStatPanelLabel_2, lTempStatPanelLabel_3;
	
	private JSpinner spStatPanelSpinner_0, spStatPanelSpinner_1, spStatPanelSpinner_2, spStatPanelSpinner_3, spStatPanelSpinner_4,
		spStatPanelSpinner_5, spStatPanelSpinner_6, spStatPanelSpinner_7, spStatPanelSpinner_8, spStatPanelSpinner_9;
	private JSpinner spTempStatPanelSpinner_0, spTempStatPanelSpinner_1, spTempStatPanelSpinner_2, spTempStatPanelSpinner_3;

	private JButton btStatFrameButton_0, btStatFrameButton_1;
	
	/**
	 * Create the frame.
	 */
	public StatusFrame(int pID, CharacterManager pCM, MainFrame pMF) {
		ID = pID;
		rCM = pCM;
		rMF = pMF;
		
		Width = 320;
		Height = 460;
		
		initFrame();
		
		setValues();
	}
	
	//----------------------------------------------------------------------------------------------------

	/**	Dh	24.6.2020
	 * 
	 */
	private void initFrame() {
		Point vPos = rMF.getMiddlePosition();
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds((int)(vPos.getX()-(Width/2)), (int)(vPos.getY()-(Height/2)), Width, Height);
		//setBounds(100, 100, 330, 464);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lStatFrameTitle_0 = new JLabel("Status Auswahl");
		lStatFrameTitle_0.setHorizontalAlignment(SwingConstants.CENTER);
		lStatFrameTitle_0.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		
		lStatFrameTitle_1 = new JLabel("Test");
		lStatFrameTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		lStatFrameTitle_1.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		initStatPanel();
		initTempStatPanel();
		
		btStatFrameButton_0 = new JButton("Anwenden");
		btStatFrameButton_0.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btStatFrameButton_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				apply();
			}
		});
		
		btStatFrameButton_1 = new JButton("Abbrechen");
		btStatFrameButton_1.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btStatFrameButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pStatFramePanel, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
						.addComponent(pTempStatPanel, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
						.addComponent(lStatFrameTitle_0, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lStatFrameTitle_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btStatFrameButton_0, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btStatFrameButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lStatFrameTitle_0, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lStatFrameTitle_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pStatFramePanel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pTempStatPanel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btStatFrameButton_0, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btStatFrameButton_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	/**	Dh	25.6.2020
	 * 
	 */
	private void initStatPanel() {
		pStatFramePanel = new JPanel();
		pStatFramePanel.setBackground(Color.WHITE);
		
		lStatPanelTitle = new JLabel("Basiswerte");
		lStatPanelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lStatPanelTitle.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		lStatPanelTitle.setAlignmentX(0.5f);
		
		lStatPanelLabel_0 = new JLabel("Lebenspunkte");
		lStatPanelLabel_0.setPreferredSize(new Dimension(80, 15));
		lStatPanelLabel_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lStatPanelLabel_1 = new JLabel("Ausdauerpunkte");
		lStatPanelLabel_1.setPreferredSize(new Dimension(80, 15));
		lStatPanelLabel_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lStatPanelLabel_2 = new JLabel("Astralpunkte");
		lStatPanelLabel_2.setPreferredSize(new Dimension(80, 15));
		lStatPanelLabel_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lStatPanelLabel_3 = new JLabel("Karmapunkte");
		lStatPanelLabel_3.setPreferredSize(new Dimension(80, 15));
		lStatPanelLabel_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lStatPanelLabel_4 = new JLabel("Magieresistenz");
		lStatPanelLabel_4.setPreferredSize(new Dimension(80, 15));
		lStatPanelLabel_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lStatPanelLabel_5 = new JLabel("Wundschwelle");
		lStatPanelLabel_5.setPreferredSize(new Dimension(80, 15));
		lStatPanelLabel_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lStatPanelLabel_6 = new JLabel("Ini-Basiswert");
		lStatPanelLabel_6.setPreferredSize(new Dimension(80, 15));
		lStatPanelLabel_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lStatPanelLabel_7 = new JLabel("At-Basiswert");
		lStatPanelLabel_7.setPreferredSize(new Dimension(80, 15));
		lStatPanelLabel_7.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lStatPanelLabel_8 = new JLabel("Pa-Pasiswert");
		lStatPanelLabel_8.setPreferredSize(new Dimension(80, 15));
		lStatPanelLabel_8.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lStatPanelLabel_9 = new JLabel("Fk-Basiswert");
		lStatPanelLabel_9.setPreferredSize(new Dimension(80, 15));
		lStatPanelLabel_9.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		spStatPanelSpinner_0 = new JSpinner();
		spStatPanelSpinner_0.setPreferredSize(new Dimension(37, 20));
		spStatPanelSpinner_0.setModel(new SpinnerNumberModel(25, 0, 500, 1));
		
		spStatPanelSpinner_1 = new JSpinner();
		spStatPanelSpinner_1.setPreferredSize(new Dimension(37, 20));
		spStatPanelSpinner_1.setModel(new SpinnerNumberModel(25, 0, 500, 1));
		
		spStatPanelSpinner_2 = new JSpinner();
		spStatPanelSpinner_2.setPreferredSize(new Dimension(37, 20));
		spStatPanelSpinner_2.setModel(new SpinnerNumberModel(-1, -1, 500, 1));
		spStatPanelSpinner_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (((int)spStatPanelSpinner_2.getValue()) == -1) {
					spTempStatPanelSpinner_2.setValue((int)-1);
					spTempStatPanelSpinner_2.setVisible(false);
					lTempStatPanelLabel_2.setVisible(false);
				} else {
					spTempStatPanelSpinner_2.setValue((int)0);
					spTempStatPanelSpinner_2.setVisible(true);
					lTempStatPanelLabel_2.setVisible(true);
				}
			}
		});
		
		spStatPanelSpinner_3 = new JSpinner();
		spStatPanelSpinner_3.setPreferredSize(new Dimension(37, 20));
		spStatPanelSpinner_0.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
		spStatPanelSpinner_3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (((int)spStatPanelSpinner_3.getValue()) == -1) {
					spTempStatPanelSpinner_3.setValue((int)-1);
					spTempStatPanelSpinner_3.setVisible(false);
					lTempStatPanelLabel_3.setVisible(false);
				} else {
					spTempStatPanelSpinner_3.setValue((int)0);
					spTempStatPanelSpinner_3.setVisible(true);
					lTempStatPanelLabel_3.setVisible(true);
				}
			}
		});
		
		spStatPanelSpinner_4 = new JSpinner();
		spStatPanelSpinner_4.setPreferredSize(new Dimension(37, 20));
		spStatPanelSpinner_0.setModel(new SpinnerNumberModel(4, 0, 50, 1));
		
		spStatPanelSpinner_5 = new JSpinner();
		spStatPanelSpinner_5.setPreferredSize(new Dimension(37, 20));
		spStatPanelSpinner_0.setModel(new SpinnerNumberModel(7, 1, 30, 1));
		
		spStatPanelSpinner_6 = new JSpinner();
		spStatPanelSpinner_6.setPreferredSize(new Dimension(37, 20));
		spStatPanelSpinner_0.setModel(new SpinnerNumberModel(9, 0, 30, 1));
		
		spStatPanelSpinner_7 = new JSpinner();
		spStatPanelSpinner_7.setPreferredSize(new Dimension(37, 20));
		spStatPanelSpinner_0.setModel(new SpinnerNumberModel(7, 0, 30, 1));
		
		spStatPanelSpinner_8 = new JSpinner();
		spStatPanelSpinner_8.setPreferredSize(new Dimension(37, 20));
		spStatPanelSpinner_0.setModel(new SpinnerNumberModel(7, 0, 30, 1));
		
		spStatPanelSpinner_9 = new JSpinner();
		spStatPanelSpinner_9.setPreferredSize(new Dimension(37, 20));
		spStatPanelSpinner_0.setModel(new SpinnerNumberModel(7, 0, 30, 1));
		
		GroupLayout gl_pStatFramePanel = new GroupLayout(pStatFramePanel);
		gl_pStatFramePanel.setHorizontalGroup(
			gl_pStatFramePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pStatFramePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pStatFramePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lStatPanelTitle, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
						.addGroup(gl_pStatFramePanel.createSequentialGroup()
							.addComponent(lStatPanelLabel_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spStatPanelSpinner_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lStatPanelLabel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spStatPanelSpinner_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pStatFramePanel.createSequentialGroup()
							.addComponent(lStatPanelLabel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spStatPanelSpinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lStatPanelLabel_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spStatPanelSpinner_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pStatFramePanel.createSequentialGroup()
							.addComponent(lStatPanelLabel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spStatPanelSpinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lStatPanelLabel_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spStatPanelSpinner_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pStatFramePanel.createSequentialGroup()
							.addComponent(lStatPanelLabel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spStatPanelSpinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lStatPanelLabel_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spStatPanelSpinner_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pStatFramePanel.createSequentialGroup()
							.addComponent(lStatPanelLabel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spStatPanelSpinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lStatPanelLabel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spStatPanelSpinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pStatFramePanel.setVerticalGroup(
			gl_pStatFramePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pStatFramePanel.createSequentialGroup()
					.addComponent(lStatPanelTitle, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pStatFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lStatPanelLabel_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spStatPanelSpinner_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lStatPanelLabel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spStatPanelSpinner_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pStatFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lStatPanelLabel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spStatPanelSpinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lStatPanelLabel_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spStatPanelSpinner_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pStatFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lStatPanelLabel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spStatPanelSpinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lStatPanelLabel_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spStatPanelSpinner_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pStatFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lStatPanelLabel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spStatPanelSpinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lStatPanelLabel_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spStatPanelSpinner_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pStatFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lStatPanelLabel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spStatPanelSpinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lStatPanelLabel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spStatPanelSpinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		pStatFramePanel.setLayout(gl_pStatFramePanel);
	}
	/**	Dh	24.6.2020
	 * 
	 */
	private void initTempStatPanel() {
		pTempStatPanel = new JPanel();
		pTempStatPanel.setBackground(Color.WHITE);
		
		lTempStatTitle = new JLabel("Tempor\u00E4re Statuswerte");
		lTempStatTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lTempStatTitle.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		lTempStatTitle.setAlignmentX(0.5f);
		
		lTempStatPanelLabel_0 = new JLabel("Lebenspunkte");
		lTempStatPanelLabel_0.setPreferredSize(new Dimension(80, 15));
		lTempStatPanelLabel_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lTempStatPanelLabel_1 = new JLabel("Ausdauerpunkte");
		lTempStatPanelLabel_1.setPreferredSize(new Dimension(80, 15));
		lTempStatPanelLabel_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lTempStatPanelLabel_2 = new JLabel("Astralpunkte");
		lTempStatPanelLabel_2.setPreferredSize(new Dimension(80, 15));
		lTempStatPanelLabel_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lTempStatPanelLabel_3 = new JLabel("Karmalpunkte");
		lTempStatPanelLabel_3.setPreferredSize(new Dimension(80, 15));
		lTempStatPanelLabel_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		spTempStatPanelSpinner_0 = new JSpinner();
		spTempStatPanelSpinner_0.setPreferredSize(new Dimension(37, 20));
		
		spTempStatPanelSpinner_1 = new JSpinner();
		spTempStatPanelSpinner_1.setPreferredSize(new Dimension(37, 20));
		
		spTempStatPanelSpinner_2 = new JSpinner();
		spTempStatPanelSpinner_2.setPreferredSize(new Dimension(37, 20));
	
		spTempStatPanelSpinner_3 = new JSpinner();
		spTempStatPanelSpinner_3.setPreferredSize(new Dimension(37, 20));
		
		GroupLayout gl_pTempStatPanel = new GroupLayout(pTempStatPanel);
		gl_pTempStatPanel.setHorizontalGroup(
			gl_pTempStatPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 302, Short.MAX_VALUE)
				.addGroup(gl_pTempStatPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pTempStatPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lTempStatTitle, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
						.addGroup(gl_pTempStatPanel.createSequentialGroup()
							.addComponent(lTempStatPanelLabel_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spTempStatPanelSpinner_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lTempStatPanelLabel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spTempStatPanelSpinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pTempStatPanel.createSequentialGroup()
							.addComponent(lTempStatPanelLabel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spTempStatPanelSpinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lTempStatPanelLabel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spTempStatPanelSpinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pTempStatPanel.setVerticalGroup(
			gl_pTempStatPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 180, Short.MAX_VALUE)
				.addGroup(gl_pTempStatPanel.createSequentialGroup()
					.addComponent(lTempStatTitle, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pTempStatPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lTempStatPanelLabel_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spTempStatPanelSpinner_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lTempStatPanelLabel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spTempStatPanelSpinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pTempStatPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lTempStatPanelLabel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spTempStatPanelSpinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lTempStatPanelLabel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spTempStatPanelSpinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		pTempStatPanel.setLayout(gl_pTempStatPanel);
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	25.6.2020
	 * 
	 */
	private void setValues() {
		try {
			if ((ID >= 0) && (rCM.haveCharacterID(ID) == true)) {
				lStatFrameTitle_1.setText("für "+rCM.getNameOfCharacter(ID));
				
				spStatPanelSpinner_0.setValue(rCM.getMaxStatOfCharacter(ID, 0));
				spStatPanelSpinner_1.setValue(rCM.getMaxStatOfCharacter(ID, 1));
				spStatPanelSpinner_2.setValue(rCM.getMaxStatOfCharacter(ID, 2));
				spStatPanelSpinner_3.setValue(rCM.getMaxStatOfCharacter(ID, 3));
				
				spStatPanelSpinner_4.setValue(rCM.getMagicResistanceOfCharacter(ID));
				spStatPanelSpinner_5.setValue(rCM.getWoundThresholdOfCharacter(ID));
				
				spStatPanelSpinner_6.setValue(rCM.getFightValueOfCharacter(ID, 0));
				spStatPanelSpinner_7.setValue(rCM.getFightValueOfCharacter(ID, 1));
				spStatPanelSpinner_8.setValue(rCM.getFightValueOfCharacter(ID, 2));
				spStatPanelSpinner_9.setValue(rCM.getFightValueOfCharacter(ID, 3));
				
				spTempStatPanelSpinner_0.setValue(rCM.getStatOfCharacter(ID, 0));
				spTempStatPanelSpinner_1.setValue(rCM.getStatOfCharacter(ID, 1));
				spTempStatPanelSpinner_2.setValue(rCM.getStatOfCharacter(ID, 2));
				spTempStatPanelSpinner_3.setValue(rCM.getStatOfCharacter(ID, 3));
				
				if (((int)spStatPanelSpinner_2.getValue()) == -1) {
					lTempStatPanelLabel_2.setVisible(false);
					spTempStatPanelSpinner_2.setVisible(false);
				}
				if (((int)spStatPanelSpinner_3.getValue()) == -1) {
					lTempStatPanelLabel_3.setVisible(false);
					spTempStatPanelSpinner_3.setVisible(false);
				}
			} else {
				rMF.handleException(new Exception("02; StFra,sV"));
				cancel();				
			}
		}catch (Exception ex) {rMF.handleException(ex);}
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	24.6.2020
	 * 
	 */
	private void cancel() {
		rMF.closeCharManModFrame();
		
		setVisible(false);
		dispose();
	}
	/**	Dh	24.6.2020
	 * 
	 */
	private void apply() {
		
		try { rCM.setMaxStatusOfCharacter(ID, (int)spStatPanelSpinner_0.getValue(), 0);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setMaxStatusOfCharacter(ID, (int)spStatPanelSpinner_1.getValue(), 1);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setMaxStatusOfCharacter(ID, (int)spStatPanelSpinner_2.getValue(), 2);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setMaxStatusOfCharacter(ID, (int)spStatPanelSpinner_3.getValue(), 3);}
		catch (Exception ex) {rMF.handleException(ex);}

		try { rCM.setMagicResistanceOfCharacter(ID, (int)spStatPanelSpinner_4.getValue());}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setWoundThresholdOfCharacter(ID, (int)spStatPanelSpinner_5.getValue());}
		catch (Exception ex) {rMF.handleException(ex);}
		
		try { rCM.setFightValueOfCharacter(ID, (int)spStatPanelSpinner_6.getValue(), 0);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setFightValueOfCharacter(ID, (int)spStatPanelSpinner_7.getValue(), 1);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setFightValueOfCharacter(ID, (int)spStatPanelSpinner_8.getValue(), 2);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setFightValueOfCharacter(ID, (int)spStatPanelSpinner_9.getValue(), 4);}
		catch (Exception ex) {rMF.handleException(ex);}
		
		try { rCM.setMaxStatusOfCharacter(ID, (int)spTempStatPanelSpinner_0.getValue(), 0);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setMaxStatusOfCharacter(ID, (int)spTempStatPanelSpinner_1.getValue(), 1);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setMaxStatusOfCharacter(ID, (int)spTempStatPanelSpinner_2.getValue(), 2);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setMaxStatusOfCharacter(ID, (int)spTempStatPanelSpinner_3.getValue(), 3);}
		catch (Exception ex) {rMF.handleException(ex);}
		
		cancel();
	}
	
}
