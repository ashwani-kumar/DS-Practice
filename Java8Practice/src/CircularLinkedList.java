import java.util.ArrayList;
import java.util.List;

public class CircularLinkedList {
    Node head = null;
    Node tail = null;

    public void add(int value) {
        Node node = new Node();
        node.value = value;
        node.next = null;
        if(head == null){
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        tail.next = head;
    }

    public boolean contains(int value){
        Node currentNode = head;
        if (head != null) {
            do {
                if (currentNode.value == value) {
                    return true;
                }
                currentNode = currentNode.next;
            } while (currentNode.next != head);
        }
        return false;
    }

    public void detele(int value) {
        Node currentNode = head;
        if (head != null) {
            if (currentNode.value == value) {
                head = head.next;
                tail.next = head;
            }else {
                do {
                    Node nextNode = currentNode.next;
                    if (nextNode.value == value) {
                        currentNode.next = nextNode.next;
                        break;
                    }
                    currentNode = currentNode.next;
                } while (currentNode.next != head);
            }
        }
    }

    public void traverse(){
        Node currentNode = head;
        do {
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        } while(currentNode.next != head);
    }

}

class Node {
    int value;
    Node next;
}
