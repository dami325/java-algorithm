import java.util.Comparator;
import java.util.PriorityQueue;
class Solution {

    private PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
    private PriorityQueue<Integer> minQueue = new PriorityQueue<>(Integer::compareTo);

    public int[] solution(String[] operations) {
      for (String operation : operations) {
        String[] command = operation.split(" ");
        int value = Integer.parseInt(command[1]);
        switch (command[0]) {
          case "I": {
            maxQueue.add(value);
            minQueue.add(value);
            break;
          }
          case "D": {
            if (value == 1) {
              minQueue.remove(maxQueue.poll());
            } else {
              maxQueue.remove(minQueue.poll());
            }
            break;
          }
        }
      }
      if (maxQueue.isEmpty()) {
        return new int[]{0, 0};
      }
      return new int[]{maxQueue.poll(), minQueue.poll()};
    }
  }