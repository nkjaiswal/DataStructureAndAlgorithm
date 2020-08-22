import java.util.HashMap;
import java.util.Map;

class TestClass {
    public static void main(String[] args) {
        String A = "abcdefghi";
        String B = "tocc";
        new TestClass().findMinRange(A, B);
    }

    public void findMinRange(String source, String dest) {
        Map<Character, Integer> bMap = new HashMap<>();
        for(Character s : dest.toCharArray()) {
            if(!bMap.containsKey(s)) {
                bMap.put(s, 0);
            }
            bMap.put(s, bMap.get(s)+1);
        }

        int left = 0;
        int right = 0;

        Map<Character, Integer> aMap = new HashMap<>();
        for (int i=0; i<source.length(); i++) {
            if(bMap.containsKey(source.charAt(i))) {
                if(!aMap.containsKey(source.charAt(i))) {
                    aMap.put(source.charAt(i), 0);
                }
                aMap.put(source.charAt(i), aMap.get(source.charAt(i))+1);
                if(isDestCovered(aMap, bMap)) {
                    while (true) {
                        if(bMap.containsKey(source.charAt(left))) {
                            if (bMap.get(source.charAt(left)) < aMap.get(source.charAt(left))) {
                                aMap.put(source.charAt(left), aMap.get(source.charAt(left))-1);
                                left ++;
                            } else {
                                break;
                            }
                        } else {
                            left++;
                        }
                    }
                    System.out.println("left, right " + left + ", " + i);
                }

            }


        }
    }

    private boolean isDestCovered(Map<Character, Integer> aMap, Map<Character, Integer> bMap) {
        for (Map.Entry<Character, Integer> e: bMap.entrySet()) {
            if (!aMap.containsKey(e.getKey())) {
                return false;
            }
            if (aMap.get(e.getKey()) < e.getValue()) {
                return false;
            }
        }
        return true;
    }
}


































////Asked in R JIO
//
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.PriorityQueue;
//
////[ L1: 1->4->5, L2: 1->2->3->6, L3:2->5->7->9->10]
//class Node implements Comparable<Node> {
//    LinkedList<Integer> header;
//
//    @java.lang.Override
//    public String toString() {
//        return "Node{" +
//                "header=" + header +
//                ", topValue=" + topValue +
//                '}';
//    }
//
//    Integer topValue; // only field should be used for compareTo
//
//    public Node(LinkedList<Integer> ll, Integer first) {
//        this.header = ll;
//        this.topValue = first;
//    }
//
//    @java.lang.Override
//    public int compareTo(Node o) {
//        return this.topValue - o.topValue;
//    }
//}
//class TestClass {
//    public static void main(String[] args) throws Exception {
//
//        LinkedList<Integer> ll1 = new LinkedList<>();
//        ll1.add(1); ll1.add(4); ll1.add(5);
//
//        LinkedList<Integer> ll2 = new LinkedList<>();
//        ll2.add(1); ll2.add(2); ll2.add(3); ll2.add(6);
//
//        LinkedList<Integer> ll3 = new LinkedList<>();
//        ll3.add(2); ll3.add(5); ll3.add(7); ll3.add(9); ll3.add(10);
//
//        System.out.println(new TestClass().getMergedLinkedList(Arrays.asList(ll1, ll2, ll3)));
//    }
//
//    public LinkedList<Integer> getMergedLinkedList(List<LinkedList<Integer>> linkedlists){
//        PriorityQueue<Node> pq = new PriorityQueue<>(); //Min Heap
//        for (LinkedList<Integer> ll : linkedlists) {
//            pq.add(new Node(ll, ll.getFirst()));
//        }
//        LinkedList<Integer> mergedLinkedList = new LinkedList<>();
//        System.out.println(pq);
//        while(!pq.isEmpty()) {
//            Node top = pq.remove();
//            System.out.println(pq);
//            mergedLinkedList.add(top.topValue);
//            top.header.remove();
//            if(top.header != null && top.header.peekFirst()!=null) {
//                Node newNode = new Node(top.header, top.header.peekFirst()); // go to next node in LL
//                pq.add(newNode);
//            }
//        }
//        return mergedLinkedList;
//    }
//}
//
//
//
//
//
//
//
