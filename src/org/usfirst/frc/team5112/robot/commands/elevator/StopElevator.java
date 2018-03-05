package org.usfirst.frc.team5112.robot.commands.elevator;

import org.usfirst.frc.team5112.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopElevator extends Command {

    public StopElevator() {
    	requires(Robot.elevator);
    }

    protected void initialize() {
    	Robot.elevator.stop();
    }

    protected void execute() {
    	Robot.elevator.stop();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	Robot.elevator.stop();
    }

    protected void interrupted() {
    	Robot.elevator.stop();
    }
}
