# Allen4J

Allen4J is the quickest, easiest and the most way to reliable way to develop applications integrating Allen's API.

[![Maven Central](https://img.shields.io/maven-central/v/xyz.lamergameryt/Allen4J/1.0.1.svg?style=flat-square)](https://search.maven.org/artifact/xyz.lamergameryt/Allen4J)
[![Javadocs](https://javadoc.io/badge2/xyz.lamergameryt/Allen4J/1.0.1/javadoc.svg?color=blue&style=flat-square)](https://javadoc.io/doc/xyz.lamergameryt/Allen4J/1.0.1)
![License](https://img.shields.io/github/license/lamergameryt/Allen4J)
![GitHub followers](https://img.shields.io/github/followers/lamergameryt?style=social)

## ⏩ Quick Example

In this example for v1.0.1, we will get a users form number from his name.

```java
public final class ExampleSearch {
    public static void main(final String[] args) throws IOException, URISyntaxException {
        final String baseURL = args[0];
        final String authorization = args[1];
        final String name = args[2];

        final AllenAPI api = new AllenAPI(baseURL, authorization);

        NameSearchResponse response = api.searchByName(NameSearchRequest.build(name, 1));
        List<Student> students = response.getStudents();
        Student student = students.get(0);
        
        System.out.println("The form number of " + student.getFullName()
                + " is " + student.getFormNumber());
    }
} 
```

## 🔗 Useful Links

* [Javadocs](https://www.javadoc.io/doc/xyz.lamergameryt/Allen4J)
* [Wiki](https://github.com/lamergameryt/Allen4J/wiki)

## ⁉ Interesting Features

* 🦄 **Unique** - Allen4J is currently the only wrapper present that allows users to interact with Allen's API without having to write long lines of code to do so.
* 🕐 **Easy to use** - Simplifying complex requests to a few lines, Allen4J makes interacting with Allen's API a breeze. You can accomplish complex tasks with just a few lines of code.
* 🚀 **Growing** - With a growing set of features and being updated constantly to improve performance, Allen4J is the ideal choice for your application!

## 👩‍🏫 Installation

### Maven
```xml
<dependencies>
  <dependency>
    <groupId>xyz.lamergameryt</groupId>
    <artifactId>Allen4J</artifactId>
    <version>1.0.1</version>
  </dependency>
</dependencies>
```

### Gradle
```groovy
repositories {
  mavenCentral()
}

dependencies {
  implementation 'xyz.lamergameryt:Allen4J:1.0.1'
}
```

### SBT
```scala
libraryDependencies += "xyz.lamergameryt" % "Allen4J" % "1.0.1"
```

## 📖 More information

With the evergrowing list of features being added to this api wrapper, it's not feasible to edit the readme everytime something new is added.
To know more about the project and how to use it, visit our [Wiki](https://github.com/lamergameryt/Allen4J/wiki).

## 🥺 Liked it?
Thank you for reading through this!

If you liked it, consider giving a star to this project and following me on GitHub as I have put my ❤ and a lot of effort in this.
