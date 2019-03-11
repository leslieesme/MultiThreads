import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
            taskTwo();
    }
    public static void taskOne(){
        int [] array = new int[]{5,4,3,2,1};
        int half = array.length/2;
        Thread sortOne = new Thread(new Sorting(array,0,half));
        Thread sortTwo = new Thread(new Sorting(array,half+1,array.length-1));
        sortOne.start();
        sortTwo.start();
        try {
            sortOne.join();
            sortTwo.join();
            Thread merge = new Thread(new Merging(array, half));
            merge.start();
            merge.join();
            System.out.println("Sorted list is: " + Arrays.toString(array));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void taskTwo(){
        Processor one = new Processor(1,0,8,1);
        Processor two = new Processor(2,0.4,4,2);
        Processor three = new Processor(3,1.0,1,3);

        Processor [] pids = {one,two,three};
        FirstComeFirstServe fcfs = new FirstComeFirstServe(pids);
        fcfs.findAvergeTime();
        System.out.println("-----------------------------------------------------------");
    }


}
