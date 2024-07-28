package de.khudhur.projects.ticket;

abstract class Ticket{
    String name;
    public String getInfo(){
        return name;
    }
}

class KurzStrecke extends Ticket{
    @Override
    public String getInfo() {
        return "KurzStrecke";
    }
}
class SemesterTicket extends Ticket{
    @Override
    public String getInfo() {
        return "SemesterTicket";
    }
}

public class Factory {
    private Factory(){}

    public static Ticket getTicket(String wunsch, int cent){
        if (wunsch.matches("Kurz.*") && cent >= 240){
            return new KurzStrecke();
        }
        if (wunsch.matches("Sem.*|Stud.*") && cent >= 5600){
            return new SemesterTicket();
        }
        return null;
    }

    public static void main(String[] args) {
        Ticket ticketStudi = Factory.getTicket("Sem Ticket", 5600);
        assert ticketStudi != null;
        System.err.println(ticketStudi.getInfo());
    }
}
