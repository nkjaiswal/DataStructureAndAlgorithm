public class StaticTest {
    public static void main(String[] args) {
        A a = new B();

    }
}

class A {
    public static void test() {
        System.out.println("A-Static-Test");
    }
}


class B extends A {
    public static void test() {
        System.out.println("B-Static-Test");
    }
}