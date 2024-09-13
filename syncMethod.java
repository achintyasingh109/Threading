

public class syncMethod {
    public static void main(String[] args) throws InterruptedException {
        Counter c=new Counter();
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

class  Counter{
    private int count;
    public synchronized void increase(){
       count++;
    }
    public int getCount() {
        return count;
    }

}













//        int c=0;
//        ExecutorService e = Executors.newFixedThreadPool(2);
////        Thread t1=new Thread(new Synchro<T>(c),"thread 1");
////        Thread t2=new Thread(new Synchro<T>(c),"thread 2");
//        Synchro t1 = new Synchro(c);
//        Synchro t2 = new Synchro(c);
//
//        e.submit(t1);
//        e.submit(t2);
//        System.out.println(c);
//    }
//
//    class Synchro implements Callable<Integer>{
//        public int c;
//
//        public Synchro(int c){
//            this.c=c;
//        }
//        @Override
//        public Integer call() throws Exception {
//            for(int i=0;i<1001;i++){
//                c++;
//            }
//            return c;
//        }
//    }


//    public static void main(String[] args) {
//        int c=0;
//        Thread t1=new Thread(new Synchro1(),"thread 1");
//        Thread t2=new Thread(new Synchro1(),"thread 2");
//        t1.start();
//        t2.start();
//
//    }
//}
//
//class Synchro1 implements Runnable{
//    Counter c=new Counter();
//    @Override
//    public void run(){
//        for(int i=0;i<1000;i++){
//            c.increase();
//        }
//        System.out.println(c);
//    }
//
////    public int count;
////    public Synchro1(int count){
////        this.count=count;
////    }
////    @Override
////    public void run(){
////        for(int i=0;i<1000;i++){
////            count++;
////        }
////        System.out.println(count);
////    }
//
//
//}
//
//class Counter{
//    int count;
//    public void increase(){
//        count++;
//    }
//}


