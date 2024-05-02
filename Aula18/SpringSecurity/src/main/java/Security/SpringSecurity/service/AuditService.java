package Security.SpringSecurity.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Security.SpringSecurity.entity.AuditLog;
import Security.SpringSecurity.repository.AuditLogRepository;

@Service
public class AuditService {
	    @Autowired
	    private AuditLogRepository auditLogRepository;
	    
	    private static final Logger logger = LoggerFactory.getLogger(AuditService.class);
	
	    public void logEvent(String eventName, String description, String userId, String resource, String origin) {
	    	 logger.info("Logging event: {}, Description: {}, User: {}, Resource: {}, Origin: {}", 
	    	            eventName, description, userId, resource, origin);
	    	 
	        AuditLog log = new AuditLog();
	        log.setEventName(eventName);
	        log.setEventDescription(description);
	        log.setTimestamp(new Date()); // Registro automático da data/hora atual
	        log.setUserId(userId); // ID do usuário (extraído do contexto de segurança)
	        log.setAffectedResource(resource); // Nome da classe ou método que foi afetado
	        log.setOrigin(origin); // Endereço IP de origem
	        auditLogRepository.save(log);
	    }
	}
