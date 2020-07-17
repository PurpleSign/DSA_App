/**	DSA_App v0.0	Dh	16.7.2020
 * 
 * 	pGUI
 * 	  CharModFrame
 * 		CharListModFrame
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

import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import pDataStructures.List;
import pDatenbank.Loader;
import pLogik.CharacterManager;
import pLogik.Pro;
import pLogik.SpecialCraft;
import pLogik.Stringed;
import pLogik.Talent;
import pLogik.Valued;
import pLogik.Weapon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class CharListModFrame extends CharModFrame{
	protected JPanel contentPane, pFramePanel, lSubPanle;
	protected JScrollPane spPanelScrollPane_0, spPanelScrollPane_1;
	
	protected JLabel lFrameTitle_0, lFrameTitle_1, lPanelTitle_0, lPanelTitle_1;
	
	protected JButton btFrameButton, btPanelButton_0, btPanelButton_1, btPanelButton_2;
	
	protected JList liPanelList_0, liPanelList_1;
	protected JListModel rListModel_0, rListModel_1;
	
	private JLabel lEquipLabel_0, lEquipLabel_1, lEquipLabel_2, lEquipLabel_3, lEquipLabel_4,
		lEquipLabel_5, lEquipLabel_6, lEquipLabel_7;
	private JTextField tfEquipPanelField_0, tfEquipPanelField_1;
	private JSpinner spEquipPanelSpinner_0, spEquipPanelSpinner_1, spEquipPanelSpinner_2, spEquipPanelSpinner_3;
	
	private JCheckBox cbEquipPanelBox_1, cbEquipPanelBox_3;
	private JComboBox cbEquipPanelCombo_0, cbEquipPanelCombo_1;
	
	private JTable tEquipPanleTable_0, tEquipPanleTable_1, tEquipPanleTable_2, tEquipPanleTable_3, tEquipPanleTable_4;
	private JTableModel rEquipPanelTable_0, rEquipPanelTable_1, rEquipPanelTable_2, rEquipPanelTable_3, rEquipPanelTable_4;
	private JSpinnModel rEquipSpinnModel;
	
	/**	Dh	16.7.2020
	 * 
	 */
	public CharListModFrame() {
		super();
	}
	/**	Dh	11.7.2020
	 * 
	 * @param pID
	 * @param pCM
	 * @param pMF
	 * @wbp.parser.constructor
	 */
	public CharListModFrame(int pID, CharacterManager pCM, MainFrame pMF) {
		super(pID, pCM, pMF);
	}
	/**	Dh	11.7.2020
	 * 
	 * @param pID
	 * @param pCM
	 * @param pMF
	 * @param pWidth
	 * @param pHeight
	 */
	public CharListModFrame(int pID, CharacterManager pCM, MainFrame pMF, int pWidth, int pHeight) {
		super(pID, pCM, pMF, pWidth, pHeight);
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	11.7.2020
	 * 
	 */
	protected void initSize() {
		width = 565;
		height = 511;
	}
	
	/**	Dh	11.7.2020
	 * 
	 */
	protected void initModels() {
		rListModel_0 = new JListModel();
		rListModel_1 = new JListModel();
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	11.7.2020
	 * 
	 */
	protected void initFrame() {
		Point vPos = rMF.getMiddlePosition();
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//setBounds((int)(vPos.getX()-(width/2)), (int)(vPos.getY()-(height/2)), width, height);
		setBounds(100, 100, 566, 511);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lFrameTitle_0 = new JLabel("Ausr\u00FCstungs Auswahl");
		lFrameTitle_0.setHorizontalAlignment(SwingConstants.CENTER);
		lFrameTitle_0.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		
		lFrameTitle_1 = new JLabel("Test");
		lFrameTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		lFrameTitle_1.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		initPanel();
		
		btFrameButton = new JButton("Zur\u00FCck");
		btFrameButton.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btFrameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(lFrameTitle_0, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
				.addComponent(lFrameTitle_1, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(pFramePanel, GroupLayout.PREFERRED_SIZE, 544, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(151)
					.addComponent(btFrameButton, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(174, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lFrameTitle_0, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lFrameTitle_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pFramePanel, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btFrameButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(124, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	/**	Dh	11.7.2020
	 * 
	 */
	protected  void initPanel() {
		pFramePanel = new JPanel();
		pFramePanel.setBackground(SystemColor.controlShadow);
		
		lPanelTitle_0 = new JLabel("Besitzende");
		lPanelTitle_0.setHorizontalAlignment(SwingConstants.CENTER);
		lPanelTitle_0.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		lPanelTitle_1 = new JLabel("Auswahl");
		lPanelTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		lPanelTitle_1.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		spPanelScrollPane_0 = new JScrollPane();
		spPanelScrollPane_1 = new JScrollPane();
		
		liPanelList_0 = new JList();
		liPanelList_0.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liPanelList_0.setModel(rListModel_0);
		liPanelList_0.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				updateSelected(true, liPanelList_0.getSelectedIndex());
			}
		});
		spPanelScrollPane_0.setViewportView(liPanelList_0);
		
		liPanelList_1 = new JList();
		liPanelList_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liPanelList_1.setModel(rListModel_1);
		liPanelList_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				updateSelected(false, liPanelList_1.getSelectedIndex());
			}
		});
		spPanelScrollPane_1.setViewportView(liPanelList_1);
		
		lSubPanle = new JPanel();
		lSubPanle.setPreferredSize(new Dimension(180, 188));
		lSubPanle.setBackground(Color.LIGHT_GRAY);
		initSubPanle();
		
		btPanelButton_0 = new JButton("Hinzuf\u00FCgen");
		btPanelButton_0.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btPanelButton_0.setEnabled(false);
		btPanelButton_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (liPanelList_0.getSelectedIndex() != -1) applyChanges();
				else if (liPanelList_1.getSelectedIndex() != -1) addElement();
			}
		});
		
		btPanelButton_1 = new JButton("Entfernen");
		btPanelButton_1.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btPanelButton_1.setEnabled(false);
		btPanelButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove();
			}
		});
		
		btPanelButton_2 = new JButton("Alle entfernen");
		btPanelButton_2.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btPanelButton_2.setEnabled(false);
		btPanelButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAllFromList();
			}
		});
		
		GroupLayout gl_pEquipFramePanel = new GroupLayout(pFramePanel);
		gl_pEquipFramePanel.setHorizontalGroup(
			gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pEquipFramePanel.createSequentialGroup()
					.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pEquipFramePanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(spPanelScrollPane_0, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lSubPanle, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
								.addComponent(btPanelButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btPanelButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btPanelButton_0, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)))
						.addComponent(lPanelTitle_0, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lPanelTitle_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(spPanelScrollPane_1, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pEquipFramePanel.setVerticalGroup(
			gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pEquipFramePanel.createSequentialGroup()
					.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lPanelTitle_0)
						.addComponent(lPanelTitle_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(spPanelScrollPane_0, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
							.addComponent(spPanelScrollPane_1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pEquipFramePanel.createSequentialGroup()
							.addComponent(lSubPanle, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btPanelButton_0, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(btPanelButton_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btPanelButton_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addGap(149))
		);		
		pFramePanel.setLayout(gl_pEquipFramePanel);
	}
	/*protected  void initPanel() {
		pFramePanel = new JPanel();
		pFramePanel.setBackground(SystemColor.controlShadow);
		
		lPanelTitle_0 = new JLabel("Besitzende");
		lPanelTitle_0.setHorizontalAlignment(SwingConstants.CENTER);
		lPanelTitle_0.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		lPanelTitle_1 = new JLabel("Auswahl");
		lPanelTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		lPanelTitle_1.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		spPanelScrollPane_0 = new JScrollPane();
		spPanelScrollPane_1 = new JScrollPane();
		
		liPanelList_0 = new JList();
		liPanelList_0.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liPanelList_0.setModel(rListModel_0);
		liPanelList_0.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				updateSelected(true, liPanelList_0.getSelectedIndex());
			}
		});
		spPanelScrollPane_0.setViewportView(liPanelList_0);
		
		liPanelList_1 = new JList();
		liPanelList_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liPanelList_1.setModel(rListModel_1);
		liPanelList_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				updateSelected(false, liPanelList_1.getSelectedIndex());
			}
		});
		spPanelScrollPane_1.setViewportView(liPanelList_1);
		
		lSubPanle = new JPanel();
		lSubPanle.setBackground(SystemColor.controlShadow);
		lSubPanle.setLayout(null);
		initSubPanle();
		
		btPanelButton_0 = new JButton("Hinzuf\u00FCgen");
		btPanelButton_0.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btPanelButton_0.setEnabled(false);
		btPanelButton_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (liPanelList_0.getSelectedIndex() != -1) applyChanges();
				else if (liPanelList_1.getSelectedIndex() != -1) add();
			}
		});
		
		btPanelButton_1 = new JButton("Entfernen");
		btPanelButton_1.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btPanelButton_1.setEnabled(false);
		btPanelButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove();
			}
		});
		
		btPanelButton_2 = new JButton("Alle entfernen");
		btPanelButton_2.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btPanelButton_2.setEnabled(false);
		btPanelButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAllFromList();
			}
		});
		
		GroupLayout gl_pEquipFramePanel = new GroupLayout(pFramePanel);
		gl_pEquipFramePanel.setHorizontalGroup(
			gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pEquipFramePanel.createSequentialGroup()
					.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pEquipFramePanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(spPanelScrollPane_0, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lSubPanle, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
								.addComponent(btPanelButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btPanelButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btPanelButton_0, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)))
						.addComponent(lPanelTitle_0, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lPanelTitle_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(spPanelScrollPane_1, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pEquipFramePanel.setVerticalGroup(
			gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pEquipFramePanel.createSequentialGroup()
					.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lPanelTitle_0)
						.addComponent(lPanelTitle_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(spPanelScrollPane_0, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
							.addComponent(spPanelScrollPane_1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pEquipFramePanel.createSequentialGroup()
							.addComponent(lSubPanle, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btPanelButton_0, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(btPanelButton_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btPanelButton_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addGap(149))
		);
		pFramePanel.setLayout(gl_pEquipFramePanel);
	}*/
	
	protected void initSubPanle() {
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
		
		tfEquipPanelField_0 = new JTextField();
		tfEquipPanelField_0.setBounds(0, 20, 150, 20);
		tfEquipPanelField_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfEquipPanelField_0.setColumns(10);
		tfEquipPanelField_0.setVisible(false);
		lSubPanle.add(tfEquipPanelField_0);
		
		tfEquipPanelField_1 = new JTextField();
		tfEquipPanelField_1.setEditable(false);
		tfEquipPanelField_1.setBounds(0, 62, 113, 20);
		tfEquipPanelField_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfEquipPanelField_1.setEnabled(false);
		tfEquipPanelField_1.setColumns(10);
		tfEquipPanelField_1.setVisible(false);
		lSubPanle.add(tfEquipPanelField_1);
		
		tEquipPanleTable_0 = new JTable();
		tEquipPanleTable_0.setVisible(false);
		tEquipPanleTable_0.setBounds(155, 20, 50, 20);
		tEquipPanleTable_0.setRowHeight(20);
		tEquipPanleTable_0.setColumnSelectionAllowed(false);
		tEquipPanleTable_0.setCellSelectionEnabled(false);
		tEquipPanleTable_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tEquipPanleTable_0.setModel(rEquipPanelTable_0);
		tEquipPanleTable_0.getColumnModel().getColumn(0).setCellEditor(new JNumFieldEditor(1, 10));
		tEquipPanleTable_0.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				
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
		tEquipPanleTable_1.setBounds(119, 63, 41, 20);
		tEquipPanleTable_1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		tEquipPanleTable_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tEquipPanleTable_1.setRowHeight(20);
		tEquipPanleTable_1.setColumnSelectionAllowed(false);
		tEquipPanleTable_1.setCellSelectionEnabled(false);
		tEquipPanleTable_1.setModel(rEquipPanelTable_1);
		tEquipPanleTable_1.getColumnModel().getColumn(0).setCellEditor(new JNumFieldEditor(1, 30));
		tEquipPanleTable_1.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		tEquipPanleTable_1.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.LEFT);
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
		tEquipPanleTable_2.setBounds(159, 21, 41, 20);
		tEquipPanleTable_2.setRowHeight(20);
		tEquipPanleTable_2.setColumnSelectionAllowed(false);
		tEquipPanleTable_2.setCellSelectionEnabled(false);
		tEquipPanleTable_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tEquipPanleTable_2.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		tEquipPanleTable_2.setModel(rEquipPanelTable_2);
		tEquipPanleTable_2.getColumnModel().getColumn(0).setCellEditor(new JNumFieldEditor(-10, 10));
		tEquipPanleTable_2.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		tEquipPanleTable_2.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.LEFT);
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
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		tEquipPanleTable_3.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		tEquipPanleTable_3.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		tEquipPanleTable_3.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		tEquipPanleTable_3.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
				setFont(new Font("Liberation Serif", Font.PLAIN, 12));
				setHorizontalAlignment(SwingConstants.CENTER);
				
				setText(""+pTable.getValueAt(pRow, pCol));
				return this;
			}
		});
		lSubPanle.add(tEquipPanleTable_3);
		
		tEquipPanleTable_4 = new JTable();
		tEquipPanleTable_4.setVisible(false);
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
		spEquipPanelSpinner_0.setModel(new SpinnerNumberModel(0, -10, 10, 1));
		lSubPanle.add(spEquipPanelSpinner_0);
		
		spEquipPanelSpinner_1 = new JSpinner();
		spEquipPanelSpinner_1.setPreferredSize(new Dimension(25, 20));
		spEquipPanelSpinner_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		//spEquipPanelSpinner_1.setEnabled(false);
		spEquipPanelSpinner_1.setVisible(false);
		spEquipPanelSpinner_1.setModel(rEquipSpinnModel);
		spEquipPanelSpinner_1.setBounds(79, 106, 50, 20);
		lSubPanle.add(spEquipPanelSpinner_1);
		
		spEquipPanelSpinner_2 = new JSpinner();
		spEquipPanelSpinner_2.setPreferredSize(new Dimension(25, 20));
		spEquipPanelSpinner_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		spEquipPanelSpinner_2.setVisible(false);
		spEquipPanelSpinner_2.setBounds(169, 62, 41, 20);
		spEquipPanelSpinner_2.setModel(new SpinnerNumberModel(0, -10, 12, 1));
		lSubPanle.add(spEquipPanelSpinner_2);
		
		spEquipPanelSpinner_3 = new JSpinner();
		spEquipPanelSpinner_3.setPreferredSize(new Dimension(25, 20));
		spEquipPanelSpinner_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		spEquipPanelSpinner_3.setVisible(false);
		spEquipPanelSpinner_3.setBounds(164, 63, 41, 20);
		spEquipPanelSpinner_3.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		lSubPanle.add(spEquipPanelSpinner_3);
		
		cbEquipPanelCombo_0 = new JComboBox();
		cbEquipPanelCombo_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		cbEquipPanelCombo_0.setBounds(0, 138, 95, 20);
		lSubPanle.add(cbEquipPanelCombo_0);
		
		cbEquipPanelCombo_1 = new JComboBox();
		cbEquipPanelCombo_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		cbEquipPanelCombo_1.setBounds(111, 138, 95, 20);
		lSubPanle.add(cbEquipPanelCombo_1);
		
		cbEquipPanelBox_1 = new JCheckBox("Magisch");
		cbEquipPanelBox_1.setBackground(SystemColor.controlShadow);
		cbEquipPanelBox_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		cbEquipPanelBox_1.setBounds(0, 165, 97, 23);
		cbEquipPanelBox_1.setVisible(false);
		lSubPanle.add(cbEquipPanelBox_1);
		
		cbEquipPanelBox_3 = new JCheckBox("Verzehrt");
		cbEquipPanelBox_3.setBackground(SystemColor.controlShadow);
		cbEquipPanelBox_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		cbEquipPanelBox_3.setBounds(111, 165, 97, 23);
		cbEquipPanelBox_3.setVisible(false);
		lSubPanle.add(cbEquipPanelBox_3);
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	11.7.2020
	 * 
	 * @param pJLM
	 * @param pList
	 * @throws Exception
	 */
	protected void addListToModel(JListModel pJLM, List pList) throws Exception {
		Object vListEle;
		int vID;
		String vText;
		
		if (pJLM != null) {
			pJLM.clear();
			if (!pList.isEmpty()) {
				pList.toFirst();
				
				while(!pList.isEnd()) {
					vListEle = pList.getCurrent();
					
					if (vListEle instanceof Pro) {
						vID = ((Pro) vListEle).getId();
						vText = ((Pro)vListEle).getName();
						
						if (pJLM.equals(rListModel_0)) {
							//if (vListEle instanceof Referred)
							if (vListEle instanceof Stringed) vText += " "+((Stringed)vListEle).getStringedValue();
							if (vListEle instanceof Valued) vText += " "+((Valued)vListEle).getValue();
						}
					}else if (vListEle instanceof SpecialCraft) {
						vID = ((SpecialCraft) vListEle).getId();
						vText = ((SpecialCraft)vListEle).getName();
						
						if (pJLM.equals(rListModel_0)) {
							//if (vListEle instanceof Referred)
							if (vListEle instanceof Stringed) vText += " "+((Stringed)vListEle).getStringedValue();
						}
					}else if (vListEle instanceof Weapon) {
						vID = ((Weapon) vListEle).getId();
						vText = ((Weapon)vListEle).getName();
					}else if (vListEle instanceof Talent) {
						vID = ((Talent) vListEle).getId();
						vText = ((Talent)vListEle).getName();
					}else throw new Exception("06; ChLiMoFra, aLtM");
					
					pJLM.addElement(vText, vID);
					
					pList.next();
				}
			}//else throw new Exception("05; MaFra, aLtM");
		}else throw new Exception("04; ChLiMoFra, aLtM");
	}
	
	protected void setSpecificValues(int pID) throws Exception {}
	
	/**	Dh	11.7.2020
	 * 
	 */
	protected void setValues() {
		List vTemp;
		try {
			if ((id >= 0) && (rCM.haveCharacterID(id) == true)) {
				lFrameTitle_1.setText("für "+rCM.getNameOfCharacter(id));
				
				setSpecificValues(id);
					
				if (rListModel_0.getSize() > 0) btPanelButton_2.setEnabled(true);
			} else {
				rMF.handleException(new Exception("02; ChLiMoFra,sV"));
				cancel();				
			}
		}catch (Exception ex) {rMF.handleException(ex);}
	}
	
	//----------------------------------------------------------------------------------------------------
		
	protected void updateSelected(boolean pChoosed, int pInd) {}
	
//--------------------------------------------------------------------------------------------------------
	
	protected void addElement() {}
	protected void applyChanges() {}
	protected void remove() {}
	protected void removeAllFromList() {}
}
