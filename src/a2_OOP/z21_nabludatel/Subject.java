package a2_OOP.z21_nabludatel;

// субъект
public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
