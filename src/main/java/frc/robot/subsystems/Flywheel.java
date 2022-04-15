// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Flywheel extends SubsystemBase {

  private PWMSparkMax m_flywheel;
  
  public Flywheel() {
    m_flywheel = new PWMSparkMax(Constants.PWM.flywheel);
  }

  public void flywheelOn() {
    m_flywheel.set(0.5);
  }

  public void flywheelOff() {
    m_flywheel.set(0.0);
  }

  public void flywheelReverse() {
    m_flywheel.set(-0.5);
  }

  public void set(double power){
    m_flywheel.set(power);
  }

  public void stop() {
    m_flywheel.disable();
  }

}