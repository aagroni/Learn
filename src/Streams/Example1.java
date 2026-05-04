package Streams;

import java.util.List;
import java.util.Optional;

public class Example1 {
    static void main(String[] args) {
        List<String>  names = List.of("agron","omer", "ali", "valdet", "sejfi", "ana");
        List<Integer> nums = List.of(1,2,3,4,5,6,7,8,10,15,20,25);

        //Keep names starting with letter A and turn them into uppercase letters and print them.
        names.stream()
                .filter(n -> n.startsWith("a"))
                .map(n-> n.toUpperCase())
                .forEach(System.out::println);

        //keep only even numbers, multiply by 2 & print them
        nums.stream()
                .filter(n -> n%2 ==0)
                .map(n-> n*2)
                .forEach(n-> System.out.println(n));

        //keep names with length > 3, convert to uppercase, return as list
        List<String> filteredNames = names.stream()
                .filter(n->n.length()>3)
                .map(n->n.toUpperCase())
                .toList();
        System.out.println(filteredNames);

        //find first number > 10 & return it (Optional)
        Optional<Integer> filterNumber = nums.stream()
                .filter(n -> n > 10).findFirst();
        Integer theFirstNumberAfterTen = filterNumber.orElse(-1);
        System.out.println(theFirstNumberAfterTen);

        //keep numbers > 5 square them * collect them to a list
        List<Integer> squareNumbers = nums.stream()
                .filter(n-> n > 5)
                .map(n->n*n)
                .toList();
        System.out.println(squareNumbers);
    }
}
