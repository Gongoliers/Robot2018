package org.usfirst.frc.team5112.robot.subsystems;

import org.usfirst.frc.team5112.robot.RobotMap;
import org.usfirst.frc.team5112.robot.commands.intake.OperatorControlIntake;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The Intake subsystem controls the intake wheels on the third stage of the
 * elevator and the intake wheels attached to the chassis of the robot.
 */

public class Intake extends Subsystem {

	public static SpeedControllerGroup motorController = RobotMap.intakeMotorController;
	public static SpeedControllerGroup innerMotorController = RobotMap.intakeInnerMotorController;
	public static SpeedControllerGroup outerMotorController = RobotMap.intakeOuterMotorController;
	public static VictorSP leftInnerMotorController = RobotMap.intakeLeftInnerMotorController;
	public static VictorSP rightInnerMotorController = RobotMap.intakeRightInnterMotorControler;
	public static VictorSP leftOuterMotorController = RobotMap.intakeLeftOuterMotorController;
	public static VictorSP rightOuterMotorController = RobotMap.intakeRightOuterMotorController;
	public double interval = 0.05;
	public double speed = 0.00;
	public double multiplier = 0.6;
	public double outerMultiplier = 0.5;
	public double innerMultiplier = 1;
	public double rotateMultiplier = 0.5;
	public double elevatorJoystickMultiplier = 0.05;

	public void initDefaultCommand() {
		setDefaultCommand(new OperatorControlIntake());
	}

	// Stops the intake wheels
	public void stop() {
		motorController.stopMotor();
	}

	public void counterclockwise(double speed) {
		rightInnerMotorController.set(-speed);
		rightOuterMotorController.set(-speed * outerMultiplier);
		leftInnerMotorController.set(speed);
		leftOuterMotorController.set(speed * outerMultiplier);
	}

	public void clockwise(double speed) {
		counterclockwise(-speed);
	}

	// Runs the intake wheels to take in objects
	public void in(double speed) {
		innerMotorController.set(-speed);
		outerMotorController.set(-speed * outerMultiplier);
	}

	// Runs the intake wheels to spit objects out
	public void out(double speed) {
		in(-speed);
	}

	// Adds a value to the intake's speed (for intake+outtake commands)
	public void changeSpeed(double interval) {
		if (speed + interval >= 1.0) {
			speed = 1.0;
			SmartDashboard.putNumber("Intake Speed :", speed);
			SmartDashboard.putNumber("Outer Intake Speed :", speed * outerMultiplier);
		} else if (speed + interval <= 0) {
			speed = 0.0;
			SmartDashboard.putNumber("Intake Speed :", speed);
			SmartDashboard.putNumber("Outer Intake Speed :", speed * outerMultiplier);
		} else {
			speed += interval;
			SmartDashboard.putNumber("Intake Speed :", speed);
			SmartDashboard.putNumber("Outer Intake Speed :", speed * outerMultiplier);
		}
	}

	// Allows xbox controller's right joystick's Y movement to control intake wheels
	// in teleop
	public void OperatorControl(XboxController xboxController, Joystick joystick) {
		if (xboxController.getXButton()) {
			if (xboxController.getRawAxis(1) > 0.1) {
				innerMotorController.set(xboxController.getRawAxis(1));
				outerMotorController.set(xboxController.getRawAxis(1));
			} else if (xboxController.getRawAxis(1) < -0.1) {
				innerMotorController.set(xboxController.getRawAxis(1) * innerMultiplier);
				outerMotorController.set(xboxController.getRawAxis(1) * outerMultiplier);
			} else if (xboxController.getRawAxis(0) < -0.1) {
				clockwise(xboxController.getRawAxis(0) * rotateMultiplier);
			} else if (xboxController.getRawAxis(0) > 0.1) {
				counterclockwise(xboxController.getRawAxis(0) * rotateMultiplier*-1);
			} else if (joystick.getY() > 0.1) {
				counterclockwise(joystick.getY() * elevatorJoystickMultiplier * -1 - 0.1);
			} else {
				motorController.stopMotor();
			}
		}
		else {
			if (xboxController.getRawAxis(1) > 0.1) {
				outerMotorController.set(xboxController.getRawAxis(1));
			} else if (xboxController.getRawAxis(1) < -0.1) {
				outerMotorController.set(xboxController.getRawAxis(1) * innerMultiplier);
			} else if (xboxController.getRawAxis(0) < -0.1) {
				clockwise(xboxController.getRawAxis(0) * rotateMultiplier);
			} else if (xboxController.getRawAxis(0) > 0.1) {
				clockwise(xboxController.getRawAxis(0) * rotateMultiplier);
			} else if (joystick.getY() > 0.1) {
				out(joystick.getY() * elevatorJoystickMultiplier * -1 - 0.1);
			} else {
				motorController.stopMotor();
			}
		}

		}
	}
