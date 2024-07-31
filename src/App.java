public class App {
    public static void main(String[] args) throws Exception {

        Location[] locations = {
            new Location("Gradas", 5, 0, 300),
            new Location("Vip", 5, 0, 1500),
            new Location("Vip de pie", 5, 0, 800),
            new Location("General", 5, 0, 500)
        };

        Stadium stadium = new Stadium("Bernabeu",20,locations, 0, 0);

        //client.buyTickets(stadium, location, 3, 1500);
        //client.buyTickets(stadium, location, oldTickets, 3, 1500);
    }
}
