package com.personal.readings.my.library.model;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Book { 

	private int id;
	private String name;
	private String author;
	private String genre;

	private enum status {
		TO_READ, READING, FINISHED
	}

	private Date startDate;
	private Date endDate;
	private int rating;
	private String comments;

}
