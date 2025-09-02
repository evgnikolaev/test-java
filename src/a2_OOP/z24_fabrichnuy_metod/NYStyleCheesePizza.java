package a2_OOP.z24_fabrichnuy_metod;


// Сырная пицца в стиле Нью-Йорка
public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        setName("Сырная пицца в стиле Нью-Йорка");
        setDough("Основа теста тонкая");
        setSauce("Соус Маринара");
        getToppings().add("Тертый сыр Реджано");
    }
}
