class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            int x = s.length();
            sb.append(x);
            sb.append('#');
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i=0;
        while(i<str.length()) {
            int end = i;
            while(str.charAt(end) != '#')
                end++;
            int x = Integer.parseInt(str.substring(i,end));
            i = end+1;
            StringBuilder sb = new StringBuilder();
            while(x>0) {
                sb.append(str.charAt(i));
                x--;
                i++;
            }
            ans.add(sb.toString());
        } 
        return ans;
    }
}
