import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int sharkX, sharkY;
    static int sharkSize = 2;
    static int eatCount = 0;
    static int time = 0;

    static int[] dx = {-1, 0, 0, 1}; // 위, 왼, 오른, 아래
    static int[] dy = {0, -1, 1, 0};

    static class Node {
        int x, y, dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0; // 시작 위치는 빈칸 처리
                }
            }
        }

        while (true) {
            Node fish = bfs();

            if (fish == null) break; // 더 이상 먹을 물고기 없음

            // 이동
            sharkX = fish.x;
            sharkY = fish.y;
            time += fish.dist;

            // 먹기
            map[sharkX][sharkY] = 0;
            eatCount++;

            // 성장
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(time);
    }

    static Node bfs() {
        boolean[][] visited = new boolean[N][N];
        Queue<Node> q = new LinkedList<>();
        List<Node> fishes = new ArrayList<>();

        q.offer(new Node(sharkX, sharkY, 0));
        visited[sharkX][sharkY] = true;

        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            // 이미 최소 거리보다 멀면 더 볼 필요 없음
            if (cur.dist > minDist) continue;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                // 자기보다 큰 물고기가 있으면 못 지나감
                if (map[nx][ny] > sharkSize) continue;

                visited[nx][ny] = true;

                int ndist = cur.dist + 1;

                // 먹을 수 있는 물고기
                if (map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
                    fishes.add(new Node(nx, ny, ndist));
                    minDist = ndist;
                }

                q.offer(new Node(nx, ny, ndist));
            }
        }

        if (fishes.isEmpty()) return null;

        fishes.sort((a, b) -> {
            if (a.dist != b.dist) return a.dist - b.dist;
            if (a.x != b.x) return a.x - b.x;
            return a.y - b.y;
        });

        return fishes.get(0);
    }
}