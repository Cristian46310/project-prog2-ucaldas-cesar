import java.util.ArrayList;
import java.util.List;

public class Patient {
    private int patientId=0;
    private String name=null;
    private int age=0;
    private int weight=0;
    private int height=0;
    private String preexistingConditions=null;

    public Patient(int patientId,String name,int age, int weight, int height, String preexistingConditions){
        this.patientId=patientId;
        this.name=name;
        this.age=age;
        this.weight=weight;
        this.height=height;
        this.preexistingConditions=preexistingConditions;
    }

    public Patient() {
        //TODO Auto-generated constructor stub
    }

    public int getPatientId() {
        return patientId;
    }
    public void setPatientId(int newpatientId) {
        patientId = newpatientId;
    }
    public String getName() {
        return name;
    }
    public void setName(String newname) {
        name = newname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int newage) {
        age = newage;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int newweight) {
        weight = newweight;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int newheight) {
        height = newheight;
    }
    public String getPreexistingConditions() {
        return preexistingConditions;
    }
    public void setPreexistingConditions(String newpreexistingConditions) {
        preexistingConditions = newpreexistingConditions;
    }
    
    // public ArrayList<Patient> getPatients() {
    //     return patients;
    // }

    // public void setPatients(ArrayList<Patient> patients) {
    //     this.patients = patients;
    // }
    // public boolean registerPatient(Patient newPatient){
    //     Patient patient=getPatient(newPatient.getPatientId());
    //     if(patient == null){
    //         patients.add(newPatient);
    //         return true;
    //     }
    //     return false;
        
    // }

    // public Patient getPatient(int anId){
    //     for(Patient patient: patients){
    //         if(patient.getPatientId()==anId){
    //             return patient;
    //         }
    //     }
    //     return null;
    // }

    // public List<Patient> getAllPatients(){
    //     return patients;

    // }

    // public void removePatient(int id){
    //     Patient patientRemove=null;
    //     for(Patient patient: patients){
    //         if(patient.getPatientId()==id){
    //             patientRemove = patient;
    //             break;

    //         }
    //     }
    //     if(patientRemove!=null){
    //         patients.remove(patientRemove);
    //     }

    // }

    // public Patient updatePatients(Patient patientUpdate,int id){
    //     removePatient(id);
    //     patientUpdate.setPatientId(id);
    //     registerPatient(patientUpdate);
        
    //     return patientUpdate;
    // }

}    
 
        

