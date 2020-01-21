package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import static org.firstinspires.ftc.teamcode.BlueNear.sleep;

@Config
@Autonomous
public class RedNear extends LinearOpMode {
    HardwareBot robot;
    ElapsedTime timer;
    int pattern  = 0;

    FtcDashboard dashboard = FtcDashboard.getInstance();
    Telemetry dashboardTelemetry = dashboard.getTelemetry();

    //Path1
    public static double MOVE_DISTANCE_STEP1_PATH1 = 7;
    public static double TURN_IMU_STEP2_PATH1 = 5;
    public static double MOVE_DISTANCE_STEP3_PATH1 = 21;
    public static double TURN_IMU_STEP4_PATH1 = 5;
    public static double MOVE_DISTANCE_STEP5_PATH1 = 28;
    public static double CURVE_TURN_ANGLE_STEP6_PATH1 = 92;
    public static double MOVE_DISTANCE_STEP7_PATH1 = 56;
    public static double MOVE_DISTANCE_STEP8_PATH1 = 58;
    public static double TURN_ONESIDE_STEP9_PATH1 = 90;
    public static double MOVE_DISTANCE_STEP10_PATH1 = 5;
    public static double MOVE_DISTANCE_STEP11_PATH1 = 19;
    public static double TURN_IMU_STEP12_PATH1 = 85;
    public static double MOVE_DISTANCE_STEP13_PATH1 = 45;
    public static double MOVE_DISTANCE_STEP14_PATH1 = 6;
    public static double TURN_IMUONESIDE_STEP15_PATH1 = 90;
    public static double MOVE_DISTANCE_STEP16_PATH1 = 10;
    public static double TURN_IMU_STEP17_PATH1 = 85;


//    public static double MOVE_DISTANCE_STEP1_PATH1 = 7;
//    public static double TURN_IMU_STEP2_PATH1 = 4;
//    public static double MOVE_DISTANCE_STEP3_PATH1 = 21;
//    public static double TURN_IMU_STEP4_PATH1 = 5;
//    public static double MOVE_DISTANCE_STEP5_PATH1 = 28;
//    public static double CURVE_TURN_ANGLE_STEP6_PATH1 = 92;
//    public static double MOVE_DISTANCE_STEP7_PATH1 = 56;
//    public static double MOVE_DISTANCE_STEP8_PATH1 = 58;
//    public static double TURN_ONESIDE_STEP9_PATH1 = 90;
//    public static double MOVE_DISTANCE_STEP10_PATH1 = 5;
//    public static double MOVE_DISTANCE_STEP11_PATH1 = 19;
//    public static double TURN_IMU_STEP12_PATH1 = 85;
//    public static double MOVE_DISTANCE_STEP13_PATH1 = 45;
//    public static double MOVE_DISTANCE_STEP14_PATH1 = 6;
//    public static double TURN_IMUONESIDE_STEP15_PATH1 = 90;
//    public static double MOVE_DISTANCE_STEP16_PATH1 = 10;
//    public static double TURN_IMU_STEP17_PATH1 = 85;



//    public static double RED_TURN_ONESIDE_STEP1_PATH1 = 10;
//    public static double RED_MOVE_DISTANCE_STEP2_PATH1 = 22;
//    public static double RED_TURN_ONESIDE_STEP3_PATH1 = 10;
//    public static double RED_MOVE_DISTANCE_STEP4_PATH1 = 20;
//    public static double RED_CURVE_TURN_ANGLE_STEP5_PATH1 = 90;
//    public static double RED_MOVE_DISTANCE_STEP6_PATH1 = 58;
//    public static double RED_MOVE_DISTANCE_STEP7_PATH1 = 54;
//    public static double RED_TURN_ONESIDE_STEP8_PATH1 = 87;
//    public static double RED_MOVE_DISTANCE_STEP9_PATH1 = 5;
//    public static double RED_MOVE_DISTANCE_STEP10_PATH1 = 10;
//    public static double RED_TURN_IMU_STEP11_PATH1 = 85;
//    public static double RED_MOVE_DISTANCE_STEP12_PATH1 = 45;
//    public static double RED_MOVE_DISTANCE_STEP13_PATH1 = 8;

