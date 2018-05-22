
public class SinglyLinkedList {
	private Node head;
	
	public SinglyLinkedList() {
		this.setHead(null);
	}
	public SinglyLinkedList(Integer val) {
		this.setHead(new Node(val));
	}
	
	public SinglyLinkedList add(Integer val) {
		if(this.getHead() == null) {
			this.setHead(new Node(val));
		}
		else {
			Node runner = this.getHead();
			while (runner.getNext() != null) {
				runner = runner.getNext();
			}
			runner.setNext(new Node(val));
		}
		return this;
	}
	
	public SinglyLinkedList removeEnd() {
		if (this.getHead() == null) {
			System.out.println("Empty List");
		}
		Node runner = this.getHead();
//		System.out.println(runner.getVal());
		while(runner.getNext() != null) {	
			if(runner.getNext().getNext() != null) {
				runner = runner.getNext();
//				System.out.println(runner.getVal());
			}
			else if(runner.getNext().getNext() == null) {
					runner.setNext(runner.getNext().getNext());
//					return this;
			}
		}
		this.printValues();
		return this;
	}
	
	public SinglyLinkedList printValues() {
		if (this.getHead() == null) {
			System.out.println("Empty List");
		}
		Node runner = this.getHead();
		while(runner != null) {
			System.out.println(runner.getVal());
			runner = runner.getNext(); 
		}
		return this;
	}
	
	public Node contains(Integer match) {
		if (this.getHead() == null) {
			System.out.println("SLL is empty and does not contain value.");
			return null;
		}
		else if (this.getHead().getVal() == match) {
			System.out.println(this.getHead());
			return this.getHead();
		}
		else if (this.getHead().getVal() != match) {
			Node runner = this.getHead();
			while(runner.getNext() != null) {
				if(runner.getNext().getVal() == match) {
					System.out.println(runner.getNext());
					return runner.getNext();
				}
				runner = runner.getNext();
			}
		}
		System.out.println("SLL has no nodes containing value");
		return null;
	}
	
	public Integer removeAt(Integer location) {
		this.printValues();
		if (this.getHead() == null) {
			System.out.println("SLL is empty no values removed.");
			return -1;
		}

		Integer index = 0;
		if (index == location) {
			this.setHead(this.getHead().getNext());
			this.printValues();
			return index;
		}
		Node runner = this.getHead();
		Integer index1 = 0;
		while (runner.getNext() != null) {
			
			if (index1 + 1 == location) {
				runner.setNext(runner.getNext().getNext());
				this.printValues();
				return location;
			}
			else if (index1 + 1 != location) {
				runner = runner.getNext();
				index1 += 1;
				System.out.println("Runner Value" + runner.getVal());
			}
		}
		System.out.println("SLL does not contain " + location + "nodes.");
		return -1;
	}

	
	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	
}
