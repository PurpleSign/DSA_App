/**	DSA_App v0.0	Dh	25.6.2020
 * 
 * 	pGUI
 * 	  PropertyFrame
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

import pLogik.CharacterManager;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.Manifest;

import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class PropertyFrame extends JFrame {
	private int ID, Height, Width;
	
	private CharacterManager rCM;
	private MainFrame rMF;
	
	private JPanel contentPane, pPropFramePanel;
	
	private JLabel lPropFrameTitle_0, lPropFrameTitle_1, lPropPanelTitle;
	private JLabel lPropPanelLabel_0, lPropPanelLabel_1, lPropPanelLabel_2, lPropPanelLabel_3, lPropPanelLabel_4, lPropPanelLabel_5, 
		lPropPanelLabel_6, lPropPanelLabel_7, lPropPanelLabel_8, lPropPanelLabel_9;
	
	private JSpinner spPropPanelSpinner_0, spPropPanelSpinner_1, spPropPanelSpinner_2, spPropPanelSpinner_3, spPropPanelSpinner_4, spPropPanelSpinner_5,
		spPropPanelSpinner_6, spPropPanelSpinner_7, spPropPanelSpinner_8, spPropPanelSpinner_9;

	private JButton btPropFrameButton_0, btPropFrameButton_1;

	/**
	 * Create the frame.
	 */
	public PropertyFrame(int pID, CharacterManager pCM, MainFrame pMF) {
		ID = pID;
		rCM = pCM;
		rMF = pMF;
		
		Width = 310;
		Height = 360;
		
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
		//setBounds(100, 100, 324, 347);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		pPropFramePanel = new JPanel();
		pPropFramePanel.setBackground(Color.WHITE);
		
		
		
		lPropFrameTitle_0 = new JLabel("Eigenschafts Auswahl");
		lPropFrameTitle_0.setHorizontalAlignment(SwingConstants.CENTER);
		lPropFrameTitle_0.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		
		lPropFrameTitle_1 = new JLabel("Test");
		lPropFrameTitle_1.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		lPropFrameTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		initPropPanel();
		
		btPropFrameButton_0 = new JButton("Anwenden");
		btPropFrameButton_0.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btPropFrameButton_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				apply();
			}
		});
		
		btPropFrameButton_1 = new JButton("Abbrechen");
		btPropFrameButton_1.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btPropFrameButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lPropFrameTitle_0, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lPropFrameTitle_1, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(pPropFramePanel, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btPropFrameButton_0, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btPropFrameButton_1, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lPropFrameTitle_0, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lPropFrameTitle_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pPropFramePanel, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btPropFrameButton_0, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btPropFrameButton_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	/**	Dh	24.6.2020
	 * 
	 */
	private void initPropPanel() {
		lPropPanelTitle = new JLabel("Eigenschaften");
		lPropPanelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lPropPanelTitle.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		lPropPanelLabel_0 = new JLabel("Mut");
		lPropPanelLabel_0.setPreferredSize(new Dimension(80, 15));
		lPropPanelLabel_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lPropPanelLabel_1 = new JLabel("Klugheit");
		lPropPanelLabel_1.setPreferredSize(new Dimension(80, 15));
		lPropPanelLabel_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lPropPanelLabel_2 = new JLabel("Intuition");
		lPropPanelLabel_2.setPreferredSize(new Dimension(80, 15));
		lPropPanelLabel_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lPropPanelLabel_3 = new JLabel("Charisma");
		lPropPanelLabel_3.setPreferredSize(new Dimension(80, 15));
		lPropPanelLabel_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lPropPanelLabel_4 = new JLabel("Fingerfertigkeit");
		lPropPanelLabel_4.setPreferredSize(new Dimension(80, 15));
		lPropPanelLabel_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lPropPanelLabel_5 = new JLabel("Gewandtheit");
		lPropPanelLabel_5.setPreferredSize(new Dimension(80, 15));
		lPropPanelLabel_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lPropPanelLabel_6 = new JLabel("Konstitution");
		lPropPanelLabel_6.setPreferredSize(new Dimension(80, 15));
		lPropPanelLabel_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lPropPanelLabel_7 = new JLabel("K\u00F6rperkraft");
		lPropPanelLabel_7.setPreferredSize(new Dimension(80, 15));
		lPropPanelLabel_7.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lPropPanelLabel_8 = new JLabel("Geschwindigkeit");
		lPropPanelLabel_8.setPreferredSize(new Dimension(80, 15));
		lPropPanelLabel_8.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lPropPanelLabel_9 = new JLabel("Sozialstatus");
		lPropPanelLabel_9.setPreferredSize(new Dimension(80, 15));
		lPropPanelLabel_9.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		spPropPanelSpinner_0 = new JSpinner();
		spPropPanelSpinner_0.setPreferredSize(new Dimension(37, 20));
		spPropPanelSpinner_0.setModel(new SpinnerNumberModel(10, 0, 40, 1));
		
		spPropPanelSpinner_1 = new JSpinner();
		spPropPanelSpinner_1.setPreferredSize(new Dimension(37, 20));
		spPropPanelSpinner_1.setModel(new SpinnerNumberModel(10, 0, 40, 1));
		
		spPropPanelSpinner_2 = new JSpinner();
		spPropPanelSpinner_2.setPreferredSize(new Dimension(37, 20));
		spPropPanelSpinner_2.setModel(new SpinnerNumberModel(10, 0, 40, 1));
		
		spPropPanelSpinner_3 = new JSpinner();
		spPropPanelSpinner_3.setPreferredSize(new Dimension(37, 20));
		spPropPanelSpinner_3.setModel(new SpinnerNumberModel(10, 0, 40, 1));
		
		spPropPanelSpinner_4 = new JSpinner();
		spPropPanelSpinner_4.setPreferredSize(new Dimension(37, 20));
		spPropPanelSpinner_4.setModel(new SpinnerNumberModel(10, 0, 40, 1));
		
		spPropPanelSpinner_5 = new JSpinner();
		spPropPanelSpinner_5.setPreferredSize(new Dimension(37, 20));
		spPropPanelSpinner_5.setModel(new SpinnerNumberModel(10, 0, 40, 1));
		
		spPropPanelSpinner_6 = new JSpinner();
		spPropPanelSpinner_6.setPreferredSize(new Dimension(37, 20));
		spPropPanelSpinner_6.setModel(new SpinnerNumberModel(10, 0, 40, 1));
		
		spPropPanelSpinner_7 = new JSpinner();
		spPropPanelSpinner_7.setPreferredSize(new Dimension(37, 20));
		spPropPanelSpinner_7.setModel(new SpinnerNumberModel(10, 0, 40, 1));
		
		spPropPanelSpinner_8 = new JSpinner();
		spPropPanelSpinner_8.setPreferredSize(new Dimension(37, 20));
		spPropPanelSpinner_8.setModel(new SpinnerNumberModel(8, 0, 40, 1));
		
		spPropPanelSpinner_9 = new JSpinner();
		spPropPanelSpinner_9.setPreferredSize(new Dimension(37, 20));
		spPropPanelSpinner_9.setModel(new SpinnerNumberModel(7, 1, 18, 1));
		
		GroupLayout gl_pPropFramePanel = new GroupLayout(pPropFramePanel);
		gl_pPropFramePanel.setHorizontalGroup(
			gl_pPropFramePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pPropFramePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pPropFramePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lPropPanelTitle, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
						.addGroup(gl_pPropFramePanel.createSequentialGroup()
							.addGroup(gl_pPropFramePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lPropPanelLabel_0, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lPropPanelLabel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lPropPanelLabel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lPropPanelLabel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lPropPanelLabel_8, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(gl_pPropFramePanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pPropFramePanel.createSequentialGroup()
									.addComponent(spPropPanelSpinner_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lPropPanelLabel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pPropFramePanel.createSequentialGroup()
									.addComponent(spPropPanelSpinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lPropPanelLabel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pPropFramePanel.createSequentialGroup()
									.addComponent(spPropPanelSpinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lPropPanelLabel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pPropFramePanel.createSequentialGroup()
									.addComponent(spPropPanelSpinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lPropPanelLabel_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pPropFramePanel.createSequentialGroup()
									.addComponent(spPropPanelSpinner_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lPropPanelLabel_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pPropFramePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(spPropPanelSpinner_9, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spPropPanelSpinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spPropPanelSpinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spPropPanelSpinner_6, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spPropPanelSpinner_7, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_pPropFramePanel.setVerticalGroup(
			gl_pPropFramePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pPropFramePanel.createSequentialGroup()
					.addGap(5)
					.addComponent(lPropPanelTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pPropFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lPropPanelLabel_0, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spPropPanelSpinner_0, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lPropPanelLabel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spPropPanelSpinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pPropFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lPropPanelLabel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spPropPanelSpinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lPropPanelLabel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spPropPanelSpinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pPropFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lPropPanelLabel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spPropPanelSpinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lPropPanelLabel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spPropPanelSpinner_6, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pPropFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lPropPanelLabel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spPropPanelSpinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lPropPanelLabel_7, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spPropPanelSpinner_7, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pPropFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lPropPanelLabel_8, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spPropPanelSpinner_8, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lPropPanelLabel_9, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(spPropPanelSpinner_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		pPropFramePanel.setLayout(gl_pPropFramePanel);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	24.6.2020
	 * 
	 */
	private void setValues() {
		try {
			if ((ID >= 0) && (rCM.haveCharacterID(ID) == true)) {
				lPropFrameTitle_1.setText("für "+rCM.getNameOfCharacter(ID));
				
				spPropPanelSpinner_0.setValue(rCM.getPropertyOfCharacter(ID, 0));
				spPropPanelSpinner_1.setValue(rCM.getPropertyOfCharacter(ID, 1));
				spPropPanelSpinner_2.setValue(rCM.getPropertyOfCharacter(ID, 2));
				spPropPanelSpinner_3.setValue(rCM.getPropertyOfCharacter(ID, 3));
				spPropPanelSpinner_4.setValue(rCM.getPropertyOfCharacter(ID, 4));
				spPropPanelSpinner_5.setValue(rCM.getPropertyOfCharacter(ID, 5));
				spPropPanelSpinner_6.setValue(rCM.getPropertyOfCharacter(ID, 6));
				spPropPanelSpinner_7.setValue(rCM.getPropertyOfCharacter(ID, 7));
				
				spPropPanelSpinner_8.setValue(rCM.getVelocityOfCharacter(ID));
				spPropPanelSpinner_9.setValue(rCM.getSocialStatusOfCharacter(ID));
			} else {
				rMF.handleException(new Exception("02; PrFra,sV"));
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
		
		try { rCM.setPropertyOfCharacter(ID, (int)spPropPanelSpinner_0.getValue(), 0);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setPropertyOfCharacter(ID, (int)spPropPanelSpinner_1.getValue(), 1);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setPropertyOfCharacter(ID, (int)spPropPanelSpinner_2.getValue(), 2);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setPropertyOfCharacter(ID, (int)spPropPanelSpinner_3.getValue(), 3);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setPropertyOfCharacter(ID, (int)spPropPanelSpinner_4.getValue(), 4);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setPropertyOfCharacter(ID, (int)spPropPanelSpinner_5.getValue(), 5);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setPropertyOfCharacter(ID, (int)spPropPanelSpinner_6.getValue(), 6);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setPropertyOfCharacter(ID, (int)spPropPanelSpinner_7.getValue(), 7);}
		catch (Exception ex) {rMF.handleException(ex);}
		
		try { rCM.setVelocityOfCharacter(ID, (int)spPropPanelSpinner_8.getValue());}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setSocialStatusOfCharacter(ID, (int)spPropPanelSpinner_9.getValue());}
		catch (Exception ex) {rMF.handleException(ex);}
		
		cancel();
	}
	
}
