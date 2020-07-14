/**	DSA_App v0.0	Dh 14.7.2020
 * 
 * 	Logik
 * 	  Calculator
 * 
 * 	pSpez:
 *	  0 mundan				2 karmal
 *    1 magisch				3 alles
 * 	
 * 	zaEigenschaften: 
 * 	  0 Mut					4 Fingerfertigkeit
 * 	  1 Klugkheit			5 Gewandheit
 * 	  2 Intuition			6 Konstitution
 * 	  3 Charisma			7 Koerperkraft
 * 
 *  za(Max)Stati:
 * 	  0 Lebenspunkte		2 Astralenergie
 * 	  1 Ausdauer			3 Karmalenergie
 * 
 * 	zaFightValues:
 * 	  0 Ini-Basiswert		2 Parade-Basiswert
 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
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
 */
package pLogik;

import java.util.Random;

public abstract class Calculator {
	
	/** Dh	14.7.2020
	 * 
	 * 	pSpez:
	 * 	  0 mundan			2 karmal
	 *    1 magisch			3 alles
	 *    
	 *  pEigen: 
	 * 	  0 Mut					4 Fingerfertigkeit
	 * 	  1 Klugkheit			5 Gewandheit
	 * 	  2 Intuition			6 Konstitution
	 * 	  3 Charisma			7 Koerperkraft
	 * 
	 * 	Stati:
	 * 	  0 Lebenspunkte		2 Astralenergie
	 * 	  1 Ausdauer			3 Karmalenergie
	 * 
	 * @param pEigen
	 * @param pSpez
	 * @return
	 */
	protected static double[] calCharBasisStati(int[] pEigen, int pSpez) throws Exception{
		double[] vReturn = new double[4];
		
		if (pEigen.length == 8){
			if ((pEigen[0] >= 0) && (pEigen[5] >= 0) && (pEigen[6] >= 0) && (pEigen[7] >= 0)){
				vReturn[0] = ((double)((2*pEigen[6])+pEigen[7]))/2;
				vReturn[1] = ((double)(pEigen[0] + pEigen[5] + pEigen[6]))/2;
			}
			else throw new Exception("02; Cal,cCBS");
			
			if (pSpez == 1 || pSpez == 3){
				if ((pEigen[2] >= 0) && (pEigen[3] >= 0)){
					vReturn[2] = ((double)(pEigen[0] + pEigen[2] + pEigen[3]))/2;
				}
				else throw new Exception("02; Cal,cCBS");
			}else{
				vReturn[2] = -1;
			}
			if (pSpez == 2 || pSpez == 3){
				vReturn[3] = 0;
			}else{
				vReturn[3] = -1;
			}
		}
		else throw new Exception("01; Cal,cCBS");
		
		return vReturn;
	}
	/**	Dh 	9.2.2020
	 * 	
	 * 	pEigen: 
	 * 	  0 Mut					4 Fingerfertigkeit
	 * 	  1 Klugkheit			5 Gewandheit
	 * 	  2 Intuition			6 Konstitution
	 * 	  3 Charisma			7 Koerperkraft
	 * 
	 * 	FightValues:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pEigen
	 * @return
	 */
	protected static double[] calCharFightValue(int[] pEigen) throws Exception{
		double[] vReturn = new double[4];
		
		if (pEigen.length == 8){
			if ((pEigen[0] >= 0) && (pEigen[2] >= 0) && (pEigen[5] >= 0)){
				vReturn[0] = ((double)((2*pEigen[0]) + pEigen[2] + pEigen[5]))/5;
			}
			else throw new Exception("02; Cal,cCFV");
			if (pEigen[7] >= 0){
				vReturn[1] = ((double)((pEigen[0]) + pEigen[5] + pEigen[7]))/5;
			}
			else throw new Exception("02; Cal,cCFV");
			vReturn[2] = ((double)((pEigen[2]) + pEigen[5] + pEigen[7]))/5;
			if (pEigen[4] >= 0){
				vReturn[3] = ((double)((2*pEigen[2]) + pEigen[4] + pEigen[7]))/5;
			}
			else throw new Exception("02; Cal,cCFV");
		}
		else throw new Exception("01; Cal,cCFV");
		
		return vReturn;
	}
	/**	Dh 	9.2.2020
	 * 
	 * @param pEigen
	 * @return
	 */
	protected static double calCharMr(int[] pEigen) throws Exception{
		double vReturn = -1;
		
		if (pEigen.length == 8){
			if ((pEigen[0] >= 0) && (pEigen[1] >= 0) && (pEigen[6] >= 0)){
				vReturn = ((double)((pEigen[0]) + pEigen[1] + pEigen[6]))/5;
			}
			else throw new Exception("02; Cal,cCMr");
		}
		else throw new Exception("01; Cal,cCMr");
		
		return vReturn;
	}
	/**	Dh	10.2.2002
	 * 
	 * @param pKo
	 * @return
	 * @throws Exception
	 */
	protected static double calCharWs(int pKo) throws Exception{
		double vReturn;
		
		if (pKo >= 0) vReturn = ((double)pKo)/2;
		else throw new Exception("02; Cal,cCWs");
		
		return vReturn;
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	9.7.2020
	 * 
	 * 	Berechnet den int Value aus einer gegeben Bitfolge (BooleanArray).
	 * 
	 * @param pBitFolge
	 * @return
	 * @throws Exception
	 */
	public static int convertBitToInt(boolean[] pBitFolge) throws Exception{
		int vRet = -1;
		
		if (pBitFolge != null) {
			vRet = 0;
			
			for (int i=0; i<pBitFolge.length; i++) {
				if (pBitFolge[i] == true) vRet += (int)Math.pow(2, i);
			}
		} else throw new Exception("04, Cal,cBtI");
		
		return vRet;
	}
	/**	Dh	10.7.2020
	 * 
	 * 	Berechnet die Bitfolge(BooleanArray), eienr vorgegeben Länge, aus einem Int Value.
	 * 
	 * @param pIntValue
	 * @param pBitLength
	 * @return
	 * @throws Exception
	 */
	public static boolean[] convertIntToBit(int pIntValue, int pBitLength) throws Exception{
		boolean[] vRet = null;
		
		if ((pIntValue >= 0) && (pIntValue < Math.pow(2, pBitLength))) {
			vRet = new boolean[pBitLength];
			for (int i=(pBitLength-1); i >= 0; i--) {
				if (pIntValue >= Math.pow(2, i)) {
					vRet[i] = true;
					pIntValue = pIntValue - (int)Math.pow(2, i);
				} else vRet[i] = false;
			}
		} else throw new Exception("02; Cal,cItB");
		
		return vRet;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	10.6.2020
	 * 
	 * @param pSide
	 * @return
	 * @throws Exception
	 */
	protected static int makeDiceRoll(int pSide) throws Exception{
		return makeDiceRolls(1, pSide)[0];
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pNumber
	 * @param pSide
	 * @return
	 * @throws Exception
	 */
	protected static int[] makeDiceRolls(int pNumber, int pSide) throws Exception{
		int[] vRet = null;
		Random vRan = new Random();
		
		if ((pNumber > 0) && (pSide > 0)) {
			vRet = new int[pNumber];
			
			for (int i=0; i < pNumber; i++) {
				vRet[i] = vRan.nextInt(pSide-1)+1;
			}
		}else throw new Exception("02; Cal,mDRs");
		
		return vRet;
	}
}
