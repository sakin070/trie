/*** 
 * This is class implements a trie that holds a set of strings.
 * MyTrie stores stores nodes using class TreeNode
 * 
 * Name: Saheed Akinbile  
 * Student Number: 8872464
 * Uottawa Email: sakin070@uottawa.ca
 * 
 *
 */
import java.util.ArrayList;

public class MyTrie {
	
	private TreeNode root = null;
	private int numNodes;

    // Constructor. Note that an empty trie (no strings added) contains the root node 
	public MyTrie() {
		root = new TreeNodeWithData(null, null, null,false,null); 
		numNodes=1;
	}

	// Method to be implemented by you. See handout part 1A
	public boolean insert(String s) {
 
		// ***** method code to be added in this class *****
		// now we just have a dummy that prints  message and returns true.
		char[] charArray = s.toCharArray();
		TreeNodeWithData current = (TreeNodeWithData)root;
		for (int i= 0; i< charArray.length;i++) {
			if(i == charArray.length-1) {
				
				if(charArray[i]=='0') {
					if(current.getLeftChild() != null ) {
						if (current.getLeftChild().getIsUsed()) {
							return false;
							
						}
						else {
							current.getLeftChild().setIsUsed(true);
							((TreeNodeWithData)current.getLeftChild()).setData(s);//just freestyling
						}
						
					}
					else {
						current.setLeftChild(new TreeNodeWithData(current,null,null,true,s));
						numNodes++;
					}
					
					current = (TreeNodeWithData)current.getLeftChild();
				}
				else {
					if(current.getRightChild() !=null ) {
						if(current.getRightChild().getIsUsed()) {
							return false;
						}
						else {
							current.getRightChild().setIsUsed(true);
							((TreeNodeWithData)current.getRightChild()).setData(s);
						}
						
					}
					else {
						current.setRightChild(new TreeNodeWithData(current,null,null,true,s));
						numNodes++;
					}
					
					current = (TreeNodeWithData)current.getRightChild();
				}
				return true;
			}
			else {
				if(charArray[i]=='0') {
					if(current.getLeftChild() ==null ) {
						current.setLeftChild(new TreeNodeWithData(current,null,null,false,null));
						numNodes++;
					}
					current = (TreeNodeWithData)current.getLeftChild();
				}
				else {
					if(current.getRightChild() == null) {
						current.setRightChild(new TreeNodeWithData(current,null,null,false,null));
						numNodes++;
					}
					current = (TreeNodeWithData)current.getRightChild();
				}
			}
			
		}
		return false;

	}
	
	// Method to be implemented by you. See handout part 1A
	public boolean search(String s) {
		// **** method code to be added in this class *****
		// now we just have a dummy that prints  message and returns true.
		char[] charArray = s.toCharArray();
		TreeNode current = root;
		for(int i =0;i<charArray.length;i++) {
			if(current== null ) {
				return false;
			}
			if(i == charArray.length-1 ) {
				if(charArray[i]=='0') {
					current = current.getLeftChild();
				}
				else {
					current = current.getRightChild();
				}
				if(current== null ) {
					return false;
				}
				return current.getIsUsed();
				
			}
			else {
				if(charArray[i]=='0') {
					current = current.getLeftChild();
				}
				else {
					current = current.getRightChild();
				}
			}
		}
		return false;	
	    
	}

	

	// Method to be implemented by you. See handout part 1A	
	public void printStringsInLexicoOrder() {
		// ***** method code to be added in this class *****
		// now we just have a dummy method that prints a message.
		visit(root,"");

	}
	

	private void visit(TreeNode node,String r) {
		if(node.getIsUsed()) {
			System.out.println(r);
		}
		
		if(node.getLeftChild()!= null) {
			visit(node.getLeftChild(),r+"0");
			
			
		}
		if (node.getRightChild()!= null) {
			visit(node.getRightChild(),r+"1");
		}
	}
	


	// the following method that calls its recursive counterpart
	// prints the tree and its boolean values at nodes in 
	// in-order traversal order
	
	public void printInOrder() { // not to be changed
		printInOrder(root);
	}
	private void printInOrder(TreeNode N) { // not to be changed
		System.out.print("(");
		if (N!=null) {
			printInOrder(N.getLeftChild());
			System.out.print(N.getIsUsed());
			printInOrder(N.getRightChild());

		}
		System.out.print(")");
	}
	

	
	public TreeNode root() { // not to be changed
		return root;
	}
	
	public int numNodes() { // not to be changed
		return numNodes;
	}


}
