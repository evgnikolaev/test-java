/*


Паттерны проектирования


    Паттерн "Наблюдатель"
    https://stepik.org/lesson/1117569/step/4?unit=1129079

       


*/
package a2_OOP.z21_nabludatel;


public class aMain {
    public static void main(String[] args) {

        //создаем объект WeatherData
        WeatherData station = new WeatherData();

        //Создаем визуальные компоненты
        CurrentConditionsDisplay display1 = new CurrentConditionsDisplay(station);
        ForecastDisplay display3 = new ForecastDisplay(station);

        //имитация получения новых погодных данных
        station.measurementsChanged(20, 760, 80);
    }
}
