class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> required = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(required.containsKey(nums[i])){
                int [] indices = {required.get(nums[i]), i};
                return indices;
            }
            required.put(target - nums[i], i);
        }
        int [] indices = {0, 1};
        return indices;
    }
}
