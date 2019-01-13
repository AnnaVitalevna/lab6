
package log;

public class Log {
    public static void main(String[] args){
        new Thread1("Поток 1");
        new Thread2("Поток 2");
        try{ Thread.sleep(6000); }
        catch (InterruptedException e){ System.out.println("Error"); }
    }
}
