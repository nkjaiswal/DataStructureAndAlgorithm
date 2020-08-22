public class LLBinaryToDecimal {

    public static void main(String[] args) {
        SinglyLinkedListNode l1 = new SinglyLinkedListNode(1, new SinglyLinkedListNode(0,new SinglyLinkedListNode(0,null)));
        System.out.println(getNumber(l1));
    }


    public static long getNumber(SinglyLinkedListNode binary){
        int length = getLength(binary);
//        System.out.println(length);
        return (long) getValue(binary, length-1);
    }

    private static double getValue(SinglyLinkedListNode binary, int length){
        if(length == 0){
            return binary.data;
        }
        return Math.pow(2,length)*binary.data + getValue(binary.next, length-1);
    }

    private static int getLength(SinglyLinkedListNode binary){
        if(binary == null)
            return 0;
        else
            return 1+getLength(binary.next);
    }
}
