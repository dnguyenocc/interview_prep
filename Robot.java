import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Robot {
    static int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static void main(String[] arg) {
        List<List<Integer>> map = Arrays.asList(
                Arrays.asList(1, 0, 0),
                Arrays.asList(1, 0, 0),
                Arrays.asList(1, 9, 1)
        );
        List<List<Integer>> map2 = Arrays.asList(
                Arrays.asList(1, 1, 1, 1),
                Arrays.asList(0, 1, 1, 1),
                Arrays.asList(0, 1, 0, 1),
                Arrays.asList(1, 1, 9, 1),
                Arrays.asList(0, 0, 1, 1)
        );
        System.out.print(distance(map, 3, 3));
        System.out.print(distance(map2, 5, 4));
    }

    static int distance(List<List<Integer>> map, int numRows, int numCols) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0));
        int[][] dist = new int[numRows][numCols];
        boolean[][] visited = new boolean[numRows][numCols];
        visited[0][0] = true;
        dist[0][0] = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;
            if (map.get(x).get(y) == 9) {
                return dist[x][y];
            }
            for (int i = 0; i < moves.length; i++) {
                int nextX = x + moves[i][0];
                int nextY = y + moves[i][1];
                if (nextX >= 0 && nextX < numRows && nextY >= 0 && nextY < numCols
                        && map.get(nextX).get(nextY) != 0 && !visited[nextX][nextY]) {
                    queue.add(new Point(nextX, nextY));
                    visited[nextX][nextY] = true;
                    dist[nextX][nextY] = dist[x][y] + 1;
                }
            }
        }
        return 1;
    }


    static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
