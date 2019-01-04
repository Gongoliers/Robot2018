package org.usfirst.frc.team5112.robot.commands.commandGroups;

import org.usfirst.frc.team5112.robot.Robot;
import org.usfirst.frc.team5112.robot.commands.drivetrain.StopDrivetrain;
import org.usfirst.frc.team5112.robot.commands.elevator.ElevatorReverse;
import org.usfirst.frc.team5112.robot.commands.elevator.ToggleCubePossession;
import org.usfirst.frc.team5112.robot.commands.elevator.ToggleElevatorUse;
import org.usfirst.frc.team5112.robot.commands.intake.OuttakeCube;

import com.thegongoliers.pathFollowing.FollowPathCommand;
import com.thegongoliers.pathFollowing.Path;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class TestCommand extends CommandGroup {
	
	public TestCommand() {
//		Path path = new Path(Robot.drivetrain);
//		path.addStraightAway(80);
//		path.addRotation(-90);
//		
//		Path path2 = new Path(Robot.drivetrain);
//		path2.addStraightAway(-30);
//
//		Path path3 = new Path(Robot.drivetrain);
//		path3.addStraightAway(22);
//
//		addSequential(new ToggleCubePossession());
//		addSequential(new ToggleElevatorUse());
//		addSequential(new FollowPathCommand(path));
//		addSequential(new FollowPathCommand(path2), 2.5);
//		addSequential(new FollowPathCommand(path3));
//		addSequential(new StopDrivetrain());
//		addSequential(new ElevatorReverse(0.4), 3.33);
//		addSequential(new ElevatorReverse(.15), 0.5);
//		addSequential(new OuttakeCube(), 2);
//		addSequential(new ElevatorReverse(0), .5);
//		addSequential(new ElevatorReverse(.2), .25);
//		addSequential(new ElevatorReverse(0), .5);
//		addSequential(new ElevatorReverse(.2), .25);
//		addSequential(new ElevatorReverse(0), .5);
//		addSequential(new ElevatorReverse(.2), .25);
//		addSequential(new ElevatorReverse(0), .5);
//		addSequential(new ElevatorReverse(.2), .25);
//		addSequential(new ElevatorReverse(0), .5);
//		addSequential(new ElevatorReverse(.2), .25);
//		addSequential(new ElevatorReverse(0), .5);

		addSequential(new ToggleCubePossession());
		addSequential(new ToggleElevatorUse());
		addParallel(new ElevatorReverse(0.4), 1.5);
//		addSequential(new ElevatorReverse(.15), 0.5);
		addSequential(new WaitCommand(2));
		addSequential(new OuttakeCube(), 3);
		addSequential(new ElevatorReverse(0), .5);
		addSequential(new ElevatorReverse(.2), .25);
		addSequential(new ElevatorReverse(0.05),8);

	}

}
