import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class App {
    
    /** 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // File handling
        File file = new File("data.csv");
        FileWriter fileWriter = new FileWriter("data.csv");
        if (file.createNewFile()) System.out.println("File created: " + file.getName());

        Scanner kb = new Scanner(System.in);

        Location[] locations = {
            new Location("Gradas", 50, 0, 250),
            new Location("Vip", 42, 8, 1720),
            new Location("Vip de pie", 50, 0, 575),
            new Location("General", 50, 0, 425)
        };

        // Create an array with the location names that would be used in the app
        String[] locationsNames = new String[locations.length];
        for (int i = 0; i < locations.length; i++){
            locationsNames[i] = locations[i].getName();
        }

        // Create the stadium
        Stadium stadium = new Stadium("Mercedes Benz Stadium",300,locations, 148, 138000);

        // flag to know if the user wants to stay in the app or quit
        boolean exit = false;
        char ans;
        Client[] clients = null; // Initialize clients to null

        while(!exit) {

            System.out.println("\nMENU MUNDIAL FEMENINO: ");
            System.out.println("1. Crear Clientes \n2. Comprar Tickets. \n3. Generar reporte del estadio \n4. Obtener la disponibilidad de todas las localidades. \n5. Obtener informacion de disponibilidad de una localidad especifica. \nq. Salir");
            ans = kb.nextLine().charAt(0);
            switch (ans){
                case '1':
                    System.out.println("Ingresa la cantidad de clientes a crear:");
                    int clientCantity = kb.nextInt();
                    kb.nextLine(); // Clean the buffer of the scanner class to the nextLine
                    clients = new Client[clientCantity];

                    for (int i = 0; i < clients.length; i++){
                        System.out.println("Ingresa el nombre para el cliente " + (i+1) + ":");
                        String clientName = kb.nextLine();
                        System.out.println("Ingresa un numero de telefono para el cliente "+ (i+1) + ":");
                        String clientPhone = kb.nextLine();
                        System.out.println("Ingresa el presupuesto del cliente " + (i+1) + ":");
                        double budget = kb.nextDouble();
                        kb.nextLine(); // Clean the buffer of the scanner class to the nextLine
                        clients[i] = new Client(clientName, clientPhone,0, budget);
                        System.out.println("Cliente " + (i+1) + " creado exitosamente.");
                    } 
                    break;

                case '2':
                    if (clients == null || clients.length == 0) {
                        System.out.println("No hay clientes creados. Por favor crea clientes primero.");
                        break;
                    }

                    System.out.println("Ingresa el numero del cliente que desea comprar tickets: ");
                    for (int i = 0; i < clients.length; i++) {
                        System.out.println((i + 1) + ". Cliente: " +  clients[i].getName());
                    } 
                    int clientIndex = kb.nextInt() - 1;
                    kb.nextLine(); // Clean the buffer of the scanner class to the nextLine

                    if (clientIndex < 0 || clientIndex >= clients.length) {
                        System.out.println("Cliente no válido.");
                        break;
                    }

                    System.out.println("Ingresa la cantidad de tickets a comprar: ");
                    int clientReqTickets = kb.nextInt();
                    kb.nextLine(); // Clean the buffer of the scanner class to the nextLine

                    clients[clientIndex].setTicketsReq(clientReqTickets);
                    
                    System.out.println("Localidades disponibles para compra: ");
                    for (int i = 0; i < locations.length; i++){
                        System.out.println((i + 1) + ". " + locations[i].getName());
                    }  
                    System.out.println("Escoge la localidad a comprar: ");
                    int locChoice = kb.nextInt();
                    kb.nextLine(); // Clean the buffer of the scanner class to the nextLine

                    if (locChoice < 1 || locChoice > locations.length) {
                        System.out.println("Opción no válida.");
                        break;
                    }
                    clients[clientIndex].buyTickets(stadium, locations[locChoice -1]); // You may need to select a location here
                    System.out.println("Informacion de tus tickets:\n");
                    Ticket[] newTickets = clients[clientIndex].getTickets();
                    for (Ticket newTicket : newTickets) {
                        System.out.println(newTicket.toString());
                    } System.out.println();
                    break;

                case '3':
                    // Generar reporte
                    fileWriter.write(stadium.generateReport());
                    fileWriter.close();
                    System.out.println("Archivo con el reporte guardado en: " + file.getAbsolutePath()); 
                    break;

                case '4':
                    // Informacion total
                    System.out.println("\nInformacion de disponibilidad de todas las localidades: ");
                    System.out.println(stadium.checkAvailability());
                    System.out.println();
                    break;

                case '5':
                    // Informacion individual
                    System.out.println("Localidades dispobiles: ");
                    for (int i = 0; i < locations.length; i++){
                        System.out.println((i + 1) + ". " + locations[i].getName());
                    }  
                    System.out.println("Escoge una localidad: ");
                    locChoice = kb.nextInt();
                    kb.nextLine(); // Clean the buffer of the scanner class to the nextLine

                    if (locChoice < 1 || locChoice > locations.length) {
                        System.out.println("Opción no válida.");
                        break;
                    }
                    System.out.println(stadium.checkAvailability(locationsNames[locChoice - 1]));
                    break;

                case 'q':
                    System.out.println("\nSALIENDO...");
                    exit = true;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
        kb.close();
    }
}