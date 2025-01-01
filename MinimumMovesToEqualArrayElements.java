class Solution {
    public int minMoves2(int[] nums) {
      
      int sum=0;

     Arrays.sort(nums);

      int elem = nums[nums.length/2];


    for(int num:nums){
        sum+= Math.abs(num-elem);
    }

      return sum;



    }
}
