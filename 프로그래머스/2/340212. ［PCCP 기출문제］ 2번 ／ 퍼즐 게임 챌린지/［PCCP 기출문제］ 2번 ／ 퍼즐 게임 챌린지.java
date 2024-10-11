class Solution {
        public int solution(int[] diffs, int[] times, long limit) {
            int left = 1;
            int right = 100000; // diffs의 최대값이 100,000이므로 가능한 숙련도의 최대값 설정
            int answer = right;

            while (left <= right) {
                int level = (left + right) / 2;
                long totalTime = calculateTotalTime(diffs, times, limit, level);

                if (totalTime <= limit) {
                    answer = level;
                    right = level - 1; // 더 작은 숙련도로도 가능한지 확인
                } else {
                    left = level + 1; // 숙련도를 늘려야 함
                }
            }

            return answer;
        }

        private long calculateTotalTime(int[] diffs, int[] times, long limit, int level) {
            long totalTime = 0;
            int timePrev = 0;

            for (int i = 0; i < diffs.length; i++) {
                int diff = diffs[i];
                int time = times[i];

                if (diff <= level) {
                    totalTime += time;
                } else {
                    int mistakes = diff - level;
                    totalTime += mistakes * (time + timePrev) + time;
                }

                if (totalTime > limit) {
                    return totalTime; // 제한 시간을 초과하면 바로 반환
                }

                timePrev = time;
            }

            return totalTime;
        }
}
// 난이도 diff, 퍼즐소요시간 time_cur, 이전퍼즐소요시간 time_prev, 숙련도 level
// 1. 난이도 <= 숙련도 = 시간 소요하여 해결
// 2. 난이도 > 숙련도 = (난이도 - 숙련도)* (소요시간 + 이전소요시간) + 소요시간
//      (3-1) * (2 + 4) + 2  = 14
// 1번 문항 LEVEL이 1이라고 가정한다면 입출력 예 1번에서 위의 공식을 적용
/*
    1 <= 1 = 1 소요시간 2
    5 > 1  = (5 - 1) = 4번 틀림 즉 4 * (현재소요시간 4 + 이전 소요시간 2 = 6 낭비됨)  = 4 * 6 그리고 + 소요시간 해서 해결함 = 4 * 6 + 4 = 소요시간 28
    3 > 1 = (3 - 1) * (7 + 28) +
*/