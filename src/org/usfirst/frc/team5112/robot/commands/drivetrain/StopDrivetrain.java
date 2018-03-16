package org.usfirst.frc.team5112.robot.commands.drivetrain;

import org.usfirst.frc.team5112.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopDrivetrain extends Command {

    public StopDrivetrain() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    	Robot.drivetrain.stop();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    	Robot.drivetrain.stop();
    }
}
