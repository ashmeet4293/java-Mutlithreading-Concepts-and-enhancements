package com.company.multithreading.coding_exercises.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/** Here we have 3 tickets in total where 3 person(thread) wants to buy 1 or more ticket
 * Since we acquire a lock on Ticket(Shared Resource) one thread can only access totalTickets variable at once
 * After the ticket is purchased totalTicket No will be deducted and then other thread can access it */

class Ticket{
    int totalTickets=3;
    private static ReentrantLock reentrantLock= new ReentrantLock();

    public void buyTicket(String personName, int noOfTickets){

        reentrantLock.lock();
        if(noOfTickets<= totalTickets){
            totalTickets= totalTickets-noOfTickets;
            System.out.println("Ticket bought "+ noOfTickets + " by  : "+personName+" Remaining :  "+totalTickets);

        }else{
            System.out.println("No available tickets for "+ personName +" to buy "+noOfTickets);
        }
        reentrantLock.unlock();

    }

}

class Person extends Thread{
    String name;
    Ticket ticket;
    int noOfTickets;

    public Person(String name, int noOfTickets, Ticket ticket) {
        this.name = name;
        this.noOfTickets=noOfTickets;
        this.ticket = ticket;
    }

    @Override
    public void run() {
        ticket.buyTicket(name, noOfTickets);
    }
}



public class ReentrantLockWithTicketBuying {
    public static void main(String[] args) {
        Ticket ticket= new Ticket();

        Person person= new Person("ashmeet", 1,  ticket);
        Person person1= new Person("pawan", 2,  ticket);
        Person person2= new Person("tiwari", 4,  ticket);

        person.start();
        person1.start();
        person2.start();



    }
}
