class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            boolean anagram = false;
            for(int j = 0; j<result.size(); j++){
                if(isAnagram(strs[i], result.get(j).get(0))){
                    result.get(j).add(strs[i]);
                    anagram = true;
                    break;
                }
            }
            if(!anagram){
                List<String> newAnagram = new ArrayList<>();
                newAnagram.add(strs[i]);
                result.add(newAnagram);
            }
        }
        return result;
    }

    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int [] frequency = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for(int i = 0; i<s.length(); i++){
            frequency[s.charAt(i) - 'a']++;
            frequency[t.charAt(i) - 'a']--;
        }
        for(int j = 0; j<26; j++){
            if(frequency[j] != 0){
                return false;
            }
        }
        return true;
    }
}
