package org.firstinspires.ftc.teamcode.Test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class DriveTest extends LinearOpMode {
    DcMotor leftFront = null;
    DcMotor rightFront = null;
    DcMotor leftBack;
    DcMotor rightBack;

    private ElapsedTime runtime = new ElapsedTime();

    public void runOpMode() throws InterruptedException {
        leftFront = hardwareMap.get(DcMotor.class, "lf");
        rightFront = hardwareMap.get(DcMotor.class, "rf");
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack = hardwareMap.get(DcMotor.class, "lb");
        rightBack = hardwareMap.get(DcMotor.class, "rb");
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);

        rightFront.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.FORWARD);

        waitForStart();

        while(opModeIsActive()) {
            if (gamepad1.x) {
                leftFront.setPower(0.4);
            }
            else {
                leftFront.setPower(0);
            }

            if(gamepad1.a) {
                leftBack.setPower(0.4);
            }
            else {
                leftBack.setPower(0);
            }

            if(gamepad1.y) {
                rightFront.setPower(0.4);
            }
            else if(gamepad1.dpad_down) {
                rightFront.setPower(-0.4);
            }
            else {
                rightFront.setPower(0);
            }

            if(gamepad1.b) {
                rightBack.setPower(0.4);
            }
            else if(gamepad1.dpad_up) {
                rightBack.setPower(-0.4);
            }
            else {
                rightBack.setPower(0);
            }

            telemetry.addData("Leftfront: ", leftFront.getCurrentPosition());
            telemetry.addData("Rightfront: ", rightFront.getCurrentPosition());
            telemetry.addData("Leftback: ", leftBack.getCurrentPosition());
            telemetry.addData("Rightback: ", rightBack.getCurrentPosition());
            telemetry.update();
        }
        //leftFront.setPower(0.4);
        //rightFront.setPower(0.4);
        //leftBack.setPower(0.4);
        //rightBack.setPower(0.4);

        runtime.reset();

        while(runtime.seconds() < 3 && opModeIsActive()) {
            telemetry.addData("Leftfront: ", leftFront.getCurrentPosition());
            telemetry.addData("Rightfront: ", rightFront.getCurrentPosition());
            telemetry.addData("Leftback: ", leftBack.getCurrentPosition());
            telemetry.addData("Rightback: ", rightBack.getCurrentPosition());
            telemetry.update();
        }

        leftFront.setPower(0);
        rightFront.setPower(0);
        leftBack.setPower(0);
        rightBack.setPower(0);

    }
}
