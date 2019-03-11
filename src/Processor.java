public class Processor {
    private int myId;
    private double myArrival;
    private double myBurst;
    private int myPriority;
    Processor(int id,double arrival, double burst, int priority){
        myId=id;
        myArrival=arrival;
        myBurst=burst;
        myPriority=priority;
    }
    int getId(){
        return myId;
    }
    double getArrival(){
        return myArrival;
    }
    double getBurst(){
        return myBurst;
    }
    int getPriority(){
        return myPriority;
    }

}
