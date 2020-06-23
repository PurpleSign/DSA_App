/**	DSA_App v0.0	Dh	11.6.2020
 * 
 * 	Logik
 * 	  IniElement
 * 
 * 	Ein Listen-Node-Object, welches die Initiative und den Aktionscounter eines kaempfenden beinhaltet.
 * 		Es beinhaltet den aktuellen Initiativwert, die aktuelle Anzahl an Aktionen in der aktuellen Runde.
 * 		Es kann die Zehnerstelle der Initiative herausgeben.
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
 */
package pLogik;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "inielement")
public class IniElement {
	private int ID, Ini, TempIni, Action, TempAction;			// ID des kaempfenden.
	
	/**	Dh	30.4.2020
	 */
	public IniElement() {
		super();
		ID = -1;
		Ini = -1;
		TempIni = -1;
		Action = -1;
		TempAction = -1;
	}
	/**	Dh	22.2.2020
	 * 
	 * @param pID
	 * @param pIni
	 */
	public IniElement(int pID, int pIni){
		Exception vExc;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; InEle_a");
		if (pIni >= 0) Ini = pIni;
		else vExc = new Exception("02; InEle_a");
		
		TempIni = Ini;
		Action = 1;
		TempAction = Action;
	}
	/**	Dh	22.2.2020
	 * 
	 * @param pID
	 * @param pIni
	 * @param pAction
	 */
	public IniElement(int pID, int pIni, int pAction){
		Exception vExc;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; InEle_b");
		if (pIni >= 0) Ini = pIni;
		else vExc = new Exception("02; InEle_b");
		TempIni = Ini;
		if (pAction >= 0) Action = pAction;
		else vExc = new Exception("02; InEle_b");
		TempAction = Action;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	22.02.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public int getID(){
		return ID;
	}
	/**	Dh	22.2.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "Ini")
	public int getIni(){
		return Ini;
	}
	/**	Dh	3.5.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public int getTempIni() {
		return TempIni;
	}
	/**	Dh	22.2.2020
	 * 
	 * 	Gibt zurueck, die wie vielte Action es in dieser Ini-Runde ist.
	 * 
	 * @return
	 */
	@XmlElement(name = "Action")
	public int getAction(){
		return Action;
	}
	/**	Dh	3.5.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public int getTempAction(){
		return TempAction;
	}
	
	/**	Dh	22.2.2020
	 * 
	 * 	Gibt die 10-Stelle der Ini wieder.
	 * 
	 * @return
	 */
	public int getIniDek(){
		return (int) (Ini/10);
	}
	
	//----------------------------------------------------------------------------------------------------
	
	public void setID(int pID) throws Exception {
		if (pID >= 0) ID = pID;
		else throw new Exception("02; InEle,sID");
	}
	/**	Dh	22.2.2020
	 * 
	 * @param pIni
	 * @throws Exception
	 */
	public void setIni(int pIni) throws Exception{
		if (pIni >= 0) Ini = pIni;
		else throw new Exception("02; InEle,sIn");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pTempIni
	 * @throws Exception
	 */
	public void setTempIni(int pTempIni) throws Exception {
		if ((pTempIni >= 0) && (pTempIni <= Ini)) TempIni = pTempIni;
		else throw new Exception("02; InEle,sTIn");
	}
	/**	Dh	22.2.2020
	 * 
	 * 	Setzt die wie vielte Action das dieses Ini-Runde war.
	 * 
	 * @param pAction
	 * @throws Exception
	 */
	public void setAction(int pAction) throws Exception{
		if (pAction >= 0) Action = pAction;
		else throw new Exception("02; InEle,sAk");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pTempAction
	 * @throws Exception
	 */
	public void setTempAction(int pTempAction) throws Exception{
		if ((pTempAction >= 0) && (pTempAction <= Action)) TempAction = pTempAction;
		else throw new Exception("02; InEle,sTAk");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	22.2.2020
	 * 
	 * @param pIni
	 * @throws Exception
	 */
	public void addIni(int pIni) throws Exception{
		if ((pIni + Ini) >= 0) Ini += pIni;
		else throw new Exception("03; InEle,aIn");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pTempIni
	 * @throws Exception
	 */
	public void addTempIni(int pTempIni) throws Exception{
		if (((pTempIni + TempIni) >= 0) && ((pTempIni + TempIni) <= Ini)) TempIni += pTempIni;
		else throw new Exception("03; InEle,aTIn");
	}
	/**	Dh	22.2.2020
	 * 	
	 * @param pAction
	 * @throws Exception
	 */
	public void addAction(int pAction) throws Exception{
		if ((pAction + Action) >= 0) Action += pAction;
		else throw new Exception("03; InEle,aAk");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pTempAction
	 * @throws Exception
	 */
	public void addTempAction(int pTempAction) throws Exception{
		if (((pTempAction + TempAction) >= 0) && ((TempAction + pTempAction) <= Action)) TempAction += pTempAction;
		else throw new Exception("03; InEle,aTAk");
	}
}
