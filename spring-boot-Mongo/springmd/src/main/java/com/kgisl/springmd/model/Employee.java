package com.kgisl.springmd.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Document
public class Employee {
    @Id
	private String id;
	private String name;
	private String designation;
	private float age;
	private String place;
	
}
