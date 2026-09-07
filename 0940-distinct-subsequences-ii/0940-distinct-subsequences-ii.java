class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long[] endsWith = new long[26];
        long total = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            
            long newForCh = (total + 1) % MOD;
            
            total = (total - endsWith[idx] + newForCh) % MOD;
            if (total < 0) {
                total += MOD;
            }
            
            endsWith[idx] = newForCh;
        }
        
        return (int) total;
    }
}