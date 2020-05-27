/**	DSA_App v0.0	Dh 6.5.2020
 * 
 * 	Datenbank
 * 	  Loader
 * 
 * 	zaEigenschaften: 
 * 	  0 Mut					4 Fingerfertigkeit
 * 	  1 Klugkheit			5 Gewandheit
 * 	  2 Intuition			6 Konstitution
 * 	  3 Charisma			7 Koerperkraft
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
 * 
 */

package pDatenbank;

import java.util.Random;

import pLogik.Charakter;
import pLogik.IniElement;

public abstract class Loader {
	
	public static void save(Object pObj) {
		
	}
	
	/**	Dh	6.5.2020
	 * 
	 * 	Erstellt einen Charakter anhand der Type Spezifikation.
	 * 
	 * @param pType
	 * @return
	 * @throws Exception
	 */
	public static Charakter loadNewCharacter(int pType) throws Exception {
		String vName, vRasse;
		int[] vProp;
		Charakter vRet;
		
		vName = "Test"+Integer.toString(pType);
		vRasse = "Tulamide";
		vProp = new int[10];
		
		if (pType == 0) {
			for (int i=0; i<8; i++) {
				vProp[i] = 11;
			}
			vProp[8] = 8;
			vProp[9] = 7;
			
			vRet = new Charakter(vName, vRasse, vProp);
		} else throw new Exception("02; Loa,lNC");
		
		return vRet;
	}
	/**	Dh	6.5.2020
	 * 
	 * 	Erzeugt einen zufaelligen Charakter und gibt ihn zurueck.
	 * 
	 * @return
	 */
	public static Charakter loadNewRandomCharakter() {
		String vName, vRasse;
		int[] vProp;
		Random vRan;
		Charakter vRet;
		vRan = new Random();
		
		vName = "Random"+Integer.toString(vRan.nextInt(100));
		vRasse = "Tulamid";
		vProp = new int[10];
		
		for (int i=0; i<8; i++) {
			vProp[i] = 8+vRan.nextInt(6);
		}
		vProp[8] = 1+vRan.nextInt(13);
		vProp[9] = 6+vRan.nextInt(4);
		
		vRet = new Charakter(vName, vRasse, vProp);
		
		return vRet;
	}
	
//--------------------------------------------------------------------------------------------------------
	

	
//--------------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) {
		
	}
}
