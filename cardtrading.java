import java.util.*;
import java.io.*;

public class cardtrading {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String firstLine_temp = br.readLine();
    String[] firstLine = firstLine_temp.split(" ");
    int total = Integer.parseInt(firstLine[0]);
    int types = Integer.parseInt(firstLine[1]);
    int combos = Integer.parseInt(firstLine[2]);

    String[] numCards = br.readLine().split(" ");
    int[] cards = new int[types];
    for (int i = 0; i < total; i++) {
      int tempcards = Integer.parseInt(numCards[i]);
      cards[tempcards - 1] += 1;
    }

    // check cards
    /*
     * for(int card : cards){
     * System.out.println(card);
     * }
     */

    List<Card> cardlist = new ArrayList<Card>();

    for (int i = 1; i < types + 1; i++) {
      String[] price = br.readLine().split(" ");
      long buy = Long.parseLong(price[0]);
      long sell = Long.parseLong(price[1]);
      cardlist.add(new Card(i, cards[i - 1], buy, sell));
    }

    // check cardlist
    /*
     * for(Card cl : cardlist){
     * System.out.println(cl.toString());
     * }
     */

    Collections.sort(cardlist);

    long profit = 0;
    for (int i = 0; i < types; i++) {
      if (i < combos) {
        if (cardlist.get(i).getnum() != 2) {
          profit -= cardlist.get(i).getbuy();
        } else {
          continue;
        }
      } else {
        profit += cardlist.get(i).getsell();
      }
    }

    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    pw.println(profit);
    pw.close();

  }

  public static class Card implements Comparable<Card> {
    private int type;
    private int num;
    private long buy;
    private long sell;

    public Card(int type, int num, long buy, long sell) {
      this.type = type;
      this.num = num;
      this.buy = buy;
      this.sell = sell;
    }

    public int gettype() {
      return this.type;
    }

    public int getnum() {
      return this.num;
    }

    public long getbuy() {
      return (2 - this.num) * this.buy;
    }

    public long getsell() {
      return this.num * this.sell;
    }

    public long getsort() {
      if (num == 2) {
        return getsell();
      } else {
        return getbuy() + getsell();
      }
    }

    public int compareTo(Card temp) {
      if (temp.getsort() < this.getsort()) {
        return 1;
      } else if (temp.getsort() > this.getsort()) {
        return -1;
      } else {
        return 0;
      }
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("type: ").append(this.type).append(" ")
          .append("num: ").append(this.num).append(" ")
          .append("buy: ").append(this.buy).append(" ")
          .append("sell: ").append(this.sell);
      return sb.toString();
    }
  }

}