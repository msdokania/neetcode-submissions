class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0, j=numbers.length-1;
        while(i<j) {
            int x = numbers[i]+numbers[j];
            if(x == target) {
                return new int[]{i+1, j+1};
            }
            else if(x < target) i++;
            else j--;
        }
        return new int[]{0, 0};
    }
}
