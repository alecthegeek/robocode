/*******************************************************************************
 * Copyright (c) 2001-2012 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/epl-v10.html
 *
 * Contributors:
 *     Mathew A. Nelson
 *     - Initial implementation
 *******************************************************************************/
package com.papercut.robot;


import robocode.HitByBulletEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import java.util.Random;


/**
 * MyFirstRobot - a sample robot by Mathew Nelson
 * <p/>
 * Moves in a seesaw motion, and spins the gun around at each end
 */
public class Jones extends Robot {

	/**
	 * MyFirstRobot's run method - Seesaw
	 */
	
	public void run() {
        Random generator = new Random();
		while (true) {
			ahead(generator.nextInt(100)); // Move ahead max 100
			turnGunRight(generator.nextInt(45)); // Spin gun around
			turnRight(generator.nextInt(110)); // Spin tank around
			//back(generator.nextInt(100)); // Move back max 100
			//turnGunRight(generator.nextInt(45)); // Spin gun around
		}
	}

	/**
	 * Fire when we see a robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(7);
	}

	/**
	 * We were hit!  Turn perpendicular to the bullet,
	 * so our seesaw might avoid a future shot.
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		turnLeft(110 - e.getBearing());
	}				
}