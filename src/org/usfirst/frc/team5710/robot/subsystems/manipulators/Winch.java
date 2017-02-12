package org.usfirst.frc.team5710.robot.subsystems.manipulators;

import org.usfirst.frc.team5710.robot.RobotMap;

public class Winch extends Manipulator{
	
	public static void climb(boolean winchUp, boolean winchDwn, double winchSpeed){
		if(winchUp == true && winchDwn == false){
			RobotMap.winchMotor.setSpeed(winchSpeed);
		} else if(winchUp == false && winchDwn == true){
			RobotMap.winchMotor.setSpeed(-winchSpeed);
		} else {
			RobotMap.winchMotor.setSpeed(0);
		}
		
	}
}
