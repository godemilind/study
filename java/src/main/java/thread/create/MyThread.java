package thread.create;

public class MyThread extends Thread{

    @Override
    public void run() {
        super.run();
        System.out.println("Thread is running");
    }
}
