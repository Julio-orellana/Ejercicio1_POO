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
    }

    public String getName(){
        return this.name;
    }

    public String getPhone(){
        return this.phone;
    }

    public int getTicketsReq(){
        return this.reqTickets;
    }

    public void setTicketsReq(int reqTickets){
        this.reqTickets = reqTickets;
    }

    public double getBudget(){
        return this.budget;
    }

    public void setBudget(double budget){
        this.budget = budget;
    }

    public Ticket[] getTickets(){
        return this.tickets;
    }

    public void buyTickets(Stadium stadium, Location location){
        Ticket[] newTickets = new Ticket[this.reqTickets];
        stadium.sellTickets(location, this.tickets, this.reqTickets, this.budget);
        this.tickets = newTickets;
    }
}