    //Path 2
    public static double MOVE_DISTANCE_STEP1_PATH2 = 4;
    public static double TURN_IMU_STEP2_PATH2 = 40;
    public static double MOVE_DISTANCE_STEP3_PATH2 = 24;
    public static double TURN_IMU_STEP4_PATH2 = 36;
    public static double MOVE_DISTANCE_STEP5_PATH2 = 5;
    public static double MOVE_DISTANCE_STEP6_PATH2 = 26;
    public static double CURVE_TURN_ANGLE_STEP7_PATH2 = 90;
    public static double MOVE_DISTANCE_STEP8_PATH2 = 58;
    public static double MOVE_DISTANCE_STEP9_PATH2 = 54;
    public static double TURN_ONESIDE_STEP10_PATH2 = 90;
    public static double MOVE_DISTANCE_STEP11_PATH2 = 6;
    public static double MOVE_DISTANCE_STEP12_PATH2 = 12;
    public static double TURN_IMU_STEP13_PATH2 = 90;
    public static double MOVE_DISTANCE_STEP14_PATH2 = 58;
    public static double MOVE_DISTANCE_STEP15_PATH2 = 6;

//    public static double RED_MOVE_DISTANCE_STEP1_PATH2 = 5;
//    public static double RED_TURN_IMU_STEP2_PATH2 = 41;
//    public static double RED_MOVE_DISTANCE_STEP3_PATH2 = 21;
//    public static double RED_TURN_ONESIDE_STEP4_PATH2 = 41;
//    public static double RED_MOVE_DISTANCE_STEP5_PATH2 = 2;
//    public static double RED_MOVE_DISTANCE_STEP6_PATH2 = 20;
//    public static double RED_CURVE_TURN_ANGLE_STEP7_PATH2 = 90;
//    public static double RED_MOVE_DISTANCE_STEP8_PATH2 = 72;
//    public static double RED_MOVE_DISTANCE_STEP9_PATH2 = 63;
//    public static double RED_TURN_ONESIDE_STEP10_PATH2 = 89;
//    public static double RED_MOVE_DISTANCE_STEP11_PATH2 = 9;
//    public static double RED_MOVE_DISTANCE_STEP12_PATH2 = 16;
//    public static double RED_TURN_IMU_STEP13_PATH2 = 84;
//    public static double RED_MOVE_DISTANCE_STEP14_PATH2 = 52;
//    public static double RED_MOVE_DISTANCE_STEP15_PATH2 = 10;

    //Path 3

    public static double MOVE_DISTANCE_STEP1_PATH3 = 4;
    public static double TURN_IMU_STEP2_PATH3 = 24;
     public static double MOVE_DISTANCE_STEP3_PATH3 = 20;
    public static double TURN_IMU_STEP4_PATH3 = 25;
    public static double MOVE_DISTANCE_STEP5_PATH3 = 4;
    public static double MOVE_DISTANCE_STEP6_PATH3 = 10;
    public static double CURVE_TURN_ANGLE_STEP7_PATH3 = 92;
    public static double MOVE_DISTANCE_STEP8_PATH3 = 60;
    public static double MOVE_DISTANCE_STEP9_PATH3 = 42;
    public static double TURN_ONESIDE_STEP10_PATH3 = 87;
    public static double MOVE_DISTANCE_STEP11_PATH3 = 8;
    public static double MOVE_DISTANCE_STEP12_PATH3 = 11;
    public static double TURN_IMU_STEP13_PATH3 = 86;
    public static double MOVE_DISTANCE_STEP14_PATH3 = 52;
    public static double MOVE_DISTANCE_STEP15_PATH3 = 7;


//    public static double MOVE_DISTANCE_STEP1_PATH3 = 4;
//    public static double TURN_IMU_STEP2_PATH3 = 24;
//    public static double MOVE_DISTANCE_STEP3_PATH3 = 18;
//    public static double TURN_ONESIDE_STEP4_PATH3 = 24;
//    public static double MOVE_DISTANCE_STEP5_PATH3 = 2;
//    public static double MOVE_DISTANCE_STEP6_PATH3 = 20;
//    public static double CURVE_TURN_ANGLE_STEP7_PATH3 = 90;
//    public static double MOVE_DISTANCE_STEP8_PATH3 = 64;
//    public static double MOVE_DISTANCE_STEP9_PATH3 = 53;
//    public static double TURN_ONESIDE_STEP10_PATH3 = 91;
//    public static double MOVE_DISTANCE_STEP11_PATH3 = 7;
//    public static double MOVE_DISTANCE_STEP12_PATH3 = 13;
//    public static double TURN_IMU_STEP13_PATH3 = 85;
//    public static double MOVE_DISTANCE_STEP14_PATH3 = 44;
//    public static double MOVE_DISTANCE_STEP15_PATH3 = 9;

