class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] res = new int[nums.length];
        int [] pre = new int [nums.length];
        int [] suf = new int [nums.length];
        for(int i = 0; i < nums.length; i++){
            if (i == 0){
                pre[i] = 1;
            } else {
                pre[i] = nums[i-1] * pre[i-1];
            }
        }
        for(int j = nums.length - 1; j >= 0; j--){
            if (j == nums.length-1){
                suf[j] = 1;
            } else {
                suf[j] = nums[j+1] * suf[j+1];
            }
        }
        for(int k = 0; k < nums.length; k ++){
            res[k] = pre[k] * suf[k];
        }
        return res;
    }
}  
