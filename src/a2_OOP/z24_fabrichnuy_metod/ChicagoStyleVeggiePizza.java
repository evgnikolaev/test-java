package a2_OOP.z24_fabrichnuy_metod;


// Вегетарианская пицца в стиле Чикаго
public class ChicagoStyleVeggiePizza extends Pizza {
    public ChicagoStyleVeggiePizza() {
        setName("Вегетарианская пицца в стиле Чикаго");
        setDough("Основа теста толстая");
        setSauce("Соус Томато");
        getToppings().add("Тертый сыр Моцарелла");
    }
}
