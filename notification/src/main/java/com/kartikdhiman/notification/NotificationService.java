package com.kartikdhiman.notification;

import com.kartikdhiman.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class NotificationService {
	private NotificationRepository notificationRepository;

	public void sendNotification(NotificationRequest notificationRequest) {
		notificationRepository.save(
						Notification.builder()
										.toCustomerId(notificationRequest.toCustomerId())
										.toCustomerEmail(notificationRequest.toCustomerEmail())
										.sender("Tony Stark")
										.sentAt(LocalDateTime.now())
										.message(notificationRequest.message())
										.build()
		);
	}
}
