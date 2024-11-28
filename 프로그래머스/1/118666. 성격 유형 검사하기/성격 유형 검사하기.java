import java.util.HashMap;
import java.util.Map;

class Solution {

        private static Category[] categories;

        public String solution(String[] survey, int[] choices) {

            Map<Character, Category> map = new HashMap<>();
            map.put('R',new Category('R',0));
            map.put('T',new Category('T',0));
            map.put('C',new Category('C',0));
            map.put('F',new Category('F',0));
            map.put('J',new Category('J',0));
            map.put('M',new Category('M',0));
            map.put('A',new Category('A',0));
            map.put('N',new Category('N',0));

            for (int i = 0; i < survey.length; i++) {
                String s = survey[i];

                char left = s.charAt(0);
                char right = s.charAt(1);

                Category leftCategory = map.get(left);
                Category rightCategory = map.get(right);

                updateScore(choices[i], leftCategory, rightCategory);

            }

            String result = "";
            result += better(map.get('R'), map.get('T'));
            result += better(map.get('C'), map.get('F'));
            result += better(map.get('J'), map.get('M'));
            result += better(map.get('A'), map.get('N'));

            return result;
        }

        public char better(Category left, Category right) {
            if(left.score == right.score){
                return (left.name - right.name) < 0 ? left.name : right.name;
            }
            return (left.score - right.score) > 0 ? left.name : right.name;
        }

        private void updateScore(int num, Category left, Category right) {
            switch (num) {
                case 1:
                    left.addScore(3);
                    break;
                case 2:
                    left.addScore(2);
                    break;
                case 3:
                    left.addScore(1);
                    break;
                case 4:
                    break;
                case 5:
                    right.addScore(1);
                    break;
                case 6:
                    right.addScore(2);
                    break;
                case 7:
                    right.addScore(3);
                    break;
            }
        }

        private class Category {
            char name;
            int score;

            public Category(char name, int score) {
                this.name = name;
                this.score = score;
            }

            public void addScore(int score) {
                this.score += score;
            }

        }
}
