/**	DSA_App v0.0	Dh	 1.7.2020
 * 	
 * 	Logik
 * 	  Valued
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
 * 	  09 Wrong Selection
 **/
package pLogik;

public interface Valued {
	
	public int getValue();
	public int getValueLimit();
	//----------------------------------------------------------------------------------------------------
	public void setValue(int pValue) throws Exception;
	public void setValueLimit(int pLimit) throws Exception;
//--------------------------------------------------------------------------------------------------------
	public void addValue(int pValue) throws Exception;
}