    public void runOpMode() throws InterruptedException {
        robot = new HardwareBot(this);
        timer = new ElapsedTime();
        robot.camera.setAllianceColor("red");

        waitForStart();

        timer.reset();
        while (timer.seconds() <= 2 && !isStopRequested()) {
            telemetry.addData("Pattern: ",robot.camera.getPattern());
            pattern = robot.camera.getPattern();
            telemetry.addData("Timer: ", timer.seconds());
            telemetry.update();
        }

        switch (pattern) {
            case 1:
                //test
                robot.accessories.readyToGrabOrUnlatch();
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP1_PATH1,true);
                robot.drive.turnIMU(TURN_IMU_STEP2_PATH1,0.3,false);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP3_PATH1,true);
                sleep(sleep);
                robot.drive.turnIMU(TURN_IMU_STEP4_PATH1,0.3,true);
                robot.accessories.Grab();
                sleep(sleep);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP5_PATH1, false);
                robot.drive.turnIMU(CURVE_TURN_ANGLE_STEP6_PATH1,0.4,true); // initially false before 85
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP7_PATH1,true);  // initially true
                robot.accessories.readyToGrabOrUnlatch();
                sleep(sleep);

                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP8_PATH1,false);
                robot.drive.turnIMUOneSide(TURN_ONESIDE_STEP9_PATH1,0.4,false);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP10_PATH1,true);
                robot.accessories.Grab();
                sleep(sleep);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP11_PATH1,false);
                robot.drive.turnIMU(TURN_IMU_STEP12_PATH1,0.4,true);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP13_PATH1,true);
                robot.accessories.readyToGrabOrUnlatch();
                sleep(sleep);
                robot.drive.moveDistance(MOVE_DISTANCE_STEP14_PATH1,0.4,false);

                //robot.drive.moveDistance(4,0.4,true);
                //robot.drive.turnIMU(14,0.3,false);
                //robot.drive.turnIMUOneSide(43,0.3,false);
                //robot.drive.moveDistance(30,0.4,true);
                //robot.drive.turnIMU(14,0.3,true);
                //sleep(1000);
                //robot.drive.moveDistance(10,0.4,true);
                //robot.accessories.Grab();
                //robot.drive.moveDistance(1,0.3,true);
                //robot.accessories.Grab();
                //robot.drive.turnIMU(90,0.4,true);
                //robot.drive.moveDistance(8,0.4,true);

                /* PREVIOUS PATH WITH ROBOT LINED UP WITH RIGHT OF MAT
                robot.drive.moveDistance(2,0.4,true);
                robot.drive.turnIMU(28,0.55,false);
                robot.drive.moveDistance(25,0.3,true); //prev 27
                 */
                break;

            case 2:

                robot.accessories.readyToGrabOrUnlatch();
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP1_PATH2,true);
                robot.drive.turnIMU(TURN_IMU_STEP2_PATH2,0.3,false); //prev 37
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP3_PATH2,true);
                sleep(sleep);
                robot.drive.turnIMU(TURN_IMU_STEP4_PATH2,0.25,true);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP5_PATH2,true);
                robot.accessories.Grab();
                sleep(sleep);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP6_PATH2, false);
                //robot.drive.turnIMU(82,0.3,false);
                //robot.drive.turnIMUThreeWheel(82,0.3,false);
                robot.drive.turnIMUOneSideRevised(CURVE_TURN_ANGLE_STEP7_PATH2,true);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP8_PATH2,true);
                robot.accessories.readyToGrabOrUnlatch();
                sleep(sleep);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP9_PATH2,false);
                robot.drive.turnIMUOneSideRevised(TURN_ONESIDE_STEP10_PATH2,false);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP11_PATH2,true);
                robot.accessories.Grab();
                sleep(sleep);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP12_PATH2,false);
                robot.drive.turnIMU(TURN_IMU_STEP13_PATH2,0.4,true);
                robot.drive.moveDistance(MOVE_DISTANCE_STEP14_PATH2,0.4,true);
                robot.accessories.readyToGrabOrUnlatch();
                sleep(sleep);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP15_PATH2,false);


