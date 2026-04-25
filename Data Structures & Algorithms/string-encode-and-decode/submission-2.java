class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
            // char[] carr = s.toCharArray();
            // for(int i=0; i<carr.length; i++) {
            //     if(carr[i]=='/') {
            //         sb.append("//");
            //     }
            //     else sb.append(carr[i]);
            // }
            // sb.append("/#");
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i=0;
        while(i<str.length()) {
            int j=i+1;
            while(str.charAt(j)!='#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            j++;
            i = j+len;
            ans.add(str.substring(j,i));
        }
        return ans;
    }
}

// neet/#code/#lo//#ve/#y///o//u/#

// neet, code, lo/#ve, y//o/u

// / & / -> skip / and continue
// / & #
