/**	DSA_App v0.0	Dh	3.7.2020
 * 
 * 	pGUI
 * 	  EquipmentFrame
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
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pDataStructures.List;
import pDatenbank.Loader;
import pLogik.CharacterManager;
import pLogik.Pro;
import pLogik.Stringed;
import pLogik.Valued;
import pLogik.Weapon;

import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;

public class EquipmentFrame extends JFrame {
	private int ID, Width, Height;
	private CharacterManager rCM;
	private MainFrame rMF;
	
	private JPanel contentPane, pEquipFramePanel;
	private JScrollPane spEquipPanelScrollPane_0, spEquipPanelScrollPane_1;
	
	private JLabel lEquipFrameTitle_0, lEquipFrameTitle_1;
	private JLabel lEquipPanelTitle_0, lEquipPanelTitle_1, lEquipLabel_0, lEquipLabel_1, lEquipLabel_2;
	
	private JTextField tfEquipPanelField_0, tfEquipPanelField_1;
	private JSpinner spinner;
	
	private JButton btEquipFrameButton, btEquipPanelButton_0, btEquipPanelButton_1, btEquipPanelButton_2;
	
	private JList liEquipPanelList_0, liEquipPanelList_1;
	private JListModel rEquipListModel_0, rEquipListModel_1;

	/**
	 * Create the frame.
	 */
	public EquipmentFrame(int pID, CharacterManager pCM, MainFrame pMF) {
		ID = pID;
		rCM = pCM;
		rMF = pMF;
		
		Width = 565;
		Height = 511;
		
		rEquipListModel_0 = new JListModel();
		rEquipListModel_1 = new JListModel();
		
		initFrame();
		
		setValues();
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	3.7.2020
	 * 
	 */
	private void initFrame() {
		Point vPos = rMF.getMiddlePosition();
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//setBounds((int)(vPos.getX()-(Width/2)), (int)(vPos.getY()-(Height/2)), Width, Height);
		setBounds(100, 100, 566, 512);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lEquipFrameTitle_0 = new JLabel("Ausr\u00FCstungs Auswahl");
		lEquipFrameTitle_0.setHorizontalAlignment(SwingConstants.CENTER);
		lEquipFrameTitle_0.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		
		lEquipFrameTitle_1 = new JLabel("Test");
		lEquipFrameTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		lEquipFrameTitle_1.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		initEquipPanel();
		
		btEquipFrameButton = new JButton("Zur\u00FCck");
		btEquipFrameButton.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btEquipFrameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lEquipFrameTitle_0, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
				.addComponent(lEquipFrameTitle_1, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(pEquipFramePanel, GroupLayout.PREFERRED_SIZE, 544, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(151)
					.addComponent(btEquipFrameButton, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(174, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lEquipFrameTitle_0, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lEquipFrameTitle_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pEquipFramePanel, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btEquipFrameButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	/**	Dh	3.7.2020
	 * 
	 */
	private void initEquipPanel() {
		pEquipFramePanel = new JPanel();
		pEquipFramePanel.setBackground(SystemColor.controlShadow);
		
		lEquipPanelTitle_0 = new JLabel("Besitzende");
		lEquipPanelTitle_0.setHorizontalAlignment(SwingConstants.CENTER);
		lEquipPanelTitle_0.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		lEquipPanelTitle_1 = new JLabel("Auswahl");
		lEquipPanelTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		lEquipPanelTitle_1.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		spEquipPanelScrollPane_0 = new JScrollPane();
		spEquipPanelScrollPane_1 = new JScrollPane();
		
		liEquipPanelList_0 = new JList();
		liEquipPanelList_0.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liEquipPanelList_0.setModel(rEquipListModel_0);
		liEquipPanelList_0.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				updateSelectedPro(true, liEquipPanelList_0.getSelectedIndex());
			}
		});
		spEquipPanelScrollPane_0.setViewportView(liEquipPanelList_0);
		
		liEquipPanelList_1 = new JList();
		liEquipPanelList_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liEquipPanelList_1.setModel(rEquipListModel_1);
		liEquipPanelList_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				updateSelectedPro(false, liEquipPanelList_1.getSelectedIndex());
			}
		});
		spEquipPanelScrollPane_1.setViewportView(liEquipPanelList_1);
		
		lEquipLabel_0 = new JLabel("Ausr\u00FCstung");
		lEquipLabel_0.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		
		lEquipLabel_1 = new JLabel("Auswahl");
		lEquipLabel_1.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		lEquipLabel_2 = new JLabel("Wert");
		lEquipLabel_2.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		tfEquipPanelField_0 = new JTextField();
		tfEquipPanelField_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfEquipPanelField_0.setEditable(false);
		tfEquipPanelField_0.setColumns(10);
		
		tfEquipPanelField_1 = new JTextField();
		tfEquipPanelField_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfEquipPanelField_1.setEditable(false);
		tfEquipPanelField_1.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setPreferredSize(new Dimension(25, 20));
		spinner.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		spinner.setEnabled(false);
		
		btEquipPanelButton_0 = new JButton("Hinzuf\u00FCgen");
		btEquipPanelButton_0.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btEquipPanelButton_0.setEnabled(false);
		btEquipPanelButton_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (liEquipPanelList_0.getSelectedIndex() != -1) applyChanges();
				else if (liEquipPanelList_1.getSelectedIndex() != -1) addEquipment();
			}
		});
		
		btEquipPanelButton_1 = new JButton("Entfernen");
		btEquipPanelButton_1.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btEquipPanelButton_1.setEnabled(false);
		btEquipPanelButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeEquipment();
			}
		});
		
		btEquipPanelButton_2 = new JButton("Alle entfernen");
		btEquipPanelButton_2.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btEquipPanelButton_2.setEnabled(false);
		btEquipPanelButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAllEquipments();
			}
		});
		
		GroupLayout gl_pEquipFramePanel = new GroupLayout(pEquipFramePanel);
		gl_pEquipFramePanel.setHorizontalGroup(
			gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 544, Short.MAX_VALUE)
				.addGroup(gl_pEquipFramePanel.createSequentialGroup()
					.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pEquipFramePanel.createSequentialGroup()
							.addGap(10)
							.addComponent(spEquipPanelScrollPane_0, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pEquipFramePanel.createSequentialGroup()
									.addGap(6)
									.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lEquipLabel_0, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_pEquipFramePanel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(tfEquipPanelField_0, 166, 166, 166))
										.addGroup(gl_pEquipFramePanel.createSequentialGroup()
											.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING)
												.addComponent(lEquipLabel_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
												.addComponent(tfEquipPanelField_1, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lEquipLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)))))
								.addGroup(gl_pEquipFramePanel.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING)
										.addComponent(btEquipPanelButton_1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
										.addComponent(btEquipPanelButton_0, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
										.addComponent(btEquipPanelButton_2, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(lEquipPanelTitle_0, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lEquipPanelTitle_1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(spEquipPanelScrollPane_1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_pEquipFramePanel.setVerticalGroup(
			gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 361, Short.MAX_VALUE)
				.addGroup(gl_pEquipFramePanel.createSequentialGroup()
					.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lEquipPanelTitle_0)
						.addComponent(lEquipPanelTitle_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_pEquipFramePanel.createSequentialGroup()
								.addComponent(spEquipPanelScrollPane_0, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
								.addGap(28))
							.addGroup(gl_pEquipFramePanel.createSequentialGroup()
								.addGap(42)
								.addComponent(lEquipLabel_0)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tfEquipPanelField_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.LEADING)
									.addComponent(lEquipLabel_1)
									.addComponent(lEquipLabel_2))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_pEquipFramePanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(tfEquipPanelField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btEquipPanelButton_0, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btEquipPanelButton_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btEquipPanelButton_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addGap(57)))
						.addComponent(spEquipPanelScrollPane_1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))
					.addGap(121))
		);
		pEquipFramePanel.setLayout(gl_pEquipFramePanel);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	3.7.2020
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
					
					if (vListEle instanceof Weapon) {
						vID = ((Weapon) vListEle).getID();
						vText = ((Weapon)vListEle).getName();
						
						pJLM.addElement(vText, vID);
					}else throw new Exception("06; EqFra, aLtM");
					
					pList.next();
				}
			}else throw new Exception("04; EqFra, aLtM");
		}//else throw new Exception("05; MaFra, aLtM");
	}
	
	/**	Dh	3.7.2020
	 * 
	 */
	private void setValues() {
		List vTemp;
		try {
			if ((ID >= 0) && (rCM.haveCharacterID(ID) == true)) {
				lEquipFrameTitle_1.setText("für "+rCM.getNameOfCharacter(ID));
				
				addListToModel(rEquipListModel_0, rCM.getWeaponListOfCharacter(ID));
				addListToModel(rEquipListModel_1, Loader.getWeaponList());
				
				if (rEquipListModel_0.getSize() > 0) btEquipPanelButton_2.setEnabled(true);
			} else {
				rMF.handleException(new Exception("02; EqFra,sV"));
				cancel();				
			}
		}catch (Exception ex) {rMF.handleException(ex);}
	}
	
	//----------------------------------------------------------------------------------------------------

	/**	Dh	3.7.2020
	 * 
	 * @param pChoosed
	 * @param pInd
	 */
	private void updateSelectedPro(boolean pChoosed, int pInd) {
		Weapon vCur;
		String vName = "";
		String vText = null;
		
		if (pInd != -1) {
			try {
				if (pChoosed == true) {
					vCur = rCM.getWeaponOfCharacter(ID, (int)rEquipListModel_0.getObjectAt(pInd));
					
					
					/*if (vCur instanceof Stringed) vText = ((Stringed)vCur).getStringedValue();
					if (vCur instanceof Valued) {
						vValue = ((Valued)vCur).getValue();
						vLimit = ((Valued)vCur).getValueLimit();
					}*/
					
					btEquipPanelButton_0.setEnabled(true);
					btEquipPanelButton_0.setText("Ändern");
					btEquipPanelButton_1.setEnabled(true);
					liEquipPanelList_1.clearSelection();
				}else {
					vCur = Loader.getWeapon((int)rEquipListModel_1.getObjectAt(pInd));
					
					//if (vCur instanceof Referred)
					/*if (vCur instanceof Stringed) vText = "";
					if (vCur instanceof Valued) {
						vValue = 1;
						vLimit = ((Valued)vCur).getValueLimit();
					}*/
					
					btEquipPanelButton_0.setEnabled(true);
					btEquipPanelButton_0.setText("Hinzufügen");
					liEquipPanelList_0.clearSelection();
				}
				
				vName = vCur.getName();
			}catch(Exception ex) {
				if (pChoosed == true) liEquipPanelList_0.clearSelection();
				else liEquipPanelList_1.clearSelection();
				
				rMF.handleException(ex);
			}
		}else {
			if (pChoosed == true) btEquipPanelButton_1.setEnabled(false);
			
			if ((liEquipPanelList_0.getSelectedIndex() == -1) && (liEquipPanelList_1.getSelectedIndex() == -1)) btEquipPanelButton_0.setEnabled(false);
		}
		
		tfEquipPanelField_0.setText(""+vName);
		
		if (vText != null) {
			tfEquipPanelField_1.setText(vText);
			tfEquipPanelField_1.setEditable(true);
		} else {
			tfEquipPanelField_1.setText("");
			tfEquipPanelField_1.setEditable(false);
		}
	}
	
