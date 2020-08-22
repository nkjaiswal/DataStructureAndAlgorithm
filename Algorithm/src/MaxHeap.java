import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MaxHeap {

//
//    public static void main(String[] args) {
//        MaxHeap heap;
//        heap = new MaxHeap(10);
//        heap.insert(20);
//        heap.insert(30);
//        heap.insert(15);
//        heap.insert(40);
//        System.out.println(heap.extractTop());
//        System.out.println(heap);
//        System.out.println(heap.extractTop());
//        System.out.println(heap.extractTop());
//        System.out.println(heap.extractTop());
//        heap.insert(20);
//        heap.insert(30);
//        heap.insert(15);
//        System.out.println(heap);
//        System.out.println(heap.extractTop());
//    }
//
//    int[] heap;
//    int maxSize;
//    int size;
//
//    public MaxHeap(int size) {
//        this.heap = new int[size];
//        this.maxSize = size;
//        this.size = 0;
//    }
//
//    private int getParent(int childPos) {
//        return childPos / 2;
//    }
//
//    private int getLeftChild (int parentPos) {
//        return 2*parentPos + 1;
//    }
//
//    private int getRightChild (int parentPos) {
//        return 2*parentPos + 2;
//    }
//
//    private boolean isLeaf(int pos) {
//        return pos >= size/2 && pos <= size;
//    }
//
//    private void swap(int i, int j) {
//        int temp = heap[i];
//        heap[i] = heap[j];
//        heap[j]= temp;
//    }
//
//    private void heapify(int nodeIndex) {
//        if (isLeaf(nodeIndex))
//            return;
//        if (heap[nodeIndex] < heap[getLeftChild(nodeIndex)] || heap[nodeIndex] < heap[getRightChild(nodeIndex)]) {
//            if (heap[getRightChild(nodeIndex)] > heap[getLeftChild(nodeIndex)]) {
//                swap(getRightChild(nodeIndex), nodeIndex);
//                heapify(getRightChild(nodeIndex));
//            } else {
//                swap(getLeftChild(nodeIndex), nodeIndex);
//                heapify(getLeftChild(nodeIndex));
//            }
//        }
//    }
//
//    public void insert(int data) {
//        heap[size] = data;
//        size++;
//        int parent = getParent(size);
//        int current = size;
//        while (current != parent) {
//            heapify(parent);
//            current = parent;
//            parent = getParent(parent);
//        }
//    }
//
//    public int extractTop(){
//        int d = heap[0];
//        heap[0] = heap[size-1];
//        size--;
//        heapify(0);
//        return d;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder s = new StringBuilder();
//        int count = 0;
//        for (int i : heap) {
//            if(count == size)
//                s.append("|");
//            s.append(i).append(",");
//            count++;
//        }
//        return s.toString();
//    }
}
