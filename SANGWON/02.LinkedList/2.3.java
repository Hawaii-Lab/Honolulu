public class LinkedList_2_3 {
    public static void main(String[] args)  {
        Solution_2_3 k = new Solution_2_3();
        Node root = new Node("a");
        root.appendToTail("b");
        root.next.appendToTail("c");
        root.next.next.appendToTail("d");
        root.next.next.next.appendToTail("e");

        Boolean ans = k.solution(root.next.next);

        while(root.data != null){
            System.out.println(root.data);
            if(root.next!= null) {
                root = root.next;
            }else{
                break;
            }
        }

        System.out.println(ans);
    }
}
class Solution_2_3 {
    public Boolean solution(Node target) {

        if(target==null || target.next ==null){
            return false;
        }

        Node next = target.next;
        target.data = next.data;
        target.next = next.next;

        return true;
    }
}

class Node {
    Node next = null;
    String data;
    public Node(String d) {
        data =d;
    }

    void appendToTail(String d){
        Node end = new Node(d);
        Node n = this;
        while ( n.next != null){
            n = n.next;
        }
        n.next = end;
    }
}