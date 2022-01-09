import java.util.Arrays;
import java.util.LinkedList;

public class LinkedList_2_4 {
    public static void main(String[] args)  {
        Solution k = new Solution();
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(3,5,8,5,10,2,1));
        LinkedList<Integer> ans = k.solution(list,5);
        System.out.println(ans);
    }
}
class Solution {
    public LinkedList<Integer> solution(LinkedList<Integer> list, Integer x ) {

        LinkedList<Integer> head = new LinkedList<>();
        LinkedList<Integer> tail = new LinkedList<>();

        for( Integer i : list){
            if(i < x){
                head.add(i);
            }else{
                tail.add(i);
            }
        }

        LinkedList<Integer> ans = new LinkedList<>();
        ans.addAll(head);
        ans.addAll(tail);
        return ans;
    }
}