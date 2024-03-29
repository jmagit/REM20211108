package com.example.domains.entities.dtos;

import org.hibernate.validator.constraints.Length;

import com.example.domains.entities.Actor;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ActorDTO {
	@JsonProperty("id")
	private int actorId;
	@Length(min = 2, max = 45)
	@JsonProperty("nombre")
	private String firstName;
	@JsonProperty("apellidos")
	private String lastName;
	
	public static ActorDTO from(Actor source) {
		return new ActorDTO(
				source.getActorId(),
				source.getFirstName(),
				source.getLastName()
				);
	}
	
	public static Actor from(ActorDTO source) {
		return new Actor(
				source.getActorId(),
				source.getFirstName(),
				source.getLastName()
				);
	}
}
