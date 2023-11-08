package com.endpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.endpro.dao.EndProDao;
import com.endpro.entity.EndPro;

@Service
public class EndProService {
	@Autowired
	EndProDao ed;

	public String saveData(List<EndPro> ep) {

		return ed.saveData(ep);
	}

	public String getlist(List<EndPro> a) {

		return ed.getlist(a);
	}

}
