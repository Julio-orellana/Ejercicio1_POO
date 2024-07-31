public class Client {

    private String name;
    private String phone;
    private int ticketsReq;
    private double budget;
    private Ticket[] tickets;

    public Client(String name, String phone, int ticketsReq, double budget){
        this.name = name;
        this.phone = phone;
        this.ticketsReq = ticketsReq;
        this.budget = budget;
    }

    public Client(String name, String phone, int ticketsReq, double budget, Ticket[] tickets){
        this.name = name;
        this.phone = phone;
        this.ticketsReq = ticketsReq;
        this.budget = budget;
        this.tickets = tickets;
    }

    public Client(String name, String phone, double budget){
    this.name = name;
        this.phone = phone;
        this.ticketsReq = 0;
        this.budget = budget;
    }

    public String getName(){
        return this.name;
    }

    public String getPhone(){
        return this.phone;
    }

    public int getTicketsReq(){
        return this.ticketsReq;
    }

    public void setTicketsReq(int ticketsReq){
        this.ticketsReq = ticketsReq;
    }

    public double getBudget(){
        return this.budget;
    }

    public Ticket[] getTickets(){
        return this.tickets;
    }

    public Ticket[] buyTickets(Stadium stadium, Location location, int reqTickets, double budget){
        Ticket[] newTickets = new Ticket[reqTickets];
        stadium.sellTickets(location, this.tickets, reqTickets, budget);
        return newTickets;
    }


}