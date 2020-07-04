/**	DSA_App	v0.0	Dh	2.7.2020
 * 
 * 	Logik
 * 	  Talent
 * 		BasicTalent
 *		  PhysicalTalent
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

import pGUI.MainFrame;

@XmlRootElement(name = "physicaltalent")
public class PhysicalTalent extends Basictalent {
	private int[] eBE;
	
	/**	Dh	2.7.2020
	 * 
	 * 	Konstruktor nach Bean Standart
	 */
	public PhysicalTalent() {
		super();
		
		eBE = new int[] {0, 0};
	}
	/**	Dh	2.7.2020
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
	public PhysicalTalent(int pID, String pName, int[] pPropInds) {
		super(2, pID, pName, pPropInds);
		
		eBE = new int[] {0, 0};
	}
	/**	Dh	2.7.2020
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
	 * @param pEBE
	 */
	public PhysicalTalent(int pID, String pName, int[] pPropInds, int[] pEBE) {
		super(2, pID, pName, pPropInds);
		Exception vExc = null;
		
		if (pEBE != null) {
			if (pEBE.length == 2) {
				if (pEBE[0] >= 0) eBE = pEBE;
				else vExc = new Exception("02; PhTal_b");
			} else vExc = new Exception("01; PhTal_b");
		} else vExc = new Exception("04; PhTal_b");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	2.7.2020
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
	 * @param pEBE
	 * @param pTaW
	 */
	public PhysicalTalent(int pID, String pName, int[] pPropInds, int[] pEBE, int pTaW) {
		super(2, pID, pName, pPropInds, pTaW);
		Exception vExc = null;
		
		if (pEBE != null) {
			if (pEBE.length == 2) {
				if (pEBE[0] >= 0) eBE = pEBE;
				else vExc = new Exception("02; PhTal_c");
			} else vExc = new Exception("01; PhTal_c");
		} else vExc = new Exception("04; PhTal_c");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}

//--------------------------------------------------------------------------------------------------------

	/**	Dh	5.6.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getEBE(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < eBE.length)) {
			return eBE[pInd];
		} throw new Exception("02; PhTal,gEBE");
	}
	/**	Dh	5.6.2020
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "BehinderungsWerteArray")
	@XmlElement(name = "Behinderungswerte")
	public int[] getEBE() {
		return eBE;
	}
	
	/**	Dh	5.6.2020
	 * 
	 * @param pEBEValue
	 * @param pInd
	 * @throws Exception
	 */
	public void setEBE(int pEBEValue, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < eBE.length))
			if ((pInd != 0) || (pEBEValue >= 0)) eBE[pInd] = pEBEValue;
			else throw new Exception("02; PhTal,sEBE");
		else throw new Exception("02; PhTal,sEBE");
	}
	/**	Dh	5.6.2020
	 * 
	 * @param pEBE
	 * @throws Exception
	 */
	public void setEBE(int[] pEBE) throws Exception{
		if (pEBE != null) {
			if (pEBE.length == 2) {
				if (pEBE[0] >= 0) eBE = pEBE;
				else throw new Exception("02; PhTal,sEBE");
			} else throw new Exception("01; PhTal,sEBE");
		} else throw new Exception("04; PhTal,sEBE");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	5.6.2020
	 * 
	 */
	public int makeProbe(int[] pProps) throws Exception{
		int vEBE = (1*eBE[0])+eBE[1]; 
		return super.makeProbe(pProps, -vEBE);
	}
	/**	Dh	5.6.2020
	 * 
	 */
	public int makeProbe(int[] pProps, int pMod) throws Exception{
		int vEBE = (1*eBE[0])+eBE[1]; 
		return super.makeProbe(pProps, pMod-vEBE);
	}
	/**	Dh	5.6.2020
	 * 
	 */
	public int makeProbe(int[] pProps, int[] pRolls) throws Exception{
		int vEBE = (1*eBE[0])+eBE[1];
		return super.makeProbe(pProps, pRolls, -vEBE);
	}
	/**	Dh	5.6.2020
	 * 
	 */
	public int makeProbe(int[] pProps, int[] pRolls, int pMod) throws Exception{
		int vEBE = (1*eBE[0])+eBE[1];
		return super.makeProbe(pProps, pRolls, pMod-vEBE);
	}
	
}
