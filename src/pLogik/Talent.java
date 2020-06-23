/**	DSA_App	v0.0	Dh	9.6.2020
 * 
 * 	Logik
 * 	  Talent
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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import pGUI.MainFrame;

@XmlRootElement(name = "talent")
@XmlSeeAlso({Basictalent.class, Fighttalent.class})
public abstract class Talent {
	protected int ID, TaW;
	protected String Name;
	
	/**	Dh	5.6.2020
	 * 
	 * 	Bean Standard Konstruktor
	 */
	public Talent() {
		ID = -1;
		TaW = 0;
		
		Name = "";
	}
	/**	Dh	5.6.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pGainType
	 */
	public Talent(int pID, String pName) {
		Exception vExc = null;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; Tal_a");
		TaW = 0;
		
		if ((pName != null) && (pName != "")) Name = pName;
		else vExc =  new Exception("02; Tal_a");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	5.6.2020
	 * 
	 * @param pID
	 * @param pName
	 * @param pGainType
	 * @param pTaW
	 */
	public Talent(int pID, String pName, int pTaW) {
		Exception vExc = null;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; Tal_b");
		TaW = pTaW;
		
		if ((pName != null) && (pName != "")) Name = pName;
		else vExc =  new Exception("02; Tal_b");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	5.6.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public int getID() {
		return ID;
	}
	/**	Dh	5.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "TaW")
	public int getTaW() {
		return TaW;
	}
	
	/**	Dh	5.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Name")
	public String getName() {
		return Name;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	5.6.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void setID(int pID) throws Exception{
		if (pID >= 0) {
			ID = pID;
		} else throw new Exception("02; Tal,sID");
	}
	/**	Dh	5.6.2020
	 * 
	 * @param pTaW
	 * @throws Exception
	 */
	public void setTaW(int pTaW) throws Exception{
		TaW = pTaW;
	}
	
	/**	Dh	5.6.2020
	 * 
	 * @param pName
	 * @throws Exception
	 */
	public void setName(String pName) throws Exception{
		if (pName != null) {
			if (!pName.equals("")) {
				Name = pName;
			}else throw new Exception("02; Tal,sN");
		}else throw new Exception("04; Tal,sN");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	9.6.2020
	 * 	
	 * @param pTaW
	 * @throws Exception
	 */
	public void addTaW(int pTaW) throws Exception{
		int vNew = TaW + pTaW;
		
		if (vNew >= 0) TaW = vNew;
		else throw new Exception("02; Tal,aTaW");
	}
}
