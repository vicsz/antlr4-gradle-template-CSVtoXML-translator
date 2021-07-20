# antlr4-gradle-template-CSVtoXML-translator

[![.github/workflows/build.yml](https://github.com/vicsz/antlr4-gradle-template-CSVtoXML-translator/actions/workflows/build.yml/badge.svg)](https://github.com/vicsz/antlr4-gradle-template-CSVtoXML-translator/actions/workflows/build.yml)

Simple template Antlr4 gradle template with ANTLR based translation, traversal, and validation.

## Running the Code 

Just run gradlew from root directory to generate Antlr4 created code, compile actual code, and run unit tests.

Only requirement is a JavaJDK installed. 

```sh
./gradlew
```

## Testing G4 Grammers

GUI based Antlr Validation tools such as the ANTLR Intellij Plugin help in rapidly verifying Grammer file updates. 

Once plugin is installed, you'll have a right click context of *Test Rule* when viewing the G4 file in the IDE. 