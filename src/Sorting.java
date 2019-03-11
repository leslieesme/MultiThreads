import java.util.Arrays;

//Multithreaded Sorting Application- Task 1
public class Sorting implements Runnable {
    int [] myArray;
    int myStart;
    int myEnd;
    public Sorting(int [] array, int start,int end){
        myArray = array;
        myStart =  start;
        myEnd = end;
    }

    @Override
    public void run() {
        try{
            quickSort(myArray,myStart,myEnd);
        }catch (Exception e){
            System.out.println("ERROR CAUGHT");
        }
    }

    private void quickSort(int array[], int low, int high){
        if(low<high){
            int part= partition(array,low,high);
            quickSort(array,low,part-1);
            quickSort(array,part+1,high);
        }
    }

    int partition(int array[],int low, int high){
        int pivot = array[high];
        int i = (low-1);
        for(int j = low;j<high;j++){
            if(array[j] <= pivot){
                i++;
                int temp = array[i];
                array[i]=array[j];
                array[j]=temp;
            }
        }
        int temp=array[i+1];
        array[i+1]= array[high];
        array[high] = temp;
        return i+1;
   }

}
