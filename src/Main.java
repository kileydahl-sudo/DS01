import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //generics vs ArrayLists that only take in one class -> generics when you know what type of object you can specify what the data structures will hold with methods
       MyLL<String> myLL = new MyLL<String>();
       for(int i = 0; i<5; i++) {
           myLL.addLast(i+"");
           }

        System.out.println("Done"); //0,1,2,6,3,4
        System.out.println("i added a fix");

    }
}