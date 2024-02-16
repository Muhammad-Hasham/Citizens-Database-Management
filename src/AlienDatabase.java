public class AlienDatabase {
// This class contains Alien Database attributes, constructor, getters and setters
    private int CNIC;
    private String Name;
    private  String F_Name;
    private Character Gender;
    private int Age;
    private String Address;
    private String Nationality;

    public AlienDatabase(int cNIC, String name, String f_Name, Character gender, int age, String address,
                         String nationality) {
        CNIC = cNIC;
        Name = name;
        F_Name = f_Name;
        Gender = gender;
        Age = age;
        Address = address;
        Nationality = nationality;
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


}
