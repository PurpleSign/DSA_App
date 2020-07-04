/**	DSA_App v0.0	Dh	 25.6.2020
 * 	
 * 	Logik
 * 	  Pro
 * 		StringedPro (Stringed)
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
 **/
package pLogik;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import pGUI.MainFrame;

@XmlRootElement(name = "stringedpro")
public class StringedPro extends Pro implements Stringed{
	private String StringedValue;

	/**	Dh	17.6.2020
	 * 
	 * 	Konstruktor nach Bean-Standart.
	 */
	public StringedPro() {
		super();
		
		StringedValue = "";
	}
	/**	Dh	17.6.2020
	 * 
	 * @param pID
	 * @param pName
	 */
	public StringedPro(int pID, String pName) {
		super(pID, pName);
		
		StringedValue = "";
	}
	/**	Dh	17.6.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pPro
	 */
	public StringedPro(int pID, String pName, boolean pPro) {
		super(pID, pName, pPro);
		
		StringedValue = "";
	}
	/**	Dh	17.6.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pPro
	 * @param pArkane
	 */
	public StringedPro(int pID, String pName, boolean pPro, boolean pArkane) {
		super(pID, pName, pPro, pArkane);
		
		StringedValue = "";
	}
	/**	Dh	17.6.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pPro
	 * @param pArkane
	 * @param pGift
	 */
	public StringedPro(int pID, String pName, boolean pPro, boolean pArkane, boolean pGift) {
		super(pID, pName, pPro, pArkane, pGift);
		
		StringedValue = "";
	}
	/**	Dh	17.6.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pPro
	 * @param pArkane
	 * @param pGift
	 * @param pStringedValue
	 */
	public StringedPro(int pID, String pName, boolean pPro, boolean pArkane, boolean pGift, String pStringedValue) {
		super(pID, pName, pPro, pArkane, pGift);
		Exception vExc = null ;
		
		if (!pStringedValue.equals("")) StringedValue = pStringedValue;
		else vExc = new Exception("02; StPro_e");
			
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
		} else throw new Exception("04; StPro,sSV");
	}
	
//--------------------------------------------------------------------------------------------------------

}
