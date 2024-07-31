import java.time.LocalDate;

public class Ticket {

    private String ticketID;
    private LocalDate date = LocalDate.now();
    private int correlativo = 0;
    private String locationName;
   
    // Constructores
    public Ticket(String ticketID, int correlativo, String locationName){
        this.ticketID = ticketID;
        this.correlativo = correlativo;
        this.locationName = locationName;
    }

    public Ticket(int correlativo, String locationName, Ticket lastTicket){
        this.correlativo = correlativo;
        this.locationName = locationName;
        this.ticketID = generateTicketID(lastTicket);
    }

    public Ticket(int correlativo, String locationName){
        this.correlativo = correlativo;
        this.locationName = locationName;
        this.ticketID = generateTicketID();
    }

    public int getCorrelativo(){
        return this.correlativo;
    }

    public String generateTicketID(){
        String newCorrelativo = String.valueOf(this.correlativo);
        return date + "-" + newCorrelativo;
    }

    public String generateTicketID(Ticket lastTicket){
        int newCorrelativo = lastTicket.getCorrelativo() + 1;
        this.correlativo = newCorrelativo;
        return date + "-" + newCorrelativo;
    }

    public String getTicketID(){
        return this.ticketID;
    }

    public String toString(){
        return "TicketID: " + this.ticketID + "\nLocalidad: " + this.locationName;
    }

}