// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Indexer extends SubsystemBase {

  private Spark m_intake;
  
  public Indexer() {
    m_intake = new Spark(Constants.PWM.indexer);
  }

  public void indexerOn() {
    m_intake.set(1.0);
  }

  public void indexerOff() {
    m_intake.set(0.0);
  }

  public void indexerReverse() {
    m_intake.set(-1.0);
  }

}