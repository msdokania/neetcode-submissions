class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return ans;
    }
    public void helper(String s, int i, List<String> curr) {
        if(i==s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int j=i; j<s.length(); j++) {
            String tmp = s.substring(i,j+1);
            if(!isPali(tmp)) continue;
            curr.add(tmp);
            helper(s, j+1, curr);
            curr.removeLast();
        }
    }
    public boolean isPali(String s) {
        int l=0, r=s.length()-1;
        while(l<=r) {
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
