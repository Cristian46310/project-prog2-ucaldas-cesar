import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    // Constants for file paths
    private final String FILE_PATHPATIENT = "Data/Patient.csv";
    private final String FILE_PATHDIETITIAN = "Data/Dietitian.csv";
    private final String FILE_PATHDIETPLAN = "Data/DietPlans.csv";
    private final String FILE_PATHMEAL = "Data/Meals.csv";
    // Lists to hold data for patients, dietitians, diet plans, and meals
    private List<Patient> patients = new ArrayList<>();
    private List<Dietitian> dietitians = new ArrayList<>();
    private List<DietPlan> dietPlans = new ArrayList<>();
    private List<Meal> meals = new ArrayList<>();
    // CSV Coders for encoding and decoding CSV data
    private CSVCoder<Patient> patientCoder;
    private CSVCoder<Dietitian> dietitianCoder;
    private CSVCoder<DietPlan> dietPlanCoder;
    private CSVCoder<Meal> mealCoder;

    // Constructor initializing the CSV coders
    public Main2() {

        patientCoder = new CSVCoder<Patient>(';') {

            public Patient decode(String[] Data) {
                Patient patient;
                if (Data.length == 6) {
                    patient = new Patient(Integer.parseInt(Data[0]), Data[1], Integer.parseInt(Data[2]),
                            Integer.parseInt(Data[3]),
                            Integer.parseInt(Data[4]), Data[5]);
                    return patient;
                }
                return null;
            }

            public String[] encode(Patient patient) {
                String[] Data = new String[6];
                Data[0] = String.valueOf(patient.getPatientId());
                Data[1] = patient.getName();
                Data[2] = String.valueOf(patient.getAge());
                Data[3] = String.valueOf(patient.getWeight());
                Data[4] = String.valueOf(patient.getHeight());
                Data[5] = patient.getPreexistingConditions();
                return Data;
            }
        };

        dietitianCoder = new CSVCoder<Dietitian>(';') {

            @Override
            public Dietitian decode(String[] Data) {
                Dietitian dietitian;
                if (Data.length == 3) {
                    dietitian = new Dietitian(Integer.parseInt(Data[0]), Data[1], Data[2]);
                    return dietitian;
                }
                return null;
            }

            @Override
            public String[] encode(Dietitian dietitian) {
                String[] Data = new String[3];
                Data[0] = String.valueOf(dietitian.getDietitianId());
                Data[1] = dietitian.getName();
                Data[2] = dietitian.getSpeciality();

                return Data;
            }

        };
        dietPlanCoder = new CSVCoder<DietPlan>(';') {

            @Override
            public DietPlan decode(String[] Data) {
                DietPlan dietPlan;
                if (Data.length == 6) {
                    dietPlan = new DietPlan();
                    dietPlan.setPlanId(Integer.parseInt(Data[0]));
                    dietPlan.setDailyCalories(Integer.parseInt(Data[1]));
                    dietPlan.setMacronutrientDistribution(Data[2]);
                    dietPlan.setSpecificRecommendations(Data[3]);
                    dietPlan.setDietitian(Integer.parseInt(Data[4]));
                    dietPlan.setPatient(Integer.parseInt(Data[5]));
                    return dietPlan;

                }
                return null;
            }

            @Override
            public String[] encode(DietPlan dietPlan) {
                String[] Data = new String[6];
                Data[0] = String.valueOf(dietPlan.getPlanId());
                Data[1] = String.valueOf(dietPlan.getDailyCalories());
                Data[2] = String.valueOf(dietPlan.getMacronutrientDistribution());
                Data[3] = dietPlan.getSpecificRecommendations();
                Data[4] = String.valueOf(dietPlan.getDietitian());
                Data[5] = String.valueOf(dietPlan.getPatient());
                return Data;
            }

        };

        mealCoder = new CSVCoder<Meal>(';') {

            @Override
            public Meal decode(String[] Data) {
                Meal meal;
                if (Data.length == 5) {
                    meal = new Meal(Integer.parseInt(Data[0]), Data[1], Data[2], Integer.parseInt(Data[3]), Data[4]);
                    return meal;
                }
                return null;
            }

            @Override
            public String[] encode(Meal meal) {
                String[] Data = new String[5];
                Data[0] = String.valueOf(meal.getId());
                Data[1] = meal.getName();
                Data[2] = meal.getMacronutrients();
                Data[3] = String.valueOf(meal.getCalories());
                Data[4] = meal.getTimeOfDay();
                return Data;
            }
        };
    }

    // Method to load patient information from CSV file
    public void loadInfoPatient(String FILE_PATHPATIENT) {
        try {
            patientCoder.readFromFile(FILE_PATHPATIENT, patients);
        } catch (IOException e) {
            Console.writeLine("Hubo un error al cargar o leer los datos");
        }
    }

    // Method to save patient information to CSV file
    public void saveInfoPatient(String FILE_PATHPATIENT) {
        try {
            patientCoder.writeToFile(FILE_PATHPATIENT, patients);
        } catch (IOException e) {
            Console.writeLine("Hubo un error al guardar el paciente");
            ;
        }
    }

    // Method to load dietitian information from CSV file
    public void loadInfoDietitian(String FILE_PATHDIETITIAN) {
        try {
            dietitianCoder.readFromFile(FILE_PATHDIETITIAN, dietitians);
        } catch (IOException e) {
            Console.writeLine("Hubo un error al cargar o leer los datos");
        }
    }

    // Method to save dietitian information to CSV file
    public void saveInfoDietitian(String FILE_PATHDIETITIAN) {
        try {
            dietitianCoder.writeToFile(FILE_PATHDIETITIAN, dietitians);
        } catch (IOException e) {
            Console.writeLine("Hubo un error al guardar");
        }
    }

    // Method to load diet plan information from CSV file
    public void loadInfoDietPlan(String FILE_PATHDIETPLAN) {
        try {
            dietPlanCoder.readFromFile(FILE_PATHDIETPLAN, dietPlans);
        } catch (IOException e) {
            Console.writeLine("Hubo un error al cargar los planes de dieta");
        }
    }

    // Method to save diet plan information to CSV file
    public void saveInfoDietPlan(String FILE_PATHDIETPLAN) {
        try {
            dietPlanCoder.writeToFile(FILE_PATHDIETPLAN, dietPlans);
        } catch (IOException e) {
            Console.writeLine("Hubo un error al guardar las dietas");

        }
    }

    // Method to get a patient by their ID
    public Patient getPatient(int anId) {
        for (Patient patient : patients) {
            if (patient.getPatientId() == anId) {
                return patient;
            }
        }
        return null;
    }

    // Method to add a new patient
    public void addPatient() {
        patients= new ArrayList<>();
        loadInfoPatient(FILE_PATHPATIENT);

        Console.writeLine("Ingrese un Id que quiera añadir");
        int patientId = Integer.parseInt(Console.readLine());
        if (getPatient(patientId) != null) {
            Console.writeLine("El Id que quiere ingresar ya esta siendo usado por otro paciente.");
            return;
        } else {
            Console.writeLine("Ingrese el nombre del paciente");
            String patientName = Console.readLine();

            Console.writeLine("Ingrese la edad del paciente");
            int patientAge = Integer.parseInt(Console.readLine());

            Console.writeLine("Ingrese el peso del paciente");
            int patientWeight = Integer.parseInt(Console.readLine());

            Console.writeLine("Ingrese la altura del paciente");
            int patientHeight = Integer.parseInt(Console.readLine());

            Console.writeLine("Ingrese si el paciente ya tenia condiciones pre-existentes");
            String patientPreexistingConditions = Console.readLine();

            Patient newpPatient = new Patient(patientId, patientName, patientAge, patientWeight, patientHeight,
                    patientPreexistingConditions);
            patients.add(newpPatient);
            // Save updated patient list to file
            try {
                saveInfoPatient(FILE_PATHPATIENT);
                Console.writeLine("El paciente ha sido agregado de forma exitosa.");
            } catch (Exception e) {
                Console.writeLine("Error: El paciente no ha podido ser agregado.");
            }
        }
    }

    // Method to remove a patient by their ID
    public void removePatient(int id) {
        loadInfoPatient(FILE_PATHPATIENT);
        for (Patient patient : patients) {
            if (patient.getPatientId() == id) {
                patients.remove(patient);
                saveInfoPatient(FILE_PATHPATIENT);
                Console.writeLine("El paciente ha sido eliminado");
                return;
            }
        }
        Console.writeLine("no existe paciente");
    }

    // Method to update a patient by their ID
    public void updatePatients(int id, Patient patient) {
        loadInfoPatient(FILE_PATHPATIENT);
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getPatientId() == id) {
                patient.setPatientId(id);
                patients.remove(i);
                patients.add(patient);// Use set instead of remove/add
                try {
                    saveInfoPatient(FILE_PATHPATIENT);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // Method to get a dietitian by their ID
    public Dietitian getDietitian(int anId) {
        for (Dietitian dietitian : dietitians) {
            if (dietitian.getDietitianId() == anId) {
                return dietitian;
            }
        }
        return null;
    }

    // Method to add a new dietitian
    public void addDietitian() {
        dietitians=new ArrayList<>();
        loadInfoDietitian(FILE_PATHDIETITIAN);
        Console.writeLine("Ingrese la Id del nutricionista que quiere registrar.");
        int dietitianId = Integer.parseInt(Console.readLine());
        if (getDietitian(dietitianId) != null) {
            Console.writeLine("El id ya esta siendo usado por otro nutricionista.");
            return;
        } else {
            // Gather dietitian details
            Console.writeLine("Ingrese el nombre del nutricionista.");
            String dietitianName = Console.readLine();

            Console.writeLine("Ingrese la especialidad que tiene el nutriconista.");
            String dietitianSpeciality = Console.readLine();
            // Create new dietitian and add to list
            Dietitian newDietitian = new Dietitian(dietitianId, dietitianName, dietitianSpeciality);
            dietitians.add(newDietitian);
            try {
                // Save updated dietitian list to file
                saveInfoDietitian(FILE_PATHDIETITIAN);
                Console.writeLine("El nutricionista ha sido registrado correctamente.");
            } catch (Exception e) {
                Console.writeLine("El nutricionista no ha podido ser registrado");
            }
        }
    }

    // Method to remove a dietitian by their ID
    public void removeDietitian(int id) {
        loadInfoDietitian(FILE_PATHDIETITIAN);
        for (Dietitian dietitian : dietitians) {
            if (dietitian.getDietitianId() == id) {
                dietitians.remove(dietitian);
                saveInfoDietitian(FILE_PATHDIETITIAN);
                Console.writeLine("El nutricionista ha sido eliminado con exito del sistema");
                return;
            }
        }
        Console.writeLine("El nutricionista no existe");
    }

    // Method to update a dietitian by their ID
    public void updateDietitians(int id, Dietitian dietitian) {
        loadInfoDietitian(FILE_PATHDIETITIAN);
        for (int i = 0; i < dietitians.size(); i++) {
            if (dietitians.get(i).getDietitianId() == id) {
                dietitian.setDietitianId(id);
                dietitians.remove(i);
                dietitians.add(dietitian);
                saveInfoDietitian(FILE_PATHDIETITIAN);
                return;
            }
        }
    }

    // Method to load meal information from CSV file
    public void loadInfoMeal(String FILE_PATHMEAL) {
        try {
            mealCoder.readFromFile(FILE_PATHMEAL, meals);
        } catch (IOException e) {
            Console.writeLine("Hubo un error al cargar o leer los archisvos.");
        }
    }

    // Method to save meal information from CSV file
    public void saveInfoMeals(String FILE_PATHMEAL) {
        try {
            mealCoder.writeToFile(FILE_PATHMEAL, meals);
        } catch (IOException e) {
            Console.writeLine("Hubo un error al guardar los archivos");
        }

    }

    public Meal getMeal(int anId) {
        for (Meal meal : meals) {
            if (meal.getId() == anId) {
                return meal;
            }
        }
        return null;
    }

    // Method to add new meals
    public void registerMeals() {
        meals = new ArrayList<>(); // starts a new arraylist
        loadInfoMeal(FILE_PATHMEAL);// load information of Csv
        Read read = new Read(); // Create a new read, for show the foods
        int id = 0;
        Console.writeLine("Agregar comidas");
        Console.writeLine("Ingrese una id");
        id = Integer.parseInt(Console.readLine());
        if (getMeal(id) != null) {
            Console.writeLine("El id ya esta siendo usado por otra comida");
            return;
        } else {
            Console.writeLine("Agregar comidas");
            Console.writeLine("Cuantas comidas quiere agregar para este día:");
            int foods = Integer.parseInt(Console.readLine());
            for (int i = 1; i <= foods; i++) {// to do the process the number of times the user wants to do it
                String timeOfDay = null;
                while (timeOfDay == null) {
                    // obtain information about the meals, if it is the afternoon or morning, id,
                    // name, calories, and macronutrients
                    Console.writeLine(
                            "Ingrese el tiempo en el que se hara la comida: 1)Desayuno, 2) almuerzo, 3)comida, 4)M. mañana, 5)Algo.");
                    int opcion = Integer.parseInt(Console.readLine());
                    if (opcion == 1) {
                        timeOfDay = "Desayuno";
                        Console.writeLine("Ingrese un nombre para esta comida.");
                        String newname = Console.readLine();
                        Console.writeLine("Ingrese cuantas calorias tiene esta comida.");
                        int newCalories = Integer.parseInt(Console.readLine());
                        Console.writeLine("Ahora escriba lo que va a agregar en la comida");
                        Console.writeLine("Quesos y derivados:");
                        read.showCheesesandderivatives();
                        String cheese = Console.readLine();
                        Console.writeLine("Harinas:");
                        read.showFlours();
                        String flour = Console.readLine();
                        Console.writeLine("Frutas");
                        read.showFruits();
                        String fruit = Console.readLine();
                        Console.writeLine("Grasas");
                        read.showFats();
                        String fat = Console.readLine();

                        String newMacronutrients = (cheese + "," + flour + "," + fruit + "," + fat);
                        Meal newBreakfast = new Meal(id, newname, newMacronutrients, newCalories, timeOfDay);
                        meals.add(newBreakfast);
                        break;
                    } else if (opcion == 2) {
                        timeOfDay = "Almuerzo";
                        Console.writeLine("Ingrese un nombre para esta comida.");
                        String newname = Console.readLine();
                        Console.writeLine("Ingrese cuantas calorias tiene esta comida.");
                        int newCalories = Integer.parseInt(Console.readLine());
                        Console.writeLine("Ahora escriba lo que va a agregar en la comida");
                        Console.writeLine("Carnes:");
                        read.showMeats();
                        String meat = Console.readLine();
                        Console.writeLine("legumbres:");
                        read.showLegum();
                        String legum = Console.readLine();
                        Console.writeLine("flour");
                        read.showFlours();
                        String flour = Console.readLine();
                        Console.writeLine("verduras");
                        read.showVegetables();
                        String vegetable = Console.readLine();
                        Console.writeLine("grasas");
                        read.showFats();
                        String fat = Console.readLine();

                        String newMacronutrients = (meat + "," + legum + "," + flour + "," + vegetable + "," + fat);
                        Meal newLunch = new Meal(id, newname, newMacronutrients, newCalories, timeOfDay);
                        meals.add(newLunch);
                        break;
                    } else if (opcion == 3) {
                        timeOfDay = "Comida";
                        Console.writeLine("Ingrese un nombre para esta comida.");
                        String newname = Console.readLine();
                        Console.writeLine("Ingrese cuantas calorias tiene esta comida.");
                        int newCalories = Integer.parseInt(Console.readLine());
                        Console.writeLine("Ahora escriba lo que va a agregar en la comida");
                        Console.writeLine("Quesos y derivados:");
                        read.showCheesesandderivatives();
                        String cheese = Console.readLine();
                        Console.writeLine("Harinas:");
                        read.showFlours();
                        String flour = Console.readLine();
                        String newMacronutrients = (cheese + "," + flour);
                        Meal newDinner = new Meal(id, newname, newMacronutrients, newCalories, timeOfDay);
                        meals.add(newDinner);
                        break;
                    } else if (opcion == 4) {
                        timeOfDay = "m.merienda";
                        Console.writeLine("Ingrese un nombre para esta comida.");
                        String newname = Console.readLine();
                        Console.writeLine("Ingrese cuantas calorias tiene esta comida.");
                        int newCalories = Integer.parseInt(Console.readLine());
                        Console.writeLine("Ahora escriba lo que va a agregar en la comida");
                        Console.writeLine("Frutas:");
                        read.showFruits();
                        String fruits = Console.readLine();
                        Console.writeLine("Nueces:");
                        read.showNutsanSeeds();
                        String nuts = Console.readLine();
                        String newMacronutrients = (fruits + "," + nuts);
                        Meal newSnack = new Meal(id, newname, newMacronutrients, newCalories, timeOfDay);
                        meals.add(newSnack);

                    } else if (opcion == 5) {
                        timeOfDay = "Algo";
                        Console.writeLine("Ingrese un nombre para esta comida.");
                        String newname = Console.readLine();
                        Console.writeLine("Ingrese cuantas calorias tiene esta comida.");
                        int newCalories = Integer.parseInt(Console.readLine());
                        Console.writeLine("Ahora escriba lo que va a agregar en la comida");
                        Console.writeLine("Frutas:");
                        read.showFruits();
                        String fruits = Console.readLine();
                        Console.writeLine("semillas:");
                        read.showNutsanSeeds();
                        String nuts = Console.readLine();
                        String newMacronutrients = (fruits + "," + nuts);
                        Meal newSnack = new Meal(id, newname, newMacronutrients, newCalories, timeOfDay);
                        meals.add(newSnack);
                    } else {
                        Console.writeLine("Ingrese una comida correcta por favor.");
                    }
                }
                // save the info in csv
                try {
                    saveInfoMeals(FILE_PATHMEAL);
                } catch (Exception e) {
                    Console.writeLine("Ha habido un error al guardar la comida");
                    e.printStackTrace();
                }
            }
        }
    }

    // get and compare the ids
    public DietPlan getDietPlan(int anId) {
        for (DietPlan dietPlan : dietPlans) {
            if (dietPlan.getPlanId() == anId) {
                return dietPlan;
            }
        }
        return null;
    }

    // Method for add diets and meals
    public void addDiets() {
        dietPlans = new ArrayList<>();
        loadInfoDietPlan(FILE_PATHDIETPLAN);
        Console.writeLine("Agregar planes de dieta");
        int planId = 0;
        // create a new id and check if it is repeated or not
        while (planId == 0) {
            Console.writeLine("Ingrese un id del plan de alimentacion que quiere añadir.");
            planId = Integer.parseInt(Console.readLine());
            if (getDietPlan(planId) != null) {
                Console.writeLine(
                        "El id del plan de comida ya esta siendo utilizado por otro, por favor ingresar otro id.");
            }
        }
        // Collect the information to create the diet plan
        Console.writeLine("Ingrese las calorias diarias del plan de comida");
        int newDailyCalories = Integer.parseInt(Console.readLine());

        Console.writeLine("Ingrese la distribucion de los nutrientes");
        System.out.println("Ejemplo: 70% proteina,10% harina, 20% grasas");
        String newMacronutrients = Console.readLine();

        Console.writeLine("Ingrese que recomendaciones que le da al paciente");
        String newSpecificRecommendations = Console.readLine();

        Console.writeLine("Ingrese el Id del paciente");
        int patientId = Integer.parseInt(Console.readLine());
        Console.writeLine("Ingrese el Id del nutricionista");
        int dietitianid = Integer.parseInt(Console.readLine());
        Console.writeLine("Desea crear una comida nueva? (Si/No)");
        String option = Console.readLine();
        option.toLowerCase();
        if (option.equals("si")) {
            registerMeals();// use the method registermeal for create a new meal and dietplan
        } else {
            Console.writeLine("Ok, muchas gracias");
        }
        DietPlan dietPla = new DietPlan(planId, newDailyCalories, newMacronutrients, newSpecificRecommendations,
                dietitianid, patientId);
        dietPlans.add(dietPla);
        // save the info in the csv
        try {
            saveInfoDietPlan(FILE_PATHDIETPLAN);
            Console.writeLine("El plan de dieta ha sido guardado exitosamente.");
        } catch (Exception e) {
            Console.writeLine("Ha habido un error al guardar el dietplan");
            e.printStackTrace();

        }

    }
}
