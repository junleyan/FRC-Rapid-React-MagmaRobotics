//subsystem for all of cargo dump tray

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.Constants;

public class Cargo_Subsystem extends SubsystemBase {
  private Spark dump_motor;
  public DigitalInput bot_limit, top_limit;

  /** Creates a new ExampleSubsystem. */
  public Cargo_Subsystem() 
  {
    dump_motor = new Spark(Constants.DUMP_ID);
    bot_limit = new DigitalInput(Constants.BOT_CARGO_SWITCH_ID);
    top_limit = new DigitalInput(Constants.TOP_CARGO_SWITCH_ID);
  }

  public void stopCargo() {
    dump_motor.set(0.0);
  }

  public void toggleCargoUp(){
    dump_motor.set(0.5);
  }

  public void toggleCargoDown() {
    dump_motor.set(-0.5);
  }
}