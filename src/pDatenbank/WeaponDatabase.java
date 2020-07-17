/**	DSA_App v0.0	Dh 16.7.2020
 * 
 * 	Datenbank
 * 	  WeaponDatabase
 * 
 * 	UsedType:
 * 	  0: Natuerlich		 3: Linkhand
 * 	  1: Haupthand		 4: Schild
 * 	  2: Nebenhand
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
 */
package pDatenbank;

import java.util.*;
import javax.xml.bind.annotation.*;

import pDataStructures.List;
import pLogik.CloseWeapon;
import pLogik.DefenceWeapon;
import pLogik.Pro;
import pLogik.RangeWeapon;
import pLogik.Weapon;

@XmlRootElement(name="weapons")
@XmlSeeAlso(Weapon.class)
public class WeaponDatabase {
	private List weaponList;
	private String[] weaponTypes, damageTypes;
	private String[] weaponUseTypes = new String[] {"Natürlich", "Haupthand", "Nebenhand", "Linkhand", "Schild"};
	
	/**	Dh	16.7.2020
	 * 
	 */
	public WeaponDatabase() {
		weaponList = new List();
		weaponTypes = new String[] {};
		damageTypes = new String[] {};
	}
	/**	Dh	16.7.2020
	 * 
	 * pWeaponType:
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
	 * @param pWeaponList
	 */
	public WeaponDatabase(List pWeaponList, String[] pWeaponTypes, String[] pDamageTypes) {
		weaponList = new List();
		weaponTypes = pWeaponTypes;
		damageTypes = pDamageTypes;
		try{setWeaponList(pWeaponList);}
		catch(Exception ex) {System.out.println(ex);}
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	4.6.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	protected Weapon getWeapon(int pID) throws Exception {
		Weapon vRet = null;
		
		if ((pID >= 0) && (pID < weaponList.getContentNumber())) {
			weaponList.toFirst();
			
			while(!weaponList.isEnd() && (vRet == null)) {
				if (((Weapon)weaponList.getCurrent()).getId() == pID) vRet = copyWeapon((Weapon)weaponList.getCurrent());
				
				weaponList.next();
			}
		}else throw new Exception("02; WeDat,gW");
		
		return vRet;
	}
	/**	Dh	3.7.2020
	 * 
	 * @param pName
	 * @return
	 * @throws Exception
	 */
	protected Weapon getWeapon(String pName) throws Exception{
		Weapon vRet = null;
		
		if (pName != "") {
			if (!weaponList.isEmpty()) {
				weaponList.toFirst();
				
				while (!weaponList.isEnd()) {
					vRet = (Weapon) weaponList.getCurrent();
					
					if (vRet.getName().equals(pName)) weaponList.toLast();
					else vRet = null;
					
					weaponList.next();
				}
			}
			if (vRet == null) throw new Exception("02; WeDat,gW; "+pName);
			else vRet = copyWeapon(vRet);
		}else throw new Exception("02; WeDat,gW");
		
		return vRet;
	}
	//-----
	/**	Dh	9.7.2020
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	protected String getWeaponType(int pID) throws Exception{
		String vRet = "";
		
		if ((pID >= 0) && (pID < weaponTypes.length)) {
			vRet = weaponTypes[pID];
		} else throw new Exception("02; WeDat,gWT");
		
		return vRet;
	}
	/**	Dh	9.7.2020
	 * 
	 * @param pName
	 * @return
	 * @throws Exception
	 */
	protected int getWeaponTypeID(String pName) throws Exception{
		int vRet = -1;
		
		if (pName != null) {
			if (!pName.equals("")) {
				for (int i=0; (i < weaponTypes.length) && (vRet == -1); i++) {
					if (weaponTypes[i].equals(pName)) vRet = i;
				}
			} else throw new Exception("02; WeDat,gWTID");
		} else throw new Exception("04; WeDat,gWTID");
		
		return vRet;
	}
	//-----
	/**	Dh	16.7.2020
	 * 
	 * @param pID
	 * @return
	 * @throws Exception
	 */
	protected String getDamageType(int pID) throws Exception{
		if ((pID >= 0) && (pID < damageTypes.length)) return damageTypes[pID];
		else throw new Exception("02; WeDat,gDT");
	}
	/**	Dh	16.7.2020
	 * 
	 * @param pName
	 * @return
	 * @throws Exception
	 */
	protected int getDamageTypeID(String pName) throws Exception{
		int vRet = -1;
		
		if (pName != null) {
			if (!pName.equals("")) {
				for (int i=0; (i < damageTypes.length) && (vRet == -1); i++) {
					if (damageTypes[i].equals(pName)) vRet = i;
				}
			} else throw new Exception("02; WeDat,gDTID");
		} else throw new Exception("04; WeDat,gDTID");
		
		return vRet;
	}
	
	/**	Dh	16.7.2020
	 * 
	 * @param pIDs
	 * @return
	 * @throws Exception
	 */
	protected String[] getDamageTypes(int[] pIDs) throws Exception{
		String[] vRet = null;
		
		if (pIDs != null) {
			vRet = new String[pIDs.length];
			
			for (int i=0; i<pIDs.length; i++) {
				vRet[i] = getDamageType(pIDs[i]);
			}
		} else throw new Exception("04; WeDat,gDTs"); 
		
		return vRet;
	}
	/**	Dh	16.7.2020
	 * 
	 * @param pNames
	 * @return
	 * @throws Exception
	 */
	protected int[] getDamageTypesID(String[] pNames) throws Exception{
		int[] vRet = null;
		
		if (pNames != null) {
			vRet = new int[pNames.length];
			
			for (int i=0; i<pNames.length; i++) {
				vRet[i] = getDamageTypeID(pNames[i]);
			}
		} else throw new Exception("04; WeDat,gDTsID"); 
		
		return vRet;
	}
	
	/**	Dh	4.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "WeaponList")
	public List getWeaponList() {
		return weaponList.copyList();
	}
	/**	Dh	9.7.2020
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "WeaponTypeArray")
	@XmlElement(name = "WeaponType")
	public String[] getWeaponTypes() {
		return weaponTypes;
	}
	/**	Dh	16.7.2020
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "DamageTypeArray")
	@XmlElement(name = "DamageType")
	public String[] getDamageTypes() {
		return damageTypes;
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
	public String getWeaponUseType(int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < weaponUseTypes.length)) return weaponUseTypes[pInd];
		else throw new Exception("02; WaDat,gWUT");
	}
	/**	Dh	15.7.2020
	 * 
	 * 	UsedType:
	 * 	  0: Natuerlich		 3: Linkhand
	 * 	  1: Haupthand		 4: Schild
	 * 	  2: Nebenhand
	 * 
	 * @return
	 */
	public String[] getWeaponUseTypes() {
		return weaponUseTypes;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	9.6.2020
	 * 
	 * @param pWeaponList
	 * @throws Exception
	 */
	public void setWeaponList(List pWeaponList) throws Exception{
		Object vCur;
		boolean containsOnlyWeapons = true;
		
		if (pWeaponList != null) {
			if (!pWeaponList.isEmpty()) {
				pWeaponList.toFirst();
				
				while (!pWeaponList.isEnd() && (containsOnlyWeapons == true)) {
					vCur = pWeaponList.getCurrent();
					
					if (!(vCur instanceof Weapon)) containsOnlyWeapons = false;
					
					pWeaponList.next();
				}
				
				if (containsOnlyWeapons == true) weaponList = pWeaponList;
				else throw new Exception("06; WeDat,sWL");
			} else weaponList = pWeaponList;
		} else throw new Exception("04; WeDat,sWL");
	}
	/**	Dh	9.7.2020
	 * 
	 * @param pWeaponTypes
	 */
	public void setWeaponTypes(String[] pWeaponTypes){
		weaponTypes = pWeaponTypes;
	}
	/**	Dh	16.7.2020
	 * 
	 * @param pDamageTypes
	 */
	public void setDamageTypes(String[] pDamageTypes) {
		damageTypes = pDamageTypes;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	4.6.2020
	 * 
	 * @param pWeapon
	 * @throws Exception
	 */
	protected void addWeapon(Weapon pWeapon) throws Exception {
		if (pWeapon != null) {
			pWeapon.setId(weaponList.getContentNumber());
			weaponList.append(pWeapon);
		}else throw new Exception("04; WeDat,aW");
	}
	/**	Dh	4.6.2020
	 * 
	 * @param pWeapons
	 * @throws Exception
	 */
	protected void addWeapons(List pWeapons) throws Exception{
		Object vCur;
		
		if (pWeapons != null) {
			if (!pWeapons.isEmpty()) {
				pWeapons.toFirst();
				
				while(!pWeapons.isEnd()) {
					vCur = pWeapons.getCurrent();
					
					if (vCur instanceof Weapon) addWeapon((Weapon) vCur);
					else throw new Exception("06; WaDat,aWs");
					
					pWeapons.next();
				}
			}throw new Exception("05; WaDat,aWs");
		}throw new Exception("04; WaDat,aWs");
	}
	
	/**	Dh	4.6.2020
	 * 
	 * @param pID
	 * @throws Exception
	 */
	protected void removeWeapon(int pID) throws Exception{
		if ((pID >= 0) && (pID < weaponList.getContentNumber())) {
			weaponList.toFirst();
			
			while(!weaponList.isEnd()) {
				if (((Weapon)weaponList.getCurrent()).getId() == pID) {
					weaponList.remove();
					weaponList.toLast();
				}
				
				weaponList.next();
			}
		}else throw new Exception("02; WeDat,rW");
	}
	/**	Dh	4.6.2020
	 * 
	 * @param pIDList
	 * @throws Exception
	 */
	protected void removeWeapons(List pIDList) throws Exception{
		Object vCur;
		
		if (pIDList != null) {
			if (!pIDList.isEmpty()) {
				pIDList.toFirst();
				
				while(!pIDList.isEnd()) {
					vCur = pIDList.getCurrent();
					
					if (vCur instanceof Integer) removeWeapon((int)vCur);
					else throw new Exception("06; WaDat,rWs");
					
					pIDList.next();
				}
			} throw new Exception("05; WaDat,rWs");
		} throw new Exception("04; WaDat,rWs");
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	16.7.2002
	 * 
	 * @param pWeaponType
	 * @return
	 * @throws Exception
	 */
	protected int[] determineWeaponUseTypes(int pWeaponType) throws Exception{
		int[] vRet = null;
		
		if ((pWeaponType == 0) || (pWeaponType == 1)) vRet = new int[] {0};
		else if ((pWeaponType == 26) || (pWeaponType == 27) || (pWeaponType == 28)) vRet = new int[]{4};
		else if (pWeaponType == 29) vRet = new int[] {3};
		else if (pWeaponType == 3) vRet = new int[] {1, 2, 3};
		else if ((pWeaponType == 4) || (pWeaponType == 5) || (pWeaponType == 9) || (pWeaponType == 10) || (pWeaponType == 11)) vRet = new int[] {1, 2};
		else vRet = new int[] {1};
		
		return vRet;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	9.7.2020
	 * 
	 * @param pWeapon
	 * @return
	 */
	private Weapon copyWeapon(Weapon pWeapon) {
		Weapon vRet = null;
		
		try {
			if (pWeapon instanceof CloseWeapon) {
				if (pWeapon instanceof DefenceWeapon) vRet = new DefenceWeapon();
				else vRet = new CloseWeapon();
			}
			if (pWeapon instanceof RangeWeapon) vRet = new RangeWeapon();
			
			vRet.setId(pWeapon.getId());
			vRet.setWeaponType(pWeapon.getWeaponType());
			vRet.setName(pWeapon.getName());
			vRet.setTp(pWeapon.getTp().clone());
			vRet.setTpkk(pWeapon.getTpkk().clone());
			vRet.setArkan(pWeapon.isArkan());
			vRet.setHoly(pWeapon.isHoly());
			vRet.setUnholy(pWeapon.isUnholy());
			
			if (vRet instanceof CloseWeapon) {
				((CloseWeapon) vRet).setBf(((CloseWeapon)pWeapon).getBf());
				((CloseWeapon) vRet).setIniMod(((CloseWeapon)pWeapon).getIniMod());
				((CloseWeapon) vRet).setWm(((CloseWeapon)pWeapon).getWm().clone());
				((CloseWeapon) vRet).setBrawlRange(((CloseWeapon)pWeapon).isBrawlRange());
				((CloseWeapon) vRet).setCloseRange(((CloseWeapon)pWeapon).isCloseRange());
				((CloseWeapon) vRet).setPikeRange(((CloseWeapon)pWeapon).isPikeRange());
				((CloseWeapon) vRet).setSpearRange(((CloseWeapon)pWeapon).isSpearRange());
			}
			if (vRet instanceof RangeWeapon) {
				((RangeWeapon) vRet).setLoadTime(((RangeWeapon)pWeapon).getLoadTime());
				((RangeWeapon) vRet).setRanges(((RangeWeapon)pWeapon).getRanges().clone());
				((RangeWeapon) vRet).setTpRangeMods(((RangeWeapon)pWeapon).getTpRangeMods().clone());
			}
		} catch(Exception ex) {System.out.println(ex.getMessage());}
		
		return vRet;
	}

}
