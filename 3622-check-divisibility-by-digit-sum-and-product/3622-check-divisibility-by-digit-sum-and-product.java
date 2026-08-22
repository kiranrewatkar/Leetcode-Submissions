class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int s = 0;
        int p = 1;
        
        while(n>0){
            int dig = n % 10;
            s = dig + s;
            p *= dig;
            n = n/10;
        }

        if (num%(s+p)==0){ 
            return true;
            }
        return false;
        
    }
} 