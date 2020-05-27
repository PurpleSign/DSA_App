/**	DSA_App	v0.0	Dh	5.5.2020
 * 
 * 	Logik
 * 	  NeighbourElement
 * 
 * 	Ein Listen-Node-Object, welches das Nachbarschaftsverhaehltnis in einem Kampf beinhaltet.
 * 		Es beinhaltet die Information ob die entsprechende Nachbar*In feindlich, oder nicht feindlich, 
 * 		ist, in welcher Distanzklasse sich dieser befindet und welche Kampfmopdifikationen bezüglich 
 * 		dieser spezifischen Nachbar*In gelten.
 * 
 * 	FightMods:
 * 	  0 Ini-Basiswert		2 Parade-Basiswert
 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
 * 
 * 	Distance:
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
 * 	  08 Equal Object Error
 */
package pLogik;

public class NeighbourElement {
	private boolean Enemy;
	private int ID, Distance;							// ID der Nachbar*In des kämpfenden.
	private double[] FightMods;
	
	/**	Dh	30.4.2020
	 */
	public NeighbourElement() {
		ID = -1;
		Enemy = false;
		Distance = -1;
		FightMods = new double[4];
	}
	/**	Dh	13.2.2020
	 * 
	 * @param pID
	 * @param pEnemy
	 */
	public NeighbourElement(int pID, boolean pEnemy){
		Exception vExc;
		
		Enemy = pEnemy;
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; NeEle, NE_a");
		
		Distance = 1;
		
		FightMods = new double[4];
		for (int i=0; i<FightMods.length; i++){
			FightMods[i] = 0;
		}
	}
	/**	Dh	13.2.2020
	 * 
	 * 	Distance:
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
		
		Enemy = pEnemy;
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; NeEle, NE_b");
		
		if (pDistance >= 0) Distance = pDistance;
		else vExc = new Exception("02; NeEle, NE_b");
		
		FightMods = new double[4];
		for (int i=0; i<FightMods.length; i++){
			FightMods[i] = 0;
		}
	}
	/**	Dh	5.5.2020
	 * 
	 * 	FightMods:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pID
	 * @param pEnemy
	 * @param pFightMods
	 */
	public NeighbourElement(int pID, boolean pEnemy, double[] pFightMods){
		Exception vExc;
		
		Enemy = pEnemy;
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; NeEle, NE_c");
		
		Distance = 1;
		
		if (pFightMods.length == 4) {
			FightMods = pFightMods;
			
			if (FightMods[0] != 0) {
				FightMods[0] = 0;
				vExc = new Exception("02b; NeEle, NE_c");
			}
		}
		else vExc = new Exception("01; NeEle, NE_c");
	}
	/**	Dh	5.5.2020
	 * 
	 * 	Distance:
	 * 	  0 Handgemenge
	 * 	  1 Nahkampf
	 * 	  2 Hellebarde
	 *    3 Pike
	 *    >4 Angabe in Schritt
	 *    
	 *	FightMods:
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
		
		Enemy = pEnemy;
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; NeEle, NE_d");
		
		if (pDistance >= 0) Distance = pDistance;
		else vExc = new Exception("02; NeEle, NE_d");
		
		if (pFightMods.length == 4) {
			FightMods = pFightMods;
			
			if (FightMods[0] != 0) {
				FightMods[0] = 0;
				vExc = new Exception("02b; NeEle, NE_d");
			}
		}
		else vExc = new Exception("01; NeEle, NE_d");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	13.2.2020
	 * 
	 * @return
	 */
	public boolean getEnemy(){
		return Enemy;
	}
	/**	Dh	13.2.2020
	 * 
	 * @return
	 */
	public int getID(){
		return ID;
	}
	/**	Dh	13.2.2020
	 * 
	 * 	Distance:
	 * 	  0 Handgemenge
	 * 	  1 Nahkampf
	 * 	  2 Hellebarde
	 *    3 Pike
	 *    >4 Angabe in Schritt
	 * 
	 * @return
	 */
	public int getDistance(){
		return Distance;
	}
	
	/**	Dh	13.2.2020
	 * 
	 * 	FightMods:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public double getFightMod(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < FightMods.length)){
			return FightMods[pInd];
		}else throw new Exception("07; NeEle,gFM");
	}
	/**	Dh	13.2.2020
	 * 
	 * 	FightMods:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @return
	 */
	public double[] getFightMods(){
		return FightMods;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	13.2.2020
	 * 	
	 * @param pEnemy
	 */
	public void setEnemy(boolean pEnemy){
		Enemy = pEnemy;
	}
	/**	Dh	30.4.2020
	 * 
	 * @param pID
	 */
	public void setID(int pID) throws Exception{
		if (pID >= 0) ID = pID;
		else throw new Exception("02; NeEle,sID");
	}
	/**	Dh	13.2.2020
	 * 
	 * 	Distance:
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
		if (pDistance >= 0) Distance = pDistance;
		else throw new Exception("02; NeEle,sDi");
	}
	
	/**	Dh	5.5.2020
	 * 
	 * 	Setzt die FightMods außer den Ini-Basiswert.
	 * 
	 * 	FightMods:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pFightMod
	 * @param pInd
	 * @throws Exception
	 */
	public void setFightMod(double pFightMod, int pInd) throws Exception{
		if ((pInd > 0) && (pInd < FightMods.length)) FightMods[pInd] = pFightMod;
		else throw new Exception("07; NeEle,sFM");
	}
	/**	Dh	5.5.2020
	 * 	
	 * 	Setzt die FightMods, außer den Ini-Basiswert.
	 * 
	 * 	FightMods:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pFightMods
	 * @throws Exception
	 */
	public void setFightMods(double[] pFightMods) throws Exception{
		if (pFightMods.length == FightMods.length) {
			FightMods = pFightMods;
			if (FightMods[0] != 0) {
				FightMods[0] = 0;
				throw new Exception("02b; NeEle,sFMs");
			}
		}
		else throw new Exception("01; NeEle,sFMs");
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	5.5.2020
	 * 
	 * @return
	 */
	public boolean isEnemy() {
		return Enemy;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	5.5.2020
	 * 
	 * 	Addiert den Wert zu den FightMods außer den Ini-Basiswert.
	 * 
	 * 	FightMods:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pFightMod
	 * @param pInd
	 * @throws Exception
	 */
	public void addFightMod(double pFightMod, int pInd) throws Exception{
		if ((pInd > 0) && (pInd < FightMods.length)) FightMods[pInd] += pFightMod;
		else throw new Exception("07; NeEle,sFM");
	}
	/**	Dh	13.2.2020
	 * 
	 * 	Addiert die FightMods, außer den Ini-Basiswert.
	 * 
	 * 	FightMods:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * @param pFightMods
	 * @throws Exception
	 */
	public void addFightMods(double[] pFightMods) throws Exception{
		if (pFightMods.length == FightMods.length) {
			for (int i=1; i<FightMods.length; i++){
				FightMods[i] += pFightMods[i];
			}
			
			if (pFightMods[0] != 0) throw new Exception("02b; NeEle,sFMs");
		}
		else throw new Exception("01; NeEle,sFMs");
	}
}
