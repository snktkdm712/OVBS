package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.dao.IAvailableDates;
import com.app.pojos.AvailableDates;

@Service
public class AvailableDatesService implements IAvailableDatesService {

	@Autowired
	private IAvailableDates dao;

	@Override
	public AvailableDates addDates(AvailableDates availableDates) {
		return dao.save(availableDates);
	}

	@Override
	public List<AvailableDates> getAllAvailableDates() {
		return dao.findAll();
	}


}
