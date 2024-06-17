import java.util.ArrayList;
import java.util.List;

/**
 * The DietPlan class represents a diet plan with its nutritional and specific recommendations.
 */
public class DietPlan {
    // Attributes of the DietPlan class
    private int planId=0;
    private int dailyCalories=0;
    private String macronutrientDistribution=null;
    private String specificRecommendations=null;
    private int dietitian;
    private int patient;

    //Constructor for creating a new DietPlan with specified details.
    public DietPlan(int planId, int dailyCalories, String macronutrientDistribution, String specificRecommendations,
            int dietitian, int patient) {
        this.planId = planId;
        this.dailyCalories = dailyCalories;
        this.macronutrientDistribution = macronutrientDistribution;
        this.specificRecommendations = specificRecommendations;
        this.dietitian = dietitian;
        this.patient = patient;
    }
    public DietPlan(){      
    }

    //Here are the setters and getters to use in the main methods

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getDailyCalories() {
        return dailyCalories;
    }

    public void setDailyCalories(int dailyCalories) {
        this.dailyCalories = dailyCalories;
    }

    public String getMacronutrientDistribution() {
        return macronutrientDistribution;
    }

    public void setMacronutrientDistribution(String macronutrientDistribution) {
        this.macronutrientDistribution = macronutrientDistribution;
    }

    public String getSpecificRecommendations() {
        return specificRecommendations;
    }

    public void setSpecificRecommendations(String specificRecommendations) {
        this.specificRecommendations = specificRecommendations;
    }
   public int getDietitian() {
        return dietitian;
    }
    public void setDietitian(int dietitian) {
        this.dietitian = dietitian;
    }

    public int getPatient() {
        return patient;
    }

    public void setPatient(int patient) {
        this.patient = patient;
    } 
    
      
    @Override
    public String toString() {
        return "DietPlan [planId=" + planId + ", dailyCalories=" + dailyCalories + ", macronutrientDistribution="
                + macronutrientDistribution + ", specificRecommendations=" + specificRecommendations + ", dietitian="
                + dietitian + ", patient=" + patient + "]";
    }
 }

    
    







