import java.util.*;

public class Malware {
    public static void main(String[] args) {
        Integer[][] com_0 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        List<List<Integer>> matrix = new ArrayList<>();
        for (Integer[] aCom_0 : com_0) {
            matrix.add(Arrays.asList(aCom_0));
        }
        for (List<Integer> a : matrix) {
            System.out.print("{");
            for (int i: a) {
                System.out.print(i);
            }
            System.out.println("}");
        }
        List<Integer> infectedMachines = Arrays.asList(0, 2);
        List<Integer> result = solution(matrix, infectedMachines);
        for (int i: result) {
            System.out.print(i);
        }
    }


    public static List<Integer> solution(List<List<Integer>> matrix, List<Integer> infectedMachines) {
        List<Integer> result = new ArrayList<>();

        int V = matrix.size();
        boolean[] visited = new boolean[V];
        for (int v = 0; v < V; v++) {
            visited[v] = false;
        }
        Map<Integer, Group> dict = new HashMap<>();
        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                Group a = new Group();
                a.groupSize++;
                if (infectedMachines.contains(v)) {
                    a.numinff++;
                }
                dict.put(v, a);
                dfs(v, matrix, infectedMachines, visited, dict);
            }
        }
        int max = 0;
        for (int i : infectedMachines) {
            Group a = dict.get(i);
            if (a.numinff == 1) {
                if (a.groupSize > max) {
                    result.clear();
                    max = a.groupSize;
                }
                if (max == a.groupSize) {
                    result.add(i);
                }
            }
        }

        return result;
    }

    static void dfs(int i, List<List<Integer>> matrix,  List<Integer> infectedMachines, boolean[] visited, Map<Integer, Group> dict) {
        int j;
        visited[i] = true;
        for (j=0; j < matrix.size(); j++) {
            if (!visited[j] && matrix.get(i).get(j) == 1) {
                Group a = dict.get(i);
                a.groupSize++;
                if (infectedMachines.contains(j)) {
                    a.numinff++;
                }
                dict.put(j, a);
                dfs(j, matrix, infectedMachines, visited, dict);
            }
        }
    }


    static class Group {
        int groupNumber = 0;
        int groupSize = 0;
        int numinff = 0;


    }
}
