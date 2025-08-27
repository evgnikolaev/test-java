/*


Паттерны проектирования


    Паттерн "Наблюдатель"
    https://stepik.org/lesson/1117569/step/4?unit=1129079

        Предыдущая версия z21_nabludatel считается устаревшей.
        Разберем стандартные возможности.



*/
package a2_OOP.z21_nabludatel_standart;


public class aMain {
    public static void main(String[] args) {
        //создаем объект WeatherData
        WeatherData station = new WeatherData();
        //Создаем визуальные компоненты
        CurrentConditionsDisplay display1 = new CurrentConditionsDisplay();
        ForecastDisplay display2 = new ForecastDisplay();
        //добавляем их как слушателей изменений погоды
        station.registerListener(display1);
        station.registerListener(display2);
        //имитация получения новых погодных данных
        station.measurementsChanged(20, 760, 80);
    }
}
