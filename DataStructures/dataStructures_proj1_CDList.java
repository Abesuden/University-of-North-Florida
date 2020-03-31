
public class CDList<E> implements Cloneable {
//--------------nested node class------------
	private static class Node<E> {
		private E element;
		private Node<E> prev;
		private Node<E> next;

		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setPrev(Node<E> p) {
			prev = p;
		}

		public void setNext(Node<E> n) {
			next = n;
		}

		public String toString() {
			return "(" + prev.getElement() + "," + element + "," + next.getElement() + ")";
		}
	}

//---------------end of nested node class------------
//Member data
	private Node<E> tail = null;
	private int size = 0;

//Member Methods
	public CDList() {
//default contructor
	}

	public CDList(CDList<E> cdl) {
//the copy constructor
		for (int i = 0; i < cdl.size; i++) {
			addFirst(cdl.tail.getElement());
			cdl.rotateBackward();
		}
//		cdl.size() = this.size();
	}

	public int size() {
		// returns the size of the list
		return size;
	}

	public boolean isEmpty() {
//checks if the list is empty
		return size == 0;
	}

	public E first() {
//return the first element of the list
		return tail.getNext().getElement();
	}

	public E last() {
//return the last element of the list
		return tail.getElement();
	}

	public void rotate() {
//rotate the first element to the back of the list
		if (tail != null)
			tail = tail.getNext();
	}

	public void rotateBackward() {
//rotate the last element to the front of the list
		if (tail != null)
			tail = tail.getPrev();
	}

	public void addFirst(E e) {
//add element e to the front of the list
		if (size == 0) {
			tail = new Node<>(e, null, null);
			tail.setNext(tail);
			tail.setPrev(tail);
		} else {
			Node<E> headNode = new Node<>(e, tail, tail.getNext());
			tail.getNext().setPrev(headNode);
			tail.setNext(headNode);
		}
		size++;
	}

	public void addLast(E e) {
//add element e to the back of the list
		addFirst(e);
		tail = tail.getNext();
	}

	public E removeFirst() {
//remove and return the element at the front of the list
		tail.setNext(tail.getNext().getNext());
		tail.getNext().setPrev(tail);
		size--;
		return tail.getNext().getElement();
	}

	public E removeLast() {
//remove and return the element at the back of the list
		tail = tail.getPrev();
		// break those chains and free them slaves
		tail.setNext(tail.getNext().getNext());
		tail.getNext().setPrev(tail);
		size--;
		return tail.getElement();
	}

	public CDList<E> clone() {
//clone and return the new list(deep clone)
		CDList<E> cpList = new CDList<E>(this);
		return cpList;
	}

	public boolean equals(Object o) {
		/* Worst case time complexity
		 * -  The worst case time complexity for the equals() method is O(n^2). This was determined because two for loops were used to rotate through the linked list
		 * 	  and compare the element values. Each for loop has a worst case time complexity of O(n). Therefore, when each iteration of the first for loop calls another for loop,
		 *    it creates a worst case time complexity of O(n^2).
		 */
//check if the current instance and o are from the same class, have the same type
//and have the same sequence of elements despite having possibly different starting points.
		boolean flag = false;
		if (o instanceof CDList) {
			if (this.size == ((CDList<E>) o).size) {
				for (int i = 0; i < this.size; i++) {
					if (this.tail.getElement() == ((CDList<E>) o).tail.getElement()) {
						for (int j = 0; j < this.size(); j++) {
//							if (this.tail.getElement() == ((CDList<E>) o).tail.getElement()) {
							if (this.tail.getElement().equals(((CDList<E>) o).tail.getElement())) {
								flag = true;
								this.rotate();
								((CDList<E>) o).rotate();
							} else {
								flag = false;
								break;
							}
						}
					} else {
						this.rotate();
					}
				}
			} else {
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;
	}

	public void attach(CDList cdl) {
//insert cdl after the tail of the current list
		
		CDList<E> extender = cdl.clone();
		Node<E> tempHolder = this.tail.getNext(); // shallow copy
		this.tail.setNext(extender.tail.getNext());
		extender.tail.getNext().setPrev(this.tail);
		extender.tail.setNext(tempHolder);
		extender.tail.getNext().setPrev(extender.tail);
		this.tail = extender.tail;
		this.size = this.size + extender.size;
	}

	public void removeDuplicates() {
		/* Worst case time complexity
		 * 	- The worst case time complexity for the removeDuplicates() method is O(n^2). This was determined because two for loops were used to rotate through the linked list
		 * 	  and compare the element values. Each for loop has a worst case time complexity of O(n). Therefore, when each iteration of the first for loop calls another for loop,
		 *    it creates a worst case time complexity of O(n^2).  
		 */
//remove all elements that happen more than once in the list. If the tail gets deleted, the element immediately before the tailÂ will become the new tail.
		// [2] <-- tempHolder
		// ,->[2]=[3]=[2]=[4]=[6]<-,
		// `-----------------------`
		for (int l = 0; l < this.size(); l++) {
			E tempHolder = this.tail.getElement(); // creates temporary node with the same element
			for (int k = 1; k < (this.size()); k++) {
				this.rotate();
				if (this.tail.getElement() == tempHolder) {
					this.removeLast();
				}
			}
			this.rotate();
		}
	}

	public void printList() {
//prints all elements in the list
		if (size == 0)
			System.out.println("List is empty.");
		else {
			Node<E> walk = tail.getNext();
			while (!(walk.getNext().equals(tail.getNext()))) {
				System.out.print(walk.toString() + ", ");
				walk = walk.getNext();
			}
			System.out.println(walk.toString());
		}
	}
}