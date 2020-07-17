/**	DSA_App v0.0	Dh	14.7.2020
 * 
 * 	pGUI
 * 	  JSpinnModel
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

import javax.swing.AbstractSpinnerModel;

import pDataStructures.List;

public class JSpinnModel extends AbstractSpinnerModel {
	private List rList;
	
	/**	Dh	10.7.2020
	 * 
	 */
	public JSpinnModel() {
		rList = new List();
	}
	/**	Dh	10.7.2020
	 * 
	 * @param pList
	 */
	public JSpinnModel(List pList) {
		try {setList(pList);}
		catch(Exception ex) {MainFrame.handleException(ex);}
	}
	/**	Dh	14.7.2020
	 * 
	 * 	Erstellt ein SpinnModel mit vordefinierten Listen, je nach Eingabe.
	 * 
	 * 	pPreDefTypeInd:
	 * 	   0: DK-Liste.
	 * 	   1: Reichweiten-Liste
	 * 
	 * @param pPreDefTypeInd
	 */
	public JSpinnModel(int pPreDefTypeInd) {
		rList = new List();
		
		if (pPreDefTypeInd == 0) {
			rList.append(new JListModelElement("H", 0));
			rList.append(new JListModelElement("N", 1));
			rList.append(new JListModelElement("S", 2));
			rList.append(new JListModelElement("P", 3));
			
			rList.append(new JListModelElement("HN", 4));
			rList.append(new JListModelElement("NP", 5));
			rList.append(new JListModelElement("PS", 6));
			
			rList.append(new JListModelElement("HNS", 7));
			rList.append(new JListModelElement("NSP", 8));
			
			rList.append(new JListModelElement("HNSP", 9));
		}else if (pPreDefTypeInd == 1) {
			rList.append(new JListModelElement("", -1));
			rList.append(new JListModelElement("H", 0));
			rList.append(new JListModelElement("N", 1));
			rList.append(new JListModelElement("S", 2));
			rList.append(new JListModelElement("P", 3));
			
			for (int i=4; i <= 1000; i++) {
				rList.append(new JListModelElement(""+i, i));
			}
		}
	}

//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	10.7.2020
	 * 
	 */
	public Object getNextValue() {
		Object vRet = null;
		
		if (!rList.isEmpty() && !rList.isEnd()) {
			if (!rList.isLast()) {
				rList.next();
				vRet = ((JListModelElement)rList.getCurrent()).getText();
				rList.prior();
			} else vRet = ((JListModelElement)rList.getCurrent()).getText();
		} else vRet = "";
		
		return vRet;
	}
	/**	Dh	10.7.2020
	 * 
	 */
	public Object getPreviousValue() {
		Object vRet = null;
		
		if (!rList.isEmpty() && !rList.isEnd()) {
			if (!rList.isFirst()) {
				rList.prior();
				vRet = ((JListModelElement)rList.getCurrent()).getText();
				rList.next();
			} else vRet = ((JListModelElement)rList.getCurrent()).getText();
		} else vRet = "";
		
		return vRet;
	}
	
	/**	Dh	10.7.2020
	 * 
	 */
	public Object getValue() {
		if (!rList.isEnd()) return ((JListModelElement)rList.getCurrent()).getText();
		else return "";
	}
	/**	Dh	10.7.2020
	 * 
	 * @return
	 */
	public Object getObject() {
		if (!rList.isEnd()) return ((JListModelElement)rList.getCurrent()).getObject();
		else return null;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	10.7.2020
	 * 
	 */
	public void setValue(Object pObj) {
		boolean isFinished = false;
		
		if (!rList.isEmpty()) {
			rList.toFirst();
			
			while(!rList.isEnd() && (isFinished == false)) {
				if (((JListModelElement)rList.getCurrent()).getText().equals(pObj)) isFinished = true;
				else rList.next();
			}
		}
		
		fireStateChanged();
	}
	/**	Dh	10.7.2020
	 * 
	 * @param pObj
	 */
	public void setObject(Object pObj) {
		boolean isFinished = false;
		
		if (!rList.isEmpty()) {
			rList.toFirst();
			
			while(!rList.isEnd() && (isFinished == false)) {
				if (((JListModelElement)rList.getCurrent()).getObject().equals(pObj)) isFinished = true;
				else rList.next();
			}
		}
		
		fireStateChanged();
	}
	
	/**	Dh	10.7.2020
	 * 
	 * @param pList
	 * @throws Exception
	 */
	public void setList(List pList) throws Exception{
		Object vCur;
		boolean vContainsOnlyModelElements = true;
		
		if (pList != null) {
			if (!pList.isEmpty()) {
				pList.toFirst();
				
				while(!pList.isEnd() && (vContainsOnlyModelElements == true)) {
					vCur = pList.getCurrent();
					
					if (!(vCur instanceof JListModelElement)) vContainsOnlyModelElements = false;
					
					pList.next();
				}
			}
			
			if (vContainsOnlyModelElements == true) rList = pList;
			else throw new Exception("06; JSpMod,sL");
		} else throw new Exception("04; JSpMod,sL");
	}
}
