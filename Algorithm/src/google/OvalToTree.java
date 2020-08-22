package google;


import java.util.ArrayList;
import java.util.List;

class Node {
    int id;
    List<Node> childs = new ArrayList<>();
}

class OvalToTree {
    //[1,1,1,0,1,0,0,1,1,0,1,0,0,0]
    public static void main(String[] args) {
        int[] oval = {1,1,1,0,1,0,0,1,1,0,1,0,0,0};
        Node treeRoot = new OvalToTree().convert(oval);
        System.out.println("Done");
    }

    public Node convert(int[] oval) {
        Node preRoot = new Node();
        int pointer = 0;
        this.constructTree(preRoot, pointer, oval);
        return preRoot;
    }

    public int constructTree(Node treeNode, int pointer, int[] oval) {
        while(pointer < oval.length) {
            if(oval[pointer] == 1) {
                Node childNode = new Node();
                treeNode.childs.add(childNode);
                pointer = constructTree(childNode, pointer + 1, oval);
            } else {
                return pointer + 1;
            }
        }
        return 0;
    }
}