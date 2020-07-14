/**	DSA_App v0.0	Dh 9.7.2020
 * 
 * 	pSettings
 * 	  SettingManager
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

import pDatenbank.Loader;

public abstract class SettingManager {
	private static AppSettings rAS;
	private static GameSettings rGS;
	private static GUISettings rGUIS;
	
	/**	Dh	11.6.2020
	 * 
	 * @throws Exception
	 */
	public static void initSettingManager() throws Exception{
		try {rAS = Loader.loadAppSettings();}
		catch(Exception ex) {
			if (ex.getMessage().equals("21; Loa,lAS")) rAS = new AppSettings();
			else throw ex;;
		}
		try {rGUIS = Loader.loadGUISettings();}
		catch(Exception ex) {
			if (ex.getMessage().equals("21; Loa,lGUIS")) rGUIS = new GUISettings();
			else throw ex;
		}
		
		rGS = null;
	}
	/**	Dh	11.6.2020
	 * 
	 * @param pGameID
	 * @throws Exception
	 */
	public static void initSettingManager(int pGameID) throws Exception{
		try {rAS = Loader.loadAppSettings();}
		catch(Exception ex) {
			if (ex.getMessage().equals("21; Loa,lAS")) rAS = new AppSettings();
			else throw ex;
		}
		try {rGUIS = Loader.loadGUISettings();}
		catch(Exception ex) {
			if (ex.getMessage().equals("21; Loa,lGUIS")) rGUIS = new GUISettings();
			else throw ex;
		}
		try {rGS = Loader.loadGameSettings(); }
		catch(Exception ex) {
			if (ex.getMessage().equals("21; Loa,lSS")) rGS = new GameSettings(pGameID);
			else throw ex;
		}
	}
	
	/**	Dh	11.6.2020
	 * 
	 * @throws Exception
	 */
	public static void saveSettingManager() throws Exception {
		try {
			Loader.saveAppSettings(rAS);
			Loader.saveGUISettings(rGUIS);
			if (rGS != null)	Loader.saveGameSettings(rGS);
		}catch(Exception ex) {throw ex;}
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	11.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static int getGameID() throws Exception{
		if (rGS != null) return rGS.getID();
		else throw new Exception("04; SeMan,gGID");
	}
	
	/**	Dh	11.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static boolean isWithDistances() throws Exception {
		if (rGS != null) return rGS.isWithDistances();
		else throw new Exception("04; SeMan,iWD");
	}
	/**	Dh	11.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static boolean getWithHitZones() throws Exception{
		if (rGS != null) return rGS.isWithHitZones();
		else throw new Exception("04; SeMan,iWHZ");
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	11.6.2020
	 * 
	 * @param pGS
	 * @throws Exception
	 */
	public static void setGameSettings(GameSettings pGS) throws Exception{
		if (pGS != null) rGS = pGS;
		else throw new Exception("04; SeMan,sGS");
	}
	
	/**	Dh	11.6.2020
	 * 
	 * @param pWithDistances
	 * @throws Exception
	 */
	public static void setWithDistances(boolean pWithDistances) throws Exception{
		if (rGS != null) rGS.setWithHitZones(pWithDistances);
		else throw new Exception("04; SeMan,sWD");
	}
	/**	Dh	11.6.2020
	 * 
	 * @param pWithHitZones
	 * @throws Exception
	 */
	public static void setWithHitZones(boolean pWithHitZones) throws Exception{
		if (rGS != null) rGS.setWithHitZones(pWithHitZones);
		else throw new Exception("04; SeMan,sWHZ");
	}
	
}
