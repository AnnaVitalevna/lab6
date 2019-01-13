//�������� ���������� ������� ����������
public class NewThread3 implements Runnable {
    String name;
    Thread t;

    NewThread3(String threadname){
        name=threadname;
        t= new Thread(this,name);
        System.out.println("����� �����: "+t);
        t.start();
    }

    public void run(){
        try{
            for(int i=5; i>0; i--){
                System.out.println(name+"; "+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            System.out.println(name+" �������");
        }
        System.out.println(name+" ��������");
    }
}

class MultiThreadDemo {
    public static void main (String args[]){
        new NewThread3("����");
        new NewThread3("���");
        new NewThread3("���");

        try{
            Thread.sleep(10000);
        } catch (InterruptedException e){
            System.out.println("������� ����� �������.");
        }
        System.out.println("������� ����� ��������");
    }
}