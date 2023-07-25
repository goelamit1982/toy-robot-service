package com.toy.robot.api.dto;

public class RobotPosition {
    private int xPos;
    private int yPos;
    public Direction direction;

    public RobotPosition(int xPos, int yPos, Direction direction) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
    }

    public RobotPosition(RobotPosition position) {
        this.xPos = position.getxPos();
        this.yPos = position.getyPos();
        this.direction = position.getDirection();
    }


    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void change(int x, int y) {
        this.xPos = this.xPos + x;
        this.yPos = this.yPos + y;
    }

    public RobotPosition getNextPosition()  {
        RobotPosition newPosition = new RobotPosition(this);
        switch (this.direction) {
            case NORTH:
                newPosition.change(0, 1);
                break;
            case EAST:
                newPosition.change(1, 0);
                break;
            case SOUTH:
                newPosition.change(0, -1);
                break;
            case WEST:
                newPosition.change(-1, 0);
                break;
        }
        return newPosition;
    }

    @Override
    public String toString() {

        return String.format("(%s, %s, %s)",
                getxPos(),
                getyPos(),
                getDirection().toString());

    }
}
