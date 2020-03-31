/*	
 * 		Created By: Alexander Besuden (n00850421)
 * 		Date Created: Feb. 12, 2019
 * 
 * 		Part 2
 * 		------
 * 		The goal is to create a singly linked list that stores elements in an array of size 8. When the array is filled a new node will be created.
 * 		When an array becomes empty in a node, the node will be deleted. The goal is to create an array that can increase in size and is not fixed.
 * 
 */
public class LinkedArrayQueue<E> {
//don't forget the member data
	
	SinglyLinkedList<E> sllObject = new SinglyLinkedList<>();
	private int size;
	private static final int CAP = 8;
	E[] blankArry;
	private int frontArrayElement;
	private int lastArrayElement;

	
//[---done---] the default constructor
	public LinkedArrayQueue() {
		this.size = 0;
		this.frontArrayElement = 0;
		this.lastArrayElement = 0;
	}

//[---done---] return the number of elements in the queue
	public int size() {
		return size;
	}

//[---done---] return the number of arrays currently storing elements
	public int numArrays() {
		return sllObject.size();
	}

//[---done---] test if the queue is empty
	public boolean isEmpty() {		
		return (size == 0);
	}

//[---done---] return the element at the front of the queue. return null if queue is empty
	public E first() {
		if (isEmpty()) {
			return null;
		} else {
			// do nothing
		}
//		E[] ay = sllObject.first();
//		return ay[frontArrayElement];
		return sllObject.first()[frontArrayElement];
	}

//[---done---] return the element at the back of the queue. return null if queue is empty
	public E last() {
		if (isEmpty()) {
			return null;
		} else {
			// do nothing
		}
//		E[] ay = sllObject.last();
//		return ay[lastArrayElement];
		return sllObject.last()[lastArrayElement - 1];
	}

//[---done---] push e to the back of the queue.
	@SuppressWarnings("unchecked")
	public void enqueue(E e) {
//		E[] ay = sllObject.last();
		if (sllObject.isEmpty()) {
			blankArry = (E[]) new Object[CAP];
			sllObject.addFirst(blankArry);
//			System.out.println("here (added node to empty queue)");
		} else {
			// do nothing
		}
		if (lastArrayElement == CAP) {		// checks the node's array, if it is 8 then a new node is added to use
			blankArry = (E[]) new Object[CAP];
			sllObject.addLast(blankArry);
			lastArrayElement = 0;
		} else {
			// do nothing
		}
//		ay[lastArrayElement] = e;
		blankArry[lastArrayElement] = e;
		lastArrayElement++;
		size++;
	}

//[---done---] pop and return the element at the front of the queue. return null if queue is empty
	public E dequeue() {
		if (isEmpty()) {
			return null;
		} else {
			// do nothing
		}
		E[] ay = sllObject.first();
		E element = ay[frontArrayElement];
		ay[frontArrayElement] = null;
		frontArrayElement++;
		size--;
		if (frontArrayElement == CAP) { // checks the length of the node's array, if its 0 then it removes the node
			sllObject.removeFirst();
			frontArrayElement = 0;
		}
		if (size == 0) {	// checks to see if the last element left in the singly linked list is empty and removes it
			sllObject.removeFirst();
			frontArrayElement = 0;
			lastArrayElement = 0;
		}
		return element;
	}
}




