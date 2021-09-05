// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ServoTrigger extends SubsystemBase {
  Servo servoTrigger;

  /** Creates a new ServoTrigger. */
  public ServoTrigger() {
    servoTrigger = new Servo(Constants.SERVO_TRIGGER);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void servoTriggerOpen(double angle){
    servoTrigger.set(angle);   
  }

  public void servoTriggerClosed(double angle){
    servoTrigger.set(angle);
  }

  public void stop(){
    //servoTrigger.set(0);
  }
}
