package ua.edu.sumdu.j2se.pr6;

/**
 * Created by God on 09.03.2017.
 */
public class ThreadDemo {

    public static void main(String[] args) {
        class Tread1 extends Thread{
            @Override
            public void run() {

                synchronized (System.out) {
                    try {
                        sleep(300);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    print10();
                }
            }
            public void print10(){
                for (int i = 0; i < 10; i++) {
                    System.out.print("Thread1: ");
                    for (int j = 0; j < 10; j++) {
                        System.out.print(i*10+j+1 + " ");
                    }
                    System.out.println();
                }
            }
        }
        Tread1 t = new Tread1();
        t.setPriority(Thread.MAX_PRIORITY);

        class TreadDemon extends Thread{
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("I`m alive!");
                    try{
                        Thread.sleep(10);
                    } catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        }

        TreadDemon td = new TreadDemon();
        td.setDaemon(true);
        td.start();

        System.out.println("Start of Thread1");
        t.start();

        System.out.println("Start of Thread2");
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        print10();
                    }
                    public synchronized void print10() {
                        for (int i = 0; i < 10; i++) {
                            System.out.print("Thread2: ");
                            for (int j = 0; j < 10; j++) {
                                System.out.print(i * 10 + j + 101 + " ");
                            }
                            System.out.println();
                        }
                    }
                }

        ).start();
        t.suspend();
        System.out.println(t.getState());
        t.resume();
        System.out.println(t.getState());
        //t.stop();
        System.out.println(t.getState());

    }

}
