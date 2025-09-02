package a2_OOP.z24_fabrichnuy_metod;


// Пицца Пепперони в стиле Чикаго
public class ChicagoStylePepperonyPizza extends Pizza {
    public ChicagoStylePepperonyPizza() {
        setName("Пицца Пепперони в стиле Чикаго");
        setDough("Основа теста толстая");
        setSauce("Соус Томато");
        getToppings().add("Тертый сыр Моцарелла");
    }
}
