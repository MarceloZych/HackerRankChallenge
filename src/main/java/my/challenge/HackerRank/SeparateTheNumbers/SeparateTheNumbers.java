package my.challenge.HackerRank.SeparateTheNumbers;

import java.io.*;
import java.util.stream.*;

public class SeparateTheNumbers {

    /*
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
        // Write your code here

        int digit = 1;
        int le = s.length();
        long res = Long.MAX_VALUE;
        boolean ok = false;
        while (digit <= le / 2) {
            String fi = s.substring(0, digit);
            long Fi = Long.parseLong(fi);
            long Tmp_res = Fi;
            int i = digit;
            int Digit = digit;
            while (i <= le - Digit) {
                String tmp = s.substring(i, i + Digit);
                long Tmp = Long.parseLong(tmp);
                if (tmp.charAt(0) == '0') break;
                if (Tmp - Fi == 1) {
                    Fi = Tmp;
                    i += Digit;
                    continue;
                }
                if (i + Digit + 1 <= le) {
                    String tmp1 = s.substring(i, i + Digit + 1);
                    if (tmp.charAt(0) == '0') break;
                    long Tmp1 = Long.parseLong(tmp1);
                    if (Tmp1 - Fi == 1) {
                        Fi = Tmp1;
                        Digit++;
                        i += Digit;
                        continue;
                    }
                }
                break;
            }
            if (i == le) {
                ok = true;
                res = Tmp_res;
                break;
            }
            digit++;
        }
        if (ok) {
            System.out.println("YES " + res);
        } else {
            System.out.println("NO");
        }

    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                SeparateTheNumbers.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

