package com.app.service;

import java.util.List;

import com.app.pojos.AvailableDates;

public interface IAvailableDatesService {
	AvailableDates addDates(AvailableDates a);

	List<AvailableDates> getAllAvailableDates();
}
