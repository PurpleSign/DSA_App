/**	DSA_App v0.0	Dh	9.7.2020
 * 
 * 	pGUI
 * 	  CharakterPanel
 * 
 * 
 * 	Type:
 *    0 Aktive
 *    1 Verbuendet
 *    2 Gegnerisch
 *  
 *  Exceptions:
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

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import pLogik.FightManager;

public class CharakterPanel {
	private int id, fighterID, type;
	private int height, width; 
	private FightManager rFM;
	private MainFrame rMF;
	
	private JPanel pFMCharPanel;
	private JLabel lFMCharName, lFMCharLable_0, lFMCharLable_1, lFMCharLable_2, lFMCharLable_3;
	//private JTextField tfFMCharField_0, tfFMCharField_1, tfFMCharField_2, tfFMCharField_3; 
	private JProgressBar pbFMCharBar_0, pbFMCharBar_1, pbFMCharBar_2, pbFMCharBar_3;
	private JButton btFMCharButton;
	
	public CharakterPanel(String pName, int pID, int pFighterID, int pType, FightManager pFM, MainFrame pMF) {
		id = pID;
		fighterID = pFighterID;
		type = pType;
		rFM = pFM;
		rMF = pMF;
		
		width = 125;
		height = 140;
		
		pFMCharPanel = new JPanel();
		pFMCharPanel.setBackground(Color.WHITE);
		pFMCharPanel.setBounds(480,170, width, height);
		//pFMPanel_0.add(pFMCharPanel);
		
		lFMCharName = new JLabel(pName);
		lFMCharName.setAlignmentX(Component.CENTER_ALIGNMENT);
		lFMCharName.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		
		lFMCharLable_0 = new JLabel("LeP:");
		lFMCharLable_0.setPreferredSize(new Dimension(35, 15));
		lFMCharLable_0.setMaximumSize(new Dimension(35, 15));
		lFMCharLable_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMCharLable_1 = new JLabel("AuP:");
		lFMCharLable_1.setPreferredSize(new Dimension(35, 15));
		lFMCharLable_1.setMaximumSize(new Dimension(35, 15));
		lFMCharLable_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMCharLable_2 = new JLabel("AsP:");
		lFMCharLable_2.setPreferredSize(new Dimension(35, 15));
		lFMCharLable_2.setMaximumSize(new Dimension(35, 15));
		lFMCharLable_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMCharLable_3 = new JLabel("KaP:");
		lFMCharLable_3.setPreferredSize(new Dimension(35, 15));
		lFMCharLable_3.setMaximumSize(new Dimension(35, 15));
		lFMCharLable_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		lFMCharLable_3.setVisible(false);
		
		pbFMCharBar_0 = new JProgressBar();
		pbFMCharBar_0.setStringPainted(true);
		pbFMCharBar_0.setValue(50);
		pbFMCharBar_0.setForeground(new Color(255, 0, 0));
		pbFMCharBar_0.setPreferredSize(new Dimension(50, 15));
		
		pbFMCharBar_1 = new JProgressBar();
		pbFMCharBar_1.setStringPainted(true);
		pbFMCharBar_1.setValue(50);
		pbFMCharBar_1.setPreferredSize(new Dimension(50, 15));
		pbFMCharBar_1.setForeground(new Color(255, 215, 0));
		
		pbFMCharBar_2 = new JProgressBar();
		pbFMCharBar_2.setStringPainted(true);
		pbFMCharBar_2.setValue(50);
		pbFMCharBar_2.setPreferredSize(new Dimension(50, 15));
		pbFMCharBar_2.setForeground(new Color(0, 0, 205));
		
		pbFMCharBar_3 = new JProgressBar();
		pbFMCharBar_3.setStringPainted(true);
		pbFMCharBar_3.setValue(50);
		pbFMCharBar_3.setPreferredSize(new Dimension(50, 15));
		pbFMCharBar_3.setForeground(new Color(0, 0, 205));
		pbFMCharBar_3.setVisible(false);
		
		GroupLayout gl_pFMCharPanel = new GroupLayout(pFMCharPanel);
		gl_pFMCharPanel.setHorizontalGroup(
			gl_pFMCharPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFMCharPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pFMCharPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_pFMCharPanel.createSequentialGroup()
							.addGroup(gl_pFMCharPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_pFMCharPanel.createSequentialGroup()
									//.addGap(15)
									.addComponent(lFMCharName)
									.addGap(15, 20, 30))
								.addGroup(gl_pFMCharPanel.createSequentialGroup()
									.addComponent(lFMCharLable_0, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(pbFMCharBar_0, GroupLayout.PREFERRED_SIZE, 60, 60))
								.addGroup(gl_pFMCharPanel.createSequentialGroup()
									.addComponent(lFMCharLable_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(pbFMCharBar_1, GroupLayout.DEFAULT_SIZE, 60, 60))
								.addGroup(gl_pFMCharPanel.createSequentialGroup()
									.addComponent(lFMCharLable_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(pbFMCharBar_2, GroupLayout.DEFAULT_SIZE, 60, 60))
								.addGroup(gl_pFMCharPanel.createSequentialGroup()
									.addComponent(lFMCharLable_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(pbFMCharBar_3, GroupLayout.DEFAULT_SIZE, 60, 60)))
							.addContainerGap(47, Short.MAX_VALUE))))
		);
		gl_pFMCharPanel.setVerticalGroup(
			gl_pFMCharPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFMCharPanel.createSequentialGroup()
					.addComponent(lFMCharName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMCharPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(pbFMCharBar_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lFMCharLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMCharPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(pbFMCharBar_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lFMCharLable_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMCharPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(pbFMCharBar_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lFMCharLable_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMCharPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(pbFMCharBar_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lFMCharLable_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pFMCharPanel.setLayout(gl_pFMCharPanel);
		
		btFMCharButton = new JButton("Angreifen");
		btFMCharButton.setBounds(12, height-30, 100, 25);
		btFMCharButton.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		btFMCharButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionButton();
			}
		});
		pFMCharPanel.add(btFMCharButton);
		
		updateCharStati();
	}
	
	public void removePanel() {
		pFMCharPanel.removeAll();
		pFMCharPanel.update(pFMCharPanel.getGraphics());
		
		lFMCharName = null;
		lFMCharLable_0 = null;
		lFMCharLable_1 = null;
		lFMCharLable_2 = null;
		lFMCharLable_3 = null;
		
		pbFMCharBar_0 = null;
		pbFMCharBar_1 = null;
		pbFMCharBar_2 = null;
		pbFMCharBar_3 = null;
		
		//pFMCharPanel = null;
		rFM = null;
		rMF = null;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	26.5.2020
	 * 
	 * 	Gibt die zugewiesene ID des Panels zurueck.
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**	Dh	´3.6.2020
	 * 
	 * @return
	 */
	public int getFighterID() {
		return fighterID;
	}
	/**	Dh	26.5.2020
	 * 
	 * 	Gibt den Type des Panels wieder.
	 * 
	 *  Type:
	 *  	0 Aktive
	 *  	1 Verbuendet
	 *  	2 Gegnerisch
	 * 
	 * @return
	 */
	public int getType() {
		return type;
	}
	/**	Dh	26.5.2020
	 * 
	 * 	Gibt das JPanel-Element wieder.
	 * 
	 * @return
	 */
	public JPanel getPanel() {
		return pFMCharPanel;
	}
	/**	Dh	26.5.2020
	 * 
	 * @return
	 */
	public Point getLocation() {
		return pFMCharPanel.getLocation();
	}
	/**	Dh	26.5.2020
	 * 
	 * @return
	 */
	public int getWidth() {
		return width;
	}
	/**	Dh	26.5.2020
	 * 	
	 * @return
	 */
	public int getHeight() {
		return height;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	26.5.2020
	 * 
	 * 	Setzt die Location des Frames.
	 * 
	 * @param pX
	 * @param pY
	 */
	public void setLocation(int pX, int pY) {
		pFMCharPanel.setLocation(pX, pY);
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	11.6.2020
	 * 
	 * @param pInd
	 */
	protected void updateAttackValue(int pInd) {
		int vAt;
		
		try{
			if (fighterID != id) vAt = (int)(rFM.getActiveWeaponAttackValueOfFighter(fighterID, pInd) + rFM.getFightModOfNeighbourOfFighter(fighterID, id, 1));
			else vAt = -1;
			
			if (type != 1) {
				btFMCharButton.setVisible(true);
				if (type == 0) btFMCharButton.setText("Skip");
				else btFMCharButton.setText("Angreifen ("+vAt+")");
			}
			else btFMCharButton.setVisible(false);
		}catch (Exception ex) {MainFrame.handleException(ex);}
	}
	/**	Dh	11.6.2020
	 * 
	 */
	protected void updateAttackValue() {
		int vAt;
		
		try{
			if (fighterID != id) vAt = (int)(rFM.getActiveWeaponAttackValueOfFighter(fighterID) + rFM.getFightModOfNeighbourOfFighter(fighterID, id, 1));
			else vAt = -1;
			
			if (type != 1) {
				btFMCharButton.setVisible(true);
				if (type == 0) btFMCharButton.setText("Skip");
				else btFMCharButton.setText("Angreifen ("+vAt+")");
			}
			else btFMCharButton.setVisible(false);
		}catch (Exception ex) {MainFrame.handleException(ex);}
	}
	
	/**	Dh	11.6.2020
	 * 
	 * @param pInd
	 */
	protected void updateCharStati(int pInd) {
		double[] vStat, vMaxStat;
		
		try {
			vStat = rFM.getCharacterOfFighter(id).getStats(0);
			vMaxStat = rFM.getCharacterOfFighter(id).getMaxStats();
			
			pbFMCharBar_0.setMaximum((int)vMaxStat[0]);
			pbFMCharBar_0.setValue((int)vStat[0]);
			pbFMCharBar_0.setString(""+((int)vStat[0])+"/"+vMaxStat[0]);
			
			pbFMCharBar_1.setMaximum((int)vMaxStat[1]);
			pbFMCharBar_1.setValue((int)vStat[1]);
			pbFMCharBar_1.setString(""+((int)vStat[1])+"/"+vMaxStat[1]);
			
			lFMCharLable_3.setVisible(false);
			pbFMCharBar_3.setVisible(false);
			
			if (vMaxStat[2] != -1) {
				pbFMCharBar_2.setMaximum((int)vMaxStat[2]);
				pbFMCharBar_2.setValue((int)vStat[2]);
				pbFMCharBar_2.setForeground(new Color(0, 0, 205));
				pbFMCharBar_2.setString(""+((int)vStat[2])+"/"+vMaxStat[2]);
				
				if (vMaxStat[3] != -1) {
					pbFMCharBar_3.setMaximum((int)vMaxStat[3]);
					pbFMCharBar_3.setValue((int)vStat[3]);
					pbFMCharBar_3.setString(""+((int)vStat[3])+"/"+vMaxStat[3]);
					
					lFMCharLable_3.setVisible(true);
					pbFMCharBar_3.setVisible(true);
				}
			} else if (vMaxStat[3] != -1) {
				lFMCharLable_2.setText("KaP:");
				
				pbFMCharBar_2.setMaximum((int)vMaxStat[3]);
				pbFMCharBar_2.setValue((int)vStat[3]);
				pbFMCharBar_2.setForeground(new Color(0, 0, 205));
				pbFMCharBar_2.setString(""+((int)vStat[3])+"/"+vMaxStat[3]);
			}else {
				lFMCharLable_2.setVisible(false);
				pbFMCharBar_2.setVisible(false);
			}
			
			updateAttackValue(pInd);
		} catch (Exception ex) {rMF.handleException(ex);}
	}
	/**	Dh	26.5.2020
	 * 
	 * 	Updatet die Charakter Stati.
	 */
	protected void updateCharStati() {
		double[] vStat, vMaxStat;
		
		try {
			vStat = rFM.getCharacterOfFighter(id).getStats(0);
			vMaxStat = rFM.getCharacterOfFighter(id).getMaxStats();
			
			pbFMCharBar_0.setMaximum((int)vMaxStat[0]);
			pbFMCharBar_0.setValue((int)vStat[0]);
			pbFMCharBar_0.setString(""+((int)vStat[0])+"/"+vMaxStat[0]);
			
			pbFMCharBar_1.setMaximum((int)vMaxStat[1]);
			pbFMCharBar_1.setValue((int)vStat[1]);
			pbFMCharBar_1.setString(""+((int)vStat[1])+"/"+vMaxStat[1]);
			
			lFMCharLable_3.setVisible(false);
			pbFMCharBar_3.setVisible(false);
			
			if (vMaxStat[2] != -1) {
				pbFMCharBar_2.setMaximum((int)vMaxStat[2]);
				pbFMCharBar_2.setValue((int)vStat[2]);
				pbFMCharBar_2.setForeground(new Color(0, 0, 205));
				pbFMCharBar_2.setString(""+((int)vStat[2])+"/"+vMaxStat[2]);
				
				if (vMaxStat[3] != -1) {
					pbFMCharBar_3.setMaximum((int)vMaxStat[3]);
					pbFMCharBar_3.setValue((int)vStat[3]);
					pbFMCharBar_3.setString(""+((int)vStat[3])+"/"+vMaxStat[3]);
					
					lFMCharLable_3.setVisible(true);
					pbFMCharBar_3.setVisible(true);
				}
			} else if (vMaxStat[3] != -1) {
				lFMCharLable_2.setText("KaP:");
				
				pbFMCharBar_2.setMaximum((int)vMaxStat[3]);
				pbFMCharBar_2.setValue((int)vStat[3]);
				pbFMCharBar_2.setForeground(new Color(0, 0, 205));
				pbFMCharBar_2.setString(""+((int)vStat[3])+"/"+vMaxStat[3]);
			}else {
				lFMCharLable_2.setVisible(false);
				pbFMCharBar_2.setVisible(false);
			}
			
			updateAttackValue();
		} catch (Exception ex) {rMF.handleException(ex);}
	}
	/**	Dh	3.6.2020
	 * 
	 */
	protected void updatePanelElements() {
		pFMCharPanel.update(pFMCharPanel.getGraphics());
	}
	/**	Dh	4.6.2020
	 * 
	 * @param pEnable
	 */
	protected void setButtonEnable(boolean pEnable) {
		btFMCharButton.setEnabled(pEnable);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	4.6.2020
	 * 
	 */
	private void actionButton() {
		if (type == 2)	rMF.openAttackFrame(fighterID, id);
		if (type == 0) rMF.nextTurn();
	}
}
