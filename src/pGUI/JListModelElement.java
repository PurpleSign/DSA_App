/**	DSA_App v0.0	Dh	6.5.2020
 * 
 * 	pGUI
 * 	  JListModelElement
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
package pGUI;

public class JListModelElement {
	private Object Object;
	private String Text;
	
	/**	Dh	6.5.2020
	 * 	
	 */
	public JListModelElement() {
		Object = null;
		Text = null;
	}
	/**	Dh	6.5.2020
	 * 
	 * @param pText
	 * @param pObject
	 */
	public JListModelElement(String pText, Object pObject) {
		Text = pText;
		Object = pObject;
	}
	
//--------------------------------------------------------------------------------------------------------

	/**	Dh	6.5.2020
	 * 
	 * @return
	 */
	public Object getObject() {
		return Object;
	}
	/**	Dh	6.5.2020
	 * 
	 * @return
	 */
	public String getText() {
		return Text;
	}
	
	//----------------------------------------------------------------------------------------------------
	
	/**	Dh	6.5.2020
	 * 
	 * @param pObject
	 */
	public void setObject(Object pObject) {
		Object = pObject;
	}
	/**	Dh	6.5.2020
	 * 
	 * @param pText
	 */
	public void setText(String pText) {
		Text = pText;
	}
}
