# toy-robot-service

## This API endpoint provides access to the Toy robot service which provides end point to control and retrieve the current position details.

1) GET : /robot/v1/position/
   It retrieve the current X Pos, Y Pos and Direction of the robot

2) POST : /robot/v1/place
   This end point Place the toy robot on the board at a specific position and direction as per the given param provided.
    e.g. {
   "x": 1,
   "y": 1,
   "direction": "WEST"
   }

3) POST : /persons/v1/command
   This end point provides command to the robot as a request parameter whether it turn LEFT, RIGHT or MOVE and make sure ROBOT is inside the square table boundary.
   e.g. commandName : MOVE/LEFT/RIGHT

## To run api using command line
java -jar toy-robot-service-0.0.1-SNAPSHOT.jar
