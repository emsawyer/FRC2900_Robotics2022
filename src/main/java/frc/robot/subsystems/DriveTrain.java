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
import frc.robot.RobotContainer;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveTrain extends SubsystemBase {

    private static Spark frontLeft;
    private static Spark backLeft;
    private static MotorControllerGroup leftMotor;
    private static Spark frontRight;
    private static Spark backRight;
    private static MotorControllerGroup rightMotor;
    public static DifferentialDrive differentialDrive;


    public DriveTrain() {
        
        frontLeft = new Spark(Constants.FRONT_LEFT_MOTOR_PORT);
        addChild("Front Left",frontLeft);
        frontLeft.setInverted(false);

        backLeft = new Spark(Constants.BACK_LEFT_MOTOR_PORT); //1
        addChild("Back Left",backLeft);
        backLeft.setInverted(false);

        leftMotor = new MotorControllerGroup(frontLeft, backLeft);
        addChild("Left Motor",leftMotor);
        

        frontRight = new Spark(Constants.FRONT_RIGHT_MOTOR_PORT); //2
        addChild("Front Right",frontRight);
        frontRight.setInverted(true);

        backRight = new Spark(Constants.BACK_RIGHT_MOTOR_PORT); //3
        addChild("Back Right",backRight);
        backRight.setInverted(true);

        rightMotor = new MotorControllerGroup(frontRight, backRight);
        addChild("Right Motor",rightMotor);
        

        differentialDrive = new DifferentialDrive(leftMotor, rightMotor);
        addChild("Differential Drive",differentialDrive);
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);


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

    public static double setLeftMotors() {
        
        return Constants.DRIVE_MOTOR_PERCENTAGE*RobotContainer.getXboxController().getLeftY();
    }

    public static double setRightMotors() {

        return Constants.DRIVE_MOTOR_PERCENTAGE*RobotContainer.getXboxController().getRightY();
    }

    public static void stop() {

        leftMotor.set(0);
        rightMotor.set(0);
    }

    public static void move(double time, double power) {
        RobotContainer.m_timer.reset();
        RobotContainer.m_timer.start();
        if (RobotContainer.m_timer.get() <= time) {
            DriveTrain.differentialDrive.tankDrive(power, power);
        }
        else {
            DriveTrain.differentialDrive.tankDrive(0, 0);

        }

    }

}

