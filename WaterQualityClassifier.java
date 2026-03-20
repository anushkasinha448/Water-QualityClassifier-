package Water_Quality_Classifier;

public class WaterQualityClassifier {

    // Must return a String so servlet can store it
    public static String classify(double pH, double turbidity, double dissolvedOxygen, double temperature) {
        // Strict unsafe conditions
        if (pH < 6.0 || pH > 9.0) {
            return "Unsafe - Extreme pH";
        } else if (turbidity > 8.0) {
            return "Unsafe - Very high turbidity";
        } else if (dissolvedOxygen < 4.0) {
            return "Unsafe - Critically low oxygen";
        } else if (temperature < 5.0 || temperature > 40.0) {
            return "Unsafe - Extreme temperature";
        }

        // Moderate conditions
        if ((pH < 6.5 || pH > 8.5) || (turbidity > 5.0 && turbidity <= 8.0) || (dissolvedOxygen >= 4.0 && dissolvedOxygen < 5.0)) {
            return "Moderate - Needs attention";
        }

        // Safe conditions
        if ((pH >= 6.5 && pH <= 8.5) && (turbidity <= 5.0) && (dissolvedOxygen >= 5.0) && (temperature >= 10.0 && temperature <= 35.0)) {
            return "Safe";
        }

        return "Acceptable - Within tolerable limits";
    }
}
