import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<Integer, String> rankMap = new HashMap<>();
        Map<String, Integer> playerMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            String player = players[i];
            playerMap.put(player, i);
            rankMap.put(i, player);
        }

        for (String calling : callings) {
            Integer rightPlayerRank = playerMap.get(calling);
            String rightPlayer = rankMap.get(rightPlayerRank);

            String leftPlayer = rankMap.get(rightPlayerRank - 1);
            Integer leftPlayerRank = playerMap.get(leftPlayer);


            leftPlayerRank += 1;
            rightPlayerRank -= 1;

            playerMap.put(leftPlayer, leftPlayerRank);
            rankMap.put(leftPlayerRank, leftPlayer);

            playerMap.put(rightPlayer, rightPlayerRank);
            rankMap.put(rightPlayerRank, rightPlayer);
        }

        String[] answer = new String[players.length];

        for (Map.Entry<String, Integer> entry : playerMap.entrySet()) {
            answer[entry.getValue()] = entry.getKey();
        }

        return answer;
    }

}