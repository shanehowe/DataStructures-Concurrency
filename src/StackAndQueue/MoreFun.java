package StackAndQueue;

public class MoreFun {
    public void haveMoreFun() {
        System.out.println("Having more fun!");
        int number = 10/0;  // to generate an exception
//        int number = 10;  // to NOT generate an exception
        System.out.println("Finishing more fun"+number);
    }
}
