package org.usfirst.frc.team5710.robot.subsystems;

import org.usfirst.frc.team5710.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {
	double defaultAngle = 0;
	
	
	
	
	
	
	public void init(){
		RobotMap.cameraServo.setAngle(defaultAngle);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
