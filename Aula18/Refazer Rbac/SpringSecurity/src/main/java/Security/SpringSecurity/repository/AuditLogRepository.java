package Security.SpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Security.SpringSecurity.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
	
}