package a2_OOP.z24_fabrichnuy_metod;


// Вегетарианская пицца в стиле Нью-Йорка
public class NYStyleVeggiePizza extends Pizza {
    public NYStyleVeggiePizza() {
        setName("Вегетарианская пицца в стиле Нью-Йорка");
        setDough("Основа теста тонкая");
        setSauce("Соус Маринара");
        getToppings().add("Тертый сыр Реджано");
    }
}
