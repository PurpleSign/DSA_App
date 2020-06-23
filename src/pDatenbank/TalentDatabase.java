/**	DSA_App v0.0	Dh 10.6.2020
 * 
 * 	Datenbank
 * 	  TalentDatabase
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
 * 
 * 	  20 Wrong OS
 */
package pDatenbank;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import pDataStructures.List;
import pLogik.Basictalent;
import pLogik.Communicationtalent;
import pLogik.Fighttalent;
import pLogik.PhysicalTalent;
import pLogik.Talent;

@XmlRootElement(name = "talents")
@XmlType(propOrder = { "talentList", "basicTalents"})
@XmlSeeAlso({Talent.class})
public class TalentDatabase {
	private List TalentList;
	private int[] BasicTalents;
	
	/**	Dh	9.6.2020
	 * 
	 * 	Konstruktor nach Bean-Standart.
	 */
 	public TalentDatabase() {
		TalentList = new List();
		BasicTalents = null;
	}
	/**	Dh	9.6.2020
	 * 
	 * @param pTalentList
	 */
	public TalentDatabase(List pTalentList) {
		TalentList = new List();
		try{setTalentList(pTalentList);}
		catch(Exception ex) {System.out.println(ex);}
		BasicTalents = null;
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pTalentList
	 * @param pBasisTalentIDs
	 */
	public TalentDatabase(List pTalentList, int[] pBasicTalentIDs) {
		TalentList = new List();
		try{
			setTalentList(pTalentList);
			setBasicTalents(pBasicTalentIDs);
		}catch(Exception ex) {System.out.println(ex);}
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	9.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	protected Talent getTalent(int pID) throws Exception{
		Talent vRet = null;
		
		if ((pID >= 0) && (pID < TalentList.getContentNumber())) {
			TalentList.toFirst();
			
			while (!TalentList.isEnd()) {
				vRet = (Talent) TalentList.getCurrent();
				
				if (vRet.getID() == pID) TalentList.toLast();
				else vRet = null;
				
				TalentList.next();
			}
			
			if (vRet == null) throw new Exception("02; TaDat,gT");
			else vRet = copyTalent(vRet);
		}else throw new Exception("02; TaDat,gT");
		
		return vRet;
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pName
	 * @return
	 * @throws Exception
	 */
	protected Talent getTalent(String pName) throws Exception{
		Talent vRet = null;
		
		if (pName != "") {
			if (!TalentList.isEmpty()) {
				TalentList.toFirst();
				
				while (!TalentList.isEnd()) {
					vRet = (Talent) TalentList.getCurrent();
					
					if (vRet.getName().equals(pName)) TalentList.toLast();
					else vRet = null;
					
					TalentList.next();
				}
			}
			if (vRet == null) throw new Exception("02; TaDat,gT; "+pName);
			else vRet = copyTalent(vRet);
		}else throw new Exception("02; TaDat,gT");
		
		return vRet;
	}
	/**	Dh	9.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "TalentList")
	public List getTalentList() {
		return TalentList.copyList();
	}
	/**	Dh	10.6.2020
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "BasicTalentsArray")
	@XmlElement(name = "BasicTalentID")
	public int[] getBasicTalents() {
		return BasicTalents.clone();
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	9.6.2020
	 * 
	 * @param pTalentList
	 * @throws Exception
	 */
	public void setTalentList(List pTalentList) throws Exception {
		Object vCur;
		boolean containsOnlyTalents = true;
		
		if (pTalentList != null) {
			if (!pTalentList.isEmpty()) {
				pTalentList.toFirst();
				
				while (!pTalentList.isEnd() && (containsOnlyTalents == true)) {
					vCur = pTalentList.getCurrent();
					
					if (!(vCur instanceof Talent)) containsOnlyTalents = false;
					
					pTalentList.next();
				}
				
				if (containsOnlyTalents == true) TalentList = pTalentList;
				else throw new Exception("06; WeDat,sTL");
			} TalentList = pTalentList;
		} else throw new Exception("04; WeDat,sTL");
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pBasicTalents
	 * @throws Exception
	 */
	public void setBasicTalents(int[] pBasicTalents) throws Exception {
		boolean vContainsOnlyTalentIDs = true;
		int vTalentListLength;
		
		if (pBasicTalents != null) {
			if (TalentList != null) {
				vTalentListLength = TalentList.getContentNumber();
				
				for (int i=0; (i<pBasicTalents.length) && (vContainsOnlyTalentIDs == true) ; i++) {
					if ((pBasicTalents[i] < 0) || (pBasicTalents[i] >= vTalentListLength)) vContainsOnlyTalentIDs = false;
				}
				
				if (vContainsOnlyTalentIDs == true) BasicTalents = pBasicTalents;
			}
		}
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	9.6.2020
	 * 
	 * @param pTalent
	 * @throws Exception
	 */
	protected void addTalent(Talent pTalent) throws Exception{
		if (pTalent != null) {
			pTalent.setID(TalentList.getContentNumber());
			TalentList.append(pTalent);
		}else throw new Exception("04; TaDat,aT");
	}
	/**	Dh	9.6.2020
	 * 
	 * @param pTalents
	 * @throws Exception
	 */
	protected void addTalents(List pTalents) throws Exception{
		Object vCur;
		
		if (pTalents != null) {
			if (!pTalents.isEmpty()) {
				pTalents.toFirst();
				
				while(!pTalents.isEnd()) {
					vCur = pTalents.getCurrent();
					
					if (vCur instanceof Talent) addTalent((Talent) vCur);
					else throw new Exception("06; WaDat,aTs");
					
					pTalents.next();
				}
			}throw new Exception("05; WaDat,aTs");
		}throw new Exception("04; WaDat,aTs");
	}
	
	/**	Dh	9.6.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	protected void removeTalent(int pID) throws Exception{
		if ((pID >= 0) && (pID < TalentList.getContentNumber())) {
			TalentList.toFirst();
			
			while(!TalentList.isEnd()) {
				if (((Talent)TalentList.getCurrent()).getID() == pID) {
					TalentList.remove();
					TalentList.toLast();
				}
				
				TalentList.next();
			}
		}else throw new Exception("02; WeDat,rT");
	}
	/**	Dh	9.6.2020
	 * 
	 * @param pIDList
	 * @throws Exception
	 */
	protected void removeTalents(List pIDList) throws Exception{
		Object vCur;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) removeTalent((int)vCur);
					else throw new Exception("06; WaDat,rTs");
					
					pIDList.next();
				}
			} throw new Exception("05; WaDat,rTs");
		} throw new Exception("04; WaDat,rTs");
	}
	
	/**	Dh	10.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	protected boolean haveTalent(int pID) throws Exception{
		boolean vRet = false;
		
		if (pID >= 0) {
			if (pID < TalentList.getContentNumber()) vRet = true;
		}else throw new Exception("02; TaDat,hT");
		
		return vRet;
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pTalent
	 * @return
	 * @throws Exception
	 */
	protected boolean haveTalent(Talent pTalent) throws Exception{
		boolean vRet = false;
		Talent vCur;
		
		if (pTalent != null) {
			if (!TalentList.isEmpty()) {
				TalentList.toFirst();
				
				while((!TalentList.isEnd()) && (vRet == false)) {
					vCur = (Talent)TalentList.getCurrent();
					
					if (vCur.getID() == pTalent.getID()) vRet = true;
					
					TalentList.next();
				}
			}
		} else throw new Exception("04; TaDat,hT");
		
		return vRet;
	}
	
	/**	Dh	10.6.2020
	 * 	
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	protected boolean isBasicTalent(int pID) throws Exception{
		boolean vRet = false;
		
		if ((pID >= 0) && (pID < TalentList.getContentNumber())) {
			if (BasicTalents != null) {
				for (int i=0; (i < BasicTalents.length) && (vRet == false); i++) {
					if (BasicTalents[i] == pID) vRet = true;
				}
			}
		} else throw new Exception("02; TaDat,iBT");
		
		return vRet;
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pTalent
	 * @return
	 * @throws Exception
	 */
	protected boolean isBasicTalent(Talent pTalent) throws Exception{
		boolean vRet = false;
		
		if (pTalent != null) {
			if (BasicTalents != null) {
				for (int i=0; (i < BasicTalents.length) && (vRet == false); i++) {
					if (BasicTalents[i] == pTalent.getID()) vRet = true;
				}
			}
		} else throw new Exception("04; TaDat,iBT");
		
		return vRet;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	9.6.2020
	 * 
	 * @param pTalent
	 * @return
	 */
	private Talent copyTalent(Talent pTalent) {
		Talent vRet = null;
		
		try {
			if (pTalent instanceof Basictalent) {
				if (pTalent instanceof PhysicalTalent) vRet = new PhysicalTalent();
				else if (pTalent instanceof Communicationtalent) vRet = new Communicationtalent();
				else vRet = new Basictalent();
			}
			if (pTalent instanceof Fighttalent) vRet = new Fighttalent();
			
			vRet.setID(pTalent.getID());
			vRet.setName(pTalent.getName());
			vRet.setTaW(pTalent.getTaW());
			
			if (pTalent instanceof Basictalent) {
				((Basictalent) vRet).setPropInds(((Basictalent)pTalent).getPropInds().clone());
				
				if (pTalent instanceof PhysicalTalent) ((PhysicalTalent) vRet).setEBE(((PhysicalTalent)pTalent).getEBE().clone());
				else if (pTalent instanceof Communicationtalent) {
					((Communicationtalent) vRet).setComplexity(((Communicationtalent)pTalent).getComplexity());
					((Communicationtalent) vRet).setLanguage(((Communicationtalent)pTalent).isLanguage());
				}
			}
			if (pTalent instanceof Fighttalent) {
				((Fighttalent) vRet).setCategory(((Fighttalent)pTalent).getCategory());
				((Fighttalent) vRet).setEBE(((Fighttalent)pTalent).getEBE().clone());
				((Fighttalent) vRet).setFightValues(((Fighttalent)pTalent).getFightValues().clone());
				((Fighttalent) vRet).setUsableWeaponType(((Fighttalent)pTalent).getUsableWeaponType().clone());
			}
		} catch(Exception ex) {System.out.println(ex.getMessage());}
		
		return vRet;
	}
}
