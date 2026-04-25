class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hs = new HashSet<>();
        while(n!=1) {
            int x = 0;
            while(n > 0) {
                int rem = n%10;
                x += rem*rem;
                n /= 10;
            }
            if(hs.contains(x)) 
                return false;
            hs.add(x);
            n=x;
        }
        return true;
    }
}
