package com.ray.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "RestProduct")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_entity_seq")
	@SequenceGenerator(name = "my_entity_seq", sequenceName = "my_rest_sequence", initialValue = 1000, allocationSize = 1)
	private Integer pid;
	@NonNull
	@Column(length = 20)
	private String pname;
	@NonNull
	@Column(length = 20)
	private String brand;
	@NonNull
	private Double price;
	@NonNull
	@Column(length = 20)
	private String manufacturer;

}
