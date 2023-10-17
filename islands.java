
/*pseudo code
 *     ....  input ....
 *     ....  output ....
 * 
 * 
 *    int rows = Integer.parseInt(input[0]);
 *    int columns = Integer.parseInt(input[1]);
 * 
 * 
 *   char x[][] = new char[rows][columns];
 *   int y[][] = new int[rows][columns];
 *   int cnt = 0;
 * 
 *   Create another class island  with two parameters 
 *   
 *   class island {
 *    public int x;
 *    public int y;
 * 
 *    public island(int x, int y) {
 *    this.x = x;
 *    this.y = y;
 *    }
 *   }
 * }
 * 
 *   
 * 
 *   // store the case 
 *   for(int i = 0; i < rows; i++) {
 *    String temp = bf.readline();
 *   for(int j = 0; j < columns; j++) {
 *     char c_temp = temp.charAt(j);
 *      x[i][j] = c_temp
 *      y[i][j] = 0;}
 * }
 *   
 *   for (int i = 0; i < rows; i++) {
 *     for (int j = 0; j < columns; j++) {
 *         if(x[i][j] == 'L' && x[i][j] == 0) {
 *             y[i][j] == 1;
 *             ArrayDeque<island> arr = new ArrayDeque<>();
 *             arr.add(new island(i,j));
 *             cnt++; 
 *              while(!arr.isEmpty()) {
 *              island land = arr.pollFirst(); 
 *              int row = land.x;
 *              int col = land.y;
 *              if (row - 1 > -1 && (x[row - 1][col] == 'C' || x[row - 1][col] == 'L') && y[row - 1][col] != 1){
 *                   arr.add(new island(row - 1, col));
 *                   y[row - 1][col] = 1;
 *                 }
 *              if ( row + 1 < rows && (x[row + 1][col] == 'C' || x[row + 1][col] == 'L') && y[row+1][col] != 1) {
 *                   arr.add(new island(row + 1, col));
 *                   y[row + 1][col] = 1;}
 *              if( col -1 > -1 && (x[row][col -1] == 'C' || x[row][col - 1] == 'L') && y[row][col - 1] != 1) {
 *                   arr.add(new island(row, col - 1);
 *                   y[row][col - 1] = 1;)}
 *              if (col + 1 < columns && (x[row][col + 1] == 'C' || x[row][col + 1] == 'L') && y[row][col + 1] != 1) {
 *                   arr.add(new island(row, col + 1));
 *                   y[row][col + 1] = 1;}}}
 * 
 *               if (x[i][j] != 'C') {
 *                       y[i][j] = 1;}
 *    }


 * }  
 * 
 * print(cnt);
 * 
 * 
 */

import java.io.*;
import java.util.*;

public class islands {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    String[] first_line = bf.readLine().split(" ");

    int rows = Integer.parseInt(first_line[0]);
    int columns = Integer.parseInt(first_line[1]);

    char x[][] = new char[rows][columns];
    int y[][] = new int[rows][columns];
    int cnt = 0;

    for (int i = 0; i < rows; i++) {
      String temp = bf.readLine();
      for (int j = 0; j < columns; j++) {
        char c_temp = temp.charAt(j);
        x[i][j] = c_temp;
        y[i][j] = 0;
      }
    }

    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < columns; j++) {
        if(x[i][j] == 'L' && y[i][j] != 1) {
          y[i][j] = 1;
          ArrayDeque<island> arr = new ArrayDeque<>();
          arr.add(new island(i,j));
          cnt++;
          while(!arr.isEmpty()) {
            island cur = arr.pollFirst();
            int row = cur.x;
            int col = cur.y;

            if(row - 1 > -1 && (x[row - 1][col] == 'C' || x[row - 1][col] == 'L') && y[row - 1][col] != 1){
              arr.add(new island(row - 1, col));
              y[row - 1][col] = 1;
            }
             
            if(row + 1 < rows && (x[row + 1][col] == 'C' || x[row + 1][col] == 'L') && y[row + 1][col] != 1) {
              arr.add(new island(row + 1, col));
              y[row + 1][col] = 1;
            }

            if(col - 1 > -1 && (x[row][col - 1] == 'C' || x[row][col - 1] == 'L') && y[row][col - 1] != 1) {
              arr.add(new island(row, col - 1));
              y[row][col - 1] = 1;
            }

            if(col + 1 < columns && (x[row][col + 1] == 'C' || x[row][col + 1] == 'L') && y[row][col + 1] != 1) {
              arr.add(new island(row, col + 1));
              y[row][col + 1] = 1;
            }
          }
        }

        if(x[i][j] != 'C') {
          y[i][j] = 1;
        }
      }
    }

    

    pw.print(cnt);
    pw.close();

  }
}

class island {
  public int x;
  public int y;

  public island(int x, int y) {
    this.x = x;
    this.y = y;
  }

}


