package com.company.multithreading.coding_exercises.synchornized;

class Printer{
    String name;

    synchronized void print(String filename){
       for (int i = 0; i < 5; i++) {
           try {
               Thread.sleep(500);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("Printer : " + name + " is Printing File : "+filename);
       }
    }
}
class MicrosoftExcel extends Thread{
    Printer printer;
    public MicrosoftExcel(Printer printer){
        this.printer= printer;
    }
    @Override
    public void run() {
        printer.print("Excel File");
    }
}
class MicrosoftWord extends Thread{
    Printer printer;

    public MicrosoftWord(Printer printer){
        this.printer= printer;
    }

    @Override
    public void run() {

        printer.print("Word Document");
    }
}


public class SynchornizationConcept {
    public static void main(String[] args) {
        Printer printer= new Printer();

        MicrosoftExcel microsoftExcel= new MicrosoftExcel(printer);
        MicrosoftWord microsoftWord= new MicrosoftWord(printer);

        microsoftExcel.start();
        microsoftWord.start();

        System.out.println(printer.name);
    }
}
