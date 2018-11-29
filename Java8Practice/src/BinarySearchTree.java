public class BinarySearchTree {

	class Node{
		int key;
		Node left;
		Node right;
		public Node(int item){
			key = item;
			left = right = null;
		}
	}
	
	Node root;
	
	public BinarySearchTree(){
		root = null;
	}
	
	public void insert(int item) {
		root = insertRec(root, item);
	}

	private Node insertRec(Node root, int key) {
		// TODO Auto-generated method stub
		if(root == null || root.key == key) {
			root = new Node(key);
			return root;
		}
		
		if(key < root.key) {
			root.left = insertRec(root.left, key);
		}else {
			root.right = insertRec(root.right, key);
		}
		return root;
	}
	
	public void inorder() {
		inorderRec(root);
	}

	private void inorderRec(Node root) {
		// TODO Auto-generated method stub
		if(root != null) {
			System.out.println(root.key);
			inorderRec(root.left);
			inorderRec(root.right);
		}
	}
	
	public static void main(String... args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insert(2);
		binarySearchTree.insert(1);
		binarySearchTree.insert(3);
		binarySearchTree.insert(0);
		binarySearchTree.insert(7);
		binarySearchTree.insert(9);
		binarySearchTree.insert(1);
		binarySearchTree.inorder();
		
	}
}
