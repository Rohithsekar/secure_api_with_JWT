package com.example.Spring_security_with_JWT.records;

/*
Records in Java are a new feature introduced in Java 14 that provide a concise way to declare classes for
immutable data models(They dont have setter methods). They are designed to simplify the creation of classes
that mainly encapsulate data and provide basic behavior. Records aim to reduce boilerplate code by automatically
generating useful methods such as constructors, getters, equals(), hashCode(), and toString() based on the fields
declared in the record.

Here are some key points about records in Java:

1. Declaration: Records are declared using the `record` keyword followed by the name of the record and a parameter list,
 which represents the fields of the record.

   Example:
   record Person(String name, int age) {
   }

2. Fields: Fields in a record are declared as part of the record's declaration. They are implicitly private and final,
 meaning they cannot be modified once the record is created.

3. Constructors: Records automatically generate a compact constructor that takes parameters for each field declared in
the record. The constructor initializes the fields with the provided arguments.

4. Accessors (Getters): Records generate accessor methods for each field, allowing you to access the values of the
 fields. These accessor methods follow the naming convention of `getFieldName()`.

5. toString(): Records automatically provide a `toString()` method that returns a string representation of the record,
 including the field names and their values.

6. equals() and hashCode(): Records generate implementations of `equals()` and `hashCode()` based on the fields
declared in the record. Two record instances are considered equal if their fields have the same values.

7. Destructuring: Records support destructuring, which allows you to extract individual field values from a record
instance using pattern matching.

Records are primarily intended for use cases where the data is immutable and equality is based on the values of the
fields. They provide a more concise and readable way to define such classes compared to traditional Java classes.

It's important to note that records are implicitly final and cannot be extended. They also cannot explicitly declare
additional methods or define their own superclass. If you require additional behavior or need more flexibility, a
regular class would be more suitable.

Records can be a powerful tool in Java for representing data-centric models and can help reduce the amount of
boilerplate code needed for such classes.

Records in Java allow you to define your own constructors. By default, records automatically generate a compact
constructor that initializes all the components (fields) of the record. However, if you need custom initialization
logic or want to provide additional constructor options, you can define your own constructors within a record.
 */

public record RecordDemo(String name, int age) {
// Default compact constructor is automatically generated:
    // public Person(String name, int age) { ... }

    // Custom constructor with additional parameters
    public RecordDemo(String name, int age, String address) {
        this(name, age);  // Call the compact constructor to initialize name and age
        // Custom initialization for the address
        // ...
    }

    // Custom constructor with different parameter types
    public RecordDemo(String name, String age) {
        this(name, Integer.parseInt(age));  // Convert the age String to an int
        // Custom initialization for age as an int
        // ...
    }

    // Custom constructor with different visibility modifier
    private RecordDemo(String name) {
        this(name, 0);  // Default age is 0
    }


    public static void main(String[] args) {
        RecordDemo person1 = new RecordDemo("Alice", 25);
        RecordDemo person2 = new RecordDemo("Bob", 30, "123 Main St.");
        RecordDemo person3 = new RecordDemo("Charlie", "35");

        // Accessing fields
        System.out.println(person1.name());
        System.out.println(person1.age());

        // Using custom constructors
        System.out.println(person2.name());
        System.out.println(person2.age());


        System.out.println(person3.name());
        System.out.println(person3.age());
    }
}

