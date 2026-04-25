class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.replace("/", "//"));
            sb.append("/#");
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)=='/' && str.charAt(i+1)=='/') {
                sb.append('/');
                i++;
            }
            else if(str.charAt(i)=='/' && str.charAt(i+1)=='#') {
                ans.add(sb.toString());
                sb = new StringBuilder();
                i++;
            }
            else {
                sb.append(str.charAt(i));
            }
        }
        return ans;
    }
}
