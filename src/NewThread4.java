//���������� ������� isAlive() � join()
public class NewThread4 implements Runnable {
    String name;
    Thread t;

    NewThread4 (String threadname){
        name=threadname;
        t= new Thread(this,name);
        System.out.println("����� �����: "+t);
        t.start();
    }

    public void run(){
        try{
            for (int i=5;i>0;i--){
                System.out.println(name+": "+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            System.out.println(name+" �������.");
        }
        System.out.println(name+" ��������.");
    }
}

class DemoJoin {
    public static void main (String args[]){
        NewThread4 ob1 = new NewThread4("����");
        NewThread4 ob2 = new NewThread4("���");
        NewThread4 ob3 = new NewThread4("���");

        System.out.println("����� ���� �������: "+ob1.t.isAlive());
        System.out.println("����� ��� �������: "+ob2.t.isAlive());
        System.out.println("����� ��� �������: "+ob3.t.isAlive());

        try{
            System.out.println("�������� ���������� �������...");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e){
            System.out.println("������� ����� �������.");
        }
        System.out.println("����� ���� �������: "+ob1.t.isAlive());
        System.out.println("����� ��� �������: "+ob2.t.isAlive());
        System.out.println("����� ��� �������: "+ob3.t.isAlive());

        System.out.println("������� ����� ��������.");
    }
}