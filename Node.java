// The Node Class
public class Node {
    
	private int data; // This is where the integer of Node is held

	// Empty Node Constructor. Does Nothing
    public Node() {
    	
    }
    
    // This is the normal Node Constructor. Assigns the integer data parameter to the integer data field for the Node Class
    public Node(int data) {
    	this.data = data; 
    }
    
    // This just returns the Data Field from the Node Class
    public int getData() {
        return data;
    }
}
