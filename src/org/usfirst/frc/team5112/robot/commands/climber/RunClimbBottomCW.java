package org.usfirst.frc.team5112.robot.commands.climber;

import org.usfirst.frc.team5112.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RunClimbBottomCW extends Command {

	public RunClimbBottomCW() {
		requires(Robot.climber);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.climber.runBottCW();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
