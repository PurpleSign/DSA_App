/**	DSA_App v0.0	Dh	 9.7.2020
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
	protected boolean isPro, isArkane, isGift;
	protected int id;
	protected String name;
	
	/**	Dh	16.6.2020
	 * 
	 */
	public Pro() {
		isPro = true;
		isArkane = false;
		isGift = false;
		id = -1;
		name = "";
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pID
	 * @param pName
	 */
	public Pro(int pID, String pName) {
		Exception vExc = null ;
		
		isPro = true;
		isArkane = false;
		isGift = false;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; Pro_a");
		
		if (!pName.equals("")) name = pName;
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
		
		isPro = pPro;
		isArkane = false;
		isGift = false;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; Pro_b");
		
		if (!(pName.equals(""))) name = pName;
		else vExc = new Exception("02; Pro_b2:"+pName+","+id);
		
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
		
		isPro = pPro;
		isArkane = pArkane;
		isGift = false;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; Pro_c");
		
		if (!pName.equals("")) name = pName;
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
		
		isPro = pPro;
		isArkane = pArkane;
		isGift = pGift;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; Pro_d");
		
		if (!pName.equals("")) name = pName;
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
		return isPro;
	}
	/**	Dh	16.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Arkane")
	public boolean isArkane() {
		return isArkane;
	}
	/**	Dh	16.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Gift")
	public boolean isGift() {
		return isGift;
	}
	
	/**	Dh	16.6.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public int getId() {
		return id;
	}
	/**	Dh	16.2.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Name")
	public String getName() {
		return name;
	}

	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	16.6.2020
	 * 
	 * @param pPro
	 */
	public void setPro(boolean pPro) {
		isPro = pPro;
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pArkane
	 */
	public void setArkane(boolean pArkane) {
		isArkane = pArkane;
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pGift
	 */
	public void setGift(boolean pGift) {
		isGift = pGift;
	}
	
	/**	Dh	16.6.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void setId(int pID) throws Exception{
		if (pID >= 0) id = pID;
		else throw new Exception("02; Pro,sID");
	}
	/**	Dh	16.6.2020
	 * 
	 * @param pName
	 * @throws Exception
	 */
	public void setName(String pName) throws Exception{
		if (!pName.equals("")) name = pName;
		else throw new Exception("02; Pro,sN");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	
}
