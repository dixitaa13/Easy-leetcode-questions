145. Binary Tree Postorder Traversal
Given the root of a binary tree, return the postorder traversal of its nodes values.

Example 1:
Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,6,7,5,2,9,8,3,1]

Example 3:
Input: root = []
Output: []

Example 4:
Input: root = [1]
Output: [1]

Solution 1: tc:O(N)  sc: O(N)
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(result,root);
        return result;
    }

    public void helper(List<Integer> result, TreeNode root){
        if(root==null) return;
        helper(result,root.left);
        helper(result,root.right);
        result.add(root.val);
    }
}

Solution 2: Iterative tc: O(N)  sc: O(N) 
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        while(root!=null || !stack.isEmpty()){
            if(root!=null){
                result.add(root.val);
                stack.push(root);
                root = root.right;
            }
            else{
                root = stack.pop();
                root=root.left;
            }
        }
        Collections.reverse(result);
        return result;
    }
}


Explaination:
Here in solution 2 we will do a trick like in general we first visit root so we will put root then visit right until its null and then pop all right and visit left
so its root->right->left and we will just reverse it all at last to get postorder:
left->right->root

