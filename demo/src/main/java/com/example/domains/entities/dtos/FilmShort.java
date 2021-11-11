package com.example.domains.entities.dtos;

import com.example.domains.entities.Film;

import lombok.Value;

@Value
public class FilmShort {
	private int filmId;
	private String title;
	
	public static FilmShort from(Film source) {
		return new FilmShort(source.getFilmId(), source.getTitle());
	}
}
