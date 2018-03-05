package org.usfirst.frc.team5112.robot.subsystems;

import org.usfirst.frc.team5112.robot.RobotMap;
import org.usfirst.frc.team5112.robot.commands.gripper.OpenGripper;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gripper extends Subsystem {

	public Solenoid gripperSolenoid = RobotMap.gripper;
	
    public void initDefaultCommand() {
    	setDefaultCommand(new OpenGripper());
    }
    
    public void openGripper() {
    	gripperSolenoid.set(false);
    }
    
    public void closeGripper() {
    	gripperSolenoid.set(true);
    }
    
}