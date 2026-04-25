class Solution {
    HashMap<Integer, Integer> count;
    public int[] topKFrequent(int[] nums, int k) {
        count = new HashMap<>();
        int[] ans = new int[k];
        for(int num : nums)
            count.put(num, count.getOrDefault(num,0)+1);
        int n = count.size();
        int[] unique = new int[n];
        int i=0;
        for(int x : count.keySet())
            unique[i++] = x;
        quickselect(unique, 0, n-1, n-k-1);
        for(i=0; i<k; i++) {
            ans[i] = unique[n-i-1];
        }
        return ans;
    }

    public void quickselect(int[] arr, int l, int r, int idx) {
        if(l>=r) return;
        int pivIdx = partition(arr, l,r);
        if(pivIdx==idx) {
            return;
        }
        else if(pivIdx<idx) {
            quickselect(arr, pivIdx+1, r, idx);
        }
        else {
            quickselect(arr, pivIdx+1, r, idx);
            quickselect(arr, l, pivIdx-1, idx);
        }
    }

    public int partition(int[] arr, int l, int r) {
        int i=l, j=l;
        while(j<r) {
            if(count.get(arr[j]) <= count.get(arr[r])) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
            j++;
        }
        int tmp = arr[i];
        arr[i] = arr[r];
        arr[r] = tmp;
        return i;
    }
}

