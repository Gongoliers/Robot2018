package org.usfirst.frc.team5112.robot.commands.elevator;

import org.usfirst.frc.team5112.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorReverse extends Command {

	private double speed;
	
    public ElevatorReverse(double speed) {
    	requires(Robot.elevator);
    	this.speed = speed;
    	
    }

    protected void initialize() {
    	Robot.elevator.elevatorSpeed = speed;
    }

    protected void execute() {
    	Robot.elevator.up();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
