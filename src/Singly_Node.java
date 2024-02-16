public class Singly_Node <T> {


        T MyData;

    Singly_Node <T> next;

    Singly_Node(){}

    Singly_Node(T MyData){
            this.MyData = MyData;
        }


    public T getMyData() {
        return MyData;
    }

    @Override
    public String toString() {
        return "Singly_Node{" +
                "MyData=" + MyData +
                ", next=" + next +
                '}';
    }
}



