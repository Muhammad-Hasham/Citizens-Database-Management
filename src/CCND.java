import java.util.Scanner;

public class CCND {
        CCND_Node head;
        CCND_Node tail;
    SinglyLinkedList<Number> numbers = new SinglyLinkedList<>();

        public CCND()
        {
            head = null;
            tail = null;
        }

        public void insert(CCND_Node new_node)
        {
            if( head == null )
            {
                head = new CCND_Node(new_node.getCNIC(),new_node.getNumbers().getHead().getMyData().getNumber(),new_node.getNumbers().getHead().getMyData().getNetwork(),new_node.getNumbers().getHead().getMyData().getActivation_Date(),new_node.getNumbers().getHead().getMyData().getDeactivation_Date(),new_node.getNumbers().getHead().getMyData().getStatus(),new_node.cbid_ref2);
                head.next = head;
                tail = head;
            }
            else
            {
                // If the new node is smaller than the current head
                if(head.getCNIC() >= new_node.getCNIC())
                {
                    new_node.next = head;
                    head = new_node;

                    return;
                }

                // iterate over all and check where it fixes
                CCND_Node iter = head;
                CCND_Node prev = head;

                do {
                    prev = iter;
                    iter = iter.next;
                }
                while(new_node.getCNIC() > iter.getCNIC() && iter != head);

                //System.out.println(iter.getCNIC() + " " + new_node.getCNIC());

                //CCND_Node previousNode = iter.prev;
                prev.next = new_node;
               // new_node.prev = previousNode;
                new_node.next = iter;
               // iter.prev = new_node;

            }
        }



        public void printList()
        {
            CCND_Node iter = head;
            do{

                iter.print();
                iter.cbid_ref2.print();
                System.out.println();
                iter = iter.next;
            }
            while(iter != head);
        }


        public void printReverse()
        {
            for(CCND_Node iter = tail ; iter != null ; iter = iter.prev)
            {
                iter.print();
            }
        }
        public void AddNumber(){
            System.out.println("-----Adding New Number-----");
            System.out.println();

            System.out.println("Enter the person's cnic ");
            Scanner scan = new Scanner(System.in);
            int cnic = scan.nextInt();

            boolean flag = false;
            CCND_Node check = head;
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
            CCND_Node iter = head;
            while (cnic != iter.getCNIC()) {
                iter = iter.next;
            }
            iter.print();
            System.out.println();


            System.out.println("Enter New Number(6 digits)");
            Scanner scan1 = new Scanner(System.in);
            String newnumber = scan1.nextLine();

            System.out.println("Enter Network");
            Scanner scan2 = new Scanner(System.in);
            String network = scan2.nextLine();

            System.out.println("Enter Activation Date");
            Scanner scan3 = new Scanner(System.in);
            String act_date = scan3.nextLine();

            System.out.println("Enter Deactivation Date");
            Scanner scan4 = new Scanner(System.in);
            String deact_date = scan4.nextLine();

            System.out.println("Enter Status");
            Scanner scan5 = new Scanner(System.in);
            String status = scan5.nextLine();

            numbers.insert(new Number(newnumber, network, act_date,deact_date,status));
            numbers.DisplaySingly();


        }
        public void updateNumber(){

            System.out.println("Enter the person's cnic to update");
            Scanner scan = new Scanner(System.in);
            int cnic = scan.nextInt();
            boolean flag = false;
            CCND_Node check = head;
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

            CCND_Node iter = head;
            while (cnic != iter.getCNIC()) {
                iter = iter.next;
            }

            iter.print();
            System.out.println();
            System.out.println("Enter New Number");
            Scanner scan1 = new Scanner(System.in);
            String newNum = scan1.nextLine();
            iter.getNumbers().getHead().MyData.setNumber(newNum);
        }
        public void SwapNumbers()
        {
            System.out.println("Enter the first person's cnic ");
            Scanner scan = new Scanner(System.in);
            int cnic = scan.nextInt();
            boolean flag = false;
            CCND_Node check = head;
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

            CCND_Node iter = head;
            while (cnic != iter.getCNIC()) {
                iter = iter.next;
            }


            System.out.println("Enter the second person's cnic ");
            Scanner scan2 = new Scanner(System.in);
            int cnic2 = scan2.nextInt();
            boolean flag2 = false;
            CCND_Node check2 = head;
            do{

                if(cnic2 == check2.getCNIC()){
                    flag2= true;
                }
                check2 = check2.next;
            }
            while(check2 != head);
            if(flag2 == false){
                System.out.println("This person does not exist");
                return;
            }

            CCND_Node iter2 = head;
            while (cnic2 != iter2.getCNIC()) {
                iter2 = iter2.next;
            }
            System.out.println("Before Swap");
            iter.print();
            iter2.print();
            System.out.println("After Swap");
            String temp= iter.getNumbers().getHead().MyData.getNumber();
            iter.getNumbers().getHead().MyData.setNumber(iter2.getNumbers().getHead().MyData.getNumber());
            iter2.getNumbers().getHead().MyData.setNumber(temp);
            iter.print();
            iter2.print();

        }

        public void CountNetworks(){
            int Vodafone = 0, EE = 0, O2 = 0, Skymobile = 0, BTmobile = 0;
            CCND_Node current = head;
            do{}
            while(current != head);
                System.out.println(current.getNumbers().getHead().MyData.getNetwork());
                if(current.getNumbers().getHead().MyData.getNetwork().equals("Vodafone")){
                    Vodafone++;

                }
                else if(current.getNumbers().getHead().MyData.getNetwork().equals("EE")){
                    EE++;

                }
                else if(current.getNumbers().getHead().MyData.getNetwork().equals("O2")){
                    O2++;

                }
                else if(current.getNumbers().getHead().MyData.getNetwork().equals("Skymobile")){
                    Skymobile++;

                }
                else if(current.getNumbers().getHead().MyData.getNetwork().equals("BTmobile")){
                    BTmobile++;

                }
                
                current = current.next;
            System.out.println("Vodafone Network count " + Vodafone);
            System.out.println("EE Network count " + EE);
            System.out.println("O2 Network count "+ O2);
            System.out.println("Skymobile Network count " + Skymobile);
            System.out.println("BTmobile Network count " + BTmobile );
            }

        }




