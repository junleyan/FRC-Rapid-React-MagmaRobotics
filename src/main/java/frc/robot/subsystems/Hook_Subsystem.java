//subsystem for entire lift mechanism

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Hook_Subsystem extends SubsystemBase {
    private Spark hook;

    public Hook_Subsystem() {
        hook = new Spark(Constants.HOOK_ID);
    }
    
    public void hookUp(){
        hook.set(0.8);
    }

    public void hookOff(){
        hook.set(0.0);
    }

    public void hookDown(){
        hook.set(-0.8);
    }
}