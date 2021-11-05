package br.com.luque.patrimonio.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import br.com.luque.patrimonio.domain.dto.BemMovelDTO;
import br.com.luque.patrimonio.domain.entities.BemMovel;
import br.com.luque.patrimonio.domain.entities.Categoria;
import br.com.luque.patrimonio.domain.repository.BemMovelRepository;
import br.com.luque.patrimonio.domain.repository.CategoriaRepository;

@Service
public class BemMovelService {

    @Autowired
    private BemMovelRepository bemMovelRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public BemMovel adiciona(BemMovelDTO dto) {
        BemMovel bemMovel = BemMovel.builder()
                    .descricao(dto.getDescricao())
                    .categoria(findCategoria(dto.getCodigoCategoria()))
                    .marca((dto.getMarca() != null ? dto.getMarca() : null))
                    .build();
        return bemMovelRepository.save(bemMovel);
    }

    public void remover(Integer codBemMovel) {
        bemMovelRepository.delete(findBemMovel(codBemMovel));
    }

    public void alterar(BemMovelDTO dto, Integer codBemMovel) {
        BemMovel bemMovel = findBemMovel(codBemMovel);

        bemMovel.setCategoria(findCategoria(dto.getCodigoCategoria()));
        bemMovel.setDescricao(dto.getDescricao());
        bemMovel.setMarca(dto.getMarca());
        bemMovelRepository.save(bemMovel);
    }

    public BemMovel consultaPorId(Integer codigo) {
        return findBemMovel(codigo);
    }

    public BemMovel findBemMovel(Integer codBemMovel) {
        Optional<BemMovel> bemMovel = bemMovelRepository.findById(codBemMovel);
        if (!bemMovel.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Código do bem móvel não encontrado");
        }
        return bemMovel.get();
    }

    public Categoria findCategoria(Integer codCategoria) {
        Optional<Categoria> categoria = categoriaRepository.findById(codCategoria);
        if (!categoria.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Código da categoria não encontrado");
        }
        return categoria.get();
    }

}
