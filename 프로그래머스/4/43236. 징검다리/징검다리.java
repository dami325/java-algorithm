import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        if (rocks.length == n) return distance;
        Arrays.sort(rocks);
        int rockCount = rocks.length;

        int l = Math.min(rocks[0],distance-rocks[rockCount-n-1]); // 적어도 이 이상이어야 함 
        int res = l;
        for (int i = 1; i < rockCount-n; i++) l = Math.min(rocks[i]-rocks[i-1],l);

        // in case of even distribution, remaining rocks = rockCount-n+2
        int remainingRocks = rockCount-n+2;
        int r = distance % (remainingRocks-1) == 0 ? distance/(remainingRocks-1) : distance/(remainingRocks-1)+1;

        while (l <= r) {
            int m = (l+r)/2;
            if (possible(m,rocks,rockCount-n,distance)) l = m+1;
            else r = m-1;
        }
        return r;
    }

    public boolean possible(int minDist, int[] rocks, int count, int distance) {
        int prevRock = 0;
        for (int i = 0; i < rocks.length; i++) {
            if (rocks[i] - prevRock >= minDist) {
                count--;
                if (count == 0) {
                    if (distance-rocks[i] >= minDist) return true;
                    return false;
                }
                prevRock = rocks[i];
            }
        }
        return false;
    }
}