class Solution:
    def sumGame(self, num: str) -> bool:
        n = len(num)
        half = n // 2
        
        sum_diff = 0
        q_diff = 0
        
        for i in range(half):
            if num[i] == "?":
                q_diff += 1
            else:
                sum_diff += int(num[i])
                
        for i in range(half, n):
            if num[i] == "?":
                q_diff -= 1
            else:
                sum_diff -= int(num[i])
                
        # 2 * sum_diff == -9 * q_diff checks if 2 * (S_L - S_R) == 9 * (Q_R - Q_L)
        # Note: If total '?' is odd, 2 * sum_diff (even) != -9 * q_diff (odd) automatically holds.
        return 2 * sum_diff != -9 * q_diff