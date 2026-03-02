package com.boleia.boleia.infra.repository.notification;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.boleia.boleia.domain.model.Notification.OTPEntry;

public class InMemoryOtpRepository {
    
    // private final ConcurrentHashMap<String, OTPEntry> storage = new ConcurrentHashMap<>();

    
    // public void save(OTPEntry entry) {
    //     storage.put(entry.getPhoneNumber(), entry);
    // }

    // public OTPEntry findByPhoneNumber(String phoneNumber){
    //     return storage.get(phoneNumber);
    // }

    // public void delete(String phoneNumber){
    //     this.storage.remove(phoneNumber);
    // }

    // public void deleteIfExpired(String phoneNumber) {
    //     OTPEntry entry = this.storage.get(phoneNumber);
    //     if(entry != null && entry.isExpired()) {
    //         this.storage.remove(phoneNumber);
    //     }
    // }

    // public Set<String> getAllPhoneNumbers(){
    //     return storage.keySet();
    // }

}
