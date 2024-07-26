# ANALISIS Y DISEÑO:

## Analisis.
### Requisitos funcionales del sistema:
- Entrada de datos. (nombre, teléfono, cantidad de boletos a comprar y presupuesto máximo.)
- Generacion de reportes
- Gestion de datos en un CSV
- Gestion de compra de entrdas con validaciones como presupuestos y disponibilidad
- Generacion de ID de transaccion de Ticket
- Construir objetos.
- Verificar disponibilidad de entradas

### Descripcion de clases y carpetas:

**Carpetas:**
El Proyecto contiene una carpeta en la cual se gestionan todas las clases del sistema.

- `src`: Carpeta con todas las clases del sistema.

**Clases:**
Descripcion de las clases en el sistema y su funcion:

- `Client`: Clase en la que se crean las instancias de compradores y con la que se tendra la informacion del cliente.
- `Ticket`: Clase en la que se gestiona toda la informacion sobre los tickets como la compra y generacion de id.
- `Location`: Clase para gestionar las ditintas localizaciones en el estadio.
- `Stadium`: Clase para gestionar la capacidad, ventas, Localidades y reportes de ventas.
- `App`: Clase donde se tiene el metodo main para instanciar objetos en el sistema.

### Descripcion de Atributos y metodos de las clases:
**Clase App**

*Metodos:*
   -   main: Metodo principal del sistema

**Clase Client**

*Atributos:* 
- name: Nombre del cliente
- phone: Telefono del cliente
- ticketsReq: Cantidad de voletos deseada por el cliente.
- budget: Presupuesto maximo del cliente.

*Metodos:* 
- Client(): Constructor
- getName(): Obtener el nombre del cliente
- getTicketsReq(): Obtener la cantidad de tickets deseados.
- getBudget(): Obtener presupuesto final del cliente.
- buyTickets(): Comprar tickets para el evento.

**Clase Ticket**

*Atributos*
- ticketNum: 
- ticketID: Identificador del ticket
- date: Fecha en mes y dia de la compra
- correlativo: Contador de numero de ticket comprado; ej. 1, 100.

*Metodos*
- Ticket(): Constructor
- getCorrelativo(): Obtener el numero de correlativo.
- generateTicketID(): Generar el identificador del ticket.
- getTicketID: obtener el identificador del ticket.

**Clase Location**

*Atributos*
- name: Nombre de la localidad
- capacity: capacidad de la localidad
- ticketsSold: Tickets vendidos en esa localidad
- price: Precio de la localidad

*Metodos*
- Location(): Constructor
- validateSpace(): Comprobar si aun queda capacidad suficiente en la localidad
- validatePrice(): Validar que el presupuesto sea igual o mayor al de la compra
- sellTickets(): Vender tickets de esa localidad
- checkAvailability(): Comprobar y actualizar la disponibilidad de la localidad.

**Clase Stadium**

*Atributos*
- name: Nombre del estadio
- totalCapacity: Capacidad total del estadio.
- locations: Lista de localidades en el estadio.
- ticketsSold: Cantidad total de boletos vendidos en el estadio,
- revenue: Ganancias totales por las ventas de boletos.

*Metodos*
- Stadium: Constructor
- getLocations: Obtener una localidad del estadio.
- getTotalTicketsSold(): Obtener la cantidad total de tickets vendidos en todas las localidades.
- getTotalRevenue(): Obtener las ganancias totales por ventas.
- checkStock(): Verificar si aun quedan entradas disponibles en alguna de las localidades.
- checkTicketsAvailability(): Verificar disponibilidad de tickets en una localidad especifica.
- generateReport():Generar reporte de ventas, ganancias y disponibilidad.


## Diseño.
### Diagrama de clases UML del proyecto.
Ver el diagrama de clases [UML](https://github.com/Julio-orellana/Ejercicio1_POO/blob/main/docs/UML%20Mundial%20Femenino(1).jpg) del proyecto.

### Patron de diseño.
> Se usara un patron de diseño MVC el cual estara estructurado de la siguiente manera:
- **Modeling:** Clases donde se gestionaran los comportamientos y estados de los objetos.
- **View:** Terminal con la que interactuara el usuario Final del proyecto.
- **Controller:** Clase main en donde se llevara a cabo la instancia de objetos y flujo del sistema.

## Repositorio de Github

Acceder al repositorio de [GITHUB](https://github.com/Julio-orellana/Ejercicio1_POO).
