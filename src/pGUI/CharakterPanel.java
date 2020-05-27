/**	DSA_App v0.0	Dh	26.5.2020
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
	private int ID, Type;
	private int Height, Width; 
	private FightManager rFM;
	private MainFrame rMF;
	
	private JPanel pFMCharPanel;
	private JLabel lFMCharName, lFMCharLable_0, lFMCharLable_1, lFMCharLable_2, lFMCharLable_3;
	private JTextField tfFMCharField_0, tfFMCharField_1, tfFMCharField_2, tfFMCharField_3; 
	private JProgressBar pbFMCharBar_0, pbFMCharBar_1, pbFMCharBar_2, pbFMCharBar_3;
	private JButton btFMCharButton;
	
	public CharakterPanel(String pName, int pID, int pType, FightManager pFM, MainFrame pMF) {
		ID = pID;
		Type = pType;
		rFM = pFM;
		rMF = pMF;
		
		Width = 125;
		Height = 140;
		
		pFMCharPanel = new JPanel();
		pFMCharPanel.setBackground(Color.WHITE);
		pFMCharPanel.setBounds(480,170, Width, Height);
		//pFMPanel_0.add(pFMCharPanel);
		
		lFMCharName = new JLabel(pName);
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
		pbFMCharBar_0.setValue(50);
		pbFMCharBar_0.setForeground(new Color(255, 0, 0));
		pbFMCharBar_0.setPreferredSize(new Dimension(50, 15));
		
		pbFMCharBar_1 = new JProgressBar();
		pbFMCharBar_1.setValue(50);
		pbFMCharBar_1.setPreferredSize(new Dimension(50, 15));
		pbFMCharBar_1.setForeground(new Color(255, 215, 0));
		
		pbFMCharBar_2 = new JProgressBar();
		pbFMCharBar_2.setValue(50);
		pbFMCharBar_2.setPreferredSize(new Dimension(50, 15));
		pbFMCharBar_2.setForeground(new Color(0, 0, 205));
		
		pbFMCharBar_3 = new JProgressBar();
		pbFMCharBar_3.setValue(50);
		pbFMCharBar_3.setPreferredSize(new Dimension(50, 15));
		pbFMCharBar_3.setForeground(new Color(0, 0, 205));
		pbFMCharBar_3.setVisible(false);
		
		tfFMCharField_0 = new JTextField();
		tfFMCharField_0.setEnabled(false);
		tfFMCharField_0.setPreferredSize(new Dimension(6, 15));
		tfFMCharField_0.setMinimumSize(new Dimension(6, 15));
		tfFMCharField_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMCharField_0.setColumns(3);
		
		tfFMCharField_1 = new JTextField();
		tfFMCharField_1.setPreferredSize(new Dimension(6, 15));
		tfFMCharField_1.setMinimumSize(new Dimension(6, 15));
		tfFMCharField_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMCharField_1.setEnabled(false);
		tfFMCharField_1.setColumns(3);
		
		tfFMCharField_2 = new JTextField();
		tfFMCharField_2.setPreferredSize(new Dimension(6, 15));
		tfFMCharField_2.setMinimumSize(new Dimension(6, 15));
		tfFMCharField_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMCharField_2.setEnabled(false);
		tfFMCharField_2.setColumns(3);
		
		tfFMCharField_3 = new JTextField();
		tfFMCharField_3.setEnabled(false);
		tfFMCharField_3.setPreferredSize(new Dimension(6, 15));
		tfFMCharField_3.setMinimumSize(new Dimension(6, 15));
		tfFMCharField_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMCharField_3.setColumns(3);
		tfFMCharField_3.setVisible(false);
		
		btFMCharButton = new JButton("Angreifen");
		btFMCharButton.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		btFMCharButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionButton();
			}
		});
		
		GroupLayout gl_pFMCharPanel = new GroupLayout(pFMCharPanel);
		gl_pFMCharPanel.setHorizontalGroup(
			gl_pFMCharPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pFMCharPanel.createSequentialGroup()
					.addComponent(lFMCharLable_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pbFMCharBar_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addComponent(tfFMCharField_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(56))
				.addGroup(gl_pFMCharPanel.createSequentialGroup()
					.addComponent(lFMCharLable_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pbFMCharBar_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addComponent(tfFMCharField_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(56))
				.addGroup(gl_pFMCharPanel.createSequentialGroup()
					.addComponent(lFMCharLable_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pbFMCharBar_3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addComponent(tfFMCharField_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(56))
				.addGroup(gl_pFMCharPanel.createSequentialGroup()
					.addComponent(lFMCharLable_0, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMCharPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lFMCharName)
						.addGroup(gl_pFMCharPanel.createSequentialGroup()
							.addComponent(pbFMCharBar_0, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfFMCharField_0, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGap(56))
				.addGroup(Alignment.LEADING, gl_pFMCharPanel.createSequentialGroup()
					.addGap(19)
					.addComponent(btFMCharButton)
					.addContainerGap(72, Short.MAX_VALUE))
		);
		gl_pFMCharPanel.setVerticalGroup(
			gl_pFMCharPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFMCharPanel.createSequentialGroup()
					.addComponent(lFMCharName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMCharPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(tfFMCharField_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pbFMCharBar_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lFMCharLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMCharPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lFMCharLable_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(pbFMCharBar_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMCharField_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMCharPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lFMCharLable_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(pbFMCharBar_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMCharField_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMCharPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lFMCharLable_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(pbFMCharBar_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMCharField_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btFMCharButton)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		pFMCharPanel.setLayout(gl_pFMCharPanel);
		
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
		
		tfFMCharField_0 = null;
		tfFMCharField_1 = null;
		tfFMCharField_2 = null;
		tfFMCharField_3 = null;
		
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
	public int getID() {
		return ID;
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
		return Type;
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
		return Width;
	}
	/**	Dh	26.5.2020
	 * 	
	 * @return
	 */
	public int getHeight() {
		return Height;
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

	/**	Dh	26.5.2020
	 * 
	 * 	Updatet die Charakter Stati.
	 */
	public void updateCharStati() {
		double[] vStat;
		int[]vMaxStat;
		
		try {
			vStat = rFM.getCharacterOfFighter(ID).getStati(0);
			vMaxStat = rFM.getCharacterOfFighter(ID).getMaxStati();
			
			pbFMCharBar_0.setMaximum(vMaxStat[0]);
			pbFMCharBar_0.setValue((int)vStat[0]);
			tfFMCharField_0.setText(""+((int)vStat[0])+"/"+vMaxStat[0]);
			
			pbFMCharBar_1.setMaximum(vMaxStat[1]);
			pbFMCharBar_1.setValue((int)vStat[1]);
			tfFMCharField_1.setText(""+((int)vStat[1])+"/"+vMaxStat[1]);
			
			lFMCharLable_3.setVisible(false);
			pbFMCharBar_3.setVisible(false);
			tfFMCharField_3.setVisible(false);
			
			if (vMaxStat[2] != -1) {
				pbFMCharBar_2.setMaximum(vMaxStat[2]);
				pbFMCharBar_2.setValue((int)vStat[2]);
				tfFMCharField_2.setText(""+((int)vStat[2])+"/"+vMaxStat[2]);
				
				if (vMaxStat[3] != -1) {
					pbFMCharBar_3.setMaximum(vMaxStat[3]);
					pbFMCharBar_3.setValue((int)vStat[3]);
					tfFMCharField_3.setText(""+((int)vStat[3])+"/"+vMaxStat[3]);
					
					lFMCharLable_3.setVisible(true);
					pbFMCharBar_3.setVisible(true);
					tfFMCharField_3.setVisible(true);
				}
			} else if (vMaxStat[3] != -1) {
				lFMCharLable_2.setText("KaP:");
				
				pbFMCharBar_2.setMaximum(vMaxStat[3]);
				pbFMCharBar_2.setValue((int)vStat[3]);
				tfFMCharField_2.setText(""+((int)vStat[3])+"/"+vMaxStat[3]);
			}else {
				lFMCharLable_2.setVisible(false);
				pbFMCharBar_2.setVisible(false);
				tfFMCharField_2.setVisible(false);
			}
			
			if (Type != 2) {
				btFMCharButton.setVisible(false);
			}
		} catch (Exception ex) {rMF.handleException(ex);}
	}

	
//--------------------------------------------------------------------------------------------------------
	
	
	private void actionButton() {
		
	}
}
