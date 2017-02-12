package org.usfirst.frc.team5710.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import java.lang.Math;
import org.usfirst.frc.team5710.robot.RobotMap;

/**
 *
 */
public class Drive extends Subsystem {
	private static double maxMagnitude = 1.0; //1.0 means 100%
	private static double deadBand = .05;
		//If the output to the motors is less than the deadBand, then the output to the motors is
		//set to 0. This prevents tiny inaccuracies in the joystick input from making the robot move
		//when it shouldn't.
	
	
	public void stopMoving(){
		RobotMap.frontLeftMotor.set(0);
		RobotMap.frontRightMotor.set(0);
		RobotMap.rearLeftMotor.set(0);
		RobotMap.rearRightMotor.set(0);
		
		//This function sets the motor outputs at zero when called.
		}
	
	public void mecanumCartesian(double x, double y, double z, int gyroAngle){
		y = -y; 								//negate y axis
		z = .75 * z; 							//Modify z axis to 75%
		x = (Math.abs(x) / x) * x * x;
		y = (Math.abs(y) / y) * y * y; 			//squaring the input axis increases sensitivity to low speeds.
		z = (Math.abs(z) / z) * z * z;			//(Math.abs(y) / y) carries the sign of the original value to the output.
				
		double[] rotated = rotateVector(x, y, gyroAngle);
	    x = rotated[0]; 						//Adjust x and y to gyro angle.
	    y = rotated[1];
	    double[] normalized = Drive.normalize(x, y, z, maxMagnitude);
	    x = normalized[0];						//Keeps the total of x, y, and z <= 1.
	    y = normalized[1];
	    z = normalized[2];
	    double fLMotor = Drive.setDeadBand((x + y + z));
	    double fRMotor = Drive.setDeadBand(-(-x + y - z)); //Is inverted
	    double rLMotor = Drive.setDeadBand((-x + y + z)); 
	    double rRMotor = Drive.setDeadBand(-(x + y - z)); //Is inverted
	    
	    RobotMap.frontLeftMotor.setSpeed(fLMotor);
	    RobotMap.frontRightMotor.setSpeed(fRMotor);
		RobotMap.rearLeftMotor.setSpeed(rLMotor);
		RobotMap.rearRightMotor.setSpeed(rRMotor);
		
		/*This can be called to drive your robot using Mecanum Wheels. If the 'gyroAngle' argument is
		 * set to a gyro sensor, the robot will adjust its motion so pushing the Joystick away from you
		 * will always make the robot move away from you, despite what direction the robot is facing.
		 * Setting 'gyroAngle' to 0 will make the robot move through its perspective.
		 */
	}
	
	public void setSpeed(String motor, double speed){
		if(motor == "frontLeftMotor"){
			RobotMap.frontLeftMotor.setSpeed(speed);	
		}
		if(motor == "frontRightMotor"){
			RobotMap.frontRightMotor.setSpeed(speed);
		}
		if(motor == "rearLeftMotor"){
			RobotMap.rearLeftMotor.setSpeed(speed);
		}
		if(motor == "rearRightMotor"){
			RobotMap.rearRightMotor.setSpeed(speed);
		}
		// This function will set the speed of individual motors for test and autonomous purposes.
	}
	
	public double[] rotateVector(double x, double y, double angle) {
		/*Using double with square brackets creates an array: a 'list' of multiple
		*doubles all under the same name and sorted into indexes (Indexes are integer
		*labels that go in the square brackets to call and write the different doubles
		*that are being stored.
		*/
	    double cosA = Math.cos(angle * (3.14159 / 180.0));
	    double sinA = Math.sin(angle * (3.14159 / 180.0));
	    //(3.14159 / 180.0) <--This converts from degrees to radians
	    double[] out = new double[2];
	    out[0] = (x * cosA) - (y * sinA);
	    out[1] = (x * sinA) + (y * cosA);
	    return out; //Return the array to wherever the 'rotateVector' function is called.
	    
	    /*This is copied from the RobotDrive class. This function uses trigonometry
	     * to adjust the x & y inputs based on the angle that the gyro sensor reads.
	     */
	  }
	
	public static double[] normalize(double x, double y, double z, double maxMagnitude){
		double axisTotal = Math.abs(x) + Math.abs(y) + Math.abs(z);	//Totals x, y, and z, ignoring signs.
		double[] out = new double[3]; 					//Initializes the array 'out' with 3 indexes.
		if(axisTotal > maxMagnitude){
			x = x * (maxMagnitude / axisTotal);			//Decreases the values of x, y, and z proportionally.
			y = y * (maxMagnitude / axisTotal);
			z = z * (maxMagnitude / axisTotal);
		}
		out[0] = x;
		out[1] = y;
		out[2] = z;
		return out;
		
		//This function makes sure that the total of x, y, and z is not greater than 1 (100%)
		//while keeping x, y, and z proportional to each other. This can be used without the
		//the z axis by setting the argument z equal to zero.
	}
	
	public static double setDeadBand(double input){
		if(Math.abs(input) < deadBand){
			input = 0;
		}
		return input;
		
		//This function utilizes the deadBand. This must be called in order for deadBand to work.
	}
	
	

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
