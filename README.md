# WeDOQATest

Basic project was done using JUnit and in the Chrome browser.

Main tests should be run from WeDoQATests class located in src\test\java\tests.

Not every chunk of code is commented, some parts are described by method name so other comments are unnecessary. Most web elements are not defined as variables. It can be done easily,
but I find it unnecessary in not so complicated tests. Defining variables would be more moddable and would be more like strict, complex programming.

Bonus tasks made a mess because basic tasks were meant to be done using JUnit and almost all bonus tasks imply use of TestNG.

Jenkins runs only TestNG projects...

Screenshot creation module also implies use of TestNG, its Listeners, and works only if tests are run as TestNG tests. The second task message is meant to be printed using JUnit Assert
so it wont call TestNG Listeners and the Assert method from TestNG has to be used, left as a comment. That applies to all Assert methods in tests.

Multi browser support was written, but not tested and it is left as a comment in BaseTest class, testng.xml was altered too.

Logger is also set but it doesn't write to the file. It prints out in the console, creates the file, but the file is empty. Couldn't find out why...

Not done at all: no local dependencies, run via command line, Selenium Grid Hub.

I hope I haven't missed something...
