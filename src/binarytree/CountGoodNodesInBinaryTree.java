package binarytree;

import binarytree.tree.BinaryTree;
import binarytree.tree.TreeNode;

//https://leetcode.com/problems/count-good-nodes-in-binary-tree/
public class CountGoodNodesInBinaryTree {
	
	public int dfs(TreeNode node,int maxVal) {
		if(node==null) return 0;
		int res=node.val>=maxVal?1:0;

		maxVal=Math.max(maxVal, node.val);
		res+=dfs(node.left,maxVal)+dfs(node.right,maxVal);
		return res;
		
	}

	public int goodNodes(TreeNode root) {
		return dfs(root,root.val);
	}

	public static void main(String[] args) {
		CountGoodNodesInBinaryTree cgnib=new CountGoodNodesInBinaryTree();
		System.out.println(cgnib.goodNodes(BinaryTree.createTree(new Integer [] {3,1,4,3,null,1,5})));

	}

}
