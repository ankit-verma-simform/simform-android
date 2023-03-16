package com.example.androiddemoproject.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionsExample {
    static class Planet {
        final String name;

        Planet(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Planet{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<String> planetNameList = new ArrayList<>();
        planetNameList.add("Sun");
        planetNameList.add("Mercury");
        planetNameList.add("Venus");
        planetNameList.add("Earth");
        planetNameList.add("Mars");
        planetNameList.add("Jupiter");
        planetNameList.add("Saturn");
        planetNameList.add("Uranus");
        planetNameList.add("Neptune");
        planetNameList.add("Pluto");

        System.out.print("Planets original list: ");
        System.out.println(planetNameList);

        // sun is a star, need to remove from list
        planetNameList.remove(0); // as sun is at zeroth index

        // oops, pluto is also not a planet! we need to remove it!
        planetNameList.remove("Pluto");

        // printing planetNameList after modification
        System.out.println("Planets modified list: " + planetNameList);

        // filtering planetNameList
        List<String> planetsStartingWithM = planetNameList
                .stream()
                .filter(planet -> planet.startsWith("M"))
                .collect(Collectors.toList());
        System.out.println("Planets that start with `M`: " + planetsStartingWithM);

        // mapping planet names to create Planet objects
        List<Planet> planets = planetNameList
                .stream()
                .map(planetName -> new Planet(planetName))
                .collect(Collectors.toList());
        System.out.println(planets);

        planetNameList.set(0, "Unknown Planet");
        System.out.println(planetNameList);

        // map
        Map<Integer, Planet> planetMap = new HashMap<>();
        for (int i = 0; i < planetNameList.size(); i++) {
            planetMap.put(i, planets.get(i));
        }
        System.out.println(planetMap);

        // sorting list of planets based on alphabetical order
        // one way to do it -> planets.sort((planet1, planet2) -> planet1.name.compareTo(planet2.name));
        planets.sort(Comparator.comparing(planet -> planet.name)); // shorter/suggested way to do it
        System.out.println("Sorted planets: " + planets);

        // reverse sorting list
        List<Integer> numbers = Arrays.asList(2, 3, 5, 1, 0);
        numbers.sort((n1, n2) -> n2 - n1);
        System.out.println(numbers);
    }
}
