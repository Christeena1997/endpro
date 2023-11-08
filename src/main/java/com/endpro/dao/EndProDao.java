package com.endpro.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.endpro.entity.EndPro;
import com.endpro.repository.EndProRepository;

@Repository
public class EndProDao {
	@Autowired
	EndProRepository ex;

	public String saveData(List<EndPro> ep) {
		ex.saveAll(ep);
		return "successfully";
	}

	public String getlist(List<EndPro> a) {
		ex.saveAll(a);
		return "list save";
	}

}
