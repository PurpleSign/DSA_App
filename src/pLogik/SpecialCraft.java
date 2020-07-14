/**	DSA_App v0.0	Dh	 9.7.2020
 * 	
 * 	Logik
 * 	  SpecialCrafts
 *
 *	Type:
 * 	  0: Allgemein
 * 	  1: Kampf
 * 	  2: Magische
 * 	  3: Geweihte
 * 
 * 	PremiseTypes:
 * 	  0: Vorteile				4: Talentgruppe
 * 	  1: Sonderfertigkeiten		5: Zauber
 * 	  2: Kampfwert				6: Rituale
 * 	  3: Talente				7: Liturgien
 * 
 * 	Properties: 
 * 	  0 Mut					4 Fingerfertigkeit
 * 	  1 Klugkheit			5 Gewandheit
 * 	  2 Intuition			6 Konstitution
 * 	  3 Charisma			7 Koerperkraft
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
package pLogik;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import pDataStructures.List;
import pGUI.MainFrame;

@XmlRootElement(name = "SpecialCraft")
@XmlType(propOrder = {"name", "propertiePremises", "typedPremiseList"})
@XmlSeeAlso({StringedSpecialCraft.class, ReferredSpecialCraft.class, int[].class})
public class SpecialCraft {
	private int id, type;
	private String name;
	
	private int[] propertiePremises;
	private List typedPremiseList;
	
	/**	Dh	18.6.2020
	 * 
	 * 	Bean-Standard Konstruktor
	 */
	public SpecialCraft() {
		id = -1;
		type = -1;
		name = "";
		
		propertiePremises = new int[] {-1, -1, -1, -1, -1, -1, -1, -1};
		typedPremiseList = new List();
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @param pName
	 */
	public SpecialCraft(int pID, String pName) {
		Exception vExc = null ;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; SpCra_a");
		type = 0;
		
		if (!pName.equals("")) name = pName;
		else vExc = new Exception("02; SpCra_a");
		
		propertiePremises = new int[] {-1, -1, -1, -1, -1, -1, -1, -1};
		typedPremiseList = new List();
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	18.6.2020
	 * 
	 * 	Type:
	 * 	  0: Allgemeine
	 * 	  1: Kampf
	 * 	  2: Magische
	 * 	  3: Geweihte
	 * 
	 * @param pID
	 * @param pName
	 * @param pType
	 */
	public SpecialCraft(int pID, String pName, int pType) {
		Exception vExc = null ;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; SpCra_b");
		if ((pType >= 0) && (pType < 4)) type = pType;
		else vExc = new Exception("02; SpCra_b");
		
		if (!pName.equals("")) name = pName;
		else vExc = new Exception("02; SpCra_b");
		
		propertiePremises = new int[] {-1, -1, -1, -1, -1, -1, -1, -1};
		typedPremiseList = new List();
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	18.6.2020
	 * 
	 * 	Type:
	 * 	  0: Allgemeine
	 * 	  1: Kampf
	 * 	  2: Magische
	 * 	  3: Geweihte
	 * 
	 * 	pEigen:
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			(8 Geschwindigkeit)
	 * 	  4 Fingerfertigkeit	(9 Sozialstatus)
	 * 
	 * @param pID
	 * @param pName
	 * @param pType
	 * @param pPropertiePremises
	 */
	public SpecialCraft(int pID, String pName, int pType, int[] pPropertiePremises) {
		Exception vExc = null ;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; SpCra_c");
		if ((pType >= 0) && (pType < 4)) type = pType;
		else vExc = new Exception("02; SpCra_c");
		
		if (!pName.equals("")) name = pName;
		else vExc = new Exception("02; SpCra_c");
		
		if (pPropertiePremises.length == 8) {
			if ((pPropertiePremises[0] >= -1) && (pPropertiePremises[1] >= -1) && (pPropertiePremises[2] >= -1)
					&& (pPropertiePremises[3] >= -1) && (pPropertiePremises[4] >= -1) && (pPropertiePremises[5] >= -1)
					&& (pPropertiePremises[6] >= -1) && (pPropertiePremises[7] >= -1)) propertiePremises = pPropertiePremises;
			else vExc = new Exception("02; SpCra_c");
		} else vExc = new Exception("01; SpCra_c");
		typedPremiseList = new List();
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	18.6.2020
	 * 
	 * 	Type:
	 * 	  0: Allgemeine
	 * 	  1: Kampf
	 * 	  2: Magische
	 * 	  3: Geweihte
	 * 
	 * 	PremiseTypes:
	 * 	  0: Vorteile				4: Talentgruppe
	 * 	  1: Sodnerfertigkeiten		5: Zauber
	 * 	  2: Kampfwert				6: Rituale
	 * 	  3: Talente				7: Litugrien
	 * 
	 * @param pID
	 * @param pName
	 * @param pType
	 * @param pTypedPremiseList
	 */
	public SpecialCraft(int pID, String pName, int pType, List pTypedPremiseList) {
		Exception vExc = null ;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; SpCra_d");
		if ((pType >= 0) && (pType < 4)) type = pType;
		else vExc = new Exception("02; SpCra_d");
		
		if (!pName.equals("")) name = pName;
		else vExc = new Exception("02; SpCra_d");
		
		
		propertiePremises = new int[] {-1, -1, -1, -1, -1, -1, -1, -1};
		try{setTypedPremiseList(pTypedPremiseList);}
		catch (Exception ex) {vExc = ex;}
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	18.6.2020
	 * 
	 * 	Type:
	 * 	  0: Allgemeine
	 * 	  1: Kampf
	 * 	  2: Magische
	 * 	  3: Geweihte
	 * 
	 * 	pEigen:
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			(8 Geschwindigkeit)
	 * 	  4 Fingerfertigkeit	(9 Sozialstatus)
	 * 
	 * 	PremiseTypes:
	 * 	  0: Vorteile				4: Talentgruppe
	 * 	  1: Sodnerfertigkeiten		5: Zauber
	 * 	  2: Kampfwert				6: Rituale
	 * 	  3: Talente				7: Litugrien
	 * 
	 * @param pID
	 * @param pName
	 * @param pType
	 * @param pPropertiePremises
	 * @param pTypedPremiseList
	 */
	public SpecialCraft(int pID, String pName, int pType, int[] pPropertiePremises, List pTypedPremiseList) {
		Exception vExc = null ;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; SpCra_e");
		if ((pType >= 0) && (pType < 4)) type = pType;
		else vExc = new Exception("02; SpCra_e");
		
		if (!pName.equals("")) name = pName;
		else vExc = new Exception("02; SpCra_e");
		
		
		if (pPropertiePremises.length == 8) {
			if ((pPropertiePremises[0] >= -1) && (pPropertiePremises[1] >= -1) && (pPropertiePremises[2] >= -1)
					&& (pPropertiePremises[3] >= -1) && (pPropertiePremises[4] >= -1) && (pPropertiePremises[5] >= -1)
					&& (pPropertiePremises[6] >= -1) && (pPropertiePremises[7] >= -1)) propertiePremises = pPropertiePremises;
			else vExc = new Exception("02; SpCra_e");
		} else vExc = new Exception("01; SpCra_e");
		try{setTypedPremiseList(pTypedPremiseList);}
		catch (Exception ex) {vExc = ex;}
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	16.6.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public int getId() {
		return id;
	}
	/**	Dh	16.6.2020
	 * 
	 * 	Type:
	 * 	  0: Allgemeine
	 * 	  1: Kampf
	 * 	  2: Magische
	 * 	  3: Geweihte
	 * 
	 * @return
	 */
	@XmlAttribute
	public int getType() {
		return type;
	}
	
	/**	Dh	16.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Name")
	public String getName() {
		return name;
	}
	
	/**	Dh	16.6.2020
	 * 
	 * 	pEigen:
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			(8 Geschwindigkeit)
	 * 	  4 Fingerfertigkeit	(9 Sozialstatus)
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getPropertiePremise(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < propertiePremises.length)) return propertiePremises[pInd];
		else throw new Exception("07; SpCra,gPP");
	}
	/**	Dh	16.6.2020
	 * 
	 * 	pEigen:
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			(8 Geschwindigkeit)
	 * 	  4 Fingerfertigkeit	(9 Sozialstatus)
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "PropertiePremisesArray")
	@XmlElement(name = "PropertiePermise")
	public int[] getPropertiePremises() {
		return propertiePremises.clone();
	}
	
	/**	Dh	18.6.2020
	 * 
	 * 	PremiseTypes:
	 * 	  0: Vorteile				4: Talentgruppe
	 * 	  1: Sodnerfertigkeiten		5: Zauber
	 * 	  2: Kampfwert				6: Rituale
	 * 	  3: Talente				7: Litugrien
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getTypedPremise(int pInd) throws Exception{		
		if ((pInd >= 0) && (pInd < typedPremiseList.getContentNumber())) {
			typedPremiseList.toFirst();
			
			for (int i=0; i < pInd; i++) {
				typedPremiseList.next();
			}
			
			return ((int[])typedPremiseList.getCurrent())[2];
		} else throw new Exception("02; SpCra,gTP");
	}
	/**	Dh	18.6.2020
	 * 
	 * 	PremiseTypes:
	 * 	  0: Vorteile				4: Talentgruppe
	 * 	  1: Sodnerfertigkeiten		5: Zauber
	 * 	  2: Kampfwert				6: Rituale
	 * 	  3: Talente				7: Litugrien
	 * 
	 * @param pPremiseType
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int getTypedPremise(int pPremiseType, int pID) throws Exception{
		int vRet = -1;
		int[] vCur;
		
		if ((pPremiseType >= 0) && (pPremiseType < 8) && (pID >= 0)) {
			if (!typedPremiseList.isEmpty()) {
				typedPremiseList.toFirst();
				
				while(!typedPremiseList.isEnd() && (vRet == -1)) {
					vCur = (int[])typedPremiseList.getCurrent();
					
					if ((vCur[0] == pPremiseType) && (vCur[1] == pID)) vRet = vCur[2];
					
					typedPremiseList.next();
				}
			}
		} else throw new Exception("02; SpCra,gTP");
		
		return vRet;
	}
	/**	Dh	2.7.2020
	 * 
	 * 	PremiseTypes:
	 * 	  0: Vorteile				4: Talentgruppe
	 * 	  1: Sodnerfertigkeiten		5: Zauber
	 * 	  2: Kampfwert				6: Rituale
	 * 	  3: Talente				7: Litugrien
	 * 
	 * @param pPremiseType
	 * @return
	 * @throws Exception
	 */
	public List getTypedPremiseByType(int pPremiseType) throws Exception{
		int[] vCur;
		List vRet = new List();
		
		if ((pPremiseType >= 0) && (pPremiseType < 8)) {
			if (!typedPremiseList.isEmpty()) {
				typedPremiseList.toFirst();
				
				while(!typedPremiseList.isEnd()) {
					vCur = (int[])typedPremiseList.getCurrent();
					
					if ((vCur[0] == pPremiseType)) vRet.append(vCur[2]);
					
					typedPremiseList.next();
				}
			}
		} else throw new Exception("02; SpCra,gTPbT");
		
		return vRet.copyList();
	}
	/**	Dh	2.7.2020
	 * 
	 * PremiseTypes:
	 * 	  0: Vorteile				4: Talentgruppe
	 * 	  1: Sodnerfertigkeiten		5: Zauber
	 * 	  2: Kampfwert				6: Rituale
	 * 	  3: Talente				7: Litugrien
	 * 
	 * @return
	 */
	@XmlElement(name = "TypedPremiseList")
	public List getTypedPremiseList() {
		return typedPremiseList.copyList();
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	16.6.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void setId(int pID) throws Exception {
		if (pID >= 0) id = pID;
		else throw new Exception("02; SpCra_sID");
	}
	/**	Dh	16.6.2020
	 * 	
	 * 	Type:
	 * 	  0: Allgemeine
	 * 	  1: Kampf
	 * 	  2: Magische
	 * 	  3: Geweihte
	 * 
	 * @param pType
	 * @throws Exception
	 */
	public void setType(int pType) throws Exception{
		if ((pType >= 0) && (pType < 4)) type = pType;
		else throw new Exception("02; SpCra_sT");
	}
	
	/**	Dh	16.6.2020
	 * 
	 * @param pName
	 * @throws Exception
	 */
	public void setName(String pName) throws Exception{
		if (!pName.equals("")) name = pName;
		else throw new Exception("02; SpCra_sN");
	}
	
	/**	Dh	16.6.2020
	 * 
	 * @param pPropertiePremise
	 * @param pInd
	 * @throws Exception
	 */
	public void setPropertiePremise(int pPropertiePremise, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < propertiePremises.length)) { 
			if (pPropertiePremise >= -1) propertiePremises[pInd] = pPropertiePremise;
			else throw new Exception("02; SPCra,sPP");
		} else throw new Exception("07; SpCra,sPP");
	}
	/**	Dh	16.2.2020
	 * 	
	 * @param pPropertiePremises
	 * @throws Exception
	 */
	public void setPropertiePremises(int[] pPropertiePremises) throws Exception{
		if (pPropertiePremises.length == propertiePremises.length) {
			if ((pPropertiePremises[0] >= -1) && (pPropertiePremises[1] >= -1) && (pPropertiePremises[2] >= -1)
					&& (pPropertiePremises[3] >= -1) && (pPropertiePremises[4] >= -1) && (pPropertiePremises[5] >= -1)
					&& (pPropertiePremises[6] >= -1) && (pPropertiePremises[7] >= -1)) propertiePremises = pPropertiePremises;
			else throw new Exception("02; SpCra,sPPs");
		} else throw new Exception("01; SpCra,sPPs");
	}
	
	/**	Dh	2.7.2020
	 * 
	 * 	PremiseTypes:
	 * 	  0: Vorteile				4: Talentgruppe
	 * 	  1: Sodnerfertigkeiten		5: Zauber
	 * 	  2: Kampfwert				6: Rituale
	 * 	  3: Talente				7: Litugrien
	 * 
	 * @param pTypedPremiseList
	 * @throws Exception
	 */
	public void setTypedPremiseList(List pTypedPremiseList) throws Exception{
		Object vCur;
		
		if (pTypedPremiseList != null) {
			if (!pTypedPremiseList.isEmpty()) {
				pTypedPremiseList.toFirst();
				
				while (!pTypedPremiseList.isEnd()) {
					vCur = pTypedPremiseList.getCurrent();
					
					if (!((vCur instanceof Integer[]) || (vCur instanceof int[]))) throw new Exception("06; SpCra,sTPL"+vCur.getClass());
					else if ((((int[])vCur).length != 3)) throw new Exception("01; SpCra,sTPL");
					else if (( ((int[])vCur)[0] < 0 ) || ( ((int[])vCur)[0] >= 8) || ( ((int[])vCur)[1] < 0 ) || ( ((int[])vCur)[2] < -1 )) throw new Exception("02; SpCra,sTPL");
					
					pTypedPremiseList.next();
				}
			}
			
			typedPremiseList = pTypedPremiseList.copyList();
		} else throw new Exception("04; SpCra,sTPL");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	18.6.2020
	 * 	
	 * 	PremiseTypes:
	 * 	  0: Vorteile				4: Talentgruppe
	 * 	  1: Sodnerfertigkeiten		5: Zauber
	 * 	  2: Kampfwert				6: Rituale
	 * 	  3: Talente				7: Litugrien
	 * 
	 * @param pPremiseType
	 * @param pID
	 * @param pValue
	 * @throws Exception
	 */
	public void addTypedPremise(int pPremiseType, int pID, int pValue) throws Exception{
		if ((pPremiseType >= 0) && (pPremiseType < 8) && (pID >= 0) && (pValue >= -1)) {
			typedPremiseList.append(new int[] {pPremiseType, pID, pValue});
		}else throw new Exception("02; SpCra,aTP");
	}
	
	/**	Dh	18.6.2020
	 * 
	 * 	PremiseTypes:
	 * 	  0: Vorteile				4: Talentgruppe
	 * 	  1: Sodnerfertigkeiten		5: Zauber
	 * 	  2: Kampfwert				6: Rituale
	 * 	  3: Talente				7: Litugrien
	 * 
	 * @param pInd
	 * @throws Exception
	 */
	public void removeTypedPremise(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < typedPremiseList.getContentNumber())) {
			typedPremiseList.toFirst();
			
			for (int i=0; i < pInd; i++) {
				typedPremiseList.next();
			}
			
			typedPremiseList.remove();
		} else throw new Exception("02; SpCra,rTP");
	}
	/**	Dh	18.6.2020
	 * 
	 * 	PremiseTypes:
	 * 	  0: Vorteile				4: Talentgruppe
	 * 	  1: Sodnerfertigkeiten		5: Zauber
	 * 	  2: Kampfwert				6: Rituale
	 * 	  3: Talente				7: Litugrien
	 * 
	 * @param pPremiseType
	 * @param pID
	 * @throws Exception
	 */
	public void removeTypedPremise(int pPremiseType, int pID) throws Exception{
		int[] vCur;
		
		if ((pPremiseType >= 0) && (pPremiseType < 8) && (pID >= 0)) {
			if (!typedPremiseList.isEmpty()) {
				typedPremiseList.toFirst();
				
				while(!typedPremiseList.isEnd()) {
					vCur = (int[])typedPremiseList.getCurrent();
					
					if ((vCur[0] == pPremiseType) && (vCur[1] == pID)) {
						typedPremiseList.remove();
						typedPremiseList.toLast();
					}
					
					typedPremiseList.next();
				}
			}
		} else throw new Exception("02; SpCra,gTP");
	}
	
	/**	Dh	18.6.2020
	 * 
	 * 	PremiseTypes:
	 * 	  0: Vorteile				4: Talentgruppe
	 * 	  1: Sodnerfertigkeiten		5: Zauber
	 * 	  2: Kampfwert				6: Rituale
	 * 	  3: Talente				7: Litugrien
	 * 
	 * @param pPremiseType
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public boolean haveTypedPremise(int pPremiseType, int pID) throws Exception{
		boolean vRet = false;
		int[] vCur;
		
		if ((pPremiseType >= 0) && (pPremiseType < 8) && (pID >= 0)) {
			if (!typedPremiseList.isEmpty()) {
				typedPremiseList.toFirst();
				
				while(!typedPremiseList.isEnd() && (vRet == false)) {
					vCur = (int[])typedPremiseList.getCurrent();
					
					if ((vCur[0] == pPremiseType) && (vCur[1] == pID)) vRet = true;
					
					typedPremiseList.next();
				}
			}
		} else throw new Exception("02; SpCra,hTP");
		
		return vRet;
	}
	
}
