##Welcome to Registers

###Prerequisites:
- JDK 1.8
- Maven 3
- JAVA_HOME & MAVEN_HOME env variables declared also their executables added to PATH env variable

###Install deps:
- `mvn install`

###Execute test: 
- `mvn test`

###Generate .jar
- `npm package` # This will generate a .jar file under ./target folder

###Run the program
- You can execute `java -jar ./target/registers-0.0.1-SNAPSHOT.jar -P "./path/to/file.csv"` after building the .jar

####TODO
- Would be nice to have a file parse with generic type to be able to reuse it for other data structures
- Using streams in proper way is key for reading big chunks of data avoid RAM collapse
- Split this project into two services, an API for reading and a CLI that will request that API
- Test data transformation