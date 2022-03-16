package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Pull extends SubsystemBase {

    private static PWMSparkMax pull;

    public Pull() {

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

    public static void setPull() {
        pull.set(Constants.PULL_MOTOR_PERCENTAGE);

    }

    public static void stop() {
        pull.set(0);

    }
}

