

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] num = new int[8001];
        int[] list = new int[N];
        int same = 0,number = 0;
        int max = -4000, min = 4000, avg = 0;
        for(int i = 0; i < N; i++){
            int idx = s.nextInt();
            list[i] = idx;
            avg += idx;
            if(max < idx){
                max = idx;
            }
            if(min > idx){
                min = idx;
            }
            num[idx + 4000]++;
        }

        boolean sameSame = false;
        for(int i = min + 4000; i <= max + 4000; i++){

            if(num[i] > 0){

                if (same < num[i]) {
                    same = num[i];
                    number = i - 4000;
                    sameSame = true;
                } else if ((same == num[i] && sameSame) == true) {
                    number = i - 4000;
                    sameSame = false;
                 }
            }
        }

        Arrays.sort(list);

        System.out.println((int)Math.round((double)avg/N)); // 평균
        System.out.println(list[N/2]); // 중앙
        System.out.println(number); // 최빈
        System.out.println(max - min); // 범위

    }
}
