class Solution {
    int[][][] dp;
    char[] bits;

    public int findIntegers(int n) {
        bits = Integer.toBinaryString(n).toCharArray();
        int len = bits.length;
        dp = new int[len][2][2];

        for (int i = 0; i < len; i++)
            for (int j = 0; j < 2; j++)
                Arrays.fill(dp[i][j], -1);

        return solve(0, 0, 1);
    }

    int solve(int pos, int prev, int tight) {
        if (pos == bits.length) return 1;

        if (dp[pos][prev][tight] != -1)
            return dp[pos][prev][tight];

        int limit = tight == 1 ? bits[pos] - '0' : 1;
        int ans = 0;

        for (int digit = 0; digit <= limit; digit++) {

            if (prev == 1 && digit == 1) continue;

            int newTight = (tight == 1 && digit == limit) ? 1 : 0;

            ans += solve(pos + 1, digit, newTight);
        }

        return dp[pos][prev][tight] = ans;
    }
}