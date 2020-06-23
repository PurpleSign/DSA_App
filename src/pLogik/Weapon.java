/**	DSA_App	v0.0	Dh	5.6.2020
 * 
 * 	Logik
 * 	  Weapon
 * 
 * 	
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
@XmlType(propOrder = { "name", "TP", "TPKK", "arkan", "holy", "unholy", "nonlethal" })
public abstract class Weapon {
	private boolean Arkan, Holy, Unholy, Nonlethal;
	private int ID, WeaponType;
	private int[] TP;
	private int[] TPKK;
	private String Name;
	
	/**	Dh	28.5.2020
	 * 
	 * 	Konstruktor gemaess Bean vorschrift.
	 * 
	 */
	public Weapon() {
		ID = -1;
		WeaponType = -1;
		Name = "";
		
		TP = new int[] {0, 0};
		TPKK = new int[] {0, 0};
		
		Arkan = false;
		Holy = false;
		Unholy = false;
	}
	/**	Dh	28.5.2020
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
	 */
	public Weapon(int pID, String pName, int pWeaponType, int[] pTP) {
		Exception vExc = null;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; Wea_a");
		if (pWeaponType >= 0) WeaponType = pWeaponType;
		else vExc = new Exception("02; Wea_a");
		if ((pName != null) && (pName != "")) Name = pName;
		else vExc =  new Exception("02; Wea_a");
		
		if (pTP.length == 2) {
			if (pTP[0] >= 1) TP = pTP;
			else vExc = new Exception("02, Wea_a");
		} else vExc = new Exception("01; Wea_a");
		TPKK = new int[] {0, 0};
		
		Nonlethal = false;
		Arkan = false;
		Holy = false;
		Unholy = false;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	28.5.2020
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
	 * @param pTPKK
	 */
	public Weapon(int pID, String pName, int pWeaponType, int[] pTP, int[] pTPKK) {
		Exception vExc = null;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; Wea_b");
		if (pWeaponType >= 0) WeaponType = pWeaponType;
		else vExc = new Exception("02; Wea_b");
		if ((pName != null) && (pName != "")) Name = pName;
		else vExc =  new Exception("02; Wea_b");
		
		if (pTP.length == 2) {
			if (pTP[0] >= 1) TP = pTP;
			else vExc = new Exception("02, Wea_b");
		} else vExc = new Exception("01; Wea_b");
		if (pTPKK.length == 2) {
			if ((pTPKK[0] >= 0) && (pTPKK[1] > 0)) TPKK = pTPKK;
			else vExc = new Exception("02; Wea_b");
		} else vExc = new Exception("01; Wea_b");
		
		Nonlethal = false;
		Arkan = false;
		Holy = false;
		Unholy = false;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/** Dh	28.5.2020
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
	 * @param pID
	 * @param pName
	 * @param pTP
	 * @param pMund
	 */
	public Weapon(int pID, String pName, int pWeaponType, int[] pTP, int pMund) {
		Exception vExc = null;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; Wea_c");
		if (pWeaponType >= 0) WeaponType = pWeaponType;
		else vExc = new Exception("02; Wea_c");
		if ((pName != null) && (pName != "")) Name = pName;
		else vExc =  new Exception("02; Wea_c");
		
		if (pTP.length == 2) {
			if (pTP[0] >= 1) TP = pTP;
			else vExc = new Exception("02, Wea_a");
		} else vExc = new Exception("01; Wea_a");
		TPKK = new int[] {0, 0};
		
		if ((pMund < 0) || (pMund >= 16)) vExc = new Exception("02; Wea_c");
		if ((pMund == 1) || (pMund == 5) || (pMund == 6) || (pMund == 7) || (pMund == 11) ||
				(pMund == 12) || (pMund == 13) || (pMund == 15)) Nonlethal = true;
		else Nonlethal = false;
		if ((pMund == 2) || (pMund == 5) || (pMund == 8) || (pMund == 9) || (pMund == 11) ||
				(pMund == 12) || (pMund == 13) || (pMund == 15)) Arkan = true;
		else Arkan = false;
		if ((pMund == 3) || (pMund == 6) || (pMund == 8) || (pMund == 10) || (pMund == 11) ||
				(pMund == 13) || (pMund == 14) || (pMund == 15)) Holy = true;
		else Holy = false;
		if ((pMund == 4) || (pMund == 7) || (pMund == 9) || (pMund == 10) || (pMund == 12) ||
				(pMund == 13) || (pMund == 14) || (pMund == 15)) Unholy = true;
		else Unholy = false;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	28.5.2020
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
	 * @param pID
	 * @param pName
	 * @param pTP
	 * @param pTPKK
	 * @param pMund
	 */
	public Weapon(int pID, String pName, int pWeaponType, int[] pTP, int[] pTPKK, int pMund) {
		Exception vExc= null;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; Wea_d");
		if (pWeaponType >= 0) WeaponType = pWeaponType;
		else vExc = new Exception("02; Wea_d");
		if ((pName != null) && (pName != "")) Name = pName;
		else vExc =  new Exception("02; Wea_d");

		if (pTP.length == 2) {
			if (pTP[0] >= 1) TP = pTP;
			else vExc = new Exception("02, Wea_a");
		} else vExc = new Exception("01; Wea_a");
		if (pTPKK.length == 2) {
			if ((pTPKK[0] >= 0) && (pTPKK[1] > 0)) TPKK = pTPKK;
			else vExc = new Exception("02; Wea_d");
		}
		else vExc = new Exception("01; Wea_d");
		
		if ((pMund < 0) || (pMund >= 16)) vExc = new Exception("02; Wea_d");
		if ((pMund == 1) || (pMund == 5) || (pMund == 6) || (pMund == 7) || (pMund == 11) ||
				(pMund == 12) || (pMund == 13) || (pMund == 15)) Nonlethal = true;
		else Nonlethal = false;
		if ((pMund == 2) || (pMund == 5) || (pMund == 8) || (pMund == 9) || (pMund == 11) ||
				(pMund == 12) || (pMund == 13) || (pMund == 15)) Arkan = true;
		else Arkan = false;
		if ((pMund == 3) || (pMund == 6) || (pMund == 8) || (pMund == 10) || (pMund == 11) ||
				(pMund == 13) || (pMund == 14) || (pMund == 15)) Holy = true;
		else Holy = false;
		if ((pMund == 4) || (pMund == 7) || (pMund == 9) || (pMund == 10) || (pMund == 12) ||
				(pMund == 13) || (pMund == 14) || (pMund == 15)) Unholy = true;
		else Unholy = false;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public int getID() {
		return ID;
	}
	/**	Dh	5.6.2020
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
	 * @return
	 */
	@XmlAttribute
	public int getWeaponType() {
		return WeaponType;
	}

	/**	Dh	28.5.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getTP(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 2)) return TPKK[pInd];
		else throw new Exception("07; Wea,gTP");
	}
	/**	Dh	28.5.2020
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "TPArray")
	public int[] getTP() {
		return TP;
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getTPKK(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 2)) return TPKK[pInd];
		else throw new Exception("07; Wea,gTPKK");
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "TPKKArray")
	public int[] getTPKK() {
		return TPKK;
	}
	
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Name")
	public String getName() {
		return Name;
	}
	
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Arkan")
	public boolean isArkan() {
		return Arkan;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Holy")
	public boolean isHoly() {
		return Holy;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Unholy")
	public boolean isUnholy() {
		return Unholy;
	}
	/**	Dh	4.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Nonlethal")
	public boolean isNonlethal() {
		return Nonlethal;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	27.5.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void setID(int pID) throws Exception {
		if (pID >= 0) ID = pID;
		else throw new Exception("02; Wea,sID");
	}
	/**	Dh	5.6.2020
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
	 * @param pWeaponType
	 * @throws Exception
	 */
	public void setWeaponType(int pWeaponType) throws Exception{
		if (pWeaponType >= 0) WeaponType = pWeaponType;
		else throw new Exception("02; Wea,sWT");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pName
	 * @throws Exception
	 */
	public void setName(String pName) throws Exception {
		if ((pName != null) && (pName != "")) Name = pName;
		else throw new Exception("02; Wea,sN");
	}
	
	/**	Dh	28.5.2020
	 * 
	 * @param pTPValue
	 * @param pInd
	 * @throws Exception
	 */
	public void setTP(int pTPValue, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 2)) {
			if ((pInd == 1) ||(pTPValue >= 0)) TP[pInd] = pTPValue;
			else throw new Exception("02; Wea,sTP");
		} else throw new Exception("07; Wea,sTP");
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pTP
	 * @throws Exception
	 */
	public void setTP(int[] pTP) throws Exception{
		if (pTP.length == TP.length) {
			if (pTP[0] >= 0) TP = pTP;
			else throw new Exception("02; Wea,sTP");
		} else throw new Exception("01; Wea,sTP");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pTPKKValue
	 * @param pInd
	 * @throws Exception
	 */
	public void setTPKK(int pTPKKValue, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 2)) {
			if (pTPKKValue >= 0) TPKK[pInd] = pTPKKValue;
			else throw new Exception("02; Wea,sTPKK");
		} else throw new Exception("07; Wea,sTPKK");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pTPKK
	 * @throws Exception
	 */
	public void setTPKK(int[] pTPKK) throws Exception{
		if (pTPKK.length == 2) {
			if ((pTPKK[0] >= 0) && (pTPKK[1] >= 0)) TPKK = pTPKK;
			else throw new Exception("02; Wea,sTPKK");
		} else throw new Exception("01; Wea,sTPKK");
	}
	
	/**	Dh	27.5.2020
	 * 
	 * @param pArkan
	 */
	public void setArkan(boolean pArkan) {
		Arkan = pArkan;
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pHoly
	 */
	public void setHoly(boolean pHoly) {
		Holy = pHoly;
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pUnholy
	 */
	public void setUnholy(boolean pUnholy) {
		Unholy = pUnholy;
	}
	/**	Dh	4.6.2020
	 * 
	 * @param pNonletahl
	 */
	public void setNonlethal(boolean pNonletahl) {
		Nonlethal =pNonletahl;
	}
	
	/**	Dh	27.5.2020
	 * 
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
	 * @param pMund
	 * @throws Exception
	 */
	public void setMund(int pMund) throws Exception{
		if ((pMund >= 0) && (pMund <= 15)) {
			if ((pMund == 1) || (pMund == 5) || (pMund == 6) || (pMund == 7) || (pMund == 11) ||
					(pMund == 12) || (pMund == 13) || (pMund == 15)) Nonlethal = true;
			else Nonlethal = false;
			if ((pMund == 2) || (pMund == 5) || (pMund == 8) || (pMund == 9) || (pMund == 11) ||
					(pMund == 12) || (pMund == 13) || (pMund == 15)) Arkan = true;
			else Arkan = false;
			if ((pMund == 3) || (pMund == 6) || (pMund == 8) || (pMund == 10) || (pMund == 11) ||
					(pMund == 13) || (pMund == 14) || (pMund == 15)) Holy = true;
			else Holy = false;
			if ((pMund == 4) || (pMund == 7) || (pMund == 9) || (pMund == 10) || (pMund == 12) ||
					(pMund == 13) || (pMund == 14) || (pMund == 15)) Unholy = true;
			else Unholy = false;
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
		
		for (int i=0; i < TP[0]; i++) {
			vRet += vRan.nextInt(6)+1;
		}
		vRet += TP[1];
		
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
			if (TPKK[1] != 0) {
				pKK = (pKK - TPKK[0])/TPKK[1];
				vRet += pKK;
			}
		}else new Exception("02; Wea,mD");
		
		return vRet;
	}
}
