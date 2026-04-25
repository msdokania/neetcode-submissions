class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    Map<Integer, Integer> hm = new HashMap<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        for(int x : nums)
            hm.put(x, hm.getOrDefault(x, 0)+1);
        int n = nums.length;
        helper(new ArrayList<>(), n);
        return ans;
    }
    public void helper(List<Integer> curr, int n) {
        if(curr.size()==n) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int k : hm.keySet()) {
            if(hm.get(k)!=0) {
                curr.add(k);
                hm.put(k, hm.get(k)-1);
                helper(curr, n);
                curr.removeLast();
                hm.put(k, hm.get(k)+1);
            }
        }
    }
}