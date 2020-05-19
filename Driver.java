import java.util.Collection;
import java.util.LinkedList;

// This is the main class. I do not regret calling it for what it is :) I did this project 3 times before I got it right.
public class Driver {
	
    public static void main(String [] args) {
    	
    	
    	// This part of the code builds the Tree from the ground up
    	// Feel free to make your own trees. This tree is the same from the example in the Word Document
    	// PLEASE USE LINKED LISTS FOR EVERYTHING. THAT IS THE PREFERRED COLLECTION FOR THIS ASSIGNMENT!
    	// ON THE SEARCH(Node, key, index) METHOD, the index ALWAYS has to start at 0, so when calling it in your own test, always make sure the index parameter starts at 0
    	Collection<Integer> ar1 = new LinkedList<Integer>();
    	ar1.add(100);
    	ar1.add(120);
    	ar1.add(140);
    	ar1.add(160);
    	Collection<Integer> ar2 = new LinkedList<Integer>();
    	ar2.add(200);
    	ar2.add(220);
    	ar2.add(240);
    	ar2.add(260);
    	Collection<Integer> ar3 = new LinkedList<Integer>();
    	ar3.add(300);
    	ar3.add(320);
    	ar3.add(340);
    	ar3.add(360);
    	
    	Collection<Node> Nodes1100 = new LinkedList<Node>();
    	Collection<Node> Nodes100199 = new LinkedList<Node>();
    	Collection<Node> Nodes200399 = new LinkedList<Node>();
    	Collection<Node> Nodes300399 = new LinkedList<Node>();
        
    	LeafNode Leaf100199 = new LeafNode(ar1);
        LeafNode Leaf200299 = new LeafNode(ar2);
        LeafNode Leaf300399 = new LeafNode(ar3);
        
        Nodes100199.add(Leaf100199);
        Nodes200399.add(Leaf200299);
        Nodes300399.add(Leaf300399);
        RootNode rNode300399 = new RootNode(300, 399, Nodes300399);
        Nodes200399.add(rNode300399);
        RootNode rNode200399 = new RootNode(200, 399, Nodes200399);
        RootNode rNode100199 = new RootNode(100, 199, Nodes100199);
        Nodes1100.add(rNode100199);
        Nodes1100.add(rNode200399);
        RootNode MainRootNode = new RootNode(1, 1000, Nodes1100);
        
        // These values exist in the Tree
        System.out.println("Searching 100, Must be True: " + search(MainRootNode, 100, 0));
        System.out.println("Searching 120, Must be True: " + search(MainRootNode, 120, 0));
        System.out.println("Searching 140, Must be True: " + search(MainRootNode, 140, 0));
        System.out.println("Searching 160, Must be True: " + search(MainRootNode, 160, 0));
        System.out.println("Searching 200, Must be True: " + search(MainRootNode, 200, 0));
        System.out.println("Searching 220, Must be True: " + search(MainRootNode, 220, 0));
        System.out.println("Searching 240, Must be True: " + search(MainRootNode, 240, 0));
        System.out.println("Searching 260, Must be True: " + search(MainRootNode, 260, 0));
        System.out.println("Searching 300, Must be True: " + search(MainRootNode, 300, 0));
        System.out.println("Searching 320, Must be True: " + search(MainRootNode, 320, 0));
        System.out.println("Searching 340, Must be True: " + search(MainRootNode, 340, 0));
        System.out.println("Searching 360, Must be True: " + search(MainRootNode, 360, 0));
        
        // These values don't exist in the Tree
        System.out.println("Searching 20, Must be False: " + search(MainRootNode, 20, 0));
        System.out.println("Searching -20, Must be False: " + search(MainRootNode, -20, 0));
        System.out.println("Searching 2000, Must be False: " + search(MainRootNode, 2000, 0));
        System.out.println("Searching 210, Must be False: " + search(MainRootNode, 210, 0));
        
        
    }
    
    /* If the collection in the leafnode is empty, return false
     * else if the index parameter is equal to the size of the leafnode's collection, we are out of bounds, so return false;
     * else if the spot we are in on the list is null, return false
     * else if the element on the list is not null and is the number we are looking for, return true
     * else if the element on the list is not null and is not the number we are looking for, return recursive LeafSearch for the next index (so index + 1)
     */ 
    
    public static boolean leafSearch(Node node, int val, int index) {
    	
    	if (((LeafNode) node).getCollection().isEmpty()) {
    		return false;
    	} else if (index == ((LeafNode) node).getCollection().size()) {
    		return false;
    	} else if(((LinkedList<Integer>)((LeafNode) node).getCollection()).get(index) == null) {
    		return false;
    	} else if (((LinkedList<Integer>)((LeafNode) node).getCollection()).get(index) != null && (((LinkedList<Integer>)((LeafNode) node).getCollection()).get(index)) == val) {
   				return true;
    	} else if (((LinkedList<Integer>)((LeafNode) node).getCollection()).get(index) != null && !((((LinkedList<Integer>)((LeafNode) node).getCollection()).get(index)) == val)){
    		return leafSearch(node, val, index + 1);
    	}
		return false;
    	
    }
	
	
    /* If the size of the Collection of Nodes is equal to the index, we are out of bounds, so return false
     * if the value we are searching for is less than the minimum of the current RootNode or greater than the Maximum, return false
     * else if The current element of the Collection of Nodes is an instance of a RootNode, if the size is not equal to the index parameter (so we don't run out of bounds), and the key is within the bounds of the RootNode we are investigating, we recursively search that RootNode and traverse down
     * else if the current Node is an instance of a LeafNode, we search the leaf using the leafSearch method above, and if its not in the list, we simply proceed, else, if we do find it, its obviously going to be true
     * in the end we simply return the search function again (recursion) with the index as index + 1 so we can investigate the next Node in the Collection
     */ 
	public static boolean search(Node root, int key, int index) {
		
		if (index == ((LinkedList<Node>)((RootNode) root).getNodes()).size()) {
			return false;
		}
		
		if (key < ((RootNode)root).getMin() || key > ((RootNode)root).getMax()) {
			return false;
		} else if ((((LinkedList<Node>)((RootNode) root).getNodes()).get(index)) instanceof RootNode) {
			if (((LinkedList<Node>)((RootNode) root).getNodes()).size() != index && key >= ((RootNode)((LinkedList<Node>)((RootNode) root).getNodes()).get(index)).getMin() && key <= ((RootNode)((LinkedList<Node>)((RootNode) root).getNodes()).get(index)).getMax()) {
				return search(((RootNode)((LinkedList<Node>)((RootNode) root).getNodes()).get(index)), key, 0);
			}
			
		} else if ((((LinkedList<Node>)((RootNode) root).getNodes()).get(index)) instanceof LeafNode){
			if(leafSearch(((LeafNode)((LinkedList<Node>)((RootNode) root).getNodes()).get(index)), key, 0) == false) {
				
			} else {
				return true;
			}
		}
		return search(((RootNode)root), key, index + 1);
		
	}
	
	
	
	
	
}

