class Solution {
    List<String> ans;
    String[] arr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if(digits.length()==0) return ans;
        helper(digits, 0, new StringBuilder());
        return ans;
    }
    public void helper(String digits, int i, StringBuilder sb) {
        if(i==digits.length()) {
            ans.add(sb.toString());
            return;
        }
        int x = digits.charAt(i) - '0';
        for(char c : arr[x].toCharArray()) {
            sb.append(c);
            helper(digits, i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
