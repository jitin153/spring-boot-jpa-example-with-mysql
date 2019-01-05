package com.jitin.springbootjpaexamplewithmysql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Response<T> {
	private T result;
	private Boolean isError;
}
