/**	DSA_App v0.0	Dh	 9.7.2020
 * 	
 * 	pDatenbank
 * 	  ProDatabase
 * 
 * Exceptions:
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
package pDatenbank;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import pDataStructures.List;
import pLogik.BadCharacteristic;
import pLogik.Pro;
import pLogik.ReferredPro;
import pLogik.SpecialCraft;
import pLogik.StringedPro;
import pLogik.StringedValuedPro;
import pLogik.ValuedPro;

@XmlRootElement(name = "prodatabase")
@XmlSeeAlso(Pro.class)
public class ProDatabase {
	private List proList;
	
	/**	Dh	16.6.2020
	 * 
	 * 	Konstruktor nach Bean-Vorschrift.
	 */
	public ProDatabase() {
		proList = new List();
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pProList
	 */
	public ProDatabase(List pProList) {
		proList = new List();
		try {setProList(pProList);}
		catch(Exception ex) {System.out.println(ex);}
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	16.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	protected Pro getPro(int pID) throws Exception {
		Pro vRet = null;
		
		if ((pID >= 0) && (pID < proList.getContentNumber())) {
			proList.toFirst();
			
			while (!proList.isEnd()) {
				vRet = (Pro) proList.getCurrent();
				
				if (vRet.getId() == pID) proList.toLast();
				else vRet = null;
				
				proList.next();
			}
			
			if (vRet == null) throw new Exception("02; ProDat,gP");
			else vRet = copyPro(vRet);
		}else throw new Exception("02; ProDat,gP");
		
		return vRet;
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pName
	 * @return
	 * @throws Exception
	 */
	protected Pro getPro(String pName) throws Exception{
		Pro vRet = null;
		
		if (pName != "") {
			if (!proList.isEmpty()) {
				proList.toFirst();
				
				while (!proList.isEnd()) {
					vRet = (Pro) proList.getCurrent();
					
					if (vRet.getName().equals(pName)) proList.toLast();
					else vRet = null;
					
					proList.next();
				}
			}
			if (vRet == null) throw new Exception("02; ProDat,gP; "+pName);
			else vRet = copyPro(vRet);
		}else throw new Exception("02; ProDat,gP");
		
		return vRet;
	}
	
	/**	Dh	25.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "ProList")
	public List getProList() {
		return proList.copyList();
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	16.6.2020
	 * 
	 * @param pProList
	 * @throws Exception
	 */
	public void setProList(List pProList) throws Exception{
		Object vCur;
		boolean containsOnlyPros = true;
		
		if (pProList != null) {
			if (!pProList.isEmpty()) {
				pProList.toFirst();
				
				while (!pProList.isEnd() && (containsOnlyPros == true)) {
					vCur = pProList.getCurrent();
					
					if (!(vCur instanceof Pro)) containsOnlyPros = false;
					
					pProList.next();
				}
				
				if (containsOnlyPros == true) proList = pProList;
				else throw new Exception("06; ProDat,sPL");
			} proList = pProList;
		} else throw new Exception("04; ProDat,sPL");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	16.6.2020
	 * 
	 * @param pPro
	 * @throws Exception
	 */
	protected void addPro(Pro pPro) throws Exception{
		if (pPro != null) {
			pPro.setId(proList.getContentNumber());
			proList.append(pPro);
		}else throw new Exception("04; ProDat,aP");
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pPros
	 * @throws Exception
	 */
	protected void addPros(List pPros) throws Exception{
		Object vCur;
		
		if (pPros != null) {
			if (!pPros.isEmpty()) {
				pPros.toFirst();
				
				while(!pPros.isEnd()) {
					vCur = pPros.getCurrent();
					
					if (vCur instanceof Pro) addPro((Pro) vCur);
					else throw new Exception("06; ProDat,aPs");
					
					pPros.next();
				}
			}throw new Exception("05; ProDat,aPs");
		}throw new Exception("04; ProDat,aPs");
	}
	
	/**	Dh	16.6.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	protected void removePro(int pID) throws Exception{
		if ((pID >= 0) && (pID < proList.getContentNumber())) {
			proList.toFirst();
			
			while(!proList.isEnd()) {
				if (((Pro)proList.getCurrent()).getId() == pID) {
					proList.remove();
					proList.toLast();
				}
				
				proList.next();
			}
		}else throw new Exception("02; ProDat,rP");
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pIDList
	 * @throws Exception
	 */
	protected void removePros(List pIDList) throws Exception{
		Object vCur;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) removePro((int)vCur);
					else throw new Exception("06; ProDat,rPs");
					
					pIDList.next();
				}
			} throw new Exception("05; ProDat,rPs");
		} throw new Exception("04; ProDat,rPs");
	}
	
	/**	Dh	16.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	protected boolean havePro(int pID) throws Exception{
		boolean vRet = false;
		
		if (pID >= 0) {
			if (pID < proList.getContentNumber()) vRet = true;
		}else throw new Exception("02; ProDat,hP");
		
		return vRet;
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pPro
	 * @return
	 * @throws Exception
	 */
	protected boolean havePro(Pro pPro) throws Exception{
		boolean vRet = false;
		Pro vCur;
		
		if (pPro != null) {
			if (!proList.isEmpty()) {
				proList.toFirst();
				
				while((!proList.isEnd()) && (vRet == false)) {
					vCur = (Pro)proList.getCurrent();
					
					if (vCur.getId() == pPro.getId()) vRet = true;
					
					proList.next();
				}
			}
		} else throw new Exception("04; ProDat,hP");
		
		return vRet;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	1.7.2020
	 * 
	 * @param pPro
	 * @return
	 */
	private Pro copyPro(Pro pPro) {
		Pro vRet = null;
		
		try {
			if (pPro instanceof ValuedPro) {
				if (pPro instanceof BadCharacteristic) vRet = new BadCharacteristic();
				else if(pPro instanceof StringedValuedPro) vRet = new StringedValuedPro();
				else vRet = new ValuedPro();
			}else if (pPro instanceof ReferredPro) vRet = new ReferredPro();
			else if (pPro instanceof StringedPro) vRet = new StringedPro();
			else vRet = new Pro();
			
			vRet.setId(pPro.getId());
			vRet.setName(pPro.getName());
			
			vRet.setPro(pPro.isPro());
			vRet.setArkane(pPro.isArkane());
			vRet.setGift(pPro.isGift());
			
			if (pPro instanceof ValuedPro) {
				((ValuedPro)vRet).setValue(((ValuedPro)pPro).getValue());
				((ValuedPro)vRet).setValueLimit(((ValuedPro)pPro).getValueLimit());
			}
			if (pPro instanceof StringedPro) ((StringedPro)vRet).setStringedValue(((StringedPro)pPro).getStringedValue());
			if (pPro instanceof StringedValuedPro) ((StringedValuedPro)vRet).setStringedValue(((StringedValuedPro)pPro).getStringedValue());
			if (pPro instanceof ReferredPro) ((ReferredPro)vRet).setReferredValue(((ReferredPro)pPro).getReferredValue());
		} catch(Exception ex) {System.out.println(ex.getMessage());}
		
		return vRet;
	}
}
