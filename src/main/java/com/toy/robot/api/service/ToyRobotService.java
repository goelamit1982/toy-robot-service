package com.toy.robot.api.service;

import com.toy.robot.api.dto.RobotPosition;
import com.toy.robot.api.repository.ToyRobot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToyRobotService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ToyRobotService.class);

    private static final int BOARD_SIZE = 5;

    @Autowired
    private ToyRobot robot;

    public boolean isValidPosition(RobotPosition position) {
        if(robot.isPlaced())
            return position.getxPos() >= 0 && position.getxPos() < BOARD_SIZE && position.getyPos() >= 0 && position.getyPos() < BOARD_SIZE;
        else
            return true;
    }

    public String place(RobotPosition position) {
        robot.setPosition(position);
        return String.valueOf(robot.getPosition().toString());
    }

    public void move(RobotPosition position) {
        robot.move(position);
    }

    public void rotateLeft() {
        robot.rotateLeft();
    }

    public void rotateRight() {
        robot.rotateRight();
    }

    public String report() {
        if(robot == null || robot.getPosition() == null || !robot.isPlaced())
            return "ROBOT MISSING";
        return String.valueOf(robot.getPosition());
    }

    public RobotPosition getNextPosition() {
        if(robot.isPlaced())
        {
            return robot.getPosition().getNextPosition();
        }
        return null;

    }
}