//                robot.accessories.readyToGrabOrUnlatch();
//                robot.drive.moveDistance(RED_MOVE_DISTANCE_STEP1_PATH2,0.4,true);
//                robot.drive.turnIMU(RED_TURN_IMU_STEP2_PATH2,0.3,false); //prev 37
//                robot.drive.moveDistance(RED_MOVE_DISTANCE_STEP3_PATH2,0.4,true);
//                sleep(500);
//                robot.drive.turnIMUOneSide(RED_TURN_ONESIDE_STEP4_PATH2,0.3,true);
//                robot.accessories.Grab();
//                sleep(700);
//                robot.drive.moveDistance(RED_MOVE_DISTANCE_STEP5_PATH2,0.4, false);
//                //PREVIOUS PIVOT TURN
//                //robot.drive.Auto2ndTurnRed(90,0.3);
//                robot.drive.turnIMUOneSide(RED_CURVE_TURN_ANGLE_STEP7_PATH2,0.3,true);
//                //robot.drive.turnIMUThreeWheel(90,0.3,true);
//                robot.drive.moveDistance(RED_MOVE_DISTANCE_STEP8_PATH2,0.4,true);
//                robot.accessories.readyToGrabOrUnlatch();
//                sleep(700);
//                robot.drive.moveDistance(RED_MOVE_DISTANCE_STEP9_PATH2,0.4,false);
//                robot.drive.turnIMUOneSide(RED_TURN_ONESIDE_STEP10_PATH2,0.4,false);
//                robot.drive.moveDistance(RED_MOVE_DISTANCE_STEP11_PATH2,0.4,true);
//                robot.accessories.Grab();
//                sleep(700);
//                robot.drive.moveDistance(RED_MOVE_DISTANCE_STEP12_PATH2,0.4,false);
//                robot.drive.turnIMU(RED_TURN_IMU_STEP13_PATH2,0.4,true);
//                robot.drive.moveDistance(RED_MOVE_DISTANCE_STEP14_PATH2,0.4,true);
//                robot.accessories.readyToGrabOrUnlatch();
//                sleep(700);
//                robot.drive.moveDistance(RED_MOVE_DISTANCE_STEP15_PATH2,0.4,false);


                /*robot.drive.moveDistance(30,0.4,true);
                robot.accessories.Grab();
                sleep(2000);
                robot.drive.moveDistance(7,0.4, false);
                robot.drive.turnIMU(90,0.4,true);
                robot.drive.moveDistance(47,0.4,true);
                robot.accessories.readyToGrabOrUnlatch();
                sleep(2000);
                //robot.drive.turnIMU(10,0.4,false);
                robot.drive.moveDistance(60,0.4,false);
                sleep(1000);
                robot.drive.turnIMU(90,0.4,false);
                */

                //robot.drive.moveDistance(8,0.4,false);
                //robot.drive.turnIMU(94,0.4,true);
                //robot.drive.resetEncoders();
                //robot.drive.runWithoutEncoders();
                //robot.drive.moveDistance(10, 0.4, true);
                /* PREVIOUS PATH WITH ROBOT LINED UP WITH RIGHT OF MAT
                robot.drive.moveDistance(10,0.4,true);
                //wait(1000);
                robot.drive.turnIMU(9,0.3,false);
                //wait(1000);
                //robot.drive.moveDistance(22, 0.3, true); //prev 28
                //robot.drive.turnIMU(9,0.3,false);
                //robot.drive.moveDistance(2,0.4,false);
                //robot.drive.turnIMU(90,0.4,false);
                //robot.drive.turnIMU(90,0.4,false);
                 */
                break;

            case 3:
                robot.accessories.readyToGrabOrUnlatch();
                //robot.drive.turn
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP1_PATH3,true);
                robot.drive.turnIMURed(TURN_IMU_STEP2_PATH3,0.3,false);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP3_PATH3,true);
                sleep(sleep);
                robot.drive.turnIMURed(TURN_IMU_STEP4_PATH3,0.25,true);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP5_PATH3,true);
                robot.accessories.Grab();
                sleep(sleep);

                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP6_PATH3, false);
                robot.drive.turnIMU(CURVE_TURN_ANGLE_STEP7_PATH3,0.3,true);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP8_PATH3,true);
                robot.accessories.readyToGrabOrUnlatch();
                sleep(sleep);

                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP9_PATH3,false);
                robot.drive.turnIMUOneSide(TURN_ONESIDE_STEP10_PATH3,0.4,false);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP11_PATH3,true);
                robot.accessories.Grab();
                sleep(sleep);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP12_PATH3,false);
                robot.drive.turnIMU(TURN_IMU_STEP13_PATH3,0.4,true);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP14_PATH3,true);
                robot.accessories.readyToGrabOrUnlatch();
                sleep(sleep);
                robot.drive.moveDistanceRevised(MOVE_DISTANCE_STEP15_PATH3,false);
