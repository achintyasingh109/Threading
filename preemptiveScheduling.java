public class preemptiveScheduling {

    public static void main(String[] args) {
        Thread a = new Thread(new A(), "Thread 1");
        Thread b = new Thread(new B(), "Thread 2");

        System.out.println("a priority before " + a.getPriority());
        System.out.println("b priority before " + b.getPriority());

        b.setPriority(10);
        a.setPriority(2);


        a.start();
        b.start();
        int[][] A = new int[1000][1000];
        int[][] B = new int[1000][1000];
        int[][] C = new int[1000][1000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                A[i][j] = (int) (Math.random() * 100);
                B[i][j] = (int) (Math.random() * 100);
            }
        }
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                C[i][j] = A[i][j] * B[i][j];
            }
        }
        System.out.println("main runs");

        System.out.println("Hello World");
        System.out.println("a priority after " + a.getPriority());
        System.out.println("b priority after " + b.getPriority());

    }
}

    class B implements Runnable {

        @Override
        public void run() {
            int[][] A = new int[10][10];
            int[][] B = new int[10][10];
            int[][] C = new int[10][10];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    A[i][j] = i * j;
                    B[i][j] = i * j;
                }
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    C[i][j] = A[i][j] * B[i][j];
                }
            }
            System.out.println("b runs");


        }
    }

    class A implements Runnable {

        @Override
        public void run() {
            int[][] A = new int[10][10];
            int[][] B = new int[10][10];
            int[][] C = new int[10][10];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    A[i][j] = i * j;
                    B[i][j] = i * j;
                }
            }
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    C[i][j] = A[i][j] * B[i][j];
                }
            }
            System.out.println("a runs");


        }
    }



