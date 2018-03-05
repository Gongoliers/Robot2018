package org.usfirst.frc.team5112.robot.commands.gripper;

import org.usfirst.frc.team5112.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CloseGripper extends Command {

    public CloseGripper() {
    	requires(Robot.gripper);
    }

    protected void initialize() {
    	Robot.gripper.closeGripper();
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