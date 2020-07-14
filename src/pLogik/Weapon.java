/**	DSA_App	v0.0	Dh	9.7.2020
 * 
 * 	Logik
 * 	  Weapon
 * 
 * 	
 * 
 * pMund:
 * 	 00: Mundan			  	08: Unholy
 * 	 01: Nonleathal		  	09: Nonlehtal+Unholy
 * 	 02: Arkan			  	10: Arkan+Unholy
 * 	 03: Nonlethal+Arkan  	11: Nonle+Ark+Unho
 * 	 04: Holy				12: Holy+Unholy
 * 	 05: Nonlethal+Holy		13: Nonle+Ho+Unho
 * 	 06: Arkan+Holy			14: Ark+Ho+Unho
 *   07: Nonle+Ark+Hol		15: All
 *   
 *   WeaponType:
 * 	 00: Raufen				13: Staebe
 * 	 01: Ringen				14: Zweihandpflegel
 * 	 02: Anderhalbhaender	15: Zweihand-Hiebwaffen
 * 	 03: Dolche				16: Zweihandschwerter
 * 	 04: Fechtwaffen		17: Improvisiert
 * 	 05: Hiebwaffen			18: Armbrust
 * 	 06: Infanteriewaffen	19: Blasrohr
 * 	 07: Kettenstaebe		20: Bogen
 * 	 08: Kettenwwaffen		21: Diskus
 * 	 09: Peitsche			22: Schleuder
 * 	 10: Saebel				23: Wurfbeil
 * 	 11: Schwerter			24: Wurfmesser
 * 	 12: Speere				25: Wurfspeer
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

import java.util.Random;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import pGUI.MainFrame;

@XmlRootElement(name="weapon")
@XmlSeeAlso({CloseWeapon.class, RangeWeapon.class})
@XmlType(propOrder = { "name", "tp", "tpkk", "arkan", "holy", "unholy", "nonLethal" })
public abstract class Weapon {
	private boolean isArkan, isHoly, isUnholy, isNonLethal;
	private int id, weaponType;
	private int[] tp;
	private int[] tpkk;
	private String name;
	
	/**	Dh	28.5.2020
	 * 
	 * 	Konstruktor gemaess Bean vorschrift.
	 * 
	 */
	public Weapon() {
		id = -1;
		weaponType = -1;
		name = "";
		
		tp = new int[] {0, 0};
		tpkk = new int[] {0, 0};
		
		isArkan = false;
		isHoly = false;
		isUnholy = false;
	}
	/**	Dh	28.5.2020
	 * 
	 * pWeaponType:
	 * 	 00: Raufen				15: Zweihand-Hiebwaffen
	 * 	 01: Ringen				16: Zweihandschwerter
	 * 	 02: Anderhalbhaender	17: Improvisiert
	 * 	 03: Dolche				18: Armbrust
	 * 	 04: Fechtwaffen		19: Blasrohr
	 * 	 05: Hiebwaffen			20: Bogen
	 * 	 06: Infanteriewaffen	21: Diskus
	 * 	 07: Kettenstaebe		22: Schleuder
	 * 	 08: Kettenwaffen		23: Wurfbeil
	 * 	 09: Peitsche			24: Wurfmesser
	 * 	 10: Saebel				25: Wurfspeer
	 * 	 11: Schwerter			26: kleine Schilde
	 * 	 12: Speere				27: große Schilde
	 * 	 13: Staebe				28: sehr große Schilde
	 * 	 14: Zweihandpflegel	29: Parierwaffen
	 * 
	 * @param pID
	 * @param pName
	 * @param pTP
	 */
	public Weapon(int pID, String pName, int pWeaponType, int[] pTP) {
		Exception vExc = null;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; Wea_a");
		if (pWeaponType >= 0) weaponType = pWeaponType;
		else vExc = new Exception("02; Wea_a");
		if ((pName != null) && (pName != "")) name = pName;
		else vExc =  new Exception("02; Wea_a");
		
		if (pTP.length == 2) {
			if (pTP[0] >= 0) tp = pTP;
			else vExc = new Exception("02, Wea_a");
		} else vExc = new Exception("01; Wea_a");
		tpkk = new int[] {0, 0};
		
		isNonLethal = false;
		isArkan = false;
		isHoly = false;
		isUnholy = false;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	28.5.2020
	 * 
	 * pWeaponType:
	 * 	 00: Raufen				15: Zweihand-Hiebwaffen
	 * 	 01: Ringen				16: Zweihandschwerter
	 * 	 02: Anderhalbhaender	17: Improvisiert
	 * 	 03: Dolche				18: Armbrust
	 * 	 04: Fechtwaffen		19: Blasrohr
	 * 	 05: Hiebwaffen			20: Bogen
	 * 	 06: Infanteriewaffen	21: Diskus
	 * 	 07: Kettenstaebe		22: Schleuder
	 * 	 08: Kettenwaffen		23: Wurfbeil
	 * 	 09: Peitsche			24: Wurfmesser
	 * 	 10: Saebel				25: Wurfspeer
	 * 	 11: Schwerter			26: kleine Schilde
	 * 	 12: Speere				27: große Schilde
	 * 	 13: Staebe				28: sehr große Schilde
	 * 	 14: Zweihandpflegel	29: Parierwaffen
	 * 
	 * @param pID
	 * @param pName
	 * @param pTP
	 * @param pTPKK
	 */
	public Weapon(int pID, String pName, int pWeaponType, int[] pTP, int[] pTPKK) {
		Exception vExc = null;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; Wea_b");
		if (pWeaponType >= 0) weaponType = pWeaponType;
		else vExc = new Exception("02; Wea_b");
		if ((pName != null) && (pName != "")) name = pName;
		else vExc =  new Exception("02; Wea_b");
		
		if (pTP.length == 2) {
			if (pTP[0] >= 0) tp = pTP;
			else vExc = new Exception("02, Wea_b");
		} else vExc = new Exception("01; Wea_b");
		if (pTPKK.length == 2) {
			if ((pTPKK[0] >= 0) && (pTPKK[1] >= 0)) tpkk = pTPKK;
			else vExc = new Exception("02; Wea_b");
		} else vExc = new Exception("01; Wea_b");
		
		isNonLethal = false;
		isArkan = false;
		isHoly = false;
		isUnholy = false;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/** Dh	9.7.2020
	 * 
	 * pWeaponType:
	 * 	 00: Raufen				15: Zweihand-Hiebwaffen
	 * 	 01: Ringen				16: Zweihandschwerter
	 * 	 02: Anderhalbhaender	17: Improvisiert
	 * 	 03: Dolche				18: Armbrust
	 * 	 04: Fechtwaffen		19: Blasrohr
	 * 	 05: Hiebwaffen			20: Bogen
	 * 	 06: Infanteriewaffen	21: Diskus
	 * 	 07: Kettenstaebe		22: Schleuder
	 * 	 08: Kettenwaffen		23: Wurfbeil
	 * 	 09: Peitsche			24: Wurfmesser
	 * 	 10: Saebel				25: Wurfspeer
	 * 	 11: Schwerter			26: kleine Schilde
	 * 	 12: Speere				27: große Schilde
	 * 	 13: Staebe				28: sehr große Schilde
	 * 	 14: Zweihandpflegel	29: Parierwaffen
	 * 
	 * pMund:
	 * 	 00: Mundan			  	08: Unholy
	 * 	 01: Nonleathal		  	09: Nonlehtal+Unholy
	 * 	 02: Arkan			  	10: Arkan+Unholy
	 * 	 03: Nonlethal+Arkan  	11: Nonle+Ark+Unho
	 * 	 04: Holy				12: Holy+Unholy
	 * 	 05: Nonlethal+Holy		13: Nonle+Ho+Unho
	 * 	 06: Arkan+Holy			14: Ark+Ho+Unho
	 *   07: Nonle+Ark+Hol		15: All
	 * 
	 * @param pID
	 * @param pName
	 * @param pTP
	 * @param pMund
	 */
	public Weapon(int pID, String pName, int pWeaponType, int[] pTP, int pMund) {
		Exception vExc = null;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; Wea_c");
		if (pWeaponType >= 0) weaponType = pWeaponType;
		else vExc = new Exception("02; Wea_c");
		if ((pName != null) && (pName != "")) name = pName;
		else vExc =  new Exception("02; Wea_c");
		
		if (pTP.length == 2) {
			if (pTP[0] >= 0) tp = pTP;
			else vExc = new Exception("02, Wea_c");
		} else vExc = new Exception("01; Wea_c");
		tpkk = new int[] {0, 0};
		
		try {setMund(pMund);}
		catch(Exception ex) {vExc = ex;}
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	9.7.2020
	 * 
	 * pWeaponType:
	 * 	 00: Raufen				15: Zweihand-Hiebwaffen
	 * 	 01: Ringen				16: Zweihandschwerter
	 * 	 02: Anderhalbhaender	17: Improvisiert
	 * 	 03: Dolche				18: Armbrust
	 * 	 04: Fechtwaffen		19: Blasrohr
	 * 	 05: Hiebwaffen			20: Bogen
	 * 	 06: Infanteriewaffen	21: Diskus
	 * 	 07: Kettenstaebe		22: Schleuder
	 * 	 08: Kettenwaffen		23: Wurfbeil
	 * 	 09: Peitsche			24: Wurfmesser
	 * 	 10: Saebel				25: Wurfspeer
	 * 	 11: Schwerter			26: kleine Schilde
	 * 	 12: Speere				27: große Schilde
	 * 	 13: Staebe				28: sehr große Schilde
	 * 	 14: Zweihandpflegel	29: Parierwaffen
	 * 
	 * 	pMund:
	 * 	 00: Mundan			  	08: Unholy
	 * 	 01: Nonleathal		  	09: Nonlehtal+Unholy
	 * 	 02: Arkan			  	10: Arkan+Unholy
	 * 	 03: Nonlethal+Arkan  	11: Nonle+Ark+Unho
	 * 	 04: Holy				12: Holy+Unholy
	 * 	 05: Nonlethal+Holy		13: Nonle+Ho+Unho
	 * 	 06: Arkan+Holy			14: Ark+Ho+Unho
	 *   07: Nonle+Ark+Hol		15: All
	 * 
	 * @param pID
	 * @param pName
	 * @param pTP
	 * @param pTPKK
	 * @param pMund
	 */
	public Weapon(int pID, String pName, int pWeaponType, int[] pTP, int[] pTPKK, int pMund) {
		Exception vExc= null;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; Wea_d");
		if (pWeaponType >= 0) weaponType = pWeaponType;
		else vExc = new Exception("02; Wea_d");
		if ((pName != null) && (pName != "")) name = pName;
		else vExc =  new Exception("02; Wea_d");

		if (pTP.length == 2) {
			if (pTP[0] >= 0) tp = pTP;
			else vExc = new Exception("02, Wea_d");
		} else vExc = new Exception("01; Wea_d");
		if (pTPKK.length == 2) {
			if ((pTPKK[0] >= 0) && (pTPKK[1] >= 0)) tpkk = pTPKK;
			else vExc = new Exception("02; Wea_d");
		}
		else vExc = new Exception("01; Wea_d");
		
		try {setMund(pMund);}
		catch(Exception ex) {vExc = ex;}
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public int getId() {
		return id;
	}
	/**	Dh	5.6.2020
	 * 
	 * pWeaponType:
	 * 	 00: Raufen				15: Zweihand-Hiebwaffen
	 * 	 01: Ringen				16: Zweihandschwerter
	 * 	 02: Anderhalbhaender	17: Improvisiert
	 * 	 03: Dolche				18: Armbrust
	 * 	 04: Fechtwaffen		19: Blasrohr
	 * 	 05: Hiebwaffen			20: Bogen
	 * 	 06: Infanteriewaffen	21: Diskus
	 * 	 07: Kettenstaebe		22: Schleuder
	 * 	 08: Kettenwaffen		23: Wurfbeil
	 * 	 09: Peitsche			24: Wurfmesser
	 * 	 10: Saebel				25: Wurfspeer
	 * 	 11: Schwerter			26: kleine Schilde
	 * 	 12: Speere				27: große Schilde
	 * 	 13: Staebe				28: sehr große Schilde
	 * 	 14: Zweihandpflegel	29: Parierwaffen
	 * 
	 * @return
	 */
	@XmlAttribute
	public int getWeaponType() {
		return weaponType;
	}

	/**	Dh	28.5.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getTp(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 2)) return tpkk[pInd];
		else throw new Exception("07; Wea,gTP");
	}
	/**	Dh	28.5.2020
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "TPArray")
	@XmlElement(name = "TP")
	public int[] getTp() {
		return tp;
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getTpkk(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 2)) return tpkk[pInd];
		else throw new Exception("07; Wea,gTPKK");
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "TPKKArray")
	@XmlElement(name = "TPKK")
	public int[] getTpkk() {
		return tpkk;
	}
	
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Name")
	public String getName() {
		return name;
	}
	
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Arkan")
	public boolean isArkan() {
		return isArkan;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Holy")
	public boolean isHoly() {
		return isHoly;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Unholy")
	public boolean isUnholy() {
		return isUnholy;
	}
	/**	Dh	4.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Nonlethal")
	public boolean isNonLethal() {
		return isNonLethal;
	}
	
	/**	Dh	9.7.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public int getMundType() throws Exception {
		return Calculator.convertBitToInt(new boolean[] {isNonLethal, isArkan, isHoly, isUnholy});
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	27.5.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void setId(int pID) throws Exception {
		if (pID >= 0) id = pID;
		else throw new Exception("02; Wea,sID");
	}
	/**	Dh	5.6.2020
	 * 
	 * pWeaponType:
	 * 	 00: Raufen				15: Zweihand-Hiebwaffen
	 * 	 01: Ringen				16: Zweihandschwerter
	 * 	 02: Anderhalbhaender	17: Improvisiert
	 * 	 03: Dolche				18: Armbrust
	 * 	 04: Fechtwaffen		19: Blasrohr
	 * 	 05: Hiebwaffen			20: Bogen
	 * 	 06: Infanteriewaffen	21: Diskus
	 * 	 07: Kettenstaebe		22: Schleuder
	 * 	 08: Kettenwaffen		23: Wurfbeil
	 * 	 09: Peitsche			24: Wurfmesser
	 * 	 10: Saebel				25: Wurfspeer
	 * 	 11: Schwerter			26: kleine Schilde
	 * 	 12: Speere				27: große Schilde
	 * 	 13: Staebe				28: sehr große Schilde
	 * 	 14: Zweihandpflegel	29: Parierwaffen
	 * 
	 * @param pWeaponType
	 * @throws Exception
	 */
	public void setWeaponType(int pWeaponType) throws Exception{
		if (pWeaponType >= 0) weaponType = pWeaponType;
		else throw new Exception("02; Wea,sWT");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pName
	 * @throws Exception
	 */
	public void setName(String pName) throws Exception {
		if ((pName != null) && (pName != "")) name = pName;
		else throw new Exception("02; Wea,sN");
	}
	
	/**	Dh	28.5.2020
	 * 
	 * @param pTPValue
	 * @param pInd
	 * @throws Exception
	 */
	public void setTp(int pTPValue, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 2)) {
			if ((pInd == 1) ||(pTPValue >= 0)) tp[pInd] = pTPValue;
			else throw new Exception("02; Wea,sTP");
		} else throw new Exception("07; Wea,sTP");
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pTP
	 * @throws Exception
	 */
	public void setTp(int[] pTP) throws Exception{
		if (pTP.length == tp.length) {
			if (pTP[0] >= 0) tp = pTP;
			else throw new Exception("02; Wea,sTP");
		} else throw new Exception("01; Wea,sTP");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pTPKKValue
	 * @param pInd
	 * @throws Exception
	 */
	public void setTpkk(int pTPKKValue, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 2)) {
			if (pTPKKValue >= 0) tpkk[pInd] = pTPKKValue;
			else throw new Exception("02; Wea,sTPKK");
		} else throw new Exception("07; Wea,sTPKK");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pTPKK
	 * @throws Exception
	 */
	public void setTpkk(int[] pTPKK) throws Exception{
		if (pTPKK.length == 2) {
			if ((pTPKK[0] >= 0) && (pTPKK[1] >= 0)) tpkk = pTPKK;
			else throw new Exception("02; Wea,sTPKK");
		} else throw new Exception("01; Wea,sTPKK");
	}
	
	/**	Dh	27.5.2020
	 * 
	 * @param pArkan
	 */
	public void setArkan(boolean pArkan) {
		isArkan = pArkan;
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pHoly
	 */
	public void setHoly(boolean pHoly) {
		isHoly = pHoly;
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pUnholy
	 */
	public void setUnholy(boolean pUnholy) {
		isUnholy = pUnholy;
	}
	/**	Dh	4.6.2020
	 * 
	 * @param pNonletahl
	 */
	public void setNonLethal(boolean pNonletahl) {
		isNonLethal =pNonletahl;
	}
	
	/**	Dh	9.7.2020
	 * 
	 * 	
	 * 	pMund:
	 * 	 00: Mundan			  	08: Unholy
	 * 	 01: Nonleathal		  	09: Nonlehtal+Unholy
	 * 	 02: Arkan			  	10: Arkan+Unholy
	 * 	 03: Nonlethal+Arkan  	11: Nonle+Ark+Unho
	 * 	 04: Holy				12: Holy+Unholy
	 * 	 05: Nonlethal+Holy		13: Nonle+Ho+Unho
	 * 	 06: Arkan+Holy			14: Ark+Ho+Unho
	 *   07: Nonle+Ark+Hol		15: All
	 * 
	 * @param pMund
	 * @throws Exception
	 */
	public void setMund(int pMund) throws Exception{
		boolean[] vBitfolge;
		
		if ((pMund >= 0) && (pMund <= 15)) {
			vBitfolge = Calculator.convertIntToBit(pMund, 4);
			
			isNonLethal = vBitfolge[0];
			isArkan = vBitfolge[1];
			isHoly = vBitfolge[2];
			isUnholy = vBitfolge[3];
		} else throw new Exception("02; Wea,sM");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	28.5.2020
	 * 
	 * 	Berechnet Grundsätzlich den Schaden, den eine Waffe, ohne TPKK, oder Reichweiten Mod macht.
	 * 
	 * @return
	 */
	public int calTP() {
		int vRet = 0;
		Random vRan = new Random();
		
		for (int i=0; i < tp[0]; i++) {
			vRet += vRan.nextInt(6)+1;
		}
		vRet += tp[1];
		
		return vRet;
	}
	/**	Dh	28.5.2020
	 * 
	 * 	Berechnet den Schaden, unter beruecksichtikung der TPKK Mod.
	 * 
	 * @param pKK
	 * @return
	 * @throws Exception
	 */
	public int calTP(int pKK) throws Exception{
		int vRet = calTP();
		
		if (pKK >= 0) {
			if (tpkk[1] != 0) {
				pKK = (pKK - tpkk[0])/tpkk[1];
				vRet += pKK;
			}
		}else new Exception("02; Wea,mD");
		
		return vRet;
	}
}
