import java.util.Arrays;

public class Merging implements Runnable{
    int[] myArray;
    int myMidpoint;

    public Merging(int[] array, int midpoint) {
        myArray = array;
        myMidpoint = midpoint;
    }
    private void merge(int [] array, int midpoint){
        int i =0;
        int j = midpoint;
        int count = 0;
        int [] temp = Arrays.copyOf(array,array.length);
        System.out.println(Arrays.toString(temp) + "TEMP");
        while (i<midpoint && j <temp.length){
            if(temp[i] < temp[j]){
                array[count] = temp[i];
                count++;
                i++;
                System.out.println("array[count]" + array[count]);
            }else {
                array[count] = temp[j];
                count++;
                j++;
            }
            System.out.println(Arrays.toString(array )+ "LLLLLLLLLLLLLLLL");
        }
        if(i==midpoint){
            for(int k =j; k<temp.length+1;k++){
                System.out.println("MISISISISIIS");
                array[count] = temp[k];
                count++;
                System.out.println("array[count]" + array[count]);
            }
        }
        else {
            for(int k = i;k<midpoint;k++ ){
                array[count] = temp[k];
                count++;
            }
        }
        System.out.println(Arrays.toString(array )+ "LLLLLLLLLLLLLLLL");

    }
    @Override
    public void run() {
        try {
            merge(myArray,myMidpoint);
        } catch (Exception e) {
            System.out.println("Merging CLASS" + e.getMessage());
        }
    }
}
