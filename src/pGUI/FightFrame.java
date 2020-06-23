/**	DSA_App v0.0	Dh	11.6.2020
 * 
 * 	pGUI
 * 	  AttackFrame
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

import pLogik.CloseWeapon;
import pLogik.FightElement;
import pLogik.FightManager;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSplitPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;

public class FightFrame extends JFrame {
	private boolean Attack, CloseCombat;
	private int FighterID, OpponentID;
	
	private FightManager rFM;
	private MainFrame rMF;
	
	private JPanel contentPane, pAttackPanel, pSPPanel_0, pSPPanel_1;
	private JSplitPane spAttackSplitPanel;
	private JLabel lAttackTitle, lAttackLabel_0, lAttackLabel_1;
	private JTextField tfAttackField_0, tfAttackField_1;
	private JButton btAttackButton_0, btAttackButton_3, btAttackButton_2, btAttackButton_4;
	private JLabel lAttackLabel_2;

	/**
	 * Create the frame.
	 */
	public FightFrame(int pFighterID, int pOpponentID, boolean pAttack, boolean pCloseCombat, FightManager pFM, MainFrame pMF) {
		Attack = pAttack;
		CloseCombat = pCloseCombat;
		FighterID =pFighterID;
		OpponentID = pOpponentID;
		
		rFM = pFM;
		rMF = pMF;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pAttackPanel = new JPanel();
		contentPane.add(pAttackPanel, BorderLayout.CENTER);
		
		lAttackTitle = new JLabel("grefit an");
		lAttackTitle.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		
		lAttackLabel_0 = new JLabel("Angriffswert:");
		lAttackLabel_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lAttackLabel_1 = new JLabel("Modifikator:");
		lAttackLabel_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		tfAttackField_0 = new JTextField();
		tfAttackField_0.setPreferredSize(new Dimension(6, 15));
		tfAttackField_0.setEnabled(false);
		tfAttackField_0.setColumns(3);
		
		tfAttackField_1 = new JTextField();
		tfAttackField_1.setPreferredSize(new Dimension(6, 15));
		tfAttackField_1.setEnabled(false);
		tfAttackField_1.setColumns(3);
		
		initSplitPanel();
		
		btAttackButton_4 = new JButton("Abbrechen");
		btAttackButton_4.setPreferredSize(new Dimension(120, 30));
		btAttackButton_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		btAttackButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancle();
			}
		});
		
		lAttackLabel_2 = new JLabel("Angriff");
		lAttackLabel_2.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		GroupLayout gl_pAttackPanel = new GroupLayout(pAttackPanel);
		gl_pAttackPanel.setHorizontalGroup(
			gl_pAttackPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pAttackPanel.createSequentialGroup()
					.addGroup(gl_pAttackPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pAttackPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lAttackLabel_0)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfAttackField_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(lAttackLabel_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfAttackField_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pAttackPanel.createSequentialGroup()
							.addGap(95)
							.addComponent(lAttackTitle)))
					.addContainerGap(28, Short.MAX_VALUE))
				.addGroup(gl_pAttackPanel.createSequentialGroup()
					.addGap(110)
					.addComponent(lAttackLabel_2)
					.addContainerGap(126, Short.MAX_VALUE))
				.addComponent(spAttackSplitPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
				.addGroup(gl_pAttackPanel.createSequentialGroup()
					.addGap(71)
					.addComponent(btAttackButton_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(83, Short.MAX_VALUE))
		);
		gl_pAttackPanel.setVerticalGroup(
			gl_pAttackPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pAttackPanel.createSequentialGroup()
					.addComponent(lAttackTitle)
					.addGap(7)
					.addGroup(gl_pAttackPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lAttackLabel_0)
						.addComponent(tfAttackField_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lAttackLabel_1)
						.addComponent(tfAttackField_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lAttackLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spAttackSplitPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btAttackButton_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		pAttackPanel.setLayout(gl_pAttackPanel);
		
		initSpez();
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	3.6.2020
	 * 
	 */
	private void initSplitPanel() {
		spAttackSplitPanel = new JSplitPane();
		spAttackSplitPanel.setEnabled(false);
		
		pSPPanel_0 = new JPanel();
		spAttackSplitPanel.setLeftComponent(pSPPanel_0);
		
		pSPPanel_1 = new JPanel();
		spAttackSplitPanel.setRightComponent(pSPPanel_1);
		
		btAttackButton_0 = new JButton("Automatisch");
		btAttackButton_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		btAttackButton_0.setPreferredSize(new Dimension(110, 30));
		btAttackButton_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				automaticFightAction();
			}
		});
		
		GroupLayout gl_pSPPanel_0 = new GroupLayout(pSPPanel_0);
		gl_pSPPanel_0.setHorizontalGroup(
			gl_pSPPanel_0.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pSPPanel_0.createSequentialGroup()
					.addContainerGap()
					.addComponent(btAttackButton_0, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_pSPPanel_0.setVerticalGroup(
			gl_pSPPanel_0.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pSPPanel_0.createSequentialGroup()
					.addGap(29)
					.addComponent(btAttackButton_0, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		pSPPanel_0.setLayout(gl_pSPPanel_0);
		
		btAttackButton_2 = new JButton("Getroffen");
		btAttackButton_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		btAttackButton_2.setPreferredSize(new Dimension(110, 30));
		btAttackButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				successfulFightAction();
			}
		});
		
		btAttackButton_3 = new JButton("Verfehlt");
		btAttackButton_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		btAttackButton_3.setPreferredSize(new Dimension(110, 30));
		btAttackButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				unsuccessfullFightAction();
			}
		});
		
		GroupLayout gl_pSPPanel_1 = new GroupLayout(pSPPanel_1);
		gl_pSPPanel_1.setHorizontalGroup(
			gl_pSPPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pSPPanel_1.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_pSPPanel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btAttackButton_3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btAttackButton_2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_pSPPanel_1.setVerticalGroup(
			gl_pSPPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pSPPanel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btAttackButton_2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btAttackButton_3, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pSPPanel_1.setLayout(gl_pSPPanel_1);
		spAttackSplitPanel.setDividerLocation(130);
	}
	/**	Dh	4.6.2020
	 * 
	 */
	private void initSpez() {
		int vFigValue, vFigMod;
		String vFigName, vOppName;
		
		try {
			vFigName = rFM.getCharacterOfFighter(FighterID).getName();
			vOppName = rFM.getCharacterOfFighter(OpponentID).getName();
			
			
			if (Attack == true) {
				lAttackTitle.setText(vFigName+" greift "+vOppName+" an.");
				vFigValue = rFM.getActiveWeaponAttackValueOfFighter(FighterID);
				
				if (CloseCombat == true) {
					vFigMod = (int)rFM.getFightModOfNeighbourOfFighter(FighterID, OpponentID, 1);
					
					lAttackLabel_2.setText("Nahkampf angriff");
				}
				else {
					vFigMod = (int)rFM.getFightModOfNeighbourOfFighter(FighterID, OpponentID, 3);
					
					lAttackLabel_2.setText("Fernkampf angriff");
				}
			} else {
				lAttackTitle.setText(vFigName+" verteidigt sich gegen "+vOppName+".");
				lAttackLabel_0.setText("Verdeitigungswert:");
				
				vFigMod = (int)rFM.getFightModOfNeighbourOfFighter(FighterID, OpponentID, 2);
				
				if (CloseCombat == true) {
					lAttackLabel_2.setText("Parieren");
					btAttackButton_2.setText("Pariert");
					
					vFigValue = rFM.getActiveWeaponDefenceValueOfFighter(FighterID);
				}
				else {
					lAttackLabel_2.setText("Ausweichen");
					btAttackButton_2.setText("Ausgewichen");
					
					vFigValue = rFM.getActiveWeaponDefenceValueOfFighter(FighterID);
				}
				
				btAttackButton_3.setText("Getroffen");
			}
			
			tfAttackField_0.setText(""+vFigValue);
			tfAttackField_1.setText(""+vFigMod);
		} catch(Exception ex) {rMF.handleException(ex);}
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	4.6.2020
	 * 
	 */
	private void cancle() {
		rMF.closeFightFrame(0);
		setVisible(false);
		dispose();
	}
	
	/**	Dh	11.6.2020
	 * 
	 */
	private void automaticFightAction() {
		int vDiff;
		
		try {
			if (Attack == true) {
				vDiff = rFM.makeAttackProbe(FighterID, Integer.valueOf(tfAttackField_1.getText()));
				
				if (vDiff >= 0)rMF.openDefensivFrame(FighterID, OpponentID);
				else rMF.closeFightFrame(1);
			} else {
				vDiff = rFM.makeDefenceProbe(FighterID, Integer.valueOf(tfAttackField_1.getText()));
				
				if (vDiff >= 0)rMF.closeFightFrame(2);
				else {
					rMF.closeFightFrame(2);
					
					// Muss noch um den Schaden ergänz werden!
				}
			}
		} catch(Exception ex) {MainFrame.handleException(ex);}
		
		setVisible(false);
		dispose();
	}
	/**	Dh	4.6.2020
	 * 
	 */
	private void successfulFightAction() {
		if (Attack == true) rMF.openDefensivFrame(FighterID, OpponentID);
		else rMF.closeFightFrame(2);
		
		setVisible(false);
		dispose();
	}
	/**	Dh	4.6.2020
	 * 
	 */
	private void unsuccessfullFightAction() {
		if (Attack == true) rMF.closeFightFrame(1);
		else {
			rMF.closeFightFrame(2);
			
			// Muss noch um den Schaden ergänzt werden!!!
		}
		
		setVisible(false);
		dispose();
	}
}
