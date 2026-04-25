class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int i = 0;
        int ans = 0;
        while(i<s.length()) {
            if(i!=s.length()-1 && hm.get(s.charAt(i)) < hm.get(s.charAt(i+1))) {
                int num = hm.get(s.charAt(i+1)) - hm.get(s.charAt(i));
                ans += num;
                i++;
            }
            else {
                ans += + hm.get(s.charAt(i));
            }
            i++;
        }
        return ans;
    }
}