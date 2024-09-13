public class syncBlock {
    public static void main(String[] args) throws InterruptedException {
        Counter1 c=new Counter1();
        Thread t1 =new Thread(() -> {  //Runnable was there but is now
                                       //replaced with lambda , will work same
            for(int i=1;i<=1000;i++) {
                c.increase();
            }

        });
        Thread t2 =new Thread(() -> {

            for(int i=1;i<=1000;i++) {

                c.increase();
            }

        });
//        t1.setPriority(10);
//        t2.setPriority(10);
        t1.start();

        t2.start();
        try{
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(c.getCount());
    }
}
class  Counter1{
    private int count;
    public void increase(){
        String tName=Thread.currentThread().getName();
        System.out.println(tName);
        synchronized (this) {  // Now we are using Synchronized block.
            count++;
        }
    }
    public int getCount() {
        return count;
    }

}

