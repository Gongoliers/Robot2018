package org.usfirst.frc.team5112.robot.commands.commandGroups;

import org.usfirst.frc.team5112.robot.Robot;
import org.usfirst.frc.team5112.robot.commands.drivetrain.Forwards;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drives forwards at 70% speed for 3 seconds before stopping during auto.
 */
public class AutoBaselineCommand extends AutoCommand {

    public AutoBaselineCommand() {
    	
    	Robot.drivetrain.speed = 0.7;
    	addSequential(new Forwards(), 1.75);
    	
    }

	@Override
	public void init() {
		
	}
}
