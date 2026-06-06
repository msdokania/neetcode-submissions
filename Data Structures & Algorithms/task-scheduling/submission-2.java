class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c : tasks)
            freq[c-'A']++;
        Arrays.sort(freq);
        int idle = (freq[25]-1)*n;
        for(int i=24; i>=0; i--) {
            if(idle==0) break;
            if(freq[i]==freq[25]) {
                idle -= (freq[i]-1);
            } else {
                idle -= freq[i];
            }
        }
        return idle+tasks.length;
    }
}
