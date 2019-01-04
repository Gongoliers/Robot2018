package org.usfirst.frc.team5112.robot.commands.commandGroups;

import java.util.logging.Level;

import org.usfirst.frc.team5112.robot.Robot;
import org.usfirst.frc.team5112.robot.commands.drivetrain.Backwards;
import org.usfirst.frc.team5112.robot.commands.drivetrain.Forwards;
import org.usfirst.frc.team5112.robot.commands.drivetrain.StopDrivetrain;
import org.usfirst.frc.team5112.robot.commands.elevator.ElevatorReverse;
import org.usfirst.frc.team5112.robot.commands.elevator.ToggleCubePossession;
import org.usfirst.frc.team5112.robot.commands.elevator.ToggleElevatorUse;
import org.usfirst.frc.team5112.robot.commands.intake.OuttakeCube;

import com.thegongoliers.pathFollowing.FollowPathCommand;
import com.thegongoliers.pathFollowing.Path;

/**
 * Places a pre-loaded power cube into the scale.
 * 
 * @author Nicholas Bottone
 */
public class AutoScaleCommand extends AutoCommand {

	/**
	 * If conservativeMode is set to TRUE, the robot will only go for the 
	 * switch if and only if it is already lined up with the switch directly.
	 * Otherwise, it will simply only go for baseline.
	 * 
	 * If conservativeMode is set to FALSE, the robot will go for the switch
	 * regardless of position.
	 */
	boolean conservativeMode = false;

	private void startRightGoRight() {
		Path path = new Path(Robot.drivetrain);
		path.addStraightAway(80);
		path.addRotation(-90);
		
		Path path2 = new Path(Robot.drivetrain);
		path2.addStraightAway(-30);

		Path path3 = new Path(Robot.drivetrain);
		path3.addStraightAway(22);

		addSequential(new ToggleCubePossession());
		addSequential(new ToggleElevatorUse());
		addSequential(new FollowPathCommand(path));
		addSequential(new FollowPathCommand(path2), 2.5);
		addSequential(new FollowPathCommand(path3));
		addSequential(new StopDrivetrain());
		addSequential(new ElevatorReverse(0.4), 3.33);
		addSequential(new ElevatorReverse(.15), 0.5);
		addSequential(new OuttakeCube(), 2);
		addSequential(new ElevatorReverse(0), .5);
		addSequential(new ElevatorReverse(.2), .25);
		addSequential(new ElevatorReverse(0), .5);
		addSequential(new ElevatorReverse(.2), .25);
		addSequential(new ElevatorReverse(0), .5);
		addSequential(new ElevatorReverse(.2), .25);
		addSequential(new ElevatorReverse(0), .5);
		addSequential(new ElevatorReverse(.2), .25);
		addSequential(new ElevatorReverse(0), .5);
		addSequential(new ElevatorReverse(.2), .25);
		addSequential(new ElevatorReverse(0), .5);
		
	}

	private void startRightGoLeft() {
		Path path = new Path(Robot.drivetrain);
		path.addStraightAway(50);
		path.addRotation(-90);
		
		Path path2 = new Path(Robot.drivetrain);
		path2.addStraightAway(100);
		
		Path path3 = new Path(Robot.drivetrain);
		path3.addStraightAway(-16);
		path3.addRotation(90);
		
		addSequential(new FollowPathCommand(path));
		addSequential(new FollowPathCommand(path2));
		addSequential(new FollowPathCommand(path3));
		addSequential(new StopDrivetrain());
	
	}

	private void startCenterGoRight() {
	}

	private void startCenterGoLeft() {
	}
	
	private void startLeftGoRight() {
		Path path = new Path(Robot.drivetrain);
		path.addStraightAway(50);
		path.addRotation(90);
		
		Path path2 = new Path(Robot.drivetrain);
		path2.addStraightAway(100);
		
		Path path3 = new Path(Robot.drivetrain);
		path3.addStraightAway(-16);
		path3.addRotation(-90);
		
		addSequential(new FollowPathCommand(path));
		addSequential(new FollowPathCommand(path2));
		addSequential(new FollowPathCommand(path3));
		addSequential(new StopDrivetrain());
	
	}

	private void startLeftGoLeft() {
		Path path = new Path(Robot.drivetrain);
		path.addStraightAway(80);
		path.addRotation(90);
		
		Path path2 = new Path(Robot.drivetrain);
		path2.addStraightAway(-30);

		Path path3 = new Path(Robot.drivetrain);
		path3.addStraightAway(22);

		addSequential(new ToggleCubePossession());
		addSequential(new ToggleElevatorUse());
		addSequential(new FollowPathCommand(path));
		addSequential(new FollowPathCommand(path2), 2.5);
		addSequential(new FollowPathCommand(path3));
		addSequential(new StopDrivetrain());
		addSequential(new ElevatorReverse(0.4), 3.33);
		addSequential(new ElevatorReverse(.15), 0.5);
		addSequential(new OuttakeCube(), 2);
		addSequential(new ElevatorReverse(0), .5);
		addSequential(new ElevatorReverse(.2), .25);
		addSequential(new ElevatorReverse(0), .5);
		addSequential(new ElevatorReverse(.2), .25);
		addSequential(new ElevatorReverse(0), .5);
		addSequential(new ElevatorReverse(.2), .25);
		addSequential(new ElevatorReverse(0), .5);
		addSequential(new ElevatorReverse(.2), .25);
		addSequential(new ElevatorReverse(0), .5);
		addSequential(new ElevatorReverse(.2), .25);
		addSequential(new ElevatorReverse(0), .5);
	}

	@Override
	public void init() {
		char start = Robot.startingPos;
		char switc = Robot.plateStates[1];

		Robot.drivetrain.speed = 0.6;

		System.out.println("Start: " + start);
		System.out.println("Switch: " + switc);

			switch (start) {

			case 'L':
				if (switc == 'L')
					startLeftGoLeft();
				if (switc == 'R')
					startLeftGoRight();
				break;

			case 'C':
				addSequential(new AutoBaselineCommand());
				break;

			case 'R':
				if (switc == 'L')
					startRightGoLeft();
				if (switc == 'R')
					startRightGoRight();
				break;

			}
	}
}
