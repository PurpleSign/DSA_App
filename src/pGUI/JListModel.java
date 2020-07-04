/**	DSA_App v0.0	Dh	6.5.2020
 * 
 * 	pGUI
 * 	  JListModel
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

import  javax.swing.DefaultListModel;
import pGUI.JListModelElement;

public class JListModel extends DefaultListModel {
	
	/**	Dh	6.5.2020
	 * 
	 * 	Gibt den Text des Elementes des entsprechenden Indexes aus.
	 * 
	 * @param pInd
	 * @return
	 */
	public Object getElementAt(int pInd) {
		JListModelElement vEle = (JListModelElement) super.getElementAt(pInd);
		return vEle.getText();
	}
	/**	Dh	6.5.2020
	 * 
	 * 	Gibt das Objekt des Elementes des entsprechenden Indexes aus.
	 * 
	 * @param pInd
	 * @return
	 */
	public Object getObjectAt(int pInd) {
		JListModelElement vEle = (JListModelElement) super.getElementAt(pInd);
		return vEle.getObject();
	}
	
	/**	Dh	6.5.2020
	 * 
	 * @param pEle
	 */
	public void addElement(JListModelElement pEle) {
		super.addElement(pEle);
	}
	/**	Dh	6.5.2020
	 * 
	 * @param pText
	 * @param pObject
	 * @throws Exception
	 */
	public void addElement(String pText, Object pObject) throws Exception {
		if (pText != null && pObject != null) {
			addElement(new JListModelElement(pText, pObject));
		} else throw new Exception("04; JLiMod, aE");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	1.7.2020
	 * 
	 * @param pEle
	 * @param pInd
	 * @throws Exception
	 */
	public void changeElementAt(JListModelElement pEle,  int pInd) throws Exception {
		super.setElementAt(pEle, pInd);
	}
}
