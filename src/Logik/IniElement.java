/**	DSA_App v0.0	Dh	16.2.2020
 * 
 * 	Logik
 * 	  IniElement
 * 
 * 	Exceptions:
 * 	  01 Wrong length
 * 	  02 Wrong Value
 * 	  03 Calculation Error
 * 	  04 Nullpointer Error
 * 	  05 Empty List Error
 * 	  06 Wrong Type Error
 * 	  07 Index Error
 */
package Logik;

public class IniElement {
	private int zID, zIni, zAktion;
	
	/**	Dh	22.2.2020
	 * 
	 * @param pID
	 * @param pIni
	 */
	public IniElement(int pID, int pIni){
		Exception vExc;
		
		if (pID >= 0) zID = pID;
		else vExc = new Exception("02; InEle_a");
		if (pIni >= 0) zIni = pIni;
		else vExc = new Exception("02; InEle_a");
		
		zAktion = 1;
	}
	/**	Dh	22.2.2020
	 * 
	 * @param pID
	 * @param pIni
	 * @param pAktion
	 */
	public IniElement(int pID, int pIni, int pAktion){
		Exception vExc;
		
		if (pID >= 0) zID = pID;
		else vExc = new Exception("02; InEle_b");
		if (pIni >= 0) zIni = pIni;
		else vExc = new Exception("02; InEle_b");
		if (pAktion >= 0) zAktion = pAktion;
		else vExc = new Exception("02; InEle_b");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	22.02.2020
	 * 
	 * @return
	 */
	public int getID(){
		return zID;
	}
	/**	Dh	22.2.2020
	 * 
	 * @return
	 */
	public int getIni(){
		return zIni;
	}
	/**	Dh	22.2.2020
	 * 
	 * 	Gibt zurueck, die wie vielte Aktion es in dieser Ini-Runde ist.
	 * 
	 * @return
	 */
	public int getAktion(){
		return zAktion;
	}
	
	/**	Dh	22.2.2020
	 * 
	 * 	Gibt die 10-Stelle der Ini wieder.
	 * 
	 * @return
	 */
	public int getIniDek(){
		return (int) (zIni/10);
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	22.2.2020
	 * 
	 * @param pIni
	 * @throws Exception
	 */
	public void setIni(int pIni) throws Exception{
		if (pIni >= 0) zIni = pIni;
		else throw new Exception("02; InEle,sIn");
	}
	/**	Dh	22.2.2020
	 * 
	 * 	Setzt die wie vielte Aktion das dieses Ini-Runde war.
	 * 
	 * @param pAktion
	 * @throws Exception
	 */
	public void setAktion(int pAktion) throws Exception{
		if (pAktion >= 0) zAktion = pAktion;
		else throw new Exception("02; InEle,sAk");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	22.2.2020
	 * 
	 * @param pIni
	 * @throws Exception
	 */
	public void addIni(int pIni) throws Exception{
		if ((pIni + zIni) >= 0) zIni += pIni;
		else throw new Exception("03; InEle,aIn");
	}
	/**	Dh	22.2.2020
	 * 	
	 * @param pAktion
	 * @throws Exception
	 */
	public void addAktion(int pAktion) throws Exception{
		if ((pAktion + zAktion) >= 0) zAktion += pAktion;
		else throw new Exception("03; InEle,aAk");
	}
}
