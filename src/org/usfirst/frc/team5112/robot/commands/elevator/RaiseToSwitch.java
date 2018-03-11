package org.usfirst.frc.team5112.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RaiseToSwitch extends CommandGroup {

    public RaiseToSwitch() {
    	
    	addSequential(new ElevatorReverse(), 0.8);
    	// TODO
    	addParallel(new ToggleCubePossession());
    	addParallel(new ToggleElevatorUse());
    }

}
