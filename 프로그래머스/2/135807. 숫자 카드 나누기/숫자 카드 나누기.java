class Solution {

    // 유클리드 호제법을 이용한 최대공약수 계산
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 배열의 최대공약수 계산
    private static int findGCD(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result = gcd(result, array[i]);
        }
        return result;
    }

    // 특정 값으로 배열 요소가 나누어지는지 확인
    private static boolean isDivisibleBy(int divisor, int[] array) {
        for (int num : array) {
            if (num % divisor == 0) {
                return true;
            }
        }
        return false;
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        int gcdA = findGCD(arrayA);
        int gcdB = findGCD(arrayB);

        if (gcdA == gcdB) {
            return 0;
        }

        boolean bDividesA = isDivisibleBy(gcdA, arrayB);
        boolean aDividesB = isDivisibleBy(gcdB, arrayA);

        if (bDividesA && aDividesB) {
            return 0;
        }

        if (!bDividesA && !aDividesB) {
            return Math.max(gcdA, gcdB);
        }

        if (!bDividesA) {
            return gcdA;
        }

        if (!aDividesB) {
            return gcdB;
        }

        return 0;
    }
}