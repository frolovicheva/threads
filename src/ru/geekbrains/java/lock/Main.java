package ru.geekbrains.java.lock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CounterWithLock counter = new CounterWithLock ();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        counter.incCounter ();
                    }
                }
            }).start();
        }

        Thread.sleep(2000);
        System.out.println (counter.getCounter ());
    }
}
