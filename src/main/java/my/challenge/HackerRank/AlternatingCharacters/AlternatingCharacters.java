package my.challenge.HackerRank.AlternatingCharacters;
import java.io.*;
import java.util.stream.*;

class AlternatingCharacters {

    /*
     * Complete the 'alternatingCharacters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternatingCharacters(String s) {
        // Write your code here

        int count = 0;

        for ( int i = 0; i < s.length() - 1; i++){
            // System.out.println("mi s.length() es: " + s.length());
            // System.out.println("mi s.charAt(i) es: " + s.charAt(i));
            // System.out.println("mi s.charAt(i + 1) es: " + s.charAt(i + 1));
            if ( s.charAt(i) == s.charAt(i + 1)){
                count++;
            }
        }

        return count;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = AlternatingCharacters.alternatingCharacters(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
