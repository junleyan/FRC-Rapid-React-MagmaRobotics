//subsystem for intake flipper

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Rotate_Intake_Subsystem extends SubsystemBase {
    private Spark rot_intk;

    public Rotate_Intake_Subsystem() {
        rot_intk = new Spark(Constants.ROT_INTK_ID);
    }

    public void rotIntkOut(){
        rot_intk.set(0.45); //reduced from .75
    }

    public void rotIntkOff(){
        rot_intk.set(0.0);
    }

    public void rotIntkIn(){
        rot_intk.set(-0.55); //reduced from -.5
    }
}