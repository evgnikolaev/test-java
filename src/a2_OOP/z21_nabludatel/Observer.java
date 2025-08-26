package a2_OOP.z21_nabludatel;

// observer, для наблюдателей
public interface Observer {
    void update(float temperature, float pressure, float humidity);
}
