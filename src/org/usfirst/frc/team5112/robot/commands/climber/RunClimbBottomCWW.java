package org.usfirst.frc.team5112.robot.commands.climber;

import org.usfirst.frc.team5112.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RunClimbBottomCWW extends Command {

    public RunClimbBottomCWW() {
    	requires(Robot.climber);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.climber.runBottCWW();
   }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
   }

    protected void interrupted() {
  }
}
