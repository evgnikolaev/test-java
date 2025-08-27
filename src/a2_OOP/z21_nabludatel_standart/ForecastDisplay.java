package a2_OOP.z21_nabludatel_standart;

// наблюдатель

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ForecastDisplay implements PropertyChangeListener, DisplayElement {

    private Data data;

    @Override
    public void display() {
        System.out.println("Текущие данные ForecastDisplay:");
        System.out.println("Температура: " + data.getTemperature());
        System.out.println("Давление: " + data.getPressure());
        System.out.println("Влажность: " + data.getHumidity());
        System.out.println();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) { //вызывается при изменении данных у субъекта
        Data newData = (Data) evt.getNewValue(); //извлекаем новые данные
        data = newData; //фиксируем
        display(); //выводим на экран
    }
}