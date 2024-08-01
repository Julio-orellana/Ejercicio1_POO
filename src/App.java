import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // File handling
        File file = new File("data.csv");
        FileWriter fileWriter = new FileWriter("data.csv");
        if (file.createNewFile()) System.out.println("File created: " + file.getName());

        Scanner kb = new Scanner(System.in);

        Location[] locations = {
            new Location("Gradas", 50, 0, 300),
            new Location("Vip", 42, 8, 1500),
            new Location("Vip de pie", 50, 0, 800),
            new Location("General", 50, 0, 500)
        };

        String[] locationsNames = new String[locations.length];
        for (int i =0; i < locations.length; i++){
            locationsNames[i] = locations[i].getName();
        }

        Stadium stadium = new Stadium("Mercedes Benz Stadium",300,locations, 148, 138000);

        boolean exit = false;
        
        while(!exit) {
            Client client1 = new Client("Julio Orellana", "5012-0433", 3, 8000);

            client1.buyTickets(stadium, locations[0]);
            Ticket[] newTickets = client1.getTickets();
            for (int i =0; i<newTickets.length; i++){
            System.out.println(newTickets[i].toString());
            }

            System.out.println("Ganancias totales del estadio " + stadium.getName() + ": Q"+stadium.getTotalRevenue());
        
            fileWriter.write(stadium.generateReport());
            fileWriter.close();
            System.out.println("Informacion guardada en: " + file.getAbsolutePath()); 
            System.out.println(stadium.checkAvailability());

            // Informacion individual
            for (int i =0; i < locations.length; i++){
                System.out.println(String.valueOf(i + 1) + locations[i].getName());
            }  
            System.out.println("Escoge una opcion: ");
            char ans = kb.nextLine().charAt(0);
            switch (ans) {
                case '1' :
                    System.out.println(stadium.checkAvailability(locationsNames[0]));
                    break;
                case '2':
                    System.out.println(stadium.checkAvailability(locationsNames[1]));
                    break;
                case '3':
                    System.out.println(stadium.checkAvailability(locationsNames[2]));
                    break;
                case '4':
                    System.out.println(stadium.checkAvailability(locationsNames[3]));
                    break;
                default:
                    throw new AssertionError();
            }
            // Validar para salir
            System.out.println("Desea Salir? s/n: ");
            ans = kb.nextLine().charAt(0);
            if (ans == 's'){
                exit = true;
            }
        } kb.close();
    }
}
