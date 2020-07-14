/**	DSA_App v0.0	Dh	14.7.2020
 * 
 * 	pGUI
 * 	  CharModFrame
 * 		CharValueModFrame
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
import java.awt.Color;
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
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import pLogik.CharacterManager;
import javax.swing.JTextField;

public class CharValueModFrame extends CharModFrame{
	protected JPanel contentPane, pFramePanel;
	protected JLabel lFrameTitle_0, lFrameTitle_1;
	protected JButton btFrameButton_0, btFrameButton_1;

	/**
	 * Create the frame.
	 */
	public CharValueModFrame(int pID, CharacterManager pCM, MainFrame pMF) {
		super(pID, pCM, pMF);
		
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);*/
	}

	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	14.7.2020
	 * 
	 */
	protected void initSize() {
		width = 310;
		height = 360;
	}
	/**	Dh	14.7.2020
	 * 
	 */
	protected void initModels() {}
		
	//----------------------------------------------------------------------------------------------------
		
	/**	Dh	14.7.2020
	 * 
	 */
	protected void initFrame() {
		Point vPos = rMF.getMiddlePosition();
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//setBounds((int)(vPos.getX()-(width/2)), (int)(vPos.getY()-(height/2)), width, height);
		setBounds(100, 100, 310, 360);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lFrameTitle_0 = new JLabel("Eigenschafts Auswahl");
		lFrameTitle_0.setHorizontalAlignment(SwingConstants.CENTER);
		lFrameTitle_0.setFont(new Font("Liberation Serif", Font.BOLD, 18));
		
		lFrameTitle_1 = new JLabel("Test");
		lFrameTitle_1.setFont(new Font("Liberation Serif", Font.BOLD, 12));
		lFrameTitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		pFramePanel = new JPanel();
		pFramePanel.setBackground(Color.WHITE);
		initSubPanel();
		
		btFrameButton_0 = new JButton("Anwenden");
		btFrameButton_0.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btFrameButton_0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				apply();
			}
		});
		
		btFrameButton_1 = new JButton("Abbrechen");
		btFrameButton_1.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		btFrameButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lFrameTitle_0, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lFrameTitle_1, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(pFramePanel, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btFrameButton_0, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btFrameButton_1, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lFrameTitle_0, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lFrameTitle_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pFramePanel, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btFrameButton_0, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btFrameButton_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	protected void initSubPanel() {}
	
//--------------------------------------------------------------------------------------------------------

	protected void setSpecificValues(int pID) throws Exception{}
	/**	Dh	14.7.2020
	 * 
	 */
	protected void setValues() {
		try {
			if ((id >= 0) && (rCM.haveCharacterID(id) == true)) {
				lFrameTitle_1.setText("für "+rCM.getNameOfCharacter(id));
				
				setSpecificValues(id);
			} else {
				rMF.handleException(new Exception("02; ChVaMoFra,sV"));
				cancel();				
			}
		}catch (Exception ex) {rMF.handleException(ex);}
	}
		
//--------------------------------------------------------------------------------------------------------

	protected void apply() {}
}
