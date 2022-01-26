// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Tank_Drive_Subsystem extends SubsystemBase {
  private MotorController MotorL, MotorR;

  public DifferentialDrive diffDrive;

  /** Creates a new ExampleSubsystem. */
  public Tank_Drive_Subsystem() 
  {
    MotorL = new PWMSparkMax(Constants.LEFT_DRIVE_ID);
    MotorR = new PWMSparkMax(Constants.RIGHT_DRIVE_ID);

    diffDrive = new DifferentialDrive(MotorL, MotorR);
  }

  public void driveOff()
  {
    MotorL.set(0);
    MotorR.set(0);
  }

  public void tankDrive(double speedL, double speedR)
  {
    diffDrive.tankDrive(
      speedL * Constants.LEFT_DRIVE_MULTIPLIER, 
      speedR * Constants.RIGHT_DRIVE_MULTIPLIER
      );
  }
}

