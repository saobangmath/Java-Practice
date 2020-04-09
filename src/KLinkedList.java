import java.util.List;
import java.util.Stack;

public class KLinkedList {
    public static class ListNode<T>{
        T value;
        ListNode next;
        public ListNode(T value){
            this.value = value;
            this.next = null;
        }
    }
    static ListNode<Integer> reverseNodeInKGroups(ListNode<Integer> l, int k){
        ListNode<Integer> tail = null, root = null, nxt = null;
        if (l == null){
            return null;
        }
        int c = k;
        while (c > 0 && l != null){
            nxt = l.next;
            if (root == null){
                tail = l;
            }
            l.next = root;
            root = l;
            l = nxt;
            c--;
        }
        if (c == 0){
            tail.next = reverseNodeInKGroups(nxt, k);
        }
        else{
            root = reverse(root);
        }
        return root;
    }

    private static ListNode<Integer> reverse(ListNode<Integer> root) {
        Stack<ListNode<Integer>> st = new Stack<>();
        ListNode<Integer> result = null, tail = null;
        while (root != null){
            st.push(root);
            root = root.next;
        }
        while (!st.isEmpty()){
            ListNode<Integer> top = st.pop();
            if (result == null){
                result = top;
                tail = top;
            }
            else{
                tail.next = top;
                tail = tail.next;
            }
        }
        tail.next = null;
        return result;
    }

    public static void main(String[] args) {
        ListNode<Integer>[] list = new ListNode[5];
        list[0] = new ListNode<>(1);
        list[1] = new ListNode<>(2);
        list[2] = new ListNode<>(3);
        list[3] = new ListNode<>(4);
        list[4] = new ListNode<>(5);

        list[0].next = list[1];
        list[1].next = list[2];
        list[2].next = list[3];
        list[3].next = list[4];

        ListNode root = reverseNodeInKGroups(list[0], 3);
        while (root != null){
            System.out.print(root.value + " ");
            root = root.next;
        }
    }
}
