/**	DSA_App	v0.0	Dh	5.6.2020
 * 
 * 	Logik
 * 	  Talent
 * 		BasicTalent
 *		  Communicationtalent
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
	private boolean Language;
	private int Complexity;
	
	/**	Dh	5.6.2020
	 * 
	 */
	public Communicationtalent() {
		Language = false;
		Complexity = -1;
	}
	/**	Dh	5.6.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pLanguage
	 * @param pComplexity
	 */
	public Communicationtalent(int pID, String pName, boolean pLanguage, int pComplexity) {
		super(pID, pName, new int[] {1, 2, 3});
		Exception vExc = null;
		
		Language = pLanguage;
		try { if (pLanguage == false) setPropInds(new int[] {1, 1, 4});}
		catch (Exception ex) {vExc = ex;}
		
		if (pComplexity > 0) Complexity = pComplexity;
		else vExc = new Exception("02; CoTal_a");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	5.6.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pLanguage
	 * @param pComplexity
	 * @param pTaW
	 */
	public Communicationtalent(int pID, String pName, boolean pLanguage, int pComplexity, int pTaW) {
		super(pID, pName, new int[] {1, 2, 3}, pTaW);
		Exception vExc = null;
		
		Language = pLanguage;
		try { if (pLanguage == false) setPropInds(new int[] {1, 1, 4});}
		catch (Exception ex) {vExc = ex;}
		
		if (pComplexity > 0) Complexity = pComplexity;
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
		return Language;
	}
	/**	Dh	5.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Complexity")
	public int getComplexity() {
		return Complexity;
	}
	
	/**	Dh	5.6.2020
	 * 
	 * @param pLanguage
	 */
	public void setLanguage(boolean pLanguage) {
		Language = pLanguage;
	}
	/**	Dh	5.6.2020
	 * 
	 * @param pComplexity
	 * @throws Exception
	 */
	public void setComplexity(int pComplexity) throws Exception{
		if (pComplexity > 0) Complexity = pComplexity;
		else throw new Exception("02; CoTal,sC");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	
}
