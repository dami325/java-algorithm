class Solution {

    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {

                if (j == 0) {
                    triangle[i][j] = triangle[i][j] + triangle[i - 1][j];
                } else if(j ==  triangle[i].length - 1){
                    triangle[i][j] = triangle[i][j] + triangle[i - 1][j - 1];
                }else {
                    int left = triangle[i][j] + triangle[i - 1][j - 1];
                    int right = triangle[i][j] + triangle[i - 1][j];

                    triangle[i][j] = Math.max(left, right);
                }
            }
        }

        int answer = 0;

        for (int j = 0; j < triangle[triangle.length - 1].length; j++) {
            answer = Math.max(triangle[triangle.length - 1][j], answer);
        }

        return answer;
    }

}