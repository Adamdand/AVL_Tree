package AVL_Tree;

public class StudentTree {

	private StudentNode root;

	public StudentTree() {
		setRoot(null);
	}

	// Function to get height of the tree
	void updateHeight(StudentNode node) {
		node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));
	}

	public int height(StudentNode node) {
		// return node == null? -1 : node.height;
		if (node == null)
			return 0;
		return node.getHeight();
	}

	// Function to find maximum of 2 integers (to determine which tree branch is
	// largest)
	public int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public boolean isLeaf(StudentNode a) {
		if (a.getRight() == null && a.getLeft() == null)
			return true;
		return false;
	}

	// Right Rotate Function
	public StudentNode rightRotate(StudentNode y) {

		StudentNode x = y.getLeft();
		StudentNode T2 = x.getRight();

		// rotate
		x.setRight(y);
		y.setLeft(T2);

		// Update Heights
		x.setHeight(1 + max(height(x.getLeft()), height(x.getRight())));
		y.setHeight(1 + max(height(y.getLeft()), height(y.getRight())));

		// return new root
		return x;
	}
	

	// Left Rotate Function
	public StudentNode leftRotate(StudentNode y) {
		StudentNode x = y.getRight();
		StudentNode T2 = x.getLeft();

		// rotate
		x.setLeft(y);
		y.setRight(T2);

		// update Heights
		x.setHeight(1 + max(height(x.getLeft()), height(x.getRight())));
		y.setHeight(1 + max(height(y.getLeft()), height(y.getRight())));

		// Return new root
		return x;
	}


/**
 * This function outputs the balance of a node for the other functions
 */
	public int getBalance(StudentNode node) {
		//System.out.println("CHECKPOINT"); // < -- used as a check
		if (node == null || isLeaf(node))
			return 0;
		else if (node.getLeft() == null) {
			return height(node.getRight()); 
												
		} else if (node.getRight() == null) {
			return -height(node.getLeft());
		} else
			return (height(node.getRight()) - (height(node.getLeft())));
	}
	

	/**
	 * Function is used for rebalancing the tree if it finds a node with a balance +/- 2
	 */
	public StudentNode reBalance(StudentNode node) {
			updateHeight(node);
			//System.out.println("node " + node + " balance: " + getBalance(node)); // <-- used as a check
			int balance = getBalance(node);
			if(balance >= 2) {
				if (height(node.right.right) > height(node.right.left)) {
				}else {
					node.setRight(rightRotate(node.right));
					node = leftRotate(node);
				}
			}else if (balance <= -2) {
				//System.out.println("balance less than 1");
				if(height(node.left.left)> height(node.left.right)) {
					node = rightRotate(node);
					//System.out.println("New node = " + node); // <--used as a check
				}else {
					node.setLeft(leftRotate(node.left));
					node = rightRotate(node);
					//System.out.println("New node = " + node); // <--used as a check
				}
			}
			return node;
	}

	/**
	 * Inserting new Node Functions
	 * Thus function called "InserCall" method, which then recursively creates a tree, and then sorts it.
	 */
	public void insert (StudentNode newNode) {
		root = insertCall(root,newNode );
	}


	// AVL Tree insert method
	public StudentNode insertCall(StudentNode cursor, StudentNode newNode) {
		if (cursor == null) {
			return newNode;
		}else if (cursor.getId() > newNode.getId()) {
			cursor.setLeft(insertCall(cursor.getLeft(), newNode));		//insert node into left
		}else if (cursor.getId() < newNode.getId()) {
			cursor.setRight(insertCall(cursor.getRight(), newNode));	//insert node into right
		}else {
			System.out.println("unable to insert, this is a duplicate value!"); // no duplicate values alowed
		}
		StudentNode reblance = reBalance(cursor);
		return reblance;
	}

	
	/**
	 * Printing Functions (all of the ones bellow until next "blue comments")
	 */
	public void printInOrder() { // create this function to call the traverseInOrder function, so we dont need to
									// call root node in the treeApp
		TraverseInOrder(getRoot());
	}

	public void printPreOrder() { // create this function to call the traverseInOrder function, so we dont need to
									// call root node in the treeApp
		TraversePreOrder(getRoot());
	}

	public void printPostOrder() { // create this function to call the traverseInOrder function, so we dont need to
									// call root node in the treeApp
		TraversePostOrder(getRoot());
	}

	private void TraverseInOrder(StudentNode cursor) { // Traverse in order , left, Node, right

		if (cursor != null) {
			TraverseInOrder(cursor.getLeft()); // left node
			System.out.println(cursor); // current node
			TraverseInOrder(cursor.getRight()); // right node
		}
	}

	private void TraversePostOrder(StudentNode cursor) { // Traverse post order, left, right , node

		if (cursor != null) {
			TraversePostOrder(cursor.getLeft()); // left node

			TraversePostOrder(cursor.getRight()); // right node
			System.out.println(cursor); // current node
		}
	}

	private void TraversePreOrder(StudentNode cursor) { // Traverse pre Order, node, leftsubtree, rightsubtree

		if (cursor != null) {
			System.out.println(cursor); // current node
			TraversePreOrder(cursor.getLeft()); // left node
			TraversePreOrder(cursor.getRight()); // right node
		}
	}

	
	/**
	 * Searching Functions (all of the functions bellow)
	 * Used for testing
	 */
	// Search for Node of certain value
	public StudentNode search(int key) { // (StudentNode cursor, int key)
		StudentNode cursor = root;
		while (cursor != null) {
			if (key == cursor.getId()) // current.getId()
				return cursor; // found
			else if (key < cursor.getId())
				cursor = cursor.getLeft(); // current.getleft()
			else
				cursor = cursor.getRight();
		}
		return cursor; // not found
	}

	public StudentNode search2(int key) { // (StudentNode cursor, int key) //search2 Function is used to find the
											// balance of a node
		StudentNode cursor = root;
		while (cursor != null) {
			if (key == cursor.getId()) { // current.getId()
				System.out.println("Balance of " + cursor + " is: " + getBalance(cursor)); // a check to see what the
																							// balance is
				return cursor; // found
			} else if (key < cursor.getId()) {
				cursor = cursor.getLeft(); // current.getleft()
			} else {
				cursor = cursor.getRight();
			}
		}

		return cursor; // not found
	}

	// get parent of a node
	public StudentNode findParent(StudentNode child) {
		return parentHelper(root, child);
	}

	public StudentNode parentHelper(StudentNode currentNode, StudentNode child) {
		if (root == null || root == child) {
			return null;
		} else {
			if (currentNode.getLeft() == child || currentNode.getRight() == child)
				return currentNode;
			else {
				if (currentNode.getId() < child.getId()) {
					return parentHelper(currentNode.getRight(), child);
				} else {
					return parentHelper(currentNode.getLeft(), child);
				}
			}
		}
	}

	public StudentNode getRoot() {
		return root;
	}

	public void setRoot(StudentNode root) {
		this.root = root;
	}

}
