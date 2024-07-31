import java.io.File;
import java.io.FileWriter;

public class App {
    public static void main(String[] args) throws Exception {

        // File handling
        File file = new File("data.csv");
        FileWriter fileWriter = new FileWriter("data.csv");
        if (file.createNewFile()) System.out.println("File created: " + file.getName());


        Location[] locations = {
            new Location("Gradas", 5, 0, 300),
            new Location("Vip", 5, 0, 1500),
            new Location("Vip de pie", 5, 0, 800),
            new Location("General", 5, 0, 500)
        };

        Stadium stadium = new Stadium("Mercedes Benz Stadium",300,locations, 250, 15000);

        Client client1 = new Client("Julio Orellana", "5012-0433", 3, 8000);

        client1.buyTickets(stadium, locations[1]);
        Ticket[] newTickets = client1.getTickets();
        for (int i =0; i<newTickets.length; i++){
           System.out.println(newTickets[i].toString());
        }

        client1.setTicketsReq(2);
        client1.buyTickets(stadium, locations[3]);
        newTickets = client1.getTickets();
        for (int i =0; i<newTickets.length; i++){
           System.out.println(newTickets[i].toString());
        }

        System.out.println("Presupuesto del Cliente: " + client1.getBudget());
        client1.setBudget(6000);
        client1.setTicketsReq(4);
        client1.buyTickets(stadium, locations[2]);
        newTickets = client1.getTickets();
        for (int i =0; i<newTickets.length; i++){
           System.out.println(newTickets[i].toString());
        }

        System.out.println("Ganancias totales del estadio " + stadium.getName() + ": Q"+stadium.getTotalRevenue());
    
        fileWriter.write(stadium.generateReport());
        fileWriter.close();
        System.out.println("Informacion guardada en: " + file.getAbsolutePath());
    }
}
