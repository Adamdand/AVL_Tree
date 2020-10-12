package AVL_Tree;

public class StudentNode {
	public int id; //key
	public int height;

	public String name;
	public StudentNode left;
	public StudentNode right;
	public StudentNode parent;
	
	public StudentNode(String name, int id) {
		
		setName(name);
		setId(id);
		setLeft(null);
		setRight(null);
		setHeight(0);
		setParent(null);
	}
	

	@Override //over riding superclass, from inheritance
	public String toString() {
		return name + ", " + id;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHeight() {
		return height;
	}
	
	public void setParent(StudentNode parent) {
		this.parent = parent;
	}
	
	public StudentNode getParent() {
		return parent;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StudentNode getLeft() {
		return left;
	}
	public void setLeft(StudentNode left) {
		this.left = left;
	}
	public StudentNode getRight() {
		return right;
	}
	public void setRight(StudentNode right) {
		this.right = right;
	}
	
		

}
