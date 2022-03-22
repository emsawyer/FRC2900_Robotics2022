package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {

    // pwm values
    public static final int FRONT_LEFT_MOTOR_PORT = 2; 
    public static final int BACK_LEFT_MOTOR_PORT = 1;
    public static final int FRONT_RIGHT_MOTOR_PORT = 4; 
    public static final int BACK_RIGHT_MOTOR_PORT = 3;

    public static final int INTAKE_MOTOR_PORT = 5;
    public static final int LAUNCHER_MOTOR_PORT = 7;
    public static final int PULL_MOTOR_PORT = 6;

    //motor percentages
    public static final double DRIVE_MOTOR_PERCENTAGE = .75;
    public static final double INTAKE_MOTOR_PERCENTAGE = -.50;

    public static final double PULL_MOTOR_PERCENTAGE = -.50;

    public static final double LAUNCHER_MOTOR_PERCENTAGE = -.75;
    public static final double LAUNCHER_MOTOR_PERCENTAGE2 = -.5;
    public static final double LAUNCHER_MOTOR_PERCENTAGE3 = -.25;
    

    public static final int INVERSION = -1;

    //Joystick
    public static final int XBOX_CONTROLLER = 0;

    //PID
    public static final double kP = .1; //likely needs to be adjusted
    public static final double kDriveTick2Feet = (1.0/128) * 6 * Math.PI * (1/12); //might not be right or needed

    //Autonomous
    public static final double AUTO_TIME = 4.0; 
    public static final double AUTONOMOUS_DRIVE_PERCENTAGE = -.25;
    public static final double SHOOT_TIME = 7.0;

}

