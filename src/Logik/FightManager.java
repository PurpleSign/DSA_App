/**	DSA_App v0.0	Dh	22.2.2020
 * 
 * 	Logik
 * 	  FightManager
 * 
 * 	Exceptions:
 * 	  01 Wrong length
 * 	  02 Wrong Value
 * 	  03 Calculation Error
 * 	  04 Nullpointer Error
 * 	  05 Empty List Error
 * 	  06 Wrong Type Error
 * 	  07 Index Error
 */
package Logik;

import pDataStructures.List;

public class FightManager {
	private int zID;
	private List zlFightList, zlIniList;
	
	/**	Dh	22.2.2020
	 * 
	 * @param pID
	 */
	public FightManager(int pID){
		Exception vExc;
		
		if (pID >= 0) zID = pID;
		else vExc = new Exception("02; FiMan_a");
			
		zlFightList = new List();
		zlIniList = new List();
	}
	/**	Dh	22.2.2020
	 * 
	 * @param pID
	 * @param pFightList
	 */
	public FightManager(int pID, List pFightList){
		Exception vExc;
		
		if (pID >= 0) zID = pID;
		else vExc = new Exception("02; FiMan_b");
		
		if (pFightList != null) zlFightList = pFightList;
		else vExc = new Exception("04; FiMan_b");
			
		zlIniList = new List();
	}
	/**	Dh	22.2.2020
	 * 
	 * @param pID
	 * @param pFightList
	 * @param pIniList
	 */
	public FightManager(int pID, List pFightList , List pIniList){
		Exception vExc;
		
		if (pID >= 0) zID = pID;
		else vExc = new Exception("02; FiMan_b");
		
		if (pFightList != null) zlFightList = pFightList;
		else vExc = new Exception("04; FiMan_b");
		if (pIniList != null) zlIniList = pIniList;
		else vExc = new Exception("04; FiMan_b");
	}
	
	/**	Dh	22.2.2020
	 * 
	 * @throws Exception
	 */
	public void destroyFightManager() throws Exception{
		Exception vExc = null;
		
		if (zlFightList != null){
			while(!zlFightList.isEmpty()){
				zlFightList.toFirst();
				zlFightList.remove();
			}
			zlFightList = null;
		} else vExc = new Exception("04; FiMan,dFM");
		if (zlIniList != null) {
			while(!zlIniList.isEmpty()){
				zlIniList.toFirst();
				zlIniList.remove();
			}
			zlIniList = null;
		} else vExc = new Exception("04; FiMan,dFM");
		
		if (vExc != null) throw vExc;
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	22.2.2020
	 * 
	 * @return
	 */
	public int getID(){
		return zID;
	}
	/**	Dh	22.2.2020
	 * 
	 * @return
	 */
	public List getFightList(){
		return zlFightList;
	}
	/**	Dh	22.2.2020
	 * 
	 * @return
	 */
	public List getIniList(){
		return zlIniList;
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
			if (!zlFightList.isEmpty()){
				zlFightList.toFirst();
				while(!zlFightList.isEnd() && (vRet == null)){
					vTemp = zlFightList.getCurrent();
					
					if (vTemp instanceof FightElement){
						if (((FightElement)vTemp).getID() == pID) vRet = (FightElement)vTemp;
					} else throw new Exception("06; FiMan,gFE");
					
					zlFightList.next();
				}
			} else throw new Exception("05; FiMan,gFE");
		} else throw new Exception("02; FiMan,gFE");
		
		return vRet;
	}
	//-----
	/**	Dh	23.2.2020
	 * 
	 * 	pEigenMod: 
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
	
	/**	Dh	23.2.2020
	 * 
	 * 	pEigenMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Gibt die EigenschaftsModifikatoren fuer den*die gewaehlte*N Kaempfer*In(pID).
	 * 
	 * @param pID
	 * @param pEigenMods
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
	public double[] getStatModsOfFighter(int pID) throws Exception{
		try{ return getFightElement(pID).getStatMods();}
		catch(Exception vExc) { throw vExc;}
	}

	/**	Dh	23.2.2020
	 * 
	 * 	pEigenMod: 
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
	public int[] getPropModToFighters(int pInd) throws Exception{
		Object vFiEle;
		int[] vRet;
		
		if ((pInd >= 0) && (pInd < 10)){
			if (!zlFightList.isEmpty()){
				vRet = new int[zlFightList.getContentNumber()];
				
				zlFightList.toFirst();
				for (int i=0; i<vRet.length; i++){
					vFiEle = zlFightList.getCurrent();
				
					if (vFiEle instanceof FightElement) vRet[i] = ((FightElement) vFiEle).getPropMod(pInd);
					else throw new Exception("06; FiMan,gPMFs");
				
					zlFightList.next();
				}
			} else throw new Exception("05; FiMan,gPMFs");
		} else throw new Exception("07; FiMan,gPMFs");
		
		return vRet;
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
	 * 	Gibt den gewaehlten StatusModifikator fuer die Kaempfer*Innen als ein Array zurueck.
	 * 
	 * @param pInd
	 * @return
	 * @throws Exception
	 */
	public double[] getStatModToFighters(int pInd) throws Exception{
		Object vFiEle;
		double[] vRet;
		
		if ((pInd >= 0) && (pInd < 10)){
			if (!zlFightList.isEmpty()){
				vRet = new double[zlFightList.getContentNumber()];
				
				zlFightList.toFirst();
				for (int i=0; i<vRet.length; i++){
					vFiEle = zlFightList.getCurrent();
				
					if (vFiEle instanceof FightElement) vRet[i] = ((FightElement) vFiEle).getStatMod(pInd);
					else throw new Exception("06; FiMan,gSMFs");
				
					zlFightList.next();
				}
			} else throw new Exception("05; FiMan,gSMFs");
		} else throw new Exception("07; FiMan,gSMFs");
		
		return vRet;
	}
	
