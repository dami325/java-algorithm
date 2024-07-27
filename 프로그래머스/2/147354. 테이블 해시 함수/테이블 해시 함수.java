import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int selectIndex = col - 1;

        int[][] sortData = Arrays.stream(data).sorted((o1, o2) -> {
            if (o1[selectIndex] == o2[selectIndex]) {
                return o2[0] - o1[0];
            }
            return o1[selectIndex] - o2[selectIndex];
        }).toArray(int[][]::new);

        List<Integer> si = new ArrayList<>();

        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int[] sortDatum = sortData[i];
            int result = 0;
            for (int j = 0; j < sortDatum.length; j++) {
                result += sortDatum[j] % (i + 1);
            }
            si.add(result);
        }

        return si.stream().reduce(0, (integer, integer2) -> integer ^ integer2);
    }

}