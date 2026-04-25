class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int ans = -1;
        for(int i=0; i<str1.length() && i<str2.length(); i++) {
            // if(!(str1.length()%(i+1) == 0 && str1.length()%(i+1) == 0))
            //     break;
            int factor1 = str1.length()/(i+1);
            int factor2 = str2.length()/(i+1);
            String s1 = str1.substring(0,i+1);
            StringBuilder sb1 = new StringBuilder();
            sb1.append(s1);
            for(int j=1; j<factor1; j++)
                sb1.append(s1);
            // String s2 = str2.substring(0,i+1);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(s1);
            for(int j=1; j<factor2; j++)
                sb2.append(s1);
            if(str1.equals(sb1.toString()) && str2.equals(sb2.toString()))
                ans = i;

        }
        return str1.substring(0,ans+1);
    }
}