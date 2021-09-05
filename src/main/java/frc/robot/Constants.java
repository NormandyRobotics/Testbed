// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
	//Motor PWM values
	public static final int MOTOR_1 = 0;
	public static final int MOTOR_2 = 1;
	public static final int JOYSTICK_LEFT_Y_AXIS = 1;
	public static final int JOYSTICK_LEFT_X_AXIS = 0;
	public static final double DRIVETRAINSPEED = 0.75;
	public static final double DRIVE_FORWARD_TIME = 3.0; //drive forward 3 seconds
	public static final double AUTONOMOUS_SPEED = 0.5; //auto speed 50%
	public static final int JOYSTICK_NUMBER = 0;

	//Shooter constants
	public static final int SHOOTER = 5;
	public static final double SHOOTER_SPEED = 0.85;


	//Spinner constants
	public static final int SPINNER_MOTOR = 3;

	//Servo constants
	public static final int SERVO_TRIGGER = 4;
	public static final double TRIGGER_OPEN_ANGLE = 0.8;
	public static final double TRIGGER_CLOSED_ANGLE = 0.1;
	
	//Camera constants
	public static final int CAMERA_RES_X = 320;
	public static final int CAMERA_RES_Y = 240;

	//autonomous shooter
	public static final double AUTO_SHOOT_TIME = 2.0;

	//analog inputs
	public static final int RANGE_FINDER = 0;
	public static final double SETPOINT_FORWARD = 1.5; //hopefully 1.5m


}  
