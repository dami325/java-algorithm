import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());



        Queue<Person> queue = new ArrayDeque<>();
        List<Person> personList = new ArrayList<>();

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Person person = new Person(x, y);
            queue.add(person);
            personList.add(person);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Person person = queue.poll();
            getRank(person, personList);
            sb.append(person.rank).append(" ");
        }


        System.out.println(sb.toString());
    }

    private static void getRank(Person person, List<Person> personList) {
        for (Person per : personList) {
            if (per.cm > person.cm && per.kg > person.kg) {
                person.plusRank();
            }
        }
    }

    static class Person{
        int rank = 1;
        int kg;
        int cm;
        public Person(int kg, int cm) {
            this.kg = kg;
            this.cm = cm;
        }

        public void plusRank() {
            this.rank++;
        }
    }
}