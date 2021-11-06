package thread.create;

public class Main {
    public static void main(String []args){
        MyThread thread = new MyThread();
        thread.start();

        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();
    }
}
