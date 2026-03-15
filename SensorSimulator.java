package casestudy;
import java.util.Random;

public class SensorSimulator {
    private Random random = new Random();

    public double getPH() {
        return 6.0 + random.nextDouble() * 3.0; // range 6.0–9.0
    }

    public double getTurbidity() {
        return random.nextDouble() * 10.0; // NTU
    }

    public double getDissolvedOxygen() {
        return 4.0 + random.nextDouble() * 5.0; // mg/L
    }

    public double getTemperature() {
        return 15.0 + random.nextDouble() * 15.0; // °C
    }
}