//tank drive subsystem, sends power to motors

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Tank_Drive_Subsystem extends SubsystemBase {
  private MotorController MotorL, MotorR;
  public DifferentialDrive diffDrive;

  public Tank_Drive_Subsystem() {
    MotorL = new PWMSparkMax(Constants.LEFT_DRIVE_ID);
    MotorR = new PWMSparkMax(Constants.RIGHT_DRIVE_ID);

    diffDrive = new DifferentialDrive(MotorL, MotorR);
  }
  
  public void driveOff(){
    MotorL.set(0);
    MotorR.set(0);
  }

  public void tankDrive(double speedL, double speedR) {
    diffDrive.tankDrive(
      speedL * Constants.LEFT_DRIVE_MULTIPLIER, 
      speedR * Constants.RIGHT_DRIVE_MULTIPLIER
      );
  }

  public void freeDrive(double speedL, double speedR) {
    diffDrive.tankDrive(speedL, speedR);
  }
}