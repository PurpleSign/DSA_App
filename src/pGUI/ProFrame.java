/**	DSA_App v0.0	Dh	2.7.2020
 * 
 * 	pGUI
 * 	  ProFrame
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

public class ProFrame extends JFrame {
	private int ID, Width, Height;
	private CharacterManager rCM;
	private MainFrame rMF;
	
	private JPanel contentPane, pProFramePanel;
	private JScrollPane sPProPanelScrollPane_0, sPProPanelScrollPane_1;
	
	private JLabel lProFrameTitle_0, lProFrameTitle_1;
	private JLabel lProPanelLabel_0, lProPanelLabel_1, lProPanelLabel_2, lProPanelLabel_3, lProPanelLabel_4;
	
	private JTextField tfProPanelField_0, tfProPanelField_1;
	
	private JButton btProFrameButton_0;
	private JButton btProPanelButton_0, btProPanelButton_1, btProPanelButton_2;
	
	private JSpinner spProPanelSpinner;
	
	private JList liProPanelList_0, liProPanelList_1;
	private JListModel rProListModel_0, rProListModel_1;

	/**
	 * Create the frame.
	 */
	public ProFrame(int pID, CharacterManager pCM, MainFrame pMF) {
		ID = pID;
		rCM = pCM;
		rMF = pMF;
		
		Width = 565;
		Height = 511;
		
		rProListModel_0 = new JListModel();
		rProListModel_1 = new JListModel();
		
		initFrame();
		
		setValues();
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	25.6.2020
	 * 
	 */
	private void initFrame() {
		Point vPos = rMF.getMiddlePosition();
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds((int)(vPos.getX()-(Width/2)), (int)(vPos.getY()-(Height/2)), Width, Height);
		//setBounds(100, 100, 566, 512);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lProFrameTitle_0 = new JLabel("Vor- und Nachteil Auswahl");
		lProFrameTitle_0.setHorizontalAlignment(SwingConstants.CENTER);
		lProFrameTitle_0.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		
		lProFrameTitle_1 = new JLabel("Test");
		lProFrameTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		lProFrameTitle_1.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		initPanel();
		
		btProFrameButton_0 = new JButton("Zur\u00FCck");
		btProFrameButton_0.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btProFrameButton_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lProFrameTitle_1, GroupLayout.DEFAULT_SIZE, 1107, Short.MAX_VALUE)
						.addComponent(lProFrameTitle_0, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1107, Short.MAX_VALUE)
						.addComponent(pProFramePanel, GroupLayout.PREFERRED_SIZE, 544, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(155)
							.addComponent(btProFrameButton_0, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lProFrameTitle_0, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lProFrameTitle_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pProFramePanel, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btProFrameButton_0, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	/**	Dh	25.6.2020
	 * 
	 */
	private void initPanel() {
		pProFramePanel = new JPanel();
		pProFramePanel.setBackground(UIManager.getColor("Button.shadow"));
		
		sPProPanelScrollPane_0 = new JScrollPane();
		sPProPanelScrollPane_1 = new JScrollPane();
		
		lProPanelLabel_0 = new JLabel("Erhaltene");
		lProPanelLabel_0.setHorizontalAlignment(SwingConstants.CENTER);
		lProPanelLabel_0.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		lProPanelLabel_1 = new JLabel("Auswahl");
		lProPanelLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lProPanelLabel_1.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		lProPanelLabel_2 = new JLabel("Vorteil");
		lProPanelLabel_2.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		
		lProPanelLabel_3 = new JLabel("Auswahl");
		lProPanelLabel_3.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		lProPanelLabel_4 = new JLabel("Wert");
		lProPanelLabel_4.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		liProPanelList_0 = new JList();
		liProPanelList_0.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sPProPanelScrollPane_0.setViewportView(liProPanelList_0);
		liProPanelList_0.setModel(rProListModel_0);
		liProPanelList_0.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				updateSelectedPro(true, liProPanelList_0.getSelectedIndex());
			}
		});
		liProPanelList_0.addContainerListener(new ContainerListener() {
			@Override
			public void componentRemoved(ContainerEvent e) {
				if (rProListModel_0.getSize() == 0) {
					if (liProPanelList_1.getSelectedIndex() == -1) btProPanelButton_0.setEnabled(false);
					btProPanelButton_1.setEnabled(false);
					btProPanelButton_2.setEnabled(false);
				}
			}
			@Override
			public void componentAdded(ContainerEvent e) {
				if (rProListModel_0.getSize() == 1) btProPanelButton_2.setEnabled(true);
			}
		});
		
		liProPanelList_1 = new JList();
		liProPanelList_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sPProPanelScrollPane_1.setViewportView(liProPanelList_1);
		liProPanelList_1.setModel(rProListModel_1);
		liProPanelList_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				updateSelectedPro(false, liProPanelList_1.getSelectedIndex());
			}
		});
		liProPanelList_1.addContainerListener(new ContainerListener() {
			@Override
			public void componentRemoved(ContainerEvent e) {
				if (liProPanelList_0.getSelectedIndex() == -1) btProPanelButton_0.setEnabled(false);
			}
			@Override
			public void componentAdded(ContainerEvent e) {
				
			}
		});
		
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
		spProPanelSpinner.setPreferredSize(new Dimension(25, 20));
		spProPanelSpinner.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		btProPanelButton_0 = new JButton("Hinzuf\u00FCgen");
		btProPanelButton_0.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btProPanelButton_0.setEnabled(false);
		btProPanelButton_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (liProPanelList_0.getSelectedIndex() != -1) applyChanges();
				else if (liProPanelList_1.getSelectedIndex() != -1) addPro();
			}
		});
		
		btProPanelButton_1 = new JButton("Entfernen");
		btProPanelButton_1.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btProPanelButton_1.setEnabled(false);
		btProPanelButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removePro();
			}
		});
		
		btProPanelButton_2 = new JButton("Alle entfernen");
		btProPanelButton_2.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btProPanelButton_2.setEnabled(false); 
		btProPanelButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAllPros();
			}
		});
		
		GroupLayout gl_pProFramePanel = new GroupLayout(pProFramePanel);
		gl_pProFramePanel.setHorizontalGroup(
			gl_pProFramePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pProFramePanel.createSequentialGroup()
					.addGroup(gl_pProFramePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pProFramePanel.createSequentialGroup()
							.addGap(10)
							.addComponent(sPProPanelScrollPane_0, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_pProFramePanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pProFramePanel.createSequentialGroup()
									.addGap(6)
									.addGroup(gl_pProFramePanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lProPanelLabel_2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_pProFramePanel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(tfProPanelField_0))
										.addGroup(Alignment.TRAILING, gl_pProFramePanel.createSequentialGroup()
											.addGroup(gl_pProFramePanel.createParallelGroup(Alignment.LEADING)
												.addComponent(lProPanelLabel_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
												.addComponent(tfProPanelField_1, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_pProFramePanel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lProPanelLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(spProPanelSpinner, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)))))
								.addGroup(gl_pProFramePanel.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_pProFramePanel.createParallelGroup(Alignment.LEADING)
										.addComponent(btProPanelButton_1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
										.addComponent(btProPanelButton_0, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
										.addComponent(btProPanelButton_2, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(lProPanelLabel_0, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pProFramePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lProPanelLabel_1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(sPProPanelScrollPane_1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_pProFramePanel.setVerticalGroup(
			gl_pProFramePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pProFramePanel.createSequentialGroup()
					.addGroup(gl_pProFramePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lProPanelLabel_0)
						.addComponent(lProPanelLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pProFramePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pProFramePanel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_pProFramePanel.createSequentialGroup()
								.addComponent(sPProPanelScrollPane_0, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
								.addGap(28))
							.addGroup(gl_pProFramePanel.createSequentialGroup()
								.addGap(42)
								.addComponent(lProPanelLabel_2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tfProPanelField_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_pProFramePanel.createParallelGroup(Alignment.LEADING)
									.addComponent(lProPanelLabel_3)
									.addComponent(lProPanelLabel_4))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_pProFramePanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(tfProPanelField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(spProPanelSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btProPanelButton_0, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btProPanelButton_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btProPanelButton_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addGap(57)))
						.addComponent(sPProPanelScrollPane_1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))
					.addGap(121))
		);
		pProFramePanel.setLayout(gl_pProFramePanel);
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	25.6.2020
	 * 
	 * @param pJLM
	 * @param pList
	 * @throws Exception
	 */
	private void addListToModel(JListModel pJLM, List pList) throws Exception {
		Object vListEle;
		int vID;
		String vText;
		
		if (!pList.isEmpty()) {
			if (pJLM != null) {
				pList.toFirst();
				
				while(!pList.isEnd()) {
					vListEle = pList.getCurrent();
					
					if (vListEle instanceof Pro) {
						vID = ((Pro) vListEle).getID();
						vText = ((Pro)vListEle).getName();
						
						if (pJLM.equals(rProListModel_0)) {
							//if (vListEle instanceof Referred)
							if (vListEle instanceof Stringed) vText += " "+((Stringed)vListEle).getStringedValue();
							if (vListEle instanceof Valued) vText += " "+((Valued)vListEle).getValue();
						}
						
						pJLM.addElement(vText, vID);
					}else throw new Exception("06; PrFra, aLtM");
					
					pList.next();
				}
			}else throw new Exception("04; PrFra, aLtM");
		}//else throw new Exception("05; MaFra, aLtM");
	}
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
			if ((rCM.haveProByCharacter(ID, "Vollzauberer")) || (rCM.haveProByCharacter(ID, "Halbzauberer")) || (rCM.haveProByCharacter(ID, "Viertelzauberer, unentdeckt"))
					|| (rCM.haveProByCharacter(ID, "Viertelzauberer, bekannt"))) vIsMagic = true;
			else vIsMagic = false;
			
			if (!vTemp.isEmpty()) {
				vTemp.toFirst();
				
				while(!vTemp.isEnd()) {
					vCur = vTemp.getCurrent();
					
					if (vCur instanceof Pro) {
						if (rCM.haveProByCharacter(ID, ((Pro)vCur).getID()) == true) vTemp.remove();
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
				
				addListToModel(rProListModel_1, vTemp);
			}
		}
	}
	
	/**	Dh	2.7.2020
	 * 
	 */
	private void setValues() {
		List vTemp;
		try {
			if ((ID >= 0) && (rCM.haveCharacterID(ID) == true)) {
				lProFrameTitle_1.setText("für "+rCM.getNameOfCharacter(ID));
				
				addListToModel(rProListModel_0, rCM.getProListOfCharacter(ID));
				addFreePros();
				
				if (rProListModel_0.getSize() > 0) btProPanelButton_2.setEnabled(true);
			} else {
				rMF.handleException(new Exception("02; PrFra,sV"));
				cancel();				
			}
		}catch (Exception ex) {rMF.handleException(ex);}
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	1.7.2020
	 * 
	 * @param pChoosed
	 * @param pInd
	 */
	private void updateSelectedPro(boolean pChoosed, int pInd) {
		Pro vCur;
		int vValue = -1;
		int vLimit = 0;
		String vName = "";
		String vText = null;
		
		if (pInd != -1) {
			try {
				if (pChoosed == true) {
					vCur = rCM.getProOfCharacter(ID, (int)rProListModel_0.getObjectAt(pInd));
					
					//if (vCur instanceof Referred)
					if (vCur instanceof Stringed) vText = ((Stringed)vCur).getStringedValue();
					if (vCur instanceof Valued) {
						vValue = ((Valued)vCur).getValue();
						vLimit = ((Valued)vCur).getValueLimit();
					}
					
					btProPanelButton_0.setEnabled(true);
					btProPanelButton_0.setText("Ändern");
					btProPanelButton_1.setEnabled(true);
					liProPanelList_1.clearSelection();
				}else {
					vCur = Loader.getPro((int)rProListModel_1.getObjectAt(pInd));
					
					//if (vCur instanceof Referred)
					if (vCur instanceof Stringed) vText = "";
					if (vCur instanceof Valued) {
						vValue = 1;
						vLimit = ((Valued)vCur).getValueLimit();
					}
					
					btProPanelButton_0.setEnabled(true);
					btProPanelButton_0.setText("Hinzufügen");
					liProPanelList_0.clearSelection();
				}
				
				vName = vCur.getName();
			}catch(Exception ex) {
				if (pChoosed == true) liProPanelList_0.clearSelection();
				else liProPanelList_1.clearSelection();
				
				rMF.handleException(ex);
			}
		}else {
			if (pChoosed == true) btProPanelButton_1.setEnabled(false);
			
			if ((liProPanelList_0.getSelectedIndex() == -1) && (liProPanelList_1.getSelectedIndex() == -1)) btProPanelButton_0.setEnabled(false);
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
	private void addPro() {
		String vText;
		Pro vPro;
		int vSelInd = liProPanelList_1.getSelectedIndex();
		
		if (vSelInd !=-1 ) {
			try {
				vPro = Loader.getPro((int)rProListModel_1.getObjectAt(vSelInd));
				
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
				
				rCM.addProToCharacter(ID, vPro);
				rProListModel_0.addElement(vText, vPro.getID());
				if (vText.equals("Vollzauberer") || vText.equals("Halbzauberer") || vText.equals("Viertelzauberer, unentdeckt") ||
						vText.equals("Viertelzauberer, bekannt")) {
					rProListModel_1.clear();
					addFreePros();
				}else rProListModel_1.removeElementAt(vSelInd);
				
				if (btProPanelButton_2.isEnabled() == false) btProPanelButton_2.setEnabled(true);
			} catch (Exception ex) {rMF.handleException(ex);}
		} else rMF.handleException(new Exception("07; PrFra,aP"));
	}
	/**	Dh	1.7.2020
	 * 
	 */
	private void applyChanges() {
		int vID;
		String vText;
		Pro vPro;
		
		int vSelInd = liProPanelList_0.getSelectedIndex();
		
		if (vSelInd !=-1 ) {
			vID = (int)rProListModel_0.getObjectAt(vSelInd);
			try {
				vPro = rCM.getProOfCharacter(ID, vID);
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
				
				rProListModel_0.setElementAt(new JListModelElement(vText, vPro.getID()), vSelInd);
				
			} catch (Exception ex) {rMF.handleException(ex);}
		} else rMF.handleException(new Exception("07; PrFra,aC"));
	}
	/**	Dh	2.7.2020
	 * 
	 */
	private void removePro() {
		int vID;
		int vSelInd = liProPanelList_0.getSelectedIndex();
		
		if (vSelInd != -1) {
			vID = (int)rProListModel_0.getObjectAt(vSelInd);
			try {
				rCM.removeProOfCharacter(ID, vID);
				rProListModel_0.removeElementAt(vSelInd);
				
				rProListModel_1.clear();
				addFreePros();
				
				if ((liProPanelList_0.getComponentCount() > 0) && (btProPanelButton_2.isEnabled() == false)) btProPanelButton_2.setEnabled(true);
				if (rProListModel_0.getSize() == 0) btProPanelButton_2.setEnabled(false);
			}catch(Exception ex) {rMF.handleException(ex);}
		} else rMF.handleException(new Exception("07; PrFra,rP"));
	}
	/**	Dh	25.6.2020
	 * 
	 */
	private void removeAllPros() {
		try {
			if (btProPanelButton_2.isEnabled() == true) btProPanelButton_2.setEnabled(false);
			rCM.setProListOfCharacter(ID, new List());
			rProListModel_0.clear();
			rProListModel_1.clear();
			addFreePros(); 
		} catch(Exception ex) {rMF.handleException(ex);} 
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	25.6.2020
	 * 
	 */
	private void cancel() {
		rMF.closeCharManModFrame();
		
		setVisible(false);
		dispose();
	}
}
