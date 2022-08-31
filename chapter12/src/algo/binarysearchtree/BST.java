package algo.binarysearchtree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class BST {
    public TreeNode root;

    public BST() {

    }

    public void inorderTreeWalk(TreeNode root){
        if(root != null){
            inorderTreeWalk(root.left);
            System.out.println(root.key);
            inorderTreeWalk(root.right);
        }
    }

    public void inorderTreeWalkIterative(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        if(root == null){
            return;
        }
        TreeNode currNode = root;
        while(currNode != null || !stack.isEmpty()){
            while(currNode != null){
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            System.out.println(currNode.key);
            currNode = currNode.right;
        }
    }

    public void inorderTreeWalkMorris(TreeNode root){
        TreeNode cur = root;
        TreeNode pre;
        while(cur != null){
            if(cur.left == null){
                //Print key
                System.out.println(cur.key);
                //go to right subtree
                cur = cur.right;
            }
            else{
                //find the rightmost node in the left
                //subtree of cur
                pre = cur.left;
                while(pre.right != null){
                    pre = pre.right;
                }
                //make cur the right child of pre.
                pre.right = cur;
                cur = cur.left;
                cur.p = null;
                pre.right.left = null;
                pre.right.p = pre;
            }
        }
    }

    @Test
    public void testInorder(){
        TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(17);
        tree.left.left = new TreeNode(1);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(16);
        tree.right.right = new TreeNode(21);
        inorderTreeWalkMorris(tree);
    }
}
