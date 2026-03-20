class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);

        if (a > 0) pq.add(new int[]{a, 'a'});
        if (b > 0) pq.add(new int[]{b, 'b'});
        if (c > 0) pq.add(new int[]{c, 'c'});

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] first = pq.poll();

            int count1 = first[0];
            char ch1 = (char) first[1];

            int n = sb.length();
            if (n >= 2 && sb.charAt(n - 1) == ch1 && sb.charAt(n - 2) == ch1) {
                if (pq.isEmpty()) break;

                int[] second = pq.poll();
                int count2 = second[0];
                char ch2 = (char) second[1];

                sb.append(ch2);
                count2--;

                if (count2 > 0) pq.add(new int[]{count2, ch2});
                pq.add(first);
            } else {
                sb.append(ch1);
                count1--;
                if (count1 > 0) pq.add(new int[]{count1, ch1});
            }
        }

        return sb.toString();
    }
}