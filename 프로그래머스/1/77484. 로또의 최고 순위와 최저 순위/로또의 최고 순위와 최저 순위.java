import java.util.Arrays;
import java.util.Map;

class Solution {

    private Map<Integer, Integer> rankMap = Map.of(
            0, 6,
            1, 6,
            2, 5,
            3, 4,
            4, 3,
            5, 2,
            6, 1
    );

    public int[] solution(int[] lottos, int[] win_nums) {

        int zeroCount = (int) Arrays.stream(lottos)
                .filter(value -> value == 0)
                .count();

        int sameCount = (int) Arrays.stream(lottos)
                .filter(
                        lottoNum -> Arrays.stream(win_nums).anyMatch(winNum -> winNum == lottoNum)
                )
                .count();

        int lowestRanking = rankMap.get(sameCount);
        int highestRanking = rankMap.get(sameCount + zeroCount);

        return new int[]{highestRanking, lowestRanking};
    }

}