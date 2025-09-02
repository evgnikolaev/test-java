package a2_OOP.z24_fabrichnuy_metod;


// Пицца Пепперони в стиле Нью-Йорка
public class NYStylePepperonyPizza extends Pizza {
    public NYStylePepperonyPizza() {
        setName("Пицца Пепперони в стиле Нью-Йорка");
        setDough("Основа теста тонкая");
        setSauce("Соус Маринара");
        getToppings().add("Тертый сыр Реджано");
    }
}
