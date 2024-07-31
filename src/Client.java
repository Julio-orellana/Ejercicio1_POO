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
        this.tickets = new Ticket[reqTickets];
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

    public String toString(){
        return "Nombre: " + this.name + "\nTelefono: " + this.phone + "\nTickets solicitados: " + this.reqTickets + "\nPresupuesto: Q" + this.budget;
    }
}