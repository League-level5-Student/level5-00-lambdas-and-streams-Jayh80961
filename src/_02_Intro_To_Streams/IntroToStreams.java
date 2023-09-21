package _02_Intro_To_Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import java.util.*;
import java.util.stream.*;

public class IntroToStreams {
    
    public static void main(String[] args) {
        class Car {
            String make;
            int mileage;
            
            Car(String make, int mileage){
                this.make = make;
                this.mileage = mileage;
            }
        }
        
        /*
         * Create streams from different collections
         */
        String[] strArr = {"one", "two", "three", "four"};
        Stream<String> arrStream = Arrays.stream(strArr);

        List<Integer> intList = Arrays.asList(1, -2, 3);
        Stream<Integer> listStream = intList.stream();

        List<Car> carList = new LinkedList<>();
        carList.add(new Car("Honda", 200000));
        carList.add(new Car("Ford", 60000));
        carList.add(new Car("Ferrari", 10000));
        Stream<Car> carListStream = carList.stream();

        // Stream of 100 random double values from 50 to 200
        DoubleStream dblStream = new Random().doubles(100, 50, 200);
        
        /*
         * Apply operation to all elements
         */
        System.out.print("Array stream forEach(): ");
        Arrays.stream(strArr).forEach((word) -> System.out.print(word + " "));
        
        System.out.print("\nList stream forEach(): ");
        intList.forEach((i) -> System.out.print(i + " "));
        
        /*
         * Sort elements
         */
        System.out.println();
        System.out.print("\nArray stream sorted(): ");
        Arrays.stream(strArr).sorted().forEach((word) -> System.out.print(word + " "));
        
        System.out.print("\nList stream sorted(): ");
        intList.stream().sorted().forEach((i) -> System.out.print(i + " " ));
        
        /*
         * Sort based on specific criteria
         */
        System.out.println();
        System.out.println("\nList sorted alphabetically by car name: ");
        carList.stream().sorted((car1, car2) -> car1.make.compareTo(car2.make))
                         .forEach((car) -> System.out.print(car.make + " "));
        
        System.out.println();
        System.out.println("\nList sorted from highest mileage to lowest: ");
        carList.stream().sorted((car1, car2) -> car2.mileage - car1.mileage)
                         .forEach((car) -> System.out.println(car.make + " " + car.mileage));
        
        /*
         * Convert Array to List
         */
        List<Double> dblObjList = new Random()
                                    .doubles(5, 0, 10)
                                    .boxed()
                                    .collect(Collectors.toList());
        System.out.println("\nStream of double values to List of Double objects:");
        System.out.println(dblObjList);
        
        /*
         * Convert List to array
         */
        Integer[] integerArr = intList.toArray(new Integer[0]);
        System.out.println("\nStream of Integer objects to an array of Integer objects");
        System.out.println(Arrays.toString(integerArr));
        
        /*
         * Filter elements based on condition
         */
        long count = Arrays.stream(strArr)
                           .filter((word) -> word.contains("e"))
                           .count();
        System.out.println("\nNumber of words that contain the letter 'e': " + count);
        
        /*
         * Combine elements into a single value
         */
        int totalMileage = intList.stream().reduce(0, Integer::sum);
        System.out.println("\nSum of all ints in list: " + totalMileage);
        
        /*
         * Scale or convert a stream of elements to another
         */
        List<String> models = carList.stream()
                                      .map((car) -> car.make)
                                      .collect(Collectors.toList());
        System.out.println("\nMap list of cars to list of strings: " + models);
        
        /*
         * Stream method chaining: filter, map, and reduce
         */
        int totalCharacters = Arrays.stream(strArr)
                                    .filter((word) -> word.length() > 3)
                                    .map(String::length)
                                    .reduce(0, Integer::sum);
        
        System.out.println("\nThe total number of characters for words"
                + " longer than 3 characters is: " + totalCharacters);
        
        /*
         * Sort and remove duplicates in an array
         */
        double[] data = {1.1, 1.1, 2.9, 55.2, -12.0, 2.9, 98.6, 77.7, 55.2, -459.5, 1.1};
        double[] sorted = Arrays.stream(data)
                                .distinct()
                                .sorted()
                                .toArray();
                                
        System.out.println("\nSort array and remove duplicates:");
        System.out.println(Arrays.toString(sorted));
        
        System.out.println();
        System.out.println("Min val: " + Arrays.stream(sorted).min().getAsDouble());
        System.out.println("Max val: " + Arrays.stream(sorted).max().getAsDouble());
        System.out.println("Sum ...: " + Arrays.stream(sorted).sum());
        System.out.println("Average: " + Arrays.stream(sorted).average().getAsDouble());
        System.out.println("Summary: " + Arrays.stream(sorted).summaryStatistics());
    }
}

