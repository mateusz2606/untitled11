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

