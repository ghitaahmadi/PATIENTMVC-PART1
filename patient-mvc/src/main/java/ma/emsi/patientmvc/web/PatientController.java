package ma.emsi.patientmvc.web;


import lombok.AllArgsConstructor;
import ma.emsi.patientmvc.entities.Patient;
import ma.emsi.patientmvc.repositories.PatientRepository;
import org.hibernate.engine.jdbc.env.spi.AnsiSqlKeywords;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
// injection de dependances
@AllArgsConstructor
public class PatientController {
    // acceder a la bd
    private PatientRepository patientRepository;
// methode qui retourne une vue traité coté serveur sont creer dans template
    //acceder a la methode patient
    @GetMapping(path = "/index")
    //pagination
    public String patients(Model model,
                           @RequestParam(name="page",defaultValue = "0") int page,
                           @RequestParam(name="size",defaultValue = "5") int size,
                           @RequestParam(name="Keyword",defaultValue = "") String keyword ){
        //chercher la liste
        Page <Patient> pagepatients;
        //pagination
        pagepatients = patientRepository.findByNameContains(keyword,PageRequest.of(page,size));

        //stocker dans le model

        model.addAttribute("listePatients",pagepatients.getContent());

        model.addAttribute("pages",new int[pagepatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("Keyword", keyword);
             return  "patients";
    }

    @GetMapping(path = "/delete")
    public String DeletePatient(Model model,Long id){
        patientRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/")

        public String home(){

        return "redirect:/index";
}

}
