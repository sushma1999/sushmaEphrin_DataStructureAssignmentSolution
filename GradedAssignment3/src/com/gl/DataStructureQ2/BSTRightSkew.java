package com.gl.DataStructureQ2;

public class BSTRightSkew {
public Node root;
		
		Node prevNode = null;
		Node headNode = null;
		
		public class Node
		{
			public int key;
			public Node left;
			public Node right;
		}

		public Node newNode(int data) 
		{
			Node temp = new Node();
			
			temp.key = data;
			temp.left = null;
			temp.right = null;
			
			return temp;
		}
		
		public void skewedTree(Node root) {
			if (root == null) 
			{
				return;
			}
			
			skewedTree(root.left);
			
			Node rightNode = root.right;
					
			if (headNode == null)
			{
				headNode = root;
				root.left = null;
				prevNode = root;
			} else {
				prevNode.right = root;
				root.left = null;
				prevNode = root;
			}
			
			skewedTree(rightNode);
		}
		 
		public void Show() {
			
			if (headNode == null) 
			{
				return;
			}
			
			System.out.print(headNode.key + " ");
			headNode = headNode.right;
			Show();
		}
	}