package org.example;

import java.io.IOError;
import java.util.ArrayList;

public class Producer{
    ArrayList<String> tab;
    int i;
    public Producer(ArrayList<String> tab){
        this.tab=tab;
    }
   synchronized public void produce() throws InterruptedException {
        synchronized (tab) {

            while (tab.size() == 5) {
                System.out.println("producer wait");
                tab.wait();
            }
            Thread.sleep(1000);
            tab.add("aaa: " + i);
            System.out.println("producer element");

           tab.notifyAll();

        }
    }



}
