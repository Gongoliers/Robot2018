package org.usfirst.frc.team5112.robot.commands.intake;

import org.usfirst.frc.team5112.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AllIntakeCounterclockwise extends Command {

    public AllIntakeCounterclockwise() {
    	requires(Robot.intake);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.intake.counterclockwise(Robot.intake.speed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}