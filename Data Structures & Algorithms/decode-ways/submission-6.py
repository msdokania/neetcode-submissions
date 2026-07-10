class Solution:
    def numDecodings(self, s: str) -> int:
        n = len(s)
        if s[0] == "0":
            return 0
        prev = 1
        prevprev = 1
        for i in range(1,n):
            curr = 0
            if s[i]!="0":
                curr = prev
            if int(s[i-1:i+1])<=26 and int(s[i-1:i+1])>=10:
                curr += prevprev
            prevprev = prev
            prev = curr
        return prev
        

# prevprev = 1
# prev = 2
# curr = 

# curr = prev + prevprev