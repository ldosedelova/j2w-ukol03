package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {

  private final List<Vizitka> seznamVizitek = List.of(
          new Vizitka("Pepa Novák", "Pat a Mat s.r.o", "Nové sady 25","602 00 Brno-střed","pepa@novak.cz","+420232767555", "www.czechitas.cz"),
          new Vizitka("Alena Vochomůrková", "Czechitas z. s.", "nám. Svobody 86/17","602 00 Brno-město",null,null, "www.czechitas.cz"),
          new Vizitka("Sebastian Nekonečno", "Pohádkovo a.s.", "Jateční 33a","17000 Praha","sebanekonecno@pohadkovo.cz","+420123456789", null),
          new Vizitka("Bětka Jirásková", "Literát a.s.", "Václavské náměstí 837/11","11000 Praha 1","b.jiraskova@literat.cz","+420123456789", null)
  );
  @GetMapping("/")
  public ModelAndView seznam() {
    ModelAndView modelAndView = new ModelAndView("/seznam");
    modelAndView.addObject("vizitky",seznamVizitek);
    return modelAndView;
  }

  @GetMapping("/detail/{id}")
  public ModelAndView detail (@PathVariable int id) {
    ModelAndView modelAndView = new ModelAndView("/detail");
    modelAndView.addObject("vizitka",seznamVizitek.get(id));
    return modelAndView;
  }
}
