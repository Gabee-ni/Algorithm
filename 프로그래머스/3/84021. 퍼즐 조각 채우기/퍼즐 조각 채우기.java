import java.util.*;

class Solution {

    int n;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;

        List<List<int[]>> blanks = new ArrayList<>();
        List<List<int[]>> puzzles = new ArrayList<>();

        boolean[][] visitedBoard = new boolean[n][n];
        boolean[][] visitedTable = new boolean[n][n];

        // 1. game_board에서 빈칸(0) 추출
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (!visitedBoard[r][c] && game_board[r][c] == 0) {
                    List<int[]> shape = bfs(game_board, visitedBoard, r, c, 0);
                    blanks.add(normalize(shape));
                }
            }
        }

        // 2. table에서 퍼즐 조각(1) 추출
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (!visitedTable[r][c] && table[r][c] == 1) {
                    List<int[]> shape = bfs(table, visitedTable, r, c, 1);
                    puzzles.add(normalize(shape));
                }
            }
        }

        boolean[] used = new boolean[puzzles.size()];
        int answer = 0;

        // 3. 빈칸마다 퍼즐 조각 비교
        for (List<int[]> blank : blanks) {
            for (int i = 0; i < puzzles.size(); i++) {
                if (used[i]) continue;

                List<int[]> puzzle = puzzles.get(i);

                if (blank.size() != puzzle.size()) continue;

                if (isMatch(blank, puzzle)) {
                    used[i] = true;
                    answer += blank.size();
                    break;
                }
            }
        }

        return answer;
    }

    private List<int[]> bfs(int[][] board, boolean[][] visited, int sr, int sc, int target) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> shape = new ArrayList<>();

        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            shape.add(new int[]{r, c});

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (visited[nr][nc]) continue;
                if (board[nr][nc] != target) continue;

                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }

        return shape;
    }

    private List<int[]> normalize(List<int[]> shape) {
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;

        for (int[] p : shape) {
            minR = Math.min(minR, p[0]);
            minC = Math.min(minC, p[1]);
        }

        List<int[]> result = new ArrayList<>();

        for (int[] p : shape) {
            result.add(new int[]{p[0] - minR, p[1] - minC});
        }

        result.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        return result;
    }

    private boolean isMatch(List<int[]> blank, List<int[]> puzzle) {
        List<int[]> rotated = puzzle;

        for (int i = 0; i < 4; i++) {
            rotated = rotate(rotated);
            rotated = normalize(rotated);

            if (isSame(blank, rotated)) {
                return true;
            }
        }

        return false;
    }

    private List<int[]> rotate(List<int[]> shape) {
        List<int[]> result = new ArrayList<>();

        for (int[] p : shape) {
            int r = p[0];
            int c = p[1];

            // 90도 회전: (r, c) -> (c, -r)
            result.add(new int[]{c, -r});
        }

        return result;
    }

    private boolean isSame(List<int[]> a, List<int[]> b) {
        if (a.size() != b.size()) return false;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] != b.get(i)[0]) return false;
            if (a.get(i)[1] != b.get(i)[1]) return false;
        }

        return true;
    }
}