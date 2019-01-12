// https://leetcode.com/problems/subarray-sum-equals-k/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] subArrays = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            subArrays[i+1] = sum;
        }
        
        int count = 0;
        for (int i = 0; i <= nums.length; i++) {
            for (int j = i+1; j <= nums.length; j++) {
                //System.out.println(i + ": " + subArrays[i] + ", " + j + ": " + subArrays[j]);
                if (k == subArrays[j] - subArrays[i]) {
                    count++;
                }
            }
        }
        return count;
    }
}
