class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        if(bills[0]!=5) return false;
        int a=0, b=0;
        for(int x : bills) {
            if(x==5) {
                a++;
            }
            else if(x==10) {
                if(a==0) return false;
                a--;
                b++;
            }
            else {
                if(a==0) return false;
                if(b>0) {
                    b--;
                    a--;
                } else if(a>2) {
                    a -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}