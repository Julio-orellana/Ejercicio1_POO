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

    // Metodos
    public boolean validateSpace(int reqTickets){
        int currentCapacity = this.capacity - this.ticketsSold;

        return reqTickets <= 6 && reqTickets <= currentCapacity;
    }

    public boolean validatePrice(double budget, int reqTickets){

        return budget >= this.price * reqTickets;
    }

    // Overload para validar si antes tenia mas tickets y no perderlos.
    public Ticket[] sellTickets(int stadiumTkSold, int reqTickets, double budget){
        if (!this.checkAvailability(reqTickets, budget)) return null;
        Ticket[] newTickets = new Ticket[reqTickets];
        for (int i = 0; i < reqTickets; i++) {
            newTickets[i] = new Ticket(stadiumTkSold + i + 1, this.name);
        }
        this.ticketsSold += newTickets.length;
        ticketsSold += reqTickets;
        return newTickets;
    }

    public boolean checkAvailability(int tickets, double budget){
        if (this.validateSpace(tickets)){
            if (this.validatePrice(budget, tickets)) return true;
        } return false;
    }

    public String getName(){
        return this.name;
    }

    public int getTicketsSold(){
        return this.ticketsSold;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public double getPrice(){
        return this.price;
    }

    public String toString(){
        return "Localidad: " + this.name + " Capacidad: " + this.capacity + " Tickets vendidos: " + this.ticketsSold + " Precio: " + this.price;
    }

}