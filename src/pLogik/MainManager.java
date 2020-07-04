/**	DSA_App v0.0	Dh	24.6.2020
 * 
 * 	Logik
 * 	  MainManager
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

import java.awt.EventQueue;

import pDataStructures.List;
import pDatenbank.Loader;
import pGUI.MainFrame;
import pSettings.SettingManager;

public class MainManager {
	private static FightManager rFM;
	private static CharacterManager rCM;
	private static MainFrame rMF;

	public static void main(String[] args) {
		new MainManager();
	}
	
	/**	Dh	24.6.2020
	 * 
	 */
	public MainManager() {
		Exception vExc = null;
		
		try {
			Loader.initLoader();
			SettingManager.initSettingManager();
			
		} catch(Exception ex) {vExc = ex;}
		
		try {rFM = Loader.loadFightManager();}
		catch (Exception ex) {
			if (ex.getMessage().equals("21; Loa,lFM")) rFM = new FightManager(0);
			else vExc = ex;
		}
		
		try {rCM = Loader.loadCharacterManager();}
		catch (Exception ex) {
			if (ex.getMessage().equals("21; Loa,lCM")) {
				List vTemp = new List();
				List vFightList = rFM.getFightList();
				
				if (!vFightList.isEmpty()) {
					vFightList.toFirst();
					
					while(!vFightList.isEnd()) {
						vTemp.append(((FightElement) vFightList.getCurrent()).getCharacter());
						
						vFightList.next();
					}
				}
				
				rCM = new CharacterManager(0, vTemp);
			}
			else vExc = ex;
		}
		
		rMF = new MainFrame(rFM, rCM);
		
		if (vExc != null) rMF.handleException(vExc);
	}
	
	/**	Dh	24.6.2020
	 * 
	 */
	public static void closeApp() {
		try {
			//Loader.saveFightManager(rFM);
			//Loader.saveCharacterManager(rCM);
			//Loader.saveDatabases();
			//SettingManager.saveSettingManager();		
		} catch (Exception ex) {System.out.println(ex.getMessage());}
		
		rMF.dispose();
		rFM = null;
		
		System.exit(0);
	}
	
//--------------------------------------------------------------------------------------------------------

}
