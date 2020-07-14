/**	DSA_App v0.0	Dh	12.7.2020
 * 
 * 	pGUI
 * 	  CharModFrame
 * 		CharListModFrame
 * 		  ProFrame
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
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pDataStructures.List;
import pDatenbank.Loader;
import pLogik.CharacterManager;
import pLogik.Charakter;
import pLogik.FightElement;
import pLogik.IniElement;
import pLogik.NeighbourElement;
import pLogik.Pro;
import pLogik.Referred;
import pLogik.Stringed;
import pLogik.StringedPro;
import pLogik.Valued;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ProFrame extends CharListModFrame {
	private JLabel lProPanelLabel_0, lProPanelLabel_1, lProPanelLabel_2;
	
	private JTextField tfProPanelField_0, tfProPanelField_1;
	
	private JSpinner spProPanelSpinner;

	/**
	 * Create the frame.
	 */
	public ProFrame(int pID, CharacterManager pCM, MainFrame pMF) {
		super(pID, pCM, pMF);
	}
	
	//----------------------------------------------------------------------------------------------------
	
	
	/**	Dh	11.7.2020
	 * 	
	 */
	protected void initSubPanle() {
		lSubPanle.setBackground(SystemColor.controlShadow);
		lSubPanle.setPreferredSize(new Dimension(180, 165));
		
		lProPanelLabel_0 = new JLabel("Vorteil");
		lProPanelLabel_0.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		
		lProPanelLabel_1 = new JLabel("Auswahl");
		lProPanelLabel_1.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		lProPanelLabel_2 = new JLabel("Wert");
		lProPanelLabel_2.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		tfProPanelField_0 = new JTextField();
		tfProPanelField_0.setEditable(false);
		tfProPanelField_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfProPanelField_0.setColumns(10);
		
		tfProPanelField_1 = new JTextField();
		tfProPanelField_1.setEditable(false);
		tfProPanelField_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfProPanelField_1.setColumns(10);
		
		spProPanelSpinner = new JSpinner();
		spProPanelSpinner.setEnabled(false);
		spProPanelSpinner.setPreferredSize(new Dimension(30, 20));
		spProPanelSpinner.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		GroupLayout gl_lSubPanle = new GroupLayout(lSubPanle);
		gl_lSubPanle.setHorizontalGroup(
			gl_lSubPanle.createParallelGroup(Alignment.LEADING)
				.addComponent(tfProPanelField_0, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
				.addComponent(lProPanelLabel_0, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
				.addGroup(gl_lSubPanle.createSequentialGroup()
					.addGroup(gl_lSubPanle.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lProPanelLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tfProPanelField_1, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_lSubPanle.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_lSubPanle.createSequentialGroup()
							.addComponent(lProPanelLabel_2, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
							.addContainerGap())
						.addComponent(spProPanelSpinner, GroupLayout.PREFERRED_SIZE, 39, Short.MAX_VALUE)))
		);
		gl_lSubPanle.setVerticalGroup(
			gl_lSubPanle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lSubPanle.createSequentialGroup()
					.addGap(40)
					.addComponent(lProPanelLabel_0)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfProPanelField_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_lSubPanle.createParallelGroup(Alignment.BASELINE)
						.addComponent(lProPanelLabel_1)
						.addComponent(lProPanelLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_lSubPanle.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfProPanelField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spProPanelSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(70, Short.MAX_VALUE))
		);
		lSubPanle.setLayout(gl_lSubPanle);
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	1.7.2020
	 * 
	 * @throws Exception
	 */
	private void addFreePros() throws Exception {
		Object vCur;
		boolean vIsMagic;
		String vName;
		List vTemp = Loader.getProList();
		
		if (vTemp != null) {
			if ((rCM.haveProByCharacter(id, "Vollzauberer")) || (rCM.haveProByCharacter(id, "Halbzauberer")) || (rCM.haveProByCharacter(id, "Viertelzauberer, unentdeckt"))
					|| (rCM.haveProByCharacter(id, "Viertelzauberer, bekannt"))) vIsMagic = true;
			else vIsMagic = false;
			
			if (!vTemp.isEmpty()) {
				vTemp.toFirst();
				
				while(!vTemp.isEnd()) {
					vCur = vTemp.getCurrent();
					
					if (vCur instanceof Pro) {
						if (rCM.haveProByCharacter(id, ((Pro)vCur).getId()) == true) vTemp.remove();
						else if (((Pro)vCur).isArkane() == true) {
							vName = ((Pro)vCur).getName();
							if (vIsMagic == true) {							
								if (vName.equals("Vollzauberer") || vName.equals("Halbzauberer") || vName.equals("Viertelzauberer, unentdeckt") ||
										vName.equals("Viertelzauberer, bekannt")) vTemp.remove();
								else vTemp.next();
							} else {
								if (vName.equals("Vollzauberer") || vName.equals("Halbzauberer") || vName.equals("Viertelzauberer, unentdeckt") ||
										vName.equals("Viertelzauberer, bekannt")) vTemp.next();
								else vTemp.remove();
							}
						} else vTemp.next();
					}else throw new Exception("06; PrFra,aFP");
				}
				
				addListToModel(rListModel_1, vTemp);
			}
		}
	}
	
	/**	Dh	11.7.2020
	 * 
	 */
	protected void setSpecificValues(int pID) throws Exception{
		lFrameTitle_0.setText("Vor- und Nachteils Auswahl");
		lPanelTitle_0.setText("Erhaltene");
		lPanelTitle_1.setText("Auswahl");
		
		addListToModel(rListModel_0, rCM.getProListOfCharacter(pID));
		addFreePros();
		
		if (rListModel_0.getSize() > 0) btPanelButton_2.setEnabled(true);
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	1.7.2020
	 * 
	 * @param pChoosed
	 * @param pInd
	 */
	protected void updateSelected(boolean pChoosed, int pInd) {
		Pro vCur;
		int vValue = -1;
		int vLimit = 0;
		String vName = "";
		String vText = null;
		
		if (pInd != -1) {
			try {
				if (pChoosed == true) {
					vCur = rCM.getProOfCharacter(id, (int)rListModel_0.getObjectAt(pInd));
					
					//if (vCur instanceof Referred)
					if (vCur instanceof Stringed) vText = ((Stringed)vCur).getStringedValue();
					if (vCur instanceof Valued) {
						vValue = ((Valued)vCur).getValue();
						vLimit = ((Valued)vCur).getValueLimit();
					}
					
					btPanelButton_0.setEnabled(true);
					btPanelButton_0.setText("Ändern");
					btPanelButton_1.setEnabled(true);
					liPanelList_1.clearSelection();
				}else {
					vCur = Loader.getPro((int)rListModel_1.getObjectAt(pInd));
					
					//if (vCur instanceof Referred)
					if (vCur instanceof Stringed) vText = "";
					if (vCur instanceof Valued) {
						vValue = 1;
						vLimit = ((Valued)vCur).getValueLimit();
					}
					
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
		
		tfProPanelField_0.setText(""+vName);
		
		if (vText != null) {
			tfProPanelField_1.setText(vText);
			tfProPanelField_1.setEditable(true);
		} else {
			tfProPanelField_1.setText("");
			tfProPanelField_1.setEditable(false);
		}
		if (vValue != -1) {
			if (vLimit == -1) vLimit = 60;
			spProPanelSpinner.setModel(new SpinnerNumberModel(1, 1, vLimit, 1));
			spProPanelSpinner.setValue(vValue);
			spProPanelSpinner.setEnabled(true);
		} else {
			spProPanelSpinner.setValue(0);
			spProPanelSpinner.setEnabled(false);
		}
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	25.6.2020
	 * 
	 */
	protected void addElement() {
		String vText;
		Pro vPro;
		int vSelInd = liPanelList_1.getSelectedIndex();
		
		if (vSelInd !=-1 ) {
			try {
				vPro = Loader.getPro((int)rListModel_1.getObjectAt(vSelInd));
				
				vText = vPro.getName();
				//if (vPro instanceof Referred)
				if (vPro instanceof Stringed) {
					vText += " "+tfProPanelField_1.getText();
					((Stringed)vPro).setStringedValue(tfProPanelField_1.getText());
				}
				if (vPro instanceof Valued) {
					vText += " "+(int)spProPanelSpinner.getValue();
					((Valued)vPro).setValue((int)spProPanelSpinner.getValue());
				}
				
				rCM.addProToCharacter(id, vPro);
				rListModel_0.addElement(vText, vPro.getId());
				if (vText.equals("Vollzauberer") || vText.equals("Halbzauberer") || vText.equals("Viertelzauberer, unentdeckt") ||
						vText.equals("Viertelzauberer, bekannt")) {
					rListModel_1.clear();
					addFreePros();
				}else rListModel_1.removeElementAt(vSelInd);
				
				if (btPanelButton_2.isEnabled() == false) btPanelButton_2.setEnabled(true);
			} catch (Exception ex) {rMF.handleException(ex);}
		} else rMF.handleException(new Exception("07; PrFra,aE"));
	}
	/**	Dh	1.7.2020
	 * 
	 */
	protected void applyChanges() {
		int vID;
		String vText;
		Pro vPro;
		
		int vSelInd = liPanelList_0.getSelectedIndex();
		
		if (vSelInd !=-1 ) {
			vID = (int)rListModel_0.getObjectAt(vSelInd);
			try {
				vPro = rCM.getProOfCharacter(id, vID);
				vText = vPro.getName();
				
				//if (vPro instanceof Referred)
				if (vPro instanceof Stringed) { 
					if (!tfProPanelField_1.getText().equals("")) {
						((Stringed)vPro).setStringedValue(tfProPanelField_1.getText());
						vText += " " + ((Stringed)vPro).getStringedValue();
					}
				}
				if (vPro instanceof Valued) {
					((Valued)vPro).setValue((int)spProPanelSpinner.getValue());
					vText += " " + ((Valued)vPro).getValue();
				}
				
				rListModel_0.setElementAt(new JListModelElement(vText, vPro.getId()), vSelInd);
				
			} catch (Exception ex) {rMF.handleException(ex);}
		} else rMF.handleException(new Exception("07; PrFra,aC"));
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
				rCM.removeProOfCharacter(id, vID);
				rListModel_0.removeElementAt(vSelInd);
				
				rListModel_1.clear();
				addFreePros();
				
				if ((liPanelList_0.getComponentCount() > 0) && (btPanelButton_2.isEnabled() == false)) btPanelButton_2.setEnabled(true);
				if (rListModel_0.getSize() == 0) btPanelButton_2.setEnabled(false);
			}catch(Exception ex) {rMF.handleException(ex);}
		} else rMF.handleException(new Exception("07; PrFra,r"));
	}
	/**	Dh	25.6.2020
	 * 
	 */
	protected void removeAllFromList() {
		try {
			if (btPanelButton_2.isEnabled() == true) btPanelButton_2.setEnabled(false);
			rCM.setProListOfCharacter(id, new List());
			rListModel_0.clear();
			rListModel_1.clear();
			addFreePros(); 
		} catch(Exception ex) {rMF.handleException(ex);} 
	}
}
