package org.usfirst.frc.team5710.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick driveStick = new Joystick(0);
	//Joystick Axes
	double xAxis;
	double yAxis;
	double zAxis;
	double winchSpeed;
	//Joystick Buttons
	boolean winchUp;
	boolean winchDwn;
	boolean spit;
	boolean reverse;
	
	
	public void getSetData(){
		xAxis = driveStick.getX();
		yAxis = driveStick.getY();
		zAxis = driveStick.getZ();
		
		winchSpeed = driveStick.getThrottle();
		winchUp = driveStick.getRawButton(6);
		winchDwn = driveStick.getRawButton(4);
		spit = driveStick.getRawButton(1);
		reverse = driveStick.getRawButton(11);
		
		//This should be included in any loop that is running functions using the above variables.
		//This gathers new data from the joystick every time the function is called.
	}
}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

