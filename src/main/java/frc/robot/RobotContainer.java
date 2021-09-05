// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Auto1;
import frc.robot.commands.Auto2;
import frc.robot.commands.AutoShoot;
import frc.robot.commands.DriveForwardTimed;
import frc.robot.commands.DriveToDistance;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.ServoTriggerClosed;
import frc.robot.commands.ServoTriggerOpen;
import frc.robot.commands.ShootBall;
import frc.robot.commands.SpinBackward;
import frc.robot.commands.SpinForward;
import frc.robot.subsystems.DirectMotorDrive;
import frc.robot.subsystems.ServoTrigger;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Spinner;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  //DirectMotorDrive declare
  private final DirectMotorDrive directMotorDrive;
  private final DriveWithJoysticks driveWithJoysticks;
  private final DriveForwardTimed driveForwardTimed;
  private final DriveToDistance driveToDistance;
  public static XboxController driverJoystick;
  //Shooter declare
  private final Shooter shooter;
  private final ShootBall shootBall;
  private final AutoShoot autoShoot;
  //Spinner declare
  private final Spinner spinner;
  private final SpinBackward spinBackward;
  private final SpinForward spinForward;
  //ServoTrigger declare
  private final ServoTrigger servoTrigger;
  private final ServoTriggerOpen servoTriggerOpen;
  private final ServoTriggerClosed servoTriggerClosed;
  
  //auto declare
  private final Auto1 auto1;
  private final Auto2 auto2;

  //sendable chooser declare
  SendableChooser<Command> chooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //initialize drive values
    directMotorDrive = new DirectMotorDrive();
    driveWithJoysticks = new DriveWithJoysticks(directMotorDrive);
    driveWithJoysticks.addRequirements(directMotorDrive);
    directMotorDrive.setDefaultCommand(driveWithJoysticks);

    driveForwardTimed = new DriveForwardTimed(directMotorDrive);
    driveForwardTimed.addRequirements(directMotorDrive);

    driveToDistance = new DriveToDistance(directMotorDrive);
    driveToDistance.addRequirements(directMotorDrive);

    driverJoystick = new XboxController(Constants.JOYSTICK_NUMBER);

    //initialize shooter values
    shooter = new Shooter();
    shootBall = new ShootBall(shooter);
    shootBall.addRequirements(shooter);

    autoShoot = new AutoShoot(shooter);
    autoShoot.addRequirements(shooter);


    //initialize spinner values
    spinner = new Spinner();
    spinForward = new SpinForward(spinner);
    spinForward.addRequirements(spinner);
    spinBackward = new SpinBackward(spinner);
    spinBackward.addRequirements(spinner);

    //initialize servoTrigger values
    servoTrigger = new ServoTrigger();
    servoTriggerClosed = new ServoTriggerClosed(servoTrigger);
    servoTriggerClosed.addRequirements(servoTrigger);
    servoTriggerOpen = new ServoTriggerOpen(servoTrigger);
    servoTriggerOpen.addRequirements(servoTrigger);

    //initalize autonomous
    auto1 = new Auto1(directMotorDrive, shooter);
    auto2 = new Auto2(directMotorDrive, shooter);

      //Add choices as options here
      chooser.addOption("Autonomous 2", auto2);
      //Default option
      chooser.setDefaultOption("Autonomous 1", auto1);
      //Add Choices to SmartDashboard
      SmartDashboard.putData("Autnomous", chooser);


    //initalize camera (move to its own subsystem later)
  /*  UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    camera.setResolution(Constants.CAMERA_RES_X, Constants.CAMERA_RES_Y);
    */


    
    
    
    
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton shootButton = new JoystickButton(driverJoystick, XboxController.Button.kBumperRight.value);
    shootButton.whileHeld(new ShootBall(shooter));

    JoystickButton spinForwardButton = new JoystickButton(driverJoystick, 1);
    spinForwardButton.whileHeld(new SpinForward(spinner));

    JoystickButton spinBackwardButton = new JoystickButton(driverJoystick, 3);
    spinBackwardButton.whileHeld(new SpinBackward(spinner));

    JoystickButton servoTriggerOpenButton = new JoystickButton(driverJoystick, 2);
    servoTriggerOpenButton.whileHeld(new ServoTriggerOpen(servoTrigger));

    JoystickButton servoTriggerClosedButton = new JoystickButton(driverJoystick, 4);
    servoTriggerClosedButton.whileHeld(new ServoTriggerClosed(servoTrigger));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // call the chooser from SmartDashboard
    return chooser.getSelected();
  }
}
