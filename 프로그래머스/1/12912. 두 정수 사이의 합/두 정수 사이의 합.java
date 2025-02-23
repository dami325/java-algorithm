class Solution {
    public long solution(int a, int b) {
        long start = Math.min(a, b);
        long end = Math.max(a, b);
        
        // 등차수열의 합 공식: (첫 항 + 끝 항) * 항의 개수 / 2
        return (end - start + 1) * (start + end) / 2;
    }
}