public class DietPlan {
    private int planId=0;
    private int dailyCalories=0;
    private int macronutrientDistribution=0;
    private String specificRecommendations=null;
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
    public int getMacronutrientDistribution() {
        return macronutrientDistribution;
    }
    public void setMacronutrientDistribution(int macronutrientDistribution) {
        this.macronutrientDistribution = macronutrientDistribution;
    }
    public String getSpecificRecommendations() {
        return specificRecommendations;
    }
    public void setSpecificRecommendations(String specificRecommendations) {
        this.specificRecommendations = specificRecommendations;
    }
        
}
