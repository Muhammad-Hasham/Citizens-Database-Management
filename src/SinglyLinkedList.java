public class SinglyLinkedList <T> {

    Singly_Node <T> head;
    Singly_Node <T> tail;


    SinglyLinkedList(){}

    SinglyLinkedList(T myobj ){

        head = new Singly_Node<>(myobj);
    }

    public Singly_Node<T> getHead() {
        return head;
    }

    public void insert(T newData)
    {
        if( head == null )
        {
            head = new Singly_Node<>(newData);
            head.next = null;
            //tail = head;
        }
        else{
            Singly_Node<T> newNode = new Singly_Node<>(newData);
            newNode.next =head;
            head = newNode;
        }

    }

    public void remove(int indexToRemove)
    {
        if (indexToRemove == 0){
            if (head.next == null){
                head = null;
            }
            else {
                head = head.next;
            }
        }
        else {
            Singly_Node<T>currentNode = head;
            Singly_Node<T> previousNode = currentNode;
            int i = 0;

            while (currentNode != null && i < indexToRemove){
                previousNode = currentNode;
                currentNode = currentNode.next;
                i++;
            }

            if (i == indexToRemove){
                if(currentNode == null){
                    previousNode.next = null;
                }
                else {
                    previousNode.next = currentNode.next;
                }
            }
        }


    }
    public void DisplaySingly() {
        Singly_Node<T> currentNode = head;
        while(currentNode != null) {

            System.out.println(currentNode.MyData.toString());
            currentNode = currentNode.next;
        }

    }
}
