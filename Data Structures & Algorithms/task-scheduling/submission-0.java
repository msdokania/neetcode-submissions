class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c : tasks)
            freq[c-'A']++;
        Arrays.sort(freq);
        if(freq[25]==0) return 0;
        int idle = (freq[25]-1)*n;
        for(int i=24; i>=0; i--) {
            if(freq[i]==0) break;
            idle -= Math.min(freq[25]-1, freq[i]);
        }
        return Math.max(0,idle) + tasks.length;
    }
}


