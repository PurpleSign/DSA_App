/**	DSA_App v0.0	Dh	14.7.2020
 * 
 * 	pGUI
 * 	  CharModFrame
 * 		CharValueModFrame
 * 		  StatusFrame
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

public class StatusFrame extends CharValueModFrame{
	private JPanel contentPane, pStatFramePanel, pTempStatPanel;
	
	private JLabel lStatPanelTitle, lTempStatTitle;
	private JLabel lStatPanelLabel_0, lStatPanelLabel_1, lStatPanelLabel_2, lStatPanelLabel_3, lStatPanelLabel_4, lStatPanelLabel_5,
		lStatPanelLabel_6, lStatPanelLabel_7, lStatPanelLabel_8, lStatPanelLabel_9;
	private JLabel lTempStatPanelLabel_0, lTempStatPanelLabel_1, lTempStatPanelLabel_2, lTempStatPanelLabel_3;
	
	private JSpinner spStatPanelSpinner_0, spStatPanelSpinner_1, spStatPanelSpinner_2, spStatPanelSpinner_3, spStatPanelSpinner_4,
		spStatPanelSpinner_5, spStatPanelSpinner_6, spStatPanelSpinner_7, spStatPanelSpinner_8, spStatPanelSpinner_9;
	private JSpinner spTempStatPanelSpinner_0, spTempStatPanelSpinner_1, spTempStatPanelSpinner_2, spTempStatPanelSpinner_3;

	
	/**
	 * Create the frame.
	 */
	public StatusFrame(int pID, CharacterManager pCM, MainFrame pMF) {
		super(pID, pCM, pMF);
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	14.7.2020
	 * 
	 */
	protected void initSize() {
		width = 320;
		height = 460;
	}
	
	//----------------------------------------------------------------------------------------------------

	/**	Dh	14.7.2020
	 * 
	 */
	protected void initFrame() {
		Point vPos = rMF.getMiddlePosition();
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds((int)(vPos.getX()-(width/2)), (int)(vPos.getY()-(height/2)), width, height);
		//setBounds(100, 100, 330, 464);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lFrameTitle_0 = new JLabel("Status Auswahl");
		lFrameTitle_0.setHorizontalAlignment(SwingConstants.CENTER);
		lFrameTitle_0.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		
		lFrameTitle_1 = new JLabel("Test");
		lFrameTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		lFrameTitle_1.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		initSubPanel();
		initTempStatPanel();
		
		btFrameButton_0 = new JButton("Anwenden");
		btFrameButton_0.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btFrameButton_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				apply();
			}
		});
		
		btFrameButton_1 = new JButton("Abbrechen");
		btFrameButton_1.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btFrameButton_1.addActionListener(new ActionListener() {
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
						.addComponent(lFrameTitle_0, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lFrameTitle_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btFrameButton_0, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btFrameButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lFrameTitle_0, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lFrameTitle_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pStatFramePanel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pTempStatPanel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btFrameButton_0, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btFrameButton_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	/**	Dh	14.7.2020
	 * 
	 */
	protected void initSubPanel() {
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
		spStatPanelSpinner_3.setModel(new SpinnerNumberModel(-1, -1, 100, 1));
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
		spStatPanelSpinner_4.setModel(new SpinnerNumberModel(4, 0, 50, 1));
		
		spStatPanelSpinner_5 = new JSpinner();
		spStatPanelSpinner_5.setPreferredSize(new Dimension(37, 20));
		spStatPanelSpinner_5.setModel(new SpinnerNumberModel(7, 1, 30, 1));
		
		spStatPanelSpinner_6 = new JSpinner();
		spStatPanelSpinner_6.setPreferredSize(new Dimension(37, 20));
		spStatPanelSpinner_6.setModel(new SpinnerNumberModel(9, 0, 30, 1));
		
		spStatPanelSpinner_7 = new JSpinner();
		spStatPanelSpinner_7.setPreferredSize(new Dimension(37, 20));
		spStatPanelSpinner_7.setModel(new SpinnerNumberModel(7, 0, 30, 1));
		
		spStatPanelSpinner_8 = new JSpinner();
		spStatPanelSpinner_8.setPreferredSize(new Dimension(37, 20));
		spStatPanelSpinner_8.setModel(new SpinnerNumberModel(7, 0, 30, 1));
		
		spStatPanelSpinner_9 = new JSpinner();
		spStatPanelSpinner_9.setPreferredSize(new Dimension(37, 20));
		spStatPanelSpinner_9.setModel(new SpinnerNumberModel(7, 0, 30, 1));
		
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
	/**	Dh	14.7.2020
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
		spTempStatPanelSpinner_0.setModel(new SpinnerNumberModel(25, -100, 500, 1));
		
		spTempStatPanelSpinner_1 = new JSpinner();
		spTempStatPanelSpinner_1.setPreferredSize(new Dimension(37, 20));
		spTempStatPanelSpinner_1.setModel(new SpinnerNumberModel(25, 0, 500, 1));
		
		spTempStatPanelSpinner_2 = new JSpinner();
		spTempStatPanelSpinner_2.setPreferredSize(new Dimension(37, 20));
		spTempStatPanelSpinner_2.setModel(new SpinnerNumberModel(25, -1, 500, 1));
	
		spTempStatPanelSpinner_3 = new JSpinner();
		spTempStatPanelSpinner_3.setPreferredSize(new Dimension(37, 20));
		spTempStatPanelSpinner_3.setModel(new SpinnerNumberModel(25, -1, 500, 1));
		
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

	/**	Dh	14.7.2020
	 * 
	 */
	protected void setSpecificValues(int pID) throws Exception{
		spStatPanelSpinner_0.setValue((int)Math.round(rCM.getMaxStatOfCharacter(pID, 0)));
		spStatPanelSpinner_1.setValue((int)Math.round(rCM.getMaxStatOfCharacter(pID, 1)));
		spStatPanelSpinner_2.setValue((int)Math.round(rCM.getMaxStatOfCharacter(pID, 2)));
		spStatPanelSpinner_3.setValue((int)Math.round(rCM.getMaxStatOfCharacter(pID, 3)));
		
		spStatPanelSpinner_4.setValue((int)Math.round(rCM.getMagicResistanceOfCharacter(pID)));
		spStatPanelSpinner_5.setValue((int)Math.round(rCM.getWoundThresholdOfCharacter(pID)));
		
		spStatPanelSpinner_6.setValue((int)Math.round(rCM.getFightValueOfCharacter(pID, 0)));
		spStatPanelSpinner_7.setValue((int)Math.round(rCM.getFightValueOfCharacter(pID, 1)));
		spStatPanelSpinner_8.setValue((int)Math.round(rCM.getFightValueOfCharacter(pID, 2)));
		spStatPanelSpinner_9.setValue((int)Math.round(rCM.getFightValueOfCharacter(pID, 3)));
		
		spTempStatPanelSpinner_0.setValue(rCM.getStatOfCharacter(pID, 0));
		spTempStatPanelSpinner_1.setValue(rCM.getStatOfCharacter(pID, 1));
		spTempStatPanelSpinner_2.setValue(rCM.getStatOfCharacter(pID, 2));
		spTempStatPanelSpinner_3.setValue(rCM.getStatOfCharacter(pID, 3));
		
		if (((int)spStatPanelSpinner_2.getValue()) == -1) {
			lTempStatPanelLabel_2.setVisible(false);
			spTempStatPanelSpinner_2.setVisible(false);
		}
		if (((int)spStatPanelSpinner_3.getValue()) == -1) {
			lTempStatPanelLabel_3.setVisible(false);
			spTempStatPanelSpinner_3.setVisible(false);
		}
	}
		
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	14.7.2020
	 * 
	 */
	protected void apply() {
		
		try { rCM.setMaxStatusOfCharacter(id, ((double)((int)spStatPanelSpinner_0.getValue())+getDeci(rCM.getMaxStatOfCharacter(id, 0))), 0);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setMaxStatusOfCharacter(id, ((double)((int)spStatPanelSpinner_1.getValue())+getDeci(rCM.getMaxStatOfCharacter(id, 1))), 1);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setMaxStatusOfCharacter(id, ((double)((int)spStatPanelSpinner_2.getValue())+getDeci(rCM.getMaxStatOfCharacter(id, 2))), 2);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setMaxStatusOfCharacter(id, ((double)((int)spStatPanelSpinner_3.getValue())+getDeci(rCM.getMaxStatOfCharacter(id, 3))), 3);}
		catch (Exception ex) {rMF.handleException(ex);}
		
		try { rCM.setMagicResistanceOfCharacter(id, ((double)((int)spStatPanelSpinner_4.getValue())+getDeci(rCM.getMagicResistanceOfCharacter(id))));}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setWoundThresholdOfCharacter(id, ((double)((int)spStatPanelSpinner_5.getValue())+getDeci(rCM.getWoundThresholdOfCharacter(id))));}
		catch (Exception ex) {rMF.handleException(ex);}
		
		try { rCM.setFightValueOfCharacter(id, ((double)((int)spStatPanelSpinner_6.getValue())+getDeci(rCM.getFightValueOfCharacter(id, 0))), 0);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setFightValueOfCharacter(id, ((double)((int)spStatPanelSpinner_7.getValue())+getDeci(rCM.getFightValueOfCharacter(id, 1))), 1);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setFightValueOfCharacter(id, ((double)((int)spStatPanelSpinner_8.getValue())+getDeci(rCM.getFightValueOfCharacter(id, 2))), 2);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setFightValueOfCharacter(id, ((double)((int)spStatPanelSpinner_9.getValue())+getDeci(rCM.getFightValueOfCharacter(id, 3))), 3);}
		catch (Exception ex) {rMF.handleException(ex);}
		
		try { rCM.setStatusOfCharacter(id, (int)spTempStatPanelSpinner_0.getValue(), 0);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setStatusOfCharacter(id, (int)spTempStatPanelSpinner_1.getValue(), 1);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setStatusOfCharacter(id, (int)spTempStatPanelSpinner_2.getValue(), 2);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setStatusOfCharacter(id, (int)spTempStatPanelSpinner_3.getValue(), 3);}
		catch (Exception ex) {rMF.handleException(ex);}
		
		cancel();
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	14.7.2020
	 * 
	 * @param pValue
	 * @return
	 */
	private double getDeci(double pValue) {
		double vRet = pValue-((int)pValue);
		
		if (vRet >= 0.5) pValue = -1*pValue;
		
		return vRet;
	}
}
