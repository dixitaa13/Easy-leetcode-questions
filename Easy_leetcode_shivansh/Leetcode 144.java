Given the root of a binary tree, return the preorder traversal of its nodes values.

Example 1:

Input: root = [1,null,2,3]

Output: [1,2,3]

Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [1,2,4,5,6,7,3,8,9]


Solution 1: Recursion 
Tc: O(N)  
Sc: O(N)
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

Solution2 : Iterative
TC: O(N)
SC: O(N)

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
        if(root==null) return ans;

        Stack<TreeNode>st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode node = st.pop();
            ans.add(node.val);

            if(node.right!=null) st.push(node.right);
            if(node.left!=null) st.push(node.left);
        }
            return ans;

    }
}