package org.usfirst.frc.team5710.robot.subsystems.manipulators;

import org.usfirst.frc.team5710.robot.RobotMap;

public class FuelSpitter extends Manipulator{
	
	public static void spitFuel(boolean spit, boolean reverse){
		double spitSpeed = .5;
		if(spit == true && reverse == false){
			RobotMap.spitMotor.setSpeed(spitSpeed);
		} else if (spit == true && reverse == true){
			RobotMap.spitMotor.setSpeed(-spitSpeed);
		} else {
			RobotMap.spitMotor.setSpeed(0);
		}
	}

}
