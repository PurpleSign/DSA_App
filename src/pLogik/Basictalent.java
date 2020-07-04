/**	DSA_App	v0.0	Dh	2.7.2020
 * 
 * 	Logik
 * 	  Talent
 * 		BasicTalent
 * 
 * Properties: 
 * 	  0 Mut					4 Fingerfertigkeit
 * 	  1 Klugkheit			5 Gewandheit
 * 	  2 Intuition			6 Konstitution
 * 	  3 Charisma			7 Koerperkraft
 * 
 * 	Types:
 * 	  00: Nahkampf				05: Wissens
 * 	  01: Fernkampf				06: Sprache
 * 	  02: Koerperliche			07: Handwerks
 * 	  03: Gesellschaftliche		08: Alle Kampf
 * 	  04: Natur					09: Alle mundan nicht Kampf
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
**/
package pLogik;

import java.util.Random;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import pGUI.MainFrame;

@XmlRootElement(name = "basictalent")
@XmlSeeAlso({PhysicalTalent.class, Communicationtalent.class})
public class Basictalent extends Talent {
	private int[] PropInds;
	
	/**	Dh	5.6.2020
	 * 
	 * 	Beans Standard Konstruktor
	 */
	public Basictalent() {
		super();
		
		PropInds = new int[] {-1, -1, -1};
	}
	/**	Dh	2.7.2020
	 * 
	 * Properties: 
	 * 	  0 Mut					4 Fingerfertigkeit
	 * 	  1 Klugkheit			5 Gewandheit
	 * 	  2 Intuition			6 Konstitution
	 * 	  3 Charisma			7 Koerperkraft
	 * 
	 * 	Types:
	 * 	  00: Nahkampf				05: Wissens
	 * 	  01: Fernkampf				06: Sprache
	 * 	  02: Koerperliche			07: Handwerks
	 * 	  03: Gesellschaftliche		08: Alle Kampf
	 * 	  04: Natur					09: Alle mundan nicht Kampf
	 * 
	 * @param pID
	 * @param pName
	 * @param pPropInds
	 */
	public Basictalent(int pType, int pID, String pName, int[] pPropInds) {
		super(pType, pID, pName);
		Exception vExc = null;
		
		if (pPropInds != null) {
			if (pPropInds.length == 3) {
				if ((pPropInds[0] >= 0) && (pPropInds[1] >= 0) && (pPropInds[2] >= 0) && (pPropInds[0] < 8)
						&& (pPropInds[1] < 8) && (pPropInds[2] < 8)) PropInds = pPropInds;
				else vExc = new Exception("02; BaTal_a");
			} else vExc = new Exception("01; BaTal_a");
		} else vExc = new Exception("04; BaTal_a");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	2.7.2020
	 * 
	 * 	Properties: 
	 * 	  0 Mut					4 Fingerfertigkeit
	 * 	  1 Klugkheit			5 Gewandheit
	 * 	  2 Intuition			6 Konstitution
	 * 	  3 Charisma			7 Koerperkraft
	 * 
	 * 	Types:
	 * 	  00: Nahkampf				05: Wissens
	 * 	  01: Fernkampf				06: Sprache
	 * 	  02: Koerperliche			07: Handwerks
	 * 	  03: Gesellschaftliche		08: Alle Kampf
	 * 	  04: Natur					09: Alle mundan nicht Kampf
	 * 
	 * @param pID
	 * @param pName
	 * @param pPropInds
	 * @param pTaW
	 */
	public Basictalent(int pType, int pID, String pName, int[] pPropInds, int pTaW) {
		super(pType, pID, pName, pTaW);
		Exception vExc = null;
		
		if (pPropInds != null) {
			if (pPropInds.length == 3) {
				if ((pPropInds[0] >= 0) && (pPropInds[1] >= 0) && (pPropInds[2] >= 0) && (pPropInds[0] < 8)
						&& (pPropInds[1] < 8) && (pPropInds[2] < 8)) PropInds = pPropInds;
				else vExc = new Exception("02; BaTal_b");
			} else vExc = new Exception("01; BaTal_b");
		} else vExc = new Exception("04; BaTal_b");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	5.6.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getPropInd(int pInd) throws Exception {
		if ((pInd >= 0) && (pInd < PropInds.length)) {
			return PropInds[pInd];
		} else throw new Exception("02; BaTal,gPI");
	}
	/**	Dh	5.6.2020
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "PropertieIndiceArray")
	@XmlElement(name = "PropertieIndice")
	public int[] getPropInds() {
		return PropInds;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	5.6.2020
	 * 
	 * @param pPropInd
	 * @param pInd
	 * @throws Exception
	 */
	public void setPropInd(int pPropInd, int pInd) throws Exception{
		if ((pInd >= 0) && (pPropInd >= 0) && (pPropInd < 8) && (pInd < PropInds.length)) PropInds[pInd] = pPropInd;
		else throw new Exception("02; BaTal,sPI");
	}
	/**	Dh	5.6.2020
	 * 
	 * @param pPropInds
	 * @throws Exception
	 */
	public void setPropInds(int[] pPropInds) throws Exception{
		if (pPropInds != null) {
			if (pPropInds.length == PropInds.length) {
				if ((pPropInds[0] >= 0) && (pPropInds[1] >= 0) && (pPropInds[2] >= 0) && (pPropInds[0] < 8)
						&& (pPropInds[1] < 8) && (pPropInds[2] < 8)) PropInds = pPropInds;
				else throw new Exception("02; BaTal,sPIs");
			} else throw new Exception("01; BaTal,sPIs");
		} else throw new Exception("04; BaTal,sPIs");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	10.6.2020
	 * 
	 * @param pProps
	 * @return
	 * @throws Exception
	 */
	public int makeProbe(int[] pProps) throws Exception{
		return makeProbe(pProps, Calculator.makeDiceRolls(pProps.length, 20), 0);
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pProps
	 * @param pMod
	 * @return
	 * @throws Exception
	 */
	public int makeProbe(int[] pProps, int pMod) throws Exception{
		return makeProbe(pProps, Calculator.makeDiceRolls(pProps.length, 20), pMod);
	}
	/**	Dh	5.6.2020
	 * 
	 * @param pProps
	 * @param pRolls
	 * @return
	 * @throws Exception
	 */
	public int makeProbe(int[] pProps, int[] pRolls) throws Exception{
		return makeProbe(pProps, pRolls, 0);
	}
	/**	Dh	5.6.2020
	 * 
	 * @param pProps
	 * @param pRolls
	 * @param pMod
	 * @return
	 * @throws Exception
	 */
	public int makeProbe(int[] pProps, int[] pRolls, int pMod) throws Exception{
		int vDiff, vTaW, vTaWMod;
		int vTaP = -1;
		
		if (pProps != null) {
			if ((pProps.length == PropInds.length) && (pRolls.length == PropInds.length)) {
				vTaW = TaW+pMod;
				vTaP = 0;
				if (vTaW < 0) vTaWMod = vTaW;
				else vTaWMod = 0;
				
				for (int i=0; i < PropInds.length; i++) {
					vDiff = pProps[i] - pRolls[i] + vTaWMod;
					
					if (vDiff < 0) vTaP += vDiff;
				}
				
				if (vTaW >= 0) {
					if (-vTaP == vTaW) vTaP = 1;
					else vTaP += vTaW;
				} else if (vTaP == 0) vTaP = 1;
			} else throw new Exception("01; BaTal,mP");
		} else throw new Exception("04; BaTal,mP");
		
		return vTaP;
	}
}
