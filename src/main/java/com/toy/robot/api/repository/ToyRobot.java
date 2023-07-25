package com.toy.robot.api.repository;


import com.toy.robot.api.controller.ToyRobotException;
import com.toy.robot.api.dto.RobotPosition;
import org.springframework.stereotype.Component;


/**
 * Robot POJO.
 *
 * States:
 *   placed     boolean     Has the robot been placed on the board?
 *   x          int         X-position on the board
 *   y          int         Y-position on the board
 *   facing     Direction   Enum representing direction of the toy robot
 *
 * Commands:
 *
 *  - PLACE X,Y,F
 *	- MOVE
 *	- LEFT
 *	- RIGHT
 *	- REPORT
 *
 *
 *
 */
@Component
public class ToyRobot {

    private RobotPosition position;
    private boolean isPlaced = false;

    public ToyRobot() {
    }

    public boolean setPosition(RobotPosition position) {
        if (position == null)
            return false;
        isPlaced = true;
        this.position = position;
        return true;
    }

    /**
     * Will move the toy robot one unit forward in the direction it is currently facing
     * @return
     * @throws ToyRobotException
     */
    public void move() throws ToyRobotException {
        if(isPlaced) {
            move(position.getNextPosition());
        }
    }

    /**
     * Moves the toy robot to new position
     *
     * @return true if moved successfully
     */
    public void move(RobotPosition newPosition) {
        if(isPlaced) {
            if (newPosition == null)
                return;

            this.position = newPosition;
        }
    }

    /**
     * Report - announces the X, Y, F of the toy robot
     * @return
     */
    public RobotPosition getPosition() {
        if(isPlaced) {
            return this.position;
        }
        return null;
    }

    /**
     * Rotates the toy robot 90 degrees LEFT without changing the position of the toy robot
     *
     */
    public void rotateLeft() {
        if(isPlaced) {
            if (this.position.direction == null)
                return;

            this.position.direction = this.position.direction.leftDirection();
            return;
        }
    }

    /**
     * Rotates the robot 90 degrees RIGHT without changing the position of the toy robot
     */
    public void rotateRight() {
        if(isPlaced) {
            if (this.position.direction == null)
                return;

            this.position.direction = this.position.direction.rightDirection();
            return;
        }
    }

    public boolean isPlaced() {
        return isPlaced;
    }
}
