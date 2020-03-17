/**	DSA_App	v0.0	Dh	23.2.2020
 * 
 * 	Logik
 * 	  FightElement
 * 	
 * 	zaEigenMod: 
 * 	  0 Mut					5 Gewandheit
 * 	  1 Klugkheit			6 Konstitution
 * 	  2 Intuition			7 Koerperkraft
 * 	  3 Charisma			8 Geschwindigkeit
 * 	  4 Fingerfertigkeit	9 Sozialstatus
 * 
 * 	zaStatiMod:
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
 */
package Logik;

import pDataStructures.List;

public class FightElement {
	private int zID;
	private int[] zaEigenMod;
	private double[] zaStatiMod;
	private List zlNeighbourList;
	private Charakter zChar;
	
	/**	Dh	12.2.2020
	 * 
	 * @param pID
	 * @param pChar
	 */
	public FightElement(int pID, Charakter pChar){
		Exception vExc;
		
		if (pID >= 0) zID = pID;
		else vExc = new Exception("02; FiEle_a");
		
		if (pChar != null) zChar = pChar;
		else vExc = new Exception("04; FiEle_a");
		
		zaEigenMod = new int[10];
		zaStatiMod = new double[10];
		
		for (int i=0; i<zaEigenMod.length; i++){
			zaEigenMod[i] = 0;
		}
		for (int i=0; i<zaStatiMod.length; i++ ){
			zaStatiMod[i] = 0;
		}
		
		zlNeighbourList = new List();
	}
	/**	Dh	12.2.2020
	 * 
	 * 	zaEigenMod: 
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
	public FightElement(int pID, Charakter pChar, int[] pEigenMod){
		Exception vExc;
		
		if (pID >= 0) zID = pID;
		else vExc = new Exception("02; FiEle_b");
		
		if (pChar != null) zChar = pChar;
		else vExc = new Exception("04; FiEle_b");
		
		try{
			if (pEigenMod.length == 10){
				pChar.addProperties(pEigenMod);
				zaEigenMod = pEigenMod;
			}
			else vExc = new Exception("01; FiEle_b");
		} catch(Exception exc) {vExc = exc;}
		zaStatiMod = new double[10];
		
		for (int i=0; i<zaStatiMod.length; i++ ){
			zaStatiMod[i] = 0;
		}
		
		zlNeighbourList = new List();
	}
	/**	Dh	12.2.2020
	 * 
	 * 	zaStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pID
	 * @param pChar
	 * @param pStatiMod
	 */
	public FightElement(int pID, Charakter pChar, double[] pStatiMod){
		Exception vExc;
		
		if (pID >= 0) zID = pID;
		else vExc = new Exception("02; FiEle_c");
		
		if (pChar != null) zChar = pChar;
		else vExc = new Exception("04; FiEle_c");
		
		zaEigenMod = new int[10];
		try{
			if (pStatiMod.length == 10){
				pChar.addStati(pStatiMod);
				zaStatiMod = pStatiMod;
			}
			else vExc = new Exception("01; FiEle_c");
		} catch(Exception exc) {vExc = exc;}
		
		for (int i=0; i<zaEigenMod.length; i++ ){
			zaEigenMod[i] = 0;
		}
		
		zlNeighbourList = new List();
	}
	/**	Dh	12.2.2020
	 * 
	 * @param pID
	 * @param pChar
	 * @param pNeighbour
	 */
	public FightElement(int pID, Charakter pChar, List pNeighbours){
		Exception vExc;
		
		if (pID >= 0) zID = pID;
		else vExc = new Exception("02; FiEle_d");
		
		if (pChar != null) zChar = pChar;
		else vExc = new Exception("04; FiEle_d");
		
		zaEigenMod = new int[10];
		zaStatiMod = new double[10];
		
		for (int i=0; i<zaEigenMod.length; i++){
			zaEigenMod[i] = 0;
		}
		for (int i=0; i<zaStatiMod.length; i++ ){
			zaStatiMod[i] = 0;
		}
		
		if (pNeighbours != null)	zlNeighbourList = pNeighbours;
		else vExc = new Exception("04; FiEle_d");
	}
	/**	Dh	12.2.2020
	 * 
	 * 	zaEigenMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	zaStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pID
	 * @param pChar
	 * @param pEigenMod
	 * @param pStatiMod
	 */
	public FightElement(int pID, Charakter pChar, int[] pEigenMod, double[] pStatiMod){
		Exception vExc;
		
		if (pID >= 0) zID = pID;
		else vExc = new Exception("02; FiEle_e");
		
		if (pChar != null) zChar = pChar;
		else vExc = new Exception("04; FiEle_e");
		
		try{
			if ((pEigenMod.length == 10) && (pStatiMod.length == 10)){
				pChar.addProperties(pEigenMod);
				pChar.addStati(pStatiMod);
				zaEigenMod = pEigenMod;
				zaStatiMod = pStatiMod;
			}
			else vExc = new Exception("01; FiEle_e");
		} catch(Exception exc) {vExc = exc;}
		
		
		zlNeighbourList = new List();
	}
	/**	Dh	12.2.2020
	 * 
	 * 	zaEigenMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * @param pID
	 * @param pChar
	 * @param pEigenMod
	 * @param pNeighbours
	 */
	public FightElement(int pID, Charakter pChar, int[] pEigenMod, List pNeighbours){
		Exception vExc;
		
		if (pID >= 0) zID = pID;
		else vExc = new Exception("02; FiEle_f");
		
		if (pChar != null) zChar = pChar;
		else vExc = new Exception("04; FiEle_f");
		
		try{
			if (pEigenMod.length == 10){
				pChar.addProperties(pEigenMod);
				zaEigenMod = pEigenMod;
			}
			else vExc = new Exception("01; FiEle_f");
		} catch(Exception exc) {vExc = exc;}
		zaStatiMod = new double[10];
		
		for (int i=0; i<zaStatiMod.length; i++ ){
			zaStatiMod[i] = 0;
		}
		
		if (pNeighbours != null)	zlNeighbourList = pNeighbours;
		else vExc = new Exception("04; FiEle_f");
	}
	/**	Dh	12.2.2020
	 * 
	 * 	zaStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pID
	 * @param pChar
	 * @param pStatiMod
	 * @param pNeighbours
	 */
	public FightElement(int pID, Charakter pChar, double[] pStatiMod, List pNeighbours){
		Exception vExc;
		
		if (pID >= 0) zID = pID;
		else vExc = new Exception("02; FiEle_g");
		
		if (pChar != null) zChar = pChar;
		else vExc = new Exception("04; FiEle_g");
		
		zaEigenMod = new int[10];
		try{
			if (pStatiMod.length == 10){
				pChar.addStati(pStatiMod);
				zaStatiMod = pStatiMod;
			}
			else vExc = new Exception("01; FiEle_g");
		} catch(Exception exc) {vExc = exc;}
		
		for (int i=0; i<zaEigenMod.length; i++ ){
			zaEigenMod[i] = 0;
		}
		
		if (pNeighbours != null)	zlNeighbourList = pNeighbours;
		else vExc = new Exception("04; FiEle_g");
	}
	/**	Dh	12.2.2020
	 * 
	 * 	zaEigenMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	zaStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pID
	 * @param pChar
	 * @param pEigenMod
	 * @param pStatiMod
	 * @param pNeighbours
	 */
	public FightElement(int pID, Charakter pChar, int[] pEigenMod, double[] pStatiMod, List pNeighbours){
		Exception vExc;
		
		if (pID >= 0) zID = pID;
		else vExc = new Exception("02; FiEle_h");
		
		if (pChar != null) zChar = pChar;
		else vExc = new Exception("04; FiEle_h");
		
		try{
			if ((pEigenMod.length == 10) && (pStatiMod.length == 10)){
				pChar.addProperties(pEigenMod);
				pChar.addStati(pStatiMod);
				zaEigenMod = pEigenMod;
				zaStatiMod = pStatiMod;
			}
			else vExc = new Exception("01; FiEle_h");
		} catch(Exception exc) {vExc = exc;}
		
		if (pNeighbours != null)	zlNeighbourList = pNeighbours;
		else vExc = new Exception("04; FiEle_h");
	}
	
