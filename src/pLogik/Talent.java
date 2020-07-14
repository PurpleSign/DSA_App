/**	DSA_App	v0.0	Dh	9.7.2020
 * 
 * 	Logik
 * 	  Talent
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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import pGUI.MainFrame;

@XmlRootElement(name = "talent")
@XmlSeeAlso({Basictalent.class, Fighttalent.class})
public abstract class Talent {
	protected int id, taw, type;
	protected String name;
	
	/**	Dh	2.7.2020
	 * 
	 * 	Bean Standard Konstruktor
	 */
	public Talent() {
		id = -1;
		taw = 0;
		type = -1;
		
		name = "";
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
	 * @param pGainType
	 */
	public Talent(int pType, int pID, String pName) {
		Exception vExc = null;
		
		if (pType >= -1) type = pType;
		else vExc = new Exception("02; Tal_a");
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; Tal_a");
		taw = 0;
		
		if ((pName != null) && (pName != "")) name = pName;
		else vExc =  new Exception("02; Tal_a");
		
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
	 * @param pGainType
	 * @param pTaW
	 */
	public Talent(int pType, int pID, String pName, int pTaW) {
		Exception vExc = null;
		
		if (pType >= -1) type = pType;
		else vExc = new Exception("02; Tal_b");
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; Tal_b");
		taw = pTaW;
		
		if ((pName != null) && (pName != "")) name = pName;
		else vExc =  new Exception("02; Tal_b");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	5.6.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public int getId() {
		return id;
	}
	/**	Dh	5.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "TaW")
	public int getTaw() {
		return taw;
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
	 * @return
	 */
	@XmlElement(name = "Type")
	public int getType() {
		return type;
	}
	
	/**	Dh	5.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Name")
	public String getName() {
		return name;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	5.6.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void setId(int pID) throws Exception{
		if (pID >= 0) {
			id = pID;
		} else throw new Exception("02; Tal,sID");
	}
	/**	Dh	5.6.2020
	 * 
	 * @param pTaW
	 * @throws Exception
	 */
	public void setTaw(int pTaW) throws Exception{
		taw = pTaW;
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
	 * @param pType
	 * @throws Exception
	 */
	public void setType(int pType) throws Exception{
		if ((pType >= -1) && (pType < 10)) type = pType;
		else throw new Exception("02; Tal,sT");
	}
	
	/**	Dh	5.6.2020
	 * 
	 * @param pName
	 * @throws Exception
	 */
	public void setName(String pName) throws Exception{
		if (pName != null) {
			if (!pName.equals("")) {
				name = pName;
			}else throw new Exception("02; Tal,sN");
		}else throw new Exception("04; Tal,sN");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	9.6.2020
	 * 	
	 * @param pTaW
	 * @throws Exception
	 */
	public void addTaw(int pTaW) throws Exception{
		int vNew = taw + pTaW;
		
		if (vNew >= 0) taw = vNew;
		else throw new Exception("02; Tal,aTaW");
	}
}
