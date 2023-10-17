/*Pseudo code
* 
* BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
* 
* input start coordinate x and y
* input destination  coordinate des_x and des_y
* double[] begin = new double[2];
* double[] end = new double[2];
* 
* //initialize cannonMatrix
*  double[][] cannonMax = new double[number + 2][2];
   for(int i = 1; i <= number; i++) {
     String[] temp_3 = bf.readLine().split(" ");
     for(int j = 0; j < 2; j++) {
       cannonMax[i][j] = Double.parseDouble(temp_3[j]);
     }
   }
   cannonMax[0][0] = x;
   cannonMax[0][1] = y;
   cannonMax[number + 1][0] = des_x;
   cannonMax[number + 1][1] = des_y;

* // initialize adjacent Matrix
*  double[][] adjMat = new double[number + 2][number + 2];
*  infinity = 9999999;
*  for (int i = 0; i < number + 2; i++) {
     for (int j = 0; j < number + 2; j++) {
       if ( i == j) {
          adjMat[i][j] = 0;
       } else {
         adjMat[i][j] = infinity;
       }
     }
   }  
  // fill in the distance and check whether the shootrange of cannon is beyond the endpoint, also running
   for(int i = 1; i < number + 2; i++) {
     adjMat[0][i] = dist(cannonMax[0], cannonMax[i]) / 5;}
   for (int i = 1; i < number + 1; i++) {
     for (int j = 1; j < number + 2; j++) {
       double distance = dist(cannonMax[i], cannonMax[j]);
       if ( distance > 50) {
         adjMat[i][j] = Math.min(((distance - 50) / 5) + 2, distance / 5);
       } else {
         adjMat[i][j] = Math.min(((50 - distance) / 5) + 2, distance / 5);
       }
     }
   }
   print(adjMat[0][number + 1])
*/

import java.util.*;
import java.io.*;

public class cannon {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    int speed = 5;
    int shootRange = 50;

    String[] temp = bf.readLine().split(" ");
    double x = Double.parseDouble(temp[0]);
    double y = Double.parseDouble(temp[1]);

    String[] temp_2 = bf.readLine().split(" ");
    double des_x = Double.parseDouble(temp_2[0]);
    double des_y = Double.parseDouble(temp_2[1]);

    int number = Integer.parseInt(bf.readLine());

    double[][] cannonMax = new double[number + 2][2];
    for (int i = 1; i <= number; i++) {
      String[] temp_3 = bf.readLine().split(" ");
      for (int j = 0; j < 2; j++) {
        cannonMax[i][j] = Double.parseDouble(temp_3[j]);
      }
    }

    // System.out.println(Arrays.toString(cannonMax));

    double[][] adjMat = new double[number + 2][number + 2];
    cannonMax[0][0] = x;
    cannonMax[0][1] = y;
    cannonMax[number + 1][0] = des_x;
    cannonMax[number + 1][1] = des_y;
    // double a = x - des_x;
    // double b = y - des_y;
    // double time = Math.hypot(a, b) / speed ;
    double infinity = 999999;

    for (int i = 0; i < number + 2; i++) {
      for (int j = 0; j < number + 2; j++) {
        if (i == j) {
          adjMat[i][j] = 0;
        } else {
          adjMat[i][j] = infinity;
        }
      }
    }

    for (int i = 1; i < number + 2; i++) {
      adjMat[0][i] = dist(cannonMax[0], cannonMax[i]) / speed;
      // System.out.println(adjMat[0][i]);
    }

    for (int i = 1; i < number + 1; i++) {
      for (int j = 1; j < number + 2; j++) {
        double distance = dist(cannonMax[i], cannonMax[j]);
        if (distance > shootRange) {
          adjMat[i][j] = Math.min(((distance - shootRange) / speed) + 2, distance / speed);
        } else {
          adjMat[i][j] = Math.min(((shootRange - distance) / speed) + 2, distance / speed);
        }
      }
    }

    // Floyd Warshall
    for (int k = 0; k < number + 2; k++) {
      for (int i = 0; i < number + 2; i++) {
        for (int j = 0; j < number + 2; j++) {
          adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][k] + adjMat[k][j]);
        }
      }
    }

    pw.println(adjMat[0][number + 1]);

    pw.close();

    /*
     * double a = x - des_x;
     * double b = y = des_y;
     * adjMat[0][1] = Math.hypot(a, b) / speed;
     * adjMat[1][0] = Math.hypot(a, b) / speed; // SET UP RUN time\
     * 
     * for (int i = 0; i < number; i++) {
     * double dis = Math.hypot(des_x - cannonMax[i][0], des_y - cannonMax[i][1]);
     * 
     * }
     */

  }

  public static double dist(double[] a, double[] b) {
    return Math.hypot(a[0] - b[0], a[1] - b[1]);
  }

}
