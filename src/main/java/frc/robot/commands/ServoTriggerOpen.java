// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ServoTrigger;

public class ServoTriggerOpen extends CommandBase {
  ServoTrigger servoTrigger;

  /** Creates a new ServoTriggerOpen. */
  public ServoTriggerOpen(ServoTrigger st) {
      servoTrigger = st;
      addRequirements(servoTrigger);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    servoTrigger.servoTriggerOpen(Constants.TRIGGER_OPEN_ANGLE);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    servoTrigger.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
