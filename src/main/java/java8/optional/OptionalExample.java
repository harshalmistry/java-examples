package java8.optional;

import java.util.Optional;
import java.util.Random;

/**
 * This is java Optional example, introduced in Java8.
 * This class provides type level solution for representing optional values
 * instead of null references.
 * Optional is meant to be used as a return type. Trying to use it as a field type is not recommended.
 *
 * @author niharsh
 * @created 07/05/2021 - 20:04
 */
public class OptionalExample {

    public static void main(String[] args) {
        //To create empty optional
        Optional<Object> emptyOptional = Optional.empty();
        emptyOptional.ifPresent(object->System.out.println("I won't be printed."));

        //To create non-empty optional
        //Argument to Optional.of must be non-null, otherwise it will throw NullPointerException
        String ofString = "of string";
        Optional<String> stringOptional = Optional.of(ofString);
        stringOptional.ifPresent(str -> System.out.println(str));
        ofString = null;
        // Below line will throw at run time NullPointerException
        // Optional.of(randomString);

        //To create optional with null reference
        //If Argument to ofNullable is null then empty Optional will be created.
        String ofNullableString = "ofNullable string";
        Optional<String> nullOptional = Optional.ofNullable(ofNullableString);
        nullOptional.ifPresent(str -> System.out.println(ofNullableString));

        //To check value presence in optional, isPresent method is used.
        //It will be true for any non-null value, otherwise false.
        String isPresentString = "isPresent string";
        Optional<String> isPresentOptional = Optional.of(isPresentString);
        System.out.println("Does Optional have value? "+isPresentOptional.isPresent());
        if(isPresentOptional.isPresent()){
            // To get value from Optional, use get method.
            System.out.println(isPresentOptional.get());
        }

        //To check if optional is empty, isEmpty method is used
        String isEmptyString = null;
        Optional<String> isEmptyOptional = Optional.ofNullable(isEmptyString);
        System.out.println("Is Optional empty? "+isEmptyOptional.isEmpty());

        //To get default value in case of Optional is empty using OrElse
        //It requires only one parameter
        String orElseString = null;
        orElseString = Optional.ofNullable(orElseString).orElse("default string");
        System.out.println(orElseString);

        //To get default value in case of Optional is empty using orElseGet
        //It requires Supplier function
        String orElseGetString = null;
        orElseGetString = Optional.ofNullable(orElseGetString).orElseGet(()->"default string");
        System.out.println(orElseGetString);

        //Understand difference between orElse and orElseGet
        //orElse will be executed no matter Optional is empty or not.
        //orElseGet will be only executed if Optional is empty.
        //in case of empty optional, both methods will be executed.
        //It is recommended to use orElseGet method when there is costly operation involved.
        String testString = "test string";
        System.out.println("Executing orElse method");
        String s1 = Optional.of(testString).orElse(someCostlyOperation());
        System.out.println("Executing orElseGet method");
        String s2 = Optional.of(testString).orElseGet(OptionalExample::someCostlyOperation);

        //In case when we don't want to return default value,
        // instead throw an exception use orElseThrow
        Object receivedArgument = null;
        //Below line will throw runtime IllegalArgumentException
        //Optional.ofNullable(receivedArgument).orElseThrow(IllegalArgumentException::new);
        //Below line will throw runtime NoSuchElementException: No value present
        //Optional.ofNullable(receivedArgument).orElseThrow();

        //To get value from Optional use get method
        //If Optional is empty then NoSuchElementException will be thrown
        //It is recommended to use other way of retrieve value out of Optional
        Integer i = 1;
        Optional<Integer> integerOptional = Optional.of(i);
        integerOptional.ifPresent(integer -> System.out.println(integer));
        i = null;
        Optional<Integer> integerOptional1 = Optional.ofNullable(i);
        //Below line will throw runtime NoSuchElementException: No value present
        //integerOptional1.get();

        //Optional + filter example
        //This is very useful to do certain check, like password check, range check of any field, etc
        int number = new Random().nextInt(10);
        boolean isEven = Optional.of(number).filter(n -> n % 2 == 0).isPresent();
        System.out.println("Number - "+number+" is even? " + isEven);

    }



    // Some dummy costly operation function
    private static String someCostlyOperation(){
        System.out.println("Performing some costly operation");
        return "return value after costly operation";
    }
}
