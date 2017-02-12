package org.usfirst.frc.team5710.robot.subsystems.manipulators;

import org.usfirst.frc.team5710.robot.RobotMap;

public class FuelLauncher extends Manipulator{
	double time;
	double timelatch;
	boolean latch;
	double launchSpeed = 1;
	double controlSpeed = .5;

	public void launchFuel(boolean launch, boolean reverse){
		if(launch == true && reverse == false){
			time = timer.get();
			if(latch == false){
				timelatch = timer.get();
				latch = true;	
			} else if(time <= timelatch + 2){
				RobotMap.launchMotor.setSpeed(launchSpeed);
				} else {
					RobotMap.launchMotor.setSpeed(launchSpeed);
					RobotMap.launchControl.setSpeed(controlSpeed);
				}
		} else if(launch == true && reverse == true){
			RobotMap.launchMotor.setSpeed(-launchSpeed);
			RobotMap.launchControl.setSpeed(-controlSpeed);
			} else {
				RobotMap.launchMotor.setSpeed(0);
				RobotMap.launchControl.setSpeed(0);
				latch = false;
			}
	}

}
