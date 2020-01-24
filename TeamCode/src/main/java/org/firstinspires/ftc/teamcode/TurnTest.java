package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;

@Autonomous
public class TurnTest extends LinearOpMode {

    HardwareBot robot;

    public void runOpMode() throws InterruptedException {
        robot = new HardwareBot(this);

        waitForStart();

        //robot.drive.turnIMU(90.0,100000,false);
        //robot.drive.turnIMUThreeWheel(82,0.3,false);
//        while(opModeIsActive()) {
//            float angles = robot.drive.imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle;
//            telemetry.addData("Current Angle: ", (int) angles);
//            telemetry.update();
//        }
        robot.drive.turnIMUTest(30,0.3,false);
        robot.drive.moveDistance(2,0.4,true);
        robot.drive.turnIMUTest(30,0.3,true);
    }
}
