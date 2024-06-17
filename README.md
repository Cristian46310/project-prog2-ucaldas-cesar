Gestión de Pacientes y Nutricionistas
Este programa está diseñado para gestionar pacientes y nutricionistas, así como dietas asociadas. Proporciona un menú interactivo para realizar varias operaciones como añadir, eliminar y actualizar información.

Clases y Métodos
Menu
La clase Menu es la clase principal que contiene el método main, responsable de presentar el menú y gestionar la lógica de la interfaz de usuario.

Métodos
main(String[] args): Es el punto de entrada del programa. Presenta un menú al usuario y permite la gestión de pacientes, nutricionistas y dietas a través de submenús.
Main2
La clase Main2 contiene los métodos para gestionar la lógica de negocio del programa. A continuación, se describen sus métodos:

Métodos
addPatient(): Añade un nuevo paciente al sistema.
removePatient(int id): Elimina un paciente existente del sistema utilizando su ID.
updatePatients(int id, Patient newPatient): Actualiza la información de un paciente existente. Recibe el ID del paciente a actualizar y un objeto Patient con los nuevos datos.
addDietitian(): Añade un nuevo nutricionista al sistema.
removeDietitian(int id): Elimina un nutricionista existente del sistema utilizando su ID.
updateDietitians(int id, Dietitian newDietitian): Actualiza la información de un nutricionista existente. Recibe el ID del nutricionista a actualizar y un objeto Dietitian con los nuevos datos.
addDiets(): Añade nuevas dietas y planes de comida al sistema.
Clases Auxiliares
Patient
La clase Patient representa a un paciente y contiene información relevante sobre el mismo.

Atributos
int id: Identificador único del paciente.
String name: Nombre del paciente.
int age: Edad del paciente.
int weight: Peso del paciente.
int height: Altura del paciente.
String preexistingConditions: Condiciones preexistentes del paciente.
Métodos
Patient(int id, String name, int age, int weight, int height, String preexistingConditions): Constructor para inicializar un objeto Patient con los detalles proporcionados.
Dietitian
La clase Dietitian representa a un nutricionista y contiene información relevante sobre el mismo.

Atributos
int id: Identificador único del nutricionista.
String name: Nombre del nutricionista.
String speciality: Especialidad del nutricionista.
Métodos
Dietitian(int id, String name, String speciality): Constructor para inicializar un objeto Dietitian con los detalles proporcionados.
Estructura del Menú
El menú principal ofrece las siguientes opciones:

Gestionar pacientes:
Añadir paciente
Quitar un paciente
Actualizar la información de un paciente
Gestión de nutricionistas:
Añadir nutricionista
Quitar un nutricionista
Actualizar la información de un nutricionista
Dietas:
Gestión de dietas y comidas
Salir del menú