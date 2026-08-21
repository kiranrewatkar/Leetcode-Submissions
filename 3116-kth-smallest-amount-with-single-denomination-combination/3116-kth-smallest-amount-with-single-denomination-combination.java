class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        int minCoin = coins[0];
        for (int c : coins) minCoin = Math.min(minCoin, c);
        
        long left = 1, right = (long) k * minCoin;
        long ans = right;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (countAmounts(coins, n, mid) >= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    
    private long countAmounts(int[] coins, int n, long mx) {
        long cnt = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcmVal = 1;
            for (int j = 0; j < n; j++) {
                if (((mask >> j) & 1) == 1) {
                    lcmVal = lcm(lcmVal, coins[j]);
                    if (lcmVal > mx) break;
                }
            }
            int bits = Integer.bitCount(mask);
            if (bits % 2 == 1) {
                cnt += mx / lcmVal;
            } else {
                cnt -= mx / lcmVal;
            }
        }
        return cnt;
    }
    
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}