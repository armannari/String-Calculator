#Compile and unit_test

javac -classpath "classes/:lib/junit-4.12.jar" src/main/java/is/ru/stringcalculator/*.java -d classes
javac -classpath "classes/:lib/junit-4.12.jar" src/test/java/is/ru/stringcalculator/*.java -d classes
java -cp "classes/:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore is.ru.stringcalculator.CalculatorTest