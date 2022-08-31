package algo.binarysearchtree;

import org.junit.Test;

import static algo.binarysearchtree.QueryBST.treeMinimum;

public class BSTManipulation{

    /**
     * TREE-INSERTION(T,z)
     * y = NIL
     * x = T.root
     * while x != NIL
     *     y = x;
     *     if z.key < x.key
     *         x = x.left
     *     else x = x.right
     * z.p = y;
     * if y == NIL
     *     T.root = z;
     * elseif z.key < y.key
     *     y.left = z
     * else y.right = z
     *
     * @param z The tree node to be inserted
     */
    public void treeInsertion(TreeNode root, TreeNode z){
        // The technique here is to maintain a trailing
        // pointer y as the parent of x.
        if(z == null){
            return;
        }
        TreeNode x,y;
        x = root;
        y = null;
        while(x != null){
            //x points to the position (NIL)
            //z is going to be inserted
            y = x;
            if (z.key < x.key){
                x = x.left;
            }else{
                x = x.right;
            }
        }
        z.p = y;
        if(y == null){
            root = z;
        }else if(z.key < y.key){
            y.left = z;
        }else{
            y.right = z;
        }

    }

    /**
     * This is a helper method that replace a subtree rooted at u with
     * a subtree rooted at v. It doesn't touch v.left or v.right. Doing
     * so or not doing so are the responsibility of the caller.
     *
     *
     * Pseudocode
     * TRANSPLANT(T,u,v)
     * if u.p == NIL
     *     T.root = v
     * elseif u.p.left == u
     *     u.p.left = v
     * else u.p.right = v
     * if v != NIL
     *     v.p = u.p
     * @param root The root node of the tree
     * @param u The node to be replaced by node v
     * @param v The node replacing node u
     */
    private void transplant(TreeNode root, TreeNode u, TreeNode v) {
        if (root == null || u == null) {
            return;
        }
        if (u.p == null) {// which is equivalent to u.p == null
            root = v;
        } else if (u.p.left == u) {
            u.p.left = v;
        }else{
            u.p.right = v;
        }
        if(v != null){
            v.p = u.p;
        }

    }

    /**
     * Pseudocode:
     * Tree-DELETION(T,z)
     * if z.left == NIL
     *     TRANSPLANT(T,z,z.right)
     * elseif z.right == NIL
     *     TRANSPLANT(T,z,z.left)
     * else y = MINIMUM(z.right)
     *     if y.p != z
     *         TRANSPLANT(T,y,y.right)
     *         y.right = z.right
     *         y.right.p = y
     *     TRANSPLANT(T,z,y)
     *     y.left = z.left
     *     y.left.p = y
     * @param tree
     * @param z
     */
    public void treeDeletion(TreeNode tree, TreeNode z){
        if(tree == null || z == null){
            return;
        }
        if(z.left == null){
            transplant(tree,z,z.right);
        } else if (z.right == null) {
            transplant(tree,z,z.left);
        }else{
            TreeNode y = treeMinimum(z.right);
            if( y.p != z){
                //replace y with y.right
                transplant(tree,y,y.right);
                y.right = z.right;
                y.right.p = y;
            }
            transplant(tree,z,y);
            y.left = z.left;
            y.left.p = y;
        }
    }

    public void leftRotation(){

    }

    public void rightRotation(){

    }

    @Test
    public void test(){
        int i,j;
        i = 7;
        j = 52;
        String str;
        while(j < 72){
            str = new String();
            if(i < 10){
                str = "0" + i + " " + j;
            }else{
                str = "" + i + " " + j;
            }
            j = j + 2;
            if(j > 71){
                j = 71;
                str = str + "--" + j;
                System.out.println(str);
                break;
            }
            i++;
            str = str + "--" + j;
            System.out.println(str);
        }
    }
}
