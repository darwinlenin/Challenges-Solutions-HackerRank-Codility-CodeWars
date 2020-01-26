import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'angryAnimals' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY a
     *  3. INTEGER_ARRAY b
     */

    public static long angryAnimals(int n, List<Integer> a, List<Integer> b) {

        Map<Integer, Integer> highestEnemy = new HashMap<>();

        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            int ele = Math.max(a.get(i), b.get(i));

            highestEnemy.put(ele, Math.max(highestEnemy.getOrDefault(ele, Integer.MIN_VALUE), Math.min(a.get(i), b.get(i))));
        }

        long count = 0;
        int startIndex = 1;
        int endIndex = 1;
        int highest = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (highestEnemy.containsKey(i)) {

				count += (endIndex - startIndex) * (endIndex - startIndex + 1) / 2;

                highest = Math.max(highest, highestEnemy.get(i) + 1);

                startIndex = highest;

                count -= (endIndex - startIndex) * (endIndex - startIndex + 1) / 2;
            }
            endIndex++;
        }

        count += (endIndex - startIndex) * (endIndex - startIndex + 1) / 2;
        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int bCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> b = IntStream.range(0, bCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result.angryAnimals(n, a, b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
