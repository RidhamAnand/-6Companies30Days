class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);

        int count=0;
        for(int i=0;i<nums.length-1;i++){
            
            if(i>0 && nums[i]==nums[i-1]) continue;
            int s=i+1;
            int e=nums.length-1;
            int tg = nums[i]+k;

            if(found(s,e,tg,nums)){
                count++;
            }
            

        }

        return count;

    }

    public static boolean found(int s, int e, int tg, int[] nums){

        while(s<=e){
            int mid = s+(e-s)/2;
            if(nums[mid]==tg) return true;
            else if(nums[mid]>tg)e=mid-1;
            else s=mid+1;
        }

        return false;

    }
}
