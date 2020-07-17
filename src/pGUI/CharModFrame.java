/**	DSA_App v0.0	Dh	16.7.2020
 * 
 * 	pGUI
 * 	  CharModFrame
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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pDataStructures.List;
import pDatenbank.Loader;
import pLogik.CharacterManager;

public abstract class CharModFrame extends JFrame {
	protected int id, width, height;
	protected CharacterManager rCM;
	protected MainFrame rMF;	
	
	/**	Dh	16.7.2020
	 * 
	 */
	public CharModFrame() {
		
	}
	/**	Dh	11.7.2020
	 * 
	 * @param pID
	 * @param pCM
	 * @param pMF
	 */
	public CharModFrame(int pID, CharacterManager pCM, MainFrame pMF) {
		id = pID;
		rCM = pCM;
		rMF = pMF;
		
		initSize();
		initModels();
		
		initFrame();
		
		setValues();
	}
	/**	Dh	11.7.2020
	 * 
	 * @param pID
	 * @param pCM
	 * @param pMF
	 * @param pWidth
	 * @param pHeight
	 */
	public CharModFrame(int pID, CharacterManager pCM, MainFrame pMF, int pWidth, int pHeight) {
		id = pID;
		rCM = pCM;
		rMF = pMF;
		
		width = pWidth;
		height = pHeight;
		
		initModels();
		
		initFrame();
		
		setValues();
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
	
	/**	Dh	11.7.2020
	 * 
	 */
	protected void cancel() {
		rMF.closeCharManModFrame();
		
		setVisible(false);
		dispose();
	}
}
