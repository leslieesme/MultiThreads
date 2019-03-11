/**
 * Input the processes along with their burst time(bt)
 *    and arrival time(at)
 * 2- Find waiting time for all other processes i.e. for
 *    a given process  i:
 *        wt[i] = (bt[0] + bt[1] +...... bt[i-1]) - at[i]
 * 3- Now find turn around time
 *           = waiting_time + burst_time for all processes
 * 4- Average waiting time =
 *                     total_waiting_time / no_of_processes
 * 5- Average turn around time =
 *                  total_turn_around_time / no_of_processes
 */

public class FirstComeFirstServe {
    Processor [] myIds;
    double [] wait;
    double [] tt;
    double serviceTime[];
    int length;
    FirstComeFirstServe(Processor[]ids){
        myIds = ids;
        length = myIds.length;
        wait = new double[length];
        tt = new double[length];
        serviceTime = new double[length];

    }

    //total time all queues have to wait
    void findWaitTime(){
        serviceTime[0] = 0;
        wait[0] = 0;
        for(int i =1;i<length;i++){
            serviceTime[i] = serviceTime[i-1] + myIds[i-1].getBurst();
            wait[i] = serviceTime[i] - myIds[i].getArrival();
            if(wait[i]<0){
                wait[i] = 0;
            }
        }

    }

    void findTurnAroundTime(){
        for(int i = 0; i<length;i++){
           tt[i] = myIds[i].getBurst() + wait[i];
        }
    }

    void findAvergeTime(){
        findWaitTime();
        findTurnAroundTime();
        double totalWT =0;
        double totalTT=0;
        for(int i=0; i<length;i++){
            totalWT=totalWT+wait[i];
            totalTT=totalTT+tt[i];
            double complete = tt[i]+myIds[i].getArrival();
            System.out.println(myIds[i].getId() + " BT:" + myIds[i].getBurst() +
                   " AT:" +myIds[i].getArrival() + " WT:" + wait[i]+ " TT:" +tt[i] + " Cmplt:" + complete);
        }
        System.out.println("Avg Time:" + totalWT/ (double) length);
        System.out.println("Avg Turn Around Time:" +  totalTT / (double) length);

    }



    //average wait time ->( previous BT + previous WT ) - AT
        //response time -> wait time.
        //turnaround time -> current wait time + burst time.
        //CPU utlization rate
    //progress
}
