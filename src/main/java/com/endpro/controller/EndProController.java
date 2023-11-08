package com.endpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.endpro.dao.EndProDao;
import com.endpro.entity.EndPro;
import com.endpro.service.EndProService;

@RestController
public class EndProController {
	@Autowired
	EndProService es;

	@Autowired
	RestTemplate rt;

	@PostMapping(value = "getlist")
	public String getList(@RequestBody List<EndPro> a) {
		return es.getlist(a);
	}

	@GetMapping(value = "xxx")
	public List<EndPro> setprice() {
		String url1 = "http://localhost:8081/putname";
		String url2 = "http://localhost:8081/getdis/";
		ResponseEntity<List<EndPro>> ab = rt.exchange(url1, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<EndPro>>() {
				});
		List<EndPro> abc = ab.getBody();
		abc.forEach(x -> {
			int h = x.getHsn();
			ResponseEntity<Integer> a1 = rt.exchange(url2 + h, HttpMethod.GET, null, Integer.class);
			Integer ac = a1.getBody();
			x.setPrice(x.getPrice() - x.getPrice() * ac / 100);
		});

		return abc;
	}

	@PostMapping(value = "setvalue")
	public String saveData() {
		List<EndPro> ep = setprice();
		return es.saveData(ep);
	}
}