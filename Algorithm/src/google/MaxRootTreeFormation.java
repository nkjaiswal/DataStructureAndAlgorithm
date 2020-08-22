package google;
//https://leetcode.com/problems/maximum-binary-tree/


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxRootTreeFormation {
    public static void main(String[] args) {
        int[] data = {3,2,1,6,0,5};
        System.out.println(new MaxRootTreeFormation().formTree(data));
    }

    private TreeNode formTree(int[] data) {
        Map<Integer, Integer> index = new HashMap<>();

        for(int i=0; i<data.length; i++) {
            index.put(data[i], i);
        }

        Arrays.sort(data);
        int i=data.length-1;

        TreeNode root = new TreeNode(data[i]);
        i--;

        while (i>=0) {
            int currentData = data[i];
            insertInTreeComparingIndex(index, currentData, root);
            i--;
        }
        return root;
    }

    private void insertInTreeComparingIndex(Map<Integer, Integer> index, int currentData, TreeNode root) {
        int currentIndex = index.get(currentData);
        if(index.get(root.val) > currentIndex) {
            if(root.left != null) {
                insertInTreeComparingIndex(index, currentData, root.left);
            } else {
                root.left = new TreeNode(currentData);
            }
        } else {
            if (root.right != null) {
                insertInTreeComparingIndex(index, currentData, root.right);
            } else {
                root.right = new TreeNode(currentData);
            }
        }
    }
}


