class Solution {
    public int numOfWays(int n) {
        long mod = 1_000_000_007;

        long a = 6;  
        long b = 6;  

        for (int i = 2; i <= n; i++) {
            long newA = (a * 3 + b * 2) % mod;
            long newB = (a * 2 + b * 2) % mod;

            a = newA;
            b = newB;
        }

        return (int)((a + b) % mod);
    }
}
