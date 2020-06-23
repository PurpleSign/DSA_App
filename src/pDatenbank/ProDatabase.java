/**	DSA_App v0.0	Dh	 17.6.2020
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
	private List ProList;
	
	/**	Dh	16.6.2020
	 * 
	 * 	Konstruktor nach Bean-Vorschrift.
	 */
	public ProDatabase() {
		ProList = new List();
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pProList
	 */
	public ProDatabase(List pProList) {
		ProList = new List();
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
		
		if ((pID >= 0) && (pID < ProList.getContentNumber())) {
			ProList.toFirst();
			
			while (!ProList.isEnd()) {
				vRet = (Pro) ProList.getCurrent();
				
				if (vRet.getID() == pID) ProList.toLast();
				else vRet = null;
				
				ProList.next();
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
			if (!ProList.isEmpty()) {
				ProList.toFirst();
				
				while (!ProList.isEnd()) {
					vRet = (Pro) ProList.getCurrent();
					
					if (vRet.getName().equals(pName)) ProList.toLast();
					else vRet = null;
					
					ProList.next();
				}
			}
			if (vRet == null) throw new Exception("02; ProDat,gP; "+pName);
			else vRet = copyPro(vRet);
		}else throw new Exception("02; ProDat,gP");
		
		return vRet;
	}
	
	/**	Dh	16.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "ProList")
	public List getProList() {
		return ProList;
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
				
				if (containsOnlyPros == true) ProList = pProList;
				else throw new Exception("06; ProDat,sPL");
			} ProList = pProList;
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
			pPro.setID(ProList.getContentNumber());
			ProList.append(pPro);
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
		if ((pID >= 0) && (pID < ProList.getContentNumber())) {
			ProList.toFirst();
			
			while(!ProList.isEnd()) {
				if (((Pro)ProList.getCurrent()).getID() == pID) {
					ProList.remove();
					ProList.toLast();
				}
				
				ProList.next();
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
			if (pID < ProList.getContentNumber()) vRet = true;
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
			if (!ProList.isEmpty()) {
				ProList.toFirst();
				
				while((!ProList.isEnd()) && (vRet == false)) {
					vCur = (Pro)ProList.getCurrent();
					
					if (vCur.getID() == pPro.getID()) vRet = true;
					
					ProList.next();
				}
			}
		} else throw new Exception("04; ProDat,hP");
		
		return vRet;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	17.6.2020
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
			
			vRet.setID(pPro.getID());
			vRet.setName(pPro.getName());
			
			vRet.setPro(pPro.isPro());
			vRet.setArkane(pPro.isArkane());
			vRet.setGift(pPro.isGift());
			
			if (pPro instanceof ValuedPro) ((ValuedPro)vRet).setValue(((ValuedPro)pPro).getValue());
			if (pPro instanceof StringedPro) ((StringedPro)vRet).setStringedValue(((StringedPro)pPro).getStringedValue());
			if (pPro instanceof StringedValuedPro) ((StringedValuedPro)vRet).setStringedValue(((StringedValuedPro)pPro).getStringedValue());
			if (pPro instanceof ReferredPro) ((ReferredPro)vRet).setReferredValue(((ReferredPro)pPro).getReferredValue());
		} catch(Exception ex) {System.out.println(ex.getMessage());}
		
		return vRet;
	}
}