/**
 * @author Alexander Besuden (n00850421)
 * @Date Apr 4, 2019 
 * >>> The Entry class is used to make a data structure of key and value pairs (in this example, I replaced the notion of a Key with that
 * of an Index). This is what CuckooHashMap class builds its underlying data structure on.
 *
 * copyright © 2019
 */

public class Entry <I,V> {
	private I index;
	private V value;
	
	/**
	 * Empty constructor
	 */
	Entry () {
		// nothing
		this.index = null;
		this.value = null;
	}
	
	/**
	 * Constructor 
	 * @param (Key, value)
	 * @return nothing
	 */
	Entry (I i, V v) {
		this.index = i;
		this.value = v;
	}

	/**
	 * This is a getter method for the Entry class
	 * @param nothing
	 * @return value
	 */
	public V getValue(){
		return value;
	}
	
	/**
	 * This is a setter method for the Entry class
	 * @param value
	 * @return value
	 */
	public V setValue(V v) {
		this.value = v;
		return v;
	}

	/**
	 * This is a getter method for the Entry class
	 * @param nothing
	 * @return key
	 */
	public I getKey() {
		return index;
	}

	/**
	 * This is a getter method for the Entry class
	 * @param nothing
	 * @return key
	 */
	public void getKey(I i) {
		this.index = i;
	}
	
	
}
