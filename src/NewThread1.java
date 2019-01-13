//�������� ������ � ������� ������������ �� ������ Thread
public class NewThread1 extends Thread {

    NewThread1() {
        super("���������������� �����");
        System.out.println("�������� �����: "+this);
        start();
    }

    public void run(){
        try{
            for(int i=5; i>0; i--){
                System.out.println("�������� �����: "+i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e){
            System.out.println("�������� ����� �������.");
        }
        System.out.println("�������� ����� ��������");
    }
}

class ExtendThread1{
    public static void main(String args[]){
        new NewThread1();

        try{
            for(int i=5; i>0;i--){
                System.out.println("������� �����: "+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e){
            System.out.println("������� ����� �������.");
        }
        System.out.println("������� ����� ��������.");
    }
}