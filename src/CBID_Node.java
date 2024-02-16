public class CBID_Node {
	//This class contains CBID attributes, constructor, getters and setters
    private int CNIC;
    private String Name;
    private  String F_Name;
    private Character Gender;
    private int Age;
    private String Address;
    private String Nationality;

    CBID_Node next;
    CBID_Node prev;

    CCID_Node ccid_ref;
    CCND_Node ccnd_ref;

    public CBID_Node(int cnic, String name, String f_name, Character gender, int age, String address, String nationality)
    {
        CNIC = cnic;
        Name = name;
        F_Name = f_name;
        Gender = gender;
        Address = address;
        Nationality = nationality;
        Age = age;

        next = null;
        prev = null;

        ccid_ref = null;
		ccnd_ref =null;
    }

    public int getCNIC() {
		return CNIC;
	}

	public void setCNIC(int cNIC) {
		CNIC = cNIC;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getF_Name() {
		return F_Name;
	}

	public void setF_Name(String f_Name) {
		F_Name = f_Name;
	}

	public Character getGender() {
		return Gender;
	}

	public void setGender(Character gender) {
		Gender = gender;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	public CBID_Node getNext() {
		return next;
	}

	public void setNext(CBID_Node next) {
		this.next = next;
	}

	public CBID_Node getPrev() {
		return prev;
	}

	public void setPrev(CBID_Node prev) {
		this.prev = prev;
	}

	public CCID_Node getCcid_ref() {
		return ccid_ref;
	}

	public void setCcnd_ref(CCND_Node ccnd_ref) {
		this.ccnd_ref = ccnd_ref;
	}

	public CCND_Node getCcnd_ref() {
		return ccnd_ref;
	}

	public void setCcid_ref(CCID_Node ccid_ref) {
		this.ccid_ref = ccid_ref;
	}


// printing function to print CBID record
	public void print()
    {
        System.out.printf("CNIC: %d, Name: %s, Father Name: %s, Gender: %c, Age: %d, Address: %s, Nationality: %s\n", CNIC, Name, F_Name, Gender, Age, Address, Nationality);
    }

	@Override
	public String toString() {
		return "CBID_Node{" +
				"CNIC=" + CNIC +
				", Name='" + Name + '\'' +
				", F_Name='" + F_Name + '\'' +
				", Gender=" + Gender +
				", Age=" + Age +
				", Address='" + Address + '\'' +
				", Nationality='" + Nationality + '\'' +
				'}';
	}
}
