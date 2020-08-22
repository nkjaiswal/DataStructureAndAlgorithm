public class Visa3 {
    public static void main(String[] args){
        SinglyLinkedListNode n5 = new SinglyLinkedListNode(22, null);
        SinglyLinkedListNode n4 = new SinglyLinkedListNode(21, n5);
        SinglyLinkedListNode n3 = new SinglyLinkedListNode(130, n4);
        SinglyLinkedListNode n2 = new SinglyLinkedListNode(110, n3);
        SinglyLinkedListNode n1 = new SinglyLinkedListNode(200, n2);
        System.out.println(removeNodes(n1, 20));

    }
    public static SinglyLinkedListNode removeNodes(SinglyLinkedListNode listHead, int x){
        SinglyLinkedListNode head = null;
        while( listHead !=null && listHead.data > x){
            listHead = listHead.next;
        }
        head = listHead;
        if(head == null)
            return head;
        SinglyLinkedListNode temp = head;
        while(temp.next != null){
            if(temp.next.data > x){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return head;
    }
}




class SinglyLinkedListNode{
    int data;

    public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
        this.data = data;
        this.next = next;
    }

    SinglyLinkedListNode next;


    public String toString() {
        return data + "->" + next;
    }
}
