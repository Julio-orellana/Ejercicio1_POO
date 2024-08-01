public class Client {

    private String name;
    private String phone;
    private int reqTickets;
    private double budget;
    private Ticket[] tickets;

    public Client(String name, String phone, int reqTickets, double budget){
        this.name = name;
        this.phone = phone;
        this.reqTickets = reqTickets;
        this.budget = budget;
        this.tickets = new Ticket[reqTickets];
    }

    public Client(String name, String phone, int reqTickets, double budget, Ticket[] tickets){
        this.name = name;
        this.phone = phone;
        this.reqTickets = reqTickets;
        this.budget = budget;
        this.tickets = tickets;
    }

    public Client(String name, String phone, double budget){
        this.name = name;
        this.phone = phone;
        this.reqTickets = 0;
        this.budget = budget;
        this.tickets = new Ticket[0];
    }

    
    /** 
     * @return String
     */
    public String getName(){
        return this.name;
    }

    
    /** 
     * @return String
     */
    public String getPhone(){
        return this.phone;
    }

    
    /** 
     * @return int
     */
    public int getTicketsReq(){
        return this.reqTickets;
    }

    
    /** 
     * @param reqTickets
     */
    public void setTicketsReq(int reqTickets){
        this.reqTickets = reqTickets;
        this.tickets = new Ticket[reqTickets];
    }

    
    /** 
     * @return double
     */
    public double getBudget(){
        return this.budget;
    }

    
    /** 
     * @param budget
     */
    public void setBudget(double budget){
        this.budget = budget;
    }

    
    /** 
     * @return Ticket[]
     */
    public Ticket[] getTickets(){
        return this.tickets;
    }

    
    /** 
     * @param stadium
     * @param location
     */
    public void buyTickets(Stadium stadium, Location location) {
        double moneySpent = 0;
        Ticket lastTicket = this.tickets[this.tickets.length -1];
        Ticket[] newTickets = stadium.sellTickets(location, lastTicket, this.reqTickets, this.budget);
        if (newTickets != null) {
            this.tickets = newTickets;
            for (int i =0; i<newTickets.length; i++){
                moneySpent += location.getPrice();
            }
            this.budget -= moneySpent;
        }
    }

    
    /** 
     * @return String
     */
    public String toString(){
        return "Nombre: " + this.name + "\nTelefono: " + this.phone + "\nTickets solicitados: " + this.reqTickets + "\nPresupuesto: Q" + this.budget;
    }
}