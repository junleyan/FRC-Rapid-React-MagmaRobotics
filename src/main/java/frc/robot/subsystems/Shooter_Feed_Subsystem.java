//subsystem for feed mechanism

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Shooter_Feed_Subsystem extends SubsystemBase {
    private Spark feed;
    
    public Shooter_Feed_Subsystem() {
        feed = new Spark(Constants.FEED_ID);
    }

    public void feedIn(){
        feed.set(-0.85); //changed from -.75
    }

    public void feedOff(){
        feed.set(0.0);
    }

    public void feedOut(){
        feed.set(0.85); //changed from .75
    }
}