import java.util.*;

/**
 * @author Alexander Besuden (n00850421)
 * @Date Mar 26, 2019
 * >>>
 *
 * copyright © 2019
 */
public class BET <E>{	// Thats a BET!
	
	// initialization
//		Stack<BinaryNode<String>> pfStack = new Stack<>();

	@SuppressWarnings("hiding")
	private static class BinaryNode<String> { // creating the node class to use in the binary tree
		private String pkg;
		private BinaryNode<String> leftNode;
		private BinaryNode<String> rightNode;
		private BinaryNode<String> parentNode;
		
		public BinaryNode (String e, BinaryNode<String> rNode, BinaryNode<String> lNode, BinaryNode<String> pNode) {
			pkg = e;
			this.rightNode = rNode;
			this.leftNode = lNode;
			this.parentNode = pNode;
		}
		
		public String getElement () {
			return this.pkg;
		}
		
		public void setElement (String e) {
			this.pkg = e;
		}
		
		public BinaryNode<String> getParent () {
			return this.parentNode;
		}
		
		public void setParent (BinaryNode<String> node) {
			this.parentNode = node;
		}
		
		public BinaryNode<String> getLeft () {
			return this.leftNode;
		}
		
		public void setLeft (BinaryNode<String> node) {
			this.leftNode = node;
		}
		
		public BinaryNode<String> getRight () {
			return this.rightNode;
		}
		
		public void setRight (BinaryNode<String> node) {
			this.rightNode = node;
		}
	}
	
	private BinaryNode<String> rightNode;
	private BinaryNode<String> leftNode;
	private BinaryNode<String> parentNode;
	private BinaryNode<String> root;
	private int size;
	
	// public methods ====================================================
	// === DONE ===
	public BET() {
		// create empty binary tree
			rightNode = null;
			leftNode = null;
			parentNode = null;
			root = null;
			size = 0;
	}

	// === DONE ===
	public BET(String expr, char mode) {
		if (mode == 'p' || mode == 'P')
			buildFromPostfix(expr);
		else if (mode == 'i' || mode == 'I')
			buildFromInfix(expr);
		else
//			System.out.println("throw error"); // <<<----------------------------------------------------------------- handle later
			throw new IllegalStateException("Error, invalid mode!");
	}

	// === done ===
	public boolean buildFromPostfix(String postfix) {
		// build tree
		try {
			Stack<BinaryNode<String>> pfStack = new Stack<>();
			String[] splinterArray = postfix.split(" ");
			
			for (int i = 0; i < splinterArray.length; i++) {
				if (!isOperator(splinterArray[i])) {
					BinaryNode<String> treeNode = new BinaryNode(splinterArray[i], null, null, null);
					pfStack.push(treeNode);
				} else if (isOperator(splinterArray[i])) {
					BinaryNode<String> treeNode = new BinaryNode(splinterArray[i], pfStack.pop(), pfStack.pop(), null);
					treeNode.getLeft().setParent(treeNode);
					treeNode.getRight().setParent(treeNode);
					pfStack.push(treeNode);
					root = treeNode;
				} else {
					System.out.println("You just made the impossible possible!");
				}
//				System.out.print(splinterArray[i] + " ");
			}
			
			if (pfStack.size() > 1) {
				throw new IllegalStateException("Missing an operator");
			}
		}
		catch (Exception e) {
			System.out.println("Illegal Input");
			// default if tree was not build
//			 throw(e);
		}
		return false;
	}

	// === DONE ===
	public boolean buildFromInfix(String infix) {
		/* shuntingYardAlgo() takes in the infix string and converts it to a postfix string.
		 * This method then returns the postfix string to the buildFromPostfix() you see below.
		 * The tree is then constructed based off of a postfix string (way easier).
		 * This conversion is called the Shunting Yard Algorithm.
		 */
		return buildFromPostfix(shuntingYardAlgo(infix));
	}
	// === DONE ===
	public void printInfixExpression() {
		if (this.root != null) {
			printInfixExpression(this.root);
			System.out.printf("\n");			
		} else {
			System.out.printf("It's Empty\n");			
		}
	}
	
	// === DONE ===
	public void printPostfixExpression() {
		if (this.root != null) {
			printPostfixExpression(this.root);
			System.out.printf("\n");
		} else {
			System.out.printf("It's Empty\n");
		}
	}
	
	// === DONE ===
	public int size() {
		return size(this.root);
	}
	
	// === DONE ===
	public boolean isEmpty() {
		return size() == 0;
	}
	
	// === DONE ===
	public int leafNodes() {
		return leafNodes(this.root);
	}

	// private methods ==============================================

	// === done ===
	private void makeEmpty(BinaryNode t) {
		root = null;
	}

	// === DONE ===
	private void printInfixExpression(BinaryNode<String> n) {
		if (n == null) {
			return;
		}
		if (n.getRight() != null || n.getLeft() != null) {
			System.out.printf("( ");
		}
		printInfixExpression(n.getLeft());
		if (n.getLeft() != null) {
			System.out.printf(" ");
		}
		System.out.print(n.getElement());
		if (n.getRight() != null) {
			System.out.printf(" ");
		}
		printInfixExpression(n.getRight());
		if (n.getLeft() != null || n.getRight() != null) {
			System.out.printf(" )");
		}
	}
	
	// === DONE ===
	private void printPostfixExpression(BinaryNode<String> n) {
		if (n.getLeft() != null) {
			printPostfixExpression(n.getLeft());
		}
		if (n.getRight() != null) {
			printPostfixExpression(n.getRight());
		}
		System.out.printf(n.getElement() + " ");
	}
	
