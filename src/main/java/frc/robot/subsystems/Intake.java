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
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Intake extends SubsystemBase {
    
    private static Spark intake;

    static boolean toggle = false;
    /**
    *
    */
    public Intake() {
        
        intake = new Spark(Constants.INTAKE_MOTOR_PORT);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    public Spark getIntake() {
        return intake;
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public static void toggleIntake() { //toggle might be done automatically, so if there's a bug, try removing it
        if (toggle == true) { //== true might be unnecessary
            intake.set(0);
        }
        else {
            intake.set(Constants.INTAKE_MOTOR_PERCENTAGE);
            toggle = true;
        }
        
        

    }

    public static void stop() {
        intake.set(0);

    }
}

