
public class CCND_Node {

	private int CNIC;

    
    CCND_Node next;
    CCND_Node prev;

    CBID_Node cbid_ref2;

	SinglyLinkedList<Number> numbers = new SinglyLinkedList<>();

	public CCND_Node(int cNIC, String number, String netwrok, String activation_Date, String deactivation_Date,
					 String status, CBID_Node CBID_Ref2) {
		CNIC = cNIC;

		numbers.insert(new Number (number, netwrok, activation_Date,deactivation_Date,status));
		next= null;
		prev= null;
		
		cbid_ref2 = CBID_Ref2;
	}

	public SinglyLinkedList<Number> getNumbers() {
		return numbers;
	}

	public int getCNIC() {
		return CNIC;
	}

	public void setCNIC(int cNIC) {
		CNIC = cNIC;
	}

	public CCND_Node getNext() {
		return next;
	}

	public void setNext(CCND_Node next) {
		this.next = next;
	}

	public CCND_Node getPrev() {
		return prev;
	}

	public void setPrev(CCND_Node prev) {
		this.prev = prev;
	}

	public CBID_Node getCbid_ref2() {
		return cbid_ref2;
	}

	public void setCbid_ref2(CBID_Node cbid_ref2) {
		this.cbid_ref2 = cbid_ref2;
	}
    

	public void print()
	{
		System.out.printf("CNIC: %d, Number: %s, Network: %s, Activation Date: %s, Deactivation Date: %s , Status: %s\n", CNIC, getNumbers().getHead().getMyData().getNumber(),getNumbers().getHead().getMyData().getNetwork(),getNumbers().getHead().getMyData().getActivation_Date(),getNumbers().getHead().getMyData().getDeactivation_Date(),getNumbers().getHead().getMyData().getStatus());
	}
	
}
