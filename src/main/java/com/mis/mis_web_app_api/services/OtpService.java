//package com.mis.mis_web_app_api.services;
//
//import com.google.common.cache.CacheBuilder;
//import com.google.common.cache.CacheLoader;
//import com.google.common.cache.LoadingCache;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//@Service
//public class OtpService {
//
//    @Value("${spring.otp.sms.expire}")
//    private String expireIn;
//
//    @Value("${spring.otp.sms.template}")
//    private String smsTemplate;
//
//    private LoadingCache<String, Integer> otpCache;
//
//    // Initialize the OTP cache
//    public void init() {
//        this.otpCache = CacheBuilder.newBuilder()
//                .expireAfterWrite(Long.parseLong(expireIn), TimeUnit.MINUTES)
//                .build(new CacheLoader<String, Integer>() {
//                    @Override
//                    public Integer load(String key) {
//                        return 0;
//                    }
//                });
//    }
//
//    // Generate OTP for a specific key
//    public String generate(String key) {
//        Random random = new Random();
//        Integer otp = 100000 + random.nextInt(900000); // Generate 6-digit OTP
//        this.otpCache.put(key, otp);
//        return otp.toString();
//    }
//
//    // Generate a generic OTP (without a key)
//    public String generate() {
//        Random random = new Random();
//        int otp = 100000 + random.nextInt(900000); // Generate 6-digit OTP
//        return Integer.toString(otp);
//    }
//
//    // Get OTP for a given key
//    public Integer get(String key) {
//        try {
//            return otpCache.get(key);
//        } catch (Exception e) {
//            return 0; // Return 0 if no OTP exists for the key
//        }
//    }
//
//    // Clear the OTP for a given key
//    public void clear(String key) {
//        this.otpCache.invalidate(key);
//    }
//
//    // Verify the OTP for a given key
//    public boolean verify(int otp, String key) {
//        if (otp < 0) {
//            return false;
//        }
//        int serverOtp = this.get(key);
//        if (serverOtp > 0 && otp == serverOtp) {
//            clear(key);
//            return true;
//        }
//        return false;
//    }
//}
