class Solution {
      class Pair{
        int value;
        int weight;
     Pair(int value, int weight){
         this.value = value;
         this.weight=weight;
     }
    }

        public  int findTheCity(int n, int[][] edges, int distanceThreshold) {

        HashMap<Integer,ArrayList<Pair>> adjacency = new HashMap<>();
        for(int[] row : edges){

            adjacency.computeIfAbsent(row[0], k -> new ArrayList<>()).add(new Pair(row[1], row[2]));
            adjacency.computeIfAbsent(row[1], k -> new ArrayList<>()).add(new Pair(row[0], row[2]));


        }

        int[][] cities = new int[n][];

        for(int i =0;i<n;i++){
            cities[i] = distraitAlgorithm(i,adjacency,n);
        }
        int mainCount = Integer.MAX_VALUE;
        int city = -1;
        for(int i =0;i<cities.length;i++){
            int count=0;
           for(int j =0;j<cities[i].length;j++){
               if(j!=i && cities[i][j]<=distanceThreshold){
                   count++;
               }

           }

            if(count<=mainCount){
                mainCount=count;
                city = i;
            }
        }

        return city;

    }


    public int[] distraitAlgorithm(int src, HashMap<Integer, ArrayList<Pair>> adjacency, int n){

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt((x)->x.weight));
        int[] distance = new int[n];
        Arrays.fill(distance,(int) 1e8);
        distance[src]=0;
        queue.add(new Pair(src,0));
        while (!queue.isEmpty()){
            Pair u = queue.remove();

            if(adjacency.containsKey(u.value)){
                for(Pair v : adjacency.get(u.value)){
                    int newWeight = distance[u.value]+ v.weight;
                    if(newWeight<distance[v.value]){
                        distance[v.value] = newWeight;
                        queue.add( new Pair(v.value,newWeight));
                    }
                }
            }

           

        }

        return distance;
    }
}