//
//                robot.accessories.readyToGrabOrUnlatch();
//                robot.drive.moveDistance(MOVE_DISTANCE_STEP1_PATH3,0.4,true);
//                robot.drive.turnIMU(TURN_IMU_STEP2_PATH3,0.4,false);
//                robot.drive.moveDistance(MOVE_DISTANCE_STEP3_PATH3,0.4,true);
//                robot.drive.turnIMUOneSide(TURN_ONESIDE_STEP4_PATH3,0.4,true);
//                robot.drive.moveDistance(MOVE_DISTANCE_STEP5_PATH3,0.4,true);
//                robot.accessories.Grab();
//                sleep(700);
//                robot.drive.moveDistance(MOVE_DISTANCE_STEP6_PATH3,0.4, false);
//                robot.drive.turnIMUOneSide(CURVE_TURN_ANGLE_STEP7_PATH3,0.4,true);
//                robot.drive.moveDistance(MOVE_DISTANCE_STEP8_PATH3,0.4,true);
//                robot.accessories.readyToGrabOrUnlatch();
//                sleep(700);
//                robot.drive.moveDistance(MOVE_DISTANCE_STEP9_PATH3,0.4,false);
//                robot.drive.turnIMUOneSide(TURN_ONESIDE_STEP10_PATH3,0.4,false);
//                robot.drive.moveDistance(MOVE_DISTANCE_STEP11_PATH3,0.4,true);
//                robot.accessories.Grab();
//                sleep(700);
//                robot.drive.moveDistance(MOVE_DISTANCE_STEP12_PATH3,0.4,false);
//                robot.drive.turnIMU(TURN_IMU_STEP13_PATH3,0.4,true);
//                robot.drive.moveDistance(MOVE_DISTANCE_STEP14_PATH3,0.4,true);
//                robot.accessories.readyToGrabOrUnlatch();
//                sleep(700);
//                robot.drive.moveDistance(MOVE_DISTANCE_STEP15_PATH3,0.4,false);

                /*robot.drive.moveDistance(4,0.4,true);
                robot.drive.turnIMU(17,0.3,true);
                robot.drive.moveDistance(40,0.4,true);
                robot.accessories.readyToGrabOrUnlatch();
                robot.drive.turnIMU(17,0.4,false);
                //robot.drive.resetEncoders();
                //robot.drive.runWithoutEncoders();
                robot.drive.moveDistance(3,0.4,true);
                robot.accessories.Grab();
                robot.drive.turnIMU(90,0.4,true);
                robot.drive.moveDistance(10,0.4,true);
                */

                /* PREVIOUS PATH WITH ROBOT LINED UP WITH RIGHT OF MAT
                robot.drive.moveDistance(2, 0.4, true);
                robot.drive.turnIMU(10, 0.4, false);
                robot.drive.moveDistance(10, 0.3, true); //prev 27
                 */
                break;

            default:
                telemetry.addData("No skystone found: ", pattern);
        }
    }
}
