/**	DSA_App	v0.0	Dh	9.7.2020
 * 
 * 	Logik
 * 	  Talent
 * 		Fighttalent
 *  
 *  Category:
 *     0: Bewaffneter Nahkampf
 *     1: Waffenloser Kampf
 *     2: Fernkampf
 *     
 *  Types:
 * 	  00: Nahkampf				05: Wissens
 * 	  01: Fernkampf				06: Sprache
 * 	  02: Koerperliche			07: Handwerks
 * 	  03: Gesellschaftliche		08: Alle Kampf
 * 	  04: Natur					09: Alle mundan nicht Kampf
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

import java.util.Random;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import pGUI.MainFrame;

@XmlRootElement(name = "fighttalent")
public class Fighttalent extends Talent {
	private int category;
	private int[] fightValues, eBE, usableWeaponTypes;
	
	/**	Dh	5.6.2020
	 * 
	 * 	Bean Standart Konstruktor.
	 */
	public Fighttalent() {
		super();
		
		category = -1;
		fightValues = new int[] {0, 0};
		eBE = new int[] {0, 0};
		usableWeaponTypes = new int[] {-1};
	}
	/**	Dh	2.7.2020
	 * 
	 * 	Types:
	 * 	  00: Nahkampf				05: Wissens
	 * 	  01: Fernkampf				06: Sprache
	 * 	  02: Koerperliche			07: Handwerks
	 * 	  03: Gesellschaftliche		08: Alle Kampf
	 * 	  04: Natur					09: Alle mundan nicht Kampf
	 * 
	 * 	Category:
	 *     0: Bewaffneter Nahkampf
	 *     1: Waffenloser Kampf
	 *     2: Fernkampf
	 *     
	 *  WeaponType:
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
	 * @param pCategory
	 * @param pEBE
	 * @param pUsableWeaponTypes
	 */
	public Fighttalent(int pID, String pName, int pCategory, int[] pEBE, int[] pUsableWeaponTypes) {
		super(-1, pID, pName);
		Exception vExc = null;
		
		if ((pCategory >= 0) && (pCategory < 3)) {
			category = pCategory;
			try {
				if ((pCategory == 0) || (pCategory == 1)) super.setType(0);
				else super.setType(1);
			} catch (Exception ex) {vExc = ex;}
		}
		else vExc = new Exception("02; FiTal_a");
		
		fightValues = new int[] {0, 0};
		if (pEBE != null) {
			if (pEBE.length == 2) {
				if (pEBE[0] >= 0) eBE = pEBE;
				else vExc = new Exception("02; FiTal_a");
			} else vExc = new Exception("01; FiTal_a");
		} else vExc = new Exception("04; FiTal_a");
		if (pUsableWeaponTypes != null) {
			usableWeaponTypes = pUsableWeaponTypes;
		} else vExc = new Exception("04; FiTal_a");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	2.7.2020
	 * 
	 * 	Types:
	 * 	  00: Nahkampf				05: Wissens
	 * 	  01: Fernkampf				06: Sprache
	 * 	  02: Koerperliche			07: Handwerks
	 * 	  03: Gesellschaftliche		08: Alle Kampf
	 * 	  04: Natur					09: Alle mundan nicht Kampf
	 * 
	 * 	Category:
	 *     0: Bewaffneter Nahkampf
	 *     1: Waffenloser Kampf
	 *     2: Fernkampf
	 *     
	 *  WeaponType:
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
	 * @param pCategory
	 * @param pEBE
	 * @param pUsableWeaponTypes
	 * @param pTaW
	 */
	public Fighttalent(int pID, String pName, int pCategory, int[] pEBE, int[] pUsableWeaponTypes, int pTaW) {
		super(-1, pID, pName, pTaW);
		Exception vExc = null;
		
		if ((pCategory >= 0) && (pCategory < 3)) {
			category = pCategory;
			try {
				if ((pCategory == 0) || (pCategory == 1)) super.setType(0);
				else super.setType(1);
			} catch (Exception ex) {vExc = ex;}
		}
		else vExc = new Exception("02; FiTal_b");
		
		if (pCategory != 2) fightValues = new int[] {0, 0};
		else fightValues = new int[] {taw, 0};
		if (pEBE != null) {
			if (pEBE.length == 2) {
				if (pEBE[0] >= 0) eBE = pEBE;
				else vExc = new Exception("02; FiTal_b");
			} else vExc = new Exception("01; FiTal_b");
		} else vExc = new Exception("04; FiTal_b");
		if (pUsableWeaponTypes != null) {
			usableWeaponTypes = pUsableWeaponTypes;
		} else vExc = new Exception("04; FiTal_b");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	2.7.2020
	 * 
	 * Types:
	 * 	  00: Nahkampf				05: Wissens
	 * 	  01: Fernkampf				06: Sprache
	 * 	  02: Koerperliche			07: Handwerks
	 * 	  03: Gesellschaftliche		08: Alle Kampf
	 * 	  04: Natur					09: Alle mundan nicht Kampf
	 * 
	 * Category:
	 *     0: Bewaffneter Nahkampf
	 *     1: Waffenloser Kampf
	 *     2: Fernkampf
	 * 
	 * WeaponType:
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
	 * @param pCategory
	 * @param pEBE
	 * @param pUsableWeaponTypes
	 * @param pTaW
	 * @param pFightValues
	 */
	public Fighttalent(int pID, String pName, int pCategory, int[] pEBE, int[] pUsableWeaponTypes, int pTaW, int[] pFightValues) {
		super(-1, pID, pName, pTaW);
		Exception vExc = null;
		
		if ((pCategory >= 0) && (pCategory < 3)) {
			category = pCategory;
			try {
				if ((pCategory == 0) || (pCategory == 1)) super.setType(0);
				else super.setType(1);
			} catch (Exception ex) {vExc = ex;}
		}
		else vExc = new Exception("02; FiTal_c");
		
		if (pFightValues != null) {
			if (pFightValues.length == 2) {
				if ((pFightValues[0] >= 0) && (pFightValues[1] >= 0)) fightValues = pFightValues; 
				else vExc = new Exception("02; FiTal_c");
			} else vExc = new Exception("01; FiTal_c");
		} else vExc = new Exception("04; FiTal_c");
		if (pEBE != null) {
			if (pEBE.length == 2) {
				if (pEBE[0] >= 0) eBE = pEBE;
				else vExc = new Exception("02; FiTal_c");
			} else vExc = new Exception("01; FiTal_c");
		} else vExc = new Exception("04; FiTal_c");
		if (pUsableWeaponTypes != null) {
			usableWeaponTypes = pUsableWeaponTypes;
		} else vExc = new Exception("04; FiTal_c");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	5.6.2020
	 * 
	 * 	Category:
	 *     0: Bewaffneter Nahkampf
	 *     1: Waffenloser Kampf
	 *     2: Fernkampf
	 * 
	 * @return
	 */
	@XmlElement(name = "Category")
	public int getCategory() {
		return category;
	}
	
	/**	Dh	5.6.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getEBE(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < eBE.length)) {
			return eBE[pInd];
		} throw new Exception("02; FiTal,gEBE");
	}
	/**	Dh	5.6.2020
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "BehinderungsWerteArray")
	@XmlElement(name = "Behinderungswerte")
	public int[] getEBE() {
		return eBE;
	}
	/**	Dh	5.6.2020
	 * 
	 *  WeaponType:
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
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getUsableWeaponType(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < usableWeaponTypes.length)) {
			return usableWeaponTypes[pInd];
		} throw new Exception("02; FiTal,guWT");
	}
	/**	Dh	5.6.2020
	 * 
	 * WeaponType:
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
	@XmlElementWrapper(name = "Benutzbare_Waffenkategorien")
	@XmlElement(name = "WaffenkategorieID")
	public int[] getUsableWeaponType() {
		return usableWeaponTypes;
	}
	/**	Dh	5.6.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getFightValue(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < fightValues.length)) {
			return fightValues[pInd];
		} throw new Exception("02; FiTal,gFV");
	}
	/**	Dh	5.6.2020
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "Kampfwerte")
	@XmlElement(name = "Kampfwert")
	public int[] getFightValues() {
		return fightValues;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	5.6.2020
	 * 
	 * 	Category:
	 *     0: Bewaffneter Nahkampf
	 *     1: Waffenloser Kampf
	 *     2: Fernkampf
	 * 
	 * @param pCategory
	 * @throws Exception
	 */
	public void setCategory(int pCategory) throws Exception{
		if ((pCategory >= 0) && (pCategory < 3)) category = pCategory;
		else throw new Exception("02; FiTal,sC");
	}
	/**	Dh	9.6.2020
	 * 
	 */
	public void setTaw(int pTaW) throws Exception{
		if (pTaW < (fightValues[0]+fightValues[1])) fightValues = new int[] {0, 0};
		super.setTaw(pTaW);
		
		if (category == 2) fightValues[0] = pTaW;
	}
	
	/**	Dh	5.6.2020
	 * 
	 * @param pEBEValue
	 * @param pInd
	 * @throws Exception
	 */
	public void setEBE(int pEBEValue, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < eBE.length))
			if ((pInd != 0) || (pEBEValue >= 0)) eBE[pInd] = pEBEValue;
			else throw new Exception("02; FiTal,sEBE");
		else throw new Exception("02; FiTal,sEBE");
	}
	/**	Dh	5.6.2020
	 * 
	 * @param pEBE
	 * @throws Exception
	 */
	public void setEBE(int[] pEBE) throws Exception{
		if (pEBE != null) {
			if (pEBE.length == 2) {
				if (pEBE[0] >= 0) eBE = pEBE;
				else throw new Exception("02; FiTal,sEBE");
			} else throw new Exception("01; FiTal,sEBE");
		} else throw new Exception("04; FiTal,sEBE");
	}
	/**	Dh	5.6.2020
	 * 
	 * WeaponType:
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
	 * @param pUsableWeapontype
	 * @param pInd
	 * @throws Exception
	 */
	public void setUsableWeaponType(int pUsableWeaponType, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < usableWeaponTypes.length))
			if ((pInd != 0) || (pUsableWeaponType >= 0)) usableWeaponTypes[pInd] = pUsableWeaponType;
			else throw new Exception("02; FiTal,suWT");
		else throw new Exception("02; FiTal,suWT");
	}
	/**	Dh	5.6.2020
	 * 
	 * WeaponType:
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
	 * @param pUsableWeaponType
	 * @throws Exception
	 */
	public void setUsableWeaponType(int[] pUsableWeaponType) throws Exception{
		if (pUsableWeaponType != null) {
			usableWeaponTypes = pUsableWeaponType;
		} else throw new Exception("04; FiTal,sEBE");
	}
	/**	Dh	5.6.2020
	 * 
	 * @param pFightValue
	 * @param pInd
	 * @throws Exception
	 */
	public void setFightValue(int pFightValue, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < fightValues.length))
			if ((pFightValue >= 0) && (((pInd == 0) && (pFightValue+fightValues[1] <= taw)) 
					|| ((pInd == 1) && (pFightValue + fightValues[0] <= taw)))) {
				if (category != 2) fightValues[pInd] = pFightValue;
			}else throw new Exception("02; FiTal,sFV");
		else throw new Exception("02; FiTal,sFV");
	}
	/**	Dh	5.6.2020
	 * 
	 * @param pFightValues
	 * @throws Exception
	 */
	public void setFightValues(int[] pFightValues) throws Exception{
		if (pFightValues != null) {
			if (pFightValues.length == fightValues.length) {
				if((pFightValues[0] >= 0) && (pFightValues[1] >= 0) && (pFightValues[0]+pFightValues[1] <= taw)){
					if (category != 2) fightValues = pFightValues;
				}else throw new Exception("2; FiTal,sFVs; "+taw+", "+pFightValues[0]+pFightValues[1]);
			} else throw new Exception("01; FiTal,sFVs");
		} else throw new Exception("04; FiTal,sFVs");
	}

