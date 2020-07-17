/**	DSA_App v0.0	Dh	17.7.2020
 * 
 * 	pGUI
 * 	  CharModFrame
 * 		CharListModFrame
 * 		  FMActiveWeaponFrame
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

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ItemSelectable;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import pDataStructures.List;
import pDatenbank.Loader;
import pLogik.Calculator;
import pLogik.CharacterManager;
import pLogik.Charakter;
import pLogik.CloseWeapon;
import pLogik.DefenceWeapon;
import pLogik.FightManager;
import pLogik.Pro;
import pLogik.RangeWeapon;
import pLogik.Weapon;

public class FMActiveWeaponFrame extends CharListModFrame {
	private int charID;
	private FightManager rFM;
	
	private JLabel lEquipLabel_0, lEquipLabel_1, lEquipLabel_2, lEquipLabel_3, lEquipLabel_4,
		lEquipLabel_5, lEquipLabel_6, lEquipLabel_7, lEquipLabel_8, lEquipLabel_9;
	private JTextField tfEquipPanelField_0, tfEquipPanelField_1, tfEquipPanelField_2;
	private JSpinner spEquipPanelSpinner_0, spEquipPanelSpinner_1, spEquipPanelSpinner_2, spEquipPanelSpinner_3;
	
	private JComboBox cbEquipPanelCombo;
	//private JCheckBox cbEquipPanelBox_0, cbEquipPanelBox_1, cbEquipPanelBox_2, cbEquipPanelBox_3;
	
	private JTable tEquipPanleTable_0, tEquipPanleTable_1, tEquipPanleTable_2, tEquipPanleTable_3, tEquipPanleTable_4;
	private JTableModel rEquipPanelTable_0, rEquipPanelTable_1, rEquipPanelTable_2, rEquipPanelTable_3, rEquipPanelTable_4;
	private JSpinnModel rEquipSpinnModel;
	private JComboBoxModel rEquipComboModel;
	
	/**	Dh	16.7.2020
	 * 
	 * @param pID
	 * @param pFM
	 * @param pCM
	 * @param pMF
	 */
	public FMActiveWeaponFrame(int pID, FightManager pFM, CharacterManager pCM, MainFrame pMF) {
		super();
		
		id = pID;
		rFM = pFM;
		rCM = pCM;
		rMF = pMF;
		
		initSize();
		initModels();
		
		initFrame();
		
		setValues();
		
		try { charID = rFM.getIDOfCharacterOfFighter(id);}
		catch(Exception ex) {rMF.handleException(ex);}
	}

	/**	Dh	16.7.2020
	 * 
	 */
	protected void initModels() {
		super.initModels();
		
		rEquipPanelTable_0 = new JTableModel(new String[]{"", "", ""}, new int[] {id}, new Object[][] {{1, 'W', 0}},
				new boolean[][] {{true, false, true}});
		rEquipPanelTable_1 = new JTableModel(new String[]{"", "", ""}, new int[] {id}, new Object[][] {{10, '/', 3}},
				new boolean[][] {{true, false, true}});
		rEquipPanelTable_2 = new JTableModel(new String[]{"", "", ""}, new int[] {id}, new Object[][] {{0, '/', 0}},
				new boolean[][] {{true, false, true}});
		rEquipPanelTable_3 = new JTableModel(new String[]{"", "", "", "", ""}, new int[] {id}, new Object[][] {{0, 0, 0, 0, 0}},
				new boolean[][] {{true, true, true, true, true}});
		rEquipPanelTable_4 = new JTableModel(new String[]{"", "", "", "", ""}, new int[] {id}, new Object[][] {{0, 0, 0, 0, 0}},
				new boolean[][] {{true, true, true, true, true}});
		
		rEquipSpinnModel = new JSpinnModel(0);
		
		rEquipComboModel = new JComboBoxModel();
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	17.7.2020
	 * 
	 */
	protected void initSubPanle() {
		lSubPanle.setBackground(SystemColor.controlShadow);
		lSubPanle.setLayout(null);
		
		lEquipLabel_0 = new JLabel("Ausr\u00FCstung");
		lEquipLabel_0.setBounds(0, 0, 150, 17);
		lEquipLabel_0.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		lEquipLabel_0.setVisible(false);
		lSubPanle.add(lEquipLabel_0);
		
		lEquipLabel_1 = new JLabel("Type");
		lEquipLabel_1.setBounds(0, 46, 113, 14);
		lEquipLabel_1.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		lEquipLabel_1.setVisible(false);
		lSubPanle.add(lEquipLabel_1);
		
		lEquipLabel_2 = new JLabel("TP");
		lEquipLabel_2.setBounds(155, 3, 50, 14);
		lEquipLabel_2.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		lEquipLabel_2.setVisible(false);
		lSubPanle.add(lEquipLabel_2);
		
		lEquipLabel_3 = new JLabel("TP/KK");
		lEquipLabel_3.setBounds(119, 46, 41, 14);
		lEquipLabel_3.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		lEquipLabel_3.setVisible(false);
		lSubPanle.add(lEquipLabel_3);
		
		lEquipLabel_4 = new JLabel("Ini");;
		lEquipLabel_4.setBounds(123, 46, 30, 14);
		lEquipLabel_4.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		lEquipLabel_4.setVisible(false);
		lSubPanle.add(lEquipLabel_4);
		
		lEquipLabel_5 = new JLabel("WM");
		lEquipLabel_5.setBounds(159, 2, 41, 14);
		lEquipLabel_5.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		lEquipLabel_5.setVisible(false);
		lSubPanle.add(lEquipLabel_5);
		
		lEquipLabel_6 = new JLabel("TP+");
		lEquipLabel_6.setBounds(110, 89, 96, 14);
		lEquipLabel_6.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		lEquipLabel_6.setVisible(false);
		lSubPanle.add(lEquipLabel_6);
		
		lEquipLabel_7 = new JLabel("BF");
		lEquipLabel_7.setBounds(169, 46, 41, 14);
		lEquipLabel_7.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		lEquipLabel_7.setVisible(false);
		lSubPanle.add(lEquipLabel_7);
		
		lEquipLabel_8 = new JLabel("Schadensart");
		lEquipLabel_8.setBounds(0, 132, 95, 14);
		lEquipLabel_8.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		lEquipLabel_8.setVisible(false);
		lSubPanle.add(lEquipLabel_8);
		
		lEquipLabel_9 = new JLabel("Verwendung");
		lEquipLabel_9.setBounds(110, 132, 95, 14);
		lEquipLabel_9.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		lEquipLabel_9.setVisible(false);
		lSubPanle.add(lEquipLabel_9);
		
		tfEquipPanelField_0 = new JTextField();
		tfEquipPanelField_0.setBounds(0, 20, 150, 20);
		tfEquipPanelField_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfEquipPanelField_0.setColumns(10);
		tfEquipPanelField_0.setVisible(false);
		tfEquipPanelField_0.setEnabled(false);
		lSubPanle.add(tfEquipPanelField_0);
		
		tfEquipPanelField_1 = new JTextField();
		//tfEquipPanelField_1.setEditable(false);
		tfEquipPanelField_1.setBounds(0, 62, 113, 20);
		tfEquipPanelField_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfEquipPanelField_1.setEnabled(false);
		tfEquipPanelField_1.setColumns(10);
		tfEquipPanelField_1.setVisible(false);
		tfEquipPanelField_1.setEnabled(false);
		lSubPanle.add(tfEquipPanelField_1);
		
		tfEquipPanelField_2 = new JTextField();
		//tfEquipPanelField_2.setEditable(false);
		tfEquipPanelField_2.setBounds(0, 149, 95, 20);
		tfEquipPanelField_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfEquipPanelField_2.setEnabled(false);
		tfEquipPanelField_2.setColumns(10);
		tfEquipPanelField_2.setVisible(false);
		tfEquipPanelField_2.setEnabled(false);
		lSubPanle.add(tfEquipPanelField_2);
		
		tEquipPanleTable_0 = new JTable();
		tEquipPanleTable_0.setVisible(false);
		tEquipPanleTable_0.setEnabled(false);
		tEquipPanleTable_0.setBounds(155, 20, 50, 20);
		tEquipPanleTable_0.setRowHeight(20);
		tEquipPanleTable_0.setColumnSelectionAllowed(false);
		tEquipPanleTable_0.setCellSelectionEnabled(false);
		tEquipPanleTable_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tEquipPanleTable_0.setModel(rEquipPanelTable_0);
		tEquipPanleTable_0.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setEnabled(false);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		tEquipPanleTable_0.getColumnModel().getColumn(0).setCellEditor(new JNumFieldEditor(1, 10));
		tEquipPanleTable_0.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				setEnabled(false);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		tEquipPanleTable_0.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				Object vVal = pTable.getValueAt(pRow, pCol);
				
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.LEFT);
				setEnabled(false);
				
				if ((vVal instanceof Integer) && (((int)vVal) >= 0)) setText("+"+pTable.getValueAt(pRow, pCol));
				else setText(""+pTable.getValueAt(pRow, pCol));
				
				return this;
			}
		});
		tEquipPanleTable_0.getColumnModel().getColumn(2).setCellEditor(new JNumFieldEditor(-10, 10));
		tEquipPanleTable_0.getColumnModel().getColumn(0).setPreferredWidth(15);
		tEquipPanleTable_0.getColumnModel().getColumn(1).setPreferredWidth(15);
		lSubPanle.add(tEquipPanleTable_0);
		
		tEquipPanleTable_1 = new JTable();
		tEquipPanleTable_1.setVisible(false);
		tEquipPanleTable_1.setEnabled(false);
		tEquipPanleTable_1.setBounds(119, 63, 41, 20);
		tEquipPanleTable_1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		tEquipPanleTable_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tEquipPanleTable_1.setRowHeight(20);
		tEquipPanleTable_1.setColumnSelectionAllowed(false);
		tEquipPanleTable_1.setCellSelectionEnabled(false);
		tEquipPanleTable_1.setModel(rEquipPanelTable_1);
		tEquipPanleTable_1.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setEnabled(false);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		tEquipPanleTable_1.getColumnModel().getColumn(0).setCellEditor(new JNumFieldEditor(1, 30));
		tEquipPanleTable_1.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				setEnabled(false);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		tEquipPanleTable_1.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.LEFT);
				setEnabled(false);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		tEquipPanleTable_1.getColumnModel().getColumn(2).setCellEditor(new JNumFieldEditor(1, 10));
		tEquipPanleTable_1.getColumnModel().getColumn(0).setWidth(20);
		tEquipPanleTable_1.getColumnModel().getColumn(1).setMinWidth(5);
		tEquipPanleTable_1.getColumnModel().getColumn(1).setWidth(7);
		lSubPanle.add(tEquipPanleTable_1);
		
		tEquipPanleTable_2 = new JTable();
		tEquipPanleTable_2.setVisible(false);
		tEquipPanleTable_2.setEnabled(false);
		tEquipPanleTable_2.setBounds(159, 21, 41, 20);
		tEquipPanleTable_2.setRowHeight(20);
		tEquipPanleTable_2.setColumnSelectionAllowed(false);
		tEquipPanleTable_2.setCellSelectionEnabled(false);
		tEquipPanleTable_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tEquipPanleTable_2.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		tEquipPanleTable_2.setModel(rEquipPanelTable_2);
		tEquipPanleTable_2.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setEnabled(false);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		tEquipPanleTable_2.getColumnModel().getColumn(0).setCellEditor(new JNumFieldEditor(-10, 10));
		tEquipPanleTable_2.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				setEnabled(false);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		tEquipPanleTable_2.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.LEFT);
				setEnabled(false);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		tEquipPanleTable_2.getColumnModel().getColumn(2).setCellEditor(new JNumFieldEditor(-10, 10));
		tEquipPanleTable_2.getColumnModel().getColumn(1).setMinWidth(5);
		tEquipPanleTable_2.getColumnModel().getColumn(1).setWidth(7);
		lSubPanle.add(tEquipPanleTable_2);
		
		tEquipPanleTable_3 = new JTable();
		tEquipPanleTable_3.setVisible(false);
		tEquipPanleTable_3.setEnabled(false);
		tEquipPanleTable_3.setRowHeight(20);
		tEquipPanleTable_3.setColumnSelectionAllowed(false);
		tEquipPanleTable_3.setCellSelectionEnabled(false);
		tEquipPanleTable_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tEquipPanleTable_3.setBounds(0, 106, 95, 20);
		tEquipPanleTable_3.setModel(rEquipPanelTable_3);
		tEquipPanleTable_3.setCellEditor(new JNumFieldEditor(0, 1000));
		tEquipPanleTable_3.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				setEnabled(false);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		tEquipPanleTable_3.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				setEnabled(false);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		tEquipPanleTable_3.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				setEnabled(false);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		tEquipPanleTable_3.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				setEnabled(false);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		tEquipPanleTable_3.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				setEnabled(false);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		lSubPanle.add(tEquipPanleTable_3);
		
		tEquipPanleTable_4 = new JTable();
		tEquipPanleTable_4.setVisible(false);
		tEquipPanleTable_4.setEnabled(false);
		tEquipPanleTable_4.setRowHeight(20);
		tEquipPanleTable_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tEquipPanleTable_4.setColumnSelectionAllowed(false);
		tEquipPanleTable_4.setCellSelectionEnabled(false);
		tEquipPanleTable_4.setBounds(110, 106, 95, 20);
		tEquipPanleTable_4.setModel(rEquipPanelTable_4);
		tEquipPanleTable_4.setCellEditor(new JNumFieldEditor(-10, 10));
		tEquipPanleTable_4.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				Object vVal = pTable.getValueAt(pRow, pCol);
				
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.LEFT);
				setEnabled(false);
				
				if ((vVal instanceof Integer) && (((int)vVal) > 0)) setText("+"+pTable.getValueAt(pRow, pCol));
				else setText(""+pTable.getValueAt(pRow, pCol));
				
				return this;
			}
		});
		tEquipPanleTable_4.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				Object vVal = pTable.getValueAt(pRow, pCol);
				
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.LEFT);
				setEnabled(false);
				
				if ((vVal instanceof Integer) && (((int)vVal) > 0)) setText("+"+pTable.getValueAt(pRow, pCol));
				else setText(""+pTable.getValueAt(pRow, pCol));
				
				return this;
			}
		});
		tEquipPanleTable_4.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				Object vVal = pTable.getValueAt(pRow, pCol);
				
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.LEFT);
				setEnabled(false);
				
				if ((vVal instanceof Integer) && (((int)vVal) > 0)) setText("+"+pTable.getValueAt(pRow, pCol));
				else setText(""+pTable.getValueAt(pRow, pCol));
				
				return this;
			}
		});
		tEquipPanleTable_4.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				Object vVal = pTable.getValueAt(pRow, pCol);
				
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.LEFT);
				setEnabled(false);
				
				if ((vVal instanceof Integer) && (((int)vVal) > 0)) setText("+"+pTable.getValueAt(pRow, pCol));
				else setText(""+pTable.getValueAt(pRow, pCol));
				
				return this;
			}
		});
		tEquipPanleTable_4.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				Object vVal = pTable.getValueAt(pRow, pCol);
				
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.LEFT);
				setEnabled(false);
				
				if ((vVal instanceof Integer) && (((int)vVal) > 0)) setText("+"+pTable.getValueAt(pRow, pCol));
				else setText(""+pTable.getValueAt(pRow, pCol));
				
				return this;
			}
		});
		lSubPanle.add(tEquipPanleTable_4);
		
		spEquipPanelSpinner_0 = new JSpinner();
		spEquipPanelSpinner_0.setBounds(123, 62, 41, 20);
		spEquipPanelSpinner_0.setPreferredSize(new Dimension(25, 20));
		spEquipPanelSpinner_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		spEquipPanelSpinner_0.setVisible(false);
		spEquipPanelSpinner_0.setEnabled(false);
		spEquipPanelSpinner_0.setModel(new SpinnerNumberModel(0, -10, 10, 1));
		lSubPanle.add(spEquipPanelSpinner_0);
		
		spEquipPanelSpinner_1 = new JSpinner();
		spEquipPanelSpinner_1.setPreferredSize(new Dimension(25, 20));
		spEquipPanelSpinner_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		//spEquipPanelSpinner_1.setEnabled(false);
		spEquipPanelSpinner_1.setVisible(false);
		spEquipPanelSpinner_1.setEnabled(false);
		spEquipPanelSpinner_1.setModel(rEquipSpinnModel);
		spEquipPanelSpinner_1.setBounds(79, 106, 50, 20);
		lSubPanle.add(spEquipPanelSpinner_1);
		
		spEquipPanelSpinner_2 = new JSpinner();
		spEquipPanelSpinner_2.setPreferredSize(new Dimension(25, 20));
		spEquipPanelSpinner_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		spEquipPanelSpinner_2.setVisible(false);
		spEquipPanelSpinner_2.setEnabled(false);
		spEquipPanelSpinner_2.setBounds(169, 62, 41, 20);
		spEquipPanelSpinner_2.setModel(new SpinnerNumberModel(0, -10, 12, 1));
		lSubPanle.add(spEquipPanelSpinner_2);
		
		spEquipPanelSpinner_3 = new JSpinner();
		spEquipPanelSpinner_3.setPreferredSize(new Dimension(25, 20));
		spEquipPanelSpinner_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		spEquipPanelSpinner_3.setVisible(false);
		spEquipPanelSpinner_3.setEnabled(false);
		spEquipPanelSpinner_3.setBounds(164, 63, 41, 20);
		spEquipPanelSpinner_3.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		lSubPanle.add(spEquipPanelSpinner_3);
		
		//cbEquipPanelCombo_0 = new JComboBox();
		//cbEquipPanelCombo_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		//cbEquipPanelCombo_0.setBounds(0, 138, 95, 20);
		//lSubPanle.add(cbEquipPanelCombo_0);
		
		cbEquipPanelCombo = new JComboBox();
		cbEquipPanelCombo.setVisible(false);
		cbEquipPanelCombo.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		cbEquipPanelCombo.setBounds(110, 149, 95, 20);
		cbEquipPanelCombo.setModel(rEquipComboModel);
		cbEquipPanelCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				int vWUT, vOrgWUT;     // WeaponUseType
				
				if (e.getStateChange() == ItemEvent.SELECTED) {
					vWUT = (int)rEquipComboModel.getSelectedObject();
					try {
						if (liPanelList_1.getSelectedIndex() != -1) {
							if ((vWUT == 0) || ((vWUT == 1) && (!rFM.hasFighterAPrimaryWeapon(id))) || (((vWUT == 2) || (vWUT == 3) || (vWUT == 4)) &&
									((!rFM.hasFighterAnySecondaryWeapon(id)) && (!rFM.hasFighterATwoHandedWeapon(id))) )) {
								btPanelButton_0.setEnabled(true);
							} else btPanelButton_0.setEnabled(false);
						}else if (liPanelList_0.getSelectedIndex() != -1){
							vOrgWUT = rFM.getActiveWeaponUseTypeOfFighter(id, (int)rListModel_0.getObjectAt((liPanelList_0.getSelectedIndex())));
							
							if ((vWUT == 0)) btPanelButton_0.setEnabled(true);
							else if ((vOrgWUT == 1) && ((vWUT == 1) || (((vWUT == 2) || (vWUT == 3) || (vWUT == 4)) && (!rFM.hasFighterAnySecondaryWeapon(id))) ) )
								btPanelButton_0.setEnabled(true);
							else if ((vOrgWUT == 2) && ( ((vWUT == 1) && (!rFM.hasFighterAPrimaryWeapon(id)))  || ((vWUT == 2) || (vWUT == 3) || (vWUT == 14)))) btPanelButton_0.setEnabled(true);
							else if ((vOrgWUT == 3) || (vOrgWUT == 4)) btPanelButton_0.setEnabled(true);
							else btPanelButton_0.setEnabled(false);
						}
					} catch(Exception ex) {rMF.handleException(ex);}
				}
			}
		});
		lSubPanle.add(cbEquipPanelCombo);

	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	16.7.2020
	 * 
	 */
	private void resetPanel() {
		tfEquipPanelField_0.setVisible(false);
		tfEquipPanelField_1.setVisible(false);
		tfEquipPanelField_2.setVisible(false);
		
		lEquipLabel_0.setVisible(false);
		lEquipLabel_1.setVisible(false);
		lEquipLabel_2.setVisible(false);
		lEquipLabel_3.setVisible(false);
		lEquipLabel_4.setVisible(false);
		lEquipLabel_5.setVisible(false);
		lEquipLabel_6.setVisible(false);
		lEquipLabel_7.setVisible(false);
		lEquipLabel_8.setVisible(false);
		lEquipLabel_9.setVisible(false);
		
		tEquipPanleTable_0.setVisible(false);
		tEquipPanleTable_1.setVisible(false);
		tEquipPanleTable_2.setVisible(false);
		tEquipPanleTable_3.setVisible(false);
		tEquipPanleTable_4.setVisible(false);
		
		spEquipPanelSpinner_0.setVisible(false);
		spEquipPanelSpinner_1.setVisible(false);
		spEquipPanelSpinner_2.setVisible(false);
		spEquipPanelSpinner_3.setVisible(false);
		
		cbEquipPanelCombo.setVisible(false);
	}
	
	/**	Dh	16.7.2020
	 * 
	 */
	private void setCloseWeaponPanel() {
		tfEquipPanelField_0.setVisible(true);
		tfEquipPanelField_1.setVisible(true);
		tfEquipPanelField_2.setVisible(true);
		
		lEquipLabel_0.setVisible(true);
		lEquipLabel_1.setVisible(true);
		lEquipLabel_2.setVisible(true);
		lEquipLabel_3.setText("TP/KK");
		lEquipLabel_3.setBounds(119, 46, 41, 14);
		lEquipLabel_3.setVisible(true);
		lEquipLabel_4.setText("Ini");;
		lEquipLabel_4.setBounds(164, 46, 41, 14);
		lEquipLabel_4.setVisible(true);
		lEquipLabel_5.setText("WM");
		lEquipLabel_5.setBounds(20, 89, 41, 14);
		lEquipLabel_5.setVisible(true);
		lEquipLabel_6.setText("DK");
		lEquipLabel_6.setBounds(79, 89, 50, 14);
		lEquipLabel_6.setVisible(true);
		lEquipLabel_7.setBounds(144, 89, 41, 14);
		lEquipLabel_7.setVisible(true);
		lEquipLabel_8.setVisible(true);
		lEquipLabel_9.setVisible(true);
		
		tEquipPanleTable_0.setVisible(true);
		tEquipPanleTable_1.setVisible(true);
		tEquipPanleTable_2.setBounds(20, 106, 41, 20);
		tEquipPanleTable_2.setVisible(true);
		
		spEquipPanelSpinner_0.setBounds(164, 63, 41, 20);
		spEquipPanelSpinner_0.setVisible(true);
		spEquipPanelSpinner_1.setVisible(true);
		spEquipPanelSpinner_2.setBounds(144, 106, 41, 20);
		spEquipPanelSpinner_2.setVisible(true);
		
		cbEquipPanelCombo.setVisible(true);
	}
	/**	Dh	16.7.2020
	 * 
	 */
	private void setRangedWeaponPanel() {
		tfEquipPanelField_0.setVisible(true);
		tfEquipPanelField_1.setVisible(true);
		tfEquipPanelField_2.setVisible(true);
		
		lEquipLabel_0.setVisible(true);
		lEquipLabel_1.setVisible(true);
		lEquipLabel_2.setVisible(true);
		lEquipLabel_3.setText("TP/KK");
		lEquipLabel_3.setBounds(119, 46, 41, 14);
		lEquipLabel_3.setVisible(true);
		lEquipLabel_4.setText("Laden");
		lEquipLabel_4.setBounds(164, 46, 35, 14);
		lEquipLabel_4.setVisible(true);
		lEquipLabel_5.setText("Reichweite");
		lEquipLabel_5.setBounds(0, 89, 95, 14);
		lEquipLabel_5.setVisible(true);
		lEquipLabel_6.setText("TP+");
		lEquipLabel_6.setBounds(110, 89, 96, 14);
		lEquipLabel_6.setVisible(true);
		lEquipLabel_8.setVisible(true);
		lEquipLabel_9.setVisible(true);
		
		tEquipPanleTable_0.setVisible(true);
		tEquipPanleTable_1.setVisible(true);
		tEquipPanleTable_3.setVisible(true);
		tEquipPanleTable_4.setVisible(true);
		
		spEquipPanelSpinner_3.setVisible(true);
		
		cbEquipPanelCombo.setVisible(true);
	}
	/**	Dh	16.7.2020
	 * 
	 */
	private void setDefenceWeaponPanel() {
		tfEquipPanelField_0.setVisible(true);
		tfEquipPanelField_1.setVisible(true);
		tfEquipPanelField_2.setVisible(true);
		
		lEquipLabel_0.setVisible(true);
		lEquipLabel_1.setVisible(true);
		lEquipLabel_4.setText("Ini");;
		lEquipLabel_4.setBounds(119, 46, 30, 14);
		lEquipLabel_4.setVisible(true);
		lEquipLabel_5.setText("WM");
		lEquipLabel_5.setBounds(159, 3, 41, 14);
		lEquipLabel_5.setVisible(true);
		lEquipLabel_7.setBounds(164, 46, 41, 14);
		lEquipLabel_7.setVisible(true);
		lEquipLabel_8.setVisible(true);
		lEquipLabel_9.setVisible(true);
		
		tEquipPanleTable_2.setBounds(159, 20, 41, 20);
		tEquipPanleTable_2.setVisible(true);
		
		spEquipPanelSpinner_0.setBounds(119, 63, 41, 20);
		spEquipPanelSpinner_0.setVisible(true);
		spEquipPanelSpinner_2.setBounds(164, 63, 41, 20);
		spEquipPanelSpinner_2.setVisible(true);
		
		cbEquipPanelCombo.setVisible(true);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	16.7.2020
	 * 
	 * @param pJCBM
	 * @param pArray
	 * @param pWeaponType
	 * @throws Exception
	 */
	private void addArrayToComboBoxModel(JComboBoxModel pJCBM, int[] pArray) throws Exception {
		if (pJCBM != null) {
			pJCBM.clearElements();
			
			if (pArray != null) {
				
				for (int i=0; i < pArray.length; i++) {
					pJCBM.addElement(Loader.getWeaponUseType(pArray[i]), pArray[i]);
				}
				
				pJCBM.setSelectedItem(pJCBM.getElementAt(0));
			}
		}else throw new Exception("04; FMAcWeFra,aAtCBM");
	}
	
	/**	Dh	16.7.2020
	 * 
	 * @throws Exception
	 */
	private void addFreeWeapons() throws Exception {
		Object vCur;
		List vTemp = rCM.getWeaponListOfCharacter(charID).copyList();
		
		if (vTemp != null) {
			if (!vTemp.isEmpty()) {
				vTemp.toFirst();
				
				while(!vTemp.isEnd()) {
					vCur = vTemp.getCurrent();
					
					if (vCur instanceof Weapon) {
						if (rFM.hasFighterActiveWeapon(charID, ((Weapon)vCur).getId()) == true) vTemp.remove();
						else vTemp.next();
					}else throw new Exception("06; FMAcWeFra,aFW");
				}
				
				addListToModel(rListModel_1, vTemp);
			}
		}
	}
	
	/**	Dh	16.7.2020
	 * 
	 */
	protected void setSpecificValues(int pID) throws Exception{
		Object[][] vCurArray;
		List vCurList;
		
		try {
			vCurArray = rFM.getActiveWeaponsOfFighter(pID);
			
			if (vCurArray != null) {
				vCurList = new List(vCurArray.length);
				
				for (int i=0; i < vCurArray.length; i++) {
					vCurList.append(vCurArray[i][0]);
				}
				
				addListToModel(rListModel_0, vCurList);
			}
			
			addFreeWeapons();
				
			if (rListModel_0.getSize() > 0) btPanelButton_2.setEnabled(true);
		} catch(Exception ex) {throw ex;}
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	16.7.2020
	 * 
	 */
	protected void updateSelected(boolean pChoosed, int pInd) {
		Weapon vCur;
		int vIni = -100;
		int vDK = -1;
		int vBF = -100;
		int vLoad = -1;
		int vUseType = -1;
		int[] vTP = null;
		int[] vTPKK = null;
		int[] vWM = null;
		int[] vRanges = null;
		int[] vTPRanges = null;
		int[] vWeaponUse = null;
		String vName = "";
		String vType = null;
		String vDamageType = null;
		
		resetPanel();
		
		if (pInd != -1) {
			try {
				if (pChoosed == true) {
					vCur = rFM.getActiveWeaponOfFighter(id, (int)rListModel_0.getObjectAt(pInd));
					
					vUseType = rFM.getActiveWeaponUseTypeOfFighter(id, vCur.getId());
					
					btPanelButton_0.setEnabled(true);
					btPanelButton_0.setText("Ändern");
					btPanelButton_1.setEnabled(true);
					liPanelList_1.clearSelection();
				}else {
					vCur = rCM.getWeaponOfCharacter(charID, (int)rListModel_1.getObjectAt(pInd));
					
					btPanelButton_0.setEnabled(true);
					btPanelButton_0.setText("Hinzufügen");
					liPanelList_0.clearSelection();
				}
				
				vName = vCur.getName();
				vType = ""+Loader.getWeaponType(vCur.getWeaponType());
				vTP = vCur.getTp();
				vTPKK = vCur.getTpkk();
				
				vDamageType = Loader.getDamageType(vCur.getMundType());
				vWeaponUse = Loader.determineWeaponUseTypes(vCur.getWeaponType());
				
				if (vCur instanceof CloseWeapon) {
					vIni = ((CloseWeapon)vCur).getIniMod();
					vDK = ((CloseWeapon)vCur).getDk();
					vBF = ((CloseWeapon)vCur).getBf();
					vWM = ((CloseWeapon)vCur).getWm();
					
					if (vCur instanceof DefenceWeapon) setDefenceWeaponPanel();
					else setCloseWeaponPanel();
				} else if (vCur instanceof RangeWeapon) {
					vLoad = ((RangeWeapon)vCur).getLoadTime();
					vRanges = ((RangeWeapon)vCur).getRanges();
					vTPRanges = ((RangeWeapon)vCur).getTpRangeMods();
					
					setRangedWeaponPanel();
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
		
		tfEquipPanelField_0.setText(""+vName);
		
		if (vType != null) tfEquipPanelField_1.setText(vType);
		else tfEquipPanelField_1.setText("");
		if (vDamageType != null) tfEquipPanelField_2.setText(vDamageType);
		else tfEquipPanelField_2.setText("");
		if (vWeaponUse != null) {
			try{addArrayToComboBoxModel(rEquipComboModel, vWeaponUse);}
			catch(Exception ex) {rMF.handleException(ex);}
		} else rEquipComboModel.clearElements();
		if (vUseType != -1) 
			rEquipComboModel.setSelectedObject(vUseType);
		if (vTP != null) {
			tEquipPanleTable_0.setValueAt(vTP[0], 0, 0);
			tEquipPanleTable_0.setValueAt(vTP[1], 0, 2);
		} 
		if (vTPKK != null) {
			tEquipPanleTable_1.setValueAt(vTPKK[0], 0, 0);
			tEquipPanleTable_1.setValueAt(vTPKK[1], 0, 2);
		}
		if (vWM != null) {
			tEquipPanleTable_2.setValueAt(vWM[0], 0, 0);
			tEquipPanleTable_2.setValueAt(vWM[1], 0, 2);
		}
		if (vRanges != null) {
			tEquipPanleTable_3.setValueAt(vRanges[0], 0, 0);
			tEquipPanleTable_3.setValueAt(vRanges[1], 0, 1);
			tEquipPanleTable_3.setValueAt(vRanges[1], 0, 2);
			tEquipPanleTable_3.setValueAt(vRanges[1], 0, 3);
			tEquipPanleTable_3.setValueAt(vRanges[1], 0, 4);
		}
		if (vTPRanges != null) {
			tEquipPanleTable_4.setValueAt(vTPRanges[0], 0, 0);
			tEquipPanleTable_4.setValueAt(vTPRanges[1], 0, 1);
			tEquipPanleTable_4.setValueAt(vTPRanges[1], 0, 2);
			tEquipPanleTable_4.setValueAt(vTPRanges[1], 0, 3);
			tEquipPanleTable_4.setValueAt(vTPRanges[1], 0, 4);
		}
		if (vIni != -100) spEquipPanelSpinner_0.setValue(vIni);
		if (vDK != -1) rEquipSpinnModel.setObject(vDK);
		if (vBF != -100) spEquipPanelSpinner_2.setValue(vBF);
		if (vLoad != -1) spEquipPanelSpinner_3.setValue(vLoad);
	}
	
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	17.7.2020
	 * 
	 */
	protected void addElement() {
		String vText;
		Weapon vWeapon;
		int vSelInd = liPanelList_1.getSelectedIndex();
		
		if (vSelInd !=-1 ) {
			try {
				vWeapon = rCM.getWeaponOfCharacter(charID, (int)rListModel_1.getObjectAt(vSelInd));
				
				rFM.addActiveWeaponOfFighter(id, vWeapon, (int)rEquipComboModel.getSelectedObject());
		
				rListModel_0.addElement(vWeapon.getName(), vWeapon.getId());
				addFreeWeapons();
				
				if (btPanelButton_2.isEnabled() == false) btPanelButton_2.setEnabled(true);
			} catch (Exception ex) {rMF.handleException(ex);}
		} else rMF.handleException(new Exception("07; EqFra,aE"));
	}
	/**	Dh	17.7.2020
	 * 
	 */
	protected void applyChanges() {
		int vID;
		
		int vSelInd = liPanelList_0.getSelectedIndex();
		
		if (vSelInd !=-1 ) {
			vID = (int)rListModel_0.getObjectAt(vSelInd);
			try {
				rFM.setActiveWeaponUseTypeOfFighter(id, vID, (int)rEquipComboModel.getSelectedObject());
			} catch (Exception ex) {if (!ex.getMessage().equals("02; FiEle,sAWUT_a")) rMF.handleException(ex);}
		} else rMF.handleException(new Exception("07; EqFra,aC"));
	}
	/**	Dh	16.7.2020
	 * 
	 */
	protected void remove() {
		int vID;
		int vSelInd = liPanelList_0.getSelectedIndex();
		
		if (vSelInd != -1) {
			vID = (int)rListModel_0.getObjectAt(vSelInd);
			try {
				rFM.removeActiveWeaponOfFighter(id, vID);
				rListModel_0.removeElementAt(vSelInd);
				
				addFreeWeapons();
				
				if ((liPanelList_0.getComponentCount() > 0) && (btPanelButton_2.isEnabled() == false)) btPanelButton_2.setEnabled(true);
				if (rListModel_0.getSize() == 0) btPanelButton_2.setEnabled(false);
			}catch(Exception ex) {rMF.handleException(ex);}
		} else rMF.handleException(new Exception("07; EqFra,r"));
	}
	/**	Dh	16.7.2020
	 * 
	 */
	protected void removeAllFromList() {
		Object[][] vCur;
		
		try {
			if (btPanelButton_2.isEnabled() == true) btPanelButton_2.setEnabled(false);
			vCur = rFM.getActiveWeaponsOfFighter(id);
			if (vCur != null) {
				for (int i=0; i<vCur.length; i++) {
					rFM.removeActiveWeaponOfFighter(id, ((Weapon)vCur[i][0]).getId());
				}
			}
			rListModel_0.clear();
			addFreeWeapons();
		} catch(Exception ex) {rMF.handleException(ex);} 
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	16.7.2020
	 * 
	 */
	protected void cancel() {
		rMF.closeFighterModFrame();
		
		setVisible(false);
		dispose();
	}
	
}
