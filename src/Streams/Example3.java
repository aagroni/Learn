package Streams;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Example3 {
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

        //Group people by age
        Map<Integer, List<Person>> peopleByAge = people.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(peopleByAge);


        //Keep people older than 25, convert to names, sort alphabetically, return list
        List<String> filteredPeople = people.stream().filter(p->p.getAge()>25)
                .map(Person::getName)
                .sorted()
                .toList();
        System.out.println(filteredPeople);

        //get average age of people
        double averageAgeOfPeople = people.stream().mapToDouble(Person::getAge).average().orElse(0.0);

        System.out.println(averageAgeOfPeople);
    }
}
