package org.usfirst.frc.team5112.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class RobotMap {
	public static VictorSP leftDrivetrainMotorController;
	public static VictorSP rightDrivetrainMotorController;
	public static VictorSP intakeLeftOuterMotorController;
	public static VictorSP intakeRightOuterMotorController;
	public static VictorSP intakeLeftInnerMotorController;
	public static VictorSP intakeRightInnterMotorControler;
	public static VictorSP elevatorLeftMotorController;
	public static VictorSP elevatorRightMotorController;
	public static VictorSP climberLeftMotorController;
	public static VictorSP climberRightMotorController;
	
	public static SpeedControllerGroup climberMotorController;
	public static SpeedControllerGroup elevatorMotorController;
	public static SpeedControllerGroup intakeInnerMotorController;
	public static SpeedControllerGroup intakeOuterMotorController;
	public static SpeedControllerGroup intakeMotorController;
	
	public static Encoder encoderLeft;
	public static Encoder encoderRight;
	
	public static Gyro gyro;
	
	public static DifferentialDrive diffDrive;

	public static Solenoid gripper;
    
	public static void init(){
		leftDrivetrainMotorController = new VictorSP(0);
		rightDrivetrainMotorController = new VictorSP(1);
		intakeLeftOuterMotorController = new VictorSP(2);
		intakeRightOuterMotorController = new VictorSP(3);
		intakeLeftInnerMotorController = new VictorSP(4);
		intakeRightInnterMotorControler = new VictorSP(5);
		elevatorLeftMotorController = new VictorSP(6);
		elevatorRightMotorController = new VictorSP(7);
		climberLeftMotorController = new VictorSP(8);
		climberRightMotorController = new VictorSP(9);
		
		encoderLeft = new Encoder(1, 2);
		encoderRight = new Encoder(3, 4);
		encoderLeft.setDistancePerPulse(1); // TODO: set to recommended values - IN INCHES
		encoderRight.setDistancePerPulse(1); // TODO: set to recommended values - IN INCHES
		
		gyro = new AnalogGyro(0);
		gyro.calibrate();
		
		leftDrivetrainMotorController.setInverted(true);
		rightDrivetrainMotorController.setInverted(true);
		diffDrive = new DifferentialDrive(leftDrivetrainMotorController, rightDrivetrainMotorController);
		diffDrive.setSafetyEnabled(false);
		diffDrive.setExpiration(0.1);
		diffDrive.setMaxOutput(1.0);
		
		climberLeftMotorController.setInverted(false);
		climberRightMotorController.setInverted(true);
		climberMotorController = new SpeedControllerGroup(climberLeftMotorController, climberRightMotorController);
		
		elevatorLeftMotorController.setInverted(false);
		elevatorRightMotorController.setInverted(true);
		elevatorMotorController = new SpeedControllerGroup(elevatorLeftMotorController, elevatorRightMotorController);
		
		intakeLeftInnerMotorController.setInverted(false);
		intakeRightInnterMotorControler.setInverted(true);
		intakeInnerMotorController = new SpeedControllerGroup(intakeLeftInnerMotorController, intakeRightInnterMotorControler);
		
		intakeLeftOuterMotorController.setInverted(true);
		intakeRightOuterMotorController.setInverted(true);
		intakeOuterMotorController = new SpeedControllerGroup(intakeLeftOuterMotorController, intakeRightOuterMotorController);
		
		intakeMotorController = new SpeedControllerGroup(intakeInnerMotorController, intakeOuterMotorController);
		
        gripper = new Solenoid(0);	
	}
}