package org.usfirst.frc.team5112.robot.commands.climber;

import org.usfirst.frc.team5112.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopClimber extends Command {

    public StopClimber() {
    	requires(Robot.climber);
    }

    protected void initialize() {
    	Robot.climber.stop();
    }

    protected void execute() {
    	Robot.climber.stop();
   }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
   }

    protected void interrupted() {
    	Robot.climber.stop();
   }
}
