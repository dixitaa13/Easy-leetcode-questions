101. Symmetric Tree
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false


Solution 1: tc: O(N)   sc: O(N)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root==null || helper(root.left,root.right);
    }

    public boolean helper(TreeNode left, TreeNode right){
        if(left==null || right==null) return left==right;
        if(left.val!=right.val) return false;

        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}


Explaination:
in main func we have checked if root is null then return true otherwise iterate through left subtree and right subtree
in helper func:
1. check if null==null then true otherwise null==not null false
2. value of left != value of right return false
3. return if left.left==right.right and left.right=right.left then it is symmetric