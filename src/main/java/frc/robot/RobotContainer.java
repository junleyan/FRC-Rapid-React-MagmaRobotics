// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Hook;
import frc.robot.subsystems.Indexer;
import frc.robot.commands.teleop.drivetrain.DriveTrainCommand;
import frc.robot.commands.teleop.flywheel.flywheelIn;
import frc.robot.commands.teleop.flywheel.flywheelOff;
import frc.robot.commands.teleop.flywheel.flywheelOut;
import frc.robot.commands.teleop.hook.hookDown;
import frc.robot.commands.teleop.hook.hookOff;
import frc.robot.commands.teleop.hook.hookUp;
import frc.robot.commands.teleop.indexer.indexerIn;
import frc.robot.commands.teleop.indexer.indexerOff;
import frc.robot.commands.teleop.indexer.indexerOut;


public class RobotContainer {
  DriveTrain m_driveTrain;
  Indexer m_indexer;
  Flywheel m_flywheel;
  Hook m_hook;

  XboxController m_driver_controller, m_partner_controller;
  JoystickButton m_d_face_a, m_d_face_b, m_d_face_x, m_d_face_y, m_d_bumper_left, m_d_bumper_right;
  JoystickButton m_p_face_a, m_p_face_b, m_p_face_x, m_p_face_y, m_p_bumper_left, m_p_bumper_right;
  POVButton m_dpad_up, m_dpad_down, m_dpad_left, m_dpad_right;
  UsbCamera m_camera;

  public RobotContainer() {
    m_driveTrain = new DriveTrain();
    m_indexer = new Indexer();
    m_flywheel = new Flywheel();
    m_hook = new Hook();
    
    m_driver_controller = new XboxController(Constants.ControllerPort.driver);
    m_partner_controller = new XboxController(Constants.ControllerPort.partner);

    // Joystick Buttons
    m_d_face_a = new JoystickButton(m_driver_controller, Constants.Face.A);
    m_d_face_b = new JoystickButton(m_driver_controller, Constants.Face.B);
    m_d_face_x = new JoystickButton(m_driver_controller, Constants.Face.X);
    m_d_face_y = new JoystickButton(m_driver_controller, Constants.Face.Y);
    m_d_bumper_left = new JoystickButton(m_driver_controller, Constants.Bumper.left);
    m_d_bumper_right = new JoystickButton(m_driver_controller, Constants.Bumper.right);

    m_p_face_a = new JoystickButton(m_partner_controller, Constants.Face.A);
    m_p_face_b = new JoystickButton(m_partner_controller, Constants.Face.B);
    m_p_face_x = new JoystickButton(m_partner_controller, Constants.Face.X);
    m_p_face_y = new JoystickButton(m_partner_controller, Constants.Face.Y);
    m_p_bumper_left = new JoystickButton(m_partner_controller, Constants.Bumper.left);
    m_p_bumper_right = new JoystickButton(m_partner_controller, Constants.Bumper.right);

    m_dpad_up = new POVButton(m_partner_controller, 0);
    m_dpad_down = new POVButton(m_partner_controller, 180);
    m_dpad_left = new POVButton(m_partner_controller, 270);
    m_dpad_right = new POVButton(m_partner_controller, 90);

    m_driveTrain.setDefaultCommand(new DriveTrainCommand(m_driveTrain, m_driver_controller));
    
    m_camera = CameraServer.startAutomaticCapture();
    //m_camera.setResolution(640, 480);

    configureButtonBindings();
  }


  private void configureButtonBindings() {
    // Driver bindings
    m_d_face_a.whenPressed(new indexerIn(m_indexer));
    m_d_face_a.whenReleased(new indexerOff(m_indexer));

    m_d_face_b.whenPressed(new indexerOut(m_indexer));
    m_d_face_b.whenReleased(new indexerOff(m_indexer));

    m_d_face_x.whenPressed(new flywheelIn(m_flywheel));
    m_d_face_x.whenReleased(new flywheelOff(m_flywheel));

    m_d_face_y.whenPressed(new flywheelOut(m_flywheel));
    m_d_face_y.whenReleased(new flywheelOff(m_flywheel));

    m_dpad_up.whenPressed(new hookUp(m_hook));
    m_dpad_up.whenReleased(new hookOff(m_hook));
    
    m_dpad_down.whenPressed(new hookDown(m_hook));
    m_dpad_down.whenReleased(new hookOff(m_hook));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}