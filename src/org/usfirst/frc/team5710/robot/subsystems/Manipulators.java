package org.usfirst.frc.team5710.robot.subsystems;

import org.usfirst.frc.team5710.robot.RobotMap;

import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Manipulators extends Subsystem {
	double maxMagnitude = 1.0;
	

	public static void init(){
	RobotMap.launchMotor.setSpeed(0);
	RobotMap.launchControl.setSpeed(0);
	RobotMap.winchMotor.setSpeed(0);
	RobotMap.loadMotor.setSpeed(0);
	}
	
	public void climb(boolean winchUp, boolean winchDwn, double winchSpeed){
		if(winchUp == true && winchDwn == false){
			RobotMap.winchMotor.setSpeed(winchSpeed);
		} else if(winchUp == false && winchDwn == true){
			RobotMap.winchMotor.setSpeed(-winchSpeed);
		} else {
			RobotMap.winchMotor.setSpeed(0);
		}
		
	}
	
	public void spitFuel(boolean spit, boolean reverse)

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
