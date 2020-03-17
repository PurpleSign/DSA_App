/**	DSA_App v0.0	Dh	 11.2.2020
 * 	
 * 	Logik
 * 	  Charakter
 * 
 * 	zMund:
 * 	  0 mundan				2 karmal
 *    1 magisch				3 alles
 * 
 * 	zaEigenschaften: 
 * 	  0 Mut					4 Fingerfertigkeit
 * 	  1 Klugkheit			5 Gewandheit
 * 	  2 Intuition			6 Konstitution
 * 	  3 Charisma			7 Koerperkraft
 * 
 * 	za(Max)Stati:
 * 	  0 Lebenspunkte		2 Astralenergie
 * 	  1 Ausdauer			3 Karmalenergie
 * 
 * 	zaFightValues:
 * 	  0 Ini-Basiswert		2 Parade-Basiswert
 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
 * 
 * 	zaRS:
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
 * 
 */
package Logik;

import pDataStructures.List;

public class Charakter {

	private String zName, zRasse;
	private int zSO, zGS, zMund;
	private double zMR, zWS, zBE;
	private int[] zaEigenschaften, zaMaxStati, zaStati;
	private double[] zaFightValue, zaRS, zaStatiMod;
	private List zlVorteile, zlSonderfertigkeiten, zlTalente;
	
