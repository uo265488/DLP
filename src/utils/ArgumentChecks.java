package utils;

import ast.type.ErrorType;

public class ArgumentChecks {


    public static void checkString(String message) {
        if(message == null) throw new RuntimeException("String cannot be null. ");
        if(message.isBlank()) throw new RuntimeException("String cannot be blank. ");
        if(message.isEmpty()) throw  new RuntimeException("String cannot be empty.");
    }

    public static void isNotNull(Object o) {
        if(o == null) throw new RuntimeException("Object cannot be null. ");
    }
}
