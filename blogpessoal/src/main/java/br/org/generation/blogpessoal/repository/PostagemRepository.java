package br.org.generation.blogpessoal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.org.generation.blogpessoal.model.Postagem;

@Repository //indica para o spring que a classe é um repositório
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
	//linha 10 se equipara a select *  from tb_postagens where titulo like "%titulo%";
	
	
	
}
