import java.util.*;
import java.io.*;

public class Almost {
  public static void main(String[] args) throws IOException {
    Kattio io = new Kattio(System.in);
    while (io.hasMoreTokens()) {
      int n = io.getInt();
      int m = io.getInt();
      unionfind uf = new unionfind(n);
      for (int i = 0; i < m; i++) {
        int check = io.getInt();
        if (check == 1) {
          int x = io.getInt();
          int y = io.getInt();
          int fx = uf.find(x);
          int fy = uf.find(y);
          if (fx != fy) {
            uf.set[fx] = fy;
            uf.sum[fy] += uf.sum[fx];
            uf.num[fy] += uf.num[fx];
          }
        } else if (check == 2) {
          int x = io.getInt();
          int y = io.getInt();
          int fx = uf.find(x);
          int fy = uf.find(y);
          if (fx != fy) {
            uf.set[x] = fy;
            uf.sum[fy] += x;
            uf.sum[fx] -= x;
            uf.num[fy] += 1;
            uf.num[fx] -= 1;
          }
        } else {
          int x = io.getInt();
          int elements = uf.num[uf.find(x)];
          long sumElements = uf.sum[uf.find(x)];
          io.write(elements + " " + sumElements + "\n");
        }
      }
    }
    io.close();

  }

}

class unionfind {
  final int Max = 1000000;
  public int set[];
  public int num[];
  public long sum[];

  public unionfind(int N) {
    set = new int[Max];
    num = new int[Max];
    sum = new long[Max];
    for (int i = 1; i <= N; i++) {
      set[i] = i + N;
      set[i + N] = i + N;
      sum[i + N] = i;
      num[i + N] = 1;
    }
  }

  public int find(int x) {
    if (set[x] == x) {
      return x;
    } else {
      set[x] = find(set[x]);
      return set[x];
    }
  }
}

class Kattio extends PrintWriter {
  public Kattio(InputStream i) {
    super(new BufferedOutputStream(System.out));
    r = new BufferedReader(new InputStreamReader(i));
  }

  public Kattio(InputStream i, OutputStream o) {
    super(new BufferedOutputStream(o));
    r = new BufferedReader(new InputStreamReader(i));
  }

  public boolean hasMoreTokens() {
    return peekToken() != null;
  }

  public int getInt() {
    return Integer.parseInt(nextToken());
  }

  public double getDouble() {
    return Double.parseDouble(nextToken());
  }

  public long getLong() {
    return Long.parseLong(nextToken());
  }

  public String getWord() {
    return nextToken();
  }

  private BufferedReader r;
  private String line;
  private StringTokenizer st;
  private String token;

  private String peekToken() {
    if (token == null)
      try {
        while (st == null || !st.hasMoreTokens()) {
          line = r.readLine();
          if (line == null)
            return null;
          st = new StringTokenizer(line);
        }
        token = st.nextToken();
      } catch (IOException e) {
      }
    return token;
  }

  private String nextToken() {
    String ans = peekToken();
    token = null;
    return ans;
  }
}
/*
 * (public class unionfind {
 * public int[] p;
 * public int[] rank;
 * 
 * 
 * public unionfind(int N) {
 * p = new int[N];
 * rank = new int[N];
 * for (int i = 1; i <= N; i++) {
 * p[i] = i;
 * rank[i] = 0;
 * }
 * }
 * 
 * 
 * public int findSet(int i) {
 * if (p[i] == i) return i;
 * else {
 * p[i] = findSet(p[i]);
 * return p[i];
 * }
 * }
 * 
 * public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }
 * 
 * public void unionSet(int i, int j) {
 * if (!isSameSet(i, j)) {
 * int x = findSet(i), y = findSet(j);
 * // rank is used to keep the tree short
 * if (rank[x] > rank[y])
 * p[y] = x;
 * else {
 * p[x] = y;
 * if (rank[x] == rank[y])
 * rank[y] = rank[y]+1;
 * }
 * }
 * }
 * 
 * public void
 * 
 * 
 * @Override
 * public String toString() {
 * 
 * return Arrays.toString(p);
 * 
 * }
 * }
 */