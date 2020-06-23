/**	DSA_App v0.0	Dh	11.6.2020
 * 
 * 	pGUI
 * 	  MainFrame
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

import pLogik.CloseWeapon;
import pLogik.FightElement;
import pLogik.FightManager;
import pLogik.IniElement;
import pLogik.MainManager;
import pLogik.NeighbourElement;
import pDatenbank.Loader;
import pDataStructures.List;

import java.awt.EventQueue;
import java.io.ObjectInputStream.GetField;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.sun.codemodel.fmt.JTextFile;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import java.awt.ComponentOrientation;
import java.awt.Point;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.SystemColor;
import javax.swing.JInternalFrame;
import javax.swing.JCheckBox;
import java.awt.Insets;
import javax.swing.JProgressBar;

public class MainFrame {
	private boolean HexFMCharFieldGrid;
	private int zHeight, zWidth, zFightTabPanleWidth;
	private int[] zGenPropMods;
	private double[] zGenStatMods;
	
	private JFrame frmDsaAppV;
	private JPanel pFMCharInfoPanel, pFMCharInfoPanel_0, pFMCharInfoPanel_1, pFMCharInfoPanel_2, lFMNeiInfoPanel;
	private JPanel pFMSpezModPanel_0, pFMSpezModPanel_1, pFMGenModPanel_0, pFMGenModPanel_1;
	
	private JTabbedPane tpFMCharInfoTabbedPane;
	
	private JList liFMFightList, liFMIniList, liFMNeiList;
	
	private JLabel lFMSpezPropModLable, lFMSpezPropModLable_0, lFMSpezPropModLable_1, lFMSpezPropModLable_2, lFMSpezPropModLable_3, lFMSpezPropModLable_4,
		lFMSpezPropModLable_5, lFMSpezPropModLable_6, lFMSpezPropModLable_7, lFMSpezPropModLable_8;
	private JLabel lFMSpezStatModLable, lFMSpezStatModLable_0, lFMSpezStatModLable_1, lFMSpezStatModLable_2, lFMSpezStatModLable_3, lFMSpezStatModLable_4,
		lFMSpezStatModLable_5, lFMSpezStatModLable_6, lFMSpezStatModLable_7, lFMSpezStatModLable_8, lFMSpezStatModLable_9;
	private JLabel lblListLabel1, lblListLabel2;
	private JLabel lFMCharInfoTitle, lFMOverviewTitle, lFMOverviewLabel_0, lFMOverviewLabel_1, lFMOverviewLabel_2, lFMOverviewLabel_3;
	private JLabel lFMNeiTitle, lFMNeiListTitle, lFMNeiInfoTitle, lFMNeiInfoLable_0, lFMNeiInfoLable_1, lFMNeiInfoLable_2, lFMNeiInfoLable_3, lFMNeiInfoLable_4;
	private JLabel lFMGenModTitle, lFMGenPropModTitle, lFMGenStatModTitle;
	private JLabel lFMGenPropModLabel_0, lFMGenPropModLabel_1, lFMGenPropModLabel_2, lFMGenPropModLabel_3, lFMGenPropModLabel_4,
		lFMGenPropModLabel_5, lFMGenPropModLabel_6, lFMGenPropModLabel_7, lFMGenPropModLabel_8;
	private JLabel lFMGenStatModLabel_0, lFMGenStatModLabel_1, lFMGenStatModLabel_2, lFMGenStatModLabel_3, lFMGenStatModLabel_4,
		lFMGenStatModLabel_5, lFMGenStatModLabel_6, lFMGenStatModLabel_7, lFMGenStatModLabel_8, lFMGenStatModLabel_9;
	
	private JTextField tfOverviewField_0, tfOverviewField_1, tfOverviewField_2, tfOverviewField_3;
	private JTextField tfFMSpezStatModField_0, tfFMSpezStatModField_1, tfFMSpezStatModField_2, tfFMSpezStatModField_3, tfFMSpezStatModField_4,
		tfFMSpezStatModField_5, tfFMSpezStatModField_6, tfFMSpezStatModField_7, tfFMSpezStatModField_8, tfFMSpezStatModField_9;
	private JTextField tfFMSpezPropModField_0, tfFMSpezPropModField_1, tfFMSpezPropModField_2, tfFMSpezPropModField_3, tfFMSpezPropModField_4,
		tfFMSpezPropModField_5, tfFMSpezPropModField_6, tfFMSpezPropModField_7, tfFMSpezPropModField_8;
	private JTextField tfFMGenPropModField_0, tfFMGenPropModField_1, tfFMGenPropModField_2, tfFMGenPropModField_3, tfFMGenPropModField_4,
		tfFMGenPropModField_5, tfFMGenPropModField_6, tfFMGenPropModField_7, tfFMGenPropModField_8;
	private JTextField tfFMGenStatModField_0, tfFMGenStatModField_1, tfFMGenStatModField_2, tfFMGenStatModField_3, tfFMGenStatModField_4,
		tfFMGenStatModField_5, tfFMGenStatModField_6, tfFMGenStatModField_7, tfFMGenStatModField_8, tfFMGenStatModField_9;
	private JTextField tfFMNeiInfoField_1, tfFMNeiInfoField_2, tfFMNeiInfoField_3, tfFMNeiInfoField_4;
	
	private JButton btCharFieldButton_0;
	private JButton btFMSpezModButton_0, btFMSpezModButton_1, btFMSpezModButton_2;
	private JButton btFMNeiButton_0, btFMNeiButton_1, btFMNeiButton_2, btFMNeiButton_3;
	private JButton btFMFightListButton_0, btFMFightListButton_1, btFMFightListButton_2;
	private JButton btFMGenModButton_0, btFMGenModButton_1, btFMGenModButton_2;
	
	private JCheckBox chFMNeiInfoBox;
	
	private JTabbedPane tpTabbedPane;
	private JSplitPane spFMSplitPane;
	private JPanel pFMPanel_0;
	
	private FightManager rFM;
	private CharakterPanel[] aCharPanelArray; 
	
	private JPanel pFMCharPanel;
	private JLabel lFMCharName, lFMCharLable_0, lFMCharLable_1, lFMCharLable_2, lFMCharLable_3;
	private JProgressBar pbFMCharBar_0, pbFMCharBar_1, pbFMCharBar_2, pbFMCharBar_3;
	private JButton lFMCharButton;
	
	private JListModel rListModel1, rListModel2, rNeiListModel;
	private JLabel lblNewLabel_2;

	/**	Dh	6.5.2020
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	MainFrame window = new MainFrame();
				//	window.frmDsaAppV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**	Dh	6.5.2020
	 * @wbp.parser.entryPoint
	 * 
	 */
	public MainFrame(FightManager pFM) {
		rFM = pFM;
		HexFMCharFieldGrid = false;
		
		zGenPropMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		zGenStatMods = new double[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		aCharPanelArray = new CharakterPanel[9];
		
		initialize();
		
		frmDsaAppV.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		zFightTabPanleWidth = 150;
		
		rListModel1 = new JListModel();
		rListModel2 = new JListModel();
		rNeiListModel = new JListModel();
		
		frmDsaAppV = new JFrame();
		frmDsaAppV.setResizable(false);
		frmDsaAppV.setTitle("DSA App v0.0");
		frmDsaAppV.setBounds(350, 150, 1200, 800);
		frmDsaAppV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		zHeight = frmDsaAppV.getHeight();
		zWidth = frmDsaAppV.getWidth();
		
		tpTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmDsaAppV.getContentPane().add(tpTabbedPane, BorderLayout.CENTER);
		
		spFMSplitPane = new JSplitPane();
		spFMSplitPane.setEnabled(false);
		spFMSplitPane.setDividerSize(10);
		spFMSplitPane.setDividerLocation(300);
		spFMSplitPane.setDividerLocation(zHeight*5 / 8);
		spFMSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		tpTabbedPane.addTab("Kampf Manager", null, spFMSplitPane, null);
		
		initFirstFightManagerPanel();
		initSecondFightManagerPanel();
		
		JPanel tbpanel1 = new JPanel();
		tpTabbedPane.addTab("Test", null, tbpanel1, null);
		
		JSplitPane spCMSplitPane = new JSplitPane();
		tpTabbedPane.addTab("New tab", null, spCMSplitPane, null);
		
		JMenuBar menuBar = new JMenuBar();
		frmDsaAppV.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Datei");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Beenden");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				closeApp();				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Bearbeiten");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Hilfe");
		menuBar.add(mnNewMenu_2);
		
		try {			
			updateLists();
		} catch(Exception ex) {handleException(ex);}
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	17.5.2020
	 * 
	 * 	Initiiert die GUI-Elemente des ersten FightManager SplitPanels.
	 */
	private void initFirstFightManagerPanel() {
		pFMPanel_0 = new JPanel(null, true);
		pFMPanel_0.setAlignmentY(Component.TOP_ALIGNMENT);
		pFMPanel_0.setAlignmentX(Component.LEFT_ALIGNMENT);
		pFMPanel_0.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spFMSplitPane.setLeftComponent(pFMPanel_0);
		
		lblListLabel1 = new JLabel("K\u00E4mpfenden Liste");
		lblListLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblListLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblListLabel1.setFont(new Font("Liberation Serif", Font.BOLD, 24));
		lblListLabel1.setBounds(0, 0, 200, 30);
		pFMPanel_0.add(lblListLabel1);
		
		liFMFightList = new JList();
		liFMFightList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				updateSelectedFighter();
			}
		});
		liFMFightList.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		liFMFightList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liFMFightList.setModel(rListModel1);
		liFMFightList.setBounds(0, lblListLabel1.getHeight()+5, 200, 465);
		pFMPanel_0.add(liFMFightList);
		
		pFMCharInfoPanel = new JPanel();
		pFMCharInfoPanel.setBackground(SystemColor.menu);
		pFMCharInfoPanel.setBounds(886, 0, 301, 500);
		pFMPanel_0.add(pFMCharInfoPanel);
		
		lFMCharInfoTitle = new JLabel("Name");
		lFMCharInfoTitle.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		
		tpFMCharInfoTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		GroupLayout gl_pFMCharInfoPanel = new GroupLayout(pFMCharInfoPanel);
		gl_pFMCharInfoPanel.setHorizontalGroup(
			gl_pFMCharInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFMCharInfoPanel.createSequentialGroup()
					.addGap(136)
					.addComponent(lFMCharInfoTitle)
					.addContainerGap(120, Short.MAX_VALUE))
				.addComponent(tpFMCharInfoTabbedPane, GroupLayout.PREFERRED_SIZE, 306, Short.MAX_VALUE)
		);
		gl_pFMCharInfoPanel.setVerticalGroup(
			gl_pFMCharInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFMCharInfoPanel.createSequentialGroup()
					.addComponent(lFMCharInfoTitle)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tpFMCharInfoTabbedPane, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		
		initInfoOverviewPanel();
		initSpezModPanel();
		initNeighbourPanel();
		
		pFMCharInfoPanel.setLayout(gl_pFMCharInfoPanel);
		
		//initCharPanle();
		
		btCharFieldButton_0 = new JButton("N\u00E4chster Zug");
		btCharFieldButton_0.setBounds(461, 461, 162, 27);
		btCharFieldButton_0.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		btCharFieldButton_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nextTurn();
			}
		});
		pFMPanel_0.add(btCharFieldButton_0);
	}
	/**	Dh	17.5.2020
	 * 
	 * 	Initiiert die GUI-Elemente des zweiten FightManger Panels.
	 */
	private void initSecondFightManagerPanel() {
		JPanel pFMPanel_1 = new JPanel();
		spFMSplitPane.setRightComponent(pFMPanel_1);
		
		btFMFightListButton_0 = new JButton("Neue K\u00E4mpfer*In");
		btFMFightListButton_0.setPreferredSize(new Dimension(120, 25));
		btFMFightListButton_0.setMaximumSize(new Dimension(180, 30));
		btFMFightListButton_0.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		btFMFightListButton_0.setSize(new Dimension(180, 30));
		btFMFightListButton_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addFighter();
			}
		});
		
		btFMFightListButton_1 = new JButton("Neue K\u00E4mpfende Liste");
		btFMFightListButton_1.setEnabled(false);
		
		btFMFightListButton_2 = new JButton("Leere K\u00E4mpfenden Liste");
		btFMFightListButton_2.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		btFMFightListButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteAllFighter();
			}
		});
		
		lFMGenModTitle = new JLabel("Allgemeine tempor\u00E4re Mods");
		lFMGenModTitle.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		
		initGenPropModPanel();
		initGenStatModPanel();
		
		btFMGenModButton_0 = new JButton("Anwenden");
		btFMGenModButton_0.setPreferredSize(new Dimension(115, 25));
		btFMGenModButton_0.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		btFMGenModButton_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openModFrame(true);			
			}
		});
		
		btFMGenModButton_1 = new JButton("Zur\u00FCcksetzen");
		btFMGenModButton_1.setPreferredSize(new Dimension(97, 25));
		btFMGenModButton_1.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		btFMGenModButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//resetGeneralMods();				
			}
		});
		btFMGenModButton_1.setEnabled(false);
		
		btFMGenModButton_2 = new JButton("Alle entfernen");
		btFMGenModButton_2.setPreferredSize(new Dimension(101, 25));
		btFMGenModButton_2.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		btFMGenModButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAllGeneralMods();				
			}
		});
		
		lblListLabel2 = new JLabel("Initiativ Liste");
		lblListLabel2.setEnabled(false);
		lblListLabel2.setFont(new Font("Liberation Serif", Font.BOLD, 24));
		lblListLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblListLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		liFMIniList = new JList();
		liFMIniList.setEnabled(false);
		liFMIniList.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		liFMIniList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liFMIniList.setModel(rListModel2);
		liFMIniList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				updateCharaField();
			}
		});
		
		GroupLayout gl_pFMPanel_1 = new GroupLayout(pFMPanel_1);
		gl_pFMPanel_1.setHorizontalGroup(
			gl_pFMPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFMPanel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pFMPanel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_pFMPanel_1.createSequentialGroup()
							.addGroup(gl_pFMPanel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btFMFightListButton_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btFMFightListButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btFMFightListButton_0, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(pFMGenModPanel_0, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(pFMGenModPanel_1, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_pFMPanel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btFMGenModButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btFMGenModButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btFMGenModButton_0, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
							.addGap(47))
						.addGroup(Alignment.TRAILING, gl_pFMPanel_1.createSequentialGroup()
							.addComponent(lFMGenModTitle)
							.addGap(254)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_pFMPanel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblListLabel2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(liFMIniList, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_pFMPanel_1.setVerticalGroup(
			gl_pFMPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFMPanel_1.createSequentialGroup()
					.addComponent(lFMGenModTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMPanel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pFMPanel_1.createSequentialGroup()
							.addComponent(btFMGenModButton_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btFMGenModButton_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btFMGenModButton_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pFMPanel_1.createSequentialGroup()
							.addComponent(btFMFightListButton_0, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btFMFightListButton_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btFMFightListButton_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(66))
						.addGroup(gl_pFMPanel_1.createSequentialGroup()
							.addGroup(gl_pFMPanel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(pFMGenModPanel_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(pFMGenModPanel_0, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
							.addContainerGap())))
				.addGroup(gl_pFMPanel_1.createSequentialGroup()
					.addComponent(lblListLabel2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(liFMIniList, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		pFMPanel_1.setLayout(gl_pFMPanel_1);
	}
	
	/**	Dh	17.5.2020
	 * 
	 * 	Initiiert die GUI-Elemente des Info Uebersicht Panels.
	 */
	private void initInfoOverviewPanel() {
		pFMCharInfoPanel_0 = new JPanel();
		tpFMCharInfoTabbedPane.addTab("\u00DCbersicht", null, pFMCharInfoPanel_0, null);
		
		lFMOverviewTitle = new JLabel("\u00DCbersicht");
		lFMOverviewTitle.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		lFMOverviewLabel_0 = new JLabel("Lebenspunkte:");
		lFMOverviewLabel_0.setSize(new Dimension(75, 15));
		lFMOverviewLabel_0.setPreferredSize(new Dimension(75, 15));
		lFMOverviewLabel_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMOverviewLabel_1 = new JLabel("Ausdauer:");
		lFMOverviewLabel_1.setSize(new Dimension(75, 15));
		lFMOverviewLabel_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMOverviewLabel_2 = new JLabel("Astralenergie:");
		lFMOverviewLabel_2.setSize(new Dimension(75, 15));
		lFMOverviewLabel_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMOverviewLabel_3 = new JLabel("Magieresistenz:");
		lFMOverviewLabel_3.setSize(new Dimension(75, 15));
		lFMOverviewLabel_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		tfOverviewField_0 = new JTextField();
		tfOverviewField_0.setText("");
		tfOverviewField_0.setEditable(false);
		tfOverviewField_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfOverviewField_0.setSize(new Dimension(6, 15));
		tfOverviewField_0.setColumns(4);
		
		tfOverviewField_1 = new JTextField();
		tfOverviewField_1.setText("");
		tfOverviewField_1.setSize(new Dimension(6, 15));
		tfOverviewField_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfOverviewField_1.setEditable(false);
		tfOverviewField_1.setColumns(4);
		
		tfOverviewField_2 = new JTextField();
		tfOverviewField_2.setText("");
		tfOverviewField_2.setSize(new Dimension(6, 15));
		tfOverviewField_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfOverviewField_2.setEditable(false);
		tfOverviewField_2.setColumns(4);
		
		tfOverviewField_3 = new JTextField();
		tfOverviewField_3.setText("");
		tfOverviewField_3.setSize(new Dimension(6, 15));
		tfOverviewField_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfOverviewField_3.setEditable(false);
		tfOverviewField_3.setColumns(4);
		
		GroupLayout gl_pFMCharInfoPanel_0 = new GroupLayout(pFMCharInfoPanel_0);
		gl_pFMCharInfoPanel_0.setHorizontalGroup(
			gl_pFMCharInfoPanel_0.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFMCharInfoPanel_0.createSequentialGroup()
					.addGroup(gl_pFMCharInfoPanel_0.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pFMCharInfoPanel_0.createSequentialGroup()
							.addGap(121)
							.addComponent(lFMOverviewTitle))
						.addGroup(gl_pFMCharInfoPanel_0.createSequentialGroup()
							.addContainerGap()
							.addComponent(lFMOverviewLabel_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfOverviewField_0, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pFMCharInfoPanel_0.createSequentialGroup()
							.addContainerGap()
							.addComponent(lFMOverviewLabel_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfOverviewField_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pFMCharInfoPanel_0.createSequentialGroup()
							.addContainerGap()
							.addComponent(lFMOverviewLabel_2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfOverviewField_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pFMCharInfoPanel_0.createSequentialGroup()
							.addContainerGap()
							.addComponent(lFMOverviewLabel_3, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfOverviewField_3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(140, Short.MAX_VALUE))
		);
		gl_pFMCharInfoPanel_0.setVerticalGroup(
			gl_pFMCharInfoPanel_0.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFMCharInfoPanel_0.createSequentialGroup()
					.addComponent(lFMOverviewTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMCharInfoPanel_0.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMOverviewLabel_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfOverviewField_0, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMCharInfoPanel_0.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMOverviewLabel_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfOverviewField_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMCharInfoPanel_0.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMOverviewLabel_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfOverviewField_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMCharInfoPanel_0.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMOverviewLabel_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfOverviewField_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(336, Short.MAX_VALUE))
		);
		pFMCharInfoPanel_0.setLayout(gl_pFMCharInfoPanel_0);
	}
	/**	Dh	17.5.2020
	 * 
	 * 	Initialisiert die GUI-Elemente des speziellen ModPanels.
	 */
	private void initSpezModPanel() {
		pFMCharInfoPanel_1 = new JPanel();
		pFMCharInfoPanel_1.setBackground(SystemColor.menu);
		tpFMCharInfoTabbedPane.addTab("Mods", null, pFMCharInfoPanel_1, null);
		
		lblNewLabel_2 = new JLabel("spezifische Mods");
		lblNewLabel_2.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		
		initSpezPropModPanel();
		initSpezStatModPanel();
		
		btFMSpezModButton_0 = new JButton("Mod hinzuf\u00FCgen");
		btFMSpezModButton_0.setMaximumSize(new Dimension(110, 30));
		btFMSpezModButton_0.setPreferredSize(new Dimension(110, 30));
		btFMSpezModButton_0.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btFMSpezModButton_0.setEnabled(false);
		btFMSpezModButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openModFrame(false);
			}
		});
		
		btFMSpezModButton_1 = new JButton("Mod entfernen");
		btFMSpezModButton_1.setPreferredSize(new Dimension(110, 30));
		btFMSpezModButton_1.setMaximumSize(new Dimension(110, 30));
		btFMSpezModButton_1.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btFMSpezModButton_1.setEnabled(false);
		
		btFMSpezModButton_2 = new JButton("Mods entfernen");
		btFMSpezModButton_2.setPreferredSize(new Dimension(110, 30));
		btFMSpezModButton_2.setMaximumSize(new Dimension(110, 30));
		btFMSpezModButton_2.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btFMSpezModButton_2.setEnabled(false);
		btFMSpezModButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeAllSpezMods();
			}
		});
		
		GroupLayout gl_pFMCharInfoPanel_1 = new GroupLayout(pFMCharInfoPanel_1);
		gl_pFMCharInfoPanel_1.setHorizontalGroup(
			gl_pFMCharInfoPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFMCharInfoPanel_1.createSequentialGroup()
					.addGroup(gl_pFMCharInfoPanel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pFMCharInfoPanel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(btFMSpezModButton_0, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pFMCharInfoPanel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(btFMSpezModButton_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
								.addComponent(btFMSpezModButton_2, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
							.addGap(29))
						.addGap(88))
					.addGap(0))
				.addGroup(gl_pFMCharInfoPanel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(pFMSpezModPanel_1, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
					.addGap(31))
				.addGroup(gl_pFMCharInfoPanel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(pFMSpezModPanel_0, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
					.addGap(31))
				.addGroup(gl_pFMCharInfoPanel_1.createSequentialGroup()
					.addGap(81)
					.addComponent(lblNewLabel_2)
					.addContainerGap(99, Short.MAX_VALUE))
		);
		gl_pFMCharInfoPanel_1.setVerticalGroup(
			gl_pFMCharInfoPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFMCharInfoPanel_1.createSequentialGroup()
					.addComponent(lblNewLabel_2)
					.addGap(11)
					.addComponent(pFMSpezModPanel_0, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(pFMSpezModPanel_1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_pFMCharInfoPanel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pFMCharInfoPanel_1.createSequentialGroup()
							.addGap(32)
							.addComponent(btFMSpezModButton_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pFMCharInfoPanel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btFMSpezModButton_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btFMSpezModButton_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		pFMCharInfoPanel_1.setLayout(gl_pFMCharInfoPanel_1);
		
		
	}
	/**	Dh	3.6.2020
	 *
	 *	Initialisiert die GUI-Elemente des KampfnachbarPanels. 
	 */
	private void initNeighbourPanel() {
		pFMCharInfoPanel_2 = new JPanel();
		tpFMCharInfoTabbedPane.addTab("Kampfnachbar*Innen", null, pFMCharInfoPanel_2, null);
		
		lFMNeiTitle = new JLabel("Kampfnachber*Innen");
		lFMNeiTitle.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		
		JPanel lFMNeiInfoPanel = new JPanel();
		lFMNeiInfoPanel.setBackground(Color.WHITE);
		
		lFMNeiListTitle = new JLabel("Kampfnachber*Innen Liste");
		lFMNeiListTitle.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		liFMNeiList = new JList();
		liFMNeiList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				updateSelectedNeighbour();
			}
		});
		liFMNeiList.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		liFMNeiList.setModel(rNeiListModel);
		
		btFMNeiButton_0 = new JButton("Modifizieren");
		btFMNeiButton_0.setPreferredSize(new Dimension(120, 30));
		btFMNeiButton_0.setMaximumSize(new Dimension(200, 30));
		btFMNeiButton_0.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btFMNeiButton_0.setEnabled(false);
		btFMNeiButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openNeighbourFrame(false);
			}
		});
		
		btFMNeiButton_1 = new JButton("Hinzuf\u00FCgen");
		btFMNeiButton_1.setPreferredSize(new Dimension(120, 30));
		btFMNeiButton_1.setMaximumSize(new Dimension(200, 30));
		btFMNeiButton_1.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btFMNeiButton_1.setEnabled(false);
		btFMNeiButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openNeighbourFrame(true);
			}
		});
		
		btFMNeiButton_2 = new JButton("Entfernen");
		btFMNeiButton_2.setPreferredSize(new Dimension(120, 30));
		btFMNeiButton_2.setMaximumSize(new Dimension(200, 30));
		btFMNeiButton_2.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btFMNeiButton_2.setEnabled(false);
		btFMNeiButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeNeighbour();
			}
		});
		
		btFMNeiButton_3 = new JButton("Liste leeren");
		btFMNeiButton_3.setPreferredSize(new Dimension(120, 30));
		btFMNeiButton_3.setMaximumSize(new Dimension(200, 30));
		btFMNeiButton_3.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btFMNeiButton_3.setEnabled(false);
		btFMNeiButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeAllNeighbours();
			}
		});
		
		GroupLayout gl_pFMCharInfoPanel_2 = new GroupLayout(pFMCharInfoPanel_2);
		gl_pFMCharInfoPanel_2.setHorizontalGroup(
			gl_pFMCharInfoPanel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFMCharInfoPanel_2.createSequentialGroup()
					.addGroup(gl_pFMCharInfoPanel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pFMCharInfoPanel_2.createSequentialGroup()
							.addGap(62)
							.addComponent(lFMNeiTitle))
						.addGroup(gl_pFMCharInfoPanel_2.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pFMCharInfoPanel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pFMCharInfoPanel_2.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btFMNeiButton_0, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addComponent(lFMNeiInfoPanel, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
								.addComponent(btFMNeiButton_3, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addComponent(btFMNeiButton_2, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addComponent(btFMNeiButton_1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pFMCharInfoPanel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(liFMNeiList, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
								.addComponent(lFMNeiListTitle))))
					.addContainerGap())
		);
		gl_pFMCharInfoPanel_2.setVerticalGroup(
			gl_pFMCharInfoPanel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFMCharInfoPanel_2.createSequentialGroup()
					.addComponent(lFMNeiTitle)
					.addGroup(gl_pFMCharInfoPanel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pFMCharInfoPanel_2.createSequentialGroup()
							.addGap(45)
							.addComponent(lFMNeiInfoPanel, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btFMNeiButton_0, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
							.addComponent(btFMNeiButton_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btFMNeiButton_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btFMNeiButton_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pFMCharInfoPanel_2.createSequentialGroup()
							.addGap(6)
							.addComponent(lFMNeiListTitle)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(liFMNeiList, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		lFMNeiInfoTitle = new JLabel("Inforamtionen");
		lFMNeiInfoTitle.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		
		lFMNeiInfoLable_0 = new JLabel("Verb\u00FCndet:");
		lFMNeiInfoLable_0.setPreferredSize(new Dimension(60, 15));
		lFMNeiInfoLable_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMNeiInfoLable_1 = new JLabel("Distanz:");
		lFMNeiInfoLable_1.setPreferredSize(new Dimension(60, 15));
		lFMNeiInfoLable_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMNeiInfoLable_2 = new JLabel("At-Mod:");
		lFMNeiInfoLable_2.setPreferredSize(new Dimension(60, 15));
		lFMNeiInfoLable_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMNeiInfoLable_3 = new JLabel("Pa-Mod:");
		lFMNeiInfoLable_3.setPreferredSize(new Dimension(60, 15));
		lFMNeiInfoLable_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMNeiInfoLable_4 = new JLabel("Fk-Mod:");
		lFMNeiInfoLable_4.setPreferredSize(new Dimension(60, 15));
		lFMNeiInfoLable_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		chFMNeiInfoBox = new JCheckBox("");
		//chFMNeiInfoBox.setSize(new Dimension(15, 5));
		chFMNeiInfoBox.setMargin(new Insets(1, 1, 1, 1));
		chFMNeiInfoBox.setBackground(Color.WHITE);
		chFMNeiInfoBox.setPreferredSize(new Dimension(18, 15));
		chFMNeiInfoBox.setEnabled(false);
		//chFMNeiInfoBox.setMinimumSize(new Dimension(15, 15));
		//chFMNeiInfoBox.setMaximumSize(new Dimension(20, 20));
		
		tfFMNeiInfoField_1 = new JTextField();
		tfFMNeiInfoField_1.setText("");
		tfFMNeiInfoField_1.setPreferredSize(new Dimension(6, 15));
		tfFMNeiInfoField_1.setEditable(false);
		tfFMNeiInfoField_1.setColumns(2);
		
		tfFMNeiInfoField_2 = new JTextField();
		tfFMNeiInfoField_2.setText("");
		tfFMNeiInfoField_2.setPreferredSize(new Dimension(6, 15));
		tfFMNeiInfoField_2.setEditable(false);
		tfFMNeiInfoField_2.setColumns(2);
		
		tfFMNeiInfoField_3 = new JTextField();
		tfFMNeiInfoField_3.setText("");
		tfFMNeiInfoField_3.setPreferredSize(new Dimension(6, 15));
		tfFMNeiInfoField_3.setEditable(false);
		tfFMNeiInfoField_3.setColumns(2);
		
		tfFMNeiInfoField_4 = new JTextField();
		tfFMNeiInfoField_4.setText("");
		tfFMNeiInfoField_4.setPreferredSize(new Dimension(6, 15));
		tfFMNeiInfoField_4.setEditable(false);
		tfFMNeiInfoField_4.setColumns(2);
		
		GroupLayout gl_lFMNeiInfoPanel = new GroupLayout(lFMNeiInfoPanel);
		gl_lFMNeiInfoPanel.setHorizontalGroup(
			gl_lFMNeiInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lFMNeiInfoPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_lFMNeiInfoPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_lFMNeiInfoPanel.createSequentialGroup()
							.addGroup(gl_lFMNeiInfoPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_lFMNeiInfoPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_lFMNeiInfoPanel.createSequentialGroup()
										.addComponent(lFMNeiInfoLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(chFMNeiInfoBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_lFMNeiInfoPanel.createSequentialGroup()
										.addComponent(lFMNeiInfoLable_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tfFMNeiInfoField_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_lFMNeiInfoPanel.createSequentialGroup()
									.addComponent(lFMNeiInfoLable_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMNeiInfoField_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
								.addComponent(lFMNeiInfoTitle))
							.addContainerGap(150, Short.MAX_VALUE))
						.addGroup(gl_lFMNeiInfoPanel.createSequentialGroup()
							.addComponent(lFMNeiInfoLable_4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfFMNeiInfoField_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_lFMNeiInfoPanel.createSequentialGroup()
							.addComponent(lFMNeiInfoLable_3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfFMNeiInfoField_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(179, Short.MAX_VALUE))))
		);
		gl_lFMNeiInfoPanel.setVerticalGroup(
			gl_lFMNeiInfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lFMNeiInfoPanel.createSequentialGroup()
					.addComponent(lFMNeiInfoTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_lFMNeiInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMNeiInfoLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(chFMNeiInfoBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_lFMNeiInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMNeiInfoLable_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMNeiInfoField_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_lFMNeiInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMNeiInfoLable_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMNeiInfoField_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_lFMNeiInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMNeiInfoLable_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMNeiInfoField_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_lFMNeiInfoPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMNeiInfoLable_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMNeiInfoField_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(61))
		);
		lFMNeiInfoPanel.setLayout(gl_lFMNeiInfoPanel);
		pFMCharInfoPanel_2.setLayout(gl_pFMCharInfoPanel_2);
	}
	
	/**	Dh	17.5.2020
	 * 
	 * 	Initialisiert die GUI-Elemente fuer den spezielen PropModPanel.
	 */
	private void initSpezPropModPanel() {
		pFMSpezModPanel_0 = new JPanel();
		pFMSpezModPanel_0.setBackground(Color.WHITE);
		
		lFMSpezPropModLable = new JLabel("Eigenschafts Mods");
		lFMSpezPropModLable.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		lFMSpezPropModLable_0 = new JLabel("Mut");
		lFMSpezPropModLable_0.setPreferredSize(new Dimension(80, 15));
		lFMSpezPropModLable_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMSpezPropModLable_1 = new JLabel("Klugheit");
		lFMSpezPropModLable_1.setPreferredSize(new Dimension(80, 15));
		lFMSpezPropModLable_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMSpezPropModLable_2 = new JLabel("Intuition");
		lFMSpezPropModLable_2.setPreferredSize(new Dimension(80, 15));
		lFMSpezPropModLable_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMSpezPropModLable_3 = new JLabel("Charisma");
		lFMSpezPropModLable_3.setPreferredSize(new Dimension(80, 15));
		lFMSpezPropModLable_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMSpezPropModLable_4 = new JLabel("Fingerfertigkeit");
		lFMSpezPropModLable_4.setPreferredSize(new Dimension(80, 15));
		lFMSpezPropModLable_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMSpezPropModLable_5 = new JLabel("Gewandtheit");
		lFMSpezPropModLable_5.setPreferredSize(new Dimension(80, 15));
		lFMSpezPropModLable_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMSpezPropModLable_6 = new JLabel("Konstitution");
		lFMSpezPropModLable_6.setPreferredSize(new Dimension(80, 15));
		lFMSpezPropModLable_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMSpezPropModLable_7 = new JLabel("K\u00F6rperkraft");
		lFMSpezPropModLable_7.setPreferredSize(new Dimension(80, 15));
		lFMSpezPropModLable_7.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMSpezPropModLable_8 = new JLabel("Geschwindigkeit");
		lFMSpezPropModLable_8.setPreferredSize(new Dimension(80, 15));
		lFMSpezPropModLable_8.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		tfFMSpezPropModField_0 = new JTextField();
		tfFMSpezPropModField_0.setText("");
		tfFMSpezPropModField_0.setPreferredSize(new Dimension(6, 15));
		tfFMSpezPropModField_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMSpezPropModField_0.setEditable(false);
		tfFMSpezPropModField_0.setColumns(2);
		
		tfFMSpezPropModField_1 = new JTextField();
		tfFMSpezPropModField_1.setText("");
		tfFMSpezPropModField_1.setPreferredSize(new Dimension(6, 15));
		tfFMSpezPropModField_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMSpezPropModField_1.setEditable(false);
		tfFMSpezPropModField_1.setColumns(2);
		
		tfFMSpezPropModField_2 = new JTextField();
		tfFMSpezPropModField_2.setText("");
		tfFMSpezPropModField_2.setPreferredSize(new Dimension(6, 15));
		tfFMSpezPropModField_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMSpezPropModField_2.setEditable(false);
		tfFMSpezPropModField_2.setColumns(2);
		
		tfFMSpezPropModField_3 = new JTextField();
		tfFMSpezPropModField_3.setText("");
		tfFMSpezPropModField_3.setPreferredSize(new Dimension(6, 15));
		tfFMSpezPropModField_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMSpezPropModField_3.setEditable(false);
		tfFMSpezPropModField_3.setColumns(2);
		
		tfFMSpezPropModField_4 = new JTextField();
		tfFMSpezPropModField_4.setText("");
		tfFMSpezPropModField_4.setPreferredSize(new Dimension(6, 15));
		tfFMSpezPropModField_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMSpezPropModField_4.setEditable(false);
		tfFMSpezPropModField_4.setColumns(2);
		
		tfFMSpezPropModField_5 = new JTextField();
		tfFMSpezPropModField_5.setText("");
		tfFMSpezPropModField_5.setPreferredSize(new Dimension(6, 15));
		tfFMSpezPropModField_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMSpezPropModField_5.setEditable(false);
		tfFMSpezPropModField_5.setColumns(2);
		
		tfFMSpezPropModField_6 = new JTextField();
		tfFMSpezPropModField_6.setText("");
		tfFMSpezPropModField_6.setPreferredSize(new Dimension(6, 15));
		tfFMSpezPropModField_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMSpezPropModField_6.setEditable(false);
		tfFMSpezPropModField_6.setColumns(2);
		
		tfFMSpezPropModField_7 = new JTextField();
		tfFMSpezPropModField_7.setText("");
		tfFMSpezPropModField_7.setPreferredSize(new Dimension(6, 15));
		tfFMSpezPropModField_7.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMSpezPropModField_7.setEditable(false);
		tfFMSpezPropModField_7.setColumns(2);
		
		tfFMSpezPropModField_8 = new JTextField();
		tfFMSpezPropModField_8.setText("");
		tfFMSpezPropModField_8.setPreferredSize(new Dimension(6, 15));
		tfFMSpezPropModField_8.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMSpezPropModField_8.setEditable(false);
		tfFMSpezPropModField_8.setColumns(2);
		
		GroupLayout gl_pFMSpezModPanel_0 = new GroupLayout(pFMSpezModPanel_0);
		gl_pFMSpezModPanel_0.setHorizontalGroup(
			gl_pFMSpezModPanel_0.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFMSpezModPanel_0.createSequentialGroup()
					.addGroup(gl_pFMSpezModPanel_0.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pFMSpezModPanel_0.createSequentialGroup()
							.addGroup(gl_pFMSpezModPanel_0.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pFMSpezModPanel_0.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_pFMSpezModPanel_0.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_pFMSpezModPanel_0.createSequentialGroup()
											.addComponent(lFMSpezPropModLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(tfFMSpezPropModField_0, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_pFMSpezModPanel_0.createSequentialGroup()
											.addComponent(lFMSpezPropModLable_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(tfFMSpezPropModField_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_pFMSpezModPanel_0.createSequentialGroup()
									.addContainerGap()
									.addComponent(lFMSpezPropModLable_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMSpezPropModField_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pFMSpezModPanel_0.createSequentialGroup()
									.addContainerGap()
									.addComponent(lFMSpezPropModLable_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMSpezPropModField_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_pFMSpezModPanel_0.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pFMSpezModPanel_0.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_pFMSpezModPanel_0.createParallelGroup(Alignment.TRAILING)
										.addComponent(lFMSpezPropModLable_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lFMSpezPropModLable_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lFMSpezPropModLable_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pFMSpezModPanel_0.createParallelGroup(Alignment.LEADING)
										.addComponent(tfFMSpezPropModField_7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfFMSpezPropModField_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfFMSpezPropModField_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_pFMSpezModPanel_0.createSequentialGroup()
									.addGap(18)
									.addComponent(lFMSpezPropModLable_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMSpezPropModField_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_pFMSpezModPanel_0.createSequentialGroup()
							.addGap(69)
							.addComponent(lFMSpezPropModLable))
						.addGroup(gl_pFMSpezModPanel_0.createSequentialGroup()
							.addGap(60)
							.addComponent(lFMSpezPropModLable_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfFMSpezPropModField_8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		gl_pFMSpezModPanel_0.setVerticalGroup(
			gl_pFMSpezModPanel_0.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFMSpezModPanel_0.createSequentialGroup()
					.addComponent(lFMSpezPropModLable)
					.addGap(11)
					.addGroup(gl_pFMSpezModPanel_0.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMSpezPropModLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMSpezPropModField_0, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lFMSpezPropModLable_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMSpezPropModField_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMSpezModPanel_0.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pFMSpezModPanel_0.createParallelGroup(Alignment.BASELINE)
							.addComponent(lFMSpezPropModLable_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfFMSpezPropModField_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pFMSpezModPanel_0.createParallelGroup(Alignment.BASELINE)
							.addComponent(lFMSpezPropModLable_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfFMSpezPropModField_5, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMSpezModPanel_0.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pFMSpezModPanel_0.createParallelGroup(Alignment.BASELINE)
							.addComponent(lFMSpezPropModLable_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfFMSpezPropModField_6, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pFMSpezModPanel_0.createParallelGroup(Alignment.BASELINE)
							.addComponent(lFMSpezPropModLable_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfFMSpezPropModField_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMSpezModPanel_0.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pFMSpezModPanel_0.createParallelGroup(Alignment.BASELINE)
							.addComponent(lFMSpezPropModLable_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lFMSpezPropModLable_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfFMSpezPropModField_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(tfFMSpezPropModField_7, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pFMSpezModPanel_0.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMSpezPropModLable_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMSpezPropModField_8, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		pFMSpezModPanel_0.setLayout(gl_pFMSpezModPanel_0);
	}
	/**	Dh	17.5.2020
	 * 
	 * 	Initialisiert die GUI-Elemente fuer den spezielen StatModPanel.
	 */
	private void initSpezStatModPanel() {
		pFMSpezModPanel_1 = new JPanel();
		pFMSpezModPanel_1.setBackground(Color.WHITE);
		
		lFMSpezStatModLable = new JLabel("Basiswert Mods");
		lFMSpezStatModLable.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		lFMSpezStatModLable.setAlignmentX(0.5f);
		
		lFMSpezStatModLable_0 = new JLabel("Lebenspunkte");
		lFMSpezStatModLable_0.setPreferredSize(new Dimension(80, 15));
		lFMSpezStatModLable_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMSpezStatModLable_1 = new JLabel("Ausdauerpunkte");
		lFMSpezStatModLable_1.setPreferredSize(new Dimension(80, 15));
		lFMSpezStatModLable_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMSpezStatModLable_2 = new JLabel("Astralpunkte");
		lFMSpezStatModLable_2.setPreferredSize(new Dimension(80, 15));
		lFMSpezStatModLable_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMSpezStatModLable_3 = new JLabel("Karmapunkte");
		lFMSpezStatModLable_3.setPreferredSize(new Dimension(80, 15));
		lFMSpezStatModLable_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMSpezStatModLable_4 = new JLabel("Magieresistenz");
		lFMSpezStatModLable_4.setPreferredSize(new Dimension(80, 15));
		lFMSpezStatModLable_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMSpezStatModLable_5 = new JLabel("Wundschwelle");
		lFMSpezStatModLable_5.setPreferredSize(new Dimension(80, 15));
		lFMSpezStatModLable_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMSpezStatModLable_6 = new JLabel("Ini-Basiswert");
		lFMSpezStatModLable_6.setPreferredSize(new Dimension(80, 15));
		lFMSpezStatModLable_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMSpezStatModLable_7 = new JLabel("At-Basiswert");
		lFMSpezStatModLable_7.setPreferredSize(new Dimension(80, 15));
		lFMSpezStatModLable_7.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMSpezStatModLable_8 = new JLabel("Pa-Pasiswert");
		lFMSpezStatModLable_8.setPreferredSize(new Dimension(80, 15));
		lFMSpezStatModLable_8.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMSpezStatModLable_9 = new JLabel("Fk-Basiswert");
		lFMSpezStatModLable_9.setPreferredSize(new Dimension(80, 15));
		lFMSpezStatModLable_9.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		tfFMSpezStatModField_0 = new JTextField();
		tfFMSpezStatModField_0.setText("");
		tfFMSpezStatModField_0.setPreferredSize(new Dimension(6, 15));
		tfFMSpezStatModField_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMSpezStatModField_0.setEditable(false);
		tfFMSpezStatModField_0.setColumns(2);
		
		tfFMSpezStatModField_1 = new JTextField();
		tfFMSpezStatModField_1.setText("");
		tfFMSpezStatModField_1.setPreferredSize(new Dimension(6, 15));
		tfFMSpezStatModField_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMSpezStatModField_1.setEditable(false);
		tfFMSpezStatModField_1.setColumns(2);
		
		tfFMSpezStatModField_2 = new JTextField();
		tfFMSpezStatModField_2.setText("");
		tfFMSpezStatModField_2.setPreferredSize(new Dimension(6, 15));
		tfFMSpezStatModField_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMSpezStatModField_2.setEditable(false);
		tfFMSpezStatModField_2.setColumns(2);
		
		tfFMSpezStatModField_3 = new JTextField();
		tfFMSpezStatModField_3.setText("");
		tfFMSpezStatModField_3.setPreferredSize(new Dimension(6, 15));
		tfFMSpezStatModField_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMSpezStatModField_3.setEditable(false);
		tfFMSpezStatModField_3.setColumns(2);
		
		tfFMSpezStatModField_4 = new JTextField();
		tfFMSpezStatModField_4.setText("");
		tfFMSpezStatModField_4.setPreferredSize(new Dimension(6, 15));
		tfFMSpezStatModField_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMSpezStatModField_4.setEditable(false);
		tfFMSpezStatModField_4.setColumns(2);
		
		tfFMSpezStatModField_5 = new JTextField();
		tfFMSpezStatModField_5.setText("");
		tfFMSpezStatModField_5.setPreferredSize(new Dimension(6, 15));
		tfFMSpezStatModField_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMSpezStatModField_5.setEditable(false);
		tfFMSpezStatModField_5.setColumns(2);
		
		tfFMSpezStatModField_6 = new JTextField();
		tfFMSpezStatModField_6.setText("");
		tfFMSpezStatModField_6.setPreferredSize(new Dimension(6, 15));
		tfFMSpezStatModField_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMSpezStatModField_6.setEditable(false);
		tfFMSpezStatModField_6.setColumns(2);
		
		tfFMSpezStatModField_7 = new JTextField();
		tfFMSpezStatModField_7.setText("");
		tfFMSpezStatModField_7.setPreferredSize(new Dimension(6, 15));
		tfFMSpezStatModField_7.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMSpezStatModField_7.setEditable(false);
		tfFMSpezStatModField_7.setColumns(2);
		
		tfFMSpezStatModField_8 = new JTextField();
		tfFMSpezStatModField_8.setText("");
		tfFMSpezStatModField_8.setPreferredSize(new Dimension(6, 15));
		tfFMSpezStatModField_8.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMSpezStatModField_8.setEditable(false);
		tfFMSpezStatModField_8.setColumns(2);
		
		tfFMSpezStatModField_9 = new JTextField();
		tfFMSpezStatModField_9.setText("");
		tfFMSpezStatModField_9.setPreferredSize(new Dimension(6, 15));
		tfFMSpezStatModField_9.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMSpezStatModField_9.setEditable(false);
		tfFMSpezStatModField_9.setColumns(2);
		
		GroupLayout gl_pFMSpezModPanel_1 = new GroupLayout(pFMSpezModPanel_1);
		gl_pFMSpezModPanel_1.setHorizontalGroup(
			gl_pFMSpezModPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFMSpezModPanel_1.createSequentialGroup()
					.addGroup(gl_pFMSpezModPanel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pFMSpezModPanel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pFMSpezModPanel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_pFMSpezModPanel_1.createSequentialGroup()
									.addGroup(gl_pFMSpezModPanel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lFMSpezStatModLable_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lFMSpezStatModLable_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lFMSpezStatModLable_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pFMSpezModPanel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(tfFMSpezStatModField_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfFMSpezStatModField_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfFMSpezStatModField_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_pFMSpezModPanel_1.createSequentialGroup()
									.addComponent(lFMSpezStatModLable_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(tfFMSpezStatModField_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_pFMSpezModPanel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pFMSpezModPanel_1.createSequentialGroup()
									.addComponent(lFMSpezStatModLable_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMSpezStatModField_9, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pFMSpezModPanel_1.createSequentialGroup()
									.addComponent(lFMSpezStatModLable_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMSpezStatModField_8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pFMSpezModPanel_1.createSequentialGroup()
									.addComponent(lFMSpezStatModLable_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMSpezStatModField_7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pFMSpezModPanel_1.createSequentialGroup()
									.addComponent(lFMSpezStatModLable_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMSpezStatModField_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_pFMSpezModPanel_1.createSequentialGroup()
							.addGap(79)
							.addComponent(lFMSpezStatModLable))
						.addGroup(gl_pFMSpezModPanel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lFMSpezStatModLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfFMSpezStatModField_0, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lFMSpezStatModLable_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfFMSpezStatModField_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_pFMSpezModPanel_1.setVerticalGroup(
			gl_pFMSpezModPanel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pFMSpezModPanel_1.createSequentialGroup()
					.addComponent(lFMSpezStatModLable, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMSpezModPanel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMSpezStatModLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMSpezStatModField_0, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lFMSpezStatModLable_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMSpezStatModField_6, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_pFMSpezModPanel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfFMSpezStatModField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lFMSpezStatModLable_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMSpezStatModField_7, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lFMSpezStatModLable_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addGroup(gl_pFMSpezModPanel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMSpezStatModLable_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMSpezStatModField_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lFMSpezStatModLable_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMSpezStatModField_8, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMSpezModPanel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMSpezStatModLable_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMSpezStatModField_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lFMSpezStatModLable_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMSpezStatModField_9, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_pFMSpezModPanel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pFMSpezModPanel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lFMSpezStatModLable_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfFMSpezStatModField_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pFMSpezModPanel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lFMSpezStatModLable_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfFMSpezStatModField_5, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
					.addGap(35))
		);
		pFMSpezModPanel_1.setLayout(gl_pFMSpezModPanel_1);
	}
	
	/**	Dh	17.5.2020
	 * 
	 * 	Initiiert die GUI-Elemente des allgemeinen PropMod Panels.
	 */
	private void initGenPropModPanel() {
		pFMGenModPanel_0 = new JPanel();
		pFMGenModPanel_0.setBackground(Color.WHITE);
		
		lFMGenPropModTitle = new JLabel("Eigenschafts Mods");
		lFMGenPropModTitle.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		lFMGenPropModLabel_0 = new JLabel("Mut");
		lFMGenPropModLabel_0.setPreferredSize(new Dimension(80, 15));
		lFMGenPropModLabel_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMGenPropModLabel_1 = new JLabel("Klugheit");
		lFMGenPropModLabel_1.setPreferredSize(new Dimension(80, 15));
		lFMGenPropModLabel_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMGenPropModLabel_2 = new JLabel("Intuition");
		lFMGenPropModLabel_2.setPreferredSize(new Dimension(80, 15));
		lFMGenPropModLabel_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMGenPropModLabel_3 = new JLabel("Charisma");
		lFMGenPropModLabel_3.setPreferredSize(new Dimension(80, 15));
		lFMGenPropModLabel_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMGenPropModLabel_4 = new JLabel("Fingerfertigkeit");
		lFMGenPropModLabel_4.setPreferredSize(new Dimension(80, 15));
		lFMGenPropModLabel_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMGenPropModLabel_5 = new JLabel("Gewandtheit");
		lFMGenPropModLabel_5.setPreferredSize(new Dimension(80, 15));
		lFMGenPropModLabel_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMGenPropModLabel_6 = new JLabel("Konstitution");
		lFMGenPropModLabel_6.setPreferredSize(new Dimension(80, 15));
		lFMGenPropModLabel_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMGenPropModLabel_7 = new JLabel("K\u00F6rperkraft");
		lFMGenPropModLabel_7.setPreferredSize(new Dimension(80, 15));
		lFMGenPropModLabel_7.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMGenPropModLabel_8 = new JLabel("Geschwindigkeit");
		lFMGenPropModLabel_8.setPreferredSize(new Dimension(80, 15));
		lFMGenPropModLabel_8.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		tfFMGenPropModField_0 = new JTextField("0");
		tfFMGenPropModField_0.setPreferredSize(new Dimension(6, 15));
		tfFMGenPropModField_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMGenPropModField_0.setEditable(false);
		tfFMGenPropModField_0.setColumns(2);
		
		tfFMGenPropModField_1 = new JTextField("0");
		tfFMGenPropModField_1.setPreferredSize(new Dimension(6, 15));
		tfFMGenPropModField_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMGenPropModField_1.setEditable(false);
		tfFMGenPropModField_1.setColumns(2);
		
		tfFMGenPropModField_2 = new JTextField("0");
		tfFMGenPropModField_2.setPreferredSize(new Dimension(6, 15));
		tfFMGenPropModField_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMGenPropModField_2.setEditable(false);
		tfFMGenPropModField_2.setColumns(2);
		
		tfFMGenPropModField_3 = new JTextField("0");
		tfFMGenPropModField_3.setPreferredSize(new Dimension(6, 15));
		tfFMGenPropModField_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMGenPropModField_3.setEditable(false);
		tfFMGenPropModField_3.setColumns(2);
		
		tfFMGenPropModField_4 = new JTextField("0");
		tfFMGenPropModField_4.setPreferredSize(new Dimension(6, 15));
		tfFMGenPropModField_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMGenPropModField_4.setEditable(false);
		tfFMGenPropModField_4.setColumns(2);
		
		tfFMGenPropModField_5 = new JTextField("0");
		tfFMGenPropModField_5.setPreferredSize(new Dimension(6, 15));
		tfFMGenPropModField_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMGenPropModField_5.setEditable(false);
		tfFMGenPropModField_5.setColumns(2);
		
		tfFMGenPropModField_6 = new JTextField("0");
		tfFMGenPropModField_6.setPreferredSize(new Dimension(6, 15));
		tfFMGenPropModField_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMGenPropModField_6.setEditable(false);
		tfFMGenPropModField_6.setColumns(2);
		
		tfFMGenPropModField_7 = new JTextField("0");
		tfFMGenPropModField_7.setPreferredSize(new Dimension(6, 15));
		tfFMGenPropModField_7.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMGenPropModField_7.setEditable(false);
		tfFMGenPropModField_7.setColumns(2);
		
		tfFMGenPropModField_8 = new JTextField("0");
		tfFMGenPropModField_8.setPreferredSize(new Dimension(6, 15));
		tfFMGenPropModField_8.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMGenPropModField_8.setEditable(false);
		tfFMGenPropModField_8.setColumns(2);
		
		GroupLayout gl_pFMGenModPanel_0 = new GroupLayout(pFMGenModPanel_0);
		gl_pFMGenModPanel_0.setHorizontalGroup(
			gl_pFMGenModPanel_0.createParallelGroup(Alignment.LEADING)
				.addGap(0, 270, Short.MAX_VALUE)
				.addGroup(gl_pFMGenModPanel_0.createSequentialGroup()
					.addGroup(gl_pFMGenModPanel_0.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pFMGenModPanel_0.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pFMGenModPanel_0.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pFMGenModPanel_0.createSequentialGroup()
									.addComponent(lFMGenPropModLabel_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMGenPropModField_0, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pFMGenModPanel_0.createSequentialGroup()
									.addComponent(lFMGenPropModLabel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMGenPropModField_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pFMGenModPanel_0.createSequentialGroup()
									.addComponent(lFMGenPropModLabel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMGenPropModField_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pFMGenModPanel_0.createSequentialGroup()
									.addComponent(lFMGenPropModLabel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMGenPropModField_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_pFMGenModPanel_0.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pFMGenModPanel_0.createSequentialGroup()
									.addGroup(gl_pFMGenModPanel_0.createParallelGroup(Alignment.TRAILING)
										.addComponent(lFMGenPropModLabel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lFMGenPropModLabel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lFMGenPropModLabel_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pFMGenModPanel_0.createParallelGroup(Alignment.LEADING)
										.addComponent(tfFMGenPropModField_7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfFMGenPropModField_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfFMGenPropModField_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_pFMGenModPanel_0.createSequentialGroup()
									.addComponent(lFMGenPropModLabel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMGenPropModField_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_pFMGenModPanel_0.createSequentialGroup()
							.addGap(69)
							.addComponent(lFMGenPropModTitle))
						.addGroup(gl_pFMGenModPanel_0.createSequentialGroup()
							.addGap(60)
							.addComponent(lFMGenPropModLabel_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfFMGenPropModField_8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_pFMGenModPanel_0.setVerticalGroup(
			gl_pFMGenModPanel_0.createParallelGroup(Alignment.LEADING)
				.addGap(0, 157, Short.MAX_VALUE)
				.addGroup(gl_pFMGenModPanel_0.createSequentialGroup()
					.addComponent(lFMGenPropModTitle)
					.addGap(11)
					.addGroup(gl_pFMGenModPanel_0.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMGenPropModLabel_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMGenPropModField_0, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lFMGenPropModLabel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMGenPropModField_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMGenModPanel_0.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pFMGenModPanel_0.createParallelGroup(Alignment.BASELINE)
							.addComponent(lFMGenPropModLabel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfFMGenPropModField_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pFMGenModPanel_0.createParallelGroup(Alignment.BASELINE)
							.addComponent(lFMGenPropModLabel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfFMGenPropModField_5, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMGenModPanel_0.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pFMGenModPanel_0.createParallelGroup(Alignment.BASELINE)
							.addComponent(lFMGenPropModLabel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfFMGenPropModField_6, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pFMGenModPanel_0.createParallelGroup(Alignment.BASELINE)
							.addComponent(lFMGenPropModLabel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfFMGenPropModField_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMGenModPanel_0.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pFMGenModPanel_0.createParallelGroup(Alignment.BASELINE)
							.addComponent(lFMGenPropModLabel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lFMGenPropModLabel_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfFMGenPropModField_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(tfFMGenPropModField_7, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pFMGenModPanel_0.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMGenPropModLabel_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMGenPropModField_8, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pFMGenModPanel_0.setLayout(gl_pFMGenModPanel_0);
	}
	/**	Dh	17.5.2020
	 * 
	 * 	Initiiert die GUI-Elemente des allgemeinen StatMod Panels.
	 */
	private void initGenStatModPanel() {
		pFMGenModPanel_1 = new JPanel();
		pFMGenModPanel_1.setBackground(Color.WHITE);
		
		lFMGenStatModTitle = new JLabel("Basiswert Mods");
		lFMGenStatModTitle.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		lFMGenStatModTitle.setAlignmentX(0.5f);
		
		lFMGenStatModLabel_0 = new JLabel("Lebenspunkte");
		lFMGenStatModLabel_0.setPreferredSize(new Dimension(80, 15));
		lFMGenStatModLabel_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMGenStatModLabel_1 = new JLabel("Ausdauerpunkte");
		lFMGenStatModLabel_1.setPreferredSize(new Dimension(80, 15));
		lFMGenStatModLabel_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMGenStatModLabel_2 = new JLabel("Astralpunkte");
		lFMGenStatModLabel_2.setPreferredSize(new Dimension(80, 15));
		lFMGenStatModLabel_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMGenStatModLabel_3 = new JLabel("Karmapunkte");
		lFMGenStatModLabel_3.setPreferredSize(new Dimension(80, 15));
		lFMGenStatModLabel_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMGenStatModLabel_4 = new JLabel("Magieresistenz");
		lFMGenStatModLabel_4.setPreferredSize(new Dimension(80, 15));
		lFMGenStatModLabel_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMGenStatModLabel_5 = new JLabel("Wundschwelle");
		lFMGenStatModLabel_5.setPreferredSize(new Dimension(80, 15));
		lFMGenStatModLabel_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMGenStatModLabel_6 = new JLabel("Ini-Basiswert");
		lFMGenStatModLabel_6.setPreferredSize(new Dimension(80, 15));
		lFMGenStatModLabel_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMGenStatModLabel_7 = new JLabel("At-Basiswert");
		lFMGenStatModLabel_7.setPreferredSize(new Dimension(80, 15));
		lFMGenStatModLabel_7.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMGenStatModLabel_8 = new JLabel("Pa-Pasiswert");
		lFMGenStatModLabel_8.setPreferredSize(new Dimension(80, 15));
		lFMGenStatModLabel_8.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lFMGenStatModLabel_9 = new JLabel("Fk-Basiswert");
		lFMGenStatModLabel_9.setPreferredSize(new Dimension(80, 15));
		lFMGenStatModLabel_9.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		tfFMGenStatModField_0 = new JTextField("0");
		tfFMGenStatModField_0.setPreferredSize(new Dimension(6, 15));
		tfFMGenStatModField_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMGenStatModField_0.setEditable(false);
		tfFMGenStatModField_0.setColumns(2);
		
		tfFMGenStatModField_1 = new JTextField("0");
		tfFMGenStatModField_1.setPreferredSize(new Dimension(6, 15));
		tfFMGenStatModField_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMGenStatModField_1.setEditable(false);
		tfFMGenStatModField_1.setColumns(2);
		
		tfFMGenStatModField_2 = new JTextField("0");
		tfFMGenStatModField_2.setPreferredSize(new Dimension(6, 15));
		tfFMGenStatModField_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMGenStatModField_2.setEditable(false);
		tfFMGenStatModField_2.setColumns(2);
		
		tfFMGenStatModField_3 = new JTextField("0");
		tfFMGenStatModField_3.setPreferredSize(new Dimension(6, 15));
		tfFMGenStatModField_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMGenStatModField_3.setEditable(false);
		tfFMGenStatModField_3.setColumns(2);
		
		tfFMGenStatModField_4 = new JTextField("0");
		tfFMGenStatModField_4.setPreferredSize(new Dimension(6, 15));
		tfFMGenStatModField_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMGenStatModField_4.setEditable(false);
		tfFMGenStatModField_4.setColumns(2);
		
		tfFMGenStatModField_5 = new JTextField("0");
		tfFMGenStatModField_5.setPreferredSize(new Dimension(6, 15));
		tfFMGenStatModField_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMGenStatModField_5.setEditable(false);
		tfFMGenStatModField_5.setColumns(2);
		
		tfFMGenStatModField_6 = new JTextField("0");
		tfFMGenStatModField_6.setPreferredSize(new Dimension(6, 15));
		tfFMGenStatModField_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMGenStatModField_6.setEditable(false);
		tfFMGenStatModField_6.setColumns(2);
		
		tfFMGenStatModField_7 = new JTextField("0");
		tfFMGenStatModField_7.setPreferredSize(new Dimension(6, 15));
		tfFMGenStatModField_7.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMGenStatModField_7.setEditable(false);
		tfFMGenStatModField_7.setColumns(2);
		
		tfFMGenStatModField_8 = new JTextField("0");
		tfFMGenStatModField_8.setPreferredSize(new Dimension(6, 15));
		tfFMGenStatModField_8.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMGenStatModField_8.setEditable(false);
		tfFMGenStatModField_8.setColumns(2);
		
		tfFMGenStatModField_9 = new JTextField("0");
		tfFMGenStatModField_9.setPreferredSize(new Dimension(6, 15));
		tfFMGenStatModField_9.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfFMGenStatModField_9.setEditable(false);
		tfFMGenStatModField_9.setColumns(2);
		
		GroupLayout gl_pFMGenModPanel_1 = new GroupLayout(pFMGenModPanel_1);
		gl_pFMGenModPanel_1.setHorizontalGroup(
			gl_pFMGenModPanel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 270, Short.MAX_VALUE)
				.addGroup(gl_pFMGenModPanel_1.createSequentialGroup()
					.addGroup(gl_pFMGenModPanel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pFMGenModPanel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pFMGenModPanel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_pFMGenModPanel_1.createSequentialGroup()
									.addGroup(gl_pFMGenModPanel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(lFMGenStatModLabel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lFMGenStatModLabel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lFMGenStatModLabel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pFMGenModPanel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(tfFMGenStatModField_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfFMGenStatModField_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfFMGenStatModField_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_pFMGenModPanel_1.createSequentialGroup()
									.addComponent(lFMGenStatModLabel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(tfFMGenStatModField_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_pFMGenModPanel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pFMGenModPanel_1.createSequentialGroup()
									.addComponent(lFMGenStatModLabel_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMGenStatModField_9, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pFMGenModPanel_1.createSequentialGroup()
									.addComponent(lFMGenStatModLabel_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMGenStatModField_8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pFMGenModPanel_1.createSequentialGroup()
									.addComponent(lFMGenStatModLabel_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMGenStatModField_7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pFMGenModPanel_1.createSequentialGroup()
									.addComponent(lFMGenStatModLabel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMGenStatModField_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_pFMGenModPanel_1.createSequentialGroup()
							.addGap(79)
							.addComponent(lFMGenStatModTitle))
						.addGroup(gl_pFMGenModPanel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lFMGenStatModLabel_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfFMGenStatModField_0, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lFMGenStatModLabel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfFMGenStatModField_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_pFMGenModPanel_1.setVerticalGroup(
			gl_pFMGenModPanel_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 144, Short.MAX_VALUE)
				.addGroup(gl_pFMGenModPanel_1.createSequentialGroup()
					.addComponent(lFMGenStatModTitle, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMGenModPanel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMGenStatModLabel_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMGenStatModField_0, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lFMGenStatModLabel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMGenStatModField_6, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_pFMGenModPanel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfFMGenStatModField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lFMGenStatModLabel_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMGenStatModField_7, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lFMGenStatModLabel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_pFMGenModPanel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMGenStatModLabel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMGenStatModField_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lFMGenStatModLabel_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMGenStatModField_8, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFMGenModPanel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMGenStatModLabel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMGenStatModField_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lFMGenStatModLabel_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMGenStatModField_9, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pFMGenModPanel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lFMGenStatModLabel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMGenStatModField_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lFMGenStatModLabel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFMGenStatModField_5, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(29))
		);
		pFMGenModPanel_1.setLayout(gl_pFMGenModPanel_1);
	}
	
	private void initCharPanle() {
		pFMCharPanel = new JPanel();
		pFMCharPanel.setBackground(Color.WHITE);
		pFMCharPanel.setBounds(480, 200, 125, 140);
		pFMPanel_0.add(pFMCharPanel);
		
		lFMCharName = new JLabel("Name");
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
		//lFMCharLable_3.setVisible(false);
		
		pbFMCharBar_0 = new JProgressBar();
		pbFMCharBar_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
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
		
		lFMCharButton = new JButton("Angreifen");
		lFMCharButton.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		//tfFMCharField_3.setVisible(false);
		
		GroupLayout gl_pFMCharPanel = new GroupLayout(pFMCharPanel);
		gl_pFMCharPanel.setHorizontalGroup(
			gl_pFMCharPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFMCharPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pFMCharPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_pFMCharPanel.createSequentialGroup()
							.addGroup(gl_pFMCharPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_pFMCharPanel.createSequentialGroup()
									.addComponent(lFMCharLable_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(pbFMCharBar_1, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
								.addGroup(gl_pFMCharPanel.createSequentialGroup()
									.addComponent(lFMCharLable_0, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pFMCharPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lFMCharName)
										.addComponent(pbFMCharBar_0, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))))
							.addGap(47))
						.addGroup(gl_pFMCharPanel.createSequentialGroup()
							.addGroup(gl_pFMCharPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lFMCharButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_pFMCharPanel.createSequentialGroup()
									.addComponent(lFMCharLable_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(pbFMCharBar_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, gl_pFMCharPanel.createSequentialGroup()
									.addComponent(lFMCharLable_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(pbFMCharBar_2, GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)))
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lFMCharButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pFMCharPanel.setLayout(gl_pFMCharPanel);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	17.5.2020
	 * 
	 * 	Addiert allgemeine Prop Mods zu den bestehenden.
	 * 
	 * @param pGenPropMods
	 * @throws Exception
	 */
	protected void addGenPropMods(int[] pGenPropMods) throws Exception {
		if(pGenPropMods != null) {
			if (pGenPropMods.length == 10) {
				for (int i=0; i<pGenPropMods.length; i++) {
					zGenPropMods[i] = zGenPropMods[i] + pGenPropMods[i];
				}
			} else throw new Exception("01; MaFra,aGPM");
		}else throw new Exception("04; MaFra,aGPM");
	}
	/**	Dh	17.5.2020
	 * 
	 * 	Addiert allgemeine Stat Mods zu den bestehenden.
	 * 
	 * @param pGenStatMods
	 * @throws Exception
	 */
	protected void addGenStatMods(double[] pGenStatMods) throws Exception {
		if(pGenStatMods != null) {
			if (pGenStatMods.length == 10) {
				for (int i=0; i<pGenStatMods.length; i++) {
					zGenStatMods[i] = zGenStatMods[i] + pGenStatMods[i];
				}
			} else throw new Exception("01; MaFra,aGSM");
		}else throw new Exception("04; MaFra,aGSM");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	20.5.2020
	 * 	
	 * 	Ueberfuehrt die gegebener FighterList in das angegebene ListModel.
	 * 
	 * @param pJLM
	 * @param pList
	 * @throws Exception
	 */
	private void addListToModel(JListModel pJLM, List pList) throws Exception {
		Object vListEle;
		int vID, vIni;
		String vText;
		FightElement vFiEle;
		
		if (!pList.isEmpty()) {
			if (pJLM != null) {
				pList.toFirst();
				
				while(!pList.isEnd()) {
					vListEle = pList.getCurrent();
					
					if (vListEle instanceof FightElement) pJLM.addElement(((FightElement)vListEle).getCharacter().getName(), ((FightElement)vListEle).getID());
					else if (vListEle instanceof int[]) {
						vFiEle = rFM.getFightElement(((int[])vListEle)[0]);
						if (vFiEle != null) {
							vIni = (int)((int[])vListEle)[1];
							if (vIni >= 10)	pJLM.addElement(vIni+"    "+vFiEle.getCharacter().getName(), ((int[])vListEle)[0]);
							else pJLM.addElement("  "+vIni+"    "+vFiEle.getCharacter().getName(), ((int[])vListEle)[0]);
						}
						else throw new Exception("04; MaFra, aLtM");
					} else if (vListEle instanceof IniElement) {
						vFiEle = rFM.getFightElement(((IniElement)vListEle).getID());
						if (vFiEle != null) pJLM.addElement(vFiEle.getCharacter().getName(), ((IniElement)vListEle).getID());
						else throw new Exception("04; MaFra, aLtM");
					} else if (vListEle instanceof NeighbourElement) {
						vFiEle = rFM.getFightElement(((NeighbourElement)vListEle).getID());
						if (vFiEle != null) pJLM.addElement(vFiEle.getCharacter().getName(), ((NeighbourElement)vListEle).getID());
						else throw new Exception("04; MaFra, aLtM");
					} else throw new Exception("06; MaFra, aLtM");
					
					pList.next();
				}
			}else throw new Exception("04; MaFra, aLtM");
		}//else throw new Exception("05; MaFra, aLtM");
	}
	
	/**	Dh	17.5.2020
	 * 
	 * 	Setzt alle GUI Elemente, die von der Auswahl der FightList abhaengen. 
	 * 
	 * @param pEnable
	 */
	private void setFightListSelectionObjectsEnable(boolean pEnable) {
		btFMSpezModButton_0.setEnabled(pEnable);
		btFMSpezModButton_2.setEnabled(pEnable);
	}
	/**	Dh	20.5.2020
	 * 	
	 * 	Setzt alle GUI Elemente, die das Mod Frame oeffnen. 
	 * 
	 * @param pEnable
	 */
	private void setModFrameObjectsEnable(boolean pEnable) {
		if ((liFMFightList.getSelectedIndex() != -1)) {
			btFMSpezModButton_0.setEnabled(pEnable);
			btFMSpezModButton_2.setEnabled(pEnable);
		}else if (pEnable == false) {
			btFMSpezModButton_0.setEnabled(pEnable);
			btFMSpezModButton_2.setEnabled(pEnable);
		}
			
		btFMGenModButton_0.setEnabled(pEnable);
		btFMGenModButton_2.setEnabled(pEnable);
	}
	/**	Dh	22.5.2020
	 * 
	 * 	Setzt alle GUI-Elemente die zur Modifikation der Neighbor Details gehören.
	 * 
	 * @param pEnable
	 */
	private void setNeiModPanelObjectsEnable(boolean pEnable) {
		if ((pEnable == false) || ((liFMFightList.getSelectedIndex() != -1) && (liFMNeiList.getSelectedIndex() != -1))) {
			btFMNeiButton_0.setEnabled(pEnable);
			btFMNeiButton_2.setEnabled(pEnable);
		}
	}
	/**	Dh	20.5.2020
	 * 
	 * 	Setzt alle GUI Elemente, die zum NeighbourPanel gehören.. 
	 * 
	 * @param pEnable
	 */
	private void setNeiPanelObjectsEnable(boolean pEnable) {
		if ((liFMFightList.getSelectedIndex() != -1) || (pEnable == false)) {
			setNeiModPanelObjectsEnable(pEnable);
			btFMNeiButton_1.setEnabled(pEnable);
			if ((rNeiListModel.getSize() >= 1) || (pEnable == false)) btFMNeiButton_3.setEnabled(pEnable);
			else btFMNeiButton_3.setEnabled(false);
		}
	}
	/**	Dh	4.6.2020
	 * 
	 * @param pEnable
	 */
	private void setCharFieldObjectsEnable(boolean pEnable) {
		if ((liFMIniList.getSelectedIndex() != -1) || (pEnable == false)) {
			for (int i=0; i<aCharPanelArray.length; i++) {
				if (aCharPanelArray[i] != null) aCharPanelArray[i].setButtonEnable(pEnable);
			}
			
			btCharFieldButton_0.setEnabled(pEnable);
		}
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	11.5.2020
	 * 
	 * 	Updated die Kämpfenden Liste der GUI.
	 */
	private void updateFightList() {
		int vID, vTempID, vInd;
		vInd = liFMFightList.getSelectedIndex();
		if (vInd != -1) vID = (int)((JListModelElement)rListModel1.get(vInd)).getObject();
		else vID = -1;
		
		rListModel1.removeAllElements();
		try {addListToModel(rListModel1, rFM.getFightList());}
		catch(Exception ex) {handleException(ex);}
		
		if (vInd != -1) {
			for (int i=0; i<rListModel1.getSize(); i++) {
				vTempID = (int)((JListModelElement)rListModel1.get(i)).getObject();
				
				if (vID == vTempID) {
					liFMFightList.setSelectedIndex(i);
					i = rListModel1.getSize();
				}
			}
		}
	}
	/**	Dh	3.6.2020
	 * 
	 * 	Updated die Ini Liste der GUI.
	 * 
	 */
	private void updateIniList() {
		rListModel2.removeAllElements();
		try {
			addListToModel(rListModel2, rFM.getIniOrder());
			if (rListModel2.size() >= 1) {
				liFMIniList.setSelectedIndex(0);
				//updateCharaField();
				liFMIniList.validate();
			}
		}catch(Exception ex) {handleException(ex);}
	}
	/**	Dh	20.5.2020
	 * 
	 * 	Updated die NeighbourList.
	 */
	private void updateNeighbourList() {
		int vFightID, vID, vTempID, vInd, vFightInd;
		vInd = liFMNeiList.getSelectedIndex();
		vFightInd = liFMFightList.getSelectedIndex();
		if (vInd != -1) vID = (int)((JListModelElement)rNeiListModel.get(vInd)).getObject();
		else vID = -1;
		
		if (vFightInd != -1) {
			vFightID = (int) ((JListModelElement)rListModel1.get(vFightInd)).getObject();
			
			rNeiListModel.removeAllElements();
			try {addListToModel(rNeiListModel, rFM.getNeighbourListOfFighter(vFightID));}
			catch(Exception ex) {handleException(ex);}
			
			if (vInd != -1) {
				for (int i=0; i<rNeiListModel.getSize(); i++) {
					vTempID = (int)((JListModelElement)rNeiListModel.get(i)).getObject();
					
					if (vID == vTempID) {
						liFMNeiList.setSelectedIndex(i);
						i = rNeiListModel.getSize();
					}
				}
			}
		}else rNeiListModel.removeAllElements();
		
		updateSelectedNeighbour();
		updateCharaField();
	}
	
	/**	Dh	11.5.2020
	 * 
	 * 	Updated alle Listen der GUI.
	 */
	private void updateLists() {
		updateFightList();
		updateIniList();
		updateNeighbourList();
	}
	
	/**	Dh	20.5.2020
	 * 
	 * 	Updated die GUI-Elemente zur Anzeige der Kampfnachber*Innen Infos.
	 */
	private void updateSelectedNeighbour() {
		int vFiID, vNeiID, vTempValue, vMaxValue, vInd;
		vInd = liFMNeiList.getSelectedIndex();
		if (vInd != -1) {
			vFiID = (int)((JListModelElement)rListModel1.get(liFMFightList.getSelectedIndex())).getObject();
			JListModelElement vCurEle = (JListModelElement)rNeiListModel.get(vInd);
			vNeiID = (int)vCurEle.getObject();
			
			try {
				chFMNeiInfoBox.setSelected(!rFM.getEnemyTypeOfNeighbourOfFighter(vFiID, vNeiID));
				
				tfFMNeiInfoField_1.setText(""+rFM.getDistanceOfNeighbourOfFighter(vFiID, vNeiID));
				tfFMNeiInfoField_2.setText(""+(int)rFM.getFightModOfNeighbourOfFighter(vFiID, vNeiID, 1));
				tfFMNeiInfoField_3.setText(""+(int)rFM.getFightModOfNeighbourOfFighter(vFiID, vNeiID, 2));
				tfFMNeiInfoField_4.setText(""+(int)rFM.getFightModOfNeighbourOfFighter(vFiID, vNeiID, 3));
			} catch (Exception ex) {handleException(ex);}
		
			setNeiModPanelObjectsEnable(true);
		} else {
			chFMNeiInfoBox.setSelected(false);
			
			tfFMNeiInfoField_1.setText("");
			tfFMNeiInfoField_2.setText("");
			tfFMNeiInfoField_3.setText("");
			tfFMNeiInfoField_4.setText("");
			
			setNeiModPanelObjectsEnable(false);
		}
	}
	/**	Dh	17.5.2020
	 * 
	 * 	Updated die GUI-Elemente zur Anzeige von Informationen der zur Zeit ausgewaehlten Kaempfer*In. 
	 * 
	 */
	private void updateSelectedFighter() {
		int vTempValue, vMaxValue, vInd;
		vInd = liFMFightList.getSelectedIndex();
		if (vInd != -1) {
			JListModelElement vCurEle = (JListModelElement)rListModel1.get(vInd);
			int vID = (int)vCurEle.getObject();
			
			try {			
				lFMCharInfoTitle.setText(rFM.getCharacterOfFighter(vID).getName());
			
				vTempValue = rFM.getCharacterOfFighter(vID).getStat(0);
				vMaxValue = rFM.getCharacterOfFighter(vID).getMaxStat(0);
				tfOverviewField_0.setText(vTempValue + "/" + vMaxValue);
			
				vTempValue = rFM.getCharacterOfFighter(vID).getStat(1);
				vMaxValue = rFM.getCharacterOfFighter(vID).getMaxStat(1);
				tfOverviewField_1.setText(vTempValue + "/" + vMaxValue);
			
				vTempValue = rFM.getCharacterOfFighter(vID).getStat(2);
				vMaxValue = rFM.getCharacterOfFighter(vID).getMaxStat(2);
				tfOverviewField_2.setText(vTempValue + "/" + vMaxValue);
			
				vTempValue = rFM.getCharacterOfFighter(vID).getStat(3);
				vMaxValue = rFM.getCharacterOfFighter(vID).getMaxStat(3);
				tfOverviewField_3.setText(vTempValue + "/" + vMaxValue);
			
				tfFMSpezPropModField_0.setText(""+rFM.getPropModOfFighter(vID, 0));
				tfFMSpezPropModField_1.setText(""+rFM.getPropModOfFighter(vID, 1));
				tfFMSpezPropModField_2.setText(""+rFM.getPropModOfFighter(vID, 2));
				tfFMSpezPropModField_3.setText(""+rFM.getPropModOfFighter(vID, 3));
				tfFMSpezPropModField_4.setText(""+rFM.getPropModOfFighter(vID, 4));
				tfFMSpezPropModField_5.setText(""+rFM.getPropModOfFighter(vID, 5));
				tfFMSpezPropModField_6.setText(""+rFM.getPropModOfFighter(vID, 6));
				tfFMSpezPropModField_7.setText(""+rFM.getPropModOfFighter(vID, 7));
				tfFMSpezPropModField_8.setText(""+rFM.getPropModOfFighter(vID, 8));
				
				tfFMSpezStatModField_0.setText(""+((int)rFM.getStatModOfFighter(vID, 0)));
				tfFMSpezStatModField_1.setText(""+((int)rFM.getStatModOfFighter(vID, 1)));
				tfFMSpezStatModField_2.setText(""+((int)rFM.getStatModOfFighter(vID, 2)));
				tfFMSpezStatModField_3.setText(""+((int)rFM.getStatModOfFighter(vID, 3)));
				tfFMSpezStatModField_4.setText(""+((int)rFM.getStatModOfFighter(vID, 4)));
				tfFMSpezStatModField_5.setText(""+((int)rFM.getStatModOfFighter(vID, 5)));
				tfFMSpezStatModField_6.setText(""+((int)rFM.getStatModOfFighter(vID, 6)));
				tfFMSpezStatModField_7.setText(""+((int)rFM.getStatModOfFighter(vID, 7)));
				tfFMSpezStatModField_8.setText(""+((int)rFM.getStatModOfFighter(vID, 8)));
				tfFMSpezStatModField_9.setText(""+((int)rFM.getStatModOfFighter(vID, 9)));
			} catch (Exception ex) {handleException(ex);}
		
			setFightListSelectionObjectsEnable(true);
			setNeiPanelObjectsEnable(true);
		} else {
			lFMCharInfoTitle.setText("Name");
			
			tfOverviewField_0.setText("");
			tfOverviewField_1.setText("");
			tfOverviewField_2.setText("");
			tfOverviewField_3.setText("");
		
			tfFMSpezPropModField_0.setText("");
			tfFMSpezPropModField_1.setText("");
			tfFMSpezPropModField_2.setText("");
			tfFMSpezPropModField_3.setText("");
			tfFMSpezPropModField_4.setText("");
			tfFMSpezPropModField_5.setText("");
			tfFMSpezPropModField_6.setText("");
			tfFMSpezPropModField_7.setText("");
			tfFMSpezPropModField_8.setText("");
			
			tfFMSpezStatModField_0.setText("");
			tfFMSpezStatModField_1.setText("");
			tfFMSpezStatModField_2.setText("");
			tfFMSpezStatModField_3.setText("");
			tfFMSpezStatModField_4.setText("");
			tfFMSpezStatModField_5.setText("");
			tfFMSpezStatModField_6.setText("");
			tfFMSpezStatModField_7.setText("");
			tfFMSpezStatModField_8.setText("");
			tfFMSpezStatModField_9.setText("");
			
			setFightListSelectionObjectsEnable(false);
			setNeiPanelObjectsEnable(false);
		}
		updateNeighbourList();
	}
	/**	Dh	17.5.2020
	 * 
	 * 	Updatet die allgemeinen Mod GUI-Elemente.
	 */
	private void updateGenModFields() {
		tfFMGenPropModField_0.setText(""+zGenPropMods[0]);
		tfFMGenPropModField_1.setText(""+zGenPropMods[1]);
		tfFMGenPropModField_2.setText(""+zGenPropMods[2]);
		tfFMGenPropModField_3.setText(""+zGenPropMods[3]);
		tfFMGenPropModField_4.setText(""+zGenPropMods[4]);
		tfFMGenPropModField_5.setText(""+zGenPropMods[5]);
		tfFMGenPropModField_6.setText(""+zGenPropMods[6]);
		tfFMGenPropModField_7.setText(""+zGenPropMods[7]);
		tfFMGenPropModField_8.setText(""+zGenPropMods[8]);
		
		tfFMGenStatModField_0.setText(""+(int)zGenStatMods[0]);
		tfFMGenStatModField_1.setText(""+(int)zGenStatMods[1]);
		tfFMGenStatModField_2.setText(""+(int)zGenStatMods[2]);
		tfFMGenStatModField_3.setText(""+(int)zGenStatMods[3]);
		tfFMGenStatModField_4.setText(""+(int)zGenStatMods[4]);
		tfFMGenStatModField_5.setText(""+(int)zGenStatMods[5]);
		tfFMGenStatModField_6.setText(""+(int)zGenStatMods[6]);
		tfFMGenStatModField_7.setText(""+(int)zGenStatMods[7]);
		tfFMGenStatModField_8.setText(""+(int)zGenStatMods[8]);
		tfFMGenStatModField_9.setText(""+(int)zGenStatMods[9]);
	}
	
	/**	Dh	26.5.2020
	 * 
	 * 	Updatet die angezeigten Kaempfer*Innen.
	 */
	private void updateCharaField() {
		boolean vCurType;
		int vID, vCurID, vInd, i;
		List vNeiList;
		CharakterPanel vCur;
		
		vInd = liFMIniList.getSelectedIndex();
		if (vInd != -1) {
	
			for (int u=0; u < aCharPanelArray.length; u++) {
				if(aCharPanelArray[u] != null) {
					aCharPanelArray[u].removePanel();
					pFMPanel_0.remove(aCharPanelArray[u].getPanel());
					aCharPanelArray[u] = null;
				}
			}
			
			vID = (int)rListModel2.getObjectAt(vInd);
			aCharPanelArray = new CharakterPanel[9];
			
			try {
				aCharPanelArray[0] = new CharakterPanel(rFM.getCharacterOfFighter(vID).getName(), vID, vID, 0, rFM, this);
				pFMPanel_0.add(aCharPanelArray[0].getPanel());
				aCharPanelArray[0].getPanel().setVisible(true);
				
				vNeiList = rFM.getIDOfNeighboursOfFighter(vID);
				if ((vNeiList != null) && (!vNeiList.isEmpty())) {
					vNeiList.toFirst();
					i=1;
					
					while(!vNeiList.isEnd()) {
						vCurID = (int) vNeiList.getCurrent();
						vCurType = rFM.getEnemyTypeOfNeighbourOfFighter(vID, vCurID);
						
						if (vCurType == false) vCur = new CharakterPanel(rFM.getCharacterOfFighter(vCurID).getName(), vCurID, vID, 1, rFM, this);
						else vCur = new CharakterPanel(rFM.getCharacterOfFighter(vCurID).getName(), vCurID, vID, 2, rFM, this);
						pFMPanel_0.add(vCur.getPanel());
						aCharPanelArray[i] = vCur;
						aCharPanelArray[i].getPanel().setVisible(true);
						
						i++;
						vNeiList.next();
					}
				}
			} catch (Exception ex) {if (!ex.getMessage().contains("05")) handleException(ex);}
			updateCharFieldPos();
			pFMPanel_0.update(pFMPanel_0.getGraphics());
			pFMPanel_0.validate();
		}
	}
	/**	Dh	26.5.2020
	 * 
	 * 	Updatet die Positionen der angezeigten Kaempfer*Innen.
	 */
	private void updateCharFieldPos() {
		int vID, vInd, vType, vXMove, vYMove;
		int vEneTotCount, vFriTotCount, vEneCount, vFriCount;
		int vXCenter, vYCenter, vLeft, vRight, vTop, vBottom; 
		
		vInd = liFMIniList.getSelectedIndex();
		if (vInd != -1) {
			vID =  (int)rListModel2.getObjectAt(vInd);
			vEneCount = 0;
			vFriCount = 0;
			
			try {
				vXCenter = (int)aCharPanelArray[0].getLocation().getX();
				vYCenter = (int)aCharPanelArray[0].getLocation().getY();
				
				vXMove = aCharPanelArray[0].getWidth() + 5;
				vYMove = aCharPanelArray[0].getHeight() + 5;
				
				vLeft = vXCenter - vXMove;
				vRight = vXCenter + vXMove;
				vTop = vYCenter - vYMove;
				vBottom = vYCenter + vYMove;
				
				vEneTotCount = rFM.getNeighbourCountByTypeOfFighter(vID, true);
				vFriTotCount = rFM.getNeighbourCountByTypeOfFighter(vID, false);
				
				for (int i=1; i<aCharPanelArray.length; i++) {
					if (aCharPanelArray[i] != null) {
						vType = aCharPanelArray[i].getType();
						if (HexFMCharFieldGrid == false) {
							if (vType == 2) {
								if (vEneTotCount == 1) aCharPanelArray[i].setLocation(vXCenter, vTop);
								else if ((vEneTotCount == 2) && (vFriTotCount < 6) ) aCharPanelArray[i].setLocation(vLeft+(vEneCount*2*vXMove), vTop);
								else if (vEneTotCount == 2) aCharPanelArray[i].setLocation(vXCenter+(vEneCount*vXMove), vTop);
								else if (vEneCount <= 2) aCharPanelArray[i].setLocation(vLeft+(vEneCount*vXMove), vTop);
								else if (vEneCount <= 4)  aCharPanelArray[i].setLocation(vRight-((vEneCount-3)*2*vXMove), vYCenter);
								else if ((vEneTotCount == 6) || (vEneTotCount == 8)) aCharPanelArray[i].setLocation(vRight-((vEneCount-5)*vXMove), vBottom);
								else if (vEneTotCount == 7) aCharPanelArray[i].setLocation(vRight-((vEneCount-5)*2*vXMove), vBottom);
								else throw new Exception("01; MaFra,uCFP");
								
								vEneCount ++;
							}else {
								if (vFriTotCount == 1) aCharPanelArray[i].setLocation(vXCenter, vBottom);
								else if ((vFriTotCount == 2) && (vEneTotCount < 6) ) aCharPanelArray[i].setLocation(vLeft+(vFriCount*2*vXMove), vBottom);
								else if (vFriTotCount == 2) aCharPanelArray[i].setLocation(vRight-(vFriCount*vXMove), vBottom);
								else if (vFriCount <= 2) aCharPanelArray[i].setLocation(vLeft+(vFriCount*vXMove), vBottom);
								else if (vFriCount <= 4)  aCharPanelArray[i].setLocation(vLeft+((vFriCount-3)*2*vXMove), vYCenter);
								else if ((vFriTotCount == 6) || (vFriTotCount == 8)) aCharPanelArray[i].setLocation(vRight-((vFriCount-5)*vXMove), vTop);
								else if (vFriTotCount == 7) aCharPanelArray[i].setLocation(vRight-((vFriCount-5)*2*vXMove), vTop);
								else throw new Exception("01; MaFra,uCFP");
							
								vFriCount ++;
							}
						}
					}
				}
			} catch(Exception ex) {handleException(ex);}
		}
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	11.5.2020
	 * 	
	 * 	Bearbeitet den nächsten Zug des FightMananers.
	 */
	protected void nextTurn() {
		try{ rFM.nextTurn(); }
		catch(Exception ex) {handleException(ex);}
		updateIniList();
	}
	/**	Dh	11.5.2020
	 * 
	 * 	Fuegt einen kämpfenden dem FightManager hinzu.
	 */
	private void addFighter() {
		try {rFM.addFighter(Loader.loadNewRandomCharakter());}
		catch(Exception ex) {handleException(ex);}
		updateLists();
	}
	/**	Dh	11.5.2020
	 * 
	 */
	private void deleteAllFighter() {
		rFM.removeAllFighters();
		updateLists();
		updateSelectedFighter();
	}
	
	/**	Dh	16.5.2020
	 * 
	 * 	Setzt die allgemeinen Mods zurück, und aktualisiert die ausgewaehlte Kaempfer*Innen Infos.
	 */
	private void resetGeneralMods() {
		try {
			zGenPropMods = negArrayValues(zGenPropMods);
			zGenStatMods = negArrayValues(zGenStatMods);
			rFM.addPropModsToFighters(zGenPropMods);
			rFM.addStatModsToFighters(zGenStatMods);
			zGenPropMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			zGenStatMods = new double[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		}catch(Exception ex) {if (!ex.getMessage().contains("03")) handleException(ex);}
		/**
		spFMGenPropModSpinner_0.setValue(zGenPropMods[0]);
		spFMGenPropModSpinner_1.setValue(zGenPropMods[1]);
		spFMGenPropModSpinner_2.setValue(zGenPropMods[2]);
		spFMGenPropModSpinner_3.setValue(zGenPropMods[3]);
		spFMGenPropModSpinner_4.setValue(zGenPropMods[4]);
		spFMGenPropModSpinner_5.setValue(zGenPropMods[5]);
		spFMGenPropModSpinner_6.setValue(zGenPropMods[6]);
		spFMGenPropModSpinner_7.setValue(zGenPropMods[7]);
		spFMGenPropModSpinner_8.setValue(zGenPropMods[8]);
		
		spFMGenFightModSpinner_0.setValue(zGenStatMods[0]);
		spFMGenFightModSpinner_1.setValue(zGenStatMods[1]);
		spFMGenFightModSpinner_2.setValue(zGenStatMods[2]);
		spFMGenFightModSpinner_3.setValue(zGenStatMods[3]);
		spFMGenFightModSpinner_4.setValue(zGenStatMods[4]);
		spFMGenFightModSpinner_5.setValue(zGenStatMods[5]);
		spFMGenFightModSpinner_6.setValue(zGenStatMods[6]);
		spFMGenFightModSpinner_7.setValue(zGenStatMods[7]);
		spFMGenFightModSpinner_8.setValue(zGenStatMods[8]);
		spFMGenFightModSpinner_9.setValue(zGenStatMods[9]);
		**/
		updateSelectedFighter();
	}
	/**	Dh	12.5.2020
	 * 
	 * 	Entfernt alle generellen Mods und updated die Spinner, und aktualisiert die ausgewaehlte Kaempfer*Innen Infos.
	 */
	private void removeAllGeneralMods() {
		try {
			zGenPropMods = negArrayValues(zGenPropMods);
			zGenStatMods = negArrayValues(zGenStatMods);
			
			rFM.addPropModsToFighters(zGenPropMods);
			rFM.addStatModsToFighters(zGenStatMods);
		}catch(Exception ex) {handleException(ex);}
		
		zGenPropMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		zGenStatMods = new double[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		updateLists();
		updateGenModFields();
		updateSelectedFighter();
	}
	/**	Dh	17.5.2020
	 * 
	 * 	Entferne alle spezifischen Mods, der selektierten Kaempfer*In.
	 */
	private void removeAllSpezMods() {
		int vID, vInd;
		int[] vSpezPropMod;
		double[] vSpezStatMod;
		
		vInd = liFMFightList.getSelectedIndex();
		if (vInd != -1) {
			vID = (int)((JListModelElement)rListModel1.get(vInd)).getObject();
			
			try {
				vSpezPropMod = rFM.getPropModsOfFighter(vID).clone();
				vSpezStatMod = rFM.getStatModsOfFighter(vID).clone();
				
				for (int i=0; i<10; i++) {
					vSpezPropMod[i] = vSpezPropMod[i] - zGenPropMods[i];
					vSpezStatMod[i] = vSpezStatMod[i] - zGenStatMods[i];
					
					if (vSpezPropMod[i] != 0) rFM.addPropModToFighter(vID, -vSpezPropMod[i], i);
					if (vSpezStatMod[i] != 0) rFM.addStatModToFighter(vID, -vSpezStatMod[i], i);
				}
			}catch(Exception ex) {handleException(ex);}
			updateLists();
			updateSelectedFighter();
		}else handleException(new Exception("09; MaFra,rASM"));
	}
	/**	Dh	23.5.2020
	 * 
	 * 	Entfernt die ausgewaehlten Nachbarschaft.
	 */
	private void removeNeighbour() {
		int vID, vNeiID;
		
		if (liFMFightList.getSelectedIndex() != -1) {
			vID = (int)((JListModelElement)rListModel1.get(liFMFightList.getSelectedIndex())).getObject();
			
			if (liFMNeiList.getSelectedIndex() != -1) {
				vNeiID = (int)((JListModelElement)rNeiListModel.get(liFMNeiList.getSelectedIndex())).getObject();
				
				try { rFM.removeNeighbourOfFighter(vID, vNeiID);}
				catch (Exception ex) {handleException(ex);}
				
				updateNeighbourList();
			}
		}
	}
	/**	Dh	23.5.2020
	 * 
	 * 	Entfernt alle Nachbarschaften einer Kaempfer*In.
	 */
	private void removeAllNeighbours() {
		int vID, vNeiID;
		
		if (liFMFightList.getSelectedIndex() != -1) {
			vID = (int)((JListModelElement)rListModel1.get(liFMFightList.getSelectedIndex())).getObject();
			
			if (rNeiListModel.getSize() != 0) {
				for (int i=0; i <rNeiListModel.getSize(); i++) {
					vNeiID = (int)rNeiListModel.getObjectAt(i);
					
					try { rFM.removeNeighbourOfFighter(vID, vNeiID);}
					catch (Exception ex) {handleException(ex);}
				}
				
				updateNeighbourList();
			}
		}
	}
	
	/**	Dh	17.5.2020
	 * 
	 * 	Oeffenet das ModFrame, und gibt die auswahl, ob es ein allgemeiner Mod, oder Spezieller Mod ist.
	 * 
	 * @param pGen
	 */
	private void openModFrame(boolean pGen) {
		int vID, vInd;
		String vName = null;
		
		if (pGen == true) {
			vID = -1;
			vName = "";
		}else {
			vInd = liFMFightList.getSelectedIndex();
			if (vInd != -1) {
				vID = (int)((JListModelElement)rListModel1.get(vInd)).getObject();
				try { vName = rFM.getCharacterOfFighter(vID).getName(); }
				catch(Exception ex) {handleException(ex);}
			} else {
				handleException(new Exception("09; MaFra,oMF"));
				vID = -1;
				vName = "";
			}
		}
		
		ModFrame vCur = new ModFrame(vName, vID, rFM, this);
		vCur.setVisible(true);
		if (pGen == false) setFightListSelectionObjectsEnable(false);
		setModFrameObjectsEnable(false);
	}
	/**	Dh	17.5.2020
	 * 
	 * 	Bearbeitet das schliessen des ModFrame.
	 */
	protected void closeModFrame() {
		updateSelectedFighter();
		updateGenModFields();
		updateLists();
		setFightListSelectionObjectsEnable(true);
		setModFrameObjectsEnable(true);
	}
	/**	Dh	22.5.2020
	 * 
	 * 	Oeffnet das NeighbourFrame, und teilt diesem mit, ob ein neuer hinzugefuergt wird, oder ein vorhandener Modifiziert wird.
	 * 
	 * @param pGen
	 */
	private void openNeighbourFrame(boolean pGen) {
		int vID, vNeiID, vInd;
		String vName = null;
		
		vInd = liFMFightList.getSelectedIndex();
		if (vInd != -1) {
			vID = (int)((JListModelElement)rListModel1.get(vInd)).getObject();
			try {vName = rFM.getFightElement(vID).getCharacter().getName();}
			catch(Exception ex) {handleException(ex);}
			
			if (pGen == false) {
				vInd = liFMNeiList.getSelectedIndex();
				if (vInd != -1) {
					vNeiID = (int)((JListModelElement)rNeiListModel.get(vInd)).getObject();
				} else {
					handleException(new Exception("09; MaFra,oNF"));
					vNeiID = -1;
				}
			} else vNeiID = -1;
			
			NeighbourFrame vCur = new NeighbourFrame(vName, vID, vNeiID, rFM, this);
			vCur.setVisible(true);
			
			setNeiPanelObjectsEnable(false);
		} else handleException(new Exception("09; MaFra,oNF"));
	}
	/**	Dh	22.5.2020
	 * 
	 * 	Bearbeitet das Schließen des NeighbourFrames.
	 */
	protected void closeNeighbourFrame() {
		updateSelectedFighter();
		updateCharaField();
		setNeiPanelObjectsEnable(true);
	}
	/**	Dh	4.6.2020
	 * 
	 * @param pFightID
	 * @param pTarID
	 */
	protected void openAttackFrame(int pFightID, int pTarID) {
		boolean vCloseCombat = false;
		
		try {
			if (rFM.getActiveWeaponOfFighter(pFightID, 0) instanceof CloseWeapon) vCloseCombat = true;
			else vCloseCombat = false;
		} catch (Exception ex) {handleException(ex);}
		
		FightFrame vCur = new FightFrame(pFightID, pTarID, true, vCloseCombat, rFM, this);
		vCur.setVisible(true);
		
		setCharFieldObjectsEnable(false);
		//nextTurn();
	}
	/**	DH	4.6.2020
	 * 
	 * @param pFightID
	 * @param pOpponentID
	 */
	protected void openDefensivFrame(int pFightID, int pOpponentID) {
		boolean vCloseCombat = false;
		
		try {
			if (rFM.getActiveWeaponOfFighter(pOpponentID, 0) instanceof CloseWeapon) vCloseCombat = true;
			else vCloseCombat = false;
		} catch (Exception ex) {handleException(ex);}
		
		FightFrame vCur = new FightFrame(pFightID, pOpponentID, false, vCloseCombat, rFM, this);
		vCur.setVisible(true);
		
		setCharFieldObjectsEnable(false);
	}
	/**	Dh	4.6.2020
	 * 
	 * 	ClsoeSpez:
	 * 		0: Abbgebrochen
	 * 		1: Attacke daneben
	 * 		2: Verdeitigung daneben
	 */
	protected void closeFightFrame(int pCloseSpez) {
		setCharFieldObjectsEnable(true);
		
		if (pCloseSpez != 0) nextTurn();
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	12.5.2020
	 * 
	 * 	Negiert die Werte eines Arrays.
	 * 
	 * @param pArray
	 * @throws Exception
	 */
	private static int[] negArrayValues(int[] pArray) throws Exception {
		if(pArray != null) {
			for (int i=0; i<pArray.length;i++) {
				pArray[i] = -1*pArray[i];
			}
			return pArray;
		}else throw new Exception("04; MaFra,nAV_a");
	}
	/**	Dh	12.5.2020
	 * 
	 * 	Negiert die Werte eines Arrays.
	 * 
	 * @param pArray
	 * @throws Exception
	 */
	private static double[] negArrayValues(double[] pArray) throws Exception {
		if(pArray != null) {
			for (int i=0; i<pArray.length;i++) {
				pArray[i] = -1*pArray[i];
			}
			return pArray;
		}else throw new Exception("04; MaFra,nAV_b");
	}
	
	
	/**	Dh	11.6.2020
	 * 
	 */
	public void dispose() {
		frmDsaAppV.setVisible(false);
		frmDsaAppV.dispose();
	}
	/**	11.6.2020
	 * 
	 */
	public static void closeApp() {
		MainManager.closeApp();
	}
	/**	11.5.2020
	 * 
	 * @param pEx
	 */
	public static void handleException(Exception pEx) {
		System.out.println(pEx.getMessage());
	}
}
