package org.usfirst.frc.team5112.robot.commands.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5112.robot.commands.climber.StopClimber;
import org.usfirst.frc.team5112.robot.commands.drivetrain.StopDrivetrain;
import org.usfirst.frc.team5112.robot.commands.elevator.StopElevator;
import org.usfirst.frc.team5112.robot.commands.intake.StopIntake;

/**
 * Stops all subsystems of the robot.
 * Can be used as an emergency stop if desired.
 */
public class StopEverything extends CommandGroup {

    public StopEverything() {
    	
    	addParallel(new StopDrivetrain());
    	addParallel(new StopIntake());
    	addParallel(new StopElevator());
    	addParallel(new StopClimber());
    	
    }
}
