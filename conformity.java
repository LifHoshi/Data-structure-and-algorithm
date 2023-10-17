/*
 * 1. create a Hashmap<String, Integer>
 * 
 * 2. Loop:
 *    Using ArrayList first to store combination number
 *    Collection.sort(ArrayList);
 * 
 *    then convert it to string, store in key
 *    toString(), 
 *    
 *
 *    if HashMap contains combination in key, value plus one. else create new value in HashMap with<new combination, value>
 * 
 *    if value > Max,  Max = value
 *   
 * 
 * 3. check if all values equal to 1, if it is, plus them tgt and equal to Max;
 * 
 * 
 */

import java.util.*;
import java.io.*;

public class conformity {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    int total = Integer.parseInt(bf.readLine());

    // ArrayList<ArrayList<Integer>> numList = new ArrayList<>();
    HashMap<String, Integer> numMap = new HashMap<>();
    int Max = 0;
    int Max_second = 0;
    // int popularity = 1;

    for (int i = 0; i < total; i++) {
      String[] numSer = bf.readLine().split(" ");
      List<String> comList = new ArrayList<>();

      for (int j = 0; j < numSer.length; j++) {
        comList.add(numSer[j]);
      }

      Collections.sort(comList);

      String comString = comList.toString();
      
      if(numMap.containsKey(comString)) {
        numMap.put(comString, numMap.get(comString) + 1);
      } else {
        numMap.put(comString, 1);
      }

      if(numMap.get(comString) > Max) {
        Max = numMap.get(comString);
      }
      // System.out.println(numList);
    }  

    for(Map.Entry<String, Integer> p : numMap.entrySet()) {
      if(p.getValue() == Max) {
             Max_second += p.getValue();
      }
    }
    pw.print(Max_second);



    pw.close();
    /* 
    int Max = 0;
    for (int i = 0; i < numList.size(); i++) {
      if (i + 1 == numList.size()) {
        break;
      } else {
        int count = 1;
        int count_second = 1;
        ArrayList<Integer> compare = numList.get(0);
        for (int j = i + 1; j < numList.size(); j++) {
          if (compare.equals(numList.get(j))) {
            count++;
          } else {
            count_second++;
          }
        }

        // System.out.println(count_second);

        if (Max < count || Max < count_second) {
          if (count > count_second) {
            Max = count;
          } else {
            Max = count_second;
          }
        }

      }
    }
    pw.print(Max);
    pw.close();*/

  }
}
