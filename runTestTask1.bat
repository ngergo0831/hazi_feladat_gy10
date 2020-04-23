javac bar/*.java
javac -cp .;lib/hamcrest-core-1.3.jar;lib/junit-4.12.jar test/Task1.java
java -cp .;lib/hamcrest-core-1.3.jar;lib/junit-4.12.jar org.junit.runner.JUnitCore test.Task1
