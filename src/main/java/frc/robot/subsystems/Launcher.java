package frc.robot.subsystems;


import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;



public class Launcher extends SubsystemBase {

    private static Spark launcher;


    public Launcher() {

        launcher = new Spark(Constants.LAUNCHER_MOTOR_PORT);
        addChild("launcher",launcher);
        launcher.setInverted(false);

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
        launcher.set(Constants.LAUNCHER_MOTOR_PERCENTAGE);

    }
}

