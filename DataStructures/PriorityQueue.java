package DataStructures;

public class PriorityQueue {
    private Node head = null;

    public void enqueue(String name, float cost) {
        Node newNode = new Node(name, cost);
        boolean pushable = true;

        if (exists(name)) {
            pushable = checkExisting(name, cost);
        }

        if (head == null) {
            head = new Node(name, cost);
        }

        else {
            if (pushable == true) {
                if (newNode.cost < head.cost) {
                    newNode.next = head;
                    head = newNode;
                }
                else {
                    Node current = head;
                    while (current.next != null && current.next.cost <= newNode.cost) {
                        current = current.next;
                    }
                    newNode.next = current.next;
                    current.next = newNode;
                }   
            }
        }
    }

    public String dequeue() {
        String top = null;
        if (!isEmpty()) {
            top = head.name;
            head = head.next;
        }
        return top;
    }

    public boolean exists(String vertex) {
        boolean status = false;
        Node current = head;

        while (current != null) {
            if (current.name.equals(vertex)) {
                status = true;
                break;
            }
            current = current.next;
        }

        return status;
    }

    public boolean checkExisting(String vertex, float cost) {
        Node current = head;

        if (current.name.equals(vertex)) {
            if (current.cost > cost) {
                head = current.next;
                return true;
            }
            else {
                return false;
            }
        }
        else {
            while(!current.next.name.equals(vertex)){
                current = current.next;
            }

            if (current.next.cost > cost) {
                // current.next = current.next.next;
                return true;
            }
            else {
                return false;
            }
        }  
    }

    public boolean isEmpty() {
        if (head == null) return true;
        else return false;
    }

    public class Node {
        private String name;
        private float cost;
        private Node next;

        public Node(String name, float cost) {
            this.name = name;
            this.cost = cost;
            next = null;
        }
    }
}
