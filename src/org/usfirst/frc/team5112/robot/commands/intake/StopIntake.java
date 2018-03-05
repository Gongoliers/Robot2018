package org.usfirst.frc.team5112.robot.commands.intake;

import org.usfirst.frc.team5112.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopIntake extends Command {

    public StopIntake() {
    	requires(Robot.intake);
    }

    protected void initialize() {
    	Robot.intake.stop();
    }

    protected void execute() {
    	Robot.intake.stop();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	Robot.intake.stop();
    }
    
    protected void interrupted() {
    	Robot.intake.stop();
    }
}
