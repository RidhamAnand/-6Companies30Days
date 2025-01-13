class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int curr=0;
        int[] values = new int[ages.length];
        for(int i=ages.length-1;i>=0;i--){
            if(i!=ages.length-1 && ages[i]==ages[i+1]){
              values[i]=values[i+1];
               
            }else{
                double tg = 0.5*(ages[i]) + 7;
                int ifFound = findCeil(tg,ages,i-1);
                if(ifFound==-1)values[i]=0;
                else values[i] = i-ifFound;
            }
            curr+=values[i];
        }

        return curr;
        
    }

    public static int findCeil(double tg, int[] ages, int e){
        int s=0;
        int ans=-1;
        while(s<=e){


            int mid = s+(e-s)/2;
            if((double) ages[mid]>tg){
                ans=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }

        }

        return ans;
    }
}
