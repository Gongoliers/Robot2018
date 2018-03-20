package org.usfirst.frc.team5112.robot.commands.commandGroups;

import org.usfirst.frc.team5112.robot.Robot;
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
public class AutoSwitchCommand extends AutoCommand {

	boolean conservativeMode = true;

	private void startRightGoRight() {
		Path path = new Path(Robot.drivetrain);
		path.addStraightAway(16);
		path.addRotation(90);
		path.addStraightAway(67.5);
		path.addRotation(-90);

		Path path2 = new Path(Robot.drivetrain);
		path2.addStraightAway(136);

		addSequential(new ToggleCubePossession());
		addSequential(new ToggleElevatorUse());
		addSequential(new FollowPathCommand(path));
		addSequential(new ElevatorReverse(0.4), 1.5);
		addSequential(new ElevatorReverse(.15), 1.5);
		addSequential(new FollowPathCommand(path2));
		addSequential(new StopDrivetrain());
		addSequential(new OuttakeCube(), 3);
	}

	private void startRightGoLeft() {
		Path path = new Path(Robot.drivetrain);
		path.addStraightAway(16);
		path.addRotation(-90);
		path.addStraightAway(137.5);
		path.addRotation(90);

		Path path2 = new Path(Robot.drivetrain);
		path2.addStraightAway(136);

		addSequential(new ToggleCubePossession());
		addSequential(new ToggleElevatorUse());
		addSequential(new FollowPathCommand(path));
		addSequential(new ElevatorReverse(0.4), 1.5);
		addSequential(new ElevatorReverse(.15), 1.5);
		addSequential(new FollowPathCommand(path2));
		addSequential(new StopDrivetrain());
		addSequential(new OuttakeCube(), 3);
	}

	private void startCenterGoRight() {
		Path path = new Path(Robot.drivetrain);
		path.addStraightAway(16);
		path.addRotation(90);
		path.addStraightAway(28);
		path.addRotation(-90);

		Path path2 = new Path(Robot.drivetrain);
		path2.addStraightAway(136);

		addSequential(new ToggleCubePossession());
		addSequential(new ToggleElevatorUse());
		addSequential(new FollowPathCommand(path));
		addSequential(new ElevatorReverse(0.4), 1.5);
		addSequential(new ElevatorReverse(.15), 1.5);
		addSequential(new FollowPathCommand(path2));
		addSequential(new StopDrivetrain());
		addSequential(new OuttakeCube(), 3);
	}

	private void startCenterGoLeft() {
		Path path = new Path(Robot.drivetrain);
		path.addStraightAway(16);
		path.addRotation(-90);
		path.addStraightAway(30.5);
		path.addRotation(90);

		Path path2 = new Path(Robot.drivetrain);
		path2.addRotation(136);

		addSequential(new ToggleCubePossession());
		addSequential(new ToggleElevatorUse());
		addSequential(new FollowPathCommand(path));
		addSequential(new ElevatorReverse(0.4), 1.5);
		addSequential(new ElevatorReverse(.15), 1.5);
		addSequential(new FollowPathCommand(path2));
		addSequential(new StopDrivetrain());
		addSequential(new OuttakeCube(), 3);
	}

	private void startLeftGoRight() {
		Path path = new Path(Robot.drivetrain);
		path.addStraightAway(16);
		path.addRotation(90);
		path.addStraightAway(137.5);
		path.addRotation(-90);

		Path path2 = new Path(Robot.drivetrain);
		path2.addStraightAway(136);

		addSequential(new ToggleCubePossession());
		addSequential(new ToggleElevatorUse());
		addSequential(new FollowPathCommand(path));
		addSequential(new ElevatorReverse(0.4), 1.5);
		addSequential(new ElevatorReverse(.15), 1.5);
		addSequential(new FollowPathCommand(path2));
		addSequential(new StopDrivetrain());
		addSequential(new OuttakeCube(), 3);
	}

	private void startLeftGoLeft() {
		Path path = new Path(Robot.drivetrain);
		path.addStraightAway(16);
		path.addRotation(90);
		path.addStraightAway(38);
		path.addRotation(-90);

		Path path2 = new Path(Robot.drivetrain);
		path2.addStraightAway(136);

		addSequential(new ToggleCubePossession());
		addSequential(new ToggleElevatorUse());
		addSequential(new FollowPathCommand(path));
		addSequential(new ElevatorReverse(0.4), 1.5);
		addSequential(new ElevatorReverse(.15), 1.5);
		addSequential(new FollowPathCommand(path2));
		addSequential(new StopDrivetrain());
		addSequential(new OuttakeCube(), 3);
	}

	@Override
	public void init() {
		char start = Robot.startingPos;
		char switc = Robot.plateStates[0];

		Robot.drivetrain.speed = 0.6;

		System.out.println("Start: " + start);
		System.out.println("Switch: " + switc);

		if (conservativeMode) {
			System.out.println("Conservative mode...");
			if (start == switc) {
				System.out.println("Go for switch");
				addSequential(new ToggleCubePossession());
				addSequential(new ToggleElevatorUse());
				addSequential(new ElevatorReverse(0.4), 1.5);
				addSequential(new ElevatorReverse(.15), 1.5);
				addSequential(new Forwards(), 3);
				addSequential(new StopDrivetrain());
				addSequential(new OuttakeCube(), 3);

			} else {
				System.out.println("Baseline only");
				addSequential(new ToggleCubePossession());
				addSequential(new ToggleElevatorUse());
				addSequential(new ElevatorReverse(0.4), 1.5);
				addSequential(new ElevatorReverse(.15), 1);
				addSequential(new Forwards(), 3);
				addSequential(new StopDrivetrain());

			}
		}

		if (!conservativeMode)
			switch (start) {

			case 'L':
				if (switc == 'L')
					startLeftGoLeft();
				if (switc == 'R')
					startLeftGoRight();
				break;

			case 'C':
				if (switc == 'L')
					startCenterGoLeft();
				if (switc == 'R')
					startCenterGoRight();
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
