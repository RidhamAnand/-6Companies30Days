class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        System.out.println(asteroids.length);
        long curr=mass;
        for(int target:asteroids){
            if(target<=curr){
                curr+=(long) target;
            }else{
                return false;
            }
        }

        return true;
    }
}
