package br.org.generation.blogpessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import br.org.generation.blogpessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		usuarioRepository.save(new Usuario(0L, "joão maria", "joao@email.com.br", "12345678", ""));
		usuarioRepository.save(new Usuario(0L, "safira veloso", "saf@email.com.br", "12345678", ""));
		usuarioRepository.save(new Usuario(0L, "maria joana", "majo@email.com.br", "", "12345678"));
		usuarioRepository.save(new Usuario(0L, "maria eduarda", "duarda@email.com.br", "12345678", ""));
	}
	
	@Test
	@DisplayName("🦕 retorna um usuário")
	public void deveRetornarUmUsuario() {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("joao@email.com.br");
		assertTrue(usuario.get().getUsuario().equals("joao@email.com.br"));
	}
	
	@Test
	@DisplayName("🦖 retorna três usuários")
	public void deveRetornarTresUsuarios() {
		List<Usuario> listaUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("maria");
		assertEquals(3, listaUsuarios.size());
		assertTrue(listaUsuarios.get(0).getNome().equals("joão maria"));
		assertTrue(listaUsuarios.get(1).getNome().equals("safira veloso"));
		assertTrue(listaUsuarios.get(2).getNome().equals("maria eduarda"));
	}
	
	@AfterAll
	void end() {
		usuarioRepository.deleteAll();
	}
	
}
