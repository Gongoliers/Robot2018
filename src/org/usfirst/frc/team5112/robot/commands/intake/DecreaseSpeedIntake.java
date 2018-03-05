package org.usfirst.frc.team5112.robot.commands.intake;

import org.usfirst.frc.team5112.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DecreaseSpeedIntake extends Command {

    public DecreaseSpeedIntake() {
    	requires(Robot.intake);
    }

    protected void initialize() {
    	Robot.intake.changeSpeed(Robot.intake.interval * -1);
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
