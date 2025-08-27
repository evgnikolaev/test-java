package a2_OOP.z21_nabludatel_standart;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WeatherData {
    private Data data;
    private PropertyChangeSupport support; //переменная обеспечивает работу с наблюдателями

    public WeatherData() {
        support = new PropertyChangeSupport(this);
    }

    public void registerListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void measurementsChanged(float temperature, float pressure, float humidity) {
        Data newData = new Data(temperature, pressure, humidity);
        support.firePropertyChange("weatherData:", this.data, newData);
        this.data = newData;
    }
}