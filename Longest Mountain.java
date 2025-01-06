class Solution {
    public int longestMountain(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }

        int maxLength = 0;

        // Iterate over the array from the second element to the second-last element
        for (int i = 1; i < arr.length - 1; i++) {
            // Check if arr[i] is a peak (must be greater than both its neighbors)
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                // Expand left side as long as the values are strictly increasing
                while (left >= 0 && arr[left] < arr[left + 1]) {
                    left--;
                }

                // Expand right side as long as the values are strictly decreasing
                while (right < arr.length && arr[right] < arr[right - 1]) {
                    right++;
                }

                // Calculate the length of the current mountain
                int length = right - left - 1;

                // Update the maximum length found
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
