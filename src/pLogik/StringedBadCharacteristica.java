/**	DSA_App v0.0	Dh	 1.7.2020
 * 	
 * 	Logik
 * 	  Pro
 * 		ValuedPro
 * 		  BadCharacteristic
 * 			StringedBadCharacteristica (Stringed)
 *
 *	Type:
 * 	  0: Allgemein
 * 	  1: Kampf
 * 	  2: Magisch
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
 * 	  09 Wrong Selection
 **/
package pLogik;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import pGUI.MainFrame;

@XmlRootElement(name = "stringedbadcharacteristica")
public class StringedBadCharacteristica extends BadCharacteristic implements Stringed{
	private String StringedValue;
	
	/**	Dh	17.6.2020
	 * 
	 * 	Konstruktor nach Bean-Standart
	 */
	public StringedBadCharacteristica() {
		super();
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pID
	 * @param pName
	 */
	public StringedBadCharacteristica(int pID, String pName) {
		super(pID, pName);
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pArkane
	 */
	public StringedBadCharacteristica(int pID, String pName, boolean pArkane) {
		super(pID, pName, pArkane);
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pArkane
	 * @param pValue
	 * @param pStringedValue
	 */
	public StringedBadCharacteristica(int pID, String pName, boolean pArkane, int pValue, String pStringedValue) {
		super(pID, pName, pArkane, pValue);
		Exception vExc = null ;
		
		if (!pStringedValue.equals(pStringedValue)) StringedValue = pStringedValue;
		else vExc = new Exception("02; StVaPro_c");
			
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
		} else throw new Exception("04; StVaPro,sSV");
	}
			
//--------------------------------------------------------------------------------------------------------

}
