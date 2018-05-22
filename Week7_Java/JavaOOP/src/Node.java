
public class Node {
	private Integer val;
	private Node next;
	
	//constructor
	public Node(Integer val) {
		this.val = val;
		this.next = null;
	}
	
	//getters
	public Integer getVal() {
		return val;
	}
	public Node getNext() {
		return next;
	}
	
	//setters
	public void setVal(Integer val) {
		this.val = val;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
}
