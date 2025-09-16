783. Minimum Distance Between BST Nodes
Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.

Example 1:
Input: root = [4,2,6,1,3]
Output: 1

Example 2:
Input: root = [1,0,48,null,null,12,49]
Output: 1

Constraints:
The number of nodes in the tree is in the range [2, 100].
0 <= Node.val <= 105

Solution: tc: O(N)   sc: O(N)   //recursion space
class Solution {
    int res = Integer.MAX_VALUE;
    Integer pre = null;
    public int minDiffInBST(TreeNode root) {
        if(root.left!=null) minDiffInBST(root.left);
        if(pre!=null) res = Math.min(res, root.val-pre);
        pre = root.val;
        if(root.right!=null) minDiffInBST(root.right);

        return res;
    }
}

Explaination:
Why Inorder Traversal?
Inorder traversal of a BST gives nodes in sorted order (smallest → largest).
That means the minimum difference must occur between two consecutive values in sorted order.

Example:
BST values → [1, 3, 6, 10]
Differences → [3-1, 6-3, 10-6]
The smallest difference will always be between two adjacent numbers in this sorted list.
If you used preorder or postorder, nodes wouldn’t be visited in ascending order — you might compare nodes that are far apart in value and miss the true minimum difference.