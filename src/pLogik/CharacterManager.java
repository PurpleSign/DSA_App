/**	DSA_App v0.0	Dh	18.6.2020
 * 
 * 	Logik
 * 	  CharacterManager
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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import pDataStructures.List;
import pGUI.MainFrame;

@XmlRootElement(name = "charactermanager")
@XmlSeeAlso(Charakter.class)
public class CharacterManager {
	private int ID;
	private List CharacterList;
	
	/**	Dh	18.6.2020
	 * 
	 * 	Konstruktor nach Bean-Standart
	 */
	public CharacterManager() {
		ID = -1;
		CharacterList = new List();
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 */
	public CharacterManager(int pID) {
		Exception vExc = null;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; ChMan_a");
		
		CharacterList = new List();
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @param pCharacterList
	 */
	public CharacterManager(int pID, List pCharacterList) {
		Exception vExc = null;
		
		if (pID >= 0) ID = pID;
		else vExc = new Exception("02; ChMan_b");
		
		if (pCharacterList != null) CharacterList = pCharacterList;
		else vExc = new Exception("04; ChMan_b");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}

//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	18.6.2020
	 * 	
	 * @return
	 */
	@XmlAttribute
	public int getID() {
		return ID;
	}
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "CharacterList")
	public List getCharacterList() {
		return CharacterList;
	}
	
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public Charakter getCharacter(int pID) throws Exception{
		Charakter vRet = null;
		
		if (pID >= 0) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == null)) {
					vRet = (Charakter)CharacterList.getCurrent();
					
					if (vRet.getID() == pID) CharacterList.toLast();
					else vRet = null;
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pName
	 * @return
	 * @throws Exception
	 */
	public Charakter getCharacter(String pName) throws Exception{
		Charakter vRet = null;
		
		if (!pName.equals("")) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == null)) {
					vRet = (Charakter)CharacterList.getCurrent();
					
					if (vRet.getName().equals(pName)) CharacterList.toLast();
					else vRet = null;
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gC");
		
		return vRet;
	}
	
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public String getNameOfCharacter(int pID) throws Exception{
		String vRet = "";
		Charakter vCur;
		
		if (pID >= 0) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == "")) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getName();
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gNoC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public String getRaceOfCharacter(int pID) throws Exception{
		String vRet = "";
		Charakter vCur;
		
		if (pID >= 0) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == "")) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getRace();
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gRoC");
		
		return vRet;
	}
	//-----
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getNameOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getNameOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gNoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gNoCs");
		} else throw new Exception("04; ChMan,gNoCs");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getRaceOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getRaceOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gRoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gRoCs");
		} else throw new Exception("04; ChMan,gRoCs");
		
		return vRet;
	}
	//-----
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public List getNameOfAllCharacters() {
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getName());
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public List getRaceOfAllCharacters() {
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getRace());
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int getSocialStatusOfCharacter(int pID) throws Exception{
		int vRet = -1;
		Charakter vCur;
		
		if (pID >= 0) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getSO();
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gSSoC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int getVelocityOfCharacter(int pID) throws Exception{
		int vRet = -1;
		Charakter vCur;
		
		if (pID >= 0) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getGS();
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gVoC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int getMundanTypeOfCharacter(int pID) throws Exception{
		int vRet = -1;
		Charakter vCur;
		
		if (pID >= 0) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getMundType();
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gMToC");
		
		return vRet;
	}
	//-----
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getSocialStatusOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getSocialStatusOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gSSoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gSSoCs");
		} else throw new Exception("04; ChMan,gSSoCs");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getVelocityOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getVelocityOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gVoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gVoCs");
		} else throw new Exception("04; ChMan,gVoCs");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getMundanTypeOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getMundanTypeOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gMToCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gMToCs");
		} else throw new Exception("04; ChMan,gMToCs");
		
		return vRet;
	}
	//-----
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public List getSocialStatusOfAllCharacters() {
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getSO());
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public List getVelocityOfAllCharacters() {
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getGS());
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public List getMundanTypeOfAllCharaters() {
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getMundType());
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public double getMagicResistanceOfCharacter(int pID) throws Exception{
		double vRet = -1;
		Charakter vCur;
		
		if (pID >= 0) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getMR();
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gMRoC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public double getWoundThresholdOfCharacter(int pID) throws Exception{
		double vRet = -1;
		Charakter vCur;
		
		if (pID >= 0) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getWS();
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gWToC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public double getHandicapOfCharacter(int pID) throws Exception{
		double vRet = -1;
		Charakter vCur;
		
		if (pID >= 0) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getBE();
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gHoC");
		
		return vRet;
	}
	//-----
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getMagicResistanceOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getMagicResistanceOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gMRoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gMRoCs");
		} else throw new Exception("04; ChMan,gMRoCs");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getWoundThresholdOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getWoundThresholdOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gWToCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gWToCs");
		} else throw new Exception("04; ChMan,gWToCs");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Excpetion
	 */
	public List getHandicapOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getHandicapOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gHoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gHoCs");
		} else throw new Exception("04; ChMan,gHoCs");
		
		return vRet;
	}
	//-----
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	public List getMagicResistanceOfAllCharacters() {
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getMR());
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	public List getWoundThresholdOfAllCharacters() {
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getWS());
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	public List getHandicapOfAllCharacters() {
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getBE());
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getPropertyOfCharacter(int pID, int pInd) throws Exception{
		int vRet = -1;
		Charakter vCur;
		
		if ((pID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getPropertie(pInd);
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gPoC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getMaxStatOfCharacter(int pID, int pInd) throws Exception{
		int vRet = -1;
		Charakter vCur;
		
		if ((pID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getMaxStat(pInd);
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gMSoC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getStatOfCharacter(int pID, int pInd) throws Exception{
		int vRet = -1;
		Charakter vCur;
		
		if ((pID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getStat(pInd);
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gSoC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public int getWoundNumberOfCharacter(int pID, int pInd) throws Exception{
		int vRet = -1;
		Charakter vCur;
		
		if ((pID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getWound(pInd);
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gWNoC");
		
		return vRet;
	}
	//-----
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getPropertyOfCharacters(List pIDList, int pInd) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getPropertyOfCharacter((int)vCur, pInd));
					else throw new Exception("06; ChMan,gPoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gPoCs");
		} else throw new Exception("04; ChMan,gPoCs");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getMaxStatOfCharacters(List pIDList, int pInd) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getMaxStatOfCharacter((int)vCur, pInd));
					else throw new Exception("06; ChMan,gMSoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gMSoCs");
		} else throw new Exception("04; ChMan,gMSoCs");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getStatOfCharacters(List pIDList, int pInd) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getStatOfCharacter((int)vCur, pInd));
					else throw new Exception("06; ChMan,gSoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gSoCs");
		} else throw new Exception("04; ChMan,gSoCs");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getWoundNumberOfCharacters(List pIDList, int pInd) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getWoundNumberOfCharacter((int)vCur, pInd));
					else throw new Exception("06; ChMan,gWNoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gWNoCs");
		} else throw new Exception("04; ChMan,gWNoCs");
		
		return vRet;
	}
	//-----
	/**	Dh	18.6.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getPropertyOfAllCharacter(int pInd) throws Exception {
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getPropertie(pInd));
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getMaxStatOfAllCharacter(int pInd) throws Exception{
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getMaxStat(pInd));
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getStatOfAllCharacter(int pInd) throws Exception{
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getStat(pInd));
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getWoundNumberOfAllCharacters(int pInd) throws Exception{
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getWound(pInd));
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int[] getPropertiesOfCharacter(int pID) throws Exception{
		int[] vRet = null;
		Charakter vCur;
		
		if ((pID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getProperties();
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gPsoC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int[] getMaxStatsOfCharacter(int pID) throws Exception{
		int[] vRet = null;
		Charakter vCur;
		
		if ((pID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getMaxStats();
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gMSsoC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int[] getStatsOfCharacter(int pID) throws Exception{
		int[] vRet = null;
		Charakter vCur;
		
		if ((pID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getStats();
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gSsoC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public int[] getWoundNumbersOfCharacter(int pID) throws Exception{
		int[] vRet = null;
		Charakter vCur;
		
		if ((pID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getWounds();
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gWNsoC");
		
		return vRet;
	}
	//-----
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getPropertiesOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getPropertiesOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gPsoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gPsoCs");
		} else throw new Exception("04; ChMan,gPsoCs");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getMaxStatsOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getMaxStatsOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gMSsoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gMSsoCs");
		} else throw new Exception("04; ChMan,gMSsoCs");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getStatsOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getStatsOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gSsoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gSsoCs");
		} else throw new Exception("04; ChMan,gSsoCs");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getWoundNumbersOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getWoundNumbersOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gWNsoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gWNsoCs");
		} else throw new Exception("04; ChMan,gWNsoCs");
		
		return vRet;
	}
	//-----
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public List getPropertiesOfAllCharacter() {
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getProperties());
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public List getMaxStatsOfAllCharacter() {
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getMaxStats());
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public List getStatsOfAllCharacter() {
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getStats());
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public List getWoundNumbersOfAllCharacter() {
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getWounds());
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public double getFightValueOfCharacter(int pID, int pInd) throws Exception{
		double vRet = -1;
		Charakter vCur;
		
		if ((pID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getFightValue(pInd);
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gFVoC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public double getArmorValueOfCharacter(int pID, int pInd) throws Exception{
		double vRet = -1;
		Charakter vCur;
		
		if ((pID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getRS(pInd);
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gAVoC");
		
		return vRet;
	}
	//-----
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getFightValueOfCharacters(List pIDList, int pInd) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getFightValueOfCharacter((int)vCur, pInd));
					else throw new Exception("06; ChMan,gFVoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gFVoCs");
		} else throw new Exception("04; ChMan,gFVoCs");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getArmorValueOfCharacters(List pIDList, int pInd) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getArmorValueOfCharacter((int)vCur, pInd));
					else throw new Exception("06; ChMan,gAVoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gAVoCs");
		} else throw new Exception("04; ChMan,gAVoCs");
		
		return vRet;
	}
	//-----
	/**	Dh	18.6.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getFightValueOfAllCharacter(int pInd) throws Exception{
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getFightValue(pInd));
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public List getArmorValueOfAllCharacter(int pInd) throws Exception{
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getRS(pInd));
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public double[] getFightValuesOfCharacter(int pID) throws Exception{
		double[] vRet = null;
		Charakter vCur;
		
		if ((pID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getFightValues();
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gFVsoC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public double[] getArmorValuesOfCharacter(int pID) throws Exception{
		double[] vRet = null;
		Charakter vCur;
		
		if ((pID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getRS();
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gFVsoC");
		
		return vRet;
	}
	//-----
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getFightValuesOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getFightValuesOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gFVsoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gFVsoCs");
		} else throw new Exception("04; ChMan,gFVsoCs");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getArmorValuesOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getArmorValuesOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gAVsoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gAVsoCs");
		} else throw new Exception("04; ChMan,gAVsoCs");
		
		return vRet;
	}
	//-----
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public List getFightValuesOfAllCharacter() {
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getFightValues());
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public List getArmorValuesOfAllCharacter() {
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getRS());
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	
	/**	Dh	18.6.2020
	 * 
	 * @param pCharID
	 * @param pProID
	 * @return
	 * @throws Exception
	 */
	public Pro getProOfCharacter(int pCharID, int pProID) throws Exception{
		Pro vRet = null;
		Charakter vCur;
		
		if ((pCharID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pCharID) vRet = vCur.getPro(pProID);
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gPoC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pCharID
	 * @param pSpecialCraftID
	 * @return
	 * @throws Exception
	 */
	public SpecialCraft getSpecialCraftOfCharacter(int pCharID, int pSpecialCraftID) throws Exception{
		SpecialCraft vRet = null;
		Charakter vCur;
		
		if ((pCharID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pCharID) vRet = vCur.getSpecialCraft(pSpecialCraftID);
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gSCoC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pCharID
	 * @param pTalentID
	 * @return
	 * @throws Exception
	 */
	public Talent getTalentOfCharacter(int pCharID, int pTalentID) throws Exception{
		Talent vRet = null;
		Charakter vCur;
		
		if ((pCharID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pCharID) vRet = vCur.getTalent(pTalentID);
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gToC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pCharID
	 * @param pWeaponID
	 * @return
	 * @throws Exception
	 */
	public Weapon getWeaponOfCharacter(int pCharID, int pWeaponID) throws Exception{
		Weapon vRet = null;
		Charakter vCur;
		
		if ((pCharID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pCharID) vRet = vCur.getWeapon(pWeaponID);
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gWoC");
		
		return vRet;
	}
	//-----
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @param pProID
	 * @return
	 * @throws Exception
	 */
	public List getProOfCharacters(List pIDList, int pProID) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getProOfCharacter((int)vCur, pProID));
					else throw new Exception("06; ChMan,gPoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gPoCs");
		} else throw new Exception("04; ChMan,gPoCs");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @param pSpecialCraftID
	 * @return
	 * @throws Exception
	 */
	public List getSpecialCraftOfCharacters(List pIDList, int pSpecialCraftID)throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getSpecialCraftOfCharacter((int)vCur, pSpecialCraftID));
					else throw new Exception("06; ChMan,gSCoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gSCoCs");
		} else throw new Exception("04; ChMan,gSCoCs");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @param pTalentID
	 * @return
	 * @throws Exception
	 */
	public List getTalentOfCharacters(List pIDList, int pTalentID) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getTalentOfCharacter((int)vCur, pTalentID));
					else throw new Exception("06; ChMan,gToCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gToCs");
		} else throw new Exception("04; ChMan,gToCs");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @param pWeaponID
	 * @return
	 * @throws Exception
	 */
	public List getWeaponOfCharacters(List pIDList, int pWeaponID) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getWeaponOfCharacter((int)vCur, pWeaponID));
					else throw new Exception("06; ChMan,gWoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gWoCs");
		} else throw new Exception("04; ChMan,gWoCs");
		
		return vRet;
	}
	//-----
	/**	Dh	18.6.2020
	 * 
	 * @param pProID
	 * @return
	 * @throws Exception
	 */
	public List getProOfAllCharacter(int pProID) throws Exception{
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getPro(pProID));
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pSpecialCraftID
	 * @return
	 * @throws Exception
	 */
	public List getSpecialCraftOfAllCharacter(int pSpecialCraftID) throws Exception{
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getSpecialCraft(pSpecialCraftID));
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pTalentID
	 * @return
	 * @throws Exception
	 */
	public List getTalentOfAllCharacter(int pTalentID) throws Exception{
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getTalent(pTalentID));
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pWeaponID
	 * @return
	 * @throws Exception
	 */
	public List getWeaponOfAllCharacter(int pWeaponID) throws Exception{
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getWeapon(pWeaponID));
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public List getProListOfCharacter(int pID) throws Exception{
		List vRet = null;
		Charakter vCur;
		
		if ((pID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getProList();
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gPLoC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public List getSpecialCraftListOfCharacter(int pID) throws Exception{
		List vRet = null;
		Charakter vCur;
		
		if ((pID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getSpecialCraftList();
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gSCLoC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public List getTalentListOfCharacter(int pID) throws Exception{
		List vRet = null;
		Charakter vCur;
		
		if ((pID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getTalentList();
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gTLoC");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public List getWeaponListOfCharacter(int pID) throws Exception{
		List vRet = null;
		Charakter vCur;
		
		if ((pID >= 0)) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) vRet = vCur.getWeaponList();
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gWLoC");
		
		return vRet;
	}
	//-----
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getProListOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getProListOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gPLoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gPLoCs");
		} else throw new Exception("04; ChMan,gPLoCs");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getSpecialCraftOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getSpecialCraftListOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gSCLoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gSCLoCs");
		} else throw new Exception("04; ChMan,gSCLoCs");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getTalentListOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getTalentListOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gTLoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gTLoCs");
		} else throw new Exception("04; ChMan,gTLoCs");
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getWeaponListOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getWeaponListOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gWLoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gWLoCs");
		} else throw new Exception("04; ChMan,gWLoCs");
		
		return vRet;
	}
	//-----
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public List getProListOfAllCharacter() {
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getProList());
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public List getSpecialCraftListOfAllCharacters() {
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getSpecialCraftList());
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public List getTalentListOfAllCharacters() {
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getTalentList());
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public List getWeaponListOfAllCharacter() {
		Charakter vCur;
		List vRet = new List();
		
		if (!CharacterList.isEmpty()) {
			CharacterList.toFirst();
			
			while(!CharacterList.isEnd()) {
				vCur = (Charakter)CharacterList.getCurrent();
				
				vRet.append(vCur.getWeaponList());
				
				CharacterList.next();
			}
		}
		
		return vRet;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void setID(int pID) throws Exception{
		if (pID >= 0) ID = pID;
		else throw new Exception("02; ChMan,sID");
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pCharList
	 * @throws Exception
	 */
	public void setCharacterList(List pCharList) throws Exception{
		Object vCur;
		
		if (pCharList != null) {
			if (!pCharList.isEmpty()) {
				pCharList.toFirst();
				
				while(!pCharList.isEnd()) {
					vCur = pCharList.getCurrent();
					
					if (!(vCur instanceof Charakter)) throw new Exception("06; ChMan,sCL");
					else if (vCur == null) throw new Exception("04; ChMan,sCL");
					
					pCharList.next();
				}
			}
			
			CharacterList = pCharList;
		} else throw new Exception("04; ChMan,aCL");
	}
	
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @param pName
	 * @throws Exception
	 */
	public void setNameOfCharacter(int pID, String pName) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd()) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) {
						vCur.setName(pName);
						CharacterList.toLast();
					}
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sNoC");
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @param pRace
	 * @throws Exception
	 */
	public void setRaceOfCharacter(int pID, String pRace) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd()) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) {
						vCur.setRace(pRace);
						CharacterList.toLast();
					}
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sRoC");
	}
	
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @param pSO
	 * @throws Exception
	 */
	public void setSocialStatusOfCharacter(int pID, int pSO) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!CharacterList.isEmpty()) {
				CharacterList.toFirst();
				
				while(!CharacterList.isEnd()) {
					vCur = (Charakter)CharacterList.getCurrent();
					
					if (vCur.getID() == pID) {
						vCur.setSO(pSO);
						CharacterList.toLast();
					}
					
					CharacterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sSSoC");
	}
	
//--------------------------------------------------------------------------------------------------------
}
