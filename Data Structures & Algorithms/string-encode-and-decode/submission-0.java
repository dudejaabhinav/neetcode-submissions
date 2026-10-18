class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for(String s : strs){
            int len = s.length();
            str.append(String.valueOf(len)).append('#').append(s);
        }
        System.out.println(str.toString());
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int singleStrLen = 0;
            System.out.println(singleStrLen);
            while(true){
                if(str.charAt(i) == '#'){
                    i++;
                    break;
                }
                else{
                    singleStrLen = singleStrLen * 10 + Character.getNumericValue(str.charAt(i));
                    i++;
                }
            }
            res.add(str.substring(i, i+singleStrLen));
            i = i + singleStrLen;
        }
        return res;
    }
}
