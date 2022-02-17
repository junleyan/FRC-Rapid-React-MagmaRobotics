// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Auto_Drive;
import frc.robot.commands.Hook_Down;
import frc.robot.commands.Hook_Up;
import frc.robot.commands.Hook_Off;
import frc.robot.commands.Intake_Off;
import frc.robot.commands.Intake_On;
import frc.robot.commands.Intake_Reverse;
import frc.robot.commands.Rotate_Intake_In;
import frc.robot.commands.Rotate_Intake_Out;
import frc.robot.commands.Spin_Cargo;
import frc.robot.commands.Spin_Cargo_Opposite;
import frc.robot.commands.Tank_Drive_Command;
import frc.robot.subsystems.Cargo_Subsystem;
import frc.robot.subsystems.Hook_Subsystem;
import frc.robot.subsystems.Intake_Subsystem;
import frc.robot.subsystems.Rotate_Intake_Subsystem;
import frc.robot.subsystems.Tank_Drive_Subsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here
  public static Tank_Drive_Subsystem TankDrive;
  public static Tank_Drive_Command driving;
  public static Intake_Subsystem Intake;
  public static Cargo_Subsystem Cargo;
  public static Rotate_Intake_Subsystem RotIntk;
  public static Hook_Subsystem Hook;
  
  static XboxController stick0;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    TankDrive = new Tank_Drive_Subsystem();
    Intake = new Intake_Subsystem();
    Cargo = new Cargo_Subsystem();
    RotIntk = new Rotate_Intake_Subsystem();
    Hook = new Hook_Subsystem();

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    stick0 = new XboxController(Constants.CONTROLLER_PORT);
    TankDrive.setDefaultCommand(new Tank_Drive_Command());

    new JoystickButton(stick0, Constants.A_BUTTON_ID)
      .whileHeld(new Intake_On())
      .whenReleased(new Intake_Off());
    new JoystickButton(stick0, Constants.B_BUTTON_ID)
      .whileHeld(new Intake_Reverse())
      .whenReleased(new Intake_Off());
    new JoystickButton(stick0, Constants.X_BUTTON_ID)
      .whenPressed(new Spin_Cargo());
    new JoystickButton(stick0, Constants.Y_BUTTON_ID)
      .whenPressed(new Spin_Cargo_Opposite());
    new JoystickButton(stick0, Constants.LEFT_BUMPER_ID)
      .whenPressed(new Rotate_Intake_In());
    new JoystickButton(stick0, Constants.RIGHT_BUMPER_ID)
      .whenPressed(new Rotate_Intake_Out());
    new POVButton(stick0, 0)
      .whenPressed(new Hook_Up())
      .whenReleased(new Hook_Off());
    new POVButton(stick0, 180)
      .whenPressed(new Hook_Down())
      .whenReleased(new Hook_Off());
  }

  public static double getLeftStickY()
  {
    return (stick0.getRawAxis(Constants.LEFT_JOYSTICK_CHANNEL_ID));
  }

  public static double getRightStickY()
  {
    return (stick0.getRawAxis(Constants.RIGHT_JOYSTICK_CHANNEL_ID));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new SequentialCommandGroup(
      new Auto_Drive(1500, 0.4), 
      new Spin_Cargo(),
      new Spin_Cargo_Opposite(),
      new Auto_Drive(1500, -0.4)
      );
  }

  public Command getDriving() 
  {
    return driving;
  }
}
