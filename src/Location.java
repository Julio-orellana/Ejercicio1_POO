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
     
    // Tipo de retorno del metodo modificado.
    public Ticket[] sellTickets(int reqTickets, double budget){
        Ticket[] newTickets = new Ticket[reqTickets];
        if (this.checkAvailability(reqTickets, budget)){
            for (int i = 0; i < newTickets.length; i++){
                newTickets[i] = new Ticket(i, this.name);
                this.capacity--;
                this.ticketsSold++;
            }
        } return newTickets;
    }

    // Overload para validar si antes tenia mas tickets y no perderlos.
    public Ticket[] sellTickets(Ticket[] oldTickets, int reqTickets, double budget){
        Ticket[] newTickets = new Ticket[reqTickets + oldTickets.length];
        if (this.checkAvailability(reqTickets, budget)){
            for (int i = 0; i < newTickets.length; i++){
                for (int j = 0; j < oldTickets.length; j++){
                    newTickets[i] = oldTickets[j];
                    this.capacity--;
                    this.ticketsSold++;
                }
                newTickets[i] = new Ticket(newTickets[i-1].getCorrelativo(), this.name);
                this.capacity--;
                this.ticketsSold++;
            }
        } return newTickets;
    }

    public boolean checkAvailability(int tickets, double budget){
        if (this.validateSpace(tickets)){
            if (this.validatePrice(budget, tickets)) return true;
        } return false;
    }

    public String getName(){
        return this.name;
    }
}