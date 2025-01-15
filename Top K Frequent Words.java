class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        TreeMap<String, Integer> wordCountMap = new TreeMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int frequency : wordCountMap.values()) {
            maxHeap.add(frequency);
        }

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < k; ++i) {
            int frequency = maxHeap.poll();
            String word = findWordByFrequency(wordCountMap, frequency);
            wordCountMap.remove(word);
            result.add(word);
        }

        return result;
    }

    public String findWordByFrequency(TreeMap<String, Integer> map, int frequency) {
        for (String word : map.keySet()) {
            if (map.get(word) == frequency) {
                return word;
            }
        }
        return " ";
    }
}
