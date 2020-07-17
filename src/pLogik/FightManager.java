/**	DSA_App v0.0	Dh	17.7.2020
 * 
 * 	Logik
 * 	  FightManager
 * 
 * 	Verwaltungseinheit für die Kampf- und die Ini-Liste.
 * 		Verwaltet sowohl die Listen an sich, als auch die Delegation von Befehlen an die Elemente in den Listen.
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

import java.util.Random;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import pGUI.MainFrame;

import pDataStructures.List;
import pDatenbank.Loader;

@XmlRootElement(name="fightmanager")
@XmlSeeAlso({FightElement.class, IniElement.class, int[].class})
@XmlType(propOrder = {"roundCounter", "fightList", "iniList", "iniOrder"})
public class FightManager {
	private int id, roundCounter;
	private List fightList, iniList, iniOrder;
	
	/**	Dh	11.6.2020
	 * 
	 */
	public FightManager() {
		id = -1;
		
		roundCounter = 0;
			
		fightList = new List();
		iniList = new List();
		iniOrder = new List();
	}
	/**	Dh	6.5.2020
	 * 
	 * @param pID
	 */
	public FightManager(int pID){
		Exception vExc = null;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; FiMan_a");
		
		roundCounter = 0;
			
		fightList = new List();
		iniList = new List();
		iniOrder = new List();
		
		try { 
			addFighter(Loader.loadNewCharacter(0));
			addFighter(Loader.loadNewCharacter(1));
			addFighter(Loader.loadNewCharacter(2));
			
			addFighter(Loader.loadNewRandomCharakter(3));
			addFighter(Loader.loadNewRandomCharakter(4));
			addFighter(Loader.loadNewRandomCharakter(5));
			addFighter(Loader.loadNewRandomCharakter(6));
			
			makeIniOrder();
		} catch(Exception ex) {vExc = ex;}
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	6.5.2020
	 * 
	 * @param pID
	 * @param pFightList
	 */
	public FightManager(int pID, List pFightList){
		Exception vExc = null;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; FiMan_b");
		
		roundCounter = 0;
		
		if (pFightList != null) fightList = pFightList;
		else vExc = new Exception("04; FiMan_b");
			
		iniList = new List();
		iniOrder = new List();
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	6.5.2020
	 * 
	 * @param pID
	 * @param pFightList
	 * @param pIniList
	 */
	public FightManager(int pID, List pFightList , List pIniList){
		Exception vExc = null;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; FiMan_b");
		
		roundCounter = 0;
		
		if (pFightList != null) fightList = pFightList;
		else vExc = new Exception("04; FiMan_b");
		if (pIniList != null) iniList = pIniList;
		else vExc = new Exception("04; FiMan_b");
		
		iniOrder = new List();
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	6.5.2020
	 * 
	 * @param pID
	 * @param pFightList
	 * @param pIniList
	 * @param pIniOrder
	 */
	public FightManager(int pID, List pFightList , List pIniList, List pIniOrder){
		Exception vExc = null;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; FiMan_c");
		
		roundCounter = 0;
		
		if (pFightList != null) fightList = pFightList;
		else vExc = new Exception("04; FiMan_c");
		if (pIniList != null) iniList = pIniList;
		else vExc = new Exception("04; FiMan_c");
		if (pIniOrder != null) iniOrder = pIniOrder;
		else vExc = new Exception("04; FiMan_c");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	
	/**	Dh	4.5.2020
	 * 
	 * @throws Exception
	 */
	public void destroyFightManager() throws Exception{
		Exception vExc = null;
		
		if (fightList != null){
			while(!fightList.isEmpty()){
				fightList.toFirst();
				fightList.remove();
			}
			fightList = null;
		} else vExc = new Exception("04; FiMan,dFM");
		if (iniList != null) {
			while(!iniList.isEmpty()){
				iniList.toFirst();
				iniList.remove();
			}
			iniList = null;
		} else vExc = new Exception("04; FiMan,dFM");
		if (iniOrder != null) {
			while(!iniOrder.isEmpty()){
				iniOrder.toFirst();
				iniOrder.remove();
			}
			iniOrder = null;
		} else vExc = new Exception("04; FiMan,dFM");
		
		if (vExc != null) throw vExc;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	22.2.2020
	 * 
	 * @return
	 */
	@XmlAttribute
	public int getId(){
		return id;
	}
	/**	Dh	6.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "RoundCounter")
	public int getRoundCounter() {
		return roundCounter;
	}
	
	/**	Dh	22.2.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "FightList")
	public List getFightList(){
		return fightList;
	}
	/**	Dh	22.2.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "IniList")
	public List getIniList(){
		return iniList;
	}
	/**	Dh	3.5.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "IniOrder")
	public List getIniOrder(){
		return iniOrder;
	}
	//-----
	/**	Dh	23.2.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public FightElement getFightElement(int pID) throws Exception{
		FightElement vRet = null;
		Object vTemp = null;
		int vID = -1;
		
		if (pID >= 0){
			if (!fightList.isEmpty()){
				fightList.toFirst();
				while(!fightList.isEnd() && (vRet == null)){
					vTemp = fightList.getCurrent();
					
					if (vTemp instanceof FightElement){
						if (((FightElement)vTemp).getId() == pID) vRet = (FightElement)vTemp;
					} else throw new Exception("06; FiMan,gFE");
					
					fightList.next();
				}
			} else throw new Exception("05; FiMan,gFE");
		} else throw new Exception("02; FiMan,gFE");
		
		return vRet;
	}
	//-----
	/**	Dh	3.5.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getIdOfFighters() throws Exception{
		Object vFiEle;
		List vRet;
		
		if (!fightList.isEmpty()){
			vRet = new List();
			
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
			
				if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getId());
				else throw new Exception("06; FiMan,gIDoFs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gIDoFs");
		
		return vRet;
	}
	
	/**	Dh	16.7.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int getIDOfCharacterOfFighter(int pID) throws Exception{
		if (pID >= 0) return getFightElement(pID).getCharacter().getId();
		else throw new Exception("02; FiMan,gIDoCoF");
	}
	
	/**	Dh	3.5.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public Charakter getCharacterOfFighter(int pID) throws Exception{
		try{ return getFightElement(pID).getCharacter();}
		catch(Exception vExc) { throw vExc;}
	}
	/**	Dh	3.5.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getCharacterOfFighters() throws Exception{
		Object vFiEle;
		List vRet;
		
		if (!fightList.isEmpty()){
			vRet = new List();
			
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
			
				if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getCharacter());
				else throw new Exception("06; FiMan,gCoFs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gCoFs");
		
		return vRet;
	}
	
	/**	Dh	23.2.2020
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Gibt den gewaehlten EigenschaftsModifikator fuer den*die gewaehlte*N Kaempfer*In(pID).
	 * 
	 * @param pID
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getPropModOfFighter(int pID, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 10)){
			try{ return getFightElement(pID).getPropMod(pInd);}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,gPMF");
	}
	/**	Dh	23.2.2020
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * 	Gibt den gewaehlten StatusModifikator fuer den*die gewaehlte*N Kaempfer*In(pID).
	 * 
	 * @param pID
	 * @param pStatMod
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public double getStatModOfFighter(int pID, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 10)){
			try{ return getFightElement(pID).getStatMod(pInd);}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,gPMF");
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pID
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public Weapon getActiveWeaponOfFighter(int pID, int pInd) throws Exception{
		if ((pID >= 0) && (pInd >= 0)) {
			try {return getFightElement(pID).getActiveWeapon(pInd);}
			catch(Exception ex) {throw ex;}
		}else throw new Exception("02; FiMan,gAWoF");
	}
	/** Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pID
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getActiveWeaponUseTypeOfFighter(int pID, int pInd) throws Exception{
		if ((pID >= 0) && (pInd >= 0)) {
			try {return getFightElement(pID).getActiveWeaponUseType(pInd);}
			catch(Exception ex) {throw ex;}
		}else throw new Exception("02; FiMan,gAWUToF");
	}
	
	/**	Dh	23.2.2020
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Gibt die EigenschaftsModifikatoren fuer den*die gewaehlte*N Kaempfer*In(pID).
	 * 
	 * @param pID
	 * @param pPropMods
	 * @return
	 * @throws Exception
	 */
	public int[] getPropModsOfFighter(int pID) throws Exception{
		try{ return getFightElement(pID).getPropMods();}
		catch(Exception vExc) { throw vExc;}
	}
	/**	Dh	23.2.2020
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * 	Gibt die StatusModifikatoren fuer den*die gewaehlte*N Kaempfer*In(pID).
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int[] getStatModsOfFighter(int pID) throws Exception{
		try{ return getFightElement(pID).getStatMods();}
		catch(Exception vExc) { throw vExc;}
	}
	/**	Dh	28.5.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public Object[][] getActiveWeaponsOfFighter(int pID) throws Exception{
		if (pID >= 0) {
			try {return getFightElement(pID).getActiveWeapons();}
			catch(Exception ex) {throw ex;}
		}else throw new Exception("02; FiMan,gAWsoF");
	}

	/**	Dh	1.5.2020
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Gibt den gewaehlten EigenschaftsModifikator fuer die Kaempfer*Innen als ein Array zurueck.
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getPropModToFighters(int pInd) throws Exception{
		Object vFiEle;
		List vRet;
		
		if ((pInd >= 0) && (pInd < 10)){
			if (!fightList.isEmpty()){
				vRet = new List();
				
				fightList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
				
					if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getPropMod(pInd));
					else throw new Exception("06; FiMan,gPMFs");
				
					fightList.next();
				}
			} else throw new Exception("05; FiMan,gPMFs");
		} else throw new Exception("07; FiMan,gPMFs");
		
		return vRet;
	}
	/**	Dh	1.5.2020
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * 	Gibt den gewaehlten StatusModifikator fuer die Kaempfer*Innen als ein Array zurueck.
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getStatModToFighters(int pInd) throws Exception{
		Object vFiEle;
		List vRet;
		
		if ((pInd >= 0) && (pInd < 10)){
			if (!fightList.isEmpty()){
				vRet = new List();
				
				fightList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
				
					if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getStatMod(pInd));
					else throw new Exception("06; FiMan,gSMFs");
				
					fightList.next();
				}
			} else throw new Exception("05; FiMan,gSMFs");
		} else throw new Exception("07; FiMan,gSMFs");
		
		return vRet;
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getActiveWeaponOfFighters(int pInd) throws Exception{
		List vRet;
		Weapon vCur;
		
		if (pInd >= 0) {
			vRet = new List();
			
			if (!fightList.isEmpty()) {
				fightList.toFirst();
				
				while(!fightList.isLast()) {
					vCur = ((FightElement)fightList.getCurrent()).getActiveWeapon(pInd);
					
					vRet.append(vCur);
					
					fightList.next();
				}
			}else throw new Exception("05; FiMan,gAWoFs");
		}else throw new Exception("02; FiMan,gAWoFs");
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getActiveWeaponUseTypeOfFighter(int pInd) throws Exception{
		List vRet;
		int vCur;
		
		if (pInd >= 0) {
			vRet = new List();
			
			if (!fightList.isEmpty()) {
				fightList.toFirst();
				
				while(!fightList.isLast()) {
					vCur = ((FightElement)fightList.getCurrent()).getActiveWeaponUseType(pInd);
					
					vRet.append(vCur);
					
					fightList.next();
				}
			}else throw new Exception("05; FiMan,gAWUToFs");
		}else throw new Exception("02; FiMan,gAWUToFs");
		
		return vRet;
	}
	
	/**	Dh	1.5.2020
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	vRet[Fighter][Eigenschaft]
	 * 
	 * 	Gibt die EigenschaftsModifikatoren fuer die Kaempfer*Innen als ein Doppel-Array zurueck.
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getPropModsToFighters() throws Exception{
		Object vFiEle;
		List vRet;
		
		if (!fightList.isEmpty()){
			vRet = new List();
				
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
				
				if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getPropMods());
				else throw new Exception("06; FiMan,gPMsFs");
				
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gPMsFs");
		
		return vRet;
	}
	/**	Dh	1.5.2020
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * 	vRet[Fighter][Eigenschaft]
	 * 
	 * 	Gibt die EigenschaftsModifikatoren fuer die Kaempfer*Innen als ein Array zurueck.
	 * 
	 * @param pStatMods
	 * @return
	 * @throws Exception
	 */
	public List getStatModsToFighters(double[] pStatMods) throws Exception{
		Object vFiEle;
		List vRet;
		
		if (!fightList.isEmpty()){
			vRet = new List();
				
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
				
				if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getStatMods());
				else throw new Exception("06; FiMan,gSMsFs");
				
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gSMsFs");
		
		return vRet;
	}
	/**	Dh	28.5.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getActiveWeaponsOfFighters() throws Exception{
		List vRet;
		
		if (!fightList.isEmpty()){
			vRet = new List();
				
			fightList.toFirst();
			while(!fightList.isEnd()){
				vRet.append(((FightElement)fightList.getCurrent()).getActiveWeapons());
				
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gAWsoFs");
		
		return vRet;
	}
	
	/**	Dh	15.7.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public double getHandicapOfFighter(int pID) throws Exception{
		if (pID >= 0) return getCharacterOfFighter(pID).getBe();
		else throw new Exception("02; FiMan,gHoF");
	}
	/**	Dh	15.7.2020
	 * 
	 * @param pID
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public double getArmorValueOfFighter(int pID, int pInd) throws Exception{
		double vRet = -1;
		
		if ((pID >= 0) && (pInd >= 0) && (pInd < 9)) vRet = getCharacterOfFighter(pID).getRs(pInd);
		else throw new Exception("02; FiMan,gAVoF");
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public double[] getArmorValuesOfFighter(int pID) throws Exception{
		double[] vRet = null;
		
		if (pID >= 0) vRet = getCharacterOfFighter(pID).getRs();
		else throw new Exception("02; FiMan,gAVsoF");
		
		return vRet;
	}
	//-----
	/**	Dh	15.7.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getHandicapOfFighters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getHandicapOfFighter((int) vCur));
					else throw new Exception("06; FiMan,gHoFs");
					
					pIDList.next();
				}
			}
		} else throw new Exception("04; FiMan,gHoFs");
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * @param pIDList
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getArmorValueOfFighters(List pIDList, int pInd) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getArmorValueOfFighter((int) vCur, pInd));
					else throw new Exception("06; FiMan,gAVoFs");
					
					pIDList.next();
				}
			}
		} else throw new Exception("04; FiMan,gAVoFs");
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getArmorValuesOfFighters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getArmorValuesOfFighter((int) vCur));
					else throw new Exception("06; FiMan,gAVsoFs");
					
					pIDList.next();
				}
			}
		} else throw new Exception("04; FiMan,gAVsoFs");
		
		return vRet;
	}
	//-----
	/**	Dh	15.7.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public List getHandicapOfAllFighter() throws Exception{
		List vRet = new List();
		
		if (fightList != null) {
			if (!fightList.isEmpty()) {
				fightList.toFirst();
				
				while(!fightList.isEnd()) {
					vRet.append(getHandicapOfFighter((int) fightList.getCurrent()));
					
					fightList.next();
				}
			}
		} else throw new Exception("04; FiMan,gAVoAFs");
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getArmorValueOfAllFighters(int pInd) throws Exception{
		List vRet = new List();
		
		if (fightList != null) {
			if (!fightList.isEmpty()) {
				fightList.toFirst();
				
				while(!fightList.isEnd()) {
					vRet.append(getArmorValueOfFighter((int) fightList.getCurrent(), pInd));
					
					fightList.next();
				}
			}
		} else throw new Exception("04; FiMan,gAVoAFs");
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getArmorValuesOfAllFighters(int pInd) throws Exception{
		List vRet = new List();
		
		if (fightList != null) {
			if (!fightList.isEmpty()) {
				fightList.toFirst();
				
				while(!fightList.isEnd()) {
					vRet.append(getArmorValuesOfFighter((int) fightList.getCurrent()));
					
					fightList.next();
				}
			}
		} else throw new Exception("04; FiMan,gAVsoAFs");
		
		return vRet;
	}
	
	/**	Dh	10.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int getActiveWeaponAttackValueOfFighter(int pID) throws Exception{
		try{ return getActiveWeaponAttackValueOfFighter(pID, 2);}
		catch(Exception vExc) { throw vExc;}
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int getActiveWeaponDefenceValueOfFighter(int pID) throws Exception{
		try{ return getActiveWeaponDefenceValueOfFighter(pID, 2);}
		catch(Exception vExc) { throw vExc;}
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int[] getActiveWeaponFightValuesOfFighter(int pID) throws Exception{
		try{ return getActiveWeaponFightValuesOfFighter(pID, 2);}
		catch(Exception vExc) { throw vExc;}
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pID
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getActiveWeaponAttackValueOfFighter(int pID, int pInd) throws Exception{
		try{ return getFightElement(pID).getActiveWeaponAttackValue(pInd);}
		catch(Exception vExc) { throw vExc;}
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pID
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getActiveWeaponDefenceValueOfFighter(int pID, int pInd) throws Exception{
		try{ return getFightElement(pID).getActiveWeaponDefenceValue(pInd);}
		catch(Exception vExc) { throw vExc;}
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pID
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int[] getActiveWeaponFightValuesOfFighter(int pID, int pInd) throws Exception{
		try{ return getFightElement(pID).getActiveWeaponFightValues(pInd);}
		catch(Exception vExc) { throw vExc;}
	}
	
	/**	Dh	10.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getActiveWeaponAttackValueOfFighters() throws Exception{
		return getActiveWeaponAttackValueOfFighters(2);
	}
	/**	Dh	10.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getActiveWeaponDefenceValueOfFighters() throws Exception{
		return getActiveWeaponDefenceValueOfFighters(2);
	}
	/**	Dh	10.6.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getActiveWeaponFightValuesOfFighters() throws Exception{
		return getActiveWeaponFightValuesOfFighters(2);
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getActiveWeaponAttackValueOfFighters(int pInd) throws Exception{
		Object vFiEle;
		List vRet;
		
		if (!fightList.isEmpty()){
			vRet = new List();
				
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
				
				if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getActiveWeaponAttackValue(pInd));
				else throw new Exception("06; FiMan,gAWAVoFs");
				
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gAWAVoFs");
		
		return vRet;
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getActiveWeaponDefenceValueOfFighters(int pInd) throws Exception{
		Object vFiEle;
		List vRet;
		
		if (!fightList.isEmpty()){
			vRet = new List();
				
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
				
				if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getActiveWeaponDefenceValue(pInd));
				else throw new Exception("06; FiMan,gAWDVoFs");
				
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gAWDVoFs");
		
		return vRet;
	}
	/**	Dh	10.6.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getActiveWeaponFightValuesOfFighters(int pInd) throws Exception{
		Object vFiEle;
		List vRet;
		
		if (!fightList.isEmpty()){
			vRet = new List();
				
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
				
				if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getActiveWeaponFightValues(pInd));
				else throw new Exception("06; FiMan,gAWFVsoFs");
				
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gAWFVsoFs");
		
		return vRet;
	}
	//-----
	/**	Dh	1.5.2020
	 * 
	 * @param pID
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public NeighbourElement getNeighbourElementOfFighter(int pFigID, int pNeiID) throws Exception{
		if ((pFigID >= 0) && (pNeiID >= 0)){
			try{ return getFightElement(pFigID).getNeighbourElement(pNeiID);}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,gNEoF");
	}
	/**	Dh	1.5.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public NeighbourElement getLastNeighbourElementOfFighter(int pID) throws Exception{
		if (pID >= 0){
			try{ return getFightElement(pID).getLastNeighbourElement();}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,gLNEoF");
	}
	/**	Dh	1.5.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public List getNeighbourListOfFighter(int pID) throws Exception {
		if (pID >= 0){
			try{ return getFightElement(pID).getNeighbourList();}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,gNLoF");
	}
	
	/**	Dh	1.5.2020
	 * 
	 * @param pNeiID
	 * @return
	 * @throws Exception
	 */
	public List getNeighbourElementOfFighters(int pNeiID) throws Exception{
		Object vFiEle;
		List vRet = null;
		
		if ((pNeiID >= 0)){
			if (!fightList.isEmpty()){
				vRet = new List();
				
				fightList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
				
					if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getNeighbourElement(pNeiID));
					else throw new Exception("06; FiMan,gNEoFs");
				
					fightList.next();
				}
			} else throw new Exception("05; FiMan,gNEoFs");
		} else throw new Exception("07; FiMan,gNEoFs");
		
		return vRet;
	}
	/**	Dh	1.5.2020	
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getLastNeighbourElementOfFighters() throws Exception{
		Object vFiEle;
		List vRet;
		
		if (!fightList.isEmpty()){
			vRet = new List();
			
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
			
				if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getLastNeighbourElement());
				else throw new Exception("06; FiMan,gLNEoFs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gLNEoFs");
		
		return vRet;
	}
	/**	Dh	1.5.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getNeighbourListOfFighters() throws Exception {
		Object vFiEle;
		List vRet;
		
		if (!fightList.isEmpty()){
			vRet = new List();
			
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
			
				if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getNeighbourList());
				else throw new Exception("06; FiMan,gNLoFs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gNLoFs");
		
		return vRet;
	}
	//-----
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @return
	 * @throws Exception
	 */
	public List getIdOfNeighboursOfFighter(int pFigID) throws Exception{
		Object vNeiEle;
		List vRet, vNeiList = null;
		
		if (pFigID >= 0){
			vNeiList = getFightElement(pFigID).getNeighbourList();
				
			if (!vNeiList.isEmpty()){
				vRet = new List();
				
				vNeiList.toFirst();
				while(!vNeiList.isEnd()){
					vNeiEle = vNeiList.getCurrent();
				
					if (vNeiEle instanceof NeighbourElement) vRet.append(((NeighbourElement) vNeiEle).getId());
					else throw new Exception("06; FiMan,gIDoNsoF");
				
					vNeiList.next();
				}
			} else throw new Exception("05; FiMan,gIDoNsoF");
		} else throw new Exception("07; FiMan,gIDoNsoF");
		
		return vRet;
	}
	/**	Dh	3.5.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getIdOfNeighboursOfFighters() throws Exception{
		Object vFiEle, vNeiEle;
		List vRet = null;
		
		if (!fightList.isEmpty()){
			vRet = new List();
			
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
			
				if (vFiEle instanceof FightElement) vRet.append(getIdOfNeighboursOfFighter(((FightElement) vFiEle).getId()));
				else throw new Exception("06; FiMan,gIDoNsoFs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gIDoNsoFs");
				
		return vRet;
	}	
	//-----
	/**	Dh	11.6.2020
	 * 
	 * @param pFigID
	 * @param pNeiID
	 * @return
	 * @throws Exception
	 */
	public boolean getEnemyTypeOfNeighbourOfFighter(int pFigID, int pNeiID) throws Exception{
		if ((pFigID >= 0) && (pNeiID >= 0)){
			try{ return getFightElement(pFigID).getNeighbourElement(pNeiID).isEnemy();}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,gEToNoF");
	}
	/**	Dh	2.5.2020
	 * 
	 * @param pFigID
	 * @param pNeiID
	 * @return
	 * @throws Exception
	 */
	public int getDistanceOfNeighbourOfFighter(int pFigID, int pNeiID) throws Exception{
		if ((pFigID >= 0) && (pNeiID >= 0)){
			try{ return getFightElement(pFigID).getNeighbourElement(pNeiID).getDistance();}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,gDoNoF");
	}
	/**	Dh	2.5.2020
	 * 
	 * @param pFigID
	 * @param pNeiID
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public double getFightModOfNeighbourOfFighter(int pFigID, int pNeiID, int pInd) throws Exception{
		if ((pFigID >= 0) && (pNeiID >= 0)){
			try{ return getFightElement(pFigID).getNeighbourElement(pNeiID).getFightMod(pInd);}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,gFMoNoF");
	}
	/**	Dh	2.5.2020
	 * 
	 * @param pFigID
	 * @param pNeiID
	 * @return
	 * @throws Exception
	 */
	public double[] getFightModsOfNeighbourOfFighter(int pFigID, int pNeiID) throws Exception{
		if ((pFigID >= 0) && (pNeiID >= 0)){
			try{ return getFightElement(pFigID).getNeighbourElement(pNeiID).getFightMods();}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,gFMsoNoF");
	}
	
	/**	Dh	11.6.2020
	 * 
	 * @param pFigID
	 * @return
	 * @throws Exception
	 */
	public List getEnemyTypeOfNeighboursOfFighter(int pFigID) throws Exception{
		Object vNeiEle;
		List vRet, vNeiList = null;
		
		if (pFigID >= 0){
			vNeiList = getFightElement(pFigID).getNeighbourList();
				
			if (!vNeiList.isEmpty()){
				vRet = new List();
				
				vNeiList.toFirst();
				while(!vNeiList.isEnd()){
					vNeiEle = vNeiList.getCurrent();
				
					if (vNeiEle instanceof NeighbourElement) vRet.append(((NeighbourElement) vNeiEle).isEnemy());
					else throw new Exception("06; FiMan,gEToNsoF");
				
					vNeiList.next();
				}
			} else throw new Exception("05; FiMan,gEToNsoF");
		} else throw new Exception("07; FiMan,gEToNsoF");
		
		return vRet;
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @return
	 * @throws Exception
	 */
	public List getDistanceOfNeighboursOfFighter(int pFigID) throws Exception{
		Object vNeiEle;
		List vRet, vNeiList = null;
		
		if (pFigID >= 0){
			vNeiList = getFightElement(pFigID).getNeighbourList();
				
			if (!vNeiList.isEmpty()){
				vRet = new List();
				
				vNeiList.toFirst();
				while(!vNeiList.isEnd()){
					vNeiEle = vNeiList.getCurrent();
				
					if (vNeiEle instanceof NeighbourElement) vRet.append(((NeighbourElement) vNeiEle).getDistance());
					else throw new Exception("06; FiMan,gDoNsoF");
				
					vNeiList.next();
				}
			} else throw new Exception("05; FiMan,gDoNsoF");
		} else throw new Exception("07; FiMan,gDoNsoF");
		
		return vRet;
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getFightModOfNeighboursOfFighter(int pFigID, int pInd) throws Exception{
		Object vNeiEle;
		List vRet, vNeiList = null;
		
		if (pFigID >= 0){
			vNeiList = getFightElement(pFigID).getNeighbourList();
				
			if (!vNeiList.isEmpty()){
				vRet = new List();
				
				vNeiList.toFirst();
				while(!vNeiList.isEnd()){
					vNeiEle = vNeiList.getCurrent();
				
					if (vNeiEle instanceof NeighbourElement) vRet.append(((NeighbourElement) vNeiEle).getFightMod(pInd));
					else throw new Exception("06; FiMan,gFMoNsoF");
				
					vNeiList.next();
				}
			} else throw new Exception("05; FiMan,gFMoNsoF");
		} else throw new Exception("07; FiMan,gFMoNsoF");
		
		return vRet;
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @return
	 * @throws Exception
	 */
	public List getFightModsOfNeighboursOfFighter(int pFigID) throws Exception{
		Object vNeiEle;
		List vRet, vNeiList = null;
		
		if (pFigID >= 0){
			vNeiList = getFightElement(pFigID).getNeighbourList();
				
			if (!vNeiList.isEmpty()){
				vRet = new List();
				
				vNeiList.toFirst();
				while(!vNeiList.isEnd()){
					vNeiEle = vNeiList.getCurrent();
				
					if (vNeiEle instanceof NeighbourElement) vRet.append(((NeighbourElement) vNeiEle).getFightMods());
					else throw new Exception("06; FiMan,gFMsoNsoF");
				
					vNeiList.next();
				}
			} else throw new Exception("05; FiMan,gFMsoNsoF");
		} else throw new Exception("07; FiMan,gFMsoNsoF");
		
		return vRet;
	}
	
	/**	Dh	11.6.2020
	 * 
	 * @param pNeiID
	 * @return
	 * @throws Exception
	 */
	public List getEnemyTypeOfNeighbourOfFighters(int pNeiID) throws Exception{
		Object vFiEle;
		List vRet = null;
		
		if ((pNeiID >= 0)){
			if (!fightList.isEmpty()){
				vRet = new List();
				
				fightList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
				
					if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getNeighbourElement(pNeiID).isEnemy());
					else throw new Exception("06; FiMan,gEToNoFs");
				
					fightList.next();
				}
			} else throw new Exception("05; FiMan,gEToNoFs");
		} else throw new Exception("07; FiMan,gEToNoFs");
		
		return vRet;
	}
	/**	Dh	2.5.2020
	 * 
	 * @param pNeiID
	 * @return
	 * @throws Exception
	 */
	public List getDistanceOfNeighbourOfFighters(int pNeiID) throws Exception{
		Object vFiEle;
		List vRet = null;
		
		if ((pNeiID >= 0)){
			if (!fightList.isEmpty()){
				vRet = new List();
				
				fightList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
				
					if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getNeighbourElement(pNeiID).getDistance());
					else throw new Exception("06; FiMan,gDoNoFs");
				
					fightList.next();
				}
			} else throw new Exception("05; FiMan,gDoNoFs");
		} else throw new Exception("07; FiMan,gDoNoFs");
		
		return vRet;
	}
	/**	Dh	2.5.2020
	 * 
	 * @param pNeiID
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getFightModOfNeighbourOfFighters(int pNeiID, int pInd) throws Exception{
		Object vFiEle;
		List vRet = null;
		
		if ((pNeiID >= 0)){
			if (!fightList.isEmpty()){
				vRet = new List();
				
				fightList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
				
					if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getNeighbourElement(pNeiID).getFightMod(pInd));
					else throw new Exception("06; FiMan,gFMoNoFs");
				
					fightList.next();
				}
			} else throw new Exception("05; FiMan,gFMoNoFs");
		} else throw new Exception("07; FiMan,gFMoNoFs");
		
		return vRet;
	}
	/**	Dh	2.5.2020
	 * 
	 * @param pNeiID
	 * @return
	 * @throws Exception
	 */
	public List getFightModsOfNeighbourOfFighters(int pNeiID) throws Exception{
		Object vFiEle;
		List vRet = null;
		
		if ((pNeiID >= 0)){
			if (!fightList.isEmpty()){
				vRet = new List();
				
				fightList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
				
					if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getNeighbourElement(pNeiID).getFightMods());
					else throw new Exception("06; FiMan,gFMsoNoFs");
				
					fightList.next();
				}
			} else throw new Exception("05; FiMan,gFMsoNoFs");
		} else throw new Exception("07; FiMan,gFMsoNoFs");
		
		return vRet;
	}
	
	/**	Dh	3.5.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getEnemyTypeOfNeighboursOfFighters() throws Exception{
		Object vFiEle, vNeiEle;
		List vRet = null;
		
		if (!fightList.isEmpty()){
			vRet = new List();
			
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
			
				if (vFiEle instanceof FightElement) vRet.append(getEnemyTypeOfNeighboursOfFighter(((FightElement) vFiEle).getId()));
				else throw new Exception("06; FiMan,gEToNsoFs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gEToNsoFs");
				
		return vRet;
	}
	/**	Dh	3.5.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getDistanceOfNeighboursOfFighters() throws Exception{
		Object vFiEle, vNeiEle;
		List vRet = null;
		
		if (!fightList.isEmpty()){
			vRet = new List();
			
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
			
				if (vFiEle instanceof FightElement) vRet.append(getDistanceOfNeighboursOfFighter(((FightElement) vFiEle).getId()));
				else throw new Exception("06; FiMan,gDoNsoFs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gDoNsoFs");
				
		return vRet;
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getFightModOfNeighboursOfFighters(int pInd) throws Exception{
		Object vFiEle, vNeiEle;
		List vRet = null;
		
		if (!fightList.isEmpty()){
			vRet = new List();
			
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
			
				if (vFiEle instanceof FightElement) vRet.append(getFightModOfNeighboursOfFighter(((FightElement) vFiEle).getId(), pInd));
				else throw new Exception("06; FiMan,gFMoNsoFs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gFMoNsoFs");
				
		return vRet;
	}
	/**	Dh	3.5.2020
	 * 	
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getFightModsOfNeighboursOfFighters() throws Exception{
		Object vFiEle, vNeiEle;
		List vRet = null;
		
		if (!fightList.isEmpty()){
			vRet = new List();
			
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
			
				if (vFiEle instanceof FightElement) vRet.append(getFightModsOfNeighboursOfFighter(((FightElement) vFiEle).getId()));
				else throw new Exception("06; FiMan,gFMsoNsoFs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gFMsoNsoFs");
				
		return vRet;
	}
	//-----
	/**	Dh	2.5.2020
	 * 
	 * 	Gibt die Anzahl an Kampfnachbarn fuer eine spezifische Kaempfer*In wieder; Unabhaengig ihrer Gesinnung gegenueber der betreffenden Entitaet.
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int getNeighbourCountOfFighter(int pID) throws Exception{
		if (pID >= 0){
			try{ return getFightElement(pID).getNeighbourCount();}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,gNCoF");
	}
	/**	Dh	2.5.2020
	 * 
	 * 	Gibt die Anzahl an Kampfnachbarn der spezifischen Kaempfer*In an, die der gewaehlten Gesinnung entsprechen.
	 * 
	 * @param pID
	 * @param pEnemy
	 * @return
	 * @throws Exception
	 */
	public int getNeighbourCountByTypeOfFighter(int pID, boolean pEnemy) throws Exception{
		if (pID >= 0){
			try{ return getFightElement(pID).getNeighbourCountByType(pEnemy);}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,gNCbToF");
	}
	/**	2.5.2020
	 * 
	 * 	Gibt die Anzhal an Kaempfer*Innen an, mit welchen die entsprechende Kaempfer*In in Uerbzahl kaempft;
	 * 
	 * 	vRet kann auch negative Werte annehmen, was ein kaempfen in Unterzahl bedeutet.
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int getNeighbourMajorityNumberOfFighter(int pID) throws Exception{
		if (pID >= 0){
			try{ return getFightElement(pID).getNeighbourMajorityNumber();}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,gNMaNoF");
	}
	/**	2.5.2020
	 * 
	 * 	Gibt die Anzahl an Kaempfer*Innen an, mit welchen die entsprechende Kaempfer*In in Unterzahl gekaempft;
	 * 
	 * 	vRet kann auch negative Werte annehmen, was ein kaempfen in Unterzahl bedeutet.
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int getNeighbourMinorityNumberOfFighter(int pID) throws Exception{
		if (pID >= 0){
			try{ return getFightElement(pID).getNeighbourMinorityNumber();}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,gNMiNoF");
	}
	/**	2.5.2020
	 * 
	 * 	Gibt die Anzahl an Kaempfer*Innen an, mit welchen die durch pEnemy spezifizierte Partei in Ueberzahl kaempft;
	 * 
	 * 	vRet kann auch negative Werte annehmen, was ein kaempfen in Unterzahl bedeutet.
	 * 
	 * @param pID
	 * @param pEnemy
	 * @return
	 * @throws Exception
	 */
	public int getNeighbourMajorityNumberByTypeOfFighter(int pID, boolean pEnemy) throws Exception{
		if (pID >= 0){
			try{ return getFightElement(pID).getNeighbourMajorityNumberByType(pEnemy);}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,gNMaNbToF");
	}
	/**	Dh	2.5.2020
	 * 
	 * 	Gibt die Anzahl an Kaempfer*Innen an, mit welchen die durch pEnemy spezifizierte Partei in Unterzahl kaempft;
	 * 
	 * 	vRet kann auch negative Werte annehmen, was ein kaempfen in Unterzahl bedeutet.
	 * 
	 * @param pID
	 * @param pEnemy
	 * @return
	 * @throws Exception
	 */
	public int getNeighbourMinorityNumberByTypeOfFighter(int pID, boolean pEnemy) throws Exception{
		if (pID >= 0){
			try{ return getFightElement(pID).getNeighbourMinorityNumberByType(pEnemy);}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,gNMiNbToF");
	}
	
	/**	Dh	2.5.2020
	 * 
	 * 	Gibt die Anzahl an Kampfnachbarn fuer alle Kaempfer*In wieder; Unabhaengig ihrer Gesinnung gegenueber der betreffenden Entitaet.
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getNeighbourCountOfFighters() throws Exception{
		Object vFiEle;
		List vRet = null;
		
		if (!fightList.isEmpty()){
			vRet = new List();
			
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
			
				if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getNeighbourCount());
				else throw new Exception("06; FiMan,gNCoFs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gNCoFs");
		
		return vRet;
	}
	/**	Dh	2.5.2020
	 * 
	 * 	Gibt die Anzahl an Kampfnachbarn aller Kaempfer*In an, die der gewaehlten Gesinnung entsprechen.
	 * 
	 * @param pEnemy
	 * @return
	 * @throws Exception
	 */
	public List getNeighbourCountByTypeOfFighters(boolean pEnemy) throws Exception{
		Object vFiEle;
		List vRet = null;
		
		if (!fightList.isEmpty()){
			vRet = new List();
			
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
			
				if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getNeighbourCountByType(pEnemy));
				else throw new Exception("06; FiMan,gNCbEoFs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gNCbEoFs");
		
		return vRet;
	}
	/**	Dh	2.5.2020
	 * 
	 * 	Gibt die Anzhal an Kaempfer*Innen an, mit welchen jeweils alle Kaempfer*In fuer sich in Uerbzahl kaempfen;
	 * 
	 * 	vRet kann auch negative Werte annehmen, was ein kaempfen in Unterzahl bedeutet.
	 * 	
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getNeighbourMajorityNumberOfFighters() throws Exception{
		Object vFiEle;
		List vRet = null;
		
		if (!fightList.isEmpty()){
			vRet = new List();
			
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
			
				if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getNeighbourMajorityNumber());
				else throw new Exception("06; FiMan,gNMaNoFs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gNMaNoFs");
		
		return vRet;
	}
	/**	Dh	2.5.2020
	 * 
	 * 	Gibt die Anzahl an Kaempfer*Innen an, mit welchen alle Kaempfer*In fuer sich in Unterzahl gekaempfen;
	 * 
	 * 	vRet kann auch negative Werte annehmen, was ein kaempfen in Unterzahl bedeutet.
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getNeighbourMinorityNumberOfFighters() throws Exception{
		Object vFiEle;
		List vRet = null;
		
		if (!fightList.isEmpty()){
			vRet = new List();
			
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
			
				if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getNeighbourMinorityNumber());
				else throw new Exception("06; FiMan,gNMiNoFs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gNMiNoFs");
		
		return vRet;
	}
	/**	Dh	2.5.2020
	 * 
	 * 	Gibt die Anzahl an Kaempfer*Innen an, mit welchen die durch pEnemy spezifizierte Partei fuer alle Kaempfer*Innen spezifisch in Ueberzahl kaempft;
	 * 
	 * 	vRet kann auch negative Werte annehmen, was ein kaempfen in Unterzahl bedeutet.
	 * 
	 * @param pEnemy
	 * @return
	 * @throws Exception
	 */
	public List getNeighbourMajorityNumberByTypeOfFighters(boolean pEnemy) throws Exception{
		Object vFiEle;
		List vRet = null;
		
		if (!fightList.isEmpty()){
			vRet = new List();
			
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
			
				if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getNeighbourMajorityNumberByType(pEnemy));
				else throw new Exception("06; FiMan,gNMaNbToFs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gNMaNbToFs");
		
		return vRet;
	}
	/**	Dh	2.5.2020
	 * 
	 * 	Gibt die Anzahl an Kaempfer*Innen an, mit welchen die durch pEnemy spezifizierte Partei fuer alle Kaempfer*Innen in Unterzahl kaempft;
	 * 
	 * 	vRet kann auch negative Werte annehmen, was ein kaempfen in Unterzahl bedeutet.
	 * 
	 * @param pEnemy
	 * @return
	 * @throws Exception
	 */
	public List getNeighbourMinorityNumberByTypeOfFighters(boolean pEnemy) throws Exception{
		Object vFiEle;
		List vRet = null;
		
		if (!fightList.isEmpty()){
			vRet = new List();
			
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
			
				if (vFiEle instanceof FightElement) vRet.append(((FightElement) vFiEle).getNeighbourMinorityNumberByType(pEnemy));
				else throw new Exception("06; FiMan,gNMiNbToFs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gNMiNbToFs");
		
		return vRet;
	}
	//-----
	/**	Dh	3.5.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public IniElement getIniElement(int pID) throws Exception{
		IniElement vRet = null;
		Object vTemp = null;
		int vID = -1;
		
		if (pID >= 0){
			if (!iniList.isEmpty()){
				iniList.toFirst();
				while(!iniList.isEnd() && (vRet == null)){
					vTemp = iniList.getCurrent();
					
					if (vTemp instanceof IniElement){
						if (((IniElement)vTemp).getId() == pID) vRet = (IniElement)vTemp;
					} else throw new Exception("06; FiMan,gIE");
					
					iniList.next();
				}
			} else throw new Exception("05; FiMan,gIE");
		} else throw new Exception("02; FiMan,gIE");
		
		return vRet;
	}
	//-----
	/**	Dh	3.5.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getIdOfIniElements() throws Exception {
		Object vIniEle;
		List vRet;
		
		if (!iniList.isEmpty()){
			vRet = new List();
			
			iniList.toFirst();
			while(!iniList.isEnd()){
				vIniEle = iniList.getCurrent();
			
				if (vIniEle instanceof IniElement) vRet.append(((IniElement) vIniEle).getId());
				else throw new Exception("06; FiMan,gIDoIEs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gIDoIEs");
		
		return vRet;
	}
	
	/**	Dh	3.5.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int getIniOfIniElement(int pID) throws Exception {
		try{ return getIniElement(pID).getIni();}
		catch(Exception vExc) { throw vExc;}
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int getTempIniOfIniElement(int pID) throws Exception {
		try{ return getIniElement(pID).getTempIni();}
		catch(Exception vExc) { throw vExc;}
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int getActionOfIniElement(int pID) throws Exception {
		try{ return getIniElement(pID).getAction();}
		catch(Exception vExc) { throw vExc;}
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int getTempActionOfIniElement(int pID) throws Exception {
		try{ return getIniElement(pID).getTempAction();}
		catch(Exception vExc) { throw vExc;}
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int getIniDek(int pID) throws Exception {
		try{ return getIniElement(pID).getIniDek();}
		catch(Exception vExc) { throw vExc;}
	}
	
	/**	Dh	3.5.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getIniOfIniElements() throws Exception{
		Object vIniEle;
		List vRet;
		
		if (!iniList.isEmpty()){
			vRet = new List();
			
			iniList.toFirst();
			while(!iniList.isEnd()){
				vIniEle = iniList.getCurrent();
			
				if (vIniEle instanceof IniElement) vRet.append(((IniElement) vIniEle).getIni());
				else throw new Exception("06; FiMan,gIoIEs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gIoIEs");
		
		return vRet;
	}
	/**	Dh	3.5.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getTempIniOfIniElements() throws Exception{
		Object vIniEle;
		List vRet;
		
		if (!iniList.isEmpty()){
			vRet = new List();
			
			iniList.toFirst();
			while(!iniList.isEnd()){
				vIniEle = iniList.getCurrent();
			
				if (vIniEle instanceof IniElement) vRet.append(((IniElement) vIniEle).getTempIni());
				else throw new Exception("06; FiMan,gTIoIEs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gTIoIEs");
		
		return vRet;
	}
	/**	Dh	3.5.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getActionsOfIniElements() throws Exception{
		Object vIniEle;
		List vRet;
		
		if (!iniList.isEmpty()){
			vRet = new List();
			
			iniList.toFirst();
			while(!iniList.isEnd()){
				vIniEle = iniList.getCurrent();
			
				if (vIniEle instanceof IniElement) vRet.append(((IniElement) vIniEle).getAction());
				else throw new Exception("06; FiMan,gAoIEs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gAoIEs");
		
		return vRet;
	}
	/**	Dh	3.5.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getTempActionsOfIniElements() throws Exception{
		Object vIniEle;
		List vRet;
		
		if (!iniList.isEmpty()){
			vRet = new List();
			
			iniList.toFirst();
			while(!iniList.isEnd()){
				vIniEle = iniList.getCurrent();
			
				if (vIniEle instanceof IniElement) vRet.append(((IniElement) vIniEle).getTempAction());
				else throw new Exception("06; FiMan,gTAoIEs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gTAoIEs");
		
		return vRet;
	}
	/**	Dh	3.5.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	@XmlTransient
	public List getIniDekOfIniElements() throws Exception{
		Object vIniEle;
		List vRet;
		
		if (!iniList.isEmpty()){
			vRet = new List();
			
			iniList.toFirst();
			while(!iniList.isEnd()){
				vIniEle = iniList.getCurrent();
			
				if (vIniEle instanceof IniElement) vRet.append(((IniElement) vIniEle).getIniDek());
				else throw new Exception("06; FiMan,gIDoIEs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gIDoIEs");
		
		return vRet;
	}
	
	/**	Dh	20.5.2020
	 * 
	 * 	Gibt eine List mit den Ini-Werten der IniOrder wieder, die zu pID gehören.
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public List getInisOfIniOrderElement(int pID) throws Exception{
		List vRet = new List();
		int[] vIniOrderEle;
		
		if (pID >= 0) {
			if (!iniOrder.isEmpty()) {
				
				iniOrder.toFirst();
				while(!iniOrder.isEnd()) {
					vIniOrderEle = (int[])iniOrder.getCurrent();
					
					if (vIniOrderEle[0] == pID) {
						vRet.append(vIniOrderEle[1]);
					}
					
					iniOrder.next();
				}
			}
		}else throw new Exception("02; FiMan,gIsoIOE");
		
		return vRet;
	}
	/**	Dh	20.5.2020
	 * 
	 * 	Gibt eine List von Listen zurück, in welchen die jeweiligen Ini-Werte der IDs der pIDList, nach IDs sortiert, enthalten sind. 
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getInisOfIniOrderElements(List pIDList) throws Exception{
		Object vID;
		List vRet = new List();
		
		if (pIDList != null) {
			if ((!pIDList.isEmpty()) && (!iniOrder.isEmpty())){
				pIDList.toFirst();
				
				while (!pIDList.isEnd()) {
					vID = pIDList.getCurrent();
					
					if (vID instanceof Integer) {
						try{ vRet.append(getInisOfIniOrderElement((int)vID));}
						catch(Exception ex) {throw ex;}
					}
					else throw new Exception("06; FiMan,gIsoIOEs");
					
					pIDList.next();
				}
			}
		}else throw new Exception("04; FiMan,gIsoIOEs");
		
		return vRet;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	1.5.2020
	 * 	
	 * @param pID
	 * @throws Exception
	 */
	public void setId(int pID) throws Exception{
		if (pID >= 0) id = pID;
		else throw new Exception("02; FiMan,sID");
	}
	/**	Dh	6.5.2020
	 * 
	 * @param pRoundCounter
	 * @throws Exception
	 */
	public void setRoundCounter(int pRoundCounter) throws Exception{
		if (pRoundCounter >= 0) roundCounter = pRoundCounter;
		else throw new Exception("02; FiMan,sRC");
	}
	
	/**	Dh	1.5.2020
	 * 	
	 * @param pFightList
	 * @throws Exception
	 */
	public void setFightList(List pFightList) throws Exception{
		if (pFightList != null) fightList = pFightList;
		else throw new Exception("04; FiMan_sFL");
	}
	/**	Dh	1.5.2020
	 * 	
	 * @param pIniList
	 * @throws Exception
	 */
	public void setIniList(List pIniList) throws Exception{
		if (pIniList != null) {
			iniList = pIniList;

			updateIniList();
		}
		else throw new Exception("04; FiMan_sIL");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pIniOrder
	 * @throws Exception
	 */
	public void setIniOrder(List pIniOrder) throws Exception{
		if (pIniOrder != null) iniOrder = pIniOrder;
		else throw new Exception("04; FiMan_sIO");
	}
	//-----
	/**	Dh	23.2.2020
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Setzt den gewaehlten EigenschaftsModifikator fuer den*die gewaehlte*N Kaempfer*In(pID).
	 * 
	 * @param pID
	 * @param pPropMod
	 * @param pInd
	 * @throws Exception
	 */
	public void setPropModToFighter(int pID, int pPropMod, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 10)){
			try{ getFightElement(pID).setPropMod(pPropMod, pInd);}
			catch (Exception vExc) {throw vExc;}
		} else throw new Exception("07; FiMan,sPMF");
	}
	/**	Dh	20.5.2020
	 * 
	 * 	Setzt den gewaehlten StatusModifikator fuer den*die gewaehlte*N Kaempfer*In(pID).
	 * 		Wenn es der Ini-Basiswert ist, dann wird der Wert auch dem entsprechenden IniElement
	 * 		hinzugefuegt.
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pID
	 * @param pStatMod
	 * @param pInd
	 * @throws Exception
	 */
	public void setStatModToFighter(int pID, int pStatMod, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 10)){
			try{
				if (pInd == 6) setIniOfIniElement(pID, (int)Math.round(pStatMod));
				getFightElement(pID).setStatMod(pStatMod, pInd);
			} catch (Exception vExc) {throw vExc;}
		} else throw new Exception("07; FiMan,sSMF");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pID
	 * @param pActiveWeapon
	 * @param pInd
	 * @throws Exception
	 */
	public void setActiveWeaponOfFighter(int pID, Weapon pActiveWeapon, int pUseType, int pInd) throws Exception {
		if ((pID >= 0) && (pInd >= 0)) {
			try {getFightElement(pID).setActiveWeapon(pActiveWeapon, pUseType, pInd);}
			catch(Exception ex) {throw ex;}
		}else throw new Exception("02; FiMan,sAWoF");
	}
	/**	Dh	17.7.2020
	 * 
	 * @param pFighterID
	 * @param pWeaponID
	 * @param pUseType
	 * @throws Exception
	 */
	public void setActiveWeaponUseTypeOfFighter(int pFighterID, int pWeaponID, int pUseType) throws Exception {
		if (pFighterID >= 0) {
			try {getFightElement(pFighterID).setActiveWeaponUseType(pWeaponID, pUseType);}
			catch(Exception ex) {throw ex;}
		}else throw new Exception("02; FiMan,sAWUToF");
	}
	
	/**	Dh	23.2.2020
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Setzt die EigenschaftsModifikatoren fuer den*die gewaehlte*N Kaempfer*In(pID).
	 * 
	 * @param pID
	 * @param pPropMods
	 * @throws Exception
	 */
	public void setPropModsToFighter(int pID, int[] pPropMods) throws Exception{
		if (pPropMods != null){
			if (pPropMods.length == 10){
				try{ getFightElement(pID).setPropMods(pPropMods);}
				catch (Exception vExc) {throw vExc;}
			} else throw new Exception("01; FiMan,sPMsF");
		} else throw new Exception("04; FiMan,sPMsF");
	}
	/**	Dh	20.5.2020
	 * 
	 * 	Setzt die StatusModifikatoren fuer den*die gewaehlte*N Kaempfer*In(pID).
	 * 		Wenn es der Ini-Basiswert ist, dann wird der Wert auch dem entsprechenden IniElement
	 * 		hinzugefuegt.
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * 	Setzt die StatusModifikatoren fuer den*die gewaehlte*N Kaempfer*In(pID).
	 * 
	 * @param pID
	 * @param pStatMods
	 * @throws Exception
	 */
	public void setStatModsToFighter(int pID, int[] pStatMods) throws Exception{
		if (pStatMods != null){
			if (pStatMods.length == 10){
				try{
					if (pStatMods[6] != 0) setIniOfIniElement(pID, (int)Math.round(pStatMods[6]));
					getFightElement(pID).setStatMods(pStatMods);
				} catch (Exception vExc) {throw vExc;}
			} else throw new Exception("04; FiMan,sSMsF");
		} else throw new Exception("04; FiMan,sSMsF");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pID
	 * @param pActiveWeapons
	 * @throws Exception
	 */
	public void setActiveWeaponsOfFighter(int pID, Object[][] pActiveWeapons) throws Exception{
		if (pID >= 0) {
			try {getFightElement(pID).setActiveWeapons(pActiveWeapons);}
			catch(Exception ex) {throw ex;}
		}else throw new Exception("02; FiMan,sAWsoF");
	}

	/**	Dh	23.2.2020
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Setzt den gewaehlten EigenschaftsModifikator fuer alle Kaempfer*Innen.
	 * 
	 * @param pPropMod
	 * @param pInd
	 * @throws Exception
	 */
	public void setPropModToFighters(int pPropMod, int pInd) throws Exception{
		Object vFiEle;
		
		if ((pInd >= 0) && (pInd < 10)){
			if (!fightList.isEmpty()){
				fightList.toFirst();
				while (!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
				
					if (vFiEle instanceof FightElement) ((FightElement) vFiEle).setPropMod(pPropMod, pInd);
					else throw new Exception("06; FiMan,sPMFs");
				
					fightList.next();
				}
			} else throw new Exception("05; FiMan,sPMFs");
		} else throw new Exception("07; FiMan,sPMFs");
	}
	/**	Dh	1.5.2020
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Setzt EigenschaftsModifikatoren der Liste fuer die entsprechenden Kaempfer*Innen.
	 * 
	 * @param pPropsModList
	 * @param pInd
	 * @throws Exception
	 */
	public void setPropsModToFighters(List pPropsModList, int pInd) throws Exception{
		Object vFiEle, vPrEle;
		
		if ((pInd >= 0) && (pInd < 10)){
			if (!fightList.isEmpty() && !pPropsModList.isEmpty()){
				if (fightList.getContentNumber() == pPropsModList.getContentNumber()) {
					fightList.toFirst();
					pPropsModList.toFirst();
					while (!fightList.isEnd()){
						vFiEle = fightList.getCurrent();
						vPrEle = pPropsModList.getCurrent();
						
						if ((vFiEle instanceof FightElement)&& (vPrEle instanceof Integer)) ((FightElement) vFiEle).setPropMod((int)vPrEle, pInd);
						else throw new Exception("06; FiMan,sPsMFs");
				
						fightList.next();
						pPropsModList.next();
					}
				} else throw new Exception("01; FiMan,sPsMFs");
			} else throw new Exception("05; FiMan,sPsMFs");
		} else throw new Exception("07; FiMan,sPsMFs");
	}
	/**	Dh	20.5.2020
	 * 
	 * 	Setzt den gewaehlten StatusModifikator fuer alle Kaempfer*Innen.
	 * 		Wenn es der Ini-Basiswert ist, dann wird der Wert auch dem entsprechenden IniElement
	 * 		hinzugefuegt.
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pStatMod
	 * @param pInd
	 * @throws Exception
	 */
	public void setStatModToFighters(int pStatMod, int pInd) throws Exception{
		Object vFiEle;
		
		if ((pInd >= 0) && (pInd < 10)){
			if (!fightList.isEmpty()){
				fightList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
				
					if (vFiEle instanceof FightElement) {
						if (pInd == 6) setIniOfIniElement(((FightElement) vFiEle).getId(), (int)Math.round(pStatMod));
						((FightElement) vFiEle).setStatMod(pStatMod, pInd);
					}
					else throw new Exception("06; FiMan,sSMFs");
				
					fightList.next();
				}
			} else throw new Exception("05; FiMan,sSMFs");
		} else throw new Exception("07; FiMan,sSMFs");
	}
	/**	Dh	20.5.2020
	 * 
	 * 	Setzt StatusModifikatoren der Liste fuer die entsprechenden Kaempfer*Innen.
	 * 		Wenn es der Ini-Basiswert ist, dann wird der Wert auch dem entsprechenden IniElement
	 * 		hinzugefuegt.
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pStatsModList
	 * @param pInd
	 * @throws Exception
	 */
	public void setStatsModToFighters(List pStatsModList, int pInd) throws Exception{
		Object vFiEle, vPrEle;
		
		if ((pInd >= 0) && (pInd < 10)){
			if (!fightList.isEmpty() && !pStatsModList.isEmpty()){
				if (fightList.getContentNumber() == pStatsModList.getContentNumber()) {
					fightList.toFirst();
					pStatsModList.toFirst();
					while (!fightList.isEnd()){
						vFiEle = fightList.getCurrent();
						vPrEle = pStatsModList.getCurrent();
						
						if ((vFiEle instanceof FightElement)&& (vPrEle instanceof Integer)) {
							if (pInd == 6) setIniOfIniElement(((FightElement) vFiEle).getId(), (int)Math.round((int)vPrEle));
							((FightElement) vFiEle).setStatMod((int)vPrEle, pInd);
						}
						else throw new Exception("06; FiMan,sSsMFs");
				
						fightList.next();
						pStatsModList.next();
					}
				} else throw new Exception("01; FiMan,sSsMFs");
			} else throw new Exception("05; FiMan,sSsMFs");
		} else throw new Exception("07; FiMan,sSsMFs");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 	
	 * @param pActiveWeapon
	 * @param pInd
	 * @throws Exception
	 */
	public void setActiveWeaponOfFighters(Weapon pActiveWeapon, int pUseType, int pInd) throws Exception{
		if (pInd >= 0) {
			if (!fightList.isEmpty()) {
				fightList.toFirst();
				
				while(!fightList.isLast()) {			
					try {((FightElement)fightList.getCurrent()).setActiveWeapon(pActiveWeapon, pUseType, pInd);}
					catch (Exception ex) {throw ex;}
					
					fightList.next();
				}
			}else throw new Exception("05; FiMan,sAWoFs");
		}else throw new Exception("02; FiMan,sAWoFs");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pActiveWeaponList
	 * @param pInd
	 * @throws Exception
	 */
	public void setActiveWeaponsOfFighters(List pActiveWeaponList, int pInd) throws Exception{
		Object vTempWeapon;
		
		if (pInd >= 0) {
			if (pActiveWeaponList != null) {
				if (pActiveWeaponList.getContentNumber() == fightList.getContentNumber()) {
					if (!fightList.isEmpty()) {
						fightList.toFirst();
						pActiveWeaponList.toFirst();
						
						while(!fightList.isLast()) {		
							vTempWeapon = pActiveWeaponList.getCurrent();
							
							if (vTempWeapon instanceof Object[]) {
								if ((((Object[])vTempWeapon)[0] instanceof Weapon) && (((Object[])vTempWeapon)[1] instanceof Integer)) {
									try {((FightElement)fightList.getCurrent()).setActiveWeapon((Weapon)((Object[])vTempWeapon)[0], (int)((Object[])vTempWeapon)[1], pInd);}
									catch (Exception ex) {throw ex;}
								} else throw new Exception("06; FiMan,sAWoFs");
							} else throw new Exception("02; FiMan,sAWoFs");
							
							pActiveWeaponList.toFirst();
							fightList.next();
						}
					}else throw new Exception("05; FiMan,sAWoFs");
				} else throw new Exception("01; FiMan,sAWoFs");
			}else throw new Exception("04; FiMan,sAWoFs");
		}else throw new Exception("02; FiMan,sAWoFs");
	}
	
	/**	Dh	23.2.2020
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Setzt die EigenschaftsModifikatoren fuer alle Kaempfer*Innen.
	 * 
	 * @param pPropMods
	 * @throws Exception
	 */
	public void setPropModsToFighters(int[] pPropMods) throws Exception{
		Object vFiEle;
		
		if (pPropMods != null){
			if (pPropMods.length == 10){
				if (!fightList.isEmpty()){
					fightList.toFirst();
				
					while(!fightList.isEnd()){
						vFiEle = fightList.getCurrent();
					
						if (vFiEle instanceof FightElement) ((FightElement) vFiEle).setPropMods(pPropMods);
						else throw new Exception("06; FiMan,sPMsFs");
					
						fightList.next();
					}
				} else throw new Exception("05; FiMan,sPMsFs");
			} else throw new Exception("01; FiMan,sPMsFs");
		} else throw new Exception("04; FiMan,sPMsFs");
	}
	/**	Dh	1.5.2020
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Setzt EigenschaftsModifikatoren der Liste fuer die entsprechenden Kaempfer*Innen.
	 * 
	 * @param pPropsModsList
	 * @throws Exception
	 */
	public void setPropsModsToFighters(List pPropsModsList) throws Exception{
		Object vFiEle, vPrEle;
		
		if (!fightList.isEmpty() && !pPropsModsList.isEmpty()){
			if (fightList.getContentNumber() == pPropsModsList.getContentNumber()) {
				fightList.toFirst();
				pPropsModsList.toFirst();
				while (!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
					vPrEle = pPropsModsList.getCurrent();
						
					if ((vFiEle instanceof FightElement)&& (vPrEle instanceof Integer)) ((FightElement) vFiEle).setPropMods((int[])vPrEle);
					else throw new Exception("06; FiMan,sPsMFs");
			
					fightList.next();
					pPropsModsList.next();
				}
			} else throw new Exception("01; FiMan,sPsMFs");
		} else throw new Exception("05; FiMan,sPsMFs");
	}
	/**	Dh	20.5.2020
	 * 
	 * 	Setzt die StatusModifikatoren fuer alle Kaempfer*Innen.
	 * 		Wenn es der Ini-Basiswert ist, dann wird der Wert auch dem entsprechenden IniElement
	 * 		hinzugefuegt.
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pStatMods
	 * @throws Exception
	 */
	public void setStatModsToFighters(int[] pStatMods) throws Exception{
		Object vFiEle;
		
		if (pStatMods != null){
			if (pStatMods.length == 10){
				if (!fightList.isEmpty()){
					fightList.toFirst();
				
					while(!fightList.isEnd()){
						vFiEle = fightList.getCurrent();
					
						if (vFiEle instanceof FightElement) {
							if(pStatMods[6] != 0) setIniOfIniElement(((FightElement) vFiEle).getId(), (int)Math.round(pStatMods[6]));
							((FightElement) vFiEle).setStatMods(pStatMods);
						}
						else throw new Exception("06; FiMan,sSMsFs");
					
						fightList.next();
					}
				} else throw new Exception("05; FiMan,sSMsFs");
			} else throw new Exception("01; FiMan,sSMsFs");
		} else throw new Exception("04; FiMan,sSMsFs");
	}
	/**	Dh	20.5.2020
	 * 	
	 * 	Setzt StatusModifikatoren der Liste fuer die entsprechenden Kaempfer*Innen.
	 * 		Wenn es der Ini-Basiswert ist, dann wird der Wert auch dem entsprechenden IniElement
	 * 		hinzugefuegt.
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pStatsModsList
	 * @throws Exception
	 */
	public void setStatModsToFighters(List pStatsModsList) throws Exception{
		Object vFiEle, vPrEle;
		
		if (!fightList.isEmpty() && !pStatsModsList.isEmpty()){
			if (fightList.getContentNumber() == pStatsModsList.getContentNumber()) {
				fightList.toFirst();
				pStatsModsList.toFirst();
				while (!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
					vPrEle = pStatsModsList.getCurrent();
						
					if ((vFiEle instanceof FightElement) && (vPrEle instanceof Integer[])) {
						if (((double[])vPrEle)[6] != 0) setIniOfIniElement(((FightElement) vFiEle).getId(), (int)Math.round(((int[])vPrEle)[6]));
						((FightElement) vFiEle).setStatMods((int[])vPrEle);
					}
					else throw new Exception("06; FiMan,sSsMFs");
			
					fightList.next();
					pStatsModsList.next();
				}
			} else throw new Exception("01; FiMan,sSsMFs");
		} else throw new Exception("05; FiMan,sSsMFs");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pActiveWeapon
	 * @throws Exception
	 */
	public void setActiveWeaponsOfFighters(Object[][] pActiveWeapon) throws Exception{
		if (!fightList.isEmpty()){
			fightList.toFirst();
			while(!fightList.isEnd()){
				((FightElement)fightList.getCurrent()).setActiveWeapons(pActiveWeapon);
				
				fightList.next();
			}
		} else throw new Exception("05; FiMan,sAWsoFs");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pActiveWeaponList
	 * @throws Exception
	 */
	public void setActiveWeaponsOfFighters(List pActiveWeaponList) throws Exception{
		Object vCur;
		
		if (pActiveWeaponList != null) {
			if (pActiveWeaponList.getContentNumber() == fightList.getContentNumber()) {
				if (!fightList.isEmpty()){
					fightList.toFirst();
					pActiveWeaponList.toFirst();
					
					while(!fightList.isEnd()){
						vCur = pActiveWeaponList.getCurrent();
						
						if (vCur instanceof Object[][]) {
							try{ ((FightElement)fightList.getCurrent()).setActiveWeapons((Object[][])vCur);}
							catch(Exception ex) {throw ex;}
						}
						
						pActiveWeaponList.next();
						fightList.next();
					}
				} else throw new Exception("05; FiMan,sAWsoFs");
			}else throw new Exception("01; FiMan,sAWsoFs");
		}else throw new Exception("04; FiMan,sAWsoFs");
	}
	//-----
	/**	Dh	3.5.2020
	 * 
	 * @param pID
	 * @param pNeiList
	 * @throws Exception
	 */
	public void setNeighbourListOfFighter(int pID, List pNeiList) throws Exception{
		if (pID >= 0){
			try{ getFightElement(pID).setNeighbourList(pNeiList);}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,sNLoF");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pNeiList
	 * @throws Exception
	 */
	public void setNeighbourListOfFighters(List pNeiList) throws Exception {
		Object vFiEle;
		
		if (!fightList.isEmpty()){
			fightList.toFirst();
			while(!fightList.isEnd()){
				vFiEle = fightList.getCurrent();
			
				if (vFiEle instanceof FightElement) ((FightElement) vFiEle).setNeighbourList(pNeiList);
				else throw new Exception("06; FiMan,sNLoFs");
			
				fightList.next();
			}
		} else throw new Exception("05; FiMan,gNLoFs");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pNeiList
	 * @throws Exception
	 */
	public void setNeighbourListsOfFighters(List pNeiList) throws Exception{
		Object vFiEle, vNeiList;
		
		if (fightList.getContentNumber() == pNeiList.getContentNumber()) {
			if (!fightList.isEmpty()){
				fightList.toFirst();
				pNeiList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
					vNeiList = pNeiList.getCurrent();
					
					if ((vFiEle instanceof FightElement) && (vNeiList instanceof List)) ((FightElement) vFiEle).setNeighbourList((List)vNeiList);
					else throw new Exception("06; FiMan,sNLsoFs");
			
					fightList.next();
					pNeiList.next();
				}
			}
		} else throw new Exception("01; FiMan,sNLsoFs");
	}
	//-----
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @param pNeiID
	 * @param pEnemyType
	 * @throws Exception
	 */
	public void setEnemyTypeOfNeighbourOfFighter(int pFigID, int pNeiID, boolean pEnemyType) throws Exception{
		if ((pFigID >= 0) && (pNeiID >= 0)){
			try{ getFightElement(pFigID).getNeighbourElement(pNeiID).setEnemy(pEnemyType);}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,sEToNoF");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @param pNeiID
	 * @param pDistance
	 * @throws Exception
	 */
	public void setDistanceOfNeighbourOfFighter(int pFigID, int pNeiID, int pDistance) throws Exception{
		if ((pFigID >= 0) && (pNeiID >= 0)){
			try{ getFightElement(pFigID).getNeighbourElement(pNeiID).setDistance(pDistance);}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,sDoNoF");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @param pNeiID
	 * @param pInd
	 * @param pFightMod
	 * @throws Exception
	 */
	public void setFightModOfNeighbourOfFighter(int pFigID, int pNeiID, double pFightMod, int pInd) throws Exception{
		if ((pFigID >= 0) && (pNeiID >= 0)){
			try{ getFightElement(pFigID).getNeighbourElement(pNeiID).setFightMod(pFightMod, pInd);}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,sFMoNoF");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @param pNeiID
	 * @param pFightMods
	 * @throws Exception
	 */
	public void setFightModsOfNeighbourOfFighter(int pFigID, int pNeiID, double[] pFightMods) throws Exception{
		if ((pFigID >= 0) && (pNeiID >= 0)){
			try{ getFightElement(pFigID).getNeighbourElement(pNeiID).setFightMods(pFightMods);}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,sFMsoNoF");
	}
	
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @param pEnemyType
	 * @throws Exception
	 */
	public void setEnemyTypeOfNeighboursOfFighter(int pFigID, boolean pEnemyType) throws Exception{
		Object vNeiEle;
		List vNeiList = null;
		
		if (pFigID >= 0){
			vNeiList = getFightElement(pFigID).getNeighbourList();
				
			if (!vNeiList.isEmpty()){
				
				vNeiList.toFirst();
				while(!vNeiList.isEnd()){
					vNeiEle = vNeiList.getCurrent();
				
					if (vNeiEle instanceof NeighbourElement) ((NeighbourElement) vNeiEle).setEnemy(pEnemyType);
					else throw new Exception("06; FiMan,sEToNsoF");
				
					vNeiList.next();
				}
			} else throw new Exception("05; FiMan,sEToNsoF");
		} else throw new Exception("07; FiMan,sEToNsoF");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @param pDistance
	 * @throws Exception
	 */
	public void setDistanceOfNeighboursOfFighter(int pFigID, int pDistance) throws Exception{
		Object vNeiEle;
		List vNeiList = null;
		
		if (pFigID >= 0){
			vNeiList = getFightElement(pFigID).getNeighbourList();
				
			if (!vNeiList.isEmpty()){
				vNeiList.toFirst();
				while(!vNeiList.isEnd()){
					vNeiEle = vNeiList.getCurrent();
				
					if (vNeiEle instanceof NeighbourElement) ((NeighbourElement) vNeiEle).setDistance(pDistance);
					else throw new Exception("06; FiMan,sDoNsoF");
				
					vNeiList.next();
				}
			} else throw new Exception("05; FiMan,sDoNsoF");
		} else throw new Exception("07; FiMan,sDoNsoF");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @param pFightMod
	 * @param pInd
	 * @throws Exception
	 */
	public void setFightModOfNeighboursOfFighter(int pFigID, double pFightMod, int pInd) throws Exception{
		Object vNeiEle;
		List vNeiList = null;
		
		if (pFigID >= 0){
			vNeiList = getFightElement(pFigID).getNeighbourList();
				
			if (!vNeiList.isEmpty()){
				vNeiList.toFirst();
				while(!vNeiList.isEnd()){
					vNeiEle = vNeiList.getCurrent();
				
					if (vNeiEle instanceof NeighbourElement) ((NeighbourElement) vNeiEle).setFightMod(pFightMod, pInd);
					else throw new Exception("06; FiMan,sFMoNsoF");
				
					vNeiList.next();
				}
			} else throw new Exception("05; FiMan,sFMoNsoF");
		} else throw new Exception("07; FiMan,sFMoNsoF");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @param pFightMods
	 * @throws Exception
	 */
	public void setFightModsOfNeighboursOfFighter(int pFigID, double[] pFightMods) throws Exception{
		Object vNeiEle;
		List vNeiList = null;
		
		if (pFigID >= 0){
			vNeiList = getFightElement(pFigID).getNeighbourList();
				
			if (!vNeiList.isEmpty()){
				vNeiList.toFirst();
				while(!vNeiList.isEnd()){
					vNeiEle = vNeiList.getCurrent();
				
					if (vNeiEle instanceof NeighbourElement) ((NeighbourElement) vNeiEle).setFightMods(pFightMods);
					else throw new Exception("06; FiMan,sFMsoNsoF");
				
					vNeiList.next();
				}
			} else throw new Exception("05; FiMan,sFMsoNsoF");
		} else throw new Exception("07; FiMan,sFMsoNsoF");
	}
	
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @param pEnemyTypeList
	 * @throws Exception
	 */
	public void setEnemyTypesOfNeighboursOfFighter(int pFigID, List pEnemyTypeList) throws Exception{
		Object vNeiEle, vEnemyType;
		List vNeiList = null;
		
		if (pFigID >= 0){
			vNeiList = getFightElement(pFigID).getNeighbourList();
				
			if (vNeiList.getContentNumber() == pEnemyTypeList.getContentNumber()){
				vNeiList.toFirst();
				pEnemyTypeList.toFirst();
				while(!vNeiList.isEnd()){
					vNeiEle = vNeiList.getCurrent();
					vEnemyType = pEnemyTypeList.getCurrent();
				
					if ((vNeiEle instanceof NeighbourElement) && (vEnemyType instanceof Boolean)) ((NeighbourElement) vNeiEle).setEnemy((boolean) vEnemyType);
					else throw new Exception("06; FiMan,sETsoNsoF");
				
					vNeiList.next();
					pEnemyTypeList.next();
				}
			} else throw new Exception("01; FiMan,sETsoNsoF");
		} else throw new Exception("07; FiMan,sETsoNsoF");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @param pDistanceList
	 * @throws Exception
	 */
	public void setDistancesOfNeighboursOfFighter(int pFigID, List pDistanceList) throws Exception{
		Object vNeiEle, vDistance;
		List vNeiList = null;
		
		if (pFigID >= 0){
			vNeiList = getFightElement(pFigID).getNeighbourList();
				
			if (vNeiList.getContentNumber() == pDistanceList.getContentNumber()){
				vNeiList.toFirst();
				pDistanceList.toFirst();
				while(!vNeiList.isEnd()){
					vNeiEle = vNeiList.getCurrent();
					vDistance = pDistanceList.getCurrent();
				
					if ((vNeiEle instanceof NeighbourElement) && (vDistance instanceof Integer)) ((NeighbourElement) vNeiEle).setDistance((int) vDistance);
					else throw new Exception("06; FiMan,sDsoNsoF");
				
					vNeiList.next();
					pDistanceList.next();
				}
			} else throw new Exception("01; FiMan,sDsoNsoFs");
		} else throw new Exception("07; FiMan,sDsoNsoF");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @param pFightModList
	 * @param pInd
	 * @throws Exception
	 */
	public void setFightModsOfNeighboursOfFighter(int pFigID, List pFightModList, int pInd) throws Exception{
		Object vNeiEle, vFightMod;
		List vNeiList = null;
		
		if (pFigID >= 0){
			vNeiList = getFightElement(pFigID).getNeighbourList();
				
			if (vNeiList.getContentNumber() == pFightModList.getContentNumber()){
				vNeiList.toFirst();
				pFightModList.toFirst();
				while(!vNeiList.isEnd()){
					vNeiEle = vNeiList.getCurrent();
					vFightMod = pFightModList.getCurrent();
				
					if ((vNeiEle instanceof NeighbourElement) && (vFightMod instanceof Double)) ((NeighbourElement) vNeiEle).setFightMod((double) vFightMod, pInd);
					else throw new Exception("06; FiMan,sFMsoNsoF");
				
					vNeiList.next();
					pFightModList.next();
				}
			} else throw new Exception("01; FiMan,sFMsoNsoFs");
		} else throw new Exception("07; FiMan,sFMsoNsoF");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @param pFightModsList
	 * @throws Exception
	 */
	public void setFightModssOfNeighboursOfFighter(int pFigID, List pFightModsList) throws Exception{
		Object vNeiEle, vFightMods;
		List vNeiList = null;
		
		if (pFigID >= 0){
			vNeiList = getFightElement(pFigID).getNeighbourList();
				
			if (vNeiList.getContentNumber() == pFightModsList.getContentNumber()){
				vNeiList.toFirst();
				pFightModsList.toFirst();
				while(!vNeiList.isEnd()){
					vNeiEle = vNeiList.getCurrent();
					vFightMods = pFightModsList.getCurrent();
				
					if ((vNeiEle instanceof NeighbourElement) && (vFightMods instanceof Double[])) ((NeighbourElement) vNeiEle).setFightMods((double[]) vFightMods);
					else throw new Exception("06; FiMan,sFMssoNsoF");
				
					vNeiList.next();
					pFightModsList.next();
				}
			} else throw new Exception("01; FiMan,sFMssoNsoFs");
		} else throw new Exception("07; FiMan,sFMssoNsoF");
	}
	
	/**	Dh	3.5.2020
	 * 
	 * @param pNeiID
	 * @param pEnemyType
	 * @throws Exception
	 */
	public void setEnemyTypeOfNeighbourOfFighters(int pNeiID, boolean pEnemyType) throws Exception{
		Object vFiEle;
		
		if ((pNeiID >= 0)){
			if (!fightList.isEmpty()){				
				fightList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
				
					if (vFiEle instanceof FightElement) ((FightElement) vFiEle).getNeighbourElement(pNeiID).setEnemy(pEnemyType);
					else throw new Exception("06; FiMan,sEToNoFs");
				
					fightList.next();
				}
			} else throw new Exception("05; FiMan,sEToNoFs");
		} else throw new Exception("07; FiMan,sEToNoFs");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pNeiID
	 * @param pDistance
	 * @throws Exception
	 */
	public void setDistanceOfNeighbourOfFighters(int pNeiID, int pDistance) throws Exception{
		Object vFiEle;
		
		if ((pNeiID >= 0)){
			if (!fightList.isEmpty()){
				fightList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
				
					if (vFiEle instanceof FightElement) ((FightElement) vFiEle).getNeighbourElement(pNeiID).setDistance(pDistance);
					else throw new Exception("06; FiMan,sDoNoFs");
				
					fightList.next();
				}
			} else throw new Exception("05; FiMan,sDoNoFs");
		} else throw new Exception("07; FiMan,sDoNoFs");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pNeiID
	 * @param pFightMod
	 * @param pInd
	 * @throws Exception
	 */
	public void setFightModOfNeighbourOfFighters(int pNeiID, double pFightMod, int pInd) throws Exception{
		Object vFiEle;
		
		if ((pNeiID >= 0)){
			if (!fightList.isEmpty()){
				fightList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
				
					if (vFiEle instanceof FightElement) ((FightElement) vFiEle).getNeighbourElement(pNeiID).setFightMod(pFightMod, pInd);
					else throw new Exception("06; FiMan,sFMoNoFs");
				
					fightList.next();
				}
			} else throw new Exception("05; FiMan,sFMoNoFs");
		} else throw new Exception("07; FiMan,sFMoNoFs");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pNeiID
	 * @param pFightMods
	 * @throws Exception
	 */
	public void setFightModsOfNeighbourOfFighters(int pNeiID, double[] pFightMods) throws Exception{
		Object vFiEle;
		
		if ((pNeiID >= 0)){
			if (!fightList.isEmpty()){
				fightList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
				
					if (vFiEle instanceof FightElement) ((FightElement) vFiEle).getNeighbourElement(pNeiID).setFightMods(pFightMods);
					else throw new Exception("06; FiMan,sFMsoNoFs");
				
					fightList.next();
				}
			} else throw new Exception("05; FiMan,sFMsoNoFs");
		} else throw new Exception("07; FiMan,sFMsoNoFs");
	}
	
	/**	Dh	3.5.2020
	 * 
	 * @param pEnemyTypeList
	 * @throws Exception
	 */
	public void setEnemyTypeOfNeighboursOfFighters(List pEnemyTypeList) throws Exception{
		Object vFiEle, vEnemyType;
		
		if (fightList.getContentNumber() == pEnemyTypeList.getContentNumber()) {
			if (!fightList.isEmpty()){
				fightList.toFirst();
				pEnemyTypeList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
					vEnemyType = pEnemyTypeList.getCurrent();
					
					if ((vFiEle instanceof FightElement) && (vEnemyType instanceof Boolean)) setEnemyTypeOfNeighboursOfFighter(((FightElement) vFiEle).getId(), (boolean)vEnemyType);
					else throw new Exception("06; FiMan,sEToNsoFs");
			
					fightList.next();
					pEnemyTypeList.next();
				}
			}
		} else throw new Exception("01; FiMan,sEToNsoFs");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pDistanceList
	 * @throws Exception
	 */
	public void setDistanceOfNeighboursOfFighters(List pDistanceList) throws Exception{
		Object vFiEle, vDistance;
		
		if (fightList.getContentNumber() == pDistanceList.getContentNumber()) {
			if (!fightList.isEmpty()){
				fightList.toFirst();
				pDistanceList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
					vDistance = pDistanceList.getCurrent();
					
					if ((vFiEle instanceof FightElement) && (vDistance instanceof Integer)) setDistanceOfNeighboursOfFighter(((FightElement) vFiEle).getId(), (int)vDistance);
					else throw new Exception("06; FiMan,sDoNsoFs");
			
					fightList.next();
					pDistanceList.next();
				}
			}
		} else throw new Exception("01; FiMan,sDoNsoFs");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFightModList
	 * @param pInd
	 * @throws Exception
	 */
	public void setFightModOfNeighboursOfFighters(List pFightModList, int pInd) throws Exception{
		Object vFiEle, vFightMod;
		
		if (fightList.getContentNumber() == pFightModList.getContentNumber()) {
			if (!fightList.isEmpty()){
				fightList.toFirst();
				pFightModList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
					vFightMod = pFightModList.getCurrent();
					
					if ((vFiEle instanceof FightElement) && (vFightMod instanceof Double)) setFightModOfNeighboursOfFighter(((FightElement) vFiEle).getId(), (double)vFightMod, pInd);
					else throw new Exception("06; FiMan,sFMoNsoFs");
			
					fightList.next();
					pFightModList.next();
				}
			}
		} else throw new Exception("01; FiMan,sFMoNsoFs");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFightModsList
	 * @throws Exception
	 */
	public void setFightModsOfNeighboursOfFighters(List pFightModsList) throws Exception{
		Object vFiEle, vFightMods;
		
		if (fightList.getContentNumber() == pFightModsList.getContentNumber()) {
			if (!fightList.isEmpty()){
				fightList.toFirst();
				pFightModsList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
					vFightMods = pFightModsList.getCurrent();
					
					if ((vFiEle instanceof FightElement) && (vFightMods instanceof Double[])) setFightModsOfNeighboursOfFighter(((FightElement) vFiEle).getId(), (double[])vFightMods);
					else throw new Exception("06; FiMan,sFMsoNsoFs");
			
					fightList.next();
					pFightModsList.next();
				}
			}
		} else throw new Exception("01; FiMan,sFMsoNsoFs");
	}
	
	/**	Dh	3.5.2020
	 * 
	 * @param pEnemyTypeList
	 * @throws Exception
	 */
	public void setEnemyTypesOfNeighboursOfFighters(List pEnemyTypeList) throws Exception{
		Object vFiEle, vEnemyTypeList;
		
		if (fightList.getContentNumber() == pEnemyTypeList.getContentNumber()) {
			if (!fightList.isEmpty()){
				fightList.toFirst();
				pEnemyTypeList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
					vEnemyTypeList = pEnemyTypeList.getCurrent();
					
					if ((vFiEle instanceof FightElement) && (vEnemyTypeList instanceof List)) setEnemyTypesOfNeighboursOfFighter(((FightElement) vFiEle).getId(), (List)vEnemyTypeList);
					else throw new Exception("06; FiMan,sETsoNsoFs");
			
					fightList.next();
					pEnemyTypeList.next();
				}
			}
		} else throw new Exception("01; FiMan,sETsoNsoFs");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pDistanceList
	 * @throws Exception
	 */
	public void setDistancesOfNeighboursOfFighters(List pDistanceList) throws Exception{
		Object vFiEle, vDistanceList;
		
		if (fightList.getContentNumber() == pDistanceList.getContentNumber()) {
			if (!fightList.isEmpty()){
				fightList.toFirst();
				pDistanceList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
					vDistanceList = pDistanceList.getCurrent();
					
					if ((vFiEle instanceof FightElement) && (vDistanceList instanceof List)) setDistancesOfNeighboursOfFighter(((FightElement) vFiEle).getId(), (List)vDistanceList);
					else throw new Exception("06; FiMan,sDsoNsoFs");
			
					fightList.next();
					pDistanceList.next();
				}
			}
		} else throw new Exception("01; FiMan,sDsoNsoFs");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFightModList
	 * @param pInd
	 * @throws Exception
	 */
	public void setFightModsOfNeighboursOfFighters(List pFightModList, int pInd) throws Exception{
		Object vFiEle, vFightModList;
		
		if (fightList.getContentNumber() == pFightModList.getContentNumber()) {
			if (!fightList.isEmpty()){
				fightList.toFirst();
				pFightModList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
					vFightModList = pFightModList.getCurrent();
					
					if ((vFiEle instanceof FightElement) && (vFightModList instanceof List)) setFightModsOfNeighboursOfFighter(((FightElement) vFiEle).getId(), (List)vFightModList, pInd);
					else throw new Exception("06; FiMan,sFMsoNsoFs");
			
					fightList.next();
					pFightModList.next();
				}
			}
		} else throw new Exception("01; FiMan,sFMsoNsoFs");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFightModsList
	 * @throws Exception
	 */
	public void setFightModssOfNeighboursOfFighters(List pFightModsList) throws Exception{
		Object vFiEle, vFightModsList;
		
		if (fightList.getContentNumber() == pFightModsList.getContentNumber()) {
			if (!fightList.isEmpty()){
				fightList.toFirst();
				pFightModsList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
					vFightModsList = pFightModsList.getCurrent();
					
					if ((vFiEle instanceof FightElement) && (vFightModsList instanceof List)) setFightModssOfNeighboursOfFighter(((FightElement) vFiEle).getId(), (List)vFightModsList);
					else throw new Exception("06; FiMan,sFMssoNsoFs");
			
					fightList.next();
					pFightModsList.next();
				}
			}
		} else throw new Exception("01; FiMan,sFMssoNsoFs");
	}
	//-----
	/**	Dh	20.5.2020
	 * 
	 * 	Setzt den Ini-Wert eine IniElements und updatet dieses Element in der IniList, und update die IniList Reihenfolgen und die IniOrder.
	 * 
	 * @param pID
	 * @param pIni
	 * @throws Exception
	 */
	private void setIniOfIniElement(int pID, int pIni) throws Exception{
		int vOldIni;
		IniElement vIniEle; 
		try{ 
			vIniEle = getIniElement(pID);
			vOldIni = vIniEle.getIni();
			vIniEle.setIni(pIni);
			updateIniElementInIniList(pID, pIni - vOldIni);
			setIniToIniOrderElement(pID, pIni);
		}catch (Exception vExc) {throw vExc;}
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pID
	 * @param pTempIni
	 * @throws Exception
	 */
	private void setTempIniOfIniElement(int pID, int pTempIni) throws Exception{
		try{ getIniElement(pID).setTempIni(pTempIni);}
		catch (Exception vExc) {throw vExc;}
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pID
	 * @param pAction
	 * @throws Exception
	 */
	private void setActionOfIniElement(int pID, int pAction) throws Exception{
		try{ getIniElement(pID).setTempIni(pAction);}
		catch (Exception vExc) {throw vExc;}
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pID
	 * @param pTempAction
	 * @throws Exception
	 */
	private void setTempActionOfIniElement(int pID, int pTempAction) throws Exception{
		try{ getIniElement(pID).setTempIni(pTempAction);}
		catch (Exception vExc) {throw vExc;}
	}
	
	/**	Dh	5.5.2020
	 * 
	 * 	Setzt IniWerte der IniElements der IniList und updated dieses und die IniOrder.
	 * 
	 * @param pIniList
	 * @throws Exception
	 */
	private void setIniOfIniElements(List pIniList) throws Exception{
		Object vIniEle, vIni;
		List vIDList = new List();
		
		if (iniList.getContentNumber() == pIniList.getContentNumber()){
			iniList.toFirst();
			pIniList.toFirst();
			while (!iniList.isEnd()){
				vIniEle = iniList.getCurrent();
				vIni = pIniList.getCurrent();
			
				if ((vIniEle instanceof IniElement) && (vIni instanceof Integer)) {
					((IniElement) vIniEle).setIni((int)vIni);
					vIDList.append(((IniElement)vIniEle).getId());
				}
				else throw new Exception("06; FiMan,sIoIEs");
			
				fightList.next();
				pIniList.next();
			}
			updateIniList();
			setInisToIniOrderElements(vIDList, pIniList);
		} else throw new Exception("01; FiMan,sIoIEs");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pTempIniList
	 * @throws Exception
	 */
	private void setTempIniOfIniElements(List pTempIniList) throws Exception{
		Object vIniEle, vTempIni;
		
		if (iniList.getContentNumber() == pTempIniList.getContentNumber()){
			iniList.toFirst();
			pTempIniList.toFirst();
			while (!iniList.isEnd()){
				vIniEle = iniList.getCurrent();
				vTempIni = pTempIniList.getCurrent();
			
				if ((vIniEle instanceof IniElement) && (vTempIni instanceof Integer)) ((IniElement) vIniEle).setTempIni((int)vTempIni);
				else throw new Exception("06; FiMan,sTIoIEs");
			
				fightList.next();
				pTempIniList.next();
			}
		} else throw new Exception("01; FiMan,sTIoIEs");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pActionList
	 * @throws Exception
	 */
	private void setActionOfIniElements(List pActionList) throws Exception{
		Object vIniEle, vAction;
		
		if (iniList.getContentNumber() == pActionList.getContentNumber()){
			iniList.toFirst();
			pActionList.toFirst();
			while (!iniList.isEnd()){
				vIniEle = iniList.getCurrent();
				vAction = pActionList.getCurrent();
			
				if ((vIniEle instanceof IniElement) && (vAction instanceof Integer)) ((IniElement) vIniEle).setAction((int)vAction);
				else throw new Exception("06; FiMan,sAoIEs");
			
				fightList.next();
				pActionList.next();
			}
		} else throw new Exception("01; FiMan,sAoIEs");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pTempActionList
	 * @throws Exception
	 */
	private void setTempActionOfIniElements(List pTempActionList) throws Exception{
		Object vIniEle, vTempAction;
		
		if (iniList.getContentNumber() == pTempActionList.getContentNumber()){
			iniList.toFirst();
			pTempActionList.toFirst();
			while (!iniList.isEnd()){
				vIniEle = iniList.getCurrent();
				vTempAction = pTempActionList.getCurrent();
			
				if ((vIniEle instanceof IniElement) && (vTempAction instanceof Integer)) ((IniElement) vIniEle).setTempAction((int)vTempAction);
				else throw new Exception("06; FiMan,sTAoIEs");
			
				fightList.next();
				pTempActionList.next();
			}
		} else throw new Exception("01; FiMan,sTAoIEs");
	}
	
	/**	Dh	20.5.2020
	 * 
	 * 	Setzt den pIni Wert des durch pID angegeben IniOrderElemente, und sorgt dafür, dass der Wert nicht negativ wird.
	 * 
	 * @param pID
	 * @param pIni
	 * @throws Exception
	 */
	private void setIniToIniOrderElement(int pID, int pIni) throws Exception {
		int[] vIniOrderEle;
		
		if (pID >= 0) {
			if (!iniOrder.isEmpty()) {
				
				iniOrder.toFirst();
				while(!iniOrder.isEnd()) {
					vIniOrderEle = (int[])iniOrder.getCurrent();
					
					if (vIniOrderEle[0] == pID) {
						if (pIni >= 0) vIniOrderEle[1] = pIni;
						else {
							vIniOrderEle[1] = 0;
							throw new Exception("02; FiMan,sItIOE");
						}
					}
					
					iniOrder.next();
				}
				
				updateIniOrder();
			}
		}else throw new Exception("02; FiMan,sItIOE");
	}
	/**	Dh	20.5.2020
	 * 
	 * 	Setzt den pIni Wert des durch die pIDList gegeben IDs der IniOrerElements, und sorgt dafür, dass der Wert nicht negativ wird.
	 * 
	 * @param pIDList
	 * @param pIni
	 * @throws Exception
	 */
	private void setIniToIniOderElements(List pIDList, int pIni) throws Exception{
		Object vID;
		
		if (pIDList != null) {
			if ((!pIDList.isEmpty()) && (!iniOrder.isEmpty())){
				pIDList.toFirst();
				
				while (!pIDList.isEnd()) {
					vID = pIDList.getCurrent();
					
					if (vID instanceof Integer) {
						try{ setIniToIniOrderElement((int)vID, pIni);}
						catch(Exception ex) {throw ex;}
					}
					else throw new Exception("06; FiMan,sItIOEs");
					
					pIDList.next();
				}
			}
		}else throw new Exception("04; FiMan,sItIOEs");
	}
	/**	Dh	20.5.2020
	 * 
	 * 	Setzt die Ini Wert der pIniList der durch die pIDList gegeben IDs der iniOrerElements, und sorgt dafür, dass der Wert nicht negativ wird.
	 * 
	 * @param pIDList
	 * @param pIniList
	 * @throws Exception
	 */
	private void setInisToIniOrderElements(List pIDList, List pIniList) throws Exception{
		Object vID, vIni;
		
		if ((pIDList != null) && (pIniList != null)) {
			if ((!pIniList.isEmpty()) &&(!pIDList.isEmpty()) && (!iniOrder.isEmpty())){
				if (pIniList.getContentNumber() != pIDList.getContentNumber()) {
					pIDList.toFirst();
					pIniList.toFirst();
				
					while (!pIDList.isEnd()) {
						vID = pIDList.getCurrent();
						vIni = pIniList.getCurrent();
						
						if ((vID instanceof Integer) && (vIni instanceof Integer)) {
							try{ setIniToIniOrderElement((int)vID, (int)vIni);}
							catch(Exception ex) {throw ex;}
						}
						else throw new Exception("06; FiMan,sIstIOEs");
						
						pIDList.next();
						pIniList.next();
					}
				} else throw new Exception("01; FiMan,sIstIOEs");
			}
		}else throw new Exception("04; FiMan,sIstIOEs");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	16.7.2020
	 * 
	 * @param pFighterID
	 * @param pWeaponID
	 * @return
	 * @throws Exception
	 */
	public boolean hasFighterActiveWeapon(int pFighterID, int pWeaponID) throws Exception{
		if (pFighterID >= 0) return getFightElement(pFighterID).haveWeaponActive(pWeaponID);
		else throw new Exception("02; FiMan,hFAW");
	}
	
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pID
	 * @param pUseType
	 * @return
	 * @throws Exception
	 */
	public boolean hasFighterAActiveWeaponUseType(int pID, int pUseType) throws Exception{
		if (pID >= 0) return getFightElement(pID).haveActiveWeaponUseType(pUseType);
		else throw new Exception("02; FiMan,hFaAWUT");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public boolean hasFighterAPrimaryWeapon(int pID) throws Exception{
		if (pID >= 0) return getFightElement(pID).havePrimaryWeapon();
		else throw new Exception("02; FiMan,hFaPrW");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public boolean hasFighterASecondaryWeapon(int pID) throws Exception{
		if (pID >= 0) return getFightElement(pID).haveSecondaryWeapon();
		else throw new Exception("02; FiMan,hFaSW");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public boolean hasFighterAParryWeapon(int pID) throws Exception{
		if (pID >= 0) return getFightElement(pID).haveParryWeapon();
		else throw new Exception("02; FiMan,hFaPaW");
	}
	/**	Dh	15.7.2020
	 * 	
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public boolean hasFighterAShield(int pID) throws Exception{
		if (pID >= 0) return getFightElement(pID).haveShield();
		else throw new Exception("02; FiMan,hFaS");
	}
	/**	Dh	17.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public boolean hasFighterAnySecondaryWeapon(int pID) throws Exception{
		if (pID >= 0) return getFightElement(pID).haveAnySecondaryWeapon();
		else throw new Exception("02; FiMan,hFaSW");
	}
	/**	Dh	17.7.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public boolean hasFighterATwoHandedWeapon(int pID) throws Exception{
		if (pID >= 0) return getFightElement(pID).haveTwoHandedWeapon();
		else throw new Exception("02; FiMan,hFaTHW");
	}
	//-----
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pIDList
	 * @param pUseType
	 * @return
	 * @throws Exception
	 */
	public List haveFightersAActiveWeaponUseType(List pIDList, int pUseType) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(hasFighterAActiveWeaponUseType((int)vCur, pUseType));
					else throw new Exception("06; FiMan,hFsaAWUT");
					
					pIDList.next();
				}
			}
		} else throw new Exception("04; FiMan,hFsaAWUT");
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List haveFightersAPrimaryWeapon(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(hasFighterAPrimaryWeapon((int)vCur));
					else throw new Exception("06; FiMan,hFsaPrW");
					
					pIDList.next();
				}
			}
		} else throw new Exception("04; FiMan,hFsaPrW");
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List haveFightersASecondaryWeapon(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(hasFighterASecondaryWeapon((int)vCur));
					else throw new Exception("06; FiMan,hFsaSW");
					
					pIDList.next();
				}
			}
		} else throw new Exception("04; FiMan,hFsaSW");
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List haveFightersAParryWeapon(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(hasFighterAParryWeapon((int)vCur));
					else throw new Exception("06; FiMan,hFsaPaW");
					
					pIDList.next();
				}
			}
		} else throw new Exception("04; FiMan,hFsaPaW");
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List haveFightersAShield(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(hasFighterAShield((int)vCur));
					else throw new Exception("06; FiMan,hFsaS");
					
					pIDList.next();
				}
			}
		} else throw new Exception("04; FiMan,hFsaS");
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List haveFightersAnySecondaryWeapon(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(hasFighterAnySecondaryWeapon((int)vCur));
					else throw new Exception("06; FiMan,hFsaSW");
					
					pIDList.next();
				}
			}
		} else throw new Exception("04; FiMan,hFsaSW");
		
		return vRet;
	}
	/**	Dh	17.7.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List haveFightersATwoHandedWeapon(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(hasFighterATwoHandedWeapon((int)vCur));
					else throw new Exception("06; FiMan,hFsaTHW");
					
					pIDList.next();
				}
			}
		} else throw new Exception("04; FiMan,hFsaTHW");
		
		return vRet;
	}
	//-----
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pUseType
	 * @return
	 * @throws Exception
	 */
	public List haveAllFightersAActiveWeaponUseType(int pUseType) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (fightList != null) {
			if (!fightList.isEmpty()) {
				fightList.toFirst();
				
				while(!fightList.isEnd()) {
					vCur = fightList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(hasFighterAActiveWeaponUseType((int)vCur, pUseType));
					else throw new Exception("06; FiMan,haFsaAWUT");
					
					fightList.next();
				}
			}
		} else throw new Exception("04; FiMan,haFsaAWUT");
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @return
	 * @throws Exception
	 */
	public List haveAllFightersAPrimaryWeapon() throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (fightList != null) {
			if (!fightList.isEmpty()) {
				fightList.toFirst();
				
				while(!fightList.isEnd()) {
					vCur = fightList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(hasFighterAPrimaryWeapon((int)vCur));
					else throw new Exception("06; FiMan,haFsaPrW");
					
					fightList.next();
				}
			}
		} else throw new Exception("04; FiMan,haFsaPrW");
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @return
	 * @throws Exception
	 */
	public List haveAllFightersASecondaryWeapon() throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (fightList != null) {
			if (!fightList.isEmpty()) {
				fightList.toFirst();
				
				while(!fightList.isEnd()) {
					vCur = fightList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(hasFighterASecondaryWeapon((int)vCur));
					else throw new Exception("06; FiMan,haFsaSW");
					
					fightList.next();
				}
			}
		} else throw new Exception("04; FiMan,haFsaSW");
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @return
	 * @throws Exception
	 */
	public List haveAllFightersAParryWeapon() throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (fightList != null) {
			if (!fightList.isEmpty()) {
				fightList.toFirst();
				
				while(!fightList.isEnd()) {
					vCur = fightList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(hasFighterAParryWeapon((int)vCur));
					else throw new Exception("06; FiMan,haFsaPaW");
					
					fightList.next();
				}
			}
		} else throw new Exception("04; FiMan,haFsaPaW");
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @return
	 * @throws Exception
	 */
	public List haveAllFightersAShield() throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (fightList != null) {
			if (!fightList.isEmpty()) {
				fightList.toFirst();
				
				while(!fightList.isEnd()) {
					vCur = fightList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(hasFighterAShield((int)vCur));
					else throw new Exception("06; FiMan,haFsaS");
					
					fightList.next();
				}
			}
		} else throw new Exception("04; FiMan,haFsaS");
		
		return vRet;
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @return
	 * @throws Exception
	 */
	public List haveAllFightersAnySecondaryWeapon() throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (fightList != null) {
			if (!fightList.isEmpty()) {
				fightList.toFirst();
				
				while(!fightList.isEnd()) {
					vCur = fightList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(hasFighterAnySecondaryWeapon((int)vCur));
					else throw new Exception("06; FiMan,haFsaSW");
					
					fightList.next();
				}
			}
		} else throw new Exception("04; FiMan,haFsaSW");
		
		return vRet;
	}
	/**	Dh	17.7.2020
	 * 
	 * @return
	 * @throws Exception
	 */
	public List haveAllFightersATwoHandedWeapon() throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (fightList != null) {
			if (!fightList.isEmpty()) {
				fightList.toFirst();
				
				while(!fightList.isEnd()) {
					vCur = fightList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(hasFighterATwoHandedWeapon((int)vCur));
					else throw new Exception("06; FiMan,haFsaTHW");
					
					fightList.next();
				}
			}
		} else throw new Exception("04; FiMan,haFsaTHW");
		
		return vRet;
	}
	
	/**	Dh	6.5.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public boolean haveFighterIDInList(int pID) throws Exception{
		boolean vRet = false;
		Object vTemp = null;
		int vID = -1;
		
		if (pID >= 0){
			if (!fightList.isEmpty()){
				fightList.toFirst();
				while(!fightList.isEnd() && (vRet == false)){
					vTemp = fightList.getCurrent();
					
					if (vTemp instanceof FightElement){
						if (((FightElement)vTemp).getId() == pID) vRet = true;
					} else throw new Exception("06; FiMan,hFIDL");
					
					fightList.next();
				}
			}
		} else throw new Exception("02; FiMan,hFIDL");
		
		return vRet;
	}
	/**	Dh	6.5.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public boolean haveIDInIniList(int pID) throws Exception{
		boolean vRet = false;
		Object vTemp = null;
		int vID = -1;
		
		if (pID >= 0){
			if (!iniList.isEmpty()){
				iniList.toFirst();
				while(!iniList.isEnd() && (vRet == false)){
					vTemp = iniList.getCurrent();
					
					if (vTemp instanceof IniElement){
						if (((IniElement)vTemp).getId() == pID) vRet = true;
					} else throw new Exception("06; FiMan,hIDiIL");
					
					iniList.next();
				}
			}
		} else throw new Exception("02; FiMan,hIDiIL");
		
		return vRet;
	}
	
	/**	Dh	11.5.2020
	 * 
	 * @return
	 */
	public boolean isFightListEmpty() {
		return fightList.isEmpty();
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	15.7.2020
	 * 
	 * 	Fuegt eine neue Kaempfer*In zur KaempferListe hinzu und erzeugt einen neuen Ini-Eintrag dafuer.
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pChar
	 * @throws Exception
	 */
	public void addFighter(Charakter pChar) throws Exception{
		int vID, vIni;
		Object[][] vActiveWeapon;
		
		if (fightList != null) vID = fightList.getContentNumber();
		else throw new Exception("04; FiMan,aFi_a");
		
		if (pChar != null) {
			
			vActiveWeapon = new Object[][] {{pChar.getWeapon(0), 0}, {pChar.getWeapon(1), 0}, {pChar.getWeapon(2), 1}};
			fightList.append(new FightElement(vID, pChar, vActiveWeapon));
		}
		else throw new Exception("04; FiMan,aFi_a");
		
		vIni = calcIni(pChar);
		addIniElement(vID, vIni, 2);
	}
	/**	Dh	15.7.2020
	 * 
	 * 	Fuegt eine neue Kaempfer*In zur KaempferListe hinzu und erzeugt einen neuen Ini-Eintrag dafuer.
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * @param pChar
	 * @param pActiveWeapons
	 * @param pPropMods
	 * @throws Exception
	 */
	public void addFighter(Charakter pChar, Object[][] pActiveWeapons, int[] pPropMods) throws Exception{
		int vID, vIni;
		
		if (fightList != null) vID = fightList.getContentNumber();
		else throw new Exception("04; FiMan,aFi_b");
		
		if ((pChar != null) && (pPropMods != null)){
			if (pPropMods.length == 10) fightList.append(new FightElement(vID, pChar, pActiveWeapons, pPropMods));
			else throw new Exception("01; FiMan,aFi_b");
		} else throw new Exception("04; FiMan,aFi_b");
		
		vIni = calcIni(pChar);
		addIniElement(vID, vIni, 2);
	}
	/**	Dh	15.7.2020
	 * 
	 * 	Fuegt eine neue Kaempfer*In zur KaempferListe hinzu und erzeugt einen neuen Ini-Eintrag dafuer.
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pChar
	 * @param pActiveWeapons
	 * @param pNeighbours
	 * @throws Exception
	 */
	public void addFighter(Charakter pChar, Object[][] pActiveWeapons, List pNeighbours) throws Exception{
		int vID, vIni;
		
		if (fightList != null) vID = fightList.getContentNumber();
		else throw new Exception("04; FiMan,aFi_c");
		
		if ((pChar != null) && (pNeighbours != null))fightList.append(new FightElement(vID, pChar, pActiveWeapons, pNeighbours));
		else throw new Exception("04; FiMan,aFi_c");
		
		vIni = calcIni(pChar);
		addIniElement(vID, vIni, 2);
	}
	/**	Dh	15.7.2020
	 * 
	 * 	Fuegt eine neue Kaempfer*In zur KaempferListe hinzu und erzeugt einen neuen Ini-Eintrag dafuer.
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pChar
	 * @param pActiveWeapons
	 * @param pPropMods
	 * @param pStatMods
	 * @throws Exception
	 */
	public void addFighter(Charakter pChar, Object[][] pActiveWeapons, int[] pPropMods, int[] pStatMods) throws Exception{
		int vID, vIni;
		
		if (fightList != null) vID = fightList.getContentNumber();
		else throw new Exception("04; FiMan,aFi_d");
		
		if ((pChar != null) && (pPropMods != null) && (pStatMods != null)){
			if ((pPropMods.length == 10) && (pStatMods.length == 10)) fightList.append(new FightElement(vID, pChar, pActiveWeapons, pPropMods, pStatMods));
			else throw new Exception("01; FiMan,aFi_d");
		} else throw new Exception("04; FiMan,aFi_d");
		
		vIni = calcIni(pChar);
		addIniElement(vID, vIni, 2);
	}
	/**	Dh	15.7.2020
	 * 
	 * 	Fuegt eine neue Kaempfer*In zur KaempferListe hinzu und erzeugt einen neuen Ini-Eintrag dafuer.
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * @param pChar
	 * @param pActiveWeapons
	 * @param pPropMods
	 * @param pNeighbours
	 * @throws Exception
	 */
	public void addFighter(Charakter pChar, Object[][] pActiveWeapons, int[] pPropMods, List pNeighbours) throws Exception{
		int vID, vIni;
		
		if (fightList != null) vID = fightList.getContentNumber();
		else throw new Exception("04; FiMan,aFi_e");
		
		if ((pChar != null) && (pPropMods != null) && (pNeighbours != null)){
			if (pPropMods.length == 10) fightList.append(new FightElement(vID, pChar, pActiveWeapons, pPropMods, pNeighbours));
			else throw new Exception("01; FiMan,aFi_e");
		} else throw new Exception("04; FiMan,aFi_e");
		
		vIni = calcIni(pChar);
		addIniElement(vID, vIni, 2);
	}
	/**	Dh	15.7.2020
	 * 
	 * 	Fuegt eine neue Kaempfer*In zur KaempferListe hinzu und erzeugt einen neuen Ini-Eintrag dafuer.
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pChar
	 * @param pActiveWeapons
	 * @param pPropMods
	 * @param pStatMods
	 * @param pNeighbours
	 * @throws Exception
	 */
	public void addFighter(Charakter pChar, Object[][] pActiveWeapons, int[] pPropMods, int[] pStatMods, List pNeighbours) throws Exception{
		int vID, vIni;
		
		if (fightList != null) vID = fightList.getContentNumber();
		else throw new Exception("04; FiMan,aFi_f");
		
		if ((pChar != null) && (pPropMods != null) && (pStatMods != null) && (pNeighbours != null)){
			if ((pPropMods.length == 10) && (pStatMods.length == 10)) fightList.append(new FightElement(vID, pChar, pActiveWeapons, pPropMods, pStatMods, pNeighbours));
			else throw new Exception("01; FiMan,aFi_f");
		} else throw new Exception("04; FiMan,aFi_f");
		
		vIni = calcIni(pChar);
		addIniElement(vID, vIni, 2);
	}
	//-----
	/**	Dh	23.2.2020
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Fuegt dem ausgewaehltem Fighter (pID) die ausgewaehlte (pInd) EigenschaftsModifikation hinzu.
	 * 
	 * @param pID
	 * @param pInd
	 * @param pPropMod
	 * @throws Exception
	 */
	public void addPropModToFighter(int pID, int pPropMod, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 10)){
			try{ getFightElement(pID).addPropMod(pPropMod, pInd);}
			catch (Exception vExc) {throw vExc;}
		} else throw new Exception("07; FiMan,aPMF");
	}
	/**	Dh	5.5.2020
	 * 
	 * 	Fuegt dem ausgewaehltem Fighter (pID) die ausgewaehlte (pInd) StatusModifikation hinzu.
	 * 		Wenn es der Ini-Basiswert ist, dann wird der Wert auch dem entsprechenden IniElement
	 * 		hinzugefuegt. 
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pID
	 * @param pInd
	 * @param pStatMod
	 * @throws Exception
	 */
	public void addStatModToFighter(int pID, double pStatMod, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 10)){
			try{ 
				getFightElement(pID).addStatMod(pStatMod, pInd);
				if (pInd == 6) addIniOfIniElement(pID, (int)Math.round(pStatMod));
			} catch (Exception vExc) {throw vExc;}
		} else throw new Exception("07; FiMan,aSMF");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pID
	 * @param pActiveWeapon
	 * @throws Exception
	 */
	public void addActiveWeaponOfFighter(int pID, Weapon pActiveWeapon, int pUseType) throws Exception {
		if (pID >= 0) {
			try {getFightElement(pID).addActiveWeapon(pActiveWeapon, pUseType);}
			catch(Exception ex) {throw ex;}
		}else throw new Exception("02; FiMan,aAWoF");
	}
	
	/**	Dh	23.2.2020
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Fuegt dem ausgewaehltem Fighter (pID) die entsprechenden EigenschaftsModifikatoren hinzu.
	 * 
	 * @param pID
	 * @param pPropMods
	 * @throws Exception
	 */
	public void addPropModsToFighter(int pID, int[] pPropMods) throws Exception{
		if (pPropMods != null){
			if (pPropMods.length == 10){
				try{ getFightElement(pID).addPropMods(pPropMods);}
				catch (Exception vExc) {throw vExc;}
			} else throw new Exception("01; FiMan,aPMsF");
		} else throw new Exception("04; FiMan,aPMsF");
	}
	/**	Dh	5.5.2020
	 * 
	 * 	Fuegt dem ausgewaehltem Fighter (pID) die entsprechenden StatusModifikatoren hinzu.
	 * 		Wenn es der Ini-Basiswert ist, dann wird der Wert auch dem entsprechenden IniElement
	 * 		hinzugefuegt. 
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pID
	 * @param pStatMods
	 * @throws Exception
	 */
	public void addStatModsToFighter(int pID, int[] pStatMods) throws Exception{
		if (pStatMods != null){
			if (pStatMods.length == 10){
				try{ 
					getFightElement(pID).addStatMods(pStatMods);
					if (pStatMods[6] != 0) addIniOfIniElement(pID, (int)Math.round(pStatMods[6]));
				} catch (Exception vExc) {throw vExc;}
			} else throw new Exception("01; FiMan,aSMsF");
		} else throw new Exception("04; FiMan,aSMsF");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pID
	 * @param pActiveWeapons
	 * @throws Exception
	 */
	public void addActiveWeaponsOfFighter(int pID, Object[][] pActiveWeapons) throws Exception{
		if (pID >= 0) {
			try {getFightElement(pID).addActiveWeapons(pActiveWeapons);}
			catch(Exception ex) {throw ex;}
		}else throw new Exception("02; FiMan,aAWsoF");
	}
	
	/**	Dh	23.2.2020
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Fuegt allen Kaempfer*Innen der Liste die jeweilige EigenschaftsModifikation hinzu.
	 * 
	 * @param pInd
	 * @param pPropMod
	 * @throws Exception
	 */
	public void addPropModToFighters(int pPropMod, int pInd) throws Exception{
		Object vFiEle;
		
		if ((pInd >= 0) && (pInd < 10)){
			if (!fightList.isEmpty()){
				fightList.toFirst();
				while (!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
				
					if (vFiEle instanceof FightElement) ((FightElement) vFiEle).addPropMod(pPropMod, pInd);
					else throw new Exception("06; FiMan,aPMFs");
				
					fightList.next();
				}
			} else throw new Exception("05; FiMan,aPMFs");
		} else throw new Exception("07; FiMan,aPMFs");
	}
	/**	Dh	1.5.2020
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Fuegt den entsprechenden Kaempfer*Innen der Liste die jeweiligen EigenschaftsModifikationen hinzu.
	 * 
	 * @param pPropsModList
	 * @param pInd
	 * @throws Exception
	 */
	public void addPropsModToFighters(List pPropsModList, int pInd) throws Exception{
		Object vFiEle, vPrEle;
	
		if ((pInd >= 0) && (pInd < 10)){
			if (!fightList.isEmpty() && !pPropsModList.isEmpty()){
				if (fightList.getContentNumber() == pPropsModList.getContentNumber()) {
					fightList.toFirst();
					pPropsModList.toFirst();
					while (!fightList.isEnd()){
						vFiEle = fightList.getCurrent();
						vPrEle = pPropsModList.getCurrent();
					
						if ((vFiEle instanceof FightElement)&& (vPrEle instanceof Integer)) ((FightElement) vFiEle).addPropMod((int)vPrEle, pInd);
						else throw new Exception("06; FiMan,aPsMFs");
			
						fightList.next();
						pPropsModList.next();
					}
				} else throw new Exception("01; FiMan,aPsMFs");
			} else throw new Exception("05; FiMan,aPsMFs");
		} else throw new Exception("07; FiMan,aPsMFs");
	}
	/**	Dh	5.5.2020
	 * 
	 *	Fuegt allen Kaempfer*Innen der Liste die StatusModifikation zu.
	 *		Wenn es der Ini-Basiswert ist, dann wird der Wert auch dem entsprechenden IniElement
	 * 		hinzugefuegt. 
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pID
	 * @param pInd
	 * @param pStatMod
	 * @throws Exception
	 */
	public void addStatModToFighters(double pStatMod, int pInd) throws Exception{
		Object vFiEle;
		
		if ((pInd >= 0) && (pInd < 10)){
			if (!fightList.isEmpty()){
				fightList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
				
					if (vFiEle instanceof FightElement) {
						((FightElement) vFiEle).addStatMod(pStatMod, pInd);
						if (pInd == 6) addIniOfIniElement(((FightElement) vFiEle).getId(), (int)Math.round(pStatMod));
					}
					else throw new Exception("06; FiMan,aSMFs");
				
					fightList.next();
				}
			} else throw new Exception("05; FiMan,aSMFs");
		} else throw new Exception("07; FiMan,aSMFs");
	}
	/**	Dh	5.5.2020
	 * 
	 * 	Fuegt den entsprechenden Kaempfer*Innen der Liste die jeweilige StatusModifikation zu.
	 * 		Wenn es der Ini-Basiswert ist, dann wird der Wert auch dem entsprechenden IniElement
	 * 		hinzugefuegt. 
	 * 	
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pStatsModList
	 * @param pInd
	 * @throws Exception
	 */
	public void addStatsModToFighters(List pStatsModList, int pInd) throws Exception{
		Object vFiEle, vPrEle;
		
		if ((pInd >= 0) && (pInd < 10)){
			if (!fightList.isEmpty() && !pStatsModList.isEmpty()){
				if (fightList.getContentNumber() == pStatsModList.getContentNumber()) {
					fightList.toFirst();
					pStatsModList.toFirst();
					while (!fightList.isEnd()){
						vFiEle = fightList.getCurrent();
						vPrEle = pStatsModList.getCurrent();
						
						if ((vFiEle instanceof FightElement) && (vPrEle instanceof Double)) {
							((FightElement) vFiEle).addStatMod((double)vPrEle, pInd);
							if (pInd == 6) addIniOfIniElement(((FightElement) vFiEle).getId(), (int)Math.round((double)vPrEle));
						}
						else throw new Exception("06; FiMan,aSsMFs");
				
						fightList.next();
						pStatsModList.next();
					}
				} else throw new Exception("01; FiMan,aSsMFs");
			} else throw new Exception("05; FiMan,aSsMFs");
		} else throw new Exception("07; FiMan,aSsMFs");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pActiveWeapon
	 * @throws Exception
	 */
	public void addActiveWeaponOfFighters(Weapon pActiveWeapon, int pUseType) throws Exception{
		FightElement vCur;
		
		if (!fightList.isEmpty()) {
			fightList.toFirst();
			
			while(!fightList.isLast()) {			
				try {((FightElement)fightList.getCurrent()).addActiveWeapon(pActiveWeapon, pUseType);}
				catch (Exception ex) {throw ex;}
				
				fightList.next();
			}
		}else throw new Exception("05; FiMan,aAWoFs");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @param pActiveWeaponList
	 * @throws Exception
	 */
	public void addActiveWeaponsOfFighters(List pActiveWeaponList) throws Exception{
		Object vTempWeapon;
		
		if (pActiveWeaponList != null) {
			if (pActiveWeaponList.getContentNumber() == fightList.getContentNumber()) {
				if (!fightList.isEmpty()) {
					fightList.toFirst();
					pActiveWeaponList.toFirst();
					
					while(!fightList.isLast()) {		
						vTempWeapon = pActiveWeaponList.getCurrent();
						
						if (vTempWeapon instanceof Object[]) {
							if ((((Object[])vTempWeapon)[0] instanceof Weapon) && (((Object[])vTempWeapon)[1] instanceof Integer)) {
								try {((FightElement)fightList.getCurrent()).addActiveWeapon((Weapon)((Object[])vTempWeapon)[0], (int)((Object[])vTempWeapon)[1]);}
								catch (Exception ex) {throw ex;}
							} else throw new Exception("06; FiMan,aAWoFs");
						} else throw new Exception("02; FiMan,aAWoFs");
						
						pActiveWeaponList.toFirst();
						fightList.next();
					}
				}else throw new Exception("05; FiMan,aAWoFs");
			} else throw new Exception("01; FiMan,aAWoFs");
		}else throw new Exception("04; FiMan,aAWoFs");
	}
	
	/**	Dh	23.2.2020
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Fuegt allen Kaempfer*Innen der Liste die jeweilige EigenschaftsModifikationen hinzu.
	 * 
	 * @param pPropMods
	 * @throws Exception
	 */
	public void addPropModsToFighters(int[] pPropMods) throws Exception{
		Object vFiEle;
		
		if (pPropMods != null){
			if (pPropMods.length == 10){
				if (!fightList.isEmpty()){
					fightList.toFirst();
				
					while(!fightList.isEnd()){
						vFiEle = fightList.getCurrent();
					
						if (vFiEle instanceof FightElement) ((FightElement) vFiEle).addPropMods(pPropMods);
						else throw new Exception("06; FiMan,aPMsFs");
					
						fightList.next();
					}
				} else throw new Exception("05; FiMan,aPMsFs");
			} else throw new Exception("01; FiMan,aPMsFs");
		} else throw new Exception("04; FiMan,aPMsFs");
	}
	/**	Dh	1.5.2020
	 * 
	 * 	pPropMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Fuegt den entsprechenden Kaempfer*Innen der Liste die jeweilige EigenschaftsModifikationen hinzu.
	 * 
	 * @param pPropsModsList
	 * @throws Exception
	 */
	public void addPropsModsToFighters(List pPropsModsList) throws Exception{
		Object vFiEle, vPrEle;
		
		if (!fightList.isEmpty() && !pPropsModsList.isEmpty()){
			if (fightList.getContentNumber() == pPropsModsList.getContentNumber()) {
				fightList.toFirst();
				pPropsModsList.toFirst();
				while (!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
					vPrEle = pPropsModsList.getCurrent();
						
					if ((vFiEle instanceof FightElement)&& (vPrEle instanceof Integer)) ((FightElement) vFiEle).addPropMods((int[])vPrEle);
					else throw new Exception("06; FiMan,aPsMFs");
			
					fightList.next();
					pPropsModsList.next();
				}
			} else throw new Exception("01; FiMan,aPsMFs");
		} else throw new Exception("05; FiMan,aPsMFs");
	}
	/**	Dh	5.5.2020
	 * 
	 * 	Fuegt allen Kaempfer*Innen der Liste die jeweilige StatusModifikationen hinzu.
	 * 		Wenn es der Ini-Basiswert ist, dann wird der Wert auch dem entsprechenden IniElement
	 * 		hinzugefuegt.
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pStatMods
	 * @throws Exception
	 */
	public void addStatModsToFighters(int[] pStatMods) throws Exception{
		Object vFiEle;
		
		if (pStatMods != null){
			if (pStatMods.length == 10){
				if (!fightList.isEmpty()){
					fightList.toFirst();
				
					while(!fightList.isEnd()){
						vFiEle = fightList.getCurrent();
					
						if (vFiEle instanceof FightElement) {
							((FightElement) vFiEle).addStatMods(pStatMods);
							if (pStatMods[6] != 0) addIniOfIniElement(((FightElement) vFiEle).getId(), (int) Math.round(pStatMods[6]));
						}
						else throw new Exception("06; FiMan,aSMsFs");
					
						fightList.next();
					}
				} else throw new Exception("05; FiMan,aSMsFs");
			} else throw new Exception("01; FiMan,aSMsFs");
		} else throw new Exception("04; FiMan,aSMsFs");
	}
	/**	Dh	5.5.2020
	 * 
	 * 	Fuegt den entsprechenden Kaempfer*Innen der Liste die jeweilige StatusModifikationen hinzu.
	 * 		Wenn es der Ini-Basiswert ist, dann wird der Wert auch dem entsprechenden IniElement
	 * 		hinzugefuegt.
	 * 
	 * 	pStatiMod:
	 * 	  0 Lebenspunkte		5 Wundschwelle
	 * 	  1 Ausdauerpunkte		6 Initiativ-Basiswert
	 * 	  2 Astralpunkte		7 Attack-Basiswert
	 * 	  3 Karmalpunkte		8 Parade-Basiswert
	 * 	  4 Magieresitenz		9 Fernkampf-Basiswert
	 * 
	 * @param pStatsModsList
	 * @throws Exception
	 */
	public void addStatsModsToFighters(List pStatsModsList) throws Exception{
		Object vFiEle, vPrEle;
		
		if (!fightList.isEmpty() && !pStatsModsList.isEmpty()){
			if (fightList.getContentNumber() == pStatsModsList.getContentNumber()) {
				fightList.toFirst();
				pStatsModsList.toFirst();
				while (!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
					vPrEle = pStatsModsList.getCurrent();
						
					if ((vFiEle instanceof FightElement)&& (vPrEle instanceof Integer[])) {
						((FightElement) vFiEle).addStatMods((int[])vPrEle);
						if (((double[])vPrEle)[6] != 0) addIniOfIniElement(((FightElement) vFiEle).getId(), (int) Math.round(((int[])vPrEle)[6]));
					}
					else throw new Exception("06; FiMan,aSsMFs");
			
					fightList.next();
					pStatsModsList.next();
				}
			} else throw new Exception("01; FiMan,aSsMFs");
		} else throw new Exception("05; FiMan,aSsMFs");
	}
	/**	Dh	15.7.2020
	 * 
	 * @param pActiveWeapon
	 * @throws Exception
	 */
	public void addActiveWeaponsOfFighters(Object[][] pActiveWeapon) throws Exception{
		if (!fightList.isEmpty()){
			fightList.toFirst();
			while(!fightList.isEnd()){
				((FightElement)fightList.getCurrent()).addActiveWeapons(pActiveWeapon);
				
				fightList.next();
			}
		} else throw new Exception("05; FiMan,aAWsoFs");
	}
	/**	Dh	15.7.2020
	 * 
	 * @param pActiveWeaponsList
	 * @throws Exception
	 */
	public void addActiveWeaponssOfFighters(List pActiveWeaponsList) throws Exception{
		Object vCur;
		
		if (pActiveWeaponsList != null) {
			if (pActiveWeaponsList.getContentNumber() == fightList.getContentNumber()) {
				if (!fightList.isEmpty()){
					fightList.toFirst();
					pActiveWeaponsList.toFirst();
					
					while(!fightList.isEnd()){
						vCur = pActiveWeaponsList.getCurrent();
						
						if (vCur instanceof Object[][]) {
							try{ ((FightElement)fightList.getCurrent()).addActiveWeapons((Object[][])vCur);}
							catch(Exception ex) {throw ex;}
						}
						
						pActiveWeaponsList.next();
						fightList.next();
					}
				} else throw new Exception("05; FiMan,aAWssoFs");
			}else throw new Exception("01; FiMan,aAWssoFs");
		}else throw new Exception("04; FiMan,aAWssoFs");
	}
	//-----
	/**	Dh	22.5.2020
	 * 
	 * 	Erstellt fuer den ausgewaehltem Fighter (pID) einen Kampfnachbar und fuegt diesem hinzu.
	 * 
	 * @param pID
	 * @param pNeighbourID
	 * @param pEnemy
	 * @throws Exception
	 */
	public void addNeighbourToFighter(int pFighterID, int pNeighbourID, boolean pEnemy) throws Exception{
		NeighbourElement vNeigh;
		
		if ((pNeighbourID >= 0) && (pNeighbourID < fightList.getContentNumber()) && (pFighterID != pNeighbourID)){
			vNeigh = new NeighbourElement(pNeighbourID, pEnemy);
			
			try{ getFightElement(pFighterID).addNeighbourElement(vNeigh); }
			catch (Exception vExc) {throw vExc;}
		} else throw new Exception("02; FiMan,aNtFe_a");
	}
	/**	Dh	22.5.2020
	 * 
	 * 	pDistance:
	 * 	  0 Handgemenge
	 * 	  1 Nahkampf
	 * 	  2 Hellebarde
	 *    3 Pike
	 *    >4 Angabe in Schritt
	 *    
	 *  Erstellt fuer den ausgewaehltem Fighter (pID) einen Kampfnachbar und fuegt diesem hinzu.
	 * 
	 * @param pID
	 * @param pNeighbourID
	 * @param pEnemy
	 * @param pDistance
	 * @throws Exception
	 */
	public void addNeighbourToFighter(int pFighterID, int pNeighbourID, boolean pEnemy, int pDistance) throws Exception{
		NeighbourElement vNeigh;
		
		if ((pNeighbourID >= 0) && (pNeighbourID < fightList.getContentNumber()) && (pFighterID != pNeighbourID) && (pDistance >= 0)){
			vNeigh = new NeighbourElement(pNeighbourID, pEnemy, pDistance);
				
			try{ getFightElement(pFighterID).addNeighbourElement(vNeigh); }
			catch (Exception vExc) {throw vExc;}
		} else throw new Exception("02; FiMan,aNtFe_b");
	}
	/**	Dh	22.5.2020
	 * 
	 * 	pFightMods:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * 	Erstellt fuer den ausgewaehltem Fighter (pID) einen Kampfnachbar und fuegt diesem hinzu.
	 * 
	 * @param pID
	 * @param pNeighbourID
	 * @param pEnemy
	 * @param pFightMods
	 * @throws Exception
	 */
	public void addNeighbourToFighter(int pFighterID, int pNeighbourID, boolean pEnemy, double[] pFightMods) throws Exception{
		NeighbourElement vNeigh;
		
		if ((pNeighbourID >= 0) && (pNeighbourID < fightList.getContentNumber()) && (pFighterID != pNeighbourID)){
			if (pFightMods.length == 4){
				vNeigh = new NeighbourElement(pNeighbourID, pEnemy, pFightMods);
						
				try{ getFightElement(pFighterID).addNeighbourElement(vNeigh); }
				catch (Exception vExc) {throw vExc;}
			} else throw new Exception("01; FiMan,aNtFe_c"); 
		} else throw new Exception("02; FiMan,aNtFe_c");

	}
	/**	Dh	22.5.2020
	 * 
	 * 	pDistance:
	 * 	  0 Handgemenge
	 * 	  1 Nahkampf
	 * 	  2 Hellebarde
	 *    3 Pike
	 *    >4 Angabe in Schritt
	 *    
	 *  pFightMods:
	 * 	  0 Ini-Basiswert		2 Parade-Basiswert
	 * 	  1 Attacke-Basiswert	3 Fernkampf-Basiswert
	 * 
	 * 	Erstellt fuer den ausgewaehltem Fighter (pID) einen Kampfnachbar und fuegt diesem hinzu.
	 * 
	 * @param pID
	 * @param pNeighbourID
	 * @param pEnemy
	 * @param pDistance
	 * @param pFightMods
	 * @throws Exception
	 */
	public void addNeighbourToFighter(int pFighterID, int pNeighbourID, boolean pEnemy, int pDistance, double[] pFightMods) throws Exception{
		NeighbourElement vNeigh;

		if ((pNeighbourID >= 0) && (pNeighbourID < fightList.getContentNumber()) && (pFighterID != pNeighbourID) && (pDistance >= 0)){
			if (pFightMods.length == 4){
				vNeigh = new NeighbourElement(pNeighbourID, pEnemy, pDistance, pFightMods);
			
				try{ getFightElement(pFighterID).addNeighbourElement(vNeigh); }
				catch (Exception vExc) {throw vExc;}
			} else throw new Exception("01; FiMan,aNtFe_d");
		} else throw new Exception("02; FiMan,aNtFe_d");

	}
	
	/**	Dh	3.5.2020
	 * 
	 *  Erstellt fuer alle Fighter*Innen einen Kampfnachbar und fuegt diesen hinzu.
	 * 
	 * @param pNeighbourID
	 * @param pEnemy
	 * @throws Exception
	 */
	public void addNeighbourToFighters(int pNeighbourID, boolean pEnemy) throws Exception{
		FightElement vFiEle;
		NeighbourElement vNeigh;
		
		if (!fightList.isEmpty()) {
			fightList.toFirst();
			while(!fightList.isEmpty()) {
				vFiEle = (FightElement) fightList.getCurrent();
				
				if (vFiEle.getId() != pNeighbourID) {
					vNeigh = new NeighbourElement(pNeighbourID, pEnemy);
					
					try{ vFiEle.addNeighbourElement(vNeigh); }
					catch (Exception vExc) {throw vExc;}
				}
	
				fightList.next();
			}
		} else throw new Exception("05; FiMan,aNtFs_a");
	}
	/**	Dh	3.5.2020
	 * 
	 * 	Erstellt fuer alle Fighter*Innen einen Kampfnachbar und fuegt diesen hinzu.
	 * 
	 * @param pFighterID
	 * @param pNeighbourID
	 * @param pEnemy
	 * @param pDistance
	 * @throws Exception
	 */
	public void addNeighbourToFighters(int pFighterID, int pNeighbourID, boolean pEnemy, int pDistance) throws Exception{
		FightElement vFiEle;
		NeighbourElement vNeigh;
		
		if (!fightList.isEmpty()) {
			fightList.toFirst();
			while(!fightList.isEmpty()) {
				vFiEle = (FightElement) fightList.getCurrent();
				
				if (vFiEle.getId() != pNeighbourID) {
					vNeigh = new NeighbourElement(pNeighbourID, pEnemy, pDistance);
					
					try{ vFiEle.addNeighbourElement(vNeigh); }
					catch (Exception vExc) {throw vExc;}
				}
	
				fightList.next();
			}
		} else throw new Exception("05; FiMan,aNtFs_b");
	}
	/**	Dh	3.5.2020
	 * 
	 * 	Erstellt fuer alle Fighter*Innen einen Kampfnachbar und fuegt diesen hinzu.
	 * 	
	 * @param pFighterID
	 * @param pNeighbourID
	 * @param pEnemy
	 * @param pFightMods
	 * @throws Exception
	 */
	public void addNeighbourToFighters(int pFighterID, int pNeighbourID, boolean pEnemy, double[] pFightMods) throws Exception{
		FightElement vFiEle;
		NeighbourElement vNeigh;
		
		if (!fightList.isEmpty()) {
			fightList.toFirst();
			while(!fightList.isEmpty()) {
				vFiEle = (FightElement) fightList.getCurrent();
				
				if (vFiEle.getId() != pNeighbourID) {
					vNeigh = new NeighbourElement(pNeighbourID, pEnemy, pFightMods);
					
					try{ vFiEle.addNeighbourElement(vNeigh); }
					catch (Exception vExc) {throw vExc;}
				}
	
				fightList.next();
			}
		} else throw new Exception("05; FiMan,aNtFs_c");
	}
	/**	Dh	3.5.2020
	 * 
	 * 	Erstellt fuer alle Fighter*Innen einen Kampfnachbar und fuegt diesen hinzu.
	 * 
	 * @param pFighterID
	 * @param pNeighbourID
	 * @param pEnemy
	 * @param pDistance
	 * @param pFightMods
	 * @throws Exception
	 */
	public void addNeighbourToFighters(int pFighterID, int pNeighbourID, boolean pEnemy, int pDistance, double[] pFightMods) throws Exception{
		FightElement vFiEle;
		NeighbourElement vNeigh;
		
		if (!fightList.isEmpty()) {
			fightList.toFirst();
			while(!fightList.isEmpty()) {
				vFiEle = (FightElement) fightList.getCurrent();
				
				if (vFiEle.getId() != pNeighbourID) {
					vNeigh = new NeighbourElement(pNeighbourID, pEnemy, pDistance, pFightMods);
					
					try{ vFiEle.addNeighbourElement(vNeigh); }
					catch (Exception vExc) {throw vExc;}
				}
	
				fightList.next();
			}
		} else throw new Exception("05; FiMan,aNtFs_d");
	}
	//-----
	/**	Dh	23.2.2020
	 * 
	 * 	Fuegt dem ausgewaehlten Kaempfer (pID) die Kampfnachbarliste hinzu.
	 * 
	 * @param pID
	 * @param pNeighbourList
	 * @throws Exception
	 */
	public void addNeighbourListToFighter(int pID, List pNeighbourList) throws Exception{
		if (pNeighbourList != null){
			try{ getFightElement(pID).addNeighbourList(pNeighbourList);}
			catch (Exception vExc) {throw vExc;}
		} else throw new Exception("04; FiMan,aNLtF");
	}
	/**	Dh	3.5.2020
	 * 
	 * 	Fuegt allen Kaempfer*Innen die Kampfnachbarliste hinzu.
	 * 
	 * @param pNeighbourList
	 * @throws Exception
	 */
	public void addNeighbourListToFighters(List pNeighbourList) throws Exception{
		FightElement vFiEle;
		
		if (pNeighbourList != null){
			if (!fightList.isEmpty()) {
				fightList.toFirst();
				while(!fightList.isEmpty()) {
					vFiEle = (FightElement) fightList.getCurrent();
					
					try{ vFiEle.addNeighbourList(pNeighbourList);}
					catch (Exception vExc) {throw vExc;}
		
					fightList.next();
				}
			} else throw new Exception("05; FiMan,aNLtFs");
		} else throw new Exception("04; FiMan,aNLtFs");
	}
	/**	Dh	3.5.2020
	 * 
	 * 	Fuegt allen Kaempfer*Innen eine seperate Kampfnachbarliste hinzu.
	 * 
	 * @param pNeighbourListList
	 * @throws Exception
	 */
	public void addNeighbourListsToFighters(List pNeighbourListList) throws Exception{
		FightElement vFiEle;
		Object vNeighbourList;
		
		if (pNeighbourListList.getContentNumber() == fightList.getContentNumber()) {
			if (!fightList.isEmpty()) {
				fightList.toFirst();
				pNeighbourListList.toFirst();
				
				while(!fightList.isEmpty()) {
					vFiEle = (FightElement) fightList.getCurrent();
					vNeighbourList = pNeighbourListList.getCurrent();
					
					if (vNeighbourList instanceof List) {
						try{ vFiEle.addNeighbourList((List)vNeighbourList);}
						catch (Exception vExc) {throw vExc;}
					} else throw new Exception("06; FiMan,aNLstFs");
					
		
					fightList.next();
					pNeighbourListList.next();
				}
			}
		} else throw new Exception("01; FiMan,aNLstFs");
	}
	//-----
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @param pNeiID
	 * @param pFightMod
	 * @param pInd
	 * @throws Exception
	 */
	public void addFightModOfNeighbourOfFighter(int pFigID, int pNeiID, double pFightMod, int pInd) throws Exception{
		if ((pFigID >= 0) && (pNeiID >= 0)){
			try{ getFightElement(pFigID).getNeighbourElement(pNeiID).addFightMod(pFightMod, pInd);}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,aFMoNoF");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @param pNeiID
	 * @param pFightMods
	 * @throws Exception
	 */
	public void addFightModsOfNeighbourOfFighter(int pFigID, int pNeiID, double[] pFightMods) throws Exception{
		if ((pFigID >= 0) && (pNeiID >= 0)){
			try{ getFightElement(pFigID).getNeighbourElement(pNeiID).addFightMods(pFightMods);}
			catch(Exception vExc) { throw vExc;}
		} else throw new Exception("07; FiMan,aFMsoNoF");
	}
	
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @param pFightMod
	 * @param pInd
	 * @throws Exception
	 */
	public void addFightModOfNeighboursOfFighter(int pFigID, double pFightMod, int pInd) throws Exception{
		Object vNeiEle;
		List vNeiList = null;
		
		if (pFigID >= 0){
			vNeiList = getFightElement(pFigID).getNeighbourList();
				
			if (!vNeiList.isEmpty()){
				vNeiList.toFirst();
				while(!vNeiList.isEnd()){
					vNeiEle = vNeiList.getCurrent();
				
					if (vNeiEle instanceof NeighbourElement) ((NeighbourElement) vNeiEle).addFightMod(pFightMod, pInd);
					else throw new Exception("06; FiMan,aFMoNsoF");
				
					vNeiList.next();
				}
			} else throw new Exception("05; FiMan,aFMoNsoF");
		} else throw new Exception("07; FiMan,aFMoNsoF");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @param pFightMods
	 * @throws Exception
	 */
	public void addFightModsOfNeighboursOfFighter(int pFigID, double[] pFightMods) throws Exception{
		Object vNeiEle;
		List vNeiList = null;
		
		if (pFigID >= 0){
			vNeiList = getFightElement(pFigID).getNeighbourList();
				
			if (!vNeiList.isEmpty()){
				vNeiList.toFirst();
				while(!vNeiList.isEnd()){
					vNeiEle = vNeiList.getCurrent();
				
					if (vNeiEle instanceof NeighbourElement) ((NeighbourElement) vNeiEle).addFightMods(pFightMods);
					else throw new Exception("06; FiMan,aFMsoNsoF");
				
					vNeiList.next();
				}
			} else throw new Exception("05; FiMan,aFMsoNsoF");
		} else throw new Exception("07; FiMan,aFMsoNsoF");
	}
	
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @param pFightModList
	 * @param pInd
	 * @throws Exception
	 */
	public void addFightModsOfNeighboursOfFighter(int pFigID, List pFightModList, int pInd) throws Exception{
		Object vNeiEle, vFightMod;
		List vNeiList = null;
		
		if (pFigID >= 0){
			vNeiList = getFightElement(pFigID).getNeighbourList();
				
			if (vNeiList.getContentNumber() == pFightModList.getContentNumber()){
				vNeiList.toFirst();
				pFightModList.toFirst();
				while(!vNeiList.isEnd()){
					vNeiEle = vNeiList.getCurrent();
					vFightMod = pFightModList.getCurrent();
				
					if ((vNeiEle instanceof NeighbourElement) && (vFightMod instanceof Double)) ((NeighbourElement) vNeiEle).addFightMod((double) vFightMod, pInd);
					else throw new Exception("06; FiMan,aFMsoNsoF");
				
					vNeiList.next();
					pFightModList.next();
				}
			} else throw new Exception("01; FiMan,aFMsoNsoFs");
		} else throw new Exception("07; FiMan,aFMsoNsoF");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFigID
	 * @param pFightModsList
	 * @throws Exception
	 */
	public void addFightModssOfNeighboursOfFighter(int pFigID, List pFightModsList) throws Exception{
		Object vNeiEle, vFightMods;
		List vNeiList = null;
		
		if (pFigID >= 0){
			vNeiList = getFightElement(pFigID).getNeighbourList();
				
			if (vNeiList.getContentNumber() == pFightModsList.getContentNumber()){
				vNeiList.toFirst();
				pFightModsList.toFirst();
				while(!vNeiList.isEnd()){
					vNeiEle = vNeiList.getCurrent();
					vFightMods = pFightModsList.getCurrent();
				
					if ((vNeiEle instanceof NeighbourElement) && (vFightMods instanceof Double[])) ((NeighbourElement) vNeiEle).addFightMods((double[]) vFightMods);
					else throw new Exception("06; FiMan,aFMssoNsoF");
				
					vNeiList.next();
					pFightModsList.next();
				}
			} else throw new Exception("01; FiMan,aFMssoNsoFs");
		} else throw new Exception("07; FiMan,aFMssoNsoF");
	}
	
	/**	Dh	3.5.2020
	 * 
	 * @param pNeiID
	 * @param pFightMod
	 * @param pInd
	 * @throws Exception
	 */
	public void addFightModOfNeighbourOfFighters(int pNeiID, double pFightMod, int pInd) throws Exception{
		Object vFiEle;
		
		if ((pNeiID >= 0)){
			if (!fightList.isEmpty()){
				fightList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
				
					if (vFiEle instanceof FightElement) ((FightElement) vFiEle).getNeighbourElement(pNeiID).addFightMod(pFightMod, pInd);
					else throw new Exception("06; FiMan,aFMoNoFs");
				
					fightList.next();
				}
			} else throw new Exception("05; FiMan,aFMoNoFs");
		} else throw new Exception("07; FiMan,aFMoNoFs");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pNeiID
	 * @param pFightMods
	 * @throws Exception
	 */
	public void addFightModsOfNeighbourOfFighters(int pNeiID, double[] pFightMods) throws Exception{
		Object vFiEle;
		
		if ((pNeiID >= 0)){
			if (!fightList.isEmpty()){
				fightList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
				
					if (vFiEle instanceof FightElement) ((FightElement) vFiEle).getNeighbourElement(pNeiID).addFightMods(pFightMods);
					else throw new Exception("06; FiMan,aFMsoNoFs");
				
					fightList.next();
				}
			} else throw new Exception("05; FiMan,aFMsoNoFs");
		} else throw new Exception("07; FiMan,aFMsoNoFs");
	}
	
	/**	Dh	3.5.2020
	 * 
	 * @param pFightModList
	 * @param pInd
	 * @throws Exception
	 */
	public void addFightModOfNeighboursOfFighters(List pFightModList, int pInd) throws Exception{
		Object vFiEle, vFightMod;
		
		if (fightList.getContentNumber() == pFightModList.getContentNumber()) {
			if (!fightList.isEmpty()){
				fightList.toFirst();
				pFightModList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
					vFightMod = pFightModList.getCurrent();
					
					if ((vFiEle instanceof FightElement) && (vFightMod instanceof Double)) addFightModOfNeighboursOfFighter(((FightElement) vFiEle).getId(), (double)vFightMod, pInd);
					else throw new Exception("06; FiMan,aFMoNsoFs");
			
					fightList.next();
					pFightModList.next();
				}
			}
		} else throw new Exception("01; FiMan,aFMoNsoFs");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFightModsList
	 * @throws Exception
	 */
	public void addFightModsOfNeighboursOfFighters(List pFightModsList) throws Exception{
		Object vFiEle, vFightMods;
		
		if (fightList.getContentNumber() == pFightModsList.getContentNumber()) {
			if (!fightList.isEmpty()){
				fightList.toFirst();
				pFightModsList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
					vFightMods = pFightModsList.getCurrent();
					
					if ((vFiEle instanceof FightElement) && (vFightMods instanceof Double[])) addFightModsOfNeighboursOfFighter(((FightElement) vFiEle).getId(), (double[])vFightMods);
					else throw new Exception("06; FiMan,aFMsoNsoFs");
			
					fightList.next();
					pFightModsList.next();
				}
			}
		} else throw new Exception("01; FiMan,aFMsoNsoFs");
	}
	
	/**	Dh	3.5.2020
	 * 
	 * @param pFightModList
	 * @param pInd
	 * @throws Exception
	 */
	public void addFightModsOfNeighboursOfFighters(List pFightModList, int pInd) throws Exception{
		Object vFiEle, vFightModList;
		
		if (fightList.getContentNumber() == pFightModList.getContentNumber()) {
			if (!fightList.isEmpty()){
				fightList.toFirst();
				pFightModList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
					vFightModList = pFightModList.getCurrent();
					
					if ((vFiEle instanceof FightElement) && (vFightModList instanceof List)) addFightModsOfNeighboursOfFighter(((FightElement) vFiEle).getId(), (List)vFightModList, pInd);
					else throw new Exception("06; FiMan,aFMsoNsoFs");
			
					fightList.next();
					pFightModList.next();
				}
			}
		} else throw new Exception("01; FiMan,aFMsoNsoFs");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pFightModsList
	 * @throws Exception
	 */
	public void addFightModssOfNeighboursOfFighters(List pFightModsList) throws Exception{
		Object vFiEle, vFightModsList;
		
		if (fightList.getContentNumber() == pFightModsList.getContentNumber()) {
			if (!fightList.isEmpty()){
				fightList.toFirst();
				pFightModsList.toFirst();
				while(!fightList.isEnd()){
					vFiEle = fightList.getCurrent();
					vFightModsList = pFightModsList.getCurrent();
					
					if ((vFiEle instanceof FightElement) && (vFightModsList instanceof List)) addFightModssOfNeighboursOfFighter(((FightElement) vFiEle).getId(), (List)vFightModsList);
					else throw new Exception("06; FiMan,aFMssoNsoFs");
			
					fightList.next();
					pFightModsList.next();
				}
			}
		} else throw new Exception("01; FiMan,aFMssoNsoFs");
	}
	//-----
	/**	Dh	11.5.2020
	 * 
	 * 	Sortiert das IniElement in die IniListe ein, und updatet die IniOrder.
	 * 
	 * @param pIniElement
	 * @throws Exception
	 */
	private void addIniElement(IniElement pIniElement) throws Exception{
		int vIni, vTempIni;
		double vIniBasis, vIniBasis2;
		FightElement vFigEle, vFigEle2;
		vIni = pIniElement.getIni();
		
		if (!iniList.haveObject(pIniElement)) {
			if (!iniList.isEmpty()) {
				iniList.toFirst();
					
				while(!iniList.isEnd()) {
					vTempIni = ((IniElement)iniList.getCurrent()).getIni();
						
					if (vTempIni < vIni) {
						iniList.insert(pIniElement);
						iniList.toLast();
					} else if (vTempIni == vIni) {
							vFigEle = getFightElement(pIniElement.getId());
							vFigEle2 = getFightElement(((IniElement)iniList.getCurrent()).getId());
							
							if ((vFigEle != null) && (vFigEle2 != null)) {
								vIniBasis = vFigEle.getCharacter().getFightValue(0);
								vIniBasis2 = vFigEle2.getCharacter().getFightValue(0);
								
								if(vIniBasis >= vIniBasis2) {
									iniList.insert(pIniElement);
									iniList.toLast();
								} else if (iniList.isLast()) {
									iniList.append(pIniElement);
									iniList.next();
								}
							} else throw new Exception("04; FiMan,aIE_a");
					} else if (iniList.isLast()) {
						iniList.append(pIniElement);
						iniList.next();
					}
						
					iniList.next();
				}
			} else iniList.append(pIniElement);
			
			addIniOrderElement(pIniElement.getId(), vIni);
		} else throw new Exception("08; FiMan,aIE_a");
	}
	/**	Dh	11.5.2020
	 * 
	 * 	Erstellt ein IniElement und fuegt es sortiert in die IniListe ein.
	 * 
	 * @param pID
	 * @param pIni
	 * @throws Exception
	 */
	private void addIniElement(int pID, int pIni) throws Exception{
		if (pID >= 0){
			if (!haveIDInIniList(pID)) {
				try { addIniElement(new IniElement(pID, pIni));}
				catch(Exception ex) { throw ex; }
			} throw new Exception("08; FiMan,aIE_b");
		} else throw new Exception("02; FiMan,aIE_b");
	}
	/**	Dh	11.5.2020
	 * 
	 * 	Erstellt ein IniElement und fuegt es sortiert in die IniListe ein.
	 * 
	 * @param pID
	 * @param pIni
	 * @param pAction
	 * @throws Exception
	 */
	private void addIniElement(int pID, int pIni, int pAction) throws Exception{
		if (pID >= 0){
			if (!haveIDInIniList(pID)) {
				try { addIniElement(new IniElement(pID, pIni, pAction));}
				catch(Exception ex) { throw ex; }
			}else throw new Exception("08; FiMan,aIE_c");
		} else throw new Exception("02; FiMan,aIE_c");
	}
	//-----
	/**	Dh	20.5.2020
	 * 
	 * 	Addiert den entsprechenden Ini-Wert des gewaehlten Ini-Elementes und updatet die Reihenfolge und die IniOrder.
	 * 
	 * @param pID
	 * @param pIni
	 * @throws Exception
	 */
	private void addIniOfIniElement(int pID, int pIni) throws Exception{
		IniElement vTemp;
		
		try{ 
			vTemp = getIniElement(pID);
			if (vTemp != null) {
				vTemp.addIni(pIni);
				
				updateIniElementInIniList(pID, pIni);
				addIniToIniOrderElement(pID, pIni);
			} else throw new Exception("04; FiMan,aIoIE");
		} catch (Exception vExc) {throw vExc;}
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pID
	 * @param pTempIni
	 * @throws Exception
	 */
	private void addTempIniOfIniElement(int pID, int pTempIni) throws Exception{
		try{ getIniElement(pID).addTempIni(pTempIni);}
		catch (Exception vExc) {throw vExc;}
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pID
	 * @param pAction
	 * @throws Exception
	 */
	private void addActionOfIniElement(int pID, int pAction) throws Exception{
		try{ getIniElement(pID).addTempIni(pAction);}
		catch (Exception vExc) {throw vExc;}
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pID
	 * @param pTempAction
	 * @throws Exception
	 */
	private void addTempActionOfIniElement(int pID, int pTempAction) throws Exception{
		try{ getIniElement(pID).addTempIni(pTempAction);}
		catch (Exception vExc) {throw vExc;}
	}
	
	/**	Dh	20.5.2020
	 * 
	 * 	Addiert den jeweiligen Ini-Wert des entsprechenden Ini-Elementes und updatet die Reihenfolge und die IniOrder.
	 * 
	 * @param pIniList
	 * @throws Exception
	 */
	private void addIniOfIniElements(List pIniList) throws Exception{
		Object vIniEle, vIni;
		List vIDList = new List();
		
		if (iniList.getContentNumber() == pIniList.getContentNumber()){
			iniList.toFirst();
			pIniList.toFirst();
			while (!iniList.isEnd()){
				vIniEle = iniList.getCurrent();
				vIni = pIniList.getCurrent();
			
				if ((vIniEle instanceof IniElement) && (vIni instanceof Integer)) {
					((IniElement) vIniEle).addIni((int)vIni);
					vIDList.append(((IniElement)vIniEle).getId());
				}
				else throw new Exception("06; FiMan,aIoIEs");
			
				fightList.next();
				pIniList.next();
			}
			try { 
				updateIniList();
				addInisToIniOrderElements(vIDList, pIniList);
			}catch(Exception ex) {throw ex;}
		} else throw new Exception("01; FiMan,aIoIEs");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pTempIniList
	 * @throws Exception
	 */
	private void addTempIniOfIniElements(List pTempIniList) throws Exception{
		Object vIniEle, vTempIni;
		
		if (iniList.getContentNumber() == pTempIniList.getContentNumber()){
			iniList.toFirst();
			pTempIniList.toFirst();
			while (!iniList.isEnd()){
				vIniEle = iniList.getCurrent();
				vTempIni = pTempIniList.getCurrent();
			
				if ((vIniEle instanceof IniElement) && (vTempIni instanceof Integer)) ((IniElement) vIniEle).addTempIni((int)vTempIni);
				else throw new Exception("06; FiMan,aTIoIEs");
			
				fightList.next();
				pTempIniList.next();
			}
		} else throw new Exception("01; FiMan,aTIoIEs");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pActionList
	 * @throws Exception
	 */
	private void addActionOfIniElements(List pActionList) throws Exception{
		Object vIniEle, vAction;
		
		if (iniList.getContentNumber() == pActionList.getContentNumber()){
			iniList.toFirst();
			pActionList.toFirst();
			while (!iniList.isEnd()){
				vIniEle = iniList.getCurrent();
				vAction = pActionList.getCurrent();
			
				if ((vIniEle instanceof IniElement) && (vAction instanceof Integer)) ((IniElement) vIniEle).addAction((int)vAction);
				else throw new Exception("06; FiMan,sAoIEs");
			
				fightList.next();
				pActionList.next();
			}
		} else throw new Exception("01; FiMan,sAoIEs");
	}
	/**	Dh	3.5.2020
	 * 
	 * @param pTempActionList
	 * @throws Exception
	 */
	private void addTempActionOfIniElements(List pTempActionList) throws Exception{
		Object vIniEle, vTempAction;
		
		if (iniList.getContentNumber() == pTempActionList.getContentNumber()){
			iniList.toFirst();
			pTempActionList.toFirst();
			while (!iniList.isEnd()){
				vIniEle = iniList.getCurrent();
				vTempAction = pTempActionList.getCurrent();
			
				if ((vIniEle instanceof IniElement) && (vTempAction instanceof Integer)) ((IniElement) vIniEle).addTempAction((int)vTempAction);
				else throw new Exception("06; FiMan,sTAoIEs");
			
				fightList.next();
				pTempActionList.next();
			}
		} else throw new Exception("01; FiMan,sTAoIEs");
	}
	
	/**	Dh	11.5.2020
	 * 
	 * 	Fuegt sortiert ein neues IniOrderElement in die IniOrder ein.
	 * 
	 * @param pIniOrderElement
	 * @param pIniBasis
	 * @throws Exception
	 */
	private void addIniOrderElement(int[] pIniOrderElement) throws Exception{
		double vIniBasis, vIniBasis2;
		int[] vCur;
		FightElement vFiEle, vFiEle2;
		
		if (pIniOrderElement != null) {
			if (!iniOrder.isEmpty()) {
				iniOrder.toFirst();
			
				while(!iniOrder.isEnd() && (pIniOrderElement != null)) {
					vCur = (int[])iniOrder.getCurrent();
				
					if (vCur[1] < pIniOrderElement[1]) {
						iniOrder.insert(pIniOrderElement.clone());
						pIniOrderElement = null;
					}
					else if(vCur[1] == pIniOrderElement[1]) {
						vFiEle = getFightElement(pIniOrderElement[0]);
						vFiEle2 = getFightElement(vCur[0]);
						if ((vFiEle != null) &&(vFiEle2 != null)) {
							vIniBasis = vFiEle.getCharacter().getFightValue(0);
							vIniBasis2 = vFiEle2.getCharacter().getFightValue(0);
						
							if (vIniBasis2 <= vIniBasis) {
								iniOrder.insert(pIniOrderElement.clone());
								pIniOrderElement = null;
							}
						}
						else throw new Exception("05; FiMan,aIOE_a");
					}
					
					iniOrder.next();
				}
			
				if (pIniOrderElement != null) iniOrder.append(pIniOrderElement);
			} else iniOrder.append(pIniOrderElement);
		} else throw new Exception("05; FiMan,aIOE_a");
	}
	/**	Dh	11.5.2020
	 * 
	 * 	Fuegt sortiert ein neues IniOrderElement in die IniOrder ein.
	 * 
	 * @param pID
	 * @param pIni
	 * @param pIniBasis
	 * @throws Exception
	 */
	private void addIniOrderElement(int pID, int pIni) throws Exception {
		double vIniBasis, vIniBasis2;
		int[] vIniOrderElement, vCur;
		FightElement vFiEle, vFiEle2;
		
		vIniOrderElement = new int[] {pID, pIni};
		
		
		if (!iniOrder.isEmpty()) {
			iniOrder.toFirst();
			
			while(!iniOrder.isEnd() && (vIniOrderElement != null)) {
				vCur = (int[])iniOrder.getCurrent();
				
				if (vCur[1] < pIni) {
					iniOrder.insert(vIniOrderElement.clone());
					vIniOrderElement = null;
				}
				else if(vCur[1] == pIni) {
					vFiEle = getFightElement(pID);
					vFiEle2 = getFightElement(vCur[0]);
					if ((vFiEle != null) && (vFiEle2 != null)) {
						vIniBasis = vFiEle.getCharacter().getFightValue(0);
						vIniBasis2 = vFiEle2.getCharacter().getFightValue(0);
						
						if (vIniBasis2 <= vIniBasis) {
							iniOrder.insert(vIniOrderElement.clone());
							vIniOrderElement = null;
						}
					}
					else throw new Exception("05; FiMan,aIOE");
				}
				
				iniOrder.next();
			}
			
			if (vIniOrderElement != null) iniOrder.append(vIniOrderElement);
		} else iniOrder.append(vIniOrderElement);
	}
	
	/**	Dh	20.5.2020
	 * 
	 * 	Addiert den pIni Wert zu den durch pID angegeben IniOrderElemente, und sorgt dafür, dass der Wert nicht negativ wird.
	 * 
	 * @param pID
	 * @param pIni
	 * @throws Exception
	 */
	private void addIniToIniOrderElement(int pID, int pIni) throws Exception {
		int[] vIniOrderEle;
		
		if (pID >= 0) {
			if (!iniOrder.isEmpty()) {
				
				iniOrder.toFirst();
				while(!iniOrder.isEnd()) {
					vIniOrderEle = (int[])iniOrder.getCurrent();
					
					if (vIniOrderEle[0] == pID) {
						if ((pIni >= 0) || (vIniOrderEle[1] >= -pIni)) vIniOrderEle[1] += pIni;
						else {
							vIniOrderEle[1] = 0;
							throw new Exception("02; FiMan,aItIOE");
						}
					}
					
					iniOrder.next();
				}
				updateIniOrder();
			}
		}else throw new Exception("02; FiMan,aItIOE");
	}
	/**	Dh	20.5.2020
	 * 
	 * 	Addiert den pIni Wert zu den durch die pIDList gegeben IDs der iniOrerElements, und sorgt dafür, dass der Wert nicht negativ wird.
	 * 
	 * @param pIDList
	 * @param pIni
	 * @throws Exception
	 */
	private void addIniToIniOderElements(List pIDList, int pIni) throws Exception{
		Object vID;
		
		if (pIDList != null) {
			if ((!pIDList.isEmpty()) && (!iniOrder.isEmpty())){
				pIDList.toFirst();
				
				while (!pIDList.isEnd()) {
					vID = pIDList.getCurrent();
					
					if (vID instanceof Integer) {
						try{ addIniToIniOrderElement((int)vID, pIni);}
						catch(Exception ex) {throw ex;}
					}
					else throw new Exception("06; FiMan,aItIOEs");
					
					pIDList.next();
				}
			}
		}else throw new Exception("04; FiMan,aItIOEs");
	}
	/**	Dh	20.5.2020
	 * 
	 * 	Addiert die Ini Wert der pIniList zu den durch die pIDList gegeben IDs der iniOrerElements, und sorgt dafür, dass der Wert nicht negativ wird.
	 * 
	 * @param pIDList
	 * @param pIniList
	 * @throws Exception
	 */
	private void addInisToIniOrderElements(List pIDList, List pIniList) throws Exception{
		Object vID, vIni;
		
		if ((pIDList != null) && (pIniList != null)) {
			if ((!pIniList.isEmpty()) &&(!pIDList.isEmpty()) && (!iniOrder.isEmpty())){
				if (pIniList.getContentNumber() != pIDList.getContentNumber()) {
					pIDList.toFirst();
					pIniList.toFirst();
				
					while (!pIDList.isEnd()) {
						vID = pIDList.getCurrent();
						vIni = pIniList.getCurrent();
						
						if ((vID instanceof Integer) && (vIni instanceof Integer)) {
							try{ addIniToIniOrderElement((int)vID, (int)vIni);}
							catch(Exception ex) {throw ex;}
						}
						else throw new Exception("06; FiMan,aIstIOEs");
						
						pIDList.next();
						pIniList.next();
					}
				} else throw new Exception("01; FiMan,aIstIOEs");
			}
		}else throw new Exception("04; FiMan,aIstIOEs");
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	11.5.2020
	 * 
	 * 	Entfernt den Fighter mit der entsprechenden ID aus der FightList, und updated die Ini Liste.
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void removeFighter(int pID) throws Exception {
		FightElement vFiEle;
		
		if(pID >= 0) {
			if(!fightList.isEmpty()) {
				fightList.toFirst();
				
				while(!fightList.isEnd()) {
					vFiEle = (FightElement) fightList.getCurrent();
					if (vFiEle.getId() == pID) {
						fightList.remove();
						fightList.toLast();
						removeIniElement(pID);
					}
					
					fightList.next();
				}
			}else throw new Exception("05; FiMan,rF");
		} else throw new Exception("02; FiMan,rF");
	}
	/**	Dh	11.5.2020
	 * 
	 * 	Entfernt alle FightElemente deren ID in der ID Liste ist aus der FightListe.
	 * 	
	 * @param pIDList
	 * @throws Exception
	 */
	public void removeFighters(List pIDList) throws Exception{
		Object vID;
		
		if (!pIDList.isEmpty()) {
			pIDList.toFirst();
			
			while(!pIDList.isEnd()) {
				vID = pIDList.getCurrent();
				if (vID instanceof Integer) {
					removeFighter((int)vID);
					removeIniElements(pIDList);
				}
				else throw new Exception("02; FiMan, rFs");
				
				pIDList.next();
			}
		}else throw new Exception("05; FiMan,rFs");
	}
	/**	Dh	11.5.2020
	 * 
	 * 	Entfernt alle Elemente aus der FightListe und updatet die IniListe.
	 */
	public void removeAllFighters() {
		if (!fightList.isEmpty()) {
			fightList.toFirst();
			while(!fightList.isEmpty()) {
				fightList.remove();
			}
		}
		removeAllIniElements();
	}
	
	/**	Dh	28.5.2020
	 * 
	 * @param pID
	 * @param pInd
	 * @throws Exception
	 */
	public void removeActiveWeaponOfFighter(int pID, int pInd) throws Exception{
		FightElement vCur;
		if (pID >= 0) {
			vCur = getFightElement(pID);
			if (vCur != null) vCur.removeActiveWeapon(pInd);
			else throw new Exception("02; FiMan,rAWoF");
		}
		else throw new Exception("02; FiMan,rAWoF");
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pID
	 * @param pActiveWeapon
	 * @throws Exception
	 */
	public void removeActiveWeaponOfFighter(int pID, Weapon pActiveWeapon) throws Exception{
		FightElement vCur;
		if (pID >= 0) {
			vCur = getFightElement(pID);
			if (vCur != null) vCur.removeActiveWeapon(pActiveWeapon);
			else throw new Exception("02; FiMan,rAWoF");
		}
		else throw new Exception("02; FiMan,rAWoF");
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pID
	 * @param pActiveWeapons
	 * @throws Exception
	 */
	public void removeActiveWeaponsOfFighter(int pID, List pActiveWeapons) throws Exception{
		FightElement vCur;
		if (pID >= 0) {
			vCur = getFightElement(pID);
			if (vCur != null) vCur.removeActiveWeapons(pActiveWeapons);
			else throw new Exception("02; FiMan,rAWsoF");
		}
		else throw new Exception("02; FiMan,rAWsoF");
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pInd
	 * @throws Exception
	 */
	public void removeActiveWeaponOfFighters(int pInd) throws Exception{
		if (!fightList.isEmpty()) {
			fightList.toFirst();
			
			while (!fightList.isEnd()) {
				((FightElement)fightList.getCurrent()).removeActiveWeapon(pInd);
				
				fightList.next();
			}
		} else throw new Exception("05; FiMan,rAWoFs");
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pActiveWeapon
	 * @throws Exception
	 */
	public void removeActiveWeaponOfFighters(Weapon pActiveWeapon) throws Exception{
		if (!fightList.isEmpty()) {
			fightList.toFirst();
			
			while (!fightList.isEnd()) {
				((FightElement)fightList.getCurrent()).removeActiveWeapon(pActiveWeapon);
				
				fightList.next();
			}
		} else throw new Exception("05; FiMan,rAWoFs");
	}
	/**	Dh	28.5.2020
	 * 
	 * @param pActiveWeaponList
	 * @throws Exception
	 */
	public void removeActiveWeaponsOfFighters(List pActiveWeaponList) throws Exception{
		if (!fightList.isEmpty()) {
			fightList.toFirst();
			
			while (!fightList.isEnd()) {
				((FightElement)fightList.getCurrent()).removeActiveWeapons(pActiveWeaponList);
				
				fightList.next();
			}
		} else throw new Exception("05; FiMan,rAWoFs");
	}
	
	/**	Dh	23.5.2020
	 * 
	 * 	Entfernt den durch pNeiID angegeben Neighbour des Fighter der pID.
	 * 
	 * @param pID
	 * @param pNeiID
	 * @throws Exception
	 */
	public void removeNeighbourOfFighter(int pID, int pNeiID) throws Exception {
		FightElement vCur;
		
		if (pID >= 0) {
			vCur = getFightElement(pID);
			if (vCur != null) {
				try {vCur.removeNeighbourElement(pNeiID);}
				catch(Exception ex) {throw ex;}
			}
		}else throw new Exception("02; FiMan,rNoF");
	}
	/**	Dh	23.5.2020
	 * 
	 * 	Entfernt das pNeiEle des Fighter der pID.
	 * 
	 * @param pID
	 * @param pNeiEle
	 * @throws Exception
	 */
	public void removeNeighbourOfFighter(int pID, NeighbourElement pNeiEle) throws Exception {
		FightElement vCur;
		
		if (pID >= 0) {
			vCur = getFightElement(pID);
			if (vCur != null) {
				try {vCur.removeNeighbourElement(pNeiEle);}
				catch(Exception ex) {throw ex;}
			}
		}else throw new Exception("02; FiMan,rNoF");
	}
	/**	Dh	23.5.2020
	 * 
	 * 	Entfernt von allen Kaempfer*Innen die pNeiID aus der NeighbourList.
	 * 
	 * @param pNeiID
	 * @throws Exception
	 */
	public void removeNeighbourOfFighters(int pNeiID) throws Exception {
		FightElement vCur;
		
		if (!fightList.isEmpty()) {
			fightList.toFirst();
			
			while (!fightList.isEnd()) {
				vCur = (FightElement)fightList.getCurrent();
				
				try {vCur.removeNeighbourElement(pNeiID);}
				catch(Exception ex) {throw ex;}
				
				fightList.next();
			}
		} else throw new Exception("05; FiMan,rNoFs");
	}
	/**	Dh	23.5.2020
	 * 
	 * 	Entfernt von allen Kaempfer*Innen das pNeiEle.
	 * 
	 * @param pNeiEle
	 * @throws Exception
	 */
	public void removeNeighbourOfFighters(NeighbourElement pNeiEle) throws Exception {
		FightElement vCur;
		
		if (!fightList.isEmpty()) {
			fightList.toFirst();
			
			while (!fightList.isEnd()) {
				vCur = (FightElement)fightList.getCurrent();
				
				try {vCur.removeNeighbourElement(pNeiEle);}
				catch(Exception ex) {throw ex;}
				
				fightList.next();
			}
		} else throw new Exception("05; FiMan,rNoFs");
	}
	//-----
	/**	Dh	11.5.2020
	 * 
	 * 	Entfernt das IniElement mit der entsprechenden ID aus der IniList, und updated die IniOrder.
	 * 
	 * @param pID
	 * @throws Exception
	 */
	private void removeIniElement(int pID) throws Exception {
		IniElement vIniEle;
		
		if(pID >= 0) {
			if(!iniList.isEmpty()) {
				iniList.toFirst();
				
				while(!iniList.isEnd()) {
					vIniEle = (IniElement) iniList.getCurrent();
					if (vIniEle.getId() == pID) {
						iniList.remove();
						iniList.toLast();
					}
					
					iniList.next();
				}
			}else throw new Exception("05; FiMan,rF");
		} else throw new Exception("02; FiMan,rF");
	}
	/**	Dh	11.5.2020
	 * 
	 * 	Entfernt alle IniElemente deren ID in der ID Liste ist aus der IniListe.
	 * 
	 * @param pIDList
	 * @throws Exception
	 */
	private void removeIniElements(List pIDList) throws Exception{
		Object vID;
		
		if (!pIDList.isEmpty()) {
			pIDList.toFirst();
			
			while(!pIDList.isEnd()) {
				vID = pIDList.getCurrent();
				if (vID instanceof Integer) {
					removeIniElement((int)vID);
					removeIniOrderElements(pIDList);
				}
				else throw new Exception("02; FiMan, rIEs");
				
				pIDList.next();
			}
		}else throw new Exception("05; FiMan,rIEs");
	}
	/**	Dh	11.5.2020
	 * 
	 * 	Entfernt alle Elemente aus der IniListe und updatet die IniOrder.
	 */
	private void removeAllIniElements() {
		if (!iniList.isEmpty()) {
			iniList.toFirst();
			while(!iniList.isEmpty()) {
				iniList.remove();
			}
		}
		removeAllIniOrderElements();
	}
	//-----
	/**	Dh	11.5.2020
	 * 
	 * 	Entfernt alle IniOrderElemente mit der entsprechenden ID aus der IniOrder.
	 * 
	 * @param pID
	 * @throws Exception
	 */
	private void removeIniOrderElement(int pID) throws Exception{
		int[] vIniEle;
		
		if(pID >= 0) {
			if(!iniOrder.isEmpty()) {
				iniOrder.toFirst();
				
				while(!iniOrder.isEnd()) {
					vIniEle = (int[]) iniOrder.getCurrent();
					if (vIniEle[0] == pID) iniOrder.remove();
					
					iniOrder.next();
				}
				
				if (iniOrder.isEmpty()) makeIniOrder();
			}else throw new Exception("05; FiMan,rF");
		} else throw new Exception("02; FiMan,rF");
	}
	/**	Dh	11.5.2020
	 * 
	 * 	Entfernt alle IniOrderElemente deren ID in der ID Liste ist aus der IniOrder.
	 * 
	 * @param pIDList
	 * @throws Exception
	 */
	private void removeIniOrderElements(List pIDList) throws Exception {
		Object vID;
		
		if (!pIDList.isEmpty()) {
			pIDList.toFirst();
			
			while(!pIDList.isEnd()) {
				vID = pIDList.getCurrent();
				if (vID instanceof Integer) removeIniOrderElement((int)vID);
				else throw new Exception("02; FiMan, rIOEs");
				
				pIDList.next();
			}
		}else throw new Exception("05; FiMan,rIOEs");
	}
	/**	Dh	11.5.2020
	 * 
	 * 	Entfernt alle Elemente aus der IniOrder.
	 */
	private void removeAllIniOrderElements() {
		iniOrder = new List();
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	6.5.2020
	 * 
	 * 	Geht zum nächsten Zug.
	 */
	public void nextTurn() throws Exception{
		if (!iniOrder.isEmpty()) {
			iniOrder.toFirst();
			iniOrder.remove();
			
			if (iniOrder.isEmpty()) {
				nextRound();
			}
		} else throw new Exception("05; FiMan,nT");
	}
	/**	Dh	6.5.2020
	 * 
	 * 	Geht zur naechsten Runde.
	 * 
	 * @throws Exception
	 */
	public void nextRound(){
		makeIniOrder();
		roundCounter += 1;
	}
	
	/**	Dh	11.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int makeAttackProbe(int pID) throws Exception{
		return makeAttackProbe(pID, 0, 2);
	}
	/**	Dh	11.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int makeDefenceProbe(int pID) throws Exception{
		return makeDefenceProbe(pID, 0, 2);
	}
	/**	Dh	11.6.2020
	 * 
	 * @param pID
	 * @param pMod
	 * @return
	 * @throws Exception
	 */
	public int makeAttackProbe(int pID, int pMod) throws Exception{
		return makeAttackProbe(pID, pMod, 2);
	}
	/**	Dh	11.6.2020
	 * 
	 * @param pID
	 * @param pMod
	 * @return
	 * @throws Exception
	 */
	public int makeDefenceProbe(int pID, int pMod) throws Exception{
		return makeDefenceProbe(pID, pMod, 2);
	}
	/**	Dh	11.6.2020
	 * 
	 * @param pID
	 * @param pMod
	 * @param pActiveWeaponInd
	 * @return
	 * @throws Exception
	 */
	public int makeAttackProbe(int pID, int pMod, int pActiveWeaponInd) throws Exception{
		if (pID >= 0) {
			return getFightElement(pID).makeAttackWithActiveWeapon(pMod, pActiveWeaponInd);
		}else throw new Exception("02; FiMan,mAP");
	}
	/**	Dh	11.6.2020
	 * 
	 * @param pID
	 * @param pMod
	 * @param pActiveWeaponInd
	 * @return
	 * @throws Exception
	 */
	public int makeDefenceProbe(int pID, int pMod, int pActiveWeaponInd) throws Exception{
		if (pID >= 0) {
			return getFightElement(pID).makeDefenceWithActiveWeapon(pMod, pActiveWeaponInd);
		}else throw new Exception("02; FiMan,mAP");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	4.5.2020
	 * 
	 * 	Berechnet den Ini-Wert anhand des entsprechenden Ini-Basiswert und gibt den zurück.
	 * 
	 * @param pIniBasis
	 * @return
	 * @throws Exception
	 */
	private int calcIni(int pIniBasis, int pDiceCount) throws Exception {
		Random vRandom = new Random();
		int vRet = pIniBasis;
		
		if ((pIniBasis >= 0) && (pDiceCount >= 0)) {
			for (int i=0; i<pDiceCount; i=i+1) {
				vRet += vRandom.nextInt(7);
			}
		} else throw new Exception("02; FiMan,cI_a");
		
		return  vRet;
	}
	/**	Dh	4.5.2020
	 * 
	 * 	Berechnet den Ini-Wert eines Charakters, macht das Setup fuer die Berechnung.
	 * 
	 * @param pCharacter
	 * @return
	 * @throws Exception
	 */
	private int calcIni(Charakter pCharacter) throws Exception{
		int vIniBasis, vDiceCount;
		
		if (pCharacter != null) {
			vIniBasis = (int)Math.round(pCharacter.getFightValue(0));
			vDiceCount = 1;
			try { return calcIni(vIniBasis, vDiceCount);}
			catch(Exception ex) {throw ex;}
		} else throw new Exception("04; FiMan,cI_b");
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	6.5.2020
	 * 
	 * 	Erzeugt eine neue Ini-Order Liste
	 * 
	 */
	private void makeIniOrder() {
		int[] vTemp = new int[2];
		iniOrder = new List();
		
		if (!iniList.isEmpty()) {
			iniList.toFirst();
			
			while(!iniList.isEnd()) {
				vTemp[0] = ((IniElement)iniList.getCurrent()).getId();
				vTemp[1] = ((IniElement)iniList.getCurrent()).getIni();
				
				iniOrder.append(vTemp.clone());
				
				iniList.next();
			}
			
			iniOrder.toFirst();
		}
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	4.5.2020
	 * 
	 * 	Updatet das IniElemente nach verändertem Ini-Wert.
	 * 
	 * @param pID
	 * @param pChangeValue
	 * @throws Exception
	 */
	private void updateIniElementInIniList(int pID, int pChangeValue) throws Exception {
		int vIni, vTempIni;
		double vIniBasis, vIniBasis2;
		FightElement vFigEle, vFigEle2;
		IniElement vTemp = null;
		
		if (pID >= 0) {
			if (!iniList.isEmpty()) {
				iniList.toFirst();
				
				while(!iniList.isEnd() && vTemp == null) {
					vTemp = (IniElement)iniList.getCurrent();
					
					if (pID != vTemp.getId()) {
						vTemp = null;
						iniList.next();
					}
				}
				
				if (vTemp != null) {
					vIni = vTemp.getIni();
					vFigEle = getFightElement(vTemp.getId());
					if (vFigEle != null) {
						vIniBasis = vFigEle.getCharacter().getFightValue(0);
						iniList.remove();
						
						if (pChangeValue > 0) {							
							while(!iniList.isFirst() && vTemp != null) {
								vTempIni = ((IniElement)iniList.getCurrent()).getIni();
								if (vIni < vTempIni ) {
									iniList.next();
									iniList.insert(vTemp);
									vTemp = null;
								}
								else if (vIni == vTempIni) {
									vFigEle2 = getFightElement(((IniElement)iniList.getCurrent()).getId());
									if (vFigEle2 != null) {
										vIniBasis2 = vFigEle2.getCharacter().getFightValue(0);
										
										if (vIniBasis < vIniBasis2) {
											iniList.next();
											iniList.insert(vTemp);
											vTemp = null;
										}
									} else throw new Exception("04; FiMan,uIEiIL");
								}
								
								iniList.prior();
							}
							
							if (vTemp != null) iniList.insert(vTemp);
						}else {
							while(!iniList.isEnd()) {
								vTempIni = ((IniElement)iniList.getCurrent()).getIni();
								if (vIni > vTempIni ) iniList.insert(vTemp);
								else if (vIni == vTempIni) {
									vFigEle2 = getFightElement(((IniElement)iniList.getCurrent()).getId());
									if (vFigEle2 != null) {
										vIniBasis2 = vFigEle2.getCharacter().getFightValue(0);
										
										if (vIniBasis >= vIniBasis2) iniList.insert(vTemp);
										else {
											iniList.insert(vTemp);
											iniList.next();
										}
									} else throw new Exception("04; FiMan,uIEiIL");
								} else if (iniList.isLast()) {
									iniList.insert(vTemp);
									iniList.next();
								}
								
								iniList.next();
							}
						}
					} else throw new Exception("04; FiMan,uIEiIL");
				} else throw new Exception("07; FiMan,uIEiIL");
			} else throw new Exception("05; FiMan,uIEiIL");
		} else throw new Exception("02; FiMan,uIEiIL");
	}
	/**	Dh	20.5.2020
	 * 
	 * @param pIniElement
	 * @param pIni
	 * @param pIniBasis
	 * @throws Exception
	 */
	private void recElementUpdateIniList(IniElement pIniElement, int pIni, double pIniBasis) throws Exception{
		int vIni;
		double vIniBasis;
		FightElement vFigEle;
		
		vIni = ((IniElement)iniList.getCurrent()).getIni();
			
		if (pIni < vIni) {
			iniList.next();
			iniList.insert(pIniElement);
		} else if (pIni == vIni) {
			vFigEle = getFightElement(((IniElement)iniList.getCurrent()).getId());
			if (vFigEle != null) {
				vIniBasis = vFigEle.getCharacter().getFightValue(0);
				
				if(pIniBasis < vIniBasis) {
					iniList.next();
					iniList.insert(pIniElement);
				} else if (!iniList.isFirst()) {
					iniList.prior();
					recElementUpdateIniList(pIniElement, pIni, pIniBasis);
					if (!iniList.isLast()) iniList.next();
				} else iniList.insert(pIniElement);
			} else throw new Exception("04; FiMan,rEuIL");
		} else if (!iniList.isFirst()) {
			iniList.prior();
			recElementUpdateIniList(pIniElement, pIni, pIniBasis);
			if (!iniList.isLast())iniList.next();
		} else iniList.insert(pIniElement);
	}
	/**	Dh	24.6.2020
	 * 
	 * 	Updatet die IniList.
	 * 
	 * @throws Exception
	 */
	private void updateIniList() throws Exception {
		int vIni, vTempIni;
		double vIniBasis, vTempIniBasis;
		FightElement vFigEle, vFigEle2;
		IniElement vTempIniEle;
		
		if (!iniList.isEmpty()) {
			iniList.toFirst();
			vIni = ((IniElement)iniList.getCurrent()).getIni();
			vFigEle = getFightElement(((IniElement)iniList.getCurrent()).getId());
			
			if (vFigEle != null) vIniBasis = vFigEle.getCharacter().getFightValue(0);
			else throw new Exception("04; FiMan,uIL");
			iniList.next();
			
			while(!iniList.isEnd()) {
				vTempIniEle = ((IniElement)iniList.getCurrent());
				vTempIni = vTempIniEle.getIni();
				vFigEle2 = getFightElement(vTempIniEle.getId());
				if (vFigEle2 != null) {
					vTempIniBasis = vFigEle2.getCharacter().getFightValue(0);
					
					if (vTempIni > vIni) {
						iniList.remove();
						if (!iniList.isLast()) iniList.prior();
						try { recElementUpdateIniList(vTempIniEle, vTempIni, vTempIniBasis); }
						catch(Exception ex) {throw ex;}
						iniList.prior();
						vTempIni = vIni;
						vTempIniBasis = vIniBasis;
					} else if ((vTempIni == vIni) && (vTempIniBasis > vIniBasis)) {
						iniList.remove();
						if (!iniList.isLast()) iniList.prior();
						try { recElementUpdateIniList(vTempIniEle, vTempIni, vTempIniBasis); }
						catch(Exception ex) {throw ex;}
						iniList.prior();
						vTempIni = vIni;
						vTempIniBasis = vIniBasis;
					}
				} else throw new Exception("04; FiMan,uIL");
				
				vIni = vTempIni;
				vIniBasis = vTempIniBasis;
				
				iniList.next();
			}
		}
	}
	
	/**	Dh	6.5.2020
	 * 
	 * @param pID
	 * @param pOldIni
	 * @param pNewIni
	 * @throws Exception
	 */
	private void updateElementOfIniOrder(int pID, int pOldIni, int pNewIni) throws Exception {
		int[] vCur, vCur2;
		double vIniBasis, vIniBasis2;
		FightElement vFigEle, vFigEle2;
		
		if (pOldIni != pNewIni) {
			if (!iniOrder.isEmpty()) {
				iniOrder.toFirst();
			
				while(!iniOrder.isEnd()) {
					vCur = (int[])iniOrder.getCurrent();
					
					if ((vCur[0] == pID) && (vCur[1] == pOldIni)) {
						iniOrder.remove();
						vCur[1] = pNewIni;
						vFigEle = getFightElement(pID);
						if (vFigEle != null) {
							vIniBasis = vFigEle.getCharacter().getFightValue(0);
							if (pOldIni > pNewIni) {
								while(!iniOrder.isEnd() && (vCur != null)) {
									vCur2 = (int[])iniOrder.getCurrent();
									
									if (pNewIni > vCur2[1]) {
										iniOrder.insert(vCur);
										vCur = null;
									} else if (pNewIni == vCur2[1]) {
										vFigEle2 = getFightElement(vCur2[0]);
										if (vFigEle2 != null) {
											vIniBasis2 = vFigEle2.getCharacter().getFightValue(0);
											if (vIniBasis >= vIniBasis2) {
												iniOrder.insert(vCur);
												vCur = null;
											}
										} else throw new Exception("04; FiMan,uEoIO");
									}
									
									iniOrder.next();
								}
								
								if (vCur != null) iniOrder.append(vCur);
							} else {
								while(!iniOrder.isFirst() && (vCur != null)) {
									vCur2 = (int[])iniOrder.getCurrent();
									
									if (pNewIni < vCur2[1]) {
										iniOrder.next();
										iniOrder.insert(vCur);
										vCur = null;
									} else if (pNewIni == vCur2[1]) {
										vFigEle2 = getFightElement(vCur2[0]);
										if (vFigEle2 != null) {
											vIniBasis2 = vFigEle2.getCharacter().getFightValue(0);
											if (vIniBasis >= vIniBasis2) {
												iniOrder.next();
												iniOrder.insert(vCur);
												vCur = null;
											}
										} else throw new Exception("04; FiMan,uEoIO");
									}
									
									iniOrder.prior();
								}
								
								if (vCur != null) iniOrder.insert(vCur);
							}
						} else throw new Exception("04; FiMan,uEoIO");
						iniOrder.toLast();
					}
				
					iniOrder.next();
				}
				
				iniOrder.toFirst();
			}else throw new Exception("05; FiMan,uEoIO");
		}
	}
	/**	Dh	20.5.2020
	 * 
	 * @param pIniOrderElement
	 * @param pIni
	 * @param pIniBasis
	 * @throws Exception
	 */
	private void recElementUpdateIniOrder(int[] pIniOrderElement, int pIni, double pIniBasis) throws Exception{
		int vIni;
		double vIniBasis;
		FightElement vFigEle;
		
		vIni = ((int[])iniOrder.getCurrent())[1];
			
		if (pIni < vIni) {
			iniOrder.next();
			iniOrder.insert(pIniOrderElement);
		} else if (pIni == vIni) {
			vFigEle = getFightElement(((int[])iniOrder.getCurrent())[0]);
			if (vFigEle != null) {
				vIniBasis = vFigEle.getCharacter().getFightValue(0);
				
				if(pIniBasis < vIniBasis) {
					iniOrder.next();
					iniOrder.insert(pIniOrderElement);
				} else if (!iniOrder.isFirst()) {
					iniOrder.prior();
					recElementUpdateIniOrder(pIniOrderElement, pIni, pIniBasis);
					if (!iniOrder.isLast()) iniOrder.next();
				} else iniOrder.insert(pIniOrderElement);
			} else throw new Exception("04; FiMan,rEuIO");
		} else if (!iniOrder.isFirst()) {
			iniOrder.prior();
			recElementUpdateIniOrder(pIniOrderElement, pIni, pIniBasis);
			if (!iniOrder.isLast()) iniOrder.next();
		} else iniOrder.insert(pIniOrderElement);
	}
	/**	Dh	20.5.2020
	 * 
	 * @throws Exception
	 */
	private void updateIniOrder() throws Exception{
		int vIni, vIni2;
		int[] vCur;
		double vIniBasis, vIniBasis2;
		FightElement vFigEle, vFigEle2;
		
		if (!iniOrder.isEmpty()) {
			iniOrder.toFirst();
			
			vIni = ((int[])iniOrder.getCurrent())[1];
			vFigEle = getFightElement(((int[])iniOrder.getCurrent())[0]);
			if (vFigEle != null) {
				vIniBasis = vFigEle.getCharacter().getFightValue(0);
				iniOrder.next();
				
				while(!iniOrder.isEnd()) {
					vIni2 = ((int[])iniOrder.getCurrent())[1];
					vFigEle2 = getFightElement(((int[])iniOrder.getCurrent())[0]);
					if (vFigEle2 != null) {
						vIniBasis2 = vFigEle2.getCharacter().getFightValue(0);
						if(vIni2 > vIni) {
							vCur = (int[])iniOrder.getCurrent();
							iniOrder.remove();
							if (!iniOrder.isLast()) iniOrder.prior();
							try { recElementUpdateIniOrder(vCur, vIni2, vIniBasis2); }
							catch(Exception ex) {throw ex;}
							iniOrder.prior();
							vIni2 = vIni;
							vIniBasis2 = vIniBasis;
						} else if ((vIni2 == vIni) && (vIniBasis2 > vIniBasis)) {
							vCur = (int[])iniOrder.getCurrent();
							iniOrder.remove();
							if (!iniOrder.isLast())iniOrder.prior();
							try { recElementUpdateIniOrder(vCur, vIni2, vIniBasis2); }
							catch(Exception ex) {throw ex;}
							iniOrder.prior();
							vIni2 = vIni;
							vIniBasis2 = vIniBasis;
						}
						
						vIni = vIni2;
						vIniBasis = vIniBasis2;
						
						iniOrder.next();
					} else throw new Exception("04; FiMan,uIO");
				}
			} else throw new Exception("04; FiMan,uIO");
		} else throw new Exception("05; FiMan,uIO");
	}
}
