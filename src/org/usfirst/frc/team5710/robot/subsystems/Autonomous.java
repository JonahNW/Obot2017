package org.usfirst.frc.team5710.robot.subsystems;

import edu.wpi.first.wpilibj.*;

public class Autonomous {
	Drive myRobotDrive = new Drive();
	Timer timer = new Timer();
	
	public void init(){
		timer.reset();
		timer.start();
	}
	
	public void moveForward(){
		
		myRobotDrive.mecanumCartesian(0, .3, 0, 0);
		if(timer.get() >= 2){
			myRobotDrive.mecanumCartesian(0, 0, 0, 0);
		}
		
	}

}