//--------------------------------------------------------------------------------------------------------
	
	private void addEquipment() {
		String vText;
		/*Pro vPro;
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
		} else rMF.handleException(new Exception("07; PrFra,aP"));*/
	}
	
	private void applyChanges() {
		int vID;
		String vText;
		/*Pro vPro;
		
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
		} else rMF.handleException(new Exception("07; PrFra,aC"));*/
	}
	/**	Dh	3.7.2020
	 * 
	 */
	private void removeEquipment() {
		int vID;
		int vSelInd = liEquipPanelList_0.getSelectedIndex();
		
		if (vSelInd != -1) {
			vID = (int)rEquipListModel_0.getObjectAt(vSelInd);
			try {
				rCM.removeWeaponOfCharacter(ID, vID);
				rEquipListModel_0.removeElementAt(vSelInd);
				
				addListToModel(rEquipListModel_1, Loader.getWeaponList());
				
				if ((liEquipPanelList_0.getComponentCount() > 0) && (btEquipPanelButton_2.isEnabled() == false)) btEquipPanelButton_2.setEnabled(true);
				if (rEquipListModel_0.getSize() == 0) btEquipPanelButton_2.setEnabled(false);
			}catch(Exception ex) {rMF.handleException(ex);}
		} else rMF.handleException(new Exception("07; EqFra,rE"));
	}
	/**	Dh	3.7.2020
	 * 
	 */
	private void removeAllEquipments() {
		try {
			if (btEquipPanelButton_2.isEnabled() == true) btEquipPanelButton_2.setEnabled(false);
			rCM.setWeaponListOfCharacter(ID, new List());
			rEquipListModel_0.clear();
			addListToModel(rEquipListModel_1, Loader.getWeaponList());
		} catch(Exception ex) {rMF.handleException(ex);} 
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	3.7.2020
	 * 
	 */
	private void cancel() {
		rMF.closeCharManModFrame();
		
		setVisible(false);
		dispose();
	}
}
