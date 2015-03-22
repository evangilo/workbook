package br.com.ifrn.workbook.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Service;

import br.com.ifrn.workbook.model.user.UserAccount;
import br.com.ifrn.workbook.repository.UserRepository;

@Service
public class FacebookService {
	
	@Inject Facebook facebook;
	@Inject UserRepository userRepository;
	
	public List<UserAccount> getFriends() {
		List<String> friendIDs = facebook.friendOperations().getFriendIds();		
		return userRepository.findByFacebookIdIn(friendIDs);
	}

}
