/**	DSA_App v0.0	Dh	 1.7.2020
 * 	
 * 	Logik
 * 	  SpecialCrafts
 * 		ReferredSpecialCraft
 *
 *	Type:
 * 	  0: Allgemein
 * 	  1: Kampf
 * 	  2: Magische
 * 	  3: Geweihte
 * 
 * 	PremiseTypes:
 * 	  0: Vorteile				3: Zauber
 * 	  1: Sodnerfertigkeiten		4: Rituale
 * 	  2: Talente				5: Liturgien
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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import pDataStructures.List;
import pGUI.MainFrame;

@XmlRootElement(name = "referredspecialcraft")
public class ReferredSpecialCraft extends SpecialCraft implements Referred {
	private int[] ReferredValue;
	
	/**	Dh	17.6.2020
	 * 
	 * 	Konstruktor nach Bean-Standart
	 */
	public ReferredSpecialCraft() {
		super();
		
		ReferredValue = new int[] {-1, -1};
	}
	/**	Dh	17.6.2020
	 * 
	 * @param pID
	 * @param pName
	 */
	public ReferredSpecialCraft(int pID, String pName) {
		super(pID, pName);
		
		ReferredValue = new int[] {-1, -1};
	}
	/**	Dh	17.6.2020
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
	public ReferredSpecialCraft(int pID, String pName, int pType) {
		super(pID, pName, pType);
		
		ReferredValue = new int[] {-1, -1};
	}
	/**	Dh	17.6.2020
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
	 * @param pPropertiePremises
	 */
	public ReferredSpecialCraft(int pID, String pName, int pType, int[] pPropertiePremises) {
		super(pID, pName, pType, pPropertiePremises);

		ReferredValue = new int[] {-1, -1};
	}
	/**	Dh	17.6.2020
	 * 
	 * 	Type:
	 * 	  0: Allgemeine
	 * 	  1: Kampf
	 * 	  2: Magische
	 * 	  3: Geweihte
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
	 * @param pID
	 * @param pName
	 * @param pType
	 * @param pPropertiePremises
	 * @param pReferredValue
	 */
	public ReferredSpecialCraft(int pID, String pName, int pType, int[] pPropertiePremises, int[] pReferredValue) {
		super(pID, pName, pType, pPropertiePremises);
		Exception vExc = null ;
		
		try { setReferredValue(pReferredValue);}
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
	 * 	PremiseTypes:
	 * 	  0: Vorteile				4: Zauber
	 * 	  1: Sodnerfertigkeiten		5: Rituale
	 * 	  2: Kampfwert				6: Liturgien
	 * 	  3: Talente
	 * 
	 * @param pID
	 * @param pName
	 * @param pType
	 * @param pTypedPremiseList
	 */
	public ReferredSpecialCraft(int pID, String pName, int pType, List pTypedPremiseList) {
		super(pID, pName, pType, pTypedPremiseList);

		ReferredValue = new int[] {-1, -1};
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
	 * 	  0: Vorteile				4: Zauber
	 * 	  1: Sodnerfertigkeiten		5: Rituale
	 * 	  2: Kampfwert				6: Liturgien
	 * 	  3: Talente
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
	 * @param pID
	 * @param pName
	 * @param pType
	 * @param pTypedPremiseList
	 * @param pReferredValue
	 */
	public ReferredSpecialCraft(int pID, String pName, int pType, List pTypedPremiseList, int[] pReferredValue) {
		super(pID, pName, pType, pTypedPremiseList);
		Exception vExc = null ;
		
		try { setReferredValue(pReferredValue);}
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
	 * 	PremiseTypes:
	 * 	  0: Vorteile				4: Zauber
	 * 	  1: Sodnerfertigkeiten		5: Rituale
	 * 	  2: Kampfwert				6: Liturgien
	 * 	  3: Talente
	 * 
	 * @param pID
	 * @param pName
	 * @param pType
	 * @param pPropertiePremises
	 * @param pTypedPremiseList
	 */
	public ReferredSpecialCraft(int pID, String pName, int pType, int[] pPropertiePremises, List pTypedPremiseList) {
		super(pID, pName, pType, pPropertiePremises, pTypedPremiseList);

		ReferredValue = new int[] {-1, -1};
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
	 * 	  0: Vorteile				4: Zauber
	 * 	  1: Sodnerfertigkeiten		5: Rituale
	 * 	  2: Kampfwert				6: Liturgien
	 * 	  3: Talente
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
	 * @param pID
	 * @param pName
	 * @param pType
	 * @param pPropertiePremises
	 * @param pTypedPremiseList
	 * @param pReferredValue
	 */
	public ReferredSpecialCraft(int pID, String pName, int pType, int[] pPropertiePremises, List pTypedPremiseList, int[] pReferredValue) {
		super(pID, pName, pType, pPropertiePremises, pTypedPremiseList);
		Exception vExc = null ;
		
		try { setReferredValue(pReferredValue);}
		catch (Exception ex) {vExc = ex;}
		
		if (vExc != null) MainFrame.handleException(vExc);
	}

//--------------------------------------------------------------------------------------------------------

	/**	Dh	17.6.2020
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
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getReferredValue(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < ReferredValue.length)) return ReferredValue[pInd];
		else throw new Exception("02; ReSpCra,gRV");
	}
	/**	Dh	17.6.2020
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
	 * @return
	 */
	@XmlElement(name = "ReferredValue")
	public int[] getReferredValue() {
		return ReferredValue;
	}
		
	//----------------------------------------------------------------------------------------------------
		
	/**	Dh	17.6.2020
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
	 * @param pValue
	 * @param pInd
	 * @throws Exception
	 */
	public void setReferredValue(int pValue, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < ReferredValue.length)) {
			if ((pValue >= -1) && (((pInd == 0) && (pValue < 14)) || (pInd == 1))) ReferredValue[pInd] = pValue;
			else throw new Exception("02; ReSpCra,sRV");
		}else throw new Exception("01; ReSpCra,sRV");
	}
	/**	Dh	17.6.2020
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
	 * @param pReferredValue
	 * @throws Exception
	 */
	public void setReferredValue(int[] pReferredValue) throws Exception{
		if (pReferredValue.length == ReferredValue.length) {
			if ((pReferredValue[0] >= -1) && (pReferredValue[0] < 14) && (pReferredValue[1] >= -1)) ReferredValue = pReferredValue;
			else throw new Exception("02; ReSpCra,sRV");
		} else throw new Exception("01; ReSpCra,sRv");
	}
		
	//--------------------------------------------------------------------------------------------------------
}
