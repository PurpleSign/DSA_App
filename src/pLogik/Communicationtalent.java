/**	DSA_App	v0.0	Dh	2.7.2020
 * 
 * 	Logik
 * 	  Talent
 * 		BasicTalent
 *		  Communicationtalent
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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import pGUI.MainFrame;

@XmlRootElement(name = "communicationtalent")
public class Communicationtalent extends Basictalent {
	private boolean isLanguage;
	private int complexity;
	
	/**	Dh	2.7.2020
	 * 
	 */
	public Communicationtalent() {
		super();
		
		isLanguage = false;
		complexity = -1;
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
	 * @param pLanguage
	 * @param pComplexity
	 */
	public Communicationtalent(int pID, String pName, boolean pLanguage, int pComplexity) {
		super(6, pID, pName, new int[] {1, 2, 3});
		Exception vExc = null;
		
		isLanguage = pLanguage;
		try { if (pLanguage == false) setPropInds(new int[] {1, 1, 4});}
		catch (Exception ex) {vExc = ex;}
		
		if (pComplexity > 0) complexity = pComplexity;
		else vExc = new Exception("02; CoTal_a");
		
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
	 * @param pLanguage
	 * @param pComplexity
	 * @param pTaW
	 */
	public Communicationtalent(int pID, String pName, boolean pLanguage, int pComplexity, int pTaW) {
		super(6, pID, pName, new int[] {1, 2, 3}, pTaW);
		Exception vExc = null;
		
		isLanguage = pLanguage;
		try { if (pLanguage == false) setPropInds(new int[] {1, 1, 4});}
		catch (Exception ex) {vExc = ex;}
		
		if (pComplexity > 0) complexity = pComplexity;
		else vExc = new Exception("02; CoTal_a");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	5.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Language")
	public boolean isLanguage() {
		return isLanguage;
	}
	/**	Dh	5.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Complexity")
	public int getComplexity() {
		return complexity;
	}
	
	/**	Dh	5.6.2020
	 * 
	 * @param pLanguage
	 */
	public void setLanguage(boolean pLanguage) {
		isLanguage = pLanguage;
	}
	/**	Dh	5.6.2020
	 * 
	 * @param pComplexity
	 * @throws Exception
	 */
	public void setComplexity(int pComplexity) throws Exception{
		if (pComplexity > 0) complexity = pComplexity;
		else throw new Exception("02; CoTal,sC");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	
}
