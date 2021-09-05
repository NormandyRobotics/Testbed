// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  Talon shooter;
  
  /** Creates a new Shooter. */
  public Shooter() {
    shooter = new Talon(Constants.SHOOTER);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shootBall(double speed){
    shooter.set(speed);   
  }

  public void stop(){
    shooter.set(0); //hard code speed to 0 (stopped)
  }
}
