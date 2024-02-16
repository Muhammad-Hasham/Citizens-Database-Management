import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Citizens_Database{
    CBID cbid_list;
    CCID ccid_list;
    CCND ccnd_list;


    Citizens_Database()
    {
        generate_cbidlist_from_file();
        generate_ccidlist_from_file();
        generate_ccndlist_from_file();
        
    }
    //File Handling
    public void generate_cbidlist_from_file()
    {
        cbid_list = new CBID();
        try {
            File file = new File("cbid.txt");
            Scanner fileReader;
            fileReader = new Scanner(file);

            while( fileReader.hasNextLine() )
            {
                String line = fileReader.nextLine();

                int cnic = Integer.parseInt(line.substring(0, line.indexOf(' ', 0))) ;
                line = line.substring(line.indexOf(' ', 0) + 1, line.length());
                
                String name = line.substring(0, line.indexOf(' ', 0));
                line = line.substring(line.indexOf(' ', 0) + 1, line.length());

                String f_name = line.substring(0, line.indexOf(' ', 0));
                line = line.substring(line.indexOf(' ', 0) + 1, line.length());
                
                Character gender = line.substring(0, line.indexOf(' ', 0)).charAt(0);
                line = line.substring(line.indexOf(' ', 0) + 1, line.length());

                int age = Integer.parseInt(line.substring(0, line.indexOf(' ', 0))) ;
                line = line.substring(line.indexOf(' ', 0) + 1, line.length());


                String address = "";
                String nationality = "";

                while( line.indexOf(' ', 0) != -1)
                {
                    address += line.substring(0, line.indexOf(' ', 0)) + " ";
                    line = line.substring(line.indexOf(' ', 0) + 1, line.length());
                }
                nationality = line;



                CBID_Node node = new CBID_Node(cnic, name, f_name, gender, age, address, nationality);
                cbid_list.insert(node);
            }

            fileReader.close();

        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }
    //File Handling
    public void generate_ccidlist_from_file()
    {
        ccid_list = new CCID();
        try {
            File file = new File("ccid.txt");
            Scanner fileReader;
            fileReader = new Scanner(file);

            while( fileReader.hasNextLine() )
            {
                String line = fileReader.nextLine();

                int cnic = Integer.parseInt(line.substring(0, line.indexOf(' ', 0))) ;
                line = line.substring(line.indexOf(' ', 0) + 1, line.length());
                
                String charges = line.substring(0, line.indexOf(' ', 0));
                line = line.substring(line.indexOf(' ', 0) + 1, line.length());

                String punishment = "";
                int fine = 0;

                while( line.indexOf(' ', 0) != -1)
                {
                    punishment += line.substring(0, line.indexOf(' ', 0)) + " ";
                    line = line.substring(line.indexOf(' ', 0) + 1, line.length());
                }

                if(!line.equals("-"))
                    fine =  Integer.parseInt(line);



                CCID_Node node = new CCID_Node(cnic, charges, punishment, fine, null);
                node = cbid_list.link_refernce_to_CCID_object(node);
                ccid_list.insert(node);
            }

            fileReader.close();

        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }
    //File Handling
    public void generate_ccndlist_from_file()
    {
        ccnd_list = new CCND();
        try {
            File file = new File("ccnd.txt");
            Scanner fileReader;
            fileReader = new Scanner(file);

            while( fileReader.hasNextLine() )
            {
                String line = fileReader.nextLine();

                int cnic = Integer.parseInt(line.substring(0, line.indexOf(' ', 0))) ;
                line = line.substring(line.indexOf(' ', 0) + 1, line.length());

                String number = line.substring(0, line.indexOf(' ', 0));
                line = line.substring(line.indexOf(' ', 0) + 1, line.length());

                String network = line.substring(0, line.indexOf(' ', 0));
                line = line.substring(line.indexOf(' ', 0) + 1, line.length());

                String activation_date = line.substring(0, line.indexOf(' ', 0));
                line = line.substring(line.indexOf(' ', 0) + 1, line.length());

                String deactivation_date = "";
                String status = "";

                while( line.indexOf(' ', 0) != -1)
                {
                    deactivation_date += line.substring(0, line.indexOf(' ', 0)) + " ";
                    line = line.substring(line.indexOf(' ', 0) + 1, line.length());
                }
                status = line;


                CCND_Node node = new CCND_Node(cnic, number, network, activation_date, deactivation_date, status, null);
                node = cbid_list.link_refernce_to_CCND_object(node);

                ccnd_list.insert(node);
            }

            fileReader.close();

        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }
    //functions for easier printing access
    public CCID getCcid_list() {
        return ccid_list;
    }

    public void print_ccid_list()
    {
        ccid_list.printList();
    }

    public void print_cbid_list()
    {
        cbid_list.printList();
    }

    public void print_ccnd_list(){ ccnd_list.printList();}
// Menu for easy use of program
    public void menu() {
        while(true) {

            System.out.println("Press 1 to Search from CBID to Display a Record from Existing Databases");
            System.out.println("Press 2 to Search from CCID to Display a Record from Existing Databases");
            System.out.println("Press 3 to Search from CCND to Display a Record from Existing Databases");
            System.out.println("Press 4 to Display Alien Database");
            System.out.println("Press 5 to Display all records of CBID Database");
            System.out.println("Press 6 to Update a Record in CBID");
            System.out.println("Press 7 to Update a number");
            System.out.println("Press 8 to Add New Crime and its details");
            System.out.println("Press 9 to Delete Crimes");
            System.out.println("Press 10 to Update Crime Records");
            System.out.println("Press 11 to Add a new Number");
            System.out.println("Press 12 to Swap Ownership of Two Registered Numbers.");
            System.out.println("Press 13 to Display count of Cell phone Numbers Registered on each Network");
            System.out.println("Press 0 to exit program");
            System.out.println();

            System.out.println("Enter your choice");
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            switch(choice) {
                case 1:
                    cbid_list.SearchCBID();
                    break;

                case 2:
                    cbid_list.SearchCCID();
                    break;

                case 3:
                    cbid_list.SearchCCND();
                    break;

                case 4:
                    cbid_list.getAlien_database().DisplaySingly();
                    break;

                case 5:
                    print_cbid_list();
                    break;

                case 6:
                    cbid_list.updateCBIDrecord();
                    break;

                case 7:
                    ccnd_list.updateNumber();
                    break;

                case 8:
                    ccid_list.addCrimes();
                    break;

                case 9:
                    ccid_list.DeleteCrime();
                    break;

                case 10:
                    ccid_list.UpdateCrime();
                    break;

                case 11:
                    ccnd_list.AddNumber();
                    break;

                case 12:
                    ccnd_list.SwapNumbers();
                    break;

                case 13:
                    ccnd_list.CountNetworks();
                    break;

                case 0:

                    System.out.println("You have exited the program");
                    java.lang.System.exit(0);
                    break;

                default: System.out.println("Please enter a valid choice");
                    break;


            }
        }

    }


}
