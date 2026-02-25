class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return res;

        int wordLen = words[0].length();
        int totalWords = words.length;
        int windowLen = wordLen * totalWords;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);

        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> currCount = new HashMap<>();
            int left = i, count = 0;

            for (int right = i; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (wordCount.containsKey(word)) {
                    currCount.put(word, currCount.getOrDefault(word, 0) + 1);
                    count++;

                    while (currCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currCount.put(leftWord, currCount.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    if (count == totalWords)
                        res.add(left);

                } else {
                    currCount.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return res;
    }
}