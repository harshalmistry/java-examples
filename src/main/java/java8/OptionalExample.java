package java8;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * This is java Optional example, introduced in Java8.
 * This class provides type level solution for representing optional values
 * instead of null references.
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
    }
}
