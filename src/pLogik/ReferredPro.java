/**	DSA_App v0.0	Dh	 9.7.2020
 * 	
 * 	Logik
 * 	  Pro
 * 		ReferredPro (Referred)
 *
 *	ReferredType:
 * 	  0: Eigenschaft	5: Merkmale
 * 	  1: Talente		6: Gift
 * 	  2: Talentgruppen	7: Gift-Gruppe
 * 	  3: Zauber			8: Krankheiten
 * 	  4: Rituale			
 *
 *	Type:
 * 	  0: Allgemein
 * 	  1: Kampf
 * 	  2: Magisch
 * 
 * 	Properties: 
 * 	  0 Mut					4 Fingerfertigkeit
 * 	  1 Klugkheit			5 Gewandheit
 * 	  2 Intuition			6 Konstitution
 * 	  3 Charisma			7 Koerperkraft
 * 
 * Exceptions:
 * 	  01 Wrong length
 * 	  02 Wrong Value
 * 	  03 Calculation Error
 * 	  04 Nullpointer Error
 * 	  05 Empty List Error
 * 	  06 Wrong Type Error
 * 	  07 Index Error
 * 	  08 Equal Object Error
 **/
package pLogik;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import pGUI.MainFrame;

@XmlRootElement(name = "referredpro")
public class ReferredPro extends Pro implements Referred{
	private int[] referredValue;
	
	/**	Dh	17.6.2020
	 * 
	 * 	Konstruktor nach Bean-Vorschrift.
	 */
	public ReferredPro() {
		super();
		
		referredValue = new int[] {-1, -1};
	}
	/**	Dh	17.6.2020
	 * 
	 * @param pID
	 * @param pName
	 */
	public ReferredPro(int pID, String pName) {
		super(pID, pName);
		
		referredValue = new int[] {-1, -1};
	}
	/**	Dh	17.6.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pPro
	 */
	public ReferredPro(int pID, String pName, boolean pPro) {
		super(pID, pName, pPro);
		
		referredValue = new int[] {-1, -1};
	}
	/**	Dh	17.6.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pPro
	 * @param pArkane
	 */
	public ReferredPro(int pID, String pName, boolean pPro, boolean pArkane) {
		super(pID, pName, pPro, pArkane);
		
		referredValue = new int[] {-1, -1};
	}
	/**	Dh	17.6.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pPro
	 * @param pArkane
	 * @param pGift
	 */
	public ReferredPro(int pID, String pName, boolean pPro, boolean pArkane, boolean pGift) {
		super(pID, pName, pPro, pArkane, pGift);
		
		referredValue = new int[] {-1, -1};
	}
	/**	Dh	17.6.2020
	 * 
	 * 	ReferredType:
	 * 	  0: Eigenschaft	5: Merkmale
	 * 	  1: Talente		6: Gift
	 * 	  2: Talentgruppen	7: Gift-Gruppe
	 * 	  3: Zauber			8: Krankheiten
	 * 	  4: Rituale
	 * 
	 * @param pID
	 * @param pName
	 * @param pPro
	 * @param pArkane
	 * @param pGift
	 * @param pReferredValue
	 */
	public ReferredPro(int pID, String pName, boolean pPro, boolean pArkane, boolean pGift, int[] pReferredValue) {
		super(pID, pName, pPro, pArkane, pGift);
		Exception vExc = null ;
		
		try { setReferredValue(pReferredValue);}
		catch (Exception ex) {vExc = ex;}
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	17.6.2020
	 * 
	 * 	ReferredType:
	 * 	  0: Eigenschaft	5: Merkmale
	 * 	  1: Talente		6: Gift
	 * 	  2: Talentgruppen	7: Gift-Gruppe
	 * 	  3: Zauber			8: Krankheiten
	 * 	  4: Rituale
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getReferredValue(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < referredValue.length)) return referredValue[pInd];
		else throw new Exception("02; RePro,gRV");
	}
	/**	Dh	17.6.2020
	 * 
	 * 	ReferredType:
	 * 	  0: Eigenschaft	5: Merkmale
	 * 	  1: Talente		6: Gift
	 * 	  2: Talentgruppen	7: Gift-Gruppe
	 * 	  3: Zauber			8: Krankheiten
	 * 	  4: Rituale
	 * 
	 * @return
	 */
	@XmlElement(name = "ReferredValue")
	public int[] getReferredValue() {
		return referredValue;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	17.6.2020
	 * 
	 * 	ReferredType:
	 * 	  0: Eigenschaft	5: Merkmale
	 * 	  1: Talente		6: Gift
	 * 	  2: Talentgruppen	7: Gift-Gruppe
	 * 	  3: Zauber			8: Krankheiten
	 * 	  4: Rituale
	 * 
	 * @param pValue
	 * @param pInd
	 * @throws Exception
	 */
	public void setReferredValue(int pValue, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < referredValue.length)) {
			if ((pValue >= -1) && (((pInd == 0) && (pValue < 9)) || (pInd == 1))) referredValue[pInd] = pValue;
			else throw new Exception("02; RePro,sRV");
		}else throw new Exception("01; RePro,sRV");
	}
	/**	Dh	17.6.2020
	 * 
	 * 	ReferredType:
	 * 	  0: Eigenschaft	5: Merkmale
	 * 	  1: Talente		6: Gift
	 * 	  2: Talentgruppen	7: Gift-Gruppe
	 * 	  3: Zauber			8: Krankheiten
	 * 	  4: Rituale
	 * 
	 * @param pReferredValue
	 * @throws Exception
	 */
	public void setReferredValue(int[] pReferredValue) throws Exception{
		if (pReferredValue.length == referredValue.length) {
			if ((pReferredValue[0] >= -1) && (pReferredValue[0] < 9) && (pReferredValue[1] >= -1)) referredValue = pReferredValue;
			else throw new Exception("02; RePro,sRV");
		} else throw new Exception("01; RePro,sRv");
	}
	
//--------------------------------------------------------------------------------------------------------

}
