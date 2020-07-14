/**	DSA_App v0.0	Dh	 9.7.2020
 * 	
 * 	pDatenbank
 * 	  SpecialCraftDatabase
 *
 *	Type:
 * 	  0: Allgemein
 * 	  1: Kampf
 * 	  2: Magisch
 * 
 * 	PremiseTypes:
 * 	  0: Vorteile				3: Zauber
 * 	  1: Sodnerfertigkeiten		4: Rituale
 * 	  2: Talente				5: Liturgien
 * 
 * 	Properties: 
 * 	  0 Mut					4 Fingerfertigkeit
 * 	  1 Klugkheit			5 Gewandheit
 * 	  2 Intuition			6 Konstitution
 * 	  3 Charisma			7 Koerperkraft
 * 
 * 	ReferredType:
 * 	  0: Talente				 7: Zauberzeichen
 * 	  1: Zauber					 8: Waffenlose Manöver
 * 	  2: Traditionen			 9: Waffen
 * 	  3: Ritualkenntnisse		10: Schilde
 * 	  4: Merkmale				11: Rüstungen
 * 	  5: Rituale				12: Geländearten
 * 	  6: Objektrituale			13: Kulturen
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
import pLogik.ReferredSpecialCraft;
import pLogik.SpecialCraft;
import pLogik.StringedSpecialCraft;

@XmlRootElement(name = "specialcraftdatabase")
@XmlSeeAlso(SpecialCraft.class)
public class SpecialCraftDatabase {
	private List specialCraftList;
	
	/**	Dh	16.6.2020
	 * 
	 */
	public SpecialCraftDatabase() {
		specialCraftList = new List();
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pSpecialCraftList
	 */
	public SpecialCraftDatabase(List pSpecialCraftList) {
		specialCraftList = new List();
		try {setSpecialCraftList(pSpecialCraftList);}
		catch(Exception ex) {System.out.println(ex);}
	}

//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	16.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	protected SpecialCraft getSpecialCraft(int pID) throws Exception {
		SpecialCraft vRet = null;
		
		if ((pID >= 0) && (pID < specialCraftList.getContentNumber())) {
			specialCraftList.toFirst();
			
			while (!specialCraftList.isEnd()) {
				vRet = (SpecialCraft) specialCraftList.getCurrent();
				
				if (vRet.getId() == pID) specialCraftList.toLast();
				else vRet = null;
				
				specialCraftList.next();
			}
			
			if (vRet == null) throw new Exception("02; SpCrDat,gSC");
			else vRet = copySpecialCraft(vRet);
		}else throw new Exception("02; SpCrDat,gSC");
		
		return vRet;
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pName
	 * @return
	 * @throws Exception
	 */
	protected SpecialCraft getSpecialCraft(String pName) throws Exception{
		SpecialCraft vRet = null;
		
		if (pName != "") {
			if (!specialCraftList.isEmpty()) {
				specialCraftList.toFirst();
				
				while (!specialCraftList.isEnd()) {
					vRet = (SpecialCraft) specialCraftList.getCurrent();
					
					if (vRet.getName().equals(pName)) specialCraftList.toLast();
					else vRet = null;
					
					specialCraftList.next();
				}
			}
			if (vRet == null) throw new Exception("02; SpCrDat,gSC; "+pName);
			else vRet = copySpecialCraft(vRet);
		}else throw new Exception("02; SpCrDat,gSC");
		
		return vRet;
	}
	
	/**	Dh	25.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "SpecialCraftList")
	public List getSpecialCraftList() {
		return specialCraftList.copyList();
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	16.6.2020
	 * 
	 * @param pSpecialCraftList
	 * @throws Exception
	 */
	public void setSpecialCraftList(List pSpecialCraftList) throws Exception{
		Object vCur;
		boolean containsOnlySpecialCrafts = true;
		
		if (pSpecialCraftList != null) {
			if (!pSpecialCraftList.isEmpty()) {
				pSpecialCraftList.toFirst();
				
				while (!pSpecialCraftList.isEnd() && (containsOnlySpecialCrafts == true)) {
					vCur = pSpecialCraftList.getCurrent();
					
					if (!(vCur instanceof SpecialCraft)) containsOnlySpecialCrafts = false;
					
					pSpecialCraftList.next();
				}
				
				if (containsOnlySpecialCrafts == true) specialCraftList = pSpecialCraftList;
				else throw new Exception("06; SpCrDat,sSCL");
			} specialCraftList = pSpecialCraftList;
		} else throw new Exception("04; SpCrDat,sSCL");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	16.6.2020
	 * 
	 * @param pSpecialCraft
	 * @throws Exception
	 */
	protected void addSpecialCraft(SpecialCraft pSpecialCraft) throws Exception{
		if (pSpecialCraft != null) {
			pSpecialCraft.setId(specialCraftList.getContentNumber());
			specialCraftList.append(pSpecialCraft);
		}else throw new Exception("04; SpCrDat,aSC");
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pSpecialCrafts
	 * @throws Exception
	 */
	protected void addSpecialCrafts(List pSpecialCrafts) throws Exception{
		Object vCur;
		
		if (pSpecialCrafts != null) {
			if (!pSpecialCrafts.isEmpty()) {
				pSpecialCrafts.toFirst();
				
				while(!pSpecialCrafts.isEnd()) {
					vCur = pSpecialCrafts.getCurrent();
					
					if (vCur instanceof SpecialCraft) addSpecialCraft((SpecialCraft) vCur);
					else throw new Exception("06; SpCrDat,aSCs");
					
					pSpecialCrafts.next();
				}
			}throw new Exception("05; SpCrDat,aSCs");
		}throw new Exception("04; SpCrDat,aSCs");
	}
	
	/**	Dh	18.6.2020
	 * 
	 * @param pName
	 * @param pPremiseType
	 * @param pID
	 * @throws Exception
	 */
	protected void addTypedPremiseOfSpecialCraft(String pName, int pPremiseType, int pID) throws Exception{
		SpecialCraft vCur = null;
		
		if (pName != "") {
			if (!specialCraftList.isEmpty()) {
				specialCraftList.toFirst();
				
				while (!specialCraftList.isEnd()) {
					vCur = (SpecialCraft) specialCraftList.getCurrent();
					
					if (vCur.getName().equals(pName)) vCur.addTypedPremise(pPremiseType, pID, -1);
					
					specialCraftList.next();
				}
			}
		}else throw new Exception("02; SpCrDat,aTPoSC");
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pName
	 * @param pPremiseType
	 * @param pID
	 * @param pValue
	 * @throws Exception
	 */
	protected void addTypedPremiseOfSpecialCraft(String pName, int pPremiseType, int pID, int pValue) throws Exception{
		SpecialCraft vCur = null;
		
		if (pName != "") {
			if (!specialCraftList.isEmpty()) {
				specialCraftList.toFirst();
				
				while (!specialCraftList.isEnd()) {
					vCur = (SpecialCraft) specialCraftList.getCurrent();
					
					if (vCur.getName().equals(pName)) vCur.addTypedPremise(pPremiseType, pID, pValue);
					
					specialCraftList.next();
				}
			}
		}else throw new Exception("02; SpCrDat,aTPoSC");
	}
	
	/**	Dh	16.6.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	protected void removeSpecialCraft(int pID) throws Exception{
		if ((pID >= 0) && (pID < specialCraftList.getContentNumber())) {
			specialCraftList.toFirst();
			
			while(!specialCraftList.isEnd()) {
				if (((SpecialCraft)specialCraftList.getCurrent()).getId() == pID) {
					specialCraftList.remove();
					specialCraftList.toLast();
				}
				
				specialCraftList.next();
			}
		}else throw new Exception("02; SpCrDat,rSC");
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pIDList
	 * @throws Exception
	 */
	protected void removeSpecialCrafts(List pIDList) throws Exception{
		Object vCur;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) removeSpecialCraft((int)vCur);
					else throw new Exception("06; SpCrDat,rSCs");
					
					pIDList.next();
				}
			} throw new Exception("05; SpCrDat,rSCs");
		} throw new Exception("04; SpCrDat,rSCs");
	}
	
	/**	Dh	16.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	protected boolean haveSpecialCraft(int pID) throws Exception{
		boolean vRet = false;
		
		if (pID >= 0) {
			if (pID < specialCraftList.getContentNumber()) vRet = true;
		}else throw new Exception("02; SpCrDat,hSC");
		
		return vRet;
	}
	/**	Dh	16.6.2020
	 * 	
	 * @param pSpecialCraft
	 * @return
	 * @throws Exception
	 */
	protected boolean haveSpecialCraft(SpecialCraft pSpecialCraft) throws Exception{
		boolean vRet = false;
		SpecialCraft vCur;
		
		if (pSpecialCraft != null) {
			if (!specialCraftList.isEmpty()) {
				specialCraftList.toFirst();
				
				while((!specialCraftList.isEnd()) && (vRet == false)) {
					vCur = (SpecialCraft)specialCraftList.getCurrent();
					
					if (vCur.getId() == pSpecialCraft.getId()) vRet = true;
					
					specialCraftList.next();
				}
			}
		} else throw new Exception("04; SpCrDat,hSC");
		
		return vRet;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	2.7.2020
	 * 
	 * @param pSpecialCraft
	 * @return
	 */
	private SpecialCraft copySpecialCraft(SpecialCraft pSpecialCraft) {
		SpecialCraft vRet = null;
		
		try {
			if (pSpecialCraft instanceof ReferredSpecialCraft) vRet = new ReferredSpecialCraft();
			else if (pSpecialCraft instanceof StringedSpecialCraft) vRet = new StringedSpecialCraft();
			else vRet = new SpecialCraft();
			
			vRet.setId(pSpecialCraft.getId());
			vRet.setType(pSpecialCraft.getType());
			vRet.setName(pSpecialCraft.getName());
			
			vRet.setPropertiePremises(pSpecialCraft.getPropertiePremises());
			vRet.setTypedPremiseList(pSpecialCraft.getTypedPremiseList());
			
			if (pSpecialCraft instanceof ReferredSpecialCraft) ((ReferredSpecialCraft)pSpecialCraft).setReferredValue(((ReferredSpecialCraft)pSpecialCraft).getReferredValue());
			if (pSpecialCraft instanceof StringedSpecialCraft) ((StringedSpecialCraft)pSpecialCraft).setStringedValue(((StringedSpecialCraft)pSpecialCraft).getStringedValue());
		} catch(Exception ex) {System.out.println(ex.getMessage());}
		
		return vRet;
	}
}
