package com.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 深度优先查找
 *
 * @author jianzhen.yin
 * @date 2020/9/28
 */
public class DFS {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public List<TreeNode> searchDFS(TreeNode root){
        List<TreeNode> nodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()){
            TreeNode node = stack.peek();
            nodes.add(node);
            stack.pop();
            // 先压右 再压左
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return nodes;
    }
}
