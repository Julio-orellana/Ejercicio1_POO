public class Location {

    // Atributos
    private String name;
    private int capacity;
    private int ticketsSold;
    private double price;

    // Constructores
    public Location(String name, int capacity, int tkSold, double price) {
        this.name = name;
        this.capacity = capacity;
        this.ticketsSold = tkSold;
        this.price = price;
    }
    public Location(String name, int capacity, int tkSold) {
        this.name = name;
        this.capacity = capacity;
        this.ticketsSold = tkSold;
    }

    
    /** 
     * @param reqTickets
     * @return boolean
     */
    // Metodos
    
    /** 
     * @param reqTickets
     * @return boolean
     */
    public boolean validateSpace(int reqTickets){
        int currentCapacity = this.capacity - this.ticketsSold;

        return reqTickets <= 6 && reqTickets <= currentCapacity;
    }

    
    /** 
     * @param budget
     * @param reqTickets
     * @return boolean
     */
    public boolean validatePrice(double budget, int reqTickets){

        return budget >= this.price * reqTickets;
    }

    
    /** 
     * @param stadiumTkSold
     * @param reqTickets
     * @param budget
     * @return Ticket[]
     */
    // Overload para validar si antes tenia mas tickets y no perderlos.
    public Ticket[] sellTickets(int stadiumTkSold, int reqTickets, double budget){
        if (!this.checkAvailability(reqTickets, budget)) return null;
        Ticket[] newTickets = new Ticket[reqTickets];
        for (int i = 0; i < reqTickets; i++) {
            newTickets[i] = new Ticket(stadiumTkSold + i + 1, this.name);
            this.capacity--;
        }
        this.ticketsSold += newTickets.length;
        return newTickets;
    }

    
    /** 
     * @param tickets
     * @param budget
     * @return boolean
     */
    public boolean checkAvailability(int tickets, double budget){
        if (this.validateSpace(tickets)){
            if (this.validatePrice(budget, tickets)) return true;
        } return false;
    }

    
    /** 
     * @return String
     */
    public String getName(){
        return this.name;
    }

    
    /** 
     * @return int
     */
    public int getTicketsSold(){
        return this.ticketsSold;
    }

    
    /** 
     * @return int
     */
    public int getCapacity(){
        return this.capacity;
    }

    
    /** 
     * @return double
     */
    public double getPrice(){
        return this.price;
    }

    
    /** 
     * @return String
     */
    public String toString(){
        return "Localidad: " + this.name + " Capacidad: " + this.capacity + " Tickets vendidos: " + this.ticketsSold + " Precio: " + this.price;
    }

}