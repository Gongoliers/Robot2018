package org.usfirst.frc.team5112.robot.commands.commandGroups;

import org.usfirst.frc.team5112.robot.Robot;
import org.usfirst.frc.team5112.robot.commands.drivetrain.Forwards;
import org.usfirst.frc.team5112.robot.commands.elevator.RaiseToScale;
import org.usfirst.frc.team5112.robot.commands.gripper.OpenGripper;

import com.thegongoliers.pathFollowing.FollowPathCommand;
import com.thegongoliers.pathFollowing.Path;

//import com.thegongoliers.pathFollowing.FollowPathCommand;
//import com.thegongoliers.pathFollowing.Path;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Places a pre-loaded power cube into the scale.
 * @author Nicholas Bottone
 */
public class AutoScaleCommand extends AutoCommand {

    private void startLeftGoLeft() {
    	Path path = new Path(Robot.drivetrain);
    	path.addStraightAway(16);
    	path.addRotation(-90);
    	path.addStraightAway(.5); // TODO: Ask Rob about distance units (shoes)
    	path.addRotation(90);
    	path.addStraightAway(308);
    	path.addRotation(90);
    	
    	addSequential(new FollowPathCommand(path));
    	addSequential(new RaiseToScale());
    	addSequential(new Forwards(), 1); // TODO: Calibrate this speed and this time amount
    	addSequential(new OpenGripper());
    }
    
    private void startCenterGoLeft() {
    	Path path = new Path(Robot.drivetrain);
    	path.addStraightAway(16);
    	path.addRotation(-90);
    	path.addStraightAway(323.38); // TODO: Ask Rob about distance units (shoes)
    	path.addRotation(90);
    	path.addStraightAway(308);
    	path.addRotation(90);
    	
    	addSequential(new FollowPathCommand(path));
    	addSequential(new RaiseToScale());
    	addSequential(new Forwards(), 1); // TODO: Calibrate this speed and this time amount
    	addSequential(new OpenGripper());
    }
    
    private void startRightGoLeft() {
    	// TODO: Ask Rob
    	Path path = new Path(Robot.drivetrain);
    	path.addStraightAway(16);
    	path.addRotation(-90);
    	path.addStraightAway(254.11 + 200); // TODO: Ask Rob about distance units (shoes)
    	path.addRotation(90);
    	path.addStraightAway(308); // TODO: Ask ROB????? 108 vs 308?
    	path.addRotation(90);
    	
    	addSequential(new FollowPathCommand(path));
    	addSequential(new RaiseToScale());
    	addSequential(new Forwards(), 1); // TODO: Calibrate this speed and this time amount
    	addSequential(new OpenGripper());
    }
    
    private void startLeftGoRight() {
    	// TODO: Ask Rob
    	Path path = new Path(Robot.drivetrain);
    	path.addStraightAway(16);
    	path.addRotation(90);
    	path.addStraightAway(254.11 + 200); // TODO: Ask Rob about distance units (shoes)
    	path.addRotation(-90);
    	path.addStraightAway(308); // TODO: Ask ROB?????
    	path.addRotation(-90);
    	
    	addSequential(new FollowPathCommand(path));
    	addSequential(new RaiseToScale());
    	addSequential(new Forwards(), 1.5); // TODO: Calibrate this speed and this time amount
    	addSequential(new OpenGripper());
    }
    
    private void startCenterGoRight() {
    	// TODO: Ask Rob
    	Path path = new Path(Robot.drivetrain);
    	path.addStraightAway(16);
    	path.addRotation(90);
    	path.addStraightAway(323.38); // TODO: Ask Rob about distance units (shoes)
    	path.addRotation(-90);
    	path.addStraightAway(308);
    	path.addRotation(-90);
    	
    	addSequential(new FollowPathCommand(path));
    	addSequential(new RaiseToScale());
    	addSequential(new Forwards(), 1.5); // TODO: Calibrate this speed and this time amount
    	addSequential(new OpenGripper());
    }
    
    private void startRightGoRight() {
    	// TODO: Ask Rob
    	Path path = new Path(Robot.drivetrain);
    	path.addStraightAway(16);
    	path.addRotation(90);
    	path.addStraightAway(.5); // TODO: Ask Rob about distance units (shoes)
    	path.addRotation(-90);
    	path.addStraightAway(308); // TODO: Ask ROB?????
    	path.addRotation(-90);
    	
    	addSequential(new FollowPathCommand(path));
    	addSequential(new RaiseToScale());
    	addSequential(new Forwards(), 1.5); // TODO: Calibrate this speed and this time amount
    	addSequential(new OpenGripper());
    }

	@Override
	public void init() {
//		char start = Robot.startingPos;
//    	char scale = Robot.plateStates[1];
//    	
//    	switch (start) {
//    	
//    	case 'L':
//    		if (scale == 'L') startLeftGoLeft();
//    		if (scale == 'R') startLeftGoRight();
//    		break;
//    	
//    	case 'C':
//    		if (scale == 'L') startCenterGoLeft();
//    		if (scale == 'R') startCenterGoRight();
//    		break;
//    	
//    	case 'R':
//    		if (scale == 'L') startRightGoLeft();
//    		if (scale == 'R') startRightGoRight();
//    		break;
//    	
//    	}
	}
    
}
