class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i],0) + 1);
            if(hm.size() > 3) {
                HashMap<Integer, Integer> hmnew = new HashMap<>();
                for(int x : hm.keySet()) {
                    if(hm.get(x) > 1)
                        hmnew.put(x, hm.get(x)-1);
                }
                hm = hmnew;
            }
        }
        for(int x : hm.keySet()) {
            int freq = 0;
            for(int num : nums) {
                if(num==x) freq++;
            }
            if(freq > nums.length/3)
                ans.add(x);
        }
        return ans;
    }
}

// 1 2 3 4 5 6 7 8 9 10


// 5 - 4
// 2 - 5
// 3 - 1

// n/3 = 2
// 1,2,3,4,5,2,2,4,4,4,4
// 5-1
// 2-2
// 4-4