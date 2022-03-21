package frc.robot.subsystems;


import frc.robot.Constants;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    
    private static Spark intake;

    public static double intake_percent = Constants.INTAKE_MOTOR_PERCENTAGE;


    
    public Intake() {
        
        intake = new Spark(Constants.INTAKE_MOTOR_PORT);
       
        

    }

    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    public static Spark getIntake() {
        return intake;
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public static void toggleIntake() {
        intake.set(intake_percent);

    }

    public static void stop() {
        intake.set(0);

    }
}