	/**	Dh	11.2.2020
	 * 	
	 * 	pEigen:
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			(8 Geschwindigkeit)
	 * 	  4 Fingerfertigkeit	(9 Sozialstatus)
	 * 	
	 * @param pName
	 * @param pRasse
	 * @param pEigen
	 */
	public Charakter(String pName, String pRasse, int[] pEigen){
		Exception vException;
		
		zName = pName;
		zRasse = pRasse;
		zMund = 0;
		
		switch(pEigen.length){
		case 8:
			for (int i=0; i < pEigen.length; i++){
				if (pEigen[i] < 0) vException = new Exception("02; Char_a");
				zaEigenschaften[i] = pEigen[i];
			}
			zGS = 8;
			zSO = 0;
			break;
		case 9:
			for (int i=0; i < pEigen.length; i++){
				if (pEigen[i] < 0) vException = new Exception("02; Char_a");
				if (i < 8) zaEigenschaften[i] = pEigen[i];
				else zGS = pEigen[i];
			}
			zSO = 0;
			break;
		case 10:
			for (int i=0; i < pEigen.length; i++){
				if (pEigen[i] < 0) vException = new Exception("02; Char_a");
				if (i < 8) zaEigenschaften[i] = pEigen[i];
				else if (i == 9)zGS = pEigen[i];
				else zSO = pEigen[i];
			}
			break;
		default:
			vException = new Exception("01; Char_a");
		}
		
		zlVorteile = new List();
		zlSonderfertigkeiten = new List();
		zlTalente = new List();
		
		zaStatiMod = new double[4];
		for (int i=0; i<zaStatiMod.length; i++){
			zaStatiMod[i] = 0;
		}
		
		try{
			zaMaxStati = Calculator.calCharBasisStati(zaEigenschaften, zMund);
			zMR = Calculator.calCharMr(zaEigenschaften);
			zWS = zaEigenschaften[6]/2;
			zaFightValue = Calculator.calCharFightValue(zaEigenschaften);
		}catch(Exception exc){vException = exc;}

		zaStati = zaMaxStati;
		
		zaRS = new double[8];
		for (int i=0; i<zaRS.length; i++){
			zaRS[i] = 0;
		}
		zBE = 0;
	}
	/**	Dh	11.2.2020
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
	 * @param pName
	 * @param pRasse
	 * @param pEigen
	 * @param pStatiMod
	 */
	public Charakter(String pName, String pRasse, int[] pEigen, double[] pStatiMod){
		Exception vException;
		
		zName = pName;
		zRasse = pRasse;
		if (((4 <= pStatiMod.length) && (pStatiMod.length <= 6)) || (pStatiMod.length == 10)){
			if (pStatiMod[2] >= 0 && pStatiMod[3] >= 0) zMund = 3;
			else if (pStatiMod[2] >= 0) zMund = 1;
			else if (pStatiMod[3] >= 0) zMund = 2;
			else zMund = 0;
		}
		else vException = new Exception("01; Char_b");
		
		switch(pEigen.length){
		case 8:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vException = new Exception("02; Char_b");
				zaEigenschaften[i] = pEigen[i];
			}
			zGS = 8;
			zSO = 0;
			break;
		case 9:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vException = new Exception("02; Char_b");
				if (i < 8) zaEigenschaften[i] = pEigen[i];
				else zGS = pEigen[i];
			}
			zSO = 0;
			break;
		case 10:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vException = new Exception("02; Char_b");
				if (i < 8) zaEigenschaften[i] = pEigen[i];
				else if (i == 9)zGS = pEigen[i];
				else zSO = pEigen[i];
			}
			break;
		default:
			vException = new Exception("01; Char_b");
		}
		
		zlVorteile = new List();
		zlSonderfertigkeiten = new List();
		zlTalente = new List();
		
		zaStatiMod = pStatiMod;
		
		try{
			zaMaxStati = Calculator.calCharBasisStati(zaEigenschaften, 0);
			zMR = Calculator.calCharMr(zaEigenschaften);
			zWS = zaEigenschaften[6]/2;
			zaFightValue = Calculator.calCharFightValue(zaEigenschaften);
		}catch(Exception exc){vException = exc;}

		switch(pStatiMod.length){
		case 4:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vException = new Exception("02; Char_b");
				zaMaxStati[i] += (int)pStatiMod[i];
			}
			break;
		case 5:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vException = new Exception("02; Char_b");
				if (i < 4) zaMaxStati[i] += (int)pStatiMod[i];
				else zMR += pStatiMod[i];
			}
			break;
		case 6:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vException = new Exception("02; Char_b");
				if (i < 4) zaMaxStati[i] += (int)pStatiMod[i];
				else if (i==4) zMR += pStatiMod[i];
				else zWS += pStatiMod[i];
			}
			break;
		case 10:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vException = new Exception("02; Char_b");
				if (i < 4) zaMaxStati[i] += (int)pStatiMod[i];
				else if (i==4) zMR += pStatiMod[i];
				else if (i==5) zWS += pStatiMod[i];
				else zaFightValue[i-6] += pStatiMod[i];
			}
			break;
		}
		
		zaStati = zaMaxStati;
		
		zaRS = new double[8];
		for (int i=0; i<zaRS.length; i++){
			zaRS[i] = 0;
		}
		zBE = 0;
	}
	/**	Dh	11.2.2020
	 * 
	 * 	pEigen:
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			(8 Geschwindigkeit)
	 * 	  4 Fingerfertigkeit	(9 Sozialstatus)
	 * 
	 * @param pName
	 * @param pRasse
	 * @param pEigen
	 * @param pVorteile
	 * @param pSf
	 * @param pTalente
	 */
	public Charakter(String pName, String pRasse, int[] pEigen, List pVorteile, List pSf, List pTalente){
		Exception vException;
		
		zName = pName;
		zRasse = pRasse;
		zMund = 0;
		
		switch(pEigen.length){
		case 8:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vException = new Exception("02; Char_c");
				zaEigenschaften[i] = pEigen[i];
			}
			zGS = 8;
			zSO = 0;
			break;
		case 9:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vException = new Exception("02; Char_c");
				if (i < 8) zaEigenschaften[i] = pEigen[i];
				else zGS = pEigen[i];
			}
			zSO = 0;
			break;
		case 10:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vException = new Exception("02; Char_c");
				if (i < 8) zaEigenschaften[i] = pEigen[i];
				else if (i == 9)zGS = pEigen[i];
				else zSO = pEigen[i];
			}
			break;
		default:
			vException = new Exception("01; Char_c");
		}
		
		zlVorteile = pVorteile;
		zlSonderfertigkeiten = pSf;
		zlTalente = pTalente;
		
		zaStatiMod = new double[4];
		for (int i=0; i<zaStatiMod.length; i++){
			zaStatiMod[i] = 0;
		}
		
		try{
			zaMaxStati = Calculator.calCharBasisStati(zaEigenschaften, 0);
			zMR = Calculator.calCharMr(zaEigenschaften);
			zWS = zaEigenschaften[6]/2;
			zaFightValue = Calculator.calCharFightValue(zaEigenschaften);
		}catch(Exception exc){vException = exc;}
		
		zaStati = zaMaxStati;
		
		zaRS = new double[8];
		for (int i=0; i<zaRS.length; i++){
			zaRS[i] = 0;
		}
		zBE = 0;
	}
	/**	Dh	11.2.2020
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
	 * @param pName
	 * @param pRasse
	 * @param pEigen
	 * @param pStatiMod
	 * @param pVorteile
	 * @param pSf
	 * @param pTalente
	 */
	public Charakter(String pName, String pRasse, int[] pEigen, double[] pStatiMod, List pVorteile, List pSf, List pTalente){
		Exception vException;
		
		zName = pName;
		zRasse = pRasse;
		if (((4 <= pStatiMod.length) && (pStatiMod.length <= 6)) || (pStatiMod.length == 10)){
			if (pStatiMod[2] >= 0 && pStatiMod[3] >= 0) zMund = 3;
			else if (pStatiMod[2] >= 0) zMund = 1;
			else if (pStatiMod[3] >= 0) zMund = 2;
			else zMund = 0;
		}
		else vException = new Exception("01; Char_b");
		
		switch(pEigen.length){
		case 8:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vException = new Exception("02; Char_d");
				zaEigenschaften[i] = pEigen[i];
			}
			zGS = 8;
			zSO = 0;
			break;
		case 9:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vException = new Exception("02; Char_d");
				if (i < 8) zaEigenschaften[i] = pEigen[i];
				else zGS = pEigen[i];
			}
			zSO = 0;
			break;
		case 10:
			for (int i=0; i<pEigen.length; i++){
				if (pEigen[i] < 0) vException = new Exception("02; Char_d");
				if (i < 8) zaEigenschaften[i] = pEigen[i];
				else if (i == 9)zGS = pEigen[i];
				else zSO = pEigen[i];
			}
			break;
		default:
			vException = new Exception("01; Char_d");
		}
		
		zlVorteile = pVorteile;
		zlSonderfertigkeiten = pSf;
		zlTalente = pTalente;
		
		zaStatiMod = pStatiMod;
		
		try{
			zaMaxStati = Calculator.calCharBasisStati(zaEigenschaften, 0);
			zMR = Calculator.calCharMr(zaEigenschaften);
			zWS = zaEigenschaften[6]/2;
			zaFightValue = Calculator.calCharFightValue(zaEigenschaften);
		}catch(Exception exc){vException = exc;}

		switch(pStatiMod.length){
		case 4:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vException = new Exception("02; Char_d");
				zaMaxStati[i] += (int)pStatiMod[i];
			}
			break;
		case 5:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vException = new Exception("02; Char_d");
				if (i < 4) zaMaxStati[i] += (int)pStatiMod[i];
				else zMR += pStatiMod[i];
			}
			break;
		case 6:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vException = new Exception("02; Char_d");
				if (i < 4) zaMaxStati[i] += (int)pStatiMod[i];
				else if (i==4) zMR += pStatiMod[i];
				else zWS += pStatiMod[i];
			}
			break;
		case 10:
			for (int i=0; i < pStatiMod.length; i++){
				if (pStatiMod[i] < 0) vException = new Exception("02; Char_d");
				if (i < 4) zaMaxStati[i] += (int)pStatiMod[i];
				else if (i==4) zMR += pStatiMod[i];
				else if (i==5) zWS += pStatiMod[i];
				else zaFightValue[i-6] += pStatiMod[i];
			}
			break;
		}
		
		zaStati = zaMaxStati;
		
		zaRS = new double[8];
		for (int i=0; i<zaRS.length; i++){
			zaRS[i] = 0;
		}
		zBE = 0;
	}
	
	public void destroyCharacter() throws Exception{
		Exception vExc = null;
		
		zName = null;
		zRasse = null;
		
		if (zlVorteile != null){
			while(!zlVorteile.isEmpty()){
				zlVorteile.toFirst();
				zlVorteile.remove();
			}
			zlVorteile = null;
		} else vExc = new Exception("04; Char,dC");
		if (zlSonderfertigkeiten != null){
			while(!zlSonderfertigkeiten.isEmpty()){
				zlSonderfertigkeiten.toFirst();
				zlSonderfertigkeiten.remove();
			}
			zlSonderfertigkeiten = null;
		} else vExc = new Exception("04; Char,dc");
		if (zlTalente != null){
			while (!zlTalente.isEmpty()){
				zlTalente.toFirst();
				zlTalente.remove();
			}
			zlTalente = null;
		} else vExc = new Exception("04; Char,dc");
		
		if (vExc != null) throw vExc;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	public String getName(){
		return zName;
	}
	public String getRace(){
		return zRasse;
	}
	public int getSO(){
		return zSO;
	}
	public int getGS(){
		return zGS;
	}
	public double getMR(){
		return zMR;
	}
	public double getWS(){
		return zWS;
	}
	public double getBe(){
		return zBE;
	}
	//-----
	/**	Dh 10.2.2020
	 * 
	 * 	zaEigenschaften: 
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
		if ((pInd >= 0) && (pInd < zaEigenschaften.length)){
			return zaEigenschaften[pInd];
		}else throw new Exception("07; Char,gPr");
	}
	/**	Dh	10.2.2020
	 * 
	 * 	zaStati:
	 * 	  0 Lebenspunkte		2 Astralenergie
	 * 	  1 Ausdauer			3 Karmalenergie
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getStat(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < zaStati.length)){
			return zaStati[pInd];
		}else throw new Exception("07; Char,gSt");
	}
	/**	Dh	10.2.2020
	 * 
	 * 	zaMaxStati:
	 * 	  0 Lebenspunkte		2 Astralenergie
	 * 	  1 Ausdauer			3 Karmalenergie
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getMaxStat(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < zaMaxStati.length)){
			return zaMaxStati[pInd];
		}else throw new Exception("07; Char,gMS");
	}
	/**	Dh	10.2.2020
	 * 
	 * 	zaFightValues:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public double getFightValue(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < zaFightValue.length)){
			return zaFightValue[pInd];
		}else throw new Exception("07; Char,gFV");
	}
	/**	Dh	10.2.2020
	 * 
	 * 	zaRS:
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
		if ((pInd >= 0) && (pInd < zaRS.length)){
			return zaRS[pInd];
		}else throw new Exception("07; Char,gRS");
	}
	
	/**	Dh	10.2.2020
	 * 
	 * 	zaEigenschaften: 
	 * 	  0 Mut					4 Fingerfertigkeit
	 * 	  1 Klugkheit			5 Gewandheit
	 * 	  2 Intuition			6 Konstitution
	 * 	  3 Charisma			7 Koerperkraft
	 * 
	 * @return
	 */
	public int[] getProperties(){
		return zaEigenschaften;
	}
	/**	Dh	10.2.2020
	 * 
	 * 	zaStati:
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
	public double[] getStati(int pSpez) throws Exception{
		double[] vRet;
		switch(pSpez){
		case 0:
			vRet = new double[4];
			for (int i=0; i<vRet.length;i++){
				vRet[i] = (double)zaStati[i];
			}
			break;
		case 1:
			vRet = new double[5];
			for (int i=0; i<vRet.length;i++){
				if (i < (vRet.length-1)) vRet[i] = (double)zaStati[i];
				else vRet[i] = zMR;
			}
			break;
		case 2:
			vRet = new double[6];
			for (int i=0; i<vRet.length;i++){
				if (i < (vRet.length-1)) vRet[i] = (double)zaStati[i];
				else if (i == 4) vRet[i] = zMR;
				else vRet[i] = zWS;
			}
			break;
		case 3:
			vRet = new double[10];
			for (int i=0; i<vRet.length;i++){
				if (i < (vRet.length-1)) vRet[i] = (double)zaStati[i];
				else if (i == 4) vRet[i] = zMR;
				else if (i == 5) vRet[i] = zWS;
				else vRet[i] = zaFightValue[i-6];
			}
			break;
		default:
			throw new Exception("01; Char,gSti");
		}
		return vRet;
	}
	/**	Dh	10.2.2020
	 * 
	 * 	zaMaxStati:
	 * 	  0 Lebenspunkte		2 Astralenergie
	 * 	  1 Ausdauer			3 Karmalenergie
	 * 
	 * @return
	 */
	public int[] getMaxStati(){
		return zaMaxStati;
	}
	/**	Dh	10.2.2020
	 * 
	 * 	zaFightValues:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @return
	 */
	public double[] getFightValues(){
		return zaFightValue;
	}
	/**	Dh	10.2.2020
	 * 
	 * 	zaRS:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @return
	 */
	public double[] getRSs(){
		return zaRS;
	}
	//-----
	public List getPros(){
		return zlVorteile;
	}
	public List getSpezialCrafts(){
		return zlSonderfertigkeiten;
	}
	public List getCrafts(){
		return zlTalente;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	public void setName(String pName){
		zName = pName;
	}
	public void setRace(String pRasse){
		zRasse = pRasse;
	}
	public void setSO(int pSO) throws Exception{
		if (pSO >= 0) zSO = pSO;
		else throw new Exception("02; Char,sSO");
	}
	public void setGS(int pGS) throws Exception{
		if (pGS >= 0) zGS = pGS;
		else throw new Exception("02; Char,sGS");
	}
	public void setMR(double pMR) throws Exception{
		if (pMR >= 0) zMR = pMR;
		else throw new Exception("02; Char,sMR");
	}
	public void setWS(double pWS) throws Exception{
		if (pWS >= 0) zWS = pWS;
		else throw new Exception("02; Char,sWS");
	}
	public void setBe(double pBe) throws Exception{
		if (pBe >= 0) zBE = pBe;
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
		if ((pInd >= 0) && (pInd < zaEigenschaften.length)){
			if (pProp >= 0) zaEigenschaften[pInd] = pProp;
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
		if ((pInd >= 0) && (pInd < zaStati.length)){
			if ((pInd == 0) || ((pStat >= 0) && (pInd >= 1))) zaStati[pInd] = pStat;
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
		if ((pInd >= 0) && (pInd < zaMaxStati.length)){
			if (pMaxStat >= 0) {
				if ((zaMaxStati[pInd] == zaStati[pInd]) || (((pMaxStat - zaMaxStati[pInd]) < 0) && ((pMaxStat < zaStati[pInd]) && (zaStati[pInd] < zaMaxStati[pInd])))){
					zaStati[pInd] = pMaxStat;
				}
				zaMaxStati[pInd] = pMaxStat;
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
		if ((pInd >= 0) && (pInd < zaFightValue.length)){
			if ((pInd == 0) || ((pFightValue >= 0) && (pInd >= 1))) zaFightValue[pInd] = pFightValue;
			else throw new Exception("02; Char,sFV");
		}else throw new Exception("07; Char,sFV");
	}
	/**	Dh	10.2.2020
	 * 
	 * 	pRS:
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
		if ((pInd >= 0) && (pInd < zaRS.length)){
			if ((pInd == 0) || ((pRS >= 0) && (pInd >= 1))) zaRS[pInd] = pRS;
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
				zaEigenschaften[i] = pEigen[i];
			}
			break;
		case 9:
			for (int i=0; i < pEigen.length; i++){
				if (pEigen[i] < 0) throw new Exception("02; Char,sPrs");
				if (i < 8) zaEigenschaften[i] = pEigen[i];
				else zGS = pEigen[i];
			}
			break;
		case 10:
			for (int i=0; i < pEigen.length; i++){
				if (pEigen[i] < 0) throw new Exception("02; Char,sPrs");
				if (i < 8) zaEigenschaften[i] = pEigen[i];
				else if (i == 9)zGS = pEigen[i];
				else zSO = pEigen[i];
			}
			break;
		default:
			throw new Exception("01; Char,sPrs");
		}
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
	public void setStati(double[] pStati) throws Exception{
		switch(pStati.length){
		case 4:
			for (int i=0; i < pStati.length; i++){
				if (pStati[i] < 0) throw new Exception("02; Char;sSti");
				zaStati[i] = (int)pStati[i];
			}
			break;
		case 5:
			for (int i=0; i < pStati.length; i++){
				if (pStati[i] < 0) throw new Exception("02; Char;sSti");
				if (i < 4) zaStati[i] = (int)pStati[i];
				else zMR = pStati[i];
			}
			break;
		case 6:
			for (int i=0; i < pStati.length; i++){
				if (pStati[i] < 0) throw new Exception("02; Char;sSti");
				if (i < 4) zaStati[i] = (int)pStati[i];
				else if (i==4) zMR = pStati[i];
				else zWS = pStati[i];
			}
			break;
		case 10:
			for (int i=0; i < pStati.length; i++){
				if (pStati[i] < 0) throw new Exception("02; Char;sSti");
				if (i < 4) zaMaxStati[i] = (int)pStati[i];
				else if (i==4) zMR = pStati[i];
				else if (i==5) zWS = pStati[i];
				else zaFightValue[i-6] = pStati[i];
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
	public void setMaxStati(int[] pMaxStati) throws Exception{
		if (pMaxStati.length == zaMaxStati.length){
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
		if (pFightValues.length == zaFightValue.length){
			for (int i=0; i < pFightValues.length; i++){
				if (pFightValues[i] >= 0) zaFightValue[i] = pFightValues[i];
				else throw new Exception("02; Char;sFVs");
			}
		}else throw new Exception("01; Char;sFVs");
	}
	/**	Dh	10.2.2020
	 * 	
	 * 	pRS:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pRS
	 * @throws Exception
	 */
	public void setRSs(double[] pRS) throws Exception{
		if (pRS.length == zaRS.length){
			for (int i=0; i < pRS.length; i++){
				if (pRS[i] >= 0) zaRS[i] = pRS[i];
				else throw new Exception("02; Char;sRSs");
			}
		}else throw new Exception("01; Char;sRSs");
	}
	//-----
	public void setPros(List pVorteile) throws Exception{
		if (pVorteile != null){
			if (zlVorteile != null){
				while(!zlVorteile.isEmpty()){
					zlVorteile.toFirst();
					zlVorteile.remove();
				}
			}
				
			zlVorteile = pVorteile;
		}
		else throw new Exception("04; Char,sPr");
	}
	public void setSpezialCrafts(List pSonder) throws Exception{
		if (pSonder != null){
			if (zlSonderfertigkeiten != null){
				while(!zlSonderfertigkeiten.isEmpty()){
					zlSonderfertigkeiten.toFirst();
					zlSonderfertigkeiten.remove();
				}
			}
				
			zlSonderfertigkeiten = pSonder;
		}
		else throw new Exception("04; Char,sSC");
	}
	public void setCrafts(List pTalente) throws Exception{
		if (pTalente != null){
			if (zlTalente != null){
				while(!zlTalente.isEmpty()){
					zlTalente.toFirst();
					zlTalente.remove();
				}
			}
				
			zlTalente = pTalente;
		}
		else throw new Exception("04; Char,sTa");
	}
	
//--------------------------------------------------------------------------------------------------------

	public void addSO(int pSO) throws Exception{
		if ((pSO >= 0) || ((pSO < 0) && (-pSO <= zSO))) zSO += pSO;
		else{
			zSO = 0;
			throw new Exception("03; Char,aSO");
		}
	}
	public void addGS(int pGS) throws Exception{
		if ((pGS >= 0) || ((pGS < 0) && (-pGS <= zGS))) zGS += pGS;
		else{
			zGS = 0;
			throw new Exception("03; Char,aGS");
		}
	}
	public void addMR(double pMR) throws Exception{
		if ((pMR >= 0) || ((pMR < 0) && (-pMR <= zMR))) zMR += pMR;
		else{
			zMR = 0;
			throw new Exception("03; Char,aMR");
		}
	}
	public void addWS(double pWS) throws Exception{
		if ((pWS >= 0) || ((pWS < 0) && (-pWS < zWS))) zWS += pWS;
		else{
			zWS = 0;
			throw new Exception("03; Char,aWS");
		}
	}
	public void addBe(double pBe) throws Exception{
		if ((pBe >= 0) || ((pBe < 0) && (-pBe <= zBE))) zBE += pBe;
		else{
			zBE = 0;
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
		if ((pInd >= 0) && (pInd < zaEigenschaften.length)){
			if ((pProp >= 0) || ((pProp < 0) && (-pProp < zaEigenschaften[pInd]))) {
				try{ makePropDepChange(pProp, pInd);}
				catch(Exception exc) {throw exc;}
				
				zaEigenschaften[pInd] += pProp;
			}
			else{
				try{ makePropDepChange(-zaEigenschaften[pInd], pInd);}
				catch(Exception exc) {throw exc;}
				
				zaEigenschaften[pInd] = 0;
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
		if ((pInd >= 0) && (pInd < zaStati.length)){
			if ((pStat >= 0) || ((pStat < 0) && (-pStat < zaStati[pInd]))) {
				if ((zaStati[pInd] > zaMaxStati[pInd]) || ((zaStati[pInd]+pStat) <= zaMaxStati[pInd])) zaStati[pInd] += pStat;
				else zaStati[pInd] = zaMaxStati[pInd];
			}
			else{
				zaStati[pInd] = 0;
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
		if ((pInd >= 0) && (pInd < zaMaxStati.length)){
			if ((pMaxStat >= 0) || ((pMaxStat < 0) && (-pMaxStat < zaMaxStati[pInd]))) {
				if ((zaMaxStati[pInd] >= zaStati[pInd]) && ((zaMaxStati[pInd]+pMaxStat) < zaStati[pInd] )) zaStati[pInd] = zaMaxStati[pInd] + pMaxStat;
				zaMaxStati[pInd] += pMaxStat;
			}
			else{
				if ((zaStati[pInd] > 0) && (zaStati[pInd] <= zaMaxStati[pInd])) zaStati[pInd] = 0;
				zaMaxStati[pInd] = 0;
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
		if ((pInd >= 0) && (pInd < zaFightValue.length)){
			if ((pFightValue >= 0) || ((pFightValue < 0) && (-pFightValue < zaFightValue[pInd]))) zaFightValue[pInd] += pFightValue;
			else{
				zaFightValue[pInd] = 0;
				throw new Exception("03; Char,aFV");
			}
		}else throw new Exception("07; Char,aFV");
	}
	/**	Dh	11.2.2020
	 * 
	 * 	pRS:
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
		if ((pInd >= 0) && (pInd < zaRS.length)){
			if ((pRS >= 0) || ((pRS < 0) && (-pRS <= zaRS[pInd]))) zaRS[pInd] += pRS;
			else{
				zaRS[pInd] = 0;
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
	public void addStati(double[] pStati) throws Exception{
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
	public void addMaxStati(int[] pMaxStati) throws Exception{
		if (pMaxStati.length == zaMaxStati.length){
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
		if (pFightValues.length == zaFightValue.length){
			for (int i=0; i < pFightValues.length; i++){
				try{ addFightValue(pFightValues[i], i);}
				catch(Exception exc) {throw exc;}
			}
		}else throw new Exception("01; Char;sFVs");
	}
	/**	Dh	11.2.2020
	 * 
	 * 	pRS:
	 * 	  0 Kopf				4 linker Arm
	 * 	  1 Brust				5 Bauch
	 * 	  2 Rücken				6 rechtes Bein
	 * 	  3 rechter Arm			7 linkes Bein
	 * 
	 * @param pRS
	 * @throws Exception
	 */
	public void addRSs(double[] pRS) throws Exception{
		if (pRS.length == zaRS.length){
			for (int i=0; i < pRS.length; i++){
				try{ zaRS[i] = pRS[i];}
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
	public void addCrafts(){
			// Noch implementeiern
	}
	
	public void addPros(List pVorteilList){
		pVorteilList.toFirst();
		while (!pVorteilList.isEnd()){
			zlVorteile.append(pVorteilList.getCurrent());
			zlVorteile.next();
		}
	}
	public void addSpezialCrafts(List pSonderList){
		pSonderList.toFirst();
		while (!pSonderList.isEnd()){
			zlSonderfertigkeiten.append(pSonderList.getCurrent());
			zlSonderfertigkeiten.next();
		}
	}
	public void addCrafts(List pTalentList){
		pTalentList.toFirst();
		while (!pTalentList.isEnd()){
			zlTalente.append(pTalentList.getCurrent());
			zlTalente.next();
		}
	}
	
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	11.2.2020
	 * 
	 * 	zaEigenschaften: 
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
			
				if (zaMaxStati[2] > 0) addStat(pProp/2, 2);
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
			
				if (zaMaxStati[2] > 0) addStat(pProp/2, 2);
			} catch(Exception exc) {throw exc;}
			break;
		case 3:																		// Sonderfertigkeiten Gefäss der Sterne einbauen.
			try{ if (zaMaxStati[2] > 0) addStat(pProp/2, 2);}
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
}
