package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kennel {

    private List<Dog> dogs = new ArrayList<>();

    public List<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        dogs.stream()
                .forEach(Dog::feed);
    }

    public Dog findByName(String name) {
        return dogs.stream()
                .filter(d -> d.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Not Found"));
    }

    public void playWith(String name, int hours) {
        findByName(name).play(hours);
    }

    List<String> getHappyDogNames(int minHappiness) {
        return dogs.stream()
                .filter(dog -> dog.happiness > minHappiness)
                .map(Dog::getName)
                .collect(Collectors.toList());
    }
}
