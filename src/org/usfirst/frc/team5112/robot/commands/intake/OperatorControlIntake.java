package org.usfirst.frc.team5112.robot.commands.intake;

import org.usfirst.frc.team5112.robot.OI;
import org.usfirst.frc.team5112.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OperatorControlIntake extends Command {

    public OperatorControlIntake() {
    	requires(Robot.intake);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.intake.OperatorControl(OI.xboxController, OI.joystickAttack);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
