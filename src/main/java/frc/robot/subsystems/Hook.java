// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Hook extends SubsystemBase {

  private Spark m_hook;
  
  public Hook() {
    m_hook = new Spark(Constants.PWM.hook);
  }

  public void hookUp() {
    m_hook.set(1.0);
  }

  public void hookOff() {
    m_hook.set(0.0);
  }

  public void hookDown() {
    m_hook.set(-1.0);
  }

}