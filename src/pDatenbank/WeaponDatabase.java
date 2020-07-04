/**	DSA_App v0.0	Dh 3.7.2020
 * 
 * 	Datenbank
 * 	  WeaponDatabase
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
import pLogik.Pro;
import pLogik.RangeWeapon;
import pLogik.Weapon;

@XmlRootElement(name="weapons")
@XmlSeeAlso(Weapon.class)
public class WeaponDatabase {
	private List WeaponList;
	
	/**	Dh	4.6.2020
	 * 
	 */
	public WeaponDatabase() {
		WeaponList = new List();
	}
	/**	Dh	4.6.2020
	 * 
	 * @param pWeaponList
	 */
	public WeaponDatabase(List pWeaponList) {
		WeaponList = new List();
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
		
		if ((pID >= 0) && (pID < WeaponList.getContentNumber())) {
			WeaponList.toFirst();
			
			while(!WeaponList.isEnd() && (vRet == null)) {
				if (((Weapon)WeaponList.getCurrent()).getID() == pID) vRet = copyWeapon((Weapon)WeaponList.getCurrent());
				
				WeaponList.next();
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
			if (!WeaponList.isEmpty()) {
				WeaponList.toFirst();
				
				while (!WeaponList.isEnd()) {
					vRet = (Weapon) WeaponList.getCurrent();
					
					if (vRet.getName().equals(pName)) WeaponList.toLast();
					else vRet = null;
					
					WeaponList.next();
				}
			}
			if (vRet == null) throw new Exception("02; WeDat,gW; "+pName);
			else vRet = copyWeapon(vRet);
		}else throw new Exception("02; WeDat,gW");
		
		return vRet;
	}
	
	/**	Dh	4.6.2020
	 * 
	 * @return
	 */
	@XmlElement(name = "WeaponList")
	public List getWeaponList() {
		return WeaponList.copyList();
	}
	
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
				
				if (containsOnlyWeapons == true) WeaponList = pWeaponList;
				else throw new Exception("06; WeDat,sWL");
			} else WeaponList = pWeaponList;
		} else throw new Exception("04; WeDat,sWL");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	4.6.2020
	 * 
	 * @param pWeapon
	 * @throws Exception
	 */
	protected void addWeapon(Weapon pWeapon) throws Exception {
		if (pWeapon != null) {
			pWeapon.setID(WeaponList.getContentNumber());
			WeaponList.append(pWeapon);
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
		if ((pID >= 0) && (pID < WeaponList.getContentNumber())) {
			WeaponList.toFirst();
			
			while(!WeaponList.isEnd()) {
				if (((Weapon)WeaponList.getCurrent()).getID() == pID) {
					WeaponList.remove();
					WeaponList.toLast();
				}
				
				WeaponList.next();
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
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	4.6.2020
	 * 
	 * @param pWeapon
	 * @return
	 */
	private Weapon copyWeapon(Weapon pWeapon) {
		Weapon vRet = null;
		
		try {
			if (pWeapon instanceof CloseWeapon) vRet = new CloseWeapon();
			if (pWeapon instanceof RangeWeapon) vRet = new RangeWeapon();
			
			vRet.setID(pWeapon.getID());
			vRet.setWeaponType(pWeapon.getWeaponType());
			vRet.setName(pWeapon.getName());
			vRet.setTP(pWeapon.getTP().clone());
			vRet.setTPKK(pWeapon.getTPKK().clone());
			vRet.setArkan(pWeapon.isArkan());
			vRet.setHoly(pWeapon.isHoly());
			vRet.setUnholy(pWeapon.isUnholy());
			
			if (vRet instanceof CloseWeapon) {
				((CloseWeapon) vRet).setBF(((CloseWeapon)pWeapon).getBF());
				((CloseWeapon) vRet).setIniMod(((CloseWeapon)pWeapon).getIniMod());
				((CloseWeapon) vRet).setWM(((CloseWeapon)pWeapon).getWM().clone());
				((CloseWeapon) vRet).setBrawlRange(((CloseWeapon)pWeapon).isBrwalRange());
				((CloseWeapon) vRet).setCloseRange(((CloseWeapon)pWeapon).isCloseRange());
				((CloseWeapon) vRet).setPikeRange(((CloseWeapon)pWeapon).isPikeRange());
				((CloseWeapon) vRet).setSpearRange(((CloseWeapon)pWeapon).isSpearRange());
			}
			if (vRet instanceof RangeWeapon) {
				((RangeWeapon) vRet).setLoadTime(((RangeWeapon)pWeapon).getLoadTime());
				((RangeWeapon) vRet).setRanges(((RangeWeapon)pWeapon).getRanges().clone());
				((RangeWeapon) vRet).setTPRangeMods(((RangeWeapon)pWeapon).getTPRangeMods().clone());
			}
		} catch(Exception ex) {System.out.println(ex.getMessage());}
		
		return vRet;
	}

}
