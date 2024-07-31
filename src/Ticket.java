import java.time.LocalDate;

public class Ticket {

    private String ticketID;
    private LocalDate date = LocalDate.now();
    private int correlativo;
    private String locationName;
   
    // Constructores
    public Ticket(String ticketID, int correlativo, String locationName){
        this.ticketID = ticketID;
        this.correlativo = correlativo;
        this.locationName = locationName;
    }

    public Ticket(int correlativo, String locationName, Ticket lasTicket){
        this.correlativo = correlativo;
        this.locationName = locationName;
        this.ticketID = generateTicketID(lasTicket);
    }

    public Ticket(int correlativo, String locationName){
        this.correlativo = correlativo;
        this.locationName = locationName;
    }

    public int getCorrelativo(){
        return this.correlativo;
    }

    public String generateTicketID(){
        String newCorrelativo = String.valueOf(this.correlativo);
        this.correlativo++;
        return date + "-" + newCorrelativo;
    }

    public String generateTicketID(Ticket lastTicket){
        String newCorrelativo = String.valueOf(lastTicket.getCorrelativo());
        this.correlativo++;
        return date + "-" + newCorrelativo;
    }

    public String getTicketID(){
        return this.ticketID;
    }

    public String toString(){
        return "TicketID: " + this.ticketID + "\nLocalidad: " + this.locationName;
    }

}
