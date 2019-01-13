//������������, ������������� � ��������� ������� ����������
public class NewThread5 implements Runnable {
    String name;
    Thread t;
    boolean suspendFlag;

    NewThread5(String thname){
        name=thname;
        t= new Thread(this,name);
        System.out.println("����� �����: "+t);
        suspendFlag = false;
        t.start();
    }

    public void run(){
        try{
            for (int i=5;i>0;i--){
                System.out.println(name+": "+i);
                Thread.sleep(200);
                synchronized (this){
                    while (suspendFlag){
                        wait();
                    }
                }
            }
        } catch (InterruptedException e){
            System.out.println(name+" �������");
        }
        System.out.println(name+"��������");
    }

    synchronized void mysuspend(){
        suspendFlag=true;
    }

    synchronized void myresume(){
        suspendFlag=false;
        notify();
    }
}

class SuspendResume{
    public static void main(String args[]){
        NewThread5 ob1 = new NewThread5("����");
        NewThread5 ob2 = new NewThread5("���");

        try{
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("��������������� ������ ����");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("������������� ������ ����");
            ob2.mysuspend();
            System.out.println("��������������� ������ ���");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("������������� ������ ���");
        } catch (InterruptedException e){
            System.out.println("������� ����� �������");
        }

        try{
            System.out.println("�������� ���������� �������");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e){
            System.out.println("������� ����� �������");
        }
        System.out.println("������� ����� ��������");
    }
}