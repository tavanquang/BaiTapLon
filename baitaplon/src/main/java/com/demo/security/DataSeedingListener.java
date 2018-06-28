//package com.demo.security;
//
//import org.springframework.stereotype.Component;
//
//import com.demo.dao.entity.TblAdmin;
//import com.demo.repository.TblAdminDTO;
//import com.demo.service.TblAdminService;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.security.crypto.password.PasswordEncoder;
//@Component
//public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent>  {
//	
//	private static final Logger LOGGER = LoggerFactory.getLogger(config.class);
//	
//	  @Autowired 
//	   PasswordEncoder passwordEncoder;
//	  
//	  @Autowired
//	  TblAdminService adminService;
//	  
//
//	@Override
//	public void onApplicationEvent(ContextRefreshedEvent arg0) {
//
//		  if (adminService.findByUsername("manh") == null) {
//	            TblAdmin user = new TblAdmin();
//	            user.setUsername("manh");
//	            user.setPassword(passwordEncoder.encode("123"));
//	            
//	            LOGGER.info(user.getPassword());
//	           
//	            user.setRoles("ROLE_ADMIN");
//	            adminService.save(user);
//	            
//	            
//	        }
//		
//	}
//
//}
