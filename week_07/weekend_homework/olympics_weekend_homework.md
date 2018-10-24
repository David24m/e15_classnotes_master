# Olympic Games

The International Olympic Committee are looking for someone to create a new system to  manage the Events of the Olympic Games. They're looking for a system written in Java using TDD to prove it works as intended.

Their requirements are:

- Either a Team of Athletes or an individual Athlete can participate in an Event
  + Should this shared ability of Teams and Atheletes be achieved using an Interface or an Abstract Class?
  + What are the benefits and drawbacks of the different options?
  + Do they share some default behaviour or properties that should be inherited? Or is a shared Interface type and a contract to create methods enough?
- An event can give Bronze, Silver or Gold Medals to the Competitors.
  + How can you ensure that Medals can only be BRONZE, SILVER or GOLD?
- Competitors (Teams or Athletes) have a country which they represent

Once you're happy with your design and have finished a prototype, the Olympic Committee have some extra features they'd like to see (such a demanding client!) if you have extra time to work on building the system.

- Limit the number of Competitors that can compete in an Event.
- Prevent medals from accidentally being given to Competitors who aren't competing in that event
- Add scores or levels of skill to Atheletes to determine who should win an Event
- Create a Medal Table which looks at all the Events and determine which country has won the most Medals.
