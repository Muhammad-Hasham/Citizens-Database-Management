import java.util.Scanner;

public class CCID {
    CCID_Node head;
    CCID_Node tail;
    SinglyLinkedList<Crime> crimes = new SinglyLinkedList<>();

   public CCID()
    {
        head = null;
        tail = null;
    }

    public CCID_Node getHead() {
        return head;
    }

    public void insert(CCID_Node new_node)
    {
        if( head == null )
        {
            head = new CCID_Node(new_node.getCNIC(), new_node.getCrimes().getHead().getMyData().getCharges(), new_node.getCrimes().getHead().getMyData().getPunishment(), new_node.getCrimes().getHead().getMyData().getFine(), new_node.cbid_ref);
            head.next = head;
            head.prev = head;
            tail = head;
        }
        else
        {
            // If the new node is smaller than the current head
            if(head.getCNIC() >= new_node.getCNIC())
            {
                new_node.next = head;
                head = new_node;
                head.next.prev = head;
                return;
            }

            // iterate over all and check where it fixes
            CCID_Node iter = head;
            
            do {
            	 iter = iter.next;
            }
            while(new_node.getCNIC() > iter.getCNIC() && iter != head);

            //System.out.println(iter.getCNIC() + " " + new_node.getCNIC());

            CCID_Node previousNode = iter.prev;
            previousNode.next = new_node;
            new_node.prev = previousNode;
            new_node.next = iter;
            iter.prev = new_node;


        }
    }

    public void removeCitizen(int cnic)
    {
        if ( head == null)
        {
            System.out.println("Person not exists");
        }
        else
        {

            if(cnic == head.getCNIC())
            {
                head.getCbid_ref().setCcid_ref(null);
                if (head == head.next){
                    head = null;
                }
                else {
                    CCID_Node previousNode = head.prev;
                    head = head.next;
                    head.prev = previousNode;
                    previousNode.next = head;
                }

            }
            else {
                CCID_Node iter = head;

                do {
                    iter = iter.next;
                }
                while (cnic != iter.getCNIC() && iter != head);
                iter.getCbid_ref().setCcid_ref(null);

                CCID_Node previousNode = iter.prev;
                CCID_Node nextNode = iter.next;

                previousNode.next = nextNode;
                nextNode.prev = previousNode;
            }

            
        }
    }

    public void printList()
    {
        CCID_Node iter = head;
        do{

            iter.cbid_ref.print();
            iter.print();
            System.out.println();
            iter = iter.next;
        }
        while(iter != head);
    }


    public void printReverse()
    {
        for(CCID_Node iter = tail ; iter != null ; iter = iter.prev)
        {
            iter.print();
        } 
    }

    public void addCrimes(){
        System.out.println("----------Adding New Crimes----------");
        System.out.println("Enter the person's cnic ");
        Scanner scan = new Scanner(System.in);
        int cnic = scan.nextInt();
        boolean flag = false;
        CCID_Node check = head;
        do{

            if(cnic == check.getCNIC()){
                flag= true;
            }
            check = check.next;
        }
        while(check != head);
        if(flag == false){
            System.out.println("This person does not exist");
            return;
        }

        CCID_Node iter = head;
        while (cnic != iter.getCNIC()) {
            iter = iter.next;
        }
        iter.print();
        System.out.println();


        System.out.println("Enter New Crime(murder,robbery etc)");
        Scanner scan1 = new Scanner(System.in);
        String crime = scan1.nextLine();

        System.out.println("Enter Punishment for the crime (5 years in prison etc)");
        Scanner scan2 = new Scanner(System.in);
        String punishment = scan2.nextLine();

        System.out.println("Enter Fine for the said crime(0,1000,10000 etc)");
        Scanner scan3 = new Scanner(System.in);
        int fine = scan3.nextInt();


        crimes.insert(new Crime(crime,punishment,fine));
        crimes.DisplaySingly();



    }

    public void UpdateCrime(){
        System.out.println("-----Updating Crimes-----");
        System.out.println("Enter the person's cnic to update");
        Scanner scan = new Scanner(System.in);
        int cnic = scan.nextInt();
        boolean flag = false;
        CCID_Node check = head;
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

        CCID_Node iter = head;
        while (cnic != iter.getCNIC()) {
            iter = iter.next;
        }

        iter.print();
        System.out.println();
        System.out.println("Enter New Charges(Input same data if you dont wish to change this)");
        Scanner scan1 = new Scanner(System.in);
        String newCharges = scan1.nextLine();

        System.out.println("Enter New Punishment(Input same data if you dont wish to change this)");
        Scanner scan2 = new Scanner(System.in);
        String newpun = scan2.nextLine();

        System.out.println("Enter New fine (Input same data if you dont wish to change this)");
        Scanner scan3 = new Scanner(System.in);
        int newfine = scan3.nextInt();
        removeCitizen(cnic);
        insert(new CCID_Node(cnic, newCharges, newpun, newfine, null));



    }

    public void DeleteCrime(){
        System.out.println("-----Deleting Crimes-----");
        System.out.println("Enter the person's cnic to delete");
        Scanner scan = new Scanner(System.in);
        int cnic = scan.nextInt();


        removeCitizen(cnic);
        System.out.println("Crimes has been deleted");

    }


}
