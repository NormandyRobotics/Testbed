// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DirectMotorDrive extends SubsystemBase {
  Jaguar motor1;
  Jaguar motor2;
  SpeedControllerGroup cimMotorsLeft;
  SpeedControllerGroup cimMotorsRight;
  DifferentialDrive drive;

  //sensor (range finder)
  private final AnalogInput rangeFinder; 
  
  
  /** Creates a new DirectMotorDrive. */
  public DirectMotorDrive() 
  {
    motor1 = new Jaguar(Constants.MOTOR_1);
    motor1.setInverted(false);
    motor2 = new Jaguar(Constants.MOTOR_2);
    motor2.setInverted(true);

    cimMotorsLeft = new SpeedControllerGroup(motor1);
    cimMotorsRight = new SpeedControllerGroup(motor2);
    drive = new DifferentialDrive(cimMotorsLeft, cimMotorsRight);

    rangeFinder = new AnalogInput(Constants.RANGE_FINDER);
    

  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }

  public void driveWithJoysticks(XboxController controller, double speed)
  {
    drive.arcadeDrive(controller.getRawAxis(Constants.JOYSTICK_LEFT_Y_AXIS)*speed, controller.getRawAxis(Constants.JOYSTICK_LEFT_X_AXIS)*speed);
    
  }

  public boolean driveToDistance(double setPointDistance, double speed)
  {
    while(rangeFinder.getAverageVoltage() > setPointDistance) 
    {
      driveForward(speed);
    }
    return true;

  }

  public void driveForward(double speed)
  {
    drive.tankDrive(speed, speed);
  }

  public void stop()
  {
    drive.stopMotor();
  }
}
