/**	DSA_App v0.0	Dh	 9.7.2020
 * 	
 * 	Logik
 * 	  Pro
 * 		ValuedPro
 * 		  StringedValuedPro   (Stringed)
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

@XmlRootElement(name = "stringedvaluepro")
public class StringedValuedPro extends ValuedPro implements Stringed {
	private String stringedValue;
	
	/**	Dh	17.6.2020
	 * 
	 * 	Konstruktor nach Bean-Vorschrift
	 */
	public StringedValuedPro() {
		super();
		
		stringedValue = "";
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pID
	 * @param pName
	 */
	public StringedValuedPro(int pID, String pName, int pValueLimit) {
		super(pID, pName, pValueLimit);
		
		stringedValue = "";
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pPro
	 */
	public StringedValuedPro(int pID, String pName, int pValueLimit, boolean pPro) {
		super(pID, pName, pValueLimit, pPro);
		
		stringedValue = "";
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pPro
	 * @param pArkane
	 */
	public StringedValuedPro(int pID, String pName, int pValueLimit, boolean pPro, boolean pArkane) {
		super(pID, pName, pValueLimit, pPro, pArkane);
		
		stringedValue = "";
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pPro
	 * @param pArkane
	 * @param pGift
	 */
	public StringedValuedPro(int pID, String pName, int pValueLimit, boolean pPro, boolean pArkane, boolean pGift) {
		super(pID, pName, pValueLimit, pPro, pArkane, pGift);
		
		stringedValue = "";
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pPro
	 * @param pArkane
	 * @param pGift
	 * @param pValue
	 */
	public StringedValuedPro(int pID, String pName, int pValueLimit, boolean pPro, boolean pArkane, boolean pGift, int pValue) {
		super(pID, pName, pValueLimit, pPro, pArkane, pGift, pValue);
		
		stringedValue = "";
	}
	/**	Dh	1.7.2020
	 * 	
	 * @param pID
	 * @param pName
	 * @param pPro
	 * @param pArkane
	 * @param pGift
	 * @param pStringedValue
	 */
	public StringedValuedPro(int pID, String pName, int pValueLimit, boolean pPro, boolean pArkane, boolean pGift, String pStringedValue) {
		super(pID, pName, pValueLimit, pPro, pArkane, pGift);
		Exception vExc = null ;
		
		if (!pStringedValue.equals("")) stringedValue = pStringedValue;
		else vExc = new Exception("02; StVaPro_f");
			
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pPro
	 * @param pStringedValue
	 * @param pGift
	 * @param pValue
	 * @param pArkane
	 */
	public StringedValuedPro(int pID, String pName, int pValueLimit, boolean pPro, boolean pArkane, boolean pGift, int pValue, String pStringedValue) {
		super(pID, pName, pValueLimit, pPro, pArkane, pGift, pValue);
		Exception vExc = null ;
		
		if (!pStringedValue.equals("")) stringedValue = pStringedValue;
		else vExc = new Exception("02; StVaPro_g");
			
		if (vExc != null) MainFrame.handleException(vExc);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	17.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "StringedValue")
	public String getStringedValue() {
		return stringedValue;
	}
		
	//----------------------------------------------------------------------------------------------------
		
	/**	Dh	17.6.2020
	 * 
	 * @param pStringedValue
	 * @throws Exception
	 */
	public void setStringedValue(String pStringedValue) throws Exception{
		if (pStringedValue != null) {
			stringedValue = pStringedValue;
		} else throw new Exception("04; StVaPro,sSV");
	}
		
//--------------------------------------------------------------------------------------------------------

}
