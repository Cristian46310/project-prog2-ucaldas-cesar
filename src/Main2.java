import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    private final String FILE_PATHPATIENT = "Data/Patient.csv";
    private final String FILE_PATHDIETITIAN = "Data/Dietitian.csv";
    private final String FILE_PATHDIETPLAN = "Data/DietPlans.csv";

    private Patient patient = new Patient();

    private List<Patient> patients = new ArrayList<>();
    private List<Dietitian> dietitians = new ArrayList<>();
    private List<DietPlan> dietPlans = new ArrayList<>();

    private CSVCoder<Patient> patientCoder = null;
    private CSVCoder<Dietitian> dietitianCoder = null;
    private CSVCoder<DietPlan> dietPlanCoder = null;

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
                DietPlan dietPlan = new DietPlan();
                if (Data.length == 4) {
                    // teo no lo hizo bien
                    dietPlan.setPlanId(Integer.parseInt(Data[0]));
                    dietPlan.setDailyCalories(Integer.parseInt(Data[1]));
                    dietPlan.setMacronutrientDistribution(Integer.parseInt(Data[2]));
                    dietPlan.setSpecificRecommendations(Data[3]);
                }
                return dietPlan;
            }

            @Override
            public String[] encode(DietPlan dietPlan) {
                String[] Data = new String[4];
                Data[0] = String.valueOf(dietPlan.getPlanId());
                Data[1] = String.valueOf(dietPlan.getDailyCalories());
                Data[2] = String.valueOf(dietPlan.getMacronutrientDistribution());
                Data[3] = dietPlan.getSpecificRecommendations();
                return Data;
            }

        };
    }

    public void loadInfoPatient(String FILE_PATHPATIENT) {
        try {
            patientCoder.readFromFile(FILE_PATHPATIENT, patients);

            for (Patient pt : patients) {
                System.out.println(pt.getPatientId());
            }
            Console.writeLine();
        } catch (IOException e) {
            Console.writeLine("Hubo un error al cargar o leer los datos");
        }
    }

    public void saveInfoPatient(String FILE_PATHPATIENT) {
        try {
            patientCoder.writeToFile(FILE_PATHPATIENT, patients);
        } catch (IOException e) {
            Console.writeLine("Hubo un error al guardar el paciente");
            ;
        }
    }

    public void loadInfoDietitian(String FILE_PATHDIETITIAN) {

        try {
            dietitianCoder.readFromFile(FILE_PATHDIETITIAN, dietitians);
        } catch (IOException e) {
            Console.writeLine("Hubo un error al cargar o leer los datos");
        }
    }

    public void saveInfoDietitian(String FILE_PATHDIETITIAN) {

        try {
            dietitianCoder.writeToFile(FILE_PATHDIETITIAN, dietitians);
        } catch (IOException e) {
            Console.writeLine("Hubo un error al guardar");
            ;
        }
    }

    public void loadInfoDietPlan(String FILE_PATHDIETPLAN) {
        try {
            dietPlanCoder.readFromFile(FILE_PATHDIETPLAN, dietPlans);
        } catch (IOException e) {
            Console.writeLine("Hubo un error al cargar los planes de dieta");
        }
    }

    public void saveInfoDietPlan(String FILE_PATHDIETPLAN) {
        try {
            dietPlanCoder.writeToFile(FILE_PATHDIETPLAN, dietPlans);
        } catch (IOException e) {
            Console.writeLine("Hubo un error al guardar las dietas");

        }
    }

    public Patient getPatient(int anId) {
        for (Patient patient : patients) {
            if (patient.getPatientId() == anId) {
                return patient;
            }
        }
        return null;
    }

    public void addPatient() {
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
            try {
                saveInfoPatient(FILE_PATHPATIENT);
                Console.writeLine("El paciente ha sido agregado de forma exitosa.");
            } catch (Exception e) {
                Console.writeLine("Error: El paciente no ha podido ser agregado.");
            }
        }
    }

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
    
    public void updatePatients(int id, Patient patient){
        loadInfoPatient(FILE_PATHPATIENT);
        for (int i = 0; i < patients.size(); i++) {
            if(patients.get(i).getPatientId() == id){
                patient.setPatientId(id);
                patients.remove(i);
                patients.add(patient);
                saveInfoPatient(FILE_PATHPATIENT);
                return;
            }
        }

    }

}
