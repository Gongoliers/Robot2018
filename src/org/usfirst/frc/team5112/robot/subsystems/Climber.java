package org.usfirst.frc.team5112.robot.subsystems;

import org.usfirst.frc.team5112.robot.RobotMap;
import org.usfirst.frc.team5112.robot.commands.climber.OperatorControlClimber;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Climber subsystem controls the winch that the climber uses.
 */
public class Climber extends Subsystem {

	public static SpeedControllerGroup motorController = RobotMap.climberMotorController;
	
    public void initDefaultCommand() {
    	setDefaultCommand(new OperatorControlClimber());
    }
    
    //Rotates climber winch clockwise
    public void rotateClockwise(double speed) {
    	motorController.set(speed);
    }
    
    //Rotates climber winch counterclockwise
    public void rotateCounterclockwise(double speed) {
    	rotateClockwise(-speed);
    }
    
    //Stops climber winch
    public void stop() {
    	motorController.stopMotor();
    }
    
    //Allows climber winch to be controller by xbox controller's left joystick's Y movement in teleop
    public void operatorControl(edu.wpi.first.wpilibj.XboxController xboxController) {
    	if (xboxController.getRawAxis(5) > 0.1 || xboxController.getRawAxis(5) < -0.1) {
			motorController.set(xboxController.getRawAxis(5));
		} else {
			motorController.stopMotor();
		}
    }
}

