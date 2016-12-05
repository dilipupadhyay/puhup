/**
 * 
 */
package com.agr.puhup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Dilip Upadhyay
 *
 */
@Entity
@Table(name = "POINT")
public class Point {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private Integer AssignedPoint;

	@NotNull
	private Integer UsedPoint;

}
