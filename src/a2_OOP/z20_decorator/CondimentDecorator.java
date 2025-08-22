package a2_OOP.z20_decorator;

//Абстрактный класс для дополнений

public abstract class CondimentDecorator extends Beverage {
    //декораторы должны заново реализовать получение описания
    @Override
    public abstract String getDescription();
}