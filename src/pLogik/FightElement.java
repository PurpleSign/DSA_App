/**	DSA_App	v0.0	Dh	11.6.2020
 * 
 * 	Logik
 * 	  FightElement
 * 
 * 	Ein Listen-Node-Object, welches die Kampfinformationen fuer eine Kaempfer*In beinhaltet.
 * 		Es speichert die persoehnlichen Eigenschafts- und Status-Modifikatoren, sowie die Liste aller Nachbar*Innen.
 * 		Außedem eine Referenz auf den entsprechenden Charakter. 
 * 		
 * 		Außerdem kann dieses Objekt berechnen, ob die feidne in der Ueberzahl, oder Unterzahl sind, bzw. welche Partei
 * 		dies ist, bzw. nicht ist.
 * 	
 * 	PropMods: 
 * 	  0 Mut					5 Gewandheit
 * 	  1 Klugkheit			6 Konstitution
 * 	  2 Intuition			7 Koerperkraft
 * 	  3 Charisma			8 Geschwindigkeit
 * 	  4 Fingerfertigkeit	9 Sozialstatus
 * 
 * 	StatMods:
 * 	  0 Lebenspunkte		5 Wundschwelle
 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
 * 	  2 Astralpunkte		7 Attack-Basiswert
 * 	  3 Karmalpunkte		8 Parade-Basiswert
 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
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
 */
package pLogik;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import pDataStructures.List;

@XmlRootElement(name = "fightelement")
@XmlSeeAlso({NeighbourElement.class})
@XmlType(propOrder = {"character", "propMods", "statMods", "neighbourList", "activeWeapons"})
public class FightElement {
	private int ID;
	private int[] PropMods;
	private double[] StatMods;
	private List NeighbourList;
	private Weapon[] ActiveWeapons; 
	private Charakter Character;
	
