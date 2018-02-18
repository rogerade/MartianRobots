# Martian Robots Test

* **MartianRobotsMain** : Main Class - Accepts instructions via the console.
* **InputHandler** : Translates instructions executes on the Controller class
* **Controller** : Manages Robots, MarsSurface
* **MarsSurface** : Has robots, upper bounds and lost scents
* **Robot** : Has location details and isLost property
* **Orientation** : Enum for North, South, East and West
* **Commands** : Left, Right and Forward enum. Add more commands here and implement abstract method.

TODO
* User input error handling. If an exception occurs catch and print a user friendly message then await the next instruction.
* More input validation e.g. robot position is within bounds of surface
