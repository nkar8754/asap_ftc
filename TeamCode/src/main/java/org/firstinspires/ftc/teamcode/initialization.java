package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class initialization {
}
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.Servo

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Swerve Drive", group = "Linear Opmode")
class SwerveDrive : LinearOpMode() {
    private var frontLeftDrive: DcMotor? = null
    private var frontRightDrive: DcMotor? = null
    private var backLeftDrive: DcMotor? = null
    private var backRightDrive: DcMotor? = null

    private var frontLeftSteer:Servo? = null
    private var frontRightSteer:Servo? = null
    private var backLeftSteer:Servo? = null
    private var backRightSteer:Servo? = null

    fun runOpMode() {
        // Initialize the hardware variables
        frontLeftDrive = hardwareMap.get(DcMotor::class.java, "front_left_drive")
        frontRightDrive = hardwareMap.get(DcMotor::class.java, "front_right_drive")
        backLeftDrive = hardwareMap.get(DcMotor::class.java, "back_left_drive")
        backRightDrive = hardwareMap.get(DcMotor::class.java, "back_right_drive")

        frontLeftSteer = hardwareMap.get(Servo::class.java, "front_left_steer")
        frontRightSteer = hardwareMap.get(Servo::class.java, "front_right_steer")
        backLeftSteer = hardwareMap.get(Servo::class.java, "back_left_steer")
        backRightSteer = hardwareMap.get(Servo::class.java, "back_right_steer")

    //Wait for game to start (driver presses PLAY)
    waitForStart()

        //Run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            //Example control logic for swerve drive
            val drive: Double = -gamepad1.left_stick_y // Forward/backward
            val strafe: Double = gamepad1.left_stick_x // Left/right
            val rotate: Double = gamepad1.right_stick_x // Rotation

            //Calculate the power for each wheel
            val frontLeftPower = drive + strafe + rotate
            val frontRightPower = drive - strafe - rotate
            val backLeftPower = drive - strafe + rotate
            val backRightPower = drive + strafe - rotate

            //Set the power to the motors
            frontLeftDrive.setPower(frontLeftPower)
            frontRightDrive.setPower(frontRightPower)
            backLeftDrive.setPower(backLeftPower)
            backRightDrive.setPower(backRightPower)

            //Example steering logic (simplified)
            frontLeftSteer.setPosition(0.5) // Adjust as needed
            frontRightSteer.setPosition(0.5) // Adjust as needed
            backLeftSteer.setPosition(0.5) // Adjust as needed
            backRightSteer.setPosition(0.5) // Adjust as needed
    }

    }
}
