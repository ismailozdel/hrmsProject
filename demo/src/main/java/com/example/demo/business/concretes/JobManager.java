package com.example.demo.business.concretes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.JobService;
import com.example.demo.core.utilities.results.DataResult;
import com.example.demo.core.utilities.results.ErrorResult;
import com.example.demo.core.utilities.results.Result;
import com.example.demo.core.utilities.results.SuccessDataResult;
import com.example.demo.core.utilities.results.SuccessResult;
import com.example.demo.dataAccess.abstracts.JobDao;
import com.example.demo.entities.concretes.Job;
import com.example.demo.entities.concretes.JobList;
import com.example.demo.entities.dtos.JobDto;
@Service
public class JobManager implements JobService{
	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jabDao) {
		super();
		this.jobDao = jabDao;
	}

	@Override
	public SuccessDataResult<List<JobList>> getAll() {
		List<Job> job = this.jobDao.findAll();
		
		
		return new SuccessDataResult<List<JobList>>(jobResult(job),"Firmaya ait ilanlar listelendi");
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

	@Override
	public DataResult<List<JobList>> getByIsActivated() {
		List<Job> job = this.jobDao.getByIsActivated(true);
		return new SuccessDataResult<List<JobList>>(jobResult(job));
	}

	@Override
	public DataResult<List<JobList>> findByIsActivatedOrderByReleaseDateDesc() {
		List<Job> job = this.jobDao.findByIsActivatedOrderByReleaseDateDesc(true);
		return new SuccessDataResult<List<JobList>>(jobResult(job));
	}

	
	@Override
	public DataResult<List<JobList>> getByEmployerId(int id) {
		List<Job> job = this.jobDao.getByEmployerId_Id(id);
		
		
		return new SuccessDataResult<List<JobList>>(jobResult(job),"Firmaya ait ilanlar listelendi");
	}
	
	private List<JobList> jobResult(List<Job> job2) {
		List<JobList> list = new ArrayList<JobList>();
		
		for (Job job3 : job2) {
			JobList j = new JobList();
			j.setCompanyName(job3.getEmployerId().getCompanyName());
			j.setPosition(job3.getPosition());
			j.setAvaiblePositionNumber(job3.getAvaibleNumber());
			j.setReleaseDate(job3.getReleaseDate());
			j.setApplicationDeadline(job3.getApplicationDeadlinee());
			list.add(j);

			
		}
		return list;
	}


}
