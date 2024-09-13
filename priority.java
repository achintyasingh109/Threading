class PreemptiveThread implements Runnable {
//    public PreemptiveThread(String name) {
//        super(name);
//    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Running, Iteration: " + i);

            // Simulate some work with sleep
            try {
                Thread.sleep(200); // Pause for 200 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " - Completed.");
    }
}

public class priority {
    public static void main(String[] args) {

        Thread A = new Thread(new PreemptiveThread(),"Low Priority Thread");
        Thread B = new Thread(new PreemptiveThread(),"High Priority Thread");


        B.setPriority(Thread.MIN_PRIORITY); // Priority 1
        // WE CAN USE MIN_PRIORITY AND MAX_PRIORITY FOR SETTING PRIORITY JUST LIKES MAX_INTEGER VALUE
        A.setPriority(Thread.MAX_PRIORITY); // Priority 10


        A.start();
        B.start();
    }
}
