/**	DSA_App	v0.0	Dh	23.5.2020
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

import pDataStructures.List;

public class FightElement {
	private int ID;
	private int[] PropMods;
	private double[] StatMods;
	private List NeighbourList;
	private Charakter Character;
	
	/**	Dh	1.5.2020
	 */
	public FightElement() {
		ID = -1;
		PropMods = new int[10];
		StatMods = new double[10];
		Character = null;
		NeighbourList = new List();
	}
	/**	Dh	12.2.2020
	 * 
	 * @param pID
	 * @param pChar
	 */
	public FightElement(int pID, Charakter pChar){
		Exception vExc;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; FiEle_a");
		
		if (pChar != null) Character = pChar;
		else vExc = new Exception("04; FiEle_a");
		
		PropMods = new int[10];
		StatMods = new double[10];
		
		for (int i=0; i<PropMods.length; i++){
			PropMods[i] = 0;
		}
		for (int i=0; i<StatMods.length; i++ ){
			StatMods[i] = 0;
		}
		
		NeighbourList = new List();
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
	 * @param pID
	 * @param pChar
	 * @param pEigenMod
	 */
	public FightElement(int pID, Charakter pChar, int[] pPropMods){
		Exception vExc;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; FiEle_b");
		
		if (pChar != null) Character = pChar;
		else vExc = new Exception("04; FiEle_b");
		
		try{
			if (pPropMods.length == 10){
				pChar.addProperties(pPropMods);
				PropMods = pPropMods;
			}
			else vExc = new Exception("01; FiEle_b");
		} catch(Exception exc) {vExc = exc;}
		StatMods = new double[10];
		
		for (int i=0; i<StatMods.length; i++ ){
			StatMods[i] = 0;
		}
		
		NeighbourList = new List();
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
	 * @param pID
	 * @param pChar
	 * @param pStatMod
	 */
	public FightElement(int pID, Charakter pChar, double[] pStatMod){
		Exception vExc;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; FiEle_c");
		
		if (pChar != null) Character = pChar;
		else vExc = new Exception("04; FiEle_c");
		
		PropMods = new int[10];
		try{
			if (pStatMod.length == 10){
				pChar.addStati(pStatMod);
				StatMods = pStatMod;
			}
			else vExc = new Exception("01; FiEle_c");
		} catch(Exception exc) {vExc = exc;}
		
		for (int i=0; i<PropMods.length; i++ ){
			PropMods[i] = 0;
		}
		
		NeighbourList = new List();
	}
	/**	Dh	12.2.2020
	 * 
	 * @param pID
	 * @param pChar
	 * @param pNeighbour
	 */
	public FightElement(int pID, Charakter pChar, List pNeighbours){
		Exception vExc;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; FiEle_d");
		
		if (pChar != null) Character = pChar;
		else vExc = new Exception("04; FiEle_d");
		
		PropMods = new int[10];
		StatMods = new double[10];
		
		for (int i=0; i<PropMods.length; i++){
			PropMods[i] = 0;
		}
		for (int i=0; i<StatMods.length; i++ ){
			StatMods[i] = 0;
		}
		
		if (pNeighbours != null)	NeighbourList = pNeighbours;
		else vExc = new Exception("04; FiEle_d");
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
	 * 	StatMods:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pID
	 * @param pChar
	 * @param pPropMods
	 * @param pStatMod
	 */
	public FightElement(int pID, Charakter pChar, int[] pPropMods, double[] pStatMod){
		Exception vExc;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; FiEle_e");
		
		if (pChar != null) Character = pChar;
		else vExc = new Exception("04; FiEle_e");
		
		try{
			if ((pPropMods.length == 10) && (pStatMod.length == 10)){
				pChar.addProperties(pPropMods);
				pChar.addStati(pStatMod);
				PropMods = pPropMods;
				StatMods = pStatMod;
			}
			else vExc = new Exception("01; FiEle_e");
		} catch(Exception exc) {vExc = exc;}
		
		
		NeighbourList = new List();
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
	 * @param pID
	 * @param pChar
	 * @param pPropMods
	 * @param pNeighbours
	 */
	public FightElement(int pID, Charakter pChar, int[] pPropMods, List pNeighbours){
		Exception vExc;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; FiEle_f");
		
		if (pChar != null) Character = pChar;
		else vExc = new Exception("04; FiEle_f");
		
		try{
			if (pPropMods.length == 10){
				pChar.addProperties(pPropMods);
				PropMods = pPropMods;
			}
			else vExc = new Exception("01; FiEle_f");
		} catch(Exception exc) {vExc = exc;}
		StatMods = new double[10];
		
		for (int i=0; i<StatMods.length; i++ ){
			StatMods[i] = 0;
		}
		
		if (pNeighbours != null)	NeighbourList = pNeighbours;
		else vExc = new Exception("04; FiEle_f");
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
	 * @param pID
	 * @param pChar
	 * @param pStatMod
	 * @param pNeighbours
	 */
	public FightElement(int pID, Charakter pChar, double[] pStatMod, List pNeighbours){
		Exception vExc;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; FiEle_g");
		
		if (pChar != null) Character = pChar;
		else vExc = new Exception("04; FiEle_g");
		
		PropMods = new int[10];
		try{
			if (pStatMod.length == 10){
				pChar.addStati(pStatMod);
				StatMods = pStatMod;
			}
			else vExc = new Exception("01; FiEle_g");
		} catch(Exception exc) {vExc = exc;}
		
		for (int i=0; i<PropMods.length; i++ ){
			PropMods[i] = 0;
		}
		
		if (pNeighbours != null)	NeighbourList = pNeighbours;
		else vExc = new Exception("04; FiEle_g");
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
	 * 	StatMods:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pID
	 * @param pChar
	 * @param pPropMods
	 * @param pStatMod
	 * @param pNeighbours
	 */
	public FightElement(int pID, Charakter pChar, int[] pPropMods, double[] pStatMod, List pNeighbours){
		Exception vExc;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; FiEle_h");
		
		if (pChar != null) Character = pChar;
		else vExc = new Exception("04; FiEle_h");
		
		try{
			if ((pPropMods.length == 10) && (pStatMod.length == 10)){
				pChar.addProperties(pPropMods);
				pChar.addStati(pStatMod);
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
	public int getID(){
		return ID;
	}
	/**	Dh	30.4.2020
	 * 
	 * @return
	 */
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
	public double[] getStatMods(){
		return StatMods;
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
	/**	Dh	13.2.2020
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
				if (((NeighbourElement)NeighbourList.getCurrent()).getEnemy() == pEnemy) vRet ++;
				
				NeighbourList.next();
			}
		}
		
		return vRet;
	}
	//-----
	/**	Dh	16.2.2020
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
				if (((NeighbourElement)NeighbourList.getCurrent()).getEnemy() == false) vRet ++;
				else vRet --;
				
				NeighbourList.next();
			}
		}
		else throw new Exception("05; FiEle,gNMaN");
		
		return vRet;
	}
	/**	Dh	16.2.2020
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
				if (((NeighbourElement)NeighbourList.getCurrent()).getEnemy() == true) vRet ++;
				else vRet --;
				
				NeighbourList.next();
			}
		}
		else throw new Exception("05; FiEle,gNMiN");
		
		return vRet;
	}
	/**	Dh	16.2.2020
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
				if (((NeighbourElement)NeighbourList.getCurrent()).getEnemy() == pEnemy) vRet ++;
				else vRet --;
				
				NeighbourList.next();
			}
		}
		else throw new Exception("05; FiEle,gNMaNBT");
		
		return vRet;
	}
	/**	Dh	16.2.2020
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
				if (((NeighbourElement)NeighbourList.getCurrent()).getEnemy() == !pEnemy) vRet ++;
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
		}else throw new Exception("01; FiEle,sPM");
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
			try{ Character.addStati(vTemp);}
			catch(Exception exc) {throw exc;}
			StatMods = pStatMods;
		}else throw new Exception("01; FiEle,sSM");
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
			
			pNeiList.toFirst();
			while(!pNeiList.isEmpty()){
				vTemp = pNeiList.getCurrent();
				
				if (vTemp instanceof NeighbourElement){
					if (((NeighbourElement)vTemp).getID() == ID) throw new Exception("02; FiEle,sNL");
				} else throw new Exception("06; FiEle,sNL");
				
				pNeiList.next();
			}
			
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
			try{ Character.addStati(pStatMods);}
			catch(Exception exc) {throw exc;}
		}else throw new Exception("01; FiEle,sSM");
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
}
