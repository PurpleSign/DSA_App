/**	DSA_App v0.0	Dh	 25.6.2020
 * 	
 * 	Logik
 * 	  Referred
 * 
 * Exceptions:
 * 	  01 Wrong length
 * 	  02 Wrong Value
 * 	  03 Calculation Error
 * 	  04 Nullpointer Error
 * 	  05 Empty List Error
 * 	  06 Wrong Type Error
 * 	  07 Index Error
 * 	  08 Equal Object Error
 **/
package pLogik;

public interface Referred {
	
	public int getReferredValue(int pInd) throws Exception;
	public int[] getReferredValue();
	//----------------------------------------------------------------------------------------------------
	public void setReferredValue(int pValue, int pInd) throws Exception;
	public void setReferredValue(int[] pReferredValue) throws Exception;
	
}
