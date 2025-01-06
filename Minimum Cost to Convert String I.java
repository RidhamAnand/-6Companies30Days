import java.util.*;

class Solution {
    class P {
        char ch;
        long cost;

        P(char ch, long cost) {
            this.ch = ch;
            this.cost = cost;
        }
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = 26; // Number of letters in the alphabet
        long[][] minCost = new long[n][n];

        // Initialize the cost matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(minCost[i], (long) 1e9);
            minCost[i][i] = 0; // Cost to convert a character to itself is 0
        }

        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            minCost[u][v] = Math.min(minCost[u][v], cost[i]);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (minCost[i][k] < (long) 1e9 && minCost[k][j] < (long) 1e9) {
                        minCost[i][j] = Math.min(minCost[i][j], minCost[i][k] + minCost[k][j]);
                    }
                }
            }
        }

        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            char srcChar = source.charAt(i);
            char tgtChar = target.charAt(i);

            if (srcChar != tgtChar) {
                int src = srcChar - 'a';
                int tgt = tgtChar - 'a';

                if (minCost[src][tgt] == (long) 1e9) {
                    return -1; // Transformation is not possible
                }
                totalCost += minCost[src][tgt];
            }
        }

        return totalCost;
    }
}
