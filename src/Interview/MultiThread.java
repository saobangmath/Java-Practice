package Interview;

public class MultiThread extends Thread implements Runnable{
    public void run(){
        for (int i = 0; i < 5; i++){
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
    public static void main(String[] args){
        MultiThread t1 = new MultiThread();
        MultiThread t2 = new MultiThread();
        MultiThread t3 = new MultiThread();
        try{
            t1.join();
        }
        catch (Exception e){

        }
        finally {
            t2.start();
            t3.start();
        }
        //System.out.println(t1.getState());
    }
}
