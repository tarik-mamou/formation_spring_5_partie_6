package spring.partie6.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import spring.partie6.mvc.commands.LivreCommand;
import spring.partie6.persistence.entities.Livre;
import spring.partie6.service.LibrairieService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MvcController {


    @Autowired
    LibrairieService librairieService;

    @RequestMapping("/")
    public String index (){
        return "index";
    }


    @GetMapping("/file1")
    public String file1(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
         return "file1";
    }

    @RequestMapping(value = "/livres")
    public String livres(@ModelAttribute LivreCommand livreCommand, BindingResult errors, Model model) throws Exception {
        List<Livre> livres=new ArrayList<>();
        if(livreCommand.getNomlivre()!=null){
          Livre livre= librairieService.chercherLivre(livreCommand.getNomlivre());
         if(livre==null){
             throw  new Exception("livre non trouvé");
         }
          livres.add(livre);
       }else {
         livres = (List<Livre>) librairieService.findAllLivre();

       }
        model.addAttribute("listeLivres", livres);
        return "livres";
    }

    @RequestMapping(value = "/livres2")
    public String livres() {
        return "livres2";
    }

}