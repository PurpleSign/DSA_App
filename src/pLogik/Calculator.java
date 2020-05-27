/**	DSA_App v0.0	Dh 9.2.2020
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

public abstract class Calculator {
	
	/** Dh	9.2.2020
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
	public static int[] calCharBasisStati(int[] pEigen, int pSpez) throws Exception{
		int[] vReturn = new int[4];
		
		if (pEigen.length == 8){
			if ((pEigen[0] >= 0) && (pEigen[5] >= 0) && (pEigen[6] >= 0) && (pEigen[7] >= 0)){
				vReturn[0] = ((2*pEigen[6])+pEigen[7])/2;
				vReturn[1] = (pEigen[0] + pEigen[5] + pEigen[6])/2;
			}
			else throw new Exception("02; Cal,cCBS");
			
			if (pSpez == 1 || pSpez == 3){
				if ((pEigen[2] >= 0) && (pEigen[3] >= 0)){
					vReturn[2] = (pEigen[0] + pEigen[2] + pEigen[3])/2;
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
	public static double[] calCharFightValue(int[] pEigen) throws Exception{
		double[] vReturn = new double[4];
		
		if (pEigen.length == 8){
			if ((pEigen[0] >= 0) && (pEigen[2] >= 0) && (pEigen[5] >= 0)){
				vReturn[0] = ((2*pEigen[0]) + pEigen[2] + pEigen[5])/5;
			}
			else throw new Exception("02; Cal,cCFV");
			if (pEigen[7] >= 0){
				vReturn[1] = ((pEigen[0]) + pEigen[5] + pEigen[7])/5;
			}
			else throw new Exception("02; Cal,cCFV");
			vReturn[2] = ((pEigen[2]) + pEigen[5] + pEigen[7])/5;
			if (pEigen[4] >= 0){
				vReturn[3] = ((2*pEigen[2]) + pEigen[4] + pEigen[7])/5;
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
	public static double calCharMr(int[] pEigen) throws Exception{
		double vReturn = -1;
		
		if (pEigen.length == 8){
			if ((pEigen[0] >= 0) && (pEigen[1] >= 0) && (pEigen[6] >= 0)){
				vReturn = ((pEigen[0]) + pEigen[1] + pEigen[6])/5;
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
	public static double calCharWs(int pKo) throws Exception{
		double vReturn;
		
		if (pKo >= 0) vReturn = pKo/2;
		else throw new Exception("02; Cal,cCWs");
		
		return vReturn;
	}
}
