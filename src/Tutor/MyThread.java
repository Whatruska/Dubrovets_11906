package Tutor;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
