# Snakes and Ladders (but in Java this time)

## The Task

Your task is to create the board game Snakes and Ladders, this time in Java!
Your focus during this lab is to try to adhere to as many of the SOLID principles as possible - as well as the usual TDD focus.

This lab should help you consolidate what was learned in week 1 of Java, as well as what you learned yesterday:

- Java Syntax and Data structures (ArrayLists etc)
- Advanced Testing (Mockito)
- SOLID
- Really thinking about the architecture of your applications

The main task is the creation of a SOLID implementation of the game, so
if you feel that your code is as SOLID as it can be, the instructors will be free to look over your code and check through the principles with you and give you some pointers on how to improve it (or just tell you it's perfect and that you might as well go get a Java job now).

After completion, think about writing larger tests (non-unit tests), which test an entire game, using more than one 'act' in the test (These tests should go in a seperate file to your unit tests).

Try to avoid using a Runner class until the very end, as as much of your code as possible should be tested using unit tests.

---

### Tips
- Draw diagrams before touching any code.
- Think about what unit tests you want for specific classes (possibly writing them down before coding).
- Think about how a consumer of your code would go about adding to it, ie adding new types of players, tiles, etc - if when you do this you think they may need to change some of your existing code, revisit the Open-Closed principle, and think about how you could refactor your code using the other principles to adhere to it.
