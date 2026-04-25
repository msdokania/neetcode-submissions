class Solution {
    public int[] sortArray(int[] nums) {
        // insertionSort(nums);
        selectionSort(nums);
        // bubbleSort(nums);
        // quickSort(nums);
        // mergeSort(nums);
        // heapSort(nums);
        return nums;
    }

    public void insertionSort(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++) {
            int key = nums[i];
            int j = i-1;
            while(j>=0 && nums[j]>key) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }

// 1,9,10,1,1,2,3,1
    public void selectionSort(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++) {
            int idx = 0;
            int min = Integer.MAX_VALUE;
            for(int j=i; j<n; j++) {
                if(nums[j]<min) {
                    idx = j;
                    min = nums[j];
                }
            }
            if(min != Integer.MAX_VALUE)
                swap(nums, i, idx);
        }
    }

    public void bubbleSort(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n-1; j++) {
                if(nums[j]>nums[j+1])
                    swap(nums, j, j+1);
            }
        }
    }

    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}



