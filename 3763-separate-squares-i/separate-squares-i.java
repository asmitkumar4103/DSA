class Solution {
    public double separateSquares(int[][] squares) {
        double total = 0;

        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        
        for (int[] sq : squares) {
            int x = sq[0], y = sq[1], l = sq[2];

            total += (long) l * l;
            low = Math.min(low, y);
            high = Math.max(high, y + l);
        }

        double half = total / 2.0;

        
        for (int i = 0; i < 100; i++) {
            double mid = (low + high) / 2.0;
            double below = 0;

            for (int[] sq : squares) {
                int y = sq[1], l = sq[2];

                if (mid > y) {
                    below += Math.min(mid - y, l) * l;
                }
            }

            if (below < half) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return high; 
    }
}
