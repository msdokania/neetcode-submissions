class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            char[] carr = s.toCharArray();
            for(int i=0; i<carr.length; i++) {
                if(carr[i]=='/') {
                    sb.append("//");
                }
                else sb.append(carr[i]);
            }
            sb.append("/#");
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        char[] carr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<carr.length-1; i++) {
            if(carr[i]=='/' && carr[i+1]=='/') {
                sb.append('/');
                i++;
            }
            else if(carr[i]=='/' && carr[i+1]=='#') {
                ans.add(sb.toString());
                i++;
                sb = new StringBuilder();
            }
            else {
                sb.append(carr[i]);
            }
        }
        return ans;
    }
}

// neet/#code/#lo//#ve/#y///o//u/#

// neet, code, lo/#ve, y//o/u

// / & / -> skip / and continue
// / & #
