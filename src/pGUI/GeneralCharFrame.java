/**	DSA_App v0.0	Dh	14.7.2020
 * 
 * 	pGUI
 * 	  CharModFrame
 * 		CharValueModFrame
 * 		  GeneralCharFrame
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

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import pLogik.CharacterManager;

public class GeneralCharFrame extends CharValueModFrame {
	private JLabel lGenPanelTitle, lGenPanelLabel_0, lGenPanelLabel_1, lGenPanelLabel_2, lGenPanelLabel_3;
	private JTextField tfGenPanelField_0, tfGenPanelField_1, tfGenPanelField_2, tfGenPanelField_3;
	
	public GeneralCharFrame(int pID, CharacterManager pCM, MainFrame pMF) {
		super(pID, pCM, pMF);
		// TODO Auto-generated constructor stub
	}

	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	14.7.2020
	 * 
	 */
	protected void initSubPanel() {
		lGenPanelTitle = new JLabel("Generelle Angaben");
		lGenPanelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lGenPanelTitle.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		
		lGenPanelLabel_0 = new JLabel("Name:");
		lGenPanelLabel_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lGenPanelLabel_1 = new JLabel("Rasse:");
		lGenPanelLabel_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lGenPanelLabel_2 = new JLabel("Kultur:");
		lGenPanelLabel_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		lGenPanelLabel_3 = new JLabel("Profession:");
		lGenPanelLabel_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		
		tfGenPanelField_0 = new JTextField();
		tfGenPanelField_0.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfGenPanelField_0.setColumns(10);
		
		tfGenPanelField_1 = new JTextField();
		tfGenPanelField_1.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfGenPanelField_1.setColumns(10);
		
		tfGenPanelField_2 = new JTextField();
		tfGenPanelField_2.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfGenPanelField_2.setColumns(10);
		
		tfGenPanelField_3 = new JTextField();
		tfGenPanelField_3.setFont(new Font("Liberation Serif", Font.PLAIN, 12));
		tfGenPanelField_3.setColumns(10);
		
		GroupLayout gl_pFramePanel = new GroupLayout(pFramePanel);
		gl_pFramePanel.setHorizontalGroup(
			gl_pFramePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFramePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pFramePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pFramePanel.createSequentialGroup()
							.addComponent(lGenPanelLabel_0, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfGenPanelField_0, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
						.addComponent(lGenPanelTitle, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
						.addGroup(gl_pFramePanel.createSequentialGroup()
							.addComponent(lGenPanelLabel_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfGenPanelField_1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pFramePanel.createSequentialGroup()
							.addComponent(lGenPanelLabel_2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfGenPanelField_2, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pFramePanel.createSequentialGroup()
							.addComponent(lGenPanelLabel_3, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfGenPanelField_3, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pFramePanel.setVerticalGroup(
			gl_pFramePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pFramePanel.createSequentialGroup()
					.addComponent(lGenPanelTitle)
					.addGap(18)
					.addGroup(gl_pFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lGenPanelLabel_0)
						.addComponent(tfGenPanelField_0, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lGenPanelLabel_1)
						.addComponent(tfGenPanelField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFramePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lGenPanelLabel_2)
						.addComponent(tfGenPanelField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pFramePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lGenPanelLabel_3)
						.addComponent(tfGenPanelField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		pFramePanel.setLayout(gl_pFramePanel);
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	14.7.2020
	 * 
	 */
	protected void setSpecificValues(int pID) throws Exception{
		lFrameTitle_0.setText("Generelles Eingabe");
		
		tfGenPanelField_0.setText(rCM.getNameOfCharacter(pID));
		tfGenPanelField_1.setText(rCM.getRaceOfCharacter(pID));
		tfGenPanelField_2.setText(rCM.getCultureOfCharacter(pID));
		tfGenPanelField_3.setText(rCM.getProfessionOfCharacter(pID));
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	14.7.2020
	 * 
	 */
	protected void apply() {
		try {
			if (!tfGenPanelField_0.getText().equals("")) rCM.setNameOfCharacter(id, tfGenPanelField_0.getText());
			
			rCM.setRaceOfCharacter(id, tfGenPanelField_1.getText());
			rCM.setCultureOfCharacter(id, tfGenPanelField_2.getText());
			rCM.setProfessionOfCharacter(id, tfGenPanelField_3.getText());
		}catch(Exception ex) {rMF.handleException(ex);}
		
		cancel();
	}
	
//--------------------------------------------------------------------------------------------------------
	
}
