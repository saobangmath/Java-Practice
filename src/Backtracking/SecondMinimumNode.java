package Backtracking;


import java.util.PriorityQueue;
import java.util.Queue;

public class SecondMinimumNode {
    public static class TreeNode{
        public int val;
        public TreeNode left, right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }
    public static int findSecondMinimumValue(TreeNode root) {
        Queue<TreeNode> q = new PriorityQueue<>();
        int second = -1, first = -1;
        if (root == null){
            return -1;
        }
        q.add(root);
        while (!q.isEmpty()){
            TreeNode top = q.remove();
            if (top.val >= first){
                second = first;
                first = top.val;
            }
            else if (top.val > second){
                second = top.val;
            }
            if (top.left != null){
                q.add(top.left);
            }
            if (top.right != null){
                q.add(top.right);
            }
        }
        return second;
    }
}
