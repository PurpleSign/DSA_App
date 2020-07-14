/**	DSA_App v0.0	Dh	 14.7.2020
 * 	
 * 	Logik
 * 	  Charakter
 * 
 * 	mundaneType:
 * 	  0 mundan				2 karmal
 *    1 magisch				3 alles
 * 
 * 	properties: 
 * 	  0 Mut					4 Fingerfertigkeit
 * 	  1 Klugkheit			5 Gewandheit
 * 	  2 Intuition			6 Konstitution
 * 	  3 Charisma			7 Koerperkraft
 * 
 * 	(max)Stati:
 * 	  0 Lebenspunkte		2 Astralenergie
 * 	  1 Ausdauer			3 Karmalenergie
 * 
 * 	fightValuess:
 * 	  0 Ini-Basiswert		2 Parade-Basiswert
 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
 * 
 * 	BodyRegion:
 * 	  0 Kopf				4 linker Arm
 * 	  1 Brust				5 Bauch
 * 	  2 Rücken				6 rechtes Bein
 * 	  3 rechter Arm			7 linkes Bein
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
 * 	  20 Wunden Benachrichtigung
 */
package pLogik;

import pDataStructures.List;
import pDatenbank.Loader;
import pGUI.MainFrame;

import java.util.Random;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "character")
@XmlType(propOrder = {"properties", "propertieMods", "proList", "specialCraftList", "so", "gs", "mr", "ws", "stats", "maxStats", 
		"fightValues", "talentList", "wounds", "rs", "be", "weaponList"})
@XmlSeeAlso({Weapon.class, Talent.class, Pro.class, SpecialCraft.class})
public class Charakter {

	private String name, race, culture, profession;
	private int id, so, gs, mundaneType;
	private double mr, ws, be;
	private int[] properties, propertieMods, stats, wounds;
	private double[] maxStats, fightValues, rs, statMods;
	private List proList, specialCraftList, talentList, weaponList;
	
