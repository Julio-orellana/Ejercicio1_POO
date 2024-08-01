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

    
    /** 
     * @return int
     */
    public int getCorrelativo(){
        return this.correlativo;
    }

    
    /** 
     * @return String
     */
    public String generateTicketID(){
        String newCorrelativo = String.valueOf(this.correlativo);
        return date + "-" + newCorrelativo;
    }

    
    /** 
     * @param lastTicket
     * @return String
     */
    public String generateTicketID(Ticket lastTicket){
        int newCorrelativo = lastTicket.getCorrelativo() + 1;
        this.correlativo = newCorrelativo;
        return date + "-" + newCorrelativo;
    }

    
    /** 
     * @return String
     */
    public String getTicketID(){
        return this.ticketID;
    }

    
    /** 
     * @return String
     */
    public String toString(){
        return "TicketID: " + this.ticketID + "\nLocalidad: " + this.locationName;
    }

}