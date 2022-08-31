package algo.binarysearchtree;

public class TreeNode {
    public int key;
    public TreeNode p;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int key, TreeNode p, TreeNode left, TreeNode right) {
        this.key = key;
        this.p = p;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "key=" + key +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
