class Solution {
    public String convertToTitle(int columnNumber) {
        char[] map = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','Q','S','T','U','V','W','X','Y','Z'};
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0) {
            columnNumber--;
            int rem = columnNumber%26;
            sb.append((char) ('A' + rem));
            columnNumber = columnNumber/26;
        }
        sb.reverse();
        return sb.toString();
    }
}

// num%26 - rem is the char
// if left > 26
