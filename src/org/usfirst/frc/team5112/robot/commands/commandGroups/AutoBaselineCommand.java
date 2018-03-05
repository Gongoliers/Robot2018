package org.usfirst.frc.team5112.robot.commands.commandGroups;

import org.usfirst.frc.team5112.robot.Robot;
import org.usfirst.frc.team5112.robot.commands.drivetrain.Forwards;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drives forwards at 40% speed for 5 seconds before stopping during auto.
 */
public class AutoBaselineCommand extends CommandGroup {

    public AutoBaselineCommand() {
    	
    	Robot.drivetrain.speed = 0.4;
    	addSequential(new Forwards(), 5);
    	
    }
}
