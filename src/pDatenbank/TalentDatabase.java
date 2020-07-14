/**	DSA_App v0.0	Dh 12.7.2020
 * 
 * 	Datenbank
 * 	  TalentDatabase
 * 
 * 	Types:
 * 	  00: Nahkampf				05: Wissens
 * 	  01: Fernkampf				06: Sprache
 * 	  02: Koerperliche			07: Handwerks
 * 	  03: Gesellschaftliche		08: Alle Kampf
 * 	  04: Natur					09: Alle mundan nicht Kampf
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
@XmlType(propOrder = { "talentList", "basicTalents", "talentTypes"})
@XmlSeeAlso({Talent.class})
public class TalentDatabase {
	private List talentList;
	private int[] basicTalents;
	private String[] talentTypes;
	
	/**	Dh	12.7.2020
	 * 
	 * 	Konstruktor nach Bean-Standart.
	 */
 	public TalentDatabase() {
		talentList = new List();
		basicTalents = null;
		talentTypes = null;
	}
	/**	Dh	12.7.2020
	 * 
	 * @param pTalentList
	 */
	public TalentDatabase(List pTalentList, String[] pTalentTypes) {
		talentList = new List();
		talentTypes = pTalentTypes;
		try{setTalentList(pTalentList);}
		catch(Exception ex) {System.out.println(ex);}
		basicTalents = null;
	}
	/**	Dh	12.7.2020
	 * 
	 * @param pTalentList
	 * @param pBasisTalentIDs
	 */
	public TalentDatabase(List pTalentList, String[] pTalentTypes, int[] pBasicTalentIDs) {
		talentList = new List();
		talentTypes = pTalentTypes;
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
		
		if ((pID >= 0) && (pID < talentList.getContentNumber())) {
			talentList.toFirst();
			
			while (!talentList.isEnd()) {
				vRet = (Talent) talentList.getCurrent();
				
				if (vRet.getId() == pID) talentList.toLast();
				else vRet = null;
				
				talentList.next();
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
			if (!talentList.isEmpty()) {
				talentList.toFirst();
				
				while (!talentList.isEnd()) {
					vRet = (Talent) talentList.getCurrent();
					
					if (vRet.getName().equals(pName)) talentList.toLast();
					else vRet = null;
					
					talentList.next();
				}
			}
			if (vRet == null) throw new Exception("02; TaDat,gT; "+pName);
			else vRet = copyTalent(vRet);
		}else throw new Exception("02; TaDat,gT");
		
		return vRet;
	}
	//-----
	/**	Dh	12.7.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	protected String getTalentType(int pID) throws Exception{
		String vRet;
		
		if ((pID >= 0) && (pID < talentTypes.length)) {
			vRet = talentTypes[pID];
		} else throw new Exception("02; TaDat,gTT");
		
		return vRet;
	}
	/**	Dh	12.7.2020
	 * 
	 * @param pWeaponType
	 * @return
	 * @throws Exception
	 */
	protected int getTalentTypeID(String pTalentType) throws Exception{
		int vRet = -1;
		
		if (pTalentType != null) {
			if (!pTalentType.equals("")) {
				for (int i=0; (i<talentTypes.length) && (vRet == -1); i++) {
					if (talentTypes[i].equals(pTalentType)) vRet = i;
				}
				
				if (vRet == -1) throw new Exception("02; TaDat,gTTID");
			} else throw new Exception("02; TaDat,gTTID");
		} else throw new Exception("04; TaDat,gTTID");
		
		return vRet;
	}
	
	/**	Dh	9.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "TalentList")
	public List getTalentList() {
		return talentList.copyList();
	}
	/**	Dh	10.6.2020
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "BasicTalentsArray")
	@XmlElement(name = "BasicTalentID")
	public int[] getBasicTalents() {
		return basicTalents.clone();
	}
	/**	Dh	12.7.2020
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "WeaponTypeArray")
	@XmlElement(name = "WeaponType")
	public String[] getTalentTypes() {
		return talentTypes;
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
				
				if (containsOnlyTalents == true) talentList = pTalentList;
				else throw new Exception("06; WeDat,sTL");
			} talentList = pTalentList;
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
			if (talentList != null) {
				vTalentListLength = talentList.getContentNumber();
				
				for (int i=0; (i<pBasicTalents.length) && (vContainsOnlyTalentIDs == true) ; i++) {
					if ((pBasicTalents[i] < 0) || (pBasicTalents[i] >= vTalentListLength)) vContainsOnlyTalentIDs = false;
				}
				
				if (vContainsOnlyTalentIDs == true) basicTalents = pBasicTalents;
			}
		}
	}
	/**	Dh	12.7.2020
	 * 
	 * @param pWeaponTypes
	 */
	public void setTalentTypes(String[] pTalentTypes) {
		talentTypes = pTalentTypes;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	9.6.2020
	 * 
	 * @param pTalent
	 * @throws Exception
	 */
	protected void addTalent(Talent pTalent) throws Exception{
		if (pTalent != null) {
			pTalent.setId(talentList.getContentNumber());
			talentList.append(pTalent);
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
		if ((pID >= 0) && (pID < talentList.getContentNumber())) {
			talentList.toFirst();
			
			while(!talentList.isEnd()) {
				if (((Talent)talentList.getCurrent()).getId() == pID) {
					talentList.remove();
					talentList.toLast();
				}
				
				talentList.next();
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
			if (pID < talentList.getContentNumber()) vRet = true;
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
			if (!talentList.isEmpty()) {
				talentList.toFirst();
				
				while((!talentList.isEnd()) && (vRet == false)) {
					vCur = (Talent)talentList.getCurrent();
					
					if (vCur.getId() == pTalent.getId()) vRet = true;
					
					talentList.next();
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
		
		if ((pID >= 0) && (pID < talentList.getContentNumber())) {
			if (basicTalents != null) {
				for (int i=0; (i < basicTalents.length) && (vRet == false); i++) {
					if (basicTalents[i] == pID) vRet = true;
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
			if (basicTalents != null) {
				for (int i=0; (i < basicTalents.length) && (vRet == false); i++) {
					if (basicTalents[i] == pTalent.getId()) vRet = true;
				}
			}
		} else throw new Exception("04; TaDat,iBT");
		
		return vRet;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	2.7.2020
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
			
			vRet.setId(pTalent.getId());
			vRet.setName(pTalent.getName());
			vRet.setTaw(pTalent.getTaw());
			vRet.setType(pTalent.getType());
			
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
