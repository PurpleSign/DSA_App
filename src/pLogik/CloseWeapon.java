/**	DSA_App	v0.0	Dh	10.7.2020
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
 * 	 00: Raufen				09: Peitsche
 * 	 01: Ringen				10: Saebel
 * 	 02: Anderhalbhaender	11: Schwerter
 * 	 03: Dolche				12: Speere
 * 	 04: Fechtwaffen		13: Staebe
 * 	 05: Hiebwaffen			14: Zweihandpflegel
 * 	 06: Infanteriewaffen	15: Zweihand-Hiebwaffen
 * 	 07: Kettenstaebe		16: Zweihandschwerter
 * 	 08: Kettenwaffen		
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
 * 	  09 Wrong Selection
**/
package pLogik;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import pGUI.MainFrame;

@XmlRootElement(name="closeweapon")
@XmlSeeAlso(DefenceWeapon.class)
@XmlType(propOrder = { "bf", "iniMod", "wm", "brawlRange", "closeRange", "spearRange", "pikeRange" })
public class CloseWeapon extends Weapon {
	private boolean isBrawlRange, isCloseRange, isSpearRange, isPikeRange;
	private int bf, iniMod;
	private int[] wm;
	
	/**	Dh	27.5.2020
	 * 
	 * 	Konstruktur nach Bean vorschrift.
	 */
	public CloseWeapon() {
		super();
		
		bf = 12;
		iniMod = 0;
		
		wm = new int[] {0, 0};
		
		isBrawlRange = false;
		isCloseRange = false;
		isSpearRange = false;
		isPikeRange = false;
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
	 * 	 00: Raufen				09: Peitsche
	 * 	 01: Ringen				10: Saebel
	 * 	 02: Anderhalbhaender	11: Schwerter
	 * 	 03: Dolche				12: Speere
	 * 	 04: Fechtwaffen		13: Staebe
	 * 	 05: Hiebwaffen			14: Zweihandpflegel
	 * 	 06: Infanteriewaffen	15: Zweihand-Hiebwaffen
	 * 	 07: Kettenstaebe		16: Zweihandschwerter
	 * 	 08: Kettenwaffen		

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
		
		bf = pBF;
		iniMod = pIniMod;
		
		if (pWM.length == 2) {
			wm = pWM;
		}
		else vExc = new Exception("01; ClWea_a");
		
		if ((pRange < 0) || (pRange >= 10)) vExc = new Exception("02; ClWea_a");
		if ((pRange == 0) || (pRange == 4) || (pRange == 7) || (pRange == 9)) isBrawlRange = true;
		else isBrawlRange = false;
		if ((pRange == 1) || (pRange == 4) || (pRange == 5) || (pRange == 7) || (pRange == 8) || (pRange == 9)) isCloseRange = true;
		else isCloseRange = false;
		if ((pRange == 2) || (pRange == 5) || (pRange == 6) || (pRange == 7) || (pRange == 8) || (pRange == 9)) isSpearRange = true;
		else isSpearRange = false;
		if ((pRange == 3) || (pRange == 6) || (pRange == 8) || (pRange == 9)) isPikeRange = true;
		else isPikeRange = false;
		
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
	 * 	 00: Raufen				09: Peitsche
	 * 	 01: Ringen				10: Saebel
	 * 	 02: Anderhalbhaender	11: Schwerter
	 * 	 03: Dolche				12: Speere
	 * 	 04: Fechtwaffen		13: Staebe
	 * 	 05: Hiebwaffen			14: Zweihandpflegel
	 * 	 06: Infanteriewaffen	15: Zweihand-Hiebwaffen
	 * 	 07: Kettenstaebe		16: Zweihandschwerter
	 * 	 08: Kettenwaffen		
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
		
		bf = pBF;
		iniMod = pIniMod;
		
		if (pWM.length == 2) {
			wm = pWM;
		}
		else vExc = new Exception("01; ClWea_b");
		
		if ((pRange < 0) || (pRange >= 10)) vExc = new Exception("02; ClWea_b");
		if ((pRange == 0) || (pRange == 4) || (pRange == 7) || (pRange == 9)) isBrawlRange = true;
		else isBrawlRange = false;
		if ((pRange == 1) || (pRange == 4) || (pRange == 5) || (pRange == 7) || (pRange == 8) || (pRange == 9)) isCloseRange = true;
		else isCloseRange = false;
		if ((pRange == 2) || (pRange == 5) || (pRange == 6) || (pRange == 7) || (pRange == 8) || (pRange == 9)) isSpearRange = true;
		else isSpearRange = false;
		if ((pRange == 3) || (pRange == 6) || (pRange == 8) || (pRange == 9)) isPikeRange = true;
		else isPikeRange = false;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}

//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "BF")
	public int getBf() {
		return bf;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "IniMod")
	public int getIniMod() {
		return iniMod;
	}
	
