package ru.geekbrains.java.pign_pong;

public class PrintPingPong {
    private final Object mon = new Object();
    private volatile String wordToPrint = "Ping";
    private final int NUMBER_TO_PRINT = 5;

    public void printPing() {
        synchronized (mon) {
            try {
                for (int i = 0; i < NUMBER_TO_PRINT; i++) {
                    while (!wordToPrint.equals ("Ping")) {
                        mon.wait();
                    }
                    System.out.print("Ping");
                    wordToPrint = "Pong";
                    mon.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void printPong() {
        synchronized (mon) {
            try {
                for (int i = 0; i < NUMBER_TO_PRINT; i++) {
                    while (!wordToPrint.equals ("Pong")) {
                        mon.wait();
                    }
                    System.out.print("Pong ");
                    wordToPrint = "Ping";
                    mon.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        PrintPingPong printer = new PrintPingPong ();
        Thread t1 = new Thread(() -> {
            printer.printPing ();
        });
        Thread t2 = new Thread(() -> {
            printer.printPong ();
        });
        t1.start();
        t2.start();
    }

}
