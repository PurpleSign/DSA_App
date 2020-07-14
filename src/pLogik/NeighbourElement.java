/**	DSA_App	v0.0	Dh	11.6.2020
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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "neighbourelement")
@XmlType(propOrder = {"distance", "fightMods"})
public class NeighbourElement {
	private boolean isEnemy;
	private int id, distance;							// ID der Nachbar*In des kämpfenden.
	private double[] fightMods;
	
	/**	Dh	30.4.2020
	 */
	public NeighbourElement() {
		id = -1;
		isEnemy = false;
		distance = -1;
		fightMods = new double[4];
	}
	/**	Dh	13.2.2020
	 * 
	 * @param pID
	 * @param pEnemy
	 */
	public NeighbourElement(int pID, boolean pEnemy){
		Exception vExc;
		
		isEnemy = pEnemy;
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; NeEle, NE_a");
		
		distance = 1;
		
		fightMods = new double[4];
		for (int i=0; i<fightMods.length; i++){
			fightMods[i] = 0;
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
		
		isEnemy = pEnemy;
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; NeEle, NE_b");
		
		if (pDistance >= 0) distance = pDistance;
		else vExc = new Exception("02; NeEle, NE_b");
		
		fightMods = new double[4];
		for (int i=0; i<fightMods.length; i++){
			fightMods[i] = 0;
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
		
		isEnemy = pEnemy;
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; NeEle, NE_c");
		
		distance = 1;
		
		if (pFightMods.length == 4) {
			fightMods = pFightMods;
			
			if (fightMods[0] != 0) {
				fightMods[0] = 0;
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
		
		isEnemy = pEnemy;
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; NeEle, NE_d");
		
		if (pDistance >= 0) distance = pDistance;
		else vExc = new Exception("02; NeEle, NE_d");
		
		if (pFightMods.length == 4) {
			fightMods = pFightMods;
			
			if (fightMods[0] != 0) {
				fightMods[0] = 0;
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
	@XmlAttribute
	public int getId(){
		return id;
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
	@XmlElement(name = "Distance")
	public int getDistance(){
		return distance;
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
		if ((pInd >= 0) && (pInd < fightMods.length)){
			return fightMods[pInd];
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
	@XmlElementWrapper(name = "FightModArray")
	@XmlElement(name = "FightMod")
	public double[] getFightMods(){
		return fightMods;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	13.2.2020
	 * 	
	 * @param pEnemy
	 */
	public void setEnemy(boolean pEnemy){
		isEnemy = pEnemy;
	}
	/**	Dh	30.4.2020
	 * 
	 * @param pID
	 */
	public void setId(int pID) throws Exception{
		if (pID >= 0) id = pID;
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
		if (pDistance >= 0) distance = pDistance;
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
		if ((pInd > 0) && (pInd < fightMods.length)) fightMods[pInd] = pFightMod;
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
		if (pFightMods.length == fightMods.length) {
			fightMods = pFightMods;
			if (fightMods[0] != 0) {
				fightMods[0] = 0;
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
	@XmlAttribute
	public boolean isEnemy() {
		return isEnemy;
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
		if ((pInd > 0) && (pInd < fightMods.length)) fightMods[pInd] += pFightMod;
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
		if (pFightMods.length == fightMods.length) {
			for (int i=1; i<fightMods.length; i++){
				fightMods[i] += pFightMods[i];
			}
			
			if (pFightMods[0] != 0) throw new Exception("02b; NeEle,sFMs");
		}
		else throw new Exception("01; NeEle,sFMs");
	}
}
