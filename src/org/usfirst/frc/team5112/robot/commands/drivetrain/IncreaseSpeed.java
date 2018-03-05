package org.usfirst.frc.team5112.robot.commands.drivetrain;

import org.usfirst.frc.team5112.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IncreaseSpeed extends Command {

    public IncreaseSpeed() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.drivetrain.setSpeed(Robot.drivetrain.interval);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
