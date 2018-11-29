import java.awt.List;
import java.util.ArrayList;

public class BinaryTree {
	static class Node {

        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
	
	public void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println("  Inserted " + value + " to left of Node " + node.value);
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of Node " + node.value);
                node.right = new Node(value);
            }
        }
    }
	
	private void preorderRec(Node root) {
		// TODO Auto-generated method stub
		if(root != null) {
			System.out.println(root.value);
			preorderRec(root.left);
			preorderRec(root.right);
		}
	}
	
	public List findLevelList(Node node) {
		  return findLevelListHelper(
		      node,
		      0,
		      new ArrayList<List>());
		}
		 
		public List findLevelListHelper(
		    Node root,
		    int level,
		    List lists) {
		  if (root != null) {
		    if (level >= lists.size()) {
		      lists.add(new ArrayList<Node>());
		    }
		    lists.get(level).add(root);
		    findLevelListHelper(root.left,  level + 1, lists);
		    findLevelListHelper(root.right, level + 1, lists);
		  }
		  return lists;
		}
	
	public static void main(String... args) {
		BinaryTree binarySearchTree = new BinaryTree();
		Node node = new Node(2);
		binarySearchTree.insert(node,1);
		binarySearchTree.insert(node,3);
		binarySearchTree.insert(node,0);
		binarySearchTree.insert(node,7);
		binarySearchTree.insert(node,9);
		binarySearchTree.insert(node,1);
		binarySearchTree.preorderRec(node);
		
	}
}
