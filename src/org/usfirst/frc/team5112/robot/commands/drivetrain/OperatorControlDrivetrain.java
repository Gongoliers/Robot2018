package org.usfirst.frc.team5112.robot.commands.drivetrain;

import org.usfirst.frc.team5112.robot.OI;
import org.usfirst.frc.team5112.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OperatorControlDrivetrain extends Command {

    public OperatorControlDrivetrain() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.drivetrain.operatorControl(OI.joystickExtreme, OI.logitechController, Robot.drivetrain.type);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	Robot.drivetrain.stop();
    }
}
