package org.usfirst.frc.team5112.robot;

import org.usfirst.frc.team5112.robot.commands.*;
import org.usfirst.frc.team5112.robot.commands.climber.*;
import org.usfirst.frc.team5112.robot.commands.commandGroups.AutoBaselineCommand;
import org.usfirst.frc.team5112.robot.commands.commandGroups.AutoScaleCommand;
import org.usfirst.frc.team5112.robot.commands.commandGroups.AutoSwitchCommand;
import org.usfirst.frc.team5112.robot.commands.commandGroups.StopEverything;
import org.usfirst.frc.team5112.robot.commands.drivetrain.*;
import org.usfirst.frc.team5112.robot.commands.elevator.*;
import org.usfirst.frc.team5112.robot.commands.gripper.CloseGripper;
import org.usfirst.frc.team5112.robot.commands.gripper.OpenGripper;
import org.usfirst.frc.team5112.robot.commands.intake.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
	//Joystick + Controller Intializations
	public static Joystick joystickExtreme;
	public static Joystick joystickAttack;
	public static LogitechController logitechController;
	public static edu.wpi.first.wpilibj.XboxController xboxController;

	//Joystick Button Initilization
	public static JoystickButton jB1;
	public static JoystickButton jB2;
	public static JoystickButton jB3;
	public static JoystickButton jB4;
	public static JoystickButton jB5;
	public static JoystickButton jB6;
	public static JoystickButton jB7;
	public static JoystickButton jB8;
	public static JoystickButton jB9;
	public static JoystickButton jB10;
	public static JoystickButton jB11;
	public static JoystickButton jB12;

	public static JoystickButton jAB6;
	public static JoystickButton jAB7;

	public OI() {
		//Joysticks
		joystickExtreme = new Joystick(0);
		joystickAttack  = new Joystick(2);
		
		//Controllers
		logitechController = new LogitechController(1);
		xboxController = new XboxController(3);
		
		//Joystick Extreme's Buttons
		jB1 = new JoystickButton(joystickExtreme, 1);
		jB2 = new JoystickButton(joystickExtreme, 2);
		jB3 = new JoystickButton(joystickExtreme, 3);
		jB4 = new JoystickButton(joystickExtreme, 4);
		jB5 = new JoystickButton(joystickExtreme, 5);
		jB6 = new JoystickButton(joystickExtreme, 6);
		jB7 = new JoystickButton(joystickExtreme, 7);
		jB8 = new JoystickButton(joystickExtreme, 8);
		jB9 = new JoystickButton(joystickExtreme, 9);
		jB10 = new JoystickButton(joystickExtreme, 10);
		jB11 = new JoystickButton(joystickExtreme, 11);
		jB12 = new JoystickButton(joystickExtreme, 12);
		
		jAB6 = new JoystickButton(joystickAttack, 6);
		jAB7 = new JoystickButton(joystickAttack, 7);
			
		jAB6.whenPressed(new ToggleCubePossession());
		jAB7.whenPressed(new ToggleElevatorUse());
		//Climber Commands
		SmartDashboard.putData("Stop Climber", new StopClimber());
		
		logitechController.buttonA.whileHeld(new RunClimbBottomCW());
		logitechController.buttonY.whileHeld(new RunClimbBottomCWW());
		logitechController.buttonStart.whileHeld(new RunClimbTopCW());
		logitechController.buttonBack.whileHeld(new RunClimbTopCWW());
		
		
		//Drivetrain Commands
		SmartDashboard.putData("Drivetrain Backwards", new Backwards());
		SmartDashboard.putData("Drivetrain Forwards", new Forwards());
		SmartDashboard.putData("Decrease Drivetrain Speed", new DecreaseSpeed());
		SmartDashboard.putData("Increase Drivetrain Speed", new IncreaseSpeed());
		SmartDashboard.putData("Rotate Drivetrain Counterclockwise", new RotateCCW());
		SmartDashboard.putData("Rotate Drivetrain Clockwise", new RotateCW());
		SmartDashboard.putData("Stop Drivetrain", new StopDrivetrain());
		
		//Elevator Commands
		SmartDashboard.putData("Lower Elevator To Bottom Position", new LowerToBottom());
		SmartDashboard.putData("Lower Elevator To Switch Position", new LowerToSwitch());
		SmartDashboard.putData("Raise Elevator To Switch", new RaiseToSwitch());
		SmartDashboard.putData("Raise Elevator To Scale", new RaiseToScale());
		SmartDashboard.putData("Raise Elevator To Top", new RaiseToTop());
		SmartDashboard.putData("Toggle Cube Possession", new ToggleCubePossession());
		SmartDashboard.putData("Toggle Elevator Use", new ToggleElevatorUse());
		SmartDashboard.putData("Elevator In Reverse", new ElevatorReverse());
		
		//Intake Commands
		SmartDashboard.putData("Decrease Intake Speed", new DecreaseSpeedIntake());
		SmartDashboard.putData("Increase Intake Speed", new IncreaseSpeedIntake());
		SmartDashboard.putData("Intake", new IntakeCube());
		SmartDashboard.putData("Outtake", new OuttakeCube());
		SmartDashboard.putData("Stop Intake", new StopIntake());
		SmartDashboard.putData("All Intake Counterclockwise", new AllIntakeCounterclockwise());
		SmartDashboard.putData("All Intake Clockwise", new AllIntakeClockwise());
		
		//Command Groups
		SmartDashboard.putData("Autonomous Scale Command", new AutoScaleCommand());
		SmartDashboard.putData("Autonomous Switch Command", new AutoSwitchCommand());
		SmartDashboard.putData("Autonomous Baseline Command", new AutoBaselineCommand());
		SmartDashboard.putData("STOP EVERYTHING", new StopEverything());
		
		//Gripper
		SmartDashboard.putData("Open Gripper", new OpenGripper());
		SmartDashboard.putData("Close Gripper", new CloseGripper());
		
	}

}