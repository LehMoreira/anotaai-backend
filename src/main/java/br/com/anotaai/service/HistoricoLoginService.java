package br.com.anotaai.service;

import org.springframework.stereotype.Service;

import br.com.anotaai.entity.HistoricoLogin;
import br.com.anotaai.repository.HistoricoLoginRepository;
import br.com.anotaai.security.CustomUserDetails;

@Service

public class HistoricoLoginService {
	
	private HistoricoLoginRepository historicoLoginRepository;
	
	
	public HistoricoLoginService(HistoricoLoginRepository historicoLoginRepository) {
		this.historicoLoginRepository = historicoLoginRepository;
	}


	public void save(CustomUserDetails user, String token) {
        HistoricoLogin history = new HistoricoLogin();
        history.setUser_id(user.getId());
        history.setEmail(user.getEmail());
        history.setAcessToken(token);
        historicoLoginRepository.save(history);
    }


}
