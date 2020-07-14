/**	DSA_App v0.0	Dh	14.7.2020
 * 
 * 	pGUI
 * 	  CharModFrame
 * 		CharValueModFrame
 * 		  ArmorFrame
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
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import pLogik.CharacterManager;
import java.awt.Dimension;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ArmorFrame extends CharValueModFrame {
	private JLabel lArmorPanelTitle, lArmorPanelLable_0, lArmorPanelLable_1, lArmorPanelLable_2, lArmorPanelLable_3, lArmorPanelLable_4,
		lArmorPanelLable_5, lArmorPanelLable_6, lArmorPanelLable_7, lArmorPanelLable_8, lArmorPanelLable_9;
	private JSpinner spArmorPanelSpinner_0, spArmorPanelSpinner_1, spArmorPanelSpinner_2, spArmorPanelSpinner_3, spArmorPanelSpinner_4,
		spArmorPanelSpinner_5, spArmorPanelSpinner_6, spArmorPanelSpinner_7, spArmorPanelSpinner_8, spArmorPanelSpinner_9;
	
	/**
	
	/**
	 * Create the frame.
	 */
	public ArmorFrame(int pID, CharacterManager pCM, MainFrame pMF) {
		super(pID, pCM, pMF);
	}
	
	//----------------------------------------------------------------------------------------------------

	/**	Dh	14.7.2020
	 * 
	 */
	protected void initSubPanel() {
		//pArmorFramePanel = new JPanel();
		//pArmorFramePanel.setBackground(Color.WHITE);
		
		lArmorPanelTitle = new JLabel("R\u00FCstungswerte");
		lArmorPanelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lArmorPanelTitle.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		lArmorPanelLable_0 = new JLabel("Kopf");
		lArmorPanelLable_0.setPreferredSize(new Dimension(80, 15));
		lArmorPanelLable_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lArmorPanelLable_1 = new JLabel("Brust");
		lArmorPanelLable_1.setPreferredSize(new Dimension(80, 15));
		lArmorPanelLable_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lArmorPanelLable_2 = new JLabel("R\u00FCcken");
		lArmorPanelLable_2.setPreferredSize(new Dimension(80, 15));
		lArmorPanelLable_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lArmorPanelLable_3 = new JLabel("rechter Arm");
		lArmorPanelLable_3.setPreferredSize(new Dimension(80, 15));
		lArmorPanelLable_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lArmorPanelLable_4 = new JLabel("linker Arm");
		lArmorPanelLable_4.setPreferredSize(new Dimension(80, 15));
		lArmorPanelLable_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lArmorPanelLable_5 = new JLabel("Bauch");
		lArmorPanelLable_5.setPreferredSize(new Dimension(80, 15));
		lArmorPanelLable_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lArmorPanelLable_6 = new JLabel("rechtes Bein");
		lArmorPanelLable_6.setPreferredSize(new Dimension(80, 15));
		lArmorPanelLable_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lArmorPanelLable_7 = new JLabel("linkes Bein");
		lArmorPanelLable_7.setPreferredSize(new Dimension(80, 15));
		lArmorPanelLable_7.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lArmorPanelLable_8 = new JLabel("Gesamt RS");
		lArmorPanelLable_8.setPreferredSize(new Dimension(80, 15));
		lArmorPanelLable_8.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lArmorPanelLable_9 = new JLabel("Behinderung");
		lArmorPanelLable_9.setPreferredSize(new Dimension(80, 15));
		lArmorPanelLable_9.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		spArmorPanelSpinner_0 = new JSpinner();
		spArmorPanelSpinner_0.setPreferredSize(new Dimension(37, 20));
		spArmorPanelSpinner_0.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		
		spArmorPanelSpinner_1 = new JSpinner();
		spArmorPanelSpinner_1.setPreferredSize(new Dimension(37, 20));
		spArmorPanelSpinner_1.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		
		spArmorPanelSpinner_2 = new JSpinner();
		spArmorPanelSpinner_2.setPreferredSize(new Dimension(37, 20));
		spArmorPanelSpinner_2.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		
		spArmorPanelSpinner_3 = new JSpinner();
		spArmorPanelSpinner_3.setPreferredSize(new Dimension(37, 20));
		spArmorPanelSpinner_3.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		
		spArmorPanelSpinner_4 = new JSpinner();
		spArmorPanelSpinner_4.setPreferredSize(new Dimension(37, 20));
		spArmorPanelSpinner_4.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		
		spArmorPanelSpinner_5 = new JSpinner();
		spArmorPanelSpinner_5.setPreferredSize(new Dimension(37, 20));
		spArmorPanelSpinner_5.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		
		spArmorPanelSpinner_6 = new JSpinner();
		spArmorPanelSpinner_6.setPreferredSize(new Dimension(37, 20));
		spArmorPanelSpinner_6.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		
		spArmorPanelSpinner_7 = new JSpinner();
		spArmorPanelSpinner_7.setPreferredSize(new Dimension(37, 20));
		spArmorPanelSpinner_7.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		
		spArmorPanelSpinner_8 = new JSpinner();
		spArmorPanelSpinner_8.setPreferredSize(new Dimension(37, 20));
		spArmorPanelSpinner_8.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		
		spArmorPanelSpinner_9 = new JSpinner();
		spArmorPanelSpinner_9.setPreferredSize(new Dimension(37, 20));
		spArmorPanelSpinner_9.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		
		GroupLayout gl_pArmorFramePanel = new GroupLayout(pFramePanel);
		gl_pArmorFramePanel.setHorizontalGroup(
			gl_pArmorFramePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 284, Short.MAX_VALUE)
				.addGroup(gl_pArmorFramePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pArmorFramePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lArmorPanelTitle, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
						.addGroup(gl_pArmorFramePanel.createSequentialGroup()
							.addGroup(gl_pArmorFramePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lArmorPanelLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lArmorPanelLable_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lArmorPanelLable_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lArmorPanelLable_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lArmorPanelLable_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(gl_pArmorFramePanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pArmorFramePanel.createSequentialGroup()
									.addComponent(spArmorPanelSpinner_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lArmorPanelLable_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pArmorFramePanel.createSequentialGroup()
									.addComponent(spArmorPanelSpinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lArmorPanelLable_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pArmorFramePanel.createSequentialGroup()
									.addComponent(spArmorPanelSpinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lArmorPanelLable_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pArmorFramePanel.createSequentialGroup()
									.addComponent(spArmorPanelSpinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lArmorPanelLable_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pArmorFramePanel.createSequentialGroup()
									.addComponent(spArmorPanelSpinner_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lArmorPanelLable_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pArmorFramePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(spArmorPanelSpinner_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spArmorPanelSpinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spArmorPanelSpinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spArmorPanelSpinner_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spArmorPanelSpinner_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_pArmorFramePanel.setVerticalGroup(
			gl_pArmorFramePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 182, Short.MAX_VALUE)
				.addGroup(gl_pArmorFramePanel.createSequentialGroup()
					.addGap(5)
					.addComponent(lArmorPanelTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pArmorFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lArmorPanelLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spArmorPanelSpinner_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lArmorPanelLable_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spArmorPanelSpinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pArmorFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lArmorPanelLable_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spArmorPanelSpinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lArmorPanelLable_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spArmorPanelSpinner_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pArmorFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lArmorPanelLable_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spArmorPanelSpinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lArmorPanelLable_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spArmorPanelSpinner_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pArmorFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lArmorPanelLable_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spArmorPanelSpinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lArmorPanelLable_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spArmorPanelSpinner_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pArmorFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lArmorPanelLable_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spArmorPanelSpinner_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lArmorPanelLable_9, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(spArmorPanelSpinner_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		pFramePanel.setLayout(gl_pArmorFramePanel);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	14.7.2020
	 * 
	 */
	protected void setSpecificValues(int pID) throws Exception{
		lFrameTitle_0.setText("R\u00FCstungs Auswahl");
		
		spArmorPanelSpinner_0.setValue((int)Math.round(rCM.getArmorValueOfCharacter(pID, 0)));
		spArmorPanelSpinner_1.setValue((int)Math.round(rCM.getArmorValueOfCharacter(pID, 1)));
		spArmorPanelSpinner_2.setValue((int)Math.round(rCM.getArmorValueOfCharacter(pID, 2)));
		spArmorPanelSpinner_3.setValue((int)Math.round(rCM.getArmorValueOfCharacter(pID, 3)));
		spArmorPanelSpinner_4.setValue((int)Math.round(rCM.getArmorValueOfCharacter(pID, 4)));
		spArmorPanelSpinner_5.setValue((int)Math.round(rCM.getArmorValueOfCharacter(pID, 5)));
		spArmorPanelSpinner_6.setValue((int)Math.round(rCM.getArmorValueOfCharacter(pID, 6)));
		spArmorPanelSpinner_7.setValue((int)Math.round(rCM.getArmorValueOfCharacter(pID, 7)));
		
		spArmorPanelSpinner_8.setValue((int)Math.round(rCM.getArmorValueOfCharacter(0, 8)));
		spArmorPanelSpinner_9.setValue((int)Math.round(rCM.getHandicapOfCharacter(pID)));
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	14.7.2020
	 * 
	 */
	protected void apply() {
		
		try { rCM.setArmorValueOfCharacter(id, (int)spArmorPanelSpinner_0.getValue(), 0);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setArmorValueOfCharacter(id, (int)spArmorPanelSpinner_1.getValue(), 1);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setArmorValueOfCharacter(id, (int)spArmorPanelSpinner_2.getValue(), 2);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setArmorValueOfCharacter(id, (int)spArmorPanelSpinner_3.getValue(), 3);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setArmorValueOfCharacter(id, (int)spArmorPanelSpinner_4.getValue(), 4);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setArmorValueOfCharacter(id, (int)spArmorPanelSpinner_5.getValue(), 5);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setArmorValueOfCharacter(id, (int)spArmorPanelSpinner_6.getValue(), 6);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setArmorValueOfCharacter(id, (int)spArmorPanelSpinner_7.getValue(), 7);}
		catch (Exception ex) {rMF.handleException(ex);}
		
		try { rCM.setArmorValueOfCharacter(id, (int)spArmorPanelSpinner_8.getValue(), 8);}
		catch (Exception ex) {rMF.handleException(ex);}
		try { rCM.setHandicapOfCharacter(id, (int)spArmorPanelSpinner_9.getValue());}
		catch (Exception ex) {rMF.handleException(ex);}
		
		cancel();
	}
	
}
