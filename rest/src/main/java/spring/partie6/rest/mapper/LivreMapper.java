package spring.partie6.rest.mapper;

import spring.partie6.persistence.entities.Livre;
import spring.partie6.rest.dto.LivreDTO;

import java.util.ArrayList;
import java.util.List;

public class LivreMapper {

    public static LivreDTO convertToDto(Livre livre) {
        LivreDTO livreDTO = new LivreDTO();

        livreDTO.setNomLivre(livre.getNom());
        livreDTO.setNomAuteur(livre.getAuteur().getNom());

        livreDTO.setLangue (livre.getLangue());

        return livreDTO;
    }

    public static Iterable<LivreDTO> convertToDtos(Iterable<Livre> livres) {

        List<LivreDTO> livreDTOS = new ArrayList<>();
        LivreDTO livreDTO ;
        for (Livre livre : livres) {
            livreDTO = convertToDto(livre);
            livreDTOS.add(livreDTO);
        }

        return livreDTOS;
    }
}
