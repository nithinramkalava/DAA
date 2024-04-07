package practice;

import java.util.Arrays;

public class LongestSubSequence {

    public static void main(String[] args) {
        String str1 = "AGGTAB", str2 = "GXTXAYB";

        int m = str1.length() + 1, n = str2.length() + 1;

        int[][] dp = new int[m][n];

        Arrays.fill(dp[0], 0);

        for(int i = 0; i < m; i++)
            dp[i][0] = 0;

        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++) {
                if(str1.charAt(i -  1) == str2.charAt(j -  1)) {
                    dp[i][j] = 1 + dp[i - 1][ j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[m - 1][n - 1]);

        StringBuilder builder = new StringBuilder();

        for(int i = m - 1, j = n - 1; i > 0 && j > 0;){
            if( str1.charAt(i-1) == str2.charAt(j-1)) {
                builder.insert(0, str1.charAt(i - 1));
                i--; j--;
            } else if (dp[i-1][j] > dp[i][j-1]){
                i--;
            } else { 
                j--;
            }
        }

        System.out.println(builder.toString());
    }
    
}
