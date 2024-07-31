public class Stadium {

    private String name;
    private int totalCapacity;
    private Location[] locations;
    private int ticketsSold;
    private double revenue;

    public Stadium(String name, int totalCapacity, Location[] locations, int tkSold, double revenue){
        this.name = name;
        this.totalCapacity = totalCapacity;
        this.locations = locations;
        this.ticketsSold = tkSold;
        this.revenue = revenue;
    }

    public Stadium(String name, int totalCapacity, Location[] locations, int tkSold){
        this.name = name;
        this.totalCapacity = totalCapacity;
        this.locations = locations;
        this.ticketsSold = tkSold;
    }

    public Location getLocation(String locationName){
        for (int i = 0; i < this.locations.length; i++){
            if (this.locations[i].getName() == locationName) return this.locations[i];
            continue;
        }
    }

    public int getTotalTicketsSold(){
        int tkSold = 0;
        for (int i = 0; i < this.locations.length; i++){
            tkSold += this.locations[i].getTicketsSold();
        } return tkSold;
    }

    public double getTotalRevenue(){
        double totalRevenue;
         
    }

}
