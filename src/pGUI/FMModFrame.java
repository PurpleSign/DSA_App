/**	DSA_App v0.0	Dh	15.7.2020
 * 
 * 	pGUI
 * 	  FMModFrame
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

import pLogik.FightManager;

public abstract class FMModFrame extends JFrame {
	protected int id, width, height;
	protected FightManager rFM;
	protected MainFrame rMF;


	/**
	 * Create the frame.
	 */
	public FMModFrame(int pID, FightManager pFM, MainFrame pMF) {
		id = pID;
		rFM = pFM;
		rMF = pMF;
		
		initSize();
		initModels();
		
		initFrame();
		
		setValues();
		
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);*/
	}

	//----------------------------------------------------------------------------------------------------
	
	protected abstract void initSize();
	protected abstract void initModels();
		
//----------------------------------------------------------------------------------------------------
		
	protected abstract void initFrame();

//--------------------------------------------------------------------------------------------------------

	//protected abstract void setSpecificValues(int pID) throws Exception;
		
	protected abstract void setValues();

//--------------------------------------------------------------------------------------------------------
		
	/**	Dh	15.7.2020
	 * 
	 */
	protected void cancel() {
		//rMF.closeCharManModFrame();
		
		//setVisible(false);
		//dispose();
	}
}
