/*	
 * 		Created By: Alexander Besuden (n00850421)
 * 		Date Created: Feb. 12, 2019
 * 
 * 		Part 2
 * 		------
 * 		This class is to provide the singly linked list data structure for the LinkedArrayQueue class 
 * 
 */
public class SinglyLinkedList <E> {

	@SuppressWarnings("hiding")
	private static class Node<E> { // create the node class to use in the linked list
		private E[] pkg;
		private Node<E> nd;
		
		public Node (E[] e, Node<E> node) {
			pkg = e;
			nd = node;
		}
		
		public E[] getElement () {
			return this.pkg;
		}
		
		public Node<E> getNext () {
			return this.nd;
		}
		
		public void setNext (Node<E> node) {
			this.nd = node;
		}
	}
	
	private Node<E> head;
	private Node<E> tail;
	private int size;
	
	// constructor
	public SinglyLinkedList () {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	// make new node and make it head 
	public void addFirst (E[] e) {
		head = new Node<>(e, head);
		if (size == 0) {
			tail = head;
		} else {
			// do nothing
		}
		size = size + 1;
	}
	
	public void addLast (E[] e) {
		Node<E> lastNode = new Node<> (e, null); 
		if (isEmpty()) {
			head = lastNode;
		} else {
			tail.setNext(lastNode);
		}
//		tail.setNext(new Node<>(e, null));
		tail = lastNode;
		size = size + 1;
	}
	
	public E[] removeFirst () {
		if (isEmpty()) {
			return null;
		} else {
			// do nothing
		}
		E[] lostElement = head.getElement();
		head = head.getNext();
		size = size - 1;
		if ( size == 0) {
			tail = null;
		} else {
			// do nothing
		}
		return lostElement;
	}
	
	public boolean isEmpty () {
		return size == 0;
	}
	
	public int size () {
		return size;
	}
	
	public E[] first () {
		if (isEmpty()) {
			return null;
		} else {
			// do nothing
		}
		return head.getElement();
	}
	
	public E[] last () {
		if (isEmpty()) {
			return null;
		} else {
			// do nothing
		}
		return tail.getElement();
	}
	
}







