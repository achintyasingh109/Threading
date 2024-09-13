public class staticSync {
    public static void main(String[] args) throws InterruptedException {
        Counter2 c=new Counter2();
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
class  Counter2{
    private static int count; // we have to use static keyword if a variable is used inside
                           // static synchronized method.
    public static synchronized void increase(){
        String tName=Thread.currentThread().getName();
        System.out.println(tName);
        count++;
    }

    public int getCount() {
        return count;
    }

}





