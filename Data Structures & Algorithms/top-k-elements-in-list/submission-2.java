class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int [] res = new int [k];
        Map<Integer, Integer> numToFreq = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(numToFreq.containsKey(nums[i])){
                int val = numToFreq.get(nums[i]) + 1;
                numToFreq.put(nums[i], val);
            } else {
                numToFreq.put(nums[i], 1);
            }
        }
        Map<Integer, Integer> sortedMap = numToFreq.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey, 
                        Map.Entry::getValue, 
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        int j = 0;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()){
            if(j < k){
                res[j] = entry.getKey();
                j++;
            } else {
                break;
            }
        }
        return res;
    }
}
