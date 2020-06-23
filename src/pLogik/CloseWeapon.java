/**	DSA_App	v0.0	Dh	4.6.2020
 * 
 * 	Logik
 * 	  Weapon
 * 		CloseWeapon
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
 * 	 00: Raufen				08: Staebe
 * 	 01: Ringen				09: Zweihandpflegel
 * 	 02: Anderhalbhaender	10: Zweihand-Hiebwaffen
 * 	 03: Dolche				11: Zweihandschwerter
 * 	 04: Fechtwaffen		12: Improvisiert
 * 	 05: Hiebwaffen			13: Armbrust
 * 	 06: Infanteriewaffen	14: Blasrohr
 * 	 07: Kettenstaebe		15: Bogen
 * 	 08: Kettenwwaffen		16: Diskus
 * 	 09: Peitsche			17: Schleuder
 * 	 10: Saebel				18: Wurfbeil
 * 	 11: Schwerter			19: Wurfmesser
 * 	 12: Speere				20: Wurfspeer
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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import pGUI.MainFrame;

@XmlRootElement(name="closeweapon")
@XmlType(propOrder = { "BF", "iniMod", "WM", "brwalRange", "closeRange", "spearRange", "pikeRange" })
public class CloseWeapon extends Weapon {
	private boolean BrawlRange, CloseRange, SpearRange, PikeRange;
	private int BF, IniMod;
	private int[] WM;
	
	/**	Dh	27.5.2020
	 * 
	 * 	Konstruktur nach Bean vorschrift.
	 */
	public CloseWeapon() {
		super();
		
		BF = 12;
		IniMod = 0;
		
		WM = new int[] {0, 0};
		
		BrawlRange = false;
		CloseRange = false;
		SpearRange = false;
		PikeRange = false;
	}
	/**	Dh	5.6.2020
	 * 
	 * 	pRange:
	 * 	  0: BrawlRange			5: Close+SpearRange
	 * 	  1: CloseRange			6: Spear+PikeRange
	 * 	  2: SpearRange			7: Brawl+Close+Spear
	 * 	  3: PikeRange			8: Close+Spear+Pike
	 * 	  4: Brawl+CloseRange	9: All
	 * 
	 * 	pWeaponType:
	 * 	 00: Raufen				08: Staebe
	 * 	 01: Ringen				09: Zweihandpflegel
	 * 	 02: Anderhalbhaender	10: Zweihand-Hiebwaffen
	 * 	 03: Dolche				11: Zweihandschwerter
	 * 	 04: Fechtwaffen		12: Improvisiert
	 * 	 05: Hiebwaffen			13: Armbrust
	 * 	 06: Infanteriewaffen	14: Blasrohr
	 * 	 07: Kettenstaebe		15: Bogen
	 * 	 08: Kettenwwaffen		16: Diskus
	 * 	 09: Peitsche			17: Schleuder
	 * 	 10: Saebel				18: Wurfbeil
	 * 	 11: Schwerter			19: Wurfmesser
	 * 	 12: Speere				20: Wurfspeer
	 * 
	 * @param pID
	 * @param pName
	 * @param pTP
	 * @param pTPKK
	 * @param pWM
	 * @param pBF
	 * @param pIniMod
	 * @param pRange
	 */
	public CloseWeapon(int pID, String pName, int pWeaponType, int[] pTP, int[] pTPKK, int[] pWM, int pBF, int pIniMod, int pRange) {
		super(pID, pName, pWeaponType, pTP, pTPKK);
		Exception vExc = null;
		
		BF = pBF;
		IniMod = pIniMod;
		
		if (pWM.length == 2) {
			WM = pWM;
		}
		else vExc = new Exception("01; ClWea_a");
		
		if ((pRange < 0) || (pRange >= 10)) vExc = new Exception("02; ClWea_a");
		if ((pRange == 0) || (pRange == 4) || (pRange == 7) || (pRange == 9)) BrawlRange = true;
		else BrawlRange = false;
		if ((pRange == 1) || (pRange == 4) || (pRange == 5) || (pRange == 7) || (pRange == 8) || (pRange == 9)) CloseRange = true;
		else CloseRange = false;
		if ((pRange == 2) || (pRange == 5) || (pRange == 6) || (pRange == 7) || (pRange == 8) || (pRange == 9)) SpearRange = true;
		else SpearRange = false;
		if ((pRange == 3) || (pRange == 6) || (pRange == 8) || (pRange == 9)) PikeRange = true;
		else PikeRange = false;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	5.6.2020
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
	 * 	 00: Raufen				08: Staebe
	 * 	 01: Ringen				09: Zweihandpflegel
	 * 	 02: Anderhalbhaender	10: Zweihand-Hiebwaffen
	 * 	 03: Dolche				11: Zweihandschwerter
	 * 	 04: Fechtwaffen		12: Improvisiert
	 * 	 05: Hiebwaffen			13: Armbrust
	 * 	 06: Infanteriewaffen	14: Blasrohr
	 * 	 07: Kettenstaebe		15: Bogen
	 * 	 08: Kettenwwaffen		16: Diskus
	 * 	 09: Peitsche			17: Schleuder
	 * 	 10: Saebel				18: Wurfbeil
	 * 	 11: Schwerter			19: Wurfmesser
	 * 	 12: Speere				20: Wurfspeer
	 * 
	 * @param pID
	 * @param pName
	 * @param pTP
	 * @param pMund
	 * @param pTPKK
	 * @param pWM
	 * @param pBF
	 * @param pIniMod
	 * @param pRange
	 */
	public CloseWeapon(int pID, String pName, int pWeaponType, int[] pTP, int[] pTPKK, int pMund, int[] pWM, int pBF, int pIniMod, int pRange) {
		super(pID, pName, pWeaponType, pTP, pTPKK, pMund);
		Exception vExc = null;
		
		BF = pBF;
		IniMod = pIniMod;
		
		if (pWM.length == 2) {
			WM = pWM;
		}
		else vExc = new Exception("01; ClWea_b");
		
		if ((pRange < 0) || (pRange >= 10)) vExc = new Exception("02; ClWea_b");
		if ((pRange == 0) || (pRange == 4) || (pRange == 7) || (pRange == 9)) BrawlRange = true;
		else BrawlRange = false;
		if ((pRange == 1) || (pRange == 4) || (pRange == 5) || (pRange == 7) || (pRange == 8) || (pRange == 9)) CloseRange = true;
		else CloseRange = false;
		if ((pRange == 2) || (pRange == 5) || (pRange == 6) || (pRange == 7) || (pRange == 8) || (pRange == 9)) SpearRange = true;
		else SpearRange = false;
		if ((pRange == 3) || (pRange == 6) || (pRange == 8) || (pRange == 9)) PikeRange = true;
		else PikeRange = false;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}

//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "BF")
	public int getBF() {
		return BF;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "IniMod")
	public int getIniMod() {
		return IniMod;
	}
	
	/**	Dh	27.5.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getWM(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 2)) return WM[pInd];
		else throw new Exception("07; ClWea,gWM");
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "WMArray")
	public int[] getWM() {
		return WM;
	}
	
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "BrawlRange")
	public boolean isBrwalRange() {
		return BrawlRange;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "CloseRange")
	public boolean isCloseRange() {
		return CloseRange;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "SpearRange")
	public boolean isSpearRange() {
		return SpearRange;
	}
	/**	Dh	27.5.2020
	 * 	
	 * @return
	 */
	@XmlElement(name = "PikeRange")
	public boolean isPikeRange() {
		return PikeRange;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	27.5.2020
	 * 
	 * @param pBF
	 */
	public void setBF(int pBF) {
		BF = pBF;
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pIniMod
	 */
	public void setIniMod(int pIniMod) {
		IniMod = pIniMod;
	}
	
	/**	Dh	27.5.2020
	 * 
	 * @param pWMValue
	 * @param pInd
	 * @throws Exception
	 */
	public void setWM(int pWMValue, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 2)) {
			WM[pInd] = pWMValue;
		} else throw new Exception("07; ClWea,sWM");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pWM
	 * @throws Exception
	 */
	public void setWM(int[] pWM) throws Exception {
		if (pWM.length == 2) {
			WM = pWM;
		} else throw new Exception("01; ClWea,sWM");
	}
	
	/**	Dh	27.5.2020
	 * 
	 * @param pBrawlRange
	 */
	public void setBrawlRange(boolean pBrawlRange) {
		BrawlRange = pBrawlRange;
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pCloseRange
	 */
	public void setCloseRange(boolean pCloseRange) {
		CloseRange = pCloseRange;
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pSpearRange
	 */
	public void setSpearRange(boolean pSpearRange) {
		SpearRange = pSpearRange;
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pPikeRange
	 */
	public void setPikeRange(boolean pPikeRange) {
		PikeRange = pPikeRange;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**27.5.2020
	 * 
	 * @param pBF
	 */
	public void addBF(int pBF) {
		BF += pBF;
	}
	
	//----------------------------------------------------------------------------------------------------
	
}
