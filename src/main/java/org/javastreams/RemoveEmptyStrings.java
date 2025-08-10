package org.javastreams;

import java.util.Arrays;
import java.util.Objects;

public class RemoveEmptyStrings {

    public static void main(String args[])
    {
        String[] input = {"Java", ""," ",null,"streams"};
        System.out.println("Size of array" +  " " +input.length);
       // input =Arrays.stream(input).filter(p->!p.isEmpty()).toArray(String[]::new);
        input =
                Arrays
                        .stream(input)
                        .filter(Objects::nonNull)
                        .filter(p->!p.isBlank())
                        .toArray(String[]::new);

        System.out.println("Size of an stream " + input.length);
    }
}
