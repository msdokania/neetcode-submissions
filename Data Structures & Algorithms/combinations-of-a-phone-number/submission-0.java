class Solution {
    List<String> ans;
    Map<Character, String> hm;
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if(digits.length()==0) return ans;
        hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        helper(new StringBuilder(), 0, digits);
        return ans;
    }
    public void helper(StringBuilder sb, int i, String digits) {
        if(i==digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String s = hm.get(digits.charAt(i));
        for(int j=0; j<s.length(); j++) {
            sb.append(s.charAt(j));
            helper(sb, i+1, digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

