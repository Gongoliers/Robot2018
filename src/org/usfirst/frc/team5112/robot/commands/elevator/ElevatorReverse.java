package org.usfirst.frc.team5112.robot.commands.elevator;

import org.usfirst.frc.team5112.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorReverse extends Command {

    public ElevatorReverse(double speed) {
    	requires(Robot.elevator);
    	Robot.elevator.elevatorSpeed = speed;
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.elevator.rotateCounterClockwise();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
