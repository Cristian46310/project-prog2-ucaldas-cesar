public class Menu {
    public static void main(String[] args) {  
        Main2 main=new Main2();// Initialize the main application logic
        int option=0;// Variable to store user menu choice
         // Main menu loop
        do{
            // Display the main menu options
        Console.writeLine("Menu");
        Console.writeLine("1)Gestionar pacientes");
        Console.writeLine("2)Gestion de nutricionistas");
        Console.writeLine("3)Dietas");
        Console.writeLine("4)salir del menu");
         option=Integer.parseInt(Console.readLine());// Read user choice
        // Handle user choice
         switch (option) {
            case 1:
             // Submenu for patient management
                Console.writeLine("Ingrese que quiere hacer");
                Console.writeLine("1)Añadir paciente");
                Console.writeLine("2)Quitar un paciente");
                Console.writeLine("3)Actualizar la informacion de un paciente");
                int option2=Integer.parseInt(Console.readLine());

                if(option2==1){
                main.addPatient();// Add a new patient
                break;
                }else if(option2==2){
                    // Remove an existing patient
                    Console.writeLine("Ingrese la id que quiere eliminar");
                    int id=Integer.parseInt(Console.readLine());
                    main.removePatient(id);
                    break;
                }else if(option2==3){
                    // Update patient information
                    Console.writeLine("Ingrese la id del paciente que quiere actualizar");
                    int id=Integer.parseInt(Console.readLine());
                    Console.writeLine("Ingrese el nombre del paciente que quiere actualizar");
                    String newname=Console.readLine();
                    Console.writeLine("Ingrese la edad del paciente que quiere actualizar");
                    int newAge=Integer.parseInt(Console.readLine());
                    if(newAge<=-1){
                        Console.writeLine("Ingrese una edad valida");
                    }
                    Console.writeLine("Ingrese el peso del paciente que quiere actualizar");
                    int newWeight=Integer.parseInt(Console.readLine());
                    Console.writeLine("Ingrese la altura del paciente que quiere actualizar");
                    int newHeight=Integer.parseInt(Console.readLine());
                    Console.writeLine("Ingrese si el paciente tiene nuevas condiciones pre-existentes");
                    String newPreexistingConditions=Console.readLine();
                    // Create a new patient object with updated details
                    Patient newpatient=new Patient(id,newname,newAge,newWeight,newHeight,newPreexistingConditions);
                    main.updatePatients(id, newpatient);
                    break;
                }else{
                     // Invalid option for patient management submenu
                    Console.writeLine("ingrese una opcion correcta");
                    break;
                }
                case 2:
                // Submenu for dietitian management
                Console.writeLine("Ingrese que quiere hacer");
                Console.writeLine("1)Añadir nutricionista");
                Console.writeLine("2)Quitar un nutricionista");
                Console.writeLine("3)Actualizar la informacion de un nutricionista");
                int option3=Integer.parseInt(Console.readLine());
                if(option3==1){
                     // Add a new dietitian
                    main.addDietitian();
                    break;
                    }else if(option3==2){
                        // Remove an existing dietitian
                        Console.writeLine("Ingrese la id que quiere eliminar");
                        int id=Integer.parseInt(Console.readLine());
                        main.removeDietitian(id);
                        break;
                    }else if(option3==3){
                        // Update dietitian information
                        Console.writeLine("Ingrese la id del nutricionista");
                        int newDietitianId=Integer.parseInt(Console.readLine());
                        Console.writeLine("Ingrese el nombre del nutricionista");
                        String newname=Console.readLine();
                        Console.writeLine("Ingrese la especialidad del nutricionista");
                        String newSpeciality=Console.readLine();
                        // Create a new dietitian object with updated details
                        Dietitian newdietitian=new Dietitian(newDietitianId,newname,newSpeciality);
                        main.updateDietitians(newDietitianId, newdietitian);
                        break;
                        }else{
                            Console.writeLine("Ingrese una opcion valida.");
                            break;
                        }
                case 3:
                 // Submenu for diet management
                Console.writeLine("Bienvenido a la gestion de dietas");
                Console.writeLine("Ingrese si quiere gestionar comidas 1)si, 2)no");
                int option4=Integer.parseInt(Console.readLine());
                if(option4==1){
                    // Add diet plans and meals
                    //Here what I thought was that in a single option the meal plan and the diet plan could be generated with the same ID.
                    Console.writeLine("La idea con esta parte del programa es poner la misma id de comidas y plan de comida");
                    main.addDiets();
                    break;
                }
                case 4:
                 // Exit the program
                Console.writeLine("Gracias por usar el programa, se seguira trabajando para mejor el programa");
                Console.writeLine("SALIENDO DEL PROGRAMA..");   
                break;
        }

        }while(option!=4);// Continue loop until user chooses to exit
    }
}