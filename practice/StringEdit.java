package practice;


public class StringEdit {
    public static void main(String[] args) {

        String str1 = "harry", str2 = "berry";
        System.out.println(editDistance(str1, str2));
        
    }

    public static int editDistance(String str1, String str2) {
        int m = str1.length(), n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = 0;

        for(int i = 1; i <= m; i++)
            dp[i][0] = i;

        for(int i = 1; i <= n; i++)
            dp[0][i] = i;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], dp[i-1][j-1]), dp[i-1][j]);
                }
            }
        }

        return dp[m][n];
    }
}