	/**	Dh	23.2.2020
	 * 
	 * 	pEigenMod: 
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
	public int[][] getPropModsToFighters() throws Exception{
		Object vFiEle;
		int[][] vRet;
		
		if (!zlFightList.isEmpty()){
			vRet = new int[zlFightList.getContentNumber()][10];
				
			zlFightList.toFirst();
			for (int i=0; i<vRet.length; i++){
				vFiEle = zlFightList.getCurrent();
				
				if (vFiEle instanceof FightElement) vRet[i] = ((FightElement) vFiEle).getPropMods();
				else throw new Exception("06; FiMan,gPMsFs");
				
				zlFightList.next();
			}
		} else throw new Exception("05; FiMan,gPMsFs");
		
		return vRet;
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
	 * 	vRet[Fighter][Eigenschaft]
	 * 
	 * 	Gibt die EigenschaftsModifikatoren fuer die Kaempfer*Innen als ein Array zurueck.
	 * 
	 * @param pStatMods
	 * @return
	 * @throws Exception
	 */
	public double[][] getStatModsToFighters(double[] pStatMods) throws Exception{
		Object vFiEle;
		double[][] vRet;
		
		if (!zlFightList.isEmpty()){
			vRet = new double[zlFightList.getContentNumber()][10];
				
			zlFightList.toFirst();
			for (int i=0; i<vRet.length; i++){
				vFiEle = zlFightList.getCurrent();
				
				if (vFiEle instanceof FightElement) vRet[i] = ((FightElement) vFiEle).getStatMods();
				else throw new Exception("06; FiMan,gSMsFs");
				
				zlFightList.next();
			}
		} else throw new Exception("05; FiMan,gSMsFs");
		
		return vRet;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	23.2.2020
	 * 
	 * 	pEigenMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Setzt den gewaehlten EigenschaftsModifikator fuer den*die gewaehlte*N Kaempfer*In(pID).
	 * 
	 * @param pID
	 * @param pEigenMod
	 * @param pInd
	 * @throws Exception
	 */
	public void setPropModToFighter(int pID, int pEigenMod, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 10)){
			try{ getFightElement(pID).setPropMod(pEigenMod, pInd);}
			catch (Exception vExc) {throw vExc;}
		} else throw new Exception("07; FiMan,sPMF");
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
	 * 	Setzt den gewaehlten StatusModifikator fuer den*die gewaehlte*N Kaempfer*In(pID).
	 * 
	 * @param pID
	 * @param pStatMod
	 * @param pInd
	 * @throws Exception
	 */
	public void setStatModToFighter(int pID, double pStatMod, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 10)){
			try{ getFightElement(pID).setStatMod(pStatMod, pInd);}
			catch (Exception vExc) {throw vExc;}
		} else throw new Exception("07; FiMan,sSMF");
	}
	
	/**	Dh	23.2.2020
	 * 
	 * 	pEigenMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Setzt die EigenschaftsModifikatoren fuer den*die gewaehlte*N Kaempfer*In(pID).
	 * 
	 * @param pID
	 * @param pEigenMods
	 * @throws Exception
	 */
	public void setPropModsToFighter(int pID, int[] pEigenMods) throws Exception{
		if (pEigenMods != null){
			if (pEigenMods.length == 10){
				try{ getFightElement(pID).setPropMods(pEigenMods);}
				catch (Exception vExc) {throw vExc;}
			} else throw new Exception("01; FiMan,sPMsF");
		} else throw new Exception("04; FiMan,sPMsF");
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
	 * 	Setzt die StatusModifikatoren fuer den*die gewaehlte*N Kaempfer*In(pID).
	 * 
	 * @param pID
	 * @param pStatMods
	 * @throws Exception
	 */
	public void setStatModsToFighter(int pID, double[] pStatMods) throws Exception{
		if (pStatMods != null){
			if (pStatMods.length == 10){
				try{ getFightElement(pID).setStatMods(pStatMods);}
				catch (Exception vExc) {throw vExc;}
			} else throw new Exception("04; FiMan,sSMsF");
		} else throw new Exception("04; FiMan,sSMsF");
	}

	/**	Dh	23.2.2020
	 * 
	 * 	pEigenMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Setzt den gewaehlten EigenschaftsModifikator fuer die Kaempfer*Innen.
	 * 
	 * @param pEigenMod
	 * @param pInd
	 * @throws Exception
	 */
	public void setPropModToFighters(int pEigenMod, int pInd) throws Exception{
		Object vFiEle;
		
		if ((pInd >= 0) && (pInd < 10)){
			if (!zlFightList.isEmpty()){
				zlFightList.toFirst();
				while (!zlFightList.isEnd()){
					vFiEle = zlFightList.getCurrent();
				
					if (vFiEle instanceof FightElement) ((FightElement) vFiEle).setPropMod(pEigenMod, pInd);
					else throw new Exception("06; FiMan,sPMFs");
				
					zlFightList.next();
				}
			} else throw new Exception("05; FiMan,sPMFs");
		} else throw new Exception("07; FiMan,sPMFs");
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
	 * 	Setzt den gewaehlten StatusModifikator fuer die Kaempfer*Innen.
	 * 
	 * @param pStatMod
	 * @param pInd
	 * @throws Exception
	 */
	public void setStatModToFighters(double pStatMod, int pInd) throws Exception{
		Object vFiEle;
		
		if ((pInd >= 0) && (pInd < 10)){
			if (!zlFightList.isEmpty()){
				zlFightList.toFirst();
				while(!zlFightList.isEnd()){
					vFiEle = zlFightList.getCurrent();
				
					if (vFiEle instanceof FightElement) ((FightElement) vFiEle).setStatMod(pStatMod, pInd);
					else throw new Exception("06; FiMan,sSMFs");
				
					zlFightList.next();
				}
			} else throw new Exception("05; FiMan,sSMFs");
		} else throw new Exception("07; FiMan,sSMFs");
	}
	
	/**	Dh	23.2.2020
	 * 
	 * 	pEigenMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Setzt die EigenschaftsModifikatoren fuer die Kaempfer*Innen.
	 * 
	 * @param pEigenMods
	 * @throws Exception
	 */
	public void setPropModsToFighters(int[] pEigenMods) throws Exception{
		Object vFiEle;
		
		if (pEigenMods != null){
			if (pEigenMods.length == 10){
				if (!zlFightList.isEmpty()){
					zlFightList.toFirst();
				
					while(!zlFightList.isEnd()){
						vFiEle = zlFightList.getCurrent();
					
						if (vFiEle instanceof FightElement) ((FightElement) vFiEle).setPropMods(pEigenMods);
						else throw new Exception("06; FiMan,sPMsFs");
					
						zlFightList.next();
					}
				} else throw new Exception("05; FiMan,sPMsFs");
			} else throw new Exception("01; FiMan,sPMsFs");
		} else throw new Exception("04; FiMan,sPMsFs");
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
	 * 	Setzt die StatusModifikatoren fuer die Kaempfer*Innen.
	 * 
	 * @param pStatMods
	 * @throws Exception
	 */
	public void setStatModsToFighters(double[] pStatMods) throws Exception{
		Object vFiEle;
		
		if (pStatMods != null){
			if (pStatMods.length == 10){
				if (!zlFightList.isEmpty()){
					zlFightList.toFirst();
				
					while(!zlFightList.isEnd()){
						vFiEle = zlFightList.getCurrent();
					
						if (vFiEle instanceof FightElement) ((FightElement) vFiEle).setStatMods(pStatMods);
						else throw new Exception("06; FiMan,sSMsFs");
					
						zlFightList.next();
					}
				} else throw new Exception("05; FiMan,sSMsFs");
			} else throw new Exception("01; FiMan,sSMsFs");
		} else throw new Exception("04; FiMan,sSMsFs");
	}
	
//--------------------------------------------------------------------------------------------------------
	
	/**	Dh	23.2.2020
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
			if (!zlFightList.isEmpty()){
				zlFightList.toFirst();
				while(!zlFightList.isEnd() && (vRet == false)){
					vTemp = zlFightList.getCurrent();
					
					if (vTemp instanceof FightElement){
						if (((FightElement)vTemp).getID() == pID) vRet = true;
					} else throw new Exception("06; FiMan,hFIDL");
					
					zlFightList.next();
				}
			} else throw new Exception("05; FiMan,hFIDL");
		} else throw new Exception("02; FiMan,hFIDL");
		
		return vRet;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	23.2.2020
	 * 
	 * @param pChar
	 * @throws Exception
	 */
	public void addFighter(Charakter pChar) throws Exception{
		int vID;
		
		if (zlFightList != null) vID = zlFightList.getContentNumber();
		else throw new Exception("04; FiMan,aFi_a");
		
		if (pChar != null) zlFightList.append(new FightElement(vID, pChar));
		else throw new Exception("04; FiMan,aFi_a");
	}
	/**	Dh	23.2.2020
	 * 
	 * 	pEigenMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * @param pChar
	 * @param pEigenMod
	 * @throws Exception
	 */
	public void addFighter(Charakter pChar, int[] pEigenMod) throws Exception{
		int vID;
		
		if (zlFightList != null) vID = zlFightList.getContentNumber();
		else throw new Exception("04; FiMan,aFi_b");
		
		if ((pChar != null) && (pEigenMod != null)){
			if (pEigenMod.length == 10) zlFightList.append(new FightElement(vID, pChar, pEigenMod));
			else throw new Exception("01; FiMan,aFi_b");
		} else throw new Exception("04; FiMan,aFi_b");
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
	 * @param pChar
	 * @param pStatiMod
	 * @throws Exception
	 */
	public void addFighter(Charakter pChar, double[] pStatiMod) throws Exception{
		int vID;
		
		if (zlFightList != null) vID = zlFightList.getContentNumber();
		else throw new Exception("04; FiMan,aFi_c");
		
		if ((pChar != null) && (pStatiMod != null)){
			if (pStatiMod.length == 10) zlFightList.append(new FightElement(vID, pChar, pStatiMod));
			else throw new Exception("01; FiMan,aFi_c");
		} else throw new Exception("04; FiMan,aFi_c");
	}
	/**	Dh	23.2.2020
	 * 
	 * @param pChar
	 * @param pNeighbours
	 * @throws Exception
	 */
	public void addFighter(Charakter pChar, List pNeighbours) throws Exception{
		int vID;
		
		if (zlFightList != null) vID = zlFightList.getContentNumber();
		else throw new Exception("04; FiMan,aFi_d");
		
		if ((pChar != null) && (pNeighbours != null))zlFightList.append(new FightElement(vID, pChar, pNeighbours));
		else throw new Exception("04; FiMan,aFi_d");
	}
	/**	Dh	23.2.2020
	 * 
	 * 	pEigenMod: 
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
	 * @param pEigenMod
	 * @param pStatiMod
	 * @throws Exception
	 */
	public void addFighter(Charakter pChar, int[] pEigenMod, double[] pStatiMod) throws Exception{
		int vID;
		
		if (zlFightList != null) vID = zlFightList.getContentNumber();
		else throw new Exception("04; FiMan,aFi_e");
		
		if ((pChar != null) && (pEigenMod != null) && (pStatiMod != null)){
			if ((pEigenMod.length == 10) && (pStatiMod.length == 10)) zlFightList.append(new FightElement(vID, pChar, pEigenMod, pStatiMod));
			else throw new Exception("01; FiMan,aFi_e");
		} else throw new Exception("04; FiMan,aFi_e");
	}
	/**	Dh	23.2.2020
	 * 
	 * 	pEigenMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * @param pChar
	 * @param pEigenMod
	 * @param pNeighbours
	 * @throws Exception
	 */
	public void addFighter(Charakter pChar, int[] pEigenMod, List pNeighbours) throws Exception{
		int vID;
		
		if (zlFightList != null) vID = zlFightList.getContentNumber();
		else throw new Exception("04; FiMan,aFi_f");
		
		if ((pChar != null) && (pEigenMod != null) && (pNeighbours != null)){
			if (pEigenMod.length == 10) zlFightList.append(new FightElement(vID, pChar, pEigenMod, pNeighbours));
			else throw new Exception("01; FiMan,aFi_f");
		} else throw new Exception("04; FiMan,aFi_f");
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
	 * @param pChar
	 * @param pStatiMod
	 * @param pNeighbours
	 * @throws Exception
	 */
	public void addFighter(Charakter pChar, double[] pStatiMod, List pNeighbours) throws Exception{
		int vID;
		
		if (zlFightList != null) vID = zlFightList.getContentNumber();
		else throw new Exception("04; FiMan,aFi_g");
		
		if ((pChar != null) && (pStatiMod != null) && (pNeighbours != null)){
			if (pStatiMod.length == 10) zlFightList.append(new FightElement(vID, pChar, pStatiMod, pNeighbours));
			else throw new Exception("01; FiMan,aFi_g");
		} else throw new Exception("04; FiMan,aFi_g");
	}
	/**	Dh	23.2.2020
	 * 
	 * 	pEigenMod: 
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
	 * @param pEigenMod
	 * @param pStatiMod
	 * @param pNeighbours
	 * @throws Exception
	 */
	public void addFighter(Charakter pChar, int[] pEigenMod, double[] pStatiMod, List pNeighbours) throws Exception{
		int vID;
		
		if (zlFightList != null) vID = zlFightList.getContentNumber();
		else throw new Exception("04; FiMan,aFi_h");
		
		if ((pChar != null) && (pEigenMod != null) && (pStatiMod != null) && (pNeighbours != null)){
			if ((pEigenMod.length == 10) && (pStatiMod.length == 10)) zlFightList.append(new FightElement(vID, pChar, pEigenMod, pStatiMod, pNeighbours));
			else throw new Exception("01; FiMan,aFi_h");
		} else throw new Exception("04; FiMan,aFi_h");
	}
	//-----
	/**	Dh	23.2.2020
	 * 
	 * 	pEigenMod: 
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
	 * @param pEigenMod
	 * @throws Exception
	 */
	public void addPropModToFighter(int pID, int pEigenMod, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 10)){
			try{ getFightElement(pID).addPropMod(pEigenMod, pInd);}
			catch (Exception vExc) {throw vExc;}
		} else throw new Exception("07; FiMan,aPMF");
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
	 * 	Fuegt dem ausgewaehltem Fighter (pID) die ausgewaehlte (pInd) StatusModifikation hinzu.
	 * 
	 * @param pID
	 * @param pInd
	 * @param pStatMod
	 * @throws Exception
	 */
	public void addStatModToFighter(int pID, double pStatMod, int pInd) throws Exception{
		if ((pInd >= 0) && (pInd < 10)){
			try{ getFightElement(pID).addStatMod(pStatMod, pInd);}
			catch (Exception vExc) {throw vExc;}
		} else throw new Exception("07; FiMan,aSMF");
	}
	
	/**	Dh	23.2.2020
	 * 
	 * 	pEigenMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Fuegt dem ausgewaehltem Fighter (pID) die entsprechenden EigenschaftsModifikatoren hinzu.
	 * 
	 * @param pID
	 * @param pEigenMods
	 * @throws Exception
	 */
	public void addPropModsToFighter(int pID, int[] pEigenMods) throws Exception{
		if (pEigenMods != null){
			if (pEigenMods.length == 10){
				try{ getFightElement(pID).addPropMods(pEigenMods);}
				catch (Exception vExc) {throw vExc;}
			} else throw new Exception("01; FiMan,aPMsF");
		} else throw new Exception("04; FiMan,aPMsF");
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
	 * 	Fuegt dem ausgewaehltem Fighter (pID) die entsprechenden StatusModifikatoren hinzu.
	 * 
	 * @param pID
	 * @param pStatMods
	 * @throws Exception
	 */
	public void addStatModsToFighter(int pID, double[] pStatMods) throws Exception{
		if (pStatMods != null){
			if (pStatMods.length == 10){
				try{ getFightElement(pID).addStatMods(pStatMods);}
				catch (Exception vExc) {throw vExc;}
			} else throw new Exception("01; FiMan,aSMsF");
		} else throw new Exception("04; FiMan,aSMsF");
	}

	/**	Dh	23.2.2020
	 * 
	 * 	pEigenMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Fuegt allen Kaempfer*Innen der Liste die jeweilige EigenschaftsModifikation hinzu.
	 * 
	 * @param pInd
	 * @param pEigenMod
	 * @throws Exception
	 */
	public void addPropModToFighters(int pEigenMod, int pInd) throws Exception{
		Object vFiEle;
		
		if ((pInd >= 0) && (pInd < 10)){
			if (!zlFightList.isEmpty()){
				zlFightList.toFirst();
				while (!zlFightList.isEnd()){
					vFiEle = zlFightList.getCurrent();
				
					if (vFiEle instanceof FightElement) ((FightElement) vFiEle).addPropMod(pEigenMod, pInd);
					else throw new Exception("06; FiMan,aPMFs");
				
					zlFightList.next();
				}
			} else throw new Exception("05; FiMan,aPMFs");
		} else throw new Exception("07; FiMan,aPMFs");
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
	 * 	Fuegt allen Kaempfer*Innen der Liste die jeweilige StatusModifikation zu.
	 * 
	 * @param pID
	 * @param pInd
	 * @param pStatMod
	 * @throws Exception
	 */
	public void addStatModToFighters(double pStatMod, int pInd) throws Exception{
		Object vFiEle;
		
		if ((pInd >= 0) && (pInd < 10)){
			if (!zlFightList.isEmpty()){
				zlFightList.toFirst();
				while(!zlFightList.isEnd()){
					vFiEle = zlFightList.getCurrent();
				
					if (vFiEle instanceof FightElement) ((FightElement) vFiEle).addStatMod(pStatMod, pInd);
					else throw new Exception("06; FiMan,aSMFs");
				
					zlFightList.next();
				}
			} else throw new Exception("05; FiMan,aSMFs");
		} else throw new Exception("07; FiMan,aSMFs");
	}
	
	/**	Dh	23.2.2020
	 * 
	 * 	pEigenMod: 
	 * 	  0 Mut					5 Gewandheit
	 * 	  1 Klugkheit			6 Konstitution
	 * 	  2 Intuition			7 Koerperkraft
	 * 	  3 Charisma			8 Geschwindigkeit
	 * 	  4 Fingerfertigkeit	9 Sozialstatus
	 * 
	 * 	Fuegt allen Kaempfer*Innen der Liste die jeweilige EigenschaftsModifikationen hinzu.
	 * 
	 * @param pEigenMods
	 * @throws Exception
	 */
	public void addPropModsToFighters(int[] pEigenMods) throws Exception{
		Object vFiEle;
		
		if (pEigenMods != null){
			if (pEigenMods.length == 10){
				if (!zlFightList.isEmpty()){
					zlFightList.toFirst();
				
					while(!zlFightList.isEnd()){
						vFiEle = zlFightList.getCurrent();
					
						if (vFiEle instanceof FightElement) ((FightElement) vFiEle).addPropMods(pEigenMods);
						else throw new Exception("06; FiMan,aPMsFs");
					
						zlFightList.next();
					}
				} else throw new Exception("05; FiMan,aPMsFs");
			} else throw new Exception("01; FiMan,aPMsFs");
		} else throw new Exception("04; FiMan,aPMsFs");
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
	 * 	Fuegt allen Kaempfer*Innen der Liste die jeweilige StatusModifikationen hinzu.
	 * 
	 * @param pStatMods
	 * @throws Exception
	 */
	public void addStatModsToFighters(double[] pStatMods) throws Exception{
		Object vFiEle;
		
		if (pStatMods != null){
			if (pStatMods.length == 10){
				if (!zlFightList.isEmpty()){
					zlFightList.toFirst();
				
					while(!zlFightList.isEnd()){
						vFiEle = zlFightList.getCurrent();
					
						if (vFiEle instanceof FightElement) ((FightElement) vFiEle).addStatMods(pStatMods);
						else throw new Exception("06; FiMan,aSMsFs");
					
						zlFightList.next();
					}
				} else throw new Exception("05; FiMan,aSMsFs");
			} else throw new Exception("01; FiMan,aSMsFs");
		} else throw new Exception("04; FiMan,aSMsFs");
	}
	//-----
	/**	Dh	23.2.2020
	 * 
	 * 	Erstellt fuer den ausgewaehltem Fighter (pID) einen Kampfnachbar und fuegt diesem hinzu.
	 * 
	 * @param pID
	 * @param pNeighbourID
	 * @param pEnemy
	 * @throws Exception
	 */
	public void addFighterNeighbour(int pFighterID, int pNeighbourID, boolean pEnemy) throws Exception{
		NeighbourElement vNeigh;
		
		if ((haveFighterIDInList(pNeighbourID) == false) && (pFighterID != pNeighbourID)){
			vNeigh = new NeighbourElement(pNeighbourID, pEnemy);
			
			try{ getFightElement(pFighterID).addNeighbourElement(vNeigh); }
			catch (Exception vExc) {throw vExc;}
		} else throw new Exception("02; FiMan,aFNe_a");
	}
	/**	Dh	23.2.2020
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
	public void addFighterNeighbour(int pFighterID, int pNeighbourID, boolean pEnemy, int pDistance) throws Exception{
		NeighbourElement vNeigh;
		
		if ((haveFighterIDInList(pNeighbourID) == false) && (pFighterID != pNeighbourID) && (pDistance >= 0)){
			vNeigh = new NeighbourElement(pNeighbourID, pEnemy, pDistance);
				
			try{ getFightElement(pFighterID).addNeighbourElement(vNeigh); }
			catch (Exception vExc) {throw vExc;}
		} else throw new Exception("02; FiMan,aFNe_b");
	}
	/**	Dh	23.2.2020
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
	public void addFighterNeighbour(int pFighterID, int pNeighbourID, boolean pEnemy, double[] pFightMods) throws Exception{
		NeighbourElement vNeigh;
		
		if ((haveFighterIDInList(pNeighbourID) == false) && (pFighterID != pNeighbourID)){
			if (pFightMods.length == 4){
				vNeigh = new NeighbourElement(pNeighbourID, pEnemy, pFightMods);
						
				try{ getFightElement(pFighterID).addNeighbourElement(vNeigh); }
				catch (Exception vExc) {throw vExc;}
			} else throw new Exception("01; FiMan,aFNe_c"); 
		} else throw new Exception("02; FiMan,aFNe_c");

	}
	/**	Dh	23.2.2020
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
	public void addFighterNeighbour(int pFighterID, int pNeighbourID, boolean pEnemy, int pDistance, double[] pFightMods) throws Exception{
		NeighbourElement vNeigh;

		if ((pNeighbourID >= 0) && (pNeighbourID < zlFightList.getContentNumber()) && (pFighterID != pNeighbourID) && (pDistance >= 0)){
			if (pFightMods.length == 4){
				vNeigh = new NeighbourElement(pNeighbourID, pEnemy, pDistance, pFightMods);
			
				try{ getFightElement(pFighterID).addNeighbourElement(vNeigh); }
				catch (Exception vExc) {throw vExc;}
			} else throw new Exception("01; FiMan,aFNe_d");
		} else throw new Exception("02; FiMan,aFNe_d");

	}
	
	/**	Dh	23.2.2020
	 * 
	 * 	Fuegt dem ausgewaehlten Kaempfer (pID) die Kampfnachbarliste hinzu.
	 * 
	 * @param pID
	 * @param pNeighbourList
	 * @throws Exception
	 */
	public void addFighterNeighbourList(int pID, List pNeighbourList) throws Exception{
		if (pNeighbourList != null){
			try{ getFightElement(pID).addNeighbourList(pNeighbourList);}
			catch (Exception vExc) {throw vExc;}
		} else throw new Exception("04; FiMan,aFNL");
	}
	
//--------------------------------------------------------------------------------------------------------
	
}
