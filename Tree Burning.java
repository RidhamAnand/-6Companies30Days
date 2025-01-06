/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode parent = queue.poll();
            if(parent.left!=null){
                map.computeIfAbsent(parent.val,(k)->new ArrayList()).add(parent.left.val);
                map.computeIfAbsent(parent.left.val,(k)->new ArrayList()).add(parent.val);
                queue.add(parent.left);
            }
             if(parent.right!=null){
                map.computeIfAbsent(parent.val,(k)->new ArrayList()).add(parent.right.val);
                map.computeIfAbsent(parent.right.val,(k)->new ArrayList()).add(parent.val);
                queue.add(parent.right);
            }
        }


        boolean[] isInfected = new boolean[(int)1e5 + 1];
        int time=0;
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        isInfected[start] = true;

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
               int curr = q.poll();

                if(map.containsKey(curr)){
                    for(int child:map.get(curr)){
                        if(!isInfected[child]){
                            isInfected[child]=true;
                            q.add(child);
                        }
                    }
                }        
            }
            time++;

        }

        return time-1;


    }
}