	/**	Dh	14.7.2020
	 * 
	 * 	Kosntruktor nach Bea-Standard.
	 */
	public Charakter() {
		name = "";
		race = "";
		culture = "";
		profession = "";
		
		so = -1;
		gs = -1;
		mundaneType = -1;
		
		properties = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		propertieMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		stats = new int[]{0, 0, 0, 0};
		wounds = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		
		maxStats = new double[] {0, 0, 0, 0};
		fightValues = new double[] {0, 0, 0, 0};
		rs = new double[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
		statMods = new double[] {0, 0, 0, 0};
		
		proList = new List();
		specialCraftList = new List();
		talentList = new List();
		weaponList = new List();
	}
	/**	Dh	14.7.2020
	 * 
	 *  pCharSetting:
	 *    0: Rasse
	 *    1: Kultur
	 *    2: Profession
	 * 
	 * 	pEigen:
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			(8 Geschwindigkeit)
	 * 	  4 Fingerfertigkeit	(9 Sozialstatus)
	 * 
	 * @param pID
	 * @param pName
	 * @param pRasse
	 * @param pEigen
	 */
	public Charakter(int pID, String pName, String[] pCharSetting, int[] pEigen){
		Exception vExc = null ;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; Char_a");
		
		name = pName;
		if (pCharSetting != null) {
			if (pCharSetting.length == 3) {
				race = pCharSetting[0];
				culture = pCharSetting[1];
				profession = pCharSetting[2];
			} else vExc = new Exception("01; Char_a");
		} else vExc = new Exception("04; Char_a");
		
		mundaneType = 0;
		
		properties = new int[8];
		switch(pEigen.length){
		case 8:
			for (int i=0; i < pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_a");
				properties[i] = pEigen[i];
			}
			gs = 8;
			so = 0;
			break;
		case 9:
			for (int i=0; i < pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_a");
				if (i < 8) properties[i] = pEigen[i];
				else gs = pEigen[i];
			}
			so = 0;
			break;
		case 10:
			for (int i=0; i < pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_a");
				if (i < 8) properties[i] = pEigen[i];
				else if (i == 9)gs = pEigen[i];
				else so = pEigen[i];
			}
			break;
		default:
			vExc = new Exception("01; Char_a");
		}
		propertieMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		wounds = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		
		try {talentList = Loader.getBasicTalents();}
		catch(Exception ex) {vExc = ex;}
		
		proList = new List();
		specialCraftList = new List();
		weaponList = new List();
		
		statMods = new double[4];
		for (int i=0; i<statMods.length; i++){
			statMods[i] = 0;
		}
		
		try{
			maxStats = Calculator.calCharBasisStati(properties, mundaneType);
			mr = Calculator.calCharMr(properties);
			ws = properties[6]/2;
			fightValues = Calculator.calCharFightValue(properties);
		}catch(Exception exc){vExc = exc;}
		
		
		stats = new int[] {(int)maxStats[0], (int)maxStats[1], (int)maxStats[2], (int)maxStats[3]};
		
		rs = new double[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
		be = 0;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	14.7.2020
	 * 
	 *  pCharSetting:
	 *    0: Rasse
	 *    1: Kultur
	 *    2: Profession
	 * 
	 * 	pEigen:
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			(8 Geschwindigkeit)
	 * 	  4 Fingerfertigkeit	(9 Sozialstatus)
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		(5 Wundschwelle)
	 * 	  1 Ausdauerpunkte		(6 Initiativ-Basiswert)
	 * 	  2 Astralpunkte		(7 Attack-Basiswert)
	 * 	  3 Karmalpunkte		(8 Parade-Basiswert)
	 * 	  (4 Magieresitenz)		(9 Fernkampf-Basiswert) 
	 * 
	 * @param pID
	 * @param pName
	 * @param pRasse
	 * @param pEigen
	 * @param pStatiMod
	 */
	public Charakter(int pID, String pName, String[] pCharSetting, int[] pEigen, double[] pStatiMod){
		Exception vExc = null;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; Char_b");
		
		name = pName;
		if (pCharSetting != null) {
			if (pCharSetting.length == 3) {
				race = pCharSetting[0];
				culture = pCharSetting[1];
				profession = pCharSetting[2];
			} else vExc = new Exception("01; Char_b");
		} else vExc = new Exception("04; Char_b");
		
		if (((4 <= pStatiMod.length) && (pStatiMod.length <= 6)) || (pStatiMod.length == 10)){
			if (pStatiMod[2] >= 0 && pStatiMod[3] >= 0) mundaneType = 3;
			else if (pStatiMod[2] >= 0) mundaneType = 1;
			else if (pStatiMod[3] >= 0) mundaneType = 2;
			else mundaneType = 0;
		}
		else vExc = new Exception("01; Char_b");
		
		properties = new int[8];
		switch(pEigen.length){
		case 8:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_b");
				properties[i] = pEigen[i];
			}
			gs = 8;
			so = 0;
			break;
		case 9:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_b");
				if (i < 8) properties[i] = pEigen[i];
				else gs = pEigen[i];
			}
			so = 0;
			break;
		case 10:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_b");
				if (i < 8) properties[i] = pEigen[i];
				else if (i == 9)gs = pEigen[i];
				else so = pEigen[i];
			}
			break;
		default:
			vExc = new Exception("01; Char_b");
		}
		propertieMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		wounds = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		
		try {talentList = Loader.getBasicTalents();}
		catch(Exception ex) {vExc = ex;}
		
		proList = new List();
		specialCraftList = new List();
		weaponList = new List();
		
		statMods = pStatiMod;
		
		try{
			maxStats = Calculator.calCharBasisStati(properties, 0);
			mr = Calculator.calCharMr(properties);
			ws = properties[6]/2;
			fightValues = Calculator.calCharFightValue(properties);
		}catch(Exception exc){vExc = exc;}

		switch(pStatiMod.length){
		case 4:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_b");
				maxStats[i] += (int)pStatiMod[i];
			}
			break;
		case 5:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_b");
				if (i < 4) maxStats[i] += (int)pStatiMod[i];
				else mr += pStatiMod[i];
			}
			break;
		case 6:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_b");
				if (i < 4) maxStats[i] += (int)pStatiMod[i];
				else if (i==4) mr += pStatiMod[i];
				else ws += pStatiMod[i];
			}
			break;
		case 10:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_b");
				if (i < 4) maxStats[i] += (int)pStatiMod[i];
				else if (i==4) mr += pStatiMod[i];
				else if (i==5) ws += pStatiMod[i];
				else fightValues[i-6] += pStatiMod[i];
			}
			break;
		}
		
		stats = new int[]{(int)maxStats[0], (int)maxStats[1], (int)maxStats[2], (int)maxStats[3]};
		
		rs = new double[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
		be = 0;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	14.7.2020
	 * 
	 * 	pCharSetting:
	 *    0: Rasse
	 *    1: Kultur
	 *    2: Profession
	 * 
	 * 	pEigen:
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			(8 Geschwindigkeit)
	 * 	  4 Fingerfertigkeit	(9 Sozialstatus)
	 * 
	 * @param pID
	 * @param pName
	 * @param pRasse
	 * @param pEigen
	 * @param pTalents
	 */
	public Charakter(int pID, String pName, String[] pCharSetting, int[] pEigen, List pTalents){
		Exception vExc = null;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; Char_c");
		
		name = pName;
		if (pCharSetting != null) {
			if (pCharSetting.length == 3) {
				race = pCharSetting[0];
				culture = pCharSetting[1];
				profession = pCharSetting[2];
			} else vExc = new Exception("01; Char_c");
		} else vExc = new Exception("04; Char_c");
		
		mundaneType = 0;
		
		properties = new int[8];
		switch(pEigen.length){
		case 8:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_c");
				properties[i] = pEigen[i];
			}
			gs = 8;
			so = 0;
			break;
		case 9:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_c");
				if (i < 8) properties[i] = pEigen[i];
				else gs = pEigen[i];
			}
			so = 0;
			break;
		case 10:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_c");
				if (i < 8) properties[i] = pEigen[i];
				else if (i == 9)gs = pEigen[i];
				else so = pEigen[i];
			}
			break;
		default:
			vExc = new Exception("01; Char_c");
		}
		propertieMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		wounds = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		
		talentList = pTalents;
		
		proList = new List();
		specialCraftList = new List();
		weaponList = new List();
		
		statMods = new double[4];
		for (int i=0; i<statMods.length; i++){
			statMods[i] = 0;
		}
		
		try{
			maxStats = Calculator.calCharBasisStati(properties, 0);
			mr = Calculator.calCharMr(properties);
			ws = properties[6]/2;
			fightValues = Calculator.calCharFightValue(properties);
		}catch(Exception exc){vExc = exc;}
		
		stats = new int[]{(int)maxStats[0], (int)maxStats[1], (int)maxStats[2], (int)maxStats[3]};
		
		rs = new double[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
		be = 0;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	14.7.2020
	 * 
	 * 	pCharSetting:
	 *    0: Rasse
	 *    1: Kultur
	 *    2: Profession
	 * 
	 * 	pEigen:
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			(8 Geschwindigkeit)
	 * 	  4 Fingerfertigkeit	(9 Sozialstatus)
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		(5 Wundschwelle)
	 * 	  1 Ausdauerpunkte		(6 Initiativ-Basiswert)
	 * 	  2 Astralpunkte		(7 Attack-Basiswert)
	 * 	  3 Karmalpunkte		(8 Parade-Basiswert)
	 * 	  (4 Magieresitenz)		(9 Fernkampf-Basiswert)
	 * 
	 * @param pID
	 * @param pName
	 * @param pRasse
	 * @param pEigen
	 * @param pStatiMod
	 * @param pTalents
	 */
	public Charakter(int pID, String pName, String[] pCharSetting, int[] pEigen, double[] pStatiMod, List pTalents){
		Exception vExc= null;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; Char_d");
		
		name = pName;
		if (pCharSetting != null) {
			if (pCharSetting.length == 3) {
				race = pCharSetting[0];
				culture = pCharSetting[1];
				profession = pCharSetting[2];
			} else vExc = new Exception("01; Char_d");
		} else vExc = new Exception("04; Char_d");
		
		if (((4 <= pStatiMod.length) && (pStatiMod.length <= 6)) || (pStatiMod.length == 10)){
			if (pStatiMod[2] >= 0 && pStatiMod[3] >= 0) mundaneType = 3;
			else if (pStatiMod[2] >= 0) mundaneType = 1;
			else if (pStatiMod[3] >= 0) mundaneType = 2;
			else mundaneType = 0;
		}
		else vExc = new Exception("01; Char_d");
		
		properties = new int[8];
		switch(pEigen.length){
		case 8:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_d");
				properties[i] = pEigen[i];
			}
			gs = 8;
			so = 0;
			break;
		case 9:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_d");
				if (i < 8) properties[i] = pEigen[i];
				else gs = pEigen[i];
			}
			so = 0;
			break;
		case 10:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_d");
				if (i < 8) properties[i] = pEigen[i];
				else if (i == 9)gs = pEigen[i];
				else so = pEigen[i];
			}
			break;
		default:
			vExc = new Exception("01; Char_d");
		}
		propertieMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		wounds = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		
		proList = new List();
		specialCraftList = new List();
		talentList = new List();
		try {addTalents(pTalents);}
		catch(Exception ex) {vExc = ex;}
		weaponList = new List();
		
		statMods = pStatiMod;
		
		try{
			maxStats = Calculator.calCharBasisStati(properties, 0);
			mr = Calculator.calCharMr(properties);
			ws = properties[6]/2;
			fightValues = Calculator.calCharFightValue(properties);
		}catch(Exception exc){vExc = exc;}

		switch(pStatiMod.length){
		case 4:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_d");
				maxStats[i] += (int)pStatiMod[i];
			}
			break;
		case 5:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_d");
				if (i < 4) maxStats[i] += (int)pStatiMod[i];
				else mr += pStatiMod[i];
			}
			break;
		case 6:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_d");
				if (i < 4) maxStats[i] += (int)pStatiMod[i];
				else if (i==4) mr += pStatiMod[i];
				else ws += pStatiMod[i];
			}
			break;
		case 10:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_d");
				if (i < 4) maxStats[i] += (int)pStatiMod[i];
				else if (i==4) mr += pStatiMod[i];
				else if (i==5) ws += pStatiMod[i];
				else fightValues[i-6] += pStatiMod[i];
			}
			break;
		}
		
		stats = new int[]{(int)maxStats[0], (int)maxStats[1], (int)maxStats[2], (int)maxStats[3]};
		
		rs = new double[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
		be = 0;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	14.7.2020
	 * 
	 * 	pCharSetting:
	 *    0: Rasse
	 *    1: Kultur
	 *    2: Profession
	 * 
	 * 	pEigen:
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			(8 Geschwindigkeit)
	 * 	  4 Fingerfertigkeit	(9 Sozialstatus)
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		(5 Wundschwelle)
	 * 	  1 Ausdauerpunkte		(6 Initiativ-Basiswert)
	 * 	  2 Astralpunkte		(7 Attack-Basiswert)
	 * 	  3 Karmalpunkte		(8 Parade-Basiswert)
	 * 	  (4 Magieresitenz)		(9 Fernkampf-Basiswert)
	 * 
	 * @param pID
	 * @param pName
	 * @param pRasse
	 * @param pEigen
	 * @param pStatiMod
	 * @param pTalents
	 * @param pWeapons
	 */
	public Charakter(int pID, String pName, String[] pCharSetting, int[] pEigen, double[] pStatiMod, List pTalents, List pWeapons) {
		Exception vExc= null;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; Char_e");
		
		name = pName;
		if (pCharSetting != null) {
			if (pCharSetting.length == 3) {
				race = pCharSetting[0];
				culture = pCharSetting[1];
				profession = pCharSetting[2];
			} else vExc = new Exception("01; Char_e");
		} else vExc = new Exception("04; Char_e");
		
		if (((4 <= pStatiMod.length) && (pStatiMod.length <= 6)) || (pStatiMod.length == 10)){
			if (pStatiMod[2] >= 0 && pStatiMod[3] >= 0) mundaneType = 3;
			else if (pStatiMod[2] >= 0) mundaneType = 1;
			else if (pStatiMod[3] >= 0) mundaneType = 2;
			else mundaneType = 0;
		}
		else vExc = new Exception("01; Char_e");
		
		properties = new int[8];
		switch(pEigen.length){
		case 8:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_e");
				properties[i] = pEigen[i];
			}
			gs = 8;
			so = 0;
			break;
		case 9:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_e");
				if (i < 8) properties[i] = pEigen[i];
				else gs = pEigen[i];
			}
			so = 0;
			break;
		case 10:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_e");
				if (i < 8) properties[i] = pEigen[i];
				else if (i == 9)gs = pEigen[i];
				else so = pEigen[i];
			}
			break;
		default:
			vExc = new Exception("01; Char_e");
		}
		propertieMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		wounds = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		
		proList = new List();
		specialCraftList = new List();
		talentList = new List();
		try { addTalents(pTalents);}
		catch(Exception ex) {vExc = ex;}
		if (pWeapons != null) {
			pWeapons.toFirst();
			for (int i=0; i < pWeapons.getContentNumber(); i++) {
				try{ ((Weapon)pWeapons.getCurrent()).setId(i);}
				catch(Exception ex) {vExc = ex;}
				pWeapons.next();
			}
		}
		weaponList = pWeapons;
		
		statMods = pStatiMod;
		
		try{
			maxStats = Calculator.calCharBasisStati(properties, 0);
			mr = Calculator.calCharMr(properties);
			ws = properties[6]/2;
			fightValues = Calculator.calCharFightValue(properties);
		}catch(Exception exc){vExc = exc;}

		switch(pStatiMod.length){
		case 4:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_e");
				maxStats[i] += (int)pStatiMod[i];
			}
			break;
		case 5:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_e");
				if (i < 4) maxStats[i] += (int)pStatiMod[i];
				else mr += pStatiMod[i];
			}
			break;
		case 6:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_e");
				if (i < 4) maxStats[i] += (int)pStatiMod[i];
				else if (i==4) mr += pStatiMod[i];
				else ws += pStatiMod[i];
			}
			break;
		case 10:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_e");
				if (i < 4) maxStats[i] += (int)pStatiMod[i];
				else if (i==4) mr += pStatiMod[i];
				else if (i==5) ws += pStatiMod[i];
				else fightValues[i-6] += pStatiMod[i];
			}
			break;
		}
		
		stats = new int[]{(int)maxStats[0], (int)maxStats[1], (int)maxStats[2], (int)maxStats[3]};
		
		rs = new double[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
		be = 0;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	
	public void destroyCharacter() throws Exception{
		Exception vExc = null;
		
		name = null;
		race = null;
		
		if (proList != null){
			while(!proList.isEmpty()){
				proList.toFirst();
				proList.remove();
			}
			proList = null;
		} else vExc = new Exception("04; Char,dC");
		if (specialCraftList != null){
			while(!specialCraftList.isEmpty()){
				specialCraftList.toFirst();
				specialCraftList.remove();
			}
			specialCraftList = null;
		} else vExc = new Exception("04; Char,dc");
		if (talentList != null){
			while (!talentList.isEmpty()){
				talentList.toFirst();
				talentList.remove();
			}
			talentList = null;
		} else vExc = new Exception("04; Char,dc");
		if (weaponList != null){
			while (!weaponList.isEmpty()){
				weaponList.toFirst();
				weaponList.remove();
			}
			weaponList = null;
		} else vExc = new Exception("04; Char,dc");
		
		if (vExc != null) throw vExc;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public int getId() {
		return id;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public String getName(){
		return name;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public String getRace(){
		return race;
	}
	/**	Dh	14.7.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public String getCulture() {
		return culture;
	}
	/**	Dh	14.7.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public String getProfession() {
		return profession;
	}
	
	/**	Dh	11.6.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public int getMundaneType() {
		return mundaneType;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "SozialStatus")
	public int getSo(){
		return so;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Geschwindigkeit")
	public int getGs(){
		return gs;
	}
	
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Magieresistenz")
	public double getMr(){
		return mr;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Wundschwelle")
	public double getWs(){
		return ws;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Behinderung")
	public double getBe(){
		return be;
	}
	
	/**	Dh 10.2.2020
	 * 
	 * 	Properties: 
	 * 	  0 Mut					4 Fingerfertigkeit
	 * 	  1 Klugkheit			5 Gewandheit
	 * 	  2 Intuition			6 Konstitution
	 * 	  3 Charisma			7 Koerperkraft
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getPropertie(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < properties.length)){
			return properties[pInd];
		}else throw new Exception("07; Char,gPr");
	}
	/**	Dh	14.7.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getPropertieMod(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < propertieMods.length)){
			return propertieMods[pInd];
		}else throw new Exception("07; Char,gPM");
	}
	/**	Dh	10.2.2020
	 * 
	 * 	Stats:
	 * 	  0 Lebenspunkte		2 Astralenergie
	 * 	  1 Ausdauer			3 Karmalenergie
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getStat(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < stats.length)){
			return stats[pInd];
		}else throw new Exception("07; Char,gSt");
	}
	/**	Dh	27.5.2020
	 * 
	 * 	BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getWound(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < wounds.length)){
			return wounds[pInd];
		}else throw new Exception("07; Char,gWo");
	}
	//-----
	/**	Dh	10.2.2020
	 * 
	 * 	Properties: 
	 * 	  0 Mut					4 Fingerfertigkeit
	 * 	  1 Klugkheit			5 Gewandheit
	 * 	  2 Intuition			6 Konstitution
	 * 	  3 Charisma			7 Koerperkraft
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "EigenschaftsArray")
	@XmlElement(name = "Eigenschaft")
	public int[] getProperties(){
		return properties;
	}
	/**	Dh	14.7.2020
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "EigenschaftModsArray")
	@XmlElement(name = "EigenschaftMod")
	public int[] getPropertieMods() {
		return propertieMods;
	}
	/**	Dh	27.5.2020
	 * 
	 * 	Dh	27.5.2020
	 * 
	 * 	Stats:
	 * 	  0 Lebenspunkte
	 * 	  1 Ausdauerpunkte
	 * 	  2 Astralpunkte
	 * 	  3 Karmalpunkte
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "StatusArray")
	@XmlElement(name = "Status")
	public int[] getStats() {
		return stats;
	}
	/**	Dh	27.5.2020
	 * 
	 * 	BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "WundenArray")
	@XmlElement(name = "Wunde")
	public int[] getWounds() {
		return wounds;
	}
	
	/**	Dh	10.2.2020
	 * 
	 * 	MaxStats:
	 * 	  0 Lebenspunkte		2 Astralenergie
	 * 	  1 Ausdauer			3 Karmalenergie
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public double getMaxStat(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < maxStats.length)){
			return maxStats[pInd];
		}else throw new Exception("07; Char,gMS");
	}
	/**	Dh	10.2.2020
	 * 
	 * 	FightValuess:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public double getFightValue(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < fightValues.length)){
			return fightValues[pInd];
		}else throw new Exception("07; Char,gFV");
	}
	/**	Dh	10.2.2020
	 * 
	 * 	BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public double getRs(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < rs.length)){
			return rs[pInd];
		}else throw new Exception("07; Char,gRS");
	}
	//-----
	/**	Dh	27.5.2020
	 * 
	 * 	Stats:
	 * 	  0 Lebenspunkte		(5 Wundschwelle)
	 * 	  1 Ausdauerpunkte		(6 Initiativ-Basiswert)
	 * 	  2 Astralpunkte		(7 Attack-Basiswert)
	 * 	  3 Karmalpunkte		(8 Parade-Basiswert)
	 * 	  (4 Magieresitenz)		(9 Fernkampf-Basiswert)
	 * 
	 * @param pSpez
	 * @return
	 * @throws Exception
	 */
	public double[] getStats(int pSpez) throws Exception{
		double[] vRet;
		switch(pSpez){
		case 0:
			vRet = new double[4];
			for (int i=0; i<vRet.length;i++){
				vRet[i] = (double)stats[i];
			}
			break;
		case 1:
			vRet = new double[5];
			for (int i=0; i<vRet.length;i++){
				if (i < (vRet.length-1)) vRet[i] = (double)stats[i];
				else vRet[i] = mr;
			}
			break;
		case 2:
			vRet = new double[6];
			for (int i=0; i<vRet.length;i++){
				if (i < (vRet.length-1)) vRet[i] = (double)stats[i];
				else if (i == 4) vRet[i] = mr;
				else vRet[i] = ws;
			}
			break;
		case 3:
			vRet = new double[10];
			for (int i=0; i<vRet.length;i++){
				if (i < (vRet.length-1)) vRet[i] = (double)stats[i];
				else if (i == 4) vRet[i] = mr;
				else if (i == 5) vRet[i] = ws;
				else vRet[i] = fightValues[i-6];
			}
			break;
		default:
			throw new Exception("01; Char,gSti");
		}
		return vRet;
	}
	/**	Dh	10.2.2020
	 * 
	 * 	MaxStats:
	 * 	  0 Lebenspunkte		2 Astralenergie
	 * 	  1 Ausdauer			3 Karmalenergie
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "MaxStatusArray")
	@XmlElement(name = "MaxStatus")
	public double[] getMaxStats(){
		return maxStats;
	}
	/**	Dh	10.2.2020
	 * 
	 * 	FightValuess:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "KampfwertArray")
	@XmlElement(name = "Kampfwert")
	public double[] getFightValues(){
		return fightValues;
	}
	/**	Dh	10.2.2020
	 * 
	 * 	BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "RuestungsArray")
	@XmlElement(name = "Ruestungswert")
	public double[] getRs(){
		return rs;
	}
	//-----
	
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public Pro getPro(int pID) throws Exception{
		Pro vRet = null;
		
		if (pID >= 0) {
			if (!proList.isEmpty()) {
				proList.toFirst();
				while (!proList.isEnd()) {
					vRet = (Pro)proList.getCurrent();
					
					if (vRet.getId() == pID) proList.toLast();
					else vRet = null;
					
					proList.next();
				}
			}else throw new Exception("05; Char,gP");
		}else throw new Exception("02; Char,gP");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public SpecialCraft getSpecialCraft(int pID) throws Exception{
		SpecialCraft vRet = null;
		
		if (pID >= 0) {
			if (!specialCraftList.isEmpty()) {
				specialCraftList.toFirst();
				while (!specialCraftList.isEnd()) {
					vRet = (SpecialCraft)specialCraftList.getCurrent();
					
					if (vRet.getId() == pID) specialCraftList.toLast();
					else vRet = null;
					
					specialCraftList.next();
				}
			}else throw new Exception("05; Char,gSCL");
		}else throw new Exception("02; Char,SCPL");
		
		return vRet;
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public Talent getTalent(int pID) throws Exception{
		Talent vRet = null;
		
		if (pID >= 0) {
			if (!talentList.isEmpty()) {
				talentList.toFirst();
				while (!talentList.isEnd()) {
					vRet = (Talent)talentList.getCurrent();
					
					if (vRet.getId() == pID) talentList.toLast();
					else vRet = null;
					
					talentList.next();
				}
			}else throw new Exception("05; Char,gT");
		}else throw new Exception("02; Char,gT");
		
		return vRet;
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public Weapon getWeapon(int pID) throws Exception{
		Weapon vRet = null;
		
		if (pID >= 0) {
			if (!weaponList.isEmpty()) {
				weaponList.toFirst();
				while (!weaponList.isEnd()) {
					vRet = (Weapon)weaponList.getCurrent();
					
					if (vRet.getId() == pID) weaponList.toLast();
					else vRet = null;
					
					weaponList.next();
				}
			}else throw new Exception("05; Char,gW");
		}else throw new Exception("02; Char,gW");
		
		return vRet;
	}
	
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getPros(List pIDList) throws Exception{
		Object vID;
		Pro vCur;
		List vRet = new List();
		
		if (!pIDList.isEmpty()) {
			if (!proList.isEmpty()) {
				pIDList.toFirst();
				
				while (pIDList.isEnd()) {
					vID = pIDList.getCurrent();
					proList.toFirst();
					
					while (!proList.isEnd()) {
						vCur = (Pro)proList.getCurrent();
						
						if (vID instanceof Integer) {
							if ((int)vID == vCur.getId()) vRet.append(vCur);
						}else throw new Exception("06; Char_gPs");
						
						proList.next();
					}
					
					pIDList.next();
				}
			}else throw new Exception("05; Char_gPs");
		}else throw new Exception("05; Char_gPs");
			
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getSpecialCrafts(List pIDList) throws Exception{
		Object vID;
		SpecialCraft vCur;
		List vRet = new List();
		
		if (!pIDList.isEmpty()) {
			if (!specialCraftList.isEmpty()) {
				pIDList.toFirst();
				
				while (pIDList.isEnd()) {
					vID = pIDList.getCurrent();
					specialCraftList.toFirst();
					
					while (!specialCraftList.isEnd()) {
						vCur = (SpecialCraft)specialCraftList.getCurrent();
						
						if (vID instanceof Integer) {
							if ((int)vID == vCur.getId()) vRet.append(vCur);
						}else throw new Exception("06; Char_gSCs");
						
						specialCraftList.next();
					}
					
					pIDList.next();
				}
			}else throw new Exception("05; Char_gSCs");
		}else throw new Exception("05; Char_gSCs");
			
		return vRet;
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getTalents(List pIDList) throws Exception{
		Object vID;
		Talent vCur;
		List vRet = new List();
		
		if (!pIDList.isEmpty()) {
			if (!talentList.isEmpty()) {
				pIDList.toFirst();
				
				while (pIDList.isEnd()) {
					vID = pIDList.getCurrent();
					talentList.toFirst();
					
					while (!talentList.isEnd()) {
						vCur = (Talent)talentList.getCurrent();
						
						if (vID instanceof Integer) {
							if ((int)vID == vCur.getId()) vRet.append(vCur);
						}else throw new Exception("06; Char_gTs");
						
						talentList.next();
					}
					
					pIDList.next();
				}
			}else throw new Exception("05; Char_gTs");
		}else throw new Exception("05; Char_gTs");
			
		return vRet;
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getWeapons(List pIDList) throws Exception{
		Object vID;
		Weapon vCur;
		List vRet = new List();
		
		if (!pIDList.isEmpty()) {
			if (!weaponList.isEmpty()) {
				pIDList.toFirst();
				
				while (pIDList.isEnd()) {
					vID = pIDList.getCurrent();
					weaponList.toFirst();
					
					while (!weaponList.isEnd()) {
						vCur = (Weapon)weaponList.getCurrent();
						
						if (vID instanceof Integer) {
							if ((int)vID == vCur.getId()) vRet.append(vCur);
						}else throw new Exception("06; Char_gWs");
						
						weaponList.next();
					}
					
					pIDList.next();
				}
			}else throw new Exception("05; Char_gWs");
		}else throw new Exception("05; Char_gWs");
			
		return vRet;
	}
	
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "ProList")
	public List getProList(){
		return proList;
	}
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "SpecialCraftList")
	public List getSpecialCraftList(){
		return specialCraftList;
	}
	/**	Dh	10.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "TalentListe")
	public List getTalentList(){
		return talentList;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "WaffenListe")
	public List getWeaponList() {
		return weaponList;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void setId(int pID) throws Exception{
		if (pID >= 0) id = pID;
		else throw new Exception("02; Char,sID");
	}
	
	/**	Dh	14.7.2020
	 * 
	 * @param pName
	 */
	public void setName(String pName) throws Exception{
		if (pName != null) {
			if (!pName.equals("")) {
				name = pName;
			} else throw new Exception("02; Char,sN");
		}else throw new Exception("04; Char,sN"); 
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pRasse
	 */
	public void setRace(String pRasse) throws Exception{
		if (pRasse != null) {
			race = pRasse;
		} else throw new Exception("04; Char,sR");
	}
	/**	Dh	14.7.2020
	 * 
	 * @param pCulture
	 */
	public void setCulture(String pCulture) throws Exception {
		if (pCulture != null) {
			culture = pCulture;
		} else throw new Exception("04; Char,sC");
	}
	/**	Dh	14.7.2020
	 * 
	 * @param pProfession
	 * @throws Exception
	 */
	public void setProfession(String pProfession) throws Exception {
		if (pProfession != null) {
			profession = pProfession;
		} else throw new Exception("04; Char,sP");
	}
	
	/**	Dh	27.5.2020	
	 * 
	 * @param pSO
	 * @throws Exception
	 */
 	public void setSo(int pSO) throws Exception{
		if (pSO >= 0) so = pSO;
		else throw new Exception("02; Char,sSO");
	}
 	/**	Dh	27.5.2020
 	 * 
 	 * @param pGS
 	 * @throws Exception
 	 */
	public void setGs(int pGS) throws Exception{
		if (pGS >= 0) gs = pGS;
		else throw new Exception("02; Char,sGS");
	}
	/**	Dh	11.6.2020
	 * 
	 * @param pMundType
	 * @throws Exception
	 */
	public void setMundaneType(int pMundType) throws Exception {
		if ((pMundType >= 0) && (pMundType < 4)) mundaneType = pMundType;
		else throw new Exception("02; Cha,sMT");
	}
	
	/**	Dh	27.5.2020
	 * 
	 * @param pMR
	 * @throws Exception
	 */
	public void setMr(double pMR) throws Exception{
		if (pMR >= 0) mr = pMR;
		else throw new Exception("02; Char,sMR");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pWS
	 * @throws Exception
	 */
	public void setWs(double pWS) throws Exception{
		if (pWS >= 0) ws = pWS;
		else throw new Exception("02; Char,sWS");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pBe
	 * @throws Exception
	 */
	public void setBe(double pBE) throws Exception{
		if (pBE >= 0) be = pBE;
		else throw new Exception("02; Char,sBe");
	}
	//-----
	/**	Dh	14.7.2020
	 * 
	 * 	pEigenschaften: 
	 * 	  0 Mut					4 Fingerfertigkeit
	 * 	  1 Klugkheit			5 Gewandheit
	 * 	  2 Intuition			6 Konstitution
	 * 	  3 Charisma			7 Koerperkraft
	 * 
	 * @param pProp
	 * @param pInd
	 * @throws Exception
	 */
	public void setPropertie(int pProp, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < properties.length)){
			if (pProp >= 0) {
				if (pProp != properties[pInd]) {
					makePropDepChange(pProp-properties[pInd], pInd);
					properties[pInd] = pProp;
				}
			}
			else throw new Exception("02; Char,sPr");
		}else throw new Exception("07; Char,sPr");
	}
	/**	Dh	14.7.2020
	 * 
	 * @param pPropMod
	 * @param pInd
	 * @throws Exception
	 */
	public void setPropertieMod(int pPropMod, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < propertieMods.length)){
			if (pPropMod >= 0) properties[pInd] = pPropMod;
			else throw new Exception("02; Char,sPM");
		}else throw new Exception("07; Char,sPM");
	}
	/**	Dh	10.2.2020
	 * 
	 * 	pStati:
	 * 	  0 Lebenspunkte		2 Astralenergie
	 * 	  1 Ausdauer			3 Karmalenergie
	 * 
	 * @param pStat
	 * @param pInd
	 * @throws Exception
	 */
	public void setStat(int pStat, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < stats.length)){
			if ((pInd == 0) || ((pStat >= -1) && (pInd >= 1))) stats[pInd] = pStat;
			else throw new Exception("02; Char,sSt");
		}else throw new Exception("07; Char,sSt");
	}
	/**	Dh	27.5.2020
	 * 
	 * 	BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pWoundCount
	 * @param pInd
	 * @throws Exception
	 */
	public void setWound(int pWoundCount, int pInd) throws Exception{
		try {setWound(pWoundCount, pInd, -1);}
		catch (Exception ex) {throw ex;}
	}
	/**	Dh	27.5.2020
	 * 
	 * 	BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pWoundCount
	 * @param pInd
	 * @throws Exception
	 */
	public void setWound(int pWoundCount, int pInd, int pDiceRoll) throws Exception{
		int vWoundDiff;
		Random vRan = new Random();
		
		if ((pInd >= 0) && (pInd < wounds.length)){
			if (pWoundCount >= 0) {
				vWoundDiff = pWoundCount - wounds[pInd];
				if (pInd == 0) {
					addPropertie(-2*vWoundDiff, 0);
					addPropertie(-2*vWoundDiff, 1);
					addPropertie(-2*vWoundDiff, 2);
					
					addFightValue(-2*vWoundDiff, 0);
				}
				if ((pInd == 1) || (pInd == 2) || (pInd == 5)) {
					addPropertie(-1*vWoundDiff, 6);
					addPropertie(-1*vWoundDiff, 7);
					addFightValue(-1*vWoundDiff, 0);
					
					addFightValue(-1*vWoundDiff, 1);
					addFightValue(-1*vWoundDiff, 2);
					addFightValue(-1*vWoundDiff, 3);
					
					if (vWoundDiff < 0) {
						if ((pDiceRoll >= 1) && (pDiceRoll <=6)) addStat(pDiceRoll, 0);
						else {
							for (int i=0; i < vWoundDiff; i++) {
								addStat(vRan.nextInt(6)+1, 0);
							}
						}
					}
				}
				if (pInd == 5) {
					addGs(-1*vWoundDiff);
					addFightValue(-1*vWoundDiff, 0);
				}
				if ((pInd == 3) || (pInd == 4)) {
					addPropertie(-2*vWoundDiff, 6);
					addPropertie(-2*vWoundDiff, 7);
				}
				if ((pInd == 6) || (pInd == 7)) {
					addPropertie(-2*vWoundDiff, 5);
					addGs(-1*vWoundDiff);
					addFightValue(-2*vWoundDiff, 0);
				}
				if ((pInd == 6) || (pInd == 7) || (pInd == 3)) {
					addFightValue(-2*vWoundDiff, 1);
					addFightValue(-2*vWoundDiff, 2);
					addFightValue(-2*vWoundDiff, 3);
				}
				
				wounds[pInd] = pWoundCount;
			}else throw new Exception("02; Char,sWo");
		}else throw new Exception("07; Char,sWo");
	}
	//-----	
	/**	Dh 14.7.2020
	 * 
	 * 	pEigen:
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			(8 Geschwindigkeit)
	 * 	  4 Fingerfertigkeit	(9 Sozialstatus)
	 * 
	 * @param pProps
	 * @throws Exception
	 */
	public void setProperties(int[] pEigen) throws Exception{
		switch(pEigen.length){
		case 8:
			for (int i=0; i < pEigen.length; i++){
				if (pEigen[i] < 0) throw new Exception("02; Char,sPrs");
				setPropertie(pEigen[i], i);
			}
			break;
		case 9:
			for (int i=0; i < pEigen.length; i++){
				if (pEigen[i] < 0) throw new Exception("02; Char,sPrs");
				if (i < 8) setPropertie(pEigen[i], i);
				else gs = pEigen[i];
			}
			break;
		case 10:
			for (int i=0; i < pEigen.length; i++){
				if (pEigen[i] < 0) throw new Exception("02; Char,sPrs");
				if (i < 8) setPropertie(pEigen[i], i);
				else if (i == 9)gs = pEigen[i];
				else so = pEigen[i];
			}
			break;
		default:
			throw new Exception("01; Char,sPrs");
		}
	}
	/**	Dh	14.7.2020
	 * 
	 * @param pPropMods
	 * @throws Exception
	 */
	public void setPropertieMods(int[] pPropMods) throws Exception{
		if (pPropMods != null) {
			if (pPropMods.length == propertieMods.length) {
				for (int i=0; i<propertieMods.length; i++) {
					setPropertieMod(pPropMods[i], i);
				}
			} else throw new Exception("01; Char,sPMs");
		} else throw new Exception("04; Char,sPM");
	}
	/**	Dh	27.5.2020
	 * 
	 * 
	 * BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pWounds
	 * @throws Exception
	 */
	public void setWounds(int[] pWounds) throws Exception{
		if (pWounds.length == wounds.length) {
			for (int i=0; i < wounds.length; i++) {
				setWound(pWounds[i], i);
			}
		} else throw new Exception("01; Char,sWos");
	}
	/**	Dh	27.5.2020
	 * 
	 * 	 BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pWounds
	 * @param pDiceRolls
	 * @throws Exception
	 */
	public void setWounds(int[] pWounds, int[] pDiceRolls) throws Exception {
		if ((pWounds.length == wounds.length) && (pDiceRolls.length == wounds.length)) {
			for (int i=0; i < wounds.length; i++) {
				setWound(pWounds[i], i, pDiceRolls[i]);
			}
		} else throw new Exception("01; Char,sWos");
	}
	/**	Dh	24.6.2020
	 * 
	 * 	pStati:
	 * 	  0 Lebenspunkte		(5 Wundschwelle)
	 * 	  1 Ausdauerpunkte		(6 Initiativ-Basiswert)
	 * 	  2 Astralpunkte		(7 Attack-Basiswert)
	 * 	  3 Karmalpunkte		(8 Parade-Basiswert)
	 * 	  (4 Magieresitenz)		(9 Fernkampf-Basiswert)
	 * 
	 * @param pStati
	 * @throws Exception
	 */
	public void setStats(int[] pStati) throws Exception{
		switch(pStati.length){
		case 4:
			for (int i=0; i < pStati.length; i++){
				if ((pStati[i] < -1) && ((i == 2) || (i == 3))) throw new Exception("02; Char,sSti");
				stats[i] = (int)pStati[i];
			}
			break;
		case 5:
			for (int i=0; i < pStati.length; i++){
				if (i < 4) {
					if ((pStati[i] >= -1) || (i == 0) || (i == 1)) stats[i] = (int)pStati[i];
					else throw new Exception("02; Char,sSti");
				}
				else {
					if (pStati[i] >= 0) mr = pStati[i];
					else throw new Exception("02; Char,sSti");
				}
			}
			break;
		case 6:
			for (int i=0; i < pStati.length; i++){
				if (i < 4) 
					if ((pStati[i] >= -1) || (i == 0) || (i == 1)) stats[i] = (int)pStati[i];
					else throw new Exception("02; Char,sSti");
				else if (i==4) {
					if (pStati[i] >= 0) mr = pStati[i];
					else throw new Exception("02; Char,sSti");
				}
				else ws = pStati[i];
			}
			break;
		case 10:
			for (int i=0; i < pStati.length; i++){
				if (i < 4) 
					if ((pStati[i] >= -1) || (i == 0) || (i == 1)) stats[i] = (int)pStati[i];
					else throw new Exception("02; Char,sSti");
				else if (i==4) {
					if (pStati[i] >= 0) mr = pStati[i];
					else throw new Exception("02; Char,sSti");
				}
				else if (i==5) {
					if (pStati[i] >= 1) mr = pStati[i];
					else throw new Exception("02; Char,sSti");
				}
				else {
					if (pStati[i] >= 0) fightValues[i-6] = pStati[i];
					else throw new Exception("02; Char,sSti");
				}
			}
			break;
		default:
			throw new Exception("01; Char;sSti");
		}
	}
	
	/**	Dh	10.2.2020
	 * 
	 * 	pMaxStati:
	 * 	  0 Lebenspunkte		2 Astralenergie
	 * 	  1 Ausdauer			3 Karmalenergie
	 * 
	 * @param pMaxStat
	 * @param pInd
	 * @throws Exception
	 */
	public void setMaxStat(double pMaxStat, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < maxStats.length)){
			if ((pMaxStat >= 0) || (((pInd == 2) || (pInd==3)) && (pMaxStat == -1))) {
				if ((maxStats[pInd] == stats[pInd]) || (((pMaxStat - maxStats[pInd]) < 0) && ((pMaxStat < stats[pInd]) && (stats[pInd] < maxStats[pInd])))){
					stats[pInd] = (int)pMaxStat;
				}
				maxStats[pInd] = pMaxStat;
			}
			else throw new Exception("02; Char,sMS");
		}else throw new Exception("07; Char,sMS");
	}
	/**	Dh	10.2.2020
	 * 
	 * 	pFightValues:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pFightValue
	 * @param pInd
	 * @throws Exception
	 */
	public void setFightValue(double pFightValue, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < fightValues.length)){
			if ((pInd == 0) || ((pFightValue >= 0) && (pInd >= 1))) fightValues[pInd] = pFightValue;
			else throw new Exception("02; Char,sFV");
		}else throw new Exception("07; Char,sFV");
	}
	/**	Dh	10.2.2020
	 * 
	 * 	BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pRS
	 * @param pInd
	 * @throws Exception
	 */
	public void setRs(double pRS, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < rs.length)){
			if ((pInd == 0) || ((pRS >= 0) && (pInd >= 1))) rs[pInd] = pRS;
			else throw new Exception("02; Char,sRS");
		}else throw new Exception("07; Char,sRS");
	}
	//-----
	/**	Dh	10.2.2020
	 * 
	 * 	pMaxStati:
	 * 	  0 Lebenspunkte		2 Astralpunkte
	 * 	  1 Ausdauerpunkte		3 Karmalpunkte		
	 * 
	 * @param pMaxStati
	 * @throws Exception
	 */
	public void setMaxStats(double[] pMaxStati) throws Exception{
		if (pMaxStati.length == maxStats.length){
			for (int i=0; i < pMaxStati.length; i++){
				try{ setMaxStat(pMaxStati[i], i);}
				catch(Exception exc) {throw exc;}
			}
		}else throw new Exception("01; Char;sMSti");
	}
	/**	Dh 10.2.2020
	 * 
	 * 	pFightValues:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pFightValues
	 * @throws Exception
	 */
	public void setFightValues(double[] pFightValues) throws Exception{
		if (pFightValues.length == fightValues.length){
			for (int i=0; i < pFightValues.length; i++){
				if (pFightValues[i] >= 0) fightValues[i] = pFightValues[i];
				else throw new Exception("02; Char;sFVs");
			}
		}else throw new Exception("01; Char;sFVs");
	}
	/**	Dh	10.2.2020
	 * 	
	 * 	BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pRS
	 * @throws Exception
	 */
	public void setRs(double[] pRS) throws Exception{
		if (pRS.length == rs.length){
			for (int i=0; i < pRS.length; i++){
				if (pRS[i] >= 0) rs[i] = pRS[i];
				else throw new Exception("02; Char;sRSs");
			}
		}else throw new Exception("01; Char;sRSs");
	}
	
	/**	Dh	18.6.2020
	 * 
	 * @param pProList
	 * @throws Exception
	 */
	public void setProList(List pProList) throws Exception{
		if (pProList != null){
			if (proList != null){
				while(!proList.isEmpty()){
					proList.toFirst();
					proList.remove();
				}
			}
				
			proList = pProList;
		}
		else throw new Exception("04; Char,sPL");
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pSpecialCraftList
	 * @throws Exception
	 */
	public void setSpecialCraftList(List pSpecialCraftList) throws Exception{
		if (pSpecialCraftList != null){
			if (specialCraftList != null){
				while(!specialCraftList.isEmpty()){
					specialCraftList.toFirst();
					specialCraftList.remove();
				}
			}
				
			specialCraftList = pSpecialCraftList;
		}
		else throw new Exception("04; Char,sSCL");
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pTalentList
	 * @throws Exception
	 */
	public void setTalentList(List pTalentList) throws Exception{
		if (pTalentList != null){
			if (talentList != null){
				while(!talentList.isEmpty()){
					talentList.toFirst();
					talentList.remove();
				}
			}
				
			talentList = pTalentList;
		}
		else throw new Exception("04; Char,sTL");
	}
	/**	Dh	11.6.2020
	 * 
	 * @param pWeaponList
	 * @throws Exception
	 */
	public void setWeaponList(List pWeaponList) throws Exception {
		if (pWeaponList != null){
			if (weaponList != null){
				while(!weaponList.isEmpty()){
					weaponList.toFirst();
					weaponList.remove();
				}
			}
			
			pWeaponList.toFirst();
			for (int i=0; i < pWeaponList.getContentNumber(); i++) {
				((Weapon)pWeaponList.getCurrent()).setId(i);
				pWeaponList.next();
			}
			
			weaponList = pWeaponList;
		} else throw new Exception("04; Char,sWL");
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	23.6.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public boolean isUnderTheHalf(int pInd) throws Exception {
		boolean vRet;
		
		if ((pInd >= 0) && (pInd < 4)) {
			if ((stats[pInd]/maxStats[pInd]) < 0.5) vRet = true;
			else vRet =  false;
		} else throw new Exception("02; Cha,iUtH");
		
		return vRet;
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public boolean isUnderTheThird(int pInd) throws Exception {
		boolean vRet;
		
		if ((pInd >= 0) && (pInd < 4)) {
			if ((stats[pInd]/maxStats[pInd]) < (1/3)) vRet = true;
			else vRet =  false;
		} else throw new Exception("02; Cha,iUtT");
		
		return vRet;
	}
	/**	Dh	23.3.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public boolean isUnderTheQuarter(int pInd) throws Exception {
		boolean vRet;
		
		if ((pInd >= 0) && (pInd < 4)) {
			if ((stats[pInd]/maxStats[pInd]) < 0.25) vRet = true;
			else vRet =  false;
		} else throw new Exception("02; Cha,iUtQ");
		
		return vRet;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	23.6.2020
	 * 
	 * @param pPro
	 * @return
	 * @throws Exception
	 */
	public boolean havePro(Pro pPro) throws Exception{
		boolean vRet = false;
		Pro vCur;
		
		if (pPro != null) {
			if (!proList.isEmpty()) {
				proList.toFirst();
				
				while(!proList.isEnd() && (vRet == false)) {
					vCur = (Pro) proList.getCurrent();
					
					if (pPro.equals(vCur)) vRet = true;
					
					proList.next();
				}
			}
		} else throw new Exception("04; Cha,hP");
		
		return vRet;
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public boolean havePro(int pID) throws Exception{
		boolean vRet = false;
		Pro vCur;
		
		if (pID >= 0) {
			if (!proList.isEmpty()) {
				proList.toFirst();
				
				while(!proList.isEnd() && (vRet == false)) {
					vCur = (Pro) proList.getCurrent();
					
					if (pID == vCur.getId()) vRet = true;
					
					proList.next();
				}
			}
		} else throw new Exception("02; Cha,hP");
		
		return vRet;
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pName
	 * @return
	 * @throws Exception
	 */
	public boolean havePro(String pName) throws Exception{
		boolean vRet = false;
		Pro vCur;
		
		if (pName != "") {
			if (!proList.isEmpty()) {
				proList.toFirst();
				
				while(!proList.isEnd() && (vRet == false)) {
					vCur = (Pro) proList.getCurrent();
					
					if (pName.equals(vCur.getName())) vRet = true;
					
					proList.next();
				}
			}
		} else throw new Exception("02; Cha,hP");
		
		return vRet;
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pSpecialCraft
	 * @return
	 * @throws Exception
	 */
	public boolean haveSpecialCraft(SpecialCraft pSpecialCraft) throws Exception{
		boolean vRet = false;
		SpecialCraft vCur;
		
		if (pSpecialCraft != null) {
			if (!specialCraftList.isEmpty()) {
				specialCraftList.toFirst();
				
				while(!specialCraftList.isEnd() && (vRet == false)) {
					vCur = (SpecialCraft) specialCraftList.getCurrent();
					
					if (pSpecialCraft.equals(vCur)) vRet = true;
					
					specialCraftList.next();
				}
			}
		} else throw new Exception("04; Cha,hSC");
		
		return vRet;
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public boolean haveSpecialCraft(int pID) throws Exception{
		boolean vRet = false;
		SpecialCraft vCur;
		
		if (pID >= 0) {
			if (!specialCraftList.isEmpty()) {
				specialCraftList.toFirst();
				
				while(!specialCraftList.isEnd() && (vRet == false)) {
					vCur = (SpecialCraft) specialCraftList.getCurrent();
					
					if (pID == vCur.getId()) vRet = true;
					
					specialCraftList.next();
				}
			}
		} else throw new Exception("02; Cha,hSC");
		
		return vRet;
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pName
	 * @return
	 * @throws Exception
	 */
	public boolean haveSpecialCraft(String pName) throws Exception{
		boolean vRet = false;
		SpecialCraft vCur;
		
		if (pName != "") {
			if (!specialCraftList.isEmpty()) {
				specialCraftList.toFirst();
				
				while(!specialCraftList.isEnd() && (vRet == false)) {
					vCur = (SpecialCraft) specialCraftList.getCurrent();
					
					if (pName.equals(vCur.getName())) vRet = true;
					
					specialCraftList.next();
				}
			}
		} else throw new Exception("02; Cha,hSC");
		
		return vRet;
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pTalent
	 * @return
	 * @throws Exception
	 */
	public boolean haveTalent(Talent pTalent) throws Exception{
		boolean vRet = false;
		Talent vCur;
		
		if (pTalent!= null) {
			if (!talentList.isEmpty()) {
				talentList.toFirst();
				
				while(!talentList.isEnd() && (vRet == false)) {
					vCur = (Talent) talentList.getCurrent();
					
					if (pTalent.equals(vCur)) vRet = true;
					
					talentList.next();
				}
			}
		} else throw new Exception("04; Cha,hT");
		
		return vRet;
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public boolean haveTalent(int pID) throws Exception{
		boolean vRet = false;
		Talent vCur;
		
		if (pID >= 0) {
			if (!talentList.isEmpty()) {
				talentList.toFirst();
				
				while(!talentList.isEnd() && (vRet == false)) {
					vCur = (Talent) talentList.getCurrent();
					
					if (pID == vCur.getId()) vRet = true;
					
					talentList.next();
				}
			}
		} else throw new Exception("02; Cha,hT");
		
		return vRet;
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pName
	 * @return
	 * @throws Exception
	 */
	public boolean haveTalent(String pName) throws Exception{
		boolean vRet = false;
		Talent vCur;
		
		if (pName != "") {
			if (!talentList.isEmpty()) {
				talentList.toFirst();
				
				while(!talentList.isEnd() && (vRet == false)) {
					vCur = (Talent) talentList.getCurrent();
					
					if (pName.equals(vCur.getName())) vRet = true;
					
					talentList.next();
				}
			}
		} else throw new Exception("02; Cha,hT");
		
		return vRet;
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pWeapon
	 * @return
	 * @throws Exception
	 */
	public boolean haveWeapon(Weapon pWeapon) throws Exception{
		boolean vRet = false;
		Weapon vCur;
		
		if (pWeapon!= null) {
			if (!weaponList.isEmpty()) {
				weaponList.toFirst();
				
				while(!weaponList.isEnd() && (vRet == false)) {
					vCur = (Weapon) weaponList.getCurrent();
					
					if (pWeapon.equals(vCur)) vRet = true;
					
					weaponList.next();
				}
			}
		} else throw new Exception("04; Cha,hW");
		
		return vRet;
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public boolean haveWeapon(int pID) throws Exception{
		boolean vRet = false;
		Weapon vCur;
		
		if (pID >= 0) {
			if (!weaponList.isEmpty()) {
				weaponList.toFirst();
				
				while(!weaponList.isEnd() && (vRet == false)) {
					vCur = (Weapon) weaponList.getCurrent();
					
					if (pID == vCur.getId()) vRet = true;
					
					weaponList.next();
				}
			}
		} else throw new Exception("02; Cha,hW");
		
		return vRet;
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pName
	 * @return
	 * @throws Exception
	 */
	public boolean haveWeapon(String pName) throws Exception{
		boolean vRet = false;
		Weapon vCur;
		
		if (pName != "") {
			if (!weaponList.isEmpty()) {
				weaponList.toFirst();
				
				while(!weaponList.isEnd() && (vRet == false)) {
					vCur = (Weapon) weaponList.getCurrent();
					
					if (pName.equals(vCur.getName())) vRet = true;
					
					weaponList.next();
				}
			}
		} else throw new Exception("02; Cha,hW");
		
		return vRet;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	27.5.2020
	 * 
	 * @param pSO
	 * @throws Exception
	 */
	public void addSo(int pSO) throws Exception{
		if ((pSO >= 0) || ((pSO < 0) && (-pSO <= so))) so += pSO;
		else{
			so = 0;
			throw new Exception("03; Char,aSO");
		}
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pGS
	 * @throws Exception
	 */
	public void addGs(int pGS) throws Exception{
		if ((pGS >= 0) || ((pGS < 0) && (-pGS <= gs))) gs += pGS;
		else{
			gs = 0;
			throw new Exception("03; Char,aGS");
		}
	}
	
	/**	Dh	27.5.2020
	 * 
	 * @param pMR
	 * @throws Exception
	 */
	public void addMr(double pMR) throws Exception{
		if ((pMR >= 0) || ((pMR < 0) && (-pMR <= mr))) mr += pMR;
		else{
			mr = 0;
			throw new Exception("03; Char,aMR");
		}
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pWS
	 * @throws Exception
	 */
	public void addWs(double pWS) throws Exception{
		if ((pWS >= 0) || ((pWS < 0) && (-pWS < ws))) ws += pWS;
		else{
			ws = 0;
			throw new Exception("03; Char,aWS");
		}
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pBe
	 * @throws Exception
	 */
	public void addBe(double pBE) throws Exception{
		if ((pBE >= 0) || ((pBE < 0) && (-pBE <= be))) be += pBE;
		else{
			be = 0;
			throw new Exception("03; Char,aBe");
		}
	}
	//-----
	/**	Dh	11.2.2020
	 * 
	 * 	pEigenschaften: 
	 * 	  0 Mut					4 Fingerfertigkeit
	 * 	  1 Klugkheit			5 Gewandheit
	 * 	  2 Intuition			6 Konstitution
	 * 	  3 Charisma			7 Koerperkraft
	 * 
	 * @param pProp
	 * @param pInd
	 * @throws Exception
	 */
	public void addPropertie(int pProp, int pInd) throws Exception{		
		if ((pInd >= 0) && (pInd < properties.length)){
			if ((pProp >= 0) || ((pProp < 0) && (-pProp < properties[pInd]))) {
				try{ makePropDepChange(pProp, pInd);}
				catch(Exception exc) {throw exc;}
				
				properties[pInd] += pProp;
			}
			else{
				try{ makePropDepChange(-properties[pInd], pInd);}
				catch(Exception exc) {throw exc;}
				
				properties[pInd] = 0;
				throw new Exception("03; Char,aPr");
			}
		}else throw new Exception("07; Char,aPr");
	}
	/**	Dh	14.7.2020
	 * 
	 * @param pPropMod
	 * @param pInd
	 * @throws Exception
	 */
	public void addPropertieMod(int pPropMod, int pInd) throws Exception {
		if ((pInd >= 0) && (pInd < propertieMods.length)){
			if (pPropMod >= 0) properties[pInd] += pPropMod;
			else throw new Exception("02; Char,aPM");
		}else throw new Exception("07; Char,aPM");
	}
	/**	Dh	11.2.2020
	 * 
	 * 	pStati:
	 * 	  0 Lebenspunkte		2 Astralenergie
	 * 	  1 Ausdauer			3 Karmalenergie
	 * 
	 * @param pStat
	 * @param pInd
	 * @throws Exception
	 */
	public void addStat(int pStat, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < stats.length)){
			if ((pStat >= 0) || ((pStat < 0) && (-pStat < stats[pInd]))) {
				if ((stats[pInd] > maxStats[pInd]) || ((stats[pInd]+pStat) <= maxStats[pInd])) stats[pInd] += pStat;
				else stats[pInd] = (int)maxStats[pInd];
			}
			else{
				stats[pInd] = 0;
				throw new Exception("03; Char,aSt");
			}
		}else throw new Exception("07; Char,aSt");
	}
	/**	Dh	28.5.2020
	 * 
	 * 	BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pWound
	 * @param pInd
	 * @throws Exception
	 */
	public void addWound(int pWound, int pInd) throws Exception{
		try {addWound(pWound, pInd, -1);}
		catch(Exception ex) {throw ex;}
	}
	/**	Dh	28.5.2020
	 * 
	 * 	BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pWound
	 * @param pInd
	 * @param pDiceRoll
	 * @throws Exception
	 */
	public void addWound(int pWound, int pInd, int pDiceRoll) throws Exception {
		Random vRan = new Random();
		
		if ((pInd >= 0) && (pInd < wounds.length)){
			if ((wounds[pInd]+pWound) >= 0) {
				
				if (pInd == 0) {
					addPropertie(-2*pWound, 0);
					addPropertie(-2*pWound, 1);
					addPropertie(-2*pWound, 2);
					
					addFightValue(-2*pWound, 0);
				}
				if ((pInd == 1) || (pInd == 2) || (pInd == 5)) {
					addPropertie(-1*pWound, 6);
					addPropertie(-1*pWound, 7);
					addFightValue(-1*pWound, 0);
					
					addFightValue(-1*pWound, 1);
					addFightValue(-1*pWound, 2);
					addFightValue(-1*pWound, 3);
					
					if (pWound < 0) {
						if ((pDiceRoll >= 1) && (pDiceRoll <=6)) addStat(pDiceRoll, 0);
						else {
							for (int i=0; i < pWound; i++) {
								addStat(vRan.nextInt(6)+1, 0);
							}
						}
					}
				}
				if (pInd == 5) {
					addGs(-1*pWound);
					addFightValue(-1*pWound, 0);
				}
				if ((pInd == 3) || (pInd == 4)) {
					addPropertie(-2*pWound, 6);
					addPropertie(-2*pWound, 7);
				}
				if ((pInd == 6) || (pInd == 7)) {
					addPropertie(-2*pWound, 5);
					addGs(-1*pWound);
					addFightValue(-2*pWound, 0);
				}
				if ((pInd == 6) || (pInd == 7) || (pInd == 3)) {
					addFightValue(-2*pWound, 1);
					addFightValue(-2*pWound, 2);
					addFightValue(-2*pWound, 3);
				}
				
				wounds[pInd] += pWound;
			}else throw new Exception("02; Char,sWo");
		}else throw new Exception("07; Char,sWo");
	}
	
	/**	Dh	11.2.2020
	 * 
	 * 	pMaxStati:
	 * 	  0 Lebenspunkte		2 Astralenergie
	 * 	  1 Ausdauer			3 Karmalenergie
	 * 
	 * @param pMaxStat
	 * @param pInd
	 * @throws Exception
	 */
	public void addMaxStat(double pMaxStat, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < maxStats.length)){
			if ((pMaxStat >= 0) || ((pMaxStat < 0) && (-pMaxStat < maxStats[pInd]))) {
				if ((maxStats[pInd] >= stats[pInd]) && ((maxStats[pInd]+pMaxStat) < stats[pInd] )) stats[pInd] = (int)(maxStats[pInd] + pMaxStat);
				maxStats[pInd] += pMaxStat;
			}
			else{
				if ((stats[pInd] > 0) && (stats[pInd] <= maxStats[pInd])) stats[pInd] = 0;
				maxStats[pInd] = 0;
				throw new Exception("03; Char,aMS");
			}
		}else throw new Exception("07; Char,aMS");
	}
	/**	Dh	11.2.2020
	 * 
	 * 	pFightValues:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pFightValue
	 * @param pInd
	 * @throws Exception
	 */
	public void addFightValue(double pFightValue, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < fightValues.length)){
			if ((pFightValue >= 0) || ((pFightValue < 0) && (-pFightValue < fightValues[pInd]))) fightValues[pInd] += pFightValue;
			else{
				fightValues[pInd] = 0;
				throw new Exception("03; Char,aFV");
			}
		}else throw new Exception("07; Char,aFV");
	}
	/**	Dh	11.2.2020
	 * 
	 * 	BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pRS
	 * @param pInd
	 * @throws Exception
	 */
	public void addRs(double pRS, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < rs.length)){
			if ((pRS >= 0) || ((pRS < 0) && (-pRS <= rs[pInd]))) rs[pInd] += pRS;
			else{
				rs[pInd] = 0;
				throw new Exception("03; Char,aRS");
			}
		}else throw new Exception("07; Char,aRS");
	}
	
	/**	Dh 11.2.2020
	 * 
	 * 	pEigen:
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			(8 Geschwindigkeit)
	 * 	  4 Fingerfertigkeit	(9 Sozialstatus)
	 * 
	 * @param pEigen
	 * @throws Exception
	 */
	public void addProperties(int[] pEigen) throws Exception{
		switch(pEigen.length){
		case 8:
			for (int i=0; i < pEigen.length; i++){
				try{ addPropertie(pEigen[i], i);}
				catch(Exception exc) {throw exc;}
			}
			break;
		case 9:
			for (int i=0; i < pEigen.length; i++){
				try{
					if (i < 8) addPropertie(pEigen[i], i);
					else addGs(pEigen[i]);
				} catch(Exception exc) {throw exc;}
			}
			break;
		case 10:
			for (int i=0; i < pEigen.length; i++){
				try{
					if (i < 8) addPropertie(pEigen[i], i);
					else if (i == 9) addGs(pEigen[i]);
					else addSo(pEigen[i]);
				} catch(Exception exc) {throw exc;}
			}
			break;
		default:
			throw new Exception("01; Char,aPrs");
		}
	}
	/**	Dh	14.7.2020
	 * 
	 * @param pPropMods
	 * @throws Exception
	 */
	public void addPropertieMods(int[] pPropMods) throws Exception{
		if (pPropMods != null) {
			if (pPropMods.length == propertieMods.length) {
				for (int i=0; i < propertieMods.length; i++) {
					addPropertieMod(pPropMods[i],i);
				}
			} else throw new Exception("01; Char,aPMs");
		} else throw new Exception("04; Char,aPMs");
	}
	/**	Dh 11.2.2020
	 * 
	 * 	pStati:
	 * 	  0 Lebenspunkte		(5 Wundschwelle)
	 * 	  1 Ausdauerpunkte		(6 Initiativ-Basiswert)
	 * 	  2 Astralpunkte		(7 Attack-Basiswert)
	 * 	  3 Karmalpunkte		(8 Parade-Basiswert)
	 * 	  (4 Magieresitenz)		(9 Fernkampf-Basiswert)
	 * 
	 * @param pStati
	 * @throws Exception
	 */
	public void addStats(int[] pStati) throws Exception{
		switch(pStati.length){
		case 4:
			for (int i=0; i < pStati.length; i++){
				try{ addStat((int) pStati[i], i);}
				catch(Exception exc) {throw exc;}
			}
			break;
		case 5:
			for (int i=0; i < pStati.length; i++){
				try{
					if (i < 4) addStat((int) pStati[i], i);
					else addMr(pStati[i]);
				} catch(Exception exc) {throw exc;}
			}
			break;
		case 6:
			for (int i=0; i < pStati.length; i++){
				try{
					if (i < 4) addStat((int) pStati[i], i);
					else if (i==4) addMr(pStati[i]);
					else addWs(pStati[i]);
				} catch(Exception exc) {throw exc;}
			}
			break;
		case 10:
			for (int i=0; i < pStati.length; i++){
				try{
					if (i < 4) addStat((int) pStati[i], i);
					else if (i==4) addMr(pStati[i]);
					else if (i==5) addWs(pStati[i]);
					else addFightValue(pStati[i], i-6);
				} catch(Exception exc) {throw exc;}
			}
			break;
		default:
			throw new Exception("01; Char;aSti");
		}
	}
	/**	Dh	28.5.2020
	 * 
	 * 	BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pWounds
	 * @throws Exception
	 */
	public void addWounds(int[] pWounds) throws Exception{
		if (pWounds.length == wounds.length) {
			for (int i=0; i<wounds.length; i++) {
				try {addWound(pWounds[i], i, -1);}
				catch (Exception ex) {throw ex;}
			}
		}else throw new Exception("01; Char_aWos");
	}
	/**	Dh	28.5.2020
	 * 
	 * 	BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pWounds
	 * @param pDiceRolls
	 * @throws Exception
	 */
	public void addWounds(int[] pWounds, int[] pDiceRolls) throws Exception{
		if ((pWounds.length == wounds.length) && (pDiceRolls.length == wounds.length)) {
			for (int i=0; i<wounds.length; i++) {
				try {addWound(pWounds[i], i, pDiceRolls[i]);}
				catch (Exception ex) {throw ex;}
			}
		}else throw new Exception("01; Char_aWos");
	}
	
	/**	Dh	11.2.2020
	 * 
	 * 	pMaxStati:
	 * 	  0 Lebenspunkte		2 Astralpunkte
	 * 	  1 Ausdauerpunkte		3 Karmalpunkte
	 * 
	 * @param pMaxStati
	 * @throws Exception
	 */
	public void addMaxStats(double[] pMaxStati) throws Exception{
		if (pMaxStati.length == maxStats.length){
			for (int i=0; i < pMaxStati.length; i++){
				try{ addMaxStat(pMaxStati[i], i);}
				catch(Exception exc) {throw exc;}
			}
		}else throw new Exception("01; Char;aMSti");
	}
	/**	Dh	11.2.2020
	 * 
	 * 	pFightValues:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pFightValues
	 * @throws Exception
	 */
	public void addFightValues(double[] pFightValues) throws Exception{
		if (pFightValues.length == fightValues.length){
			for (int i=0; i < pFightValues.length; i++){
				try{ addFightValue(pFightValues[i], i);}
				catch(Exception exc) {throw exc;}
			}
		}else throw new Exception("01; Char;sFVs");
	}
	/**	Dh	11.2.2020
	 * 
	 * 	BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pRS
	 * @throws Exception
	 */
	public void addRs(double[] pRS) throws Exception{
		if (pRS.length == rs.length){
			for (int i=0; i < pRS.length; i++){
				try{ rs[i] = pRS[i];}
				catch(Exception exc) {throw exc;}
			}
		}else throw new Exception("01; Char;sRSs");
	}
	//-----
	/**	Dh	14.7.2020
	 * 
	 * 	Fuegt den uebergeben Vorteil nach ID sortiert in die Vorteilsliste ein.
	 * 
	 * @param pPro
	 * @throws Exception
	 */
	public void addPro(Pro pPro) throws Exception{
		int vID;
		Pro vCur;
		
		if(pPro != null) {
			vID = pPro.getId();
			
			if (!proList.isEmpty() && ((Pro)proList.getLast()).getId() > vID) {
				proList.toFirst();
				
				while(!proList.isEnd()) {
					vCur = (Pro) proList.getCurrent();
					
					if (vCur.getId() > vID) {
						proList.insert(pPro);
						proList.toLast();
					}
					
					proList.next();
				}
			} else proList.append(pPro);
		}
		else throw new Exception("04; Char,aP");
	}
	/**	Dh	14.7.2020
	 * 
	 * 	Fuegt die uebergebene Sonderfertigkeit nach ID sortiert in die Sonderfertigkeitslsite ein.
	 * 
	 * @param pSpecialCraft
	 * @throws Exception
	 */
	public void addSpecialCraft(SpecialCraft pSpecialCraft) throws Exception{
		int vID;
		SpecialCraft vCur;
		
		if(pSpecialCraft != null) {
			vID = pSpecialCraft.getId();
			if (!specialCraftList.isEmpty() && ((SpecialCraft)specialCraftList.getLast()).getId() > vID) {
				specialCraftList.toFirst();
			
				while(!specialCraftList.isEnd()) {
					vCur = (SpecialCraft) specialCraftList.getCurrent();
					
					if (vCur.getId() > vID) {
						specialCraftList.insert(pSpecialCraft);
						specialCraftList.toLast();
					}
					
					specialCraftList.next();
				}
			} else specialCraftList.append(pSpecialCraft);
		}else throw new Exception("04; Char,aSC");
	}
	/**	Dh	14.7.2020
	 * 
	 * 	Sortiert das hinzugefuegte Talent nach der ID in die Liste ein.
	 * 
	 * @param pTalent
	 * @throws Exception
	 */
	public void addTalent(Talent pTalent) throws Exception{
		int vID;
		Talent vCur;
		
		if(pTalent != null) {
			vID = pTalent.getId();
			if (!talentList.isEmpty() && ((Talent)talentList.getLast()).getId() > vID) {
				talentList.toFirst();
				
				while(!talentList.isEnd()) {
					vCur = (Talent) talentList.getCurrent();
					
					if (vCur.getId() > vID) {
						talentList.insert(pTalent);
						talentList.toLast();
					}
					
					talentList.next();
				}
			} else talentList.append(pTalent);
		}
		else throw new Exception("04; Char,aT");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pWeapon
	 * @throws Exception
	 */
	public void addWeapon(Weapon pWeapon) throws Exception {
		if(pWeapon != null) {
			pWeapon.setId(weaponList.getContentNumber());
			weaponList.append(pWeapon);
		}else throw new Exception("04; Char,aW");
	}
	
	/**	Dh	14.7.2020
	 * 
	 * 	Fuegt die Vorteile der Liste nach ID sortiert in die ProListe ein.
	 * 
	 * @param pPros
	 * @throws Exception
	 */
	public void addPros(List pPros) throws Exception{
		Object vCur;
		
		if (!pPros.isEmpty()) {
			pPros.toFirst();
			
			while(!pPros.isEnd()) {
				vCur = pPros.getCurrent();
				
				if (vCur instanceof Pro) addPro((Pro)vCur);
				else throw new Exception("06; Char,aPs");
				
				pPros.next();
			}
		}else throw new Exception("05; Char,aPs");
	}
	/**	Dh	14.7.2020
	 * 
	 * 	Fuegt die Sonderfertigkeiten der List nach ID sortiert in die specialCraftList ein.
	 * 
	 * @param pSpecialCrafts
	 */
	public void addSpecialCrafts(List pSpecialCrafts) throws Exception{
		Object vCur;
		
		if (!pSpecialCrafts.isEmpty()) {
			pSpecialCrafts.toFirst();
			
			while(!pSpecialCrafts.isEnd()) {
				vCur = pSpecialCrafts.getCurrent();
				
				if (vCur instanceof SpecialCraft) addSpecialCraft((SpecialCraft)vCur);
				else throw new Exception("06; Char,aSCs");
				
				pSpecialCrafts.next();
			}
		}else throw new Exception("05; Char,aSCs");
	}
	/**	Dh	14.7.2020
	 * 
	 * 	Fuegt die Talente der uebergebeben pListe nach ID sortiert in die talentList ein.
	 * 
	 * @param pTalents
	 * @throws Exception
	 */
	public void addTalents(List pTalents) throws Exception{
		Object vCur;
		
		if (!pTalents.isEmpty()) {
			pTalents.toFirst();
			
			while(!pTalents.isEnd()) {
				vCur = pTalents.getCurrent();
				
				if (vCur instanceof Talent) addTalent((Talent)vCur);
				else throw new Exception("06; Char,aTs");
				
				pTalents.next();
			}
		}else throw new Exception("05; Char,aTs");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pWeapons
	 * @throws Exception
	 */
	public void addWeapons(List pWeapons) throws Exception{
		Object vCur;
		
		if (!pWeapons.isEmpty()) {
			pWeapons.toFirst();
			
			while(!pWeapons.isEnd()) {
				vCur = pWeapons.getCurrent();
				
				if (vCur instanceof Weapon) {
					((Weapon)vCur).setId(weaponList.getContentNumber());
					weaponList.append(vCur);
				}
				else throw new Exception("06; Char,aWs");
				
				pWeapons.next();
			}
		}else throw new Exception("05; Char,aWs");
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void removePro(int pID) throws Exception{
		Pro vCur;
		
		if (pID >= 0) {
			if (!proList.isEmpty()) {
				proList.toFirst();
				
				while (!proList.isEnd()){
					vCur = (Pro)proList.getCurrent();
					
					if (vCur.getId() == pID) {
						proList.remove();
						proList.toLast();
					}
					
					proList.next();
				}
			}else throw new Exception("05; Char,rP");
		}else throw new Exception("02; Char,rP");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pPro
	 * @throws Exception
	 */
	public void removePro(Pro pPro) throws Exception{
		Pro vCur;
		
		if (pPro != null) {
			if (!proList.isEmpty()) {
				proList.toFirst();
				
				while (!proList.isEnd()){
					vCur = (Pro)proList.getCurrent();
					
					if (vCur == pPro) {
						proList.remove();
						proList.toLast();
					}
					
					proList.next();
				}
			}else throw new Exception("05; Char,rP");
		}else throw new Exception("04; Char,rP");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void removeSpecialCraft(int pID) throws Exception{
		SpecialCraft vCur;
		
		if (pID >= 0) {
			if (!specialCraftList.isEmpty()) {
				specialCraftList.toFirst();
				
				while (!specialCraftList.isEnd()){
					vCur = (SpecialCraft)specialCraftList.getCurrent();
					
					if (vCur.getId() == pID) {
						specialCraftList.remove();
						specialCraftList.toLast();
					}
					
					specialCraftList.next();
				}
			}else throw new Exception("05; Char,rSC");
		}else throw new Exception("02; Char,rSC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pSpecialCraft
	 * @throws Exception
	 */
	public void removeSpecialCraft(SpecialCraft pSpecialCraft) throws Exception{
		SpecialCraft vCur;
		
		if (pSpecialCraft != null) {
			if (!specialCraftList.isEmpty()) {
				specialCraftList.toFirst();
				
				while (!specialCraftList.isEnd()){
					vCur = (SpecialCraft)specialCraftList.getCurrent();
					
					if (vCur == pSpecialCraft) {
						specialCraftList.remove();
						specialCraftList.toLast();
					}
					
					specialCraftList.next();
				}
			}else throw new Exception("05; Char,rSC");
		}else throw new Exception("04; Char,rSC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void removeTalent(int pID) throws Exception{
		Talent vCur;
		
		if (pID >= 0) {
			if (!talentList.isEmpty()) {
				talentList.toFirst();
				
				while (!talentList.isEnd()){
					vCur = (Talent)talentList.getCurrent();
					
					if (vCur.getId() == pID) {
						talentList.remove();
						talentList.toLast();
					}
					
					talentList.next();
				}
			}else throw new Exception("05; Char,rT");
		}else throw new Exception("02; Char,rT");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pTalent
	 * @throws Exception
	 */
	public void removeTalent(Talent pTalent) throws Exception{
		Talent vCur;
		
		if (pTalent != null) {
			if (!talentList.isEmpty()) {
				talentList.toFirst();
				
				while (!talentList.isEnd()){
					vCur = (Talent)talentList.getCurrent();
					
					if (vCur == pTalent) {
						talentList.remove();
						talentList.toLast();
					}
					
					talentList.next();
				}
			}else throw new Exception("05; Char,rT");
		}else throw new Exception("04; Char,rT");
	}
	//-----
	/**	Dh	28.5.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void removeWeapon(int pID) throws Exception{
		Weapon vCur;
		
		if (pID >= 0) {
			if (!weaponList.isEmpty()) {
				weaponList.toFirst();
				
				while (!weaponList.isEnd()){
					vCur = (Weapon)weaponList.getCurrent();
					
					if (vCur.getId() == pID) {
						weaponList.remove();
						weaponList.toLast();
					}
					
					weaponList.next();
				}
			}else throw new Exception("05; Char,rW");
		}else throw new Exception("02; Char,rW");
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pWeapon
	 * @throws Exception
	 */
	public void removeWeapon(Weapon pWeapon) throws Exception{
		Weapon vCur;
		
		if (pWeapon != null) {
			if (!weaponList.isEmpty()) {
				weaponList.toFirst();
				
				while (!weaponList.isEnd()){
					vCur = (Weapon)weaponList.getCurrent();
					
					if (vCur == pWeapon) {
						weaponList.remove();
						weaponList.toLast();
					}
					
					weaponList.next();
				}
			}else throw new Exception("05; Char,rW");
		}else throw new Exception("04; Char,rW");
	}
	
	/**	Dh	23.6.2020
	 * 
	 * @param pPros
	 * @throws Exception
	 */
	public void removePro(List pPros) throws Exception{
		Object vCur;
		
		if (pPros != null) {
			if (!pPros.isEmpty()) {
				pPros.toFirst();
				
				while (!pPros.isEnd()){
					vCur = (Pro)pPros.getCurrent();
					
					if (vCur instanceof Integer) removePro((int) vCur);
					else if (vCur instanceof Pro) removePro((Pro) vCur);
					else throw new Exception("06; Char,rPs");
					
					pPros.next();
				}
			}else throw new Exception("05; Char,rPs");
		}else throw new Exception("04; Char,rPs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pSpecialCrafts
	 * @throws Exception
	 */
	public void removeSpecialCraft(List pSpecialCrafts) throws Exception{
		Object vCur;
		
		if (pSpecialCrafts != null) {
			if (!pSpecialCrafts.isEmpty()) {
				pSpecialCrafts.toFirst();
				
				while (!pSpecialCrafts.isEnd()){
					vCur = (SpecialCraft)pSpecialCrafts.getCurrent();
					
					if (vCur instanceof Integer) removeSpecialCraft((int) vCur);
					else if (vCur instanceof SpecialCraft) removeSpecialCraft((SpecialCraft) vCur);
					else throw new Exception("06; Char,rSCs");
					
					pSpecialCrafts.next();
				}
			}else throw new Exception("05; Char,rSCs");
		}else throw new Exception("04; Char,rSCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pTalents
	 * @throws Exception
	 */
	public void removeTalents(List pTalents) throws Exception{
		Object vCur;
		
		if (pTalents != null) {
			if (!pTalents.isEmpty()) {
				pTalents.toFirst();
				
				while (!pTalents.isEnd()){
					vCur = (Talent)pTalents.getCurrent();
					
					if (vCur instanceof Integer) removeTalent((int) vCur);
					else if (vCur instanceof Talent) removeTalent((Talent) vCur);
					else throw new Exception("06; Char,rTs");
					
					pTalents.next();
				}
			}else throw new Exception("05; Char,rTs");
		}else throw new Exception("04; Char,rTs");
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pWeapons
	 * @throws Exception
	 */
	public void removeWeapons(List pWeapons) throws Exception{
		Object vCur;
		
		if (pWeapons != null) {
			if (!pWeapons.isEmpty()) {
				pWeapons.toFirst();
				
				while (!pWeapons.isEnd()){
					vCur = (Weapon)pWeapons.getCurrent();
					
					if (vCur instanceof Integer) removeWeapon((int) vCur);
					else if (vCur instanceof Weapon) removeWeapon((Weapon) vCur);
					else throw new Exception("06; Char,rWs");
					
					pWeapons.next();
				}
			}else throw new Exception("05; Char,rWs");
		}else throw new Exception("04; Char,rWs");
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	28.5.2020
	 * 
	 * 	Haendelt den Schaden, den ein Charakter bekommt, und berechnet evt Wunden, wo und Anzahl, und gibt diese dann als int[] zurück.
	 * 
	 * 	BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pDamage
	 * @param pRegion
	 * @return
	 * @throws Exception
	 */
	public int[] takeDamage(int pDamage, int pRegion) throws Exception{
		try { return takeDamage(pDamage, pRegion, 0, false, false, 0);}
		catch (Exception ex) {throw ex;}
	}
	/**	Dh	28.5.2020
	 * 
	 * 	Haendelt den Schaden, den ein Charakter bekommt, und berechnet evt Wunden, wo und Anzahl, und gibt diese dann als int[] zurück.
	 * 
	 * 	BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pDamage
	 * @param pRegion
	 * @param pWSMod
	 * @return
	 * @throws Exception
	 */
	public int[] takeDamage(int pDamage, int pRegion, int pWSMod) throws Exception{
		try { return takeDamage(pDamage, pRegion, pWSMod, false, false, 0);}
		catch (Exception ex) {throw ex;}
	}
	/**	Dh	28.5.2020
	 * 
	 * 	Haendelt den Schaden, den ein Charakter bekommt, und berechnet evt Wunden, wo und Anzahl, und gibt diese dann als int[] zurück.
	 * 
	 * 	BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pDamage
	 * @param pRegion
	 * @param pLethal
	 * @return
	 * @throws Exception
	 */
	public int[] takeDamage(int pDamage, int pRegion, boolean pLethal) throws Exception{
		try { return takeDamage(pDamage, pRegion, 0, pLethal, false, 0);}
		catch (Exception ex) {throw ex;}
	}
	/**	Dh	28.5.2020
	 * 
	 * 	Haendelt den Schaden, den ein Charakter bekommt, und berechnet evt Wunden, wo und Anzahl, und gibt diese dann als int[] zurück.
	 * 
	 * 	BodyRegion:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pDamage
	 * @param pRegion
	 * @param pWSMod
	 * @param pLethal
	 * @param pRSIgnoring
	 * @param pDamageType
	 * @return
	 * @throws Exception
	 */
//--------------------------------------------------------------------------------------------------------

	public int[] takeDamage(int pDamage, int pRegion, int pWSMod, boolean pLethal, boolean pRSIgnoring, int pDamageType) throws Exception {
		int vWoundCount;
		int[] vRet = null;
		int vDmg = calActualDamage(pDamage, pLethal, pDamageType);
		
		if ((pDamage >= 0) && (pRegion >= -1) && (pRegion < 8)) {
			if ((pRegion != -1) && (pRSIgnoring == false))vDmg = vDmg - ((int)Math.round(rs[pRegion]));					// Option mit gRS einbauen.!!!!
			if ((pLethal == false) && (vDmg > (((int)Math.round(ws))-pWSMod))){
				if ( (((int)Math.round(ws))-pWSMod) != 0) vWoundCount = vDmg/(((int)Math.round(ws))-pWSMod);
				else vWoundCount = vDmg;
				
				vRet = new int[] {pRegion, vWoundCount};
			}
			if (pLethal == false) addStat(vDmg, 0);
			else addStat(vDmg, 1);
		}else throw new Exception("02; Char,tDa");
		
		return vRet;
	}
		
//--------------------------------------------------------------------------------------------------------
	
	
	/**	Dh	11.2.2020
	 * 
	 * 	Properties: 
	 * 	  0 Mut					4 Fingerfertigkeit
	 * 	  1 Klugkheit			5 Gewandheit
	 * 	  2 Intuition			6 Konstitution
	 * 	  3 Charisma			7 Koerperkraft
	 * 
	 * @param pProp
	 * @param pInd
	 * @throws Exception
	 */
	private void makePropDepChange(int pProp, int pInd) throws Exception{
		switch(pInd){
		case 0:
			try{
				addStat(pProp/2, 1);
				addMr(pProp/5);
				addFightValue(2*pProp/5, 0);
				addFightValue(pProp/5, 1);
			
				if (maxStats[2] > 0) addStat(pProp/2, 2);
			} catch(Exception exc) {throw exc;}
			break;
		case 1:
			try { addMr(pProp/5);}
			catch(Exception exc) {throw exc;}
			
			break;
		case 2:
			try{
				addFightValue(pProp/5, 0);
				addFightValue(pProp/5, 2);
				addFightValue(pProp/5, 3);
			
				if (maxStats[2] > 0) addStat(pProp/2, 2);
			} catch(Exception exc) {throw exc;}
			break;
		case 3:																		// Sonderfertigkeiten Gefäss der Sterne einbauen.
			try{ if (maxStats[2] > 0) addStat(pProp/2, 2);}
			catch(Exception exc) {throw exc;}
			
			break;
		case 4:
			try{ addFightValue(pProp/5, 3);} 
			catch(Exception exc) {throw exc;}
			break;
		case 5:
			try{
				addStat(pProp/2, 1);
				addFightValue(pProp/5, 0);
				addFightValue(pProp/5, 1);
				addFightValue(pProp/5, 2);
			} catch(Exception exc) {throw exc;}
			
			break;
		case 6:
			try{
				addStat(pProp, 0);
				addStat(pProp/2, 1);
				addMr(pProp/5);
				addWs(pProp/2);
			} catch(Exception exc) {throw exc;}
			
			break;
		case 7:
			try{
				addStat(pProp/2, 0);
				addFightValue(pProp/5, 1);
				addFightValue(pProp/5, 2);
				addFightValue(pProp/5, 3);
			} catch(Exception exc) {throw exc;}
			
			break;
		default:
			throw new Exception("07; Char,mPDC");
		}
	}
	
	/**	Dh	28.5.2020
	 * 	
	 * 	Berechnet den wirklichen Damage, abhängig von Resistenz, Immunitäten und Schadenstyp.
	 * 	(Commign Soon!)
	 * 
	 * @param pDamage
	 * @param pLethal
	 * @param pDamageType
	 * @return
	 */
	private int calActualDamage(int pDamage, boolean pLethal, int pDamageType) {
		int vRet = pDamage;
		
		return vRet;
	}
}
