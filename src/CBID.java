import java.util.Scanner;

public class CBID {
    // this class is based doubly linked list and contains CBID functions
    CBID_Node head;
    CBID_Node tail;

    SinglyLinkedList<CBID_Node> alien_database = new SinglyLinkedList<>();
// initializing head and tail
    public CBID() {
        head = null;
        tail = null;
    }


    public SinglyLinkedList<CBID_Node> getAlien_database() {
        return alien_database;
    }
// Insert function to populate file with CBID data
    //This function automatically arranges CNICs in ascending order without the need for a sorting function
    public void insert(CBID_Node new_node) {
        if (head == null) {
            head = new CBID_Node(new_node.getCNIC(), new_node.getName(), new_node.getF_Name(), new_node.getGender(), new_node.getAge(), new_node.getAddress(), new_node.getNationality());
            head.next = null;
            head.prev = null;
            tail = head;
        } else {
            // If the new node is smaller than the current head
            if (head.getCNIC() >= new_node.getCNIC()) {
                new_node.next = head;
                head = new_node;
                head.next.prev = head;
                return;
            }

            // iterate over all and check where it fixes
            CBID_Node iter = head;
            for (; new_node.getCNIC() > iter.getCNIC() && iter.next != null; iter = iter.next) {
            }


            if (new_node.getCNIC() <= iter.getCNIC()) {
                new_node.next = iter;
                iter.prev.next = new_node;
                new_node.prev = iter.prev;
                iter.prev = new_node;
                return;
            }

            // iter is currently our last node, just insert new_node after it

            new_node.prev = iter;
            iter.next = new_node;
            tail = new_node;
        }
    }
// This function removes a cnic from the CBID database
    // It automatically locates a node from head,tail or middle and deletes it
    public void removeCitizen(int cnic) {
        CBID_Node iter = head;

        while (iter != null) {
            if (cnic == iter.getCNIC())
                break;

            iter = iter.next;
        }

        if (iter == null) {
            System.out.println("Person does not exist in the database");
        } else {
            if (head.getCNIC() == iter.getCNIC() && cnic == iter.getCNIC()) {
                // object to remove is at head
                head = iter.next;
                head.prev = null;
                return;
            }
            if (tail.getCNIC() == iter.getCNIC() && cnic == iter.getCNIC()) {
                // object to remove is at tail
                tail = tail.prev;
                tail.next = null;
                return;
            }
            //Object is in the middle

            iter.prev.next = iter.next;
            iter.next.prev = iter.prev;
            return;

        }
    }
//This is a printing function that has references for CCID and CCND databases and prints of of the information at the same time
    public void printList() {
        for (CBID_Node iter = head; iter != null; iter = iter.next) {
            System.out.println();
            iter.print();
            if (iter.ccid_ref != null) {

                iter.ccid_ref.print();
                iter.ccnd_ref.print();

            }
        }
    }

// A testing function for ease and understanding
    //Not used in code
    public void printReverse() {
        for (CBID_Node iter = tail; iter != null; iter = iter.prev) {
            iter.print();
        }
    }
// This functions acts a Link for CCID Object and connects CBID with CCID and CCND
    public CCID_Node link_refernce_to_CCID_object(CCID_Node node) {
        CBID_Node iter = head;
        while (iter != null) {
            if (node.getCNIC() == iter.getCNIC())
                break;
            iter = iter.next;
        }

        if (iter == null) {
            System.out.println("No referece exists for CNIC: " + node.getCNIC());
        } else {
            iter.ccid_ref = node;
            node.cbid_ref = iter;
        }
        return node;
    }
// This functions acts a Link for CNID Object and connects CBID with CCID and CCND
    public CCND_Node link_refernce_to_CCND_object(CCND_Node node) {
        CBID_Node iter = head;
        while (iter != null) {
            if (node.getCNIC() == iter.getCNIC())
                break;
            iter = iter.next;
        }

        if (iter == null) {
            System.out.println("No referece exists for CNIC: " + node.getCNIC());
        } else {
            iter.ccnd_ref = node;
            node.cbid_ref2 = iter;

        }
        return node;
    }
// Update function to update records for CBID database
    // Also used to change nationality to "Alien"
    public void updateCBIDrecord() {

        System.out.println("Enter the person's cnic to update");
        Scanner scan = new Scanner(System.in);
        int cnic = scan.nextInt();
        boolean flag = false;
        CBID_Node check = head;
        while(check != null){
            if(cnic == check.getCNIC()){
                flag= true;
            }
            check = check.next;
        }
        if(flag == false){
            System.out.println("This person does not exist");
            return;
        }

        CBID_Node iter = head;

        while (cnic != iter.getCNIC()) {
            iter = iter.next;
        }

                iter.print();
                System.out.println();
                System.out.println("Enter New First Name (Enter original name if you dont want to change)");
                Scanner scan1 = new Scanner(System.in);
                String name = scan1.nextLine();

                System.out.println("Enter New Father's First Name (Enter original name if you dont want to change)");
                Scanner scan2 = new Scanner(System.in);
                String f_name = scan2.nextLine();

                System.out.println("Enter New Address (Enter original name if you dont want to change)");
                Scanner scan4 = new Scanner(System.in);
                String address = scan4.nextLine();

                System.out.println("Enter New Age (Enter original name if you dont want to change)");
                Scanner scan5 = new Scanner(System.in);
                int age = scan5.nextInt();

                System.out.println("Enter New Nationality (Enter original name if you dont want to change)");
                Scanner scan6 = new Scanner(System.in);
                String nationality = scan6.nextLine();

                iter.setName(name);
                iter.setF_Name(f_name);
                iter.setAddress(address);
                iter.setAge(age);
                iter.setNationality(nationality);
                if (nationality.equalsIgnoreCase("alien")) {
                    getAlien_database().insert(iter);
                    getAlien_database().DisplaySingly();
                    removeCitizen(cnic);



                } else {
                    System.out.println();
                    System.out.println("Record after changes");
                    iter.print();
                    System.out.println();

                }

            }
// Search Function to print a single record with all of it's information from other databases
            public void SearchCBID(){ //////// add person does not exist

                System.out.println("Enter the person's cnic ");
                Scanner scan = new Scanner(System.in);
                int cnic = scan.nextInt();

                CBID_Node iter = head;
                while (cnic != iter.getCNIC()) {
                    iter = iter.next;
                }

                iter.print();
                iter.ccid_ref.print();
                iter.ccnd_ref.print();

                System.out.println();
            }
    // Search Function to print a single record with all of it's information from other databases
    public void SearchCCID(){ //////// add person does not exist

        System.out.println("Enter the person's cnic ");
        Scanner scan = new Scanner(System.in);
        int cnic = scan.nextInt();

        CBID_Node iter = head;
        while (cnic != iter.getCNIC()) {
            iter = iter.next;
        }

        iter.print();
        iter.ccid_ref.print();
        iter.ccnd_ref.print();

        System.out.println();
    }
    // Search Function to print a single record with all of it's information from other databases
    public void SearchCCND(){ //////// add person does not exist

        System.out.println("Enter the person's cnic ");
        Scanner scan = new Scanner(System.in);
        int cnic = scan.nextInt();

        CBID_Node iter = head;
        while (cnic != iter.getCNIC()) {
            iter = iter.next;
        }

        iter.print();
        iter.ccid_ref.print();
        iter.ccnd_ref.print();

        System.out.println();
    }

//    public void printAlienDatabase(){
//
//        Singly_Node current = alien_database.head;
//        while(current != null){
//            System.out.println(current.);
//            current = current.next;
//        }
//    }
        }





