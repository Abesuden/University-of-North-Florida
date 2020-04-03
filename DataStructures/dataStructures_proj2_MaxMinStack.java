/*	
 * 		Created By: Alexander Besuden (n00850421)
 * 		Date Created: Feb. 12, 2019
 * 
 * 		Part 1
 * 		------
 * 		The goal is to create a MaxMinStack that records the entries along with current minimum and maximum entries in the stack. This was implemented by having three arrays 
 * 		with each containing either the actual elements, current maximum or current minimum. This implementation was based on the generic framework.
 */
// Note that <E extends Comparable>. Therefore you should use Comparable instead of Object while creating arrays and casting them to generic type.
// Also use compareTO() instead of < or > while comparing generic elements

public class MaxMinStack<E extends Comparable<E>> {

	private E[] arg; // create an array
	private E[] minArg;
	private E[] maxArg;
	private int argSize = 0; // created to keep track of the array size
	private int cap = 0; // sets the cap for the array

//[---done---]	the default constructor
	@SuppressWarnings("unchecked")
	public MaxMinStack() {
		arg = (E[]) new Comparable[10];
//		MaxMinStack<E> mini = new MaxMinStack<E>(this.capacity());	// creates an array object for a minimum stack
//		MaxMinStack<E> maxi = new MaxMinStack<E>(this.capacity()); // creates an array object for a maximum stack
		minArg = (E[]) new Comparable[10];
		maxArg = (E[]) new Comparable[10];
		cap = 10;
	}

//[---done---]	another constructor which returns a stack of specified size
	@SuppressWarnings("unchecked")
	public MaxMinStack(int ary_size) {
		arg = (E[]) new Comparable[ary_size];
		minArg = (E[]) new Comparable[ary_size];
		maxArg = (E[]) new Comparable[ary_size];
		cap = ary_size;
	}

//[---done---]	return the element on top of the stack without removing it. return null if stack is empty.
	public E top() {
		if (this.size() < 1) {
			return null;
		} else {
			E topped = arg[this.size() -1];
			return topped; // returns the top most element
		}
//		E topped = this.pop(); // set a variable to the top most object
//		this.push(topped); // then push() it back onto the stack because this is not meant to permanently
//							// remove an object
	}

//[---done---]	return the number of elements in the stack
	public int size() {
		return argSize;
	}

//[---done---]	test if the stack is empty
	public boolean isEmpty() {
		if (this.top() == null) { // when stack is empty the top() returns null
			return true;
		} else { // if not null then there is an object in stack
			return false;
		}
	}

//[---done---]	return the actual capacity of the stack(not the number of elements stored in it).
	public int capacity() {
		return cap;
	}

//[---done---]	return the maximum value stored in the stack. return null if stack is empty.
	public E maximum() {
		if (this.size() < 1) {
			return null;
		} else {
			return maxArg[this.size() - 1];
		}
	}

//[---done---]	return the minimum value stored in the stack. return null if stack is empty.
	public E minimum() {
		if (this.size() < 1) {
			return null;
		} else {
			return minArg[this.size() - 1];
		}
	}

//[---done---]	push a new element onto the stack
	public void push(E e) throws IllegalStateException {
		if (this.size() >= this.capacity()) {
			throw new IllegalStateException("Error: Array Out Of Bounds!"); // throws error when to many elements are pushed
//			System.out.println("Error: Array Out Of Bounds!"); // displays an error when to many elements are pushed													// into the array
		} else if (this.size() == 0) {
			arg[this.size()] = e;
			maxArg[this.size()] = e;
			minArg[this.size()] = e;
		} else {
			// push to main stack
				arg[this.size()] = e;
			// push to min and max stacks
			if (this.maximum().compareTo(e) < 0) { // returns 1 if greater then, returns 0 if equal, returns -1 is less then
				maxArg[this.size()] = e;
			} else {
				maxArg[this.size()] = maxArg[this.size()-1];
			}
			if (this.minimum().compareTo(e) > 0) {
				minArg[this.size()] = e;
			} else {
				minArg[this.size()] = minArg[this.size()-1];
			}
//			arg[this.size() + 1] = e;
		}
		argSize = argSize + 1;
	}

//[---done---]	pop the element on top of the stack and return it. return null if stack is empty.
	public E pop() {
		if (this.size() < 1) {
			return null;
		} else {
			E popper = arg[this.size() - 1];
			arg[this.size() - 1] = null;// <-- do we want it 0 or null ############################################################################################################################
			maxArg[this.size() - 1] = null;
			minArg[this.size() - 1] = null;
			argSize = argSize - 1;
			return popper;
		}
	}
}

















