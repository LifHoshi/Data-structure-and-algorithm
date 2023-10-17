/*
 * pseudo code
 * 
 * 1. use Arraylist to store all the people. sorted by arrival time.
 * 
 * 2. create priorityqueue workstation 
 * 
 * 3. for(int i = 0 ; i< people ; i++){
 * 
 *      if(workstation is empty) add arrivaltime + end time     count++;
 *  
 * 4.   if(next person arrival time < workstation's time) add new arrivaltime + endtime into
 * workstation(create new ws)                                   count++
 * 
 * 5. else if(next person arrivaltime - workstationtime.poll < locktime) remove the first element in 
 * work station, add arrivaltime + endtime into workstation
 * 
 * }
 * 6. print maximum number of unlock times - count 
 *        
 */

import java.util.*;
import java.io.*;

public class Asswork {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    String[] firstLine = bf.readLine().split(" ");
    int number = Integer.parseInt(firstLine[0]);
    int lock_time = Integer.parseInt(firstLine[1]);

    ArrayList<ppl> al = new ArrayList<ppl>();

    for (int i = 0; i < number; i++) {
      String[] nextLine = bf.readLine().split(" ");
      int arrTime = Integer.parseInt(nextLine[0]);
      int stayTime = Integer.parseInt(nextLine[1]);
      al.add(new ppl(arrTime, stayTime));
    }

    Collections.sort(al);
    // for(ppl p : al){
    // System.out.println(p.arriveTime + " " + p.endTime);
    // }

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int cnt = 0;
    for (int i = 0; i < number; i++) {

      int persArr = al.get(i).arriveTime;
      int persEnd = al.get(i).endTime;

      while (pq.size() >= 0) {
        if (pq.size() == 0) {
          pq.add(persArr + persEnd);
          break;
        }

        int currentTime = pq.poll();
        if (persArr < currentTime) {
          pq.add(persArr + persEnd);
          pq.add(currentTime);
          break;
        } else if (persArr - currentTime <= lock_time) {
          pq.add(persArr + persEnd);
          cnt++;
          break;
        }

      }
    }
    // System.out.println(pq);
    pw.print(cnt);
    pw.close();
  }

}

class ppl implements Comparable<ppl> {
  public int arriveTime;
  public int endTime;

  public ppl(int x, int y) {
    this.arriveTime = x;
    this.endTime = y;
  }

  public int compareTo(ppl other) {
    if (this.arriveTime < other.arriveTime) {
      return -1;
    } else if (this.arriveTime == other.arriveTime) {
      return 0;
    } else {
      return 1;
    }
  }
}