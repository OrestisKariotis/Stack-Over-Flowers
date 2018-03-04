package gr.ntua.ece.softeng.kidspiration;

import java.util.Date;

public class OldEventView {
     String name;
     Date date;
     int ticket_cost;
     int initial_ticketsNumber;
     int sold_ticketsNumber;
     double profit;

    public OldEventView(String name, Date date, int ticket_cost, int initial_ticketsNumber, int sold_ticketsNumber, double profit) {
        this.name = name;
        this.date = date;
        this.ticket_cost = ticket_cost;
        this.initial_ticketsNumber = initial_ticketsNumber;
        this.sold_ticketsNumber = sold_ticketsNumber;
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTicket_cost() {
        return ticket_cost;
    }

    public void setTicket_cost(int ticket_cost) {
        this.ticket_cost = ticket_cost;
    }

    public int getInitial_ticketsNumber() {
        return initial_ticketsNumber;
    }

    public void setInitial_ticketsNumber(int initial_ticketsNumber) {
        this.initial_ticketsNumber = initial_ticketsNumber;
    }

    public int getSold_ticketsNumber() {
        return sold_ticketsNumber;
    }

    public void setSold_ticketsNumber(int sold_ticketsNumber) {
        this.sold_ticketsNumber = sold_ticketsNumber;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
