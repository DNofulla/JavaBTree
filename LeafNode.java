import java.util.Collection;
import java.util.LinkedList;

// The LeafNode class extends to the Node class
public class LeafNode extends Node {
	
	// This is the Collection of Integers every LeafNode should have, as a LinkedList of Integers
    private Collection<Integer> collection = new LinkedList<Integer>();

    // Empty LeafNode Constructor
    public LeafNode() {
    	
    }
    
    // Required LeafNode Constructor. Create a LeafNode using this constructor
    public LeafNode(Collection<Integer> collection) {
        this.collection = collection;
    }
    
    // Gets the Collection of Integers
    public Collection<Integer> getCollection() {
        return collection;
    }
    
    
    
}
