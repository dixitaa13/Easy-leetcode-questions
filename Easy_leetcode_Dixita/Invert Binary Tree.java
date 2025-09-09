226. Invert Binary Tree
Given the root of a binary tree, invert the tree, and return its root.

Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:
Input: root = [2,1,3]
Output: [2,3,1]

Example 3:
Input: root = []
Output: []

Solution 1: tc: O(N)   sc: O(N)
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}


Explaination:
So in this code for a node we will just swap its left child with right child like:

       4
     /   \                  1. start ---> root, swap 2 and 7 
    2     7
   / \   / \
  1   3 6   9

       4
     /   \                  2. left subtree ---> 7 swap 6 and 9
    7     2
   / \   / \
  6   9 1   3

       4
     /   \                  3. left subtree----> 9 swap null and null move to right subtree
    7     2
   / \   / \
  9   6 1   3

       4
     /   \                  4. right subtree -----> 2 swap 3 and 1
    7     2
   / \   / \
  9   6 3   1