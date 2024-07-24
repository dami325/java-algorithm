import java.util.Map;

class Solution {
    public static int solution(String s) {
        Map<String, String> numberConvertMap = Map.of(
                "0", "zero",
                "1", "one",
                "2", "two",
                "3", "three",
                "4", "four",
                "5", "five",
                "6", "six",
                "7", "seven",
                "8", "eight",
                "9", "nine"
        );

        for (Map.Entry<String, String> entry : numberConvertMap.entrySet()) {
            s = s.replace(entry.getValue(), entry.getKey());
        }

        return Integer.parseInt(s);
    }
}