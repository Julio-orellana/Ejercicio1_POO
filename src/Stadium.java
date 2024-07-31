public class Stadium {

    private String name;
    private int totalCapacity;
    private Location[] locations;
    private int ticketsSold;
    private double revenue = 0;

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
        } return false;
    }

    public int getTotalTicketsSold(){
        int tkSold = 0;
        for (int i = 0; i < this.locations.length; i++){
            tkSold += this.locations[i].getTicketsSold();
        } return tkSold;
    }

    public double getTotalRevenue(){
        double totalRevenue = 0;
         for (int i = 0; i < this.locations.length; i++){
            totalRevenue += (this.locations[i].getPrice() * this.locations[i].getTicketsSold());
         }
         this.revenue += totalRevenue;
         return this.revenue;
    }

    public boolean checkStock(){
        int locCapacity = 0;
        for (int i = 0; i < this.locations.length; i++){
            locCapacity += this.locations[i].getCapacity();
        }
        return locCapacity <= this.totalCapacity;
    }

    public String generateReport(){
        String locationsNames = "";
        for (int i = 0; i < this.locations.length; i++){
            locationsNames += this.locations[i].getName();
            if (i != this.locations.length -1) locationsNames += ", ";
        }
        String data = "Estadio: " + this.name + "\nCapacidad total del estadio: " + this.totalCapacity + "\nLocalidades: " + locationsNames + "\nTotal de tickets Vendidos: " + this.ticketsSold + "\nGanancias totales: " + this.revenue;
        return data;
    }

}
