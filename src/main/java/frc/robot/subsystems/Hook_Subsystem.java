//subsystem for entire hook mechanism

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Hook_Subsystem extends SubsystemBase {
    private Spark hook;

    public Hook_Subsystem() 
    {
        hook = new Spark(Constants.HOOK_ID);
    }

    public void hookUp()
    {
        hook.set(0.5);
    }

    public void hookOff()
    {
        hook.set(0.0);
    }

    public void hookDown()
    {
        hook.set(-0.5);
    }

    @Override
    public void periodic() {
    // This method will be called once per scheduler run
    }
}