/**	DSA_App v0.0	Dh	 18.6.2020
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

@XmlRootElement(name = "stringedspecialcraft")
public class StringedSpecialCraft extends SpecialCraft {
	private String StringedValue;
	
	/**	Dh 17.6.2020
	 * 
	 * 	Konstruktor nach Bean-Standart.
	 */
	public StringedSpecialCraft() {
		super();
		StringedValue = "";
	}
	/**	Dh	17.6.2020
	 * 	
	 * @param pID
	 * @param pName
	 */
	public StringedSpecialCraft(int pID, String pName) {
		super(pID, pName);
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
	public StringedSpecialCraft(int pID, String pName, int pType) {
		super(pID, pName, pType);
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
	 * @param pStringedValue
	 */
	public StringedSpecialCraft(int pID, String pName, int pType, String pStringedValue) {
		super(pID, pName, pType);
		Exception vExc = null ;
		
		if (!pStringedValue.equals(pStringedValue)) StringedValue = pStringedValue;
		else vExc = new Exception("02; StSpCra_c");
			
		if (vExc != null) MainFrame.handleException(vExc);
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
	public StringedSpecialCraft(int pID, String pName, int pType, int[] pPropertiePremises) {
		super(pID, pName, pType, pPropertiePremises);
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
	 * @param pStringedValue
	 */
	public StringedSpecialCraft(int pID, String pName, int pType, int[] pPropertiePremises, String pStringedValue) {
		super(pID, pName, pType, pPropertiePremises);
		Exception vExc = null ;
		
		if (!pStringedValue.equals(pStringedValue)) StringedValue = pStringedValue;
		else vExc = new Exception("02; StSpCra_e");
			
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
	public StringedSpecialCraft(int pID, String pName, int pType, List pTypedPremiseList) {
		super(pID, pName, pType, pTypedPremiseList);
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
	 * @param pStringedValue
	 */
	public StringedSpecialCraft(int pID, String pName, int pType, List pTypedPremiseList, String pStringedValue) {
		super(pID, pName, pType, pTypedPremiseList);
		Exception vExc = null ;
		
		if (!pStringedValue.equals(pStringedValue)) StringedValue = pStringedValue;
		else vExc = new Exception("02; StSpCra_g");
			
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
	public StringedSpecialCraft(int pID, String pName, int pType, int[] pPropertiePremises, List pTypedPremiseList) {
		super(pID, pName, pType, pPropertiePremises, pTypedPremiseList);
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
	 * @param pStringedValue
	 */
	public StringedSpecialCraft(int pID, String pName, int pType, int[] pPropertiePremises, List pTypedPremiseList, String pStringedValue) {
		super(pID, pName, pType, pPropertiePremises, pTypedPremiseList);
		Exception vExc = null ;
		
		if (!pStringedValue.equals(pStringedValue)) StringedValue = pStringedValue;
		else vExc = new Exception("02; StSpCra_i");
			
		if (vExc != null) MainFrame.handleException(vExc);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	17.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "StringedValue")
	public String getStringedValue() {
		return StringedValue;
	}
		
	//----------------------------------------------------------------------------------------------------
		
	/**	Dh	17.6.2020
	 * 
	 * @param pStringedValue
	 * @throws Exception
	 */
	public void setStringedValue(String pStringedValue) throws Exception{
		if (pStringedValue != null) {
			StringedValue = pStringedValue;
		} else throw new Exception("04; StSpCra,sSV");
	}
		
//--------------------------------------------------------------------------------------------------------

}
