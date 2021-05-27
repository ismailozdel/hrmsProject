package com.example.demo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.JobService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.ErrorResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.JobDao;
import com.example.demo.entities.concretes.Job;
@Service
public class JobManager implements JobService{
	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jabDao) {
		super();
		this.jobDao = jabDao;
	}

	@Override
	public DataResult<List<Job>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Job>>(this.jobDao.findAll());
	}

	@Override
	public Result add(Job job) {
		List<Job> jobList = this.jobDao.findAll();
		for (Job job2 : jobList) {
			if(job2.getPosition().equals(job.getPosition())) {
				return new ErrorResult("Bu iş pozisyonu sistemde kayıtlı.");
			}
		}
		this.jobDao.save(job);
		return new SuccessResult("Eklendi");
	}
	
	
}