	public void destroyFightElement() throws Exception{
		zChar = null;
		
		if (zlNeighbourList != null){
			while (!zlNeighbourList.isEmpty()){
				zlNeighbourList.toFirst();
				zlNeighbourList.remove();
			}
			zlNeighbourList = null;
		} else throw new Exception("04; FilEle,dFE");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	public int getID(){
		return zID;
	}
	public Charakter getCharacter(){
		return zChar;
	}
	
	/**	Dh	12.2.2020
	 * 
	 * 	zaEigenMod: 
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
		if ((pInd >= 0) && (pInd < zaEigenMod.length)){
			return zaEigenMod[pInd];
		}else throw new Exception("07; FiEle,gPM");
	}
	/**	Dh	12.2.2020
	 * 
	 * 	zaStatiMod:
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
		if ((pInd >= 0) && (pInd < zaStatiMod.length)){
			return zaStatiMod[pInd];
		}else throw new Exception("07; FiEle,gSM");
	}
	
	/**	Dh	12.2.2020
	 * 
	 * 	zaEigenMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * @return
	 */
	public int[] getPropMods(){
		return zaEigenMod;
	}
	/**	Dh	12.2.2020
	 * 
	 * 	zaStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @return
	 */
	public double[] getStatMods(){
		return zaStatiMod;
	}
	
	/**	Dh	13.2.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public NeighbourElement getNeighbourElement(int pInd) throws Exception{
		if ((!zlNeighbourList.isEmpty()) && (pInd < zlNeighbourList.getContentNumber())){
			zlNeighbourList.toFirst();
			for (int i=0; i<=pInd; i++) zlNeighbourList.next();
			return (NeighbourElement) zlNeighbourList.getCurrent();
		} else throw new Exception("07^05; FiEle,gNE");
	}
	/**	Dh	13.2.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public NeighbourElement getLastNeighbourElement() throws Exception {
		if (!zlNeighbourList.isEmpty()){
			zlNeighbourList.toLast();
			return (NeighbourElement) zlNeighbourList.getCurrent();
		}
		else throw new Exception("05; FiEle,gLNE");
	}
	/**	Dh	13.2.2020
	 * 
	 * @return
	 */
	public List getNeighbourList(){
		return zlNeighbourList;
	}
	
	/**	Dh	13.2.2020
	 * 
	 * 	Gibt die Anzahl an Kampfnachbarn wieder; Unabhaengig ihrer Gesinnung gegenueber der betreffenden Entitaet.
	 * 
	 * @return
	 */
	public int getNeighbourCount(){
		int vRet;
		
		if (!zlNeighbourList.isEmpty()) vRet =  zlNeighbourList.getContentNumber();
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
		
		if (!zlNeighbourList.isEmpty()){
			
			zlNeighbourList.toFirst();
			while(!zlNeighbourList.isEnd()){
				if (((NeighbourElement)zlNeighbourList.getCurrent()).getEnemy() == pEnemy) vRet ++;
				
				zlNeighbourList.next();
			}
		}
		
		return vRet;
	}
	//-----
	/**	Dh	16.2.2020
	 * 
	 * 	Gibt die Anzhal an Kaempfer*Innen an, mit welchen die gewaehlte Entitaet in Uerbzahl kaempft;
	 * 
	 * 	vRet kann auch negative Werte annehmen.
	 * 
	 * @return
	 */
	public int getNeighbourMajorityNumber() throws Exception{
		int vRet = 1;
		
		if (!zlNeighbourList.isEmpty()){
			
			zlNeighbourList.toFirst();
			while(!zlNeighbourList.isEnd()){
				if (((NeighbourElement)zlNeighbourList.getCurrent()).getEnemy() == false) vRet ++;
				else vRet --;
				
				zlNeighbourList.next();
			}
		}
		else throw new Exception("05; FiEle,gNMaN");
		
		return vRet;
	}
	/**	Dh	16.2.2020
	 * 
	 * 	Gibt die Anzahl an Kaempfer*Innen an, mit welchen die gewaehlte Entitaet in Unterzahl gekaempft wird;
	 * 
	 * 	vRet kann auch negative Werte annehmen.
	 * 
	 * @return
	 */
	public int getNeighbourMinorityNumber() throws Exception{
		int vRet = -1;
		
		if (!zlNeighbourList.isEmpty()){
			
			zlNeighbourList.toFirst();
			while(!zlNeighbourList.isEnd()){
				if (((NeighbourElement)zlNeighbourList.getCurrent()).getEnemy() == true) vRet ++;
				else vRet --;
				
				zlNeighbourList.next();
			}
		}
		else throw new Exception("05; FiEle,gNMiN");
		
		return vRet;
	}
	/**	Dh	16.2.2020
	 * 
	 * 	Gibt die Anzahl an Kaempfer*Innen an, mit welchen die durch pEnemy spezifizierte Partei in Ueberzahl kaempft;
	 * 
	 * 	vRet kann auch negative Werte annehmen.
	 * 
	 * @param pEnemy
	 * @return
	 */
	public int getNeighbourMajorityNumerByType(boolean pEnemy) throws Exception{
		int vRet;
		
		if (pEnemy == true) vRet = -1;
		else vRet = 1;
		
		if (!zlNeighbourList.isEmpty()){
			
			zlNeighbourList.toFirst();
			while(!zlNeighbourList.isEnd()){
				if (((NeighbourElement)zlNeighbourList.getCurrent()).getEnemy() == pEnemy) vRet ++;
				else vRet --;
				
				zlNeighbourList.next();
			}
		}
		else throw new Exception("05; FiEle,gNMaNBT");
		
		return vRet;
	}
	/**	Dh	16.2.2020
	 * 
	 * 	Gibt die Anzahl an Kaempfer*Innen an, mit welchen die durch pEnemy spezifizierte Partei in Unterzahl kaempft;
	 * 
	 * 	vRet kann auch negative Werte annehmen.
	 * 
	 * @param pEnemy
	 * @return
	 * @throws Exception
	 */
	public int getNeighbourMinorityNumberByType(boolean pEnemy) throws Exception{
		int vRet;
		
		if (pEnemy == true) vRet = 1;
		else vRet = -1;
		
		if (!zlNeighbourList.isEmpty()){
			
			zlNeighbourList.toFirst();
			while(!zlNeighbourList.isEnd()){
				if (((NeighbourElement)zlNeighbourList.getCurrent()).getEnemy() == !pEnemy) vRet ++;
				else vRet --;
				
				zlNeighbourList.next();
			}
		}
		else throw new Exception("05; FiEle,gNMiNBT");
		
		return vRet;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	12.2.2020
	 * 
	 * 	zaEigenMod: 
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
		if ((pInd >= 0) && (pInd < zaEigenMod.length)){
			int vTemp = pPropMod - zaEigenMod[pInd];
			try{ 
				if (pInd < 8) zChar.addPropertie(vTemp, pInd);
				else if (pInd == 8) zChar.addGS(vTemp);
				else zChar.addSO(vTemp);
			}
			catch(Exception exc) {throw exc;}
			zaEigenMod[pInd] = pPropMod;
		}else throw new Exception("07; FiEle,sPM");
	}
	/**	Dh	12.2.2020
	 * 
	 * 	zaStatiMod:
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
		if ((pInd >= 0) && (pInd < zaStatiMod.length)){
			double vTemp = pStatMod - zaStatiMod[pInd];
			try{ 
				if (pInd < 4) zChar.addStat((int)vTemp, pInd);
				else if (pInd == 4) zChar.addMR(vTemp);
				else if (pInd == 5) zChar.addWS(vTemp);
				else zChar.addFightValue(vTemp, pInd-6);
			}
			catch(Exception exc) {throw exc;}
			zaStatiMod[pInd] = pStatMod;
		}else throw new Exception("07; FiEle,sSM");
	}
	
	/**	Dh	12.2.2020
	 * 
	 * 	zaEigenMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * @param pEigen
	 * @throws Exception
	 */
	public void setPropMods(int[] pEigen) throws Exception{
		if (pEigen.length == zaEigenMod.length){
			int[] vTemp = new int[zaEigenMod.length];
			for (int i=0; i<vTemp.length; i++){
				vTemp[i] = pEigen[i] - zaEigenMod[i];
			}
			try{ zChar.addProperties(vTemp);}
			catch(Exception exc) {throw exc;}
			zaEigenMod = pEigen;
		}else throw new Exception("01; FiEle,sPM");
	}
	/**	Dh	12.2.2020
	 * 
	 * 	zaStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pStatMod
	 * @throws Exception
	 */
	public void setStatMods(double[] pStatMod) throws Exception{
		if (pStatMod.length == zaStatiMod.length){
			double[] vTemp = new double[zaStatiMod.length];
			for (int i=0; i<vTemp.length; i++){
				vTemp[i] = pStatMod[i] - zaStatiMod[i];
			}
			try{ zChar.addStati(vTemp);}
			catch(Exception exc) {throw exc;}
			zaStatiMod = pStatMod;
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
			if (!zlNeighbourList.isEmpty()){
				while(!zlNeighbourList.isEmpty()){
					zlNeighbourList.toFirst();
					zlNeighbourList.remove();
				}
			}
			
			pNeiList.toFirst();
			while(!pNeiList.isEmpty()){
				vTemp = pNeiList.getCurrent();
				
				if (vTemp instanceof NeighbourElement){
					if (((NeighbourElement)vTemp).getID() == zID) throw new Exception("02; FiEle,sNL");
				} else throw new Exception("06; FiEle,sNL");
				
				pNeiList.next();
			}
			
			zlNeighbourList = pNeiList;
		}
		else throw new Exception("04; FiEle,sNL");
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	12.2.2020
	 * 
	 * 	zaEigenMod: 
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
		if ((pInd >= 0) && (pInd < zaEigenMod.length)){
			try{ 
				if (pInd < 8) zChar.addPropertie(pPropMod, pInd);
				else if (pInd == 8) zChar.addGS(pPropMod);
				else zChar.addSO(pPropMod);
			}
			catch(Exception exc) {throw exc;}
			zaEigenMod[pInd] += pPropMod;
		}else throw new Exception("07; FiEle,aPM");
	}
	/**	Dh	12.2.2020
	 * 
	 * 	zaStatiMod:
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
		if ((pInd >= 0) && (pInd < zaStatiMod.length)){
			try{ 
				if (pInd < 4) zChar.addStat((int)pStatMod, pInd);
				else if (pInd == 4) zChar.addMR(pStatMod);
				else if (pInd == 5) zChar.addWS(pStatMod);
				else zChar.addFightValue(pStatMod, pInd-6);
			}
			catch(Exception exc) {throw exc;}
			zaStatiMod[pInd] += pStatMod;
		}else throw new Exception("07; FiEle,aSM");
	}
	
	/**	Dh	12.2.2020
	 * 
	 * 	zaEigenMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * @param pEigen
	 * @throws Exception
	 */
	public void addPropMods(int[] pEigen) throws Exception{
		if (pEigen.length == zaEigenMod.length){
			try{ zChar.addProperties(pEigen);}
			catch(Exception exc) {throw exc;}
			for (int i=0; i<zaEigenMod.length; i++){
				zaEigenMod[i] += pEigen[i];
			}
		}else throw new Exception("01; FiEle,aPM");
	}
	/**	Dh	12.2.2020
	 * 
	 * 	zaStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 	
	 * @param pStatMod
	 * @throws Exception
	 */
	public void addStatMods(double[] pStatMod) throws Exception{
		if (pStatMod.length == zaStatiMod.length){
			try{ zChar.addStati(pStatMod);}
			catch(Exception exc) {throw exc;}
			for (int i=0; i<zaStatiMod.length; i++){
				zaStatiMod[i] += pStatMod[i];
			}
		}else throw new Exception("01; FiEle,sSM");
	}
	
	/**	Dh	23.2.2020
	 * 
	 * @param pNeiElement
	 * @throws Exception
	 */
	public void addNeighbourElement(NeighbourElement pNeiElement) throws Exception{
		if (!zlNeighbourList.isEmpty()){
			if (pNeiElement != null) {
				if (pNeiElement.getID() != zID) zlNeighbourList.append(pNeiElement);
				else throw new Exception("02; FiEle,aNE");
			} else throw new Exception("04; FiEle,aNE");
		}
		else throw new Exception("05; FiEle,aNE");
	}
	/**	Dh	23.2.2020
	 * 
	 * @param pNeiList
	 * @throws Exception
	 */
	public void addNeighbourList(List pNeiList) throws Exception{
		Object vTemp;
		
		if (!pNeiList.isEmpty()){
			pNeiList.toFirst();
			while (!pNeiList.isEnd()){
				vTemp = pNeiList.getCurrent();
				if (vTemp instanceof NeighbourElement){
					if (((NeighbourElement)vTemp).getID() != zID) zlNeighbourList.append(vTemp);
					else throw new Exception("02; FiEle,aNL");
				} else throw new Exception("06; FiEle,aNL");
				pNeiList.next();
			}
		}
		else throw new Exception("05; FiEle,aNL");
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
			if (!zlNeighbourList.isEmpty()){
				zlNeighbourList.toFirst();
				while(!zlNeighbourList.isEmpty()){
					NeighbourElement vTemp = (NeighbourElement) zlNeighbourList.getCurrent();
					if (vTemp.getID() == pID) vRet = true;
					
					zlNeighbourList.next();
				}
			}
		}
		else throw new Exception("02; FiEle, hNIL");
		
		return vRet;
	}
}
