package frc.robot.subsystems;


import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;



public class Launcher extends SubsystemBase {

    private static Spark launcher;
    private static double launcher_percent;
    private static double launcher_percent2;
    private static double launcher_percent3;

    public Launcher() {

        launcher = new Spark(Constants.LAUNCHER_MOTOR_PORT);
        addChild("launcher",launcher);
        launcher.setInverted(false);
        launcher_percent = Constants.LAUNCHER_MOTOR_PERCENTAGE;
        launcher_percent2 = Constants.LAUNCHER_MOTOR_PERCENTAGE2;
        launcher_percent3 = Constants.LAUNCHER_MOTOR_PERCENTAGE3;

    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public static void setLauncher() {
        launcher.set(launcher_percent);

    }

    public static void setLauncher2() {
        launcher.set(launcher_percent2);

    }

    public static void setLauncher3() {
        launcher.set(launcher_percent3);

    }

    public static void setLauncherPercent() {

    }


}

