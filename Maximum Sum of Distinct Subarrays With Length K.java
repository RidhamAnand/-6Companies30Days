class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        long cSum = 0;
        int dup = 0;

        int i = 0;
        int j = 0;

        while (j < nums.length) {
            cSum += nums[j];
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
           
            while(i<j && map.get(nums[j])>1){
                cSum-=nums[i];
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0) map.remove(nums[i]);
                i++;
            }
            if(j-i+1==k){
                sum = Math.max(cSum,sum);
                cSum-=nums[i];
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0) map.remove(nums[i]);
                i++;
            }
            j++;

        }

        return sum;
    }
}
