# Paired programming Lab for SOLID

### Task 1

Write a program that allows athletes to compete in an event, calculates points earned for event and assigns a medal based on the number of points. 

- Boxers points are calculated by hits given - hits taken (passed in when they are created)
- Gymnast points are calculated by points for difficulty + points for execution ( again passed in when they are created)
- 15+ points = Gold
- 10+ points = Silver
- 5+ points = Bronze

You should implement this for 2 types of athlete - a boxer and gymnast. 

These should extend an Athlete abstract class. 

There should be a function to allow enter an event that then calls other functions in turn to prepare, compete, calculate points and award medal. 

The prepare and compete functions should just print something to screen. 

### Task 2

Write a program that allows an Athlete to record the distance they have run in a single session and keep a record of their total distance covered.

The log should print out both the distance covered during session and also total distance covered overall for all sessions.  


### Task 3

Extend task 2 to allow the total and session distances to either be written to console or to write to a text file.

(Hint - Think about having a AthleteLog interface)

### Task 4

Make sure that your code for task 2 and 3 adheres to the SOLID principles. 