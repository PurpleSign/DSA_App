/**	DSA_App v0.0	Dh	 1.7.2020
 * 	
 * 	Logik
 * 	  Pro
 * 		ValuedPro
 * 		  BadCharacteristic
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
import javax.xml.bind.annotation.XmlSeeAlso;

import pGUI.MainFrame;

@XmlRootElement(name = "badcharacteristic")
@XmlSeeAlso(StringedBadCharacteristica.class)
public class BadCharacteristic extends ValuedPro {
		
	/**	Dh	1.7.2020
	 * 
	 * 	Bean-STandart Konstruktor.
	 */
	public BadCharacteristic() {
		super();
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pID
	 * @param pName
	 */
	public BadCharacteristic(int pID, String pName) {
		super(pID, pName, -1, false);
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pArkane
	 */
	public BadCharacteristic(int pID, String pName, boolean pArkane) {
		super(pID, pName, -1, false, pArkane);
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pArkane
	 * @param pValue
	 */
	public BadCharacteristic(int pID, String pName, boolean pArkane, int pValue) {
		super(pID, pName, -1, false, pArkane, false, pValue);
	}
	
//--------------------------------------------------------------------------------------------------------
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	17.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean makeProbe() throws Exception{
		return makeProbe(Calculator.makeDiceRoll(20), 0);
	}
	/**	Dh	17.6.2020
	 * 
	 * @param pMod
	 * @return
	 * @throws Exception
	 */
	public boolean makeProbe(int pMod) throws Exception{
		return makeProbe(Calculator.makeDiceRoll(20), pMod);
	}
	/**	Dh	17.6.2020
	 * 
	 * @param pDiceRoll
	 * @param pMod
	 * @return
	 * @throws Exception
	 */
	public boolean makeProbe(int pDiceRoll, int pMod) throws Exception{
		boolean vSuc = true;
		
		if (pDiceRoll >= 1) {
			if ((value + pMod) < pDiceRoll) vSuc = false;
		} else throw new Exception("02; BaCha,mP");
		
		return vSuc;
	}
}
