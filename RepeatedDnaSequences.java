class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        if(s.length()<10)return new ArrayList<>();
        

        int i=0;
        int j=0;

        HashMap<String,Integer> map = new HashMap<>();

        while(j<s.length()){

            while(j<s.length() && j-i+1<10) j++;
    
            if(j<s.length()){
                String curr = s.substring(i,j+1);
                map.put(curr,map.getOrDefault(curr,0)+1);
            }
            i++;
            j++;


        }

        List<String> arr = new ArrayList<>();

        for(String keys:map.keySet()){
            if(map.get(keys)>1) arr.add(keys);
        }

        return arr;

    }
}
