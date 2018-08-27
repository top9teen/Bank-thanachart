package com.thanachart.demo.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thanachart.demo.Bean.MiradoBean;
import com.thanachart.demo.Bean.ThanachartPriceBean;
import com.thanachart.demo.Dao.KasikornServer;



@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ServerController {

	
	@Autowired
	KasikornServer kasikornServer;

	@RequestMapping(value="/th" , method = RequestMethod.POST)
	public ThanachartPriceBean kars(@RequestBody MiradoBean miradoBean) throws SQLException {
		ThanachartPriceBean ff = new ThanachartPriceBean();

		String a = miradoBean.getGroupType();
		String b = miradoBean.getCarMake2();
		ff = kasikornServer.checkpriceKa(a, b);
		return ff;
	}
}
