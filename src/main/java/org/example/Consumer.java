package org.example;

import java.util.ArrayList;

public class Consumer{
    ArrayList<String> tab;
    int i;
    public Consumer(ArrayList<String> tab){
        this.tab=tab;
    }
   synchronized   public void consume() {
       synchronized (tab) {
           try {
               while (tab.isEmpty()) {
                   System.out.println("consume wait");
                   tab.wait();
               }

               Thread.sleep(100);
               tab.remove(0);
               System.out.println("consume element");
               tab.notifyAll();

           } catch (InterruptedException e) {
               System.out.println("interrup");
           }

       }
   }


}
