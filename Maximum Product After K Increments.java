class Solution {
    public int maximumProduct(int[] nums, int k) {
        int MOD = (int) 1e9 + 7;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
        }

        while (k-- > 0) {
            int minValue = minHeap.poll();
            minHeap.add(minValue + 1);
        }

        long result = 1;
        while (!minHeap.isEmpty()) {
            result = (result * minHeap.poll()) % MOD;
        }

        return (int) result;
    }
}
