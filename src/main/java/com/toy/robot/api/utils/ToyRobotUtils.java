package com.toy.robot.api.utils;

import com.toy.robot.api.dto.RobotPosition;

import java.lang.invoke.SwitchPoint;
import java.util.List;

public class ToyRobotUtils {

    private static final int BOARD_SIZE = 5;
    public static final List<String> DIRECTION_LIST =
            List.of("EAST", "WEST", "NORTH", "SOUTH");

    public static final List<String> COMMAND_LIST =
            List.of("PLACE", "MOVE", "LEFT", "RIGHT", "REPORT");
    public static boolean isValidPosition(int x, int y) {
        return x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE;
    }

    public static boolean isValidDirection(String direction) {
        return DIRECTION_LIST.stream().anyMatch(s -> s.equalsIgnoreCase(direction));
    }

    public static boolean isValidMove(String command, RobotPosition robotPosition) {
        return DIRECTION_LIST.stream().anyMatch(s -> s.equalsIgnoreCase(command));
    }
}
