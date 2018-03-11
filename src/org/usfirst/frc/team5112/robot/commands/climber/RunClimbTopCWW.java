package org.usfirst.frc.team5112.robot.commands.climber;

import org.usfirst.frc.team5112.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RunClimbTopCWW extends Command {

    public RunClimbTopCWW() {
    	requires(Robot.climber);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.climber.runTopCWW();
   }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
   }

    protected void interrupted() {
  }
}
