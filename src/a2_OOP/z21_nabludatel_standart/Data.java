package a2_OOP.z21_nabludatel_standart;

public class Data {
    private float temperature;
    private float pressure;
    private float humidity;

    public Data(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public Data() {
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }
}


