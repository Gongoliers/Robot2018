package org.usfirst.frc.team5112.robot.subsystems;

import org.usfirst.frc.team5112.robot.*;
import org.usfirst.frc.team5112.robot.commands.drivetrain.*;

import com.thegongoliers.output.PID;
import com.thegongoliers.pathFollowing.SmartDriveTrainSubsystem;
import com.thegongoliers.input.JoystickTransformer;
import com.thegongoliers.math.Filter;
import com.thegongoliers.math.LowPassFilter;
import com.thegongoliers.math.RateLimiter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The Drivetrain subsystem controls the chassis and wheels
 * that acutally move the entire body of the robot.
 */
public class Drivetrain extends SmartDriveTrainSubsystem {
	private final DifferentialDrive diffDrive = RobotMap.diffDrive;
	public double throttle = 0.6;
	public double turningThrottle = 0.7;
	public double MIN_TURNING_THROTTLE = 0.7;
	public double MAX_TURNING_THROTTLE = 0.9;
	public double MIN_THROTTLE = 0.6;
	public double MAX_THROTTLE = 0.9;
	public double speed = 0;
	public double interval = 0.05;
	public double maxrate = 0.01;
	public double filtercoef = 0.4;
	public int type = 0;
	public Filter ratelimiter = new RateLimiter(maxrate);
	public Filter lowpass = new LowPassFilter(filtercoef);
	

	public void initDefaultCommand() {
		setDefaultCommand(new OperatorControlDrivetrain());
	}

	//Moves drivetain forward at speed
	public void forwards(double speed) {
		diffDrive.arcadeDrive(-speed, 0);
	}

	//Moves drivetrain backwards at speed
	public void backwards(double speed) {
		forwards(-speed);
	}

	//Rotates drivetrain clockwise at speed
	public void rotateClockwise(double speed) {
		diffDrive.arcadeDrive(0, speed);
	}

	//Rotates drivetrain counterclockwise at speed
	public void rotateCounterclockwise(double speed) {
		rotateClockwise(-speed);
	}

	//Stops the drivetrain
	public void stop() {
		diffDrive.stopMotor();
	}

	//Adds a speed to the speed of the drivetrain (used by forwards+backwards+rotateCW+rotateCCW commands)
	public void setSpeed(double inte) {
		if ((speed + inte) >= 1.0) {
			speed = 1.0;
		} else if ((speed + inte) <= 0) {
			speed = 0;
		} else {
			speed += inte;
		}
		SmartDashboard.putNumber("Drivetrain Speed: ", speed);
		SmartDashboard.putNumber("Left Encoder Raw", RobotMap.encoderLeft.getRaw());
		SmartDashboard.putNumber("Left Encoder Distance", RobotMap.encoderLeft.getDistance());
		SmartDashboard.putNumber("Left Encoder Get", RobotMap.encoderLeft.get());
		SmartDashboard.putNumber("Left Encoder Rate", RobotMap.encoderLeft.getRate());
	}

	//Sets the multiplier all sleep values are multiplied by in Operator Control
	public void setTurbo(Joystick joystick, LogitechController controller) {
		if (joystick.getRawButton(1) || controller.getRawButton(6)) {
			throttle = MAX_THROTTLE;
			turningThrottle = MAX_TURNING_THROTTLE;
		} else {
			throttle = MIN_THROTTLE;
			turningThrottle = MIN_TURNING_THROTTLE;
		}
	}
	
	//Changes which joystick/controller is used to control drivetrain's operator control method
	public void changeControllerType() {
		if (type == 0) {
			type = 1;
		} else {
			type = 0;
		}
	}

	//Allows the operator to control the drivetrain in teleop
	public void operatorControl(Joystick joystick, LogitechController controller, int type) {
		SmartDashboard.putNumber("Left Encoder Raw", RobotMap.encoderLeft.getRaw());
		SmartDashboard.putNumber("Left Encoder Distance", RobotMap.encoderLeft.getDistance());
		SmartDashboard.putNumber("Left Encoder Get", RobotMap.encoderLeft.get());
		SmartDashboard.putNumber("Left Encoder Rate", RobotMap.encoderLeft.getRate());
//		SmartDashboard.putNumber("Right Encoder Distance", RobotMap.encoderRight.getRaw());
		
			setTurbo(joystick, controller);
			double speed = JoystickTransformer.deadzone(joystick.getY(), 0.1);
			speed = (speed - 0.1)*10/9.0;
			speed = JoystickTransformer.sensitivity(speed,throttle);
			speed = lowpass.filter(speed);
			speed = ratelimiter.filter(speed);
			diffDrive.arcadeDrive(speed, joystick.getZ() * -1 * turningThrottle);
//			if (joystick.getY() > 0.1 || joystick.getY() < -0.1) {
//				diffDrive.arcadeDrive((joystick.getY() - 0.1) * 10 / 9 * throttle,  joystick.getZ() * -1 * turningThrottle);
//			} else {
//				diffDrive.arcadeDrive(0, joystick.getZ() * -1 * turningThrottle);
//			}
		}
		

	@Override
	public double getAngle() {
		return RobotMap.gyro.getAngle();
	}

	@Override
	public PID getDriveDistancePID() {
		return new PID(0.1, 0, 0, 0.01); // TODO: tune this!
	}

	@Override
	public double getLeftDistance() {
		// TODO Auto-generated method stub
		return RobotMap.encoderLeft.getDistance();
	}

	@Override
	public double getRightDistance() {
		// TODO Auto-generated method stub
		return RobotMap.encoderRight.getDistance();
	}

	@Override
	public PID getRotateAnglePID() {
		return new PID(0.1, 0, 0, 0.01); // TODO: tune this!
	}

	@Override
	public void resetEncoders() {
		RobotMap.encoderLeft.reset();
		RobotMap.encoderRight.reset();
	}

	@Override
	public void resetGyro() {
		RobotMap.gyro.reset();
	}

	@Override
	public void arcade(double arg0, double arg1) {
		diffDrive.arcadeDrive(arg0, arg1);
	}

	@Override
	public void backward(double arg0) {
		backwards(arg0);
	}

	@Override
	public void forward(double arg0) {
		forwards(arg0);
	}

	@Override
	public void rotateLeft(double arg0) {
		rotateCounterclockwise(arg0);
	}

	@Override
	public void rotateRight(double arg0) {
		rotateClockwise(arg0);
	}

	@Override
	public void tank(double arg0, double arg1) {
		// TODO Auto-generated method stub
		diffDrive.tankDrive(arg0, arg1);
	}
}
