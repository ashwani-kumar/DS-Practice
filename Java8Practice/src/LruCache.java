import java.util.HashMap;

public class LruCache {
	
	HashMap<Integer, Entry> hashMap;
	int CACHE_SIZE = 4;
	Entry start;
	Entry end;
	
	public LruCache() {
		hashMap = new HashMap<Integer, Entry>();
	}
	
	public int getValue(int key) {
		if(hashMap.containsKey(key)) {//if value is in map
			Entry entry = hashMap.get(key);//then get the node from map
			removeNode(entry);// remove it from linkedlist
			addToTop(entry);//add it to start of linkedlist
			return entry.value;// return it's value
		}
		return -1;//if not in map then return -1
	}
	
	public void putValue(int key, int value) {
		if(hashMap.containsKey(key)) {//if key exist in map
			Entry entry = hashMap.get(key);//then get the entry
			entry.value = value;//update it's value
			removeNode(entry);//remove it from current position
			addToTop(entry);//move it to first position
		}else {
			Entry node = new Entry();//create a new node
			node.left = null;//do not link it to list
			node.right = null;
			node.value = value;//update it's value
			node.key = key;//update it's key
			if(hashMap.size() > CACHE_SIZE) {//if map has entries mode than max size
				hashMap.remove(key);// then remove that entry from map
				removeNode(node);// remove it from linked list
				addToTop(node);//add it to the start of linked list
			}else { // if max size is not reached
				addToTop(node);// then add it to the start of linkedlist
			}
			hashMap.put(key, node);// add this node into hashmap
		}
	}

	private void addToTop(Entry node) {
		// TODO Auto-generated method stub
		node.right = start; //move current not to start
		node.left = null; // set left to null as start node should not have any left
		if(start != null) { //if not first insertion
			start.left = node; //shift start to right and make this node ahead of start
		}
		start = node;//set current node as start node
		if(end == null) {//if no end node is set 
			end = start;// then point start to end 
		}
	}

	private void removeNode(Entry node) {
		// TODO Auto-generated method stub
		if(node.left != null) {
			node.left.right = node.right; //node to be removed hands over it's right reference to the right of the node sitting to it's left
		}else {
			start = node.right; //node to be removed was start so update start with node sitting to it's right
		}
		
		if(node.right != null) {
			node.right.left = node.left; //node to be removed hands over it's left reference to the left of the node sitting to it's right
		}else {
			end = node.left; //node to be removed was last so update end with node sitting to it's left
		}
	}
	
	public static void main(String[] args) {
		LruCache lrucache = new LruCache();
		lrucache.putValue(1, 1);
		lrucache.putValue(10, 15);
		lrucache.putValue(15, 10);
		lrucache.putValue(10, 16);
		lrucache.putValue(12, 15);
		lrucache.putValue(18, 10);
		lrucache.putValue(13, 16);

		System.out.println(lrucache.getValue(1));
		System.out.println(lrucache.getValue(10));
		System.out.println(lrucache.getValue(15));
		System.out.println(lrucache.getValue(11));//key does not exist
	}
}

class Entry{
	int key;
	int value;
	Entry right;
	Entry left;
}
