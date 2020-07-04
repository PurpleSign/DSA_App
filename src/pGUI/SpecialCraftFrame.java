/**	DSA_App v0.0	Dh	2.7.2020
 * 
 * 	pGUI
 * 	  SpecialCraftFrame
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

public class SpecialCraftFrame extends JFrame {
	private int ID, Width, Height;
	private CharacterManager rCM;
	private MainFrame rMF;
	
	private JPanel contentPane, pSpecialPanel;
	private JScrollPane spSpecialPanelScrollPane_0, spSpecialPanelScrollPane_1;
	
	private JLabel lSpecialFrameTitle_0, lSpecialFrameTitle_1;
	private JLabel lSpecialPanelLabel_0, lSpecialPanelLabel_1, lSpecialPanelLabel_2, lSpecialPanelLabel_3, lSpecialPanelLabel_4;
	
	private JTextField tfSpecialPanelField_0, tfSpecialPanelField_1;
	
	private JButton btSpecialPanelButton_0, btSpecialPanelButton_1, btSpecialPanelButton_2, btSpecialFrameButton;
	
	private JList liSpecialPanelList_0, liSpecialPanelList_1;
	private JListModel rSpecialListModel_0, rSpecialListModel_1;

	/**
	 * Create the frame.
	 */
	public SpecialCraftFrame(int pID, CharacterManager pCM, MainFrame pMF) {
		ID = pID;
		rCM = pCM;
		rMF = pMF;
		
		Width = 565;
		Height = 511;
		
		rSpecialListModel_0 = new JListModel();
		rSpecialListModel_1 = new JListModel();
		
		initFrame();
		
		setValues();
	}

	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	1.7.2020
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
		
		lSpecialFrameTitle_0 = new JLabel("Sonderfertigkeiten Auswahl");
		lSpecialFrameTitle_0.setHorizontalAlignment(SwingConstants.CENTER);
		lSpecialFrameTitle_0.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		
		lSpecialFrameTitle_1 = new JLabel("Test");
		lSpecialFrameTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		lSpecialFrameTitle_1.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		initPanel();
		
		btSpecialFrameButton = new JButton("Zur\u00FCck");
		btSpecialFrameButton.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btSpecialFrameButton.addActionListener(new ActionListener() {
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
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lSpecialFrameTitle_0, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lSpecialFrameTitle_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
						.addComponent(pSpecialPanel, GroupLayout.PREFERRED_SIZE, 544, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(144)
							.addComponent(btSpecialFrameButton, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lSpecialFrameTitle_0, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lSpecialFrameTitle_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pSpecialPanel, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btSpecialFrameButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	/**	Dh	2.7.2020
	 * 
	 */
	private void initPanel() {
		pSpecialPanel = new JPanel();
		pSpecialPanel.setBackground(SystemColor.controlShadow);
		
		spSpecialPanelScrollPane_0 = new JScrollPane();
		liSpecialPanelList_0 = new JList();
		liSpecialPanelList_0.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liSpecialPanelList_0.setModel(rSpecialListModel_0);
		liSpecialPanelList_0.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				updateSelectedSpecialCraft(true, liSpecialPanelList_0.getSelectedIndex());
			}
		});

		spSpecialPanelScrollPane_0.setViewportView(liSpecialPanelList_0);
		
		spSpecialPanelScrollPane_1 = new JScrollPane();
		liSpecialPanelList_1 = new JList();
		liSpecialPanelList_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		liSpecialPanelList_1.setModel(rSpecialListModel_1);
		liSpecialPanelList_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				updateSelectedSpecialCraft(false, liSpecialPanelList_1.getSelectedIndex());
			}
		});

		spSpecialPanelScrollPane_1.setViewportView(liSpecialPanelList_1);
		
		lSpecialPanelLabel_0 = new JLabel("Erhaltene");
		lSpecialPanelLabel_0.setHorizontalAlignment(SwingConstants.CENTER);
		lSpecialPanelLabel_0.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		lSpecialPanelLabel_1 = new JLabel("Auswahl");
		lSpecialPanelLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lSpecialPanelLabel_1.setFont(new Font("Liberation Serif", Font.BOLD, 16));
		
		lSpecialPanelLabel_2 = new JLabel("Sonderfertigkeit");
		lSpecialPanelLabel_2.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		
		lSpecialPanelLabel_3 = new JLabel("Auswahl");
		lSpecialPanelLabel_3.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		lSpecialPanelLabel_4 = new JLabel("Wert");
		lSpecialPanelLabel_4.setVisible(false);
		lSpecialPanelLabel_4.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		
		tfSpecialPanelField_0 = new JTextField();
		tfSpecialPanelField_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfSpecialPanelField_0.setEditable(false);
		tfSpecialPanelField_0.setColumns(10);
		
		tfSpecialPanelField_1 = new JTextField();
		tfSpecialPanelField_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfSpecialPanelField_1.setEditable(false);
		tfSpecialPanelField_1.setColumns(10);
		
		btSpecialPanelButton_0 = new JButton("Hinzuf\u00FCgen");
		btSpecialPanelButton_0.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btSpecialPanelButton_0.setEnabled(false);
		btSpecialPanelButton_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (liSpecialPanelList_0.getSelectedIndex() != -1) applyChanges();
				else if (liSpecialPanelList_1.getSelectedIndex() != -1) addSpecialCraft();
			}
		});
		
		btSpecialPanelButton_1 = new JButton("Entfernen");
		btSpecialPanelButton_1.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btSpecialPanelButton_1.setEnabled(false);
		btSpecialPanelButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeSpecialCraft();
			}
		});
		
		btSpecialPanelButton_2 = new JButton("Alle entfernen");
		btSpecialPanelButton_2.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btSpecialPanelButton_2.setEnabled(false);
		btSpecialPanelButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAllSpecialCrafts();
			}
		});
		
		GroupLayout gl_pSpecialPanel = new GroupLayout(pSpecialPanel);
		gl_pSpecialPanel.setHorizontalGroup(
			gl_pSpecialPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 544, Short.MAX_VALUE)
				.addGroup(gl_pSpecialPanel.createSequentialGroup()
					.addGroup(gl_pSpecialPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pSpecialPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(spSpecialPanelScrollPane_0, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_pSpecialPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pSpecialPanel.createSequentialGroup()
									.addGap(6)
									.addGroup(gl_pSpecialPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lSpecialPanelLabel_2, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_pSpecialPanel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(tfSpecialPanelField_0, 166, 166, 166))
										.addGroup(gl_pSpecialPanel.createSequentialGroup()
											.addGroup(gl_pSpecialPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(lSpecialPanelLabel_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
												.addComponent(tfSpecialPanelField_1, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lSpecialPanelLabel_4))))
								.addGroup(gl_pSpecialPanel.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_pSpecialPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(btSpecialPanelButton_1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
										.addComponent(btSpecialPanelButton_0, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
										.addComponent(btSpecialPanelButton_2, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(lSpecialPanelLabel_0, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pSpecialPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lSpecialPanelLabel_1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(spSpecialPanelScrollPane_1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_pSpecialPanel.setVerticalGroup(
			gl_pSpecialPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 361, Short.MAX_VALUE)
				.addGroup(gl_pSpecialPanel.createSequentialGroup()
					.addGroup(gl_pSpecialPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lSpecialPanelLabel_0)
						.addComponent(lSpecialPanelLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pSpecialPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pSpecialPanel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_pSpecialPanel.createSequentialGroup()
								.addComponent(spSpecialPanelScrollPane_0, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
								.addGap(28))
							.addGroup(gl_pSpecialPanel.createSequentialGroup()
								.addGap(42)
								.addComponent(lSpecialPanelLabel_2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tfSpecialPanelField_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_pSpecialPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(lSpecialPanelLabel_3)
									.addComponent(lSpecialPanelLabel_4))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(tfSpecialPanelField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btSpecialPanelButton_0, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btSpecialPanelButton_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btSpecialPanelButton_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addGap(57)))
						.addComponent(spSpecialPanelScrollPane_1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))
					.addGap(121))
		);
		pSpecialPanel.setLayout(gl_pSpecialPanel);
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	1.7.2020
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
					
					if (vListEle instanceof SpecialCraft) {
						vID = ((SpecialCraft) vListEle).getID();
						vText = ((SpecialCraft)vListEle).getName();
						
						if (pJLM.equals(rSpecialListModel_0)) {
							//if (vListEle instanceof Referred)
							if (vListEle instanceof Stringed) vText += " "+((Stringed)vListEle).getStringedValue();
						}
						
						pJLM.addElement(vText, vID);
					}else throw new Exception("06; SpCrFra, aLtM");
					
					pList.next();
				}
			}else throw new Exception("04; SpCrFra, aLtM");
		}//else throw new Exception("05; SpCrFra, aLtM");
	}
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
						if (rCM.haveSpecialCraftByCharacter(ID, ((SpecialCraft)vCur).getID()) == true) vTemp.remove();
						else if (!rCM.satisfyPremisesOfCharacter(ID, ((SpecialCraft)vCur).getID())) vTemp.remove();
						else vTemp.next();
					}else throw new Exception("06; SpCrFra,aFP");
				}
				
				addListToModel(rSpecialListModel_1, vTemp);
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
				lSpecialFrameTitle_1.setText("für "+rCM.getNameOfCharacter(ID));
				
				addListToModel(rSpecialListModel_0, rCM.getProListOfCharacter(ID));
				addFreeSpecials();
				
				if (rSpecialListModel_0.getSize() > 0) btSpecialPanelButton_2.setEnabled(true);
			} else {
				rMF.handleException(new Exception("02; SpCrFra,sV"));
				cancel();				
			}
		}catch (Exception ex) {rMF.handleException(ex);}
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	2.7.2020
	 * 
	 * @param pChoosed
	 * @param pInd
	 */
	private void updateSelectedSpecialCraft(boolean pChoosed, int pInd) {
		SpecialCraft vCur;
		String vName = "";
		String vText = null;
		
		if (pInd != -1) {
			try {
				if (pChoosed == true) {
					vCur = rCM.getSpecialCraftOfCharacter(ID, (int)rSpecialListModel_0.getObjectAt(pInd));
					
					//if (vCur instanceof Referred)
					if (vCur instanceof Stringed) vText = ((Stringed)vCur).getStringedValue();
					
					
					btSpecialPanelButton_0.setEnabled(true);
					btSpecialPanelButton_0.setText("Ändern");
					btSpecialPanelButton_1.setEnabled(true);
					liSpecialPanelList_1.clearSelection();
				}else {
					vCur = Loader.getSpecialCraft((int)rSpecialListModel_1.getObjectAt(pInd));
					
					//if (vCur instanceof Referred)
					if (vCur instanceof Stringed) vText = "";
					
					btSpecialPanelButton_0.setEnabled(true);
					btSpecialPanelButton_0.setText("Hinzufügen");
					liSpecialPanelList_0.clearSelection();
				}
				
				vName = vCur.getName();
			}catch(Exception ex) {
				if (pChoosed == true) liSpecialPanelList_0.clearSelection();
				else liSpecialPanelList_1.clearSelection();
				
				rMF.handleException(ex);
			}
		}else {
			if (pChoosed == true) btSpecialPanelButton_1.setEnabled(false);
			
			if ((liSpecialPanelList_0.getSelectedIndex() == -1) && (liSpecialPanelList_1.getSelectedIndex() == -1)) btSpecialPanelButton_0.setEnabled(false);
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
	private void addSpecialCraft() {
		String vText;
		SpecialCraft vSpec;
		int vSelInd = liSpecialPanelList_1.getSelectedIndex();
		
		if (vSelInd !=-1 ) {
			try {
				vSpec = Loader.getSpecialCraft((int)rSpecialListModel_1.getObjectAt(vSelInd));
				
				vText = vSpec.getName();
				//if (vPro instanceof Referred)
				if (vSpec instanceof Stringed) {
					vText += " "+tfSpecialPanelField_1.getText();
					((Stringed)vSpec).setStringedValue(tfSpecialPanelField_1.getText());
				}
				
				rCM.addSpecialCraftToCharacter(ID, vSpec);
				rSpecialListModel_0.addElement(vText, vSpec.getID());
				
				rSpecialListModel_1.clear();
				addFreeSpecials();
				if (btSpecialPanelButton_2.isEnabled() == false) btSpecialPanelButton_2.setEnabled(true);
			} catch (Exception ex) {rMF.handleException(ex);}
		} else rMF.handleException(new Exception("07; SpCrFra,aSC"));
	}
	/**	Dh	2.7.2020
	 * 
	 */
	private void applyChanges() {
		int vID;
		String vText;
		SpecialCraft vSpec;
		
		int vSelInd = liSpecialPanelList_0.getSelectedIndex();
		
		if (vSelInd !=-1 ) {
			vID = (int)rSpecialListModel_0.getObjectAt(vSelInd);
			try {
				vSpec = rCM.getSpecialCraftOfCharacter(ID, vID);
				vText = vSpec.getName();
				
				//if (vPro instanceof Referred)
				if (vSpec instanceof Stringed) { 
					if (!tfSpecialPanelField_1.getText().equals("")) {
						((Stringed)vSpec).setStringedValue(tfSpecialPanelField_1.getText());
						vText += " " + ((Stringed)vSpec).getStringedValue();
					}
				}
				
				rSpecialListModel_0.setElementAt(new JListModelElement(vText, vSpec.getID()), vSelInd);
				
			} catch (Exception ex) {rMF.handleException(ex);}
		} else rMF.handleException(new Exception("07; SpCaFra,aC"));
	}
	/**	Dh	2.7.2020
	 * 
	 */
	private void removeSpecialCraft() {
		int vID;
		int vSelInd = liSpecialPanelList_0.getSelectedIndex();
		
		if (vSelInd != -1) {
			vID = (int)rSpecialListModel_0.getObjectAt(vSelInd);
			try {
				rCM.removeSpecialCraftOfCharacter(ID, vID);
				rSpecialListModel_0.removeElementAt(vSelInd);
				
				rSpecialListModel_1.clear();
				addFreeSpecials();
				
				if ((liSpecialPanelList_0.getComponentCount() > 0) && (btSpecialPanelButton_2.isEnabled() == false)) btSpecialPanelButton_2.setEnabled(true);
				if (rSpecialListModel_0.getSize() == 0) btSpecialPanelButton_2.setEnabled(false);
			}catch(Exception ex) {rMF.handleException(ex);}
		} else rMF.handleException(new Exception("07; SpCaFra,rSC"));
	}
	/**	Dh	2.7.2020
	 * 
	 */
	private void removeAllSpecialCrafts() {
		try {
			if (btSpecialPanelButton_2.isEnabled() == true) btSpecialPanelButton_2.setEnabled(false);
			rCM.setSpecialCraftListOfCharacter(ID, new List());
			rSpecialListModel_0.clear();
			rSpecialListModel_1.clear();
			addFreeSpecials(); 
		} catch(Exception ex) {rMF.handleException(ex);} 
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	1.7.2020
	 * 
	 */
	private void cancel() {
		rMF.closeCharManModFrame();
		
		setVisible(false);
		dispose();
	}
}