/**	DSA_App v0.0	Dh 11.6.2020
 * 
 * 	pSettings
 * 	  GameSettings
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
 * 
 * 	  20 Wrong OS
 * 	  21 File does not exist
 */
package pSettings;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import pGUI.MainFrame;

@XmlRootElement(name = "gamesettings")
public class GameSettings {
	private int ID;
	private boolean WithDistances, WithHitZones;
	
	/**	Dh	11.6.2020
	 * 
	 */
	public GameSettings() {
		ID = -1;
		
		WithDistances = true;
		WithHitZones = true;
	}
	/**	Dh	11.6.2020
	 * 
	 * @param pID
	 */
	public GameSettings(int pID) {
		Exception vExc = null;
		
		if (pID >= 0)ID = pID;
		else vExc = new Exception("02; GaSet");
		
		WithDistances = true;
		WithHitZones = true;
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	11.6.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public int getID() {
		return ID;
	}
	
	/**	Dh	11.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "WithDistances")
	public boolean isWithDistances() {
		return WithDistances;
	}
	/**	Dh	11.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "WithHitZones")
	public boolean isWithHitZones() {
		return WithHitZones;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	11.6.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void setID(int pID) throws Exception {
		if (pID >= 0) {
			ID = pID;
		} else throw new Exception("02; GaSet,sID");
	}
	
	/**	Dh	11.6.2020
	 * 
	 * @param pWithDistances
	 */
	public void setWithDistances(boolean pWithDistances) {
		WithDistances = pWithDistances;
	}
	/**	Dh	11.6.2020
	 * 
	 * @param pWithHitZones
	 */
	public void setWithHitZones(boolean pWithHitZones) {
		WithHitZones = pWithHitZones;
	}
	
}
