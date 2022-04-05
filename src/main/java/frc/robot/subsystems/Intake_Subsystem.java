//subsystem for intake motor

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class Intake_Subsystem extends SubsystemBase {
    private Spark intake;
    
    public Intake_Subsystem() {
        intake = new Spark(Constants.INTAKE_ID);
    }

    public void intakeOn(){
        intake.set(-0.95); //changed from -1
    }

    public void intakeOff(){
        intake.set(0.0);
    }

    public void intakeReverse(){
        intake.set(0.95); //changed from 1
    }
}