	/**	Dh	27.5.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getWm(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 2)) return wm[pInd];
		else throw new Exception("07; ClWea,gWM");
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "WMArray")
	@XmlElement(name = "WM")
	public int[] getWm() {
		return wm;
	}
	
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "BrawlRange")
	public boolean isBrawlRange() {
		return isBrawlRange;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "CloseRange")
	public boolean isCloseRange() {
		return isCloseRange;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "SpearRange")
	public boolean isSpearRange() {
		return isSpearRange;
	}
	/**	Dh	27.5.2020
	 * 	
	 * @return
	 */
	@XmlElement(name = "PikeRange")
	public boolean isPikeRange() {
		return isPikeRange;
	}
	
	/**	Dh	10.7.2020
	 * 
	 * 	pRange:
	 * 	  0: BrawlRange			5: Close+SpearRange
	 * 	  1: CloseRange			6: Spear+PikeRange
	 * 	  2: SpearRange			7: Brawl+Close+Spear
	 * 	  3: PikeRange			8: Close+Spear+Pike
	 * 	  4: Brawl+CloseRange	9: All
	 * 
	 * @return
	 */
	@XmlTransient
	public int getDk() throws Exception{
		int vRet = -1;
		
		if (isBrawlRange == true) {
			if (isCloseRange == true) {
				if (isSpearRange == true) {
					if (isPikeRange == true) vRet = 9;
					else vRet = 7;
				} else vRet = 4;
			} else vRet = 0;
		} else if (isCloseRange == true) {
			if (isSpearRange == true) {
				if (isPikeRange == true) vRet = 8;
				else vRet = 5;
			} else vRet = 1;
		}else if (isSpearRange == true) {
			if (isPikeRange == true) vRet = 6;
			else vRet = 2;
		} else if (isPikeRange == true) vRet = 3;
		else throw new Exception("09; ClWea,gDK");
		
		return vRet;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	27.5.2020
	 * 
	 * @param pBF
	 */
	public void setBf(int pBF) {
		bf = pBF;
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pIniMod
	 */
	public void setIniMod(int pIniMod) {
		iniMod = pIniMod;
	}
	
	/**	Dh	27.5.2020
	 * 
	 * @param pWMValue
	 * @param pInd
	 * @throws Exception
	 */
	public void setWm(int pWMValue, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 2)) {
			wm[pInd] = pWMValue;
		} else throw new Exception("07; ClWea,sWM");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pWM
	 * @throws Exception
	 */
	public void setWm(int[] pWM) throws Exception {
		if (pWM.length == 2) {
			wm = pWM;
		} else throw new Exception("01; ClWea,sWM");
	}
	
	/**	Dh	27.5.2020
	 * 
	 * @param pBrawlRange
	 */
	public void setBrawlRange(boolean pBrawlRange) {
		isBrawlRange = pBrawlRange;
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pCloseRange
	 */
	public void setCloseRange(boolean pCloseRange) {
		isCloseRange = pCloseRange;
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pSpearRange
	 */
	public void setSpearRange(boolean pSpearRange) {
		isSpearRange = pSpearRange;
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pPikeRange
	 */
	public void setPikeRange(boolean pPikeRange) {
		isPikeRange = pPikeRange;
	}
	
	/**	Dh	10.7.2020
	 * 
	 * @param pDk
	 * @throws Exception
	 */
	public void setDk(int pDk) throws Exception{
		if ((pDk < 0) || (pDk >= 10)) throw new Exception("02; ClWea,sDK");
		if ((pDk == 0) || (pDk == 4) || (pDk == 7) || (pDk == 9)) isBrawlRange = true;
		else isBrawlRange = false;
		if ((pDk == 1) || (pDk == 4) || (pDk == 5) || (pDk == 7) || (pDk == 8) || (pDk == 9)) isCloseRange = true;
		else isCloseRange = false;
		if ((pDk == 2) || (pDk == 5) || (pDk == 6) || (pDk == 7) || (pDk == 8) || (pDk == 9)) isSpearRange = true;
		else isSpearRange = false;
		if ((pDk == 3) || (pDk == 6) || (pDk == 8) || (pDk == 9)) isPikeRange = true;
		else isPikeRange = false;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**27.5.2020
	 * 
	 * @param pBF
	 */
	public void addBf(int pBF) {
		bf += pBF;
	}
	
	//----------------------------------------------------------------------------------------------------
	
}
