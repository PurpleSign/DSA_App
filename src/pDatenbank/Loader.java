/**	DSA_App v0.0	Dh 9.6.2020
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
	
	private static File SystemFile;
	
	private static ProDatabase PD;
	private static SpecialCraftDatabase SCD;
	private static TalentDatabase TD;
	private static WeaponDatabase WD;
	
	public static void main(String[] args) {
		try{
			initLoader();
		} catch (Exception ex) { System.out.println(ex); }
	}
	
	/**	Dh	17.6.2020
	 * 
	 * @throws Exception
	 */
	public static void initLoader() throws Exception{
		try { 
			SystemFile = getFileSystem();
			
			loadDatabases();
			
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
		File ProFile = new File(SystemFile.getAbsolutePath()+ProPath);
		JAXBContext jc = JAXBContext.newInstance(ProDatabase.class);
		Marshaller marschaller = jc.createMarshaller();
		
		marschaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		if (!ProFile.exists()) {
			try{ ProFile.createNewFile();}
			catch(Exception ex) {throw ex;}
		}
		
	    marschaller.marshal(PD, ProFile);
	}
	/**	Dh	16.6.2020
	 * 
	 * @throws Exception
	 */
	public static void saveSpecialCraftDatabase() throws Exception {
		File SpecialCraftFile = new File(SystemFile.getAbsolutePath()+SpecialCraftPath);
		JAXBContext jc = JAXBContext.newInstance(SpecialCraftDatabase.class);
		Marshaller marschaller = jc.createMarshaller();
		
		marschaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		if (!SpecialCraftFile.exists()) {
			try{ SpecialCraftFile.createNewFile();}
			catch(Exception ex) {throw ex;}
		}
		
	    marschaller.marshal(SCD, SpecialCraftFile);
	}
	/**	Dh	9.6.2020
	 * 
	 * @throws Exception
	 */
	public static void saveTalentDatabase() throws Exception {
		File TalentFile = new File(SystemFile.getAbsolutePath()+TalentPath);
		JAXBContext jc = JAXBContext.newInstance(TalentDatabase.class);
		Marshaller marschaller = jc.createMarshaller();
		
		marschaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		if (!TalentFile.exists()) {
			try{ TalentFile.createNewFile();}
			catch(Exception ex) {throw ex;}
		}
		
	    marschaller.marshal(TD, TalentFile);
	}
	/**	Dh	4.6.2020
	 * 
	 * @throws Exception
	 */
	public static void saveWeaponDatabase() throws Exception {
		File WeaponFile = new File(SystemFile.getAbsolutePath()+WeaponPath);
		JAXBContext jc = JAXBContext.newInstance(WeaponDatabase.class);
		Marshaller marschaller = jc.createMarshaller();
		
		marschaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		if (!WeaponFile.exists()) {
			try{ WeaponFile.createNewFile();}
			catch(Exception ex) {throw ex;}
		}
		
	    marschaller.marshal(WD, WeaponFile);
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
		File SettingFile = new File(SystemFile.getAbsolutePath()+AppSettingPath);
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
		File SettingFile = new File(SystemFile.getAbsolutePath()+GameSettingPath);
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
		File SettingFile = new File(SystemFile.getAbsolutePath()+GUISettingPath);
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
			vID = pFM.getID();
			
			File FMFile = new File(SystemFile.getAbsolutePath()+GamePath+"/FM_"+vID+".xml");
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
	
	public static void saveThings(FightManager pFM) {
		File FMFile0 = new File(SystemFile.getAbsolutePath()+GamePath+"/IniElement.xml");
		File FMFile1 = new File(SystemFile.getAbsolutePath()+GamePath+"/NeighbourElement.xml");
		File FMFile2 = new File(SystemFile.getAbsolutePath()+GamePath+"/Character.xml");
		File FMFile3 = new File(SystemFile.getAbsolutePath()+GamePath+"/FightElement.xml");
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
		File ProFile = new File(SystemFile.getAbsolutePath()+ProPath);
		
		if (ProFile.exists()) PD = JAXB.unmarshal(ProFile, ProDatabase.class);
		else throw new Exception("21; Loa,lPD");
	}
	/**	Dh	16.6.2020
	 * 	
	 * @throws Exception
	 */
	public static void loadSpecialCraftDatabase() throws Exception{
		File SpecialCraftFile = new File(SystemFile.getAbsolutePath()+SpecialCraftPath);
		
		if (SpecialCraftFile.exists()) SCD = JAXB.unmarshal(SpecialCraftFile, SpecialCraftDatabase.class);
		else throw new Exception("21; Loa,lSCD");
	}
	/**	Dh	9.6.2020
	 * 	
	 * @throws Exception
	 */
	public static void loadTalentDatabase() throws Exception{
		File TalentFile = new File(SystemFile.getAbsolutePath()+TalentPath);
		
		if (TalentFile.exists()) TD = JAXB.unmarshal(TalentFile, TalentDatabase.class);
		else throw new Exception("21; Loa,lTD");
	}
	/**	Dh	4.6.2020
	 * 
	 * @throws Exception
	 */
 	public static void loadWeaponDatabase() throws Exception{
		File WeaponFile = new File(SystemFile.getAbsolutePath()+WeaponPath);
		
		if (WeaponFile.exists()) WD = JAXB.unmarshal(WeaponFile, WeaponDatabase.class);
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
		File SettingFile = new File(SystemFile.getAbsolutePath()+AppSettingPath);
		
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
		File SettingFile = new File(SystemFile.getAbsolutePath()+GameSettingPath);
		
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
		File SettingFile = new File(SystemFile.getAbsolutePath()+GUISettingPath);
		
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
		File FMFile = new File(SystemFile.getAbsolutePath()+GamePath+"/FM_"+vID+".xml");
		
		if (FMFile.exists()) vRet = JAXB.unmarshal(FMFile, FightManager.class);
		else throw new Exception("21; Loa,lFM");
		
		return vRet;
	}
	
	public static void loadThings() {
		Object vRet;
		
		File FMFile0 = new File(SystemFile.getAbsolutePath()+GamePath+"/IniElement.xml");
		File FMFile1 = new File(SystemFile.getAbsolutePath()+GamePath+"/NeighbourElement.xml");
		File FMFile2 = new File(SystemFile.getAbsolutePath()+GamePath+"/Character.xml");
		File FMFile3 = new File(SystemFile.getAbsolutePath()+GamePath+"/FightElement.xml");
		
		
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
	
	/**	Dh	10.5.2020
	 * 
	 * 	Erstellt einen Charakter anhand der Type Spezifikation.
	 * 
	 * @param pType
	 * @return
	 * @throws Exception
	 */
	public static Charakter loadNewCharacter(int pType) throws Exception {
		int vTalentID;
		String vName, vRasse;
		int[] vProp;
		double[] vStatsMod;
		Charakter vRet;
		
		List vWeapList = new List();
		
		vName = "Test"+Integer.toString(pType);
		vRasse = "Tulamide";
		vProp = new int[10];
		
		if (pType == 0) {
			for (int i=0; i<8; i++) {
				vProp[i] = 11;
			}
			vProp[8] = 8;
			vProp[9] = 7;
			
			vStatsMod = new double[] {10, 10, 0, 0};
			
			vWeapList.append(WD.getWeapon(0));
			vWeapList.append(WD.getWeapon(1));
			vWeapList.append(WD.getWeapon(103));
			vWeapList.append(WD.getWeapon(180));
			
			vRet = new Charakter(0, vName, vRasse, vProp, vStatsMod);
			
			vTalentID = TD.getTalent("Dolche").getID();
			vRet.getTalent(vTalentID).addTaW(7);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {4, 3});
			
			vTalentID = TD.getTalent("Raufen").getID();
			vRet.getTalent(vTalentID).addTaW(5);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {3, 2});
			
			vTalentID = TD.getTalent("Ringen").getID();
			vRet.getTalent(vTalentID).addTaW(5);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {3, 2});
			
			vRet.addTalent(TD.getTalent("Bogen"));
			vTalentID = TD.getTalent("Bogen").getID();
			vRet.getTalent(vTalentID).addTaW(3);
			
			vRet.setWeaponList(vWeapList);
		} else if (pType == 1) {
			for (int i=0; i<8; i++) {
				vProp[i] = 11;
			}
			vProp[8] = 8;
			vProp[9] = 9;
			
			vStatsMod = new double[] {10, 10, 12, 0};
			
			vWeapList.append(WD.getWeapon(0));
			vWeapList.append(WD.getWeapon(1));
			vWeapList.append(WD.getWeapon(103));
			vWeapList.append(WD.getWeapon(180));
			
			vRet = new Charakter(1, vName, vRasse, vProp, vStatsMod);
			
			vTalentID = TD.getTalent("Dolche").getID();
			vRet.getTalent(vTalentID).addTaW(3);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {1, 2});
			
			vTalentID = TD.getTalent("Raufen").getID();
			vRet.getTalent(vTalentID).addTaW(5);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {2, 3});
			
			vTalentID = TD.getTalent("Ringen").getID();
			vRet.getTalent(vTalentID).addTaW(5);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {2, 3});
			
			vRet.setWeaponList(vWeapList);
		} else if (pType == 2) {
			for (int i=0; i<8; i++) {
				vProp[i] = 11;
			}
			vProp[8] = 8;
			vProp[9] = 9;
			
			vStatsMod = new double[] {10, 10, 12, 24};
			
			vWeapList.append(WD.getWeapon(0));
			vWeapList.append(WD.getWeapon(1));
			vWeapList.append(WD.getWeapon(103));
			vWeapList.append(WD.getWeapon(180));
			
			vRet = new Charakter(2, vName, vRasse, vProp, vStatsMod);
			
			vTalentID = TD.getTalent("Dolche").getID();
			vRet.getTalent(vTalentID).addTaW(3);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {1, 2});
			
			vTalentID = TD.getTalent("Raufen").getID();
			vRet.getTalent(vTalentID).addTaW(5);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {2, 3});
			
			vTalentID = TD.getTalent("Ringen").getID();
			vRet.getTalent(vTalentID).addTaW(5);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {2, 3});
			
			vRet.setWeaponList(vWeapList);
		} else throw new Exception("02; Loa,lNC");
		
		return vRet;
	}
	/**	Dh	10.5.2020
	 * 
	 * 	Erzeugt einen zufaelligen Charakter und gibt ihn zurueck.
	 * 
	 * @return
	 */
	public static Charakter loadNewRandomCharakter() throws Exception {
		int vTalentID, vTaW;
		String vName, vRasse;
		int[] vProp;
		double[] vStatsMod;
		Random vRan;
		Charakter vRet;
		List vWeapList = new List();
		vRan = new Random();
		
		vName = "Random"+Integer.toString(vRan.nextInt(100));
		vRasse = "Tulamid";
		vProp = new int[10];
		
		vStatsMod = new double[] {10, 10, 0, 0};
		
		vWeapList.append(WD.getWeapon(0));
		vWeapList.append(WD.getWeapon(1));
		vWeapList.append(WD.getWeapon(103));
		vWeapList.append(WD.getWeapon(180));
		
		for (int i=0; i<8; i++) {
			vProp[i] = 8+vRan.nextInt(6);
		}
		vProp[8] = 1+vRan.nextInt(13);
		vProp[9] = 6+vRan.nextInt(4);
		
		vRet = new Charakter(6, vName, vRasse, vProp, vStatsMod);
		try {
			vTalentID = TD.getTalent("Dolche").getID();
			vTaW = vRan.nextInt(11)+1;
			vRet.getTalent(vTalentID).addTaW(vTaW);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {Math.round(vTaW/2), (int)Math.rint(vTaW/2)});
			
			vTalentID = TD.getTalent("Raufen").getID();
			vTaW = vRan.nextInt(11)+1;
			vRet.getTalent(vTalentID).addTaW(vTaW);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {Math.round(vTaW/2), (int)Math.rint(vTaW/2)});
			
			vTalentID = TD.getTalent("Ringen").getID();
			vTaW = vRan.nextInt(11)+1;
			vRet.getTalent(vTalentID).addTaW(vTaW);
			((Fighttalent)vRet.getTalent(vTalentID)).addFightValues(new int[] {Math.round(vTaW/2), (int)Math.rint(vTaW/2)});
		
			vRet.addTalent(TD.getTalent("Bogen"));
			vTaW = vRan.nextInt(11)+1;
			vTalentID = TD.getTalent("Bogen").getID();
			vRet.getTalent(vTalentID).addTaW(vTaW);
			
			vRet.setWeaponList(vWeapList);
		} catch (Exception ex) {throw ex;}
		
		return vRet;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	10.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List getBasicTalents() throws Exception{
		int[] vBasicTalentIDs;
		Talent vCur;
		List vRet = new List();
		
		if (TD != null) {
			vBasicTalentIDs = TD.getBasicTalents();
			if (vBasicTalentIDs != null) {
				for (int i=0; i < vBasicTalentIDs.length; i++) {
					vCur = TD.getTalent(vBasicTalentIDs[i]);
					
					if (vCur != null) vRet.append(vCur);
				}
			}
		}
		
		return vRet;
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
	
	/**	Dh	17.6.2020
	 * 
	 * @throws Exception
	 */
	private static void genPros() throws Exception{
		PD = new ProDatabase();
		
		try {
			// Vorteile
			PD.addPro(new Pro(0, "Adlig, Adlige Abstammmung"));
			PD.addPro(new Pro(1, "Adlig, Adliges Erbe"));
			PD.addPro(new Pro(2, "Adlig, Amtsadel"));
			PD.addPro(new StringedPro(3, "Affinität zu "));
			PD.addPro(new Pro(4, "Akademische Ausbildung (Gelehrter)"));
			
			PD.addPro(new Pro(5, "Akademische Ausbildung (Magier)", true, true));
			PD.addPro(new Pro(6, "Akademische Ausbildung (Krieger)"));
			PD.addPro(new Pro(7, "Altersresistenz"));
			PD.addPro(new Pro(8, "Astrale Regeneration I", true, true));
			PD.addPro(new Pro(9, "Astrale Regeneration II", true, true));
			
			PD.addPro(new Pro(10, "Astrale Regeneration III", true, true));
			PD.addPro(new ValuedPro(11, "Astralmacht", true, true));
			PD.addPro(new ValuedPro(12, "Ausdauernd"));
			PD.addPro(new Pro(13, "Ausdauernder Zauberer", true, true));
			PD.addPro(new ValuedPro(14, "Ausrüstungsvorteil"));
			
			PD.addPro(new Pro(15, "Balance"));
			PD.addPro(new ReferredPro(16, "Begabung für Merkmal", true, true));
			PD.addPro(new ReferredPro(17, "Begabung für Ritual", true, true));
			PD.addPro(new ReferredPro(18, "Begabung für Talent"));
			PD.addPro(new ReferredPro(19, "Begabung für Talentgruppe"));
			
			PD.addPro(new ReferredPro(20, "Begabung für Zauber", true, true));
			PD.addPro(new Pro(21, "Beidhändig"));
			PD.addPro(new Pro(22, "Beseelte Knochenkeule"));
			PD.addPro(new ValuedPro(23, "Besonderer Besitz"));
			PD.addPro(new Pro(24, "Breitgefächerte Bildung"));
			
			PD.addPro(new Pro(25, "Dämmerungssicht"));
			PD.addPro(new Pro(26, "Eidetisches gedächtnis"));
			PD.addPro(new Pro(27, "Eigeboren", true ,true));
			PD.addPro(new Pro(28, "Eisenaffine Aura", true, true));
			PD.addPro(new Pro(29, "Eisern"));
			
			PD.addPro(new Pro(30, "Empathie", true, false, true));
			PD.addPro(new Pro(31, "Entfernungssinn"));
			PD.addPro(new ValuedPro(32, "Ererbte Knochenkeuel", true, true));
			PD.addPro(new Pro(33, "Feenfreund"));
			PD.addPro(new Pro(34, "Feste Matrix", true, true));
			
			PD.addPro(new Pro(35, "Flink"));
			PD.addPro(new ValuedPro(36, "Gebildet"));
			PD.addPro(new Pro(37, "Gefahreninstinkt", true, false, true));
			PD.addPro(new Pro(38, "Geräuschhexerei", true, false, true));
			PD.addPro(new Pro(39, "Geweiht"));
			
			PD.addPro(new Pro(40, "Glück"));
			PD.addPro(new Pro(41, "Glück im Spiel"));
			PD.addPro(new Pro(42, "Gut Aussehend"));
			PD.addPro(new ValuedPro(43, "Guter Ruf"));
			PD.addPro(new Pro(44, "Gutes Gedächtnis"));
			
			PD.addPro(new Pro(45, "Halbzauberer", true, true));
			PD.addPro(new Pro(46, "Herausragende Balance"));
			PD.addPro(new Pro(47, "Herausragende Eigenschaft"));
			PD.addPro(new Pro(48, "Herausragender Sechster Sinn"));
			PD.addPro(new StringedPro(49, "Herausragender Sinn"));
			
			PD.addPro(new Pro(50, "Herausragendes Aussehen"));
			PD.addPro(new Pro(51, "Hitzeresistenz"));
			PD.addPro(new ValuedPro(52, "Hohe Lebenskraft"));
			PD.addPro(new ValuedPro(53, "Hohe Magieresistenz"));
			PD.addPro(new ReferredPro(54, "Immunität gegen Gift"));
			
			PD.addPro(new ReferredPro(55, "Immunität gegen Gift-Gruppe"));
			PD.addPro(new ReferredPro(56, "Immunität gegen alle Gifte"));
			PD.addPro(new ReferredPro(57, "Immunität gegen Krankheit"));
			PD.addPro(new ReferredPro(58, "Immunität geegen Krankheiten"));
			PD.addPro(new Pro(59, "Innerer Kompass"));
			
			PD.addPro(new Pro(60, "Kälteresistenz"));
			PD.addPro(new Pro(61, "Kampfrausch"));
			PD.addPro(new Pro(62, "Koboldfreund"));
			PD.addPro(new ReferredPro(63, "Kräfteschub", true, false, true));
			PD.addPro(new Pro(64, "Linkshänder"));
			
			PD.addPro(new Pro(65, "Machtvoller Vertrauter", true, true));
			PD.addPro(new Pro(66, "Magiegespür", true, false, true));
			PD.addPro(new ReferredPro(67, "Meisterhandwerk", true, true));
			PD.addPro(new Pro(68, "Nachtsicht"));
			PD.addPro(new ValuedPro(69, "Natürliche Waffe"));
			
			PD.addPro(new ValuedPro(70, "Natürlicher Rüstungsschutz"));
			PD.addPro(new ReferredPro(71, "Niedrige Schlechte Eigenschaft"));
			PD.addPro(new Pro(72, "Prophezeien", true, false, true));
			PD.addPro(new ReferredPro(73, "Resistenz gegen Gift"));
			PD.addPro(new ReferredPro(74, "Resistenz gegen Gifte"));
			
			PD.addPro(new ReferredPro(75, "Resistenz gegen alle Gifte"));
			PD.addPro(new ReferredPro(76, "Resistenz gegen Krankheiten"));
			PD.addPro(new Pro(77, "Richtungssinn"));
			PD.addPro(new Pro(78, "Schlangenmensch"));
			PD.addPro(new Pro(79, "Schnelle Heilung I"));
			
			PD.addPro(new Pro(80, "Schnelle Heilung II"));
			PD.addPro(new Pro(81, "Schnelle Heilung III"));
			PD.addPro(new Pro(82, "Schutzgeist", true, true));
			PD.addPro(new Pro(83, "Schwer zu verzaubern"));
			PD.addPro(new Pro(84, "Soziale Anpassungsfähigkeit"));
			
			PD.addPro(new ReferredPro(85, "Talentschub", true, false, true));
			PD.addPro(new StringedPro(86, "Tierempathie, Tiergruppe", true, false, true));
			PD.addPro(new StringedPro(87, "Tierempathie, alle", true, false, true));
			PD.addPro(new Pro(88, "Tierfreund"));
			PD.addPro(new ReferredPro(89, "Übernatürliche Begabung", true, true, true));
			
			PD.addPro(new Pro(90, "Unbeschwertes Zaubern", true, true));
			PD.addPro(new Pro(91, "Verbindungen"));
			PD.addPro(new Pro(92, "Verhüllte Aura", true, true));
			PD.addPro(new Pro(93, "Viertelzauberer, unentdeckt", true, true));
			PD.addPro(new Pro(94, "Viertelzauberer, bekannt", true, true));
			
			PD.addPro(new Pro(95, "Vollzauberer", true, true));
			PD.addPro(new Pro(96, "Vom Schicksal begünstigt"));
			PD.addPro(new Pro(97, "Wesen der Nacht I", true, true));
			PD.addPro(new Pro(98, "Wesen der Nacht II", true, true));
			PD.addPro(new Pro(99, "Wesen der Nacht III", true, true));
			
			PD.addPro(new Pro(100, "Wohlklang"));
			PD.addPro(new Pro(101, "Wolfskind", true, true));
			PD.addPro(new Pro(102, "Wolfskind, freiwillig", true, true));
			PD.addPro(new Pro(103, "Zäher Hund"));
			PD.addPro(new Pro(104, "Zauberhaar", true, true));
			
			PD.addPro(new Pro(105, "Zeitgefühl"));
			PD.addPro(new Pro(106, "Zweistimmiger Gesang", true, true));
			PD.addPro(new Pro(107, "Zwergennase", true, false, true));
			
			// Nachteile
			PD.addPro(new BadCharacteristic(108, "Aberglaube"));
			PD.addPro(new Pro(109, "Albino", false));
			PD.addPro(new StringedBadCharacteristica(110, "Angst vor ", false));
			PD.addPro(new Pro(111, "Animalische Magie", false, true));
			PD.addPro(new BadCharacteristic(112, "Arkanophobie", false));
			
			PD.addPro(new BadCharacteristic(113, "Arroganz", false));
			PD.addPro(new Pro(114, "Artefaktgebunden", false, true));
			PD.addPro(new Pro(115, "Astraler Block", false, true));
			PD.addPro(new BadCharacteristic(116, "Autoritätsgläubig", false));
			PD.addPro(new Pro(117, "Behäbig", false));
			
			PD.addPro(new BadCharacteristic(118, "Blutdurst", false));
			PD.addPro(new Pro(119, "Blutrausch", false));
			PD.addPro(new BadCharacteristic(120, "Brünstigkeit", false));
			PD.addPro(new BadCharacteristic(121, "Dunkelangst", false));
			PD.addPro(new Pro(122, "Einarmig", false));
			
			PD.addPro(new Pro(123, "Gelähmter Arm", false));
			PD.addPro(new Pro(124, "Einäugig", false));
			PD.addPro(new Pro(125, "Einbeinig", false));
			PD.addPro(new Pro(126, "Einbildungen", false));
			PD.addPro(new Pro(127, "Eingeschränkte Elementarnähe", false, true));
			
			PD.addPro(new StringedPro(128, "Engeschränkter Sinn", false));
			PD.addPro(new Pro(129, "Einhändig", false));
			PD.addPro(new BadCharacteristic(130, "Eitelkeit", false));
			PD.addPro(new Pro(131, "Elfische Weltsicht", false));
			PD.addPro(new Pro(132, "Farbenblind", false));
			
			PD.addPro(new StringedPro(133, "Feind", false));
			PD.addPro(new Pro(134, "Feste Gewohntheit", false, true));
			PD.addPro(new ValuedPro(135, "Festgefügtes Denken", false, true));
			PD.addPro(new Pro(136, "Fettleibig", false));
			PD.addPro(new Pro(137, "Fluch der Finsternis I", false, true));
			
			PD.addPro(new Pro(138, "Fluch der Finsternis II", false, true));
			PD.addPro(new Pro(139, "Fluch der Finsternis III", false, true));
			PD.addPro(new BadCharacteristic(140, "Geiz", false));
			PD.addPro(new BadCharacteristic(141, "Gerechtigkeitswahn", false));
			PD.addPro(new StringedPro(142, "Gesucht I", false));
			
			PD.addPro(new StringedPro(143, "Gesucht II", false));
			PD.addPro(new StringedPro(144, "Gesucht III", false));
			PD.addPro(new Pro(145, "Glasknochen", false));
			PD.addPro(new BadCharacteristic(146, "Goldgier", false));
			PD.addPro(new BadCharacteristic(147, "Größenwahn", false));
			
			PD.addPro(new Pro(148, "Heimwehkrank", false));
			PD.addPro(new Pro(149, "Hitzeempfindlichkeit", false));
			PD.addPro(new BadCharacteristic(150, "Höhenangst", false));
			PD.addPro(new Pro(151, "Impulsiv", false));
			PD.addPro(new BadCharacteristic(152, "Jähzorn", false));
			
			PD.addPro(new Pro(153, "Kälteempfindlichkeit", false));
			PD.addPro(new Pro(154, "Kältestarre", false));
			PD.addPro(new Pro(155, "Kein Vertrauter", false, true));
			PD.addPro(new Pro(156, "Kristallgebunden", false, true));
			PD.addPro(new Pro(157, "Kleinwüchsig", false));
			
			PD.addPro(new Pro(158, "Körpergebundene Kraft", false, true));
			PD.addPro(new BadCharacteristic(159, "Krankhafte Reinlichkeit", false));
			PD.addPro(new Pro(160, "Krankheitsanfällig", false));
			PD.addPro(new ValuedPro(161, "Kurzatmig", false));
			PD.addPro(new Pro(162, "Lahm", false));
			
			PD.addPro(new Pro(163, "Lästige Mindergsiter", false, true));
			PD.addPro(new Pro(164, "Lichtempfindlichkeit", false));
			PD.addPro(new Pro(165, "Lichtscheu", false));
			PD.addPro(new Pro(166, "Madas Fluch I", false, true));
			PD.addPro(new Pro(167, "Madas Fluch II", false, true));
			
			PD.addPro(new Pro(168, "Madas Fluch III", false, true));
			PD.addPro(new Pro(169, "Medium", false));
			PD.addPro(new BadCharacteristic(170, "Meeresangst", false));
			PD.addPro(new ReferredPro(171, "Miserable Eigenschaft", false));
			PD.addPro(new Pro(172, "Mondsüchtig", false));
			
			PD.addPro(new StringedPro(173, "Moralkodex", false));
			PD.addPro(new Pro(174, "Nachtblind", false));
			PD.addPro(new Pro(175, "Nahrungsrestriktion", false));
			PD.addPro(new BadCharacteristic(176, "Neid", false));
			PD.addPro(new BadCharacteristic(177, "Neugier", false));
			
			PD.addPro(new ValuedPro(178, "Niedrige Astralkraft", false, true));
			PD.addPro(new ValuedPro(179, "Niedrige Lebenskraft", false));
			PD.addPro(new ValuedPro(180, "Niedrige Magieresitenz", false));
			PD.addPro(new Pro(181, "Pechmagnet", false));
			PD.addPro(new BadCharacteristic(182, "Platzangst", false));
			
			PD.addPro(new StringedPro(183, "Prinzipientreue", false));
			PD.addPro(new BadCharacteristic(184, "Rachsucht", false));
			PD.addPro(new StringedPro(185, "Randgruppe", false));
			PD.addPro(new Pro(186, "Raubtiergeruch", false));
			PD.addPro(new BadCharacteristic(187, "Raumangst", false));
			
			PD.addPro(new Pro(188, "Rückschlag", false, true));
			PD.addPro(new Pro(189, "Schlafstörung I", false));
			PD.addPro(new Pro(190, "Schlafstörung II", false));
			PD.addPro(new Pro(191, "Schlafwandler", false));
			PD.addPro(new Pro(192, "Schlechte Regeneration", false));
			
			PD.addPro(new ValuedPro(193, "Schlechter Ruf", false));
			PD.addPro(new Pro(194, "Schneller Alternd", false));
			PD.addPro(new ValuedPro(195, "Schulden", false));
			PD.addPro(new ValuedPro(196, "Schwache Ausstrahlung", false, true));
			PD.addPro(new Pro(197, "Schwacher Astralkörper", false, true));
			
			PD.addPro(new Pro(198, "Schwanzlos", false));
			PD.addPro(new Pro(199, "Seffer Manich", false));
			PD.addPro(new Pro(200, "Selbstgespräche", false));
			PD.addPro(new StringedValuedPro(201, "Sensibler Geruchssinn", false));
			PD.addPro(new Pro(202, "Sippenlosigkeit", false));
			
			PD.addPro(new BadCharacteristic(203, "Sonnensucht", false));
			PD.addPro(new StringedPro(204, "Speisegebot", false));
			PD.addPro(new BadCharacteristic(205, "Spielsucht", false));
			PD.addPro(new Pro(206, "Sprachfehler", false));
			PD.addPro(new Pro(207, "Spruchhemmung", false, true));
			
			PD.addPro(new StringedPro(208, "Stigma", false));
			PD.addPro(new BadCharacteristic(209, "Streitsucht", false));
			PD.addPro(new Pro(211, "Stubenhocker", false));
			PD.addPro(new StringedValuedPro(212, "Sucht", false));
			PD.addPro(new ReferredPro(213, "Thesisgebunden", false, true));
			
			PD.addPro(new Pro(214, "Tollpatsch", false));
			PD.addPro(new BadCharacteristic(215, "Totenangst", false));
			PD.addPro(new Pro(216, "Über Geruch", false));
			PD.addPro(new Pro(217, "Unangenehme Stimme", false));
			PD.addPro(new Pro(218, "Unansehnlich", false));
			
			PD.addPro(new Pro(219, "Unfähigkeit für Talente", false));
			PD.addPro(new Pro(220, "Unfähigkeit für Talent-Gruppe", false));
			PD.addPro(new Pro(221, "Unfähigkeit für Merkmal", false, true));
			PD.addPro(new Pro(222, "Unfähigkeit für Rituale", false, true));
			PD.addPro(new Pro(223, "Unfrei", false));
			
			PD.addPro(new ValuedPro(224, "Ungebildet", false));
			PD.addPro(new Pro(225, "Unstet", false));
			PD.addPro(new Pro(226, "Unverträglichkeit mit verarbeitetem Metall", false, true));
			PD.addPro(new Pro(227, "Vergesslichkeit", false));
			PD.addPro(new Pro(228, "Verpflichtungen", false));
			
			PD.addPro(new BadCharacteristic(229, "Verschwendungssucht", false));
			PD.addPro(new BadCharacteristic(230, "Verwöhnt", false));
			PD.addPro(new StringedBadCharacteristica(231, "Vorurteile", false));
			PD.addPro(new Pro(232, "Wahnvorstellungen", false));
			PD.addPro(new Pro(233, "Wahrer Name", false, true));
			
			PD.addPro(new StringedBadCharacteristica(234, "Weltfremd", false));
			PD.addPro(new Pro(235, "Widerwärtiges Aussehen", false));
			PD.addPro(new Pro(236, "Wilde Magie", false, true));
			PD.addPro(new Pro(237, "Zielschwierigkeiten", false, true));
			PD.addPro(new Pro(238, "Zögerlicher Zauberer", false, true));
			PD.addPro(new Pro(239, "Zwergenwuchs", false));
			
//			PD.addPro(new Pro(160, "", false));
		} catch (Exception ex) {throw ex;}
	}
	
	private static void genSpecialCrafts() throws Exception{
		List vTemp;
		SCD = new SpecialCraftDatabase();
		
		try {
			// Allgemeine
			SCD.addSpecialCraft(new StringedSpecialCraft(0, "Akklimatisierung", 0, new int[] {-1, -1, -1, -1, -1, -1, 12, -1}));
			SCD.addSpecialCraft(new StringedSpecialCraft(1, "Berufsgeheimnis", 0));
			SCD.addSpecialCraft(new SpecialCraft(2, "Fälscher", 0));
			SCD.addSpecialCraft(new ReferredSpecialCraft(3, "Geländerkunde", 0));
			SCD.addSpecialCraft(new ReferredSpecialCraft(4, "Kulturkunde", 0, new int[] {-1, 10, 10, -1, -1, -1, -1, -1}));
			
			SCD.addSpecialCraft(new SpecialCraft(5, "Meister der Improvisation", 0, new int[] {-1, -1, 12, -1, 12, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(6, "Nandusgefälliges Wissen", 0, new int[] {-1, 12, 12, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new StringedSpecialCraft(7, "Ortskenntnis", 0));
			SCD.addSpecialCraft(new SpecialCraft(8, "Rosstäuscher", 0));
			SCD.addSpecialCraft(new SpecialCraft(9, "Standfest", 0, new int[] {-1, -1, -1, -1, -1, 12, -1, -1}));
			SCD.addSpecialCraft(new ReferredSpecialCraft(10, "Talentspezialisierung", 0));
			
			// Kampf
			SCD.addSpecialCraft(new SpecialCraft(11, "Aufmerksamkeit", 1, new int[] {-1, -1, 12, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(12, "Ausfall", 1, new int[] {-1, -1, -1, -1, -1, -1, 12, -1}));
			SCD.addSpecialCraft(new SpecialCraft(13, "Ausweichen I", 1, new int[] {-1, -1, -1, -1, -1, 10, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(14, "Ausweichen II", 1, new int[] {-1, -1, -1, -1, -1, 12, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(15, "Ausweichen III", 1, new int[] {-1, -1, -1, -1, -1, -1, 12, -1}));
			
			SCD.addSpecialCraft(new SpecialCraft(16, "Befreiungsschlag", 1, new int[] {12, -1, -1, -1, -1, -1, -1, 15}));
			SCD.addSpecialCraft(new SpecialCraft(17, "Beidhändiger Kampf I", 1, new int[] {-1, -1, -1, -1, -1, 12, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(18, "Beidhändiger Kampf II", 1, new int[] {-1, -1, -1, -1, -1, 15, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(19, "Berittener Schütze", 1));
			SCD.addSpecialCraft(new SpecialCraft(20, "Betäubungsschlag", 1));
			
			SCD.addSpecialCraft(new SpecialCraft(21, "Binden", 1, new int[] {-1, -1, 12, -1, -1, 12, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(22, "Blindkampf", 1, new int[] {-1, -1, -1, -1, -1, 12, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(23, "Defensiver Kampfstil", 1, new int[] {-1, -1, -1, -1, -1, 12, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(24, "Doppelangriff", 1));
			SCD.addSpecialCraft(new SpecialCraft(25, "Eisenhagel", 1, new int[] {-1, -1, -1, -1, 12, -1, -1, -1}));
			
			SCD.addSpecialCraft(new SpecialCraft(26, "Entwaffnen", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 12}));
			SCD.addSpecialCraft(new SpecialCraft(27, "Festnageln", 1, new int[] {-1, -1, -1, -1, -1, 13, -1, 13}));
			SCD.addSpecialCraft(new SpecialCraft(28, "Finte", 1, new int[] {-1, -1, -1, -1, -1, 12, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(29, "Formation", 1));
			SCD.addSpecialCraft(new SpecialCraft(30, "Gegenhalten", 1, new int[] {15, -1, -1, -1, -1, 12, -1, -1}));
			
			SCD.addSpecialCraft(new SpecialCraft(31, "Geschützmeister", 1, new int[] {-1, -1, -1, -1, 12, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(32, "Gezielter Stich", 1));
			SCD.addSpecialCraft(new SpecialCraft(33, "Halbschwert", 1));
			SCD.addSpecialCraft(new SpecialCraft(34, "Hammerschlag", 1, new int[] {15, -1, -1, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(35, "Improvisierte Waffen", 1, new int[] {-1, -1, 12, -1, -1, 12, -1, -1}));
			
			SCD.addSpecialCraft(new SpecialCraft(36, "Kampf im Wasser", 1, new int[] {-1, -1, -1, -1, -1, 12, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(37, "Kampfgespür", 1, new int[] {-1, -1, 15, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(38, "Kampfreflexe", 1));
			SCD.addSpecialCraft(new SpecialCraft(39, "Klingensturm", 1));
			SCD.addSpecialCraft(new SpecialCraft(40, "Klingentänzer", 1, new int[] {-1, -1, -1, -1, -1, 15, -1, -1}));
			
			SCD.addSpecialCraft(new SpecialCraft(41, "Klingenwand", 1));
			SCD.addSpecialCraft(new SpecialCraft(42, "Kriegsreiterei", 1));
			SCD.addSpecialCraft(new SpecialCraft(43, "Linkhand", 1, new int[] {-1, -1, -1, -1, -1, 10, -1, 10}));
			SCD.addSpecialCraft(new SpecialCraft(44, "Meisterliches Entwaffnen", 1, new int[] {-1, -1, -1, -1, -1, 15, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(45, "Meisterparade", 1));
			
			SCD.addSpecialCraft(new SpecialCraft(46, "Meisterschütze", 1));
			SCD.addSpecialCraft(new SpecialCraft(47, "Niederwerfen", 1));
			SCD.addSpecialCraft(new SpecialCraft(48, "Parierwaffen I", 1, new int[] {-1, -1, -1, -1, -1, 12, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(49, "Parierwaffen II", 1, new int[] {-1, -1, -1, -1, -1, 15, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(50, "Reiterkampf", 1));
			
			SCD.addSpecialCraft(new ReferredSpecialCraft(51, "Rüstungsgewöhnung I", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 10}));
			SCD.addSpecialCraft(new ReferredSpecialCraft(52, "Rüstungsgewöhnung II", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 12}));
			SCD.addSpecialCraft(new ReferredSpecialCraft(53, "Rüstungsgewöhnung III", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 15}));
			SCD.addSpecialCraft(new SpecialCraft(54, "Scharfschütze", 1));
			SCD.addSpecialCraft(new SpecialCraft(55, "Schildkampf I", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 12}));
			
			SCD.addSpecialCraft(new SpecialCraft(56, "Schildkampf II", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 15}));
			SCD.addSpecialCraft(new SpecialCraft(57, "Schildspalter", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 15}));
			SCD.addSpecialCraft(new SpecialCraft(58, "Schnellladen Bogen", 1, new int[] {-1, -1, -1, -1, 12, -1, -1, 12}));
			SCD.addSpecialCraft(new SpecialCraft(59, "Schnellladen Armbrust", 1, new int[] {-1, -1, -1, -1, 12, -1, -1, 12}));
			SCD.addSpecialCraft(new SpecialCraft(60, "Schnellziehen", 1, new int[] {-1, -1, -1, -1, 10, 12, -1, -1}));
			
			SCD.addSpecialCraft(new SpecialCraft(61, "Spießgespann", 1));
			SCD.addSpecialCraft(new SpecialCraft(62, "Sturmangriff", 1, new int[] {12, -1, -1, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(63, "Tod von links", 1));
			SCD.addSpecialCraft(new SpecialCraft(64, "Todesstoß", 1, new int[] {15, -1, -1, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(65, "Turnierreiterei", 1));
			
			SCD.addSpecialCraft(new SpecialCraft(66, "Umreißen", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 12}));
			SCD.addSpecialCraft(new SpecialCraft(67, "Unterwasserkampf", 1));
			SCD.addSpecialCraft(new SpecialCraft(68, "Waffe zerbrechen", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 12}));
			SCD.addSpecialCraft(new ReferredSpecialCraft(69, "Waffenmeister Waffen", 1));
			SCD.addSpecialCraft(new ReferredSpecialCraft(70, "Waffenmeister Schilde", 1));
			
			SCD.addSpecialCraft(new ReferredSpecialCraft(81, "Waffenloses Manöver: ", 1));			
			SCD.addSpecialCraft(new SpecialCraft(82, "Waffenloser Kampfstil: Bornländisch", 1));
			SCD.addSpecialCraft(new SpecialCraft(83, "Waffenloser Kampfstil: Gladiatorenstil", 1));
			SCD.addSpecialCraft(new SpecialCraft(84, "Waffenloser Kampfstil: Hammerfaust", 1));
			SCD.addSpecialCraft(new SpecialCraft(85, "Waffenloser Kampfstil: Hururuzat", 1));
			
			SCD.addSpecialCraft(new SpecialCraft(86, "Waffenloser Kampfstil: Mercenario", 1));
			SCD.addSpecialCraft(new SpecialCraft(87, "Waffenloser Kampfstil: Unauer Schule", 1));
			SCD.addSpecialCraft(new ReferredSpecialCraft(88, "Waffenspezialisierung", 1));
			SCD.addSpecialCraft(new SpecialCraft(89, "Windmühle", 1));
			SCD.addSpecialCraft(new SpecialCraft(90, "Wuchtschlag", 1, new int[] {-1, -1, -1, -1, -1, -1, -1, 12}));
			
			// Magische
			SCD.addSpecialCraft(new SpecialCraft(91, "Apport", 2, new int[] {12, 12, 13, 13, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(92, "Astrale Meditation", 2, new int[] {-1, -1, 13, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(93, "Aura verhüllen", 2, new int[] {13, -1, 13, -1, -1, -1, 12, -1}));
			SCD.addSpecialCraft(new SpecialCraft(94, "Aurapanzer", 2, new int[] {15, 13, 13, -1, -1, -1, 13, -1}));
			SCD.addSpecialCraft(new SpecialCraft(95, "Bannschwert", 2));
			
			SCD.addSpecialCraft(new SpecialCraft(96, "Blutmagie", 2, new int[] {12, -1, -1, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(97, "Chimärenmeister", 2));
			SCD.addSpecialCraft(new SpecialCraft(98, "Dämonenbindung I", 2));
			SCD.addSpecialCraft(new SpecialCraft(99, "Dämonenbindung II", 2));
			SCD.addSpecialCraft(new SpecialCraft(100, "Druidenrache", 2, new int[] {15, -1, -1, -1, -1, -1, -1, -1}));
			
			SCD.addSpecialCraft(new ReferredSpecialCraft(101, "Druidische Dolchrituale", 2));
			SCD.addSpecialCraft(new ReferredSpecialCraft(102, "Druidische Herrschaftsrituale", 2));
			SCD.addSpecialCraft(new SpecialCraft(103, "Eiserner Wille I", 2, new int[] {13, -1, 12, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(104, "Eiserner Wille II", 2, new int[] {13, -1, 12, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(105, "Elementarharmonisierte Aura", 2, new int[] {-1, 15, 15, -1, -1, -1, -1, -1}));
			
			SCD.addSpecialCraft(new ReferredSpecialCraft(106, "Elfenlieder", 2));
			SCD.addSpecialCraft(new SpecialCraft(107, "Exorzist", 2, new int[] {15, -1, -1, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(108, "Fernzauberei", 2, new int[] {-1, -1, 12, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(109, "Form der Formlosigkeit", 2));
			SCD.addSpecialCraft(new SpecialCraft(110, "Geber der Gestalt", 2));
			
			SCD.addSpecialCraft(new SpecialCraft(111, "Gedankenschutz", 2, new int[] {15, -1, 13, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(112, "Gefäß der Sterne", 2, new int[] {-1, -1, 13, 15, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new ReferredSpecialCraft(113, "Geodenrituale", 2));
			SCD.addSpecialCraft(new SpecialCraft(114, "Golembauer", 2, new int[] {15, -1, -1, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(115, "Große Meditation", 2, new int[] {-1, 12, 12, -1, -1, -1, -1, -1}));
			
			SCD.addSpecialCraft(new ReferredSpecialCraft(116, "Hexenflüche", 2));
			SCD.addSpecialCraft(new SpecialCraft(117, "Höhere Dämonenbindung", 2));
			SCD.addSpecialCraft(new SpecialCraft(118, "Hypervehemenz", 2));
			SCD.addSpecialCraft(new SpecialCraft(119, "Invocatio Integra", 2));
			SCD.addSpecialCraft(new ReferredSpecialCraft(120, "Keulenrituale", 2));
			
			SCD.addSpecialCraft(new SpecialCraft(121, "Konzentrationsstärke", 2, new int[] {15, -1, -1, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(122, "Kraftkontrolle", 2, new int[] {-1, -1, 12, 13, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(123, "Kraftlinienmagie I", 2, new int[] {-1, 15, -1, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(124, "Kraftlinienmagie II", 2));
			SCD.addSpecialCraft(new SpecialCraft(125, "Kraftspeicher", 2));
			
			SCD.addSpecialCraft(new ReferredSpecialCraft(126, "Kristallomantische Rituale", 2));
			SCD.addSpecialCraft(new ReferredSpecialCraft(127, "Kugelzauber", 2));
			SCD.addSpecialCraft(new SpecialCraft(128, "Lockeres Zaubern", 2, new int[] {-1, -1, 16, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(129, "Matrixgeber", 2));
			SCD.addSpecialCraft(new SpecialCraft(130, "Matrixkontrolle", 2));
			
			SCD.addSpecialCraft(new SpecialCraft(131, "Matrixregeneration I", 2, new int[] {-1, -1, 14, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(132, "Matrixregeneration II", 2, new int[] {-1, -1, 16, 13, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(133, "Matrixverständnis", 2, new int[] {-1, -1, 15, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(134, "Meisterliche Regeneration", 2));
			SCD.addSpecialCraft(new SpecialCraft(135, "Meisterliche Zauberkontrolle I", 2, new int[] {12, 15, -1, -1, -1, -1, -1, -1}));
			
			SCD.addSpecialCraft(new SpecialCraft(136, "Meisterliche Zauberkontrolle II", 2, new int[] {12, 15, -1, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new ReferredSpecialCraft(137, "Merkmalkenntnis", 2, new int[] {-1, 13, -1, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(138, "Nekromant", 2, new int[] {15, -1, -1, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(139, "Odûns Gaben", 2));
			SCD.addSpecialCraft(new SpecialCraft(140, "Ottagaldr", 2));
			
			SCD.addSpecialCraft(new SpecialCraft(141, "Regeneration I", 2, new int[] {-1, -1, 12, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(142, "Regeneration II", 2, new int[] {-1, -1, 15, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(143, "Repräsentation", 2));
			SCD.addSpecialCraft(new ReferredSpecialCraft(144, "Ritualkenntnis", 2));
			SCD.addSpecialCraft(new SpecialCraft(145, "Runenkunde", 2, new int[] {-1, -1, -1, -1, 12, -1, -1, -1}));
			
			SCD.addSpecialCraft(new SpecialCraft(146, "Salsandra", 2));
			SCD.addSpecialCraft(new ReferredSpecialCraft(147, "Schalenzauber", 2));
			SCD.addSpecialCraft(new ReferredSpecialCraft(148, "Schamanistische Rituale", 2));
			SCD.addSpecialCraft(new ReferredSpecialCraft(149, "Schlangenring-Zauber", 2));
			SCD.addSpecialCraft(new ReferredSpecialCraft(150, "Schuppenbeutel", 2));
			
			SCD.addSpecialCraft(new SpecialCraft(151, "Semipermanenz I", 2));
			SCD.addSpecialCraft(new SpecialCraft(152, "Semipermanenz II", 2));
			SCD.addSpecialCraft(new SpecialCraft(153, "Signaturkenntnis", 2, new int[] {-1, 15, 15, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(154, "Simultanzaubern", 2, new int[] {-1, 15, -1, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new ReferredSpecialCraft(155, "Stabzauber", 2));
			
			SCD.addSpecialCraft(new SpecialCraft(156, "Stapeleffekt", 2));
			SCD.addSpecialCraft(new SpecialCraft(157, "Tanz der Mada", 2));
			SCD.addSpecialCraft(new StringedSpecialCraft(158, "Tierischer Begleiter", 2));
			SCD.addSpecialCraft(new SpecialCraft(159, "Traumgänger", 2, new int[] {-1, -1, 12, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new ReferredSpecialCraft(160, "Trommelzauber", 2));
			
			SCD.addSpecialCraft(new SpecialCraft(161, "Verbotene Pfoten", 2, new int[] {12, -1, -1, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new StringedSpecialCraft(162, "Vertrautenbindung", 2));
			SCD.addSpecialCraft(new SpecialCraft(163, "Vielfache Ladungen", 2));
			SCD.addSpecialCraft(new SpecialCraft(164, "Zauber bereithalten", 2, new int[] {15, 15, -1, -1, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(165, "Zauberkontrolle", 2, new int[] {-1, 12, -1, -1, -1, -1, -1, -1}));
			
			SCD.addSpecialCraft(new SpecialCraft(166, "Zauberroutine", 2));
			SCD.addSpecialCraft(new SpecialCraft(167, "Zauber unterbrechen", 2));
			SCD.addSpecialCraft(new SpecialCraft(168, "Zauber vereinigen", 2));
			SCD.addSpecialCraft(new ReferredSpecialCraft(169, "Zauberspezialisierung", 2));
			SCD.addSpecialCraft(new ReferredSpecialCraft(170, "Zaubertänzer", 2));
			
			SCD.addSpecialCraft(new SpecialCraft(171, "Zauberzeichen", 2, new int[] {-1, 12, 12, -1, 12, -1, -1, -1}));
			SCD.addSpecialCraft(new ReferredSpecialCraft(172, "Zibilja-Rituale", 2));
			
			// Geweihte
			SCD.addSpecialCraft(new SpecialCraft(173, "Akoluth", 3));
			SCD.addSpecialCraft(new SpecialCraft(174, "Aura der Heiligkeit", 3, new int[] {-1, -1, 15, 15, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new SpecialCraft(175, "Karmalqueste", 3));
			
			SCD.addSpecialCraft(new SpecialCraft(176, "Kontakt zum Großen Geist", 3, new int[] {-1, -1, -1, 15, -1, -1, -1, -1}));
			SCD.addSpecialCraft(new StringedSpecialCraft(177, "Liturgiekenntnis", 3));
			SCD.addSpecialCraft(new ReferredSpecialCraft(178, "Liturgie", 3));
			SCD.addSpecialCraft(new StringedSpecialCraft(179, "Ritualkenntnis", 3));
			SCD.addSpecialCraft(new StringedSpecialCraft(180, "Spätweihe", 3, new int[] {-1, -1, -1, 11, -1, -1, -1, -1}));
			
			
			// Setzte Vorraussetzungen
			// Allgemeine
			SCD.addTypedPremiseOfSpecialCraft("Berufsgeheimnis", 4, 7, 15);
			SCD.addTypedPremiseOfSpecialCraft("Berufsgeheimnis", 4, 7, 7);
			
			SCD.addTypedPremiseOfSpecialCraft("Fälscher", 3, TD.getTalent("Alchemie").getID(), 5);
			SCD.addTypedPremiseOfSpecialCraft("Fälscher", 3, TD.getTalent("Malen/Zeichnen").getID(), 7);
			SCD.addTypedPremiseOfSpecialCraft("Fälscher", 3, TD.getTalent("Schriftlicher Ausdruck").getID(), 5);
			
			SCD.addTypedPremiseOfSpecialCraft("Rosstäuscher", 3, TD.getTalent("Reiten").getID(), 7);
			SCD.addTypedPremiseOfSpecialCraft("Rosstäuscher", 3, TD.getTalent("Sich Verkleiden").getID(), 7);
			SCD.addTypedPremiseOfSpecialCraft("Rosstäuscher", 3, TD.getTalent("Abrichten").getID(), 7);
			SCD.addTypedPremiseOfSpecialCraft("Rosstäuscher", 3, TD.getTalent("Überreden").getID(), 7);
			
			SCD.addTypedPremiseOfSpecialCraft("Talentspezialisierung", 4, 9, 7);
			
			// Kampf
			SCD.addTypedPremiseOfSpecialCraft("Ausfall", 1, SCD.getSpecialCraft("Finte").getID());
			SCD.addTypedPremiseOfSpecialCraft("Ausweichen II", 1, SCD.getSpecialCraft("Ausweichen I").getID());
			SCD.addTypedPremiseOfSpecialCraft("Ausweichen II", 1, SCD.getSpecialCraft("Aufmerksamkeit").getID());
			SCD.addTypedPremiseOfSpecialCraft("Ausweichen III", 1, SCD.getSpecialCraft("Ausweichen II").getID());
			SCD.addTypedPremiseOfSpecialCraft("Ausweichen III", 1, SCD.getSpecialCraft("Kampfreflexe").getID());
			
			SCD.addTypedPremiseOfSpecialCraft("Befreiungsschlag", 1, SCD.getSpecialCraft("Niederwerfen").getID());
			SCD.addTypedPremiseOfSpecialCraft("Beidhändiger Kampf I", 1, SCD.getSpecialCraft("Linkhand").getID());
			SCD.addTypedPremiseOfSpecialCraft("Beidhändiger Kampf II", 1, SCD.getSpecialCraft("Beidhändiger Kampf I").getID());
			SCD.addTypedPremiseOfSpecialCraft("Berittener Schütze", 3, TD.getTalent("Reiten").getID(), 7);
			SCD.addTypedPremiseOfSpecialCraft("Betäubungsschlag", 1, SCD.getSpecialCraft("Finte").getID());
			SCD.addTypedPremiseOfSpecialCraft("Betäubungsschlag", 1, SCD.getSpecialCraft("Wuchtschlag").getID());
			SCD.addTypedPremiseOfSpecialCraft("Binden", 1, SCD.getSpecialCraft("Meisterparade").getID());
			SCD.addTypedPremiseOfSpecialCraft("Binden", 1, SCD.getSpecialCraft("Parierwaffen I").getID());
			SCD.addTypedPremiseOfSpecialCraft("Blindkampf", 1, SCD.getSpecialCraft("Kampfgespür").getID());
			SCD.addTypedPremiseOfSpecialCraft("Blindkampf", 3, TD.getTalent("Sinnenschärfe").getID(), 15);
			
			SCD.addTypedPremiseOfSpecialCraft("Defensiver Kampfstil", 1, SCD.getSpecialCraft("Meisterparade").getID());
			SCD.addTypedPremiseOfSpecialCraft("Doppelangriff", 1, SCD.getSpecialCraft("Beidhändiger Kampf I").getID());
			
			SCD.addTypedPremiseOfSpecialCraft("Eisenhagel", 3, TD.getTalent("Wurfmesser").getID(), 10);
			SCD.addTypedPremiseOfSpecialCraft("Entwaffnen", 1, SCD.getSpecialCraft("Binden").getID());
			
			SCD.addTypedPremiseOfSpecialCraft("Formation", 1, SCD.getSpecialCraft("Aufmerksamkeit").getID());
			
			SCD.addTypedPremiseOfSpecialCraft("Gegenhalten", 1, SCD.getSpecialCraft("Meisterparade").getID());
			SCD.addTypedPremiseOfSpecialCraft("Geschützmeister", 3, TD.getTalent("Belagerungswaffen").getID(), 10);
			SCD.addTypedPremiseOfSpecialCraft("Geschützmeister", 3, TD.getTalent("Mechanik").getID(), 7);
			SCD.addTypedPremiseOfSpecialCraft("Gezielter Stich", 1, SCD.getSpecialCraft("Finte").getID());
			
			SCD.addTypedPremiseOfSpecialCraft("Halbschwert", 1, SCD.getSpecialCraft("Aufmerksamkeit").getID());
			SCD.addTypedPremiseOfSpecialCraft("Hammerschlag", 1, SCD.getSpecialCraft("Niederwerfen").getID());
			
			SCD.addTypedPremiseOfSpecialCraft("Improvisierte Waffen", 3, TD.getTalent("Raufen").getID(), 10);
			
			SCD.addTypedPremiseOfSpecialCraft("Kampf im Wasser", 3, TD.getTalent("Körperbeherrschung").getID(), 7);
			SCD.addTypedPremiseOfSpecialCraft("Kampfgespür", 1, SCD.getSpecialCraft("Aufmerksamkeit").getID());
			SCD.addTypedPremiseOfSpecialCraft("Kampfreflexe", 2, 0, 10);
			
			SCD.addTypedPremiseOfSpecialCraft("Klingensturm", 2, 1, 9);
			SCD.addTypedPremiseOfSpecialCraft("Klingensturm", 1, SCD.getSpecialCraft("Ausfall").getID());
			SCD.addTypedPremiseOfSpecialCraft("Klingensturm", 1, SCD.getSpecialCraft("Kampfreflexe").getID());
			SCD.addTypedPremiseOfSpecialCraft("Klingentänzer", 1, SCD.getSpecialCraft("Kampfgespür").getID());
			SCD.addTypedPremiseOfSpecialCraft("Klingentänzer", 1, SCD.getSpecialCraft("Klingensturm").getID());
			SCD.addTypedPremiseOfSpecialCraft("Klingentänzer", 1, SCD.getSpecialCraft("Klingenwand").getID());
			SCD.addTypedPremiseOfSpecialCraft("Klingenwand", 2, 2, 9);
			SCD.addTypedPremiseOfSpecialCraft("Klingenwand", 1, SCD.getSpecialCraft("Defensiver Kampfstil").getID());
			SCD.addTypedPremiseOfSpecialCraft("Klingenwand", 1, SCD.getSpecialCraft("Kampfreflexe").getID());
			
			SCD.addTypedPremiseOfSpecialCraft("Kriegsreiterei", 3, TD.getTalent("Reiten").getID(), 10);
			SCD.addTypedPremiseOfSpecialCraft("Kriegsreiterei", 1, SCD.getSpecialCraft("Reiterkampf").getID());
			
			SCD.addTypedPremiseOfSpecialCraft("Meisterliches Entwaffnen", 1, SCD.getSpecialCraft("Entwaffnen").getID());
			SCD.addTypedPremiseOfSpecialCraft("Meisterparade", 2, 2, 8);
			SCD.addTypedPremiseOfSpecialCraft("Meisterschütze", 1, SCD.getSpecialCraft("Scharfschütze").getID());
			SCD.addTypedPremiseOfSpecialCraft("Meisterschütze", 4, 1, 15);
			
			SCD.addTypedPremiseOfSpecialCraft("Niederwerfen", 1, SCD.getSpecialCraft("Wuchtschlag").getID());
			
			SCD.addTypedPremiseOfSpecialCraft("Parierwaffen I", 1, SCD.getSpecialCraft("Linkhand").getID());
			SCD.addTypedPremiseOfSpecialCraft("Parierwaffen II", 1, SCD.getSpecialCraft("Parierwaffen I").getID());
			
			SCD.addTypedPremiseOfSpecialCraft("Reiterkampf", 3, TD.getTalent("Reiten").getID(), 7);
			SCD.addTypedPremiseOfSpecialCraft("Rüstungsgewöhnung II", 1, SCD.getSpecialCraft("Rüstungsgewöhnung I").getID());
			SCD.addTypedPremiseOfSpecialCraft("Rüstungsgewöhnung III", 1, SCD.getSpecialCraft("Rüstungsgewöhnung II").getID());
			
			SCD.addTypedPremiseOfSpecialCraft("Scharfschütze", 4, 1, 7);
			SCD.addTypedPremiseOfSpecialCraft("Schildkampf I", 1, SCD.getSpecialCraft("Linkhand").getID());
			SCD.addTypedPremiseOfSpecialCraft("Schildkampf II", 1, SCD.getSpecialCraft("Schildkampf I").getID());
			SCD.addTypedPremiseOfSpecialCraft("Schildspalter", 1, SCD.getSpecialCraft("Niederwerfen").getID());
			SCD.addTypedPremiseOfSpecialCraft("Schnellladen Armbrust", 3, TD.getTalent("Armbrust").getID(), 7);
			SCD.addTypedPremiseOfSpecialCraft("Schnellladen Bogen", 3, TD.getTalent("Bogen").getID(), 7);
			SCD.addTypedPremiseOfSpecialCraft("Spießgespann", 3, TD.getTalent("Speere").getID(), 10);
			SCD.addTypedPremiseOfSpecialCraft("Spießgespann", 1, SCD.getSpecialCraft("Sturmangriff").getID());
			SCD.addTypedPremiseOfSpecialCraft("Sturmangriff", 1, SCD.getSpecialCraft("Wuchtschlag").getID());
			
			SCD.addTypedPremiseOfSpecialCraft("Tod von Links", 1, SCD.getSpecialCraft("Beidhändiger Kampf I").getID());
			SCD.addTypedPremiseOfSpecialCraft("Tod von Links", 1, SCD.getSpecialCraft("Parierwaffen II").getID());
			SCD.addTypedPremiseOfSpecialCraft("Todesstpß", 1, SCD.getSpecialCraft("Gezielter Stich").getID());
			SCD.addTypedPremiseOfSpecialCraft("Turnierreiterei", 3, TD.getTalent("Reiten").getID(), 10);
			SCD.addTypedPremiseOfSpecialCraft("Turnierreiterei", 1, SCD.getSpecialCraft("Reiterkampf").getID());
			
			SCD.addTypedPremiseOfSpecialCraft("Umreißen", 1, SCD.getSpecialCraft("Finte").getID());
			SCD.addTypedPremiseOfSpecialCraft("Unterwasserkampf", 3, TD.getTalent("Schwimmen").getID(), 10);
			
			SCD.addTypedPremiseOfSpecialCraft("Waffenmeister", 4, 8, 18);
			SCD.addTypedPremiseOfSpecialCraft("Waffenspezialisierung", 4, 8, 7);
			SCD.addTypedPremiseOfSpecialCraft("Windmühle", 1, SCD.getSpecialCraft("Gegenhalten").getID());
			SCD.addTypedPremiseOfSpecialCraft("Windmühle", 1, SCD.getSpecialCraft("Wuchtschlag").getID());
			
			// Magischer
			SCD.addTypedPremiseOfSpecialCraft("Aurapanzer", 1, SCD.getSpecialCraft("Gedankenschutz").getID());
			
			// SCD.addTypedPremiseOfSpecialCraft("", 1, SCD.getSpecialCraft("").getID());
			// SCD.addTypedPremiseOfSpecialCraft("", 2, , );
			// SCD.addTypedPremiseOfSpecialCraft("", 3, TD.getTalent("").getID(), );
			// SCD.addTypedPremiseOfSpecialCraft("", 4, , );
		} catch (Exception ex) {throw ex;}
	}
	/**	Dh	10.6.2020
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
		TD = new TalentDatabase();
		
		try {
			//	Kampftalente
			TD.addTalent(new Fighttalent(0, "Anderthalbhänder", 0, new int[] {1,-2}, new int[] {2, 11, 16}));
			TD.addTalent(new Fighttalent(1, "Armbrust", 2, new int[] {1,-5}, new int[] {18, 20}));
			TD.addTalent(new Fighttalent(2, "Belagerungswaffen", 2, new int[] {0,0}, new int[] {}));
			TD.addTalent(new Fighttalent(3, "Blasrohr", 2, new int[] {1,-5}, new int[] {19}));
			TD.addTalent(new Fighttalent(4, "Bogen", 2, new int[] {1,-3}, new int[] {20}));
			
			TD.addTalent(new Fighttalent(5, "Diskus", 2, new int[] {1,-2}, new int[] {21}));
			TD.addTalent(new Fighttalent(6, "Dolche", 0, new int[] {1,-1}, new int[] {3, 7, 0}));
			TD.addTalent(new Fighttalent(7, "Fechtwaffen", 0, new int[] {1,-1}, new int[] {4, 3, 11}));
			TD.addTalent(new Fighttalent(8, "Hiebwaffen", 0, new int[] {1,-4}, new int[] {5, 10}));
			TD.addTalent(new Fighttalent(9, "Infanteriewaffen", 0, new int[] {1,-3}, new int[] {6, 12, 15}));
			
			TD.addTalent(new Fighttalent(10, "Kettenstäbe", 0, new int[] {1,-1}, new int[] {7, 8, 14}));
			TD.addTalent(new Fighttalent(11, "Kettenwaffen", 0, new int[] {1,-3}, new int[] {8, 7, 14}));
			TD.addTalent(new Fighttalent(12, "Lanzenreiten", 0, new int[] {0,0}, new int[] {}));
			TD.addTalent(new Fighttalent(13, "Peitsche", 0, new int[] {1,-1}, new int[] {9}));
			TD.addTalent(new Fighttalent(14, "Raufen", 1, new int[] {1,0}, new int[] {0}));
			
			TD.addTalent(new Fighttalent(15, "Ringen", 1, new int[] {1,0}, new int[] {1}));
			TD.addTalent(new Fighttalent(16, "Säbel", 0, new int[] {1,-2}, new int[] {10, 5, 11}));
			TD.addTalent(new Fighttalent(17, "Schleuder", 2, new int[] {1,-2}, new int[] {22}));
			TD.addTalent(new Fighttalent(18, "Schwerter", 0, new int[] {1,-2}, new int[] {11, 2, 4, 10}));
			TD.addTalent(new Fighttalent(19, "Speere", 0, new int[] {1,-3}, new int[] {12, 6}));
			
			TD.addTalent(new Fighttalent(20, "Stäbe", 0, new int[] {1,-2}, new int[] {13, 12}));
			TD.addTalent(new Fighttalent(21, "Wurfbeile", 2, new int[] {1,-2}, new int[] {23, 24, 25}));
			TD.addTalent(new Fighttalent(22, "Wurfmesser", 2, new int[] {1,-3}, new int[] {24, 23, 25}));
			TD.addTalent(new Fighttalent(23, "Wurfspeere", 2, new int[] {1,-2}, new int[] {25, 23, 24}));
			TD.addTalent(new Fighttalent(24, "Zweihandflegel", 0, new int[] {1,-3}, new int[] {14, 6, 8}));
			
			TD.addTalent(new Fighttalent(25, "Zweihand-Hiebwaffen", 0, new int[] {1,-3}, new int[] {15, 5, 6}));
			TD.addTalent(new Fighttalent(26, "Zweihandschwerter/-säbel", 0, new int[] {1,-2}, new int[] {16, 2, 11, 10}));
			
			// Koerperliche Talente
			TD.addTalent(new PhysicalTalent(27, "Akrobatik", new int[] {0, 5, 7}, new int[] {2, 0}));
			TD.addTalent(new PhysicalTalent(28, "Athletik", new int[] {5, 6, 7}, new int[] {2, 0}));
			TD.addTalent(new PhysicalTalent(29, "Fliegen", new int[] {0, 2, 5}, new int[] {2, 0}));
			TD.addTalent(new PhysicalTalent(30, "Gaukelei", new int[] {0, 3, 4}, new int[] {2, 0}));
			TD.addTalent(new PhysicalTalent(31, "Klettern", new int[] {0, 5, 7}, new int[] {2, 0}));
			
			TD.addTalent(new PhysicalTalent(32, "Körperbeherrschung", new int[] {0, 2, 5}, new int[] {2, 0}));
			TD.addTalent(new PhysicalTalent(33, "Reiten", new int[] {3, 5, 7}, new int[] {2, 0}));
			TD.addTalent(new PhysicalTalent(34, "Schleichen", new int[] {0, 2, 5}, new int[] {2, 0}));
			TD.addTalent(new PhysicalTalent(35, "Schwimmen", new int[] {5, 6, 7}, new int[] {2, 0}));
			TD.addTalent(new PhysicalTalent(36, "Selbstbeherrschung", new int[] {0, 6, 7}, new int[] {2, 0}));
			
			TD.addTalent(new PhysicalTalent(37, "Sich Verstecken", new int[] {0, 2, 5}, new int[] {2, 0}));
			TD.addTalent(new PhysicalTalent(38, "Singen", new int[] {2, 3, 3}, new int[] {2, 0}));
			TD.addTalent(new PhysicalTalent(39, "Sinnenschärfe", new int[] {1, 2, 2}, new int[] {2, 0}));
			TD.addTalent(new PhysicalTalent(40, "Skifahren", new int[] {5, 5, 6}, new int[] {2, 0}));
			TD.addTalent(new PhysicalTalent(41, "Stimmen imitieren", new int[] {1, 2, 3}, new int[] {2, 0}));
			
			TD.addTalent(new PhysicalTalent(42, "Tanzen", new int[] {3, 5, 5}, new int[] {2, 0}));
			TD.addTalent(new PhysicalTalent(43, "Taschendiebstahl", new int[] {0, 2, 4}, new int[] {2, 0}));
			TD.addTalent(new PhysicalTalent(44, "Zechen", new int[] {2, 6, 7}, new int[] {2, 0}));
			
			// Gesellschaftliche Talente
			TD.addTalent(new Basictalent(45, "Betören", new int[] {2, 3, 3}));
			TD.addTalent(new Basictalent(46, "Etikette", new int[] {1, 2, 3}));
			TD.addTalent(new Basictalent(47, "Gassenwissen", new int[] {1, 2, 3}));
			TD.addTalent(new Basictalent(48, "Lehren", new int[] {1, 2, 3}));
			TD.addTalent(new Basictalent(49, "Menschenkenntnis", new int[] {1, 2, 3}));
			
			TD.addTalent(new Basictalent(50, "Schauspielerei", new int[] {0, 1, 3}));
			TD.addTalent(new Basictalent(51, "Schriftlicher Ausdruck", new int[] {1, 2, 2}));
			TD.addTalent(new Basictalent(52, "Sich Verkleiden", new int[] {0, 3, 5}));
			TD.addTalent(new Basictalent(53, "Überreden", new int[] {0, 2, 3}));
			TD.addTalent(new Basictalent(54, "Überzeugen", new int[] {1, 2, 3}));
			
			// Natur Talente
			TD.addTalent(new Basictalent(55, "Fährtensuchen", new int[] {1, 2, 2}));
			TD.addTalent(new Basictalent(56, "Fallenstellen", new int[] {1, 4, 7}));
			TD.addTalent(new Basictalent(57, "Fesseln/Entfesseln", new int[] {4, 5, 7}));
			TD.addTalent(new Basictalent(58, "Fischen/Angeln", new int[] {2, 4, 7}));
			TD.addTalent(new Basictalent(59, "Orientierung", new int[] {1, 2, 2}));
			TD.addTalent(new Basictalent(60, "Wettervorhersage", new int[] {1, 2, 2}));
			TD.addTalent(new Basictalent(61, "Wildnisleben", new int[] {2, 5, 6}));
			
			// Wissenstalente
			TD.addTalent(new Basictalent(62, "Anatomie", new int[] {0, 1, 4}));
			TD.addTalent(new Basictalent(63, "Baukunst", new int[] {1, 1, 4}));
			TD.addTalent(new Basictalent(64, "Brettspiel", new int[] {1, 1, 2}));
			TD.addTalent(new Basictalent(65, "Geographie", new int[] {1, 1, 2}));
			TD.addTalent(new Basictalent(66, "Geschichtswissen", new int[] {1, 1, 2}));
			
			TD.addTalent(new Basictalent(67, "Gesteinskunde", new int[] {1, 2, 4}));
			TD.addTalent(new Basictalent(68, "Götter/Kulte", new int[] {1, 1, 2}));
			TD.addTalent(new Basictalent(69, "Heraldik", new int[] {1, 1, 4}));
			TD.addTalent(new Basictalent(70, "Hüttenkunde", new int[] {1, 2, 6}));
			TD.addTalent(new Basictalent(71, "Kriegskunst", new int[] {0, 1, 3}));
			
			TD.addTalent(new Basictalent(72, "Kryptographie", new int[] {1, 1, 2}));
			TD.addTalent(new Basictalent(73, "Magiekunde", new int[] {1, 1, 2}));
			TD.addTalent(new Basictalent(74, "Mechanik", new int[] {1, 1, 4}));
			TD.addTalent(new Basictalent(75, "Pflanzenkunde", new int[] {1, 1, 4}));
			TD.addTalent(new Basictalent(76, "Philosophie", new int[] {1, 1, 2}));
			
			TD.addTalent(new Basictalent(77, "Rechnen", new int[] {1, 1, 2}));
			TD.addTalent(new Basictalent(78, "Rechtskunde", new int[] {1, 1, 2}));
			TD.addTalent(new Basictalent(79, "Sagen/Legenden", new int[] {1, 2, 3}));
			TD.addTalent(new Basictalent(80, "Schätzen", new int[] {1, 2, 2}));
			TD.addTalent(new Basictalent(81, "Sprachkunde", new int[] {1, 1, 2}));
			
			TD.addTalent(new Basictalent(82, "Staatskunst", new int[] {1, 2, 3}));
			TD.addTalent(new Basictalent(83, "Sternkunde", new int[] {1, 1, 2}));
			TD.addTalent(new Basictalent(84, "Tierkunde", new int[] {0, 1, 2}));
			
			// Sprachen
			TD.addTalent(new Communicationtalent(85, "Garethi", true, 18));
			TD.addTalent(new Communicationtalent(86, "Bosperano", true, 21));
			TD.addTalent(new Communicationtalent(87, "Aureliani", true, 21));
			TD.addTalent(new Communicationtalent(88, "Zyklopäisch", true, 18));
			
			TD.addTalent(new Communicationtalent(89, "Tulamidya", true, 18));
			TD.addTalent(new Communicationtalent(90, "Ur-Tulamidya", true, 21));
			TD.addTalent(new Communicationtalent(91, "Zelemja", true, 18));
			TD.addTalent(new Communicationtalent(92, "Alaani", true, 21));
			TD.addTalent(new Communicationtalent(93, "Zhuchammaqra", true, 15));
			TD.addTalent(new Communicationtalent(94, "Ferkina", true, 16));
			TD.addTalent(new Communicationtalent(95, "Ruuz", true, 18));
			TD.addTalent(new Communicationtalent(96, "Altes Kemi", true, 18));
			TD.addTalent(new Communicationtalent(97, "Rabensprache", true, 15));
			
			TD.addTalent(new Communicationtalent(98, "Thorwalsch", true, 18));
			TD.addTalent(new Communicationtalent(99, "Hjaldingsch", true, 18));
			
			TD.addTalent(new Communicationtalent(100, "Isdira", true, 21));
			TD.addTalent(new Communicationtalent(101, "Asharia", true, 24));
			
			TD.addTalent(new Communicationtalent(102, "Rogolan", true, 21));
			TD.addTalent(new Communicationtalent(103, "Angram", true, 21));
			
			TD.addTalent(new Communicationtalent(104, "Ologhaijan", true, 15));
			TD.addTalent(new Communicationtalent(105, "Oloarkh", true, 10));
			
			TD.addTalent(new Communicationtalent(106, "Mahrisch", true, 20));
			TD.addTalent(new Communicationtalent(107, "Rissoal", true, 20));
			
			TD.addTalent(new Communicationtalent(108, "Drachisch", true, 21));
			TD.addTalent(new Communicationtalent(109, "Goblinisch", true, 12));
			TD.addTalent(new Communicationtalent(110, "Grolmisch", true, 17));
			TD.addTalent(new Communicationtalent(111, "Koboldisch", true, 15));
			TD.addTalent(new Communicationtalent(112, "Molochisch", true, 17));
			TD.addTalent(new Communicationtalent(113, "Neckergesang", true, 18));
			TD.addTalent(new Communicationtalent(114, "Nujuka", true, 15));
			TD.addTalent(new Communicationtalent(115, "Rssahh", true, 18));
			TD.addTalent(new Communicationtalent(116, "Trollisch", true, 15));
			TD.addTalent(new Communicationtalent(117, "Waldmenschen-Sprachen", true, 15));
			TD.addTalent(new Communicationtalent(118, "Z'Lit", true, 17));
			
			TD.addTalent(new Communicationtalent(119, "Zhayad", true, 15));
			TD.addTalent(new Communicationtalent(120, "Atak", true, 12));
			TD.addTalent(new Communicationtalent(121, "Füchsisch", true, 12));
			
			// Schrift
			TD.addTalent(new Communicationtalent(122, "Altes Alaani", false, 18));
			TD.addTalent(new Communicationtalent(123, "Altes Kemi", false, 21));
			TD.addTalent(new Communicationtalent(124, "Amulashtra", false, 17));
			TD.addTalent(new Communicationtalent(125, "Angram", false, 21));
			TD.addTalent(new Communicationtalent(126, "Arkanil", false, 24));
			
			TD.addTalent(new Communicationtalent(127, "Chrmk", false, 18));
			TD.addTalent(new Communicationtalent(128, "Chuchas", false, 24));
			TD.addTalent(new Communicationtalent(129, "Drakhard-Kinken", false, 9));
			TD.addTalent(new Communicationtalent(130, "Drakned-Glyphen", false, 15));
			TD.addTalent(new Communicationtalent(131, "Geheiligte Glyphen von Unau", false, 13));
			
			TD.addTalent(new Communicationtalent(132, "Gimaril", false, 10));
			TD.addTalent(new Communicationtalent(133, "Gjalkisch", false, 14));
			TD.addTalent(new Communicationtalent(134, "Hjaldingsche Runen", false, 10));
			TD.addTalent(new Communicationtalent(135, "Imperiale Zeichen", false, 12));
			TD.addTalent(new Communicationtalent(136, "Isdira/Asdharia", false, 15));
			
			TD.addTalent(new Communicationtalent(137, "Kusliker Zeichen", false, 10));
			TD.addTalent(new Communicationtalent(138, "Mahrische Gylphen", false, 15));
			TD.addTalent(new Communicationtalent(139, "Nanduria", false, 10));
			TD.addTalent(new Communicationtalent(140, "Rogolan", false, 11));
			TD.addTalent(new Communicationtalent(141, "Trollische Raumbildschrift", false, 24));
			
			TD.addTalent(new Communicationtalent(142, "Tulamidya", false, 14));
			TD.addTalent(new Communicationtalent(143, "Ur-Tulamidya", false, 16));
			TD.addTalent(new Communicationtalent(144, "Zhayad", false, 18));
			
			// Handwerkstalente
			TD.addTalent(new Basictalent(145, "Abrichten", new int[] {0, 2, 3}));
			TD.addTalent(new Basictalent(146, "Ackerbau", new int[] {2, 4, 6}));
			TD.addTalent(new Basictalent(147, "Alchemie", new int[] {0, 1, 4}));
			TD.addTalent(new Basictalent(148, "Bergbau", new int[] {2, 6, 7}));
			TD.addTalent(new Basictalent(149, "Bogenbau", new int[] {1, 2, 4}));
			
			TD.addTalent(new Basictalent(150, "Boote fahren", new int[] {5, 6, 7}));
			TD.addTalent(new Basictalent(151, "Brauer", new int[] {1, 4, 7}));
			TD.addTalent(new Basictalent(152, "Drucker", new int[] {1, 4, 7}));
			TD.addTalent(new Basictalent(153, "Farhzeug lenken", new int[] {2, 3, 4}));
			TD.addTalent(new Basictalent(154, "Falschspiel", new int[] {0, 3, 4}));
			
			TD.addTalent(new Basictalent(155, "Feinmechanik", new int[] {1, 4, 4}));
			TD.addTalent(new Basictalent(156, "Feuersteinbearbeitung", new int[] {1, 4, 4}));
			TD.addTalent(new Basictalent(157, "Fleischer", new int[] {1, 4, 7}));
			TD.addTalent(new Basictalent(158, "Gerber/Kürschner", new int[] {1, 4, 6}));
			TD.addTalent(new Basictalent(159, "Glaskunst", new int[] {4, 4, 6}));
			
			TD.addTalent(new Basictalent(160, "Grobschmied", new int[] {4, 6, 7}));
			TD.addTalent(new Basictalent(161, "Handel", new int[] {1, 2, 3}));
			TD.addTalent(new Basictalent(162, "Hauswirtschaft", new int[] {2, 3, 4}));
			TD.addTalent(new Basictalent(163, "Heilkunde Gift", new int[] {0, 1, 2}));
			TD.addTalent(new Basictalent(164, "Heilkunde Krankheiten", new int[] {0, 1, 3}));
			
			TD.addTalent(new Basictalent(165, "Heilkunde Seele", new int[] {2, 3, 3}));
			TD.addTalent(new Basictalent(166, "Heilkunde Wunden", new int[] {1, 3, 4}));
			TD.addTalent(new Basictalent(167, "Holzbearbeitung", new int[] {1, 4, 7}));
			TD.addTalent(new Basictalent(168, "Instrumentenbauer", new int[] {1, 2, 4}));
			TD.addTalent(new Basictalent(169, "Kartographie", new int[] {1, 1, 4}));
			
			TD.addTalent(new Basictalent(170, "Kochen", new int[] {1, 2, 4}));
			TD.addTalent(new Basictalent(171, "Kristallzucht", new int[] {1, 2, 4}));
			TD.addTalent(new Basictalent(172, "Lederarbeiten", new int[] {1, 4, 4}));
			TD.addTalent(new Basictalent(173, "Malen/Zeichnen", new int[] {1, 2, 4}));
			TD.addTalent(new Basictalent(174, "Maurer", new int[] {4, 5, 7}));
			
			TD.addTalent(new Basictalent(175, "Metallguss", new int[] {1, 4, 7}));
			TD.addTalent(new Basictalent(176, "Musizieren", new int[] {1, 3, 4}));
			TD.addTalent(new Basictalent(177, "Schlösser knacken", new int[] {2, 4, 4}));
			TD.addTalent(new Basictalent(178, "Schnaps brennen", new int[] {1, 2, 4}));
			TD.addTalent(new Basictalent(179, "Schneidern", new int[] {1, 4, 4}));
			
			TD.addTalent(new Basictalent(180, "Seefahrt", new int[] {4, 5, 7}));
			TD.addTalent(new Basictalent(181, "Seiler", new int[] {4, 4, 7}));
			TD.addTalent(new Basictalent(182, "Steinmetz", new int[] {4, 4, 7}));
			TD.addTalent(new Basictalent(183, "Steinschneider/Juwelier", new int[] {2, 4, 4}));
			TD.addTalent(new Basictalent(184, "Stellmacher", new int[] {1, 4, 7}));
			
			TD.addTalent(new Basictalent(185, "Stoffe färben", new int[] {1, 4, 7}));
			TD.addTalent(new Basictalent(186, "Tätowieren", new int[] {2, 4, 4}));
			TD.addTalent(new Basictalent(187, "Töpfern", new int[] {1, 4, 4}));
			TD.addTalent(new Basictalent(188, "Viehzucht", new int[] {1, 2, 7}));
			TD.addTalent(new Basictalent(189, "Webkunst", new int[] {4, 4, 7}));
			
			TD.addTalent(new Basictalent(190, "Winzer", new int[] {1, 4, 7}));
			TD.addTalent(new Basictalent(191, "Zimemrmann", new int[] {1, 4, 7}));
		} catch (Exception ex) {throw ex;}
	}
	/**	Dh	10.6.2020
	 * 
	 * @throws Exception
	 */
	private static void genBasicTalents() throws Exception{
		int[] vBasicTalentIDs;
		if (TD != null) {
			vBasicTalentIDs = new int[31];
			
			// Kampftalente
			vBasicTalentIDs[0] = TD.getTalent("Dolche").getID();
			vBasicTalentIDs[1] = TD.getTalent("Hiebwaffen").getID();
			vBasicTalentIDs[2] = TD.getTalent("Raufen").getID();
			vBasicTalentIDs[3] = TD.getTalent("Ringen").getID();
			vBasicTalentIDs[4] = TD.getTalent("Säbel").getID();
			vBasicTalentIDs[5] = TD.getTalent("Wurfmesser").getID();
			
			// Körperliche Talente
			vBasicTalentIDs[6] = TD.getTalent("Athletik").getID();
			vBasicTalentIDs[7] = TD.getTalent("Klettern").getID();
			vBasicTalentIDs[8] = TD.getTalent("Körperbeherrschung").getID();
			vBasicTalentIDs[9] = TD.getTalent("Schleichen").getID();
			vBasicTalentIDs[10] = TD.getTalent("Schwimmen").getID();
			vBasicTalentIDs[11] = TD.getTalent("Selbstbeherrschung").getID();
			vBasicTalentIDs[12] = TD.getTalent("Sich Verstecken").getID();
			vBasicTalentIDs[13] = TD.getTalent("Singen").getID();
			vBasicTalentIDs[14] = TD.getTalent("Sinnenschärfe").getID();
			vBasicTalentIDs[15] = TD.getTalent("Tanzen").getID();
			vBasicTalentIDs[16] = TD.getTalent("Zechen").getID();
			
			// Gesellschaftliche Talente
			vBasicTalentIDs[17] = TD.getTalent("Menschenkenntnis").getID();
			vBasicTalentIDs[18] = TD.getTalent("Überreden").getID();
			
			// Natur Talente
			vBasicTalentIDs[19] = TD.getTalent("Fährtensuchen").getID();
			vBasicTalentIDs[20] = TD.getTalent("Orientierung").getID();
			vBasicTalentIDs[21] = TD.getTalent("Wildnisleben").getID();
			
			// Wissenstalente
			vBasicTalentIDs[22] = TD.getTalent("Götter/Kulte").getID();
			vBasicTalentIDs[23] = TD.getTalent("Rechnen").getID();
			vBasicTalentIDs[24] = TD.getTalent("Sagen/Legenden").getID();
			
			// Handwerkliche Talente
			vBasicTalentIDs[25] = TD.getTalent("Heilkunde Wunden").getID();
			vBasicTalentIDs[26] = TD.getTalent("Holzbearbeitung").getID();
			vBasicTalentIDs[27] = TD.getTalent("Kochen").getID();
			vBasicTalentIDs[28] = TD.getTalent("Lederarbeiten").getID();
			vBasicTalentIDs[29] = TD.getTalent("Malen/Zeichnen").getID();
			vBasicTalentIDs[30] = TD.getTalent("Schneidern").getID();
			
			TD.setBasicTalents(vBasicTalentIDs);
		}else throw new Exception("04; Loa,gBT");
	}
	/**	Dh	4.6.2020
	 * 
	 * @throws Exception
	 */
	private static void genWeapons() throws Exception {
		WD = new WeaponDatabase();
		
		try {
			WD.addWeapon(new CloseWeapon(0, "Fausthieb", 0, new int[] {1, 0}, new int[] {10, 3}, new int[] {-1, -2}, -10, -2, 1));
			WD.addWeapon(new CloseWeapon(1, "Tritt", 0, new int[] {1, 0}, new int[] {10, 3}, new int[] {-1, -2}, -10, -1, 1));
			
			// Anderthalbhaender
			WD.addWeapon(new CloseWeapon(2, "Anderthalbhänder", 2, new int[] {1, 5}, new int[] {11, 4}, new int[] {0, 0}, 1, 1, 5));
			WD.addWeapon(new CloseWeapon(3, "Bastardschwert", 2, new int[] {1, 5}, new int[] {11, 3}, new int[] {0, -1}, 2, 0, 1));
			WD.addWeapon(new CloseWeapon(4, "Nachtwind", 2, new int[] {1, 4}, new int[] {11, 5}, new int[] {0, 0}, 0, 2, 1));
			WD.addWeapon(new CloseWeapon(5, "Rondrakamm", 2, new int[] {2, 2}, new int[] {12, 3}, new int[] {0, 0}, 1, 0, 5));
			WD.addWeapon(new CloseWeapon(6, "Tuzakmesser", 2, new int[] {1, 6}, new int[] {12, 4}, new int[] {0, 0}, 1, 1, 5));
			
			// Dolche
			WD.addWeapon(new CloseWeapon(7, "Basiliskenzunge", 3, new int[] {1, 2}, new int[] {12, 4}, new int[] {0, -1}, 4, -1, 0));
			WD.addWeapon(new CloseWeapon(8, "Borndolch", 3, new int[] {1, 2}, new int[] {12, 5}, new int[] {0, -1}, 1, 0, 0));
			WD.addWeapon(new CloseWeapon(9, "Dolch", 3, new int[] {1, 1}, new int[] {12, 5}, new int[] {0, -1}, 2, 0, 0));
			WD.addWeapon(new CloseWeapon(10, "Drachenzahn", 3, new int[] {1, 2}, new int[] {12, 4}, new int[] {0, 0}, 0, 0, 0));
			WD.addWeapon(new CloseWeapon(11, "Eberfänger", 3, new int[] {1, 2}, new int[] {12, 4}, new int[] {0, -1}, 1, 0, 0));
			WD.addWeapon(new CloseWeapon(12, "Hakendolch", 3, new int[] {1, 1}, new int[] {12, 4}, new int[] {0, 1}, -2, 0, 4));
			WD.addWeapon(new CloseWeapon(13, "Jagdmesser", 3, new int[] {1, 2}, new int[] {12, 5}, new int[] {0, -2}, 3, -1, 0));
			WD.addWeapon(new CloseWeapon(14, "Kurzschwert", 3, new int[] {1, 2}, new int[] {12, 4}, new int[] {0, -1}, 1, 0, 4));
			WD.addWeapon(new CloseWeapon(15, "Langdolch", 3, new int[] {1, 2}, new int[] {12, 4}, new int[] {0, 0}, 1, 0, 0));
			WD.addWeapon(new CloseWeapon(16, "Linkhand", 3, new int[] {1, 1}, new int[] {12, 5}, new int[] {0, 1}, 0, 0, 0));
			
			WD.addWeapon(new CloseWeapon(17, "Mengbilar", 3, new int[] {1, 1}, new int[] {12, 5}, new int[] {0, -3}, 7, -2, 0));
			WD.addWeapon(new CloseWeapon(18, "Messer", 3, new int[] {1, 0}, new int[] {12, 6}, new int[] {-2, -3}, 4, -2, 0));
			WD.addWeapon(new CloseWeapon(19, "Ogerfänger", 3, new int[] {1, 2}, new int[] {12, 4}, new int[] {0, -2}, 4, 0, 0));
			WD.addWeapon(new CloseWeapon(20, "Scheibendolch", 3, new int[] {1, 2}, new int[] {12, 4}, new int[] {0, -3}, 0, 0, 0));
			WD.addWeapon(new CloseWeapon(21, "Schwerer Dolch", 3, new int[] {1, 2}, new int[] {12, 4}, new int[] {0, -1}, 1, 0, 0));
			WD.addWeapon(new CloseWeapon(22, "Vulkangalsdolch", 3, new int[] {1, -1}, new int[] {12, 5}, new int[] {-2, -3}, 6, -2, 0));
			WD.addWeapon(new CloseWeapon(23, "Waqqif", 3, new int[] {1, 2}, new int[] {12, 5}, new int[] {-1, -3}, 2, -2, 0));
			WD.addWeapon(new CloseWeapon(24, "Wurfdolch", 3, new int[] {1, 1}, new int[] {12, 5}, new int[] {-1, -2}, 2, -1, 0));
			WD.addWeapon(new CloseWeapon(25, "Wurfmesser", 3, new int[] {1, -1}, new int[] {12, 6}, new int[] {-2, -3}, 2, -1, 0));
			
			//Fechtwaffen
			WD.addWeapon(new CloseWeapon(26, "Degen", 4, new int[] {1, 3}, new int[] {12, 5}, new int[] {0, -1}, 3, 2, 1));
			WD.addWeapon(new CloseWeapon(27, "Florett", 4, new int[] {1, 3}, new int[] {13, 5}, new int[] {1, -1}, 4, 3, 1));
			WD.addWeapon(new CloseWeapon(28, "Langdolch", 4, new int[] {1, 2}, new int[] {12, 4}, new int[] {0, 0}, 1, 0, 0));
			WD.addWeapon(new CloseWeapon(29, "Magierdegen", 4, new int[] {1, 2}, new int[] {13, 5}, new int[] {0, -2}, 4, 1, 1));
			WD.addWeapon(new CloseWeapon(30, "Panzerstecher", 4, new int[] {1, 4}, new int[] {13, 3}, new int[] {-1, -1}, 0, 0, 1));
			WD.addWeapon(new CloseWeapon(31, "Rapier", 4, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 2, 1, 1));
			WD.addWeapon(new CloseWeapon(32, "Robbentöter", 4, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 2, 0, 1));
			WD.addWeapon(new CloseWeapon(33, "Stockdegen", 4, new int[] {1, 3}, new int[] {12, 5}, new int[] {-1, -3}, 4, 0, 1));
			WD.addWeapon(new CloseWeapon(34, "Woldmesser", 4, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 1, 1, 1));
			
			// Hiebwaffen
			WD.addWeapon(new CloseWeapon(35, "Baccanaq", 5, new int[] {1, 4}, new int[] {12, 4}, new int[] {0, -2}, 5, -1, 1));
			WD.addWeapon(new CloseWeapon(36, "Beil", 5, new int[] {1, 3}, new int[] {11, 4}, new int[] {-1, -2}, 5, -1, 1));
			WD.addWeapon(new CloseWeapon(37, "Brabakbengel", 5, new int[] {1, 5}, new int[] {13, 3}, new int[] {0, -1}, 1, 0, 1));
			WD.addWeapon(new CloseWeapon(38, "Byakka", 5, new int[] {1, 5}, new int[] {14, 2}, new int[] {0, -2}, 3, -1, 1));
			WD.addWeapon(new CloseWeapon(39, "Fackel", 5, new int[] {1, 0}, new int[] {11, 5}, new int[] {-2, -3}, 8, -2, 4));
			WD.addWeapon(new CloseWeapon(40, "Fleischerbeil", 5, new int[] {1, 2}, new int[] {11, 4}, new int[] {-2, -3}, 2, -1, 0));
			WD.addWeapon(new CloseWeapon(41, "Haumesser", 5, new int[] {1, 3}, new int[] {13, 3}, new int[] {0, -2}, 3, -1, 4));
			WD.addWeapon(new CloseWeapon(42, "Keule", 5, new int[] {1, 2}, new int[] {11, 3}, new int[] {0, -2}, 3, 0, 1));
			WD.addWeapon(new CloseWeapon(43, "Knochenkeule", 5, new int[] {1, 3}, new int[] {11, 3}, new int[] {0, -1}, 3, 0, 1));
			WD.addWeapon(new CloseWeapon(44, "Knüppel", 5, new int[] {1, 1}, new int[] {11, 4}, new int[] {0, -2}, 6, 0, 1));
			
			WD.addWeapon(new CloseWeapon(45, "Kriegsfächer", 5, new int[] {1, 2}, new int[] {12, 5}, new int[] {0, 1}, 3, 0, 0));
			WD.addWeapon(new CloseWeapon(46, "Lindwurmschläger", 5, new int[] {1, 4}, new int[] {11, 3}, new int[] {0, -1}, 1, -1, 4));
			WD.addWeapon(new CloseWeapon(47, "Molokdeschnaja", 5, new int[] {1, 4}, new int[] {11, 3}, new int[] {0, 0}, 3, 0, 1));
			WD.addWeapon(new CloseWeapon(48, "Orknse", 5, new int[] {1, 5}, new int[] {13, 3}, new int[] {0, -1}, 4, -1, 1));
			WD.addWeapon(new CloseWeapon(49, "Rabenschnabel", 5, new int[] {1, 4}, new int[] {10, 4}, new int[] {0, 0}, 3, 0, 1));
			WD.addWeapon(new CloseWeapon(50, "Schmiedehammer", 5, new int[] {1, 4}, new int[] {14, 2}, new int[] {-1, -1}, 1, -1, 1));
			WD.addWeapon(new CloseWeapon(51, "Sichel", 5, new int[] {1, 2}, new int[] {12, 5}, new int[] {-2, -2}, 6, -2, 0));
			WD.addWeapon(new CloseWeapon(52, "Skraja", 5, new int[] {1, 3}, new int[] {11, 3}, new int[] {0, 0}, 4, 0, 1));
			WD.addWeapon(new CloseWeapon(53, "Sonnenzepter", 5, new int[] {1, 3}, new int[] {12, 3}, new int[] {-1, -1}, 1, 0, 1));
			WD.addWeapon(new CloseWeapon(54, "Streitaxt", 5, new int[] {1, 4}, new int[] {13, 2}, new int[] {0, -1}, 2, 0, 1));
			
			WD.addWeapon(new CloseWeapon(55, "Streitkolben", 5, new int[] {1, 4}, new int[] {11, 3}, new int[] {0, -1}, 1, 0, 1));
			WD.addWeapon(new CloseWeapon(56, "Stuhlbein", 5, new int[] {1, 0}, new int[] {11, 5}, new int[] {-1, -1}, 8, -1, 4));
			WD.addWeapon(new CloseWeapon(57, "Wurfbeil", 5, new int[] {1, 3}, new int[] {10, 4}, new int[] {0, -2}, 2, -1, 0));
			WD.addWeapon(new CloseWeapon(58, "Wurfkeule", 5, new int[] {1, 2}, new int[] {12, 5}, new int[] {-1, -1}, 3, -1, 0));
			WD.addWeapon(new CloseWeapon(59, "Zwergenskraja", 5, new int[] {1, 3}, new int[] {11, 3}, new int[] {0, 0}, 1, 0, 4));
			
			// Infanteriewaffen
			WD.addWeapon(new CloseWeapon(60, "Glefe", 6, new int[] {1, 4}, new int[] {13, 3}, new int[] {0, -2}, 5, -1, 2));
			WD.addWeapon(new CloseWeapon(61, "Hakenspieß", 6, new int[] {1, 3}, new int[] {13, 4}, new int[] {-1, -1}, 5, 0, 2));
			WD.addWeapon(new CloseWeapon(62, "Hellebarde", 6, new int[] {1, 5}, new int[] {12, 3}, new int[] {0, -1}, 5, 0, 2));
			WD.addWeapon(new CloseWeapon(63, "Korspieß", 6, new int[] {1, 2}, new int[] {12, 3}, new int[] {0, -1}, 3, 0, 2));
			WD.addWeapon(new CloseWeapon(64, "Neethaner Langaxt", 6, new int[] {1, 2}, new int[] {13, 4}, new int[] {-1, -3}, 5, -2, 2));
			WD.addWeapon(new CloseWeapon(65, "Pailos", 6, new int[] {1, 4}, new int[] {14, 2}, new int[] {-1, -3}, 3, -2, 2));
			WD.addWeapon(new CloseWeapon(66, "Partisane", 6, new int[] {1, 5}, new int[] {13, 3}, new int[] {0, -2}, 4, 0, 2));
			WD.addWeapon(new CloseWeapon(67, "Schnitter", 6, new int[] {1, 5}, new int[] {14, 4}, new int[] {0, 0}, 4, 0, 5));
			WD.addWeapon(new CloseWeapon(68, "Sense", 6, new int[] {1, 3}, new int[] {13, 4}, new int[] {-2, -4}, 7, -2, 2));
			WD.addWeapon(new CloseWeapon(69, "Sturmsense", 6, new int[] {1, 4}, new int[] {13, 3}, new int[] {-1, -2}, 5, -1, 2));
			
			WD.addWeapon(new CloseWeapon(70, "Warunker Hammer", 6, new int[] {1, 6}, new int[] {14, 3}, new int[] {0, -1}, 2, -1, 5));
			WD.addWeapon(new CloseWeapon(71, "Wurmspieß", 6, new int[] {1, 5}, new int[] {13, 4}, new int[] {0, -2}, 2, 0, 2));
	
			// Kettenstaebe
			WD.addWeapon(new CloseWeapon(72, "Dreigliederstab", 7, new int[] {1, 2}, new int[] {13, 4}, new int[] {1, 1}, 3, 2, 4));
			WD.addWeapon(new CloseWeapon(73, "Kettenstab", 7, new int[] {1, 2}, new int[] {13, 4}, new int[] {1, 0}, 2, 2, 4));
			
			// Kettenwaffen
			WD.addWeapon(new CloseWeapon(74, "Geißel", 8, new int[] {1, -1}, new int[] {14, 5}, new int[] {0, -4}, 5, -1, 1));
			WD.addWeapon(new CloseWeapon(75, "Kettenkugel", 8, new int[] {3, 0}, new int[] {14, 5}, new int[] {-2, -4}, 2, -3, 2));
			WD.addWeapon(new CloseWeapon(76, "Morgenstern", 8, new int[] {1, 5}, new int[] {14, 5}, new int[] {-1, -2}, 2, -1, 1));
			WD.addWeapon(new CloseWeapon(77, "Neunschwänzige", 8, new int[] {1, 1}, new int[] {14, 5}, new int[] {-1, -4}, 5, -1, 1));
			WD.addWeapon(new CloseWeapon(78, "Ochsenherde", 8, new int[] {3, 3}, new int[] {14, 5}, new int[] {-2, -4}, 3, -3, 1));
			WD.addWeapon(new CloseWeapon(79, "Ogerschelle", 8, new int[] {2, 2}, new int[] {14, 5}, new int[] {-1, -3}, 3, -2, 1));
			
			// Peitsche
			WD.addWeapon(new CloseWeapon(80, "Peitsche", 9, new int[] {1, 0}, new int[] {14, 5}, new int[] {0, -20}, 4, 0, 2));
			
			// Saebel
			WD.addWeapon(new CloseWeapon(81, "Amazonensäbel", 10, new int[] {1, 4}, new int[] {11, 4}, new int[] {0, 0}, 2, 1, 1));
			WD.addWeapon(new CloseWeapon(82, "Arbach", 10, new int[] {1, 4}, new int[] {12, 2}, new int[] {0, -2}, 2, 0, 1));
			WD.addWeapon(new CloseWeapon(83, "Entermesser", 10, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 2, 0, 1));
			WD.addWeapon(new CloseWeapon(84, "Haumesser", 10, new int[] {1, 3}, new int[] {13, 3}, new int[] {0, -2}, 3, -1, 4));
			WD.addWeapon(new CloseWeapon(85, "Khunchomer", 10, new int[] {1, 4}, new int[] {12, 3}, new int[] {0, 0}, 2, 0, 1));
			WD.addWeapon(new CloseWeapon(86, "Kurzschwert", 10, new int[] {1, 2}, new int[] {11, 4}, new int[] {0, -1}, 1, 0, 4));
			WD.addWeapon(new CloseWeapon(87, "Kusliker Säbel", 10, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 1, 1, 1));
			WD.addWeapon(new CloseWeapon(88, "Robbentöter", 10, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 2, 0, 1));
			WD.addWeapon(new CloseWeapon(89, "Säbel", 10, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 2, 1, 1));
			WD.addWeapon(new CloseWeapon(90, "Sklaventod", 10, new int[] {1, 4}, new int[] {12, 3}, new int[] {0, 0}, 3, 0, 1));
			
			WD.addWeapon(new CloseWeapon(91, "Waqqif", 10, new int[] {1, 2}, new int[] {12, 5}, new int[] {-1, -3}, 2, -2, 0));
			WD.addWeapon(new CloseWeapon(92, "Wolfsmesser", 10, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 1, 1, 1));
			
			// Schwerter
			WD.addWeapon(new CloseWeapon(93, "Amazonensäbel", 11, new int[] {1, 4}, new int[] {11, 4}, new int[] {0, 0}, 2, 1, 1));
			WD.addWeapon(new CloseWeapon(94, "Arbach", 11, new int[] {1, 4}, new int[] {12, 3}, new int[] {0, -1}, 2, 0, 1));
			WD.addWeapon(new CloseWeapon(95, "Barbarenschwert", 11, new int[] {1, 5}, new int[] {13, 2}, new int[] {0, -1}, 4, -1, 1));
			WD.addWeapon(new CloseWeapon(96, "Bastardschwert", 11, new int[] {1, 5}, new int[] {12, 4}, new int[] {0, -1}, 2, -1, 1));
			WD.addWeapon(new CloseWeapon(97, "Breitschwert", 11, new int[] {1, 4}, new int[] {12, 3}, new int[] {0, -1}, 1, 0, 1));
			WD.addWeapon(new CloseWeapon(98, "Kurzschwert", 11, new int[] {1, 2}, new int[] {11, 4}, new int[] {0, -1}, 1, 0, 4));
			WD.addWeapon(new CloseWeapon(99, "Kusliker Säbel", 11, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 1, 1, 1));
			WD.addWeapon(new CloseWeapon(100, "Nachtwind", 11, new int[] {1, 4}, new int[] {11, 5}, new int[] {0, 0}, 0, 2, 1));
			WD.addWeapon(new CloseWeapon(101, "Rapier", 11, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 2, 1, 1));
			WD.addWeapon(new CloseWeapon(102, "Robbentöter", 11, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 2, 0, 1));
			
			WD.addWeapon(new CloseWeapon(103, "Säbel", 11, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 2, 1, 1));
			WD.addWeapon(new CloseWeapon(104, "Schwert", 11, new int[] {1, 4}, new int[] {11, 4}, new int[] {0, 0}, 1, 0, 1));
			WD.addWeapon(new CloseWeapon(105, "Turnierschwert", 11, new int[] {1, 3}, new int[] {11, 5}, 1, new int[] {0, 0}, 3, 0, 1));
			WD.addWeapon(new CloseWeapon(106, "Wolfsmesser", 11, new int[] {1, 3}, new int[] {12, 4}, new int[] {0, 0}, 1, 1, 1));
			
			// Speere
			WD.addWeapon(new CloseWeapon(107, "Drachentöter", 12, new int[] {3, 5}, new int[] {20, 1}, new int[] {-2, -4}, 3, -3, 3));
			WD.addWeapon(new CloseWeapon(108, "Dreizack", 12, new int[] {1, 4}, new int[] {13, 3}, new int[] {0, -1}, 5, 0, 2));
			WD.addWeapon(new CloseWeapon(109, "Dschadra", 12, new int[] {1, 5}, new int[] {12, 4}, new int[] {0, -3}, 6, -1, 2));
			WD.addWeapon(new CloseWeapon(110, "Efferdbart", 12, new int[] {1, 4}, new int[] {13, 3}, new int[] {0, -1}, 3, 0, 5));
			WD.addWeapon(new CloseWeapon(111, "Holzspeer", 12, new int[] {1, 3}, new int[] {12, 5}, new int[] {-1, -3}, 5, 0, 2));
			WD.addWeapon(new CloseWeapon(112, "Jagdspieß", 12, new int[] {1, 6}, new int[] {12, 4}, new int[] {0, -1}, 3, -1, 2));
			WD.addWeapon(new CloseWeapon(113, "Korspieß", 12, new int[] {2, 2}, new int[] {12, 3}, new int[] {0, -1}, 3, 0, 2));
			WD.addWeapon(new CloseWeapon(114, "Kriegslanze", 12, new int[] {1, 3}, new int[] {12, 5}, new int[] {-2, -4}, 5, -2, 3));
			WD.addWeapon(new CloseWeapon(115, "Partisane", 12, new int[] {1, 5}, new int[] {13, 3}, new int[] {0, -2}, 4, 0, 2));
			WD.addWeapon(new CloseWeapon(116, "Pike", 12, new int[] {1, 5}, new int[] {14, 4}, new int[] {-1, -2}, 6, -2, 3));
			
			WD.addWeapon(new CloseWeapon(117, "Schnitter", 12, new int[] {1, 5}, new int[] {14, 4}, new int[] {0, 0}, 4, 0, 5));
			WD.addWeapon(new CloseWeapon(118, "Speer", 12, new int[] {1, 5}, new int[] {12, 4}, new int[] {0, -2}, 5, -1, 2));
			WD.addWeapon(new CloseWeapon(119, "Stoßspeer", 12, new int[] {2, 2}, new int[] {11, 4}, new int[] {0, -1}, 3, -1, 2));
			WD.addWeapon(new CloseWeapon(120, "Turnierlanze", 12, new int[] {1, 2}, new int[] {12, 5}, 1, new int[] {-2, -4}, 8, -2, 3));
			WD.addWeapon(new CloseWeapon(121, "Wurfspeer", 12, new int[] {1, 3}, new int[] {11, 5}, new int[] {-1, -3}, 4, -2, 1));
			WD.addWeapon(new CloseWeapon(122, "Wurmspieß", 12, new int[] {1, 5}, new int[] {13, 4}, new int[] {0, -2}, 2, 0, 2));
			
			// Stäbe
			WD.addWeapon(new CloseWeapon(123, "Kampfstab", 13, new int[] {1, 1}, new int[] {12, 4}, new int[] {0, 0}, 5, 1, 5));
			WD.addWeapon(new CloseWeapon(124, "Magierstab", 13, new int[] {1, 1}, new int[] {11, 5}, 2, new int[] {-1, -1}, -10, 0, 5));
			WD.addWeapon(new CloseWeapon(125, "Zweililien", 13, new int[] {1, 3}, new int[] {12, 4}, new int[] {1, -1}, 4, 1, 1));
			
			// Zweihandflegel
			WD.addWeapon(new CloseWeapon(126, "Dreschflegel", 14, new int[] {1, 3}, new int[] {12, 3}, new int[] {-2, -3}, 6, -2, 2));
			WD.addWeapon(new CloseWeapon(127, "Kriegsflegel", 14, new int[] {1, 6}, new int[] {12, 2}, new int[] {-1, -2}, 5, -1, 2));
			
			// Zweihand-Hiebwaffen
			WD.addWeapon(new CloseWeapon(128, "Barbarenstreitaxt", 15, new int[] {3, 2}, new int[] {15, 1}, new int[] {-1, -4}, 3, -2, 1));
			WD.addWeapon(new CloseWeapon(129, "Echsische Axt", 15, new int[] {1, 5}, new int[] {12, 4}, new int[] {0, -1}, 3, 0, 5));
			WD.addWeapon(new CloseWeapon(130, "Felsspalter", 15, new int[] {2, 2}, new int[] {14, 2}, new int[] {0, -2}, 2, -1, 1));
			WD.addWeapon(new CloseWeapon(131, "Gruufhai", 15, new int[] {1, 6}, new int[] {14, 2}, new int[] {-1, -3}, 3, -2, 1));
			WD.addWeapon(new CloseWeapon(132, "Holzfälleraxt", 15, new int[] {2, 0}, new int[] {12, 2}, new int[] {-1, -4}, 5, -2, 1));
			WD.addWeapon(new CloseWeapon(133, "Kriegshammer", 15, new int[] {2, 3}, new int[] {14, 2}, new int[] {-1, -3}, 2, -2, 1));
			WD.addWeapon(new CloseWeapon(134, "Neethaner Langaxt", 15, new int[] {2, 2}, new int[] {13, 4}, new int[] {-1, -3}, 5, -2, 2));
			WD.addWeapon(new CloseWeapon(135, "Orknase", 15, new int[] {1, 5}, new int[] {12, 2}, new int[] {0, -1}, 4, -1, 1));
			WD.addWeapon(new CloseWeapon(136, "Pailos", 15, new int[] {2, 4}, new int[] {14, 2}, new int[] {-1, -3}, 3, -2, 2));
			WD.addWeapon(new CloseWeapon(137, "Schnitter", 15, new int[] {1, 5}, new int[] {14, 4}, new int[] {0, 0}, 4, 0, 5));
			
			WD.addWeapon(new CloseWeapon(138, "Spitzhacke", 15, new int[] {1, 6}, new int[] {13, 2}, new int[] {-2, -4}, 5, -3, 1));
			WD.addWeapon(new CloseWeapon(139, "Vorschlaghammer", 15, new int[] {1, 5}, new int[] {13, 2}, new int[] {-2, -4}, 5, -3, 1));
			WD.addWeapon(new CloseWeapon(140, "Warunker Hammer", 15, new int[] {1, 6}, new int[] {14, 3}, new int[] {0, -1}, 2, -1, 5));
			WD.addWeapon(new CloseWeapon(141, "Zwergenschlägel", 15, new int[] {1, 5}, new int[] {13, 3}, new int[] {0, -1}, 1, -1, 1));
			
			// Zweihandschwerter
			WD.addWeapon(new CloseWeapon(142, "Andergaster", 16, new int[] {3, 2}, new int[] {14, 2}, new int[] {0, -2}, 3, -3, 2));
			WD.addWeapon(new CloseWeapon(143, "Anderthalbhänder", 16, new int[] {1, 5}, new int[] {11, 4}, new int[] {0, 0}, 1, 1, 5));
			WD.addWeapon(new CloseWeapon(144, "Boronssichel", 16, new int[] {2, 6}, new int[] {13, 3}, new int[] {0, -3}, 3, -2, 2));
			WD.addWeapon(new CloseWeapon(145, "Doppelkhunchomer", 16, new int[] {1, 6}, new int[] {12, 2}, new int[] {0, -1}, 2, -1, 5));
			WD.addWeapon(new CloseWeapon(146, "Großer Sklaventod", 16, new int[] {2, 4}, new int[] {13, 2}, new int[] {0, -2}, 3, -2, 5));
			WD.addWeapon(new CloseWeapon(147, "Richtschwert", 16, new int[] {3, 4}, new int[] {13, 2}, new int[] {-2, -4}, 5, -3, 1));
			WD.addWeapon(new CloseWeapon(148, "Rondrakamm", 16, new int[] {2, 2}, new int[] {12, 3}, new int[] {0, 0}, 1, 0, 5));
			WD.addWeapon(new CloseWeapon(149, "Tuzakmesser", 16, new int[] {1, 6}, new int[] {12, 4}, new int[] {0, 0}, 1, 1, 5));
			WD.addWeapon(new CloseWeapon(150, "Zweihänder", 16, new int[] {2, 4}, new int[] {12, 3}, new int[] {0, -1}, 2, -1, 5));
			
			// Improvisiert
			WD.addWeapon(new RangeWeapon(151, "Stein", 17, new int[]{1, 0}, new int[] {1, 2, 4, 8, 12}, new int[] {0,0,0,-1,-1}));
			
			// Armbrust
			WD.addWeapon(new RangeWeapon(169, "Arablette", 18, new int[]{2, 5}, new int[] {10, 20, 30, 60, 100}, new int[] {2,1,0,-1,-2}, 30));
			WD.addWeapon(new RangeWeapon(170, "Arbalone", 18, new int[]{3, 6}, new int[] {15, 30, 60, 12, 250}, new int[] {4,2,0,-1,-3}, 40));
			WD.addWeapon(new RangeWeapon(171, "Balestra", 18, new int[]{2, 2}, new int[] {10, 20, 30, 50, 60}, new int[] {2,1,0,0,-1}, 12));
			WD.addWeapon(new RangeWeapon(172, "Balestrina", 18, new int[]{1, 4}, new int[] {2, 4, 8, 15, 25}, new int[] {2,1,0,0,-1}, 4));
			WD.addWeapon(new RangeWeapon(173, "Balläster", 18, new int[]{1, 4}, new int[] {10, 20, 30, 60, 100}, new int[] {3,1,0,-1,-1}, 8));
			WD.addWeapon(new RangeWeapon(174, "Eisenwalder", 18, new int[]{1, 3}, new int[] {5, 10, 15, 20, 40}, new int[] {1,0,0,0,-1}, 3));
			WD.addWeapon(new RangeWeapon(175, "Leichter Armbrust", 18, new int[]{1, 6}, new int[] {10, 15, 25, 40, 60}, new int[] {1,1,0,0,-1}, 15));
			WD.addWeapon(new RangeWeapon(176, "Windenarmbrust", 18, new int[]{2, 6}, new int[] {10, 30, 60, 100, 180}, new int[] {4,2,0,-1,-3}, 30));
			
			// Blasrohr
			WD.addWeapon(new RangeWeapon(152, "Blasrohr", 19, new int[]{1, -1}, new int[] {2, 5, 10, 20, 40}, new int[] {0,0,0,0,-2}, 2));
			
			// Bogen
			WD.addWeapon(new RangeWeapon(177, "Elfenbogen", 20, new int[]{1, 5}, new int[] {10, 25, 50, 100, 200}, new int[] {3,2,1,1,0}, 3));
			WD.addWeapon(new RangeWeapon(178, "Kompositbogen", 20, new int[]{1, 5}, new int[] {10, 20, 35, 50, 80}, new int[] {2,1,1,0,0}, 3));
			WD.addWeapon(new RangeWeapon(179, "Kriegsbogen", 20, new int[]{1, 7}, new int[] {10, 20, 40, 80, 150}, new int[] {3,2,1,0,0}, 4));
			WD.addWeapon(new RangeWeapon(180, "Kurzbogen", 20, new int[]{1, 4}, new int[] {5, 15, 25, 40, 60}, new int[] {1,1,0,0,-1}, 2));
			WD.addWeapon(new RangeWeapon(181, "Langbogen", 20, new int[]{1, 6}, new int[] {10, 25, 50, 100, 200}, new int[] {3,2,1,0,-1}, 4));
			WD.addWeapon(new RangeWeapon(182, "Ork. Reitbogen", 20, new int[]{1, 5}, new int[] {5, 15, 30, 60, 100}, new int[] {3,1,0,-1,-2}, 3));
			
			// Diskus
			WD.addWeapon(new RangeWeapon(190, "Diskus", 21, new int[]{1, 3}, new int[] {5, 10, 20, 30, 60}, new int[] {1,0,0,0,-1}));
			WD.addWeapon(new RangeWeapon(191, "Jagddiskus", 21, new int[]{2, 4}, 1, new int[] {5, 10, 20, 30, 60}, new int[] {1,0,0,0,-1}, 0));
			WD.addWeapon(new RangeWeapon(192, "Kampfdiskus", 21, new int[]{1, 5}, new int[] {10, 20, 30, 45, 60}, new int[] {1,0,0,0,0}));
			
			// Schleuder
			WD.addWeapon(new RangeWeapon(183, "Fledermaus", 22, new int[]{1, 2}, new int[] {0, 5, 10, 15, 25}, new int[] {0,0,0,0,-1}, 1));
			WD.addWeapon(new RangeWeapon(184, "Granatapfel", 22, new int[]{4, 0}, new int[] {0, 5, 10, 15, 20}, new int[] {0,0,0,0,0}));
			WD.addWeapon(new RangeWeapon(185, "Kettenkugel", 22, new int[]{2, 2}, new int[] {0, 2, 5, 8, 15}, new int[] {0,1,0,0,0}, 2));
			WD.addWeapon(new RangeWeapon(186, "Lasso", 22, new int[]{1, 4}, new int[] {0, 2, 5, 10, 15}, new int[] {0,0,0,-1,-2}, 1));
			WD.addWeapon(new RangeWeapon(187, "Schleuder", 22, new int[]{1, 2}, new int[] {0, 5, 15, 25, 40}, new int[] {0,0,0,0,0}, 2));
			WD.addWeapon(new RangeWeapon(188, "Wurfnetz", 22, new int[]{1, 2}, new int[] {0, 0, 0, 5, 5}, new int[] {0,0,0,0,0}, 1));
			WD.addWeapon(new RangeWeapon(189, "Schweres Wurfnetz", 22, new int[]{1, 6}, new int[] {0, 0, 0, 5, 5}, new int[] {0,0,0,0,0}, 1));
			
			// Wurfbeil
			WD.addWeapon(new RangeWeapon(166, "Schneidzahn", 23, new int[]{1, 4}, new int[] {0, 5, 10, 15, 30}, new int[] {0,1,1,0,-1}));
			WD.addWeapon(new RangeWeapon(167, "Wurfbeil", 23, new int[]{1, 3}, new int[] {0, 5, 10, 15, 25}, new int[] {0,1,1,0,-1}));
			WD.addWeapon(new RangeWeapon(168, "Wurfkeule", 23, new int[]{2, 4}, 1, new int[] {0, 5, 15, 25, 40}, new int[] {0,1,1,1,0}, 0));
			
			// Wurfmesser
			WD.addWeapon(new RangeWeapon(153, "Borndolch", 24, new int[]{1, 2}, new int[] {2, 4, 6, 8, 15}, new int[] {1,0,0,0,-1}));
			WD.addWeapon(new RangeWeapon(154, "Dolch", 24, new int[]{1, 0}, new int[] {1, 3, 5, 7, 10}, new int[] {0,0,0,-1,-1}));
			WD.addWeapon(new RangeWeapon(155, "Wurfdolch", 24, new int[]{1, 1}, new int[] {2, 4, 6, 8, 15}, new int[] {1,0,0,0,-1}));
			WD.addWeapon(new RangeWeapon(156, "Wurfmesser", 24, new int[]{1, 0}, new int[] {2, 4, 6, 8, 15}, new int[] {1,0,0,0,-1}));
			WD.addWeapon(new RangeWeapon(157, "Wurfscheibe", 24, new int[]{1, 1}, new int[] {2, 4, 8, 12, 20}, new int[] {1,0,0,0,0}));
			
			// Wurfspeer
			WD.addWeapon(new RangeWeapon(158, "Dschadra", 25, new int[]{1, 4}, new int[] {5, 10, 15, 25, 40}, new int[] {3,2,1,0,0}));
			WD.addWeapon(new RangeWeapon(159, "Efferdbart", 25, new int[]{1, 3}, new int[] {3, 6, 10, 15, 25}, new int[] {2,1,0,-1,-2}));
			WD.addWeapon(new RangeWeapon(160, "Granarapfel", 25, new int[]{4, 0}, new int[] {0, 5, 10, 15, 20}, new int[] {0,0,0,0,0}));
			WD.addWeapon(new RangeWeapon(161, "Holzspeer", 25, new int[]{1, 2}, new int[] {5, 10, 15, 25, 40}, new int[] {1,0,0,-1,-2}));
			WD.addWeapon(new RangeWeapon(162, "Speer", 25, new int[]{1, 3}, new int[] {5, 10, 15, 25, 40}, new int[] {1,0,0,-1,-2}));
			WD.addWeapon(new RangeWeapon(163, "Speerschleuder", 25, new int[]{1, 3}, new int[] {0, 15, 30, 60, 100}, new int[] {0,1,0,0,-1}, 2));
			WD.addWeapon(new RangeWeapon(164, "Stabschleuder", 25, new int[]{1, 3}, new int[] {0, 5, 20, 40, 60}, new int[] {0,0,0,0,0}, 2));
			WD.addWeapon(new RangeWeapon(165, "Wurfspeer", 25, new int[]{1, 4}, new int[] {5, 10, 15, 25, 40}, new int[] {3,1,0,-1,-1}));
		}catch (Exception ex) {throw ex;}
	}
	
	/**	Dh	10.6.2020
	 * 
	 * @throws Exception
	 */
	private static void genDatabanks() throws Exception{
		try {
			genTalents();
			genBasicTalents();
			genWeapons();
		} catch(Exception ex) {throw ex;}
	}
	//--------------------------------------------------------------------------------------------------------
	

}
