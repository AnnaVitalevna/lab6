//�������� ������ � ������� ���������� Runnable
public class NewThread2 implements Runnable {
    Thread t;

    NewThread2(){
        t=new Thread(this,"���������������� �����");
        System.out.println("�������� ����� ������: "+t);
        t.start();
    }

    public void run(){
        try{
            for(int i=5; i>0; i--){
                System.out.println("� ����� ����������������! "+i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e){
            System.out.println("�������� ����� �������.");
        }
        System.out.println("�������� ����� ��������.");
    }
}

class ThreadDemo{
    public static void main(String args[]){
        new NewThread2();

        try{
            for(int i=5;i>0;i--){
                System.out.println("������� �����: "+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            System.out.println("������� ����� �������.");
        }
        System.out.println("������� ����� ��������.");
    }
}