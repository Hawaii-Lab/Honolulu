import java.util.Arrays;
import java.util.LinkedList;

public class LinkedList_2_7 {
    public static void main(String[] args) {
        Solution_2_7 k = new Solution_2_7();
        LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 8));
        LinkedList<Integer> list2 = new LinkedList<>(Arrays.asList(1, 3, 5, 6));
        LinkedList<Integer> intersection = new LinkedList<>(Arrays.asList(8, 9, 10, 11, 12));
        list1.addAll(intersection);
        list2.addAll(intersection);

        int ans = k.solution(list1, list2);
        if (ans == -1) {
            System.out.println("교집합 없음");
        } else {
            System.out.println("교집합 발생 부분 : " + ans);
        }
    }
}

class Solution_2_7 {
    public int solution(LinkedList<Integer> list1, LinkedList<Integer> list2) {

        int temp1 = list1.size();
        int temp2 = list2.size();

        LinkedList<Integer> shorter = temp1 > temp2 ? list2 : list1;
        LinkedList<Integer> longer = temp1 > temp2 ? list1 : list2;

        if (list1.getLast() != list2.getLast()) {
            return -1;
        }

        for (int i = 0; i < Math.abs(temp1 - temp2); i++) {
            longer.poll();
        }

        while (shorter.peekFirst() != longer.peekFirst()) {
            shorter.poll();
            longer.poll();
        }

        return shorter.peekFirst();
    }
}
