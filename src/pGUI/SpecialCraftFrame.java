/**	DSA_App v0.0	Dh	12.7.2020
 * 
 * 	pGUI
 * 	  CharModFrame
 * 		CharListModFrame
 * 	      SpecialCraftFrame
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pDataStructures.List;
import pDatenbank.Loader;
import pLogik.CharacterManager;
import pLogik.Pro;
import pLogik.SpecialCraft;
import pLogik.Stringed;
import pLogik.Valued;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class SpecialCraftFrame extends CharListModFrame {
	private JLabel lSpecialPanelLabel_0, lSpecialPanelLabel_1;
	
	private JTextField tfSpecialPanelField_0, tfSpecialPanelField_1;

	/**
	 * Create the frame.
	 */
	public SpecialCraftFrame(int pID, CharacterManager pCM, MainFrame pMF) {
		super(pID, pCM, pMF);
	}

	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	2.7.2020
	 * 
	 */
	/*private void initPanel() {		
		lSpecialPanelLabel_0 = new JLabel("Sonderfertigkeit");
		lSpecialPanelLabel_0.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		
		lSpecialPanelLabel_1 = new JLabel("Auswahl");
		lSpecialPanelLabel_1.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		lSpecialPanelLabel_2 = new JLabel("Wert");
		lSpecialPanelLabel_2.setVisible(false);
		lSpecialPanelLabel_2.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		tfSpecialPanelField_0 = new JTextField();
		tfSpecialPanelField_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfSpecialPanelField_0.setEditable(false);
		tfSpecialPanelField_0.setColumns(10);
		
		tfSpecialPanelField_1 = new JTextField();
		tfSpecialPanelField_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfSpecialPanelField_1.setEditable(false);
		tfSpecialPanelField_1.setColumns(10);
		
		
	}*/
	
	/**	Dh	11.7.2020
	 * 
	 */
	protected void initSubPanle() {
		lSubPanle.setBackground(SystemColor.controlShadow);
		lSubPanle.setPreferredSize(new Dimension(180, 165));
		
		lSpecialPanelLabel_0 = new JLabel("Sonderfertigkeit");
		lSpecialPanelLabel_0.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		
		lSpecialPanelLabel_1 = new JLabel("Auswahl");
		lSpecialPanelLabel_1.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		tfSpecialPanelField_0 = new JTextField();
		tfSpecialPanelField_0.setEditable(false);
		tfSpecialPanelField_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfSpecialPanelField_0.setColumns(10);
		
		tfSpecialPanelField_1 = new JTextField();
		tfSpecialPanelField_1.setEditable(false);
		tfSpecialPanelField_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfSpecialPanelField_1.setColumns(10);
		
		GroupLayout gl_lSubPanle = new GroupLayout(lSubPanle);
		gl_lSubPanle.setHorizontalGroup(
			gl_lSubPanle.createParallelGroup(Alignment.LEADING)
				.addComponent(tfSpecialPanelField_0, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
				.addComponent(lSpecialPanelLabel_0, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
				.addComponent(tfSpecialPanelField_1, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
				.addComponent(lSpecialPanelLabel_1, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
		);
		gl_lSubPanle.setVerticalGroup(
			gl_lSubPanle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lSubPanle.createSequentialGroup()
					.addGap(40)
					.addComponent(lSpecialPanelLabel_0)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfSpecialPanelField_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lSpecialPanelLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfSpecialPanelField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(59, Short.MAX_VALUE))
		);
		lSubPanle.setLayout(gl_lSubPanle);
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	2.7.2020
	 * 
	 * @throws Exception
	 */
	private void addFreeSpecials() throws Exception {
		Object vCur;
		String vName;
		List vTemp = Loader.getSpecialCraftList();
		
		if (vTemp != null) {			
			if (!vTemp.isEmpty()) {
				vTemp.toFirst();
				
				while(!vTemp.isEnd()) {
					vCur = vTemp.getCurrent();
					
					if (vCur instanceof SpecialCraft) {
						if (rCM.haveSpecialCraftByCharacter(id, ((SpecialCraft)vCur).getId()) == true) vTemp.remove();
						else if (!rCM.satisfyPremisesOfCharacter(id, ((SpecialCraft)vCur).getId())) vTemp.remove();
						else vTemp.next();
					}else throw new Exception("06; SpCrFra,aFP");
				}
				
				addListToModel(rListModel_1, vTemp);
			}
		}
	}
	
	/**	Dh	11.7.2020
	 * 
	 */
	protected void setSpecificValues(int pID) throws Exception{
		lFrameTitle_0.setText("Sonderfertigkeiten Auswahl");
		lPanelTitle_0.setText("Erhaltene");
		lPanelTitle_1.setText("Auswahl");
		
		addListToModel(rListModel_0, rCM.getProListOfCharacter(pID));
		addFreeSpecials();
		
		if (rListModel_0.getSize() > 0) btPanelButton_2.setEnabled(true);
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	2.7.2020
	 * 
	 * @param pChoosed
	 * @param pInd
	 */
	protected void updateSelected(boolean pChoosed, int pInd) {
		SpecialCraft vCur;
		String vName = "";
		String vText = null;
		
		if (pInd != -1) {
			try {
				if (pChoosed == true) {
					vCur = rCM.getSpecialCraftOfCharacter(id, (int)rListModel_0.getObjectAt(pInd));
					
					//if (vCur instanceof Referred)
					if (vCur instanceof Stringed) vText = ((Stringed)vCur).getStringedValue();
					
					
					btPanelButton_0.setEnabled(true);
					btPanelButton_0.setText("Ändern");
					btPanelButton_1.setEnabled(true);
					liPanelList_1.clearSelection();
				}else {
					vCur = Loader.getSpecialCraft((int)rListModel_1.getObjectAt(pInd));
					
					//if (vCur instanceof Referred)
					if (vCur instanceof Stringed) vText = "";
					
					btPanelButton_0.setEnabled(true);
					btPanelButton_0.setText("Hinzufügen");
					liPanelList_0.clearSelection();
				}
				
				vName = vCur.getName();
			}catch(Exception ex) {
				if (pChoosed == true) liPanelList_0.clearSelection();
				else liPanelList_1.clearSelection();
				
				rMF.handleException(ex);
			}
		}else {
			if (pChoosed == true) btPanelButton_1.setEnabled(false);
			
			if ((liPanelList_0.getSelectedIndex() == -1) && (liPanelList_1.getSelectedIndex() == -1)) btPanelButton_0.setEnabled(false);
		}
		
		tfSpecialPanelField_0.setText(""+vName);
		
		if (vText != null) {
			tfSpecialPanelField_1.setText(vText);
			tfSpecialPanelField_1.setEditable(true);
		} else {
			tfSpecialPanelField_1.setText("");
			tfSpecialPanelField_1.setEditable(false);
		}
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	2.7.2020
	 * 
	 */
	protected void addElement() {
		String vText;
		SpecialCraft vSpec;
		int vSelInd = liPanelList_1.getSelectedIndex();
		
		if (vSelInd !=-1 ) {
			try {
				vSpec = Loader.getSpecialCraft((int)rListModel_1.getObjectAt(vSelInd));
				
				vText = vSpec.getName();
				//if (vPro instanceof Referred)
				if (vSpec instanceof Stringed) {
					vText += " "+tfSpecialPanelField_1.getText();
					((Stringed)vSpec).setStringedValue(tfSpecialPanelField_1.getText());
				}
				
				rCM.addSpecialCraftToCharacter(id, vSpec);
				rListModel_0.addElement(vText, vSpec.getId());
				
				rListModel_1.clear();
				addFreeSpecials();
				if (btPanelButton_2.isEnabled() == false) btPanelButton_2.setEnabled(true);
			} catch (Exception ex) {rMF.handleException(ex);}
		} else rMF.handleException(new Exception("07; SpCrFra,aE"));
	}
	/**	Dh	2.7.2020
	 * 
	 */
	protected void applyChanges() {
		int vID;
		String vText;
		SpecialCraft vSpec;
		
		int vSelInd = liPanelList_0.getSelectedIndex();
		
		if (vSelInd !=-1 ) {
			vID = (int)rListModel_0.getObjectAt(vSelInd);
			try {
				vSpec = rCM.getSpecialCraftOfCharacter(id, vID);
				vText = vSpec.getName();
				
				//if (vPro instanceof Referred)
				if (vSpec instanceof Stringed) { 
					if (!tfSpecialPanelField_1.getText().equals("")) {
						((Stringed)vSpec).setStringedValue(tfSpecialPanelField_1.getText());
						vText += " " + ((Stringed)vSpec).getStringedValue();
					}
				}
				
				rListModel_0.setElementAt(new JListModelElement(vText, vSpec.getId()), vSelInd);
				
			} catch (Exception ex) {rMF.handleException(ex);}
		} else rMF.handleException(new Exception("07; SpCaFra,aC"));
	}
	/**	Dh	2.7.2020
	 * 
	 */
	protected void remove() {
		int vID;
		int vSelInd = liPanelList_0.getSelectedIndex();
		
		if (vSelInd != -1) {
			vID = (int)rListModel_0.getObjectAt(vSelInd);
			try {
				rCM.removeSpecialCraftOfCharacter(id, vID);
				rListModel_0.removeElementAt(vSelInd);
				
				rListModel_1.clear();
				addFreeSpecials();
				
				if ((liPanelList_0.getComponentCount() > 0) && (btPanelButton_2.isEnabled() == false)) btPanelButton_2.setEnabled(true);
				if (rListModel_0.getSize() == 0) btPanelButton_2.setEnabled(false);
			}catch(Exception ex) {rMF.handleException(ex);}
		} else rMF.handleException(new Exception("07; SpCaFra,r"));
	}
	/**	Dh	2.7.2020
	 * 
	 */
	protected void removeAllFromList() {
		try {
			if (btPanelButton_2.isEnabled() == true) btPanelButton_2.setEnabled(false);
			rCM.setSpecialCraftListOfCharacter(id, new List());
			rListModel_0.clear();
			rListModel_1.clear();
			addFreeSpecials(); 
		} catch(Exception ex) {rMF.handleException(ex);} 
	}
	
}