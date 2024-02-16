public class CCID_Node {
    //This class contains attributes, constructor, getters and setters
    private int CNIC;

    //generic linked list
    SinglyLinkedList<Crime> crimes = new SinglyLinkedList<>();

    CCID_Node next;
    CCID_Node prev;

    CBID_Node cbid_ref;



   public CCID_Node(int cnic,String charges, String punishment, int fine,  CBID_Node CBID_Ref)
    {
        CNIC = cnic;


        crimes.insert(new Crime (charges, punishment, fine));

        next = null;
        prev = null;

        cbid_ref = CBID_Ref;
    }

    public SinglyLinkedList<Crime> getCrimes() {
        return crimes;
    }

    public int getCNIC() {
	return CNIC;
}

public void setCNIC(int cNIC) {
	CNIC = cNIC;
}

public CCID_Node getNext() {
	return next;
}

public void setNext(CCID_Node next) {
	this.next = next;
}

public CCID_Node getPrev() {
	return prev;
}

public void setPrev(CCID_Node prev) {
	this.prev = prev;
}

public CBID_Node getCbid_ref() {
	return cbid_ref;
}

public void setCbid_ref(CBID_Node cbid_ref) {
	this.cbid_ref = cbid_ref;
}


    public void print()
    {
        System.out.printf("CNIC: %d, Charges: %s, Punishment: %s, Fine: %d\n", CNIC, getCrimes().getHead().getMyData().getCharges(), getCrimes().getHead().getMyData().getPunishment(), getCrimes().getHead().getMyData().getFine());
    }

    @Override
    public String toString() {
        return "CCID_Node{" +
                "CNIC=" + CNIC +
                ", crimes=" + crimes +
                ", next=" + next +
                ", prev=" + prev +
                ", cbid_ref=" + cbid_ref +
                '}';
    }
}
