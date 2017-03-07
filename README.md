# ParametizedWithHamcrest

You should (as a minimum):
1. Explain the purpose of the Test (what the original test exposed, and what your test expose)
The original tests provided were just counting how many images were processed correctly and how many were not. Then it'll compare the values. The downside is that it does not report the outcome for EACH image so we see which ones fail.

Testing against a count of correct/incorrect tests is wrong. The risk is that one image, that was expected to fail, will not fail, and another image that should pass, will not pass because of changes to the code.

Using parametized tests with Hamcrest I clearly show what is wrong and for what image.


2.Explain about Parameterized Tests in JUnit and how you have used it in this exercise.

Parametized tests enable us to provide parameters to tests and run them automatically from a cvs file ofr example or a collection in our case. It makes the programmers job easier because he doesn't have to code each and every test. He has to build only the skeleton of it.




3.Explain the topic Data Driven Testing, and why it often makes a lot of sense to read test-data from a file.

...

4.Your answers to the question; whether what you implemented was a Unit Test or a JUnit Test, the problems you might have discovered with the test and, your suggestions for ways this could have been fixed.

...

5.The steps you took to include Hamcrest matchers in the project, and the difference they made for the test

copy/paste the dependency from the internet and then use the library (import it)
