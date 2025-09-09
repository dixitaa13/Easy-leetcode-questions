Given the root of a binary tree, return the postorder traversal of its nodes values.

Example 1:

Input: root = [1,null,2,3]

Output: [3,2,1]

Example 2:

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

Output: [4,6,7,5,2,9,8,3,1]


Solution 
Tc: O(N)  // as we are doing a constant thing of addition in list for all values
Sc: O(N)  // List of integer takes space n for storing
class Solution {
    public void post(TreeNode root,List<Integer>ans){
        if(root == null) return ;
                post(root.left,ans);
        post(root.right,ans);
        ans.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
        post(root,ans);
        return ans;
    }
}