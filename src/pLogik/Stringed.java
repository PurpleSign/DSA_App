/**	DSA_App v0.0	Dh	 25.6.2020
 * 	
 * 	Logik
 * 	  Stringed
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

public interface Stringed {
	
	public String getStringedValue();
	//----------------------------------------------------------------------------------------------------
	public void setStringedValue(String pStringedValue) throws Exception;
}
