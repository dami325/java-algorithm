class Solution {
    public int solution(int[] stones, int k) {
      int min = 1;
      int max = 200000000;
      int result = 0;

      while (min <= max) {
        int mid = (min + max) / 2;
        if (isToCross(mid, stones, k)) {
          result = Math.max(result, mid);
          min = mid + 1;
        } else {
          max = mid - 1;
        }
      }


      return result;
    }

    private boolean isToCross(int mid, int[] stones, int k) {
      int count = 0;

      for (int stone : stones) {
        if (stone - mid < 0) {
          count++;
        } else {
          count = 0;
        }

        if (count == k) {
          return false;
        }
      }

      return true;
    }
  }