// RobotBuilder Version: 4.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.Constants;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Intake extends SubsystemBase {
    
    private static PWMSparkMax intake;

<<<<<<< HEAD
    public static double intake_percent = Constants.INTAKE_MOTOR_PERCENTAGE;


    
=======
    static boolean toggle;

    private static double intake_percent = Constants.INTAKE_MOTOR_PERCENTAGE;

>>>>>>> e44c83dcaacd3f5e04f4b1fe7f2217dcec16c6e0
    /**
    *
    */
    public Intake() {
        
        intake = new PWMSparkMax(Constants.INTAKE_MOTOR_PORT);
        toggle = false;
        

    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

        //if intake still doesn't work
        //will need to set some activation method
        /*
            if (toggle == false) {
                intake.set(Constants.INTAKE_MOTOR_PERCENTAGE);
                toggle = true;
            }
            else {
                intake.set(0);
                toggle = false;
            }

        */

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    public static PWMSparkMax getIntake() {
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

