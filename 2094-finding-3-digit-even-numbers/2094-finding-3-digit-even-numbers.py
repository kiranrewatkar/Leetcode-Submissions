class Solution:
    def findEvenNumbers(self, digits):
        ans = set()
        n = len(digits)

        for i in range(n):
            for j in range(n):
                for k in range(n):
                    if i != j and j != k and i != k:
                        if digits[i] != 0 and digits[k] % 2 == 0:
                            ans.add(digits[i]*100 + digits[j]*10 + digits[k])

        return sorted(ans)