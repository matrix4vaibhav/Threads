package com.org.basic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadCheck tc = new ThreadCheck();
		tc.testSchedulePool();
		// tc.runScheduleThread();
		new Thread(() -> {
			tc.speak();
		}).start();
		System.out.println("MAIN ends.");
	}

	/*
	 * Runs scheduled thread
	 */
	private void runScheduleThread() {
		ScheduledExecutorService sch = Executors.newScheduledThreadPool(1);

		Runnable run = new Runnable() {

			@Override
			public void run() {
				System.out.println("In running thread.");
			}
		};

		// this job will run after every 4 seconds
		sch.scheduleAtFixedRate(run, 0, 4, TimeUnit.SECONDS);
	}

	private void speak() {
		try {
			for (int i = 0; i < 2; i++) {
				Thread.sleep(5000);
				System.out.println("I am speaking...");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * ScheduledThreadPoolExecutor check
	 */
	private void testSchedulePool() {
		ScheduledThreadPoolExecutor sch = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);

		Runnable run = new Runnable() {
			@Override
			public void run() {
				System.out.println("Breaking news...");
			}
		};
		sch.scheduleAtFixedRate(run, 0, 5, TimeUnit.SECONDS);
	}

}
