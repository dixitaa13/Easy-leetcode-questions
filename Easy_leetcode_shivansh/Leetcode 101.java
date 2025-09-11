Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Input: root = [1,2,2,3,4,4,3]
Output: true


Input: root = [1,2,2,null,3,null,3]
Output: false



Solution : TC = O(N)  SC = O(N)

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left,root.right);
    }
    private boolean helper(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;

       return (left.val == right.val) 
            && helper(left.left, right.right) 
            && helper(left.right, right.left);
    }
    }
