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
	private DifferentialDrive m_driveTrain;
	private Joystick m_joyStick;
	private DifferentialDrive m_intake;
	private DifferentialDrive m_shooter;
	
	public static class ButtonMap {
		public int A = 0;
		public int B = 1;
		public int X = 2;
		public int Y = 3;
		public int LB = 4;
		public int RB = 5;
		public int Back = 6;
		public int Start = 7;
		public int L3 = 8;
		public int R3 = 9;
	}
	
	@Override
	public void robotInit() {
		m_driveTrain = new DifferentialDrive(new Spark(0), new Spark(1));
		m_intake = new DifferentialDrive(new Spark(2), new Spark(3));
		m_shooter = new DifferentialDrive(new Spark(4), new Spark(5));
		m_joyStick = new Joystick(0);
	}
	
	@Override
	public void autonomousPeriodic() {
		super.autonomousPeriodic();
		// TODO: Write Code for autonomous
		
	}

	@Override
	public void teleopPeriodic() {
		m_driveTrain.setSafetyEnabled(true);
		while (isOperatorControl() && isEnabled()) {
			
			// Drive arcade style
			m_driveTrain.arcadeDrive(-m_joyStick.getY(), m_joyStick.getX());
			
			// Intake
			
			
			// The motors will be updated every 5ms
			Timer.delay(0.005);
		}
	}
}
