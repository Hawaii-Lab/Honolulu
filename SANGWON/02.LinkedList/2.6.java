import java.util.Arrays;
import java.util.LinkedList;

public class LinkedList_2_6 {
    public static void main(String[] args)  {
        Solution_2_6 k = new Solution_2_6();
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1,2,3,4,5,4,3,2,1));
//        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1,2,3,4,5,4,2,3,1));
//        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1,2,3,4,4,3,2,1));
        Boolean ans = k.solution(list);
        System.out.println(ans);
    }
}
class Solution_2_6 {
    public Boolean solution(LinkedList<Integer> list) {

        // 첫번째 방법
        LinkedList<Integer> reverseList = reserveList(list);

        if(list.equals(reverseList)) return true;

        return false;
    }

    private LinkedList<Integer> reserveList(LinkedList<Integer> list){

        LinkedList<Integer> reversed = new LinkedList<>();

        for(Integer i : list){
            reversed.addFirst(i);
        }

        return reversed;
    }
}