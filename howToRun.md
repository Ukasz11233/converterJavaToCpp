# Jak uruchomić aplikację

Aby uruchomić aplikację, należy uruchomić kolejno komendy:  
_mvn clean install_  
_java -cp core/target/core-1.0-SNAPSHOT.jar Generator_

Pliki wejściowe z rozszerzeniem __java__ które są konwertowane na pliki wyjściowe z rozszerzeniem
__cpp__ znajdują się w katalogu głownym __/javaToCpp__. Są to kolejno:  
_javaTestFile1.java_  
_javaTestFile2.java_  
_javaTestFile3.java_  

Pliki wyjściowe również znajdują sie w katalogu głównym: __/javaToCpp__ i są to kolejno:  
_testResult1.cpp_  
_testResult2.cpp_  
_testResult3.cpp_