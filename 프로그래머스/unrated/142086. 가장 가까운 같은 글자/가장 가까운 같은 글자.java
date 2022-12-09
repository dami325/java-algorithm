class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int i1 = s.lastIndexOf(s.charAt(i), i - 1);
            if(i1 < 0){
                answer[i] = i1;
            }else{
                answer[i] = i - i1;
            }
        }
        return answer;
    }
}