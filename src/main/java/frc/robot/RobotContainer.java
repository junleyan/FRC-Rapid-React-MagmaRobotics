// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AccelerateFlyWheel;
import frc.robot.commands.Auto_Drive;
import frc.robot.commands.FeedOn;
import frc.robot.commands.Feed_In;
import frc.robot.commands.Feed_Off;
import frc.robot.commands.Feed_Out;
import frc.robot.commands.Flywheel_Off;
import frc.robot.commands.Flywheel_Out;
import frc.robot.commands.Hook_Down;
import frc.robot.commands.Hook_Up;
import frc.robot.commands.Hook_Off;
import frc.robot.commands.Intake_Off;
import frc.robot.commands.Intake_On;
import frc.robot.commands.Intake_Reverse;
import frc.robot.commands.Ready_Intake;
import frc.robot.commands.Rotate_Intake_In;
import frc.robot.commands.Rotate_Intake_Off;
import frc.robot.commands.Rotate_Intake_Out;
import frc.robot.commands.StopFeedAndFlyWheel;
import frc.robot.commands.StopRotIntk;
import frc.robot.commands.Tank_Drive_Command;
import frc.robot.subsystems.Flywheel_Subsystem;
import frc.robot.subsystems.Hook_Subsystem;
import frc.robot.subsystems.Intake_Subsystem;
import frc.robot.subsystems.Rotate_Intake_Subsystem;
import frc.robot.subsystems.Shooter_Feed_Subsystem;
import frc.robot.subsystems.Tank_Drive_Subsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.Button;
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
  public static Flywheel_Subsystem Flywheel;
  public static Hook_Subsystem Hook;
  public static Intake_Subsystem Intake;
  public static Rotate_Intake_Subsystem RotIntk;
  public static Shooter_Feed_Subsystem Feed;
  public static Tank_Drive_Subsystem TankDrive;

  public static Tank_Drive_Command driving;
  
  static XboxController stick1; //xbox controller instead of joystick, cuz joysticks are weird.
  static XboxController stick2; //and because we had xbox controllers lol

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    Flywheel = new Flywheel_Subsystem();
    Hook = new Hook_Subsystem();
    Intake = new Intake_Subsystem();
    RotIntk = new Rotate_Intake_Subsystem();
    Feed = new Shooter_Feed_Subsystem();
    TankDrive = new Tank_Drive_Subsystem();

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    stick1 = new XboxController(Constants.CONTROLLER_1_PORT);
    stick2 = new XboxController(Constants.CONTROLLER_2_PORT);
    TankDrive.setDefaultCommand(new Tank_Drive_Command());

    //Triggers = Intake (Right In, Left Out)
    //Bumpers = Intake Flipper (Right In, Left Out)
    //Dpad = Lift/Winch
    //A = Shoot/Flywheel
    //B = Unused
    //X = Shooter Feed Out
    //Y = Shooter Feed In
    //Joysticks = Tank Drive

    //buttons
    new JoystickButton(stick1, Constants.A_BUTTON_ID)
      .whenPressed(new Flywheel_Out())
      .whenReleased(new Flywheel_Off());
    new JoystickButton(stick2, Constants.A_BUTTON_ID) 
      .whenPressed(new Flywheel_Out())
      .whenReleased(new Flywheel_Off());
    
    new JoystickButton(stick1, Constants.B_BUTTON_ID)
      .whileHeld(new Feed_In())
      .whileHeld(new Intake_On())
      .whenReleased(new Feed_Off())
      .whenReleased(new Intake_Off());
    new JoystickButton(stick2, Constants.B_BUTTON_ID)
      .whileHeld(new Feed_In())
      .whileHeld(new Intake_On())
      .whenReleased(new Feed_Off())
      .whenReleased(new Intake_Off());
    
    new JoystickButton(stick1, Constants.X_BUTTON_ID)
      .whileHeld(new Feed_Out())
      .whenReleased(new Feed_Off());
    new JoystickButton(stick2, Constants.X_BUTTON_ID)
      .whileHeld(new Feed_Out())
      .whenReleased(new Feed_Off());
    new JoystickButton(stick1, Constants.Y_BUTTON_ID)
      .whileHeld(new Feed_In())
      .whenReleased(new Feed_Off());
    new JoystickButton(stick2, Constants.Y_BUTTON_ID)
      .whileHeld(new Feed_In())
      .whenReleased(new Feed_Off());

    //bumpers
    new JoystickButton(stick1, Constants.LEFT_BUMPER_ID)
      .whileHeld(new Rotate_Intake_Out())
      .whenReleased(new Rotate_Intake_Off());
    new JoystickButton(stick2, Constants.LEFT_BUMPER_ID)
      .whileHeld(new Rotate_Intake_Out())
      .whenReleased(new Rotate_Intake_Off());
    new JoystickButton(stick1, Constants.RIGHT_BUMPER_ID)
      .whileHeld(new Rotate_Intake_In())
      .whenReleased(new Rotate_Intake_Off());
    new JoystickButton(stick2, Constants.RIGHT_BUMPER_ID)
      .whileHeld(new Rotate_Intake_In())
      .whenReleased(new Rotate_Intake_Off());

    //triggers
    new Button(() -> stick1.getLeftTriggerAxis() > 0.5)
      .whileHeld(new Intake_Reverse())
      .whenReleased(new Intake_Off());
    new Button(() -> stick2.getLeftTriggerAxis() > 0.5)
      .whileHeld(new Intake_Reverse())
      .whenReleased(new Intake_Off());
    new Button(() -> stick1.getRightTriggerAxis() > 0.5)
      .whileHeld(new Intake_On())
      .whenReleased(new Intake_Off());
    new Button(() -> stick2.getRightTriggerAxis() > 0.5)
      .whileHeld(new Intake_On())
      .whenReleased(new Intake_Off());
      
    //dpad
    /*
    new POVButton(stick1, 180)
      .whileHeld(new Hook_Up())
      .whenReleased(new Hook_Off());
    */
    new POVButton(stick2, 180)
      .whileHeld(new Hook_Up())
      .whenReleased(new Hook_Off());
    /*
    new POVButton(stick1, 0)
      .whileHeld(new Hook_Down())
      .whenReleased(new Hook_Off());
    */
    new POVButton(stick2, 0)
      .whileHeld(new Hook_Down())
      .whenReleased(new Hook_Off());
  }

  public static double getLeftStickY()
  {
    return (stick1.getRawAxis(Constants.LEFT_JOYSTICK_CHANNEL_ID));
  }
  public static double getRightStickY()
  {
    return (stick1.getRawAxis(Constants.RIGHT_JOYSTICK_CHANNEL_ID));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  public Command getAutonomousCommand() {
    return new SequentialCommandGroup(
      new Ready_Intake(1000),
      new StopRotIntk(),
      //new ParallelCommandGroup(
        //new Auto_Drive(2000, -0.55), not needed
      new AccelerateFlyWheel(2000),
      //),
      new FeedOn(2000),
      new ParallelCommandGroup(
        new StopFeedAndFlyWheel(),
        new Auto_Drive(3250, 0.55)
      )
      //new FreeDrive(1000, 0.6, 0.6)
    );
  }

  public Command getDriving() 
  {
    return driving;
  }
}