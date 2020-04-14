/**
 * @author Alexander Besuden (n00850421)
 * @Date Apr 4, 2019 >>> In this project, I will be implementing Cuckoo hashing.
 *       Internally, cuckoo hashing works by maintaining two arrays of the same
 *       size(half the capacity), along with two universal hash functions h1 and
 *       h2.
 *
 *       copyright © 2019
 */
import java.util.*;

public class CuckooHashMap<I, V> {
// === Initialization ==========================================================================================================
	private int capacity; // equals array1.length + array2.length
	private int prime;
	private int n;
	private Entry<I, V>[] array1;
	private Entry<I, V>[] array2;
	ArrayList<Integer> primeList = new ArrayList<>();

// === Constructors ==========================================================================================================

	// === DONE ===
	CuckooHashMap() {
//	-- default zero-parameter constructor. Builds an empty hash map with capacity = 4 and prime = 10007.
//		this.prime = 10007;
//		this.capacity = 4;
//		this.n = 0;
//		array1 = new Entry <I,V> [capacity/2];
//		array2 = new Entry <I,V> [capacity/2];
		this(4);
	}

	// === DONE ===
	CuckooHashMap(int cap) {
//	-- one-parameter constructor, where parameter "cap" specifies the initial capacity of the 
//	hash map. If capacity is odd, add 1 to it. prime should be set to 10007.
//		if (cap < 4) {
//			throw new IllegalArgumentException("Capacity is needs to be greater then four");
//		} else if (cap%2 != 0) {
//			cap++;
//		}
//		this.prime = 10007;
//		this.capacity = cap;
//		this.n = 0;
//		array1 = new Entry <I,V> [capacity/2];
//		array2 = new Entry <I,V> [capacity/2];
		this(cap, 10007);
	}

	// === DONE ===
	@SuppressWarnings("unchecked")
	CuckooHashMap(int cap, int prime) {
//	-- two-parameter constructor, where parameter "cap" specifies the initial capacity of the 
//	hash map, and prime is the initial prime number used in the hash function. If capacity is odd, add 1 to it.
		primeList.add(10007);
		if (cap < 4) {
			throw new IllegalArgumentException("Capacity needs to be greater then four!");
		} else if (!isPrime(prime)) {
			throw new IllegalArgumentException("You did not enter a prime number!");
		} else if (cap % 2 != 0) {
			cap++;
		}
		this.prime = prime;
		this.capacity = cap;
		this.n = 0;
		array1 = (Entry<I, V>[]) new Entry[capacity / 2];
		array2 = (Entry<I, V>[]) new Entry[capacity / 2];

	}

// === Public Methods ==========================================================================================================
	/**
	 * Getter method for the percent filled the hash map is 
	 * @return (int) load <= size / capacity
	 */
	// === DONE ===
	public float loadFactor() {
//	returns the current load factor of the hash map as a float, which is the number of entries
//	divided by the capacity of hash map.
//		return this.size() / (float) capacity;
		return (float) n / (float) capacity;
	}

	/**
	 * Getter method for size
	 * @return (int) size <= array1 + array2
	 */
	// === DONE ===
	public int size() {
//	returns the number of entries currently stored in the hash map.
		return this.n;
	}

	/**
	 * Getter method for capacity 
	 * @return (int) Hash Map capacity
	 */
	// === DONE ===
	public int capacity() {
//	-- returns the current capacity of the hash map.
		return this.capacity;
	}

	/**
	 * References the value at the passed in key 
	 * @param generic key
	 * @return generic value 
	 */
	// === DONE ===
	public V get(I key) {
//	-- if an entry with the given key exists in the hash map, return the value associated with it.
//		otherwise, return null. In order to find the entry, you have to first calculate the first
//		hash value of the key and use it to look in the first array. if the entry at the calculated
//		index does not match the given key, you have to calculate the second hash code and look in the second array.
		if (array1[h1(key)] != null && array1[h1(key)].getKey().equals(key))
			return array1[h1(key)].getValue();
		if (array2[h2(key)] != null && array2[h2(key)].getKey().equals(key))
			return array2[h2(key)].getValue();
//		else
		return null;
	}

