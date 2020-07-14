/**	DSA_App	v0.0	Dh	9.7.2020
 * 
 * 	Logik
 * 	  Weapon
 * 		RangeWeapon
 * 
 * pRagnes:
 * 	 0: Close
 * 	 1: Near
 * 	 2: Normal
 *   3: Far
 *   4: Max.
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
 * 	 12: Improvisiert		17: Schleuder
 * 	 13: Armbrust			18: Wurfbeil
 * 	 14: Blasrohr			19: Wurfmesser
 * 	 15: Bogen				20: Wurfspeer
 * 	 16: Diskus
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

@XmlRootElement(name = "rangeweapon")
@XmlType(propOrder = { "loadTime", "ranges", "tpRangeMods" })
public class RangeWeapon extends Weapon {
	private int loadTime;
	private int[] ranges, tpRangeMods;
	
	/**	Dh	27.5.2020
	 * 
	 * 	Konstruktur nach Bean vorschrift.
	 */
	public RangeWeapon() {
		super();
		
		loadTime = -1;
		ranges = new int[]{0, 0, 0, 0, 0};
		tpRangeMods = new int[] {0, 0, 0, 0, 0};
	}
	/**	Dh	5.6.2020
	 * 	
	 * pRagnes:
	 * 	 0: Close
	 * 	 1: Near
	 * 	 2: Normal
	 *   3: Far
	 *   4: Max.
	 *   
	 * pWeaponType:
	 * 	 12: Improvisiert		17: Schleuder
	 * 	 13: Armbrust			18: Wurfbeil
	 * 	 14: Blasrohr			19: Wurfmesser
	 * 	 15: Bogen				20: Wurfspeer
	 * 	 16: Diskus				
	 * 
	 * @param pID
	 * @param pName
	 * @param pTP
	 * @param pRanges
	 */
	public RangeWeapon(int pID, String pName, int pWeaponType, int[] pTP, int[] pRanges, int[] pTPRangeMods) {
		super(pID, pName, pWeaponType, pTP);
		Exception vExc = null;
		
		loadTime = 0;
		if (pRanges.length == 5) {
			if ((pRanges[0] >= 0) && (pRanges[1] >= 0) && (pRanges[2] >= 0) && (pRanges[3] >= 0) && (pRanges[4] >= 0)) ranges = pRanges;
			else vExc = new Exception("02; RaWea_a");
		}else vExc = new Exception("01; RaWea_a");
		if (pTPRangeMods.length == 5) {
			tpRangeMods = pTPRangeMods; 
		}else vExc = new Exception("01; RaWea_a");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	5.6.2020
	 * 
	 * pRagnes:
	 * 	 0: Close
	 * 	 1: Near
	 * 	 2: Normal
	 *   3: Far
	 *   4: Max.
	 *   
	 * pWeaponType:
	 * 	 12: Improvisiert		17: Schleuder
	 * 	 13: Armbrust			18: Wurfbeil
	 * 	 14: Blasrohr			19: Wurfmesser
	 * 	 15: Bogen				20: Wurfspeer
	 * 	 16: Diskus
	 * 
	 * @param pID
	 * @param pName
	 * @param pTP
	 * @param pRanges
	 * @param pTPRangeMods
	 */
	public RangeWeapon(int pID, String pName, int pWeaponType, int[] pTP, int[] pRanges, int[] pTPRangeMods, int pLoadTime) {
		super(pID, pName, pWeaponType, pTP);
		Exception vExc = null;
		
		if (pLoadTime >= 0) loadTime = pLoadTime;
		else vExc = new Exception("02; RaWea_b");
		if (pRanges.length == 5) {
			if ((pRanges[0] >= 0) && (pRanges[1] >= 0) && (pRanges[2] >= 0) && (pRanges[3] >= 0) && (pRanges[4] >= 0)) ranges = pRanges;
			else vExc = new Exception("02; RaWea_b");
		}else vExc = new Exception("01; RaWea_b");
		if (pTPRangeMods.length == 5) {
			tpRangeMods = pTPRangeMods; 
		}else vExc = new Exception("01; RaWea_b");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	5.6.2020
	 * 
	 * pRagnes:
	 * 	 0: Close
	 * 	 1: Near
	 * 	 2: Normal
	 *   3: Far
	 *   4: Max.
	 *   
	 * pWeaponType:
	 * 	 12: Improvisiert		17: Schleuder
	 * 	 13: Armbrust			18: Wurfbeil
	 * 	 14: Blasrohr			19: Wurfmesser
	 * 	 15: Bogen				20: Wurfspeer
	 * 	 16: Diskus
	 * 
	 * @param pID
	 * @param pName
	 * @param pTP
	 * @param pRanges
	 * @param pTPRangeMods
	 * @param pLoadTime
	 */
	public RangeWeapon(int pID, String pName, int pWeaponType, int[] pTP, int pMund, int[] pRanges, int[] pTPRangeMods, int pLoadTime) {
		super(pID, pName, pWeaponType, pTP, pMund);
		Exception vExc = null;
		
		if (pLoadTime >= 0) loadTime = pLoadTime;
		else vExc = new Exception("02; RaWea_c");
		if (pRanges.length == 5) {
			if ((pRanges[0] >= 0) && (pRanges[1] >= 0) && (pRanges[2] >= 0) && (pRanges[3] >= 0) && (pRanges[4] >= 0)) ranges = pRanges;
			else vExc = new Exception("02; RaWea_c");
		}else vExc = new Exception("01; RaWea_c");
		if (pTPRangeMods.length == 5) {
			tpRangeMods = pTPRangeMods; 
		}else vExc = new Exception("01; RaWea_c");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	5.6.2020
	 * 
	 * pRagnes:
	 * 	 0: Close
	 * 	 1: Near
	 * 	 2: Normal
	 *   3: Far
	 *   4: Max.	
	 *   
	 * pWeaponType:
	 * 	 12: Improvisiert		17: Schleuder
	 * 	 13: Armbrust			18: Wurfbeil
	 * 	 14: Blasrohr			19: Wurfmesser
	 * 	 15: Bogen				20: Wurfspeer
	 * 	 16: Diskus
	 * 
	 * @param pID
	 * @param pName
	 * @param pTP
	 * @param pMund
	 * @param pTPKK
	 * @param pRanges
	 * @param pTPRangeMods
	 * @param pLoadTime
	 */
	public RangeWeapon(int pID, String pName, int pWeaponType, int[] pTP, int pMund, int[] pTPKK, int[] pRanges, int[] pTPRangeMods, int pLoadTime) {
		super(pID, pName, pWeaponType, pTP, pTPKK, pMund);
		Exception vExc = null;
		
		if (pLoadTime >= 0) loadTime = pLoadTime;
		else vExc = new Exception("02; RaWea_d");
		if (pRanges.length == 5) {
			if ((pRanges[0] >= 0) && (pRanges[1] >= 0) && (pRanges[2] >= 0) && (pRanges[3] >= 0) && (pRanges[4] >= 0)) ranges = pRanges;
			else vExc = new Exception("02; RaWea_d");
		}else vExc = new Exception("01; RaWea_d");
		if (pTPRangeMods.length == 5) {
			tpRangeMods = pTPRangeMods; 
		}else vExc = new Exception("01; RaWea_d");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "LoadTime")
	public int getLoadTime() {
		return loadTime;
	}
	
	/**	Dh	27.5.2020
	 * 
	 * pRagnes:
	 * 	 0: Close
	 * 	 1: Near
	 * 	 2: Normal
	 *   3: Far
	 *   4: Max.
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getRange(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < ranges.length)) return ranges[pInd];
		else throw new Exception("01; RaWea,gR");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getTpRangMod(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < tpRangeMods.length)) return tpRangeMods[pInd];
		else throw new Exception("01; RaWea,gTPRM");
	}
	/**	Dh	27.5.2020
	 * 
	 * pRagnes:
	 * 	 0: Close
	 * 	 1: Near
	 * 	 2: Normal
	 *   3: Far
	 *   4: Max.
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "RangesArray")
	@XmlElement(name = "Range")
	public int[] getRanges() {
		return ranges;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "TPRangeModsArray")
	@XmlElement(name = "TPRangeMod")
	public int[] getTpRangeMods() {
		return tpRangeMods;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	27.5.2020
	 * 
	 * @param pLoadTime
	 * @throws Exception
	 */
	public void setLoadTime(int pLoadTime) throws Exception{
		if (pLoadTime >= 0) loadTime = pLoadTime;
		else throw new Exception("02; RaWea, sLT");
	}
	
	/**	Dh	27.5.2020
	 * 
	 * pRagnes:
	 * 	 0: Close
	 * 	 1: Near
	 * 	 2: Normal
	 *   3: Far
	 *   4: Max.
	 * 
	 * @param pRangeValue
	 * @param pInd
	 * @throws Exception
	 */
	public void setRange(int pRangeValue, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < ranges.length)) {
			if (pRangeValue >= 0) ranges[pInd] = pRangeValue;
			else throw new Exception("02; RaWea,sR");
		} else throw new Exception("07; RaWea,sR");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pTPRangeMod
	 * @param pInd
	 * @throws Exception
	 */
	public void setTpRangeMod(int pTPRangeMod, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < tpRangeMods.length)) {
			tpRangeMods[pInd] = pTPRangeMod;
		} else throw new Exception("07; RaWea,sTPRM");
	}
	/**	Dh	27.5.2020
	 * 
	 * pRagnes:
	 * 	 0: Close
	 * 	 1: Near
	 * 	 2: Normal
	 *   3: Far
	 *   4: Max.
	 * 
	 * @param pRanges
	 * @throws Exception
	 */
	public void setRanges(int[] pRanges) throws Exception {
		if (pRanges.length == ranges.length) {
			if ((pRanges[0] >= 0) && (pRanges[1] >= 0) && (pRanges[2] >= 0) && (pRanges[3] >= 0) &&
					(pRanges[4] >= 0)) ranges = pRanges;
			else throw new Exception("02; RaWea,sRs");
		}else throw new Exception("01; RaWea,sRs");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pTPRangeMods
	 * @throws Exception
	 */
	public void setTpRangeMods(int[] pTPRangeMods) throws Exception {
		if (pTPRangeMods.length == tpRangeMods.length) {
			tpRangeMods = pTPRangeMods;
		}else throw new Exception("01; RaWea,sTPRM");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	28.5.2020
	 * 
	 * 	Berechnet Grundsätzlich den Schaden, den eine Waffe, ohne TPKK macht, aber mit Reichweiten Mod.
	 */
	public int calTP(int pDistance) throws Exception{
		int vRet = super.calTP();
		int vDisInd;
		
		try{
			vDisInd = getRangeTypeOfDistance(pDistance);
			if (vDisInd != -1) {
				vRet += tpRangeMods[vDisInd];
			}else throw new Exception("02; RaWea,cD"); 
		} catch (Exception ex) {throw ex;}		
		
		return vRet;
	}
	/**	Dh	28.5.2020
	 * 
	 * 	Berechnet Grundsätzlich den Schaden, den eine Waffe macht, mit alles Mods eingeschlossen.
	 * 
	 * @param pDistance
	 * @param pKK
	 * @return
	 * @throws Exception
	 */
	public int calTP(int pDistance, int pKK) throws Exception{
		int vRet = super.calTP(pKK);
		int vDisInd;
		
		try{
			vDisInd = getRangeTypeOfDistance(pDistance);
			if (vDisInd != -1) {
				vRet += tpRangeMods[vDisInd];
			}else throw new Exception("02; RaWea,cD"); 
		} catch (Exception ex) {throw ex;}		
		
		return vRet;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	27.5.2020
	 * 
	 * 	Bestimmt die Reichweitenkategorie, in der pDistance fuer die Waffe liegt.
	 * 
	 * @param pDistance
	 * @return
	 * @throws Exception
	 */
	public int getRangeTypeOfDistance(int pDistance) throws Exception {
		int vRet = -1;
		
		if (pDistance >= 0) {
			if (isInCloseRange(pDistance) == true) vRet = 0;
			else if (isInNearRange(pDistance) == true) vRet = 1;
			else if (isInMiddleRange(pDistance) == true) vRet = 2;
			else if (isInFarRange(pDistance) == true) vRet = 3;
			else if (isInMaxRange(pDistance) == true) vRet = 4;
		}else throw new Exception("02; RaWea,gRToD");
		
		return vRet;
	}
	
	/**	Dh	27.5.2020
	 * 
	 * 	Prueft ob pDistance kleiner als die CloseRange ist.
	 * 
	 * @param pDistance
	 * @return
	 * @throws Exception
	 */
	public boolean isWithinCloseRange(int pDistance)  throws Exception{
		if (pDistance >= 0) {
			if (pDistance <= ranges[0]) return true;
			else return false;
		} else throw new Exception("02; RaWea,iwCR");
	}
	/**	Dh	27.5.2020
	 * 
	 * 	Prueft ob pDistance kleiner als die NearRange ist.
	 * 
	 * @param pDistance
	 * @return
	 * @throws Exception
	 */
	public boolean isWithinNearRange(int pDistance) throws Exception{
		if (pDistance >= 0) {
			if (pDistance <= ranges[1]) return true;
			else return false;
		} else throw new Exception("02; RaWea,iwNR");
	}
	/**	Dh	27.5.2020
	 * 
	 * 	Prueft ob pDistance kleiner als die MiddleRange ist.
	 * 
	 * @param pDistance
	 * @return
	 * @throws Exception
	 */
	public boolean isWithinMiddleRange(int pDistance) throws Exception{
		if (pDistance >= 0) {
			if (pDistance <= ranges[2]) return true;
			else return false;
		} else throw new Exception("02; RaWea,iwMiR");
	}
	/**	Dh	27.5.2020
	 * 
	 * 	Prueft ob pDistance kleiner als die FarRange ist.
	 * 
	 * @param pDistance
	 * @return
	 * @throws Exception
	 */
	public boolean isWithinFarRange(int pDistance) throws Exception{
		if (pDistance >= 0) {
			if (pDistance <= ranges[3]) return true;
			else return false;
		} else throw new Exception("02; RaWea,iwFR");
	}
	/**	Dh	27.5.2020
	 * 
	 * 	Prueft ob pDistance kleiner als die MaxRange ist.
	 * 
	 * @param pDistance
	 * @return
	 * @throws Exception
	 */
	public boolean isWithinMaxRange(int pDistance) throws Exception{
		if (pDistance >= 0) {
			if (pDistance <= ranges[4]) return true;
			else return false;
		} else throw new Exception("02; RaWea,iwMaR");
	}
	
	/**	Dh	27.5.2020
	 * 
	 * 	Prueft ob pDistance genau in der CloseRange liegt; groesser als alle kleineren.
	 * 
	 * @param pDistance
	 * @return
	 * @throws Exception
	 */
	public boolean isInCloseRange(int pDistance) throws Exception{
		if (pDistance >= 0) {
			if (pDistance <= ranges[0]) return true;
			else return false;
		} else throw new Exception("02; RaWea,iiCR");
	}
	/**	Dh	27.5.2020
	 * 
	 * 	Prueft ob pDistance genau in der NearRange liegt; groesser als alle kleineren.
	 * 
	 * @param pDistance
	 * @return
	 * @throws Exception
	 */
	public boolean isInNearRange(int pDistance) throws Exception{
		if (pDistance >= 0) {
			if ((pDistance > ranges[0]) && (pDistance <= ranges[1])) return true;
			else return false;
		} else throw new Exception("02; RaWea,iiNR");
	}
	/**	Dh	27.5.2020
	 * 
	 * 	Prueft ob pDistance genau in der MiddleRange liegt; groesser als alle kleineren.
	 * 	
	 * @param pDistance
	 * @return
	 * @throws Exception
	 */
	public boolean isInMiddleRange(int pDistance) throws Exception{
		if (pDistance >= 0) {
			if ((pDistance > ranges[1]) && (pDistance <= ranges[2])) return true;
			else return false;
		} else throw new Exception("02; RaWea,iiMiR");
	}
	/**	Dh	27.5.2020
	 * 
	 * 	Prueft ob pDistance genau in der FarRange liegt; groesser als alle kleineren.
	 * 
	 * @param pDistance
	 * @return
	 * @throws Exception
	 */
	public boolean isInFarRange(int pDistance) throws Exception{
		if (pDistance >= 0) {
			if ((pDistance > ranges[2]) && (pDistance <= ranges[3])) return true;
			else return false;
		} else throw new Exception("02; RaWea,iiFR");
	}
	/**	Dh	27.5.2020
	 * 
	 * 	Prueft ob pDistance genau in der MaxRange liegt; groesser als alle kleineren.
	 * 
	 * @param pDistance
	 * @return
	 * @throws Exception
	 */
	public boolean isInMaxRange(int pDistance) throws Exception{
		if (pDistance >= 0) {
			if ((pDistance > ranges[3]) && (pDistance <= ranges[4])) return true;
			else return false;
		} else throw new Exception("02; RaWea,iiMaR");
	}
}
