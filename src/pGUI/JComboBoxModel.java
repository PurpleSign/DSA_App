/**	DSA_App v0.0	Dh	22.5.2020
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

import javax.swing.DefaultComboBoxModel;
import pGUI.JListModelElement;

public class JComboBoxModel extends DefaultComboBoxModel {
	
	/**	Dh	22.5.2020
	 * 
	 */
	public Object getSelectedItem() {
		Object vRet = null;
		JListModelElement vEle = (JListModelElement) super.getSelectedItem();
		if (vEle != null) vRet = vEle.getText();
		
		return vRet;
	}
	/**	Dh	22.5.2020
	 * 
	 * @return
	 */
	public Object getSelectedObject() {
		Object vRet = null;
		JListModelElement vEle = (JListModelElement) super.getSelectedItem();
		if (vEle != null) vRet = vEle.getObject();
		
		return vRet;
	}
	
	/**	Dh	22.5.2020
	 * 
	 */
	public void setSelectedItem(Object pSel) {
		if (super.getSize() != 0) {
			for(int i=0; i < super.getSize(); i++) {
				if (getElementAt(i) == pSel) super.setSelectedItem(super.getElementAt(i));
			}
		}
	}
	/**	Dh	22.5.2020
	 * 
	 * @param pSel
	 */
	public void setSelectedObjetc(Object pSel) {
		if (super.getSize() != 0) {
			for(int i=0; i < super.getSize(); i++) {
				if (getObjectAt(i) == pSel) super.setSelectedItem(super.getElementAt(i));
			}
		}
	}
	
	/**	Dh	22.5.2020
	 * 
	 * 	Implementiert die neue Version des getElementAt, auf Basis des JListModelElement.
	 */
	public Object getElementAt(int pInd) {
		JListModelElement vEle = (JListModelElement) super.getElementAt(pInd);
		return vEle.getText();
	}
	/**	Dh	22.5.2020
	 * 
	 * 	Implementiert getObjektAt, auf Basis des JListModelElement.
	 * 
	 * @param pInd
	 * @return
	 */
	public Object getObjectAt(int pInd) {
		JListModelElement vEle = (JListModelElement) super.getElementAt(pInd);
		return vEle.getObject();
	}
	
	/**	Dh	22.5.2020
	 * 
	 * @param pEle
	 */
	public void addElement(JListModelElement pEle) {
		super.addElement(pEle);
	}
	/**	Dh	22.5.2020
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
	
	/**	Dh	22.5.2020
	 * 
	 * @param pEle
	 * @param pInd
	 */
	public void insertElementAt(JListModelElement pEle, int pInd) {
		super.insertElementAt(pEle, pInd);
	}
	/**	Dh	22.5.2020
	 * 
	 * @param pText
	 * @param pObject
	 * @param pInd
	 * @throws Exception
	 */
	public void insertElementAt(String pText, Object pObject, int pInd) throws Exception {
		if (pText != null && pObject != null) {
			insertElementAt(new JListModelElement(pText, pObject), pInd);
		} else throw new Exception("04; JLiMod, iEa");
	}
	
}