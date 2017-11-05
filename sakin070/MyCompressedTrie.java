
/*** 
 * This is class implements a compressed trie that holds a set of strings.
 * MyCompressedTrie stores nodes using class TreeNodeWithData
 * 
 * Name: Saheed Akinbile   
 * Student Number: 8872464
 * Uottawa Email: sakin070@uottawa.ca
 * 
 *
 */
import java.util.ArrayList;
public class MyCompressedTrie {
	
	private TreeNodeWithData root;
	
	private int numNodes;
	
	public MyCompressedTrie() { // simple constructor (empty trie consisting of root only)
		root = new TreeNodeWithData(null, null, null,false,null);
		numNodes=1;
	}
	
	// to be implemented by you see handout Part 2A
	// Constructor that receives a regular trie and creates this
	// instance that is a compressed trie
	// 
	public MyCompressedTrie(MyTrie trie) { 
		this(); // call to the simple constructor above (empty trie consisting of root only)
		// **** a lot of code to be implemented here, with possible ***
		// calls to private auxiliary methods that you may want create.
		// now we just have a dummy method that prints a message.
		root = (TreeNodeWithData)trie.root();
		numNodes = trie.numNodes();
		compress(root.getLeftChild());
		compress(root.getRightChild());
	
	}
	


	
	private void compress(TreeNode node) {
		if(node == null) {
			return ;
		}
		TreeNode left = node.getLeftChild();
		TreeNode right = node.getRightChild();
		TreeNode parent = node.getParent();
		if(left== null && right == null){
			return;
		}

		if((left!= null && right!=null)){
			compress(left);	
			compress(right);
		}	

		else{
			if(!node.getIsUsed()) {
			
				if(left == null && right!= null){
					if(parent.getLeftChild() == node){
						parent.setLeftChild(right);
						right.setParent(parent);
						numNodes--;
					}
					else{
					// i want to find out something remember to undo
					//else if(parent.getRightChild() == node){
						parent.setRightChild(right);
						right.setParent(parent);
						numNodes--;
					}
					TreeNode rt = right;
					compress(rt);

				}
				else if(left != null && right== null){
					if(parent.getLeftChild() == node){
						parent.setLeftChild(left);
						left.setParent(parent);
						numNodes--;
					}
					else{
					//else if (parent.getRightChild() == node){
						parent.setRightChild(left);
						left.setParent(parent);
						numNodes--;
					}
					TreeNode lt = left;
					compress(lt);
				}
			
			}
			else{
				compress(left);	
				compress(right);
			}
		}
		
	
	}

	
	// Method to be implemented by you. See handout part 2A	
	public void printStringsInLexicoOrder() {
		// ***** method code to be added in this class *****
		// now we just have a dummy method that prints a message.
		visit(root);

	}
	
	private void visit(TreeNodeWithData node) {
		if(node.getIsUsed()) {
			System.out.println(node.getData());
		}
		
		if(node.getLeftChild()!= null) {
			visit((TreeNodeWithData)node.getLeftChild());
		}
		if (node.getRightChild()!= null) {
			visit((TreeNodeWithData)node.getRightChild());
		}
	}

	// the following method that calls its recursive counterpart
	// prints the tree and its data values at nodes in 
	// in-order traversal order
	
	public void printInOrder() { // not to be changed
		printInOrder(root);
	}
	
	private void printInOrder(TreeNode N) { // not to be changed
		System.out.print("(");
		if (N!=null) {
			printInOrder(N.getLeftChild());
			System.out.print(((TreeNodeWithData)N).getData());
			printInOrder(N.getRightChild());

		}
		System.out.print(")");
	}
	

	
	public int numNodes() {
		return numNodes;	
	}
	

}
