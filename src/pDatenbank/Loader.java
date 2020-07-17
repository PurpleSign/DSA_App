/**	DSA_App v0.0	Dh 16.7.2020
 * 
 * 	Datenbank
 * 	  Loader
 * 
 * 	zaEigenschaften: 
 * 	  0 Mut					4 Fingerfertigkeit
 * 	  1 Klugkheit			5 Gewandheit
 * 	  2 Intuition			6 Konstitution
 * 	  3 Charisma			7 Koerperkraft
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
package pDatenbank;

import java.util.Random;
import java.io.File;
import java.util.*;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.*;

import pDataStructures.List;
import pLogik.*;
import pSettings.AppSettings;
import pSettings.GUISettings;
import pSettings.GameSettings;

public abstract class Loader {
	private static String ProPath = "/data/pros.xml";
	private static String SpecialCraftPath = "/data/specialcrafts.xml";
	private static String TalentPath = "/data/talents.xml";
	private static String WeaponPath = "/data/weapons.xml";
	private static String WeaponPath2 = "/data/weapon.xml";
	
	private static String AppSettingPath = "/settings/appsettings.xml";
	private static String GameSettingPath = "/settings/gamesettings.xml";
	private static String GUISettingPath = "/settings/guisettings.xml";
	
	private static String GamePath = "/data/saves/games";
	
	private static File rSystemFile;
	
	private static ProDatabase rPD;
	private static SpecialCraftDatabase rSCD;
	private static TalentDatabase rTD;
	private static WeaponDatabase rWD;
	
	public static void main(String[] args) {
		try{
			rSystemFile = getFileSystem();
			
			genDatabanks();
			saveDatabases();
			
			loadDatabases();
		} catch (Exception ex) { System.out.println(ex); }
	}
	
	/**	Dh	17.6.2020
	 * 
	 * @throws Exception
	 */
	public static void initLoader() throws Exception{
		try { 
			rSystemFile = getFileSystem();
			
			
			
			loadDatabases();
			
			//genDatabanks();
			//System.out.println(""+SCD.getSpecialCraft(0).getPropertiePremise(6));
			//saveSpecialCraftDatabase();
			
			//saveProDatabase();
			//saveSpecialCraftDatabase();
			//saveTalentDatabase();
			//saveWeaponDatabase();
			
			//System.out.println(SCD.getSpecialCraftList().getContentNumber());
			//System.out.println(PD.getProList().getContentNumber());
		}catch(Exception ex) { throw ex;}
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	16.6.2020
	 * 
	 * @throws Exception
	 */
	public static void saveProDatabase() throws Exception {
		File ProFile = new File(rSystemFile.getAbsolutePath()+ProPath);
		JAXBContext jc = JAXBContext.newInstance(ProDatabase.class);
		Marshaller marschaller = jc.createMarshaller();
		
		marschaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		if (!ProFile.exists()) {
			try{ ProFile.createNewFile();}
			catch(Exception ex) {throw ex;}
		}
		
	    marschaller.marshal(rPD, ProFile);
	}
	/**	Dh	16.6.2020
	 * 
	 * @throws Exception
	 */
	public static void saveSpecialCraftDatabase() throws Exception {
		File SpecialCraftFile = new File(rSystemFile.getAbsolutePath()+SpecialCraftPath);
		JAXBContext jc = JAXBContext.newInstance(SpecialCraftDatabase.class);
		Marshaller marschaller = jc.createMarshaller();
		
		marschaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		if (!SpecialCraftFile.exists()) {
			try{ SpecialCraftFile.createNewFile();}
			catch(Exception ex) {throw ex;}
		}
		
	    marschaller.marshal(rSCD, SpecialCraftFile);
	}
	/**	Dh	9.6.2020
	 * 
	 * @throws Exception
	 */
	public static void saveTalentDatabase() throws Exception {
		File TalentFile = new File(rSystemFile.getAbsolutePath()+TalentPath);
		JAXBContext jc = JAXBContext.newInstance(TalentDatabase.class);
		Marshaller marschaller = jc.createMarshaller();
		
		marschaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		if (!TalentFile.exists()) {
			try{ TalentFile.createNewFile();}
			catch(Exception ex) {throw ex;}
		}
		
	    marschaller.marshal(rTD, TalentFile);
	}
	/**	Dh	4.6.2020
	 * 
	 * @throws Exception
	 */
	public static void saveWeaponDatabase() throws Exception {
		File WeaponFile = new File(rSystemFile.getAbsolutePath()+WeaponPath);
		JAXBContext jc = JAXBContext.newInstance(WeaponDatabase.class);
		Marshaller marschaller = jc.createMarshaller();
		
		marschaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		if (!WeaponFile.exists()) {
			try{ WeaponFile.createNewFile();}
			catch(Exception ex) {throw ex;}
		}
		
	    marschaller.marshal(rWD, WeaponFile);
	}
	/**	Dh	16.6.2020
	 * 
	 * @throws Exception
	 */
	public static void saveDatabases() throws Exception{
		saveProDatabase();
		saveSpecialCraftDatabase();
		saveTalentDatabase();
		saveWeaponDatabase();
	}
	
	/**	Dh	11.6.2020
	 * 
	 * @param pAppSettings
	 * @throws Exception
	 */
	public static void saveAppSettings(AppSettings pAppSettings) throws Exception{
		File SettingFile = new File(rSystemFile.getAbsolutePath()+AppSettingPath);
		JAXBContext jc = JAXBContext.newInstance(AppSettings.class);
		Marshaller marschaller = jc.createMarshaller();
		
		marschaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		if (!SettingFile.exists()) {
			try{ SettingFile.createNewFile();}
			catch(Exception ex) {throw ex;}
		}
		
	    marschaller.marshal(pAppSettings, SettingFile);
	}
	/**	Dh	11.6.2020
	 * 
	 * @param pGameSettings
	 * @throws Exception
	 */
	public static void saveGameSettings(GameSettings pGameSettings) throws Exception{
		File SettingFile = new File(rSystemFile.getAbsolutePath()+GameSettingPath);
		JAXBContext jc = JAXBContext.newInstance(GameSettings.class);
		Marshaller marschaller = jc.createMarshaller();
		
		marschaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		if (!SettingFile.exists()) {
			try{ SettingFile.createNewFile();}
			catch(Exception ex) {throw ex;}
		}
		
	    marschaller.marshal(pGameSettings, SettingFile);
	}
	/**	Dh	11.6.2020
	 * 
	 * @param pGUISettings
	 * @throws Exception
	 */
	public static void saveGUISettings(GUISettings pGUISettings) throws Exception{
		File SettingFile = new File(rSystemFile.getAbsolutePath()+GUISettingPath);
		JAXBContext jc = JAXBContext.newInstance(GUISettings.class);
		Marshaller marschaller = jc.createMarshaller();
		
		marschaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		if (!SettingFile.exists()) {
			try{ SettingFile.createNewFile();}
			catch(Exception ex) {throw ex;}
		}
		
	    marschaller.marshal(pGUISettings, SettingFile);
	}
	
	/**	Dh	11.6.2020
	 * 
	 * @param pFM
	 * @throws Exception
	 */
	public static void saveFightManager(FightManager pFM) throws Exception{
		int vID;
		
		if (pFM != null) {
			vID = pFM.getId();
			
			File FMFile = new File(rSystemFile.getAbsolutePath()+GamePath+"/FM_"+vID+".xml");
			JAXBContext jc = JAXBContext.newInstance(FightManager.class);
			Marshaller marschaller = jc.createMarshaller();
			
			marschaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			if (!FMFile.exists()) {
				try{ FMFile.createNewFile();}
				catch(Exception ex) {throw ex;}
			}
			
			marschaller.marshal(pFM, FMFile);
			
		} else throw new Exception("04; Loa,sFM");
	}
	/**	Dh	24.6.2020
	 * 
	 * @param pCM
	 * @throws Exception
	 */
	public static void saveCharacterManager(CharacterManager pCM) throws Exception{
		int vID;
		
		if (pCM != null) {
			vID = pCM.getId();
			
			File CMFile = new File(rSystemFile.getAbsolutePath()+GamePath+"/CM_"+vID+".xml");
			JAXBContext jc = JAXBContext.newInstance(CharacterManager.class);
			Marshaller marschaller = jc.createMarshaller();
			
			marschaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			if (!CMFile.exists()) {
				try{ CMFile.createNewFile();}
				catch(Exception ex) {throw ex;}
			}
			
			marschaller.marshal(pCM, CMFile);
			
		} else throw new Exception("04; Loa,sCM");
	}
	
	public static void saveThings(FightManager pFM) {
		File FMFile0 = new File(rSystemFile.getAbsolutePath()+GamePath+"/IniElement.xml");
		File FMFile1 = new File(rSystemFile.getAbsolutePath()+GamePath+"/NeighbourElement.xml");
		File FMFile2 = new File(rSystemFile.getAbsolutePath()+GamePath+"/Character.xml");
		File FMFile3 = new File(rSystemFile.getAbsolutePath()+GamePath+"/FightElement.xml");
		try {
			JAXBContext jc0 = JAXBContext.newInstance(IniElement.class);
			JAXBContext jc1 = JAXBContext.newInstance(NeighbourElement.class);
			JAXBContext jc2 = JAXBContext.newInstance(Charakter.class);
			JAXBContext jc3 = JAXBContext.newInstance(FightElement.class);
			
			Marshaller marschaller0 = jc0.createMarshaller();
			Marshaller marschaller1 = jc1.createMarshaller();
			Marshaller marschaller2 = jc2.createMarshaller();
			Marshaller marschaller3 = jc3.createMarshaller();
			
			if (!FMFile0.exists()) FMFile0.createNewFile();
			if (!FMFile1.exists()) FMFile1.createNewFile();
			if (!FMFile2.exists()) FMFile2.createNewFile();
			if (!FMFile3.exists()) FMFile3.createNewFile();
			
			marschaller0.marshal(pFM.getIniElement(0), FMFile0);
			marschaller1.marshal(pFM.getNeighbourElementOfFighter(0, 1), FMFile1);
			marschaller2.marshal(pFM.getFightElement(0).getCharacter(), FMFile2);
			marschaller3.marshal(pFM.getFightElement(0), FMFile3);
		}catch(Exception ex) {System.out.println("bujasfbosafbosavf"+ex.getMessage());}
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	16.6.2020
	 * 
	 * @throws Exception
	 */
	public static void loadProDatabase() throws Exception{
		File ProFile = new File(rSystemFile.getAbsolutePath()+ProPath);
		
		if (ProFile.exists()) rPD = JAXB.unmarshal(ProFile, ProDatabase.class);
		else throw new Exception("21; Loa,lPD");
	}
	/**	Dh	16.6.2020
	 * 	
	 * @throws Exception
	 */
	public static void loadSpecialCraftDatabase() throws Exception{
		File SpecialCraftFile = new File(rSystemFile.getAbsolutePath()+SpecialCraftPath);
		
		if (SpecialCraftFile.exists()) rSCD = JAXB.unmarshal(SpecialCraftFile, SpecialCraftDatabase.class);
		else throw new Exception("21; Loa,lSCD");
	}
	/**	Dh	9.6.2020
	 * 	
	 * @throws Exception
	 */
	public static void loadTalentDatabase() throws Exception{
		File TalentFile = new File(rSystemFile.getAbsolutePath()+TalentPath);
		
		if (TalentFile.exists()) rTD = JAXB.unmarshal(TalentFile, TalentDatabase.class);
		else throw new Exception("21; Loa,lTD");
	}
	/**	Dh	4.6.2020
	 * 
	 * @throws Exception
	 */
 	public static void loadWeaponDatabase() throws Exception{
		File WeaponFile = new File(rSystemFile.getAbsolutePath()+WeaponPath);
		
		if (WeaponFile.exists()) rWD = JAXB.unmarshal(WeaponFile, WeaponDatabase.class);
		else throw new Exception("21; Loa,lWD");
	}
	/**	Dh	16.6.2020
	 * 
	 * @throws Exception
	 */
	public static void loadDatabases() throws Exception{
		loadProDatabase();
		loadSpecialCraftDatabase();
		loadTalentDatabase();
		loadWeaponDatabase();
	}
	
	/**	Dh	11.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static AppSettings loadAppSettings() throws Exception{
		AppSettings vRet = null;
		File SettingFile = new File(rSystemFile.getAbsolutePath()+AppSettingPath);
		
		if (SettingFile.exists()) vRet = JAXB.unmarshal(SettingFile, AppSettings.class);
		else throw new Exception("21; Loa,lAS");
		
		return vRet;
	}
	/**	Dh	11.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static GameSettings loadGameSettings() throws Exception{
		GameSettings vRet = null;
		File SettingFile = new File(rSystemFile.getAbsolutePath()+GameSettingPath);
		
		if (SettingFile.exists()) vRet = JAXB.unmarshal(SettingFile, GameSettings.class);
		else throw new Exception("21; Loa,lGS");
		
		return vRet;
	}
	/**	Dh	11.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static GUISettings loadGUISettings() throws Exception{
		GUISettings vRet = null;
		File SettingFile = new File(rSystemFile.getAbsolutePath()+GUISettingPath);
		
		if (SettingFile.exists()) vRet = JAXB.unmarshal(SettingFile, GUISettings.class);
		else throw new Exception("21; Loa,lGUIS");
		
		return vRet;
	}
	
	/**	Dh	11.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static FightManager loadFightManager() throws Exception{
		int vID = 0;
		
		FightManager vRet = null;
		File FMFile = new File(rSystemFile.getAbsolutePath()+GamePath+"/FM_"+vID+".xml");
		
		if (FMFile.exists()) vRet = JAXB.unmarshal(FMFile, FightManager.class);
		else throw new Exception("21; Loa,lFM");
		
		return vRet;
	}
	/**	Dh	24.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static CharacterManager loadCharacterManager() throws Exception{
		int vID = 0;
		
		CharacterManager vRet = null;
		File CMFile = new File(rSystemFile.getAbsolutePath()+GamePath+"/CM_"+vID+".xml");
		
		if (CMFile.exists()) vRet = JAXB.unmarshal(CMFile, CharacterManager.class);
		else throw new Exception("21; Loa,lCM");
		
		return vRet;
	}
	
	public static void loadThings() {
		Object vRet;
		
		File FMFile0 = new File(rSystemFile.getAbsolutePath()+GamePath+"/IniElement.xml");
		File FMFile1 = new File(rSystemFile.getAbsolutePath()+GamePath+"/NeighbourElement.xml");
		File FMFile2 = new File(rSystemFile.getAbsolutePath()+GamePath+"/Character.xml");
		File FMFile3 = new File(rSystemFile.getAbsolutePath()+GamePath+"/FightElement.xml");
		
		
		if (FMFile0.exists()) vRet = JAXB.unmarshal(FMFile0, IniElement.class);
		System.out.println("0");
		if (FMFile1.exists()) vRet = JAXB.unmarshal(FMFile1, NeighbourElement.class);
		System.out.println("1");
		if (FMFile2.exists()) vRet = JAXB.unmarshal(FMFile2, Charakter.class);
		System.out.println("2");
		if (FMFile3.exists()) vRet = JAXB.unmarshal(FMFile3, FightElement.class);
		System.out.println("3");
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	14.7.2020
	 * 
	 * 	Erstellt einen Charakter anhand der Type Spezifikation.
	 * 
	 * @param pType
	 * @return
	 * @throws Exception
	 */
	public static Charakter loadNewCharacter(int pType) throws Exception {
		int vTalentID;
		String vName, vRasse, vKultur, vProfession;
		int[] vProp;
		double[] vStatsMod;
		Charakter vRet;
		
		List vWeapList = new List();
		
		vName = "Test"+Integer.toString(pType);
		vRasse = "Tulamide";
		vKultur = "Tulamidische Stadtstaaten";
		vProfession = "";
		vProp = new int[10];
		
		if (pType == 0) {
			for (int i=0; i<8; i++) {
				vProp[i] = 11;
			}
			vProp[8] = 8;
			vProp[9] = 7;
			
			vStatsMod = new double[] {10, 10, 0, 0};
			
			vWeapList.append(rWD.getWeapon(0));
			vWeapList.append(rWD.getWeapon(1));
			vWeapList.append(rWD.getWeapon("Säbel"));
			vWeapList.append(rWD.getWeapon("Kurzbogen"));
			
			vRet = new Charakter(0, vName, new String[] {vRasse, vKultur, vProfession}, vProp, vStatsMod);
			
			vTalentID = rTD.getTalent("Dolche").getId();
			vRet.getTalent(vTalentID).addTaw(7);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {4, 3});
			
			vTalentID = rTD.getTalent("Raufen").getId();
			vRet.getTalent(vTalentID).addTaw(5);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {3, 2});
			
			vTalentID = rTD.getTalent("Ringen").getId();
			vRet.getTalent(vTalentID).addTaw(5);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {3, 2});
			
			vRet.addTalent(rTD.getTalent("Bogen"));
			vTalentID = rTD.getTalent("Bogen").getId();
			vRet.getTalent(vTalentID).addTaw(3);
			
			vRet.setWeaponList(vWeapList);
		} else if (pType == 1) {
			for (int i=0; i<8; i++) {
				vProp[i] = 11;
			}
			vProp[8] = 8;
			vProp[9] = 9;
			
			vStatsMod = new double[] {10, 10, 12, 0};
			
			vWeapList.append(rWD.getWeapon(0));
			vWeapList.append(rWD.getWeapon(1));
			vWeapList.append(rWD.getWeapon("Säbel"));
			vWeapList.append(rWD.getWeapon("Kurzbogen"));
			
			vRet = new Charakter(1, vName, new String[] {vRasse, vKultur, vProfession}, vProp, vStatsMod);
			
			vTalentID = rTD.getTalent("Dolche").getId();
			vRet.getTalent(vTalentID).addTaw(3);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {1, 2});
			
			vTalentID = rTD.getTalent("Raufen").getId();
			vRet.getTalent(vTalentID).addTaw(5);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {2, 3});
			
			vTalentID = rTD.getTalent("Ringen").getId();
			vRet.getTalent(vTalentID).addTaw(5);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {2, 3});
			
			vRet.setWeaponList(vWeapList);
		} else if (pType == 2) {
			for (int i=0; i<8; i++) {
				vProp[i] = 11;
			}
			vProp[8] = 8;
			vProp[9] = 9;
			
			vStatsMod = new double[] {10, 10, 12, 24};
			
			vWeapList.append(rWD.getWeapon(0));
			vWeapList.append(rWD.getWeapon(1));
			vWeapList.append(rWD.getWeapon("Säbel"));
			vWeapList.append(rWD.getWeapon("Kurzbogen"));
			
			vRet = new Charakter(2, vName, new String[] {vRasse, vKultur, vProfession}, vProp, vStatsMod);
			
			vTalentID = rTD.getTalent("Dolche").getId();
			vRet.getTalent(vTalentID).addTaw(3);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {1, 2});
			
			vTalentID = rTD.getTalent("Raufen").getId();
			vRet.getTalent(vTalentID).addTaw(5);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {2, 3});
			
			vTalentID = rTD.getTalent("Ringen").getId();
			vRet.getTalent(vTalentID).addTaw(5);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {2, 3});
			
			vRet.setWeaponList(vWeapList);
		} else throw new Exception("02; Loa,lNC");
		
		return vRet;
	}
	/**	Dh	14.7.2020
	 * 
	 * 	Erzeugt einen zufaelligen Charakter und gibt ihn zurueck.
	 * 
	 * @return
	 */
	public static Charakter loadNewRandomCharakter(int pID) throws Exception {
		int vTalentID, vTaW;
		String vName, vRasse, vKultur, vProfession;
		int[] vProp;
		double[] vStatsMod;
		Random vRan;
		Charakter vRet;
		List vWeapList = new List();
		vRan = new Random();
		
		vName = "Random"+Integer.toString(vRan.nextInt(100));
		vRasse = "Tulamid";
		vKultur = "Tulamidische Stadtstaaten";
		vProfession = "NSC";
		vProp = new int[10];
		
		vStatsMod = new double[] {10, 10, 0, 0};
		
		vWeapList.append(rWD.getWeapon(0));
		vWeapList.append(rWD.getWeapon(1));
		vWeapList.append(rWD.getWeapon("Säbel"));
		vWeapList.append(rWD.getWeapon("Kurzbogen"));
		
		for (int i=0; i<8; i++) {
			vProp[i] = 8+vRan.nextInt(6);
		}
		vProp[8] = 1+vRan.nextInt(13);
		vProp[9] = 6+vRan.nextInt(4);
		
		vRet = new Charakter(pID, vName, new String[] {vRasse, vKultur, vProfession}, vProp, vStatsMod);
		try {
			vTalentID = rTD.getTalent("Dolche").getId();
			vTaW = vRan.nextInt(11)+1;
			vRet.getTalent(vTalentID).addTaw(vTaW);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {Math.round(vTaW/2), (int)Math.rint(vTaW/2)});
			
			vTalentID = rTD.getTalent("Raufen").getId();
			vTaW = vRan.nextInt(11)+1;
			vRet.getTalent(vTalentID).addTaw(vTaW);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {Math.round(vTaW/2), (int)Math.rint(vTaW/2)});
			
			vTalentID = rTD.getTalent("Ringen").getId();
			vTaW = vRan.nextInt(11)+1;
			vRet.getTalent(vTalentID).addTaw(vTaW);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {Math.round(vTaW/2), (int)Math.rint(vTaW/2)});
		
			vRet.addTalent(rTD.getTalent("Bogen"));
			vTaW = vRan.nextInt(11)+1;
			vTalentID = rTD.getTalent("Bogen").getId();
			vRet.getTalent(vTalentID).addTaw(vTaW);
			
			vRet.setWeaponList(vWeapList);
		} catch (Exception ex) {throw ex;}
		
		return vRet;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh 25.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public static Pro getPro(int pID) throws Exception{
		return rPD.getPro(pID);
	}
	/**	Dh	25.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public static SpecialCraft getSpecialCraft(int pID) throws Exception{
		return rSCD.getSpecialCraft(pID);
	}
	/**	Dh	25.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public static Talent getTalent(int pID) throws Exception{
		return rTD.getTalent(pID);
	}
	/**	Dh	25.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public static Weapon getWeapon(int pID) throws Exception{
		return rWD.getWeapon(pID);
	}
	//-----
	/**	Dh	25.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List getProList() throws Exception{
		if (rPD != null) return rPD.getProList();
		else throw new Exception("04; Loa,gPL");
	}
	/**	Dh	25.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List getSpecialCraftList() throws Exception{
		if (rSCD != null) return rSCD.getSpecialCraftList();
		else throw new Exception("04; Loa,gSCL");
	}
	/**	Dh	25.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List getTalentList() throws Exception{
		if (rTD != null) return rTD.getTalentList();
		else throw new Exception("04; Loa,gTL");
	}
	/**	Dh	25.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List getWeaponList() throws Exception{
		if (rWD != null) return rWD.getWeaponList();
		else throw new Exception("04; Loa,gWL");
	}
	
	/**	Dh	12.7.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public static String getTalentType(int pID) throws Exception{
		if (rTD != null) return rTD.getTalentType(pID);
		else throw new Exception("04; Loa,gTT");
	}
	/**	Dh	12.7.2020
	 * 
	 * @param pTalentType
	 * @return
	 * @throws Exception
	 */
	public static int getTalentTypeID(String pTalentType) throws Exception{
		if (rTD != null) return rTD.getTalentTypeID(pTalentType);
		else throw new Exception("04; Loa,gTTID");
	}
	/**	Dh	9.7.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public static String getWeaponType(int pID) throws Exception{
		if (rWD != null) return rWD.getWeaponType(pID);
		else throw new Exception("04; Loa,gWT");
	}
	/**	Dh	9.7.2020
	 * 
	 * @param pWeaponType
	 * @return
	 * @throws Exception
	 */
	public static int getWeaponTypeID(String pWeaponType) throws Exception{
		if (rWD != null) return rWD.getWeaponTypeID(pWeaponType);
		else throw new Exception("04; Loa,gWTID");
	}
	/**	Dh	15.7.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public static String getWeaponUseType(int pID) throws Exception{
		if (rWD != null) return rWD.getWeaponUseType(pID);
		else throw new Exception("04; Loa,gWUT");
	}
	/**	Dh	16.7.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public static String getDamageType(int pID) throws Exception{
		if (rWD != null) return rWD.getDamageType(pID);
		else throw new Exception("04; Loa,gDT");
	}
	/**	Dh	16.7.2020
	 * 
	 * @param pDamgeType
	 * @return
	 * @throws Exception
	 */
	public static int getDamageTypeID(String pDamgeType) throws Exception{
		if (rWD != null) return rWD.getWeaponTypeID(pDamgeType);
		else throw new Exception("04; Loa,gDTID");
	}
	//-----
	/**	Dh	10.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List getBasicTalents() throws Exception{
		int[] vBasicTalentIDs;
		Talent vCur;
		List vRet = new List();
		
		if (rTD != null) {
			vBasicTalentIDs = rTD.getBasicTalents();
			if (vBasicTalentIDs != null) {
				for (int i=0; i < vBasicTalentIDs.length; i++) {
					vCur = rTD.getTalent(vBasicTalentIDs[i]);
					
					if (vCur != null) vRet.append(vCur);
				}
			}
		}
		
		return vRet;
	}
	/**	Dh	9.7.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String[] getWeaponTypes() throws Exception{
		if (rWD != null) return rWD.getWeaponTypes();
		else throw new Exception("04; Loa,gWts");
	}
	/**	Dh	12.7.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String[] getTalentTypes() throws Exception{
		if (rTD != null) return rTD.getTalentTypes();
		else throw new Exception("04; Loa,gTTs");
	}
	/**	Dh	15.7.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String[] getWeaponUseTypes() throws Exception{
		if (rWD != null) return rWD.getWeaponUseTypes();
		else throw new Exception("04; Loa,gWUTs");
	}
	/**	Dh	16.7.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String[] getDamageTypes() throws Exception{
		if (rWD != null) return rWD.getDamageTypes();
		else throw new Exception("04; Loa,gDTs");
	}
	
	/**	Dh	16.7.2020
	 * 
	 * @param pIDs
	 * @return
	 * @throws Exception
	 */
	public static String[] getDamageTypes(int[] pIDs) throws Exception{
		if (rWD != null) return rWD.getDamageTypes(pIDs);
		else throw new Exception("04; Loa,gDTs");
	}
	/**	Dh	16.7.2020
	 * 	
	 * @param pDamageTypes
	 * @return
	 * @throws Exception
	 */
	public static int[] getDamageTypesID(String[] pDamageTypes) throws Exception{
		if (rWD != null) return rWD.getDamageTypesID(pDamageTypes);
		else throw new Exception("04; Loa,gDTsID");
	}
	
	//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	16.7.2020
	 * 
	 * @param pWeaponTypeID
	 * @return
	 * @throws Exception
	 */
	public static int[] determineWeaponUseTypes(int pWeaponTypeID) throws Exception{
		if (rWD != null) return rWD.determineWeaponUseTypes(pWeaponTypeID);
		else throw new Exception("04; Loa,dWUTs");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	4.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	private static File getFileSystem() throws Exception {
		String vOS, vHome;
		File vHomeFile;
		
		vOS = System.getProperty("os.name");
		vHome = System.getProperty("user.home");
		
		if (vOS.contains("Windows")) vHome = vHome+ "/AppData/Roaming/DSA_App";
		else throw new Exception("20; Loa,gFS");
		
		vHomeFile = new File(vHome);
		if (!vHomeFile.exists()) {
			try{ makeFileSystem(vOS, vHomeFile); }
			catch(Exception ex) {throw ex;}
		}
		
		return vHomeFile;
	}
	/**	Dh	4.6.2020
	 * 
	 * @param vOS
	 * @param vHomeFile
	 * @throws Exception
	 */
	private static void makeFileSystem(String vOS, File vHomeFile) throws Exception {
		if (vOS.contains("Windows")) {
			vHomeFile.mkdir();
			new File(vHomeFile.getAbsoluteFile()+"/data").mkdir();
			new File(vHomeFile.getAbsoluteFile()+"/data/saves").mkdir();
			new File(vHomeFile.getAbsoluteFile()+"/data/saves/games").mkdir();
			new File(vHomeFile.getAbsoluteFile()+"/data/saves/characters").mkdir();
			new File(vHomeFile.getAbsoluteFile()+"/settings").mkdir();
		}
		else throw new Exception("20; Loa,gFS");
	}
	
	/**	Dh	1.7.2020
	 * 
	 * @throws Exception
	 */
	private static void genPros() throws Exception{
		rPD = new ProDatabase();
		
		try {
			// Vorteile
			rPD.addPro(new ReferredPro(0, "Adlig"));
			rPD.addPro(new StringedPro(1, "Affinität zu "));
			rPD.addPro(new ReferredPro(2, "Akademische Ausbildung"));
			rPD.addPro(new Pro(3, "Altersresistenz"));
			rPD.addPro(new ValuedPro(4, "Astrale Regeneration", 3, true, true));
			
			rPD.addPro(new ValuedPro(5, "Astralmacht", 6, true, true));
			rPD.addPro(new ValuedPro(6, "Ausdauernd", 3));
			rPD.addPro(new Pro(7, "Ausdauernder Zauberer", true, true));
			rPD.addPro(new ValuedPro(8, "Ausrüstungsvorteil", -1));
			rPD.addPro(new Pro(9, "Balance"));
			
			rPD.addPro(new ReferredPro(10, "Begabung für Merkmal", true, true));
			rPD.addPro(new ReferredPro(11, "Begabung für Ritual", true, true));
			rPD.addPro(new ReferredPro(12, "Begabung für Talent"));
			rPD.addPro(new ReferredPro(13, "Begabung für Talentgruppe"));
			rPD.addPro(new ReferredPro(14, "Begabung für Zauber", true, true));
			
			rPD.addPro(new Pro(15, "Beidhändig"));
			rPD.addPro(new Pro(16, "Beseelte Knochenkeule"));
			rPD.addPro(new ValuedPro(17, "Besonderer Besitz", -1));
			rPD.addPro(new Pro(18, "Breitgefächerte Bildung"));
			rPD.addPro(new Pro(19, "Dämmerungssicht"));
			
			rPD.addPro(new Pro(20, "Eidetisches gedächtnis"));
			rPD.addPro(new Pro(21, "Eigeboren", true ,true));
			rPD.addPro(new Pro(22, "Eisenaffine Aura", true, true));
			rPD.addPro(new Pro(23, "Eisern"));
			rPD.addPro(new Pro(24, "Empathie", true, false, true));
			
			rPD.addPro(new Pro(25, "Entfernungssinn"));
			rPD.addPro(new ValuedPro(26, "Ererbte Knochenkeuel", -1, true, true));
			rPD.addPro(new Pro(27, "Feenfreund"));
			rPD.addPro(new Pro(28, "Feste Matrix", true, true));
			rPD.addPro(new Pro(29, "Flink"));
			
			rPD.addPro(new ValuedPro(30, "Gebildet", 5));
			rPD.addPro(new Pro(31, "Gefahreninstinkt", true, false, true));
			rPD.addPro(new Pro(32, "Geräuschhexerei", true, false, true));
			rPD.addPro(new Pro(33, "Geweiht"));
			rPD.addPro(new Pro(34, "Glück"));
			
			rPD.addPro(new Pro(35, "Glück im Spiel"));
			rPD.addPro(new Pro(36, "Gut Aussehend"));
			rPD.addPro(new ValuedPro(37, "Guter Ruf", 10));
			rPD.addPro(new Pro(38, "Gutes Gedächtnis"));
			rPD.addPro(new Pro(39, "Halbzauberer", true, true));
			
			rPD.addPro(new Pro(40, "Herausragende Balance"));
			rPD.addPro(new Pro(41, "Herausragende Eigenschaft"));
			rPD.addPro(new Pro(42, "Herausragender Sechster Sinn"));
			rPD.addPro(new StringedPro(43, "Herausragender Sinn"));
			rPD.addPro(new Pro(44, "Herausragendes Aussehen"));
			
			rPD.addPro(new Pro(45, "Hitzeresistenz"));
			rPD.addPro(new ValuedPro(46, "Hohe Lebenskraft", 6));
			rPD.addPro(new ValuedPro(47, "Hohe Magieresistenz", 3));
			rPD.addPro(new ReferredPro(48, "Immunität gegen Gift"));
			rPD.addPro(new ReferredPro(49, "Immunität gegen Gift-Gruppe"));
			
			rPD.addPro(new ReferredPro(50, "Immunität gegen alle Gifte"));
			rPD.addPro(new ReferredPro(51, "Immunität gegen Krankheit"));
			rPD.addPro(new ReferredPro(52, "Immunität geegen Krankheiten"));
			rPD.addPro(new Pro(53, "Innerer Kompass"));
			rPD.addPro(new Pro(53, "Kälteresistenz"));
			
			rPD.addPro(new Pro(55, "Kampfrausch"));
			rPD.addPro(new Pro(56, "Koboldfreund"));
			rPD.addPro(new ReferredPro(57, "Kräfteschub", true, false, true));
			rPD.addPro(new Pro(58, "Linkshänder"));
			rPD.addPro(new Pro(59, "Machtvoller Vertrauter", true, true));
			
			rPD.addPro(new Pro(60, "Magiegespür", true, false, true));
			rPD.addPro(new ReferredPro(61, "Meisterhandwerk", true, true));
			rPD.addPro(new Pro(62, "Nachtsicht"));
			rPD.addPro(new ValuedPro(63, "Natürliche Waffe", -1));
			rPD.addPro(new ValuedPro(64, "Natürlicher Rüstungsschutz", -1));
			
			rPD.addPro(new ReferredPro(65, "Niedrige Schlechte Eigenschaft"));
			rPD.addPro(new Pro(66, "Prophezeien", true, false, true));
			rPD.addPro(new ReferredPro(67, "Resistenz gegen Gift"));
			rPD.addPro(new ReferredPro(68, "Resistenz gegen Gifte"));
			rPD.addPro(new ReferredPro(69, "Resistenz gegen alle Gifte"));
			
			rPD.addPro(new ReferredPro(70, "Resistenz gegen Krankheiten"));
			rPD.addPro(new Pro(71, "Richtungssinn"));
			rPD.addPro(new Pro(72, "Schlangenmensch"));
			rPD.addPro(new ValuedPro(73, "Schnelle Heilung", 3));
			rPD.addPro(new Pro(74, "Schutzgeist", true, true));
			
			rPD.addPro(new Pro(75, "Schwer zu verzaubern"));
			rPD.addPro(new Pro(76, "Soziale Anpassungsfähigkeit"));
			rPD.addPro(new ReferredPro(77, "Talentschub", true, false, true));
			rPD.addPro(new StringedPro(78, "Tierempathie, Tiergruppe", true, false, true));
			rPD.addPro(new StringedPro(79, "Tierempathie, alle", true, false, true));
			
			rPD.addPro(new Pro(80, "Tierfreund"));
			rPD.addPro(new ReferredPro(81, "Übernatürliche Begabung", true, true, true));
			rPD.addPro(new Pro(82, "Unbeschwertes Zaubern", true, true));
			rPD.addPro(new Pro(83, "Verbindungen"));
			rPD.addPro(new Pro(84, "Verhüllte Aura", true, true));
			
			rPD.addPro(new Pro(85, "Viertelzauberer, unentdeckt", true, true));
			rPD.addPro(new Pro(86, "Viertelzauberer, bekannt", true, true));
			rPD.addPro(new Pro(87, "Vollzauberer", true, true));
			rPD.addPro(new Pro(88, "Vom Schicksal begünstigt"));
			rPD.addPro(new ValuedPro(89, "Wesen der Nacht", 3, true, true));
			
			rPD.addPro(new Pro(90, "Wohlklang"));
			rPD.addPro(new Pro(91, "Wolfskind", true, true));
			rPD.addPro(new Pro(92, "Wolfskind, freiwillig", true, true));
			rPD.addPro(new Pro(93, "Zäher Hund"));
			rPD.addPro(new Pro(94, "Zauberhaar", true, true));
			
			rPD.addPro(new Pro(95, "Zeitgefühl"));
			rPD.addPro(new Pro(96, "Zweistimmiger Gesang", true, true));
			rPD.addPro(new Pro(97, "Zwergennase", true, false, true));
			
			// Nachteile
			rPD.addPro(new BadCharacteristic(98, "Aberglaube"));
			rPD.addPro(new Pro(99, "Albino", false));
			rPD.addPro(new StringedBadCharacteristica(100, "Angst vor ", false));
			rPD.addPro(new Pro(101, "Animalische Magie", false, true));
			rPD.addPro(new BadCharacteristic(102, "Arkanophobie", false));
			
			rPD.addPro(new BadCharacteristic(103, "Arroganz", false));
			rPD.addPro(new Pro(104, "Artefaktgebunden", false, true));
			rPD.addPro(new Pro(105, "Astraler Block", false, true));
			rPD.addPro(new BadCharacteristic(106, "Autoritätsgläubig", false));
			rPD.addPro(new Pro(107, "Behäbig", false));
			
			rPD.addPro(new BadCharacteristic(108, "Blutdurst", false));
			rPD.addPro(new Pro(109, "Blutrausch", false));
			rPD.addPro(new BadCharacteristic(110, "Brünstigkeit", false));
			rPD.addPro(new BadCharacteristic(111, "Dunkelangst", false));
			rPD.addPro(new Pro(112, "Einarmig", false));
			
			rPD.addPro(new Pro(113, "Gelähmter Arm", false));
			rPD.addPro(new Pro(114, "Einäugig", false));
			rPD.addPro(new Pro(115, "Einbeinig", false));
			rPD.addPro(new Pro(116, "Einbildungen", false));
			rPD.addPro(new Pro(117, "Eingeschränkte Elementarnähe", false, true));
			
			rPD.addPro(new StringedPro(118, "Engeschränkter Sinn", false));
			rPD.addPro(new Pro(119, "Einhändig", false));
			rPD.addPro(new BadCharacteristic(120, "Eitelkeit", false));
			rPD.addPro(new Pro(121, "Elfische Weltsicht", false));
			rPD.addPro(new Pro(122, "Farbenblind", false));
			
			rPD.addPro(new StringedPro(123, "Feind", false));
			rPD.addPro(new Pro(124, "Feste Gewohntheit", false, true));
			rPD.addPro(new ValuedPro(125, "Festgefügtes Denken", 5, false, true));
			rPD.addPro(new Pro(126, "Fettleibig", false));
			rPD.addPro(new ValuedPro(127, "Fluch der Finsternis", 3, false, true));
			
			rPD.addPro(new BadCharacteristic(128, "Geiz", false));
			rPD.addPro(new BadCharacteristic(129, "Gerechtigkeitswahn", false));
			rPD.addPro(new StringedValuedPro(130, "Gesucht", 3, false));
			rPD.addPro(new Pro(131, "Glasknochen", false));
			rPD.addPro(new BadCharacteristic(132, "Goldgier", false));
			
			rPD.addPro(new BadCharacteristic(133, "Größenwahn", false));
			rPD.addPro(new Pro(134, "Heimwehkrank", false));
			rPD.addPro(new Pro(135, "Hitzeempfindlichkeit", false));
			rPD.addPro(new BadCharacteristic(136, "Höhenangst", false));
			rPD.addPro(new Pro(137, "Impulsiv", false));
			
			rPD.addPro(new BadCharacteristic(138, "Jähzorn", false));
			rPD.addPro(new Pro(139, "Kälteempfindlichkeit", false));
			rPD.addPro(new Pro(140, "Kältestarre", false));
			rPD.addPro(new Pro(141, "Kein Vertrauter", false, true));
			rPD.addPro(new Pro(142, "Kristallgebunden", false, true));
			
			rPD.addPro(new Pro(143, "Kleinwüchsig", false));
			rPD.addPro(new Pro(144, "Körpergebundene Kraft", false, true));
			rPD.addPro(new BadCharacteristic(145, "Krankhafte Reinlichkeit", false));
			rPD.addPro(new Pro(146, "Krankheitsanfällig", false));
			rPD.addPro(new ValuedPro(147, "Kurzatmig", 6, false));
			
			rPD.addPro(new Pro(148, "Lahm", false));
			rPD.addPro(new Pro(149, "Lästige Mindergsiter", false, true));
			rPD.addPro(new Pro(150, "Lichtempfindlichkeit", false));
			rPD.addPro(new Pro(151, "Lichtscheu", false));
			rPD.addPro(new ValuedPro(152, "Madas Fluch", 3, false, true));
			
			rPD.addPro(new Pro(153, "Medium", false));
			rPD.addPro(new BadCharacteristic(154, "Meeresangst", false));
			rPD.addPro(new ReferredPro(155, "Miserable Eigenschaft", false));
			rPD.addPro(new Pro(156, "Mondsüchtig", false));
			rPD.addPro(new StringedPro(157, "Moralkodex", false));
			
			rPD.addPro(new Pro(158, "Nachtblind", false));
			rPD.addPro(new Pro(159, "Nahrungsrestriktion", false));
			rPD.addPro(new BadCharacteristic(160, "Neid", false));
			rPD.addPro(new BadCharacteristic(161, "Neugier", false));
			rPD.addPro(new ValuedPro(162, "Niedrige Astralkraft", 6, false, true));
			
			rPD.addPro(new ValuedPro(163, "Niedrige Lebenskraft", 6, false));
			rPD.addPro(new ValuedPro(164, "Niedrige Magieresitenz", 3, false));
			rPD.addPro(new Pro(165, "Pechmagnet", false));
			rPD.addPro(new BadCharacteristic(166, "Platzangst", false));
			rPD.addPro(new StringedPro(167, "Prinzipientreue", false));
			
			rPD.addPro(new BadCharacteristic(168, "Rachsucht", false));
			rPD.addPro(new StringedPro(169, "Randgruppe", false));
			rPD.addPro(new Pro(170, "Raubtiergeruch", false));
			rPD.addPro(new BadCharacteristic(171, "Raumangst", false));
			rPD.addPro(new Pro(172, "Rückschlag", false, true));
			
			rPD.addPro(new ValuedPro(173, "Schlafstörung", 2, false));
			rPD.addPro(new Pro(174, "Schlafwandler", false));
			rPD.addPro(new Pro(175, "Schlechte Regeneration", false));
			rPD.addPro(new ValuedPro(176, "Schlechter Ruf", 10, false));
			rPD.addPro(new Pro(177, "Schneller Alternd", false));
			
			rPD.addPro(new ValuedPro(178, "Schulden", -1, false));
			rPD.addPro(new ValuedPro(179, "Schwache Ausstrahlung", 5, false, true));
			rPD.addPro(new Pro(180, "Schwacher Astralkörper", false, true));
			rPD.addPro(new Pro(181, "Schwanzlos", false));
			rPD.addPro(new Pro(182, "Seffer Manich", false));
			
			rPD.addPro(new Pro(183, "Selbstgespräche", false));
			rPD.addPro(new StringedBadCharacteristica(184, "Sensibler Geruchssinn", false));
			rPD.addPro(new Pro(185, "Sippenlosigkeit", false));
			rPD.addPro(new BadCharacteristic(186, "Sonnensucht", false));
			rPD.addPro(new StringedPro(187, "Speisegebot", false));
			
			rPD.addPro(new BadCharacteristic(188, "Spielsucht", false));
			rPD.addPro(new Pro(189, "Sprachfehler", false));
			rPD.addPro(new Pro(190, "Spruchhemmung", false, true));
			rPD.addPro(new StringedPro(191, "Stigma", false));
			rPD.addPro(new BadCharacteristic(192, "Streitsucht", false));
			
			rPD.addPro(new Pro(193, "Stubenhocker", false));
			rPD.addPro(new StringedValuedPro(194, "Sucht", 12, false));
			rPD.addPro(new ReferredPro(195, "Thesisgebunden", false, true));
			rPD.addPro(new Pro(196, "Tollpatsch", false));
			rPD.addPro(new BadCharacteristic(197, "Totenangst", false));
			
			rPD.addPro(new Pro(198, "Über Geruch", false));
			rPD.addPro(new Pro(199, "Unangenehme Stimme", false));
			rPD.addPro(new Pro(200, "Unansehnlich", false));
			rPD.addPro(new Pro(201, "Unfähigkeit für Talente", false));
			rPD.addPro(new Pro(202, "Unfähigkeit für Talent-Gruppe", false));
			
			rPD.addPro(new Pro(203, "Unfähigkeit für Merkmal", false, true));
			rPD.addPro(new Pro(204, "Unfähigkeit für Rituale", false, true));
			rPD.addPro(new Pro(205, "Unfrei", false));
			rPD.addPro(new ValuedPro(206, "Ungebildet", 5, false));
			rPD.addPro(new Pro(207, "Unstet", false));
			
			rPD.addPro(new Pro(208, "Unverträglichkeit mit verarbeitetem Metall", false, true));
			rPD.addPro(new Pro(209, "Vergesslichkeit", false));
			rPD.addPro(new Pro(210, "Verpflichtungen", false));
			rPD.addPro(new BadCharacteristic(211, "Verschwendungssucht", false));
			rPD.addPro(new BadCharacteristic(212, "Verwöhnt", false));
			
			rPD.addPro(new StringedBadCharacteristica(213, "Vorurteile", false));
			rPD.addPro(new Pro(214, "Wahnvorstellungen", false));
			rPD.addPro(new Pro(215, "Wahrer Name", false, true));
			rPD.addPro(new StringedBadCharacteristica(216, "Weltfremd", false));
			rPD.addPro(new Pro(217, "Widerwärtiges Aussehen", false));
			
			rPD.addPro(new Pro(218, "Wilde Magie", false, true));
			rPD.addPro(new Pro(219, "Zielschwierigkeiten", false, true));
			rPD.addPro(new Pro(220, "Zögerlicher Zauberer", false, true));
			rPD.addPro(new Pro(221, "Zwergenwuchs", false));
			
//			PD.addPro(new Pro(160, "", false));
		} catch (Exception ex) {throw ex;}
	}
	/**	Dh	17.6.2020
	 * 
	 * @throws Exception
	 */
	private static void genSpecialCrafts() throws Exception{
		List vTemp;
		rSCD = new SpecialCraftDatabase();
		
		try {
			// Allgemeine
			rSCD.addSpecialCraft(new StringedSpecialCraft(0, "Akklimatisierung", 0, new int[] {-1, -1, -1, -1, -1, -1, 12, -1}));
			rSCD.addSpecialCraft(new StringedSpecialCraft(1, "Berufsgeheimnis", 0));
			rSCD.addSpecialCraft(new SpecialCraft(2, "Fälscher", 0));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(3, "Geländerkunde", 0));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(4, "Kulturkunde", 0, new int[] {-1, 10, 10, -1, -1, -1, -1, -1}));
			
			rSCD.addSpecialCraft(new SpecialCraft(5, "Meister der Improvisation", 0, new int[] {-1, -1, 12, -1, 12, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(6, "Nandusgefälliges Wissen", 0, new int[] {-1, 12, 12, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new StringedSpecialCraft(7, "Ortskenntnis", 0));
			rSCD.addSpecialCraft(new SpecialCraft(8, "Rosstäuscher", 0));
			rSCD.addSpecialCraft(new SpecialCraft(9, "Standfest", 0, new int[] {-1, -1, -1, -1, -1, 12, -1, -1}));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(10, "Talentspezialisierung", 0));
			
			// Kampf
			rSCD.addSpecialCraft(new SpecialCraft(11, "Aufmerksamkeit", 1, new int[] {-1, -1, 12, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(12, "Ausfall", 1, new int[] {-1, -1, -1, -1, -1, -1, 12, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(13, "Ausweichen I", 1, new int[] {-1, -1, -1, -1, -1, 10, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(14, "Ausweichen II", 1, new int[] {-1, -1, -1, -1, -1, 12, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(15, "Ausweichen III", 1, new int[] {-1, -1, -1, -1, -1, -1, 12, -1}));
			
			rSCD.addSpecialCraft(new SpecialCraft(16, "Befreiungsschlag", 1, new int[] {12, -1, -1, -1, -1, -1, -1, 15}));
			rSCD.addSpecialCraft(new SpecialCraft(17, "Beidhändiger Kampf I", 1, new int[] {-1, -1, -1, -1, -1, 12, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(18, "Beidhändiger Kampf II", 1, new int[] {-1, -1, -1, -1, -1, 15, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(19, "Berittener Schütze", 1));
			rSCD.addSpecialCraft(new SpecialCraft(20, "Betäubungsschlag", 1));
			
			rSCD.addSpecialCraft(new SpecialCraft(21, "Binden", 1, new int[] {-1, -1, 12, -1, -1, 12, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(22, "Blindkampf", 1, new int[] {-1, -1, -1, -1, -1, 12, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(23, "Defensiver Kampfstil", 1, new int[] {-1, -1, -1, -1, -1, 12, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(24, "Doppelangriff", 1));
			rSCD.addSpecialCraft(new SpecialCraft(25, "Eisenhagel", 1, new int[] {-1, -1, -1, -1, 12, -1, -1, -1}));
			
			rSCD.addSpecialCraft(new SpecialCraft(26, "Entwaffnen", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 12}));
			rSCD.addSpecialCraft(new SpecialCraft(27, "Festnageln", 1, new int[] {-1, -1, -1, -1, -1, 13, -1, 13}));
			rSCD.addSpecialCraft(new SpecialCraft(28, "Finte", 1, new int[] {-1, -1, -1, -1, -1, 12, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(29, "Formation", 1));
			rSCD.addSpecialCraft(new SpecialCraft(30, "Gegenhalten", 1, new int[] {15, -1, -1, -1, -1, 12, -1, -1}));
			
			rSCD.addSpecialCraft(new SpecialCraft(31, "Geschützmeister", 1, new int[] {-1, -1, -1, -1, 12, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(32, "Gezielter Stich", 1));
			rSCD.addSpecialCraft(new SpecialCraft(33, "Halbschwert", 1));
			rSCD.addSpecialCraft(new SpecialCraft(34, "Hammerschlag", 1, new int[] {15, -1, -1, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(35, "Improvisierte Waffen", 1, new int[] {-1, -1, 12, -1, -1, 12, -1, -1}));
			
			rSCD.addSpecialCraft(new SpecialCraft(36, "Kampf im Wasser", 1, new int[] {-1, -1, -1, -1, -1, 12, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(37, "Kampfgespür", 1, new int[] {-1, -1, 15, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(38, "Kampfreflexe", 1));
			rSCD.addSpecialCraft(new SpecialCraft(39, "Klingensturm", 1));
			rSCD.addSpecialCraft(new SpecialCraft(40, "Klingentänzer", 1, new int[] {-1, -1, -1, -1, -1, 15, -1, -1}));
			
			rSCD.addSpecialCraft(new SpecialCraft(41, "Klingenwand", 1));
			rSCD.addSpecialCraft(new SpecialCraft(42, "Kriegsreiterei", 1));
			rSCD.addSpecialCraft(new SpecialCraft(43, "Linkhand", 1, new int[] {-1, -1, -1, -1, -1, 10, -1, 10}));
			rSCD.addSpecialCraft(new SpecialCraft(44, "Meisterliches Entwaffnen", 1, new int[] {-1, -1, -1, -1, -1, 15, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(45, "Meisterparade", 1));
			
			rSCD.addSpecialCraft(new SpecialCraft(46, "Meisterschütze", 1));
			rSCD.addSpecialCraft(new SpecialCraft(47, "Niederwerfen", 1));
			rSCD.addSpecialCraft(new SpecialCraft(48, "Parierwaffen I", 1, new int[] {-1, -1, -1, -1, -1, 12, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(49, "Parierwaffen II", 1, new int[] {-1, -1, -1, -1, -1, 15, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(50, "Reiterkampf", 1));
			
			rSCD.addSpecialCraft(new ReferredSpecialCraft(51, "Rüstungsgewöhnung I", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 10}));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(52, "Rüstungsgewöhnung II", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 12}));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(53, "Rüstungsgewöhnung III", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 15}));
			rSCD.addSpecialCraft(new SpecialCraft(54, "Scharfschütze", 1));
			rSCD.addSpecialCraft(new SpecialCraft(55, "Schildkampf I", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 12}));
			
			rSCD.addSpecialCraft(new SpecialCraft(56, "Schildkampf II", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 15}));
			rSCD.addSpecialCraft(new SpecialCraft(57, "Schildspalter", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 15}));
			rSCD.addSpecialCraft(new SpecialCraft(58, "Schnellladen Bogen", 1, new int[] {-1, -1, -1, -1, 12, -1, -1, 12}));
			rSCD.addSpecialCraft(new SpecialCraft(59, "Schnellladen Armbrust", 1, new int[] {-1, -1, -1, -1, 12, -1, -1, 12}));
			rSCD.addSpecialCraft(new SpecialCraft(60, "Schnellziehen", 1, new int[] {-1, -1, -1, -1, 10, 12, -1, -1}));
			
			rSCD.addSpecialCraft(new SpecialCraft(61, "Spießgespann", 1));
			rSCD.addSpecialCraft(new SpecialCraft(62, "Sturmangriff", 1, new int[] {12, -1, -1, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(63, "Tod von links", 1));
			rSCD.addSpecialCraft(new SpecialCraft(64, "Todesstoß", 1, new int[] {15, -1, -1, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(65, "Turnierreiterei", 1));
			
			rSCD.addSpecialCraft(new SpecialCraft(66, "Umreißen", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 12}));
			rSCD.addSpecialCraft(new SpecialCraft(67, "Unterwasserkampf", 1));
			rSCD.addSpecialCraft(new SpecialCraft(68, "Waffe zerbrechen", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 12}));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(69, "Waffenmeister Waffen", 1));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(70, "Waffenmeister Schilde", 1));
			
			rSCD.addSpecialCraft(new ReferredSpecialCraft(81, "Waffenloses Manöver: ", 1));			
			rSCD.addSpecialCraft(new SpecialCraft(82, "Waffenloser Kampfstil: Bornländisch", 1));
			rSCD.addSpecialCraft(new SpecialCraft(83, "Waffenloser Kampfstil: Gladiatorenstil", 1));
			rSCD.addSpecialCraft(new SpecialCraft(84, "Waffenloser Kampfstil: Hammerfaust", 1));
			rSCD.addSpecialCraft(new SpecialCraft(85, "Waffenloser Kampfstil: Hururuzat", 1));
			
			rSCD.addSpecialCraft(new SpecialCraft(86, "Waffenloser Kampfstil: Mercenario", 1));
			rSCD.addSpecialCraft(new SpecialCraft(87, "Waffenloser Kampfstil: Unauer Schule", 1));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(88, "Waffenspezialisierung", 1));
			rSCD.addSpecialCraft(new SpecialCraft(89, "Windmühle", 1));
			rSCD.addSpecialCraft(new SpecialCraft(90, "Wuchtschlag", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 12}));
			
			// Magische
			rSCD.addSpecialCraft(new SpecialCraft(91, "Apport", 2, new int[] {12, 12, 13, 13, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(92, "Astrale Meditation", 2, new int[] {-1, -1, 13, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(93, "Aura verhüllen", 2, new int[] {13, -1, 13, -1, -1, -1, 12, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(94, "Aurapanzer", 2, new int[] {15, 13, 13, -1, -1, -1, 13, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(95, "Bannschwert", 2));
			
			rSCD.addSpecialCraft(new SpecialCraft(96, "Blutmagie", 2, new int[] {12, -1, -1, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(97, "Chimärenmeister", 2));
			rSCD.addSpecialCraft(new SpecialCraft(98, "Dämonenbindung I", 2));
			rSCD.addSpecialCraft(new SpecialCraft(99, "Dämonenbindung II", 2));
			rSCD.addSpecialCraft(new SpecialCraft(100, "Druidenrache", 2, new int[] {15, -1, -1, -1, -1, -1, -1, -1}));
			
			rSCD.addSpecialCraft(new ReferredSpecialCraft(101, "Druidische Dolchrituale", 2));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(102, "Druidische Herrschaftsrituale", 2));
			rSCD.addSpecialCraft(new SpecialCraft(103, "Eiserner Wille I", 2, new int[] {13, -1, 12, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(104, "Eiserner Wille II", 2, new int[] {13, -1, 12, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(105, "Elementarharmonisierte Aura", 2, new int[] {-1, 15, 15, -1, -1, -1, -1, -1}));
			
			rSCD.addSpecialCraft(new ReferredSpecialCraft(106, "Elfenlieder", 2));
			rSCD.addSpecialCraft(new SpecialCraft(107, "Exorzist", 2, new int[] {15, -1, -1, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(108, "Fernzauberei", 2, new int[] {-1, -1, 12, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(109, "Form der Formlosigkeit", 2));
			rSCD.addSpecialCraft(new SpecialCraft(110, "Geber der Gestalt", 2));
			
			rSCD.addSpecialCraft(new SpecialCraft(111, "Gedankenschutz", 2, new int[] {15, -1, 13, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(112, "Gefäß der Sterne", 2, new int[] {-1, -1, 13, 15, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(113, "Geodenrituale", 2));
			rSCD.addSpecialCraft(new SpecialCraft(114, "Golembauer", 2, new int[] {15, -1, -1, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(115, "Große Meditation", 2, new int[] {-1, 12, 12, -1, -1, -1, -1, -1}));
			
			rSCD.addSpecialCraft(new ReferredSpecialCraft(116, "Hexenflüche", 2));
			rSCD.addSpecialCraft(new SpecialCraft(117, "Höhere Dämonenbindung", 2));
			rSCD.addSpecialCraft(new SpecialCraft(118, "Hypervehemenz", 2));
			rSCD.addSpecialCraft(new SpecialCraft(119, "Invocatio Integra", 2));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(120, "Keulenrituale", 2));
			
			rSCD.addSpecialCraft(new SpecialCraft(121, "Konzentrationsstärke", 2, new int[] {15, -1, -1, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(122, "Kraftkontrolle", 2, new int[] {-1, -1, 12, 13, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(123, "Kraftlinienmagie I", 2, new int[] {-1, 15, -1, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(124, "Kraftlinienmagie II", 2));
			rSCD.addSpecialCraft(new SpecialCraft(125, "Kraftspeicher", 2));
			
			rSCD.addSpecialCraft(new ReferredSpecialCraft(126, "Kristallomantische Rituale", 2));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(127, "Kugelzauber", 2));
			rSCD.addSpecialCraft(new SpecialCraft(128, "Lockeres Zaubern", 2, new int[] {-1, -1, 16, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(129, "Matrixgeber", 2));
			rSCD.addSpecialCraft(new SpecialCraft(130, "Matrixkontrolle", 2));
			
			rSCD.addSpecialCraft(new SpecialCraft(131, "Matrixregeneration I", 2, new int[] {-1, -1, 14, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(132, "Matrixregeneration II", 2, new int[] {-1, -1, 16, 13, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(133, "Matrixverständnis", 2, new int[] {-1, -1, 15, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(134, "Meisterliche Regeneration", 2));
			rSCD.addSpecialCraft(new SpecialCraft(135, "Meisterliche Zauberkontrolle I", 2, new int[] {12, 15, -1, -1, -1, -1, -1, -1}));
			
			rSCD.addSpecialCraft(new SpecialCraft(136, "Meisterliche Zauberkontrolle II", 2, new int[] {12, 15, -1, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(137, "Merkmalkenntnis", 2, new int[] {-1, 13, -1, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(138, "Nekromant", 2, new int[] {15, -1, -1, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(139, "Odûns Gaben", 2));
			rSCD.addSpecialCraft(new SpecialCraft(140, "Ottagaldr", 2));
			
			rSCD.addSpecialCraft(new SpecialCraft(141, "Regeneration I", 2, new int[] {-1, -1, 12, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(142, "Regeneration II", 2, new int[] {-1, -1, 15, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(143, "Repräsentation", 2));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(144, "Ritualkenntnis", 2));
			rSCD.addSpecialCraft(new SpecialCraft(145, "Runenkunde", 2, new int[] {-1, -1, -1, -1, 12, -1, -1, -1}));
			
			rSCD.addSpecialCraft(new SpecialCraft(146, "Salsandra", 2));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(147, "Schalenzauber", 2));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(148, "Schamanistische Rituale", 2));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(149, "Schlangenring-Zauber", 2));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(150, "Schuppenbeutel", 2));
			
			rSCD.addSpecialCraft(new SpecialCraft(151, "Semipermanenz I", 2));
			rSCD.addSpecialCraft(new SpecialCraft(152, "Semipermanenz II", 2));
			rSCD.addSpecialCraft(new SpecialCraft(153, "Signaturkenntnis", 2, new int[] {-1, 15, 15, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(154, "Simultanzaubern", 2, new int[] {-1, 15, -1, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(155, "Stabzauber", 2));
			
			rSCD.addSpecialCraft(new SpecialCraft(156, "Stapeleffekt", 2));
			rSCD.addSpecialCraft(new SpecialCraft(157, "Tanz der Mada", 2));
			rSCD.addSpecialCraft(new StringedSpecialCraft(158, "Tierischer Begleiter", 2));
			rSCD.addSpecialCraft(new SpecialCraft(159, "Traumgänger", 2, new int[] {-1, -1, 12, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(160, "Trommelzauber", 2));
			
			rSCD.addSpecialCraft(new SpecialCraft(161, "Verbotene Pfoten", 2, new int[] {12, -1, -1, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new StringedSpecialCraft(162, "Vertrautenbindung", 2));
			rSCD.addSpecialCraft(new SpecialCraft(163, "Vielfache Ladungen", 2));
			rSCD.addSpecialCraft(new SpecialCraft(164, "Zauber bereithalten", 2, new int[] {15, 15, -1, -1, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(165, "Zauberkontrolle", 2, new int[] {-1, 12, -1, -1, -1, -1, -1, -1}));
			
			rSCD.addSpecialCraft(new SpecialCraft(166, "Zauberroutine", 2));
			rSCD.addSpecialCraft(new SpecialCraft(167, "Zauber unterbrechen", 2));
			rSCD.addSpecialCraft(new SpecialCraft(168, "Zauber vereinigen", 2));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(169, "Zauberspezialisierung", 2));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(170, "Zaubertänzer", 2));
			
			rSCD.addSpecialCraft(new SpecialCraft(171, "Zauberzeichen", 2, new int[] {-1, 12, 12, -1, 12, -1, -1, -1}));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(172, "Zibilja-Rituale", 2));
			
			// Geweihte
			rSCD.addSpecialCraft(new SpecialCraft(173, "Akoluth", 3));
			rSCD.addSpecialCraft(new SpecialCraft(174, "Aura der Heiligkeit", 3, new int[] {-1, -1, 15, 15, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new SpecialCraft(175, "Karmalqueste", 3));
			
			rSCD.addSpecialCraft(new SpecialCraft(176, "Kontakt zum Großen Geist", 3, new int[] {-1, -1, -1, 15, -1, -1, -1, -1}));
			rSCD.addSpecialCraft(new StringedSpecialCraft(177, "Liturgiekenntnis", 3));
			rSCD.addSpecialCraft(new ReferredSpecialCraft(178, "Liturgie", 3));
			rSCD.addSpecialCraft(new StringedSpecialCraft(179, "Ritualkenntnis", 3));
			rSCD.addSpecialCraft(new StringedSpecialCraft(180, "Spätweihe", 3, new int[] {-1, -1, -1, 11, -1, -1, -1, -1}));
			
			
			// Setzte Vorraussetzungen
			// Allgemeine
			rSCD.addTypedPremiseOfSpecialCraft("Berufsgeheimnis", 4, 7, 15);
			rSCD.addTypedPremiseOfSpecialCraft("Berufsgeheimnis", 4, 7, 7);
			
			rSCD.addTypedPremiseOfSpecialCraft("Fälscher", 3, rTD.getTalent("Alchemie").getId(), 5);
			rSCD.addTypedPremiseOfSpecialCraft("Fälscher", 3, rTD.getTalent("Malen/Zeichnen").getId(), 7);
			rSCD.addTypedPremiseOfSpecialCraft("Fälscher", 3, rTD.getTalent("Schriftlicher Ausdruck").getId(), 5);
			
			rSCD.addTypedPremiseOfSpecialCraft("Rosstäuscher", 3, rTD.getTalent("Reiten").getId(), 7);
			rSCD.addTypedPremiseOfSpecialCraft("Rosstäuscher", 3, rTD.getTalent("Sich Verkleiden").getId(), 7);
			rSCD.addTypedPremiseOfSpecialCraft("Rosstäuscher", 3, rTD.getTalent("Abrichten").getId(), 7);
			rSCD.addTypedPremiseOfSpecialCraft("Rosstäuscher", 3, rTD.getTalent("Überreden").getId(), 7);
			
			rSCD.addTypedPremiseOfSpecialCraft("Talentspezialisierung", 4, 9, 7);
			
			// Kampf
			rSCD.addTypedPremiseOfSpecialCraft("Ausfall", 1, rSCD.getSpecialCraft("Finte").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Ausweichen II", 1, rSCD.getSpecialCraft("Ausweichen I").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Ausweichen II", 1, rSCD.getSpecialCraft("Aufmerksamkeit").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Ausweichen III", 1, rSCD.getSpecialCraft("Ausweichen II").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Ausweichen III", 1, rSCD.getSpecialCraft("Kampfreflexe").getId());
			
			rSCD.addTypedPremiseOfSpecialCraft("Befreiungsschlag", 1, rSCD.getSpecialCraft("Niederwerfen").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Beidhändiger Kampf I", 1, rSCD.getSpecialCraft("Linkhand").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Beidhändiger Kampf II", 1, rSCD.getSpecialCraft("Beidhändiger Kampf I").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Berittener Schütze", 3, rTD.getTalent("Reiten").getId(), 7);
			rSCD.addTypedPremiseOfSpecialCraft("Betäubungsschlag", 1, rSCD.getSpecialCraft("Finte").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Betäubungsschlag", 1, rSCD.getSpecialCraft("Wuchtschlag").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Binden", 1, rSCD.getSpecialCraft("Meisterparade").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Binden", 1, rSCD.getSpecialCraft("Parierwaffen I").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Blindkampf", 1, rSCD.getSpecialCraft("Kampfgespür").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Blindkampf", 3, rTD.getTalent("Sinnenschärfe").getId(), 15);
			
			rSCD.addTypedPremiseOfSpecialCraft("Defensiver Kampfstil", 1, rSCD.getSpecialCraft("Meisterparade").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Doppelangriff", 1, rSCD.getSpecialCraft("Beidhändiger Kampf I").getId());
			
			rSCD.addTypedPremiseOfSpecialCraft("Eisenhagel", 3, rTD.getTalent("Wurfmesser").getId(), 10);
			rSCD.addTypedPremiseOfSpecialCraft("Entwaffnen", 1, rSCD.getSpecialCraft("Binden").getId());
			
			rSCD.addTypedPremiseOfSpecialCraft("Formation", 1, rSCD.getSpecialCraft("Aufmerksamkeit").getId());
			
			rSCD.addTypedPremiseOfSpecialCraft("Gegenhalten", 1, rSCD.getSpecialCraft("Meisterparade").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Geschützmeister", 3, rTD.getTalent("Belagerungswaffen").getId(), 10);
			rSCD.addTypedPremiseOfSpecialCraft("Geschützmeister", 3, rTD.getTalent("Mechanik").getId(), 7);
			rSCD.addTypedPremiseOfSpecialCraft("Gezielter Stich", 1, rSCD.getSpecialCraft("Finte").getId());
			
			rSCD.addTypedPremiseOfSpecialCraft("Halbschwert", 1, rSCD.getSpecialCraft("Aufmerksamkeit").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Hammerschlag", 1, rSCD.getSpecialCraft("Niederwerfen").getId());
			
			rSCD.addTypedPremiseOfSpecialCraft("Improvisierte Waffen", 3, rTD.getTalent("Raufen").getId(), 10);
			
			rSCD.addTypedPremiseOfSpecialCraft("Kampf im Wasser", 3, rTD.getTalent("Körperbeherrschung").getId(), 7);
			rSCD.addTypedPremiseOfSpecialCraft("Kampfgespür", 1, rSCD.getSpecialCraft("Aufmerksamkeit").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Kampfreflexe", 2, 0, 10);
			
			rSCD.addTypedPremiseOfSpecialCraft("Klingensturm", 2, 1, 9);
			rSCD.addTypedPremiseOfSpecialCraft("Klingensturm", 1, rSCD.getSpecialCraft("Ausfall").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Klingensturm", 1, rSCD.getSpecialCraft("Kampfreflexe").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Klingentänzer", 1, rSCD.getSpecialCraft("Kampfgespür").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Klingentänzer", 1, rSCD.getSpecialCraft("Klingensturm").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Klingentänzer", 1, rSCD.getSpecialCraft("Klingenwand").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Klingenwand", 2, 2, 9);
			rSCD.addTypedPremiseOfSpecialCraft("Klingenwand", 1, rSCD.getSpecialCraft("Defensiver Kampfstil").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Klingenwand", 1, rSCD.getSpecialCraft("Kampfreflexe").getId());
			
			rSCD.addTypedPremiseOfSpecialCraft("Kriegsreiterei", 3, rTD.getTalent("Reiten").getId(), 10);
			rSCD.addTypedPremiseOfSpecialCraft("Kriegsreiterei", 1, rSCD.getSpecialCraft("Reiterkampf").getId());
			
			rSCD.addTypedPremiseOfSpecialCraft("Meisterliches Entwaffnen", 1, rSCD.getSpecialCraft("Entwaffnen").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Meisterparade", 2, 2, 8);
			rSCD.addTypedPremiseOfSpecialCraft("Meisterschütze", 1, rSCD.getSpecialCraft("Scharfschütze").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Meisterschütze", 4, 1, 15);
			
			rSCD.addTypedPremiseOfSpecialCraft("Niederwerfen", 1, rSCD.getSpecialCraft("Wuchtschlag").getId());
			
			rSCD.addTypedPremiseOfSpecialCraft("Parierwaffen I", 1, rSCD.getSpecialCraft("Linkhand").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Parierwaffen II", 1, rSCD.getSpecialCraft("Parierwaffen I").getId());
			
			rSCD.addTypedPremiseOfSpecialCraft("Reiterkampf", 3, rTD.getTalent("Reiten").getId(), 7);
			rSCD.addTypedPremiseOfSpecialCraft("Rüstungsgewöhnung II", 1, rSCD.getSpecialCraft("Rüstungsgewöhnung I").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Rüstungsgewöhnung III", 1, rSCD.getSpecialCraft("Rüstungsgewöhnung II").getId());
			
			rSCD.addTypedPremiseOfSpecialCraft("Scharfschütze", 4, 1, 7);
			rSCD.addTypedPremiseOfSpecialCraft("Schildkampf I", 1, rSCD.getSpecialCraft("Linkhand").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Schildkampf II", 1, rSCD.getSpecialCraft("Schildkampf I").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Schildspalter", 1, rSCD.getSpecialCraft("Niederwerfen").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Schnellladen Armbrust", 3, rTD.getTalent("Armbrust").getId(), 7);
			rSCD.addTypedPremiseOfSpecialCraft("Schnellladen Bogen", 3, rTD.getTalent("Bogen").getId(), 7);
			rSCD.addTypedPremiseOfSpecialCraft("Spießgespann", 3, rTD.getTalent("Speere").getId(), 10);
			rSCD.addTypedPremiseOfSpecialCraft("Spießgespann", 1, rSCD.getSpecialCraft("Sturmangriff").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Sturmangriff", 1, rSCD.getSpecialCraft("Wuchtschlag").getId());
			
			rSCD.addTypedPremiseOfSpecialCraft("Tod von links", 1, rSCD.getSpecialCraft("Beidhändiger Kampf I").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Tod von links", 1, rSCD.getSpecialCraft("Parierwaffen II").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Todesstpß", 1, rSCD.getSpecialCraft("Gezielter Stich").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Turnierreiterei", 3, rTD.getTalent("Reiten").getId(), 10);
			rSCD.addTypedPremiseOfSpecialCraft("Turnierreiterei", 1, rSCD.getSpecialCraft("Reiterkampf").getId());
			
			rSCD.addTypedPremiseOfSpecialCraft("Umreißen", 1, rSCD.getSpecialCraft("Finte").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Unterwasserkampf", 3, rTD.getTalent("Schwimmen").getId(), 10);
			
			rSCD.addTypedPremiseOfSpecialCraft("Waffenmeister Waffen", 4, 8, 18);
			rSCD.addTypedPremiseOfSpecialCraft("Waffenmeister Schilde", 1, rSCD.getSpecialCraft("Schildkampf II").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Waffenmeister Schilde", 1, rSCD.getSpecialCraft("Beidhändiger Kampf I").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Waffenmeister Schilde", 1, rSCD.getSpecialCraft("Parierwaffen I").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Waffenspezialisierung", 4, 8, 7);
			rSCD.addTypedPremiseOfSpecialCraft("Windmühle", 1, rSCD.getSpecialCraft("Gegenhalten").getId());
			rSCD.addTypedPremiseOfSpecialCraft("Windmühle", 1, rSCD.getSpecialCraft("Wuchtschlag").getId());
			
			// Magischer
			rSCD.addTypedPremiseOfSpecialCraft("Aurapanzer", 1, rSCD.getSpecialCraft("Gedankenschutz").getId());
			
			// SCD.addTypedPremiseOfSpecialCraft("", 1, SCD.getSpecialCraft("").getID());
			// SCD.addTypedPremiseOfSpecialCraft("", 2, , );
			// SCD.addTypedPremiseOfSpecialCraft("", 3, TD.getTalent("").getID(), );
			// SCD.addTypedPremiseOfSpecialCraft("", 4, , );
		} catch (Exception ex) {throw ex;}
	}
	/**	Dh	2.7.2020
	 * 
	 * 	Properties: 
	 * 	  0 Mut					4 Fingerfertigkeit
	 * 	  1 Klugkheit			5 Gewandheit
	 * 	  2 Intuition			6 Konstitution
	 * 	  3 Charisma			7 Koerperkraft
	 * 
	 * 	Category:
	 *     0: Bewaffneter Nahkampf
	 *     1: Waffenloser Kampf
	 *     2: Fernkampf
	 *     
	 *	WeaponType:
	 * 	 00: Raufen				13: Staebe
	 * 	 01: Ringen				14: Zweihandpflegel
	 * 	 02: Anderhalbhaender	15: Zweihand-Hiebwaffen
	 * 	 03: Dolche				16: Zweihandschwerter
	 * 	 04: Fechtwaffen		17: Improvisiert
	 * 	 05: Hiebwaffen			18: Armbrust
	 * 	 06: Infanteriewaffen	19: Blasrohr
	 * 	 07: Kettenstaebe		20: Bogen
	 * 	 08: Kettenwwaffen		21: Diskus
	 * 	 09: Peitsche			22: Schleuder
	 * 	 10: Saebel				23: Wurfbeil
	 * 	 11: Schwerter			24: Wurfmesser
	 * 	 12: Speere				25: Wurfspeer
	 */
	private static void genTalents() throws Exception{
		rTD = new TalentDatabase();
		
		try {
			//	Kampftalente
			rTD.addTalent(new Fighttalent(0, "Anderthalbhänder", 0, new int[] {1,-2}, new int[] {2, 11, 16}));
			rTD.addTalent(new Fighttalent(1, "Armbrust", 2, new int[] {1,-5}, new int[] {18, 20}));
			rTD.addTalent(new Fighttalent(2, "Belagerungswaffen", 2, new int[] {0,0}, new int[] {}));
			rTD.addTalent(new Fighttalent(3, "Blasrohr", 2, new int[] {1,-5}, new int[] {19}));
			rTD.addTalent(new Fighttalent(4, "Bogen", 2, new int[] {1,-3}, new int[] {20}));
			
			rTD.addTalent(new Fighttalent(5, "Diskus", 2, new int[] {1,-2}, new int[] {21}));
			rTD.addTalent(new Fighttalent(6, "Dolche", 0, new int[] {1,-1}, new int[] {3, 7, 0}));
			rTD.addTalent(new Fighttalent(7, "Fechtwaffen", 0, new int[] {1,-1}, new int[] {4, 3, 11}));
			rTD.addTalent(new Fighttalent(8, "Hiebwaffen", 0, new int[] {1,-4}, new int[] {5, 10}));
			rTD.addTalent(new Fighttalent(9, "Infanteriewaffen", 0, new int[] {1,-3}, new int[] {6, 12, 15}));
			
			rTD.addTalent(new Fighttalent(10, "Kettenstäbe", 0, new int[] {1,-1}, new int[] {7, 8, 14}));
			rTD.addTalent(new Fighttalent(11, "Kettenwaffen", 0, new int[] {1,-3}, new int[] {8, 7, 14}));
			rTD.addTalent(new Fighttalent(12, "Lanzenreiten", 0, new int[] {0,0}, new int[] {}));
			rTD.addTalent(new Fighttalent(13, "Peitsche", 0, new int[] {1,-1}, new int[] {9}));
			rTD.addTalent(new Fighttalent(14, "Raufen", 1, new int[] {1,0}, new int[] {0}));
			
			rTD.addTalent(new Fighttalent(15, "Ringen", 1, new int[] {1,0}, new int[] {1}));
			rTD.addTalent(new Fighttalent(16, "Säbel", 0, new int[] {1,-2}, new int[] {10, 5, 11}));
			rTD.addTalent(new Fighttalent(17, "Schleuder", 2, new int[] {1,-2}, new int[] {22}));
			rTD.addTalent(new Fighttalent(18, "Schwerter", 0, new int[] {1,-2}, new int[] {11, 2, 4, 10}));
			rTD.addTalent(new Fighttalent(19, "Speere", 0, new int[] {1,-3}, new int[] {12, 6}));
			
			rTD.addTalent(new Fighttalent(20, "Stäbe", 0, new int[] {1,-2}, new int[] {13, 12}));
			rTD.addTalent(new Fighttalent(21, "Wurfbeile", 2, new int[] {1,-2}, new int[] {23, 24, 25}));
			rTD.addTalent(new Fighttalent(22, "Wurfmesser", 2, new int[] {1,-3}, new int[] {24, 23, 25}));
			rTD.addTalent(new Fighttalent(23, "Wurfspeere", 2, new int[] {1,-2}, new int[] {25, 23, 24}));
			rTD.addTalent(new Fighttalent(24, "Zweihandflegel", 0, new int[] {1,-3}, new int[] {14, 6, 8}));
			
			rTD.addTalent(new Fighttalent(25, "Zweihand-Hiebwaffen", 0, new int[] {1,-3}, new int[] {15, 5, 6}));
			rTD.addTalent(new Fighttalent(26, "Zweihandschwerter/-säbel", 0, new int[] {1,-2}, new int[] {16, 2, 11, 10}));
			
			// Koerperliche Talente
			rTD.addTalent(new PhysicalTalent(27, "Akrobatik", new int[] {0, 5, 7}, new int[] {2, 0}));
			rTD.addTalent(new PhysicalTalent(28, "Athletik", new int[] {5, 6, 7}, new int[] {2, 0}));
			rTD.addTalent(new PhysicalTalent(29, "Fliegen", new int[] {0, 2, 5}, new int[] {2, 0}));
			rTD.addTalent(new PhysicalTalent(30, "Gaukelei", new int[] {0, 3, 4}, new int[] {2, 0}));
			rTD.addTalent(new PhysicalTalent(31, "Klettern", new int[] {0, 5, 7}, new int[] {2, 0}));
			
			rTD.addTalent(new PhysicalTalent(32, "Körperbeherrschung", new int[] {0, 2, 5}, new int[] {2, 0}));
			rTD.addTalent(new PhysicalTalent(33, "Reiten", new int[] {3, 5, 7}, new int[] {2, 0}));
			rTD.addTalent(new PhysicalTalent(34, "Schleichen", new int[] {0, 2, 5}, new int[] {2, 0}));
			rTD.addTalent(new PhysicalTalent(35, "Schwimmen", new int[] {5, 6, 7}, new int[] {2, 0}));
			rTD.addTalent(new PhysicalTalent(36, "Selbstbeherrschung", new int[] {0, 6, 7}, new int[] {2, 0}));
			
			rTD.addTalent(new PhysicalTalent(37, "Sich Verstecken", new int[] {0, 2, 5}, new int[] {2, 0}));
			rTD.addTalent(new PhysicalTalent(38, "Singen", new int[] {2, 3, 3}, new int[] {2, 0}));
			rTD.addTalent(new PhysicalTalent(39, "Sinnenschärfe", new int[] {1, 2, 2}, new int[] {2, 0}));
			rTD.addTalent(new PhysicalTalent(40, "Skifahren", new int[] {5, 5, 6}, new int[] {2, 0}));
			rTD.addTalent(new PhysicalTalent(41, "Stimmen imitieren", new int[] {1, 2, 3}, new int[] {2, 0}));
			
			rTD.addTalent(new PhysicalTalent(42, "Tanzen", new int[] {3, 5, 5}, new int[] {2, 0}));
			rTD.addTalent(new PhysicalTalent(43, "Taschendiebstahl", new int[] {0, 2, 4}, new int[] {2, 0}));
			rTD.addTalent(new PhysicalTalent(44, "Zechen", new int[] {2, 6, 7}, new int[] {2, 0}));
			
			// Gesellschaftliche Talente
			rTD.addTalent(new Basictalent(3, 45, "Betören", new int[] {2, 3, 3}));
			rTD.addTalent(new Basictalent(3, 46, "Etikette", new int[] {1, 2, 3}));
			rTD.addTalent(new Basictalent(3, 47, "Gassenwissen", new int[] {1, 2, 3}));
			rTD.addTalent(new Basictalent(3, 48, "Lehren", new int[] {1, 2, 3}));
			rTD.addTalent(new Basictalent(3, 49, "Menschenkenntnis", new int[] {1, 2, 3}));
			
			rTD.addTalent(new Basictalent(3, 50, "Schauspielerei", new int[] {0, 1, 3}));
			rTD.addTalent(new Basictalent(3, 51, "Schriftlicher Ausdruck", new int[] {1, 2, 2}));
			rTD.addTalent(new Basictalent(3, 52, "Sich Verkleiden", new int[] {0, 3, 5}));
			rTD.addTalent(new Basictalent(3, 53, "Überreden", new int[] {0, 2, 3}));
			rTD.addTalent(new Basictalent(3, 54, "Überzeugen", new int[] {1, 2, 3}));
			
			// Natur Talente
			rTD.addTalent(new Basictalent(4, 55, "Fährtensuchen", new int[] {1, 2, 2}));
			rTD.addTalent(new Basictalent(4, 56, "Fallenstellen", new int[] {1, 4, 7}));
			rTD.addTalent(new Basictalent(4, 57, "Fesseln/Entfesseln", new int[] {4, 5, 7}));
			rTD.addTalent(new Basictalent(4, 58, "Fischen/Angeln", new int[] {2, 4, 7}));
			rTD.addTalent(new Basictalent(4, 59, "Orientierung", new int[] {1, 2, 2}));
			rTD.addTalent(new Basictalent(4, 60, "Wettervorhersage", new int[] {1, 2, 2}));
			rTD.addTalent(new Basictalent(4, 61, "Wildnisleben", new int[] {2, 5, 6}));
			
			// Wissenstalente
			rTD.addTalent(new Basictalent(5, 62, "Anatomie", new int[] {0, 1, 4}));
			rTD.addTalent(new Basictalent(5, 63, "Baukunst", new int[] {1, 1, 4}));
			rTD.addTalent(new Basictalent(5, 64, "Brettspiel", new int[] {1, 1, 2}));
			rTD.addTalent(new Basictalent(5, 65, "Geographie", new int[] {1, 1, 2}));
			rTD.addTalent(new Basictalent(5, 66, "Geschichtswissen", new int[] {1, 1, 2}));
			
			rTD.addTalent(new Basictalent(5, 67, "Gesteinskunde", new int[] {1, 2, 4}));
			rTD.addTalent(new Basictalent(5, 68, "Götter/Kulte", new int[] {1, 1, 2}));
			rTD.addTalent(new Basictalent(5, 69, "Heraldik", new int[] {1, 1, 4}));
			rTD.addTalent(new Basictalent(5, 70, "Hüttenkunde", new int[] {1, 2, 6}));
			rTD.addTalent(new Basictalent(5, 71, "Kriegskunst", new int[] {0, 1, 3}));
			
			rTD.addTalent(new Basictalent(5, 72, "Kryptographie", new int[] {1, 1, 2}));
			rTD.addTalent(new Basictalent(5, 73, "Magiekunde", new int[] {1, 1, 2}));
			rTD.addTalent(new Basictalent(5, 74, "Mechanik", new int[] {1, 1, 4}));
			rTD.addTalent(new Basictalent(5, 75, "Pflanzenkunde", new int[] {1, 1, 4}));
			rTD.addTalent(new Basictalent(5, 76, "Philosophie", new int[] {1, 1, 2}));
			
			rTD.addTalent(new Basictalent(5, 77, "Rechnen", new int[] {1, 1, 2}));
			rTD.addTalent(new Basictalent(5, 78, "Rechtskunde", new int[] {1, 1, 2}));
			rTD.addTalent(new Basictalent(5, 79, "Sagen/Legenden", new int[] {1, 2, 3}));
			rTD.addTalent(new Basictalent(5, 80, "Schätzen", new int[] {1, 2, 2}));
			rTD.addTalent(new Basictalent(5, 81, "Sprachkunde", new int[] {1, 1, 2}));
			
			rTD.addTalent(new Basictalent(5, 82, "Staatskunst", new int[] {1, 2, 3}));
			rTD.addTalent(new Basictalent(5, 83, "Sternkunde", new int[] {1, 1, 2}));
			rTD.addTalent(new Basictalent(5, 84, "Tierkunde", new int[] {0, 1, 2}));
			
			// Sprachen
			rTD.addTalent(new Communicationtalent(85, "Garethi", true, 18));
			rTD.addTalent(new Communicationtalent(86, "Bosperano", true, 21));
			rTD.addTalent(new Communicationtalent(87, "Aureliani", true, 21));
			rTD.addTalent(new Communicationtalent(88, "Zyklopäisch", true, 18));
			
			rTD.addTalent(new Communicationtalent(89, "Tulamidya", true, 18));
			rTD.addTalent(new Communicationtalent(90, "Ur-Tulamidya", true, 21));
			rTD.addTalent(new Communicationtalent(91, "Zelemja", true, 18));
			rTD.addTalent(new Communicationtalent(92, "Alaani", true, 21));
			rTD.addTalent(new Communicationtalent(93, "Zhuchammaqra", true, 15));
			rTD.addTalent(new Communicationtalent(94, "Ferkina", true, 16));
			rTD.addTalent(new Communicationtalent(95, "Ruuz", true, 18));
			rTD.addTalent(new Communicationtalent(96, "Altes Kemi", true, 18));
			rTD.addTalent(new Communicationtalent(97, "Rabensprache", true, 15));
			
			rTD.addTalent(new Communicationtalent(98, "Thorwalsch", true, 18));
			rTD.addTalent(new Communicationtalent(99, "Hjaldingsch", true, 18));
			
			rTD.addTalent(new Communicationtalent(100, "Isdira", true, 21));
			rTD.addTalent(new Communicationtalent(101, "Asharia", true, 24));
			
			rTD.addTalent(new Communicationtalent(102, "Rogolan", true, 21));
			rTD.addTalent(new Communicationtalent(103, "Angram", true, 21));
			
			rTD.addTalent(new Communicationtalent(104, "Ologhaijan", true, 15));
			rTD.addTalent(new Communicationtalent(105, "Oloarkh", true, 10));
			
			rTD.addTalent(new Communicationtalent(106, "Mahrisch", true, 20));
			rTD.addTalent(new Communicationtalent(107, "Rissoal", true, 20));
			
			rTD.addTalent(new Communicationtalent(108, "Drachisch", true, 21));
			rTD.addTalent(new Communicationtalent(109, "Goblinisch", true, 12));
			rTD.addTalent(new Communicationtalent(110, "Grolmisch", true, 17));
			rTD.addTalent(new Communicationtalent(111, "Koboldisch", true, 15));
			rTD.addTalent(new Communicationtalent(112, "Molochisch", true, 17));
			rTD.addTalent(new Communicationtalent(113, "Neckergesang", true, 18));
			rTD.addTalent(new Communicationtalent(114, "Nujuka", true, 15));
			rTD.addTalent(new Communicationtalent(115, "Rssahh", true, 18));
			rTD.addTalent(new Communicationtalent(116, "Trollisch", true, 15));
			rTD.addTalent(new Communicationtalent(117, "Waldmenschen-Sprachen", true, 15));
			rTD.addTalent(new Communicationtalent(118, "Z'Lit", true, 17));
			
			rTD.addTalent(new Communicationtalent(119, "Zhayad", true, 15));
			rTD.addTalent(new Communicationtalent(120, "Atak", true, 12));
			rTD.addTalent(new Communicationtalent(121, "Füchsisch", true, 12));
			
			// Schrift
			rTD.addTalent(new Communicationtalent(122, "Altes Alaani", false, 18));
			rTD.addTalent(new Communicationtalent(123, "Altes Kemi", false, 21));
			rTD.addTalent(new Communicationtalent(124, "Amulashtra", false, 17));
			rTD.addTalent(new Communicationtalent(125, "Angram", false, 21));
			rTD.addTalent(new Communicationtalent(126, "Arkanil", false, 24));
			
			rTD.addTalent(new Communicationtalent(127, "Chrmk", false, 18));
			rTD.addTalent(new Communicationtalent(128, "Chuchas", false, 24));
			rTD.addTalent(new Communicationtalent(129, "Drakhard-Kinken", false, 9));
			rTD.addTalent(new Communicationtalent(130, "Drakned-Glyphen", false, 15));
			rTD.addTalent(new Communicationtalent(131, "Geheiligte Glyphen von Unau", false, 13));
			
			rTD.addTalent(new Communicationtalent(132, "Gimaril", false, 10));
			rTD.addTalent(new Communicationtalent(133, "Gjalkisch", false, 14));
			rTD.addTalent(new Communicationtalent(134, "Hjaldingsche Runen", false, 10));
			rTD.addTalent(new Communicationtalent(135, "Imperiale Zeichen", false, 12));
			rTD.addTalent(new Communicationtalent(136, "Isdira/Asdharia", false, 15));
			
			rTD.addTalent(new Communicationtalent(137, "Kusliker Zeichen", false, 10));
			rTD.addTalent(new Communicationtalent(138, "Mahrische Gylphen", false, 15));
			rTD.addTalent(new Communicationtalent(139, "Nanduria", false, 10));
			rTD.addTalent(new Communicationtalent(140, "Rogolan", false, 11));
			rTD.addTalent(new Communicationtalent(141, "Trollische Raumbildschrift", false, 24));
			
			rTD.addTalent(new Communicationtalent(142, "Tulamidya", false, 14));
			rTD.addTalent(new Communicationtalent(143, "Ur-Tulamidya", false, 16));
			rTD.addTalent(new Communicationtalent(144, "Zhayad", false, 18));
			
			// Handwerkstalente
			rTD.addTalent(new Basictalent(7, 145, "Abrichten", new int[] {0, 2, 3}));
			rTD.addTalent(new Basictalent(7, 146, "Ackerbau", new int[] {2, 4, 6}));
			rTD.addTalent(new Basictalent(7, 147, "Alchemie", new int[] {0, 1, 4}));
			rTD.addTalent(new Basictalent(7, 148, "Bergbau", new int[] {2, 6, 7}));
			rTD.addTalent(new Basictalent(7, 149, "Bogenbau", new int[] {1, 2, 4}));
			
			rTD.addTalent(new Basictalent(7, 150, "Boote fahren", new int[] {5, 6, 7}));
			rTD.addTalent(new Basictalent(7, 151, "Brauer", new int[] {1, 4, 7}));
			rTD.addTalent(new Basictalent(7, 152, "Drucker", new int[] {1, 4, 7}));
			rTD.addTalent(new Basictalent(7, 153, "Farhzeug lenken", new int[] {2, 3, 4}));
			rTD.addTalent(new Basictalent(7, 154, "Falschspiel", new int[] {0, 3, 4}));
			
			rTD.addTalent(new Basictalent(7, 155, "Feinmechanik", new int[] {1, 4, 4}));
			rTD.addTalent(new Basictalent(7, 156, "Feuersteinbearbeitung", new int[] {1, 4, 4}));
			rTD.addTalent(new Basictalent(7, 157, "Fleischer", new int[] {1, 4, 7}));
			rTD.addTalent(new Basictalent(7, 158, "Gerber/Kürschner", new int[] {1, 4, 6}));
			rTD.addTalent(new Basictalent(7, 159, "Glaskunst", new int[] {4, 4, 6}));
			
			rTD.addTalent(new Basictalent(7, 160, "Grobschmied", new int[] {4, 6, 7}));
			rTD.addTalent(new Basictalent(7, 161, "Handel", new int[] {1, 2, 3}));
			rTD.addTalent(new Basictalent(7, 162, "Hauswirtschaft", new int[] {2, 3, 4}));
			rTD.addTalent(new Basictalent(7, 163, "Heilkunde Gift", new int[] {0, 1, 2}));
			rTD.addTalent(new Basictalent(7, 164, "Heilkunde Krankheiten", new int[] {0, 1, 3}));
			
			rTD.addTalent(new Basictalent(7, 165, "Heilkunde Seele", new int[] {2, 3, 3}));
			rTD.addTalent(new Basictalent(7, 166, "Heilkunde Wunden", new int[] {1, 3, 4}));
			rTD.addTalent(new Basictalent(7, 167, "Holzbearbeitung", new int[] {1, 4, 7}));
			rTD.addTalent(new Basictalent(7, 168, "Instrumentenbauer", new int[] {1, 2, 4}));
			rTD.addTalent(new Basictalent(7, 169, "Kartographie", new int[] {1, 1, 4}));
			
			rTD.addTalent(new Basictalent(7, 170, "Kochen", new int[] {1, 2, 4}));
			rTD.addTalent(new Basictalent(7, 171, "Kristallzucht", new int[] {1, 2, 4}));
			rTD.addTalent(new Basictalent(7, 172, "Lederarbeiten", new int[] {1, 4, 4}));
			rTD.addTalent(new Basictalent(7, 173, "Malen/Zeichnen", new int[] {1, 2, 4}));
			rTD.addTalent(new Basictalent(7, 174, "Maurer", new int[] {4, 5, 7}));
			
			rTD.addTalent(new Basictalent(7, 175, "Metallguss", new int[] {1, 4, 7}));
			rTD.addTalent(new Basictalent(7, 176, "Musizieren", new int[] {1, 3, 4}));
			rTD.addTalent(new Basictalent(7, 177, "Schlösser knacken", new int[] {2, 4, 4}));
			rTD.addTalent(new Basictalent(7, 178, "Schnaps brennen", new int[] {1, 2, 4}));
			rTD.addTalent(new Basictalent(7, 179, "Schneidern", new int[] {1, 4, 4}));
			
			rTD.addTalent(new Basictalent(7, 180, "Seefahrt", new int[] {4, 5, 7}));
			rTD.addTalent(new Basictalent(7, 181, "Seiler", new int[] {4, 4, 7}));
			rTD.addTalent(new Basictalent(7, 182, "Steinmetz", new int[] {4, 4, 7}));
			rTD.addTalent(new Basictalent(7, 183, "Steinschneider/Juwelier", new int[] {2, 4, 4}));
			rTD.addTalent(new Basictalent(7, 184, "Stellmacher", new int[] {1, 4, 7}));
			
			rTD.addTalent(new Basictalent(7, 185, "Stoffe färben", new int[] {1, 4, 7}));
			rTD.addTalent(new Basictalent(7, 186, "Tätowieren", new int[] {2, 4, 4}));
			rTD.addTalent(new Basictalent(7, 187, "Töpfern", new int[] {1, 4, 4}));
			rTD.addTalent(new Basictalent(7, 188, "Viehzucht", new int[] {1, 2, 7}));
			rTD.addTalent(new Basictalent(7, 189, "Webkunst", new int[] {4, 4, 7}));
			
			rTD.addTalent(new Basictalent(7, 190, "Winzer", new int[] {1, 4, 7}));
			rTD.addTalent(new Basictalent(7, 191, "Zimmermann", new int[] {1, 4, 7}));
		} catch (Exception ex) {
			System.out.println(""+ex.getMessage());
			throw ex;}
	}
	/**	Dh	10.6.2020
	 * 
	 * @throws Exception
	 */
	private static void genBasicTalents() throws Exception{
		int[] vBasicTalentIDs;
		if (rTD != null) {
			vBasicTalentIDs = new int[31];
			
			// Kampftalente
			vBasicTalentIDs[0] = rTD.getTalent("Dolche").getId();
			vBasicTalentIDs[1] = rTD.getTalent("Hiebwaffen").getId();
			vBasicTalentIDs[2] = rTD.getTalent("Raufen").getId();
			vBasicTalentIDs[3] = rTD.getTalent("Ringen").getId();
			vBasicTalentIDs[4] = rTD.getTalent("Säbel").getId();
			vBasicTalentIDs[5] = rTD.getTalent("Wurfmesser").getId();
			
			// Körperliche Talente
			vBasicTalentIDs[6] = rTD.getTalent("Athletik").getId();
			vBasicTalentIDs[7] = rTD.getTalent("Klettern").getId();
			vBasicTalentIDs[8] = rTD.getTalent("Körperbeherrschung").getId();
			vBasicTalentIDs[9] = rTD.getTalent("Schleichen").getId();
			vBasicTalentIDs[10] = rTD.getTalent("Schwimmen").getId();
			vBasicTalentIDs[11] = rTD.getTalent("Selbstbeherrschung").getId();
			vBasicTalentIDs[12] = rTD.getTalent("Sich Verstecken").getId();
			vBasicTalentIDs[13] = rTD.getTalent("Singen").getId();
			vBasicTalentIDs[14] = rTD.getTalent("Sinnenschärfe").getId();
			vBasicTalentIDs[15] = rTD.getTalent("Tanzen").getId();
			vBasicTalentIDs[16] = rTD.getTalent("Zechen").getId();
			
			// Gesellschaftliche Talente
			vBasicTalentIDs[17] = rTD.getTalent("Menschenkenntnis").getId();
			vBasicTalentIDs[18] = rTD.getTalent("Überreden").getId();
			
			// Natur Talente
			vBasicTalentIDs[19] = rTD.getTalent("Fährtensuchen").getId();
			vBasicTalentIDs[20] = rTD.getTalent("Orientierung").getId();
			vBasicTalentIDs[21] = rTD.getTalent("Wildnisleben").getId();
			
			// Wissenstalente
			vBasicTalentIDs[22] = rTD.getTalent("Götter/Kulte").getId();
			vBasicTalentIDs[23] = rTD.getTalent("Rechnen").getId();
			vBasicTalentIDs[24] = rTD.getTalent("Sagen/Legenden").getId();
			
			// Handwerkliche Talente
			vBasicTalentIDs[25] = rTD.getTalent("Heilkunde Wunden").getId();
			vBasicTalentIDs[26] = rTD.getTalent("Holzbearbeitung").getId();
			vBasicTalentIDs[27] = rTD.getTalent("Kochen").getId();
			vBasicTalentIDs[28] = rTD.getTalent("Lederarbeiten").getId();
			vBasicTalentIDs[29] = rTD.getTalent("Malen/Zeichnen").getId();
			vBasicTalentIDs[30] = rTD.getTalent("Schneidern").getId();
			
			rTD.setBasicTalents(vBasicTalentIDs);
		}else throw new Exception("04; Loa,gBT");
	}
	/**	Dh	12.7.2020
	 * 
	 * 	Types:
	 * 	  00: Nahkampf				05: Wissens
	 * 	  01: Fernkampf				06: Sprache
	 * 	  02: Koerperliche			07: Handwerks
	 * 	  03: Gesellschaftliche		08: Alle Kampf
	 * 	  04: Natur					09: Alle mundan nicht Kampf
	 * 
	 * @throws Exception
	 */
	private static void genTalentTypes() throws Exception{
		String[] vTalentTypes;
		
		if (rTD != null) {
			vTalentTypes = new String[10];
			
			vTalentTypes[0] = "Nahmkampf";
			vTalentTypes[1] = "Fernkampf";
			vTalentTypes[2] = "Körperliche";
			vTalentTypes[3] = "Gesellschaftliche";
			vTalentTypes[4] = "Natur";
			
			vTalentTypes[5] = "Wissens";
			vTalentTypes[6] = "Sprache";
			vTalentTypes[7] = "Handwerk";
			vTalentTypes[8] = "Alle Kampf";
			vTalentTypes[9] = "Alle Normalen";
			
			rTD.setTalentTypes(vTalentTypes);
		}
	}
	/**	Dh	9.7.2020
	 * 
	 * @throws Exception
	 */
	private static void genWeapons() throws Exception {
		rWD = new WeaponDatabase();
		
		try {
			rWD.addWeapon(new CloseWeapon(0, "Fausthieb", 0, new int[] {1, 0}, new int[] {10, 3}, new int[] {-1, -2}, -10, -2, 1));
			rWD.addWeapon(new CloseWeapon(1, "Tritt", 0, new int[] {1, 0}, new int[] {10, 3}, new int[] {-1, -2}, -10, -1, 1));
			
			// Anderthalbhaender
			rWD.addWeapon(new CloseWeapon(2, "Anderthalbhänder", 2, new int[] {1, 5}, new int[] {11, 4}, new int[] {0, 0}, 1, 1, 5));
			rWD.addWeapon(new CloseWeapon(3, "Bastardschwert", 2, new int[] {1, 5}, new int[] {11, 3}, new int[] {0, -1}, 2, 0, 1));
			rWD.addWeapon(new CloseWeapon(4, "Nachtwind", 2, new int[] {1, 4}, new int[] {11, 5}, new int[] {0, 0}, 0, 2, 1));
			rWD.addWeapon(new CloseWeapon(5, "Rondrakamm", 2, new int[] {2, 2}, new int[] {12, 3}, new int[] {0, 0}, 1, 0, 5));
			rWD.addWeapon(new CloseWeapon(6, "Tuzakmesser", 2, new int[] {1, 6}, new int[] {12, 4}, new int[] {0, 0}, 1, 1, 5));
			
			// Dolche
			rWD.addWeapon(new CloseWeapon(7, "Basiliskenzunge", 3, new int[] {1, 2}, new int[] {12, 4}, new int[] {0, -1}, 4, -1, 0));
			rWD.addWeapon(new CloseWeapon(8, "Borndolch", 3, new int[] {1, 2}, new int[] {12, 5}, new int[] {0, -1}, 1, 0, 0));
			rWD.addWeapon(new CloseWeapon(9, "Dolch", 3, new int[] {1, 1}, new int[] {12, 5}, new int[] {0, -1}, 2, 0, 0));
			rWD.addWeapon(new CloseWeapon(10, "Drachenzahn", 3, new int[] {1, 2}, new int[] {12, 4}, new int[] {0, 0}, 0, 0, 0));
			rWD.addWeapon(new CloseWeapon(11, "Eberfänger", 3, new int[] {1, 2}, new int[] {12, 4}, new int[] {0, -1}, 1, 0, 0));
			rWD.addWeapon(new CloseWeapon(12, "Hakendolch", 3, new int[] {1, 1}, new int[] {12, 4}, new int[] {0, 1}, -2, 0, 4));
			rWD.addWeapon(new CloseWeapon(13, "Jagdmesser", 3, new int[] {1, 2}, new int[] {12, 5}, new int[] {0, -2}, 3, -1, 0));
			rWD.addWeapon(new CloseWeapon(14, "Kurzschwert", 3, new int[] {1, 2}, new int[] {12, 4}, new int[] {0, -1}, 1, 0, 4));
			rWD.addWeapon(new CloseWeapon(15, "Langdolch", 3, new int[] {1, 2}, new int[] {12, 4}, new int[] {0, 0}, 1, 0, 0));
			rWD.addWeapon(new CloseWeapon(16, "Linkhand", 3, new int[] {1, 1}, new int[] {12, 5}, new int[] {0, 1}, 0, 0, 0));
			
			rWD.addWeapon(new CloseWeapon(17, "Mengbilar", 3, new int[] {1, 1}, new int[] {12, 5}, new int[] {0, -3}, 7, -2, 0));
			rWD.addWeapon(new CloseWeapon(18, "Messer", 3, new int[] {1, 0}, new int[] {12, 6}, new int[] {-2, -3}, 4, -2, 0));
			rWD.addWeapon(new CloseWeapon(19, "Ogerfänger", 3, new int[] {1, 2}, new int[] {12, 4}, new int[] {0, -2}, 4, 0, 0));
			rWD.addWeapon(new CloseWeapon(20, "Scheibendolch", 3, new int[] {1, 2}, new int[] {12, 4}, new int[] {0, -3}, 0, 0, 0));
			rWD.addWeapon(new CloseWeapon(21, "Schwerer Dolch", 3, new int[] {1, 2}, new int[] {12, 4}, new int[] {0, -1}, 1, 0, 0));
			rWD.addWeapon(new CloseWeapon(22, "Vulkangalsdolch", 3, new int[] {1, -1}, new int[] {12, 5}, new int[] {-2, -3}, 6, -2, 0));
			rWD.addWeapon(new CloseWeapon(23, "Waqqif", 3, new int[] {1, 2}, new int[] {12, 5}, new int[] {-1, -3}, 2, -2, 0));
			rWD.addWeapon(new CloseWeapon(24, "Wurfdolch", 3, new int[] {1, 1}, new int[] {12, 5}, new int[] {-1, -2}, 2, -1, 0));
			rWD.addWeapon(new CloseWeapon(25, "Wurfmesser", 3, new int[] {1, -1}, new int[] {12, 6}, new int[] {-2, -3}, 2, -1, 0));
			
			//Fechtwaffen
			rWD.addWeapon(new CloseWeapon(26, "Degen", 4, new int[] {1, 3}, new int[] {12, 5}, new int[] {0, -1}, 3, 2, 1));
			rWD.addWeapon(new CloseWeapon(27, "Florett", 4, new int[] {1, 3}, new int[] {13, 5}, new int[] {1, -1}, 4, 3, 1));
			rWD.addWeapon(new CloseWeapon(28, "Langdolch", 4, new int[] {1, 2}, new int[] {12, 4}, new int[] {0, 0}, 1, 0, 0));
			rWD.addWeapon(new CloseWeapon(29, "Magierdegen", 4, new int[] {1, 2}, new int[] {13, 5}, new int[] {0, -2}, 4, 1, 1));
			rWD.addWeapon(new CloseWeapon(30, "Panzerstecher", 4, new int[] {1, 4}, new int[] {13, 3}, new int[] {-1, -1}, 0, 0, 1));
			rWD.addWeapon(new CloseWeapon(31, "Rapier", 4, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 2, 1, 1));
			rWD.addWeapon(new CloseWeapon(32, "Robbentöter", 4, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 2, 0, 1));
			rWD.addWeapon(new CloseWeapon(33, "Stockdegen", 4, new int[] {1, 3}, new int[] {12, 5}, new int[] {-1, -3}, 4, 0, 1));
			rWD.addWeapon(new CloseWeapon(34, "Woldmesser", 4, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 1, 1, 1));
			
			// Hiebwaffen
			rWD.addWeapon(new CloseWeapon(35, "Baccanaq", 5, new int[] {1, 4}, new int[] {12, 4}, new int[] {0, -2}, 5, -1, 1));
			rWD.addWeapon(new CloseWeapon(36, "Beil", 5, new int[] {1, 3}, new int[] {11, 4}, new int[] {-1, -2}, 5, -1, 1));
			rWD.addWeapon(new CloseWeapon(37, "Brabakbengel", 5, new int[] {1, 5}, new int[] {13, 3}, new int[] {0, -1}, 1, 0, 1));
			rWD.addWeapon(new CloseWeapon(38, "Byakka", 5, new int[] {1, 5}, new int[] {14, 2}, new int[] {0, -2}, 3, -1, 1));
			rWD.addWeapon(new CloseWeapon(39, "Fackel", 5, new int[] {1, 0}, new int[] {11, 5}, new int[] {-2, -3}, 8, -2, 4));
			rWD.addWeapon(new CloseWeapon(40, "Fleischerbeil", 5, new int[] {1, 2}, new int[] {11, 4}, new int[] {-2, -3}, 2, -1, 0));
			rWD.addWeapon(new CloseWeapon(41, "Haumesser", 5, new int[] {1, 3}, new int[] {13, 3}, new int[] {0, -2}, 3, -1, 4));
			rWD.addWeapon(new CloseWeapon(42, "Keule", 5, new int[] {1, 2}, new int[] {11, 3}, new int[] {0, -2}, 3, 0, 1));
			rWD.addWeapon(new CloseWeapon(43, "Knochenkeule", 5, new int[] {1, 3}, new int[] {11, 3}, new int[] {0, -1}, 3, 0, 1));
			rWD.addWeapon(new CloseWeapon(44, "Knüppel", 5, new int[] {1, 1}, new int[] {11, 4}, new int[] {0, -2}, 6, 0, 1));
			
			rWD.addWeapon(new CloseWeapon(45, "Kriegsfächer", 5, new int[] {1, 2}, new int[] {12, 5}, new int[] {0, 1}, 3, 0, 0));
			rWD.addWeapon(new CloseWeapon(46, "Lindwurmschläger", 5, new int[] {1, 4}, new int[] {11, 3}, new int[] {0, -1}, 1, -1, 4));
			rWD.addWeapon(new CloseWeapon(47, "Molokdeschnaja", 5, new int[] {1, 4}, new int[] {11, 3}, new int[] {0, 0}, 3, 0, 1));
			rWD.addWeapon(new CloseWeapon(48, "Orknse", 5, new int[] {1, 5}, new int[] {13, 3}, new int[] {0, -1}, 4, -1, 1));
			rWD.addWeapon(new CloseWeapon(49, "Rabenschnabel", 5, new int[] {1, 4}, new int[] {10, 4}, new int[] {0, 0}, 3, 0, 1));
			rWD.addWeapon(new CloseWeapon(50, "Schmiedehammer", 5, new int[] {1, 4}, new int[] {14, 2}, new int[] {-1, -1}, 1, -1, 1));
			rWD.addWeapon(new CloseWeapon(51, "Sichel", 5, new int[] {1, 2}, new int[] {12, 5}, new int[] {-2, -2}, 6, -2, 0));
			rWD.addWeapon(new CloseWeapon(52, "Skraja", 5, new int[] {1, 3}, new int[] {11, 3}, new int[] {0, 0}, 4, 0, 1));
			rWD.addWeapon(new CloseWeapon(53, "Sonnenzepter", 5, new int[] {1, 3}, new int[] {12, 3}, new int[] {-1, -1}, 1, 0, 1));
			rWD.addWeapon(new CloseWeapon(54, "Streitaxt", 5, new int[] {1, 4}, new int[] {13, 2}, new int[] {0, -1}, 2, 0, 1));
			
			rWD.addWeapon(new CloseWeapon(55, "Streitkolben", 5, new int[] {1, 4}, new int[] {11, 3}, new int[] {0, -1}, 1, 0, 1));
			rWD.addWeapon(new CloseWeapon(56, "Stuhlbein", 5, new int[] {1, 0}, new int[] {11, 5}, new int[] {-1, -1}, 8, -1, 4));
			rWD.addWeapon(new CloseWeapon(57, "Wurfbeil", 5, new int[] {1, 3}, new int[] {10, 4}, new int[] {0, -2}, 2, -1, 0));
			rWD.addWeapon(new CloseWeapon(58, "Wurfkeule", 5, new int[] {1, 2}, new int[] {12, 5}, new int[] {-1, -1}, 3, -1, 0));
			rWD.addWeapon(new CloseWeapon(59, "Zwergenskraja", 5, new int[] {1, 3}, new int[] {11, 3}, new int[] {0, 0}, 1, 0, 4));
			
			// Infanteriewaffen
			rWD.addWeapon(new CloseWeapon(60, "Glefe", 6, new int[] {1, 4}, new int[] {13, 3}, new int[] {0, -2}, 5, -1, 2));
			rWD.addWeapon(new CloseWeapon(61, "Hakenspieß", 6, new int[] {1, 3}, new int[] {13, 4}, new int[] {-1, -1}, 5, 0, 2));
			rWD.addWeapon(new CloseWeapon(62, "Hellebarde", 6, new int[] {1, 5}, new int[] {12, 3}, new int[] {0, -1}, 5, 0, 2));
			rWD.addWeapon(new CloseWeapon(63, "Korspieß", 6, new int[] {1, 2}, new int[] {12, 3}, new int[] {0, -1}, 3, 0, 2));
			rWD.addWeapon(new CloseWeapon(64, "Neethaner Langaxt", 6, new int[] {1, 2}, new int[] {13, 4}, new int[] {-1, -3}, 5, -2, 2));
			rWD.addWeapon(new CloseWeapon(65, "Pailos", 6, new int[] {1, 4}, new int[] {14, 2}, new int[] {-1, -3}, 3, -2, 2));
			rWD.addWeapon(new CloseWeapon(66, "Partisane", 6, new int[] {1, 5}, new int[] {13, 3}, new int[] {0, -2}, 4, 0, 2));
			rWD.addWeapon(new CloseWeapon(67, "Schnitter", 6, new int[] {1, 5}, new int[] {14, 4}, new int[] {0, 0}, 4, 0, 5));
			rWD.addWeapon(new CloseWeapon(68, "Sense", 6, new int[] {1, 3}, new int[] {13, 4}, new int[] {-2, -4}, 7, -2, 2));
			rWD.addWeapon(new CloseWeapon(69, "Sturmsense", 6, new int[] {1, 4}, new int[] {13, 3}, new int[] {-1, -2}, 5, -1, 2));
			
			rWD.addWeapon(new CloseWeapon(70, "Warunker Hammer", 6, new int[] {1, 6}, new int[] {14, 3}, new int[] {0, -1}, 2, -1, 5));
			rWD.addWeapon(new CloseWeapon(71, "Wurmspieß", 6, new int[] {1, 5}, new int[] {13, 4}, new int[] {0, -2}, 2, 0, 2));
	
			// Kettenstaebe
			rWD.addWeapon(new CloseWeapon(72, "Dreigliederstab", 7, new int[] {1, 2}, new int[] {13, 4}, new int[] {1, 1}, 3, 2, 4));
			rWD.addWeapon(new CloseWeapon(73, "Kettenstab", 7, new int[] {1, 2}, new int[] {13, 4}, new int[] {1, 0}, 2, 2, 4));
			
			// Kettenwaffen
			rWD.addWeapon(new CloseWeapon(74, "Geißel", 8, new int[] {1, -1}, new int[] {14, 5}, new int[] {0, -4}, 5, -1, 1));
			rWD.addWeapon(new CloseWeapon(75, "Kettenkugel", 8, new int[] {3, 0}, new int[] {14, 5}, new int[] {-2, -4}, 2, -3, 2));
			rWD.addWeapon(new CloseWeapon(76, "Morgenstern", 8, new int[] {1, 5}, new int[] {14, 5}, new int[] {-1, -2}, 2, -1, 1));
			rWD.addWeapon(new CloseWeapon(77, "Neunschwänzige", 8, new int[] {1, 1}, new int[] {14, 5}, new int[] {-1, -4}, 5, -1, 1));
			rWD.addWeapon(new CloseWeapon(78, "Ochsenherde", 8, new int[] {3, 3}, new int[] {14, 5}, new int[] {-2, -4}, 3, -3, 1));
			rWD.addWeapon(new CloseWeapon(79, "Ogerschelle", 8, new int[] {2, 2}, new int[] {14, 5}, new int[] {-1, -3}, 3, -2, 1));
			
			// Peitsche
			rWD.addWeapon(new CloseWeapon(80, "Peitsche", 9, new int[] {1, 0}, new int[] {14, 5}, new int[] {0, -20}, 4, 0, 2));
			
			// Saebel
			rWD.addWeapon(new CloseWeapon(81, "Amazonensäbel", 10, new int[] {1, 4}, new int[] {11, 4}, new int[] {0, 0}, 2, 1, 1));
			rWD.addWeapon(new CloseWeapon(82, "Arbach", 10, new int[] {1, 4}, new int[] {12, 2}, new int[] {0, -2}, 2, 0, 1));
			rWD.addWeapon(new CloseWeapon(83, "Entermesser", 10, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 2, 0, 1));
			rWD.addWeapon(new CloseWeapon(84, "Haumesser", 10, new int[] {1, 3}, new int[] {13, 3}, new int[] {0, -2}, 3, -1, 4));
			rWD.addWeapon(new CloseWeapon(85, "Khunchomer", 10, new int[] {1, 4}, new int[] {12, 3}, new int[] {0, 0}, 2, 0, 1));
			rWD.addWeapon(new CloseWeapon(86, "Kurzschwert", 10, new int[] {1, 2}, new int[] {11, 4}, new int[] {0, -1}, 1, 0, 4));
			rWD.addWeapon(new CloseWeapon(87, "Kusliker Säbel", 10, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 1, 1, 1));
			rWD.addWeapon(new CloseWeapon(88, "Robbentöter", 10, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 2, 0, 1));
			rWD.addWeapon(new CloseWeapon(89, "Säbel", 10, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 2, 1, 1));
			rWD.addWeapon(new CloseWeapon(90, "Sklaventod", 10, new int[] {1, 4}, new int[] {12, 3}, new int[] {0, 0}, 3, 0, 1));
			
			rWD.addWeapon(new CloseWeapon(91, "Waqqif", 10, new int[] {1, 2}, new int[] {12, 5}, new int[] {-1, -3}, 2, -2, 0));
			rWD.addWeapon(new CloseWeapon(92, "Wolfsmesser", 10, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 1, 1, 1));
			
			// Schwerter
			rWD.addWeapon(new CloseWeapon(93, "Amazonensäbel", 11, new int[] {1, 4}, new int[] {11, 4}, new int[] {0, 0}, 2, 1, 1));
			rWD.addWeapon(new CloseWeapon(94, "Arbach", 11, new int[] {1, 4}, new int[] {12, 3}, new int[] {0, -1}, 2, 0, 1));
			rWD.addWeapon(new CloseWeapon(95, "Barbarenschwert", 11, new int[] {1, 5}, new int[] {13, 2}, new int[] {0, -1}, 4, -1, 1));
			rWD.addWeapon(new CloseWeapon(96, "Bastardschwert", 11, new int[] {1, 5}, new int[] {12, 4}, new int[] {0, -1}, 2, -1, 1));
			rWD.addWeapon(new CloseWeapon(97, "Breitschwert", 11, new int[] {1, 4}, new int[] {12, 3}, new int[] {0, -1}, 1, 0, 1));
			rWD.addWeapon(new CloseWeapon(98, "Kurzschwert", 11, new int[] {1, 2}, new int[] {11, 4}, new int[] {0, -1}, 1, 0, 4));
			rWD.addWeapon(new CloseWeapon(99, "Kusliker Säbel", 11, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 1, 1, 1));
			rWD.addWeapon(new CloseWeapon(100, "Nachtwind", 11, new int[] {1, 4}, new int[] {11, 5}, new int[] {0, 0}, 0, 2, 1));
			rWD.addWeapon(new CloseWeapon(101, "Rapier", 11, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 2, 1, 1));
			rWD.addWeapon(new CloseWeapon(102, "Robbentöter", 11, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 2, 0, 1));
			
			rWD.addWeapon(new CloseWeapon(103, "Säbel", 11, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 2, 1, 1));
			rWD.addWeapon(new CloseWeapon(104, "Schwert", 11, new int[] {1, 4}, new int[] {11, 4}, new int[] {0, 0}, 1, 0, 1));
			rWD.addWeapon(new CloseWeapon(105, "Turnierschwert", 11, new int[] {1, 3}, new int[] {11, 5}, 1, new int[] {0, 0}, 3, 0, 1));
			rWD.addWeapon(new CloseWeapon(106, "Wolfsmesser", 11, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 1, 1, 1));
			
			// Speere
			rWD.addWeapon(new CloseWeapon(107, "Drachentöter", 12, new int[] {3, 5}, new int[] {20, 1}, new int[] {-2, -4}, 3, -3, 3));
			rWD.addWeapon(new CloseWeapon(108, "Dreizack", 12, new int[] {1, 4}, new int[] {13, 3}, new int[] {0, -1}, 5, 0, 2));
			rWD.addWeapon(new CloseWeapon(109, "Dschadra", 12, new int[] {1, 5}, new int[] {12, 4}, new int[] {0, -3}, 6, -1, 2));
			rWD.addWeapon(new CloseWeapon(110, "Efferdbart", 12, new int[] {1, 4}, new int[] {13, 3}, new int[] {0, -1}, 3, 0, 5));
			rWD.addWeapon(new CloseWeapon(111, "Holzspeer", 12, new int[] {1, 3}, new int[] {12, 5}, new int[] {-1, -3}, 5, 0, 2));
			rWD.addWeapon(new CloseWeapon(112, "Jagdspieß", 12, new int[] {1, 6}, new int[] {12, 4}, new int[] {0, -1}, 3, -1, 2));
			rWD.addWeapon(new CloseWeapon(113, "Korspieß", 12, new int[] {2, 2}, new int[] {12, 3}, new int[] {0, -1}, 3, 0, 2));
			rWD.addWeapon(new CloseWeapon(114, "Kriegslanze", 12, new int[] {1, 3}, new int[] {12, 5}, new int[] {-2, -4}, 5, -2, 3));
			rWD.addWeapon(new CloseWeapon(115, "Partisane", 12, new int[] {1, 5}, new int[] {13, 3}, new int[] {0, -2}, 4, 0, 2));
			rWD.addWeapon(new CloseWeapon(116, "Pike", 12, new int[] {1, 5}, new int[] {14, 4}, new int[] {-1, -2}, 6, -2, 3));
			
			rWD.addWeapon(new CloseWeapon(117, "Schnitter", 12, new int[] {1, 5}, new int[] {14, 4}, new int[] {0, 0}, 4, 0, 5));
			rWD.addWeapon(new CloseWeapon(118, "Speer", 12, new int[] {1, 5}, new int[] {12, 4}, new int[] {0, -2}, 5, -1, 2));
			rWD.addWeapon(new CloseWeapon(119, "Stoßspeer", 12, new int[] {2, 2}, new int[] {11, 4}, new int[] {0, -1}, 3, -1, 2));
			rWD.addWeapon(new CloseWeapon(120, "Turnierlanze", 12, new int[] {1, 2}, new int[] {12, 5}, 1, new int[] {-2, -4}, 8, -2, 3));
			rWD.addWeapon(new CloseWeapon(121, "Wurfspeer", 12, new int[] {1, 3}, new int[] {11, 5}, new int[] {-1, -3}, 4, -2, 1));
			rWD.addWeapon(new CloseWeapon(122, "Wurmspieß", 12, new int[] {1, 5}, new int[] {13, 4}, new int[] {0, -2}, 2, 0, 2));
			
			// Stäbe
			rWD.addWeapon(new CloseWeapon(123, "Kampfstab", 13, new int[] {1, 1}, new int[] {12, 4}, new int[] {0, 0}, 5, 1, 5));
			rWD.addWeapon(new CloseWeapon(124, "Magierstab", 13, new int[] {1, 1}, new int[] {11, 5}, 2, new int[] {-1, -1}, -10, 0, 5));
			rWD.addWeapon(new CloseWeapon(125, "Zweililien", 13, new int[] {1, 3}, new int[] {12, 4}, new int[] {1, -1}, 4, 1, 1));
			
			// Zweihandflegel
			rWD.addWeapon(new CloseWeapon(126, "Dreschflegel", 14, new int[] {1, 3}, new int[] {12, 3}, new int[] {-2, -3}, 6, -2, 2));
			rWD.addWeapon(new CloseWeapon(127, "Kriegsflegel", 14, new int[] {1, 6}, new int[] {12, 2}, new int[] {-1, -2}, 5, -1, 2));
			
			// Zweihand-Hiebwaffen
			rWD.addWeapon(new CloseWeapon(128, "Barbarenstreitaxt", 15, new int[] {3, 2}, new int[] {15, 1}, new int[] {-1, -4}, 3, -2, 1));
			rWD.addWeapon(new CloseWeapon(129, "Echsische Axt", 15, new int[] {1, 5}, new int[] {12, 4}, new int[] {0, -1}, 3, 0, 5));
			rWD.addWeapon(new CloseWeapon(130, "Felsspalter", 15, new int[] {2, 2}, new int[] {14, 2}, new int[] {0, -2}, 2, -1, 1));
			rWD.addWeapon(new CloseWeapon(131, "Gruufhai", 15, new int[] {1, 6}, new int[] {14, 2}, new int[] {-1, -3}, 3, -2, 1));
			rWD.addWeapon(new CloseWeapon(132, "Holzfälleraxt", 15, new int[] {2, 0}, new int[] {12, 2}, new int[] {-1, -4}, 5, -2, 1));
			rWD.addWeapon(new CloseWeapon(133, "Kriegshammer", 15, new int[] {2, 3}, new int[] {14, 2}, new int[] {-1, -3}, 2, -2, 1));
			rWD.addWeapon(new CloseWeapon(134, "Neethaner Langaxt", 15, new int[] {2, 2}, new int[] {13, 4}, new int[] {-1, -3}, 5, -2, 2));
			rWD.addWeapon(new CloseWeapon(135, "Orknase", 15, new int[] {1, 5}, new int[] {12, 2}, new int[] {0, -1}, 4, -1, 1));
			rWD.addWeapon(new CloseWeapon(136, "Pailos", 15, new int[] {2, 4}, new int[] {14, 2}, new int[] {-1, -3}, 3, -2, 2));
			rWD.addWeapon(new CloseWeapon(137, "Schnitter", 15, new int[] {1, 5}, new int[] {14, 4}, new int[] {0, 0}, 4, 0, 5));
			
			rWD.addWeapon(new CloseWeapon(138, "Spitzhacke", 15, new int[] {1, 6}, new int[] {13, 2}, new int[] {-2, -4}, 5, -3, 1));
			rWD.addWeapon(new CloseWeapon(139, "Vorschlaghammer", 15, new int[] {1, 5}, new int[] {13, 2}, new int[] {-2, -4}, 5, -3, 1));
			rWD.addWeapon(new CloseWeapon(140, "Warunker Hammer", 15, new int[] {1, 6}, new int[] {14, 3}, new int[] {0, -1}, 2, -1, 5));
			rWD.addWeapon(new CloseWeapon(141, "Zwergenschlägel", 15, new int[] {1, 5}, new int[] {13, 3}, new int[] {0, -1}, 1, -1, 1));
			
			// Zweihandschwerter
			rWD.addWeapon(new CloseWeapon(142, "Andergaster", 16, new int[] {3, 2}, new int[] {14, 2}, new int[] {0, -2}, 3, -3, 2));
			rWD.addWeapon(new CloseWeapon(143, "Anderthalbhänder", 16, new int[] {1, 5}, new int[] {11, 4}, new int[] {0, 0}, 1, 1, 5));
			rWD.addWeapon(new CloseWeapon(144, "Boronssichel", 16, new int[] {2, 6}, new int[] {13, 3}, new int[] {0, -3}, 3, -2, 2));
			rWD.addWeapon(new CloseWeapon(145, "Doppelkhunchomer", 16, new int[] {1, 6}, new int[] {12, 2}, new int[] {0, -1}, 2, -1, 5));
			rWD.addWeapon(new CloseWeapon(146, "Großer Sklaventod", 16, new int[] {2, 4}, new int[] {13, 2}, new int[] {0, -2}, 3, -2, 5));
			rWD.addWeapon(new CloseWeapon(147, "Richtschwert", 16, new int[] {3, 4}, new int[] {13, 2}, new int[] {-2, -4}, 5, -3, 1));
			rWD.addWeapon(new CloseWeapon(148, "Rondrakamm", 16, new int[] {2, 2}, new int[] {12, 3}, new int[] {0, 0}, 1, 0, 5));
			rWD.addWeapon(new CloseWeapon(149, "Tuzakmesser", 16, new int[] {1, 6}, new int[] {12, 4}, new int[] {0, 0}, 1, 1, 5));
			rWD.addWeapon(new CloseWeapon(150, "Zweihänder", 16, new int[] {2, 4}, new int[] {12, 3}, new int[] {0, -1}, 2, -1, 5));
			
			// Improvisiert
			rWD.addWeapon(new RangeWeapon(151, "Stein", 17, new int[]{1, 0}, new int[] {1, 2, 4, 8, 12}, new int[] {0,0,0,-1,-1}));
			
			// Armbrust
			rWD.addWeapon(new RangeWeapon(169, "Arablette", 18, new int[]{2, 5}, new int[] {10, 20, 30, 60, 100}, new int[] {2,1,0,-1,-2}, 30));
			rWD.addWeapon(new RangeWeapon(170, "Arbalone", 18, new int[]{3, 6}, new int[] {15, 30, 60, 12, 250}, new int[] {4,2,0,-1,-3}, 40));
			rWD.addWeapon(new RangeWeapon(171, "Balestra", 18, new int[]{2, 2}, new int[] {10, 20, 30, 50, 60}, new int[] {2,1,0,0,-1}, 12));
			rWD.addWeapon(new RangeWeapon(172, "Balestrina", 18, new int[]{1, 4}, new int[] {2, 4, 8, 15, 25}, new int[] {2,1,0,0,-1}, 4));
			rWD.addWeapon(new RangeWeapon(173, "Balläster", 18, new int[]{1, 4}, new int[] {10, 20, 30, 60, 100}, new int[] {3,1,0,-1,-1}, 8));
			rWD.addWeapon(new RangeWeapon(174, "Eisenwalder", 18, new int[]{1, 3}, new int[] {5, 10, 15, 20, 40}, new int[] {1,0,0,0,-1}, 3));
			rWD.addWeapon(new RangeWeapon(175, "Leichter Armbrust", 18, new int[]{1, 6}, new int[] {10, 15, 25, 40, 60}, new int[] {1,1,0,0,-1}, 15));
			rWD.addWeapon(new RangeWeapon(176, "Windenarmbrust", 18, new int[]{2, 6}, new int[] {10, 30, 60, 100, 180}, new int[] {4,2,0,-1,-3}, 30));
			
			// Blasrohr
			rWD.addWeapon(new RangeWeapon(152, "Blasrohr", 19, new int[]{1, -1}, new int[] {2, 5, 10, 20, 40}, new int[] {0,0,0,0,-2}, 2));
			
			// Bogen
			rWD.addWeapon(new RangeWeapon(177, "Elfenbogen", 20, new int[]{1, 5}, new int[] {10, 25, 50, 100, 200}, new int[] {3,2,1,1,0}, 3));
			rWD.addWeapon(new RangeWeapon(178, "Kompositbogen", 20, new int[]{1, 5}, new int[] {10, 20, 35, 50, 80}, new int[] {2,1,1,0,0}, 3));
			rWD.addWeapon(new RangeWeapon(179, "Kriegsbogen", 20, new int[]{1, 7}, new int[] {10, 20, 40, 80, 150}, new int[] {3,2,1,0,0}, 4));
			rWD.addWeapon(new RangeWeapon(180, "Kurzbogen", 20, new int[]{1, 4}, new int[] {5, 15, 25, 40, 60}, new int[] {1,1,0,0,-1}, 2));
			rWD.addWeapon(new RangeWeapon(181, "Langbogen", 20, new int[]{1, 6}, new int[] {10, 25, 50, 100, 200}, new int[] {3,2,1,0,-1}, 4));
			rWD.addWeapon(new RangeWeapon(182, "Ork. Reitbogen", 20, new int[]{1, 5}, new int[] {5, 15, 30, 60, 100}, new int[] {3,1,0,-1,-2}, 3));
			
			// Diskus
			rWD.addWeapon(new RangeWeapon(190, "Diskus", 21, new int[]{1, 3}, new int[] {5, 10, 20, 30, 60}, new int[] {1,0,0,0,-1}));
			rWD.addWeapon(new RangeWeapon(191, "Jagddiskus", 21, new int[]{2, 4}, 1, new int[] {5, 10, 20, 30, 60}, new int[] {1,0,0,0,-1}, 0));
			rWD.addWeapon(new RangeWeapon(192, "Kampfdiskus", 21, new int[]{1, 5}, new int[] {10, 20, 30, 45, 60}, new int[] {1,0,0,0,0}));
			
			// Schleuder
			rWD.addWeapon(new RangeWeapon(183, "Fledermaus", 22, new int[]{1, 2}, new int[] {0, 5, 10, 15, 25}, new int[] {0,0,0,0,-1}, 1));
			rWD.addWeapon(new RangeWeapon(184, "Granatapfel", 22, new int[]{4, 0}, new int[] {0, 5, 10, 15, 20}, new int[] {0,0,0,0,0}));
			rWD.addWeapon(new RangeWeapon(185, "Kettenkugel", 22, new int[]{2, 2}, new int[] {0, 2, 5, 8, 15}, new int[] {0,1,0,0,0}, 2));
			rWD.addWeapon(new RangeWeapon(186, "Lasso", 22, new int[]{1, 4}, new int[] {0, 2, 5, 10, 15}, new int[] {0,0,0,-1,-2}, 1));
			rWD.addWeapon(new RangeWeapon(187, "Schleuder", 22, new int[]{1, 2}, new int[] {0, 5, 15, 25, 40}, new int[] {0,0,0,0,0}, 2));
			rWD.addWeapon(new RangeWeapon(188, "Wurfnetz", 22, new int[]{1, 2}, new int[] {0, 0, 0, 5, 5}, new int[] {0,0,0,0,0}, 1));
			rWD.addWeapon(new RangeWeapon(189, "Schweres Wurfnetz", 22, new int[]{1, 6}, new int[] {0, 0, 0, 5, 5}, new int[] {0,0,0,0,0}, 1));
			
			// Wurfbeil
			rWD.addWeapon(new RangeWeapon(166, "Schneidzahn", 23, new int[]{1, 4}, new int[] {0, 5, 10, 15, 30}, new int[] {0,1,1,0,-1}));
			rWD.addWeapon(new RangeWeapon(167, "Wurfbeil", 23, new int[]{1, 3}, new int[] {0, 5, 10, 15, 25}, new int[] {0,1,1,0,-1}));
			rWD.addWeapon(new RangeWeapon(168, "Wurfkeule", 23, new int[]{2, 4}, 1, new int[] {0, 5, 15, 25, 40}, new int[] {0,1,1,1,0}, 0));
			
			// Wurfmesser
			rWD.addWeapon(new RangeWeapon(153, "Borndolch", 24, new int[]{1, 2}, new int[] {2, 4, 6, 8, 15}, new int[] {1,0,0,0,-1}));
			rWD.addWeapon(new RangeWeapon(154, "Dolch", 24, new int[]{1, 0}, new int[] {1, 3, 5, 7, 10}, new int[] {0,0,0,-1,-1}));
			rWD.addWeapon(new RangeWeapon(155, "Wurfdolch", 24, new int[]{1, 1}, new int[] {2, 4, 6, 8, 15}, new int[] {1,0,0,0,-1}));
			rWD.addWeapon(new RangeWeapon(156, "Wurfmesser", 24, new int[]{1, 0}, new int[] {2, 4, 6, 8, 15}, new int[] {1,0,0,0,-1}));
			rWD.addWeapon(new RangeWeapon(157, "Wurfscheibe", 24, new int[]{1, 1}, new int[] {2, 4, 8, 12, 20}, new int[] {1,0,0,0,0}));
			
			// Wurfspeer
			rWD.addWeapon(new RangeWeapon(158, "Dschadra", 25, new int[]{1, 4}, new int[] {5, 10, 15, 25, 40}, new int[] {3,2,1,0,0}));
			rWD.addWeapon(new RangeWeapon(159, "Efferdbart", 25, new int[]{1, 3}, new int[] {3, 6, 10, 15, 25}, new int[] {2,1,0,-1,-2}));
			rWD.addWeapon(new RangeWeapon(160, "Granarapfel", 25, new int[]{4, 0}, new int[] {0, 5, 10, 15, 20}, new int[] {0,0,0,0,0}));
			rWD.addWeapon(new RangeWeapon(161, "Holzspeer", 25, new int[]{1, 2}, new int[] {5, 10, 15, 25, 40}, new int[] {1,0,0,-1,-2}));
			rWD.addWeapon(new RangeWeapon(162, "Speer", 25, new int[]{1, 3}, new int[] {5, 10, 15, 25, 40}, new int[] {1,0,0,-1,-2}));
			rWD.addWeapon(new RangeWeapon(163, "Speerschleuder", 25, new int[]{1, 3}, new int[] {0, 15, 30, 60, 100}, new int[] {0,1,0,0,-1}, 2));
			rWD.addWeapon(new RangeWeapon(164, "Stabschleuder", 25, new int[]{1, 3}, new int[] {0, 5, 20, 40, 60}, new int[] {0,0,0,0,0}, 2));
			rWD.addWeapon(new RangeWeapon(165, "Wurfspeer", 25, new int[]{1, 4}, new int[] {5, 10, 15, 25, 40}, new int[] {3,1,0,-1,-1}));
			
			// kleine Schilde
			rWD.addWeapon(new DefenceWeapon(166, "Buckler", 26, new int[]{0, 1}, 0, 0));
			rWD.addWeapon(new DefenceWeapon(167, "Vollmetallbuckler", 26, new int[]{0, 2}, -2, 0));
			rWD.addWeapon(new DefenceWeapon(168, "Panzerarm", 26, new int[]{-2, 1}, -2, 0));
			rWD.addWeapon(new DefenceWeapon(169, "Drachenklaue", 26, new int[]{-2, 1}, 0, 0));
			rWD.addWeapon(new DefenceWeapon(170, "Bock", 26, new int[]{-1, 1}, 0, 0));
			
			// große Schilde
			rWD.addWeapon(new DefenceWeapon(171, "Einfacher Holzschild", 27, new int[]{-1, 3}, 3, -1));
			rWD.addWeapon(new DefenceWeapon(172, "Verstärkter Holzschild", 27, new int[]{-2, 3}, 0, -1));
			rWD.addWeapon(new DefenceWeapon(173, "Lederschild", 27, new int[]{-1, 3}, 5, 0));
			rWD.addWeapon(new DefenceWeapon(174, "Mattenschild", 27, new int[]{-1, 4}, 6, 0));
			rWD.addWeapon(new DefenceWeapon(175, "Großer Lederschild", 27, new int[]{-1, 4}, 6, -1));
			rWD.addWeapon(new DefenceWeapon(176, "Thorwalerschild", 27, new int[]{-2, 4}, 3, -1));
			
			// sehr große Schilde
			rWD.addWeapon(new DefenceWeapon(177, "Großschild/Reiterschild", 28, new int[]{-2, 5}, 2, -2));
			rWD.addWeapon(new DefenceWeapon(178, "Turmschild", 28, new int[]{-5, 7}, 1, -3));
			
			// Parierwaffen
			rWD.addWeapon(new DefenceWeapon(179, "Hackendolch", 29, new int[]{-1, 3}, -2, 0));
			rWD.addWeapon(new DefenceWeapon(180, "Kriegsfächer", 29, new int[]{0, 2}, 3, 1));
			rWD.addWeapon(new DefenceWeapon(181, "Linkhand", 29, new int[]{0, 2}, 0, 1));
			rWD.addWeapon(new DefenceWeapon(182, "Langdolch", 29, new int[]{0, 1}, 1, 0));
		}catch (Exception ex) {throw ex;}
	}
	/**	Dh	9.7.2020
	 * 
	 * 	pWeaponType:
	 * 	 00: Raufen				15: Zweihand-Hiebwaffen
	 * 	 01: Ringen				16: Zweihandschwerter
	 * 	 02: Anderhalbhaender	17: Improvisiert
	 * 	 03: Dolche				18: Armbrust
	 * 	 04: Fechtwaffen		19: Blasrohr
	 * 	 05: Hiebwaffen			20: Bogen
	 * 	 06: Infanteriewaffen	21: Diskus
	 * 	 07: Kettenstaebe		22: Schleuder
	 * 	 08: Kettenwaffen		23: Wurfbeil
	 * 	 09: Peitsche			24: Wurfmesser
	 * 	 10: Saebel				25: Wurfspeer
	 * 	 11: Schwerter			26: kleine Schilde
	 * 	 12: Speere				27: große Schilde
	 * 	 13: Staebe				28: sehr große Schilde
	 * 	 14: Zweihandpflegel	29: Parierwaffen
	 * 	
	 */
	private static void genWeaponTypes() {
		String[] vWeaponTypes;
		if (rWD != null) {
			vWeaponTypes = new String[30];
			
			vWeaponTypes[0] = "Raufen";
			vWeaponTypes[1] = "Ringen";
			vWeaponTypes[2] = "Anderthalbhänder";
			vWeaponTypes[3] = "Dolche";
			vWeaponTypes[4] = "Fechtwaffen";
			
			vWeaponTypes[5] = "Hiebwaffen";
			vWeaponTypes[6] = "Infanteriewaffen";
			vWeaponTypes[7] = "Kettenstäbe";
			vWeaponTypes[8] = "Kettenwaffen";
			vWeaponTypes[9] = "Peitsche";
			
			vWeaponTypes[10] = "Säbel";
			vWeaponTypes[11] = "Schwerter";
			vWeaponTypes[12] = "Speere";
			vWeaponTypes[13] = "Stäbe";
			vWeaponTypes[14] = "Zweihandpflegel";
			
			vWeaponTypes[15] = "Zweihand-Hiebwaffen";
			vWeaponTypes[16] = "Zweihandschwerter";
			vWeaponTypes[17] = "Improvisierte";
			vWeaponTypes[18] = "Armbrust";
			vWeaponTypes[19] = "Blasrohr";
			
			vWeaponTypes[20] = "Bogen";
			vWeaponTypes[21] = "Diskus";
			vWeaponTypes[22] = "Schleuder";
			vWeaponTypes[23] = "Wurfbeil";
			vWeaponTypes[24] = "Wurfmesser";
			
			vWeaponTypes[25] = "Wurfspeere";
			vWeaponTypes[26] = "kleine Schile";
			vWeaponTypes[27] = "große Schilde";
			vWeaponTypes[28] = "sehr große Schilde";
			vWeaponTypes[29] = "Parierwaffen";
			
			rWD.setWeaponTypes(vWeaponTypes);
		}
	}
	/**	Dh	16.7.2020
	 * 
	 * 	pMund:
	 * 	 00: Mundan			  	08: Unholy
	 * 	 01: Nonleathal		  	09: Nonlehtal+Unholy
	 * 	 02: Arkan			  	10: Arkan+Unholy
	 * 	 03: Nonlethal+Arkan  	11: Nonle+Ark+Unho
	 * 	 04: Holy				12: Holy+Unholy
	 * 	 05: Nonlethal+Holy		13: Nonle+Ho+Unho
	 * 	 06: Arkan+Holy			14: Ark+Ho+Unho
	 *   07: Nonle+Ark+Hol		15: All
	 * 	
	 */
	private static void genDamageTypes() {
		String[] vDamageTypes;
		if (rWD != null) {
			vDamageTypes = new String[16];
			
			vDamageTypes[0] = "Mundan";
			vDamageTypes[1] = "Nicht tödlich";
			vDamageTypes[2] = "Magisch";
			vDamageTypes[3] = "Nicht tödlich, Magisch";
			vDamageTypes[4] = "Geweiht";
			
			vDamageTypes[5] = "Nicht tödlich, Geweiht";
			vDamageTypes[6] = "Magisch, Geweiht";
			vDamageTypes[7] = "Nicht tödlich, Magisch, Geweiht";
			vDamageTypes[8] = "Verzehrt";
			vDamageTypes[9] = "Nicht tödliche, Verzehrt";
			
			vDamageTypes[10] = "Magisch, Verzehrt";
			vDamageTypes[11] = "Nicht tödlich, Magisch, Verzehrt";
			vDamageTypes[12] = "Geweiht, Verzehrt";
			vDamageTypes[13] = "Nicht tödlich, Geweiht, Verzehrt";
			vDamageTypes[14] = "Magisch, Geweiht, Verzehrt";
			
			vDamageTypes[15] = "Alle";
			
			rWD.setDamageTypes(vDamageTypes);
		}
	}
	
	/**	Dh	16.7.2020
	 * 
	 * @throws Exception
	 */
	private static void genDatabanks() throws Exception{
		try {
			genTalents();
			genBasicTalents();
			genTalentTypes();
			genWeapons();
			genWeaponTypes();
			genDamageTypes();
			genPros();
			genSpecialCrafts();
		} catch(Exception ex) {throw ex;}
	}
	//--------------------------------------------------------------------------------------------------------
	

}
