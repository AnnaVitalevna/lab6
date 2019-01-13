
package log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Thread1 extends Thread {
    String name; Date date; SimpleDateFormat DateFormat;
    Thread1(String thname){
        name=thname;
        DateFormat =new SimpleDateFormat("E yyyy.MM.dd hh:mm:ss:SS");
        Thread newThread= new Thread(this,name);
        newThread.start();
    }
    public void run(){
        try{
            for (int i=10;i>0;i--){
                date=new Date();
                System.out.println(name+": "+DateFormat.format(date));
                Thread.sleep(600);
            }
        }
        catch (InterruptedException e){ System.out.println("Error"); }
        System.out.println(name+" завершился");
    }
}
