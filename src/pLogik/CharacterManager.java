/**	DSA_App v0.0	Dh	15.7.2020
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
import pDatenbank.Loader;
import pGUI.MainFrame;

@XmlRootElement(name = "charactermanager")
@XmlSeeAlso(Charakter.class)
public class CharacterManager {
	private int id;
	private List characterList;
	
	/**	Dh	18.6.2020
	 * 
	 * 	Konstruktor nach Bean-Standart
	 */
	public CharacterManager() {
		id = -1;
		characterList = new List();
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 */
	public CharacterManager(int pID) {
		Exception vExc = null;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; ChMan_a");
		
		characterList = new List();
		
		if (vExc != null) MainFrame.handleException(vExc);
	}
	/**	Dh	18.6.2020
	 * 
	 * @param pID
	 * @param pCharacterList
	 */
	public CharacterManager(int pID, List pCharacterList) {
		Exception vExc = null;
		
		if (pID >= 0) id = pID;
		else vExc = new Exception("02; ChMan_b");
		
		if (pCharacterList != null) characterList = pCharacterList;
		else vExc = new Exception("04; ChMan_b");
		
		if (vExc != null) MainFrame.handleException(vExc);
	}

//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	18.6.2020
	 * 	
	 * @return
	 */
	@XmlAttribute
	public int getId() {
		return id;
	}
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "CharacterList")
	public List getCharacterList() {
		return characterList;
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == null)) {
					vRet = (Charakter)characterList.getCurrent();
					
					if (vRet.getId() == pID) characterList.toLast();
					else vRet = null;
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == null)) {
					vRet = (Charakter)characterList.getCurrent();
					
					if (vRet.getName().equals(pName)) characterList.toLast();
					else vRet = null;
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == "")) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getName();
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == "")) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getRace();
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gRoC");
		
		return vRet;
	}
	/**	Dh	14.7.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public String getCultureOfCharacter(int pID) throws Exception{
		String vRet = "";
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == "")) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getCulture();
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gCoC");
		
		return vRet;
	}
	/**	Dh	14.7.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public String getProfessionOfCharacter(int pID) throws Exception{
		String vRet = "";
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == "")) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getProfession();
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,gPoC");
		
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
	/**	Dh	14.7.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getCultureOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getCultureOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gCoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gCoCs");
		} else throw new Exception("04; ChMan,gCoCs");
		
		return vRet;
	}
	/**	Dh	14.7.2020
	 * 
	 * @param pIDList
	 * @return
	 * @throws Exception
	 */
	public List getProfessionOfCharacters(List pIDList) throws Exception{
		Object vCur;
		List vRet = new List();
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) vRet.append(getProfessionOfCharacter((int)vCur));
					else throw new Exception("06; ChMan,gPoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,gPoCs");
		} else throw new Exception("04; ChMan,gPoCs");
		
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getName());
				
				characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getRace());
				
				characterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	14.7.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public List getCultureOfAllCharacters() {
		Charakter vCur;
		List vRet = new List();
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getCulture());
				
				characterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	14.7.2020
	 * 
	 * @return
	 */
	public List getProfessionOfAllCharacters() {
		Charakter vCur;
		List vRet = new List();
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getProfession());
				
				characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getSo();
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getGs();
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getMundaneType();
					
					characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getSo());
				
				characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getGs());
				
				characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getMundaneType());
				
				characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getMr();
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getWs();
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getBe();
					
					characterList.next();
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
	@XmlTransient
	public List getMagicResistanceOfAllCharacters() {
		Charakter vCur;
		List vRet = new List();
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getMr());
				
				characterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public List getWoundThresholdOfAllCharacters() {
		Charakter vCur;
		List vRet = new List();
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getWs());
				
				characterList.next();
			}
		}
		
		return vRet;
	}
	/**	Dh	18.6.2020
	 * 
	 * @return
	 */
	@XmlTransient
	public List getHandicapOfAllCharacters() {
		Charakter vCur;
		List vRet = new List();
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getBe());
				
				characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getPropertie(pInd);
					
					characterList.next();
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
	public double getMaxStatOfCharacter(int pID, int pInd) throws Exception{
		double vRet = -1;
		Charakter vCur;
		
		if ((pID >= 0)) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getMaxStat(pInd);
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getStat(pInd);
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getWound(pInd);
					
					characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getPropertie(pInd));
				
				characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getMaxStat(pInd));
				
				characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getStat(pInd));
				
				characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getWound(pInd));
				
				characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getProperties();
					
					characterList.next();
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
	public double[] getMaxStatsOfCharacter(int pID) throws Exception{
		double[] vRet = null;
		Charakter vCur;
		
		if ((pID >= 0)) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getMaxStats();
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getStats();
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getWounds();
					
					characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getProperties());
				
				characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getMaxStats());
				
				characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getStats());
				
				characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getWounds());
				
				characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getFightValue(pInd);
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == -1)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getRs(pInd);
					
					characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getFightValue(pInd));
				
				characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getRs(pInd));
				
				characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getFightValues();
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getRs();
					
					characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getFightValues());
				
				characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getRs());
				
				characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pCharID) vRet = vCur.getPro(pProID);
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pCharID) vRet = vCur.getSpecialCraft(pSpecialCraftID);
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pCharID) vRet = vCur.getTalent(pTalentID);
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pCharID) vRet = vCur.getWeapon(pWeaponID);
					
					characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getPro(pProID));
				
				characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getSpecialCraft(pSpecialCraftID));
				
				characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getTalent(pTalentID));
				
				characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getWeapon(pWeaponID));
				
				characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getProList();
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getSpecialCraftList();
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getTalentList();
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd() && (vRet == null)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) vRet = vCur.getWeaponList();
					
					characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getProList());
				
				characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getSpecialCraftList());
				
				characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getTalentList());
				
				characterList.next();
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
		
		if (!characterList.isEmpty()) {
			characterList.toFirst();
			
			while(!characterList.isEnd()) {
				vCur = (Charakter)characterList.getCurrent();
				
				vRet.append(vCur.getWeaponList());
				
				characterList.next();
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
	public void setId(int pID) throws Exception{
		if (pID >= 0) id = pID;
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
			
			characterList = pCharList;
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setName(pName);
						characterList.toLast();
					}
					
					characterList.next();
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setRace(pRace);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sRoC");
	}
	/**	Dh	14.7.2020
	 * 	
	 * @param pID
	 * @param pCulture
	 * @throws Exception
	 */
	public void setCultureOfCharacter(int pID, String pCulture) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setCulture(pCulture);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sCoC");
	}
	/**	Dh	14.7.2020
	 * 
	 * @param pID
	 * @param pProfession
	 * @throws Exception
	 */
	public void setProfessionOfCharacter(int pID, String pProfession) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setProfession(pProfession);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sPoC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pRace
	 * @throws Exception
	 */
	public void setRaceOfCharacters(List pIDList, String pRace) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) setRaceOfCharacter((int)vCurID, pRace);
					else throw new Exception("06; ChMan,sRoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,sRoCs");
		} else throw new Exception("04; ChMan,sRoCs");
	}
	/**	Dh	14.7.2020
	 * 
	 * @param pIDList
	 * @param pCulture
	 * @throws Exception
	 */
	public void setCultureOfCharacters(List pIDList, String pCulture) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) setCultureOfCharacter((int)vCurID, pCulture);
					else throw new Exception("06; ChMan,sCoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,sCoCs");
		} else throw new Exception("04; ChMan,sCoCs");
	}
	/**	Dh	14.7.2020
	 * 
	 * @param pIDList
	 * @param pProfession
	 * @throws Exception
	 */
	public void setProfessionOfCharacters(List pIDList, String pProfession) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) setProfessionOfCharacter((int)vCurID, pProfession);
					else throw new Exception("06; ChMan,sPoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,sPoCs");
		} else throw new Exception("04; ChMan,sPoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pNameList
	 * @throws Exception
	 */
	public void setNamesOfCharacters(List pIDList, List pNameList) throws Exception{
		Object vCurID, vCurName;
		
		if ((pIDList != null) && (pNameList != null)) {
			if (!pIDList.isEmpty() && !pNameList.isEmpty()) {
				if (pIDList.getContentNumber() == pNameList.getContentNumber()) {
					pIDList.toFirst();
					pNameList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurName = pNameList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurName instanceof String)) setNameOfCharacter((int)vCurID, (String)vCurName);
						else throw new Exception("06; ChMan,sNsoCs");
						
						pIDList.next();
						pNameList.next();
					}
				} else throw new Exception("01; ChMan,sNsoCs");
			} else throw new Exception("05; ChMan,sNsoCs");
		} else throw new Exception("04; ChMan,sNsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pRaceList
	 * @throws Exception
	 */
	public void setRacesOfCharacters(List pIDList, List pRaceList) throws Exception{
		Object vCurID, vCurRace;
		
		if ((pIDList != null) && (pRaceList != null)) {
			if (!pIDList.isEmpty() && !pRaceList.isEmpty()) {
				if (pIDList.getContentNumber() == pRaceList.getContentNumber()) {
					pIDList.toFirst();
					pRaceList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurRace = pRaceList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurRace instanceof String)) setRaceOfCharacter((int)vCurID, (String)vCurRace);
						else throw new Exception("06; ChMan,sRsoCs");
						
						pIDList.next();
						pRaceList.next();
					}
				} else throw new Exception("01; ChMan,sRsoCs");
			} else throw new Exception("05; ChMan,sRsoCs");
		} else throw new Exception("04; ChMan,sRsoCs");
	}
	/**	Dh	14.7.2020
	 * 
	 * @param pIDList
	 * @param pCultureList
	 * @throws Exception
	 */
	public void setCulturesOfCharacters(List pIDList, List pCultureList) throws Exception{
		Object vCurID, vCurCulture;
		
		if ((pIDList != null) && (pCultureList != null)) {
			if (!pIDList.isEmpty() && !pCultureList.isEmpty()) {
				if (pIDList.getContentNumber() == pCultureList.getContentNumber()) {
					pIDList.toFirst();
					pCultureList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurCulture = pCultureList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurCulture instanceof String)) setCultureOfCharacter((int)vCurID, (String)vCurCulture);
						else throw new Exception("06; ChMan,sCsoCs");
						
						pIDList.next();
						pCultureList.next();
					}
				} else throw new Exception("01; ChMan,sCsoCs");
			} else throw new Exception("05; ChMan,sCsoCs");
		} else throw new Exception("04; ChMan,sCsoCs");
	}
	/**	Dh	14.7.2020
	 * 
	 * @param pIDList
	 * @param pProfessionList
	 * @throws Exception
	 */
	public void setProfessionsOfCharacters(List pIDList, List pProfessionList) throws Exception{
		Object vCurID, vCurProfession;
		
		if ((pIDList != null) && (pProfessionList != null)) {
			if (!pIDList.isEmpty() && !pProfessionList.isEmpty()) {
				if (pIDList.getContentNumber() == pProfessionList.getContentNumber()) {
					pIDList.toFirst();
					pProfessionList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurProfession = pProfessionList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurProfession instanceof String)) setProfessionOfCharacter((int)vCurID, (String)vCurProfession);
						else throw new Exception("06; ChMan,sPsoCs");
						
						pIDList.next();
						pProfessionList.next();
					}
				} else throw new Exception("01; ChMan,sPsoCs");
			} else throw new Exception("05; ChMan,sPsoCs");
		} else throw new Exception("04; ChMan,sPsoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pNameList
	 * @throws Exception
	 */
	public void setNamesOfAllCharacters(List pNameList) throws Exception{
		Object vCurName;
		int vCurID;
		
		if (pNameList != null) {
			if (!characterList.isEmpty() && !pNameList.isEmpty()) {
				if (characterList.getContentNumber() == pNameList.getContentNumber()) {
					characterList.toFirst();
					pNameList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurName = pNameList.getCurrent();
						
						if (vCurName instanceof String) setNameOfCharacter(vCurID, (String)vCurName);
						else throw new Exception("06; ChMan,sNsoaCs");
						
						characterList.next();
						pNameList.next();
					}
				} else throw new Exception("01; ChMan,sNsoaCs");
			} else throw new Exception("05; ChMan,sNsoaCs");
		} else throw new Exception("04; ChMan,sNsoaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pRaceList
	 * @throws Exception
	 */
	public void setRacesOfAllCharacters(List pRaceList) throws Exception{
		Object vCurRace;
		int vCurID;
		
		if (pRaceList != null) {
			if (!characterList.isEmpty() && !pRaceList.isEmpty()) {
				if (characterList.getContentNumber() == pRaceList.getContentNumber()) {
					characterList.toFirst();
					pRaceList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurRace = pRaceList.getCurrent();
						
						if (vCurRace instanceof String) setRaceOfCharacter(vCurID, (String)vCurRace);
						else throw new Exception("06; ChMan,sRsoaCs");
						
						characterList.next();
						pRaceList.next();
					}
				} else throw new Exception("01; ChMan,sRsoaCs");
			} else throw new Exception("05; ChMan,sRsoaCs");
		} else throw new Exception("04; ChMan,sRsoaCs");
	}
	/**	Dh	14.7.2020
	 * 
	 * @param pCultureList
	 * @throws Exception
	 */
	public void setCulturesOfAllCharacters(List pCultureList) throws Exception{
		Object vCurCulture;
		int vCurID;
		
		if (pCultureList != null) {
			if (!characterList.isEmpty() && !pCultureList.isEmpty()) {
				if (characterList.getContentNumber() == pCultureList.getContentNumber()) {
					characterList.toFirst();
					pCultureList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurCulture = pCultureList.getCurrent();
						
						if (vCurCulture instanceof String) setCultureOfCharacter(vCurID, (String)vCurCulture);
						else throw new Exception("06; ChMan,sCsoaCs");
						
						characterList.next();
						pCultureList.next();
					}
				} else throw new Exception("01; ChMan,sCsoaCs");
			} else throw new Exception("05; ChMan,sCsoaCs");
		} else throw new Exception("04; ChMan,sCsoaCs");
	}
	/**	Dh	14.7.2020
	 * 
	 * @param pProfessionList
	 * @throws Exception
	 */
	public void setProfessionsOfAllCharacters(List pProfessionList) throws Exception{
		Object vCurProfession;
		int vCurID;
		
		if (pProfessionList != null) {
			if (!characterList.isEmpty() && !pProfessionList.isEmpty()) {
				if (characterList.getContentNumber() == pProfessionList.getContentNumber()) {
					characterList.toFirst();
					pProfessionList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurProfession = pProfessionList.getCurrent();
						
						if (vCurProfession instanceof String) setProfessionOfCharacter(vCurID, (String)vCurProfession);
						else throw new Exception("06; ChMan,sPsoaCs");
						
						characterList.next();
						pProfessionList.next();
					}
				} else throw new Exception("01; ChMan,sPsoaCs");
			} else throw new Exception("05; ChMan,sPsoaCs");
		} else throw new Exception("04; ChMan,sPsoaCs");
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
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setSo(pSO);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sSSoC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pGS
	 * @throws Exception
	 */
	public void setVelocityOfCharacter(int pID, int pGS) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setGs(pGS);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sGoC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pMundanType
	 * @throws Exception
	 */
	public void setMundanTypeOfCharacter(int pID, int pMundanType) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setMundaneType(pMundanType);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sMToC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pSO
	 * @throws Exception
	 */
	public void setSocialStatusOfCharacters(List pIDList, int pSO) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) setSocialStatusOfCharacter((int)vCurID, pSO);
					else throw new Exception("06; ChMan,sSSoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,sSSoCs");
		} else throw new Exception("04; ChMan,sSSoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pGS
	 * @throws Exception
	 */
	public void setVelocityOfCharacters(List pIDList, int pGS) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) setVelocityOfCharacter((int)vCurID, pGS);
					else throw new Exception("06; ChMan,sVoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,sVoCs");
		} else throw new Exception("04; ChMan,sVoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pMundanType
	 * @throws Exception
	 */
	public void setMundanTypeOfCharacters(List pIDList, int pMundanType) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) setSocialStatusOfCharacter((int)vCurID, pMundanType);
					else throw new Exception("06; ChMan,sMToCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,sMToCs");
		} else throw new Exception("04; ChMan,sMToCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pSOList
	 * @throws Exception
	 */
	public void setSocialStatiOfCharacters(List pIDList, List pSOList) throws Exception{
		Object vCurID, vCurSO;
		
		if ((pIDList != null) && (pSOList != null)) {
			if (!pIDList.isEmpty() && !pSOList.isEmpty()) {
				if (pIDList.getContentNumber() == pSOList.getContentNumber()) {
					pIDList.toFirst();
					pSOList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurSO = pSOList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurSO instanceof Integer)) setSocialStatusOfCharacter((int)vCurID, (int)vCurSO);
						else throw new Exception("06; ChMan,sSSsoCs");
						
						pIDList.next();
						pSOList.next();
					}
				} else throw new Exception("01; ChMan,sSSsoCs");
			} else throw new Exception("05; ChMan,sSSsoCs");
		} else throw new Exception("04; ChMan,sSSsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pGSList
	 * @throws Exception
	 */
	public void setVelocitiesOfCharacters(List pIDList, List pGSList) throws Exception{
		Object vCurID, vCurGS;
		
		if ((pIDList != null) && (pGSList != null)) {
			if (!pIDList.isEmpty() && !pGSList.isEmpty()) {
				if (pIDList.getContentNumber() == pGSList.getContentNumber()) {
					pIDList.toFirst();
					pGSList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurGS = pGSList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurGS instanceof Integer)) setVelocityOfCharacter((int)vCurID, (int)vCurGS);
						else throw new Exception("06; ChMan,sVsoCs");
						
						pIDList.next();
						pGSList.next();
					}
				} else throw new Exception("01; ChMan,sVsoCs");
			} else throw new Exception("05; ChMan,sVsoCs");
		} else throw new Exception("04; ChMan,sVsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pMundanTypeList
	 * @throws Exception
	 */
	public void setMundanTypesOfCharacters(List pIDList, List pMundanTypeList) throws Exception{
		Object vCurID, vCurMundanType;
		
		if ((pIDList != null) && (pMundanTypeList != null)) {
			if (!pIDList.isEmpty() && !pMundanTypeList.isEmpty()) {
				if (pIDList.getContentNumber() == pMundanTypeList.getContentNumber()) {
					pIDList.toFirst();
					pMundanTypeList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurMundanType = pMundanTypeList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurMundanType instanceof Integer)) setMundanTypeOfCharacter((int)vCurID, (int)vCurMundanType);
						else throw new Exception("06; ChMan,sMTsoCs");
						
						pIDList.next();
						pMundanTypeList.next();
					}
				} else throw new Exception("01; ChMan,sMTsoCs");
			} else throw new Exception("05; ChMan,sMTsoCs");
		} else throw new Exception("04; ChMan,sMTsoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pSOList
	 * @throws Exception
	 */
	public void setSocialStatiOfAllCharacters(List pSOList) throws Exception{
		Object vCurSO;
		int vCurID;
		
		if (pSOList != null) {
			if (!characterList.isEmpty() && !pSOList.isEmpty()) {
				if (characterList.getContentNumber() == pSOList.getContentNumber()) {
					characterList.toFirst();
					pSOList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurSO = pSOList.getCurrent();
						
						if (vCurSO instanceof Integer) setSocialStatusOfCharacter(vCurID, (int)vCurSO);
						else throw new Exception("06; ChMan,sSSsoaCs");
						
						characterList.next();
						pSOList.next();
					}
				} else throw new Exception("01; ChMan,sSSsoaCs");
			} else throw new Exception("05; ChMan,sSSsoaCs");
		} else throw new Exception("04; ChMan,sSSsoaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pGSList
	 * @throws Exception
	 */
	public void setVelocitiesOfAllCharacters(List pGSList) throws Exception{
		Object vCurGS;
		int vCurID;
		
		if (pGSList != null) {
			if (!characterList.isEmpty() && !pGSList.isEmpty()) {
				if (characterList.getContentNumber() == pGSList.getContentNumber()) {
					characterList.toFirst();
					pGSList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurGS = pGSList.getCurrent();
						
						if (vCurGS instanceof Integer) setVelocityOfCharacter(vCurID, (int)vCurGS);
						else throw new Exception("06; ChMan,sVsoaCs");
						
						characterList.next();
						pGSList.next();
					}
				} else throw new Exception("01; ChMan,sVsoaCs");
			} else throw new Exception("05; ChMan,sVsoaCs");
		} else throw new Exception("04; ChMan,sVsoaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pMundanTypeList
	 * @throws Exception
	 */
	public void setMundanTypesOfAllCharacters(List pMundanTypeList) throws Exception{
		Object vCurMundanType;
		int vCurID;
		
		if (pMundanTypeList != null) {
			if (!characterList.isEmpty() && !pMundanTypeList.isEmpty()) {
				if (characterList.getContentNumber() == pMundanTypeList.getContentNumber()) {
					characterList.toFirst();
					pMundanTypeList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurMundanType = pMundanTypeList.getCurrent();
						
						if (vCurMundanType instanceof Integer) setSocialStatusOfCharacter(vCurID, (int)vCurMundanType);
						else throw new Exception("06; ChMan,sMTsoaCs");
						
						characterList.next();
						pMundanTypeList.next();
					}
				} else throw new Exception("01; ChMan,sMTsoaCs");
			} else throw new Exception("05; ChMan,sMTsoaCs");
		} else throw new Exception("04; ChMan,sMTsoaCs");
	}
	
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pMR
	 * @throws Exception
	 */
	public void setMagicResistanceOfCharacter(int pID, double pMR) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setMr(pMR);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sMRoC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pWS
	 * @throws Exception
	 */
	public void setWoundThresholdOfCharacter(int pID, double pWS) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setWs(pWS);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sWToC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pBE
	 * @throws Exception
	 */
	public void setHandicapOfCharacter(int pID, double pBE) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setBe(pBE);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sBEoC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 	
	 * @param pIDList
	 * @param pMR
	 * @throws Exception
	 */
	public void setMagicResistanceOfCharacters(List pIDList, int pMR) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) setMagicResistanceOfCharacter((int)vCurID, pMR);
					else throw new Exception("06; ChMan,sMRoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,sMRoCs");
		} else throw new Exception("04; ChMan,sMRoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pWS
	 * @throws Exception
	 */
	public void setWoundThresholdOfCharacters(List pIDList, int pWS) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) setWoundThresholdOfCharacter((int)vCurID, pWS);
					else throw new Exception("06; ChMan,sWToCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,sWToCs");
		} else throw new Exception("04; ChMan,sWToCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pBE
	 * @throws Exception
	 */
	public void setHandicapOfCharacters(List pIDList, int pBE) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) setHandicapOfCharacter((int)vCurID, pBE);
					else throw new Exception("06; ChMan,sHoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,sHoCs");
		} else throw new Exception("04; ChMan,sHoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pMRList
	 * @throws Exception
	 */
	public void setMagicResistancesOfCharacters(List pIDList, List pMRList) throws Exception{
		Object vCurID, vCurMR;
		
		if ((pIDList != null) && (pMRList != null)) {
			if (!pIDList.isEmpty() && !pMRList.isEmpty()) {
				if (pIDList.getContentNumber() == pMRList.getContentNumber()) {
					pIDList.toFirst();
					pMRList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurMR = pMRList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurMR instanceof Double)) setMagicResistanceOfCharacter((int)vCurID, (double)vCurMR);
						else throw new Exception("06; ChMan,sMRsoCs");
						
						pIDList.next();
						pMRList.next();
					}
				} else throw new Exception("01; ChMan,sMRsoCs");
			} else throw new Exception("05; ChMan,sMRsoCs");
		} else throw new Exception("04; ChMan,sMRsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pWSList
	 * @throws Exception
	 */
	public void setWoundThresholdsOfCharacters(List pIDList, List pWSList) throws Exception{
		Object vCurID, vCurWS;
		
		if ((pIDList != null) && (pWSList != null)) {
			if (!pIDList.isEmpty() && !pWSList.isEmpty()) {
				if (pIDList.getContentNumber() == pWSList.getContentNumber()) {
					pIDList.toFirst();
					pWSList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurWS = pWSList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurWS instanceof Double)) setWoundThresholdOfCharacter((int)vCurID, (double)vCurWS);
						else throw new Exception("06; ChMan,sWTsoCs");
						
						pIDList.next();
						pWSList.next();
					}
				} else throw new Exception("01; ChMan,sWTsoCs");
			} else throw new Exception("05; ChMan,sWTsoCs");
		} else throw new Exception("04; ChMan,sWTsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pBEList
	 * @throws Exception
	 */
	public void setHandicapsOfCharacters(List pIDList, List pBEList) throws Exception{
		Object vCurID, vCurBE;
		
		if ((pIDList != null) && (pBEList != null)) {
			if (!pIDList.isEmpty() && !pBEList.isEmpty()) {
				if (pIDList.getContentNumber() == pBEList.getContentNumber()) {
					pIDList.toFirst();
					pBEList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurBE = pBEList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurBE instanceof Double)) setHandicapOfCharacter((int)vCurID, (double)vCurBE);
						else throw new Exception("06; ChMan,sHsoCs");
						
						pIDList.next();
						pBEList.next();
					}
				} else throw new Exception("01; ChMan,sHsoCs");
			} else throw new Exception("05; ChMan,sHsoCs");
		} else throw new Exception("04; ChMan,sHsoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pMRList
	 * @throws Exception
	 */
	public void setMagicResistancesOfAllCharacters(List pMRList) throws Exception{
		Object vCurMR;
		int vCurID;
		
		if (pMRList != null) {
			if (!characterList.isEmpty() && !pMRList.isEmpty()) {
				if (characterList.getContentNumber() == pMRList.getContentNumber()) {
					characterList.toFirst();
					pMRList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurMR = pMRList.getCurrent();
						
						if (vCurMR instanceof Double) setMagicResistanceOfCharacter(vCurID, (double)vCurMR);
						else throw new Exception("06; ChMan,sMRsoaCs");
						
						characterList.next();
						pMRList.next();
					}
				} else throw new Exception("01; ChMan,sMRsoaCs");
			} else throw new Exception("05; ChMan,sMRsoaCs");
		} else throw new Exception("04; ChMan,sMRsoaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pWSList
	 * @throws Exception
	 */
	public void setWoundThresholdsOfAllCharacters(List pWSList) throws Exception{
		Object vCurWS;
		int vCurID;
		
		if (pWSList != null) {
			if (!characterList.isEmpty() && !pWSList.isEmpty()) {
				if (characterList.getContentNumber() == pWSList.getContentNumber()) {
					characterList.toFirst();
					pWSList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurWS = pWSList.getCurrent();
						
						if (vCurWS instanceof Double) setWoundThresholdOfCharacter(vCurID, (double)vCurWS);
						else throw new Exception("06; ChMan,sWTsoaCs");
						
						characterList.next();
						pWSList.next();
					}
				} else throw new Exception("01; ChMan,sWTsoaCs");
			} else throw new Exception("05; ChMan,sWTsoaCs");
		} else throw new Exception("04; ChMan,sWTsoaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pBEList
	 * @throws Exception
	 */
	public void setHandicapsOfAllCharacters(List pBEList) throws Exception{
		Object vCurBE;
		int vCurID;
		
		if (pBEList != null) {
			if (!characterList.isEmpty() && !pBEList.isEmpty()) {
				if (characterList.getContentNumber() == pBEList.getContentNumber()) {
					characterList.toFirst();
					pBEList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurBE = pBEList.getCurrent();
						
						if (vCurBE instanceof Double) setHandicapOfCharacter(vCurID, (double)vCurBE);
						else throw new Exception("06; ChMan,sHsoaCs");
						
						characterList.next();
						pBEList.next();
					}
				} else throw new Exception("01; ChMan,sHsoaCs");
			} else throw new Exception("05; ChMan,sHsoaCs");
		} else throw new Exception("04; ChMan,sHsoaCs");
	}
	
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pProperty
	 * @param pInd
	 * @throws Exception
	 */
	public void setPropertyOfCharacter(int pID, int pProperty, int pInd) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.setPropertie(pProperty, pInd);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("02; ChMan,sPoC");
		} else throw new Exception("02; ChMan,sPoC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pMaxStatus
	 * @param pInd
	 * @throws Exception
	 */
	public void setMaxStatusOfCharacter(int pID, double pMaxStatus, int pInd) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.setMaxStat(pMaxStatus, pInd);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("02; ChMan,sMSoC");
		} else throw new Exception("02; ChMan,sMSoC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pStatus
	 * @param pInd
	 * @throws Exception
	 */
	public void setStatusOfCharacter(int pID, int pStatus, int pInd) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.setStat(pStatus, pInd);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("02; ChMan,sSoC");
		} else throw new Exception("02; ChMan,sSoC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pWoundNumber
	 * @param pInd
	 * @throws Exception
	 */
	public void setWoundNumberOfCharacter(int pID, int pWoundNumber, int pInd) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.setWound(pWoundNumber, pInd);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("02; ChMan,sWNoC");
		} else throw new Exception("02; ChMan,sWNoC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pProperty
	 * @param pInd
	 * @throws Exception
	 */
	public void setPropertyOfCharacters(List pIDList, int pProperty, int pInd) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!pIDList.isEmpty()) {
					pIDList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						
						if (vCurID instanceof Integer) setPropertyOfCharacter((int)vCurID, pProperty, pInd);
						else throw new Exception("06; ChMan,sPoCs");
						
						pIDList.next();
					}
				} else throw new Exception("05; ChMan,sPoCs");
			} else throw new Exception("02; ChMan,sPoC");
		} else throw new Exception("04; ChMan,sPoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pMaxStatus
	 * @param pInd
	 * @throws Exception
	 */
	public void setMaxStatusOfCharacters(List pIDList, double pMaxStatus, int pInd) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!pIDList.isEmpty()) {
					pIDList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						
						if (vCurID instanceof Integer) setMaxStatusOfCharacter((int)vCurID, pMaxStatus, pInd);
						else throw new Exception("06; ChMan,sMSoCs");
						
						pIDList.next();
					}
				} else throw new Exception("05; ChMan,sMSoCs");
			} else throw new Exception("02; ChMan,sMSoC");
		} else throw new Exception("04; ChMan,sMSoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pStatus
	 * @param pInd
	 * @throws Exception
	 */
	public void setStatusOfCharacters(List pIDList, int pStatus, int pInd) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!pIDList.isEmpty()) {
					pIDList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						
						if (vCurID instanceof Integer) setStatusOfCharacter((int)vCurID, pStatus, pInd);
						else throw new Exception("06; ChMan,sSoCs");
						
						pIDList.next();
					}
				} else throw new Exception("05; ChMan,sSoCs");
			} else throw new Exception("02; ChMan,sSoC");
		} else throw new Exception("04; ChMan,sSoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pWoundNumber
	 * @param pInd
	 * @throws Exception
	 */
	public void setWoundNumberOfCharacters(List pIDList, int pWoundNumber, int pInd) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!pIDList.isEmpty()) {
					pIDList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						
						if (vCurID instanceof Integer) setWoundNumberOfCharacter((int)vCurID, pWoundNumber, pInd);
						else throw new Exception("06; ChMan,sWNoCs");
						
						pIDList.next();
					}
				} else throw new Exception("05; ChMan,sWNoCs");
			} else throw new Exception("02; ChMan,sWNoC");
		} else throw new Exception("04; ChMan,sWNoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pPropertyList
	 * @param pInd
	 * @throws Exception
	 */
	public void setPropertiesOfCharacters(List pIDList, List pPropertyList, int pInd) throws Exception{
		Object vCurID, vCurProperty;
		
		if ((pIDList != null) && (pPropertyList != null)) {
			if (!pIDList.isEmpty() && !pPropertyList.isEmpty()) {
				if (pIDList.getContentNumber() == pPropertyList.getContentNumber()) {
					pIDList.toFirst();
					pPropertyList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurProperty = pPropertyList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurProperty instanceof Integer)) setPropertyOfCharacter((int)vCurID, (int)vCurProperty, pInd);
						else throw new Exception("06; ChMan,sPsoCs");
						
						pIDList.next();
						pPropertyList.next();
					}
				} else throw new Exception("01; ChMan,sPsoCs");
			} else throw new Exception("05; ChMan,sPsoCs");
		} else throw new Exception("04; ChMan,sPsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pMaxStatusList
	 * @param pInd
	 * @throws Exception
	 */
	public void setMaxStatiOfCharacters(List pIDList, List pMaxStatusList, int pInd) throws Exception{
		Object vCurID, vCurMaxStatus;
		
		if ((pIDList != null) && (pMaxStatusList != null)) {
			if (!pIDList.isEmpty() && !pMaxStatusList.isEmpty()) {
				if (pIDList.getContentNumber() == pMaxStatusList.getContentNumber()) {
					pIDList.toFirst();
					pMaxStatusList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurMaxStatus= pMaxStatusList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurMaxStatus instanceof Double)) setMaxStatusOfCharacter((int)vCurID, (double)vCurMaxStatus, pInd);
						else throw new Exception("06; ChMan,sMSioCs");
						
						pIDList.next();
						pMaxStatusList.next();
					}
				} else throw new Exception("01; ChMan,sMSioCs");
			} else throw new Exception("05; ChMan,sMSioCs");
		} else throw new Exception("04; ChMan,sMSioCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pStatusList
	 * @param pInd
	 * @throws Exception
	 */
	public void setStatiOfCharacters(List pIDList, List pStatusList, int pInd) throws Exception{
		Object vCurID, vCurStatus;
		
		if ((pIDList != null) && (pStatusList != null)) {
			if (!pIDList.isEmpty() && !pStatusList.isEmpty()) {
				if (pIDList.getContentNumber() == pStatusList.getContentNumber()) {
					pIDList.toFirst();
					pStatusList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurStatus= pStatusList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurStatus instanceof Integer)) setStatusOfCharacter((int)vCurID, (int)vCurStatus, pInd);
						else throw new Exception("06; ChMan,sSioCs");
						
						pIDList.next();
						pStatusList.next();
					}
				} else throw new Exception("01; ChMan,sSioCs");
			} else throw new Exception("05; ChMan,sSioCs");
		} else throw new Exception("04; ChMan,sSioCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pWoundNumberList
	 * @param pInd
	 * @throws Exception
	 */
	public void setWoundNumbersOfCharacters(List pIDList, List pWoundNumberList, int pInd) throws Exception{
		Object vCurID, vCurWoundNumber;
		
		if ((pIDList != null) && (pWoundNumberList != null)) {
			if (!pIDList.isEmpty() && !pWoundNumberList.isEmpty()) {
				if (pIDList.getContentNumber() == pWoundNumberList.getContentNumber()) {
					pIDList.toFirst();
					pWoundNumberList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurWoundNumber = pWoundNumberList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurWoundNumber instanceof Integer)) setWoundNumberOfCharacter((int)vCurID, (int)vCurWoundNumber, pInd);
						else throw new Exception("06; ChMan,sWNsoCs");
						
						pIDList.next();
						pWoundNumberList.next();
					}
				} else throw new Exception("01; ChMan,sWNsoCs");
			} else throw new Exception("05; ChMan,sWNsoCs");
		} else throw new Exception("04; ChMan,sWNsoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pPropertyList
	 * @param pInd
	 * @throws Exception
	 */
	public void setPropertiesOfAllCharacters(List pPropertyList, int pInd) throws Exception{
		Object vCurProperty;
		int vCurID;
		
		if (pPropertyList != null) {
			if (!characterList.isEmpty() && !pPropertyList.isEmpty()) {
				if (characterList.getContentNumber() == pPropertyList.getContentNumber()) {
					characterList.toFirst();
					pPropertyList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurProperty = pPropertyList.getCurrent();
						
						if (vCurProperty instanceof Integer) setPropertyOfCharacter(vCurID, (int)vCurProperty, pInd);
						else throw new Exception("06; ChMan,sPsoaCs");
						
						characterList.next();
						pPropertyList.next();
					}
				} else throw new Exception("01; ChMan,sPsoaCs");
			} else throw new Exception("05; ChMan,sPsoaCs");
		} else throw new Exception("04; ChMan,sPsoaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pMaxStatusList
	 * @param pInd
	 * @throws Exception
	 */
	public void setMaxStatiOfAllCharacters(List pMaxStatusList, int pInd) throws Exception{
		Object vCurMaxStatus;
		int vCurID;
		
		if (pMaxStatusList != null) {
			if (!characterList.isEmpty() && !pMaxStatusList.isEmpty()) {
				if (characterList.getContentNumber() == pMaxStatusList.getContentNumber()) {
					characterList.toFirst();
					pMaxStatusList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurMaxStatus = pMaxStatusList.getCurrent();
						
						if (vCurMaxStatus instanceof Double) setMaxStatusOfCharacter(vCurID, (double)vCurMaxStatus, pInd);
						else throw new Exception("06; ChMan,sMSioaCs");
						
						characterList.next();
						pMaxStatusList.next();
					}
				} else throw new Exception("01; ChMan,sMSioaCs");
			} else throw new Exception("05; ChMan,sMSioaCs");
		} else throw new Exception("04; ChMan,sMSioaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pStatusList
	 * @param pInd
	 * @throws Exception
	 */
	public void setStatiOfAllCharacters(List pStatusList, int pInd) throws Exception{
		Object vCurStatus;
		int vCurID;
		
		if (pStatusList != null) {
			if (!characterList.isEmpty() && !pStatusList.isEmpty()) {
				if (characterList.getContentNumber() == pStatusList.getContentNumber()) {
					characterList.toFirst();
					pStatusList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurStatus = pStatusList.getCurrent();
						
						if (vCurStatus instanceof Integer) setMaxStatusOfCharacter(vCurID, (int)vCurStatus, pInd);
						else throw new Exception("06; ChMan,sSioaCs");
						
						characterList.next();
						pStatusList.next();
					}
				} else throw new Exception("01; ChMan,sSioaCs");
			} else throw new Exception("05; ChMan,sSioaCs");
		} else throw new Exception("04; ChMan,sSioaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pWoundNumberList
	 * @param pInd
	 * @throws Exception
	 */
	public void setWoundNumbersOfAllCharacters(List pWoundNumberList, int pInd) throws Exception{
		Object vCurWoundNumber;
		int vCurID;
		
		if (pWoundNumberList != null) {
			if (!characterList.isEmpty() && !pWoundNumberList.isEmpty()) {
				if (characterList.getContentNumber() == pWoundNumberList.getContentNumber()) {
					characterList.toFirst();
					pWoundNumberList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurWoundNumber = pWoundNumberList.getCurrent();
						
						if (vCurWoundNumber instanceof Integer) setWoundNumberOfCharacter(vCurID, (int)vCurWoundNumber, pInd);
						else throw new Exception("06; ChMan,sWNsoaCs");
						
						characterList.next();
						pWoundNumberList.next();
					}
				} else throw new Exception("01; ChMan,sWNsoaCs");
			} else throw new Exception("05; ChMan,sWNsoaCs");
		} else throw new Exception("04; ChMan,sWNsoaCs");
	}
	
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pProperties
	 * @throws Exception
	 */
	public void setPropertiesOfCharacter(int pID, int[] pProperties) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setProperties(pProperties);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sPsoC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pMaxStati
	 * @throws Exception
	 */
	public void setMaxStatiOfCharacter(int pID, double[] pMaxStati) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setMaxStats(pMaxStati);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sMSioC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pStati
	 * @throws Exception
	 */
	public void setStatiOfCharacter(int pID, int[] pStati) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setStats(pStati);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sSioC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pWoundNumbers
	 * @throws Exception
	 */
	public void setWoundNumbersOfCharacter(int pID, int[] pWoundNumbers) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setWounds(pWoundNumbers);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sWNsoC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pProperties
	 * @throws Exception
	 */
	public void setPropertiesOfCharacters(List pIDList, int[] pProperties) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) setPropertiesOfCharacter((int)vCurID, pProperties);
					else throw new Exception("06; ChMan,sPsoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,sPsoCs");
		} else throw new Exception("04; ChMan,sPsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pMaxStati
	 * @throws Exception
	 */
	public void setMaxStatiOfCharacters(List pIDList, double[] pMaxStati) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) setMaxStatiOfCharacter((int)vCurID, pMaxStati);
					else throw new Exception("06; ChMan,sMSioCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,sMSioCs");
		} else throw new Exception("04; ChMan,sMSioCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pStati
	 * @throws Exception
	 */
	public void setStatiOfCharacters(List pIDList, int[] pStati) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) setStatiOfCharacter((int)vCurID, pStati);
					else throw new Exception("06; ChMan,sSioCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,sSioCs");
		} else throw new Exception("04; ChMan,sSioCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pWoundNumbers
	 * @throws Exception
	 */
	public void setWoundNumbersOfCharacters(List pIDList, int[] pWoundNumbers) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) setWoundNumbersOfCharacter((int)vCurID, pWoundNumbers);
					else throw new Exception("06; ChMan,sWNsoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,sWNsoCs");
		} else throw new Exception("04; ChMan,sWNsoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pPropertiesList
	 * @throws Exception
	 */
	public void setPropertiesOfCharacters(List pIDList, List pPropertiesList) throws Exception{
		Object vCurID, vCurProperties;
		
		if ((pIDList != null) && (pPropertiesList != null)) {
			if (!pIDList.isEmpty() && !pPropertiesList.isEmpty()) {
				if (pIDList.getContentNumber() == pPropertiesList.getContentNumber()) {
					pIDList.toFirst();
					pPropertiesList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurProperties = pPropertiesList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurProperties instanceof Integer[])) setPropertiesOfCharacter((int)vCurID, (int[])vCurProperties);
						else throw new Exception("06; ChMan,sPsoCs");
						
						pIDList.next();
						pPropertiesList.next();
					}
				} else throw new Exception("01; ChMan,sPsoCs");
			} else throw new Exception("05; ChMan,sPsoCs");
		} else throw new Exception("04; ChMan,sPsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pMaxStatiList
	 * @throws Exception
	 */
	public void setMaxStatiOfCharacters(List pIDList, List pMaxStatiList) throws Exception{
		Object vCurID, vCurMaxStati;
		
		if ((pIDList != null) && (pMaxStatiList != null)) {
			if (!pIDList.isEmpty() && !pMaxStatiList.isEmpty()) {
				if (pIDList.getContentNumber() == pMaxStatiList.getContentNumber()) {
					pIDList.toFirst();
					pMaxStatiList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurMaxStati = pMaxStatiList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurMaxStati instanceof Double[])) setMaxStatiOfCharacter((int)vCurID, (double[])vCurMaxStati);
						else throw new Exception("06; ChMan,sMSioCs");
						
						pIDList.next();
						pMaxStatiList.next();
					}
				} else throw new Exception("01; ChMan,sMSioCs");
			} else throw new Exception("05; ChMan,sMSioCs");
		} else throw new Exception("04; ChMan,sMSioCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pStatiList
	 * @throws Exception
	 */
	public void setStatiOfCharacters(List pIDList, List pStatiList) throws Exception{
		Object vCurID, vCurStati;
		
		if ((pIDList != null) && (pStatiList != null)) {
			if (!pIDList.isEmpty() && !pStatiList.isEmpty()) {
				if (pIDList.getContentNumber() == pStatiList.getContentNumber()) {
					pIDList.toFirst();
					pStatiList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurStati = pStatiList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurStati instanceof Integer[])) setStatiOfCharacter((int)vCurID, (int[])vCurStati);
						else throw new Exception("06; ChMan,sSioCs");
						
						pIDList.next();
						pStatiList.next();
					}
				} else throw new Exception("01; ChMan,sSioCs");
			} else throw new Exception("05; ChMan,sSioCs");
		} else throw new Exception("04; ChMan,sSioCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pWoundNumbersList
	 * @throws Exception
	 */
	public void setWoundNumbersOfCharacters(List pIDList, List pWoundNumbersList) throws Exception{
		Object vCurID, vCurWoundNumbers;
		
		if ((pIDList != null) && (pWoundNumbersList != null)) {
			if (!pIDList.isEmpty() && !pWoundNumbersList.isEmpty()) {
				if (pIDList.getContentNumber() == pWoundNumbersList.getContentNumber()) {
					pIDList.toFirst();
					pWoundNumbersList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurWoundNumbers = pWoundNumbersList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurWoundNumbers instanceof Integer[])) setWoundNumbersOfCharacter((int)vCurID, (int[])vCurWoundNumbers);
						else throw new Exception("06; ChMan,sWNsoCs");
						
						pIDList.next();
						pWoundNumbersList.next();
					}
				} else throw new Exception("01; ChMan,sWNsoCs");
			} else throw new Exception("05; ChMan,sWNsoCs");
		} else throw new Exception("04; ChMan,sWNsoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pPropertiesList
	 * @throws Exception
	 */
	public void setPropertiesOfAllCharacters(List pPropertiesList) throws Exception{
		Object vCurProperties;
		int vCurID;
		
		if (pPropertiesList != null) {
			if (!characterList.isEmpty() && !pPropertiesList.isEmpty()) {
				if (characterList.getContentNumber() == pPropertiesList.getContentNumber()) {
					characterList.toFirst();
					pPropertiesList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurProperties = pPropertiesList.getCurrent();
						
						if (vCurProperties instanceof Integer[]) setPropertiesOfCharacter(vCurID, (int[])vCurProperties);
						else throw new Exception("06; ChMan,sPsoaCs");
						
						characterList.next();
						pPropertiesList.next();
					}
				} else throw new Exception("01; ChMan,sPsoaCs");
			} else throw new Exception("05; ChMan,sPsoaCs");
		} else throw new Exception("04; ChMan,sPsoaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pMaxStatiList
	 * @throws Exception
	 */
	public void setMaxStatiOfAllCharacters(List pMaxStatiList) throws Exception{
		Object vCurMaxStati;
		int vCurID;
		
		if (pMaxStatiList != null) {
			if (!characterList.isEmpty() && !pMaxStatiList.isEmpty()) {
				if (characterList.getContentNumber() == pMaxStatiList.getContentNumber()) {
					characterList.toFirst();
					pMaxStatiList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurMaxStati = pMaxStatiList.getCurrent();
						
						if (vCurMaxStati instanceof Double[]) setMaxStatiOfCharacter(vCurID, (double[])vCurMaxStati);
						else throw new Exception("06; ChMan,sMSioaCs");
						
						characterList.next();
						pMaxStatiList.next();
					}
				} else throw new Exception("01; ChMan,sMSioaCs");
			} else throw new Exception("05; ChMan,sMSioaCs");
		} else throw new Exception("04; ChMan,sMSioaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pStatiList
	 * @throws Exception
	 */
	public void setStatiOfAllCharacters(List pStatiList) throws Exception{
		Object vCurStati;
		int vCurID;
		
		if (pStatiList != null) {
			if (!characterList.isEmpty() && !pStatiList.isEmpty()) {
				if (characterList.getContentNumber() == pStatiList.getContentNumber()) {
					characterList.toFirst();
					pStatiList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurStati = pStatiList.getCurrent();
						
						if (vCurStati instanceof Integer[]) setStatiOfCharacter(vCurID, (int[])vCurStati);
						else throw new Exception("06; ChMan,sSioaCs");
						
						characterList.next();
						pStatiList.next();
					}
				} else throw new Exception("01; ChMan,sSioaCs");
			} else throw new Exception("05; ChMan,sSioaCs");
		} else throw new Exception("04; ChMan,sSioaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pWoundNumbersList
	 * @throws Exception
	 */
	public void setWoundNumbersOfAllCharacters(List pWoundNumbersList) throws Exception{
		Object vCurWoundNumbers;
		int vCurID;
		
		if (pWoundNumbersList != null) {
			if (!characterList.isEmpty() && !pWoundNumbersList.isEmpty()) {
				if (characterList.getContentNumber() == pWoundNumbersList.getContentNumber()) {
					characterList.toFirst();
					pWoundNumbersList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurWoundNumbers = pWoundNumbersList.getCurrent();
						
						if (vCurWoundNumbers instanceof Integer[]) setWoundNumbersOfCharacter(vCurID, (int[])vCurWoundNumbers);
						else throw new Exception("06; ChMan,sWNsoaCs");
						
						characterList.next();
						pWoundNumbersList.next();
					}
				} else throw new Exception("01; ChMan,sWNsoaCs");
			} else throw new Exception("05; ChMan,sWNsoaCs");
		} else throw new Exception("04; ChMan,sWNsoaCs");
	}
	
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pFightValue
	 * @param pInd
	 * @throws Exception
	 */
	public void setFightValueOfCharacter(int pID, double pFightValue, int pInd) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.setFightValue(pFightValue, pInd);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("02; ChMan,sFVoC");
		} else throw new Exception("02; ChMan,sFVoC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pArmorValue
	 * @param pInd
	 * @throws Exception
	 */
	public void setArmorValueOfCharacter(int pID, double pArmorValue, int pInd) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if ((pInd >= 0) && (pInd < 9)) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.setRs(pArmorValue, pInd);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("02; ChMan,sAVoC");
		} else throw new Exception("02; ChMan,sAVoC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pFightValue
	 * @param pInd
	 * @throws Exception
	 */
	public void setFightValueOfCharacters(List pIDList, double pFightValue, int pInd) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!pIDList.isEmpty()) {
					pIDList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						
						if (vCurID instanceof Integer) setFightValueOfCharacter((int)vCurID, pFightValue, pInd);
						else throw new Exception("06; ChMan,sFVoCs");
						
						pIDList.next();
					}
				} else throw new Exception("05; ChMan,sFVoCs");
			} else throw new Exception("02; ChMan,sFVoC");
		} else throw new Exception("04; ChMan,sFVoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pArmorValue
	 * @param pInd
	 * @throws Exception
	 */
	public void setArmorValueOfCharacters(List pIDList, double pArmorValue, int pInd) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if ((pInd >= 0) && (pInd < 9)) {
				if (!pIDList.isEmpty()) {
					pIDList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						
						if (vCurID instanceof Integer) setArmorValueOfCharacter((int)vCurID, pArmorValue, pInd);
						else throw new Exception("06; ChMan,sAVoCs");
						
						pIDList.next();
					}
				} else throw new Exception("05; ChMan,sAVoCs");
			} else throw new Exception("02; ChMan,sAVoC");
		} else throw new Exception("04; ChMan,sAVoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pFightValuesList
	 * @param pInd
	 * @throws Exception
	 */
	public void setFightValuesOfCharacters(List pIDList, List pFightValuesList, int pInd) throws Exception{
		Object vCurID, vCurFightValues;
		
		if ((pIDList != null) && (pFightValuesList != null)) {
			if (!pIDList.isEmpty() && !pFightValuesList.isEmpty()) {
				if (pIDList.getContentNumber() == pFightValuesList.getContentNumber()) {
					pIDList.toFirst();
					pFightValuesList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurFightValues = pFightValuesList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurFightValues instanceof Double)) setFightValueOfCharacter((int)vCurID, (double)vCurFightValues, pInd);
						else throw new Exception("06; ChMan,sFVsoCs");
						
						pIDList.next();
						pFightValuesList.next();
					}
				} else throw new Exception("01; ChMan,sFVsoCs");
			} else throw new Exception("05; ChMan,sFVsoCs");
		} else throw new Exception("04; ChMan,sFVsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pArmorValuesList
	 * @param pInd
	 * @throws Exception
	 */
	public void setArmorValuesOfCharacters(List pIDList, List pArmorValuesList, int pInd) throws Exception{
		Object vCurID, vCurArmorValues;
		
		if ((pIDList != null) && (pArmorValuesList != null)) {
			if (!pIDList.isEmpty() && !pArmorValuesList.isEmpty()) {
				if (pIDList.getContentNumber() == pArmorValuesList.getContentNumber()) {
					pIDList.toFirst();
					pArmorValuesList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurArmorValues = pArmorValuesList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurArmorValues instanceof Double)) setArmorValueOfCharacter((int)vCurID, (double)vCurArmorValues, pInd);
						else throw new Exception("06; ChMan,sAVsoCs");
						
						pIDList.next();
						pArmorValuesList.next();
					}
				} else throw new Exception("01; ChMan,sAVsoCs");
			} else throw new Exception("05; ChMan,sAVsoCs");
		} else throw new Exception("04; ChMan,sAVsoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pFightValuesList
	 * @param pInd
	 * @throws Exception
	 */
	public void setFightValuesOfAllCharacters(List pFightValuesList, int pInd) throws Exception{
		Object vCurFightValues;
		int vCurID;
		
		if (pFightValuesList != null) {
			if (!characterList.isEmpty() && !pFightValuesList.isEmpty()) {
				if (characterList.getContentNumber() == pFightValuesList.getContentNumber()) {
					characterList.toFirst();
					pFightValuesList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurFightValues = pFightValuesList.getCurrent();
						
						if (vCurFightValues instanceof Double) setFightValueOfCharacter(vCurID, (double)vCurFightValues, pInd);
						else throw new Exception("06; ChMan,sFVsoaCs");
						
						characterList.next();
						pFightValuesList.next();
					}
				} else throw new Exception("01; ChMan,sFVsoaCs");
			} else throw new Exception("05; ChMan,sFVsoaCs");
		} else throw new Exception("04; ChMan,sFVsoaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pArmorValuesList
	 * @param pInd
	 * @throws Exception
	 */
	public void setArmorValuesOfAllCharacters(List pArmorValuesList, int pInd) throws Exception{
		Object vCurArmorValues;
		int vCurID;
		
		if (pArmorValuesList != null) {
			if (!characterList.isEmpty() && !pArmorValuesList.isEmpty()) {
				if (characterList.getContentNumber() == pArmorValuesList.getContentNumber()) {
					characterList.toFirst();
					pArmorValuesList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurArmorValues = pArmorValuesList.getCurrent();
						
						if (vCurArmorValues instanceof Double) setArmorValueOfCharacter(vCurID, (double)vCurArmorValues, pInd);
						else throw new Exception("06; ChMan,sAVsoaCs");
						
						characterList.next();
						pArmorValuesList.next();
					}
				} else throw new Exception("01; ChMan,sAVsoaCs");
			} else throw new Exception("05; ChMan,sAVsoaCs");
		} else throw new Exception("04; ChMan,sAVsoaCs");
	}
	
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pFightValues
	 * @throws Exception
	 */
	public void setFightValuesOfCharacter(int pID, double[] pFightValues) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setFightValues(pFightValues);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sFVsoC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pArmorValues
	 * @throws Exception
	 */
	public void setArmorValuesOfCharacter(int pID, double[] pArmorValues) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setRs(pArmorValues);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sAVsoC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pFightValues
	 * @throws Exception
	 */
	public void setFightValuesOfCharacters(List pIDList, double[] pFightValues) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) setFightValuesOfCharacter((int)vCurID, pFightValues);
					else throw new Exception("06; ChMan,sFVsoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,sFVsoCs");
		} else throw new Exception("04; ChMan,sFVsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pArmorValues
	 * @throws Exception
	 */
	public void setArmorValuesOfCharacters(List pIDList, double[] pArmorValues) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) setArmorValuesOfCharacter((int)vCurID, pArmorValues);
					else throw new Exception("06; ChMan,sAVsoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,sAVsoCs");
		} else throw new Exception("04; ChMan,sAVsoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pFightValuesList
	 * @throws Exception
	 */
	public void setFightValuesOfCharacters(List pIDList, List pFightValuesList) throws Exception{
		Object vCurID, vCurFightValues;
		
		if ((pIDList != null) && (pFightValuesList != null)) {
			if (!pIDList.isEmpty() && !pFightValuesList.isEmpty()) {
				if (pIDList.getContentNumber() == pFightValuesList.getContentNumber()) {
					pIDList.toFirst();
					pFightValuesList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurFightValues = pFightValuesList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurFightValues instanceof Double[])) setFightValuesOfCharacter((int)vCurID, (double[])vCurFightValues);
						else throw new Exception("06; ChMan,sFVsoCs");
						
						pIDList.next();
						pFightValuesList.next();
					}
				} else throw new Exception("01; ChMan,sFVsoCs");
			} else throw new Exception("05; ChMan,sFVsoCs");
		} else throw new Exception("04; ChMan,sFVsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pArmorValuesList
	 * @throws Exception
	 */
	public void setArmorValuesOfCharacters(List pIDList, List pArmorValuesList) throws Exception{
		Object vCurID, vCurArmorValues;
		
		if ((pIDList != null) && (pArmorValuesList != null)) {
			if (!pIDList.isEmpty() && !pArmorValuesList.isEmpty()) {
				if (pIDList.getContentNumber() == pArmorValuesList.getContentNumber()) {
					pIDList.toFirst();
					pArmorValuesList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurArmorValues = pArmorValuesList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurArmorValues instanceof Double[])) setArmorValuesOfCharacter((int)vCurID, (double[])vCurArmorValues);
						else throw new Exception("06; ChMan,sAVsoCs");
						
						pIDList.next();
						pArmorValuesList.next();
					}
				} else throw new Exception("01; ChMan,sAVsoCs");
			} else throw new Exception("05; ChMan,sAVsoCs");
		} else throw new Exception("04; ChMan,sAVsoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pFightValuesList
	 * @throws Exception
	 */
	public void setFightValuesOfAllCharacters(List pFightValuesList) throws Exception{
		Object vCurFightValues;
		int vCurID;
		
		if (pFightValuesList != null) {
			if (!characterList.isEmpty() && !pFightValuesList.isEmpty()) {
				if (characterList.getContentNumber() == pFightValuesList.getContentNumber()) {
					characterList.toFirst();
					pFightValuesList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurFightValues = pFightValuesList.getCurrent();
						
						if (vCurFightValues instanceof Integer[]) setFightValuesOfCharacter(vCurID, (double[])vCurFightValues);
						else throw new Exception("06; ChMan,sFVsoaCs");
						
						characterList.next();
						pFightValuesList.next();
					}
				} else throw new Exception("01; ChMan,sFVsoaCs");
			} else throw new Exception("05; ChMan,sFVsoaCs");
		} else throw new Exception("04; ChMan,sFVsoaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pArmorValuesList
	 * @throws Exception
	 */
	public void setArmorValuesOfAllCharacters(List pArmorValuesList) throws Exception{
		Object vCurArmorValues;
		int vCurID;
		
		if (pArmorValuesList != null) {
			if (!characterList.isEmpty() && !pArmorValuesList.isEmpty()) {
				if (characterList.getContentNumber() == pArmorValuesList.getContentNumber()) {
					characterList.toFirst();
					pArmorValuesList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurArmorValues = pArmorValuesList.getCurrent();
						
						if (vCurArmorValues instanceof Integer[]) setArmorValuesOfCharacter(vCurID, (double[])vCurArmorValues);
						else throw new Exception("06; ChMan,sAVsoaCs");
						
						characterList.next();
						pArmorValuesList.next();
					}
				} else throw new Exception("01; ChMan,sAVsoaCs");
			} else throw new Exception("05; ChMan,sAVsoaCs");
		} else throw new Exception("04; ChMan,sAVsoaCs");
	}
	
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pProList
	 * @throws Exception
	 */
	public void setProListOfCharacter(int pID, List pProList) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setProList(pProList);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sPLoC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pSpecialCraftList
	 * @throws Exception
	 */
	public void setSpecialCraftListOfCharacter(int pID, List pSpecialCraftList) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setSpecialCraftList(pSpecialCraftList);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sSCLoC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pTalentList
	 * @throws Exception
	 */
	public void setTalentListOfCharacter(int pID, List pTalentList) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setTalentList(pTalentList);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sTLoC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pWeaponList
	 * @throws Exception
	 */
	public void setWeaponListOfCharacter(int pID, List pWeaponList) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.setWeaponList(pWeaponList);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,sWLoC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pProList
	 * @throws Exception
	 */
	public void setProListOfCharacters(List pIDList, List pProList) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) setProListOfCharacter((int)vCurID, pProList);
					else throw new Exception("06; ChMan,sPLoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,sPLoCs");
		} else throw new Exception("04; ChMan,sPLoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pSpecialCraftList
	 * @throws Exception
	 */
	public void setSpecialCraftListOfCharacters(List pIDList, List pSpecialCraftList) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) setSpecialCraftListOfCharacter((int)vCurID, pSpecialCraftList);
					else throw new Exception("06; ChMan,sSCLoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,sSCLoCs");
		} else throw new Exception("04; ChMan,sSCLoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pTalentList
	 * @throws Exception
	 */
	public void setTalentListOfCharacters(List pIDList, List pTalentList) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) setTalentListOfCharacter((int)vCurID, pTalentList);
					else throw new Exception("06; ChMan,sTLoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,sTLoCs");
		} else throw new Exception("04; ChMan,sTLoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pWeaponList
	 * @throws Exception
	 */
	public void setWeaponListOfCharacters(List pIDList, List pWeaponList) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) setWeaponListOfCharacter((int)vCurID, pWeaponList);
					else throw new Exception("06; ChMan,sWLoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,sWLoCs");
		} else throw new Exception("04; ChMan,sWLoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pProLists
	 * @throws Exception
	 */
	public void setProListsOfCharacters(List pIDList, List pProLists) throws Exception{
		Object vCurID, vCurProList;
		
		if ((pIDList != null) && (pProLists != null)) {
			if (!pIDList.isEmpty() && !pProLists.isEmpty()) {
				if (pIDList.getContentNumber() == pProLists.getContentNumber()) {
					pIDList.toFirst();
					pProLists.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurProList = pProLists.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurProList instanceof List)) setProListOfCharacter((int)vCurID, (List)vCurProList);
						else throw new Exception("06; ChMan,sPLsoCs");
						
						pIDList.next();
						pProLists.next();
					}
				} else throw new Exception("01; ChMan,sPLsoCs");
			} else throw new Exception("05; ChMan,sPLsoCs");
		} else throw new Exception("04; ChMan,sPLsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pSpecialCraftLists
	 * @throws Exception
	 */
	public void setSpecialCraftListsOfCharacters(List pIDList, List pSpecialCraftLists) throws Exception{
		Object vCurID, vCurSpecialCraftList;
		
		if ((pIDList != null) && (pSpecialCraftLists != null)) {
			if (!pIDList.isEmpty() && !pSpecialCraftLists.isEmpty()) {
				if (pIDList.getContentNumber() == pSpecialCraftLists.getContentNumber()) {
					pIDList.toFirst();
					pSpecialCraftLists.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurSpecialCraftList = pSpecialCraftLists.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurSpecialCraftList instanceof List)) setSpecialCraftListOfCharacter((int)vCurID, (List)vCurSpecialCraftList);
						else throw new Exception("06; ChMan,sSCLsoCs");
						
						pIDList.next();
						pSpecialCraftLists.next();
					}
				} else throw new Exception("01; ChMan,sSCLsoCs");
			} else throw new Exception("05; ChMan,sSCLsoCs");
		} else throw new Exception("04; ChMan,sSCLsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pTalentLists
	 * @throws Exception
	 */
	public void setTalentListsOfCharacters(List pIDList, List pTalentLists) throws Exception{
		Object vCurID, vCurTalentList;
		
		if ((pIDList != null) && (pTalentLists != null)) {
			if (!pIDList.isEmpty() && !pTalentLists.isEmpty()) {
				if (pIDList.getContentNumber() == pTalentLists.getContentNumber()) {
					pIDList.toFirst();
					pTalentLists.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurTalentList = pTalentLists.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurTalentList instanceof List)) setTalentListOfCharacter((int)vCurID, (List)vCurTalentList);
						else throw new Exception("06; ChMan,sTLsoCs");
						
						pIDList.next();
						pTalentLists.next();
					}
				} else throw new Exception("01; ChMan,sTLsoCs");
			} else throw new Exception("05; ChMan,sTLsoCs");
		} else throw new Exception("04; ChMan,sTLsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pWeaponLists
	 * @throws Exception
	 */
	public void setWeaponListsOfCharacters(List pIDList, List pWeaponLists) throws Exception{
		Object vCurID, vCurWeaponList;
		
		if ((pIDList != null) && (pWeaponLists != null)) {
			if (!pIDList.isEmpty() && !pWeaponLists.isEmpty()) {
				if (pIDList.getContentNumber() == pWeaponLists.getContentNumber()) {
					pIDList.toFirst();
					pWeaponLists.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurWeaponList = pWeaponLists.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurWeaponList instanceof List)) setWeaponListOfCharacter((int)vCurID, (List)vCurWeaponList);
						else throw new Exception("06; ChMan,sWLsoCs");
						
						pIDList.next();
						pWeaponLists.next();
					}
				} else throw new Exception("01; ChMan,sWLsoCs");
			} else throw new Exception("05; ChMan,sWLsoCs");
		} else throw new Exception("04; ChMan,sWLsoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pProLists
	 * @throws Exception
	 */
	public void setProListsOfAllCharacters(List pProLists) throws Exception{
		Object vCurProList;
		int vCurID;
		
		if (pProLists != null) {
			if (!characterList.isEmpty() && !pProLists.isEmpty()) {
				if (characterList.getContentNumber() == pProLists.getContentNumber()) {
					characterList.toFirst();
					pProLists.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurProList = pProLists.getCurrent();
						
						if (vCurProList instanceof List) setProListOfCharacter(vCurID, (List)vCurProList);
						else throw new Exception("06; ChMan,sPLsoaCs");
						
						characterList.next();
						pProLists.next();
					}
				} else throw new Exception("01; ChMan,sPLsoaCs");
			} else throw new Exception("05; ChMan,sPLsoaCs");
		} else throw new Exception("04; ChMan,sPLsoaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pSpecialCraftLists
	 * @throws Exception
	 */
	public void setSpecialCraftListsOfAllCharacters(List pSpecialCraftLists) throws Exception{
		Object vCurSpecialCraftList;
		int vCurID;
		
		if (pSpecialCraftLists != null) {
			if (!characterList.isEmpty() && !pSpecialCraftLists.isEmpty()) {
				if (characterList.getContentNumber() == pSpecialCraftLists.getContentNumber()) {
					characterList.toFirst();
					pSpecialCraftLists.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurSpecialCraftList = pSpecialCraftLists.getCurrent();
						
						if (vCurSpecialCraftList instanceof List) setSpecialCraftListOfCharacter(vCurID, (List)vCurSpecialCraftList);
						else throw new Exception("06; ChMan,sSCLsoaCs");
						
						characterList.next();
						pSpecialCraftLists.next();
					}
				} else throw new Exception("01; ChMan,sSCLsoaCs");
			} else throw new Exception("05; ChMan,sSCLsoaCs");
		} else throw new Exception("04; ChMan,sSCLsoaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pTalentLists
	 * @throws Exception
	 */
	public void setTalentListsOfAllCharacters(List pTalentLists) throws Exception{
		Object vCurTalentList;
		int vCurID;
		
		if (pTalentLists != null) {
			if (!characterList.isEmpty() && !pTalentLists.isEmpty()) {
				if (characterList.getContentNumber() == pTalentLists.getContentNumber()) {
					characterList.toFirst();
					pTalentLists.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurTalentList = pTalentLists.getCurrent();
						
						if (vCurTalentList instanceof List) setTalentListOfCharacter(vCurID, (List)vCurTalentList);
						else throw new Exception("06; ChMan,sTLsoaCs");
						
						characterList.next();
						pTalentLists.next();
					}
				} else throw new Exception("01; ChMan,sTLsoaCs");
			} else throw new Exception("05; ChMan,sTLsoaCs");
		} else throw new Exception("04; ChMan,sTLsoaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pWeaponLists
	 * @throws Exception
	 */
	public void setWeaponListsOfAllCharacters(List pWeaponLists) throws Exception{
		Object vCurWeaponList;
		int vCurID;
		
		if (pWeaponLists != null) {
			if (!characterList.isEmpty() && !pWeaponLists.isEmpty()) {
				if (characterList.getContentNumber() == pWeaponLists.getContentNumber()) {
					characterList.toFirst();
					pWeaponLists.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurWeaponList = pWeaponLists.getCurrent();
						
						if (vCurWeaponList instanceof List) setWeaponListOfCharacter(vCurID, (List)vCurWeaponList);
						else throw new Exception("06; ChMan,sWLsoaCs");
						
						characterList.next();
						pWeaponLists.next();
					}
				} else throw new Exception("01; ChMan,sWLsoaCs");
			} else throw new Exception("05; ChMan,sWLsoaCs");
		} else throw new Exception("04; ChMan,sWLsoaCs");
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	23.6.2020
	 * 
	 * @param pChar
	 * @return
	 * @throws Exception
	 */
	public boolean haveCharacter(Charakter pChar) throws Exception{
		boolean vRet = false;
		Charakter vCur;
		
		if (pChar != null) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while (!characterList.isEnd() && (vRet == false)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.equals(pChar)) vRet = true;
					
					characterList.next();
				}
			}
		} else throw new Exception("04; ChMan,hCh");
		
		return vRet;
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	public boolean haveCharacterID(int pID) throws Exception{
		boolean vRet = false;
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while (!characterList.isEnd() && (vRet == false)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (pID == vCur.getId()) vRet = true;
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,hCh");
		
		return vRet;
	}
	
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pPro
	 * @return
	 * @throws Exception
	 */
	public boolean haveProByCharacter(int pID, Pro pPro) throws Exception{
		boolean vRet = false;
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while (!characterList.isEnd() && (vRet == false)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (pID == vCur.getId()) vRet = vCur.havePro(pPro);
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,hPbC");
		
		return vRet;
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pCharID
	 * @param pProID
	 * @return
	 * @throws Exception
	 */
	public boolean haveProByCharacter(int pCharID, int pProID) throws Exception{
		boolean vRet = false;
		Charakter vCur;
		
		if (pCharID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while (!characterList.isEnd() && (vRet == false)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (pCharID == vCur.getId()) vRet = vCur.havePro(pProID);
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,hPbC");
		
		return vRet;
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pName
	 * @return
	 * @throws Exception
	 */
	public boolean haveProByCharacter(int pID, String pName) throws Exception{
		boolean vRet = false;
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while (!characterList.isEnd() && (vRet == false)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (pID == vCur.getId()) vRet = vCur.havePro(pName);
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,hPbC");
		
		return vRet;
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pSpecialCraft
	 * @return
	 * @throws Exception
	 */
	public boolean haveSpecialCraftByCharacter(int pID, SpecialCraft pSpecialCraft) throws Exception{
		boolean vRet = false;
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while (!characterList.isEnd() && (vRet == false)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (pID == vCur.getId()) vRet = vCur.haveSpecialCraft(pSpecialCraft);
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,hSCbC");
		
		return vRet;
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pCharID
	 * @param pSpecialCraftID
	 * @return
	 * @throws Exception
	 */
	public boolean haveSpecialCraftByCharacter(int pCharID, int pSpecialCraftID) throws Exception{
		boolean vRet = false;
		Charakter vCur;
		
		if (pCharID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while (!characterList.isEnd() && (vRet == false)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (pCharID == vCur.getId()) vRet = vCur.haveSpecialCraft(pSpecialCraftID);
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,hSCbC");
		
		return vRet;
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pName
	 * @return
	 * @throws Exception
	 */
	public boolean haveSpecialCraftByCharacter(int pID, String pName) throws Exception{
		boolean vRet = false;
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while (!characterList.isEnd() && (vRet == false)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (pID == vCur.getId()) vRet = vCur.haveSpecialCraft(pName);
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,hSCbC");
		
		return vRet;
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pTalent
	 * @return
	 * @throws Exception
	 */
	public boolean haveTalentByCharacter(int pID, Talent pTalent) throws Exception{
		boolean vRet = false;
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while (!characterList.isEnd() && (vRet == false)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (pID == vCur.getId()) vRet = vCur.haveTalent(pTalent);
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,hTbC");
		
		return vRet;
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pCharID
	 * @param pTalentID
	 * @return
	 * @throws Exception
	 */
	public boolean haveTalentByCharacter(int pCharID, int pTalentID) throws Exception{
		boolean vRet = false;
		Charakter vCur;
		
		if (pCharID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while (!characterList.isEnd() && (vRet == false)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (pCharID == vCur.getId()) vRet = vCur.haveTalent(pTalentID);
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,hTbC");
		
		return vRet;
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pName
	 * @return
	 * @throws Exception
	 */
	public boolean haveTalentByCharacter(int pID, String pName) throws Exception{
		boolean vRet = false;
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while (!characterList.isEnd() && (vRet == false)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (pID == vCur.getId()) vRet = vCur.haveTalent(pName);
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,hTbC");
		
		return vRet;
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pWeapon
	 * @return
	 * @throws Exception
	 */
	public boolean haveWeaponByCharacter(int pID, Weapon pWeapon) throws Exception{
		boolean vRet = false;
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while (!characterList.isEnd() && (vRet == false)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (pID == vCur.getId()) vRet = vCur.haveWeapon(pWeapon);
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,hWbC");
		
		return vRet;
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pCharID
	 * @param pWeaponID
	 * @return
	 * @throws Exception
	 */
	public boolean haveWeaponByCharacter(int pCharID, int pWeaponID) throws Exception{
		boolean vRet = false;
		Charakter vCur;
		
		if (pCharID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while (!characterList.isEnd() && (vRet == false)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (pCharID == vCur.getId()) vRet = vCur.haveWeapon(pWeaponID);
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,hWbC");
		
		return vRet;
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pName
	 * @return
	 * @throws Exception
	 */
	public boolean haveWeaponByCharacter(int pID, String pName) throws Exception{
		boolean vRet = false;
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while (!characterList.isEnd() && (vRet == false)) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (pID == vCur.getId()) vRet = vCur.haveWeapon(pName);
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,hWbC");
		
		return vRet;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	2.7.2020
	 * 
	 * 	PremiseTypes:
	 * 	  0: Vorteile				4: Talentgruppe
	 * 	  1: Sodnerfertigkeiten		5: Zauber
	 * 	  2: Kampfwert				6: Rituale
	 * 	  3: Talente				7: Litugrien
	 * 
	 * 	Types:
	 * 	  00: Nahkampf				05: Wissens
	 * 	  01: Fernkampf				06: Sprache
	 * 	  02: Koerperliche			07: Handwerks
	 * 	  03: Gesellschaftliche		08: Alle Kampf
	 * 	  04: Natur					09: Alle mundan nicht Kampf
	 * 
	 * @param pCharID
	 * @param pSpecialID
	 * @return
	 * @throws Exception
	 */
	public boolean satisfyPremisesOfCharacter(int pCharID, int pSpecialID) throws Exception{
		boolean vRet = true;
		Object vCur;
		int vCurInt;
		SpecialCraft vSpes;
		int[] vProps, vPremise;
		List vPreList, vCurList;
		Talent vCurTal;
		
		if (haveCharacterID(pCharID) == true) {
			vSpes = Loader.getSpecialCraft(pSpecialID);
			
			if (vSpes != null) {
				vProps = getPropertiesOfCharacter(pCharID);
				vPremise = vSpes.getPropertiePremises();
				vPreList = vSpes.getTypedPremiseList();
				
				if ((vProps != null) && (vPremise != null)) {
					if (vProps.length == vPremise.length) {
						for (int i=0; (i < vProps.length) && (vRet == true); i++) {
							if ((vPremise[i] != -1) && (vProps[i] < vPremise[i])) vRet = false;
						}
					} else throw new Exception("01; ChMan,sPoC");
				} else throw new Exception("04; ChMan,sPoC");
				
				if ((vRet == true) && (!vPreList.isEmpty())) {
					vPreList.toFirst();
					
					while (!vPreList.isEnd() && (vRet == true)) {
						vPremise = (int[]) vPreList.getCurrent();
						
						if (vPremise[0] == 0) {
							if (haveProByCharacter(pCharID, vPremise[1]) == false) vRet = false;
						}else if (vPremise[0] == 1) {
							if (haveSpecialCraftByCharacter(pCharID, vPremise[1]) == false) vRet = false;
						} else if (vPremise[0] == 2) {
							if (getFightValueOfCharacter(pCharID, vPremise[1]) < vPremise[2]) vRet = false; 
						} else if (vPremise[0] == 3) {
							vCur = getTalentOfCharacter(pCharID, vPremise[1]);
							
							if (vCur != null) if (((Talent)vCur).getTaw() < vPremise[2]) vRet = false;
						} else if (vPremise[0] == 4) {
							vCurList = getTalentListOfCharacter(pCharID);
							vRet = false;
							
							if (!vCurList.isEmpty()) {
								if ((vPremise[1] >= 0) && (vPremise[1] < 10)) {
									vCurList.toFirst();
									
									while(!vCurList.isEnd()) {
										vCurTal = (Talent)vCurList.getCurrent();
										vCurInt = vCurTal.getType();
										
										if ((vCurInt == vPremise[1]) || (((vCurInt == 0) || (vCurInt == 1)) && (vPremise[1] == 8)) 
												|| ((vCurInt >= 2) && (vCurInt < 8) && (vPremise[1] == 9))) {
											if (vCurTal.getTaw() >= vPremise[2]) vRet = true;
										}
										
										vCurList.next();
									}
								} else throw new Exception("02; ChMan,sPoC");
							}
						} else if (vPremise[0] == 5) {
							//    Zauber noch implementieren.
							System.out.println("Vorraussetzungen für Zauber prüfen noch implementieren");
						} else if (vPremise[0] == 6) {
//						    Rituale noch implementieren.
							System.out.println("Vorraussetzungen für Ritual prüfen noch implementieren");
						} else if (vPremise[0] == 7) {
//						    Liturgien noch implementieren.
							System.out.println("Vorraussetzungen für Liturgien prüfen noch implementieren");
						} else throw new Exception("07;ChMan,sPoC");
						
						vPreList.next();
					}
				}
			} else throw new Exception("04; ChMan,sPoC");
		} else throw new Exception("02; ChMan,sPoC");
		
		return vRet;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	23.6.2020
	 * 
	 * @param pChar
	 * @throws Exception
	 */
	public void addCharacter(Charakter pChar) throws Exception{
		if (pChar != null) {
			if (haveCharacter(pChar) == false) characterList.append(pChar);
			else throw new Exception("02; ChMan,aCh");
		} else throw new Exception("04; ChMan,aCh");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pCharList
	 * @throws Exception
	 */
	public void addCharacterList(List pCharList) throws Exception{
		Object vChar;
		
		if (pCharList != null) {
			if (!pCharList.isEmpty()) {
				pCharList.toFirst();
				
				while(!pCharList.isEnd()) {
					vChar = pCharList.getCurrent();
					
					if (vChar instanceof Charakter) addCharacter((Charakter)vChar);
					else throw new Exception("06; ChMan,aCL");
					
					pCharList.next();
				}
			} else throw new Exception("05; ChMan,aCL");
		} else throw new Exception("04; ChMan,aCL");
	}
	
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pSO
	 * @throws Exception
	 */
	public void addSocialStatusOfCharacter(int pID, int pSO) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.addSo(pSO);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,aSSoC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pGS
	 * @throws Exception
	 */
	public void addVelocityOfCharacter(int pID, int pGS) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.addGs(pGS);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,aGoC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pSO
	 * @throws Exception
	 */
	public void addSocialStatusOfCharacters(List pIDList, int pSO) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) addSocialStatusOfCharacter((int)vCurID, pSO);
					else throw new Exception("06; ChMan,aSSoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,aSSoCs");
		} else throw new Exception("04; ChMan,aSSoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pGS
	 * @throws Exception
	 */
	public void addVelocityOfCharacters(List pIDList, int pGS) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) addVelocityOfCharacter((int)vCurID, pGS);
					else throw new Exception("06; ChMan,aVoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,aVoCs");
		} else throw new Exception("04; ChMan,aVoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pSOList
	 * @throws Exception
	 */
	public void addSocialStatiOfCharacters(List pIDList, List pSOList) throws Exception{
		Object vCurID, vCurSO;
		
		if ((pIDList != null) && (pSOList != null)) {
			if (!pIDList.isEmpty() && !pSOList.isEmpty()) {
				if (pIDList.getContentNumber() == pSOList.getContentNumber()) {
					pIDList.toFirst();
					pSOList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurSO = pSOList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurSO instanceof Integer)) addSocialStatusOfCharacter((int)vCurID, (int)vCurSO);
						else throw new Exception("06; ChMan,aSSsoCs");
						
						pIDList.next();
						pSOList.next();
					}
				} else throw new Exception("01; ChMan,aSSsoCs");
			} else throw new Exception("05; ChMan,aSSsoCs");
		} else throw new Exception("04; ChMan,aSSsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pGSList
	 * @throws Exception
	 */
	public void addVelocitiesOfCharacters(List pIDList, List pGSList) throws Exception{
		Object vCurID, vCurGS;
		
		if ((pIDList != null) && (pGSList != null)) {
			if (!pIDList.isEmpty() && !pGSList.isEmpty()) {
				if (pIDList.getContentNumber() == pGSList.getContentNumber()) {
					pIDList.toFirst();
					pGSList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurGS = pGSList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurGS instanceof Integer)) addVelocityOfCharacter((int)vCurID, (int)vCurGS);
						else throw new Exception("06; ChMan,aVsoCs");
						
						pIDList.next();
						pGSList.next();
					}
				} else throw new Exception("01; ChMan,aVsoCs");
			} else throw new Exception("05; ChMan,aVsoCs");
		} else throw new Exception("04; ChMan,aVsoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pSOList
	 * @throws Exception
	 */
	public void addSocialStatiOfAllCharacters(List pSOList) throws Exception{
		Object vCurSO;
		int vCurID;
		
		if (pSOList != null) {
			if (!characterList.isEmpty() && !pSOList.isEmpty()) {
				if (characterList.getContentNumber() == pSOList.getContentNumber()) {
					characterList.toFirst();
					pSOList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurSO = pSOList.getCurrent();
						
						if (vCurSO instanceof Integer) addSocialStatusOfCharacter(vCurID, (int)vCurSO);
						else throw new Exception("06; ChMan,aSSsoaCs");
						
						characterList.next();
						pSOList.next();
					}
				} else throw new Exception("01; ChMan,aSSsoaCs");
			} else throw new Exception("05; ChMan,aSSsoaCs");
		} else throw new Exception("04; ChMan,aSSsoaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pGSList
	 * @throws Exception
	 */
	public void addVelocitiesOfAllCharacters(List pGSList) throws Exception{
		Object vCurGS;
		int vCurID;
		
		if (pGSList != null) {
			if (!characterList.isEmpty() && !pGSList.isEmpty()) {
				if (characterList.getContentNumber() == pGSList.getContentNumber()) {
					characterList.toFirst();
					pGSList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurGS = pGSList.getCurrent();
						
						if (vCurGS instanceof Integer) addVelocityOfCharacter(vCurID, (int)vCurGS);
						else throw new Exception("06; ChMan,aVsoaCs");
						
						characterList.next();
						pGSList.next();
					}
				} else throw new Exception("01; ChMan,aVsoaCs");
			} else throw new Exception("05; ChMan,aVsoaCs");
		} else throw new Exception("04; ChMan,aVsoaCs");
	}
	
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pMR
	 * @throws Exception
	 */
	public void addMagicResistanceOfCharacter(int pID, double pMR) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.addMr(pMR);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,aMRoC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pWS
	 * @throws Exception
	 */
	public void addWoundThresholdOfCharacter(int pID, double pWS) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.addWs(pWS);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,aWToC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pBE
	 * @throws Exception
	 */
	public void addHandicapOfCharacter(int pID, double pBE) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.addBe(pBE);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,aBEoC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pMR
	 * @throws Exception
	 */
	public void addMagicResistanceOfCharacters(List pIDList, int pMR) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) addMagicResistanceOfCharacter((int)vCurID, pMR);
					else throw new Exception("06; ChMan,aMRoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,aMRoCs");
		} else throw new Exception("04; ChMan,aMRoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pWS
	 * @throws Exception
	 */
	public void addWoundThresholdOfCharacters(List pIDList, int pWS) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) addWoundThresholdOfCharacter((int)vCurID, pWS);
					else throw new Exception("06; ChMan,aWToCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,aWToCs");
		} else throw new Exception("04; ChMan,aWToCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pBE
	 * @throws Exception
	 */
	public void addHandicapOfCharacters(List pIDList, int pBE) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) addHandicapOfCharacter((int)vCurID, pBE);
					else throw new Exception("06; ChMan,aHoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,aHoCs");
		} else throw new Exception("04; ChMan,aHoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pMRList
	 * @throws Exception
	 */
	public void addMagicResistancesOfCharacters(List pIDList, List pMRList) throws Exception{
		Object vCurID, vCurMR;
		
		if ((pIDList != null) && (pMRList != null)) {
			if (!pIDList.isEmpty() && !pMRList.isEmpty()) {
				if (pIDList.getContentNumber() == pMRList.getContentNumber()) {
					pIDList.toFirst();
					pMRList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurMR = pMRList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurMR instanceof Double)) addMagicResistanceOfCharacter((int)vCurID, (double)vCurMR);
						else throw new Exception("06; ChMan,aMRsoCs");
						
						pIDList.next();
						pMRList.next();
					}
				} else throw new Exception("01; ChMan,aMRsoCs");
			} else throw new Exception("05; ChMan,aMRsoCs");
		} else throw new Exception("04; ChMan,aMRsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pWSList
	 * @throws Exception
	 */
	public void addWoundThresholdsOfCharacters(List pIDList, List pWSList) throws Exception{
		Object vCurID, vCurWS;
		
		if ((pIDList != null) && (pWSList != null)) {
			if (!pIDList.isEmpty() && !pWSList.isEmpty()) {
				if (pIDList.getContentNumber() == pWSList.getContentNumber()) {
					pIDList.toFirst();
					pWSList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurWS = pWSList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurWS instanceof Double)) addWoundThresholdOfCharacter((int)vCurID, (double)vCurWS);
						else throw new Exception("06; ChMan,aWTsoCs");
						
						pIDList.next();
						pWSList.next();
					}
				} else throw new Exception("01; ChMan,aWTsoCs");
			} else throw new Exception("05; ChMan,aWTsoCs");
		} else throw new Exception("04; ChMan,aWTsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pBEList
	 * @throws Exception
	 */
	public void addHandicapsOfCharacters(List pIDList, List pBEList) throws Exception{
		Object vCurID, vCurBE;
		
		if ((pIDList != null) && (pBEList != null)) {
			if (!pIDList.isEmpty() && !pBEList.isEmpty()) {
				if (pIDList.getContentNumber() == pBEList.getContentNumber()) {
					pIDList.toFirst();
					pBEList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurBE = pBEList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurBE instanceof Double)) addHandicapOfCharacter((int)vCurID, (double)vCurBE);
						else throw new Exception("06; ChMan,aHsoCs");
						
						pIDList.next();
						pBEList.next();
					}
				} else throw new Exception("01; ChMan,aHsoCs");
			} else throw new Exception("05; ChMan,aHsoCs");
		} else throw new Exception("04; ChMan,aHsoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pMRList
	 * @throws Exception
	 */
	public void addMagicResistancesOfAllCharacters(List pMRList) throws Exception{
		Object vCurMR;
		int vCurID;
		
		if (pMRList != null) {
			if (!characterList.isEmpty() && !pMRList.isEmpty()) {
				if (characterList.getContentNumber() == pMRList.getContentNumber()) {
					characterList.toFirst();
					pMRList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurMR = pMRList.getCurrent();
						
						if (vCurMR instanceof Double) addMagicResistanceOfCharacter(vCurID, (double)vCurMR);
						else throw new Exception("06; ChMan,aMRsoaCs");
						
						characterList.next();
						pMRList.next();
					}
				} else throw new Exception("01; ChMan,aMRsoaCs");
			} else throw new Exception("05; ChMan,aMRsoaCs");
		} else throw new Exception("04; ChMan,aMRsoaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pWSList
	 * @throws Exception
	 */
	public void addWoundThresholdsOfAllCharacters(List pWSList) throws Exception{
		Object vCurWS;
		int vCurID;
		
		if (pWSList != null) {
			if (!characterList.isEmpty() && !pWSList.isEmpty()) {
				if (characterList.getContentNumber() == pWSList.getContentNumber()) {
					characterList.toFirst();
					pWSList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurWS = pWSList.getCurrent();
						
						if (vCurWS instanceof Double) addWoundThresholdOfCharacter(vCurID, (double)vCurWS);
						else throw new Exception("06; ChMan,aWTsoaCs");
						
						characterList.next();
						pWSList.next();
					}
				} else throw new Exception("01; ChMan,aWTsoaCs");
			} else throw new Exception("05; ChMan,aWTsoaCs");
		} else throw new Exception("04; ChMan,aWTsoaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pBEList
	 * @throws Exception
	 */
	public void addHandicapsOfAllCharacters(List pBEList) throws Exception{
		Object vCurBE;
		int vCurID;
		
		if (pBEList != null) {
			if (!characterList.isEmpty() && !pBEList.isEmpty()) {
				if (characterList.getContentNumber() == pBEList.getContentNumber()) {
					characterList.toFirst();
					pBEList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurBE = pBEList.getCurrent();
						
						if (vCurBE instanceof Double) addHandicapOfCharacter(vCurID, (double)vCurBE);
						else throw new Exception("06; ChMan,aHsoaCs");
						
						characterList.next();
						pBEList.next();
					}
				} else throw new Exception("01; ChMan,aHsoaCs");
			} else throw new Exception("05; ChMan,aHsoaCs");
		} else throw new Exception("04; ChMan,aHsoaCs");
	}
	
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pProperty
	 * @param pInd
	 * @throws Exception
	 */
	public void addPropertyOfCharacter(int pID, int pProperty, int pInd) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.addPropertie(pProperty, pInd);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("02; ChMan,aPoC");
		} else throw new Exception("02; ChMan,aPoC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pMaxStatus
	 * @param pInd
	 * @throws Exception
	 */
	public void addMaxStatusOfCharacter(int pID, int pMaxStatus, int pInd) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.addMaxStat(pMaxStatus, pInd);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("02; ChMan,aMSoC");
		} else throw new Exception("02; ChMan,aMSoC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pStatus
	 * @param pInd
	 * @throws Exception
	 */
	public void addStatusOfCharacter(int pID, int pStatus, int pInd) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.addStat(pStatus, pInd);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("02; ChMan,aSoC");
		} else throw new Exception("02; ChMan,aSoC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pWoundNumber
	 * @param pInd
	 * @throws Exception
	 */
	public void addWoundNumberOfCharacter(int pID, int pWoundNumber, int pInd) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.addWound(pWoundNumber, pInd);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("02; ChMan,aWNoC");
		} else throw new Exception("02; ChMan,aWNoC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pProperty
	 * @param pInd
	 * @throws Exception
	 */
	public void addPropertyOfCharacters(List pIDList, int pProperty, int pInd) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!pIDList.isEmpty()) {
					pIDList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						
						if (vCurID instanceof Integer) addPropertyOfCharacter((int)vCurID, pProperty, pInd);
						else throw new Exception("06; ChMan,aPoCs");
						
						pIDList.next();
					}
				} else throw new Exception("05; ChMan,aPoCs");
			} else throw new Exception("02; ChMan,aPoC");
		} else throw new Exception("04; ChMan,aPoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pMaxStatus
	 * @param pInd
	 * @throws Exception
	 */
	public void addMaxStatusOfCharacters(List pIDList, int pMaxStatus, int pInd) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!pIDList.isEmpty()) {
					pIDList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						
						if (vCurID instanceof Integer) addMaxStatusOfCharacter((int)vCurID, pMaxStatus, pInd);
						else throw new Exception("06; ChMan,aMSoCs");
						
						pIDList.next();
					}
				} else throw new Exception("05; ChMan,aMSoCs");
			} else throw new Exception("02; ChMan,aMSoC");
		} else throw new Exception("04; ChMan,aMSoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pStatus
	 * @param pInd
	 * @throws Exception
	 */
	public void addStatusOfCharacters(List pIDList, int pStatus, int pInd) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!pIDList.isEmpty()) {
					pIDList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						
						if (vCurID instanceof Integer) addStatusOfCharacter((int)vCurID, pStatus, pInd);
						else throw new Exception("06; ChMan,aSoCs");
						
						pIDList.next();
					}
				} else throw new Exception("05; ChMan,aSoCs");
			} else throw new Exception("02; ChMan,aSoC");
		} else throw new Exception("04; ChMan,aSoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pWoundNumber
	 * @param pInd
	 * @throws Exception
	 */
	public void addWoundNumberOfCharacters(List pIDList, int pWoundNumber, int pInd) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!pIDList.isEmpty()) {
					pIDList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						
						if (vCurID instanceof Integer) addWoundNumberOfCharacter((int)vCurID, pWoundNumber, pInd);
						else throw new Exception("06; ChMan,aWNoCs");
						
						pIDList.next();
					}
				} else throw new Exception("05; ChMan,aWNoCs");
			} else throw new Exception("02; ChMan,aWNoC");
		} else throw new Exception("04; ChMan,aWNoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pPropertyList
	 * @param pInd
	 * @throws Exception
	 */
	public void addPropertiesOfCharacters(List pIDList, List pPropertyList, int pInd) throws Exception{
		Object vCurID, vCurProperty;
		
		if ((pIDList != null) && (pPropertyList != null)) {
			if (!pIDList.isEmpty() && !pPropertyList.isEmpty()) {
				if (pIDList.getContentNumber() == pPropertyList.getContentNumber()) {
					pIDList.toFirst();
					pPropertyList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurProperty = pPropertyList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurProperty instanceof Integer)) addPropertyOfCharacter((int)vCurID, (int)vCurProperty, pInd);
						else throw new Exception("06; ChMan,aPsoCs");
						
						pIDList.next();
						pPropertyList.next();
					}
				} else throw new Exception("01; ChMan,aPsoCs");
			} else throw new Exception("05; ChMan,aPsoCs");
		} else throw new Exception("04; ChMan,aPsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pMaxStatusList
	 * @param pInd
	 * @throws Exception
	 */
	public void addMaxStatiOfCharacters(List pIDList, List pMaxStatusList, int pInd) throws Exception{
		Object vCurID, vCurMaxStatus;
		
		if ((pIDList != null) && (pMaxStatusList != null)) {
			if (!pIDList.isEmpty() && !pMaxStatusList.isEmpty()) {
				if (pIDList.getContentNumber() == pMaxStatusList.getContentNumber()) {
					pIDList.toFirst();
					pMaxStatusList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurMaxStatus= pMaxStatusList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurMaxStatus instanceof Integer)) addMaxStatusOfCharacter((int)vCurID, (int)vCurMaxStatus, pInd);
						else throw new Exception("06; ChMan,aMSioCs");
						
						pIDList.next();
						pMaxStatusList.next();
					}
				} else throw new Exception("01; ChMan,aMSioCs");
			} else throw new Exception("05; ChMan,aMSioCs");
		} else throw new Exception("04; ChMan,aMSioCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pStatusList
	 * @param pInd
	 * @throws Exception
	 */
	public void addStatiOfCharacters(List pIDList, List pStatusList, int pInd) throws Exception{
		Object vCurID, vCurStatus;
		
		if ((pIDList != null) && (pStatusList != null)) {
			if (!pIDList.isEmpty() && !pStatusList.isEmpty()) {
				if (pIDList.getContentNumber() == pStatusList.getContentNumber()) {
					pIDList.toFirst();
					pStatusList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurStatus= pStatusList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurStatus instanceof Integer)) addStatusOfCharacter((int)vCurID, (int)vCurStatus, pInd);
						else throw new Exception("06; ChMan,aSioCs");
						
						pIDList.next();
						pStatusList.next();
					}
				} else throw new Exception("01; ChMan,aSioCs");
			} else throw new Exception("05; ChMan,aSioCs");
		} else throw new Exception("04; ChMan,aSioCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pWoundNumberList
	 * @param pInd
	 * @throws Exception
	 */
	public void addWoundNumbersOfCharacters(List pIDList, List pWoundNumberList, int pInd) throws Exception{
		Object vCurID, vCurWoundNumber;
		
		if ((pIDList != null) && (pWoundNumberList != null)) {
			if (!pIDList.isEmpty() && !pWoundNumberList.isEmpty()) {
				if (pIDList.getContentNumber() == pWoundNumberList.getContentNumber()) {
					pIDList.toFirst();
					pWoundNumberList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurWoundNumber = pWoundNumberList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurWoundNumber instanceof Integer)) addWoundNumberOfCharacter((int)vCurID, (int)vCurWoundNumber, pInd);
						else throw new Exception("06; ChMan,aWNsoCs");
						
						pIDList.next();
						pWoundNumberList.next();
					}
				} else throw new Exception("01; ChMan,aWNsoCs");
			} else throw new Exception("05; ChMan,aWNsoCs");
		} else throw new Exception("04; ChMan,aWNsoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pPropertyList
	 * @param pInd
	 * @throws Exception
	 */
	public void addPropertiesOfAllCharacters(List pPropertyList, int pInd) throws Exception{
		Object vCurProperty;
		int vCurID;
		
		if (pPropertyList != null) {
			if (!characterList.isEmpty() && !pPropertyList.isEmpty()) {
				if (characterList.getContentNumber() == pPropertyList.getContentNumber()) {
					characterList.toFirst();
					pPropertyList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurProperty = pPropertyList.getCurrent();
						
						if (vCurProperty instanceof Integer) addPropertyOfCharacter(vCurID, (int)vCurProperty, pInd);
						else throw new Exception("06; ChMan,aPsoaCs");
						
						characterList.next();
						pPropertyList.next();
					}
				} else throw new Exception("01; ChMan,aPsoaCs");
			} else throw new Exception("05; ChMan,aPsoaCs");
		} else throw new Exception("04; ChMan,aPsoaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pMaxStatusList
	 * @param pInd
	 * @throws Exception
	 */
	public void addMaxStatiOfAllCharacters(List pMaxStatusList, int pInd) throws Exception{
		Object vCurMaxStatus;
		int vCurID;
		
		if (pMaxStatusList != null) {
			if (!characterList.isEmpty() && !pMaxStatusList.isEmpty()) {
				if (characterList.getContentNumber() == pMaxStatusList.getContentNumber()) {
					characterList.toFirst();
					pMaxStatusList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurMaxStatus = pMaxStatusList.getCurrent();
						
						if (vCurMaxStatus instanceof Integer) addMaxStatusOfCharacter(vCurID, (int)vCurMaxStatus, pInd);
						else throw new Exception("06; ChMan,aMSioaCs");
						
						characterList.next();
						pMaxStatusList.next();
					}
				} else throw new Exception("01; ChMan,aMSioaCs");
			} else throw new Exception("05; ChMan,aMSioaCs");
		} else throw new Exception("04; ChMan,aMSioaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pStatusList
	 * @param pInd
	 * @throws Exception
	 */
	public void addStatiOfAllCharacters(List pStatusList, int pInd) throws Exception{
		Object vCurStatus;
		int vCurID;
		
		if (pStatusList != null) {
			if (!characterList.isEmpty() && !pStatusList.isEmpty()) {
				if (characterList.getContentNumber() == pStatusList.getContentNumber()) {
					characterList.toFirst();
					pStatusList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurStatus = pStatusList.getCurrent();
						
						if (vCurStatus instanceof Integer) addMaxStatusOfCharacter(vCurID, (int)vCurStatus, pInd);
						else throw new Exception("06; ChMan,aSioaCs");
						
						characterList.next();
						pStatusList.next();
					}
				} else throw new Exception("01; ChMan,aSioaCs");
			} else throw new Exception("05; ChMan,aSioaCs");
		} else throw new Exception("04; ChMan,aSioaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pWoundNumberList
	 * @param pInd
	 * @throws Exception
	 */
	public void addWoundNumbersOfAllCharacters(List pWoundNumberList, int pInd) throws Exception{
		Object vCurWoundNumber;
		int vCurID;
		
		if (pWoundNumberList != null) {
			if (!characterList.isEmpty() && !pWoundNumberList.isEmpty()) {
				if (characterList.getContentNumber() == pWoundNumberList.getContentNumber()) {
					characterList.toFirst();
					pWoundNumberList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurWoundNumber = pWoundNumberList.getCurrent();
						
						if (vCurWoundNumber instanceof Integer) addWoundNumberOfCharacter(vCurID, (int)vCurWoundNumber, pInd);
						else throw new Exception("06; ChMan,aWNsoaCs");
						
						characterList.next();
						pWoundNumberList.next();
					}
				} else throw new Exception("01; ChMan,aWNsoaCs");
			} else throw new Exception("05; ChMan,aWNsoaCs");
		} else throw new Exception("04; ChMan,aWNsoaCs");
	}
	
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pProperties
	 * @throws Exception
	 */
	public void addPropertiesOfCharacter(int pID, int[] pProperties) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.addProperties(pProperties);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,aPsoC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pMaxStati
	 * @throws Exception
	 */
	public void addMaxStatiOfCharacter(int pID, double[] pMaxStati) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.addMaxStats(pMaxStati);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,aMSioC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pStati
	 * @throws Exception
	 */
	public void addStatiOfCharacter(int pID, int[] pStati) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.addStats(pStati);;
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,aSioC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pWoundNumbers
	 * @throws Exception
	 */
	public void addWoundNumbersOfCharacter(int pID, int[] pWoundNumbers) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.addWounds(pWoundNumbers);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,aWNsoC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pProperties
	 * @throws Exception
	 */
	public void addPropertiesOfCharacters(List pIDList, int[] pProperties) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) addPropertiesOfCharacter((int)vCurID, pProperties);
					else throw new Exception("06; ChMan,aPsoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,aPsoCs");
		} else throw new Exception("04; ChMan,aPsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pMaxStati
	 * @throws Exception
	 */
	public void addMaxStatiOfCharacters(List pIDList, double[] pMaxStati) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) addMaxStatiOfCharacter((int)vCurID, pMaxStati);
					else throw new Exception("06; ChMan,aMSioCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,aMSioCs");
		} else throw new Exception("04; ChMan,aMSioCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pStati
	 * @throws Exception
	 */
	public void addStatiOfCharacters(List pIDList, int[] pStati) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) addStatiOfCharacter((int)vCurID, pStati);
					else throw new Exception("06; ChMan,aSioCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,aSioCs");
		} else throw new Exception("04; ChMan,aSioCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pWoundNumbers
	 * @throws Exception
	 */
	public void addWoundNumbersOfCharacters(List pIDList, int[] pWoundNumbers) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) addWoundNumbersOfCharacter((int)vCurID, pWoundNumbers);
					else throw new Exception("06; ChMan,aWNsoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,aWNsoCs");
		} else throw new Exception("04; ChMan,aWNsoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pPropertiesList
	 * @throws Exception
	 */
	public void addPropertiesOfCharacters(List pIDList, List pPropertiesList) throws Exception{
		Object vCurID, vCurProperties;
		
		if ((pIDList != null) && (pPropertiesList != null)) {
			if (!pIDList.isEmpty() && !pPropertiesList.isEmpty()) {
				if (pIDList.getContentNumber() == pPropertiesList.getContentNumber()) {
					pIDList.toFirst();
					pPropertiesList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurProperties = pPropertiesList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurProperties instanceof Integer[])) addPropertiesOfCharacter((int)vCurID, (int[])vCurProperties);
						else throw new Exception("06; ChMan,aPsoCs");
						
						pIDList.next();
						pPropertiesList.next();
					}
				} else throw new Exception("01; ChMan,aPsoCs");
			} else throw new Exception("05; ChMan,aPsoCs");
		} else throw new Exception("04; ChMan,aPsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pMaxStatiList
	 * @throws Exception
	 */
	public void addMaxStatiOfCharacters(List pIDList, List pMaxStatiList) throws Exception{
		Object vCurID, vCurMaxStati;
		
		if ((pIDList != null) && (pMaxStatiList != null)) {
			if (!pIDList.isEmpty() && !pMaxStatiList.isEmpty()) {
				if (pIDList.getContentNumber() == pMaxStatiList.getContentNumber()) {
					pIDList.toFirst();
					pMaxStatiList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurMaxStati = pMaxStatiList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurMaxStati instanceof Double[])) addMaxStatiOfCharacter((int)vCurID, (double[])vCurMaxStati);
						else throw new Exception("06; ChMan,aMSioCs");
						
						pIDList.next();
						pMaxStatiList.next();
					}
				} else throw new Exception("01; ChMan,aMSioCs");
			} else throw new Exception("05; ChMan,aMSioCs");
		} else throw new Exception("04; ChMan,aMSioCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pStatiList
	 * @throws Exception
	 */
	public void addStatiOfCharacters(List pIDList, List pStatiList) throws Exception{
		Object vCurID, vCurStati;
		
		if ((pIDList != null) && (pStatiList != null)) {
			if (!pIDList.isEmpty() && !pStatiList.isEmpty()) {
				if (pIDList.getContentNumber() == pStatiList.getContentNumber()) {
					pIDList.toFirst();
					pStatiList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurStati = pStatiList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurStati instanceof Integer[])) addStatiOfCharacter((int)vCurID, (int[])vCurStati);
						else throw new Exception("06; ChMan,aSioCs");
						
						pIDList.next();
						pStatiList.next();
					}
				} else throw new Exception("01; ChMan,aSioCs");
			} else throw new Exception("05; ChMan,aSioCs");
		} else throw new Exception("04; ChMan,aSioCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pWoundNumbersList
	 * @throws Exception
	 */
	public void addWoundNumbersOfCharacters(List pIDList, List pWoundNumbersList) throws Exception{
		Object vCurID, vCurWoundNumbers;
		
		if ((pIDList != null) && (pWoundNumbersList != null)) {
			if (!pIDList.isEmpty() && !pWoundNumbersList.isEmpty()) {
				if (pIDList.getContentNumber() == pWoundNumbersList.getContentNumber()) {
					pIDList.toFirst();
					pWoundNumbersList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurWoundNumbers = pWoundNumbersList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurWoundNumbers instanceof Integer[])) addWoundNumbersOfCharacter((int)vCurID, (int[])vCurWoundNumbers);
						else throw new Exception("06; ChMan,aWNsoCs");
						
						pIDList.next();
						pWoundNumbersList.next();
					}
				} else throw new Exception("01; ChMan,aWNsoCs");
			} else throw new Exception("05; ChMan,aWNsoCs");
		} else throw new Exception("04; ChMan,aWNsoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pPropertiesList
	 * @throws Exception
	 */
	public void addPropertiesOfAllCharacters(List pPropertiesList) throws Exception{
		Object vCurProperties;
		int vCurID;
		
		if (pPropertiesList != null) {
			if (!characterList.isEmpty() && !pPropertiesList.isEmpty()) {
				if (characterList.getContentNumber() == pPropertiesList.getContentNumber()) {
					characterList.toFirst();
					pPropertiesList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurProperties = pPropertiesList.getCurrent();
						
						if (vCurProperties instanceof Integer[]) addPropertiesOfCharacter(vCurID, (int[])vCurProperties);
						else throw new Exception("06; ChMan,aPsoaCs");
						
						characterList.next();
						pPropertiesList.next();
					}
				} else throw new Exception("01; ChMan,aPsoaCs");
			} else throw new Exception("05; ChMan,aPsoaCs");
		} else throw new Exception("04; ChMan,aPsoaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pMaxStatiList
	 * @throws Exception
	 */
	public void addMaxStatiOfAllCharacters(List pMaxStatiList) throws Exception{
		Object vCurMaxStati;
		int vCurID;
		
		if (pMaxStatiList != null) {
			if (!characterList.isEmpty() && !pMaxStatiList.isEmpty()) {
				if (characterList.getContentNumber() == pMaxStatiList.getContentNumber()) {
					characterList.toFirst();
					pMaxStatiList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurMaxStati = pMaxStatiList.getCurrent();
						
						if (vCurMaxStati instanceof Double[]) addMaxStatiOfCharacter(vCurID, (double[])vCurMaxStati);
						else throw new Exception("06; ChMan,aMSioaCs");
						
						characterList.next();
						pMaxStatiList.next();
					}
				} else throw new Exception("01; ChMan,aMSioaCs");
			} else throw new Exception("05; ChMan,aMSioaCs");
		} else throw new Exception("04; ChMan,aMSioaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pStatiList
	 * @throws Exception
	 */
	public void addStatiOfAllCharacters(List pStatiList) throws Exception{
		Object vCurStati;
		int vCurID;
		
		if (pStatiList != null) {
			if (!characterList.isEmpty() && !pStatiList.isEmpty()) {
				if (characterList.getContentNumber() == pStatiList.getContentNumber()) {
					characterList.toFirst();
					pStatiList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurStati = pStatiList.getCurrent();
						
						if (vCurStati instanceof Integer[]) addStatiOfCharacter(vCurID, (int[])vCurStati);
						else throw new Exception("06; ChMan,aSioaCs");
						
						characterList.next();
						pStatiList.next();
					}
				} else throw new Exception("01; ChMan,aSioaCs");
			} else throw new Exception("05; ChMan,aSioaCs");
		} else throw new Exception("04; ChMan,aSioaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pWoundNumbersList
	 * @throws Exception
	 */
	public void addWoundNumbersOfAllCharacters(List pWoundNumbersList) throws Exception{
		Object vCurWoundNumbers;
		int vCurID;
		
		if (pWoundNumbersList != null) {
			if (!characterList.isEmpty() && !pWoundNumbersList.isEmpty()) {
				if (characterList.getContentNumber() == pWoundNumbersList.getContentNumber()) {
					characterList.toFirst();
					pWoundNumbersList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurWoundNumbers = pWoundNumbersList.getCurrent();
						
						if (vCurWoundNumbers instanceof Integer[]) addWoundNumbersOfCharacter(vCurID, (int[])vCurWoundNumbers);
						else throw new Exception("06; ChMan,aWNsoaCs");
						
						characterList.next();
						pWoundNumbersList.next();
					}
				} else throw new Exception("01; ChMan,aWNsoaCs");
			} else throw new Exception("05; ChMan,aWNsoaCs");
		} else throw new Exception("04; ChMan,aWNsoaCs");
	}
	
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pFightValue
	 * @param pInd
	 * @throws Exception
	 */
	public void addFightValueOfCharacter(int pID, double pFightValue, int pInd) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.addFightValue(pFightValue, pInd);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("02; ChMan,aFVoC");
		} else throw new Exception("02; ChMan,aFVoC");
	}
	/**	Dh	23.6.2020
	 * 	
	 * @param pID
	 * @param pArmorValue
	 * @param pInd
	 * @throws Exception
	 */
	public void addArmorValueOfCharacter(int pID, double pArmorValue, int pInd) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.addRs(pArmorValue, pInd);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("02; ChMan,aAVoC");
		} else throw new Exception("02; ChMan,aAVoC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pFightValue
	 * @param pInd
	 * @throws Exception
	 */
	public void addFightValueOfCharacters(List pIDList, double pFightValue, int pInd) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!pIDList.isEmpty()) {
					pIDList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						
						if (vCurID instanceof Integer) addFightValueOfCharacter((int)vCurID, pFightValue, pInd);
						else throw new Exception("06; ChMan,aFVoCs");
						
						pIDList.next();
					}
				} else throw new Exception("05; ChMan,aFVoCs");
			} else throw new Exception("02; ChMan,aFVoC");
		} else throw new Exception("04; ChMan,aFVoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pArmorValue
	 * @param pInd
	 * @throws Exception
	 */
	public void addArmorValueOfCharacters(List pIDList, double pArmorValue, int pInd) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if ((pInd >= 0) && (pInd < 8)) {
				if (!pIDList.isEmpty()) {
					pIDList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						
						if (vCurID instanceof Integer) addArmorValueOfCharacter((int)vCurID, pArmorValue, pInd);
						else throw new Exception("06; ChMan,aAVoCs");
						
						pIDList.next();
					}
				} else throw new Exception("05; ChMan,aAVoCs");
			} else throw new Exception("02; ChMan,aAVoC");
		} else throw new Exception("04; ChMan,aAVoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pFightValuesList
	 * @param pInd
	 * @throws Exception
	 */
	public void addFightValuesOfCharacters(List pIDList, List pFightValuesList, int pInd) throws Exception{
		Object vCurID, vCurFightValues;
		
		if ((pIDList != null) && (pFightValuesList != null)) {
			if (!pIDList.isEmpty() && !pFightValuesList.isEmpty()) {
				if (pIDList.getContentNumber() == pFightValuesList.getContentNumber()) {
					pIDList.toFirst();
					pFightValuesList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurFightValues = pFightValuesList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurFightValues instanceof Double)) addFightValueOfCharacter((int)vCurID, (double)vCurFightValues, pInd);
						else throw new Exception("06; ChMan,aFVsoCs");
						
						pIDList.next();
						pFightValuesList.next();
					}
				} else throw new Exception("01; ChMan,aFVsoCs");
			} else throw new Exception("05; ChMan,aFVsoCs");
		} else throw new Exception("04; ChMan,aFVsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pArmorValuesList
	 * @param pInd
	 * @throws Exception
	 */
	public void addArmorValuesOfCharacters(List pIDList, List pArmorValuesList, int pInd) throws Exception{
		Object vCurID, vCurArmorValues;
		
		if ((pIDList != null) && (pArmorValuesList != null)) {
			if (!pIDList.isEmpty() && !pArmorValuesList.isEmpty()) {
				if (pIDList.getContentNumber() == pArmorValuesList.getContentNumber()) {
					pIDList.toFirst();
					pArmorValuesList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurArmorValues = pArmorValuesList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurArmorValues instanceof Double)) addArmorValueOfCharacter((int)vCurID, (double)vCurArmorValues, pInd);
						else throw new Exception("06; ChMan,aAVsoCs");
						
						pIDList.next();
						pArmorValuesList.next();
					}
				} else throw new Exception("01; ChMan,aAVsoCs");
			} else throw new Exception("05; ChMan,aAVsoCs");
		} else throw new Exception("04; ChMan,aAVsoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pFightValuesList
	 * @param pInd
	 * @throws Exception
	 */
	public void addFightValuesOfAllCharacters(List pFightValuesList, int pInd) throws Exception{
		Object vCurFightValues;
		int vCurID;
		
		if (pFightValuesList != null) {
			if (!characterList.isEmpty() && !pFightValuesList.isEmpty()) {
				if (characterList.getContentNumber() == pFightValuesList.getContentNumber()) {
					characterList.toFirst();
					pFightValuesList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurFightValues = pFightValuesList.getCurrent();
						
						if (vCurFightValues instanceof Double) addFightValueOfCharacter(vCurID, (double)vCurFightValues, pInd);
						else throw new Exception("06; ChMan,aFVsoaCs");
						
						characterList.next();
						pFightValuesList.next();
					}
				} else throw new Exception("01; ChMan,aFVsoaCs");
			} else throw new Exception("05; ChMan,aFVsoaCs");
		} else throw new Exception("04; ChMan,aFVsoaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pArmorValuesList
	 * @param pInd
	 * @throws Exception
	 */
	public void addArmorValuesOfAllCharacters(List pArmorValuesList, int pInd) throws Exception{
		Object vCurArmorValues;
		int vCurID;
		
		if (pArmorValuesList != null) {
			if (!characterList.isEmpty() && !pArmorValuesList.isEmpty()) {
				if (characterList.getContentNumber() == pArmorValuesList.getContentNumber()) {
					characterList.toFirst();
					pArmorValuesList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurArmorValues = pArmorValuesList.getCurrent();
						
						if (vCurArmorValues instanceof Double) addArmorValueOfCharacter(vCurID, (double)vCurArmorValues, pInd);
						else throw new Exception("06; ChMan,aAVsoaCs");
						
						characterList.next();
						pArmorValuesList.next();
					}
				} else throw new Exception("01; ChMan,aAVsoaCs");
			} else throw new Exception("05; ChMan,aAVsoaCs");
		} else throw new Exception("04; ChMan,aAVsoaCs");
	}
	
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pFightValues
	 * @throws Exception
	 */
	public void addFightValuesOfCharacter(int pID, double[] pFightValues) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.addFightValues(pFightValues);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,aFVsoC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pArmorValues
	 * @throws Exception
	 */
	public void addArmorValuesOfCharacter(int pID, double[] pArmorValues) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						vCur.addRs(pArmorValues);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,aAVsoC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pFightValues
	 * @throws Exception
	 */
	public void addFightValuesOfCharacters(List pIDList, double[] pFightValues) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) addFightValuesOfCharacter((int)vCurID, pFightValues);
					else throw new Exception("06; ChMan,aFVsoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,aFVsoCs");
		} else throw new Exception("04; ChMan,aFVsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pArmorValues
	 * @throws Exception
	 */
	public void addArmorValuesOfCharacters(List pIDList, double[] pArmorValues) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) addArmorValuesOfCharacter((int)vCurID, pArmorValues);
					else throw new Exception("06; ChMan,aAVsoCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,aAVsoCs");
		} else throw new Exception("04; ChMan,aAVsoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pFightValuesList
	 * @throws Exception
	 */
	public void addFightValuesOfCharacters(List pIDList, List pFightValuesList) throws Exception{
		Object vCurID, vCurFightValues;
		
		if ((pIDList != null) && (pFightValuesList != null)) {
			if (!pIDList.isEmpty() && !pFightValuesList.isEmpty()) {
				if (pIDList.getContentNumber() == pFightValuesList.getContentNumber()) {
					pIDList.toFirst();
					pFightValuesList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurFightValues = pFightValuesList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurFightValues instanceof Double[])) addFightValuesOfCharacter((int)vCurID, (double[])vCurFightValues);
						else throw new Exception("06; ChMan,aFVsoCs");
						
						pIDList.next();
						pFightValuesList.next();
					}
				} else throw new Exception("01; ChMan,aFVsoCs");
			} else throw new Exception("05; ChMan,aFVsoCs");
		} else throw new Exception("04; ChMan,aFVsoCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pArmorValuesList
	 * @throws Exception
	 */
	public void addArmorValuesOfCharacters(List pIDList, List pArmorValuesList) throws Exception{
		Object vCurID, vCurArmorValues;
		
		if ((pIDList != null) && (pArmorValuesList != null)) {
			if (!pIDList.isEmpty() && !pArmorValuesList.isEmpty()) {
				if (pIDList.getContentNumber() == pArmorValuesList.getContentNumber()) {
					pIDList.toFirst();
					pArmorValuesList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurArmorValues = pArmorValuesList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurArmorValues instanceof Double[])) addArmorValuesOfCharacter((int)vCurID, (double[])vCurArmorValues);
						else throw new Exception("06; ChMan,aAVsoCs");
						
						pIDList.next();
						pArmorValuesList.next();
					}
				} else throw new Exception("01; ChMan,aAVsoCs");
			} else throw new Exception("05; ChMan,aAVsoCs");
		} else throw new Exception("04; ChMan,aAVsoCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pFightValuesList
	 * @throws Exception
	 */
	public void addFightValuesOfAllCharacters(List pFightValuesList) throws Exception{
		Object vCurFightValues;
		int vCurID;
		
		if (pFightValuesList != null) {
			if (!characterList.isEmpty() && !pFightValuesList.isEmpty()) {
				if (characterList.getContentNumber() == pFightValuesList.getContentNumber()) {
					characterList.toFirst();
					pFightValuesList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurFightValues = pFightValuesList.getCurrent();
						
						if (vCurFightValues instanceof Integer[]) addFightValuesOfCharacter(vCurID, (double[])vCurFightValues);
						else throw new Exception("06; ChMan,aFVsoaCs");
						
						characterList.next();
						pFightValuesList.next();
					}
				} else throw new Exception("01; ChMan,aFVsoaCs");
			} else throw new Exception("05; ChMan,aFVsoaCs");
		} else throw new Exception("04; ChMan,aFVsoaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pArmorValuesList
	 * @throws Exception
	 */
	public void addArmorValuesOfAllCharacters(List pArmorValuesList) throws Exception{
		Object vCurArmorValues;
		int vCurID;
		
		if (pArmorValuesList != null) {
			if (!characterList.isEmpty() && !pArmorValuesList.isEmpty()) {
				if (characterList.getContentNumber() == pArmorValuesList.getContentNumber()) {
					characterList.toFirst();
					pArmorValuesList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurArmorValues = pArmorValuesList.getCurrent();
						
						if (vCurArmorValues instanceof Integer[]) addArmorValuesOfCharacter(vCurID, (double[])vCurArmorValues);
						else throw new Exception("06; ChMan,aAVsoaCs");
						
						characterList.next();
						pArmorValuesList.next();
					}
				} else throw new Exception("01; ChMan,aAVsoaCs");
			} else throw new Exception("05; ChMan,aAVsoaCs");
		} else throw new Exception("04; ChMan,aAVsoaCs");
	}
	
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pPro
	 * @throws Exception
	 */
	public void addProToCharacter(int pID, Pro pPro) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (pPro != null) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.addPro(pPro);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("04; ChMan,aPtC");
		} else throw new Exception("02; ChMan,aPtC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pSpecialCraft
	 * @throws Exception
	 */
	public void addSpecialCraftToCharacter(int pID, SpecialCraft pSpecialCraft) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (pSpecialCraft != null) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.addSpecialCraft(pSpecialCraft);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("04; ChMan,aPtC");
		} else throw new Exception("02; ChMan,aPtC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pTalent
	 * @throws Exception
	 */
	public void addTalentToCharacter(int pID, Talent pTalent) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (pTalent != null) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.addTalent(pTalent);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("04; ChMan,aTtC");
		} else throw new Exception("02; ChMan,aTtC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pWeapon
	 * @throws Exception
	 */
	public void addWeaponToCharacter(int pID, Weapon pWeapon) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (pWeapon != null) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.addWeapon(pWeapon);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("04; ChMan,aWtC");
		} else throw new Exception("02; ChMan,aWtC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pPro
	 * @throws Exception
	 */
	public void addProToCharacters(List pIDList, Pro pPro) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) addProToCharacter((int)vCurID, pPro);
					else throw new Exception("06; ChMan,aPtCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,aPtCs");
		} else throw new Exception("04; ChMan,aPtCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pSpecialCraft
	 * @throws Exception
	 */
	public void addSpecialCraftToCharacters(List pIDList, SpecialCraft pSpecialCraft) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) addSpecialCraftToCharacter((int)vCurID, pSpecialCraft);
					else throw new Exception("06; ChMan,aSCtCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,aSCtCs");
		} else throw new Exception("04; ChMan,aSCtCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pTalent
	 * @throws Exception
	 */
	public void addTalentToCharacters(List pIDList, Talent pTalent) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) addTalentToCharacter((int)vCurID, pTalent);
					else throw new Exception("06; ChMan,aTtCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,aTtCs");
		} else throw new Exception("04; ChMan,aTtCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pWeapon
	 * @throws Exception
	 */
	public void addWeaponToCharacters(List pIDList, Weapon pWeapon) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) addWeaponToCharacter((int)vCurID, pWeapon);
					else throw new Exception("06; ChMan,aWtCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,aWtCs");
		} else throw new Exception("04; ChMan,aWtCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pProList
	 * @throws Exception
	 */
	public void addProsToCharacters(List pIDList, List pProList) throws Exception{
		Object vCurID, vCurPro;
		
		if ((pIDList != null) && (pProList != null)) {
			if (!pIDList.isEmpty() && !pProList.isEmpty()) {
				if (pIDList.getContentNumber() == pProList.getContentNumber()) {
					pIDList.toFirst();
					pProList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurPro = pProList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurPro instanceof Pro)) addProToCharacter((int)vCurID, (Pro)vCurPro);
						else throw new Exception("06; ChMan,aPstCs");
						
						pIDList.next();
						pProList.next();
					}
				} else throw new Exception("01; ChMan,aPstCs");
			} else throw new Exception("05; ChMan,aPstCs");
		} else throw new Exception("04; ChMan,aPstCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pSpecialCraftList
	 * @throws Exception
	 */
	public void addSpecialCraftsToCharacters(List pIDList, List pSpecialCraftList) throws Exception{
		Object vCurID, vCurSpecialCraft;
		
		if ((pIDList != null) && (pSpecialCraftList != null)) {
			if (!pIDList.isEmpty() && !pSpecialCraftList.isEmpty()) {
				if (pIDList.getContentNumber() == pSpecialCraftList.getContentNumber()) {
					pIDList.toFirst();
					pSpecialCraftList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurSpecialCraft = pSpecialCraftList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurSpecialCraft instanceof SpecialCraft)) addSpecialCraftToCharacter((int)vCurID, (SpecialCraft)vCurSpecialCraft);
						else throw new Exception("06; ChMan,aSCstCs");
						
						pIDList.next();
						pSpecialCraftList.next();
					}
				} else throw new Exception("01; ChMan,aSCstCs");
			} else throw new Exception("05; ChMan,aSCstCs");
		} else throw new Exception("04; ChMan,aSCstCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pTalentList
	 * @throws Exception
	 */
	public void addTalentsToCharacters(List pIDList, List pTalentList) throws Exception{
		Object vCurID, vCurTalent;
		
		if ((pIDList != null) && (pTalentList != null)) {
			if (!pIDList.isEmpty() && !pTalentList.isEmpty()) {
				if (pIDList.getContentNumber() == pTalentList.getContentNumber()) {
					pIDList.toFirst();
					pTalentList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurTalent = pTalentList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurTalent instanceof Talent)) addTalentToCharacter((int)vCurID, (Talent)vCurTalent);
						else throw new Exception("06; ChMan,aTstCs");
						
						pIDList.next();
						pTalentList.next();
					}
				} else throw new Exception("01; ChMan,aTstCs");
			} else throw new Exception("05; ChMan,aTstCs");
		} else throw new Exception("04; ChMan,aTstCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pWeaponList
	 * @throws Exception
	 */
	public void addWeaponsToCharacters(List pIDList, List pWeaponList) throws Exception{
		Object vCurID, vCurWeapon;
		
		if ((pIDList != null) && (pWeaponList != null)) {
			if (!pIDList.isEmpty() && !pWeaponList.isEmpty()) {
				if (pIDList.getContentNumber() == pWeaponList.getContentNumber()) {
					pIDList.toFirst();
					pWeaponList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurWeapon = pWeaponList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurWeapon instanceof Weapon)) addWeaponToCharacter((int)vCurID, (Weapon)vCurWeapon);
						else throw new Exception("06; ChMan,aWstCs");
						
						pIDList.next();
						pWeaponList.next();
					}
				} else throw new Exception("01; ChMan,aWstCs");
			} else throw new Exception("05; ChMan,aWstCs");
		} else throw new Exception("04; ChMan,aWstCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pProList
	 * @throws Exception
	 */
	public void addProsToAllCharacters(List pProList) throws Exception{
		Object vCurPro;
		int vCurID;
		
		if (pProList != null) {
			if (!characterList.isEmpty() && !pProList.isEmpty()) {
				if (characterList.getContentNumber() == pProList.getContentNumber()) {
					characterList.toFirst();
					pProList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurPro = pProList.getCurrent();
						
						if (vCurPro instanceof Pro) addProToCharacter(vCurID, (Pro)vCurPro);
						else throw new Exception("06; ChMan,aPstaCs");
						
						characterList.next();
						pProList.next();
					}
				} else throw new Exception("01; ChMan,aPstaCs");
			} else throw new Exception("05; ChMan,aPstaCs");
		} else throw new Exception("04; ChMan,aPstaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pSpecialCraftList
	 * @throws Exception
	 */
	public void addSpecialCraftsToAllCharacters(List pSpecialCraftList) throws Exception{
		Object vCurSpecialCraft;
		int vCurID;
		
		if (pSpecialCraftList != null) {
			if (!characterList.isEmpty() && !pSpecialCraftList.isEmpty()) {
				if (characterList.getContentNumber() == pSpecialCraftList.getContentNumber()) {
					characterList.toFirst();
					pSpecialCraftList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurSpecialCraft = pSpecialCraftList.getCurrent();
						
						if (vCurSpecialCraft instanceof SpecialCraft) addSpecialCraftToCharacter(vCurID, (SpecialCraft)vCurSpecialCraft);
						else throw new Exception("06; ChMan,aSCstaCs");
						
						characterList.next();
						pSpecialCraftList.next();
					}
				} else throw new Exception("01; ChMan,aSCstaCs");
			} else throw new Exception("05; ChMan,aSCstaCs");
		} else throw new Exception("04; ChMan,aSCstaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pTalentList
	 * @throws Exception
	 */
	public void addTalentsToAllCharacters(List pTalentList) throws Exception{
		Object vCurTalent;
		int vCurID;
		
		if (pTalentList != null) {
			if (!characterList.isEmpty() && !pTalentList.isEmpty()) {
				if (characterList.getContentNumber() == pTalentList.getContentNumber()) {
					characterList.toFirst();
					pTalentList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurTalent = pTalentList.getCurrent();
						
						if (vCurTalent instanceof Talent) addTalentToCharacter(vCurID, (Talent)vCurTalent);
						else throw new Exception("06; ChMan,aTstaCs");
						
						characterList.next();
						pTalentList.next();
					}
				} else throw new Exception("01; ChMan,aTstaCs");
			} else throw new Exception("05; ChMan,aTstaCs");
		} else throw new Exception("04; ChMan,aTstaCs");
	}
	/**	Dh	23.6.2020
	 * 	
	 * @param pWeaponList
	 * @throws Exception
	 */
	public void addWeaponsToAllCharacters(List pWeaponList) throws Exception{
		Object vCurWeapon;
		int vCurID;
		
		if (pWeaponList != null) {
			if (!characterList.isEmpty() && !pWeaponList.isEmpty()) {
				if (characterList.getContentNumber() == pWeaponList.getContentNumber()) {
					characterList.toFirst();
					pWeaponList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurWeapon = pWeaponList.getCurrent();
						
						if (vCurWeapon instanceof Weapon) addWeaponToCharacter(vCurID, (Weapon)vCurWeapon);
						else throw new Exception("06; ChMan,aWstaCs");
						
						characterList.next();
						pWeaponList.next();
					}
				} else throw new Exception("01; ChMan,aWstaCs");
			} else throw new Exception("05; ChMan,aWstaCs");
		} else throw new Exception("04; ChMan,aWstaCs");
	}
	
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pProList
	 * @throws Exception
	 */
	public void addProListToCharacter(int pID, List pProList) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (pProList != null) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.addPros(pProList);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("04; ChMan,aPLtC");
		} else throw new Exception("02; ChMan,aPLtC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pSpecialCraftList
	 * @throws Exception
	 */
	public void addSpecialCraftListToCharacter(int pID, List pSpecialCraftList) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (pSpecialCraftList != null) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.addSpecialCrafts(pSpecialCraftList);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("04; ChMan,aSCLtC");
		} else throw new Exception("02; ChMan,aSCLtC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pTalentList
	 * @throws Exception
	 */
	public void addTalentListToCharacter(int pID, List pTalentList) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (pTalentList != null) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.addSpecialCrafts(pTalentList);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("04; ChMan,aTLtC");
		} else throw new Exception("02; ChMan,aTLtC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pWeaponList
	 * @throws Exception
	 */
	public void addWeaponListToCharacter(int pID, List pWeaponList) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (pWeaponList != null) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.addWeapons(pWeaponList);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("04; ChMan,aWLtC");
		} else throw new Exception("02; ChMan,aWLtC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pProList
	 * @throws Exception
	 */
	public void addProListToCharacters(List pIDList, List pProList) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) addProListToCharacter((int)vCurID, pProList);
					else throw new Exception("06; ChMan,aPLtCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,aPLtCs");
		} else throw new Exception("04; ChMan,aPLtCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pSpecialCraftList
	 * @throws Exception
	 */
	public void addSpecialCraftListToCharacters(List pIDList, List pSpecialCraftList) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) addSpecialCraftListToCharacter((int)vCurID, pSpecialCraftList);
					else throw new Exception("06; ChMan,aSCLtCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,aSCLtCs");
		} else throw new Exception("04; ChMan,aSCLtCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pTalentList
	 * @throws Exception
	 */
	public void addTalentListToCharacters(List pIDList, List pTalentList) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) addTalentListToCharacter((int)vCurID, pTalentList);
					else throw new Exception("06; ChMan,aTLtCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,aTLtCs");
		} else throw new Exception("04; ChMan,aTLtCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pWeaponList
	 * @throws Exception
	 */
	public void addWeaponListToCharacters(List pIDList, List pWeaponList) throws Exception{
		Object vCurID;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCurID = pIDList.getCurrent();
					
					if (vCurID instanceof Integer) addWeaponListToCharacter((int)vCurID, pWeaponList);
					else throw new Exception("06; ChMan,aWLtCs");
					
					pIDList.next();
				}
			} else throw new Exception("05; ChMan,aWLtCs");
		} else throw new Exception("04; ChMan,aWLtCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pProListList
	 * @throws Exception
	 */
	public void addProListsToCharacters(List pIDList, List pProListList) throws Exception{
		Object vCurID, vCurProList;
		
		if ((pIDList != null) && (pProListList != null)) {
			if (!pIDList.isEmpty() && !pProListList.isEmpty()) {
				if (pIDList.getContentNumber() == pProListList.getContentNumber()) {
					pIDList.toFirst();
					pProListList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurProList = pProListList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurProList instanceof List)) addProListToCharacter((int)vCurID, (List)vCurProList);
						else throw new Exception("06; ChMan,aPLstCs");
						
						pIDList.next();
						pProListList.next();
					}
				} else throw new Exception("01; ChMan,aPLstCs");
			} else throw new Exception("05; ChMan,aPLstCs");
		} else throw new Exception("04; ChMan,aPLstCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pSpecialCraftListList
	 * @throws Exception
	 */
	public void addSpecialCraftListsToCharacters(List pIDList, List pSpecialCraftListList) throws Exception{
		Object vCurID, vCurSpecialCraftList;
		
		if ((pIDList != null) && (pSpecialCraftListList != null)) {
			if (!pIDList.isEmpty() && !pSpecialCraftListList.isEmpty()) {
				if (pIDList.getContentNumber() == pSpecialCraftListList.getContentNumber()) {
					pIDList.toFirst();
					pSpecialCraftListList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurSpecialCraftList = pSpecialCraftListList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurSpecialCraftList instanceof List)) addSpecialCraftListToCharacter((int)vCurID, (List)vCurSpecialCraftList);
						else throw new Exception("06; ChMan,aSCLstCs");
						
						pIDList.next();
						pSpecialCraftListList.next();
					}
				} else throw new Exception("01; ChMan,aSCLstCs");
			} else throw new Exception("05; ChMan,aSCLstCs");
		} else throw new Exception("04; ChMan,aSCLstCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pTalentListList
	 * @throws Exception
	 */
	public void addTalentListsToCharacters(List pIDList, List pTalentListList) throws Exception{
		Object vCurID, vCurTalentList;
		
		if ((pIDList != null) && (pTalentListList != null)) {
			if (!pIDList.isEmpty() && !pTalentListList.isEmpty()) {
				if (pIDList.getContentNumber() == pTalentListList.getContentNumber()) {
					pIDList.toFirst();
					pTalentListList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurTalentList = pTalentListList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurTalentList instanceof List)) addTalentListToCharacter((int)vCurID, (List)vCurTalentList);
						else throw new Exception("06; ChMan,aTLstCs");
						
						pIDList.next();
						pTalentListList.next();
					}
				} else throw new Exception("01; ChMan,aTLstCs");
			} else throw new Exception("05; ChMan,aTLstCs");
		} else throw new Exception("04; ChMan,aTLstCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pIDList
	 * @param pWeaponListList
	 * @throws Exception
	 */
	public void addWeaponListsToCharacters(List pIDList, List pWeaponListList) throws Exception{
		Object vCurID, vCurWeaponList;
		
		if ((pIDList != null) && (pWeaponListList != null)) {
			if (!pIDList.isEmpty() && !pWeaponListList.isEmpty()) {
				if (pIDList.getContentNumber() == pWeaponListList.getContentNumber()) {
					pIDList.toFirst();
					pWeaponListList.toFirst();
					
					while(!pIDList.isEnd()) {
						vCurID = pIDList.getCurrent();
						vCurWeaponList = pWeaponListList.getCurrent();
						
						if ((vCurID instanceof Integer) && (vCurWeaponList instanceof List)) addWeaponListToCharacter((int)vCurID, (List)vCurWeaponList);
						else throw new Exception("06; ChMan,aWLstCs");
						
						pIDList.next();
						pWeaponListList.next();
					}
				} else throw new Exception("01; ChMan,aWLstCs");
			} else throw new Exception("05; ChMan,aWLstCs");
		} else throw new Exception("04; ChMan,aWLstCs");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pProListList
	 * @throws Exception
	 */
	public void addProListsToAllCharacters(List pProListList) throws Exception{
		Object vCurProList;
		int vCurID;
		
		if (pProListList != null) {
			if (!characterList.isEmpty() && !pProListList.isEmpty()) {
				if (characterList.getContentNumber() == pProListList.getContentNumber()) {
					characterList.toFirst();
					pProListList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurProList = pProListList.getCurrent();
						
						if (vCurProList instanceof List) addProListToCharacter(vCurID, (List)vCurProList);
						else throw new Exception("06; ChMan,aPLstaCs");
						
						characterList.next();
						pProListList.next();
					}
				} else throw new Exception("01; ChMan,aPLstaCs");
			} else throw new Exception("05; ChMan,aPLstaCs");
		} else throw new Exception("04; ChMan,aPLstaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pSpecialCraftListList
	 * @throws Exception
	 */
	public void addSpecialCraftListsToAllCharacters(List pSpecialCraftListList) throws Exception{
		Object vCurSpecialCraftList;
		int vCurID;
		
		if (pSpecialCraftListList != null) {
			if (!characterList.isEmpty() && !pSpecialCraftListList.isEmpty()) {
				if (characterList.getContentNumber() == pSpecialCraftListList.getContentNumber()) {
					characterList.toFirst();
					pSpecialCraftListList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurSpecialCraftList = pSpecialCraftListList.getCurrent();
						
						if (vCurSpecialCraftList instanceof List) addSpecialCraftListToCharacter(vCurID, (List)vCurSpecialCraftList);
						else throw new Exception("06; ChMan,aSCLstaCs");
						
						characterList.next();
						pSpecialCraftListList.next();
					}
				} else throw new Exception("01; ChMan,aSCLstaCs");
			} else throw new Exception("05; ChMan,aSCLstaCs");
		} else throw new Exception("04; ChMan,aSCLstaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pTalentListList
	 * @throws Exception
	 */
	public void addTalentListsToAllCharacters(List pTalentListList) throws Exception{
		Object vCurTalentList;
		int vCurID;
		
		if (pTalentListList != null) {
			if (!characterList.isEmpty() && !pTalentListList.isEmpty()) {
				if (characterList.getContentNumber() == pTalentListList.getContentNumber()) {
					characterList.toFirst();
					pTalentListList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurTalentList = pTalentListList.getCurrent();
						
						if (vCurTalentList instanceof List) addTalentListToCharacter(vCurID, (List)vCurTalentList);
						else throw new Exception("06; ChMan,aTLstaCs");
						
						characterList.next();
						pTalentListList.next();
					}
				} else throw new Exception("01; ChMan,aTLstaCs");
			} else throw new Exception("05; ChMan,aTLstaCs");
		} else throw new Exception("04; ChMan,aTLstaCs");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pWeaponListList
	 * @throws Exception
	 */
	public void addWeaponListsToAllCharacters(List pWeaponListList) throws Exception{
		Object vCurWeaponList;
		int vCurID;
		
		if (pWeaponListList != null) {
			if (!characterList.isEmpty() && !pWeaponListList.isEmpty()) {
				if (characterList.getContentNumber() == pWeaponListList.getContentNumber()) {
					characterList.toFirst();
					pWeaponListList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurID = (int)characterList.getCurrent();
						vCurWeaponList = pWeaponListList.getCurrent();
						
						if (vCurWeaponList instanceof List) addWeaponListToCharacter(vCurID, (List)vCurWeaponList);
						else throw new Exception("06; ChMan,aWLstaCs");
						
						characterList.next();
						pWeaponListList.next();
					}
				} else throw new Exception("01; ChMan,aWLstaCs");
			} else throw new Exception("05; ChMan,aWLstaCs");
		} else throw new Exception("04; ChMan,aWLstaCs");
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	23.6.2020
	 * 
	 * @param pChar
	 * @throws Exception
	 */
	public void removeCharacter(Charakter pChar) throws Exception{
		Charakter vCur;
		
		if (pChar != null) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter) characterList.getCurrent();
					
					if (pChar.equals(vCur)) {
						characterList.remove();
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("04; ChMan,rC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	public void removeCharacter(int pID) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter) characterList.getCurrent();
					
					if (vCur.getId() == pID) {
						characterList.remove();
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,rC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pList
	 * @throws Exception
	 */
	public void removeCharacters(List pList) throws Exception{
		Object vCurObj;
		Charakter vCurChar;
		
		if (pList != null) {
			if (!pList.isEmpty()) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCurChar = (Charakter) characterList.getCurrent();
						pList.toFirst();
						
						while(!pList.isEnd()) {
							vCurObj = pList.getCurrent();
							
							if (vCurObj instanceof Charakter) {
								if (((Charakter)vCurObj).equals(vCurChar)) {
									characterList.remove();
									characterList.toLast();
									pList.toLast();
								}
							} else if (vCurObj instanceof Integer) {
								if (vCurChar.getId() == ((int)vCurObj)) {
									characterList.remove();
									characterList.toLast();
									pList.toLast();
								}
							} else throw new Exception("06; ChMan,rC");
									
							pList.next();
						}
						
						characterList.next();
					}
				}
			}
		} else throw new Exception("04; ChMan,rC");
	}
	/**	Dh	23.6.2020
	 * 
	 */
	public void removeAllCharacters() {
		characterList = new List();
	}
	
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pPro
	 * @throws Exception
	 */
	public void removeProOfCharacter(int pID, Pro pPro) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (pPro != null) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.removePro(pPro);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("04; ChMan,rPtC");
		} else throw new Exception("02; ChMan,rPtC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pCharID
	 * @param pProID
	 * @throws Exception
	 */
	public void removeProOfCharacter(int pCharID, int pProID) throws Exception{
		Charakter vCur;
		
		if ((pCharID >= 0) && (pProID >= 0)) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
						
					if (vCur.getId() == pCharID) {
						vCur.removePro(pProID);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,rPtC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pSpecialCraft
	 * @throws Exception
	 */
	public void removeSpecialCraftOfCharacter(int pID, SpecialCraft pSpecialCraft) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (pSpecialCraft != null) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.removeSpecialCraft(pSpecialCraft);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("04; ChMan,rSCtC");
		} else throw new Exception("02; ChMan,rSCtC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pCharID
	 * @param pSpecialCraftID
	 * @throws Exception
	 */
	public void removeSpecialCraftOfCharacter(int pCharID, int pSpecialCraftID) throws Exception{
		Charakter vCur;
		
		if ((pCharID >= 0) && (pSpecialCraftID >= 0)) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
						
					if (vCur.getId() == pCharID) {
						vCur.removeSpecialCraft(pSpecialCraftID);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,rSCtC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pTalent
	 * @throws Exception
	 */
	public void removeTalentOfCharacter(int pID, Talent pTalent) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (pTalent != null) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.removeTalent(pTalent);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("04; ChMan,rTtC");
		} else throw new Exception("02; ChMan,rTtC");
	}
	/**	Dh	23.6.2020
	 * 
	 * @param pCharID
	 * @param pTalentID
	 * @throws Exception
	 */
	public void removeTalentOfCharacter(int pCharID, int pTalentID) throws Exception{
		Charakter vCur;
		
		if ((pCharID >= 0) && (pTalentID >= 0)) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
						
					if (vCur.getId() == pCharID) {
						vCur.removeTalent(pTalentID);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,rTtC");
	}
	//-----
	/**	Dh	23.6.2020
	 * 
	 * @param pID
	 * @param pWeapon
	 * @throws Exception
	 */
	public void removeWeaponOfCharacter(int pID, Weapon pWeapon) throws Exception{
		Charakter vCur;
		
		if (pID >= 0) {
			if (pWeapon != null) {
				if (!characterList.isEmpty()) {
					characterList.toFirst();
					
					while(!characterList.isEnd()) {
						vCur = (Charakter)characterList.getCurrent();
						
						if (vCur.getId() == pID) {
							vCur.removeWeapon(pWeapon);
							characterList.toLast();
						}
						
						characterList.next();
					}
				}
			} else throw new Exception("04; ChMan,rWtC");
		} else throw new Exception("02; ChMan,rWtC");
	}
	/**	Dh	11.7.2020
	 * 
	 * @param pCharID
	 * @param pWeaponID
	 * @throws Exception
	 */
	public void removeWeaponOfCharacter(int pCharID, int pWeaponID) throws Exception{
		Charakter vCur;
		
		if ((pCharID >= 0) && (pWeaponID >= 0)) {
			if (!characterList.isEmpty()) {
				characterList.toFirst();
				
				while(!characterList.isEnd()) {
					vCur = (Charakter)characterList.getCurrent();
						
					if (vCur.getId() == pCharID) {
						vCur.removeWeapon(pWeaponID);
						characterList.toLast();
					}
					
					characterList.next();
				}
			}
		} else throw new Exception("02; ChMan,rWtC");
	}
	
//--------------------------------------------------------------------------------------------------------
}
