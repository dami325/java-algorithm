import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    private Map<Long, Integer> rankMap = Map.of(
            0L,6,
            1L,6,
            2L,5,
            3L,4,
            4L,3,
            5L,2,
            6L,1
    );
    public int[] solution(int[] lottos, int[] win_nums) {

        Set<Integer> winNumSet = Arrays.stream(win_nums)
                .boxed()
                .collect(Collectors.toSet());

        Set<Integer> lottoSet = Arrays.stream(lottos)
                .filter(value -> value != 0)
                .boxed()
                .collect(Collectors.toSet());

        Long zeroCount = Arrays.stream(lottos)
                .filter(value -> value == 0)
                .count();

        Long sameCount = lottoSet.stream()
                .filter(winNumSet::contains)
                .count();

        int lowestRanking = rankMap.get(sameCount);
        int highestRanking = rankMap.get(sameCount + zeroCount);
        
        return new int[]{highestRanking, lowestRanking};
    }

}