	// === DONE ===
	// recursively find size of tree
	private int size(BinaryNode t) {
		if (t == null)
			return 0;
		else 
			return size(t.rightNode) + size(t.leftNode) + 1;	// i think this will work, if not then change to (1 + right + left) instead
	}

	// === DONE ===
	// recursively find number of leaf nodes
	private int leafNodes(BinaryNode t) {
		if (t == null)
			return 0;
		else if ((t.rightNode == null) && (t.leftNode == null))
			return 1;
		else
			return leafNodes(t.rightNode) + leafNodes(t.leftNode);
	}

	// HELPER METHODS ==========================================================================================
	// === DONE ===
	// returns true if the passed in string is an operator
	private boolean isOperator(String os) {
		if (os.equals("+"))
			return true;
		else if (os.equals("-"))
			return true;
		else if (os.equals("*"))
			return true;
		else if (os.equals("/"))
			return true;
		else
			return false;
	}
	
	// === DONE ===
	// returns true if the passed in string is a higher presidence operator
	private boolean isHigherPresidence (String os) {
		if (os.equals("*"))
			return true;
		else if (os.equals("/"))
			return true;
		else
			return false;
	}
	
	// === DONE ===
	// returns true if the passed in string is a lower presidence operator
	private boolean isLowerPresidence (String os) {
		if (os.equals("+"))
			return true;
		else if (os.equals("-"))
			return true;
		else
			return false;
	}
	
	// === DONE ===
	// returns true if the passed in string is an operator
	private boolean isOperand (String os) {
		if (os.equals("a") || os.equals("b") || os.equals("c") || os.equals("d") || os.equals("e") || os.equals("f") || os.equals("g") || os.equals("h") || os.equals("i") || os.equals("j") || os.equals("k") || os.equals("l") || os.equals("m") || os.equals("n") || os.equals("o") || os.equals("p") || os.equals("q") || os.equals("r") || os.equals("s") || os.equals("t") || os.equals("u") || os.equals("v") || os.equals("w") || os.equals("x") || os.equals("y") || os.equals("z"))
			return true;
		else if (os.equals("A") || os.equals("B") || os.equals("C") || os.equals("D") || os.equals("E") || os.equals("F") || os.equals("G") || os.equals("H") || os.equals("I") || os.equals("J") || os.equals("K") || os.equals("L") || os.equals("M") || os.equals("N") || os.equals("O") || os.equals("P") || os.equals("Q") || os.equals("R") || os.equals("S") || os.equals("T") || os.equals("U") || os.equals("V") || os.equals("W") || os.equals("X") || os.equals("Y") || os.equals("Z"))
			return true;
		else if (os.equals("0") || os.equals("1") || os.equals("2") || os.equals("3") || os.equals("4") || os.equals("5") || os.equals("6") || os.equals("7") || os.equals("8") || os.equals("9"))
			return true;
//		else if (os.length() > 1)
//			return true;
//		else if (!os.equals(")") || !os.equals("(") || !os.equals("-") || !os.equals("+") || !os.equals("*") || !os.equals("/"))
//			return true;
		else
			return false;
	}
	
	// === DONE ===
	private boolean isParen (String os) {
		if (os.equals("(") || os.equals(")"))
			return true;
		else
			return false;
	}
	
	// === DONE ===
	private String shuntingYardAlgo (String infix) {
		Stack<String> ifStack = new Stack<>();
		Queue<String> ifQueue = new LinkedList<>();
		String[] splinterArray = infix.split(" ");
		StringBuilder postfix = new StringBuilder();
		
		if (splinterArray[splinterArray.length - 1].equals(" ") && isOperator(splinterArray[splinterArray.length - 2]))
			throw new IllegalArgumentException("Your giving a postfix expression for an infix mode");			
		if (isOperator(splinterArray[splinterArray.length - 1]))
			throw new IllegalArgumentException("Your giving a postfix expression for an infix mode");
		
		for (int i = 0; i < splinterArray.length; i++) {
			if(!isOperator(splinterArray[i]) && !isParen(splinterArray[i])) {
				ifQueue.add(splinterArray[i]);
			} else if (isLowerPresidence(splinterArray[i])) {
				while (!ifStack.empty() && !ifStack.peek().equals("(")) {
					ifQueue.add(ifStack.pop());
				}
				ifStack.push(splinterArray[i]);
			} else if (isHigherPresidence(splinterArray[i])) {
				while (!ifStack.empty() && isHigherPresidence(ifStack.peek())) {
					ifQueue.add(ifStack.pop());
				}
				ifStack.push(splinterArray[i]);
			} else if (splinterArray[i].equals("(")) {
				ifStack.push(splinterArray[i]);
			} else if (splinterArray[i].equals(")")) {
				if (ifStack.empty())
					throw new IllegalArgumentException("Error"); // <<<-------------------------------------------- what error?
				while (!ifStack.peek().equals("(")) {
					ifQueue.add(ifStack.pop());
					if (ifStack.empty())
						throw new IllegalArgumentException("Error - to many or not enough ("); // <<<-------------------------------------------- what error?
				}
				if (ifStack.peek().equals("("))
					ifStack.pop();
			} else {
				throw new IllegalStateException("Error " + splinterArray[i] + " is not recognized");
			}
		}
		while (!ifStack.isEmpty()) {
			if (ifStack.peek().equals("(")) {		
				throw new IllegalArgumentException("Invalid Notation: " + infix.toString());
			}
			ifQueue.add(ifStack.pop());
		}
		// reconstruct infix string into postfix string
		for (String tempString : ifQueue) {
			postfix.append(tempString);
			postfix.append(" ");
		}
		postfix.deleteCharAt(postfix.length() - 1);
//		System.out.println("shunt " + postfix.toString());   // test print out
		return postfix.toString();
	}
} // end of class





















