package Streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Example4 {
    static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Ali", 20),
                new Person("Omer", 1),
                new Person("Agron", 31),
                new Person("Valdet", 28),
                new Person("Orhan",48),
                new Person("Arber",40),
                new Person("Fetah",40)
        );

        //Group people by age, store only names
        Map<Integer, List<String>> peopleGroupedByAge = people.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
        System.out.println(peopleGroupedByAge);

        //count how many people are older than 25
        long numberOfPeopleOver25 = people.stream().filter(p->p.getAge()>25).count();

        System.out.println(numberOfPeopleOver25);

        //Group people by age, for each age, count how many people
        Map<Integer, Long> byAgeCountPeople = people.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
        System.out.println(byAgeCountPeople);

        //Find the youngest person, return Optional <String> (only Name)
        Optional<String> theYoungestPerson = people.stream().min(Comparator.comparing(Person::getAge)).map(Person::getName);

        String youngestPerson = theYoungestPerson.orElseThrow();

        System.out.println(youngestPerson);
    }
}