	/**	Dh	28.5.2020
	 */
	public FightElement() {
		ID = -1;
		PropMods = new int[10];
		StatMods = new double[10];
		ActiveWeapons = null;
		Character = null;
		NeighbourList = new List();
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pID
	 * @param pChar
	 * @param pActiveWeapons
	 */
	public FightElement(int pID, Charakter pChar, Weapon[] pActiveWeapons){
		Exception vExc;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; FiEle_a");
		
		if (pChar != null) Character = pChar;
		else vExc = new Exception("04; FiEle_a");
		
		ActiveWeapons = pActiveWeapons;
		PropMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		StatMods = new double[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		NeighbourList = new List();
	}
	/**	Dh	28.5.2020
	 * 
	 * 	PropMods: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * @param pID
	 * @param pChar
	 * @param pActiveWeapons
	 * @param pEigenMod
	 */
	public FightElement(int pID, Charakter pChar, Weapon[] pActiveWeapons, int[] pPropMods){
		Exception vExc;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; FiEle_b");
		
		if (pChar != null) Character = pChar;
		else vExc = new Exception("04; FiEle_b");
		
		ActiveWeapons = pActiveWeapons;
		try{
			if (pPropMods.length == 10){
				pChar.addProperties(pPropMods);
				PropMods = pPropMods;
			}
			else vExc = new Exception("01; FiEle_b");
		} catch(Exception exc) {vExc = exc;}
		StatMods = new double[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		NeighbourList = new List();
	}
	/**	Dh	28.5.2020
	 * 
	 * 	StatMods:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pID
	 * @param pChar
	 * @param pActiveWeapons
	 * @param pStatMod
	 */
	public FightElement(int pID, Charakter pChar, Weapon[] pActiveWeapons, double[] pStatMod){
		Exception vExc;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; FiEle_c");
		
		if (pChar != null) Character = pChar;
		else vExc = new Exception("04; FiEle_c");
		
		ActiveWeapons = pActiveWeapons;
		PropMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		try{
			if (pStatMod.length == 10){
				pChar.addStats(pStatMod);
				StatMods = pStatMod;
			}
			else vExc = new Exception("01; FiEle_c");
		} catch(Exception exc) {vExc = exc;}
		
		
		NeighbourList = new List();
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pID
	 * @param pChar
	 * @param pActiveWeapons
	 * @param pNeighbour
	 */
	public FightElement(int pID, Charakter pChar, Weapon[] pActiveWeapons, List pNeighbours){
		Exception vExc;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; FiEle_d");
		
		if (pChar != null) Character = pChar;
		else vExc = new Exception("04; FiEle_d");
		
		ActiveWeapons = pActiveWeapons;
		PropMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		StatMods = new double[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		if (pNeighbours != null)	NeighbourList = pNeighbours;
		else vExc = new Exception("04; FiEle_d");
	}
	/**	Dh	28.5.2020
	 * 
	 * 	PropMods: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	StatMods:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pID
	 * @param pChar
	 * @param pActiveWeapons
	 * @param pPropMods
	 * @param pStatMod
	 */
	public FightElement(int pID, Charakter pChar, Weapon[] pActiveWeapons, int[] pPropMods, double[] pStatMod){
		Exception vExc;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; FiEle_e");
		
		if (pChar != null) Character = pChar;
		else vExc = new Exception("04; FiEle_e");
		
		ActiveWeapons = pActiveWeapons;
		try{
			if ((pPropMods.length == 10) && (pStatMod.length == 10)){
				pChar.addProperties(pPropMods);
				pChar.addStats(pStatMod);
				PropMods = pPropMods;
				StatMods = pStatMod;
			}
			else vExc = new Exception("01; FiEle_e");
		} catch(Exception exc) {vExc = exc;}
		
		
		NeighbourList = new List();
	}
	/**	Dh	28.5.2020
	 * 
	 * 	PropMods: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * @param pID
	 * @param pChar
	 * @param pActiveWeapons
	 * @param pPropMods
	 * @param pNeighbours
	 */
	public FightElement(int pID, Charakter pChar, Weapon[] pActiveWeapons, int[] pPropMods, List pNeighbours){
		Exception vExc;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; FiEle_f");
		
		if (pChar != null) Character = pChar;
		else vExc = new Exception("04; FiEle_f");
		
		ActiveWeapons = pActiveWeapons;
		try{
			if (pPropMods.length == 10){
				pChar.addProperties(pPropMods);
				PropMods = pPropMods;
			}
			else vExc = new Exception("01; FiEle_f");
		} catch(Exception exc) {vExc = exc;}
		StatMods = new double[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		if (pNeighbours != null)	NeighbourList = pNeighbours;
		else vExc = new Exception("04; FiEle_f");
	}
	/**	Dh	28.5.2020
	 * 
	 * 	StatMods:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pID
	 * @param pChar
	 * @param pActiveWeapons
	 * @param pStatMod
	 * @param pNeighbours
	 */
	public FightElement(int pID, Charakter pChar, Weapon[] pActiveWeapons, double[] pStatMod, List pNeighbours){
		Exception vExc;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; FiEle_g");
		
		if (pChar != null) Character = pChar;
		else vExc = new Exception("04; FiEle_g");
		
		ActiveWeapons = pActiveWeapons;
		PropMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		try{
			if (pStatMod.length == 10){
				pChar.addStats(pStatMod);
				StatMods = pStatMod;
			}
			else vExc = new Exception("01; FiEle_g");
		} catch(Exception exc) {vExc = exc;}
		
		if (pNeighbours != null)	NeighbourList = pNeighbours;
		else vExc = new Exception("04; FiEle_g");
	}
	/**	Dh	28.5.2020
	 * 
	 * 	PropMods: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	StatMods:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pID
	 * @param pChar
	 * @param pActiveWeapons
	 * @param pPropMods
	 * @param pStatMod
	 * @param pNeighbours
	 */
	public FightElement(int pID, Charakter pChar, Weapon[] pActiveWeapons, int[] pPropMods, double[] pStatMod, List pNeighbours){
		Exception vExc;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; FiEle_h");
		
		if (pChar != null) Character = pChar;
		else vExc = new Exception("04; FiEle_h");
		
		ActiveWeapons = pActiveWeapons;
		try{
			if ((pPropMods.length == 10) && (pStatMod.length == 10)){
				pChar.addProperties(pPropMods);
				pChar.addStats(pStatMod);
				PropMods = pPropMods;
				StatMods = pStatMod;
			}
			else vExc = new Exception("01; FiEle_h");
		} catch(Exception exc) {vExc = exc;}
		
		if (pNeighbours != null)	NeighbourList = pNeighbours;
		else vExc = new Exception("04; FiEle_h");
	}
	
	/**	Dh	12.2.2020
	 * 
	 * @throws Exception
	 */
	public void destroyFightElement() throws Exception{
		Character = null;
		
		if (NeighbourList != null){
			while (!NeighbourList.isEmpty()){
				NeighbourList.toFirst();
				NeighbourList.remove();
			}
			NeighbourList = null;
		} else throw new Exception("04; FilEle,dFE");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	30.4.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public int getID(){
		return ID;
	}
	/**	Dh	30.4.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Character")
	public Charakter getCharacter(){
		return Character;
	}
	
	/**	Dh	12.2.2020
	 * 
	 * 	PropMods: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * @param pInd
	 * @return
	 */
	public int getPropMod(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < PropMods.length)){
			return PropMods[pInd];
		}else throw new Exception("07; FiEle,gPM");
	}
	/**	Dh	12.2.2020
	 * 
	 * 	StatMods:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public double getStatMod(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < StatMods.length)){
			return StatMods[pInd];
		}else throw new Exception("07; FiEle,gSM");
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public Weapon getActiveWeapon(int pInd) throws Exception{
		if (ActiveWeapons != null) {
			if ((pInd >= 0) && (pInd < ActiveWeapons.length)){
				return ActiveWeapons[pInd];
			}else throw new Exception("07; FiEle,gAW");
		} else return null;
	}
	
	/**	Dh	12.2.2020
	 * 
	 * 	PropMods: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "PropertieModArray")
	@XmlElement(name = "PropertieMod")
	public int[] getPropMods(){
		return PropMods;
	}
	/**	Dh	12.2.2020
	 * 
	 * 	StatMods:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "StatusModArray")
	@XmlElement(name = "StatusMod")
	public double[] getStatMods(){
		return StatMods;
	}
	/**	Dh	28.5.2020
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "ActiveWaeponArray")
	@XmlElement(name = "ActiveWeapon")
	public Weapon[] getActiveWeapons() {
		return ActiveWeapons;
	}
	
	/**	Dh	11.6.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getActiveWeaponAttackValue(int pInd) throws Exception{
		int vRet = -1;
		Weapon vCurWeapon;
		Fighttalent vCurTalent;
		
		if ((pInd >= 0) && (pInd < ActiveWeapons.length)) {
			vRet = 0;
			
			vCurWeapon = ActiveWeapons[pInd];
			
			if (vCurWeapon != null) {
				vCurTalent = getUsableFightTalent(Character.getTalentList(), vCurWeapon.getWeaponType());
				
				if (vCurWeapon instanceof CloseWeapon) {
					vRet = (int)Character.getFightValue(1)+((CloseWeapon)vCurWeapon).getWM(0);
					
					if (vCurTalent != null) vRet += vCurTalent.getFightValue(0);
				}else{
					vRet = (int)Character.getFightValue(3);
					if (vCurTalent != null) vRet += vCurTalent.getFightValue(0);
				}
			} else throw new Exception("04; FiEle,gAWAV");
		}else throw new Exception("02; FiEle,gAWAV");
		
		return vRet;
	}
	/**	Dh	11.6.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getActiveWeaponDefenceValue(int pInd) throws Exception{
		int vRet = -1;
		Weapon vCurWeapon;
		Fighttalent vCurTalent;
		
		if ((pInd >= 0) && (pInd < ActiveWeapons.length)) {
			vRet = 0;
			vCurWeapon = ActiveWeapons[pInd];
			
			if (vCurWeapon != null) {
				vCurTalent = getUsableFightTalent(Character.getTalentList(), vCurWeapon.getWeaponType());
				
				if (vCurWeapon instanceof CloseWeapon) {
					vRet = (int)Character.getFightValue(2)+((CloseWeapon)vCurWeapon).getWM(1);
					if (vCurTalent != null) vRet += vCurTalent.getFightValue(0);
				}else{
					vRet = (int)Character.getFightValue(2);
				}
			} else throw new Exception("04; FiEle,gAWDV");
		}else throw new Exception("02; FiEle,gAWDV");
		
		return vRet;
	}
	/**	Dh	11.6.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int[] getActiveWeaponFightValues(int pInd) throws Exception {
		int[] vRet = null;
		Weapon vCurWeapon;
		Fighttalent vCurTalent;
		
		if ((pInd >= 0) && (pInd < ActiveWeapons.length)) {
			vRet = new int[] {0, 0};
			vCurWeapon = ActiveWeapons[pInd];
			
			if (vCurWeapon != null) {
				vCurTalent = getUsableFightTalent(Character.getTalentList(), vCurWeapon.getWeaponType());
				
				if (vCurWeapon instanceof CloseWeapon) {
					vRet[0] = (int)Character.getFightValue(1)+((CloseWeapon)vCurWeapon).getWM(0);
					vRet[1] = (int)Character.getFightValue(2)+((CloseWeapon)vCurWeapon).getWM(1);
					if (vCurTalent != null) {
						vRet[0] += vCurTalent.getFightValue(0);
						vRet[1] += vCurTalent.getFightValue(1);
					}
				}else{
					vRet[0] = (int)Character.getFightValue(3);
					vRet[1] = (int)Character.getFightValue(2);
					if (vCurTalent != null) vRet[0] += vCurTalent.getFightValue(0);
				}
			}else throw new Exception("04; FiEle,gAWFV");
		}else throw new Exception("02; FiEle,gAWFV");
		
		return vRet;
	}
	
	/**	Dh	1.5.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public NeighbourElement getNeighbourElement(int pID) throws Exception{
		NeighbourElement vRet = null;
		
		if (pID >= 0){
			if (!NeighbourList.isEmpty()){
				NeighbourList.toFirst();
				while((!NeighbourList.isEnd()) && (vRet == null)){
					NeighbourElement vTemp = (NeighbourElement) NeighbourList.getCurrent();
					if (vTemp.getID() == pID) vRet = vTemp;
					
					NeighbourList.next();
				}
			}
		}
		else throw new Exception("02; FiEle, gNE");
		
		return vRet;
	}
	/**	Dh	13.2.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public NeighbourElement getLastNeighbourElement() throws Exception {
		if (!NeighbourList.isEmpty()){
			NeighbourList.toLast();
			return (NeighbourElement) NeighbourList.getCurrent();
		}
		else throw new Exception("05; FiEle,gLNE");
	}
	/**	Dh	13.2.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "NeighbourList")
	public List getNeighbourList(){
		return NeighbourList;
	}
	
	/**	Dh	13.2.2020
	 * 
	 * 	Gibt die Anzahl an Kampfnachbarn wieder; Unabhaengig ihrer Gesinnung gegenueber der betreffenden Entitaet.
	 * 
	 * @return
	 */
	public int getNeighbourCount(){
		int vRet;
		
		if (!NeighbourList.isEmpty()) vRet =  NeighbourList.getContentNumber();
		else vRet = 0;
		
		return vRet;
	}
	/**	Dh	11.6.2020
	 * 
	 * 	Gibt die Anzahl an Kampfnachbarn an, die der gewaehlten gesinnung entsprechen.
	 * 
	 * @param pEnemy
	 * @return
	 */
	public int getNeighbourCountByType(boolean pEnemy){
		int vRet = 0;
		
		if (!NeighbourList.isEmpty()){
			
			NeighbourList.toFirst();
			while(!NeighbourList.isEnd()){
				if (((NeighbourElement)NeighbourList.getCurrent()).isEnemy() == pEnemy) vRet ++;
				
				NeighbourList.next();
			}
		}
		
		return vRet;
	}
	//-----
	/**	Dh	11.6.2020
	 * 
	 * 	Gibt die Anzhal an Kaempfer*Innen an, mit welchen die gewaehlte Entitaet in Uerbzahl kaempft;
	 * 
	 * 	vRet kann auch negative Werte annehmen, was ein kaempfen in Unterzahl bedeutet.
	 * 
	 * @return
	 */
	public int getNeighbourMajorityNumber() throws Exception{
		int vRet = 1;
		
		if (!NeighbourList.isEmpty()){
			
			NeighbourList.toFirst();
			while(!NeighbourList.isEnd()){
				if (((NeighbourElement)NeighbourList.getCurrent()).isEnemy() == false) vRet ++;
				else vRet --;
				
				NeighbourList.next();
			}
		}
		else throw new Exception("05; FiEle,gNMaN");
		
		return vRet;
	}
	/**	Dh	11.6.2020
	 * 
	 * 	Gibt die Anzahl an Kaempfer*Innen an, mit welchen die gewaehlte Entitaet in Unterzahl gekaempft;
	 * 
	 * 	vRet kann auch negative Werte annehmen, was ein kaempfen in Unterzahl bedeutet.
	 * 
	 * @return
	 */
	public int getNeighbourMinorityNumber() throws Exception{
		int vRet = -1;
		
		if (!NeighbourList.isEmpty()){
			
			NeighbourList.toFirst();
			while(!NeighbourList.isEnd()){
				if (((NeighbourElement)NeighbourList.getCurrent()).isEnemy() == true) vRet ++;
				else vRet --;
				
				NeighbourList.next();
			}
		}
		else throw new Exception("05; FiEle,gNMiN");
		
		return vRet;
	}
	/**	Dh	11.6.2020
	 * 
	 * 	Gibt die Anzahl an Kaempfer*Innen an, mit welchen die durch pEnemy spezifizierte Partei in Ueberzahl kaempft;
	 * 
	 * 	vRet kann auch negative Werte annehmen, was ein kaempfen in Unterzahl bedeutet.
	 * 
	 * @param pEnemy
	 * @return
	 */
	public int getNeighbourMajorityNumberByType(boolean pEnemy) throws Exception{
		int vRet;
		
		if (pEnemy == true) vRet = -1;
		else vRet = 1;
		
		if (!NeighbourList.isEmpty()){
			
			NeighbourList.toFirst();
			while(!NeighbourList.isEnd()){
				if (((NeighbourElement)NeighbourList.getCurrent()).isEnemy() == pEnemy) vRet ++;
				else vRet --;
				
				NeighbourList.next();
			}
		}
		else throw new Exception("05; FiEle,gNMaNBT");
		
		return vRet;
	}
	/**	Dh	11.6.2020
	 * 
	 * 	Gibt die Anzahl an Kaempfer*Innen an, mit welchen die durch pEnemy spezifizierte Partei in Unterzahl kaempft;
	 * 
	 * 	vRet kann auch negative Werte annehmen, was ein kaempfen in Unterzahl bedeutet.
	 * 
	 * @param pEnemy
	 * @return
	 * @throws Exception
	 */
	public int getNeighbourMinorityNumberByType(boolean pEnemy) throws Exception{
		int vRet;
		
		if (pEnemy == true) vRet = 1;
		else vRet = -1;
		
		if (!NeighbourList.isEmpty()){
			
			NeighbourList.toFirst();
			while(!NeighbourList.isEnd()){
				if (((NeighbourElement)NeighbourList.getCurrent()).isEnemy() == !pEnemy) vRet ++;
				else vRet --;
				
				NeighbourList.next();
			}
		}
		else throw new Exception("05; FiEle,gNMiNBT");
		
		return vRet;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	1.5.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void setID(int pID) throws Exception{
		if (pID >= 0) ID = pID;
		else throw new Exception("02; FiEle,sID");
	}
	/**	Dh	1.5.2020
	 * 
	 * @param pChar
	 * @throws Exception
	 */
	public void setCharacter(Charakter pChar) throws Exception{
		if (pChar != null) Character = pChar;
		else throw new Exception("04; FiEle,sCh");
	}
	
	/**	Dh	12.5.2020
	 * 
	 * 	PropMods: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * @param pPropMod
	 * @param pInd
	 * @throws Exception
	 */
	public void setPropMod(int pPropMod, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < PropMods.length)){
			int vTemp = pPropMod - PropMods[pInd];
			PropMods[pInd] = pPropMod;
			try{ 
				if (pInd < 8) Character.addPropertie(vTemp, pInd);
				else if (pInd == 8) Character.addGS(vTemp);
				else Character.addSO(vTemp);
			}
			catch(Exception exc) {throw exc;}
		}else throw new Exception("07; FiEle,sPM");
	}
	/**	Dh	12.2.2020
	 * 
	 * 	StatMods:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pStatMod
	 * @param pInd
	 * @throws Exception
	 */
	public void setStatMod(double pStatMod, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < StatMods.length)){
			double vTemp = pStatMod - StatMods[pInd];
			StatMods[pInd] = pStatMod;
			try{ 
				if (pInd < 4) Character.addStat((int)vTemp, pInd);
				else if (pInd == 4) Character.addMR(vTemp);
				else if (pInd == 5) Character.addWS(vTemp);
				else Character.addFightValue(vTemp, pInd-6);
			}
			catch(Exception exc) {throw exc;}
		}else throw new Exception("07; FiEle,sSM");
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pActiveWeapon
	 * @param pInd
	 * @throws Exception
	 */
	public void setActiveWeapon(Weapon pActiveWeapon, int pInd) throws Exception{
		if (ActiveWeapons != null) {
			if ((pInd >= 0) && (pInd < ActiveWeapons.length)){
				if (pActiveWeapon != null) ActiveWeapons[pInd] = pActiveWeapon;
				else throw new Exception("04; FiEle,sAW");
			}else throw new Exception("07; FiEle,sAW");
		}else if (pInd == 0)ActiveWeapons = new Weapon[] {pActiveWeapon};
	}
	
	/**	Dh	12.2.2020
	 * 
	 * 	PropMods: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * @param pPropMods
	 * @throws Exception
	 */
	public void setPropMods(int[] pPropMods) throws Exception{
		if (pPropMods.length == PropMods.length){
			int[] vTemp = new int[PropMods.length];
			for (int i=0; i<vTemp.length; i++){
				vTemp[i] = pPropMods[i] - PropMods[i];
			}
			try{ Character.addProperties(vTemp);}
			catch(Exception exc) {throw exc;}
			PropMods = pPropMods;
		}else throw new Exception("01; FiEle,sPMs");
	}
	/**	Dh	12.2.2020
	 * 
	 * 	StatMods:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pStatMod
	 * @throws Exception
	 */
	public void setStatMods(double[] pStatMods) throws Exception{
		if (pStatMods.length == StatMods.length){
			double[] vTemp = new double[StatMods.length];
			for (int i=0; i<vTemp.length; i++){
				vTemp[i] = pStatMods[i] - StatMods[i];
			}
			try{ Character.addStats(vTemp);}
			catch(Exception exc) {throw exc;}
			StatMods = pStatMods;
		}else throw new Exception("01; FiEle,sSMs");
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pActiveWeapon
	 * @throws Exception
	 */
	public void setActiveWeapons(Weapon[] pActiveWeapons) throws Exception{
		if (pActiveWeapons != null) ActiveWeapons = pActiveWeapons;
		else throw new Exception("04; FiEle,sAWs");
	}
	
	/**	Dh	23.2.2020
	 * 
	 * @param pNeiList
	 * @throws Exception
	 */
	public void setNeighbourList(List pNeiList) throws Exception{
		Object vTemp;
		
		if (pNeiList != null){
			if (!NeighbourList.isEmpty()){
				while(!NeighbourList.isEmpty()){
					NeighbourList.toFirst();
					NeighbourList.remove();
				}
			}
			
			//pNeiList.toFirst();
			//while(!pNeiList.isEmpty()){
			//	vTemp = pNeiList.getCurrent();
			//	
			//	if (vTemp instanceof NeighbourElement){
			//		if (((NeighbourElement)vTemp).getID() == ID) throw new Exception("02; FiEle,sNL");
			//	} else throw new Exception("06; FiEle,sNL");
			//	
			//	pNeiList.next();
			//}
			
			NeighbourList = pNeiList;
		}
		else throw new Exception("04; FiEle,sNL");
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	12.5.2020
	 * 
	 * 	PropMods: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * @param pPropMod
	 * @param pInd
	 * @throws Exception
	 */
	public void addPropMod(int pPropMod, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < PropMods.length)){
			PropMods[pInd] += pPropMod;
			try{ 
				if (pInd < 8) Character.addPropertie(pPropMod, pInd);
				else if (pInd == 8) Character.addGS(pPropMod);
				else Character.addSO(pPropMod);
			}
			catch(Exception exc) {throw exc;}
		}else throw new Exception("07; FiEle,aPM");
	}
	/**	Dh	12.5.2020
	 * 
	 * 	StatMods:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pStatMod
	 * @param pInd
	 * @throws Exception
	 */
	public void addStatMod(double pStatMod, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < StatMods.length)){
			StatMods[pInd] += pStatMod;
			try{ 
				if (pInd < 4) Character.addStat((int)pStatMod, pInd);
				else if (pInd == 4) Character.addMR(pStatMod);
				else if (pInd == 5) Character.addWS(pStatMod);
				else Character.addFightValue(pStatMod, pInd-6);
			}
			catch(Exception exc) {throw exc;}
		}else throw new Exception("07; FiEle,aSM");
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pActiveWeapon
	 * @throws Exception
	 */
	public void addActiveWeapon(Weapon pActiveWeapon) throws Exception {
		int vOldLength;
		Weapon[] vNewActiveWeapons;
		
		if (pActiveWeapon != null) {
			if (ActiveWeapons != null) {
				vOldLength = ActiveWeapons.length;
				vNewActiveWeapons = new Weapon[vOldLength+1];
				
				for (int i=0; i < vOldLength; i++) {
					vNewActiveWeapons[i] = ActiveWeapons[i];
				}
				vNewActiveWeapons[vOldLength] = pActiveWeapon;
				
				ActiveWeapons = vNewActiveWeapons;
			} else {
				ActiveWeapons = new Weapon[] {pActiveWeapon};
			}
		}else throw new Exception("04; FiEle,aAW");
	}
	
	/**	Dh	12.5.2020
	 * 
	 * 	PropMods: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * @param pPropMods
	 * @throws Exception
	 */
	public void addPropMods(int[] pPropMods) throws Exception{
		if (pPropMods.length == PropMods.length){
			for (int i=0; i<PropMods.length; i++){
				PropMods[i] += pPropMods[i];
			}
			try{ Character.addProperties(pPropMods);}
			catch(Exception exc) {throw exc;}
		}else throw new Exception("01; FiEle,aPM");
	}
	/**	Dh	12.5.2020
	 * 
	 * 	StatMods:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 	
	 * @param pStatMod
	 * @throws Exception
	 */
	public void addStatMods(double[] pStatMods) throws Exception{
		if (pStatMods.length == StatMods.length){
			for (int i=0; i<StatMods.length; i++){
				StatMods[i] += pStatMods[i];
			}
			try{ Character.addStats(pStatMods);}
			catch(Exception exc) {throw exc;}
		}else throw new Exception("01; FiEle,sSM");
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pActiveWeapons
	 * @throws Exception
	 */
	public void addActiveWeapons(Weapon[] pActiveWeapons) throws Exception {
		int vOldLength, vNewLength;
		Weapon[] vNewActiveWeapons;
		
		if (pActiveWeapons != null) {
			if (ActiveWeapons != null) {
				vOldLength = ActiveWeapons.length;
				vNewLength = vOldLength + pActiveWeapons.length;
				vNewActiveWeapons = new Weapon[vNewLength];
				
				for (int i=0; i < vNewLength; i++) {
					if (i < vOldLength) vNewActiveWeapons[i] = ActiveWeapons[i];
					else vNewActiveWeapons[i] = pActiveWeapons[i-vOldLength];
				}
				
				ActiveWeapons = vNewActiveWeapons;
			} else {
				ActiveWeapons = pActiveWeapons;
			}
		}else throw new Exception("04; FiEle,aAWs");
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pActivWeaponList
	 * @throws Exception
	 */
	public void addActiveWeapons(List pActivWeaponList) throws Exception{
		Object pCurWeapon;
		
		if (pActivWeaponList != null) {
			if (!pActivWeaponList.isEmpty()) {
				pActivWeaponList.toFirst();
				
				while(!pActivWeaponList.isLast()) {
					pCurWeapon = pActivWeaponList.getCurrent();
					
					if (pCurWeapon instanceof Weapon) addActiveWeapon((Weapon)pCurWeapon);
					else throw new Exception("06; FiEle,aAWs");
					
					pActivWeaponList.next();
				}
			}throw new Exception("05; FiEle,aAWs");
		}throw new Exception("04; FiEle,aAWs");
	}
	
	/**	Dh	22.5.2020
	 * 
	 * @param pNeiElement
	 * @throws Exception
	 */
	public void addNeighbourElement(NeighbourElement pNeiElement) throws Exception{
		if (pNeiElement != null) {
			if (pNeiElement.getID() != ID) NeighbourList.append(pNeiElement);
			else throw new Exception("02; FiEle,aNE");
		} else throw new Exception("04; FiEle,aNE");
	}
	/**	Dh	22.5.2020
	 * 
	 * @param pNeiList
	 * @throws Exception
	 */
	public void addNeighbourList(List pNeiList) throws Exception{
		Object vTemp;
		
		pNeiList.toFirst();
		while (!pNeiList.isEnd()){
			vTemp = pNeiList.getCurrent();
			if (vTemp instanceof NeighbourElement){
				if (((NeighbourElement)vTemp).getID() != ID) NeighbourList.append(vTemp);
				else throw new Exception("02; FiEle,aNL");
			} else throw new Exception("06; FiEle,aNL");
			pNeiList.next();
		}
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	28.5.2020
	 * 
	 * @param pInd
	 */
	public void removeActiveWeapon(int pInd) throws Exception{
		Weapon[] vNewWeapons;
		
		if ((pInd >= 0) && (pInd < ActiveWeapons.length)) {
			if (ActiveWeapons.length != 1) {
				vNewWeapons = new Weapon[ActiveWeapons.length-1];
				
				for (int i=0; i<vNewWeapons.length; i++) {
					if (i < pInd) vNewWeapons[i] = ActiveWeapons[i];
					else vNewWeapons[i] = ActiveWeapons[i-1];
				}
				
				ActiveWeapons = vNewWeapons;
			} else ActiveWeapons = null;
		} throw new Exception("02; FiEle, rAW");
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pActivWeapon
	 * @throws Exception
	 */
	public void removeActiveWeapon(Weapon pActivWeapon) throws Exception{
		Weapon[] vNewWeapons;
		
		if (pActivWeapon != null) {
			if (ActiveWeapons.length != 1) {
				vNewWeapons = new Weapon[ActiveWeapons.length-1];
				
				for (int i=0; i<vNewWeapons.length; i++) {
					if (ActiveWeapons[i] == pActivWeapon) pActivWeapon = null;
					if (pActivWeapon != null) vNewWeapons[i] = ActiveWeapons[i];
					else vNewWeapons[i] = ActiveWeapons[i+1];
				}
				
				if (pActivWeapon != null) ActiveWeapons = vNewWeapons;
				else throw new Exception("02; FiEle,rAW");
			} else if (ActiveWeapons[0] == pActivWeapon) ActiveWeapons = null;
			else throw new Exception("02; FiEle,rAW");
		} throw new Exception("04; FiEle,rAW");
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pActiveWeapons
	 * @throws Exception
	 */
	public void removeActiveWeapons(Weapon[] pActiveWeapons) throws Exception {	
		if (pActiveWeapons != null) {
			for (int i=0; i<pActiveWeapons.length; i++) {
				removeActiveWeapon(pActiveWeapons[i]);
			}
		}else throw new Exception("04; FiEle,aAWs");
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pActiveWeaponList
	 * @throws Exception
	 */
	public void removeActiveWeapons(List pActiveWeaponList) throws Exception{
		Object vCur;
		
		if (pActiveWeaponList != null) {
			if (!pActiveWeaponList.isEmpty()) {
				pActiveWeaponList.toFirst();
				
				while(!pActiveWeaponList.isEnd()) {
					vCur = pActiveWeaponList.getCurrent();
					
					if (vCur instanceof Integer) removeActiveWeapon((int)vCur);
					else if (vCur instanceof Weapon) removeActiveWeapon((Weapon)vCur);
					else throw new Exception("06; FiEle,rAWs");
					
					pActiveWeaponList.next();
				}
			} else throw new Exception("05; FiEle,rAWs");
		} else throw new Exception("04; FiEle,rAWs");
	}
	
	/**	Dh	23.5.2020
	 * 
	 * 	Loescht das durch pID gegebene NeighbourElement.
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void removeNeighbourElement(int pID) throws Exception {
		NeighbourElement vCur;
		
		if (pID >= 0) {
			if (!NeighbourList.isEmpty()) {
				NeighbourList.toFirst();
				
				while(!NeighbourList.isEnd()) {
					vCur = (NeighbourElement)NeighbourList.getCurrent();
					
					if (pID == vCur.getID()) {
						NeighbourList.remove();
						NeighbourList.toLast();
					}
					
					NeighbourList.next();
				}
			}else throw new Exception("05; FiEle,rNE");
		} else throw new Exception("02; FiEle,rNE");
	}
	/**	Dh	23.5.2020
	 * 
	 * 	Loescht das entsprechende NeighbourElement aus der Liste.
	 * 
	 * @param pNeiEle
	 * @throws Exception
	 */
	public void removeNeighbourElement(NeighbourElement pNeiEle) throws Exception {
		if (pNeiEle != null) {
			if (!NeighbourList.isEmpty()) {
				NeighbourList.deleteElement(pNeiEle);
			}else throw new Exception("05; FiEle,rNE");
		} else throw new Exception("04; FiEle,rNE");
	}
	/**	Dh	23.5.2020
	 * 
	 * 	Loescht alle in pEleList befindlichen Elemente aus der NeighbourList.
	 * 	Die List kann dabei sowolh IDs als auch NeighbourElemente enthalten.
	 * 
	 * @param pEleList
	 * @throws Exception
	 */
	public void removeNeighbourElements(List pEleList) throws Exception {
		Object vCur;
		
		if (pEleList != null) {
			if (!pEleList.isEmpty()) {
				vCur = pEleList.getCurrent();
				
				if (vCur instanceof Integer) removeNeighbourElement((int)vCur);
				else if (vCur instanceof NeighbourElement) removeNeighbourElement((NeighbourElement)vCur);
				else throw new Exception("06; FiEle,rNEs");
			}else throw new Exception("05; FiEle,rNEs");
		} else throw new Exception("04; FiEle,rNEs");
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	16.2.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public boolean hasNeighbourInList(int pID) throws Exception{
		boolean vRet = false;
		
		if (pID >= 0){
			if (!NeighbourList.isEmpty()){
				NeighbourList.toFirst();
				while(!NeighbourList.isEmpty()){
					NeighbourElement vTemp = (NeighbourElement) NeighbourList.getCurrent();
					if (vTemp.getID() == pID) vRet = true;
					
					NeighbourList.next();
				}
			}
		}
		else throw new Exception("02; FiEle,hNIL");
		
		return vRet;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	11.6.2020
	 * 
	 * @param pMod
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int makeAttackWithActiveWeapon(int pMod, int pInd) throws Exception{
		int vRet = -1;
		Weapon vCurWeapon;
		Fighttalent vCurTalent;
		
		if ((pInd >= 0) && (pInd < ActiveWeapons.length)) {
			vCurWeapon = ActiveWeapons[pInd];
			vCurTalent = getUsableFightTalent(Character.getTalentList(), vCurWeapon.getWeaponType());
			
			if (vCurTalent != null) {
				if (vCurWeapon instanceof CloseWeapon) {
					pMod = ((CloseWeapon)vCurWeapon).getWM(0);
					vRet = vCurTalent.makeAttackProbe((int)Math.round(Character.getFightValue(1)), pMod);
				} else if (vCurWeapon instanceof RangeWeapon) vRet = vCurTalent.makeAttackProbe((int)Math.round(Character.getFightValue(3)), pMod);
			}
		} else throw new Exception("02; FiEle,mAwAW");
			
		return vRet;
	}
	/**	Dh	11.6.2020
	 * 	
	 * @param pMod
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int makeDefenceWithActiveWeapon(int pMod, int pInd) throws Exception{
		int vRet = -1;
		Weapon vCurWeapon;
		Fighttalent vCurTalent;
		
		if ((pInd >= 0) && (pInd < ActiveWeapons.length)) {
			vCurWeapon = ActiveWeapons[pInd];
			vCurTalent = getUsableFightTalent(Character.getTalentList(), vCurWeapon.getWeaponType());
			
			if (vCurTalent != null) {
				if (vCurWeapon instanceof CloseWeapon) {
					pMod = ((CloseWeapon)vCurWeapon).getWM(1);
					vRet = vCurTalent.makeAttackProbe((int)Math.round(Character.getFightValue(2)), pMod);
				} else if (vCurWeapon instanceof RangeWeapon) vRet = vCurTalent.makeAttackProbe((int)Math.round(Character.getFightValue(2)), pMod);
			}
		} else throw new Exception("02; FiEle,mAwAW");
			
		return vRet;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	10.6.2020
	 * 
	 * @param pTalentList
	 * @param pWeaponType
	 * @return
	 * @throws Exception
	 */
	private Fighttalent getUsableFightTalent(List pTalentList, int pWeaponType) throws Exception{
		int[] vCurType;
		Talent vCur;
		Fighttalent vRet = null;
		
		if (!pTalentList.isEmpty()) {
			 if ((pWeaponType >= 0) && (pWeaponType <= 26 )) {
				 
				 for (int i=0; i<4; i++) {
					 pTalentList.toFirst();
					 
					 while(!pTalentList.isEnd()) {
						 vCur = (Talent)pTalentList.getCurrent();
						 
						 if (vCur instanceof Fighttalent) {
							 vCurType = ((Fighttalent)vCur).getUsableWeaponType();
							 
							 if ((i < vCurType.length) && (vCurType[i] == pWeaponType)) {
								 vRet = (Fighttalent)vCur;
								 pTalentList.toLast();
								 i=4;
							 }
						 }
						 
						 pTalentList.next();
					 }
				 }
			 } else throw new Exception("02; FiEle,gUFT");
		} else throw new Exception("04; FiEle,gUFT");
		
		return vRet;
	}
}
