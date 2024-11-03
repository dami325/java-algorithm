import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static class Directory {

        Map<String, Directory> child = new HashMap<>();

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Directory rootDirectory = new Directory();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Directory parent = rootDirectory;
            int depth = Integer.parseInt(st.nextToken());

            for (int j = 0; j < depth; j++) {
                String s = st.nextToken();
                if (!parent.child.containsKey(s)) {
                    parent.child.put(s, new Directory());
                }
                parent = parent.child.get(s);
            }
        }

        directoryPrint(rootDirectory, "");

        System.out.println(sb.toString());
    }

    private static void directoryPrint(Directory rootDirectory, String depth) {
        List<String> keyList = rootDirectory.child.keySet().stream().sorted()
                .collect(Collectors.toList());

        for (String key : keyList) {
            sb.append(depth).append(key).append("\n");
            directoryPrint(rootDirectory.child.get(key), depth + "--");
        }
    }
}