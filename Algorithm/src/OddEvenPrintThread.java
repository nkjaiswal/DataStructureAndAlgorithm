public class OddEvenPrintThread {
//    public static void main(String[] args) {
//        new OddEvenPrintThread().run();
//    }
//
//    public void run() {
//        Printer p =new Printer();
//        new Thread(new MyThreadOdd(p)).start();
//        new Thread(new MyThreadEven(p)).start();
//    }
//
//    public static int count = 1;
//    public static final Object oddLock = new Object();
//    public static final Object evenLock = new Object();
//
//    static class MyThreadOdd implements Runnable {
//        Printer p;
//        MyThreadOdd(Printer p){
//            this.p = p;
//        }
//        @Override
//        public void run() {
//            while(true){
//                p.printOdd(0);
//            }
//        }
//    }
//
//    static class MyThreadEven implements Runnable {
//        Printer p;
//        MyThreadEven(Printer p){
//            this.p =p;
//        }
//        @Override
//        public void run() {
//            while(true){
//               p.printEven(0);
//            }
//        }
//    }
//
//    static class Printer {
//        boolean isOdd = false;
//
//        synchronized void printEven(int number) {
//            while (!isOdd) {
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println("EVEN");
//            isOdd = false;
//            notifyAll();
//        }
//
//        synchronized void printOdd(int number) {
//            while (isOdd) {
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println("ODD");
//            isOdd = true;
//            notifyAll();
//        }
//    }
}
