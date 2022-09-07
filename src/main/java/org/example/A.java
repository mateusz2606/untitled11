package org.example;

import java.util.ArrayList;

public class A {
    ArrayList<String> tab = new ArrayList<>();


  synchronized   public void produce() {

        try {
            while (tab.size() == 5) {
                System.out.println("producer wait");
                wait();
            }
            Thread.sleep(800);
            tab.add("aaa: ");
            System.out.println("producer element");
            notifyAll();
        } catch (InterruptedException e) {
            System.out.println("bład");
        }
        catch(Exception e){
            System.out.println("jaksi błąd");
        }


    }

 synchronized    public void consume() {
        try {
            while (tab.isEmpty()) {
                System.out.println("consume wait");
                wait();
            }
            Thread.sleep(1000);
            tab.remove(0);
            System.out.println("consume element");
            notifyAll();

        } catch (InterruptedException e) {
            System.out.println("interrup");
        }
        catch(Exception e){
            System.out.println("jaksi błąd");
        }

    }
}
