package org.apn.hadoop.mapreduce.movierating;

import org.apache.hadoop.mapred.jobcontrol.JobControl;

public class JobRunner implements Runnable {
	private JobControl control;

	public JobRunner(JobControl _control) {
		this.control = _control;
	}

	@Override
	public void run() {
		this.control.run();
	}
}