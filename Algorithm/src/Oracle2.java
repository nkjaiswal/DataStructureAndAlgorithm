/*
[3,3,1,1,2,5,5,5]
3->2
1->2
2->1
5->3
{3,5}, {2,3}, {2,1}, {1,2}
k = 2
{count, key}
{3,5}, {2,3}
return 5, 3
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Oracle2 {
    public static void main(String[] args) {
        int a[] = {3,3,1,1,2,5,5,5,5,5,3,3,3,12,11,34};
        int k = 10;
        System.out.println(new Oracle2().getKTopCounts(a, k));
    }

    /**
     * Test, null, length<k, unique_element<k
     * @param arr
     * @param k
     * @return
     */

    public List<Integer> getKTopCounts(int[] arr, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Map<Integer, Integer> counts = new HashMap<>();

        if(arr.length < k) {
            throw new NoSuchElementException("A");
        }
        for(int a: arr) {
            if(!counts.containsKey(a)) {
                counts.put(a, 0);
            }
            counts.put(a, counts.get(a)+1);
        }

        if(counts.size() < k) {
            throw new NoSuchElementException("B");
        }
        for(Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        List<Integer> solution = new ArrayList<>();
        for(int i=0; i<k; i++){
            solution.add(pq.remove().key);
        }

        return solution;
    }
}

class Node implements Comparable<Node>{
    int key;
    int count;

    public Node(int key, int count) {
        this.key = key;
        this.count = count;
    }

    @java.lang.Override
    public int compareTo(Node o) {
        return o.count - this.count;
    }
}