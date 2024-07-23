    class Solution {
        /**
         * 유클리드 호제법
         */
        private static int gcd(int a, int b) {
            if (b == 0) {
                return a;
            } else {
                return gcd(b, a % b);
            }
        }

        public static int solution(int[] arrayA, int[] arrayB) {
            boolean isSame = false;

            int aGcd = arrayA[0];
            for (int i = 1; i < arrayA.length; i++) {
                aGcd = gcd(Math.max(aGcd, arrayA[i]), Math.min(aGcd, arrayA[i]));
            }

            int bGcd = arrayB[0];
            for (int i = 1; i < arrayB.length; i++) {
                bGcd = gcd(Math.max(bGcd, arrayB[i]), Math.min(bGcd, arrayB[i]));
            }

            if (aGcd == bGcd) {
                return 0;
            }

            // A의 최대 공약수가 B의 원소를 하나라도 나누면 0 리턴
            boolean bIsDividedByA = false;
            if (aGcd != 1) {
                for (int num : arrayB) {
                    if (num % aGcd == 0) {
                        bIsDividedByA = true;
                        break;
                    }
                }
            }

            // B의 최대 공약수가 A의 원소를 하나라도 나누면 0 리턴
            boolean AIsDividedByB = false;
            if (bGcd != 1) {
                for (int num : arrayA) {
                    if (num % bGcd == 0) {
                        AIsDividedByB = true;
                        break;
                    }
                }
            }

            // 둘다 서로 나눠지면 0 리턴
            if (bIsDividedByA && AIsDividedByB) {
                return 0;
            }
            // 둘다 서로 안나눠지면 큰 수 리턴
            if (!bIsDividedByA && !AIsDividedByB) {
                return Math.max(aGcd, bGcd);
            }
            // B가 A의 최대공약수로 나누어 지고 A는 B의 최대공약수로 나누어지지 않을때 B의 최대공약수가 1이 아닌 경우 
            if (bIsDividedByA && !AIsDividedByB) {
                return bGcd == 1 ? 0 : bGcd;
            }
            // A가 B의 최대공약수로 나누어 지고 B는 A의 최대공약수로 나누어지지 않을때 A의 최대공약수가 1이 아닌 경우
//            if (!bIsDividedByA && AIsDividedByB){
            return aGcd == 1 ? 0 : aGcd;
//            }

        }
    }