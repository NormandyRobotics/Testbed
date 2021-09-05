// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Spinner extends SubsystemBase {
  Relay spinner;

  /** Creates a new Spinner. */
  public Spinner() {
    spinner = new Relay(Constants.SPINNER_MOTOR);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void spinForward(){
    spinner.set(Value.kForward);
  }

  public void spinBackward(){
    spinner.set(Value.kReverse);
  }

  public void stop(){
    spinner.stopMotor();
  }
}
