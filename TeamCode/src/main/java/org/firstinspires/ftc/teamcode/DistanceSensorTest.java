package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.drive.tank.SampleTankDriveBase;
@Autonomous
public class DistanceSensorTest extends LinearOpMode {
    ModernRoboticsI2cRangeSensor rangeSensor;
    ModernRoboticsI2cRangeSensor rangeSensor2;

    DcMotor leftFront = null;
    DcMotor rightFront = null;
    DcMotor leftBack = null;
    DcMotor rightBack = null;

    double currentRangeL = 0;
    double currentRangeR = 0;

    boolean getOut = false;

    private DistanceSensor sensorRange;
    public void runOpMode() throws InterruptedException {
        rangeSensor = hardwareMap.get(ModernRoboticsI2cRangeSensor.class,"rangeL");
        rangeSensor2 = hardwareMap.get(ModernRoboticsI2cRangeSensor.class,"rangeR");
        leftFront = hardwareMap.get(DcMotor.class, "lf");
        rightFront = hardwareMap.get(DcMotor.class, "rf");
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack = hardwareMap.get(DcMotor.class, "lb");
        rightBack = hardwareMap.get(DcMotor.class, "rb");
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);

        rightFront.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.FORWARD);
        //sensorRange = hardwareMap.get(DistanceSensor.class,"range2");
        waitForStart();

        while (opModeIsActive() && !getOut) {
            currentRangeL = rangeSensor.getDistance(DistanceUnit.INCH);
            currentRangeR = rangeSensor2.getDistance(DistanceUnit.INCH);
//            telemetry.addData("Close Enough!: ",Math.abs(currentRangeL - currentRangeR) );
//            telemetry.addData("Range Left: ",rangeSensor.getDistance(DistanceUnit.INCH));
//            telemetry.addData("Range Right:", rangeSensor2.getDistance(DistanceUnit.INCH));
//            telemetry.update();

            if(currentRangeL < currentRangeR) {
                leftFront.setPower(-0.3);
                leftBack.setPower(-0.3);
                rightFront.setPower(0.3);
                rightBack.setPower(0.3);

                telemetry.addData("Range Left: ",rangeSensor.getDistance(DistanceUnit.INCH));
                telemetry.addData("Range Right:", rangeSensor2.getDistance(DistanceUnit.INCH));
                telemetry.update();
            }
            else if(currentRangeR < currentRangeL) {
                leftFront.setPower(0.3);
                leftBack.setPower(0.3);
                rightFront.setPower(-0.3);
                rightBack.setPower(-0.3);


                telemetry.addData("Range Left: ",rangeSensor.getDistance(DistanceUnit.INCH));
                telemetry.addData("Range Right:", rangeSensor2.getDistance(DistanceUnit.INCH));
                telemetry.update();
            }
            else if(Math.abs(currentRangeL - currentRangeR) < 0.1) {
                telemetry.addData("Close Enough!: ",Math.abs(currentRangeL - currentRangeR) );
                telemetry.addData("Range Left: ",rangeSensor.getDistance(DistanceUnit.INCH));
                telemetry.addData("Range Right:", rangeSensor2.getDistance(DistanceUnit.INCH));
                telemetry.update();

                leftFront.setPower(0);
                leftBack.setPower(0);
                rightFront.setPower(0);
                rightBack.setPower(0);

                getOut = true;
            }

        }

    }
}