//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	9.6.2020
	 * 
	 * WeaponType:
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
	 * @param pUsableWeaponType
	 * @throws Exception
	 */
	public void addUsableWeaponType(int pUsableWeaponType) throws Exception{
		int[] vUsableWeaponTypes = new int[usableWeaponTypes.length+1];;
		
		if ((pUsableWeaponType >= 0) && (pUsableWeaponType < 21)) {
			for (int i=0; i<usableWeaponTypes.length; i++) {
				vUsableWeaponTypes[i] = usableWeaponTypes[i];
			}
			vUsableWeaponTypes[usableWeaponTypes.length] = pUsableWeaponType;
			usableWeaponTypes = vUsableWeaponTypes;
		} else throw new Exception("02; FiTal,aUWT");
	}
	/**	Dh	9.6.2020
	 * 
	 */
	public void addTaw(int pTaW) throws Exception{
		super.addTaw(pTaW);
		
		if (category == 2) fightValues[0] = taw;
	}
	
	/**	Dh	9.6.2020
	 * 
	 * FightValue:
	 * 	0: AT
	 * 	1: PA
	 * 
	 * @param pFightValue
	 * @param pInd
	 * @throws Exception
	 */
	public void addFightValue(int pFightValue, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 2)){
			if ( ((pFightValue+fightValues[0]+fightValues[1]) <= taw) && ((pFightValue + fightValues[pInd]) >= 0) ) {
				if (category != 2) fightValues[pInd] = pFightValue;
			}else throw new Exception("02; FiTal,aFV");
		} else throw new Exception("02; FiTal,aFV");
	}
	/**	Dh	9.6.2020
	 * 
	 * FightValue:
	 * 	0: AT
	 * 	1: PA
	 * 
	 * @param pFightValues
	 * @throws Exception
	 */
	public void addFightValues(int[] pFightValues) throws Exception{
		if (pFightValues != null) {
			if (pFightValues.length == 2) {
				if (((fightValues[0]+fightValues[1]+pFightValues[0]+pFightValues[1]) <= taw) && (((fightValues[0]+pFightValues[0])>= 0)
						|| ((fightValues[1]+pFightValues[1]) >= 0))){
					if (category != 2) {
						fightValues[0] += pFightValues[0];
						fightValues[1] += pFightValues[1];
					}
				} else throw new Exception("02; FiTal,aFVs");
			} else throw new Exception("01; FiTal,aFVs");
		} else throw new Exception("04; FiTal,aFVs");
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	9.6.2020
	 * 	
	 * WeaponType:
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
	 * @param pUsableWeaponType
	 * @throws Exception
	 */
	public void removeWeaponType(int pUsableWeaponType) throws Exception{
		int[] vUsableWeaponTypes = new int[usableWeaponTypes.length-1];
		
		if ((pUsableWeaponType >= 0) && (pUsableWeaponType < 21)) {
			for (int i=0; i < (vUsableWeaponTypes.length); i++) {
				if (pUsableWeaponType == usableWeaponTypes[i]) pUsableWeaponType = -1;
				
				if (pUsableWeaponType != -1) vUsableWeaponTypes[i] = usableWeaponTypes[i];
				else vUsableWeaponTypes[i] = usableWeaponTypes[i+1];
			}
			if (pUsableWeaponType == -1) usableWeaponTypes = vUsableWeaponTypes;
			else throw new Exception("02; FiTal,rWT");
		} else throw new Exception("02; FiTal,rWT");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	10.6.2020
	 * 
	 * @param pBasicAttackValue
	 * @return
	 * @throws Exception
	 */
	public int makeAttackProbe(int pBasicAttackValue) throws Exception{
		return makeAttackProbe(pBasicAttackValue, Calculator.makeDiceRoll(20), 0);
	}
	/**	Dh	10.9.2020
	 * 
	 * @param pBasicAttackValue
	 * @param pMod
	 * @return
	 * @throws Exception
	 */
	public int makeAttackProbe(int pBasicAttackValue, int pMod) throws Exception{
		return makeAttackProbe(pBasicAttackValue, Calculator.makeDiceRoll(20), pMod);
	}
	/**	Dh	9.6.2020
	 * 
	 * @param pBasicAttackValue
	 * @param pRoll
	 * @param pMod
	 * @return
	 * @throws Exception
	 */
	public int makeAttackProbe(int pBasicAttackValue, int pRoll, int pMod) throws Exception {
		return makeFightProbe(pBasicAttackValue, true, pRoll, pMod);
	}

	/**	Dh	10.6.2020
	 * 
	 * @param pBasicDefensiveValue
	 * @return
	 * @throws Exception
	 */
	public int makeDefensiveProbe(int pBasicDefensiveValue) throws Exception{
		return makeAttackProbe(pBasicDefensiveValue, Calculator.makeDiceRoll(20), 0);
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pBasicDefensiveValue
	 * @param pMod
	 * @return
	 * @throws Exception
	 */
	public int makeDefensiveProbe(int pBasicDefensiveValue, int pMod) throws Exception{
		return makeAttackProbe(pBasicDefensiveValue, Calculator.makeDiceRoll(20), pMod);
	}
	/**	Dh	9.6.2020
	 * 
	 * @param pBasicDefensiveValue
	 * @param pRoll
	 * @param pMod
	 * @return
	 * @throws Exception
	 */
	public int makeDefensiveProbe(int pBasicDefensiveValue, int pRoll, int pMod) throws Exception {
		return makeFightProbe(pBasicDefensiveValue, false, pRoll, pMod);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	9.6.2020
	 * 
	 * @param pBasisFightValue
	 * @param pAttack
	 * @param pRoll
	 * @param pMod
	 * @return
	 * @throws Exception
	 */
	private int makeFightProbe(int pBasisFightValue, boolean pAttack, int pRoll, int pMod) throws Exception{
		int vDiff, vTaW;
		
		if (pBasisFightValue >= 0) {
			if (pAttack == true) vTaW = pBasisFightValue + fightValues[0];
			else if ((pAttack == false) && (category != 2)) vTaW = pBasisFightValue + fightValues[1];
			else throw new Exception("02; FiTal,mFP");
			
			vDiff = vTaW - pRoll + pMod;
		}else throw new Exception("02; FiTal,mFP");
		
		return vDiff;
	}
}
