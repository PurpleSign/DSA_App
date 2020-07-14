/**	DSA_App v0.0	Dh	11.7.2020
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

import pLogik.CharacterManager;
import pLogik.Charakter;
import pLogik.CloseWeapon;
import pLogik.FightElement;
import pLogik.FightManager;
import pLogik.IniElement;
import pLogik.MainManager;
import pLogik.NeighbourElement;
import pLogik.Pro;
import pLogik.Referred;
import pLogik.SpecialCraft;
import pLogik.Stringed;
import pLogik.Talent;
import pLogik.Valued;
import pLogik.Weapon;
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
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MainFrame {
	private boolean isHexFMCharFieldGrid;
	private int height, width, fightTabPanleWidth;
	private int[] genPropMods, genStatMods;
	
	private JFrame frmDsaAppV;
	private JPanel pFMCharInfoPanel, pFMCharInfoPanel_0, pFMCharInfoPanel_1, pFMCharInfoPanel_2, lFMNeiInfoPanel;
	private JPanel pFMSpezModPanel_0, pFMSpezModPanel_1, pFMGenModPanel_0, pFMGenModPanel_1;
	//-----
	private JPanel pCMPanel_0,  pCMPanel_1;
	private JPanel pCMGenPanel, pCMPropPanel, pCMStatPanel, pCMProPanel, pCMSpecialPanel, pCMArmorPanel, pCMEquipmentPanel, pCMTalentPanel;
	
	private JTabbedPane tpFMCharInfoTabbedPane;
	private JScrollPane spCharListScrollPane, spProPanelScrollPane, spSpecialPanelScrollPane, spCMEquipmentScrollPane, spCMTalentScrollPane;
	
	private JList liFMFightList, liFMIniList, liFMNeiList;
	private JList liCMCharList;
	private JTable tCMTalentPanelTable;
	
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
	//-----
	private JLabel lCMP0Title, lCMP1Title;
	private JLabel lCMGenTitle, lCMGenLable_0, lCMGenLable_1, lCMGenLable_2, lCMGenLable_3;
	private JLabel lCMPropTitle, lCMPropLabel_0, lCMPropLabel_1, lCMPropLabel_2, lCMPropLabel_3, lCMPropLabel_4, lCMPropLabel_5, lCMPropLabel_6, 
		lCMPropLabel_7,	lCMPropLabel_8, lCMPropLabel_9;
	private JLabel lCMStatTitel, lCMStatLabel_0, lCMStatLabel_1, lCMStatLabel_2, lCMStatLabel_3, lCMStatLabel_4, lCMStatLabel_5, lCMStatLabel_6,
		lCMStatLabel_7, lCMStatLabel_8, lCMStatLabel_9;
	private JLabel lCMArmorTitle, lCMArmorLabel_0, lCMArmorLabel_1, lCMArmorLabel_2, lCMArmorLabel_3, lCMArmorLabel_4, lCMArmorLabel_5,
		lCMArmorLabel_6, lCMArmorLabel_7;
	private JLabel lCMProTitel, lCMSpecialTitle, lCMEquipmentTitle, lCMTalentTitle;
	
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
	//-----
	private JTextField tfCMGenField_0, tfCMGenField_1, tfCMGenField_2, tfCMGenField_3;
	private JTextField tfCMPropField_0, tfCMPropField_1, tfCMPropField_2, tfCMPropField_3, tfCMPropField_4, tfCMPropField_5, tfCMPropField_6,
		tfCMPropField_7, tfCMPropField_8, tfCMPropField_9;
	private JTextField tfCMStatField_0, tfCMStatField_1, tfCMStatField_2, tfCMStatField_3, tfCMStatField_4, tfCMStatField_5, tfCMStatField_6,
		tfCMStatField_7, tfCMStatField_8, tfCMStatField_9;
	private JTextField tfCMArmorField_0, tfCMArmorField_1, tfCMArmorField_2, tfCMArmorField_3, tfCMArmorField_4, 
		tfCMArmorField_5, tfCMArmorField_6, tfCMArmorField_7;
	
	
	
	private JTextArea taCMProTextArea, taCMSpecialTextArea;
	
	private JButton btCharFieldButton_0;
	private JButton btFMSpezModButton_0, btFMSpezModButton_1, btFMSpezModButton_2;
	private JButton btFMNeiButton_0, btFMNeiButton_1, btFMNeiButton_2, btFMNeiButton_3;
	private JButton btFMFightListButton_0, btFMFightListButton_1, btFMFightListButton_2;
	private JButton btFMGenModButton_0, btFMGenModButton_1, btFMGenModButton_2;
	//-----
	private JButton btCharListButton_0, btCharListButton_1, btCharListButton_2;
	private JButton btCMGenButton, btCMPropButton, btCMStatButton, btCMProButton, btCMSpecialButton, btCMArmorButton, btCMEquipmentButton, btCMTalentButton;
	
	private JCheckBox chFMNeiInfoBox;
	
	private JTabbedPane tpTabbedPane;
	private JSplitPane spFMSplitPane, spCMSplitPane;
	private JPanel pFMPanel_0;
	
	private FightManager rFM;
	private CharacterManager rCM;
	private CharakterPanel[] aCharPanelArray; 
	
	private JPanel pFMCharPanel;
	private JLabel lFMCharName, lFMCharLable_0, lFMCharLable_1, lFMCharLable_2, lFMCharLable_3;
	private JProgressBar pbFMCharBar_0, pbFMCharBar_1, pbFMCharBar_2, pbFMCharBar_3;
	private JButton lFMCharButton;
	
	private JListModel rListModel1, rListModel2, rNeiListModel, rCharManListModel;
	private JTableModel rCMTalentTableModel;
	
	private JLabel lblNewLabel_2;
	private JTextArea taCMEquipmentTextArea;
	private JLabel lCMArmorLabel_8;
	private JTextField tfCMArmorField_8;
	private JLabel lCMArmorLabel_9;
	private JTextField tfCMArmorField_9;
	

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
	public MainFrame(FightManager pFM, CharacterManager pCM) {
		rFM = pFM;
		rCM = pCM;
		isHexFMCharFieldGrid = false;
		
		genPropMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		genStatMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		aCharPanelArray = new CharakterPanel[9];
		
		initialize();
		
		frmDsaAppV.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fightTabPanleWidth = 150;
		
		rListModel1 = new JListModel();
		rListModel2 = new JListModel();
		rNeiListModel = new JListModel();
		rCharManListModel = new JListModel();
		rCMTalentTableModel = new JTableModel();
		
		frmDsaAppV = new JFrame();
		frmDsaAppV.setResizable(false);
		frmDsaAppV.setTitle("DSA App v0.0");
		frmDsaAppV.setBounds(350, 150, 1200, 800);
		frmDsaAppV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		height = frmDsaAppV.getHeight();
		width = frmDsaAppV.getWidth();
		
		tpTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmDsaAppV.getContentPane().add(tpTabbedPane, BorderLayout.CENTER);
		
		initFightManagerTab();
		initFightOverviewTab();
		initCharacterManagerTab();
		
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
		} catch(Exception ex) {if (ex.getMessage() != null) handleException(ex);}
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	24.6.2020
	 * 
	 * 	Erstellt den KampfManager Tab
	 */
	private void initFightManagerTab() {
		spFMSplitPane = new JSplitPane();
		spFMSplitPane.setEnabled(false);
		spFMSplitPane.setDividerSize(10);
		spFMSplitPane.setDividerLocation(300);
		spFMSplitPane.setDividerLocation(height*5 / 8);
		spFMSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		tpTabbedPane.addTab("Kampf Manager", null, spFMSplitPane, null);
		
		initFirstFightManagerPanel();
		initSecondFightManagerPanel();
	}
	/**	Dh	24.6.2020
	 * 
	 * 	Erstellt den KampfUebersichts Tab
	 */
	private void initFightOverviewTab() {
		JPanel tbpanel1 = new JPanel();
		tpTabbedPane.addTab("Kampf \u00DCbersicht", null, tbpanel1, null);
	}
	/**	Dh	24.6.2020
	 * 
	 * 	Erstellt den Charactermanager Tab
	 */
	private void initCharacterManagerTab() {
		spCMSplitPane = new JSplitPane();
		spCMSplitPane.setEnabled(false);
		tpTabbedPane.addTab("Charakter Manager", null, spCMSplitPane, null);
		
		initFirstCharacterManagerPanel();
		initSecondCharacterManagerPanel();
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
		lFMCharInfoTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lFMCharInfoTitle.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		
		tpFMCharInfoTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		GroupLayout gl_pFMCharInfoPanel = new GroupLayout(pFMCharInfoPanel);
		gl_pFMCharInfoPanel.setHorizontalGroup(
			gl_pFMCharInfoPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(tpFMCharInfoTabbedPane, GroupLayout.PREFERRED_SIZE, 306, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_pFMCharInfoPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lFMCharInfoTitle, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
					.addGap(10))
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
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
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
					.addContainerGap()
					.addGroup(gl_pFMCharInfoPanel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pFMCharInfoPanel_1.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_pFMCharInfoPanel_1.createSequentialGroup()
							.addComponent(btFMSpezModButton_0, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pFMCharInfoPanel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(btFMSpezModButton_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
								.addComponent(btFMSpezModButton_2, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
							.addGap(29))
						.addGroup(gl_pFMCharInfoPanel_1.createSequentialGroup()
							.addComponent(pFMSpezModPanel_1, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
							.addGap(31))
						.addGroup(gl_pFMCharInfoPanel_1.createSequentialGroup()
							.addComponent(pFMSpezModPanel_0, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
							.addGap(31))))
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
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
		lFMNeiTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lFMNeiTitle.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		
		JPanel lFMNeiInfoPanel = new JPanel();
		lFMNeiInfoPanel.setBackground(Color.WHITE);
		
		lFMNeiListTitle = new JLabel("Kampfnachber*Innen Liste");
		lFMNeiListTitle.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		liFMNeiList = new JList();
		liFMNeiList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
					.addContainerGap()
					.addGroup(gl_pFMCharInfoPanel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lFMNeiTitle, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
						.addGroup(gl_pFMCharInfoPanel_2.createSequentialGroup()
							.addGroup(gl_pFMCharInfoPanel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pFMCharInfoPanel_2.createParallelGroup(Alignment.LEADING, false)
									.addComponent(btFMNeiButton_0, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addComponent(lFMNeiInfoPanel, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
								.addComponent(btFMNeiButton_3, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addComponent(btFMNeiButton_2, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addComponent(btFMNeiButton_1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pFMCharInfoPanel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(liFMNeiList, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(lFMNeiListTitle))))
					.addContainerGap())
		);
		gl_pFMCharInfoPanel_2.setVerticalGroup(
			gl_pFMCharInfoPanel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFMCharInfoPanel_2.createSequentialGroup()
					.addComponent(lFMNeiTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
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
		lFMSpezPropModLable.setHorizontalAlignment(SwingConstants.CENTER);
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
							.addContainerGap()
							.addGroup(gl_pFMSpezModPanel_0.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pFMSpezModPanel_0.createSequentialGroup()
									.addComponent(lFMSpezPropModLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMSpezPropModField_0, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pFMSpezModPanel_0.createSequentialGroup()
									.addComponent(lFMSpezPropModLable_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMSpezPropModField_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pFMSpezModPanel_0.createSequentialGroup()
									.addComponent(lFMSpezPropModLable_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMSpezPropModField_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pFMSpezModPanel_0.createSequentialGroup()
									.addComponent(lFMSpezPropModLable_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMSpezPropModField_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_pFMSpezModPanel_0.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pFMSpezModPanel_0.createSequentialGroup()
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
									.addComponent(lFMSpezPropModLable_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfFMSpezPropModField_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_pFMSpezModPanel_0.createSequentialGroup()
							.addGap(60)
							.addComponent(lFMSpezPropModLable_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfFMSpezPropModField_8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pFMSpezModPanel_0.createSequentialGroup()
							.addContainerGap()
							.addComponent(lFMSpezPropModLable, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
					.addContainerGap())
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
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
		lFMSpezStatModLable.setHorizontalAlignment(SwingConstants.CENTER);
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
					.addContainerGap()
					.addGroup(gl_pFMSpezModPanel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pFMSpezModPanel_1.createSequentialGroup()
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
							.addComponent(lFMSpezStatModLable_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfFMSpezStatModField_0, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lFMSpezStatModLable_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfFMSpezStatModField_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(lFMSpezStatModLable, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
					.addContainerGap())
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
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
		lFMGenPropModTitle.setHorizontalAlignment(SwingConstants.CENTER);
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
							.addGap(60)
							.addComponent(lFMGenPropModLabel_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfFMGenPropModField_8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pFMGenModPanel_0.createSequentialGroup()
							.addContainerGap()
							.addComponent(lFMGenPropModTitle, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_pFMGenModPanel_0.setVerticalGroup(
			gl_pFMGenModPanel_0.createParallelGroup(Alignment.LEADING)
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
		lFMGenStatModTitle.setHorizontalAlignment(SwingConstants.CENTER);
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
				.addGroup(gl_pFMGenModPanel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pFMGenModPanel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pFMGenModPanel_1.createSequentialGroup()
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
							.addComponent(lFMGenStatModLabel_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfFMGenStatModField_0, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lFMGenStatModLabel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfFMGenStatModField_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(lFMGenStatModTitle, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pFMGenModPanel_1.setVerticalGroup(
			gl_pFMGenModPanel_1.createParallelGroup(Alignment.TRAILING)
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
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	24.6.2020
	 * 
	 */
	private void initFirstCharacterManagerPanel() {
		pCMPanel_0 = new JPanel();
		spCMSplitPane.setLeftComponent(pCMPanel_0);
		
		lCMP0Title = new JLabel("Charakter Liste");
		lCMP0Title.setHorizontalAlignment(SwingConstants.CENTER);
		lCMP0Title.setAlignmentX(Component.CENTER_ALIGNMENT);
		lCMP0Title.setFont(new Font("Liberation Serif", Font.BOLD, 24));
		
		btCharListButton_0 = new JButton("Neuer Charakter");
		btCharListButton_0.setPreferredSize(new Dimension(175, 30));
		btCharListButton_0.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btCharListButton_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addCharacter();
			}
		});
		
		btCharListButton_1 = new JButton("Charakter entfernen");
		btCharListButton_1.setPreferredSize(new Dimension(175, 30));
		btCharListButton_1.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btCharListButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteCharacter();
			}
		});
		
		btCharListButton_2 = new JButton("Liste leeren");
		btCharListButton_2.setPreferredSize(new Dimension(175, 30));
		btCharListButton_2.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btCharListButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteAllCharacters();
			}
		});
		
		spCharListScrollPane = new JScrollPane();
		
		liCMCharList = new JList();
		spCharListScrollPane.setViewportView(liCMCharList);
		liCMCharList.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		liCMCharList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liCMCharList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				updateSelectedCharacter();
			}
		});
		liCMCharList.setModel(rCharManListModel);
		
		GroupLayout gl_pCMPanel_0 = new GroupLayout(pCMPanel_0);
		gl_pCMPanel_0.setHorizontalGroup(
			gl_pCMPanel_0.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pCMPanel_0.createSequentialGroup()
					.addGroup(gl_pCMPanel_0.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pCMPanel_0.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pCMPanel_0.createParallelGroup(Alignment.TRAILING)
								.addComponent(btCharListButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
								.addComponent(btCharListButton_0, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
						.addGroup(gl_pCMPanel_0.createSequentialGroup()
							.addContainerGap()
							.addComponent(btCharListButton_2, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
						.addGroup(gl_pCMPanel_0.createSequentialGroup()
							.addContainerGap()
							.addComponent(lCMP0Title, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
					.addContainerGap())
				.addComponent(spCharListScrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
		);
		gl_pCMPanel_0.setVerticalGroup(
			gl_pCMPanel_0.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pCMPanel_0.createSequentialGroup()
					.addGap(5)
					.addComponent(lCMP0Title)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spCharListScrollPane, GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btCharListButton_0, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btCharListButton_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btCharListButton_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		pCMPanel_0.setLayout(gl_pCMPanel_0);
	}
	/**	Dh	3.7.2020
	 * 
	 */
	private void initSecondCharacterManagerPanel() {
		pCMPanel_1 = new JPanel();
		spCMSplitPane.setRightComponent(pCMPanel_1);
		pCMPanel_1.setLayout(null);
		
		lCMP1Title = new JLabel("Charaktername");
		lCMP1Title.setHorizontalAlignment(SwingConstants.CENTER);
		lCMP1Title.setMaximumSize(new Dimension(200, 30));
		lCMP1Title.setPreferredSize(new Dimension(150, 20));
		lCMP1Title.setFont(new Font("Liberation Serif", Font.BOLD, 24));
		lCMP1Title.setBounds(10, 0, 909, 27);
		pCMPanel_1.add(lCMP1Title);
		
		initCharManGenPanel();
		initCharManPropPanel();
		initCharManStatPanel();
		initCharManProPanel();
		initCharManSpecialPanel();
		initCharManArmorPanel();
		initCharManEquimentPanel();
		initCharManTalentPanel();
		
		spCMSplitPane.setDividerLocation(250);
	}
	
	/**	Dh	3.7.2020
	 * 
	 */
	private void initCharManGenPanel() {
		pCMGenPanel = new JPanel();
		pCMGenPanel.setBackground(Color.WHITE);
		pCMGenPanel.setBounds(10, 33, 290, 157);
		pCMPanel_1.add(pCMGenPanel);
		
		lCMGenTitle = new JLabel("Allgemeines");
		lCMGenTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lCMGenTitle.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		lCMGenLable_0 = new JLabel("Name");
		lCMGenLable_0.setPreferredSize(new Dimension(80, 15));
		lCMGenLable_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMGenLable_1 = new JLabel("Rasse");
		lCMGenLable_1.setPreferredSize(new Dimension(80, 15));
		lCMGenLable_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMGenLable_2 = new JLabel("Kultur");
		lCMGenLable_2.setPreferredSize(new Dimension(80, 15));
		lCMGenLable_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMGenLable_3 = new JLabel("Profession");
		lCMGenLable_3.setPreferredSize(new Dimension(80, 15));
		lCMGenLable_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		tfCMGenField_0 = new JTextField("");
		tfCMGenField_0.setPreferredSize(new Dimension(6, 15));
		tfCMGenField_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMGenField_0.setEditable(false);
		tfCMGenField_0.setColumns(4);
		
		tfCMGenField_1 = new JTextField("");
		tfCMGenField_1.setPreferredSize(new Dimension(6, 15));
		tfCMGenField_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMGenField_1.setEditable(false);
		tfCMGenField_1.setColumns(4);
		
		tfCMGenField_2 = new JTextField("");
		tfCMGenField_2.setPreferredSize(new Dimension(6, 15));
		tfCMGenField_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMGenField_2.setEditable(false);
		tfCMGenField_2.setColumns(4);
		
		tfCMGenField_3 = new JTextField("");
		tfCMGenField_3.setPreferredSize(new Dimension(6, 15));
		tfCMGenField_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMGenField_3.setEditable(false);
		tfCMGenField_3.setColumns(4);
		
		btCMGenButton = new JButton("Modifizieren");
		btCMGenButton.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btCMGenButton.setEnabled(false);
		btCMGenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openGeneralFrame();
			}
		});
		
		GroupLayout gl_pCMGenPanel = new GroupLayout(pCMGenPanel);
		gl_pCMGenPanel.setHorizontalGroup(
			gl_pCMGenPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pCMGenPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pCMGenPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lCMGenTitle, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
						.addGroup(gl_pCMGenPanel.createSequentialGroup()
							.addGroup(gl_pCMGenPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btCMGenButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_pCMGenPanel.createSequentialGroup()
									.addGroup(gl_pCMGenPanel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lCMGenLable_3, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
										.addComponent(lCMGenLable_2, 0, 0, Short.MAX_VALUE)
										.addComponent(lCMGenLable_1, 0, 0, Short.MAX_VALUE)
										.addComponent(lCMGenLable_0, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pCMGenPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(tfCMGenField_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(tfCMGenField_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(tfCMGenField_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(tfCMGenField_0, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_pCMGenPanel.setVerticalGroup(
			gl_pCMGenPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pCMGenPanel.createSequentialGroup()
					.addComponent(lCMGenTitle, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pCMGenPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lCMGenLable_0, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMGenField_0, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pCMGenPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lCMGenLable_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMGenField_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pCMGenPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lCMGenLable_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMGenField_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pCMGenPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lCMGenLable_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMGenField_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btCMGenButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pCMGenPanel.setLayout(gl_pCMGenPanel);
	}
	/**	Dh	14.7.2020
	 * 
	 */
	private void initCharManPropPanel() {
		pCMPropPanel = new JPanel();
		pCMPropPanel.setBackground(Color.WHITE);
		pCMPropPanel.setBounds(310, 33, 290, 199);
		pCMPanel_1.add(pCMPropPanel);
		
		lCMPropTitle = new JLabel("Eigenschaften");
		lCMPropTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lCMPropTitle.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		lCMPropLabel_0 = new JLabel("Mut");
		lCMPropLabel_0.setPreferredSize(new Dimension(80, 15));
		lCMPropLabel_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMPropLabel_1 = new JLabel("Klugheit");
		lCMPropLabel_1.setPreferredSize(new Dimension(80, 15));
		lCMPropLabel_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMPropLabel_2 = new JLabel("Intuition");
		lCMPropLabel_2.setPreferredSize(new Dimension(80, 15));
		lCMPropLabel_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMPropLabel_3 = new JLabel("Charisma");
		lCMPropLabel_3.setPreferredSize(new Dimension(80, 15));
		lCMPropLabel_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMPropLabel_4 = new JLabel("Fingerfertigkeit");
		lCMPropLabel_4.setPreferredSize(new Dimension(80, 15));
		lCMPropLabel_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMPropLabel_5 = new JLabel("Gewandtheit");
		lCMPropLabel_5.setPreferredSize(new Dimension(80, 15));
		lCMPropLabel_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMPropLabel_6 = new JLabel("Konstitution");
		lCMPropLabel_6.setPreferredSize(new Dimension(80, 15));
		lCMPropLabel_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMPropLabel_7 = new JLabel("K\u00F6rperkraft");
		lCMPropLabel_7.setPreferredSize(new Dimension(80, 15));
		lCMPropLabel_7.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMPropLabel_8 = new JLabel("Geschwindigkeit");
		lCMPropLabel_8.setPreferredSize(new Dimension(80, 15));
		lCMPropLabel_8.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMPropLabel_9 = new JLabel("Sozialstatus");
		lCMPropLabel_9.setPreferredSize(new Dimension(80, 15));
		lCMPropLabel_9.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		tfCMPropField_0 = new JTextField("0");
		tfCMPropField_0.setPreferredSize(new Dimension(6, 15));
		tfCMPropField_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMPropField_0.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMPropField_0.setEditable(false);
		tfCMPropField_0.setColumns(2);
		
		tfCMPropField_1 = new JTextField("0");
		tfCMPropField_1.setPreferredSize(new Dimension(6, 15));
		tfCMPropField_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMPropField_1.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMPropField_1.setEditable(false);
		tfCMPropField_1.setColumns(2);
		
		tfCMPropField_2 = new JTextField("0");
		tfCMPropField_2.setPreferredSize(new Dimension(6, 15));
		tfCMPropField_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMPropField_2.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMPropField_2.setEditable(false);
		tfCMPropField_2.setColumns(2);
		
		tfCMPropField_3 = new JTextField("0");
		tfCMPropField_3.setPreferredSize(new Dimension(6, 15));
		tfCMPropField_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMPropField_3.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMPropField_3.setEditable(false);
		tfCMPropField_3.setColumns(2);
		
		tfCMPropField_4 = new JTextField("0");
		tfCMPropField_4.setPreferredSize(new Dimension(6, 15));
		tfCMPropField_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMPropField_4.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMPropField_4.setEditable(false);
		tfCMPropField_4.setColumns(2);
		
		tfCMPropField_5 = new JTextField("0");
		tfCMPropField_5.setPreferredSize(new Dimension(6, 15));
		tfCMPropField_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMPropField_5.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMPropField_5.setEditable(false);
		tfCMPropField_5.setColumns(2);
		
		tfCMPropField_6 = new JTextField("0");
		tfCMPropField_6.setPreferredSize(new Dimension(6, 15));
		tfCMPropField_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMPropField_6.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMPropField_6.setEditable(false);
		tfCMPropField_6.setColumns(2);
		
		tfCMPropField_7 = new JTextField("0");
		tfCMPropField_7.setPreferredSize(new Dimension(6, 15));
		tfCMPropField_7.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMPropField_7.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMPropField_7.setEditable(false);
		tfCMPropField_7.setColumns(2);
		
		tfCMPropField_8 = new JTextField("0");
		tfCMPropField_8.setPreferredSize(new Dimension(6, 15));
		tfCMPropField_8.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMPropField_8.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMPropField_8.setEditable(false);
		tfCMPropField_8.setColumns(2);
		
		tfCMPropField_9 = new JTextField("0");
		tfCMPropField_9.setPreferredSize(new Dimension(6, 15));
		tfCMPropField_9.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMPropField_9.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMPropField_9.setEditable(false);
		tfCMPropField_9.setColumns(2);
		
		btCMPropButton = new JButton("Modifizieren");
		btCMPropButton.setEnabled(false);
		btCMPropButton.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btCMPropButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openPropertyFrame();
			}
		});
		
		GroupLayout gl_pCMPropPanel = new GroupLayout(pCMPropPanel);
		gl_pCMPropPanel.setHorizontalGroup(
			gl_pCMPropPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pCMPropPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pCMPropPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pCMPropPanel.createSequentialGroup()
							.addGroup(gl_pCMPropPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pCMPropPanel.createSequentialGroup()
									.addComponent(lCMPropLabel_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfCMPropField_0, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pCMPropPanel.createSequentialGroup()
									.addComponent(lCMPropLabel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfCMPropField_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pCMPropPanel.createSequentialGroup()
									.addComponent(lCMPropLabel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfCMPropField_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pCMPropPanel.createSequentialGroup()
									.addComponent(lCMPropLabel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfCMPropField_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
							.addGap(32)
							.addGroup(gl_pCMPropPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_pCMPropPanel.createSequentialGroup()
									.addGroup(gl_pCMPropPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lCMPropLabel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lCMPropLabel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lCMPropLabel_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pCMPropPanel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_pCMPropPanel.createParallelGroup(Alignment.LEADING)
											.addComponent(tfCMPropField_7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
											.addComponent(tfCMPropField_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
										.addComponent(tfCMPropField_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_pCMPropPanel.createSequentialGroup()
									.addComponent(lCMPropLabel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfCMPropField_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
						.addComponent(lCMPropTitle, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
						.addGroup(gl_pCMPropPanel.createSequentialGroup()
							.addComponent(lCMPropLabel_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCMPropField_8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(lCMPropLabel_9, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCMPropField_9, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(btCMPropButton, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pCMPropPanel.setVerticalGroup(
			gl_pCMPropPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pCMPropPanel.createSequentialGroup()
					.addComponent(lCMPropTitle)
					.addGap(11)
					.addGroup(gl_pCMPropPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lCMPropLabel_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMPropField_0, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMPropField_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lCMPropLabel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pCMPropPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pCMPropPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lCMPropLabel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfCMPropField_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pCMPropPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lCMPropLabel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfCMPropField_5, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pCMPropPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pCMPropPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lCMPropLabel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfCMPropField_6, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pCMPropPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lCMPropLabel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfCMPropField_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pCMPropPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pCMPropPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lCMPropLabel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lCMPropLabel_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tfCMPropField_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
						.addComponent(tfCMPropField_7, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pCMPropPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lCMPropLabel_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMPropField_8, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMPropField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lCMPropLabel_9, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btCMPropButton)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		pCMPropPanel.setLayout(gl_pCMPropPanel);
	}
	/**	Dh	14.7.2020
	 * 
	 */
	private void initCharManStatPanel() {
		pCMStatPanel = new JPanel();
		pCMStatPanel.setBackground(Color.WHITE);
		pCMStatPanel.setBounds(10, 201, 290, 191);
		pCMPanel_1.add(pCMStatPanel);
		
		lCMStatTitel = new JLabel("Basiswerte");
		lCMStatTitel.setHorizontalAlignment(SwingConstants.CENTER);
		lCMStatTitel.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		lCMStatTitel.setAlignmentX(0.5f);
		
		lCMStatLabel_0 = new JLabel("Lebenspunkte");
		lCMStatLabel_0.setPreferredSize(new Dimension(80, 15));
		lCMStatLabel_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMStatLabel_1 = new JLabel("Ausdauerpunkte");
		lCMStatLabel_1.setPreferredSize(new Dimension(80, 15));
		lCMStatLabel_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMStatLabel_2 = new JLabel("Astralpunkte");
		lCMStatLabel_2.setPreferredSize(new Dimension(80, 15));
		lCMStatLabel_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMStatLabel_3 = new JLabel("Karmapunkte");
		lCMStatLabel_3.setPreferredSize(new Dimension(80, 15));
		lCMStatLabel_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMStatLabel_4 = new JLabel("Magieresistenz");
		lCMStatLabel_4.setPreferredSize(new Dimension(80, 15));
		lCMStatLabel_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMStatLabel_5 = new JLabel("Wundschwelle");
		lCMStatLabel_5.setPreferredSize(new Dimension(80, 15));
		lCMStatLabel_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMStatLabel_6 = new JLabel("Ini-Basiswert");
		lCMStatLabel_6.setPreferredSize(new Dimension(80, 15));
		lCMStatLabel_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMStatLabel_7 = new JLabel("At-Basiswert");
		lCMStatLabel_7.setPreferredSize(new Dimension(80, 15));
		lCMStatLabel_7.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMStatLabel_8 = new JLabel("Pa-Pasiswert");
		lCMStatLabel_8.setPreferredSize(new Dimension(80, 15));
		lCMStatLabel_8.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMStatLabel_9 = new JLabel("Fk-Basiswert");
		lCMStatLabel_9.setPreferredSize(new Dimension(80, 15));
		lCMStatLabel_9.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		tfCMStatField_0 = new JTextField("0");
		tfCMStatField_0.setPreferredSize(new Dimension(6, 15));
		tfCMStatField_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMStatField_0.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMStatField_0.setEditable(false);
		tfCMStatField_0.setColumns(4);
		
		tfCMStatField_1 = new JTextField("0");
		tfCMStatField_1.setPreferredSize(new Dimension(6, 15));
		tfCMStatField_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMStatField_1.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMStatField_1.setEditable(false);
		tfCMStatField_1.setColumns(4);
		
		tfCMStatField_2 = new JTextField("0");
		tfCMStatField_2.setPreferredSize(new Dimension(6, 15));
		tfCMStatField_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMStatField_2.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMStatField_2.setEditable(false);
		tfCMStatField_2.setColumns(4);
		
		tfCMStatField_3 = new JTextField("0");
		tfCMStatField_3.setPreferredSize(new Dimension(6, 15));
		tfCMStatField_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMStatField_3.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMStatField_3.setEditable(false);
		tfCMStatField_3.setColumns(4);
		
		tfCMStatField_4 = new JTextField("0");
		tfCMStatField_4.setPreferredSize(new Dimension(6, 15));
		tfCMStatField_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMStatField_4.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMStatField_4.setEditable(false);
		tfCMStatField_4.setColumns(2);
		
		tfCMStatField_5 = new JTextField("0");
		tfCMStatField_5.setPreferredSize(new Dimension(6, 15));
		tfCMStatField_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMStatField_5.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMStatField_5.setEditable(false);
		tfCMStatField_5.setColumns(2);
		
		tfCMStatField_6 = new JTextField("0");
		tfCMStatField_6.setPreferredSize(new Dimension(6, 15));
		tfCMStatField_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMStatField_6.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMStatField_6.setEditable(false);
		tfCMStatField_6.setColumns(2);
		
		tfCMStatField_7 = new JTextField("0");
		tfCMStatField_7.setPreferredSize(new Dimension(6, 15));
		tfCMStatField_7.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMStatField_7.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMStatField_7.setEditable(false);
		tfCMStatField_7.setColumns(2);
		
		tfCMStatField_8 = new JTextField("0");
		tfCMStatField_8.setPreferredSize(new Dimension(6, 15));
		tfCMStatField_8.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMStatField_8.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMStatField_8.setEditable(false);
		tfCMStatField_8.setColumns(2);
		
		tfCMStatField_9 = new JTextField("0");
		tfCMStatField_9.setPreferredSize(new Dimension(6, 15));
		tfCMStatField_9.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMStatField_9.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMStatField_9.setEditable(false);
		tfCMStatField_9.setColumns(2);
		
		btCMStatButton = new JButton("Modifizieren");
		btCMStatButton.setEnabled(false);
		btCMStatButton.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btCMStatButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openStatusFrame();
			}
		});
		
		GroupLayout gl_pCMStatPanel = new GroupLayout(pCMStatPanel);
		gl_pCMStatPanel.setHorizontalGroup(
			gl_pCMStatPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pCMStatPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pCMStatPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lCMStatTitel, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
						.addGroup(gl_pCMStatPanel.createSequentialGroup()
							.addComponent(lCMStatLabel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCMStatField_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lCMStatLabel_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCMStatField_7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pCMStatPanel.createSequentialGroup()
							.addComponent(lCMStatLabel_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCMStatField_0, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lCMStatLabel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCMStatField_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pCMStatPanel.createSequentialGroup()
							.addComponent(lCMStatLabel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCMStatField_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lCMStatLabel_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCMStatField_8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pCMStatPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btCMStatButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(Alignment.LEADING, gl_pCMStatPanel.createSequentialGroup()
								.addGroup(gl_pCMStatPanel.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, gl_pCMStatPanel.createSequentialGroup()
										.addComponent(lCMStatLabel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tfCMStatField_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lCMStatLabel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(Alignment.LEADING, gl_pCMStatPanel.createSequentialGroup()
										.addComponent(lCMStatLabel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tfCMStatField_3, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lCMStatLabel_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_pCMStatPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(tfCMStatField_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
									.addComponent(tfCMStatField_9, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_pCMStatPanel.setVerticalGroup(
			gl_pCMStatPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pCMStatPanel.createSequentialGroup()
					.addComponent(lCMStatTitel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pCMStatPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lCMStatLabel_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMStatField_0, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lCMStatLabel_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMStatField_6, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_pCMStatPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfCMStatField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lCMStatLabel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lCMStatLabel_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMStatField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pCMStatPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lCMStatLabel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMStatField_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lCMStatLabel_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMStatField_8, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pCMStatPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lCMStatLabel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMStatField_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lCMStatLabel_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMStatField_9, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pCMStatPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lCMStatLabel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMStatField_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lCMStatLabel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMStatField_5, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btCMStatButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		pCMStatPanel.setLayout(gl_pCMStatPanel);
		
		
	}
	/**	Dh	24.6.2020
	 * 
	 */
	private void initCharManProPanel() {
		pCMProPanel = new JPanel();
		pCMProPanel.setBackground(UIManager.getColor("Button.highlight"));
		pCMProPanel.setBounds(10, 413, 290, 145);
		pCMPanel_1.add(pCMProPanel);
		
		lCMProTitel = new JLabel("Vor- und Nachteile");
		lCMProTitel.setHorizontalAlignment(SwingConstants.CENTER);
		lCMProTitel.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		btCMProButton = new JButton("Modifizieren");
		btCMProButton.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btCMProButton.setEnabled(false);
		btCMProButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openProFrame();
			}
		});
		
		spProPanelScrollPane = new JScrollPane();
		spProPanelScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		taCMProTextArea = new JTextArea();
		taCMProTextArea.setLineWrap(true);
		spProPanelScrollPane.setViewportView(taCMProTextArea);
		taCMProTextArea.setFont(new Font("Liberation Serif", Font.PLAIN, 10));
		taCMProTextArea.setEditable(false);
		taCMProTextArea.setBackground(SystemColor.controlHighlight);
		
		GroupLayout gl_pCMProPanel = new GroupLayout(pCMProPanel);
		gl_pCMProPanel.setHorizontalGroup(
			gl_pCMProPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pCMProPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pCMProPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(spProPanelScrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
						.addComponent(lCMProTitel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
						.addComponent(btCMProButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pCMProPanel.setVerticalGroup(
			gl_pCMProPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pCMProPanel.createSequentialGroup()
					.addComponent(lCMProTitel)
					.addGap(1)
					.addComponent(spProPanelScrollPane, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btCMProButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		pCMProPanel.setLayout(gl_pCMProPanel);
	}
	/**	Dh	2.7.2020
	 * 
	 */
	private void initCharManSpecialPanel() {
		pCMSpecialPanel = new JPanel();
		pCMSpecialPanel.setBackground(Color.WHITE);
		pCMSpecialPanel.setBounds(310, 455, 290, 254);
		pCMPanel_1.add(pCMSpecialPanel);
		
		lCMSpecialTitle = new JLabel("Sonderfertigkeiten");
		lCMSpecialTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lCMSpecialTitle.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		btCMSpecialButton = new JButton("Modifizieren");
		btCMSpecialButton.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btCMSpecialButton.setEnabled(false);
		btCMSpecialButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openSpecialCraftFrame();
			}
		});
		
		spSpecialPanelScrollPane = new JScrollPane();
		spSpecialPanelScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		taCMSpecialTextArea = new JTextArea();
		taCMSpecialTextArea.setLineWrap(true);
		spSpecialPanelScrollPane.setViewportView(taCMSpecialTextArea);
		taCMSpecialTextArea.setFont(new Font("Liberation Serif", Font.PLAIN, 10));
		taCMSpecialTextArea.setEditable(false);
		taCMSpecialTextArea.setBackground(SystemColor.controlHighlight);
		
		GroupLayout gl_pCMSpecialPanel = new GroupLayout(pCMSpecialPanel);
		gl_pCMSpecialPanel.setHorizontalGroup(
			gl_pCMSpecialPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pCMSpecialPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pCMSpecialPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(spSpecialPanelScrollPane, Alignment.LEADING)
						.addComponent(lCMSpecialTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
						.addComponent(btCMSpecialButton, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pCMSpecialPanel.setVerticalGroup(
			gl_pCMSpecialPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pCMSpecialPanel.createSequentialGroup()
					.addComponent(lCMSpecialTitle)
					.addGap(1)
					.addComponent(spSpecialPanelScrollPane, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btCMSpecialButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		pCMSpecialPanel.setLayout(gl_pCMSpecialPanel);
	}
	/**	Dh	14.7.2020
	 * 
	 */
	private void initCharManArmorPanel() {
		pCMArmorPanel = new JPanel();
		pCMArmorPanel.setBackground(Color.WHITE);
		pCMArmorPanel.setBounds(310, 243, 290, 191);
		pCMPanel_1.add(pCMArmorPanel);
		
		lCMArmorTitle = new JLabel("R\u00FCstung");
		lCMArmorTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lCMArmorTitle.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		lCMArmorLabel_0 = new JLabel("Kopf");
		lCMArmorLabel_0.setPreferredSize(new Dimension(80, 15));
		lCMArmorLabel_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMArmorLabel_1 = new JLabel("Brust");
		lCMArmorLabel_1.setPreferredSize(new Dimension(80, 15));
		lCMArmorLabel_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMArmorLabel_2 = new JLabel("R\u00FCcken");
		lCMArmorLabel_2.setPreferredSize(new Dimension(80, 15));
		lCMArmorLabel_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMArmorLabel_3 = new JLabel("rechter Arm");
		lCMArmorLabel_3.setPreferredSize(new Dimension(80, 15));
		lCMArmorLabel_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMArmorLabel_4 = new JLabel("linker Arm");
		lCMArmorLabel_4.setPreferredSize(new Dimension(80, 15));
		lCMArmorLabel_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMArmorLabel_5 = new JLabel("Bauch");
		lCMArmorLabel_5.setPreferredSize(new Dimension(80, 15));
		lCMArmorLabel_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMArmorLabel_6 = new JLabel("rechtes Bein");
		lCMArmorLabel_6.setPreferredSize(new Dimension(80, 15));
		lCMArmorLabel_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMArmorLabel_7 = new JLabel("linkes Bein");
		lCMArmorLabel_7.setPreferredSize(new Dimension(80, 15));
		lCMArmorLabel_7.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMArmorLabel_8 = new JLabel("Gesamte RS");
		lCMArmorLabel_8.setPreferredSize(new Dimension(80, 15));
		lCMArmorLabel_8.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lCMArmorLabel_9 = new JLabel("Behinderung");
		lCMArmorLabel_9.setPreferredSize(new Dimension(80, 15));
		lCMArmorLabel_9.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		tfCMArmorField_0 = new JTextField("0");
		tfCMArmorField_0.setPreferredSize(new Dimension(6, 15));
		tfCMArmorField_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMArmorField_0.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMArmorField_0.setEditable(false);
		tfCMArmorField_0.setColumns(2);
		
		tfCMArmorField_1 = new JTextField("0");
		tfCMArmorField_1.setPreferredSize(new Dimension(6, 15));
		tfCMArmorField_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMArmorField_1.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMArmorField_1.setEditable(false);
		tfCMArmorField_1.setColumns(2);
		
		tfCMArmorField_2 = new JTextField("0");
		tfCMArmorField_2.setPreferredSize(new Dimension(6, 15));
		tfCMArmorField_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMArmorField_2.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMArmorField_2.setEditable(false);
		tfCMArmorField_2.setColumns(2);
		
		tfCMArmorField_3 = new JTextField("0");
		tfCMArmorField_3.setPreferredSize(new Dimension(6, 15));
		tfCMArmorField_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMArmorField_3.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMArmorField_3.setEditable(false);
		tfCMArmorField_3.setColumns(2);
		
		tfCMArmorField_4 = new JTextField("0");
		tfCMArmorField_4.setPreferredSize(new Dimension(6, 15));
		tfCMArmorField_4.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMArmorField_4.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMArmorField_4.setEditable(false);
		tfCMArmorField_4.setColumns(2);
		
		tfCMArmorField_5 = new JTextField("0");
		tfCMArmorField_5.setPreferredSize(new Dimension(6, 15));
		tfCMArmorField_5.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMArmorField_5.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMArmorField_5.setEditable(false);
		tfCMArmorField_5.setColumns(2);
		
		tfCMArmorField_6 = new JTextField("0");
		tfCMArmorField_6.setPreferredSize(new Dimension(6, 15));
		tfCMArmorField_6.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMArmorField_6.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMArmorField_6.setEditable(false);
		tfCMArmorField_6.setColumns(2);
		
		tfCMArmorField_7 = new JTextField("0");
		tfCMArmorField_7.setPreferredSize(new Dimension(6, 15));
		tfCMArmorField_7.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMArmorField_7.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMArmorField_7.setEditable(false);
		tfCMArmorField_7.setColumns(2);
		
		tfCMArmorField_8 = new JTextField("0");
		tfCMArmorField_8.setPreferredSize(new Dimension(6, 15));
		tfCMArmorField_8.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMArmorField_8.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMArmorField_8.setEditable(false);
		tfCMArmorField_8.setColumns(2);
		
		tfCMArmorField_9 = new JTextField("0");
		tfCMArmorField_9.setPreferredSize(new Dimension(6, 15));
		tfCMArmorField_9.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfCMArmorField_9.setHorizontalAlignment(SwingConstants.CENTER);
		tfCMArmorField_9.setEditable(false);
		tfCMArmorField_9.setColumns(2);
		
		btCMArmorButton = new JButton("Modifizieren");
		btCMArmorButton.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btCMArmorButton.setEnabled(false);
		btCMArmorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openArmorFrame();
			}
		});
		
		GroupLayout gl_pCMArmorPanel = new GroupLayout(pCMArmorPanel);
		gl_pCMArmorPanel.setHorizontalGroup(
			gl_pCMArmorPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pCMArmorPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pCMArmorPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lCMArmorTitle, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
						.addGroup(gl_pCMArmorPanel.createSequentialGroup()
							.addComponent(lCMArmorLabel_0, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCMArmorField_0, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lCMArmorLabel_4, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCMArmorField_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pCMArmorPanel.createSequentialGroup()
							.addComponent(lCMArmorLabel_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCMArmorField_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lCMArmorLabel_5, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCMArmorField_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pCMArmorPanel.createSequentialGroup()
							.addComponent(lCMArmorLabel_2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCMArmorField_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lCMArmorLabel_6, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCMArmorField_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pCMArmorPanel.createSequentialGroup()
							.addComponent(lCMArmorLabel_3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCMArmorField_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lCMArmorLabel_7, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCMArmorField_7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pCMArmorPanel.createSequentialGroup()
							.addComponent(lCMArmorLabel_8, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCMArmorField_8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lCMArmorLabel_9, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfCMArmorField_9, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(btCMArmorButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pCMArmorPanel.setVerticalGroup(
			gl_pCMArmorPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pCMArmorPanel.createSequentialGroup()
					.addComponent(lCMArmorTitle, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pCMArmorPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lCMArmorLabel_0, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMArmorField_0, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lCMArmorLabel_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMArmorField_4, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pCMArmorPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lCMArmorLabel_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMArmorField_1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lCMArmorLabel_5, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMArmorField_5, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pCMArmorPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lCMArmorLabel_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMArmorField_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lCMArmorLabel_6, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMArmorField_6, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pCMArmorPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lCMArmorLabel_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMArmorField_3, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lCMArmorLabel_7, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMArmorField_7, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pCMArmorPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lCMArmorLabel_8, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMArmorField_8, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(lCMArmorLabel_9, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCMArmorField_9, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btCMArmorButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		pCMArmorPanel.setLayout(gl_pCMArmorPanel);
	}
	/**	Dh	3.7.2020
	 * 
	 */
	private void initCharManEquimentPanel() {
		pCMEquipmentPanel = new JPanel();
		pCMEquipmentPanel.setBackground(Color.WHITE);
		pCMEquipmentPanel.setBounds(10, 569, 290, 140);
		pCMPanel_1.add(pCMEquipmentPanel);
		
		spCMEquipmentScrollPane = new JScrollPane();
		spCMEquipmentScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		taCMEquipmentTextArea = new JTextArea();
		taCMEquipmentTextArea.setLineWrap(true);
		taCMEquipmentTextArea.setFont(new Font("Liberation Serif", Font.PLAIN, 10));
		taCMEquipmentTextArea.setEditable(false);
		taCMEquipmentTextArea.setBackground(SystemColor.controlHighlight);
		spCMEquipmentScrollPane.setViewportView(taCMEquipmentTextArea);
		
		lCMEquipmentTitle = new JLabel("Ausr\u00FCstung");
		lCMEquipmentTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lCMEquipmentTitle.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		btCMEquipmentButton = new JButton("Modifizieren");
		btCMEquipmentButton.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btCMEquipmentButton.setEnabled(false);
		btCMEquipmentButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openEquipmentFrame();
			}
		});
		
		GroupLayout gl_pCMEquipmentPanel = new GroupLayout(pCMEquipmentPanel);
		gl_pCMEquipmentPanel.setHorizontalGroup(
			gl_pCMEquipmentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pCMEquipmentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pCMEquipmentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(spCMEquipmentScrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
						.addComponent(lCMEquipmentTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
						.addComponent(btCMEquipmentButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pCMEquipmentPanel.setVerticalGroup(
			gl_pCMEquipmentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pCMEquipmentPanel.createSequentialGroup()
					.addComponent(lCMEquipmentTitle)
					.addGap(1)
					.addComponent(spCMEquipmentScrollPane, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btCMEquipmentButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		pCMEquipmentPanel.setLayout(gl_pCMEquipmentPanel);
	}
	/**	Dh	3.7.2020
	 * 
	 */
	private void initCharManTalentPanel() {
		pCMTalentPanel = new JPanel();
		pCMTalentPanel.setBackground(Color.WHITE);
		pCMTalentPanel.setBounds(610, 33, 309, 676);
		pCMPanel_1.add(pCMTalentPanel);
		
		lCMTalentTitle = new JLabel("Talente");
		lCMTalentTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lCMTalentTitle.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		spCMTalentScrollPane = new JScrollPane();
		
		tCMTalentPanelTable = new JTable();
		tCMTalentPanelTable.setEnabled(false);
		tCMTalentPanelTable.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tCMTalentPanelTable.setModel(rCMTalentTableModel);
		tCMTalentPanelTable.getTableHeader().setReorderingAllowed(false);
		spCMTalentScrollPane.setViewportView(tCMTalentPanelTable);
		
		btCMTalentButton = new JButton("Modifizieren");
		btCMTalentButton.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btCMTalentButton.setEnabled(false);
		btCMTalentButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openTalentFrame();
			}
		});
		
		GroupLayout gl_pCMTalentPanel = new GroupLayout(pCMTalentPanel);
		gl_pCMTalentPanel.setHorizontalGroup(
			gl_pCMTalentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pCMTalentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pCMTalentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(spCMTalentScrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
						.addComponent(lCMTalentTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
						.addComponent(btCMTalentButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pCMTalentPanel.setVerticalGroup(
			gl_pCMTalentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pCMTalentPanel.createSequentialGroup()
					.addComponent(lCMTalentTitle, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spCMTalentScrollPane, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btCMTalentButton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pCMTalentPanel.setLayout(gl_pCMTalentPanel);
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
					genPropMods[i] = genPropMods[i] + pGenPropMods[i];
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
	protected void addGenStatMods(int[] pGenStatMods) throws Exception {
		if(pGenStatMods != null) {
			if (pGenStatMods.length == 10) {
				for (int i=0; i<pGenStatMods.length; i++) {
					genStatMods[i] = genStatMods[i] + pGenStatMods[i];
				}
			} else throw new Exception("01; MaFra,aGSM");
		}else throw new Exception("04; MaFra,aGSM");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	24.6.2020
	 * 
	 */
	protected Point getMiddlePosition() {
		Point vPos = frmDsaAppV.getLocation();
		vPos.setLocation(vPos.getX()+(width/2), vPos.getY()+(height/2));
		return vPos;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	24.6.2020
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
					
					if (vListEle instanceof FightElement) pJLM.addElement(((FightElement)vListEle).getCharacter().getName(), ((FightElement)vListEle).getId());
					else if (vListEle instanceof int[]) {
						vFiEle = rFM.getFightElement(((int[])vListEle)[0]);
						if (vFiEle != null) {
							vIni = (int)((int[])vListEle)[1];
							if (vIni >= 10)	pJLM.addElement(vIni+"    "+vFiEle.getCharacter().getName(), ((int[])vListEle)[0]);
							else pJLM.addElement("  "+vIni+"    "+vFiEle.getCharacter().getName(), ((int[])vListEle)[0]);
						}
						else throw new Exception("04; MaFra, aLtM");
					} else if (vListEle instanceof IniElement) {
						vFiEle = rFM.getFightElement(((IniElement)vListEle).getId());
						if (vFiEle != null) pJLM.addElement(vFiEle.getCharacter().getName(), ((IniElement)vListEle).getId());
						else throw new Exception("04; MaFra, aLtM");
					} else if (vListEle instanceof NeighbourElement) {
						vFiEle = rFM.getFightElement(((NeighbourElement)vListEle).getId());
						if (vFiEle != null) pJLM.addElement(vFiEle.getCharacter().getName(), ((NeighbourElement)vListEle).getId());
						else throw new Exception("04; MaFra, aLtM");
					} else if (vListEle instanceof Charakter) {
						pJLM.addElement(((Charakter)vListEle).getName(), ((Charakter)vListEle).getId());
					} else throw new Exception("06; MaFra, aLtM");
					
					pList.next();
				}
			}else throw new Exception("04; MaFra, aLtM");
		}//else throw new Exception("05; MaFra, aLtM");
	}
	/**	Dh	11.7.2020
	 * 
	 * @param pTA
	 * @param pList
	 * @throws Exception
	 */
	private void addListToTextArea(JTextArea pTA, List pList) throws Exception{
		Object vListEle;
		String vText = "";
		
		if (pTA != null) {
			if (!pList.isEmpty()) {
				pTA.setText("");
				pList.toFirst();
				
				while(!pList.isEnd()) {
					vListEle = pList.getCurrent();
					
					if (vListEle instanceof Pro) vText = ((Pro)vListEle).getName();
					else if (vListEle instanceof SpecialCraft) vText = (((SpecialCraft)vListEle).getName());
					else if (vListEle instanceof Weapon) vText = (((Weapon)vListEle).getName());
					else throw new Exception("06; MaFra, aLtTA");
					
					//if (vListEle instanceof Referred) 
					if (vListEle instanceof Stringed) vText += " " + ((Stringed)vListEle).getStringedValue();
					if (vListEle instanceof Valued) vText += " " + ((Valued)vListEle).getValue();
					
					pTA.append(vText);
					
					if (!pList.isLast()) pTA.append(", ");
					else pTA.append(".");
					
					pList.next();
				}
			}else pTA.setText(vText);
		} else throw new Exception("04; MaFra, aLtTA");
	}
	/**	Dh	3.7.2020
	 * 
	 * 	TableType:
	 * 	  00: BasicTalents
	 * 
	 * @param pJTM
	 * @param pList
	 * @param pTableType
	 * @throws Exception
	 */
	private void addListToTable(JTable pJT, List pList, int pTableType) throws Exception{
		Object vListEle;
		String vText = "";
		Object[][] vData;
		int[] vIDs;
		String[] vColTitle;
		
		if (pJT != null) {
			if (!pList.isEmpty()) {
				if ((pTableType >= 0) && (pTableType < 1)) {
					pList.toFirst();
					
					vIDs = new int[pList.getContentNumber()];
					if (pTableType == 0) {
						vColTitle = new String[] {"Talent", "TaW"};
						vData = new Object[vIDs.length][2];
					}
					else {
						vColTitle = null;
						vData = null;
					}
					
					for(int i=0; !pList.isEnd(); i++) {
						vListEle = pList.getCurrent();
						
						if (vListEle instanceof Talent) {
							vIDs[i] = ((Talent)vListEle).getId();
							vData[i][0] = ((Talent)vListEle).getName();
							vData[i][1] = ((Talent)vListEle).getTaw();
						}
						else throw new Exception("06; MaFra, aLtT");
						
						pList.next();
					}
					
					((JTableModel)pJT.getModel()).setNewTable(vColTitle, vIDs, vData);
					
					//pJT.setEnabled(true);
					pJT.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
						@Override
						public Component getTableCellRendererComponent(JTable pTable, Object pObj, boolean isSelected, boolean hasFocus, int pRow, int pCol) {
							setHorizontalAlignment(SwingConstants.CENTER);
							setText(""+pTable.getValueAt(pRow, pCol));
							return this;
						}
					});
					pJT.getColumnModel().getColumn(0).setPreferredWidth(200);
					pJT.getColumnModel().getColumn(1).setMinWidth(10);
					pJT.getColumnModel().getColumn(1).setPreferredWidth(10);
					//pJT.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
					
					
					
				} else throw new Exception("02; MaFra, aLtT");
			}else ((JTableModel)pJT.getModel()).clearTable();
		}else throw new Exception("04; MaFra, aLtT");
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
	//-----
	/**	Dh	24.6.2020
	 * 
	 * @param pEnable
	 */
	private void setCharacterLisSelectionObjectsEnable(boolean pEnable) {
		int vIndSel = liCMCharList.getSelectedIndex();
		
		btCharListButton_0.setEnabled(pEnable);
		if ((rCharManListModel.getSize() > 0) || (pEnable == false)) {
			if ((pEnable == false) || (vIndSel == -1)) btCharListButton_1.setEnabled(pEnable);
			btCharListButton_2.setEnabled(pEnable);
		}
	}
	/**	Dh	3.7.2020
	 * 
	 * @param pEnable
	 */
	private void setCharManSelectedObjectes(boolean pEnable) {
		int vIndSel = liCMCharList.getSelectedIndex();
		
		if ((vIndSel != -1) || (pEnable == false)) {
			btCharListButton_1.setEnabled(pEnable);
			btCMGenButton.setEnabled(pEnable);
			btCMPropButton.setEnabled(pEnable);
			btCMStatButton.setEnabled(pEnable);
			btCMProButton.setEnabled(pEnable);
			btCMSpecialButton.setEnabled(pEnable);
			btCMArmorButton.setEnabled(pEnable);
			btCMEquipmentButton.setEnabled(pEnable);
			btCMTalentButton.setEnabled(pEnable);
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
	//-----
	/**	Dh	24.6.2020
	 * 
	 */
	private void updateCharacterList() {
		int vID, vTempID, vInd;
		vInd = liCMCharList.getSelectedIndex();
		if (vInd != -1) vID = (int)((JListModelElement)rCharManListModel.get(vInd)).getObject();
		else vID = -1;
		
		rCharManListModel.removeAllElements();
		try {addListToModel(rCharManListModel, rCM.getCharacterList());}
		catch(Exception ex) {handleException(ex);}
		
		if (vInd != -1) {
			for (int i=0; i<rCharManListModel.getSize(); i++) {
				vTempID = (int)((JListModelElement)rCharManListModel.get(i)).getObject();
				
				if (vID == vTempID) {
					liCMCharList.setSelectedIndex(i);
					i = rCharManListModel.getSize();
				}
			}
		}
		if (rCharManListModel.getSize() > 0) setCharacterLisSelectionObjectsEnable(true);
		//else setCharacterLisSelectionObjectsEnable(false);
	}
	
	/**	Dh	24.6.2020
	 * 
	 */
	private void updateFightManagerLists() {
		updateFightList();
		updateIniList();
		updateNeighbourList();
	}
	/**	Dh	24.6.2020
	 * 
	 */
	private void updateCharacterManagerLists() {
		updateCharacterList();
	}
	/**	Dh	24.6.2020
	 * 
	 * 	Updated alle Listen der GUI.
	 */
	private void updateLists() {
		updateCharacterManagerLists();
		updateFightManagerLists();
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
		int vTempValue, vInd;
		double vMaxValue;
		
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
		tfFMGenPropModField_0.setText(""+genPropMods[0]);
		tfFMGenPropModField_1.setText(""+genPropMods[1]);
		tfFMGenPropModField_2.setText(""+genPropMods[2]);
		tfFMGenPropModField_3.setText(""+genPropMods[3]);
		tfFMGenPropModField_4.setText(""+genPropMods[4]);
		tfFMGenPropModField_5.setText(""+genPropMods[5]);
		tfFMGenPropModField_6.setText(""+genPropMods[6]);
		tfFMGenPropModField_7.setText(""+genPropMods[7]);
		tfFMGenPropModField_8.setText(""+genPropMods[8]);
		
		tfFMGenStatModField_0.setText(""+(int)genStatMods[0]);
		tfFMGenStatModField_1.setText(""+(int)genStatMods[1]);
		tfFMGenStatModField_2.setText(""+(int)genStatMods[2]);
		tfFMGenStatModField_3.setText(""+(int)genStatMods[3]);
		tfFMGenStatModField_4.setText(""+(int)genStatMods[4]);
		tfFMGenStatModField_5.setText(""+(int)genStatMods[5]);
		tfFMGenStatModField_6.setText(""+(int)genStatMods[6]);
		tfFMGenStatModField_7.setText(""+(int)genStatMods[7]);
		tfFMGenStatModField_8.setText(""+(int)genStatMods[8]);
		tfFMGenStatModField_9.setText(""+(int)genStatMods[9]);
	}
	
	/**	Dh	24.5.2020
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
				
				vNeiList = rFM.getIdOfNeighboursOfFighter(vID);
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
	/**	Dh	24.5.2020
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
						if (isHexFMCharFieldGrid == false) {
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
	//-----
	/**	Dh	14.7.2020
	 * 
	 */
	private void updateSelectedCharacter() {
		int vSelInd, vID;
		
		vSelInd = liCMCharList.getSelectedIndex();
		if (vSelInd != -1) {
			vID = (int) rCharManListModel.getObjectAt(vSelInd);
			try {
				lCMP1Title.setText(""+rCM.getNameOfCharacter(vID));
				
				tfCMGenField_0.setText(""+rCM.getNameOfCharacter(vID));
				tfCMGenField_1.setText(""+rCM.getRaceOfCharacter(vID));
				tfCMGenField_2.setText(""+rCM.getCultureOfCharacter(vID));
				tfCMGenField_3.setText(""+rCM.getProfessionOfCharacter(vID));
				
				tfCMPropField_0.setText(""+rCM.getPropertyOfCharacter(vID, 0));
				tfCMPropField_1.setText(""+rCM.getPropertyOfCharacter(vID, 1));
				tfCMPropField_2.setText(""+rCM.getPropertyOfCharacter(vID, 2));
				tfCMPropField_3.setText(""+rCM.getPropertyOfCharacter(vID, 3));
				tfCMPropField_4.setText(""+rCM.getPropertyOfCharacter(vID, 4));
				tfCMPropField_5.setText(""+rCM.getPropertyOfCharacter(vID, 5));
				tfCMPropField_6.setText(""+rCM.getPropertyOfCharacter(vID, 6));
				tfCMPropField_7.setText(""+rCM.getPropertyOfCharacter(vID, 7));
				tfCMPropField_8.setText(""+rCM.getVelocityOfCharacter(vID));
				tfCMPropField_9.setText(""+rCM.getSocialStatusOfCharacter(vID));
				
				tfCMStatField_0.setText(""+rCM.getStatOfCharacter(vID, 0)+"/"+rCM.getMaxStatOfCharacter(vID, 0));
				tfCMStatField_1.setText(""+rCM.getStatOfCharacter(vID, 1)+"/"+rCM.getMaxStatOfCharacter(vID, 1));
				tfCMStatField_2.setText(""+rCM.getStatOfCharacter(vID, 2)+"/"+rCM.getMaxStatOfCharacter(vID, 2));
				tfCMStatField_3.setText(""+rCM.getStatOfCharacter(vID, 3)+"/"+rCM.getMaxStatOfCharacter(vID, 3));
				tfCMStatField_4.setText(""+rCM.getMagicResistanceOfCharacter(vID));
				tfCMStatField_5.setText(""+rCM.getWoundThresholdOfCharacter(vID));
				tfCMStatField_6.setText(""+rCM.getFightValueOfCharacter(vID, 0));
				tfCMStatField_7.setText(""+rCM.getFightValueOfCharacter(vID, 1));
				tfCMStatField_8.setText(""+rCM.getFightValueOfCharacter(vID, 2));
				tfCMStatField_9.setText(""+rCM.getFightValueOfCharacter(vID, 3));
				
				addListToTextArea(taCMProTextArea, rCM.getProListOfCharacter(vID));
				addListToTextArea(taCMSpecialTextArea, rCM.getSpecialCraftListOfCharacter(vID));
				
				tfCMArmorField_0.setText(""+(int)rCM.getArmorValueOfCharacter(vID, 0));
				tfCMArmorField_1.setText(""+(int)rCM.getArmorValueOfCharacter(vID, 1));
				tfCMArmorField_2.setText(""+(int)rCM.getArmorValueOfCharacter(vID, 2));
				tfCMArmorField_3.setText(""+(int)rCM.getArmorValueOfCharacter(vID, 3));
				tfCMArmorField_4.setText(""+(int)rCM.getArmorValueOfCharacter(vID, 4));
				tfCMArmorField_5.setText(""+(int)rCM.getArmorValueOfCharacter(vID, 5));
				tfCMArmorField_6.setText(""+(int)rCM.getArmorValueOfCharacter(vID, 6));
				tfCMArmorField_7.setText(""+(int)rCM.getArmorValueOfCharacter(vID, 7));
				tfCMArmorField_8.setText("");
				tfCMArmorField_9.setText(""+(int)rCM.getHandicapOfCharacter(vID));
				
				addListToTextArea(taCMEquipmentTextArea, rCM.getWeaponListOfCharacter(vID));
				addListToTable(tCMTalentPanelTable, rCM.getTalentListOfCharacter(vID), 0);
				
				setCharManSelectedObjectes(true);
			} catch (Exception ex) {handleException(ex);}
		} else {
			lCMP1Title.setText("");
			
			tfCMGenField_0.setText("");
			tfCMGenField_1.setText("");
			tfCMGenField_2.setText("");
			tfCMGenField_3.setText("");
			
			tfCMPropField_0.setText("");
			tfCMPropField_1.setText("");
			tfCMPropField_2.setText("");
			tfCMPropField_3.setText("");
			tfCMPropField_4.setText("");
			tfCMPropField_5.setText("");
			tfCMPropField_6.setText("");
			tfCMPropField_7.setText("");
			tfCMPropField_8.setText("");
			tfCMPropField_9.setText("");
			
			tfCMStatField_0.setText("");
			tfCMStatField_1.setText("");
			tfCMStatField_2.setText("");
			tfCMStatField_3.setText("");
			tfCMStatField_4.setText("");
			tfCMStatField_5.setText("");
			tfCMStatField_6.setText("");
			tfCMStatField_7.setText("");
			tfCMStatField_8.setText("");
			tfCMStatField_9.setText("");
			
			taCMProTextArea.setText("");
			taCMSpecialTextArea.setText("");
			
			tfCMArmorField_0.setText("");
			tfCMArmorField_1.setText("");
			tfCMArmorField_2.setText("");
			tfCMArmorField_3.setText("");
			tfCMArmorField_4.setText("");
			tfCMArmorField_5.setText("");
			tfCMArmorField_6.setText("");
			tfCMArmorField_7.setText("");
			tfCMArmorField_8.setText("");
			tfCMArmorField_9.setText("");
			
			taCMEquipmentTextArea.setText("");
			rCMTalentTableModel.clearTable();
			
			setCharManSelectedObjectes(false);
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
	/**	Dh	14.7.2020
	 * 
	 * 	Fuegt einen kämpfenden dem FightManager hinzu.
	 */
	private void addFighter() {
		try {rFM.addFighter(Loader.loadNewRandomCharakter(rFM.getCharacterOfFighters().getContentNumber()));}
		catch(Exception ex) {handleException(ex);}
		updateFightManagerLists();
	}
	/**	Dh	24.6.2020
	 * 
	 */
	private void deleteAllFighter() {
		rFM.removeAllFighters();
		updateFightManagerLists();
		updateSelectedFighter();
	}
	//-----
	/**	Dh	14.7.2020
	 * 
	 */
	private void addCharacter() {
		try {rCM.addCharacter(Loader.loadNewRandomCharakter(rFM.getCharacterOfFighters().getContentNumber()));}
		catch(Exception ex) {handleException(ex);}
		updateCharacterManagerLists();
	}
	/**	Dh	24.6.2020
	 * 
	 */
	private void deleteCharacter() {
		Object vID;
		int vSelInd = liCMCharList.getSelectedIndex();
		
		if (vSelInd != -1) {
			vID = rCharManListModel.getObjectAt(vSelInd);
			try {
				if (vID instanceof Integer){
					rCM.removeCharacter((int) vID);
					updateCharacterManagerLists();
					//updateSelectedCharacter();
				} else throw new Exception("06; MaFra,dC");
			} catch (Exception ex) {handleException(ex);}
		}
	}
	/**	Dh	24.6.2020
	 * 
	 */
	private void deleteAllCharacters() {
		rCM.removeAllCharacters();
		updateCharacterManagerLists();
		//updateSelectedCharacter();
	}
	
	/**	Dh	16.5.2020
	 * 
	 * 	Setzt die allgemeinen Mods zurück, und aktualisiert die ausgewaehlte Kaempfer*Innen Infos.
	 */
	private void resetGeneralMods() {
		try {
			genPropMods = negArrayValues(genPropMods);
			genStatMods = negArrayValues(genStatMods);
			rFM.addPropModsToFighters(genPropMods);
			rFM.addStatModsToFighters(genStatMods);
			genPropMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			genStatMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
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
			genPropMods = negArrayValues(genPropMods);
			genStatMods = negArrayValues(genStatMods);
			
			rFM.addPropModsToFighters(genPropMods);
			rFM.addStatModsToFighters(genStatMods);
		}catch(Exception ex) {handleException(ex);}
		
		genPropMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		genStatMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
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
		int[] vSpezPropMod, vSpezStatMod;
		
		vInd = liFMFightList.getSelectedIndex();
		if (vInd != -1) {
			vID = (int)((JListModelElement)rListModel1.get(vInd)).getObject();
			
			try {
				vSpezPropMod = rFM.getPropModsOfFighter(vID).clone();
				vSpezStatMod = rFM.getStatModsOfFighter(vID).clone();
				
				for (int i=0; i<10; i++) {
					vSpezPropMod[i] = vSpezPropMod[i] - genPropMods[i];
					vSpezStatMod[i] = vSpezStatMod[i] - genStatMods[i];
					
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
	//-----
	/**	Dh	14.7.2020
	 * 
	 */
	private void openGeneralFrame() {
		int vSelInd = liCMCharList.getSelectedIndex();
		
		if (vSelInd != -1) {
			GeneralCharFrame vGenFrame = new GeneralCharFrame((int)rCharManListModel.getObjectAt(vSelInd), rCM, this);
			vGenFrame.setVisible(true);
			
			setCharManSelectedObjectes(false);
		} else handleException(new Exception("09; MaFra,oGF"));
	}
	/**	Dh	24.6.2020
	 * 
	 */
	private void openPropertyFrame() {
		int vSelInd = liCMCharList.getSelectedIndex();
		
		if (vSelInd != -1) {
			PropertyFrame vPropFrame = new PropertyFrame((int)rCharManListModel.getObjectAt(vSelInd), rCM, this);
			vPropFrame.setVisible(true);
			
			setCharManSelectedObjectes(false);
		} else handleException(new Exception("09; MaFra,oPF"));
	}
	/**	Dh	24.6.2020
	 * 
	 */
	private void openStatusFrame() {
		int vSelInd = liCMCharList.getSelectedIndex();
		
		if (vSelInd != -1) {
			StatusFrame vStatFrame = new StatusFrame((int)rCharManListModel.getObjectAt(vSelInd), rCM, this);
			vStatFrame.setVisible(true);
			
			setCharManSelectedObjectes(false);
		} else handleException(new Exception("09; MaFra,oSF"));
	}
	/**	Dh	25.6.2020
	 * 
	 */
	private void openProFrame() {
		int vSelInd = liCMCharList.getSelectedIndex();
		
		if (vSelInd != -1) {
			ProFrame vProFrame = new ProFrame((int)rCharManListModel.getObjectAt(vSelInd), rCM, this);
			vProFrame.setVisible(true);
			
			setCharManSelectedObjectes(false);
		} else handleException(new Exception("09; MaFra,oPF"));
	}
	/**	Dh	1.7.2020
	 * 
	 */
	private void openSpecialCraftFrame() {
		int vSelInd = liCMCharList.getSelectedIndex();
		
		if (vSelInd != -1) {
			SpecialCraftFrame vSpecialFrame = new SpecialCraftFrame((int)rCharManListModel.getObjectAt(vSelInd), rCM, this);
			vSpecialFrame.setVisible(true);
			
			setCharManSelectedObjectes(false);
		} else handleException(new Exception("09; MaFra,oSCF"));
	}
	/**	Dh	3.7.2020
	 * 
	 */
	private void openArmorFrame() {
		int vSelInd = liCMCharList.getSelectedIndex();
		
		if (vSelInd != -1) {
			ArmorFrame vArmorFrame = new ArmorFrame((int)rCharManListModel.getObjectAt(vSelInd), rCM, this);
			vArmorFrame.setVisible(true);
			
			setCharManSelectedObjectes(false);
		} else handleException(new Exception("09; MaFra,oAF"));
	}
	/**	Dh	3.7.2020
	 * 
	 */
	private void openEquipmentFrame() {
		int vSelInd = liCMCharList.getSelectedIndex();
		
		if (vSelInd != -1) {
			EquipmentFrame vEquipFrame = new EquipmentFrame((int)rCharManListModel.getObjectAt(vSelInd), rCM, this);
			vEquipFrame.setVisible(true);
			
			setCharManSelectedObjectes(false);
		} else handleException(new Exception("09; MaFra,oEF"));
	}
	/**	Dh	11.7.2020
	 * 
	 */
	private void openTalentFrame() {
		int vSelInd = liCMCharList.getSelectedIndex();
		
		if (vSelInd != -1) {
			TalentFrame vTalentFrame = new TalentFrame((int)rCharManListModel.getObjectAt(vSelInd), rCM, this);
			vTalentFrame.setVisible(true);
			
			setCharManSelectedObjectes(false);
		} else handleException(new Exception("09; MaFra,oTF"));
	}
	/**	Dh	24.6.2020
	 * 
	 */
	protected void closeCharManModFrame() {
		setCharManSelectedObjectes(true);
		updateSelectedCharacter();
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
