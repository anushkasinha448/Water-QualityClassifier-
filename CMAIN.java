package casestudy;
import java.text.DecimalFormat;
public class CMAIN {
	        public static void main(String[] args) {
	            SensorSimulator sensor = new SensorSimulator();
	            DatabaseManager db = new DatabaseManager();

	            // Formatter for 2 decimal places
	            DecimalFormat df = new DecimalFormat("#.00");

	            for (int i = 0; i < 10; i++) { // simulate 10 readings
	                double pH = sensor.getPH();
	                double turbidity = sensor.getTurbidity();
	                double oxygen = sensor.getDissolvedOxygen();
	                double temp = sensor.getTemperature();

	                String status = WaterQualityClassifier.classify(pH, turbidity, oxygen, temp);
	                System.out.printf("Reading %d -> pH: %s, Turbidity: %s, Oxygen: %s, Temp: %s => %s%n",
	                        i+1, df.format(pH), df.format(turbidity), df.format(oxygen), df.format(temp), status);

	                db.saveResult(Double.parseDouble(df.format(pH)),
	                        Double.parseDouble(df.format(turbidity)),
	                        Double.parseDouble(df.format(oxygen)),
	                        Double.parseDouble(df.format(temp)),
	                        status);
	            }
	        }
	   
}
