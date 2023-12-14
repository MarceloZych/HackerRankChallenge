package my.challenge.HackerRank.pangram;

import java.io.*;
import java.util.*;

class Result {

    public static String pangrams(String s) {
        // Write your code here
        String lowerCase = s.toLowerCase();
        HashSet<Character> uniqueLetter = new HashSet<>();

        for (char i : lowerCase.toCharArray()) {
            if (Character.isLetter(i)) {
                uniqueLetter.add(i);
            }
        }

        return (uniqueLetter.size() == 26) ? "pangram" : "not pangram";
    }

}

public class pangrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

