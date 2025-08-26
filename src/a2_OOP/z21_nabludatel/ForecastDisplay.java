package a2_OOP.z21_nabludatel;

// наблюдатель, все аналогично CurrentConditionsDisplay, только метод display отличается

public class ForecastDisplay implements Observer, DisplayElement {
    private float temperature;
    private float pressure;
    private float humidity;
    private Subject weatherData;

    //в конструкторе регистрация у субъекта в качестве наблюдателя

    public ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData; //запоминаем субъекта
        weatherData.registerObserver(this); //регистрируемся у него для получения оповещений
    }

    @Override
    public void display() {
        System.out.println("Текущие данные ForecastDisplay:");
        System.out.println("Температура: " + temperature);
        System.out.println("Давление: " + pressure);
        System.out.println("Влажность: " + humidity);
    }

    @Override
    public void update(float temperature, float pressure, float humidity) {
        //обновляем данные в полях
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        //вызываем их отрисовку
        display();
    }
}
