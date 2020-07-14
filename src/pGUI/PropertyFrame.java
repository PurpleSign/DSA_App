/**	DSA_App v0.0	Dh	14.7.2020
 * 
 * 	pGUI
 * 	  CharModFrame
 * 		CharValueModFrame
 * 	  	  PropertyFrame
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

public class PropertyFrame extends CharValueModFrame {
	private JLabel lPropPanelTitle, lPropPanelLabel_0, lPropPanelLabel_1, lPropPanelLabel_2, lPropPanelLabel_3, lPropPanelLabel_4,
		lPropPanelLabel_5, lPropPanelLabel_6, lPropPanelLabel_7, lPropPanelLabel_8, lPropPanelLabel_9;
	
	private JSpinner spPropPanelSpinner_0, spPropPanelSpinner_1, spPropPanelSpinner_2, spPropPanelSpinner_3, spPropPanelSpinner_4,
		spPropPanelSpinner_5, spPropPanelSpinner_6, spPropPanelSpinner_7, spPropPanelSpinner_8, spPropPanelSpinner_9;
	
	/**
	 * Create the frame.
	 */
	public PropertyFrame(int pID, CharacterManager pCM, MainFrame pMF) {
		super(pID, pCM, pMF);
	}

	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	14.7.2020
	 * 
	 */
	protected void initSubPanel() {
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
		
		GroupLayout gl_pPropFramePanel = new GroupLayout(pFramePanel);
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
		pFramePanel.setLayout(gl_pPropFramePanel);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	14.7.2020
	 * 
	 */
	protected void setSpecificValues(int pID) throws Exception{
		lFrameTitle_0.setText("Eigenschafts Auswahl");
		
		spPropPanelSpinner_0.setValue(rCM.getPropertyOfCharacter(pID, 0));
		spPropPanelSpinner_1.setValue(rCM.getPropertyOfCharacter(pID, 1));
		spPropPanelSpinner_2.setValue(rCM.getPropertyOfCharacter(pID, 2));
		spPropPanelSpinner_3.setValue(rCM.getPropertyOfCharacter(pID, 3));
		spPropPanelSpinner_4.setValue(rCM.getPropertyOfCharacter(pID, 4));
		spPropPanelSpinner_5.setValue(rCM.getPropertyOfCharacter(pID, 5));
		spPropPanelSpinner_6.setValue(rCM.getPropertyOfCharacter(pID, 6));
		spPropPanelSpinner_7.setValue(rCM.getPropertyOfCharacter(pID, 7));
		
		spPropPanelSpinner_8.setValue(rCM.getVelocityOfCharacter(pID));
		spPropPanelSpinner_9.setValue(rCM.getSocialStatusOfCharacter(pID));
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	24.6.2020
	 * 
	 */
	protected void apply() {
		
		try { rCM.setPropertyOfCharacter(id, (int)spPropPanelSpinner_0.getValue(), 0);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setPropertyOfCharacter(id, (int)spPropPanelSpinner_1.getValue(), 1);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setPropertyOfCharacter(id, (int)spPropPanelSpinner_2.getValue(), 2);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setPropertyOfCharacter(id, (int)spPropPanelSpinner_3.getValue(), 3);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setPropertyOfCharacter(id, (int)spPropPanelSpinner_4.getValue(), 4);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setPropertyOfCharacter(id, (int)spPropPanelSpinner_5.getValue(), 5);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setPropertyOfCharacter(id, (int)spPropPanelSpinner_6.getValue(), 6);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setPropertyOfCharacter(id, (int)spPropPanelSpinner_7.getValue(), 7);}
		catch (Exception ex) {rMF.handleException(ex);}
		
		try { rCM.setVelocityOfCharacter(id, (int)spPropPanelSpinner_8.getValue());}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setSocialStatusOfCharacter(id, (int)spPropPanelSpinner_9.getValue());}
		catch (Exception ex) {rMF.handleException(ex);}
		
		cancel();
	}
	
}
