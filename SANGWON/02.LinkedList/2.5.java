public class LinkedList_2_5 {
    public static void main(String[] args) {
        Solution_2_5 k = new Solution_2_5();
        Node root1 = new Node(7);
        root1.appendToTail(1);
        root1.next.appendToTail(6);
        root1.next.next.appendToTail(9);

        Node root2 = new Node(5);
        root2.appendToTail(9);
        root2.next.appendToTail(2);

        Node ans = k.solution(root1, root2);

        int answer = k.NodeToInt(ans);

        System.out.println(answer);
    }
}

class Solution_2_5 {
    public Node solution(Node root1, Node root2) {

        int temp = NodeToInt(root1) + NodeToInt(root2);

        Node ans = new Node(temp % 10);
        temp /= 10;
        while (temp > 0) {
            ans.appendToTail(temp % 10);
            temp /= 10;
        }
        return ans;
    }

    int NodeToInt(Node target) {
        int ans = 0;
        int idx = 0;

        while (target.data != null) {
            ans += target.data * Math.pow(10, idx);
            if (target.next == null) break;
            target = target.next;
            idx++;
        }

        return ans;
    }
}

class Node {
    Node next = null;
    Integer data;

    public Node(Integer d) {
        data = d;
    }

    void appendToTail(Integer d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
}