class Solution {

    int maxLen=-1;

    public int maxProduct(String s) {
         helper(s,"","",0);
         return maxLen;
    }

    public void helper(String s, String a, String b, int i){

        if(i==s.length()){
            if(a.length()==0 ||  b.length()==0) return;
            if(isPalindrome(a) && isPalindrome(b)) maxLen = Math.max(maxLen,a.length()*b.length());
            return;

        
        }

        // case 1 : skip
            helper(s,a,b,i+1);
            
            // case 2 : taking in str 1 only
            helper(s,a+s.charAt(i),b,i+1);

            // case 3 : taking in str 2 only

            helper(s,a,b+s.charAt(i),i+1);

    }

        public  boolean isPalindrome(String str){
            for(int i=0;i<str.length()/2;i++){
                if(str.charAt(i)!=str.charAt(str.length()-1-i)) return false;
            }

            return true;

        }

    
}
