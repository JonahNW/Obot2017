package org.usfirst.frc.team5710.robot.subsystems.manipulators;

import org.usfirst.frc.team5710.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Manipulator extends Subsystem {
	public Timer timer = new Timer(); //Creates the entity 'timer' through the Timer class.
	double maxMagnitude = 1.0;
	

	public void init(){
	RobotMap.launchMotor.setSpeed(0);
	RobotMap.launchControl.setSpeed(0);
	RobotMap.winchMotor.setSpeed(0);
	RobotMap.loadMotor.setSpeed(0);
	RobotMap.spitMotor.setSpeed(0);
	timer.reset();
	timer.start();
	
	//This function should only be called once when a loop is being initiated.
	}
	
	public void stopManipulators(){
		RobotMap.launchMotor.setSpeed(0);
		RobotMap.launchControl.setSpeed(0);
		RobotMap.winchMotor.setSpeed(0);
		RobotMap.loadMotor.setSpeed(0);
		RobotMap.spitMotor.setSpeed(0);
		
		//Stops all manipulators.
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	//This class is mainly for initializing all manipulators and the fields that
	//the manipulators use to work properly (such as the timer).
}
