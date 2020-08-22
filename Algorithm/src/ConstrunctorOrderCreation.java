public class ConstrunctorOrderCreation {
    public static void main(String[] args) {
        new Z();
    }
}

class X{
    X(){
        System.out.println("X");
    }

}

class Y extends X{
    Y(){
        System.out.println("Y");
    }

}

class Z extends Y{
    Z(){
        System.out.println("Z");
    }

}