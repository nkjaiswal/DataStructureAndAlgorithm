import java.util.ArrayList;
import java.util.List;

public class Compression {
    public static void main(String[] args) {
        System.out.println((5^6)^(6^7));
        List<Integer> data = getData();

        if (data.size() % 3 == 2) {
            data.add(99);
        }
        if (data.size() % 3 == 1) {
            data.add(99);
            data.add(99);
        }
        System.out.println(uncompress(compress(data)));
    }

    private static List<Integer> getData() {
        List<Integer> data = new ArrayList<>();
        data.add(10);
        data.add(20);
        data.add(0);
        data.add(4);
        data.add(7);
        data.add(140);
        data.add(90);
        data.add(1110);
        return data;
    }

    public static List<Integer> compress(List<Integer> data) {
        List<Integer> A = new ArrayList<>(), B = new ArrayList<>(), C = new ArrayList<>();
        int size = data.size();
        for (int i=0; i<size; i++){
            if (i < size / 3) {
                A.add(data.get(i));
            } else
            if(i>=(size)/3 && i<(size*2)/3){
                B.add(data.get(i));
            } else {
                C.add(data.get(i));
            }
        }
        System.out.print("A="); System.out.println(A);
        System.out.print("B="); System.out.println(B);
        System.out.print("C="); System.out.println(C);
        List<Integer> AB = getXOR(A,B), BCA = getXOR(getXOR(B,C), A);
        System.out.print("A^B="); System.out.println(AB);
        System.out.print("B^C=");  System.out.println(BCA);
        AB.addAll(BCA);
        System.out.print("A^B B^C^A="); System.out.println(AB);
        return AB;
    }

    public static List<Integer> uncompress(List<Integer> compressedData) {
        int size = compressedData.size();
        List<Integer> set1 = new ArrayList<>(), set2 = new ArrayList<>();

        for(int i=0; i<size; i++){
            if(i<size/2){
                set1.add(compressedData.get(i));
            } else {
                set2.add(compressedData.get(i));
            }
        }
        System.out.println(set1);
        System.out.println(set2);
        List<Integer> C = getXOR(set1, set2);
        System.out.print("C="); System.out.println(C);
        return null;
    }

    public static List<Integer> getXOR(List<Integer> s1, List<Integer> s2) {
        List<Integer> AB = new ArrayList<>();
        for(int i=0; i<s1.size(); i++){
            AB.add(s1.get(i)^s2.get(i));
        }
        return AB;
    }
}
