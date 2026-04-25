class Solution {
    List<String> ans = new ArrayList<>();
    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return ans;
        helper(digits, 0, new StringBuilder());
        return ans;
    }
    public void helper(String digits, int i, StringBuilder sb) {
        if(i==digits.length()) {
            ans.add(sb.toString());
            return;
        }
        for(char c : map[digits.charAt(i) - '0'].toCharArray()) {
            sb.append(c);
            helper(digits, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
