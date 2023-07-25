package com.toy.robot.api.controller;

import com.toy.robot.api.dto.Direction;
import com.toy.robot.api.dto.PostRobotRequest;
import com.toy.robot.api.dto.RobotPosition;
import com.toy.robot.api.service.ToyRobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/robot/v1/")
public class ToyRobotController {

    @Autowired
    private ToyRobotService toyRobotService;

    @GetMapping("/position")
    public ResponseEntity<String> getCurrentPosition() {
        return new ResponseEntity<String>(toyRobotService.report(), HttpStatus.OK);
    }

    @PostMapping(value = "/place",  produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> placeRobot(@Valid @RequestBody PostRobotRequest robotRequest) {
        RobotPosition robotPosition = new RobotPosition(robotRequest.getX(), robotRequest.getY(), Direction.valueOf(robotRequest.getDirection()));
        if(toyRobotService.isValidPosition(robotPosition)) {
            toyRobotService.place(robotPosition);
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }


    @PostMapping(value = "/command")
    public ResponseEntity<?> moveRobot(@RequestParam(name = "commandName") @Valid String commandName) {
        if("LEFT".equalsIgnoreCase(commandName)) {
            toyRobotService.rotateLeft();
        } else if ("RIGHT".equalsIgnoreCase(commandName)) {
            toyRobotService.rotateRight();
        } else if("MOVE".equalsIgnoreCase(commandName)) {
            try {
                RobotPosition newPosition = toyRobotService.getNextPosition();
                if(newPosition == null)
                    return new ResponseEntity<String>("", HttpStatus.OK);
                if(!toyRobotService.isValidPosition(newPosition))
                    return new ResponseEntity<String>("Invalid position", HttpStatus.BAD_REQUEST);
                else {
                    toyRobotService.move(newPosition);
                    return new ResponseEntity<String>("", HttpStatus.OK);
                }
            } catch (Exception e) {
                return new ResponseEntity<String>("ROBOT MISSING", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<String>("Invalid command", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("", HttpStatus.OK);
    }
}
