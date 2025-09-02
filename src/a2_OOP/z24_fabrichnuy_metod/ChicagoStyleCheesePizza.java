package a2_OOP.z24_fabrichnuy_metod;


// Сырная пицца в стиле Чикаго
public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        setName("Сырная пицца в стиле Чикаго");
        setDough("Основа теста толстая");
        setSauce("Соус Томато");
        getToppings().add("Тертый сыр Моцарелла");
    }

    //чикагская пицца нарезается не клиньями, а квадратами
    @Override
    public void cut() {
        System.out.println("Чикагская пицца нарезается квадратами");
    }
}