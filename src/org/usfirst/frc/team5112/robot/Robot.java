package org.usfirst.frc.team5112.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5112.robot.commands.*;
import org.usfirst.frc.team5112.robot.commands.commandGroups.AutoBaselineCommand;
import org.usfirst.frc.team5112.robot.commands.commandGroups.AutoCommand;
import org.usfirst.frc.team5112.robot.commands.commandGroups.AutoScaleCommand;
import org.usfirst.frc.team5112.robot.commands.commandGroups.AutoSwitchCommand;
import org.usfirst.frc.team5112.robot.commands.commandGroups.StopEverything;
import org.usfirst.frc.team5112.robot.subsystems.*;

public class Robot extends TimedRobot {
	public static OI m_oi;
	public static Drivetrain drivetrain;
	public static Elevator   elevator;
	public static Climber    climber;
	public static Intake     intake;
	public static Gripper gripper;
	
	public static String gameData;
	public static char[] plateStates; // 'L' if left, 'R' if right
	public static char startingPos; // 'L' if left, 'C' if center, 'R' if right
	
	AutoCommand m_autonomousCommand;
	SendableChooser<AutoCommand> m_chooser = new SendableChooser<>();
	SendableChooser<String> startPosition_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
//		Compressor myCompressor = new Compressor(0);
//		myCompressor.setClosedLoopControl(true);
	    RobotMap.init();
		
	    drivetrain = new Drivetrain();
		elevator   = new Elevator  ();
		climber    = new Climber   ();
        gripper    = new Gripper   ();
		intake     = new Intake    ();
		m_oi       = new OI        ();
		
		startPosition_chooser.addDefault("Left Driver Station", "L");
		startPosition_chooser.addObject("Center Driver Station", "C");
		startPosition_chooser.addObject("Right Driver Station", "R");
		SmartDashboard.putData("Starting Position", startPosition_chooser);
		
		m_chooser.addDefault("Do Nothing", new StopEverything());
		m_chooser.addDefault("Switch Auto", new AutoSwitchCommand());     // TODO: Give the command the data it needs (starting position & plate state)
//		m_chooser.addObject("Scale Auto", new AutoScaleCommand());       // TODO: Give the command the data it needs (starting position & plate state)
		m_chooser.addObject("Baseline Auto", new AutoBaselineCommand());
		SmartDashboard.putData("Auto Mode", m_chooser);
		
		UsbCamera camera1 = CameraServer.getInstance().startAutomaticCapture(0);
		camera1.setResolution(320, 240);
		camera1.setBrightness(50);
		camera1.setExposureAuto();
		UsbCamera camera2 = CameraServer.getInstance().startAutomaticCapture(1);
		camera2.setResolution(320, 240);
		camera2.setBrightness(50);
		camera2.setExposureAuto();

	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();
		startingPos = startPosition_chooser.getSelected().charAt(0);
		
		System.out.println(startingPos);
		
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData.length() >= 3) 
			plateStates = new char[] {gameData.charAt(0), gameData.charAt(1), gameData.charAt(2)};
		
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */
		
		if (m_autonomousCommand != null) {
			m_autonomousCommand.init();
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		
	}
}
