package com.diego.shoping_list.compose.app_logo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Composable
fun AppLogo(): ImageVector = remember(Unit) {
    ImageVector.Builder(
        name = "AppLogo",
        defaultWidth = 72.dp,
        defaultHeight = 72.dp,
        viewportWidth = 1024f,
        viewportHeight = 1024f
    ).apply {
        // это фон логотипа
//        path(fill = SolidColor(Color(0xFFFFDCBB))) {
//            moveTo(0f, 0f)
//            horizontalLineToRelative(1024f)
//            verticalLineToRelative(1024f)
//            horizontalLineToRelative(-1024f)
//            close()
//        }
        path(fill = SolidColor(Color(0xFF2B1700))) {
            moveTo(271.8f, 286.3f)
            lineTo(225.7f, 286.4f)
            curveTo(193.4f, 286.4f, 187.5f, 292.8f, 187.7f, 258f)
            curveTo(188f, 219.1f, 201.4f, 191.9f, 243.7f, 188f)
            lineTo(584f, 188f)
            curveTo(598.2f, 188f, 613.6f, 186.9f, 627.6f, 189.1f)
            curveTo(681.5f, 197.6f, 674.1f, 256.7f, 674f, 296.1f)
            lineTo(674.1f, 456.2f)
            curveTo(674.1f, 465.3f, 677.2f, 493.1f, 670.5f, 499.9f)
            curveTo(656.1f, 514.5f, 649.4f, 493.4f, 649.4f, 480.1f)
            lineTo(649.5f, 268.9f)
            curveTo(649.6f, 214.1f, 642.3f, 212.3f, 584.8f, 212.3f)
            lineTo(286.7f, 212.3f)
            curveTo(296f, 228.4f, 296.4f, 237.8f, 296.4f, 255.8f)
            lineTo(296.3f, 391.6f)
            lineTo(296.3f, 695.1f)
            curveTo(296.2f, 770f, 301.3f, 767.1f, 369.5f, 767.1f)
            lineTo(492.9f, 767.1f)
            curveTo(497.5f, 767.1f, 502.4f, 766.7f, 507f, 767.1f)
            curveTo(519.6f, 768.3f, 526.6f, 791.2f, 500.2f, 791.5f)
            lineTo(348.6f, 791.5f)
            curveTo(338.6f, 791.5f, 327.5f, 792.2f, 317.6f, 789.9f)
            curveTo(267.1f, 778.3f, 271.7f, 731.7f, 271.7f, 693.2f)
            lineTo(271.8f, 286.3f)
            close()
            moveTo(238.6f, 212.3f)
            curveTo(213f, 221.7f, 212.2f, 238.1f, 212.5f, 261.9f)
            horizontalLineTo(246.7f)
            horizontalLineTo(271.8f)
            curveTo(272.4f, 232.5f, 270.7f, 217.4f, 238.6f, 212.3f)
            close()
        }
        path(fill = SolidColor(Color(0xFF2B1700))) {
            moveTo(412.1f, 273.8f)
            curveTo(405.4f, 273.7f, 396.8f, 274.5f, 390.4f, 272.4f)
            curveTo(378.1f, 268.5f, 380.7f, 254.3f, 391f, 250f)
            curveTo(401.4f, 249.6f, 424.7f, 246.8f, 420.1f, 264.7f)
            curveTo(419f, 269f, 415.9f, 271.6f, 412.1f, 273.8f)
            close()
        }
        path(fill = SolidColor(Color(0xFF2B1700))) {
            moveTo(493.7f, 273.8f)
            curveTo(485.3f, 274.3f, 447f, 274.7f, 440.8f, 272.7f)
            curveTo(429.1f, 269f, 430.8f, 254.2f, 440.9f, 250f)
            curveTo(450.7f, 249.9f, 488f, 248.6f, 494.9f, 251f)
            curveTo(506.1f, 254.8f, 503f, 269.7f, 493.7f, 273.8f)
            close()
        }
        path(fill = SolidColor(Color(0xFF2B1700))) {
            moveTo(542.8f, 273.8f)
            curveTo(536.4f, 274f, 526.1f, 274.8f, 520.3f, 272.1f)
            curveTo(510f, 267.4f, 513.7f, 252.8f, 523.5f, 250f)
            curveTo(529.8f, 249.9f, 538.2f, 248.8f, 544.1f, 250.8f)
            curveTo(556.7f, 255.1f, 552.7f, 269.3f, 542.8f, 273.8f)
            close()
        }
        path(fill = SolidColor(Color(0xFF2B1700))) {
            moveTo(366f, 380.9f)
            curveTo(375.6f, 372f, 393.8f, 348.2f, 404f, 343.3f)
            curveTo(407.3f, 343.1f, 410.1f, 343.2f, 413f, 344.9f)
            curveTo(432.4f, 356f, 402.9f, 377.9f, 395.1f, 386f)
            curveTo(372.2f, 409.7f, 372.1f, 422.7f, 347.6f, 398f)
            curveTo(342.4f, 393.2f, 333.4f, 386.7f, 332.5f, 379.5f)
            curveTo(331.6f, 372.4f, 337.2f, 365.9f, 344.4f, 365.8f)
            curveTo(352.3f, 365.8f, 360.5f, 375.7f, 366f, 380.9f)
            close()
        }
        path(fill = SolidColor(Color(0xFF2B1700))) {
            moveTo(602.7f, 386.7f)
            curveTo(574.4f, 387.1f, 546f, 386.7f, 517.7f, 386.7f)
            lineTo(487f, 386.7f)
            curveTo(480.1f, 386.7f, 471.2f, 388.3f, 464.9f, 384.7f)
            curveTo(453.8f, 378.3f, 460.1f, 363.9f, 470.9f, 362.1f)
            curveTo(499.1f, 361.3f, 527.5f, 362.1f, 555.6f, 362.1f)
            lineTo(587.2f, 362f)
            curveTo(596.6f, 362f, 613.6f, 359f, 614.8f, 372.6f)
            curveTo(615.6f, 381.1f, 610.8f, 385.9f, 602.7f, 386.7f)
            close()
        }
        path(fill = SolidColor(Color(0xFF2B1700))) {
            moveTo(366f, 501f)
            curveTo(372.9f, 493.5f, 397f, 467.3f, 404f, 463.8f)
            curveTo(414.1f, 463.3f, 424.1f, 471.1f, 417.9f, 481.9f)
            curveTo(414.7f, 487.4f, 380.7f, 521.5f, 374.5f, 526.8f)
            curveTo(361.9f, 537.5f, 358.8f, 528f, 347.5f, 520.5f)
            curveTo(343.4f, 515.1f, 334.3f, 508.6f, 333f, 502.1f)
            curveTo(331.7f, 495.4f, 337f, 488.1f, 343.8f, 487.4f)
            curveTo(351.6f, 486.6f, 360.4f, 496.6f, 366f, 501f)
            close()
        }
        path(fill = SolidColor(Color(0xFF2B1700))) {
            moveTo(507.2f, 507.4f)
            curveTo(498.7f, 507.4f, 470.3f, 509.4f, 464.4f, 504.5f)
            curveTo(456.3f, 497.6f, 460f, 485.1f, 470.1f, 483.4f)
            curveTo(480f, 481.8f, 491.6f, 482.9f, 501.6f, 482.9f)
            lineTo(567.4f, 482.9f)
            curveTo(576.8f, 482.9f, 598.4f, 481.5f, 606.2f, 483.2f)
            curveTo(618.8f, 485.9f, 618.1f, 505f, 605.4f, 507f)
            curveTo(595.7f, 508.5f, 583.7f, 507.4f, 573.6f, 507.4f)
            lineTo(507.2f, 507.4f)
            close()
        }
        path(fill = SolidColor(Color(0xFF2B1700))) {
            moveTo(614.4f, 620.7f)
            curveTo(614.1f, 568.1f, 634.7f, 527.4f, 691.4f, 520.6f)
            curveTo(717.9f, 516.7f, 746.2f, 530.5f, 763.4f, 549.9f)
            curveTo(781.8f, 570.7f, 785.3f, 593.9f, 783.7f, 620.7f)
            lineTo(818.8f, 620.6f)
            curveTo(883.1f, 620.6f, 881.3f, 639.7f, 871.1f, 696.9f)
            lineTo(849f, 819.4f)
            curveTo(837.2f, 886.9f, 815.8f, 887.5f, 756.8f, 887.5f)
            lineTo(709.9f, 887.4f)
            lineTo(640.8f, 887.5f)
            curveTo(583.7f, 887.5f, 564.2f, 888.5f, 551f, 822.6f)
            lineTo(525.8f, 691.9f)
            curveTo(515.2f, 635.3f, 523.5f, 620.5f, 581.6f, 620.6f)
            lineTo(614.4f, 620.7f)
            close()
            moveTo(691.4f, 545.7f)
            curveTo(648.3f, 552.3f, 639.5f, 582.4f, 639.8f, 620.7f)
            horizontalLineTo(709.9f)
            horizontalLineTo(758.6f)
            curveTo(759.4f, 598.3f, 759.3f, 582.2f, 743f, 564.9f)
            curveTo(729.7f, 550.9f, 710.8f, 542.7f, 691.4f, 545.7f)
            close()
            moveTo(558.2f, 645.6f)
            curveTo(546.5f, 647.6f, 543.8f, 656.4f, 545.8f, 667f)
            lineTo(576f, 821.2f)
            curveTo(584.9f, 864.6f, 591f, 862.6f, 637f, 862.6f)
            lineTo(758f, 862.5f)
            curveTo(781.8f, 862.5f, 807.8f, 867.4f, 819.2f, 840.7f)
            curveTo(821.9f, 833.4f, 822.9f, 825.4f, 824.2f, 817.7f)
            lineTo(845.2f, 699.8f)
            curveTo(847.2f, 688.7f, 859.4f, 651.2f, 846.5f, 646.6f)
            curveTo(839.6f, 644.2f, 764.4f, 645.6f, 750.6f, 645.6f)
            lineTo(558.2f, 645.6f)
            close()
        }
        path(fill = SolidColor(Color(0xFF2B1700))) {
            moveTo(366f, 624.3f)
            curveTo(373.3f, 616.9f, 398f, 588.9f, 405.9f, 587.1f)
            curveTo(409.7f, 587.5f, 412.9f, 588.4f, 415.7f, 591.1f)
            curveTo(427.6f, 602.4f, 409f, 615.9f, 401.7f, 623.3f)
            lineTo(379.2f, 646f)
            curveTo(364.1f, 661.2f, 359.9f, 652.9f, 347.6f, 639.7f)
            curveTo(342.1f, 635.2f, 333.4f, 628.9f, 333.3f, 621.3f)
            curveTo(333.2f, 614.4f, 339.2f, 608f, 346.3f, 608.5f)
            curveTo(353.9f, 609f, 361.2f, 619f, 366f, 624.3f)
            close()
        }
        path(fill = SolidColor(Color(0xFF2B1700))) {
            moveTo(459.5f, 615.5f)
            curveTo(461.3f, 607.5f, 464.2f, 603.8f, 472.7f, 603.2f)
            curveTo(481.4f, 603.2f, 500.6f, 601.3f, 507.7f, 605.8f)
            curveTo(519.1f, 613.1f, 511f, 626.5f, 500f, 627.8f)
            curveTo(485.6f, 627.8f, 464.1f, 633.8f, 459.5f, 615.5f)
            close()
        }
    }.build()
}
