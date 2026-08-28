class Solution:
    def lexPalindromicPermutation(self, s: str, target: str) -> str:
        n = len(s)
        m = n // 2
        
        # Count character frequencies
        cnt = [0] * 26
        for ch in s:
            cnt[ord(ch) - ord('a')] += 1
            
        # Validate palindrome capability
        odd_cnt = 0
        mid_char = ""
        for i in range(26):
            if cnt[i] % 2 == 1:
                odd_cnt += 1
                mid_char = chr(ord('a') + i)
                
        if (n % 2 == 0 and odd_cnt > 0) or (n % 2 == 1 and odd_cnt != 1):
            return ""
            
        half_cnt = [c // 2 for c in cnt]
        
        # Find max prefix length of target's first half that can be matched
        temp_cnt = list(half_cnt)
        max_match = 0
        for j in range(m):
            idx = ord(target[j]) - ord('a')
            if temp_cnt[idx] > 0:
                temp_cnt[idx] -= 1
                max_match += 1
            else:
                break
                
        # Step 1: Try full match on the first half
        if max_match == m:
            pref = target[:m]
            full_pal = pref + mid_char + pref[::-1]
            if full_pal > target:
                return full_pal
                
        # Step 2: Deviate at index i (from min(m-1, max_match) down to 0)
        start_i = min(m - 1, max_match)
        for i in range(start_i, -1, -1):
            rem_cnt = list(half_cnt)
            for j in range(i):
                rem_cnt[ord(target[j]) - ord('a')] -= 1
                
            target_char_idx = ord(target[i]) - ord('a')
            
            # Find the smallest character strictly greater than target[i]
            found_c = -1
            for c in range(target_char_idx + 1, 26):
                if rem_cnt[c] > 0:
                    found_c = c
                    break
                    
            if found_c != -1:
                res_half = list(target[:i]) + [chr(ord('a') + found_c)]
                rem_cnt[found_c] -= 1
                for c in range(26):
                    while rem_cnt[c] > 0:
                        res_half.append(chr(ord('a') + c))
                        rem_cnt[c] -= 1
                
                pref = "".join(res_half)
                return pref + mid_char + pref[::-1]
                
        return ""