package AVL_Tree;


public class TreeApp {

	public static void main(String[] args) {
		System.out.println("Tree App");
		
	
		
		/**
		 * Original Tree:      6
		 * 				     /    \
		 *                 5       13
		 *               /        /  \
		 *            4        10     11
		 *                    /         \
		 *                  7            15
		 *                                 \
		 *                                  16
		 *      
		 *      
		 * AVL Tree:           6
		 * 				     /    \
		 *                  5      13
		 *                /       /  \
		 *               4     10     15
		 *                    /  \      \
		 *                  7    11      16
		 *      
		 *       
		 */
		
		
		
		StudentTree myTree = new StudentTree();
		
		myTree.insert(new StudentNode("6",6));
		myTree.insert(new StudentNode("5",5));
		myTree.insert(new StudentNode("13",13));
		myTree.insert(new StudentNode("4",4));
		myTree.insert(new StudentNode("10",10));
		
		myTree.insert(new StudentNode("11",11));
		myTree.insert(new StudentNode("7",7));
		myTree.insert(new StudentNode("15",15));
		myTree.insert(new StudentNode("16",16));
		myTree.insert(new StudentNode("6",6));

		
		myTree.printInOrder();	//output nodes in order

		
		/**
		 * These divisions were for testing various node inputs, and making sure they balanced correctly
		 */
		System.out.println("--------1---------");
		

		//myTree.printInOrder();
		System.out.println(myTree.getRoot()); 
		System.out.println(myTree.getRoot().getRight()); 
		System.out.println(myTree.getRoot().getLeft()); 
		
		System.out.println("--------2---------");
		
		System.out.println(myTree.search(5).getRight()); 
		System.out.println(myTree.search(5).getLeft()); 
		
		System.out.println("---------3--------");
		
		System.out.println(myTree.search(13).getRight()); 
		System.out.println(myTree.search(13).getLeft()); 
		

		System.out.println("---------4--------");
		
		System.out.println(myTree.search(10).getRight()); 
		System.out.println(myTree.search(10).getLeft());
		
		System.out.println("---------4--------");
		
		System.out.println(myTree.search(15).getRight()); 
		System.out.println(myTree.search(15).getLeft());


		
	}


}
