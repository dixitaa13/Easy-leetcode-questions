144. Binary Tree Preorder Traversal
Given the root of a binary tree, return the preorder traversal of its nodes values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,2,3]

Example 2:
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [1,2,4,5,6,7,3,8,9]

Example 3:
Input: root = []
Output: []

Example 4:
Input: root = [1]
Output: [1]

Solution 1: Recursion tc: O(N)  sc: O(N)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(result,root);
        return result;
    }

    public void helper(List<Integer> result, TreeNode root){
        if(root==null) return;
        
        result.add(root.val);
        helper(result,root.left);
        helper(result,root.right);
    }
}

Solution 2: Iterative tc: O(N)   sc: O(N)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        while(root!=null || !stack.isEmpty()){
            if(root!=null){
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            else{
                root = stack.pop();
                root = root.right;
            }
        }
        return result;
    }
}

For explaination refer to leetcode 145 same as that for preorder its:
Root->left->right