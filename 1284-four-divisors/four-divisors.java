class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;

        for (int num : nums) {
            int divisors = 0;
            int sum = 0;

            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    int d1 = i;
                    int d2 = num / i;

                    if (d1 == d2) {  
                        // perfect square → only 1 divisor pair
                        divisors++;
                        sum += d1;
                    } else {
                        // two different divisors
                        divisors += 2;
                        sum += d1 + d2;
                    }

                    if (divisors > 4) break; // no need to continue
                }
            }

            if (divisors == 4) {
                totalSum += sum;
            }
        }

        return totalSum;
    }
}
