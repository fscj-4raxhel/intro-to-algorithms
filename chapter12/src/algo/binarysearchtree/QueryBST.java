package algo.binarysearchtree;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;

/**
 * This class defines common query methods of BST like
 * search for a key; find the min and max element; and
 * successor and predecessor of an in-order traversal.
 */
public class QueryBST {

    /**
     * Search Tree
     * TREE-SEARCH(x,k)
     * if x == NIL or k == k.key
     *     return x
     * if k < x.key
     *     return TREE-SEARCH(x.left,k)
     * else return TREE-SEARCH(x.right,k)
     */
    public static TreeNode treeSearchRecursive(TreeNode root, int k){
        if(root == null || root.key == k){
            return root;
        }
        if(k < root.key){
            return treeSearchRecursive(root.left,k);
        }else{
            return treeSearchRecursive(root.right,k);
        }

    }

    /**
     * Search Tree Iterative
     * ITERATIVE-TREE-SEARCH(x,k)
     * if x == NIL or k == k.key
     *     return x
     * if k < x.key
     *     return TREE-SEARCH(x.left,k)
     * else return TREE-SEARCH(x.right,k)
     *
     * while(x != NIL and k != x.key)
     *     if k < x.key
     *         x = x.left
     *     else x = x.right
     * return x
     *
     */
    public static TreeNode treeSearchIterative(TreeNode root, int k){
        while(root != null && root.key != k) {
            if (k < root.key) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }

    /**
     * TREE-MINIMUM(x)
     * while x.left != NIL
     *     x = x.left
     * return x
     */

    public static TreeNode treeMinimum(TreeNode root){
        if(root == null){
            return null;
        }
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    /**
     * TREE-MINIMUM-RECURSIVE(x)
     * if x == NIL
     *     return NIL;
     * if root.left != NIL
     *     return TREE-MINIMUM-RECURSIVE(x.left)
     * else return root
     */

    public static TreeNode treeMinimumRecursive(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left != null){
            return treeMinimumRecursive(root.left);
        }else{
            return root;
        }


    }

    /**
     * TREE-MAXIMUM(x)
     * while x.right != NIL
     *     x = x.right;
     * return x;
     */

    public static TreeNode treeMaximum(TreeNode root){
        if(root == null){
            return null;
        }
        while(root.right != null){
            root = root.right;
        }
        return root;
    }

    /**
     * TREE-MAXIMUM-RECURSIVE(x)
     * if x == NIL
     *     return NIL;
     * if root.right != NIL
     *     return TREE-MINIMUM-RECURSIVE(x.right)
     * else return root
     */

    public static TreeNode treeMaximumRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right != null) {
            return treeMaximumRecursive(root.right);
        } else {
            return root;
        }
    }

    /**
     * TREE-SUCCESSOR(x)
     * if x.right != NIL
     *     return TREE-MINIMUM(x.right)
     * y = x.p
     * while y != null && x = y.right
     *     x = y
     *     y = y.p
     * return y
     */

    public static TreeNode treeSuccessor(TreeNode x){
        if (x == null){
            return null;
        }
        if (x.right != null){
            return treeMinimum(x.right);
        }

        //In this case we want to walk up
        //until we reach a node that is its parent's left child
        TreeNode y = x.p;
        while(y != null && x == y.right){
            x = y;
            y = y.p;
        }
        //After the while loop, y is either the root of T
        // or y is its parent's left child
        return y;
    }

    /**
     * TREE-PREDECESSOR(x)
     * if x.left != NIL
     *     return TREE-MAXIMUM(x.left)
     * y = x.p
     * while y != null && x = y.left
     *     x = y
     *     y = y.p
     * return y
     */

    public static TreeNode treePredecessor(TreeNode x){
        if (x == null){
            return null;
        }
        if (x.left != null){
            return treeMaximum(x.left);
        }

        //In this case we want to walk up
        //until we reach a node that is its parent's right child
        TreeNode y = x.p;
        while(y != null && x == y.left){
            x = y;
            y = y.p;
        }
        //After the while loop, y is either the root of T
        // or x is the right child of y
        return y;
    }


    @Test
    public void test(){
       TreeNode tree = new TreeNode(15);
       tree.left = new TreeNode(6);
       tree.left.p = tree;
       tree.right = new TreeNode(18);
       tree.right.p = tree;
       tree.left.left = new TreeNode(3);
       tree.left.left.p = tree.left;
       tree.left.right = new TreeNode(7);
       tree.left.right.p = tree.left;
       tree.right.left = new TreeNode(17);
       tree.right.left.p = tree.right;
       tree.right.right = new TreeNode(20);
       tree.right.right.p = tree.right;
       tree.left.left.left = new TreeNode(2);
       tree.left.left.left.p = tree.left.left;
       tree.left.left.right = new TreeNode(4);
       tree.left.left.right.p = tree.left.left;
       tree.left.right.right = new TreeNode(13);
       tree.left.right.right.p = tree.left.right;
       tree.left.right.right.left = new TreeNode(9);
       tree.left.right.right.left.p = tree.left.right.right;

        TreeNode res = treeSuccessor(tree.left.right.right);
        if (res != null){
            System.out.println(res.toString());
        }
    }
}
