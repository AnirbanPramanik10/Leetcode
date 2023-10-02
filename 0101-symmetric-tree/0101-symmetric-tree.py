# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root):
        if root is None:
            return True
        return self.isMirror(root.left, root.right)
    
    def isMirror(self, leftSubtree, rightSubtree):
        if leftSubtree is None and rightSubtree is None:
            return True
        if leftSubtree is None or rightSubtree is None:
            return False
        
        return (leftSubtree.val == rightSubtree.val) and \
               self.isMirror(leftSubtree.left, rightSubtree.right) and \
               self.isMirror(leftSubtree.right, rightSubtree.left)

        