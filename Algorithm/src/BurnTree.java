public class BurnTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);
        root.setLeft(n13);
        TreeNode n10 = new TreeNode(10);
        root.setRight(n10);
        TreeNode n14 = new TreeNode(14);
        TreeNode n15 = new TreeNode(15);
        n10.setLeft(n14);
        n10.setRight(n15);
        TreeNode n21 = new TreeNode(21);
        TreeNode n22 = new TreeNode(22);
        TreeNode n23 = new TreeNode(23);
        TreeNode n24 = new TreeNode(24);
        n14.setLeft(n21);
        n14.setRight(n24);
        n15.setLeft(n22);
        n15.setRight(n23);
        System.out.println(burnTree(root, 14));
        System.out.println(timeRequire);
    }

    private static int timeRequire = 0;

    private static int burnTree(TreeNode root, int target) {
        if (root == null) return 0;
        if (root.getVal() == target) return 1;

        int left = burnTree(root.getLeft(), target);
        if ( left > 0) {
            traverseTree(root.getRight(), left+1);
            return left+1;
        }

        int right = burnTree(root.getRight(), target);
        if ( right > 0) {
            traverseTree(root.getLeft(), right+1);
            return right + 1;
        }
        return 0;
    }

    private static void traverseTree(TreeNode root, int level) {
        if(root == null) return;
        timeRequire = Math.max(level, timeRequire);
        traverseTree(root.getLeft(), timeRequire+1);
        traverseTree(root.getRight(), timeRequire+1);
    }
}



class TreeNode {
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    private int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    private TreeNode left, right;
}
