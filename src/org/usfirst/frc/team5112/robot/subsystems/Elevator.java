package org.usfirst.frc.team5112.robot.subsystems;

import org.usfirst.frc.team5112.robot.RobotMap;
import org.usfirst.frc.team5112.robot.commands.elevator.OperatorControlElevator;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The Elevator subsytem controls the winch on the elevator.
 */
public class Elevator extends Subsystem {

	public static SpeedControllerGroup motorController = RobotMap.elevatorMotorController;
	public static double noCubeSpeedConstant = 0.15;
	public static double withCubeSpeedConstant = 0.19;
	public static double multiplier = 0;
	public static double elevatorConstant = noCubeSpeedConstant;
	
    public void initDefaultCommand() {
    	setDefaultCommand(new OperatorControlElevator());
    }
    
    //Stops the elevator winch
    public void stop() {
    	motorController.stopMotor();
    }
    
    //Rotates the elevator winch clockwise
    public void rotateClockwise(double speed) {
    	motorController.set(speed);
    }
    
    //Rotates the elevator winch counterclockwise
    public void rotateCounterClockwise(double speed) {
    	rotateClockwise(-speed);
    }
    
    public void switchElevatorMoveState() {
    	if (multiplier == 0) {
			multiplier = 1;
		} else {
			multiplier = 0;
		}
    	updateSmartDashboardElevator();
    }
    
    public void cubeStateChange() {
    	if (elevatorConstant == withCubeSpeedConstant) {
			elevatorConstant = noCubeSpeedConstant;
		} else  {
			elevatorConstant = withCubeSpeedConstant;
		}
    	updateSmartDashboardElevator();
    }
    
    public void updateSmartDashboardElevator() {
    	SmartDashboard.putNumber("Elevator Constant: ", elevatorConstant);
    	SmartDashboard.putNumber("Elevator Muliplier: ", multiplier);
		if (elevatorConstant == noCubeSpeedConstant) {
			SmartDashboard.putBoolean("Possesses Cube: ", false);
		} else {
			SmartDashboard.putBoolean("Possesses Cube: ", true);
		}
		if (multiplier == 0) {
			SmartDashboard.putBoolean("Is getting power: ", false);
		} else {
			SmartDashboard.putBoolean("Is getting power: ", true);
		}
    }
    //Allows elevator winch to be controllerd by joystickAttack in teleop
    public void operatorControl(Joystick joystick) {
    	if (joystick.getY() > 0.05) {
    		motorController.set((joystick.getY()-0.05)*0.85*100/95+elevatorConstant);
    		SmartDashboard.putNumber("Attack Joystick Value: ", joystick.getY());
		} else if (joystick.getY() < -.05) {
    	//	motorController.set((joystick.getY()+0.05)*0.15*100/95+elevatorConstant * 0.5 + 0.075);
    		motorController.set(.05*joystick.getY()*-1);
			SmartDashboard.putNumber("Attack Joystick Value: ", joystick.getY());
		} else {
			motorController.set(0.15 * multiplier);
		}
    }

}

