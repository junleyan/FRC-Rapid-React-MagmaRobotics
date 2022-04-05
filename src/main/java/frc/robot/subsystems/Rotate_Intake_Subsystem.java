//subsystem for intake flipper

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Rotate_Intake_Subsystem extends SubsystemBase {
    private Spark rot_intk;
    public DigitalInput top_limit;
    public DigitalInput bot_limit;

    public Rotate_Intake_Subsystem() {
        rot_intk = new Spark(Constants.ROT_INTK_ID);
        //top_limit = new DigitalInput(Constants.TOP_ROTATE_INTK_ID);
        //bot_limit = new DigitalInput(Constants.BOT_ROTATE_INTK_ID);
    }

    public void rotIntkOut(){
        rot_intk.set(0.6);
    }

    public void rotIntkOff(){
        rot_intk.set(0.0);
    }

    public void rotIntkIn(){
        rot_intk.set(-0.6);
    }
}