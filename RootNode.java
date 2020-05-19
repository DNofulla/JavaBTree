import java.util.Collection;

// We extend the RootNode class to the Node class
public class RootNode extends Node {
    private int min; // Lower Bound of RootNode
    private int max; // Upper Bound of RootNode
    private Collection<Node> nodes; // Collection of Nodes in RootNode
    
    // Default Empty Constructor. Does Nothing.
    public RootNode() {
    	
    }
    
    // Required RootNode Constructor. Create a RootNode using this constructor
    public RootNode(int min, int max, Collection<Node> nodes) {
        this.min = min;
        this.max = max;
        this.nodes = nodes;
    }
    
    // Gets the lower bound
    public int getMin() {
        return min;
    }
    
    // Gets the upper bound
    public int getMax() {
        return max;
    }

    // Gets the Collection of Nodes
    public Collection<Node> getNodes() {
        return nodes;
    }
    
    // Adds Nodes to the collection of nodes
    public void addNode(Node n) {
        this.nodes.add(n);
    }
    
}
