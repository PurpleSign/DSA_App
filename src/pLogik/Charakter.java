/**	DSA_App v0.0	Dh	 18.6.2020
 * 	
 * 	Logik
 * 	  Charakter
 * 
 * 	MundType:
 * 	  0 mundan				2 karmal
 *    1 magisch				3 alles
 * 
 * 	Properties: 
 * 	  0 Mut					4 Fingerfertigkeit
 * 	  1 Klugkheit			5 Gewandheit
 * 	  2 Intuition			6 Konstitution
 * 	  3 Charisma			7 Koerperkraft
 * 
 * 	za(Max)Stati:
 * 	  0 Lebenspunkte		2 Astralenergie
 * 	  1 Ausdauer			3 Karmalenergie
 * 
 * 	FightValuess:
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
@XmlType(propOrder = {"properties", "proList", "specialCraftList", "SO", "GS", "MR", "WS", "stats", "maxStats", 
		"fightValues", "talents", "wounds", "RS", "BE", "weapons"})
@XmlSeeAlso({Weapon.class, Talent.class, Pro.class, SpecialCraft.class})
public class Charakter {

	private String Name, Race;
	private int ID, SO, GS, MundType;
	private double MR, WS, BE;
	private int[] Properties, MaxStats, Stats, Wounds;
	private double[] FightValues, RS, StatMods;
	private List ProList, SpecialCraftList, TalentList, WeaponList;
	
	/**	Dh	27.5.2020
	 * 
	 * 	Kosntruktor nach Bea-Standard.
	 */
	public Charakter() {
		Name = "";
		Race = "";
		SO = -1;
		GS = -1;
		MundType = -1;
		
		Properties = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		MaxStats = new int[] {0, 0, 0, 0};
		Stats = new int[]{0, 0, 0, 0};
		Wounds = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		
		FightValues = new double[] {0, 0, 0, 0};
		RS = new double[] {0, 0, 0, 0, 0, 0, 0, 0};
		StatMods = new double[] {0, 0, 0, 0};
		
		ProList = new List();
		SpecialCraftList = new List();
		TalentList = new List();
		WeaponList = new List();
	}
	/**	Dh	18.6.2020
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
	public Charakter(int pID, String pName, String pRasse, int[] pEigen){
		Exception vExc = null ;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; Char_a");
		
		Name = pName;
		Race = pRasse;
		MundType = 0;
		
		Properties = new int[8];
		switch(pEigen.length){
		case 8:
			for (int i=0; i < pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_a");
				Properties[i] = pEigen[i];
			}
			GS = 8;
			SO = 0;
			break;
		case 9:
			for (int i=0; i < pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_a");
				if (i < 8) Properties[i] = pEigen[i];
				else GS = pEigen[i];
			}
			SO = 0;
			break;
		case 10:
			for (int i=0; i < pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_a");
				if (i < 8) Properties[i] = pEigen[i];
				else if (i == 9)GS = pEigen[i];
				else SO = pEigen[i];
			}
			break;
		default:
			vExc = new Exception("01; Char_a");
		}
		Wounds = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		
		try {TalentList = Loader.getBasicTalents();}
		catch(Exception ex) {vExc = ex;}
		
		ProList = new List();
		SpecialCraftList = new List();
		WeaponList = new List();
		
		StatMods = new double[4];
		for (int i=0; i<StatMods.length; i++){
			StatMods[i] = 0;
		}
		
		try{
			MaxStats = Calculator.calCharBasisStati(Properties, MundType);
			MR = Calculator.calCharMr(Properties);
			WS = Properties[6]/2;
			FightValues = Calculator.calCharFightValue(Properties);
		}catch(Exception exc){vExc = exc;}

		Stats = MaxStats;
		
		RS = new double[8];
		for (int i=0; i<RS.length; i++){
			RS[i] = 0;
		}
		BE = 0;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	18.6.2020
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
	public Charakter(int pID, String pName, String pRasse, int[] pEigen, double[] pStatiMod){
		Exception vExc = null;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; Char_b");
		
		Name = pName;
		Race = pRasse;
		if (((4 <= pStatiMod.length) && (pStatiMod.length <= 6)) || (pStatiMod.length == 10)){
			if (pStatiMod[2] >= 0 && pStatiMod[3] >= 0) MundType = 3;
			else if (pStatiMod[2] >= 0) MundType = 1;
			else if (pStatiMod[3] >= 0) MundType = 2;
			else MundType = 0;
		}
		else vExc = new Exception("01; Char_b");
		
		Properties = new int[8];
		switch(pEigen.length){
		case 8:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_b");
				Properties[i] = pEigen[i];
			}
			GS = 8;
			SO = 0;
			break;
		case 9:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_b");
				if (i < 8) Properties[i] = pEigen[i];
				else GS = pEigen[i];
			}
			SO = 0;
			break;
		case 10:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_b");
				if (i < 8) Properties[i] = pEigen[i];
				else if (i == 9)GS = pEigen[i];
				else SO = pEigen[i];
			}
			break;
		default:
			vExc = new Exception("01; Char_b");
		}
		Wounds = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		
		try {TalentList = Loader.getBasicTalents();}
		catch(Exception ex) {vExc = ex;}
		
		ProList = new List();
		SpecialCraftList = new List();
		WeaponList = new List();
		
		StatMods = pStatiMod;
		
		try{
			MaxStats = Calculator.calCharBasisStati(Properties, 0);
			MR = Calculator.calCharMr(Properties);
			WS = Properties[6]/2;
			FightValues = Calculator.calCharFightValue(Properties);
		}catch(Exception exc){vExc = exc;}

		switch(pStatiMod.length){
		case 4:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_b");
				MaxStats[i] += (int)pStatiMod[i];
			}
			break;
		case 5:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_b");
				if (i < 4) MaxStats[i] += (int)pStatiMod[i];
				else MR += pStatiMod[i];
			}
			break;
		case 6:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_b");
				if (i < 4) MaxStats[i] += (int)pStatiMod[i];
				else if (i==4) MR += pStatiMod[i];
				else WS += pStatiMod[i];
			}
			break;
		case 10:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_b");
				if (i < 4) MaxStats[i] += (int)pStatiMod[i];
				else if (i==4) MR += pStatiMod[i];
				else if (i==5) WS += pStatiMod[i];
				else FightValues[i-6] += pStatiMod[i];
			}
			break;
		}
		
		Stats = MaxStats;
		
		RS = new double[8];
		for (int i=0; i<RS.length; i++){
			RS[i] = 0;
		}
		BE = 0;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	18.6.2020
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
	public Charakter(int pID, String pName, String pRasse, int[] pEigen, List pTalents){
		Exception vExc = null;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; Char_c");
		
		Name = pName;
		Race = pRasse;
		MundType = 0;
		
		Properties = new int[8];
		switch(pEigen.length){
		case 8:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_c");
				Properties[i] = pEigen[i];
			}
			GS = 8;
			SO = 0;
			break;
		case 9:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_c");
				if (i < 8) Properties[i] = pEigen[i];
				else GS = pEigen[i];
			}
			SO = 0;
			break;
		case 10:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_c");
				if (i < 8) Properties[i] = pEigen[i];
				else if (i == 9)GS = pEigen[i];
				else SO = pEigen[i];
			}
			break;
		default:
			vExc = new Exception("01; Char_c");
		}
		Wounds = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		
		TalentList = pTalents;
		
		ProList = new List();
		SpecialCraftList = new List();
		WeaponList = new List();
		
		StatMods = new double[4];
		for (int i=0; i<StatMods.length; i++){
			StatMods[i] = 0;
		}
		
		try{
			MaxStats = Calculator.calCharBasisStati(Properties, 0);
			MR = Calculator.calCharMr(Properties);
			WS = Properties[6]/2;
			FightValues = Calculator.calCharFightValue(Properties);
		}catch(Exception exc){vExc = exc;}
		
		Stats = MaxStats;
		
		RS = new double[8];
		for (int i=0; i<RS.length; i++){
			RS[i] = 0;
		}
		BE = 0;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	18.6.2020
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
	public Charakter(int pID, String pName, String pRasse, int[] pEigen, double[] pStatiMod, List pTalents){
		Exception vExc= null;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; Char_d");
		
		Name = pName;
		Race = pRasse;
		if (((4 <= pStatiMod.length) && (pStatiMod.length <= 6)) || (pStatiMod.length == 10)){
			if (pStatiMod[2] >= 0 && pStatiMod[3] >= 0) MundType = 3;
			else if (pStatiMod[2] >= 0) MundType = 1;
			else if (pStatiMod[3] >= 0) MundType = 2;
			else MundType = 0;
		}
		else vExc = new Exception("01; Char_b");
		
		Properties = new int[8];
		switch(pEigen.length){
		case 8:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_d");
				Properties[i] = pEigen[i];
			}
			GS = 8;
			SO = 0;
			break;
		case 9:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_d");
				if (i < 8) Properties[i] = pEigen[i];
				else GS = pEigen[i];
			}
			SO = 0;
			break;
		case 10:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_d");
				if (i < 8) Properties[i] = pEigen[i];
				else if (i == 9)GS = pEigen[i];
				else SO = pEigen[i];
			}
			break;
		default:
			vExc = new Exception("01; Char_d");
		}
		Wounds = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		
		ProList = new List();
		SpecialCraftList = new List();
		TalentList = pTalents;
		WeaponList = new List();
		
		StatMods = pStatiMod;
		
		try{
			MaxStats = Calculator.calCharBasisStati(Properties, 0);
			MR = Calculator.calCharMr(Properties);
			WS = Properties[6]/2;
			FightValues = Calculator.calCharFightValue(Properties);
		}catch(Exception exc){vExc = exc;}

		switch(pStatiMod.length){
		case 4:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_d");
				MaxStats[i] += (int)pStatiMod[i];
			}
			break;
		case 5:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_d");
				if (i < 4) MaxStats[i] += (int)pStatiMod[i];
				else MR += pStatiMod[i];
			}
			break;
		case 6:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_d");
				if (i < 4) MaxStats[i] += (int)pStatiMod[i];
				else if (i==4) MR += pStatiMod[i];
				else WS += pStatiMod[i];
			}
			break;
		case 10:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_d");
				if (i < 4) MaxStats[i] += (int)pStatiMod[i];
				else if (i==4) MR += pStatiMod[i];
				else if (i==5) WS += pStatiMod[i];
				else FightValues[i-6] += pStatiMod[i];
			}
			break;
		}
		
		Stats = MaxStats;
		
		RS = new double[8];
		for (int i=0; i<RS.length; i++){
			RS[i] = 0;
		}
		BE = 0;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	18.6.2020
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
	public Charakter(int pID, String pName, String pRasse, int[] pEigen, double[] pStatiMod, List pTalents, List pWeapons) {
		Exception vExc= null;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; Char_e");
		
		Name = pName;
		Race = pRasse;
		if (((4 <= pStatiMod.length) && (pStatiMod.length <= 6)) || (pStatiMod.length == 10)){
			if (pStatiMod[2] >= 0 && pStatiMod[3] >= 0) MundType = 3;
			else if (pStatiMod[2] >= 0) MundType = 1;
			else if (pStatiMod[3] >= 0) MundType = 2;
			else MundType = 0;
		}
		else vExc = new Exception("01; Char_e");
		
		Properties = new int[8];
		switch(pEigen.length){
		case 8:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_e");
				Properties[i] = pEigen[i];
			}
			GS = 8;
			SO = 0;
			break;
		case 9:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_e");
				if (i < 8) Properties[i] = pEigen[i];
				else GS = pEigen[i];
			}
			SO = 0;
			break;
		case 10:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vExc = new Exception("02; Char_e");
				if (i < 8) Properties[i] = pEigen[i];
				else if (i == 9)GS = pEigen[i];
				else SO = pEigen[i];
			}
			break;
		default:
			vExc = new Exception("01; Char_e");
		}
		Wounds = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		
		ProList = new List();
		SpecialCraftList = new List();
		TalentList = pTalents;
		if (pWeapons != null) {
			pWeapons.toFirst();
			for (int i=0; i < pWeapons.getContentNumber(); i++) {
				try{ ((Weapon)pWeapons.getCurrent()).setID(i);}
				catch(Exception ex) {vExc = ex;}
				pWeapons.next();
			}
		}
		WeaponList = pWeapons;
		
		StatMods = pStatiMod;
		
		try{
			MaxStats = Calculator.calCharBasisStati(Properties, 0);
			MR = Calculator.calCharMr(Properties);
			WS = Properties[6]/2;
			FightValues = Calculator.calCharFightValue(Properties);
		}catch(Exception exc){vExc = exc;}

		switch(pStatiMod.length){
		case 4:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_e");
				MaxStats[i] += (int)pStatiMod[i];
			}
			break;
		case 5:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_e");
				if (i < 4) MaxStats[i] += (int)pStatiMod[i];
				else MR += pStatiMod[i];
			}
			break;
		case 6:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_e");
				if (i < 4) MaxStats[i] += (int)pStatiMod[i];
				else if (i==4) MR += pStatiMod[i];
				else WS += pStatiMod[i];
			}
			break;
		case 10:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vExc = new Exception("02; Char_e");
				if (i < 4) MaxStats[i] += (int)pStatiMod[i];
				else if (i==4) MR += pStatiMod[i];
				else if (i==5) WS += pStatiMod[i];
				else FightValues[i-6] += pStatiMod[i];
			}
			break;
		}
		
		Stats = MaxStats;
		
		RS = new double[8];
		for (int i=0; i<RS.length; i++){
			RS[i] = 0;
		}
		BE = 0;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	
	public void destroyCharacter() throws Exception{
		Exception vExc = null;
		
		Name = null;
		Race = null;
		
		if (ProList != null){
			while(!ProList.isEmpty()){
				ProList.toFirst();
				ProList.remove();
			}
			ProList = null;
		} else vExc = new Exception("04; Char,dC");
		if (SpecialCraftList != null){
			while(!SpecialCraftList.isEmpty()){
				SpecialCraftList.toFirst();
				SpecialCraftList.remove();
			}
			SpecialCraftList = null;
		} else vExc = new Exception("04; Char,dc");
		if (TalentList != null){
			while (!TalentList.isEmpty()){
				TalentList.toFirst();
				TalentList.remove();
			}
			TalentList = null;
		} else vExc = new Exception("04; Char,dc");
		if (WeaponList != null){
			while (!WeaponList.isEmpty()){
				WeaponList.toFirst();
				WeaponList.remove();
			}
			WeaponList = null;
		} else vExc = new Exception("04; Char,dc");
		
		if (vExc != null) throw vExc;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public int getID() {
		return ID;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public String getName(){
		return Name;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public String getRace(){
		return Race;
	}
	/**	Dh	11.6.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public int getMundType() {
		return MundType;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "SozialStatus")
	public int getSO(){
		return SO;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Geschwindigkeit")
	public int getGS(){
		return GS;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Magieresistenz")
	public double getMR(){
		return MR;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Wundschwelle")
	public double getWS(){
		return WS;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Behinderung")
	public double getBE(){
		return BE;
	}
	//-----
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
		if ((pInd >= 0) && (pInd < Properties.length)){
			return Properties[pInd];
		}else throw new Exception("07; Char,gPr");
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
		if ((pInd >= 0) && (pInd < Stats.length)){
			return Stats[pInd];
		}else throw new Exception("07; Char,gSt");
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
	public int getMaxStat(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < MaxStats.length)){
			return MaxStats[pInd];
		}else throw new Exception("07; Char,gMS");
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
		if ((pInd >= 0) && (pInd < Wounds.length)){
			return Wounds[pInd];
		}else throw new Exception("07; Char,gWo");
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
		if ((pInd >= 0) && (pInd < FightValues.length)){
			return FightValues[pInd];
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
	public double getRS(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < RS.length)){
			return RS[pInd];
		}else throw new Exception("07; Char,gRS");
	}
	
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
		return Properties;
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
		return Stats;
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
		return Wounds;
	}
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
				vRet[i] = (double)Stats[i];
			}
			break;
		case 1:
			vRet = new double[5];
			for (int i=0; i<vRet.length;i++){
				if (i < (vRet.length-1)) vRet[i] = (double)Stats[i];
				else vRet[i] = MR;
			}
			break;
		case 2:
			vRet = new double[6];
			for (int i=0; i<vRet.length;i++){
				if (i < (vRet.length-1)) vRet[i] = (double)Stats[i];
				else if (i == 4) vRet[i] = MR;
				else vRet[i] = WS;
			}
			break;
		case 3:
			vRet = new double[10];
			for (int i=0; i<vRet.length;i++){
				if (i < (vRet.length-1)) vRet[i] = (double)Stats[i];
				else if (i == 4) vRet[i] = MR;
				else if (i == 5) vRet[i] = WS;
				else vRet[i] = FightValues[i-6];
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
	public int[] getMaxStats(){
		return MaxStats;
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
		return FightValues;
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
	public double[] getRS(){
		return RS;
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
			if (!ProList.isEmpty()) {
				ProList.toFirst();
				while (!ProList.isEnd()) {
					vRet = (Pro)ProList.getCurrent();
					
					if (vRet.getID() == pID) ProList.toLast();
					else vRet = null;
					
					ProList.next();
				}
			}else throw new Exception("05; Char,gPL");
		}else throw new Exception("02; Char,gPL");
		
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
			if (!SpecialCraftList.isEmpty()) {
				SpecialCraftList.toFirst();
				while (!SpecialCraftList.isEnd()) {
					vRet = (SpecialCraft)SpecialCraftList.getCurrent();
					
					if (vRet.getID() == pID) SpecialCraftList.toLast();
					else vRet = null;
					
					SpecialCraftList.next();
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
			if (!TalentList.isEmpty()) {
				TalentList.toFirst();
				while (!TalentList.isEnd()) {
					vRet = (Talent)TalentList.getCurrent();
					
					if (vRet.getID() == pID) TalentList.toLast();
					else vRet = null;
					
					TalentList.next();
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
			if (!WeaponList.isEmpty()) {
				WeaponList.toFirst();
				while (!WeaponList.isEnd()) {
					vRet = (Weapon)WeaponList.getCurrent();
					
					if (vRet.getID() == pID) WeaponList.toLast();
					else vRet = null;
					
					WeaponList.next();
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
			if (!ProList.isEmpty()) {
				pIDList.toFirst();
				
				while (pIDList.isEnd()) {
					vID = pIDList.getCurrent();
					ProList.toFirst();
					
					while (!ProList.isEnd()) {
						vCur = (Pro)ProList.getCurrent();
						
						if (vID instanceof Integer) {
							if ((int)vID == vCur.getID()) vRet.append(vCur);
						}else throw new Exception("06; Char_gPs");
						
						ProList.next();
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
			if (!SpecialCraftList.isEmpty()) {
				pIDList.toFirst();
				
				while (pIDList.isEnd()) {
					vID = pIDList.getCurrent();
					SpecialCraftList.toFirst();
					
					while (!SpecialCraftList.isEnd()) {
						vCur = (SpecialCraft)SpecialCraftList.getCurrent();
						
						if (vID instanceof Integer) {
							if ((int)vID == vCur.getID()) vRet.append(vCur);
						}else throw new Exception("06; Char_gSCs");
						
						SpecialCraftList.next();
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
			if (!TalentList.isEmpty()) {
				pIDList.toFirst();
				
				while (pIDList.isEnd()) {
					vID = pIDList.getCurrent();
					TalentList.toFirst();
					
					while (!TalentList.isEnd()) {
						vCur = (Talent)TalentList.getCurrent();
						
						if (vID instanceof Integer) {
							if ((int)vID == vCur.getID()) vRet.append(vCur);
						}else throw new Exception("06; Char_gTs");
						
						TalentList.next();
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
			if (!WeaponList.isEmpty()) {
				pIDList.toFirst();
				
				while (pIDList.isEnd()) {
					vID = pIDList.getCurrent();
					WeaponList.toFirst();
					
					while (!WeaponList.isEnd()) {
						vCur = (Weapon)WeaponList.getCurrent();
						
						if (vID instanceof Integer) {
							if ((int)vID == vCur.getID()) vRet.append(vCur);
						}else throw new Exception("06; Char_gWs");
						
						WeaponList.next();
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
		return ProList;
	}
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "SpecialCraftList")
	public List getSpecialCraftList(){
		return SpecialCraftList;
	}
	/**	Dh	10.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "TalentListe")
	public List getTalentList(){
		return TalentList;
	}
	/**	Dh	27.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "WaffenListe")
	public List getWeaponList() {
		return WeaponList;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void setID(int pID) throws Exception{
		if (pID >= 0) ID = pID;
		else throw new Exception("02; Char,sID");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pName
	 */
	public void setName(String pName){
		Name = pName;
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pRasse
	 */
	public void setRace(String pRasse){
		Race = pRasse;
	}
	/**	Dh	27.5.2020	
	 * 
	 * @param pSO
	 * @throws Exception
	 */
 	public void setSO(int pSO) throws Exception{
		if (pSO >= 0) SO = pSO;
		else throw new Exception("02; Char,sSO");
	}
 	/**	Dh	27.5.2020
 	 * 
 	 * @param pGS
 	 * @throws Exception
 	 */
	public void setGS(int pGS) throws Exception{
		if (pGS >= 0) GS = pGS;
		else throw new Exception("02; Char,sGS");
	}
	/**	Dh	11.6.2020
	 * 
	 * @param pMundType
	 * @throws Exception
	 */
	public void setMundType(int pMundType) throws Exception {
		if ((pMundType >= 0) && (pMundType < 4)) MundType = pMundType;
		else throw new Exception("02; Cha,sMT");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pMR
	 * @throws Exception
	 */
	public void setMR(double pMR) throws Exception{
		if (pMR >= 0) MR = pMR;
		else throw new Exception("02; Char,sMR");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pWS
	 * @throws Exception
	 */
	public void setWS(double pWS) throws Exception{
		if (pWS >= 0) WS = pWS;
		else throw new Exception("02; Char,sWS");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pBe
	 * @throws Exception
	 */
	public void setBE(double pBE) throws Exception{
		if (pBE >= 0) BE = pBE;
		else throw new Exception("02; Char,sBe");
	}
	//-----
	/**	Dh	10.2.2020
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
		if ((pInd >= 0) && (pInd < Properties.length)){
			if (pProp >= 0) Properties[pInd] = pProp;
			else throw new Exception("02; Char,sPr");
		}else throw new Exception("07; Char,sPr");
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
		if ((pInd >= 0) && (pInd < Stats.length)){
			if ((pInd == 0) || ((pStat >= 0) && (pInd >= 1))) Stats[pInd] = pStat;
			else throw new Exception("02; Char,sSt");
		}else throw new Exception("07; Char,sSt");
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
	public void setMaxStat(int pMaxStat, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < MaxStats.length)){
			if ((pMaxStat >= 0) || (((pInd == 2) || (pInd==3)) && (pMaxStat == -1))) {
				if ((MaxStats[pInd] == Stats[pInd]) || (((pMaxStat - MaxStats[pInd]) < 0) && ((pMaxStat < Stats[pInd]) && (Stats[pInd] < MaxStats[pInd])))){
					Stats[pInd] = pMaxStat;
				}
				MaxStats[pInd] = pMaxStat;
			}
			else throw new Exception("02; Char,sMS");
		}else throw new Exception("07; Char,sMS");
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
		
		if ((pInd >= 0) && (pInd < Wounds.length)){
			if (pWoundCount >= 0) {
				vWoundDiff = pWoundCount - Wounds[pInd];
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
					addGS(-1*vWoundDiff);
					addFightValue(-1*vWoundDiff, 0);
				}
				if ((pInd == 3) || (pInd == 4)) {
					addPropertie(-2*vWoundDiff, 6);
					addPropertie(-2*vWoundDiff, 7);
				}
				if ((pInd == 6) || (pInd == 7)) {
					addPropertie(-2*vWoundDiff, 5);
					addGS(-1*vWoundDiff);
					addFightValue(-2*vWoundDiff, 0);
				}
				if ((pInd == 6) || (pInd == 7) || (pInd == 3)) {
					addFightValue(-2*vWoundDiff, 1);
					addFightValue(-2*vWoundDiff, 2);
					addFightValue(-2*vWoundDiff, 3);
				}
				
				Wounds[pInd] = pWoundCount;
			}else throw new Exception("02; Char,sWo");
		}else throw new Exception("07; Char,sWo");
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
		if ((pInd >= 0) && (pInd < FightValues.length)){
			if ((pInd == 0) || ((pFightValue >= 0) && (pInd >= 1))) FightValues[pInd] = pFightValue;
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
	public void setRS(double pRS, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < RS.length)){
			if ((pInd == 0) || ((pRS >= 0) && (pInd >= 1))) RS[pInd] = pRS;
			else throw new Exception("02; Char,sRS");
		}else throw new Exception("07; Char,sRS");
	}
	
	/**	Dh 10.2.2020
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
				Properties[i] = pEigen[i];
			}
			break;
		case 9:
			for (int i=0; i < pEigen.length; i++){
				if (pEigen[i] < 0) throw new Exception("02; Char,sPrs");
				if (i < 8) Properties[i] = pEigen[i];
				else GS = pEigen[i];
			}
			break;
		case 10:
			for (int i=0; i < pEigen.length; i++){
				if (pEigen[i] < 0) throw new Exception("02; Char,sPrs");
				if (i < 8) Properties[i] = pEigen[i];
				else if (i == 9)GS = pEigen[i];
				else SO = pEigen[i];
			}
			break;
		default:
			throw new Exception("01; Char,sPrs");
		}
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
		if (pWounds.length == Wounds.length) {
			for (int i=0; i < Wounds.length; i++) {
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
		if ((pWounds.length == Wounds.length) && (pDiceRolls.length == Wounds.length)) {
			for (int i=0; i < Wounds.length; i++) {
				setWound(pWounds[i], i, pDiceRolls[i]);
			}
		} else throw new Exception("01; Char,sWos");
	}
	/**	Dh	10.2.2020
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
	public void setStats(double[] pStati) throws Exception{
		switch(pStati.length){
		case 4:
			for (int i=0; i < pStati.length; i++){
				if (pStati[i] < 0) throw new Exception("02; Char;sSti");
				Stats[i] = (int)pStati[i];
			}
			break;
		case 5:
			for (int i=0; i < pStati.length; i++){
				if (pStati[i] < 0) throw new Exception("02; Char;sSti");
				if (i < 4) Stats[i] = (int)pStati[i];
				else MR = pStati[i];
			}
			break;
		case 6:
			for (int i=0; i < pStati.length; i++){
				if (pStati[i] < 0) throw new Exception("02; Char;sSti");
				if (i < 4) Stats[i] = (int)pStati[i];
				else if (i==4) MR = pStati[i];
				else WS = pStati[i];
			}
			break;
		case 10:
			for (int i=0; i < pStati.length; i++){
				if (pStati[i] < 0) throw new Exception("02; Char;sSti");
				if (i < 4) MaxStats[i] = (int)pStati[i];
				else if (i==4) MR = pStati[i];
				else if (i==5) WS = pStati[i];
				else FightValues[i-6] = pStati[i];
			}
			break;
		default:
			throw new Exception("01; Char;sSti");
		}
	}
	/**	Dh	10.2.2020
	 * 
	 * 	pMaxStati:
	 * 	  0 Lebenspunkte		2 Astralpunkte
	 * 	  1 Ausdauerpunkte		3 Karmalpunkte		
	 * 
	 * @param pMaxStati
	 * @throws Exception
	 */
	public void setMaxStats(int[] pMaxStati) throws Exception{
		if (pMaxStati.length == MaxStats.length){
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
		if (pFightValues.length == FightValues.length){
			for (int i=0; i < pFightValues.length; i++){
				if (pFightValues[i] >= 0) FightValues[i] = pFightValues[i];
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
	public void setRS(double[] pRS) throws Exception{
		if (pRS.length == RS.length){
			for (int i=0; i < pRS.length; i++){
				if (pRS[i] >= 0) RS[i] = pRS[i];
				else throw new Exception("02; Char;sRSs");
			}
		}else throw new Exception("01; Char;sRSs");
	}
	//-----
	/**	Dh	18.6.2020
	 * 
	 * @param pProList
	 * @throws Exception
	 */
	public void setProList(List pProList) throws Exception{
		if (pProList != null){
			if (ProList != null){
				while(!ProList.isEmpty()){
					ProList.toFirst();
					ProList.remove();
				}
			}
				
			ProList = pProList;
		}
		else throw new Exception("04; Char,sPL");
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pSpecialCraftList
	 * @throws Exception
	 */
	public void setSpezialCraftList(List pSpecialCraftList) throws Exception{
		if (pSpecialCraftList != null){
			if (SpecialCraftList != null){
				while(!SpecialCraftList.isEmpty()){
					SpecialCraftList.toFirst();
					SpecialCraftList.remove();
				}
			}
				
			SpecialCraftList = pSpecialCraftList;
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
			if (TalentList != null){
				while(!TalentList.isEmpty()){
					TalentList.toFirst();
					TalentList.remove();
				}
			}
				
			TalentList = pTalentList;
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
			if (WeaponList != null){
				while(!WeaponList.isEmpty()){
					WeaponList.toFirst();
					WeaponList.remove();
				}
			}
			
			pWeaponList.toFirst();
			for (int i=0; i < pWeaponList.getContentNumber(); i++) {
				((Weapon)pWeaponList.getCurrent()).setID(i);
				pWeaponList.next();
			}
			
			WeaponList = pWeaponList;
		} else throw new Exception("04; Char,sWL");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	27.5.2020
	 * 
	 * @param pSO
	 * @throws Exception
	 */
	public void addSO(int pSO) throws Exception{
		if ((pSO >= 0) || ((pSO < 0) && (-pSO <= SO))) SO += pSO;
		else{
			SO = 0;
			throw new Exception("03; Char,aSO");
		}
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pGS
	 * @throws Exception
	 */
	public void addGS(int pGS) throws Exception{
		if ((pGS >= 0) || ((pGS < 0) && (-pGS <= GS))) GS += pGS;
		else{
			GS = 0;
			throw new Exception("03; Char,aGS");
		}
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pMR
	 * @throws Exception
	 */
	public void addMR(double pMR) throws Exception{
		if ((pMR >= 0) || ((pMR < 0) && (-pMR <= MR))) MR += pMR;
		else{
			MR = 0;
			throw new Exception("03; Char,aMR");
		}
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pWS
	 * @throws Exception
	 */
	public void addWS(double pWS) throws Exception{
		if ((pWS >= 0) || ((pWS < 0) && (-pWS < WS))) WS += pWS;
		else{
			WS = 0;
			throw new Exception("03; Char,aWS");
		}
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pBe
	 * @throws Exception
	 */
	public void addBE(double pBE) throws Exception{
		if ((pBE >= 0) || ((pBE < 0) && (-pBE <= BE))) BE += pBE;
		else{
			BE = 0;
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
		if ((pInd >= 0) && (pInd < Properties.length)){
			if ((pProp >= 0) || ((pProp < 0) && (-pProp < Properties[pInd]))) {
				try{ makePropDepChange(pProp, pInd);}
				catch(Exception exc) {throw exc;}
				
				Properties[pInd] += pProp;
			}
			else{
				try{ makePropDepChange(-Properties[pInd], pInd);}
				catch(Exception exc) {throw exc;}
				
				Properties[pInd] = 0;
				throw new Exception("03; Char,aPr");
			}
		}else throw new Exception("07; Char,aPr");
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
		if ((pInd >= 0) && (pInd < Stats.length)){
			if ((pStat >= 0) || ((pStat < 0) && (-pStat < Stats[pInd]))) {
				if ((Stats[pInd] > MaxStats[pInd]) || ((Stats[pInd]+pStat) <= MaxStats[pInd])) Stats[pInd] += pStat;
				else Stats[pInd] = MaxStats[pInd];
			}
			else{
				Stats[pInd] = 0;
				throw new Exception("03; Char,aSt");
			}
		}else throw new Exception("07; Char,aSt");
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
	public void addMaxStat(int pMaxStat, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < MaxStats.length)){
			if ((pMaxStat >= 0) || ((pMaxStat < 0) && (-pMaxStat < MaxStats[pInd]))) {
				if ((MaxStats[pInd] >= Stats[pInd]) && ((MaxStats[pInd]+pMaxStat) < Stats[pInd] )) Stats[pInd] = MaxStats[pInd] + pMaxStat;
				MaxStats[pInd] += pMaxStat;
			}
			else{
				if ((Stats[pInd] > 0) && (Stats[pInd] <= MaxStats[pInd])) Stats[pInd] = 0;
				MaxStats[pInd] = 0;
				throw new Exception("03; Char,aMS");
			}
		}else throw new Exception("07; Char,aMS");
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
		
		if ((pInd >= 0) && (pInd < Wounds.length)){
			if ((Wounds[pInd]+pWound) >= 0) {
				
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
					addGS(-1*pWound);
					addFightValue(-1*pWound, 0);
				}
				if ((pInd == 3) || (pInd == 4)) {
					addPropertie(-2*pWound, 6);
					addPropertie(-2*pWound, 7);
				}
				if ((pInd == 6) || (pInd == 7)) {
					addPropertie(-2*pWound, 5);
					addGS(-1*pWound);
					addFightValue(-2*pWound, 0);
				}
				if ((pInd == 6) || (pInd == 7) || (pInd == 3)) {
					addFightValue(-2*pWound, 1);
					addFightValue(-2*pWound, 2);
					addFightValue(-2*pWound, 3);
				}
				
				Wounds[pInd] += pWound;
			}else throw new Exception("02; Char,sWo");
		}else throw new Exception("07; Char,sWo");
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
		if ((pInd >= 0) && (pInd < FightValues.length)){
			if ((pFightValue >= 0) || ((pFightValue < 0) && (-pFightValue < FightValues[pInd]))) FightValues[pInd] += pFightValue;
			else{
				FightValues[pInd] = 0;
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
	public void addRS(double pRS, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < RS.length)){
			if ((pRS >= 0) || ((pRS < 0) && (-pRS <= RS[pInd]))) RS[pInd] += pRS;
			else{
				RS[pInd] = 0;
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
					else addGS(pEigen[i]);
				} catch(Exception exc) {throw exc;}
			}
			break;
		case 10:
			for (int i=0; i < pEigen.length; i++){
				try{
					if (i < 8) addPropertie(pEigen[i], i);
					else if (i == 9) addGS(pEigen[i]);
					else addSO(pEigen[i]);
				} catch(Exception exc) {throw exc;}
			}
			break;
		default:
			throw new Exception("01; Char,aPrs");
		}
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
	public void addStats(double[] pStati) throws Exception{
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
					else addMR(pStati[i]);
				} catch(Exception exc) {throw exc;}
			}
			break;
		case 6:
			for (int i=0; i < pStati.length; i++){
				try{
					if (i < 4) addStat((int) pStati[i], i);
					else if (i==4) addMR(pStati[i]);
					else addWS(pStati[i]);
				} catch(Exception exc) {throw exc;}
			}
			break;
		case 10:
			for (int i=0; i < pStati.length; i++){
				try{
					if (i < 4) addStat((int) pStati[i], i);
					else if (i==4) addMR(pStati[i]);
					else if (i==5) addWS(pStati[i]);
					else addFightValue(pStati[i], i-6);
				} catch(Exception exc) {throw exc;}
			}
			break;
		default:
			throw new Exception("01; Char;aSti");
		}
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
	public void addMaxStats(int[] pMaxStati) throws Exception{
		if (pMaxStati.length == MaxStats.length){
			for (int i=0; i < pMaxStati.length; i++){
				try{ addMaxStat(pMaxStati[i], i);}
				catch(Exception exc) {throw exc;}
			}
		}else throw new Exception("01; Char;aMSti");
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
		if (pWounds.length == Wounds.length) {
			for (int i=0; i<Wounds.length; i++) {
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
		if ((pWounds.length == Wounds.length) && (pDiceRolls.length == Wounds.length)) {
			for (int i=0; i<Wounds.length; i++) {
				try {addWound(pWounds[i], i, pDiceRolls[i]);}
				catch (Exception ex) {throw ex;}
			}
		}else throw new Exception("01; Char_aWos");
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
		if (pFightValues.length == FightValues.length){
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
	public void addRS(double[] pRS) throws Exception{
		if (pRS.length == RS.length){
			for (int i=0; i < pRS.length; i++){
				try{ RS[i] = pRS[i];}
				catch(Exception exc) {throw exc;}
			}
		}else throw new Exception("01; Char;sRSs");
	}
	//-----
	public void addPros(String pVorteil){
			// Noch implementieren
	}
	public void addSpezialCrafts(String pSonder){
			// Noch implementieren
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pTalent
	 * @throws Exception
	 */
	public void addTalent(Talent pTalent) throws Exception{
		if(pTalent != null) TalentList.append(pTalent);
		else throw new Exception("04; Char,aT");
	}
	/**	Dh	27.5.2020
	 * 
	 * @param pWeapon
	 * @throws Exception
	 */
	public void addWeapon(Weapon pWeapon) throws Exception {
		if(pWeapon != null) {
			pWeapon.setID(WeaponList.getContentNumber());
			WeaponList.append(pWeapon);
		}else throw new Exception("04; Char,aW");
	}
	
	//public void addPros(List pVorteilList){
	//	pVorteilList.toFirst();
	//	while (!pVorteilList.isEnd()){
	//		Pros.append(pVorteilList.getCurrent());
	//		Pros.next();
	//	}
	//}
	//public void addSpezialCrafts(List pSonderList){
	//	pSonderList.toFirst();
	//	while (!pSonderList.isEnd()){
	//		SpezialCrafts.append(pSonderList.getCurrent());
	//		SpezialCrafts.next();
	//	}
	//}
	/**	Dh	10.6.2020
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
				
				if (vCur instanceof Talent) pTalents.append(vCur);
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
					((Weapon)vCur).setID(WeaponList.getContentNumber());
					WeaponList.append(vCur);
				}
				else throw new Exception("06; Char,aWs");
				
				pWeapons.next();
			}
		}else throw new Exception("05; Char,aWs");
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	28.5.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void removeWeapon(int pID) throws Exception{
		Weapon vCur;
		
		if (pID >= 0) {
			if (!WeaponList.isEmpty()) {
				WeaponList.toFirst();
				
				while (!WeaponList.isEnd()){
					vCur = (Weapon)WeaponList.getCurrent();
					
					if (vCur.getID() == pID) {
						WeaponList.remove();
						WeaponList.toLast();
					}
					
					WeaponList.next();
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
			if (!WeaponList.isEmpty()) {
				WeaponList.toFirst();
				
				while (!WeaponList.isEnd()){
					vCur = (Weapon)WeaponList.getCurrent();
					
					if (vCur == pWeapon) {
						WeaponList.remove();
						WeaponList.toLast();
					}
					
					WeaponList.next();
				}
			}else throw new Exception("05; Char,rW");
		}else throw new Exception("04; Char,rW");
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
					else throw new Exception("06; Char,rWes");
					
					pWeapons.next();
				}
			}else throw new Exception("05; Char,rWes");
		}else throw new Exception("04; Char,rWes");
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
			if ((pRegion != -1) && (pRSIgnoring == false))vDmg = vDmg - ((int)Math.round(RS[pRegion]));					// Option mit gRS einbauen.!!!!
			if ((pLethal == false) && (vDmg > (((int)Math.round(WS))-pWSMod))){
				if ( (((int)Math.round(WS))-pWSMod) != 0) vWoundCount = vDmg/(((int)Math.round(WS))-pWSMod);
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
				addMR(pProp/5);
				addFightValue(2*pProp/5, 0);
				addFightValue(pProp/5, 1);
			
				if (MaxStats[2] > 0) addStat(pProp/2, 2);
			} catch(Exception exc) {throw exc;}
			break;
		case 1:
			try { addMR(pProp/5);}
			catch(Exception exc) {throw exc;}
			
			break;
		case 2:
			try{
				addFightValue(pProp/5, 0);
				addFightValue(pProp/5, 2);
				addFightValue(pProp/5, 3);
			
				if (MaxStats[2] > 0) addStat(pProp/2, 2);
			} catch(Exception exc) {throw exc;}
			break;
		case 3:																		// Sonderfertigkeiten Gefäss der Sterne einbauen.
			try{ if (MaxStats[2] > 0) addStat(pProp/2, 2);}
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
				addMR(pProp/5);
				addWS(pProp/2);
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
