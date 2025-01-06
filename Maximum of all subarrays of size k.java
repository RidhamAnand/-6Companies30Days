class Solution {
    
    class Pair{
        int num;
        int i;

        Pair(int num, int i){
            this.num=num;
            this.i=i;
        }
    }
    
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int nums[], int k) {
         PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.num, a.num));
        ArrayList<Integer> arr = new ArrayList<>();


      int i=0;
      int j=0;
     

      while(j<nums.length){


        pq.add(new Pair(nums[j],j));

        if(j-i+1==k){
            while(pq.peek().i<i){
                pq.poll();
            }
            arr.add(pq.peek().num);
            i++;
        }

        j++;


      }

      return arr;



    
    }
}
