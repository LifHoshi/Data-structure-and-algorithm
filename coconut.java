/* Pseudocode 
   1. creat another class to store the status of player, also the number

   2. find the ppl who are the next start the round. (formula maybe same to hashing??  like % total ppl)
  
   3. create list to record ppl 

   4. 
    while( list.size() > 1)
      if (status == folded) {
      ppl status turn to fist
      add a  list(since it seperate to half)
     } if ( status == fist) {
       turn it to palm down
    } else {   // means push hand behind back
      remove it from list.
   }
   
   5. print the first of the ppl

 * 
 */

import java.util.*;
import java.io.*;

public class coconut {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    String[] temp = br.readLine().split(" ");
    int syllables = Integer.parseInt(temp[0]);
    int ppl = Integer.parseInt(temp[1]);

    List<player> lt = new ArrayList<>();

    for (int i = 1; i <= ppl; i++) {
      lt.add(new player(1, i));
      // lt.get(i - 1).changestatus(3);
    }
    /*
     * CHECK STATUS
     * for(player p : lt) {
     * System.out.println(p.getstatus());
     * }
     */

    int count = 0;
   

    while (lt.size() > 1) {
      count = (count + syllables - 1) % lt.size();

      if (lt.get(count).getstatus() == 1) {
        lt.get(count).changestatus(2);
        lt.add(count, new player(2, lt.get(count).getnumber()));
      } else if (lt.get(count).getstatus() == 2) {
        lt.get(count).changestatus(3);
        count++;
      } else {
        lt.remove(count);
      }
    }
      
    pw.print(lt.get(0).getnumber());
    pw.close();
    
  }

}

class player {
  private int number;
  private int status;

  public player(int status, int number) {
    this.number = number;
    this.status = status;
  }

  public int getstatus() {
    return this.status;
  }

  public int getnumber() {
    return this.number;
  }

  public void changestatus(int x) {
    this.status = x;
  }
}
