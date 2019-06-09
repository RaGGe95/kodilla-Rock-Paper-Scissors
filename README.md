# Project info
Classic rock paper scissors console game implemented in Java. In order to win we have to defeat computer required amount of times, which has been set in game settings (default value is three).
Computer randomly chooses one of the possible moves (Rock or Paper or Scissors), we can enable hints in-game settings to inspect what computer chose. I have decided to use HashMap collection in order to handle game logic. I store in hashMap pair of moves ie. (rock, paper) as a Key and those moves correspond with the victory of player who chose paper. I decided that this solution is the easiest one because we only have nine possible moves combinations, and I think an attempt to handle this with IF statements would get messy.

# Project insight
![App](/misc/app-screen.png)