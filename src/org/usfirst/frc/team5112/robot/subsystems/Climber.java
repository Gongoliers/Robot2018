package org.usfirst.frc.team5112.robot.subsystems;

import org.usfirst.frc.team5112.robot.LogitechController;
import org.usfirst.frc.team5112.robot.RobotMap;
import org.usfirst.frc.team5112.robot.commands.climber.OperatorControlClimber;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The Climber subsystem controls the winch that the climber uses.
 */
public class Climber extends Subsystem {

	public static VictorSP bottomMotorController = RobotMap.climberBottomMotorController;
	public static VictorSP topMotorController = RobotMap.climberTopMotorController;

	public void initDefaultCommand() {
		setDefaultCommand(new OperatorControlClimber());
	}

	// Rotates climber winch clockwise
	public void rotateTopClockwise(double speed) {
		topMotorController.set(speed);
	}

	// Rotates climber winch counterclockwise
	public void rotateTopCounterclockwise(double speed) {
		rotateTopClockwise(-speed);
	}

	// Stops climber winch
	public void stopTop() {
		topMotorController.stopMotor();
	}

	// Rotates climber winch clockwise
	public void rotateBottomClockwise(double speed) {
		topMotorController.set(speed);
	}

	// Rotates climber winch counterclockwise
	public void rotateBottomCounterclockwise(double speed) {
		rotateTopClockwise(-speed);
	}

	// Stops climber winch
	public void stopBottom() {
		topMotorController.stopMotor();
	}

	// Allows climber winch to be controller by xbox controller's left joystick's Y
	// movement in teleop
	public void operatorControl(LogitechController controller) {
		if (controller.getRawButton(4)) {
			topMotorController.set(0.3);
		} else if (controller.getRawButton(1)) {
			topMotorController.set(-0.3);
		} else {
			topMotorController.stopMotor();
		}
		if(controller.getPOV() == 0) {
			bottomMotorController.set(0.3);
		} else if (controller.getPOV() == 180) {
			bottomMotorController.set(-0.3);
		} else {
			bottomMotorController.stopMotor();
		}
	}
}
