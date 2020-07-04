/**	DSA_App v0.0	Dh	 1.7.2020
 * 	
 * 	Logik
 * 	  Pro
 * 		ValuedPro (Valued)
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
 * 	  09 Wrong Selection
 **/
package pLogik;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import pGUI.MainFrame;

@XmlRootElement(name = "valuedpro")
@XmlSeeAlso({BadCharacteristic.class, StringedValuedPro.class})
@XmlType(propOrder = {"value", "valueLimit"})
public class ValuedPro extends Pro implements Valued {
	protected int Value, ValueLimit;
	
	/**	Dh	1.7.2020
	 * 
	 * 	Konstruktor nach Bean-Standart
	 */
	public ValuedPro() {
		super();
		
		Value = 0;
		ValueLimit = -1;
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pID
	 * @param pName
	 */
	public ValuedPro(int pID, String pName, int pValueLimit) {
		super(pID, pName);
		Exception vExc = null;
		
		Value = 0;
		if (pValueLimit >= -1) ValueLimit = pValueLimit;
		else vExc = new Exception("02; VaPro_a");
		
		if (vExc != null) System.out.println(vExc.getMessage());
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pPro
	 */
	public ValuedPro(int pID, String pName, int pValueLimit, boolean pPro) {
		super(pID, pName, pPro);
		Exception vExc = null;
		
		Value = 0;
		if (pValueLimit >= -1) ValueLimit = pValueLimit;
		else vExc = new Exception("02; VaPro_b");
		
		if (vExc != null) System.out.println(vExc.getMessage());
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pPro
	 * @param pArkane
	 */
	public ValuedPro(int pID, String pName, int pValueLimit, boolean pPro, boolean pArkane) {
		super(pID, pName, pPro, pArkane);
		Exception vExc = null;
		
		Value = 0;
		if (pValueLimit >= -1) ValueLimit = pValueLimit;
		else vExc = new Exception("02; VaPro_c");
		
		if (vExc != null) System.out.println(vExc.getMessage());
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pPro
	 * @param pArkane
	 * @param pGift
	 */
	public ValuedPro(int pID, String pName, int pValueLimit, boolean pPro, boolean pArkane, boolean pGift) {
		super(pID, pName, pPro, pArkane, pGift);
		Exception vExc = null;
		
		Value = 0;
		if (pValueLimit >= -1) ValueLimit = pValueLimit;
		else vExc = new Exception("02; VaPro_d");
		
		if (vExc != null) System.out.println(vExc.getMessage());
	}
	/**	Dh	1.7.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pPro
	 * @param pArkane
	 * @param pGift
	 * @param pValue
	 */
	public ValuedPro(int pID, String pName, int pValueLimit, boolean pPro, boolean pArkane, boolean pGift,int pValue) {
		super(pID, pName, pPro, pArkane, pGift);
		Exception vExc = null ;
		
		if (pValue >= 0) Value = pValue;
		else vExc = new Exception("02; VaPro_e");
		if (pValueLimit >= -1) ValueLimit = pValueLimit;
		else vExc = new Exception("02; VaPro_e");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	17.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Value")
	public int getValue() {
		return Value;
	}
	
	/**	Dh	1.7.2020
	 * 
	 */
	@XmlElement(name = "ValueLimit")
	public int getValueLimit() {
		return ValueLimit;
	}
		
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	1.7.2020
	 * 
	 * @param pValue
	 * @throws Exception
	 */
	public void setValue(int pValue) throws Exception{
		if ((pValue >= 0) && ((pValue <= ValueLimit) || (ValueLimit == -1))) Value = pValue;
		else throw new Exception("02; VaPro,sV");
	}
	
	/**	Dh	1.7.2020
	 * 
	 */
	public void setValueLimit(int pValueLimit) throws Exception{
		if (pValueLimit >= -1) ValueLimit = pValueLimit;
		else throw new Exception("02; VaPro,sVL");
	}
		
//--------------------------------------------------------------------------------------------------------
		
	/**	Dh	1.7.2020
	 * 
	 * @param pValue
	 * @throws Exception
	 */
	public void addValue(int pValue) throws Exception{
		if (((pValue + Value) >= 0) && ((pValue+ Value) <= ValueLimit ) || (ValueLimit == -1)) Value += pValue;
		else {
			Value = 0;
			throw new Exception("02 VaPro,aV");
		}
	}

}
