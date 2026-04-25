class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        helper(new ArrayList<>(), 0, s);
        return ans;
    }
    public void helper(List<String> cur, int l, String s) {
        if(l==s.length()) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int j=l; j<s.length(); j++) {
            String tmp = s.substring(l,j+1);
            if(!isPalin(tmp)) continue;
            cur.add(tmp);
            helper(cur, j+1, s);
            cur.remove(cur.size()-1);
        }
    }
    public boolean isPalin(String str) {
        int l=0, r=str.length()-1;
        while(l<r) {
            if(str.charAt(l)!=str.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}

// 1st partition: {a}
// l=0, r=0-2(0)

// 2nd par: a, a
// l=1, r=1-2(2)

// 3rd par: a,a,b
// l=2, r=2

// 3rd par: a,ab
// l=3, r=3