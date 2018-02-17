/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2895.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class Robot extends IterativeRobot {
	private DifferentialDrive m_myRobot;
	private Joystick m_myJoyStick;

	@Override
	public void robotInit() {
		m_myRobot = new DifferentialDrive(new Spark(0), new Spark(1));
		m_myJoyStick = new Joystick(0);
	}
	
	@Override
	public void autonomousPeriodic() {
		super.autonomousPeriodic();
		// TODO: Write Code for autonomous
		
	}

	@Override
	public void teleopPeriodic() {
		m_myRobot.setSafetyEnabled(true);
		while (isOperatorControl() && isEnabled()) {
			// Drive arcade style
			
			m_myRobot.arcadeDrive(-m_myJoyStick.getY(), -m_myJoyStick.getX());

			// The motors will be updated every 5ms
			Timer.delay(0.005);
		}
	}
}
