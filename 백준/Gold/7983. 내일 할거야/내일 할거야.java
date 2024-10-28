import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PriorityQueue<Study> studyPriorityQueue = new PriorityQueue<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int time = sc.nextInt();
            int deadline = sc.nextInt();
            studyPriorityQueue.add(new Study(time, deadline));
        }

        Study study = studyPriorityQueue.poll();
        int beforeDeadline = study.nextDeadline(study.deadline);
        while (!studyPriorityQueue.isEmpty()) {
            study = studyPriorityQueue.poll();
            if (beforeDeadline < study.deadline) {
                beforeDeadline = study.nextDeadline(beforeDeadline);
            } else {
                beforeDeadline = study.nextDeadline(study.deadline);
            }
        }

        System.out.println(beforeDeadline);
    }
}

class Study implements Comparable<Study> {

    int time;
    int deadline;

    public Study(int time, int deadline) {
        this.time = time;
        this.deadline = deadline;
    }

    public int nextDeadline(int deadline){
        return deadline - time;
    }

    @Override
    public int compareTo(Study study) {
        if (this.deadline == study.deadline) {
            return study.time - this.time;
        }
        return study.deadline - this.deadline;
    }
}