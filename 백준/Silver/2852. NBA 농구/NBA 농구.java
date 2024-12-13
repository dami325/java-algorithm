

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseCount = Integer.parseInt(br.readLine());

        Duration team1LeadTime = Duration.ZERO;
        Duration team2LeadTime = Duration.ZERO;

        Duration lastTime = Duration.ZERO;
        int score1 = 0;
        int score2 = 0;
        int leadingTeam = 0; // 0: no team, 1: team 1, 2: team 2

        for (int i = 0; i < caseCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int teamNumber = Integer.parseInt(st.nextToken());
            Duration currentTime = toDuration(st.nextToken());


            if (leadingTeam == 1) {
                team1LeadTime = team1LeadTime.plus(currentTime.minus(lastTime));
            } else if (leadingTeam == 2) {
                team2LeadTime = team2LeadTime.plus(currentTime.minus(lastTime));
            }

            if (teamNumber == 1) {
                score1++;
            } else {
                score2++;
            }

            if (score1 > score2) {
                leadingTeam = 1;
            } else if (score2 > score1) {
                leadingTeam = 2;
            } else {
                leadingTeam = 0;
            }

            lastTime = currentTime;
        }

        Duration gameEndTime = Duration.ofMinutes(48);
        if (leadingTeam == 1) {
            team1LeadTime = team1LeadTime.plus(gameEndTime.minus(lastTime));
        } else if (leadingTeam == 2) {
            team2LeadTime = team2LeadTime.plus(gameEndTime.minus(lastTime));
        }

        System.out.println(toMinuteSecondFormat(team1LeadTime));
        System.out.println(toMinuteSecondFormat(team2LeadTime));
    }

    // "MM:SS"를 Duration으로 변환
    public static Duration toDuration(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return Duration.ofMinutes(minutes).plusSeconds(seconds);
    }

    // Duration을 "MM:SS" 형식으로 변환
    public static String toMinuteSecondFormat(Duration duration) {
        long minutes = duration.toMinutes();
        int seconds = (int) (duration.getSeconds() % 60);
        return String.format("%02d:%02d", minutes, seconds);
    }
}
