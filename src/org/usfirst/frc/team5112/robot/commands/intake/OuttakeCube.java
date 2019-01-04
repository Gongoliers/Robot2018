package org.usfirst.frc.team5112.robot.commands.intake;

import org.usfirst.frc.team5112.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OuttakeCube extends Command {

    public OuttakeCube() {
    	requires(Robot.intake);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.intake.out(Robot.intake.speed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.intake.out(0);
    }

    protected void interrupted() {
    	end();
    }
}
