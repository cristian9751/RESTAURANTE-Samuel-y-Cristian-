![](Aspose.Words.17b8a59e-5bd4-4d4b-9981-07071f9d24cf.001.jpeg)

**APP Restaurante**

21/03/2023

**─**

Integrantes:

Samuel Stefano Zamora Sanchez Cristian Popica Onciu

Clase:

1º DAM

1![](Aspose.Words.17b8a59e-5bd4-4d4b-9981-07071f9d24cf.002.png)

**Visión general**

La idea principal del programa es poder desarrollar un programa con el uso de clases, métodos, arrays, etc…, que nos permitan poder almacenar, ingresar y modifcar los datos que maneje el programa, ya sean el nombre de los usuarios o el número de meseros de un establecimiento.

Con la implementación de comentarios buscaremos facilitar la inteligibilidad de nuestro código y si es posible a posteriori mejorar el código.

En este caso **se implementara una aplicación que permita la gestión de un restaurante.** Permitira al usuario manejar los menus, platos, empleados e inventaio del restaurante. 

El usuario podra:

1. Encontrar los datos que desee
1. Ingresar sus propios datos
1. Modificar o eliminar datos 

**Requisitos funcionales**

La aplicación implementa las siguientes funcionalidades:

1\.Un **menu** desde el cual el usuario podra indicarle al programa que es lo que desea llevar a cabo. Dicho menu incluye las opciones de gestionar menus, platos, ingredientes y empleados del restaurante.

2. Añadir o eliminar **empleados** asi como modificar su puesto de trabajo
2. Tener control sobre el inventario del restaurante indicando que  **productos** estan en inventario y las unidades de cada producto
2. Crear y modificar recetas de **platos** que utilizan los ingredientes que el restaurante tiene en el inventario.

5- Crear y modificar los **menus** que ofrece el restaurante a sus clientes

**Especificaciones**

1\. El programa dispondrá de 6 clases:

- Clase restaurante
- Clase menu\_restaurante
- Clase ingredientes
- Clase platos
- Clase empleado
- Clase menu\_opciones

**Clase restaurante:** La clase restaurante es la clase principal del programa, desde el cual se ejecutara el mismo. Contendra cuatro vectores los cuales almacenaran objetos de distinta clase.

Uno almacenara objetos de la clase menu\_restaurante, otro de la clase ingredientes , otro de la clase platos y otro de la clase empleado

**Clase platos:** Define los platos que se sirven en el restaurante. Teniene como parametros el nombre, el precio y los ingredientes que contiene asi como su cantidad

**Clase ingredientes:** Define los ingredientes que sirve el restaurante en sus platos. Tiene como parametros el nombre, el tipo de producto y la cantidad que queda de dicho producto en el inventario.

**Clase menu\_restaurante:** Define los distintos menus que ofrece el restaurante con sus respectivos platos. Tiene como parametros el numero maximo de platos que pueden tener todos los menus del restaurante, el nombre del menu y un vector con los platos que se sirven en el menu.

**Clase platos:** Define los distintos platos que se preparan en el restaurante. Tiene como parametros el nombre del plato, el precio de una ración de dicho plato , por ultimo, los ingredientes que contiene el plato y su cantidad.

**Clase menu\_opciones:** Define el menu principal que se le mostrara al usuario por pantalla y recoge la opcion que seleccione el usuario. Tambien contendra metodos necesarios para la  recogida de  datos introducidos por el usuario.
