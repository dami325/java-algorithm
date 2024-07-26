import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Album> albumList = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            albumList.add(new Album(i, genre, play));
        }

        Map<String, Integer> albumMap = albumList.stream()
                .collect(
                        Collectors.groupingBy(
                                Album::getGenres,
                                Collectors.summingInt(Album::getPlays)
                        ));

        List<Map.Entry<String, Integer>> sortedGenres = albumMap.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : sortedGenres) {
            List<Album> sortedAlbums = albumList.stream()
                    .filter(album -> album.getGenres().equals(entry.getKey()))
                    .sorted((o1, o2) -> {
                        if (o2.getPlays() == o1.getPlays()) {
                            return o1.getAlbumId() - o2.getAlbumId();
                        }
                        return o2.getPlays() - o1.getPlays();
                    })
                    .collect(Collectors.toList());

            Iterator<Album> iterator = sortedAlbums.iterator();
            int count = 0;
            while (iterator.hasNext() && count < 2) {
                result.add(iterator.next().getAlbumId());
                count++;
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    class Album {
        private final int albumId;
        private final String genres;
        private final int plays;

        public Album(int albumId, String genres, int plays) {
            this.albumId = albumId;
            this.genres = genres;
            this.plays = plays;
        }

        public int getAlbumId() {
            return albumId;
        }

        public String getGenres() {
            return genres;
        }

        public int getPlays() {
            return plays;
        }
    }
}