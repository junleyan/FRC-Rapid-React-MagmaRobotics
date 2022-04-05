// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //drive multiplier
    public static final double LEFT_DRIVE_MULTIPLIER = -1; //Needs to be negative
    public static final double RIGHT_DRIVE_MULTIPLIER = 1; //usually 0.85

    //controller IDs
    public static final int CONTROLLER_1_PORT = 0;
    public static final int CONTROLLER_2_PORT = 1;
    public static final int LEFT_JOYSTICK_CHANNEL_ID = 1;
    public static final int RIGHT_JOYSTICK_CHANNEL_ID = 5;
    public static final int A_BUTTON_ID = 1;
    public static final int B_BUTTON_ID = 2;
    public static final int X_BUTTON_ID = 3;
    public static final int Y_BUTTON_ID = 4;
    public static final int LEFT_BUMPER_ID = 5;
    public static final int RIGHT_BUMPER_ID = 6;
    public static final int LEFT_TRIGGER_CHANNEL_ID = 2;
    public static final int RIGHT_TRIGGER_CHANNEL_ID = 3;

    //PWM IDs
    public static final int LEFT_DRIVE_ID = 0;
    public static final int RIGHT_DRIVE_ID = 1;
    public static final int INTAKE_ID = 2;  
    public static final int DUMP_ID = 3;
    public static final int ROT_INTK_ID = 4; //Intake Flipper
    public static final int HOOK_ID = 5; //Lift

    //DIO IDs
    /*
    public static final int BOT_CARGO_SWITCH_ID = 0; //all unused LOL
    public static final int TOP_CARGO_SWITCH_ID = 1; //;-; spent so much time working on these...
    public static final int BOT_ROTATE_INTK_ID = 2; //to waste. for shame.
    public static final int TOP_ROTATE_INTK_ID = 3; //unused
    public static final int BOT_HOOK_SWITCH_ID = 4; //unused
    public static final int TOP_HOOK_SWITCH_ID = 5; //unused
    */
    
}
