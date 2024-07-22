class Solution {
    
    private static int[] answer;
    
    public static int[] solution(int[] numbers) {
        int length = numbers.length;

        answer = new int[length];

        int lastIndex = length - 1;

        answer[lastIndex] = -1;

        for (int i = 0; i < lastIndex; i++) {
            int left = numbers[i];
            answer[i] = -1;

            for (int j = i + 1; j < length; j++) {
                int right = numbers[j];
                if (left < right) {
                    answer[j] = right;
                    break;
                }

            }
        }

        return answer;
    }
}