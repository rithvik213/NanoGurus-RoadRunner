package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.drive.tank.SampleTankDriveBase;
@Autonomous
public class DistanceSensorTest extends LinearOpMode {
    ModernRoboticsI2cRangeSensor rangeSensor;
    private DistanceSensor sensorRange;
    public void runOpMode() throws InterruptedException {
        rangeSensor = hardwareMap.get(ModernRoboticsI2cRangeSensor.class,"range");
        sensorRange = hardwareMap.get(DistanceSensor.class,"range2");
        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("Range: ",rangeSensor.getDistance(DistanceUnit.INCH));
            telemetry.addData("REV Range:", sensorRange.getDistance(DistanceUnit.INCH));
            telemetry.update();
        }

    }
}
