package br.com.anotaai.service;

import org.springframework.stereotype.Service;

import br.com.anotaai.models.HistoricoLogin;
import br.com.anotaai.repository.HistoricoLoginRepository;
import br.com.anotaai.security.CustomUserDetails;
import lombok.*;

@Service
@RequiredArgsConstructor
public class HistoricoLoginService {
	
	private HistoricoLoginRepository historicoLoginRepository;
	
	public void save(CustomUserDetails user, String token) {
        HistoricoLogin history = new HistoricoLogin();
        history.setUser_id(user.getId());
        history.setEmail(user.getEmail());
        history.setAcessToken(token);
        historicoLoginRepository.save(history);
    }


}
