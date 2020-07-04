/**	DSA_App v0.0	Dh	 16.6.2020
 * 	
 * 	Logik
 * 	  Pro
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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import pGUI.MainFrame;

@XmlRootElement(name = "pro")
@XmlType(propOrder = {"name", "pro", "arkane", "gift"})
@XmlSeeAlso({ValuedPro.class, ReferredPro.class, StringedPro.class})
public class Pro {
	protected boolean Pro, Arkane, Gift;
	protected int ID;
	protected String Name;
	
	/**	Dh	16.6.2020
	 * 
	 */
	public Pro() {
		Pro = true;
		Arkane = false;
		Gift = false;
		ID = -1;
		Name = "";
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pID
	 * @param pName
	 */
	public Pro(int pID, String pName) {
		Exception vExc = null ;
		
		Pro = true;
		Arkane = false;
		Gift = false;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; Pro_a");
		
		if (!pName.equals("")) Name = pName;
		else vExc = new Exception("02; Pro_a");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pIsPro
	 */
	public Pro(int pID, String pName, boolean pPro) {
		Exception vExc = null ;
		
		Pro = pPro;
		Arkane = false;
		Gift = false;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; Pro_b");
		
		if (!(pName.equals(""))) Name = pName;
		else vExc = new Exception("02; Pro_b2:"+pName+","+ID);
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pPro
	 * @param pArkane
	 */
	public Pro(int pID, String pName, boolean pPro, boolean pArkane) {
		Exception vExc = null ;
		
		Pro = pPro;
		Arkane = pArkane;
		Gift = false;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; Pro_c");
		
		if (!pName.equals("")) Name = pName;
		else vExc = new Exception("02; Pro_c");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pPro
	 * @param pArkane
	 * @param pGift
	 */
	public Pro(int pID, String pName, boolean pPro, boolean pArkane, boolean pGift) {
		Exception vExc = null ;
		
		Pro = pPro;
		Arkane = pArkane;
		Gift = pGift;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; Pro_d");
		
		if (!pName.equals("")) Name = pName;
		else vExc = new Exception("02; Pro_d");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	16.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Pro")
	public boolean isPro() {
		return Pro;
	}
	/**	Dh	16.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Arkane")
	public boolean isArkane() {
		return Arkane;
	}
	/**	Dh	16.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Gift")
	public boolean isGift() {
		return Gift;
	}
	
	/**	Dh	16.6.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public int getID() {
		return ID;
	}
	/**	Dh	16.2.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Name")
	public String getName() {
		return Name;
	}

	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	16.6.2020
	 * 
	 * @param pPro
	 */
	public void setPro(boolean pPro) {
		Pro = pPro;
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pArkane
	 */
	public void setArkane(boolean pArkane) {
		Arkane = pArkane;
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pGift
	 */
	public void setGift(boolean pGift) {
		Gift = pGift;
	}
	
	/**	Dh	16.6.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void setID(int pID) throws Exception{
		if (pID >= 0) ID = pID;
		else throw new Exception("02; Pro,sID");
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pName
	 * @throws Exception
	 */
	public void setName(String pName) throws Exception{
		if (!pName.equals("")) Name = pName;
		else throw new Exception("02; Pro,sN");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	
}
