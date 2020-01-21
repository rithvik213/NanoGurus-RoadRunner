package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Autonomous
public class DriveStraightTest extends LinearOpMode {
    HardwareBot robot;

    public static double forwardDistance = 28;
    public static double backwardDistance  = 28;

    public void runOpMode() throws InterruptedException {
        robot = new HardwareBot(this);

        waitForStart();

        robot.drive.moveDistanceRevised(forwardDistance,true);
        sleep(400);
        robot.drive.moveDistanceRevised(backwardDistance,false);
        //sleep(400);
        //robot.drive.turnIMUOneSideRevised(40,true);
    }
}
