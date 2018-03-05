package org.usfirst.frc.team5112.robot.commands.intake;

import org.usfirst.frc.team5112.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IncreaseSpeedIntake extends Command {

    public IncreaseSpeedIntake() {
    	requires(Robot.intake);
    }

    protected void initialize() {
    	Robot.intake.changeSpeed(Robot.intake.interval);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
