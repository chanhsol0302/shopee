package com.example.donhang.model;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@PrimaryKeyClass
public class ChiTietDonHangKey implements Serializable {
	@PrimaryKeyColumn(name = "iddonhang", type = PrimaryKeyType.PARTITIONED)
	private UUID id;
	
	@PrimaryKeyColumn(name = "idsanpham", type = PrimaryKeyType.PARTITIONED)
	private String productId;
}