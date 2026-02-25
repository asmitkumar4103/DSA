class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(temp, (a, b) -> {
            int c1 = Integer.bitCount(a);
            int c2 = Integer.bitCount(b);
            if (c1 == c2) return a - b;
            return c1 - c2;
        });

        return Arrays.stream(temp).mapToInt(i -> i).toArray();
    }
}