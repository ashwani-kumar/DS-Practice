import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FriendsOfFriends {

	public static void main(String[] args) {
		// Creating person A
		FriendsOfFriends.Person mike = new FriendsOfFriends.Person(1);
		mike.setinfo("Mike");
		// Creating person B
		FriendsOfFriends.Person jack = new FriendsOfFriends.Person(2);
		jack.setinfo("Jack");
		// Adding person B as a friend of A
		jack.addFriend(1);
		// Creating person C
		FriendsOfFriends.Person adam = new FriendsOfFriends.Person(3);
		adam.setinfo("Adam");
		// Adding person C as a friend of A
		adam.addFriend(1);
		
		HashMap<Integer, Person> peoples = new HashMap();
		peoples.put(1, mike);
		peoples.put(2, jack);
		peoples.put(3, adam);
		
		LinkedList<Person> frndsList = findPathBiBFS(peoples, 3, 1);
		System.out.println(frndsList);
	}

	public static LinkedList<Person> findPathBiBFS(HashMap<Integer, Person> people, int source, int destination) {
		BFSData sourceData = new BFSData(people.get(source));
		BFSData destData = new BFSData(people.get(destination));
		while (!sourceData.isFinished() && !destData.isFinished()) {
			/* Search out from source. */
			Person collision = searchLevel(people, sourceData, destData);
			if (collision != null)
				return mergePaths(sourceData, destData, collision.getID());
			/* Search out from destination. */
			collision = searchLevel(people, destData, sourceData);
			if (collision != null)
				return mergePaths(sourceData, destData, collision.getID());
		}
		return null;
	}

	/* Search one level and return collision, if any. */
	public static Person searchLevel(HashMap<Integer, Person> people, BFSData primary, BFSData secondary) {
		/*
		 * We only want to search one level at a time. Count how many nodes are
		 * currently in the primary's level and only do that many nodes. We continue to
		 * add nodes to the end.
		 */
		int count = primary.toVisit.size();
		for (int i = 0; i < count; i++) {
			/* Pull out first node. */
			PathNode pathNode = primary.toVisit.poll();
			int personld = pathNode.getPerson().getID();
			/* Check if it's already been visited. */
			if (secondary.visited.containsKey(personld))
				return pathNode.getPerson();
			/* Add friends to queue. */
			Person person = pathNode.getPerson();
			ArrayList<Integer> friends = person.getFriends();
			for (int friendid : friends) {
				if (!primary.visited.containsKey(friendid)) {
					Person friend = people.get(friendid);
					PathNode next = new PathNode(friend, pathNode);
					primary.visited.put(friendid, next);
					primary.toVisit.add(next);
				}
			}
		}
		return null;
	}

	/* Merge paths where searches met at the connection. */
	public static LinkedList<Person> mergePaths(BFSData bfsl, BFSData bfs2, int connection) {
		// endl -> source, end2 -> dest
		PathNode endl = bfsl.visited.get(connection);
		PathNode end2 = bfs2.visited.get(connection);
		LinkedList<Person> pathOne = endl.collapse(false);
		LinkedList<Person> pathTwo = end2.collapse(true);
		pathTwo.removeFirst(); // remove connection
		pathOne.addAll(pathTwo); // add second path
		return pathOne;
	}

	public static class PathNode {
		private Person person = null;
		private PathNode previousNode = null;

		public PathNode(Person p, PathNode previous) {
			person = p;
			previousNode = previous;
		}

		public Person getPerson() {
			return person;
		}

		public LinkedList<Person> collapse(boolean startsWithRoot) {
			LinkedList<Person> path = new LinkedList<Person>();
			PathNode node = this;
			while (node != null) {
				if (startsWithRoot)
					path.addLast(node.person);
				else
					path.addFirst(node.person);
				node = node.previousNode;
			}
			return path;
		}
	}

	public static class BFSData {
		public Queue<PathNode> toVisit = new LinkedList<PathNode>();
		public HashMap<Integer, PathNode> visited = new HashMap<Integer, PathNode>();

		public BFSData(Person root) {
			PathNode sourcePath = new PathNode(root, null);
			toVisit.add(sourcePath);
			visited.put(root.getID(), sourcePath);
		}

		public boolean isFinished() {
			return toVisit.isEmpty();
		}
	}

	public static class Person {
		private ArrayList<Integer> friends = new ArrayList<Integer>();
		private int personID;
		private String info;

		public Person(int id) {
			this.personID = id;
		}

		public String getinfo() {
			return info;
		}

		public void setinfo(String info) {
			this.info = info;
		}

		public ArrayList<Integer> getFriends() {
			return friends;
		}

		public int getID() {
			return personID;
		}

		public void addFriend(int id) {
			friends.add(id);
		}
	}

}
