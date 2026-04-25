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
            String sub = s.substring(i,j+1);
            if(!validPalindrome(sub)) continue;
            curr.add(sub);
            helper(s, j+1, curr);
            curr.removeLast();
        }
    }
    public boolean validPalindrome(String str) {
        int l=0, r=str.length()-1;
        while(l<r) {
            if(str.charAt(l) != str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}

// aab
// curr= aa
// a,a,b  
