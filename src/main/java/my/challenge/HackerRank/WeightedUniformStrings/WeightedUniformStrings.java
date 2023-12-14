package my.challenge.HackerRank.WeightedUniformStrings;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'weightedUniformStrings' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY queries
     */

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
        // Write your code here
        Set<Integer> weights = new HashSet<Integer>();
        char c = ' ';
        int consecutive = 0;

        for ( char currentChar : s.toCharArray()){
            int weight = currentChar - 'a' + 1;
            //Restar 'a' a currentChar tiene el efecto de convertir la letra en un índice basado en 1 en el alfabeto.
            //Por ejemplo, si currentChar es 'a', entonces weight será 1. Si es 'b', weight será 2, y así sucesivamente.

            if ( currentChar == c ){
                consecutive++;
                weight *= consecutive;
            } else {
                consecutive = 1;
            }
            weights.add(weight);
            c = currentChar;
        }

        List<String> result = new ArrayList<>(queries.size());

        for (int i=0; i < queries.size(); i++){
            result.add(weights.contains(queries.get(i)) ? "Yes" : "No");
        }

        return result;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<String> result = Result.weightedUniformStrings(s, queries);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}