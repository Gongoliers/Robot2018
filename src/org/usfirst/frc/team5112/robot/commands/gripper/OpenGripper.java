package org.usfirst.frc.team5112.robot.commands.gripper;

import org.usfirst.frc.team5112.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OpenGripper extends Command {

    public OpenGripper() {
    	requires(Robot.gripper);
    }

    protected void initialize() {
    	Robot.gripper.openGripper();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }
    protected void end() {
    }

    protected void interrupted() {
    }
}
