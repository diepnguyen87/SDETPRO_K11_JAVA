package lab_07;

import java.util.*;

public class AnimalContest {

    public static void main(String[] args) {
        Animal tiger = new Animal("Tiger");
        Animal horse = new Animal("Horse");
        Animal dog = new Animal("Dog");

        Map<String, Integer> map = new HashMap<>();
        map.put(tiger.getName(), tiger.speed());
        map.put(horse.getName(), horse.speed());
        map.put(dog.getName(), dog.speed());
        LinkedHashMap<String, Integer> linkedHashMap = sortMapByDescending(map);
        linkedHashMap.forEach((k, v) -> System.out.println(k + " " + v));

        String winner = linkedHashMap.keySet().toArray()[0].toString();
        Integer maxSpeed = (Integer) linkedHashMap.values().toArray()[0];
        System.out.printf("Winner is: %s, with speed: %d", winner, maxSpeed);
    }

    public static String getKeyMaxSpeed_Way1(Map<String, Integer> map) {
        int speedMax = 0;
        String key = "";

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            int currentSpeed = entry.getValue();
            if (currentSpeed > speedMax) {
                speedMax = currentSpeed;
                key = entry.getKey();
            }
        }
        return key;
    }

    public static LinkedHashMap<String, Integer> sortMapByDescending(Map<String, Integer> map) {
        Map<String, Integer> result = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
        return (LinkedHashMap<String, Integer>) result;
    }
}
