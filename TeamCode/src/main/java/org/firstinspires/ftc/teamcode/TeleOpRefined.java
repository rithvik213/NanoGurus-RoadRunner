package org.firstinspires.ftc.teamcode;
//Imt com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcontroller.external.samples.SampleRevBlinkinLedDriver;
import org.firstinspires.ftc.robotcore.internal.system.Deadline;

import java.util.concurrent.TimeUnit;

@TeleOp
public class TeleOpRefined extends LinearOpMode {

    //HardwareBot robot;
    double left;
    double right;
    double drive;
    double turn;
    double max;

    DcMotor leftFront = null;
    DcMotor rightFront = null;
    DcMotor leftBack;
    DcMotor rightBack;

    //CRServo crservo = null;

    DcMotor slides = null;

    Servo clutch = null;
    double up = 0;
    double down = 0;
    Servo autoClutch = null;

    Servo foundationClutch = null;
    Servo foundationClutch2 = null;

    Deadline gamepadRateLimit;
    private final int GAMEPAD_LOCKOUT = 500;

    public void runOpMode() throws InterruptedException {
        //robot = new HardwareBot(this);

        /*Initializing the drivetrain motors*/
        leftFront = hardwareMap.get(DcMotor.class, "lf");
        rightFront = hardwareMap.get(DcMotor.class, "rf");
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack = hardwareMap.get(DcMotor.class, "lb");
        rightBack = hardwareMap.get(DcMotor.class, "rb");
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);

        /*Initializing the motor for the slides*/
        slides = hardwareMap.dcMotor.get("slides");
        slides.setDirection(DcMotorSimple.Direction.REVERSE);
        slides.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slides.setMode(DcMotor.RunMode.RUN_USING_ENCODER); //need to change to RUN_USING_ENCODER

        /*Initializing the clutch servos*/
        clutch = hardwareMap.get(Servo.class,"clutch");
        autoClutch = hardwareMap.servo.get("autoClutch");
        foundationClutch = hardwareMap.servo.get("foundation");
        foundationClutch2 = hardwareMap.servo.get("foundation2");

        gamepadRateLimit = new Deadline(GAMEPAD_LOCKOUT, TimeUnit.MILLISECONDS);

        waitForStart();

        while (!isStopRequested()) {

            drive = -gamepad1.left_stick_y;
            turn = gamepad1.right_stick_x;

            left = drive - turn;
            right = drive + turn;

            max = Math.max(Math.abs(left), Math.abs(right)); // sets max to the greatest motor power
            if (max > 1.0) {
                left /= max;
                right /= max;
            }

            /*SET UP SLIDES*/
            up = Range.clip(gamepad1.right_trigger + gamepad2.right_trigger, 0.0, 0.6);
            down = Range.clip(gamepad1.left_trigger + gamepad2.left_trigger, 0.0, 0.6);

            telemetry.addData("Up: ", up);
            telemetry.addData("Down: ", down);

            if(up > 0.1) {
                slides.setPower(up);
            }
            else if(down > 0.1) {
                slides.setPower(-down); // the input values are positive so need to add negative
            }
            else {
                slides.setPower(0);
            }

            leftFront.setPower(left);
            leftBack.setPower(left);
            rightFront.setPower(right);
            rightBack.setPower(right);

            if(gamepad1.right_bumper || gamepad2.right_bumper) {
                clutch.setPosition(0.2); // position clutch to collect stone
            }
            else if(gamepad1.left_bumper || gamepad2.left_bumper) {
                clutch.setPosition(0.7);// position clutch to deliver stone
            }

            if(gamepad1.a || gamepad2.a) {
                autoClutch.setPosition(1);
            }
            if(gamepad1.x || gamepad2.x) {
                autoClutch.setPosition(0.4);
            }

            if(gamepad1.dpad_up) {
                foundationClutch.setPosition(0.8);
                foundationClutch2.setPosition(0.7);
            }
            else if(gamepad1.dpad_down) {
                foundationClutch.setPosition(0);
                foundationClutch2.setPosition(0);
            }
        }
    }
}