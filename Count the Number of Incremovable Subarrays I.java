import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean check(List<Integer> tmp) {
        for (int i = 1; i < tmp.size(); i++) {
            if (tmp.get(i) <= tmp.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                List<Integer> tmp = new ArrayList<>();

                for (int k = 0; k < i; k++) {
                    tmp.add(nums[k]);
                }

                for (int k = j + 1; k < n; k++) {
                    tmp.add(nums[k]);
                }

                if (check(tmp)) {
                    res++;
                }
            }
        }

        return res;
    }
}
