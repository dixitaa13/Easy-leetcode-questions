543. Diameter of Binary Tree
Given the root of a binary tree, return the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
The length of a path between two nodes is represented by the number of edges between them.

Example 1:

Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1

Solution 1: DFS tc: O(N)  sc: O(N) (worst case for skewed tree) and O(log n) best case for balanced tree

class Solution {
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }

    public int dfs(TreeNode root){
        if(root==null) return 0; //if tree is empty then return height as 0 

        int leftlength = dfs(root.left); // to calculate left path
        int rightlength = dfs(root.right); // to calculate right path

        result = Math.max(result,leftlength+rightlength); //on current node calculate depth of left subtree and right subtree 

        return 1+Math.max(leftlength, rightlength); //calculate max between both subtrees
    }
}

Explaination of this code:
    1
   / \
  2   3
 / \
4   5

dfs(4) → returns 1 (leaf).
dfs(5) → returns 1.

At node 2:
left = 1, right = 1 → res = max(0, 1+1) = 2.
return 1 + max(1,1) = 2.

At node 3:
returns 1.

At node 1:
left = 2, right = 1 → res = max(2, 2+1) = 3.

return 1 + max(2,1) = 3.

✅ Final diameter = 3 (path [4 → 2 → 1 → 3]).
