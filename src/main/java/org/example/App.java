package org.example;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ArrayList<String> tab=new ArrayList<>();
        Thread t1=new Thread(new TTT(new Producer(tab)));
        Thread t2=new Thread(new XXX(new Consumer(tab)));
        t2.start();
        t1.start();

      //  A ob=new A();

     //  Thread t3=new Thread(new T(ob));
      //  Thread t4=new Thread(new X(ob));
      //  t3.start();
     //   t4.start();




    }
}

class TTT implements Runnable{
    Producer p;
    TTT(Producer p){
        this.p=p;
    }

    @Override
    public void run() {
        while(true){
            try {
                p.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class XXX implements Runnable{
    Consumer c;
    XXX(Consumer c){
        this.c=c;
    }

    @Override
    public void run() {
        while(true){
            c.consume();
        }
    }
}


class T implements Runnable{
    A a;
    T(A a){
        this.a=a;
    }

    @Override
    public void run() {

            while (true) {
                a.produce();
            }

    }

}

class X implements Runnable{
    A a;
    X(A a){
        this.a=a;
    }

    @Override
    public void run() {

            while (true) {
                a.consume();
            }

    }
}