	/**
	 * Removes the values at the key 
	 * @param Generic key
	 * @return Generic value
	 */
	// === DONE ===
	public V remove(I key) {
//	-- similar to get() method except that it removes the entry by setting the table entry to null. 
//		If the load factor drops below 25%, the table should be resized to half the current capacity.
//		The capacity should never drop below 4. Note that you need to re-insert all entries into the new hash table after resizing.
		V tempV = null;
		if (this.get(key) == null)
			return null;
		if (array1[h1(key)] != null && array1[h1(key)].getKey().equals(key)) {
			tempV = array1[h1(key)].getValue();
//			System.out.println("ss " + temp1);
			array1[h1(key)] = null;
			n--;
		}
		if (array2[h2(key)] != null && array2[h2(key)].getKey().equals(key)) {
			tempV = array2[h2(key)].getValue();
//			System.out.println("rr " + temp2);
			array2[h2(key)] = null;
			n--;
		}
		// If the load factor drops below 25%, the table is resized to half the current
		// capacity.
		if (loadFactor() < 0.25 && capacity > 4)
			;
		resize(capacity / 2);
		return tempV;
	}

	/**
	 * Adds a key value pair into a hash map collection
	 * @param Generic key and value pair
	 * @return Generic value if the key had a previous value 
	 */
	// === DONE ===
	public V put(I key, V value) {
//	-- insert the new (key,value) pair into the hash table. If an entry with the same key exists,
//		update the entry with the new value and return the old value. Otherwise, return null. 
//		If the load factor passes 50%, double the capacity of the hash table. Note that you should 
//		re-insert all entries after resizing the hash table.
		if (loadFactor() > 0.5) {
			resize(capacity * 2);
		}
		Entry<I,V> input = new Entry<>(key, value);
		Entry<I,V> temp = null;
		I getKey = input.getKey();
		V getValue = input.getValue();
		int enHash1 = h1(getKey);
		int enHash2 = h2(getKey);
		if (array1[enHash1] != null && array1[enHash1].getKey().equals(key)) {
			return array1[enHash1].setValue(value);
		}
		if (array2[enHash2] != null && array2[enHash2].getKey().equals(key)) {
			return array2[enHash2].setValue(value);
		}
		for (int i = 0; i < size() + 1; i++) {
			temp = array1[enHash1];
			array1[enHash1] = input;
			if (temp == null) {
				n++;
				if (loadFactor() > 0.5) {
					resize(capacity * 2);
				}
				return null;
			}
			input = temp;
			getKey = input.getKey();
			enHash1 = h1(getKey);
			enHash2 = h2(getKey);
			temp = array2[enHash2];
			array2[enHash2] = input;
			if (temp == null) {
				n++;
				if (loadFactor() > 0.5) {
					resize(capacity * 2);
				}
				return null;
			}
			input = temp;
		}
		rehash();
		return put(getKey, getValue);
	}
	/**
	 * Returns a collection of the Cuckoo Hash Map key value pair 
	 * @param nothing
	 * @return Generic iterable collection
	 */
	// === DONE ===
	public Iterable<Entry<I, V>> entrySet() {
//	-- Returns an iterable collection of all entries in the hash map. Entries should be returned 
//		by starting at index 0 of table 1, then index 0 of table 2, then index 1 of table 1 and so on.
		ArrayList<Entry<I, V>> entryI = new ArrayList<>();
//		if (array1 == null && array2 == null) { // <----------------------------------------------------------------- is
//												// this necissary
//			return entryI;
//		} else 
		if (array1 == null || array2 == null) {
			throw new IllegalStateException("Arrays are not the same size");
		}

//		for (int i = 0; i < this.size(); i++) {
		for (int i = 0; i < capacity / 2; i++) {
			if (array1[i] != null)
				entryI.add(array1[i]);
			if (array2[i] != null)
				entryI.add(array2[i]);
		}
		return entryI;
	}

	/**
	 * Returns a collection of the Cuckoo Hash Map keys 
	 * @param nothing
	 * @return Generic iterable collection
	 */
	// === DONE ===
	public Iterable<I> keySet() {
//	-- Returns an iterable collection of all keys in the hash map. Same order as entrySet()
		ArrayList<I> keyI = new ArrayList<>();
//		if (array1 == null && array2 == null) { // <----------------------------------------------------------------- is
//												// this necissary
//			return keyI;
//		} else 
		if (array1 == null || array2 == null) {
			throw new IllegalStateException("Arrays are not the same size");
		}

//		for (int i = 0; i < this.size(); i++) {
		for (int i = 0; i < capacity / 2; i++) {
			if (array1[i] != null)
				keyI.add(array1[i].getKey());
			if (array2[i] != null)
				keyI.add(array2[i].getKey());
		}
		return keyI;
	}

