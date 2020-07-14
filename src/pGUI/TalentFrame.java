/**	DSA_App v0.0	Dh	12.7.2020
 * 
 * 	pGUI
 * 	  CharModFrame
 * 		CharListModFrame
 * 		  TalenttFrame
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

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.DefaultCellEditor;

import pDataStructures.List;
import pDatenbank.Loader;
import pLogik.Basictalent;
import pLogik.Calculator;
import pLogik.CharacterManager;
import pLogik.CloseWeapon;
import pLogik.Communicationtalent;
import pLogik.DefenceWeapon;
import pLogik.Fighttalent;
import pLogik.PhysicalTalent;
import pLogik.Pro;
import pLogik.RangeWeapon;
import pLogik.Stringed;
import pLogik.Talent;
import pLogik.Valued;
import pLogik.Weapon;

public class TalentFrame extends CharListModFrame {
	private String[] zPropertieLables = new String[] {"Mu", "Kl", "In", "Ch", "Ff", "Ge", "Ko", "Kk"};
	
	private JLabel lTalentPanelLabel_0, lTalentPanelLabel_1, lTalentPanelLabel_2, lTalentPanelLabel_3, lTalentPanelLabel_4;
	private JTextField tfTalentPanelField_0, tfTalentPanelField_1, tfTalentPanelField_2;
	private JSpinner spTalentPanelSpinner_0, spTalentPanelSpinner_1;
	private JCheckBox cbTalentPanelBox;
	
	private JTable tTalentPanelTable_0, tTalentPanelTable_1, tTalentPanelTable_2;
	private JTableModel rTableModel_0, rTableModel_1, rTableModel_2;

	/**
	 * Create the frame.
	 */
	public TalentFrame(int pID, CharacterManager pCM, MainFrame pMF) {
		super(pID, pCM, pMF);
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	11.7.2020
	 * 
	 */
	protected void initModels() {
		super.initModels();
		
		rTableModel_0 = new JTableModel(new String[] {"", "", ""},  new int[] {id}, new Object[][] {{-1, -1, -1}});
		rTableModel_1 = new JTableModel(new String[] {"", ""},  new int[] {id}, new Object[][] {{0, 0}});
		rTableModel_2 = new JTableModel(new String[] {"", ""},  new int[] {id}, new Object[][] {{0, 0}}, new boolean[][] {{true, true}});
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	12.7.2020
	 * 
	 */
	protected void initSubPanle() {
		lSubPanle.setBackground(SystemColor.controlShadow);
		lSubPanle.setLayout(null);
		
		lTalentPanelLabel_0 = new JLabel("Talent");
		lTalentPanelLabel_0.setBounds(0, 40, 165, 17);
		lTalentPanelLabel_0.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		lSubPanle.add(lTalentPanelLabel_0);
		
		lTalentPanelLabel_1 = new JLabel("Type");
		lTalentPanelLabel_1.setBounds(0, 90, 85, 14);
		lTalentPanelLabel_1.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		lSubPanle.add(lTalentPanelLabel_1);
		
		lTalentPanelLabel_2 = new JLabel("TaW");
		lTalentPanelLabel_2.setBounds(170, 43, 40, 14);
		lTalentPanelLabel_2.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		lSubPanle.add(lTalentPanelLabel_2);
		
		lTalentPanelLabel_3 = new JLabel("Probe");
		lTalentPanelLabel_3.setBounds(101, 90, 60, 14);
		lTalentPanelLabel_3.setVisible(false);
		lTalentPanelLabel_3.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		lSubPanle.add(lTalentPanelLabel_3);
		
		lTalentPanelLabel_4 = new JLabel("BE");
		lTalentPanelLabel_4.setBounds(170, 90, 40, 14);
		lTalentPanelLabel_4.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		lTalentPanelLabel_4.setVisible(false);
		lSubPanle.add(lTalentPanelLabel_4);
		
		tfTalentPanelField_0 = new JTextField();
		tfTalentPanelField_0.setBounds(0, 63, 165, 20);
		tfTalentPanelField_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfTalentPanelField_0.setEditable(false);
		tfTalentPanelField_0.setEnabled(false);
		tfTalentPanelField_0.setColumns(10);
		lSubPanle.add(tfTalentPanelField_0);
		
		tfTalentPanelField_1 = new JTextField();
		tfTalentPanelField_1.setBounds(0, 107, 100, 20);
		tfTalentPanelField_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfTalentPanelField_1.setEditable(false);
		tfTalentPanelField_1.setEnabled(false);
		tfTalentPanelField_1.setColumns(10);
		lSubPanle.add(tfTalentPanelField_1);
		
		tfTalentPanelField_2 = new JTextField();
		tfTalentPanelField_2.setBounds(170, 107, 40, 20);
		tfTalentPanelField_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		//tfTalentPanelField_2.setEditable(false);
		tfTalentPanelField_2.setEnabled(false);
		tfTalentPanelField_2.setVisible(false);
		tfTalentPanelField_2.setColumns(10);
		lSubPanle.add(tfTalentPanelField_2);
		
		spTalentPanelSpinner_0 = new JSpinner();
		spTalentPanelSpinner_0.setBounds(170, 63, 40, 20);
		spTalentPanelSpinner_0.setEnabled(false);
		spTalentPanelSpinner_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		lSubPanle.add(spTalentPanelSpinner_0);
		
		spTalentPanelSpinner_1 = new JSpinner();
		spTalentPanelSpinner_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		spTalentPanelSpinner_1.setEnabled(false);
		spTalentPanelSpinner_1.setVisible(false);
		spTalentPanelSpinner_1.setBounds(170, 107, 40, 20);
		//lSubPanle.add(spTalentPanelSpinner_1);
		
		cbTalentPanelBox = new JCheckBox("");
		cbTalentPanelBox.setBackground(SystemColor.controlShadow);
		cbTalentPanelBox.setBounds(113, 107, 40, 20);
		cbTalentPanelBox.setVisible(false);
		cbTalentPanelBox.setEnabled(false);
		lSubPanle.add(cbTalentPanelBox);
		
		tTalentPanelTable_0 = new JTable();
		tTalentPanelTable_0.setBounds(104, 107, 63, 20);
		tTalentPanelTable_0.setVisible(false);
		tTalentPanelTable_0.setRowHeight(20);
		tTalentPanelTable_0.setColumnSelectionAllowed(false);
		tTalentPanelTable_0.setCellSelectionEnabled(false);
		tTalentPanelTable_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tTalentPanelTable_0.setModel(rTableModel_0);
		tTalentPanelTable_0.setCellEditor(new JNumFieldEditor(0, 7));
		tTalentPanelTable_0.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				Object vCur = pTable.getValueAt(pRow, pCol);
				
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				setEnabled(false);
				
				if (vCur instanceof Integer) {
					if (((int)vCur) != -1) setText(zPropertieLables[(int)vCur]);
					else setText("");
				}
				
				return this;
			}
		});
		tTalentPanelTable_0.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				Object vCur = pTable.getValueAt(pRow, pCol);
				
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				setEnabled(false);
				
				if (vCur instanceof Integer) {
					if (((int)vCur) != -1) setText(zPropertieLables[(int)vCur]);
					else setText("");
				}
				
				return this;
			}
		});
		tTalentPanelTable_0.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				Object vCur = pTable.getValueAt(pRow, pCol);
				
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				setEnabled(false);
				
				if (vCur instanceof Integer) {
					if (((int)vCur) != -1) setText(zPropertieLables[(int)vCur]);
					else setText("");
				}
				
				return this;
			}
		});
		lSubPanle.add(tTalentPanelTable_0);
		
		tTalentPanelTable_1 = new JTable();
		tTalentPanelTable_1.setBounds(170, 107, 40, 20);
		tTalentPanelTable_1.setVisible(false);
		tTalentPanelTable_1.setRowHeight(20);
		tTalentPanelTable_1.setColumnSelectionAllowed(false);
		tTalentPanelTable_1.setCellSelectionEnabled(false);
		tTalentPanelTable_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tTalentPanelTable_1.setModel(rTableModel_1);
		tTalentPanelTable_1.getColumnModel().getColumn(0).setCellEditor(new JNumFieldEditor(0, 10));
		tTalentPanelTable_1.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				setEnabled(false);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				
				return this;
			}
		});
		tTalentPanelTable_1.getColumnModel().getColumn(1).setCellEditor(new JNumFieldEditor(-10, 10));
		tTalentPanelTable_1.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				setEnabled(false);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				
				return this;
			}
		});
		lSubPanle.add(tTalentPanelTable_1);
		
		tTalentPanelTable_2 = new JTable();
		tTalentPanelTable_2.setBounds(113, 107, 40, 20);
		tTalentPanelTable_2.setVisible(false);
		tTalentPanelTable_2.setRowHeight(20);
		tTalentPanelTable_2.setColumnSelectionAllowed(false);
		tTalentPanelTable_2.setCellSelectionEnabled(false);
		tTalentPanelTable_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tTalentPanelTable_2.setModel(rTableModel_2);
		tTalentPanelTable_2.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				
				return this;
			}
		});
		tTalentPanelTable_2.getColumnModel().getColumn(0).setCellEditor(new JNumFieldEditor(0, 20) {
			public Object getCellEditorValue() {
				Object pObj = super.getCellEditorValue();
				Object pObj2 = tTalentPanelTable_2.getValueAt(0, 1);
				
				if ((pObj instanceof Number) && (pObj2 instanceof Number)) {
					if (((int)pObj)+((int)pObj2) > ((int)spTalentPanelSpinner_0.getValue())) {
						pObj = ((int)spTalentPanelSpinner_0.getValue()) - ((int)pObj2);
					}
				}
				
				return pObj;
			}
		});
		tTalentPanelTable_2.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				
				return this;
			}
		});
		tTalentPanelTable_2.getColumnModel().getColumn(1).setCellEditor(new JNumFieldEditor(0, 20) {
			public Object getCellEditorValue() {
				Object pObj = super.getCellEditorValue();
				Object pObj2 = tTalentPanelTable_2.getValueAt(0, 0);
				
				if ((pObj instanceof Number) && (pObj2 instanceof Number)) {
					if (((int)pObj)+((int)pObj2) > ((int)spTalentPanelSpinner_0.getValue())) {
						pObj = ((int)spTalentPanelSpinner_0.getValue()) - ((int)pObj2);
					}
				}
				
				return pObj;
			}
		});
		lSubPanle.add(tTalentPanelTable_2);
		
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	12.7.2020
	 * 
	 */
	private void resetPanel() {
		lTalentPanelLabel_3.setVisible(false);
		lTalentPanelLabel_4.setVisible(false);
		
		tfTalentPanelField_0.setEditable(false);
		tfTalentPanelField_0.setEnabled(true);
		tfTalentPanelField_1.setEditable(false);
		tfTalentPanelField_1.setEnabled(true);
		tfTalentPanelField_2.setVisible(false);
		
		spTalentPanelSpinner_0.setEnabled(false);
		
		cbTalentPanelBox.setVisible(false);
		
		tTalentPanelTable_0.setVisible(false);
		tTalentPanelTable_1.setVisible(false);
		tTalentPanelTable_2.setVisible(false);
	}
	
	/**	Dh	12.7.2020
	 * 
	 */
	private void setBasisTalent() {
		lTalentPanelLabel_3.setText("Probe");
		lTalentPanelLabel_3.setBounds(104, 90, 63, 20);
		lTalentPanelLabel_3.setVisible(true);
		
		tfTalentPanelField_0.setEditable(true);
		tfTalentPanelField_0.setEnabled(false);
		tfTalentPanelField_1.setEditable(true);
		tfTalentPanelField_1.setEnabled(false);
		
		spTalentPanelSpinner_0.setEnabled(true);
		
		tTalentPanelTable_0.setVisible(true);
	}
	/**	Dh	12.7.2020
	 * 
	 */
	private void setPhysicalTalent() {
		lTalentPanelLabel_3.setText("Probe");
		lTalentPanelLabel_3.setBounds(104, 90, 63, 20);
		lTalentPanelLabel_3.setVisible(true);
		lTalentPanelLabel_4.setText("BE");
		lTalentPanelLabel_4.setVisible(true);
		
		tfTalentPanelField_0.setEditable(true);
		tfTalentPanelField_0.setEnabled(false);
		tfTalentPanelField_1.setEditable(true);
		tfTalentPanelField_1.setEnabled(false);
		
		spTalentPanelSpinner_0.setEnabled(true);
		
		tTalentPanelTable_0.setVisible(true);
		tTalentPanelTable_1.setVisible(true);
	}
	/**	Dh	12.7.2020
	 * 
	 */
	private void setCommunicationTalent() {
		lTalentPanelLabel_3.setText("Sprache");
		lTalentPanelLabel_3.setBounds(104, 90, 63, 20);
		lTalentPanelLabel_3.setVisible(true);
		lTalentPanelLabel_4.setText("Kom.");
		lTalentPanelLabel_4.setVisible(true);
		
		tfTalentPanelField_0.setEditable(true);
		tfTalentPanelField_0.setEnabled(false);
		tfTalentPanelField_1.setEditable(true);
		tfTalentPanelField_1.setEnabled(false);
		tfTalentPanelField_2.setVisible(true);
		
		spTalentPanelSpinner_0.setEnabled(true);
		
		cbTalentPanelBox.setVisible(true);
	}
	/**	Dh	12.7.2020
	 * 
	 */
	private void setFightTalent() {
		lTalentPanelLabel_3.setText("AT/PA");
		lTalentPanelLabel_3.setBounds(113, 90, 40, 20);
		lTalentPanelLabel_3.setVisible(true);
		lTalentPanelLabel_4.setText("BE");
		lTalentPanelLabel_4.setVisible(true);
		
		tfTalentPanelField_0.setEditable(true);
		tfTalentPanelField_0.setEnabled(false);
		tfTalentPanelField_1.setEditable(true);
		tfTalentPanelField_1.setEnabled(false);
		
		spTalentPanelSpinner_0.setEnabled(true);
		
		tTalentPanelTable_1.setVisible(true);
		tTalentPanelTable_2.setVisible(true);
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	11.7.2020
	 * 
	 * @throws Exception
	 */
	private void addFreeTalents() throws Exception {
		Object vCur;
		String vName;
		List vTemp = Loader.getTalentList();
		
		if (vTemp != null) {
			if (!vTemp.isEmpty()) {
				vTemp.toFirst();
				
				while(!vTemp.isEnd()) {
					vCur = vTemp.getCurrent();
					
					if (vCur instanceof Talent) {
						if (rCM.haveTalentByCharacter(id, ((Talent)vCur).getId()) == true) vTemp.remove();
						else vTemp.next();
					}else throw new Exception("06; TaFra,aFT");
				}
				
				addListToModel(rListModel_1, vTemp);
			}
		}
	}
	
	/**	Dh	11.7.2020
	 * 
	 */
	protected void setSpecificValues(int pID) throws Exception{
		lFrameTitle_0.setText("Talent Auswahl");
		lPanelTitle_0.setText("Besitzende");
		lPanelTitle_1.setText("Auswahl");
		
		addListToModel(rListModel_0, rCM.getTalentListOfCharacter(pID));
		addFreeTalents();
		
		if (rListModel_0.getSize() > 0) btPanelButton_2.setEnabled(true);
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	12.7.2020
	 * 
	 */
	protected void updateSelected(boolean pChoosed, int pInd) {
		Talent vCur;
		boolean vIsLang = false;
		int vValue = -1;
		int vCompl = -1;
		String vName = "";
		String vType = null;
		int[] vProp = null;
		int[] vBE = null;
		int[] vATPA = null;
		
		resetPanel();
		if (pInd != -1) {
			try {
				if (pChoosed == true) {
					vCur = rCM.getTalentOfCharacter(id, (int)rListModel_0.getObjectAt(pInd));
					
					btPanelButton_0.setEnabled(true);
					btPanelButton_0.setText("Ändern");
					btPanelButton_1.setEnabled(true);
					liPanelList_1.clearSelection();
				}else {
					vCur = Loader.getTalent((int)rListModel_1.getObjectAt(pInd));
					
					btPanelButton_0.setEnabled(true);
					btPanelButton_0.setText("Hinzufügen");
					liPanelList_0.clearSelection();
				}
				
				vName = vCur.getName();
				vType = ""+Loader.getTalentType(vCur.getType());
				//vType = ""+vCur.getType();
				vValue = vCur.getTaw();
				
				if (vCur instanceof Basictalent) {
					vProp = ((Basictalent)vCur).getPropInds();
					
					if (vCur instanceof PhysicalTalent) {
						vBE = ((PhysicalTalent)vCur).getEBE();
						
						setPhysicalTalent();
					} else if (vCur instanceof Communicationtalent) {
						vCompl = ((Communicationtalent)vCur).getComplexity();
						vIsLang = ((Communicationtalent)vCur).isLanguage();
						
						setCommunicationTalent();
					} else {
						setBasisTalent();
					}
				} else if (vCur instanceof Fighttalent) {
					vBE = ((Fighttalent)vCur).getEBE();
					vATPA = ((Fighttalent)vCur).getFightValues();
					
					setFightTalent();
				}
				
			}catch(Exception ex) {
				if (pChoosed == true) liPanelList_0.clearSelection();
				else liPanelList_1.clearSelection();
				
				rMF.handleException(ex);
			}
		}else {
			if (pChoosed == true) btPanelButton_1.setEnabled(false);
			
			if ((liPanelList_0.getSelectedIndex() == -1) && (liPanelList_1.getSelectedIndex() == -1)) btPanelButton_0.setEnabled(false);
		}
		
		tfTalentPanelField_0.setText(""+vName);
		
		if (vType != null) tfTalentPanelField_1.setText(vType);
		else tfTalentPanelField_1.setText("");
		if (vValue != -1) spTalentPanelSpinner_0.setValue(vValue);
		else spTalentPanelSpinner_0.setValue(0);
		if (vCompl != -1) {
			tfTalentPanelField_2.setText(""+vCompl);
			cbTalentPanelBox.setSelected(vIsLang);
		}
		else {
			tfTalentPanelField_2.setText("");
			cbTalentPanelBox.setSelected(false);
		}
		if (vProp != null) {
			rTableModel_0.setValueAt(vProp[0], 0, 0);
			rTableModel_0.setValueAt(vProp[1], 0, 1);
			rTableModel_0.setValueAt(vProp[2], 0, 2);
		}else {
			rTableModel_0.setValueAt(-1, 0, 0);
			rTableModel_0.setValueAt(-1, 0, 1);
			rTableModel_0.setValueAt(-1, 0, 2);
		}
		if (vBE != null) {
			rTableModel_1.setValueAt(vBE[0], 0, 0);
			rTableModel_1.setValueAt(vBE[1], 0, 1);
		}else {
			rTableModel_1.setValueAt(0, 0, 0);
			rTableModel_1.setValueAt(0, 0, 1);
		}
		if (vATPA != null) {
			rTableModel_2.setValueAt(vATPA[0], 0, 0);
			rTableModel_2.setValueAt(vATPA[1], 0, 1);
		}else {
			rTableModel_2.setValueAt(0, 0, 0);
			rTableModel_2.setValueAt(0, 0, 1);
		}
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	14.7.2020
	 * 
	 */
	protected void addElement() {
		Talent vTalent;
		int vSelInd = liPanelList_1.getSelectedIndex();
		
		if (vSelInd !=-1 ) {
			try {
				vTalent = Loader.getTalent((int)rListModel_1.getObjectAt(vSelInd));
				
				vTalent.setTaw((int)spTalentPanelSpinner_0.getValue());
				
				if (vTalent instanceof Fighttalent) ((Fighttalent) vTalent).setFightValues(
						new int[] {(int)tTalentPanelTable_2.getValueAt(0, 0), (int)tTalentPanelTable_2.getValueAt(0, 1)});
				
				rCM.addTalentToCharacter(id, vTalent);
				addListToModel(rListModel_0, rCM.getTalentListOfCharacter(id));
				addFreeTalents();
				
				if (btPanelButton_2.isEnabled() == false) btPanelButton_2.setEnabled(true);
			} catch (Exception ex) {rMF.handleException(ex);}
		} else rMF.handleException(new Exception("07; EqFra,aE"));
	}
	/**	Dh	14.7.2020
	 * 
	 */
	protected void applyChanges() {
		int vID;
		String vText;
		Talent vTalent;
		
		int vSelInd = liPanelList_0.getSelectedIndex();
		
		if (vSelInd !=-1 ) {
			vID = (int)rListModel_0.getObjectAt(vSelInd);
			try {
				vTalent = rCM.getTalentOfCharacter(id, vID);
				
				vTalent.setTaw((int)spTalentPanelSpinner_0.getValue());
				
				if (vTalent instanceof Fighttalent) ((Fighttalent) vTalent).setFightValues(
						new int[] {(int)tTalentPanelTable_2.getValueAt(0, 0), (int)tTalentPanelTable_2.getValueAt(0, 1)}); 
				
			} catch (Exception ex) {rMF.handleException(ex);}
		} else rMF.handleException(new Exception("07; TaFra,aC"));
	}
	/**	Dh	14.7.2020
	 * 	
	 */
	protected void remove() {
		int vID;
		int vSelInd = liPanelList_0.getSelectedIndex();
		
		if (vSelInd != -1) {
			vID = (int)rListModel_0.getObjectAt(vSelInd);
			try {
				rCM.removeTalentOfCharacter(id, vID);
				rListModel_0.removeElementAt(vSelInd);
				
				addFreeTalents();
				
				if ((liPanelList_0.getComponentCount() > 0) && (btPanelButton_2.isEnabled() == false)) btPanelButton_2.setEnabled(true);
				if (rListModel_0.getSize() == 0) btPanelButton_2.setEnabled(false);
			}catch(Exception ex) {rMF.handleException(ex);}
		} else rMF.handleException(new Exception("07; TaFra,r"));
	}
	/**	Dh	14.7.2020
	 * 
	 */
	protected void removeAllFromList() {
		try {
			if (btPanelButton_2.isEnabled() == true) btPanelButton_2.setEnabled(false);
			rCM.setWeaponListOfCharacter(id, Loader.getBasicTalents());
			addListToModel(rListModel_0, rCM.getTalentListOfCharacter(id));
			addFreeTalents();
		} catch(Exception ex) {rMF.handleException(ex);} 
	}
}
