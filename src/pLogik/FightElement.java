/**	DSA_App	v0.0	Dh	17.7.2020
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
 * 	UsedType:
 * 	  0: Natuerlich		 3: Linkhand
 * 	  1: Haupthand		 4: Schild
 * 	  2: Nebenhand
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
	private int id;
	private int[] propMods, statMods;
	private List neighbourList;
	private Object[][] activeWeapons; 
	private Charakter character;
	
	/**	Dh	28.5.2020
	 */
	public FightElement() {
		id = -1;
		propMods = new int[10];
		statMods = new int[10];
		activeWeapons = null;
		character = null;
		neighbourList = new List();
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand 
	 * 
	 * @param pID
	 * @param pChar
	 * @param pActiveWeapons
	 */
	public FightElement(int pID, Charakter pChar, Object[][] pActiveWeapons){
		Exception vExc;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; FiEle_a");
		
		if (pChar != null) character = pChar;
		else vExc = new Exception("04; FiEle_a");
		
		try{setActiveWeapons(pActiveWeapons);}
		catch(Exception ex) {vExc = ex;}
		propMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		statMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		neighbourList = new List();
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand 
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
	public FightElement(int pID, Charakter pChar, Object[][] pActiveWeapons, int[] pPropMods){
		Exception vExc;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; FiEle_b");
		
		if (pChar != null) character = pChar;
		else vExc = new Exception("04; FiEle_b");
		
		try{setActiveWeapons(pActiveWeapons);}
		catch(Exception ex) {vExc = ex;}
		try{
			if (pPropMods.length == 10){
				pChar.addProperties(pPropMods);
				propMods = pPropMods;
			}
			else vExc = new Exception("01; FiEle_b");
		} catch(Exception exc) {vExc = exc;}
		statMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		neighbourList = new List();
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand 
	 * 
	 * @param pID
	 * @param pChar
	 * @param pActiveWeapons
	 * @param pNeighbour
	 */
	public FightElement(int pID, Charakter pChar, Object[][] pActiveWeapons, List pNeighbours){
		Exception vExc;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; FiEle_c");
		
		if (pChar != null) character = pChar;
		else vExc = new Exception("04; FiEle_c");
		
		try{setActiveWeapons(pActiveWeapons);}
		catch(Exception ex) {vExc = ex;}
		propMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		statMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		if (pNeighbours != null)	neighbourList = pNeighbours;
		else vExc = new Exception("04; FiEle_c");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand 
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
	public FightElement(int pID, Charakter pChar, Object[][] pActiveWeapons, int[] pPropMods, int[] pStatMod){
		Exception vExc;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; FiEle_d");
		
		if (pChar != null) character = pChar;
		else vExc = new Exception("04; FiEle_d");
		
		try{setActiveWeapons(pActiveWeapons);}
		catch(Exception ex) {vExc = ex;}
		try{
			if ((pPropMods.length == 10) && (pStatMod.length == 10)){
				pChar.addProperties(pPropMods);
				pChar.addStats(pStatMod);
				propMods = pPropMods;
				statMods = pStatMod;
			}
			else vExc = new Exception("01; FiEle_d");
		} catch(Exception exc) {vExc = exc;}
		
		
		neighbourList = new List();
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand 
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
	public FightElement(int pID, Charakter pChar, Object[][] pActiveWeapons, int[] pPropMods, List pNeighbours){
		Exception vExc;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; FiEle_e");
		
		if (pChar != null) character = pChar;
		else vExc = new Exception("04; FiEle_e");
		
		try{setActiveWeapons(pActiveWeapons);}
		catch(Exception ex) {vExc = ex;}
		try{
			if (pPropMods.length == 10){
				pChar.addProperties(pPropMods);
				propMods = pPropMods;
			}
			else vExc = new Exception("01; FiEle_e");
		} catch(Exception exc) {vExc = exc;}
		statMods = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		if (pNeighbours != null)	neighbourList = pNeighbours;
		else vExc = new Exception("04; FiEle_e");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand 
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
	public FightElement(int pID, Charakter pChar, Object[][] pActiveWeapons, int[] pPropMods, int[] pStatMod, List pNeighbours){
		Exception vExc;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; FiEle_f");
		
		if (pChar != null) character = pChar;
		else vExc = new Exception("04; FiEle_f");
		
		try{setActiveWeapons(pActiveWeapons);}
		catch(Exception ex) {vExc = ex;}
		try{
			if ((pPropMods.length == 10) && (pStatMod.length == 10)){
				pChar.addProperties(pPropMods);
				pChar.addStats(pStatMod);
				propMods = pPropMods;
				statMods = pStatMod;
			}
			else vExc = new Exception("01; FiEle_f");
		} catch(Exception exc) {vExc = exc;}
		
		if (pNeighbours != null)	neighbourList = pNeighbours;
		else vExc = new Exception("04; FiEle_f");
	}
	
	/**	Dh	12.2.2020
	 * 
	 * @throws Exception
	 */
	public void destroyFightElement() throws Exception{
		character = null;
		
		if (neighbourList != null){
			while (!neighbourList.isEmpty()){
				neighbourList.toFirst();
				neighbourList.remove();
			}
			neighbourList = null;
		} else throw new Exception("04; FilEle,dFE");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	30.4.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public int getId(){
		return id;
	}
	/**	Dh	30.4.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Character")
	public Charakter getCharacter(){
		return character;
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
		if ((pInd >= 0) && (pInd < propMods.length)){
			return propMods[pInd];
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
		if ((pInd >= 0) && (pInd < statMods.length)){
			return statMods[pInd];
		}else throw new Exception("07; FiEle,gSM");
	}
	/**	Dh	17.7.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public Weapon getActiveWeapon(int pID) throws Exception{
		Weapon vRet = null;
		
		if (pID >= 0){
			if (activeWeapons != null) {
				for (int i=0; (i < activeWeapons.length) && (vRet == null); i++) {
					if ( ((Weapon)activeWeapons[i][0]).getId() == pID ) vRet = (Weapon)activeWeapons[i][0];
				}
			}
		}else throw new Exception("02; FiEle,gAW");
		
		return vRet;
	}
	/**	Dh	17.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getActiveWeaponUseType(int pID) throws Exception{
		int vRet = -1;
		
		if (pID >= 0){
			if (activeWeapons != null) {
				for (int i=0; (i < activeWeapons.length) && (vRet == -1); i++) {
					if ( ((Weapon)activeWeapons[i][0]).getId() == pID ) vRet = (int)activeWeapons[i][1];
				}
			}
		}else throw new Exception("02; FiEle,gAW");
		
		return vRet;
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
		return propMods;
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
	public int[] getStatMods(){
		return statMods;
	}
	/**	Dh	15.7.2020
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "ActiveWaeponArray")
	@XmlElement(name = "ActiveWeapon")
	public Object[][] getActiveWeapons() {
		return activeWeapons;
	}
	
	/**	Dh	15.7.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getActiveWeaponAttackValue(int pInd) throws Exception{
		int vRet = -1;
		Weapon vCurWeapon;
		Fighttalent vCurTalent;
		
		if ((pInd >= 0) && (pInd < activeWeapons.length)) {
			vRet = 0;
			
			vCurWeapon = (Weapon)activeWeapons[pInd][0];
			
			if (vCurWeapon != null) {
				vCurTalent = getUsableFightTalent(character.getTalentList(), vCurWeapon.getWeaponType());
				
				if (vCurWeapon instanceof CloseWeapon) {
					vRet = (int)character.getFightValue(1)+((CloseWeapon)vCurWeapon).getWm(0);
					
					if (vCurTalent != null) vRet += vCurTalent.getFightValue(0);
				}else{
					vRet = (int)character.getFightValue(3);
					if (vCurTalent != null) vRet += vCurTalent.getFightValue(0);
				}
			} else throw new Exception("04; FiEle,gAWAV");
		}else throw new Exception("02; FiEle,gAWAV");
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getActiveWeaponDefenceValue(int pInd) throws Exception{
		int vRet = -1;
		Weapon vCurWeapon;
		Fighttalent vCurTalent;
		
		if ((pInd >= 0) && (pInd < activeWeapons.length)) {
			vRet = 0;
			vCurWeapon = (Weapon)activeWeapons[pInd][0];
			
			if (vCurWeapon != null) {
				vCurTalent = getUsableFightTalent(character.getTalentList(), vCurWeapon.getWeaponType());
				
				if (vCurWeapon instanceof CloseWeapon) {
					vRet = (int)character.getFightValue(2)+((CloseWeapon)vCurWeapon).getWm(1);
					if (vCurTalent != null) vRet += vCurTalent.getFightValue(0);
				}else{
					vRet = (int)character.getFightValue(2);
				}
			} else throw new Exception("04; FiEle,gAWDV");
		}else throw new Exception("02; FiEle,gAWDV");
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int[] getActiveWeaponFightValues(int pInd) throws Exception {
		int[] vRet = null;
		Weapon vCurWeapon;
		Fighttalent vCurTalent;
		
		if ((pInd >= 0) && (pInd < activeWeapons.length)) {
			vRet = new int[] {0, 0};
			vCurWeapon = (Weapon)activeWeapons[pInd][0];
			
			if (vCurWeapon != null) {
				vCurTalent = getUsableFightTalent(character.getTalentList(), vCurWeapon.getWeaponType());
				
				if (vCurWeapon instanceof CloseWeapon) {
					vRet[0] = (int)character.getFightValue(1)+((CloseWeapon)vCurWeapon).getWm(0);
					vRet[1] = (int)character.getFightValue(2)+((CloseWeapon)vCurWeapon).getWm(1);
					if (vCurTalent != null) {
						vRet[0] += vCurTalent.getFightValue(0);
						vRet[1] += vCurTalent.getFightValue(1);
					}
				}else{
					vRet[0] = (int)character.getFightValue(3);
					vRet[1] = (int)character.getFightValue(2);
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
			if (!neighbourList.isEmpty()){
				neighbourList.toFirst();
				while((!neighbourList.isEnd()) && (vRet == null)){
					NeighbourElement vTemp = (NeighbourElement) neighbourList.getCurrent();
					if (vTemp.getId() == pID) vRet = vTemp;
					
					neighbourList.next();
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
		if (!neighbourList.isEmpty()){
			neighbourList.toLast();
			return (NeighbourElement) neighbourList.getCurrent();
		}
		else throw new Exception("05; FiEle,gLNE");
	}
	/**	Dh	13.2.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "NeighbourList")
	public List getNeighbourList(){
		return neighbourList;
	}
	
	/**	Dh	13.2.2020
	 * 
	 * 	Gibt die Anzahl an Kampfnachbarn wieder; Unabhaengig ihrer Gesinnung gegenueber der betreffenden Entitaet.
	 * 
	 * @return
	 */
	public int getNeighbourCount(){
		int vRet;
		
		if (!neighbourList.isEmpty()) vRet =  neighbourList.getContentNumber();
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
		
		if (!neighbourList.isEmpty()){
			
			neighbourList.toFirst();
			while(!neighbourList.isEnd()){
				if (((NeighbourElement)neighbourList.getCurrent()).isEnemy() == pEnemy) vRet ++;
				
				neighbourList.next();
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
		
		if (!neighbourList.isEmpty()){
			
			neighbourList.toFirst();
			while(!neighbourList.isEnd()){
				if (((NeighbourElement)neighbourList.getCurrent()).isEnemy() == false) vRet ++;
				else vRet --;
				
				neighbourList.next();
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
		
		if (!neighbourList.isEmpty()){
			
			neighbourList.toFirst();
			while(!neighbourList.isEnd()){
				if (((NeighbourElement)neighbourList.getCurrent()).isEnemy() == true) vRet ++;
				else vRet --;
				
				neighbourList.next();
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
		
		if (!neighbourList.isEmpty()){
			
			neighbourList.toFirst();
			while(!neighbourList.isEnd()){
				if (((NeighbourElement)neighbourList.getCurrent()).isEnemy() == pEnemy) vRet ++;
				else vRet --;
				
				neighbourList.next();
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
		
		if (!neighbourList.isEmpty()){
			
			neighbourList.toFirst();
			while(!neighbourList.isEnd()){
				if (((NeighbourElement)neighbourList.getCurrent()).isEnemy() == !pEnemy) vRet ++;
				else vRet --;
				
				neighbourList.next();
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
	public void setId(int pID) throws Exception{
		if (pID >= 0) id = pID;
		else throw new Exception("02; FiEle,sID");
	}
	/**	Dh	1.5.2020
	 * 
	 * @param pChar
	 * @throws Exception
	 */
	public void setCharacter(Charakter pChar) throws Exception{
		if (pChar != null) character = pChar;
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
		if ((pInd >= 0) && (pInd < propMods.length)){
			int vTemp = pPropMod - propMods[pInd];
			propMods[pInd] = pPropMod;
			try{ 
				if (pInd < 8) character.addPropertie(vTemp, pInd);
				else if (pInd == 8) character.addGs(vTemp);
				else character.addSo(vTemp);
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
	public void setStatMod(int pStatMod, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < statMods.length)){
			double vTemp = pStatMod - statMods[pInd];
			statMods[pInd] = pStatMod;
			try{ 
				if (pInd < 4) character.addStat((int)vTemp, pInd);
				else if (pInd == 4) character.addMr(vTemp);
				else if (pInd == 5) character.addWs(vTemp);
				else character.addFightValue(vTemp, pInd-6);
			}
			catch(Exception exc) {throw exc;}
		}else throw new Exception("07; FiEle,sSM");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand 
	 * 
	 * @param pActiveWeapon
	 * @param pInd
	 * @throws Exception
	 */
	public void setActiveWeapon(Weapon pActiveWeapon, int pUseType, int pInd) throws Exception{
		if (pActiveWeapon != null) {
			if ((pUseType >= 0) && (pUseType < 5)) {
				if (((pUseType == 1) && (!havePrimaryWeapon())) || (((pUseType == 2) || (pUseType == 3) || (pUseType == 4)) && (!haveAnySecondaryWeapon() && !haveTwoHandedWeapon()))) {
					if (activeWeapons != null) {
						if ((pInd >= 0) && (pInd < activeWeapons.length)) activeWeapons[pInd] = new Object[] {pActiveWeapon, pUseType};
						else throw new Exception("07; FiEle,sAW");
					}else {
						if (pInd == 0) activeWeapons = new Object[][] {{pActiveWeapon, pUseType}};
						else throw new Exception("07; FiEle,sAW");
					}
				} else throw new Exception("02; FiEle,sAW_b");
			} else throw new Exception("02; FiEle,sAW");
		} else throw new Exception("04; FiEle,sAW");
	}
	/**	Dh	17.7.2020
	 * 
	 * @param pID
	 * @param pUseType
	 * @throws Exception
	 */
	public void setActiveWeaponUseType(int pID, int pUseType) throws Exception{
		if ((pID >= 0) && (pUseType >= 0) && (pUseType < 5)) {
			if (activeWeapons != null) {
				for (int i=0; (i < activeWeapons.length) && (pID != -1); i++) {
					if (((Weapon)activeWeapons[i][0]).getId() == pID) {
						if (((pUseType == 1) && (!havePrimaryWeapon())) || (((pUseType == 2) || (pUseType == 3) || (pUseType == 4)) && (!haveAnySecondaryWeapon() && !haveTwoHandedWeapon())))
							activeWeapons[i][1] = pUseType;
						else throw new Exception("02; FiEle,sAWUT_a");
					}
				}
			}
		}else throw new Exception("02; FiEle,sAWUT");
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
		if (pPropMods.length == propMods.length){
			int[] vTemp = new int[propMods.length];
			for (int i=0; i<vTemp.length; i++){
				vTemp[i] = pPropMods[i] - propMods[i];
			}
			try{ character.addProperties(vTemp);}
			catch(Exception exc) {throw exc;}
			propMods = pPropMods;
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
	public void setStatMods(int[] pStatMods) throws Exception{
		if (pStatMods.length == statMods.length){
			int[] vTemp = new int[statMods.length];
			for (int i=0; i<vTemp.length; i++){
				vTemp[i] = pStatMods[i] - statMods[i];
			}
			try{ character.addStats(vTemp);}
			catch(Exception exc) {throw exc;}
			statMods = pStatMods;
		}else throw new Exception("01; FiEle,sSMs");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand 
	 * 
	 * @param pActiveWeapon
	 * @throws Exception
	 */
	public void setActiveWeapons(Object[][] pActiveWeapons) throws Exception{
		boolean vIsRightType = true;
		
		if (pActiveWeapons != null) {
			for (int i=0; (i < pActiveWeapons.length) && (vIsRightType == true); i++) {
				if (pActiveWeapons[i].length == 2) {
					if ((pActiveWeapons[i][0] instanceof Weapon) && (pActiveWeapons[i][1] instanceof Integer)) {
						if ((pActiveWeapons[i][0] == null) || ((((int)pActiveWeapons[i][1]) < 0) || (((int)pActiveWeapons[i][1]) > 4)) ) vIsRightType = false;
					}else {
						vIsRightType = false;
						throw new Exception("06; FiEle,sAWs");
					}
				} else {
					vIsRightType = false;
					throw new Exception("01; FiEle,sAWs");
				}
			}
			
			if (vIsRightType == true) activeWeapons = pActiveWeapons.clone();
			else throw new Exception("02; FiEle,sAWs");
		}else throw new Exception("04; FiEle,sAWs");
	}
	
	/**	Dh	23.2.2020
	 * 
	 * @param pNeiList
	 * @throws Exception
	 */
	public void setNeighbourList(List pNeiList) throws Exception{
		Object vTemp;
		
		if (pNeiList != null){
			if (!neighbourList.isEmpty()){
				while(!neighbourList.isEmpty()){
					neighbourList.toFirst();
					neighbourList.remove();
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
			
			neighbourList = pNeiList;
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
		if ((pInd >= 0) && (pInd < propMods.length)){
			propMods[pInd] += pPropMod;
			try{ 
				if (pInd < 8) character.addPropertie(pPropMod, pInd);
				else if (pInd == 8) character.addGs(pPropMod);
				else character.addSo(pPropMod);
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
		if ((pInd >= 0) && (pInd < statMods.length)){
			statMods[pInd] += pStatMod;
			try{ 
				if (pInd < 4) character.addStat((int)pStatMod, pInd);
				else if (pInd == 4) character.addMr(pStatMod);
				else if (pInd == 5) character.addWs(pStatMod);
				else character.addFightValue(pStatMod, pInd-6);
			}
			catch(Exception exc) {throw exc;}
		}else throw new Exception("07; FiEle,aSM");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pActiveWeapon
	 * @throws Exception
	 */
	public void addActiveWeapon(Weapon pActiveWeapon, int pUseType) throws Exception {
		int vOldLength;
		Object[][] vNewActiveWeapons;
		
		if (pActiveWeapon != null) {
			if (activeWeapons != null) {
				if (((pUseType == 1) && (!havePrimaryWeapon())) || (((pUseType == 2) || (pUseType == 3) || (pUseType == 4)) && (!haveAnySecondaryWeapon()))) {
					vOldLength = activeWeapons.length;
					vNewActiveWeapons = new Object[vOldLength+1][];
					
					for (int i=0; i < vOldLength; i++) {
						vNewActiveWeapons[i] = activeWeapons[i];
					}
					vNewActiveWeapons[vOldLength] = new Object[] {pActiveWeapon, pUseType};
					activeWeapons = vNewActiveWeapons.clone();
				} else throw new Exception("02; FiEle,aAW");
			} else activeWeapons = new Object[][] {{pActiveWeapon, pUseType}};
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
		if (pPropMods.length == propMods.length){
			for (int i=0; i<propMods.length; i++){
				propMods[i] += pPropMods[i];
			}
			try{ character.addProperties(pPropMods);}
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
	public void addStatMods(int[] pStatMods) throws Exception{
		if (pStatMods.length == statMods.length){
			for (int i=0; i<statMods.length; i++){
				statMods[i] += pStatMods[i];
			}
			try{ character.addStats(pStatMods);}
			catch(Exception exc) {throw exc;}
		}else throw new Exception("01; FiEle,sSM");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pActiveWeapons
	 * @throws Exception
	 */
	public void addActiveWeapons(Object[][] pActiveWeapons) throws Exception {
		if (pActiveWeapons != null) {
			for (int i=0; i < pActiveWeapons.length; i++) {
				if (pActiveWeapons[i].length == 2) {
					if ((pActiveWeapons[i][0] instanceof Weapon) && (pActiveWeapons[i][1] instanceof Integer)) 
						addActiveWeapon((Weapon)pActiveWeapons[i][0], (int)pActiveWeapons[i][1]);
					else throw new Exception("06; FiEle,aAWs");
				} else throw new Exception("01; FiEle,aAWs");
			}
		}else throw new Exception("04; FiEle,aAWs");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pActivWeaponList
	 * @throws Exception
	 */
	public void addActiveWeapons(List pActivWeaponList) throws Exception{
		Object[] pCurWeapon;
		
		if (pActivWeaponList != null) {
			if (!pActivWeaponList.isEmpty()) {
				pActivWeaponList.toFirst();
				
				while(!pActivWeaponList.isLast()) {
					pCurWeapon = (Object[]) pActivWeaponList.getCurrent();
					
					if (pCurWeapon.length == 2) {
						if ((pCurWeapon[0] instanceof Weapon) && (pCurWeapon[1] instanceof Integer)) addActiveWeapon((Weapon)pCurWeapon[0], (int)pCurWeapon[1]);
						else throw new Exception("06; FiEle,aAWs");
					}else throw new Exception("01; FiEle,aWas");
					
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
			if (pNeiElement.getId() != id) neighbourList.append(pNeiElement);
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
				if (((NeighbourElement)vTemp).getId() != id) neighbourList.append(vTemp);
				else throw new Exception("02; FiEle,aNL");
			} else throw new Exception("06; FiEle,aNL");
			pNeiList.next();
		}
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	16.7.2020
	 * 
	 * @param pInd
	 */
	public void removeActiveWeapon(int pID) throws Exception{
		Object[][] vNewWeapons;
		
		if ((pID >= 0)) {
			if (activeWeapons.length != 1) {
				vNewWeapons = new Object[activeWeapons.length-1][];
				
				for (int i=0; i<vNewWeapons.length; i++) {
					if (pID == -1) vNewWeapons[i] = activeWeapons[i-1];
					else {
						
					}
					
					if (((Weapon)activeWeapons[i][0]).getId() == pID) {
						vNewWeapons[i] = activeWeapons[i+1];
						pID = -1;
					}else if (pID != -1) vNewWeapons[i] = activeWeapons[i];
					else vNewWeapons[i] = activeWeapons[i+1];
				}
				
				activeWeapons = vNewWeapons.clone();
			} else activeWeapons = null;
		} else throw new Exception("02; FiEle,rAW");
	}
	/**	Dh	15.7.2020
	 * 
	 * @param pActivWeapon
	 * @throws Exception
	 */
	public void removeActiveWeapon(Weapon pActivWeapon) throws Exception{
		Object[][] vNewWeapons;
		
		if (pActivWeapon != null) {
			if (activeWeapons.length != 1) {
				vNewWeapons = new Object[activeWeapons.length-1][];
				
				for (int i=0; i<vNewWeapons.length; i++) {
					if (activeWeapons[i][0] == pActivWeapon) pActivWeapon = null;
					if (pActivWeapon != null) vNewWeapons[i] = activeWeapons[i];
					else vNewWeapons[i] = activeWeapons[i+1];
				}
				
				if (pActivWeapon != null) activeWeapons = vNewWeapons;
				else throw new Exception("02; FiEle,rAW");
			} else if (activeWeapons[0][0] == pActivWeapon) activeWeapons = new Object[][] {{}};
			else throw new Exception("02; FiEle,rAW");
		} throw new Exception("04; FiEle,rAW");
	}
	//-----
	/**	Dh	15.7.2020
	 * 
	 * @param pUseType
	 * @throws Exception
	 */
	public void removeActiveWeaponByUseType(int pUseType) throws Exception {
		Object[][] vNewWeapons;
		
		if ((pUseType >= 0) && (pUseType < 5)) {
			if (activeWeapons.length != 1) {
				vNewWeapons = new Object[activeWeapons.length-1][];
				
				for (int i=0; i<vNewWeapons.length; i++) {
					if (((int)activeWeapons[i][1]) == pUseType) pUseType = -1;
					if (pUseType != -1) vNewWeapons[i] = activeWeapons[i];
					else vNewWeapons[i] = activeWeapons[i+1];
				}
				
				if (pUseType == -1) activeWeapons = vNewWeapons;
				else throw new Exception("02; FiEle,rAW");
			} else if (((int)activeWeapons[0][1]) == pUseType) activeWeapons = new Object[][] {{}};
			else throw new Exception("02; FiEle,rAW");
		} throw new Exception("02; FiEle,rAW");
	}
	//-----
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
			if (!neighbourList.isEmpty()) {
				neighbourList.toFirst();
				
				while(!neighbourList.isEnd()) {
					vCur = (NeighbourElement)neighbourList.getCurrent();
					
					if (pID == vCur.getId()) {
						neighbourList.remove();
						neighbourList.toLast();
					}
					
					neighbourList.next();
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
			if (!neighbourList.isEmpty()) {
				neighbourList.deleteElement(pNeiEle);
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
	
	/**	Dh	16.7.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public boolean haveWeaponActive(int pID) throws Exception{
		boolean vRet = false;
		
		if (pID >= 0) {
			if (activeWeapons != null) {
				for (int i=0; (i<activeWeapons.length) && (vRet == false); i++) {
					if (activeWeapons[i] != null) {
						if (((Weapon)activeWeapons[i][0]).getId() == pID) vRet = true;
					}
				}
			} 
		}else throw new Exception("02; FiEle,hWA");
		
		return vRet;
	}
	
	/**	Dh	17.7.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean haveTwoHandedWeapon() throws Exception{
		boolean vRet = false;
		int vWeaponType = -1;
		
		if (activeWeapons != null) {
			for (int i=0; (i < activeWeapons.length) && (vRet == false); i++) {
				if (activeWeapons[i] != null) {
					vWeaponType = ((Weapon)activeWeapons[i][0]).getWeaponType();
					
					if ((vWeaponType == 2) || (vWeaponType == 6) || (vWeaponType == 7) || (vWeaponType == 8) || ((vWeaponType >= 12) && (vWeaponType <= 16)) ||
							(vWeaponType == 18) || (vWeaponType == 19) || (vWeaponType == 20) || (vWeaponType == 22) || (vWeaponType == 25)) vRet = true;
				}else throw new Exception("04; FiEle,hTHW");
			}
		}
		
		return vRet;
	}
	
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pUseType
	 * @return
	 * @throws Exception
	 */
	public boolean haveActiveWeaponUseType(int pUseType) throws Exception{
		boolean vRet = false;
		
		if ((pUseType >= 0) && (pUseType < 5)) {
			if (activeWeapons != null) {
				for (int i=0; (i < activeWeapons.length) && (vRet == false); i++) {
					if (((int)activeWeapons[i][1]) == pUseType) vRet = true;
				}
			}
		} else throw new Exception("02; FiEle,hAWUT");
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * @return
	 */
	public boolean havePrimaryWeapon() {
		boolean vRet = false;
		
		try {vRet = haveActiveWeaponUseType(1);}
		catch(Exception ex){}
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * @return
	 */
	public boolean haveSecondaryWeapon() {
		boolean vRet = false;
		
		try {vRet = haveActiveWeaponUseType(2);}
		catch(Exception ex){}
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * @return
	 */
	public boolean haveParryWeapon() {
		boolean vRet = false;
		
		try {vRet = haveActiveWeaponUseType(3);}
		catch(Exception ex){}
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * @return
	 */
	public boolean haveShield() {
		boolean vRet = false;
		
		try {vRet = haveActiveWeaponUseType(4);}
		catch(Exception ex){}
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * @return
	 */
	public boolean haveAnySecondaryWeapon() {
		boolean vRet = false;
		
		try {vRet = (haveSecondaryWeapon() || haveParryWeapon() || haveShield());}
		catch(Exception ex){}
		
		return vRet;
	}
	
	/**	Dh	16.2.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public boolean hasNeighbourInList(int pID) throws Exception{
		boolean vRet = false;
		
		if (pID >= 0){
			if (!neighbourList.isEmpty()){
				neighbourList.toFirst();
				while(!neighbourList.isEmpty()){
					NeighbourElement vTemp = (NeighbourElement) neighbourList.getCurrent();
					if (vTemp.getId() == pID) vRet = true;
					
					neighbourList.next();
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
		
		if ((pInd >= 0) && (pInd < activeWeapons.length)) {
			vCurWeapon = (Weapon)activeWeapons[pInd][0];
			vCurTalent = getUsableFightTalent(character.getTalentList(), vCurWeapon.getWeaponType());
			
			if (vCurTalent != null) {
				if (vCurWeapon instanceof CloseWeapon) {
					pMod = ((CloseWeapon)vCurWeapon).getWm(0);
					vRet = vCurTalent.makeAttackProbe((int)Math.round(character.getFightValue(1)), pMod);
				} else if (vCurWeapon instanceof RangeWeapon) vRet = vCurTalent.makeAttackProbe((int)Math.round(character.getFightValue(3)), pMod);
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
		
		if ((pInd >= 0) && (pInd < activeWeapons.length)) {
			vCurWeapon = (Weapon)activeWeapons[pInd][0];
			vCurTalent = getUsableFightTalent(character.getTalentList(), vCurWeapon.getWeaponType());
			
			if (vCurTalent != null) {
				if (vCurWeapon instanceof CloseWeapon) {
					pMod = ((CloseWeapon)vCurWeapon).getWm(1);
					vRet = vCurTalent.makeAttackProbe((int)Math.round(character.getFightValue(2)), pMod);
				} else if (vCurWeapon instanceof RangeWeapon) vRet = vCurTalent.makeAttackProbe((int)Math.round(character.getFightValue(2)), pMod);
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
