import java.util.Arrays;
import java.util.stream.Collectors;

 class Solution {
            public String solution(int[] numbers) {
                String result = Arrays.stream(numbers)
                        .mapToObj(String::valueOf)
                        .sorted(
                                (o1, o2) -> {
                                    String s1 = o1 + o2;
                                    String s2 = o2 + o1;

                                    return s2.compareTo(s1);
                                }
                        ).collect(Collectors.joining(""));
                return result.startsWith("0") ? "0" : result;
            }
            
        }