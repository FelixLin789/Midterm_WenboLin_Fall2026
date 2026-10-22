# Library Management System

Java 21 console application for Maple Leaf Public Library.

## How to Run

**Eclipse:** create a Java Project (JRE 21+), copy the files from `src/` into its `src` folder, then right-click `Main.java` → Run As → Java Application.

**Command line:**
```
javac -d out src/*.java
java -cp out Main
```

## Inheritance

- Single: `Member extends Person`
- Multilevel: `Person → LibraryStaff → Librarian → SeniorLibrarian`
- Hierarchical: `Member` and `LibraryStaff` extend `Person`; `Librarian` and `LibraryAssistant` extend `LibraryStaff`
- Hybrid: `SeniorLibrarian` extends `Librarian` and is both `Reportable` and `Reservable`

A Java class cannot extend more than one class. If two parent classes had the same method, Java would not know which one to use (the diamond problem). Interfaces solve this: a class can implement many interfaces, and it writes the methods itself, so there is no conflict.
