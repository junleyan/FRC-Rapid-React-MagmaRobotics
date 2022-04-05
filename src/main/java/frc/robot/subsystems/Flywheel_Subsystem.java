//subsystem for flywheel

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Flywheel_Subsystem extends SubsystemBase {
    private Spark flywheel;

    public Flywheel_Subsystem() {
        flywheel = new Spark(Constants.FLYWHEEL_ID);
    }
    
    public void flywheelOut(){
        flywheel.set(1.0);
    }

    public void flywheelOff(){
        flywheel.set(0.0);
    }

    public void flywheelIn(){
        flywheel.set(-1.0);
    }
}