	/**
	 * Returns a collection of the Cuckoo Hash Map values 
	 * @param nothing
	 * @return Generic iterable collection 
	 */
	// === DONE ===
	public Iterable<V> valueSet() {
//	-- Returns an iterable collection of all values in the hash map. same order as entrySet()
		ArrayList<V> valueI = new ArrayList<>();
//		if (array1 == null && array2 == null) { // <----------------------------------------------------------------- is
//												// this necissary
//			return valueI;
//		} else 
		if (array1 == null || array2 == null) {
			throw new IllegalStateException("Arrays are not the same size");
		}

//		for (int i = 0; i < this.size(); i++) {
		for (int i = 0; i < capacity / 2; i++) {
			if (array1[i] != null) // handles null pointer exceptions (which were a pain in my ass)
				valueI.add(array1[i].getValue());
			if (array2[i] != null) // handles null pointer exceptions (which were a pain in my ass)
				valueI.add(array2[i].getValue());
		}
		return valueI;
	}
// === Private Methods =============================================================================================================================

	/**
	 * This will set up a new hash set for the next prime
	 * @param nothing
	 * @return nothing
	 */
	// === NOT DONE ? === <------------------------ do i need to empty the arrays???
	private void rehash() {
//    	: calculate the next prime number after the current one and reinsert all entries using the new hash 
//		functions. I won't grade your project based on the efficiency of finding the next prime number.
		this.prime = nextPrime(prime);
		Iterable<Entry<I, V>> tempArray = entrySet();
		for (Entry<I, V> entry : tempArray) {
			put(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * This will resize the arrays to a new capacity that you specify. Usually it is capacity * 2 
	 * @param (int) capacity
	 * @return nothing
	 */
	// === DONE ===
	private void resize(int newCap) {
//    	: Resize the hash map to the new capacity. The hash codes will change, so you have to reinsert all entries in the new tables.
		if ((newCap != (capacity * 2)) && (newCap != (capacity / 2))) // <--------------------------------------------------------------------------------------------------
			// is this necissary????
			throw new IllegalArgumentException("New Capacity needs to be double the old capacity!");
		// move every entry in the set into a temporary array before updating the new
		// features of the data structure
		Iterable<Entry<I, V>> temp = entrySet();
		// update the data structure
		this.capacity = newCap;
		array1 = (Entry<I, V>[]) new Entry[capacity / 2];
		array2 = (Entry<I, V>[]) new Entry[capacity / 2];
		this.n = 0; // update size to 0 because the array is emptied when resizing takes place
		// put everything back into the resized arrays
		for (Entry<I, V> i : temp) {
			put(i.getKey(), i.getValue());
		}
	}

	/**
	 * This is the first hash of the passed in key 
	 * @param generic key
	 * @return (int) hashed key value
	 */
	// === DONE ===
	private int h1(I key) {
//    	: first hash function. gets a key and returns the hash code by using :
//		int temp = (Math.abs(key.hashCode()) % prime) % (capacity / 2);
//		System.out.println("H1: " + key + " " + temp);
		return (Math.abs(key.hashCode()) % prime) % (capacity / 2);
	}

	/**
	 * This is the second hash of the passed in key 
	 * @param generic key
	 * @return (int) hashed key value
	 */
	// === DONE ===
	private int h2(I key) {
//    	: second hash function. gets a key and returns the hash code by using :
//		int temp = ((Math.abs(key.hashCode()) / prime) % prime) % (capacity / 2);
//		System.out.println("H2: " + key + " " + temp);
		return ((Math.abs(key.hashCode()) / prime) % prime) % (capacity / 2);
	}

// === Helper Methods =============================================================================================================================

	/**
	 * Finds if the number passed in are prime
	 * @param (int) prime number
	 * @return boolean
	 */
	// === DONE ===
	private boolean isPrime(int op) {

		for (int i = op - 1; i > 1; i--) {
			if (op%i == 0) {
				return false;
			}
		}
		return true;
//		int np = op;
//		np--;
//		while (op % np != 0) {
//			if (np == 1) {// || op % np <= lastPrime()) {
////				System.out.println(np);
//				return true;
//			}
//			np--;
//		}
//		return false;
	}

	/**
	 * This method will pull the last prime stored in an array list
	 * @param nothing
	 * @return (int) last prime
	 */
	// === DONE ===
	private int lastPrime() {
		return primeList.get(primeList.size() - 1);
	}

	/**
	 * This will find and return the next prime
	 * @param (int) current prime number
	 * @return (int) next incremented prime number
	 */
	// === DONE ===
	private int nextPrime(int op) {
		op++;
		while (!isPrime(op)) {
			op++;
		}
		return op;
	}
}
