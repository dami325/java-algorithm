class Solution {
    public int solution(String s) {
        int answer = 0;
        // 현재 문자의 개수 나타는 변수
        int count = 1;
        // 이전 문자를 기록하는 변수
        char prevChar = s.charAt(0);
        
        for (int i = 1; i < s.length(); i++) {
            // 현재 문자
            char currentChar = s.charAt(i);
            
            // count가 0이면 새롭게 나눌 문자열 세팅
            if (count == 0) {
                prevChar = currentChar;
                count++;
                continue;
            }
            
            if (prevChar == currentChar) {
                count++; // 이전 문자와 현재 문자가 같으면 count 증가
            } else {
                count--; // 이전 문자와 현재 문자가 다르면 count 감소
            }
            
            // 문자열이 나눠진 경우
            if (count == 0) {
                answer++;
            }
        }
        
        // 남은 문자가 존재하는 경우 answer 증가
        if (count != 0) {
            answer++;
        }
                
        return answer;
    }
}