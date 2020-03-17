/**	DSA_App	v0.0	Dh	12.2.2020
 * 
 * 	Logik
 * 	  NeighbourElement
 * 
 * 	zaFightMods:
 * 	  0 Ini-Basiswert		2 Parade-Basiswert
 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
 * 
 * 	zDistance:
 * 	  0 Handgemenge
 * 	  1 Nahkampf
 * 	  2 Hellebarde
 *    3 Pike
 *    >4 Angabe in Schritt
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

public class NeighbourElement {
	boolean zEnemy;
	int zID, zDistance;
	double[] zaFightMods;
	
	/**	Dh	13.2.2020
	 * 
	 * @param pID
	 * @param pEnemy
	 */
	public NeighbourElement(int pID, boolean pEnemy){
		Exception vExc;
		
		zEnemy = pEnemy;
		if (pID >= 0) zID = pID;
		else vExc = new Exception("02; NeEle, NE_a");
		
		zDistance = 1;
		
		zaFightMods = new double[4];
		for (int i=0; i<zaFightMods.length; i++){
			zaFightMods[i] = 0;
		}
	}
	/**	Dh	13.2.2020
	 * 
	 * 	zDistance:
	 * 	  0 Handgemenge
	 * 	  1 Nahkampf
	 * 	  2 Hellebarde
	 *    3 Pike
	 *    >4 Angabe in Schritt
	 * 
	 * @param pID
	 * @param pEnemy
	 * @param pDistance
	 */
	public NeighbourElement(int pID, boolean pEnemy, int pDistance){
		Exception vExc;
		
		zEnemy = pEnemy;
		if (pID >= 0) zID = pID;
		else vExc = new Exception("02; NeEle, NE_b");
		
		if (pDistance >= 0) zDistance = pDistance;
		else vExc = new Exception("02; NeEle, NE_b");
		
		zaFightMods = new double[4];
		for (int i=0; i<zaFightMods.length; i++){
			zaFightMods[i] = 0;
		}
	}
	/**	Dh	13.2.2020
	 * 
	 * 	zaFightMods:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pID
	 * @param pEnemy
	 * @param pFightMods
	 */
	public NeighbourElement(int pID, boolean pEnemy, double[] pFightMods){
		Exception vExc;
		
		zEnemy = pEnemy;
		if (pID >= 0) zID = pID;
		else vExc = new Exception("02; NeEle, NE_c");
		
		zDistance = 1;
		
		if (pFightMods.length == 4) zaFightMods = pFightMods;
		else vExc = new Exception("01; NeEle, NE_c");
	}
	/**	Dh	13.2.2020
	 * 
	 * 	zDistance:
	 * 	  0 Handgemenge
	 * 	  1 Nahkampf
	 * 	  2 Hellebarde
	 *    3 Pike
	 *    >4 Angabe in Schritt
	 *    
	 *	zaFightMods:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pID
	 * @param pEnemy
	 * @param pDistance
	 * @param pFightMods
	 */
	public NeighbourElement(int pID, boolean pEnemy, int pDistance, double[] pFightMods){
		Exception vExc;
		
		zEnemy = pEnemy;
		if (pID >= 0) zID = pID;
		else vExc = new Exception("02; NeEle, NE_d");
		
		if (pDistance >= 0) zDistance = pDistance;
		else vExc = new Exception("02; NeEle, NE_d");
		
		if (pFightMods.length == 4) zaFightMods = pFightMods;
		else vExc = new Exception("01; NeEle, NE_d");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	13.2.2020
	 * 
	 * @return
	 */
	public boolean getEnemy(){
		return zEnemy;
	}
	/**	Dh	13.2.2020
	 * 
	 * @return
	 */
	public int getID(){
		return zID;
	}
	/**	Dh	13.2.2020
	 * 
	 * 	zDistance:
	 * 	  0 Handgemenge
	 * 	  1 Nahkampf
	 * 	  2 Hellebarde
	 *    3 Pike
	 *    >4 Angabe in Schritt
	 * 
	 * @return
	 */
	public int getDinstance(){
		return zDistance;
	}
	
	/**	Dh	13.2.2020
	 * 
	 * 	zaFightMods:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public double getFightMod(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < zaFightMods.length)){
			return zaFightMods[pInd];
		}else throw new Exception("07; NeEle,gFM");
	}
	/**	Dh	13.2.2020
	 * 
	 * 	zaFightMods:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @return
	 */
	public double[] getFightMods(){
		return zaFightMods;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	13.2.2020
	 * 	
	 * @param pEnemy
	 */
	public void setEnemy(boolean pEnemy){
		zEnemy = pEnemy;
	}
	/**	Dh	13.2.2020
	 * 
	 * 	zDistance:
	 * 	  0 Handgemenge
	 * 	  1 Nahkampf
	 * 	  2 Hellebarde
	 *    3 Pike
	 *    >4 Angabe in Schritt
	 * 
	 * @param pDistance
	 * @throws Exception
	 */
	public void setDistance(int pDistance) throws Exception{
		if (pDistance >= 0) zDistance = pDistance;
		else throw new Exception("02; NeEle,sDi");
	}
	
	/**	Dh	13.2.2020
	 * 
	 * 	zaFightMods:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pFightMod
	 * @param pInd
	 * @throws Exception
	 */
	public void setFightMod(double pFightMod, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < zaFightMods.length)) zaFightMods[pInd] = pFightMod;
		else throw new Exception("07; NeEle,sFM");
	}
	/**	Dh	13.2.2020
	 * 
	 * 	zaFightMods:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pFightMods
	 * @throws Exception
	 */
	public void setFightMods(double[] pFightMods) throws Exception{
		if (pFightMods.length == zaFightMods.length) zaFightMods = pFightMods;
		else throw new Exception("01; NeEle,sFMs");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	13.2.2020
	 * 
	 * 	zaFightMods:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pFightMod
	 * @param pInd
	 * @throws Exception
	 */
	public void addFightMod(double pFightMod, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < zaFightMods.length)) zaFightMods[pInd] += pFightMod;
		else throw new Exception("07; NeEle,sFM");
	}
	/**	Dh	13.2.2020
	 * 
	 * 	zaFightMods:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pFightMods
	 * @throws Exception
	 */
	public void addFighMods(double[] pFightMods) throws Exception{
		if (pFightMods.length == zaFightMods.length) {
			for (int i=0; i<zaFightMods.length; i++){
				zaFightMods[i] += pFightMods[i];
			}
		}
		else throw new Exception("01; NeEle,sFMs");
	}
}
