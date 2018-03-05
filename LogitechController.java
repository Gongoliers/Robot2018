package org.usfirst.frc.team5112.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class LogitechController extends Joystick {

	public JoystickButton buttonA = new JoystickButton(this, 1);
	public JoystickButton buttonB = new JoystickButton(this, 2);
	public JoystickButton buttonX = new JoystickButton(this, 3);
	public JoystickButton buttonY = new JoystickButton(this, 4);
	public JoystickButton leftBumper = new JoystickButton(this, 5);
	public JoystickButton rightBumper = new JoystickButton(this, 6);
	public JoystickButton buttonBack = new JoystickButton(this, 7);
	public JoystickButton buttonStart = new JoystickButton(this, 8);
	public JoystickButton buttonJoystickLeft = new JoystickButton(this, 9);
	public JoystickButton buttonJoystickRight = new JoystickButton(this, 10);

	public LogitechController(int port) {
		super(port);
	}
	
	public double getDPadXAxis() {
		return getRawAxis(0);
	}

	public double getDPadYAxis() {
		return getRawAxis(1);
	}

	public double getLeftTrigger() {
		return getRawAxis(2);
	}

	public double getRightTrigger() {
		return getRawAxis(3);
	}

	public double getRightXAxis() {
		return getRawAxis(4);
	}

	public double getRightYAxis() {
		return getRawAxis(5);
	}

	public final Trigger leftTrigger = new Trigger() {
		
		@Override
		public boolean get() {
			return Math.round(getLeftTrigger()) == 1;
		}
	};
	
	public final Trigger rightTrigger = new Trigger() {
		
		@Override
		public boolean get() {
			return Math.round(getRightTrigger()) == 1;
		}
	};
	
	public static final int LJOYSTICK_NORTH = 0;
	public static final int LJOYSTICK_NORTHEAST = 45;
	public static final int LJOYSTICK_EAST = 90;
	public static final int LJOYSTICK_SOUTHEAST = 135;
	public static final int LJOYSTICK_SOUTH = 180;
	public static final int LJOYSTICK_SOUTHWEST = 225;
	public static final int LJOYSTICK_WEST = 270;
	public static final int LJOYSTICK_NORTHWEST = 315;


	public final Trigger DPAD_UP = new Trigger() {

		@Override
		public boolean get() {
			return getPOV() == 0;
		}
	};

	public final Trigger DPAD_DOWN = new Trigger() {

		@Override
		public boolean get() {
			return getPOV() == 180;
		}
	};

	public final Trigger DPAD_RIGHT = new Trigger() {

		@Override
		public boolean get() {
			return getPOV() == 90;
		}
	};

	public final Trigger DPAD_LEFT = new Trigger() {

		@Override
		public boolean get() {
			return getPOV() == 270;
		}
	};


}
