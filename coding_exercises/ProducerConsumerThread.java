package com.company.multithreading.coding_exercises;

/**Here is the sample of producer-consumer example with Printer as a shared object
 * Where prodcuer produces the printing file and Consumer retrieves the files and print it
 * Once the producer thread produces the file it notifies the consumer (waiting) thread
 * After processing the File by consumer it notifies the producer (waiting) to produce the files and
 * this process contiunes. */
class Printer{
    String printerName;
    String filename;
    boolean isHavingFilename=false;

    public Printer(String printerName) {
        this.printerName = printerName;
    }

    synchronized  public void produceFile(String filename){
        while (isHavingFilename){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("File is generated and ready to send to printer : "+filename);
        this.filename=filename;
        isHavingFilename=true;
        this.notify(); /*Notifying the consumer that producer finishes producing the file*/

    }

    synchronized public void consumeAndPrintFile(){
        while (!isHavingFilename){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Printer Got the file : "+filename);
        System.out.println(filename+" : ____________ Printing DONE :) ____________ \n");
        isHavingFilename=false;
        this.notify(); /*Notifying the Producer that consumer finishes producing the file*/
    }
}

class Producer extends Thread{
    Printer printer;

    public Producer(Printer printer){
        this.printer=printer;
    }

    @Override
    public void run() {
        printer.produceFile("documents.docx");
        printer.produceFile("pdfFile.pdf");
        printer.produceFile("excel.xls");
        printer.produceFile("image.jpeg");

    }
}
class Consumer extends Thread{
    Printer printer;

    public Consumer(Printer printer){
        this.printer=printer;
    }

    @Override
    public void run() {
        while(true){
            printer.consumeAndPrintFile();
        }

    }
}

public class ProducerConsumerThread {
    public static void main(String[] args) {

        Printer printer= new Printer("HP-101");

        Producer producer= new Producer(printer);
        Consumer consumer= new Consumer(printer);
        producer.start();
        consumer.start();

    }
}
