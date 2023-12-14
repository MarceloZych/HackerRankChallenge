package my.challenge.HackerRank.BeautifulBinaryString;

import java.io.*;

class BeautifulBinaryString {

    /*
     * Complete the 'beautifulBinaryString' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING b as parameter.
     */

    public static int beautifulBinaryString(String b) {
        // Write your code here
        int change = 0;

        // iniciamos en b.length() - 2 para evitar el desbordamient
        for ( int i = 0; i < b.length() - 2; i++){
            if ( (b.charAt(i) == '0' && b.charAt(i+1) == '1') && b.charAt(i+2) == '0' ){
                // buscamos el patron de '010' y si se encuentra contamos +1 en la variable change.
                change++;
                // seguimos buscando más patrones salteandonos los patrones que ya encontramos
                i+=2;
            }

        }

        return change;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String b = bufferedReader.readLine();

        int result = BeautifulBinaryString.beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}