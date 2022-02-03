// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Lift_On;
import frc.robot.commands.Lift_Reverse;
import frc.robot.commands.Auto_Forward;
import frc.robot.commands.Lift_Off;
import frc.robot.commands.Tank_Drive_Command;
import frc.robot.subsystems.Lift_Subsystem;
import frc.robot.subsystems.Tank_Drive_Subsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static Tank_Drive_Subsystem TankDrive;
  public static Tank_Drive_Command driving;
  public static Lift_Subsystem Lift;
  

  static Joystick stick0;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    TankDrive = new Tank_Drive_Subsystem();
    Lift = new Lift_Subsystem();

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    stick0 = new Joystick(Constants.CONTROLLER_PORT);
    TankDrive.setDefaultCommand(new Tank_Drive_Command());

    final JoystickButton A_Button = new JoystickButton(stick0, Constants.A_BUTTON_ID);
    final JoystickButton B_Button = new JoystickButton(stick0, Constants.B_BUTTON_ID);

    A_Button.whileHeld(new Lift_On());
    A_Button.whenReleased(new Lift_Off());
    
    B_Button.whileHeld(new Lift_Reverse());
    B_Button.whenReleased(new Lift_Off());

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
    return new Auto_Forward(1500);
  }

  public Command getDriving() 
  {
    return driving;
  }
}
