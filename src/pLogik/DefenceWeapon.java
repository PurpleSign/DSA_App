/**	DSA_App	v0.0	Dh	9.7.2020
 * 
 * 	Logik
 * 	  Weapon
 * 		CloseWeapon
 * 		  DefenceWeapon
 * 
 * 	pRange:
 * 	  0: BrawlRange			5: Close+SpearRange
 * 	  1: CloseRange			6: Spear+PikeRange
 * 	  2: SpearRange			7: Brawl+Close+Spear
 * 	  3: PikeRange			8: Close+Spear+Pike
 * 	  4: Brawl+CloseRange	9: All
 * 
 * pMund:
 * 	 00: Mundan			  	08: Arkan+Holy
 * 	 01: Nonleathal		  	09: Arkan+Unholy
 * 	 02: Arkan			  	10: Holy+Unholy
 * 	 03: Holy			  	11: Nonle+Ark+Hol
 * 	 04: Unholy				12: Nonle+Ark+Unho
 * 	 05: Nonlethal+Arkan	13: Nonle+Ho+Unho
 * 	 06: Nonlethal+Holy		14: Ark+Ho+Unho
 *   07: Nonlehtal+Unholy	15: All
 *   
 * pWeaponType:
 * 	 26: kleine Schilde		28: sehr groﬂe Schilde
 * 	 27: groﬂe Schilde		29: Parierwaffen	
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
**/
package pLogik;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="defenceweapon")
public class DefenceWeapon extends CloseWeapon {

	/**	Dh	9.7.2020
	 * 
	 * 	Bean-Standard Konstruktor.
	 */
	public DefenceWeapon() {
		super();
	}
	/**	Dh	9.7.2020
	 * 
	 * 	pWeaponType:
	 * 	 26: kleine Schilde		28: sehr groﬂe Schilde
	 * 	 27: groﬂe Schilde		29: Parierwaffen
	 * 
	 * @param pID
	 * @param pName
	 * @param pWeaponType
	 * @param pTPKK
	 * @param pWM
	 * @param pBF
	 * @param pIniMod
	 */
	public DefenceWeapon(int pID, String pName, int pWeaponType, int[] pWM, int pBF,
			int pIniMod) {
		super(pID, pName, pWeaponType, new int[] {0, 0}, new int[] {0, 0}, pWM, pBF, pIniMod, 0);
	}
	/**	Dh	9.7.2020
	 * 
	 * 	pMund:
	 * 	 00: Mundan			  	08: Arkan+Holy
	 * 	 01: Nonleathal		  	09: Arkan+Unholy
	 * 	 02: Arkan			  	10: Holy+Unholy
	 * 	 03: Holy			  	11: Nonle+Ark+Hol
	 * 	 04: Unholy				12: Nonle+Ark+Unho
	 * 	 05: Nonlethal+Arkan	13: Nonle+Ho+Unho
	 * 	 06: Nonlethal+Holy		14: Ark+Ho+Unho
	 *   07: Nonlehtal+Unholy	15: All
	 * 
	 * 	pWeaponType:
	 * 	 26: kleine Schilde		28: sehr groﬂe Schilde
	 * 	 27: groﬂe Schilde		29: Parierwaffen
	 * 
	 * @param pID
	 * @param pName
	 * @param pWeaponType
	 * @param pMund
	 * @param pWM
	 * @param pBF
	 * @param pIniMod
	 */
	public DefenceWeapon(int pID, String pName, int pWeaponType, int pMund, int[] pWM, int pBF,
			int pIniMod) {
		super(pID, pName, pWeaponType, new int[] {0, 0}, new int[] {0, 0}, pMund, pWM, pBF, pIniMod, 0);
	}

//--------------------------------------------------------------------------------------------------------
	
}
