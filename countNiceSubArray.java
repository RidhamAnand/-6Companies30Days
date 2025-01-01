class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        return helper(nums,k+1)-helper(nums,k);

    }

    public int helper(int[] nums,int k){

        int i=0;
        int j=0;

        int cnt = 0;
        int oddCnt = 0;

        while(j<nums.length){

            oddCnt+=(nums[j]%2!=0 ? 1:0);

            while(oddCnt == k && i<=j){
                if(nums[i]%2!=0) oddCnt--;
                i++;
            }

            if(i<=j) cnt+=(j-i)+1;
            j++;

        }

        return cnt;
    }
}
