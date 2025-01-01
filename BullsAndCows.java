class Solution {
    public String getHint(String secret, String guess) {
        // easy to get no. of bulls
        // main task to find no. cow
      
        HashMap<Character,Integer> cMap = new HashMap<>();
        HashMap<Character,Integer> wMap = new HashMap<>();

        int bulls=0;
        int cows=0;

        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bulls++;
            }else{
                cMap.put(secret.charAt(i),cMap.getOrDefault(secret.charAt(i),0)+1);
                wMap.put(guess.charAt(i),wMap.getOrDefault(guess.charAt(i),0)+1);
            }
        }

        for(Character key:cMap.keySet()){
            if(wMap.containsKey(key)){
                cows+=Math.min(wMap.get(key),cMap.get(key));
            }
        }

        return bulls+"A"+cows+"B";

    }
}
