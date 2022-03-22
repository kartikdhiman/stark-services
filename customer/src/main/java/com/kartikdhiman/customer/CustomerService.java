package com.kartikdhiman.customer;

import com.kartikdhiman.clients.fraud.FraudClient;
import com.kartikdhiman.clients.notification.NotificationClient;
import com.kartikdhiman.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerService {
	private final CustomerRepository customerRepository;
	private final FraudClient fraudClient;
	private final NotificationClient notificationClient;

	public void registerCustomer(CustomerRegistrationRequest request) {
		var customer = Customer.builder()
						.firstName(request.firstName())
						.lastName(request.lastName())
						.email(request.email())
						.build();
		// check if valid email
		// check if email not taken
		customerRepository.saveAndFlush(customer);

		var fraudster = fraudClient.isFraudster(customer.getId());
		if (fraudster.isFraudulent()) {
			throw new IllegalStateException("fraudster");
		}

		// make it async, i.e. add it to queue
		notificationClient.sendNotification(
						new NotificationRequest(
										customer.getId(),
										customer.getEmail(),
										"Hi %s, welcome to Stark Industries ✨".formatted(customer.getFirstName())
						)
		);
	}
}
