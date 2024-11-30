

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] room;
    private static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    private static int[] dy = {0, 1, 0, -1};
    private static int n, m;
    private static boolean stop = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new int[n][m];

        st = new StringTokenizer(br.readLine());
        Cleaner cleaner = new Cleaner(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (!stop) {
            cleaner.move();
        }

        System.out.println(cleaner.cleanCount);
    }

    public static class Cleaner {
        int cleanerX;
        int cleanerY;
        int direction;
        int cleanCount = 0;

        public Cleaner(int cleanerX, int cleanerY, int direction) {
            this.cleanerX = cleanerX;
            this.cleanerY = cleanerY;
            this.direction = direction;
        }

        public void clean() {
            this.cleanCount++;
            room[cleanerX][cleanerY] = 2;
        }

        public boolean isNotClean() {
            return room[cleanerX][cleanerY] == 0;
        }

        public void move() {
            if (isNotClean()) {
                clean();
            }

            boolean needCleanAround = false;
            for (int i = 0; i < 4; i++) {
                int xx = cleanerX + dx[i];
                int yy = cleanerY + dy[i];
                if (xx >= 0 && xx < n && yy >= 0 && yy < m && room[xx][yy] == 0) {
                    needCleanAround = true;
                    break;
                }
            }

            if (needCleanAround) {
                for (int i = 0; i < 4; i++) {
                    turn();
                    if (isNotCleanFrontMove()) {
                        return;
                    }
                }
            } else {
                goBack();
            }
        }

        private void goBack() {
            int backDir = (direction + 2) % 4;
            int backX = cleanerX + dx[backDir];
            int backY = cleanerY + dy[backDir];
            if (backX >= 0 && backX < n && backY >= 0 && backY < m && room[backX][backY] != 1) {
                cleanerX = backX;
                cleanerY = backY;
            } else {
                stop = true;
            }
        }

        private boolean isNotCleanFrontMove() {
            int frontX = cleanerX + dx[direction];
            int frontY = cleanerY + dy[direction];
            if (frontX >= 0 && frontX < n && frontY >= 0 && frontY < m && room[frontX][frontY] == 0) {
                cleanerX = frontX;
                cleanerY = frontY;
                return true;
            }
            return false;
        }

        private void turn() {
            direction = (direction + 3) % 4; // 반시계 방향 회전
        }
    }
}
