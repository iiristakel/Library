package main;

import model.Raport;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RaportsController {

    /*
     * Töötaja peab saama näha raportit üle aja läinud laenutajatest.
     * Raport peab sisaldama nii laenutaja nime, raamatut,
     * mille tagastamise aeg on üle läinud ja ka aega palju on üle läinud.
     */
    @PostMapping("/raports")
    public List<Raport> getRaports(@RequestParam String userName,
                                   @RequestParam String passwordHash){
        // if person is in role "library worker"...
        throw new RuntimeException("not implemented yet");
    }
}
