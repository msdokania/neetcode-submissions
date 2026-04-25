class Solution {
    String[] digToChar;
    List<String> ans;
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if(digits.equals(""))
            return ans;
        digToChar = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
        helper(digits, 0, "");
        return ans;
    }
    public void helper(String digits, int i, String curr) {
        if(i==digits.length()) {
            ans.add(curr);
            return;
        }
        String options = digToChar[Integer.parseInt(digits.substring(i,i+1))];
        for(char c : options.toCharArray()) {
            curr = curr + String.valueOf(c);
            helper(digits, i+1, curr);
            curr = curr.substring(0,curr.length()-1);
        }
    }
}
