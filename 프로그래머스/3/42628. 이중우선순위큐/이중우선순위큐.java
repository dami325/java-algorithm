import java.io.IOException;
import java.util.PriorityQueue;

import static java.util.Comparator.reverseOrder;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> lowQueue = new PriorityQueue<>();
        PriorityQueue<Integer> highQueue = new PriorityQueue<>(reverseOrder());

        for (String operation : operations) {
            switch (operation) {
                case "D 1" : {
                    if (lowQueue.isEmpty() && highQueue.isEmpty()) {
                        break;
                    }
                    if(highQueue.isEmpty()){
                        highQueue.remove(lowQueue.poll());
                    }else {
                        lowQueue.remove(highQueue.poll());
                    }
                    break;
                }
                case "D -1" : {
                    if (lowQueue.isEmpty() && highQueue.isEmpty()) {
                        break;
                    }
                    if(lowQueue.isEmpty()){
                        lowQueue.remove(highQueue.poll());
                    }else {
                        highQueue.remove(lowQueue.poll());
                    }
                    break;
                }
                default: {
                    int val = Integer.parseInt(operation.split(" ")[1]);
                    lowQueue.add(val);
                    highQueue.add(val);
                }
            }
        }

        if (lowQueue.size() > 0) {
            return new int[]{highQueue.poll(), lowQueue.poll()};
        }
        return new int[]{0, 0};
    }
}