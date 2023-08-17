package alandev.com.projeto01.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import alandev.com.projeto01.Entities.Usua;
import alandev.com.projeto01.Repositori.UserRepositori;

@RestController
@RequestMapping(value = "/use")
public class UseController {

    @Autowired
    private UserRepositori repositori;

    @GetMapping
    public ResponseEntity<List<Usua>> findAll() {
        List<Usua> result = repositori.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<Usua>> pageAll(Pageable pageable) {
        Page<Usua> result = repositori.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/busca-salario")
    public ResponseEntity<Page<Usua>> findSalari(@RequestParam(defaultValue = "0") Double minisalry,
            @RequestParam(defaultValue = "100000000000000") Double maxsalary, Pageable pageable) {
        Page<Usua> result = repositori.searchSalary(maxsalary,minisalry,pageable);

        return ResponseEntity.ok(result);

    }

    @GetMapping(value = "/busca-nome")
    public ResponseEntity<Page<Usua>> findName(@RequestParam(defaultValue = "") String name,Pageable pageable){
        Page<Usua> result = repositori.findBuscanome(name,pageable);
        return ResponseEntity.ok(result);

    }

}
