import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";
        
        Map<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }
        
        int required = tFreq.size();
        int formed = 0;
        Map<Character, Integer> windowFreq = new HashMap<>();
        
        int left = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);
            
            if (tFreq.containsKey(c) && windowFreq.get(c).intValue() == tFreq.get(c).intValue()) {
                formed++;
            }
            
            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                char leftC = s.charAt(left);
                windowFreq.put(leftC, windowFreq.get(leftC) - 1);
                if (tFreq.containsKey(leftC) && windowFreq.get(leftC) < tFreq.get(leftC)) {
                    formed--;
                }
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}