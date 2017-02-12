package org.usfirst.frc.team5710.robot;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//Drive Motors
	public static VictorSP frontLeftMotor = new VictorSP(0); //Setting these variables to public means that they can be
	public static VictorSP frontRightMotor = new VictorSP(1); //called outside this class. Setting them as static means
	public static VictorSP rearLeftMotor = new VictorSP(2); //they can be called without creating a new instance of
	public static VictorSP rearRightMotor = new VictorSP(3); //the RobotMap class.
	
	//Manipulators
	public static VictorSP launchMotor = new VictorSP(4);
	public static VictorSP launchControl = new VictorSP(5);
	public static TalonSRX winchMotor = new TalonSRX(6);
	public static VictorSP loadMotor = new VictorSP(7);
	public static TalonSRX spitMotor = new TalonSRX(8);
	
	//Servos
	public static Servo cameraServo = new Servo(8);
}
