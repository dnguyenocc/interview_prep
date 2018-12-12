import com.sun.tools.javac.code.Attribute;

import java.util.*;

public class SteakHouse {
    public static void main(String[] args) {
        Integer[] x = {0, 1, 0, 0, 0};
        Integer[] y = {1, 0, 0, 1, 0};
        List<Integer> list = Arrays.asList(x);
        List<List<Integer>> input = Arrays.asList(Arrays.asList(x), Arrays.asList(y));
        List<List<Integer>> result = nearest(input,1);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }



    }

    static List<List<Integer>> nearest(List<List<Integer>> list, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<Point>((o1, o2) ->  (int)(- o1.d  + o2.d ));

        Iterator<List<Integer>> iter = list.listIterator();
        for (int i = 0; i < Math.min(k, list.size()); i++) {
            pq.add(new Point(iter.next()));
        }
        for (int i = Math.min(k, list.size()); i < Math.max(k, list.size()); i++) {
            Point p = new Point(iter.next());
            if (p.d < pq.peek().d) {
                pq.poll();
                pq.add(p);
            }
        }
        List[] result = new List[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().p;
        }
        return Arrays.asList(result);

    }
    static class Point {
        List<Integer> p;
        double d;

        Point(List<Integer> p) {
            this.p = p;
            this.d = 0;
            for (int i: p) {
                this.d += i*i;
            }
            this.d = Math.sqrt(this.d);
        }

        @Override
        public String toString() {
            return p.toString();
        }
    }
}
