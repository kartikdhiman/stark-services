package com.kartikdhiman.customer;

public record CustomerRegistrationRequest(
				String firstName,
				String lastName,
				String email
) {
}
