class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        helper(new ArrayList<>(), 0, s);
        return ans;
    }
    public void helper(List<String> cur, int i, String s) {
        if(i==s.length()) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        // if(i>s.length()) return;
        for(int j=i+1; j<=s.length(); j++) {
            if(isPalindrome(s.substring(i,j))) {
                cur.add(s.substring(i,j));
                helper(cur, j, s);
                cur.remove(cur.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s) {
        int l=0, r=s.length()-1;
        while(l<r) {
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
