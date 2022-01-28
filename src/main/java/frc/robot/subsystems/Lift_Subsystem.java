package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Lift_Subsystem extends SubsystemBase {
    private Spark lift;
    public Lift_Subsystem() 
    {
        lift = new Spark(Constants.LIFT_ID);
    }

    public void liftOn()
    {
        lift.set(1.0);
    }

    public void liftOff()
    {
        lift.set(0.0);
    }

    public void liftReverse()
    {
        lift.set(-1.0);
    }

    @Override
    public void periodic() {
    // This method will be called once per scheduler run
    }
}