# ANÁLISIS Y DISEÑO:

## Análisis.
### Requisitos funcionales del sistema:
- Entrada de datos (nombre, teléfono, cantidad de boletos a comprar y presupuesto máximo).
- Generación de reportes.
- Gestión de datos en un CSV.
- Gestión de compra de entradas con validaciones como presupuestos y disponibilidad.
- Generación de ID de transacción de Ticket.
- Construcción de objetos.
- Verificación de disponibilidad de entradas.

### Descripción de clases y carpetas:

**Carpetas:**
El Proyecto contiene una carpeta en la cual se gestionan todas las clases del sistema.

- `src`: Carpeta con todas las clases del sistema.

**Clases:**
Descripción de las clases en el sistema y su función:

- `Client`: Clase en la que se crean las instancias de compradores y se gestiona la información del cliente.
- `Ticket`: Clase en la que se gestiona toda la información sobre los tickets, como la compra y generación de ID.
- `Location`: Clase para gestionar las distintas localizaciones en el estadio.
- `Stadium`: Clase para gestionar la capacidad, ventas, localidades y reportes de ventas.
- `App`: Clase donde se tiene el método main para instanciar objetos en el sistema.

### Descripción de Atributos y métodos de las clases:
**Clase App**

*Métodos:*
   - main: Método principal del sistema.

**Clase Client**

*Atributos:* 
- name: Nombre del cliente.
- phone: Teléfono del cliente.
- ticketsReq: Cantidad de boletos deseada por el cliente.
- budget: Presupuesto máximo del cliente.
- tickets: Arreglo de tickets comprados por el cliente.

*Métodos:* 
- Client(String name, String phone, int reqTickets, double budget): Constructor.
- Client(String name, String phone, int reqTickets, double budget, Ticket[] tickets): Constructor.
- Client(String name, String phone, double budget): Constructor.
- getName(): Obtener el nombre del cliente.
- getPhone(): Obtener el teléfono del cliente.
- getTicketsReq(): Obtener la cantidad de tickets deseados.
- setTicketsReq(int reqTickets): Establecer la cantidad de tickets deseados.
- getBudget(): Obtener presupuesto final del cliente.
- setBudget(double budget): Establecer el presupuesto del cliente.
- getTickets(): Obtener los tickets comprados por el cliente.
- buyTickets(Stadium stadium, Location location): Comprar tickets para el evento.

**Clase Ticket**

*Atributos:*
- ticketID: Identificador del ticket.
- date: Fecha de la compra.
- correlativo: Contador de número de ticket comprado.
- locationName: Nombre de la localidad.

*Métodos:*
- Ticket(String ticketID, int correlativo, String locationName): Constructor.
- Ticket(int correlativo, String locationName, Ticket lastTicket): Constructor.
- Ticket(int correlativo, String locationName): Constructor.
- getCorrelativo(): Obtener el número de correlativo.
- generateTicketID(Ticket lastTicket): Generar el identificador del ticket.
- generateTicketID(): Generar el identificador del ticket.
- getTicketID(): Obtener el identificador del ticket.

**Clase Location**

*Atributos:*
- name: Nombre de la localidad.
- capacity: Capacidad de la localidad.
- ticketsSold: Tickets vendidos en esa localidad.
- price: Precio de la localidad.

*Métodos:*
- Location(String name, int capacity, int tkSold, double price): Constructor.
- validateSpace(int reqTickets): Comprobar si aún queda capacidad suficiente en la localidad.
- validatePrice(double budget, int reqTickets): Validar que el presupuesto sea igual o mayor al de la compra.
- sellTickets(int stadiumTkSold, int reqTickets, double budget): Vender tickets de esa localidad.
- checkAvailability(int tickets, double budget): Comprobar y actualizar la disponibilidad de la localidad.
- getName(): Obtener el nombre de la localidad.
- getTicketsSold(): Obtener la cantidad de tickets vendidos en la localidad.
- getCapacity(): Obtener la capacidad de la localidad.
- getPrice(): Obtener el precio de la localidad.

**Clase Stadium**

*Atributos:*
- name: Nombre del estadio.
- totalCapacity: Capacidad total del estadio.
- locations: Lista de localidades en el estadio.
- ticketsSold: Cantidad total de boletos vendidos en el estadio.
- revenue: Ganancias totales por las ventas de boletos.

*Métodos:*
- Stadium(String name, int totalCapacity, Location[] locations, int tkSold): Constructor.
- Stadium(String name, int totalCapacity, Location[] locations, int tkSold, double revenue): Constructor.
- getLocation(String locationName): Obtener una localidad del estadio.
- getTotalTicketsSold(): Obtener la cantidad total de tickets vendidos en todas las localidades.
- getTotalRevenue(): Obtener las ganancias totales por ventas.
- checkStock(): Verificar si aún quedan entradas disponibles en alguna de las localidades.
- checkAvailability(): Verificar disponibilidad de tickets en todas las localidades.
- checkAvailability(String locationName): Verificar disponibilidad de tickets en una localidad específica.
- generateReport(): Generar reporte de ventas, ganancias y disponibilidad.
- getName(): Obtener el nombre del estadio.
- getLocationsNames(): Obtener los nombres de todas las localidades.

## Diseño.
### Diagrama de clases UML del proyecto.
Diagrama de clases [UML](https://github.com/Julio-orellana/Ejercicio1_POO/blob/main/docs/UML%20Mundial%20Femenino(1).jpg) del proyecto.
![UML del proyecto](https://github.com/user-attachments/assets/ffdc4fce-947e-41f3-b0ef-16affc5f19b5) 

### Patrón de diseño.
> Se usará un patrón de diseño MVC el cual estará estructurado de la siguiente manera:
- **Modeling:** Clases donde se gestionarán los comportamientos y estados de los objetos.
- **View:** Terminal con la que interactuará el usuario final del proyecto.
- **Controller:** Clase main en donde se llevará a cabo la instancia de objetos y flujo del sistema.

## Repositorio de Github

Acceder al repositorio de [GITHUB](https://github.com/Julio-orellana/Ejercicio1_POO).