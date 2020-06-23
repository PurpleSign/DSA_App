/**	DSA_App v0.0	Dh 11.6.2020
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
	private static AppSettings AS;
	private static GameSettings GS;
	private static GUISettings GUIS;
	
	/**	Dh	11.6.2020
	 * 
	 * @throws Exception
	 */
	public static void initSettingManager() throws Exception{
		try {AS = Loader.loadAppSettings();}
		catch(Exception ex) {
			if (ex.getMessage().equals("21; Loa,lAS")) AS = new AppSettings();
			else throw ex;;
		}
		try {GUIS = Loader.loadGUISettings();}
		catch(Exception ex) {
			if (ex.getMessage().equals("21; Loa,lGUIS")) GUIS = new GUISettings();
			else throw ex;
		}
		
		GS = null;
	}
	/**	Dh	11.6.2020
	 * 
	 * @param pGameID
	 * @throws Exception
	 */
	public static void initSettingManager(int pGameID) throws Exception{
		try {AS = Loader.loadAppSettings();}
		catch(Exception ex) {
			if (ex.getMessage().equals("21; Loa,lAS")) AS = new AppSettings();
			else throw ex;
		}
		try {GUIS = Loader.loadGUISettings();}
		catch(Exception ex) {
			if (ex.getMessage().equals("21; Loa,lGUIS")) GUIS = new GUISettings();
			else throw ex;
		}
		try {GS = Loader.loadGameSettings(); }
		catch(Exception ex) {
			if (ex.getMessage().equals("21; Loa,lSS")) GS = new GameSettings(pGameID);
			else throw ex;
		}
	}
	
	/**	Dh	11.6.2020
	 * 
	 * @throws Exception
	 */
	public static void saveSettingManager() throws Exception {
		try {
			Loader.saveAppSettings(AS);
			Loader.saveGUISettings(GUIS);
			if (GS != null)	Loader.saveGameSettings(GS);
		}catch(Exception ex) {throw ex;}
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	11.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static int getGameID() throws Exception{
		if (GS != null) return GS.getID();
		else throw new Exception("04; SeMan,gGID");
	}
	
	/**	Dh	11.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static boolean isWithDistances() throws Exception {
		if (GS != null) return GS.isWithDistances();
		else throw new Exception("04; SeMan,iWD");
	}
	/**	Dh	11.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static boolean getWithHitZones() throws Exception{
		if (GS != null) return GS.isWithHitZones();
		else throw new Exception("04; SeMan,iWHZ");
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	11.6.2020
	 * 
	 * @param pGS
	 * @throws Exception
	 */
	public static void setGameSettings(GameSettings pGS) throws Exception{
		if (pGS != null) GS = pGS;
		else throw new Exception("04; SeMan,sGS");
	}
	
	/**	Dh	11.6.2020
	 * 
	 * @param pWithDistances
	 * @throws Exception
	 */
	public static void setWithDistances(boolean pWithDistances) throws Exception{
		if (GS != null) GS.setWithHitZones(pWithDistances);
		else throw new Exception("04; SeMan,sWD");
	}
	/**	Dh	11.6.2020
	 * 
	 * @param pWithHitZones
	 * @throws Exception
	 */
	public static void setWithHitZones(boolean pWithHitZones) throws Exception{
		if (GS != null) GS.setWithHitZones(pWithHitZones);
		else throw new Exception("04; SeMan,sWHZ");
	}
	
}
