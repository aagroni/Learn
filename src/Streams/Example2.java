package Streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Example2 {
    static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Ali", 20),
                new Person("Omer", 1),
                new Person("Agron", 31),
                new Person("Valdet", 28),
                new Person("Orhan",48),
                new Person("Arber",40)
        );

        //Keep people older than 18, get only their names and return them as a List<String>
        List<String> olderThanEighteenNames = people.stream()
                .filter(p-> p.getAge()>18)
                .map(Person::getName)
                .toList();
        System.out.println(olderThanEighteenNames);

        //increase age by 1 & return NEW list of Person
        List<Person> peopleOneYearOlder = people.stream()
                .map(p-> new Person(p.getName(), p.getAge()+1)).toList();

        peopleOneYearOlder.forEach(System.out::println);
        System.out.println("________________________");
        people.forEach(System.out::println);

        //Find Oldest Person, return Optional<Person>
        //Optional<Person> oldestPerson = people.stream().sorted(Comparator.comparing(Person::getAge).reversed()).findFirst();
        Optional<Person> oldestPerson = people.stream().max(Comparator.comparing(Person::getAge));
        Person oldestPerson1 = oldestPerson.orElseThrow();
        System.out.println("Oldest Person: " + oldestPerson1);
    }
}



