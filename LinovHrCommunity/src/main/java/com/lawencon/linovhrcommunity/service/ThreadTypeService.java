package com.lawencon.linovhrcommunity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.linovhrcommunity.dao.ThreadTypeDao;
import com.lawencon.linovhrcommunity.dto.threadtype.DeleteByIdThreadTypeRes;
import com.lawencon.linovhrcommunity.dto.threadtype.GetAllThreadTypeDtoDataRes;
import com.lawencon.linovhrcommunity.dto.threadtype.GetAllThreadTypeDtoRes;
import com.lawencon.linovhrcommunity.dto.threadtype.GetByIdThreadTypeDtoDataRes;
import com.lawencon.linovhrcommunity.dto.threadtype.GetByIdThreadTypeDtoRes;
import com.lawencon.linovhrcommunity.dto.threadtype.InsertThreadTypeDtoDataRes;
import com.lawencon.linovhrcommunity.dto.threadtype.InsertThreadTypeDtoReq;
import com.lawencon.linovhrcommunity.dto.threadtype.InsertThreadTypeDtoRes;
import com.lawencon.linovhrcommunity.dto.threadtype.UpdateThreadTypeDtoDataRes;
import com.lawencon.linovhrcommunity.dto.threadtype.UpdateThreadTypeDtoReq;
import com.lawencon.linovhrcommunity.dto.threadtype.UpdateThreadTypeDtoRes;
import com.lawencon.linovhrcommunity.model.ThreadType;

@Service
public class ThreadTypeService extends BaseServiceLinovCommunityImpl {

	private ThreadTypeDao threadTypeDao;
	
	@Autowired
	public ThreadTypeService(ThreadTypeDao threadTypeDao) {
		this.threadTypeDao = threadTypeDao;
	}

	public InsertThreadTypeDtoRes insert(InsertThreadTypeDtoReq dataReq) throws Exception {
		try {
			ThreadType newThreadType = new ThreadType();
			String threadTypeCode = dataReq.getCode();
			String threadTypeName = dataReq.getThreadTypeName();
			newThreadType.setCode(threadTypeCode);
			newThreadType.setThreadTypeName(threadTypeName);
			newThreadType.setCreatedBy("1");
			
			begin();
			newThreadType = threadTypeDao.save(newThreadType);			
			commit();
			
			InsertThreadTypeDtoDataRes dataRes = new InsertThreadTypeDtoDataRes();
			dataRes.setId(newThreadType.getId());
			
			InsertThreadTypeDtoRes insertRes = new InsertThreadTypeDtoRes();
			insertRes.setData(dataRes);
			insertRes.setMessage("Success Insert New ThreadType !");
			
			return insertRes;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
			throw new Exception(e);
		}
	}

	public UpdateThreadTypeDtoRes update(UpdateThreadTypeDtoReq dataReq) throws Exception {
		try {
			ThreadType editThreadType = threadTypeDao.findById(dataReq.getId());
			String threadTypeCode = dataReq.getCode();
			String threadTypeName = dataReq.getThreadTypeName();
			editThreadType.setCode(threadTypeCode);
			editThreadType.setThreadTypeName(threadTypeName);
			editThreadType.setUpdatedBy("1");
			editThreadType.setVersion(dataReq.getVersion());
			
			begin();
			editThreadType = threadTypeDao.save(editThreadType);			
			commit();
			
			UpdateThreadTypeDtoDataRes dataRes = new UpdateThreadTypeDtoDataRes();
			dataRes.setVersion(editThreadType.getVersion());
			
			UpdateThreadTypeDtoRes updateRes = new UpdateThreadTypeDtoRes();
			updateRes.setData(dataRes);
			updateRes.setMessage("Success Update ThreadType !");
			
			return updateRes;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
			throw new Exception(e);
		}
	}

	public GetByIdThreadTypeDtoRes findById(String id) throws Exception {
		ThreadType threadTypeById = threadTypeDao.findById(id);
		
		GetByIdThreadTypeDtoDataRes dataById = new GetByIdThreadTypeDtoDataRes();
		dataById.setId(threadTypeById.getId());
		dataById.setCode(threadTypeById.getCode());
		dataById.setThreadTypeName(threadTypeById.getThreadTypeName());
		dataById.setIsActive(threadTypeById.getIsActive());
		dataById.setVersion(threadTypeById.getVersion());
		
		GetByIdThreadTypeDtoRes findByIdRes = new GetByIdThreadTypeDtoRes();
		findByIdRes.setData(dataById);
		
		return findByIdRes;
	}

	public GetAllThreadTypeDtoRes findAll() throws Exception {
		List<ThreadType> listThreadTypes = new ArrayList<>();
		listThreadTypes = threadTypeDao.findAll();
		
		List<GetAllThreadTypeDtoDataRes> dataAll = new ArrayList<>();

		listThreadTypes.forEach(threadType -> {
			GetAllThreadTypeDtoDataRes data = new GetAllThreadTypeDtoDataRes();
			data.setId(threadType.getId());
			data.setCode(threadType.getCode());
			data.setThreadTypeName(threadType.getThreadTypeName());
			data.setIsActive(threadType.getIsActive());
			data.setVersion(threadType.getVersion());
			
			dataAll.add(data);
		});
		
		GetAllThreadTypeDtoRes findAllRes = new GetAllThreadTypeDtoRes();
		findAllRes.setData(dataAll);

		return findAllRes;
	}

	public DeleteByIdThreadTypeRes deleteById(String id) throws Exception {
		DeleteByIdThreadTypeRes delRes = new DeleteByIdThreadTypeRes();
		try {
			begin();
			boolean isDeleted = threadTypeDao.deleteById(id);
			commit();
			
			if(isDeleted) {
				delRes.setMessage("Delete Success !");
			}else {
				throw new Exception("Delete Failed !");
			}
			
			return delRes;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
			throw new Exception(e);
		}
	}

}