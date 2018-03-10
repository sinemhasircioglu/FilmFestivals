# FilmFestivals :movie_camera:

The website that looks at the results of the film festival and the people rate for the films that participated in these festivals

## Getting Started :warning:

First of all, you need to clone the project to your local machine

```
git clone https://github.com/sinemhasircioglu/FilmFestivals.git
cd FilmFestivals
```

## Building :hammer:

A step by step series of building that project

1. Install the required software
2. Change connection string of Database (File: DBConnection.java, Line: 20)
3. If you want to use change Database Provider to MS SQL, MySQL etc... You can change on DBConnection.java File (Line: 18)

```
//For MySQL 
Class.forName("com.mysql.jdbc.Driver").newInstance();
```

4. And add the database's jdbc driver to the library

5. Run the project on Netbeans -> File -> Open Project -> File Name :bomb:

### Built With

* [Netbeans IDE 8.2](https://netbeans.org/downloads/index.html) 
* [Java EE 7 Web](http://www.oracle.com/technetwork/java/javaee/downloads/index.html) 
* [JDK 1.8](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html) 
* JSF 2.2
* GlassFish Server 4.1.1

### Contributing

* If you want to contribute to codes, create pull request
* If you find any bugs or error, create an issue

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
