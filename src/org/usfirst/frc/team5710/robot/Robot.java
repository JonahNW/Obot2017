package org.usfirst.frc.team5710.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5710.robot.commands.ExampleCommand;
import org.usfirst.frc.team5710.robot.subsystems.*;
import org.usfirst.frc.team5710.robot.subsystems.manipulators.*;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Drive robotDrive = new Drive(); //Creates the entity 'robotDrive' through the Drive class.
	public static OI oi; //Creates the entity 'oi' (operator interface) through the OI class.
	Manipulator manipulators = new Manipulator(); //I think you get it now...
	Autonomous auto = new Autonomous();

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		robotDrive.stopMoving();
		manipulators.stopManipulators();
		
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		robotDrive.stopMoving();
		manipulators.stopManipulators();
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
		auto.init();
		robotDrive.stopMoving();
		manipulators.init();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		auto.moveForward();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		manipulators.init();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		oi.getSetData();
		//double xAxis = oi.driveStick.getX();
		//double yAxis = oi.driveStick.getY();
		//double zAxis = oi.driveStick.getZ();
		robotDrive.mecanumCartesian(oi.xAxis, oi.yAxis, oi.zAxis, 0);
		
		//boolean winchUp = oi.driveStick.getRawButton(6);
		//boolean winchDwn = oi.driveStick.getRawButton(4);
		//double winchSpeed = (oi.driveStick.getThrottle() - 1) / 2; //Negated
		Winch.climb(oi.winchUp, oi.winchDwn, oi.winchSpeed);
		
		//boolean spit = oi.driveStick.getRawButton(1);
		//boolean reverse = oi.driveStick.getRawButton(11);
		FuelSpitter.spitFuel(oi.spit, oi.reverse);
		
		
		Timer.delay(0.005); //Prevents the program from hogging cpu cycles.
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
