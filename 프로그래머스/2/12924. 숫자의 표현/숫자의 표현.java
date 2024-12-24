class Solution {
    public int solution(int n) {
        int answer = 0;
        int leftCursor = 1;
        int rightCursor = 1;
        int currentSum = 1;

        while (leftCursor <= n) {
            if (currentSum < n) {
                rightCursor += 1;
                currentSum += rightCursor;
            } else if (currentSum == n) {
                answer++;
                currentSum -= leftCursor++;
                currentSum += ++rightCursor;
            } else {
                currentSum -= leftCursor++;
            }
        }

        return answer;
    }
}